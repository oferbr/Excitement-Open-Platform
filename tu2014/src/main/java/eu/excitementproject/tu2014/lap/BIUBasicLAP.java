package eu.excitementproject.tu2014.lap;

import static org.uimafit.factory.AnalysisEngineFactory.createPrimitiveDescription;

import java.util.HashMap;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.resource.ResourceInitializationException;

import eu.excitementproject.eop.lap.LAPAccess;
import eu.excitementproject.eop.lap.LAPException;
import eu.excitementproject.eop.lap.biu.uima.BIUFullLAP;
import eu.excitementproject.eop.lap.biu.uima.ae.ner.StanfordNamedEntityRecognizerAE;
import eu.excitementproject.eop.lap.biu.uima.ae.postagger.MaxentPosTaggerAE;
import eu.excitementproject.eop.lap.biu.uima.ae.sentencesplitter.LingPipeSentenceSplitterAE;
import eu.excitementproject.eop.lap.biu.uima.ae.tokenizer.MaxentTokenizerAE;
import eu.excitementproject.eop.lap.implbase.LAP_ImplBaseAE;

/**
 * BIU's basic LAP (Linguistic Analysis Pipeline).
 * Similar to {@link BIUFullLAP}, but without parser. 
 * @author Ofer Bronstein
 * @since May 2013
 */
public class BIUBasicLAP extends LAP_ImplBaseAE implements LAPAccess {

	public BIUBasicLAP(String taggerModelFile, String nerModelFile) throws LAPException {
		super(buildDescriptorArgs(/*lemmatizerModelFile, */taggerModelFile, nerModelFile));
		
		languageIdentifier = "EN"; // set languageIdentifer 
	}
	
	private static String name(Class<?> cls, String paramName) {
		return cls.getName() + "." + paramName;
	}
	
	private static Map<String,String> buildDescriptorArgs(String taggerModelFile, String nerModelFile) {
		HashMap<String,String> args = new HashMap<String,String>();
		
		args.put(ARGNAME_MAXENT_TAGGER_MODEL_FILE, taggerModelFile);
		args.put(ARGNAME_STANFORD_NER_MODEL_FILE, nerModelFile);
		
		return args;
	}
	
	@Override
	public AnalysisEngineDescription[] listAEDescriptors(Map<String,String> args) throws LAPException {
		try 
		{
			// Build analysis engine descriptions
			AnalysisEngineDescription splitter =   createPrimitiveDescription(LingPipeSentenceSplitterAE.class);
			AnalysisEngineDescription tokenizer =  createPrimitiveDescription(MaxentTokenizerAE.class);
			AnalysisEngineDescription lemmatizer = createPrimitiveDescription(GateLemmatizerAE.class);
			AnalysisEngineDescription tagger =     createPrimitiveDescription(MaxentPosTaggerAE.class,
					MaxentPosTaggerAE.PARAM_MODEL_FILE , args.get(ARGNAME_MAXENT_TAGGER_MODEL_FILE));
			AnalysisEngineDescription ner =        createPrimitiveDescription(StanfordNamedEntityRecognizerAE.class,
					StanfordNamedEntityRecognizerAE.PARAM_MODEL_FILE , args.get(ARGNAME_STANFORD_NER_MODEL_FILE));

			
			AnalysisEngineDescription[] descs = new AnalysisEngineDescription[] {
					splitter,
					tokenizer,
					lemmatizer,
					tagger,
					ner,
			};
			return descs;
		}
		catch (ResourceInitializationException e)
		{
			throw new LAPException("Unable to create AE descriptions", e); 
		}
	}

	
	private static final String ARGNAME_MAXENT_TAGGER_MODEL_FILE = name(MaxentPosTaggerAE.class, MaxentPosTaggerAE.PARAM_MODEL_FILE);
	private static final String ARGNAME_STANFORD_NER_MODEL_FILE = name(StanfordNamedEntityRecognizerAE.class, StanfordNamedEntityRecognizerAE.PARAM_MODEL_FILE);

}
