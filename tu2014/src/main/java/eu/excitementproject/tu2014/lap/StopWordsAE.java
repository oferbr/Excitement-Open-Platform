package eu.excitementproject.tu2014.lap;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.util.JCasUtil;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import eu.excitementproject.tu2014.uima.StopWord;

/**
 * This annotator scans all tokens, and marks it as a StopWord, if it appears in the resource file.
 * Additionally, each stop word is classified on the POS level:
 * <ul>
 * <li>Some stop words are "content words", with POSes like Noun and Verb.
 * <li>Some stop words are "function words", with POSes like Preposition and Conjunction.
 * <li>All stop words with the remaining POSes are classified as "Unknown".
 * 
 * @author Ofer Bronstein
 * @since April 2014
 */
public class StopWordsAE extends JCasAnnotator_ImplBase {

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		try {
			// Load resource
			stopWords = FileUtils.readLines(new File(STOP_WORDS_LIST_FILE));
		}
		catch (IOException e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		for (Token token : JCasUtil.select(jcas, Token.class)) {
			String text = token.getCoveredText();
			if (stopWords.contains(text)) {
				StopWord stopWord = new StopWord(jcas, token.getBegin(), token.getEnd());
				stopWord.addToIndexes();
				
				String topLevelPos = token.getPos().getClass().getSimpleName();
				if (POS_CONTENT.contains(topLevelPos)) {
					stopWord.setPosLevel("Content");
				}
				else if (POS_FUNCTION.contains(topLevelPos)) {
					stopWord.setPosLevel("Function");
				}
				else {
					stopWord.setPosLevel("Unknown");
				}
			}
		}
	}
	
	private List<String> stopWords;
	
	private static final String STOP_WORDS_LIST_FILE = "src/main/resources/model/stopwords-Eyal.txt";
	private static final List<String> POS_CONTENT = Arrays.asList(new String[] {"N", "NN", "NP", "PR", "V", "ADJ", "ADV"});
	private static final List<String> POS_FUNCTION = Arrays.asList(new String[] {"ART", "PP", "CONJ"});
}
