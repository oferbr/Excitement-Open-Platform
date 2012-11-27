package eu.excitementproject.eop.lap.ae.postagger;

import java.io.File;

import org.uimafit.descriptor.ConfigurationParameter;

import ac.biu.nlp.nlp.instruments.postagger.OpenNlpPosTagger;
import eu.excitementproject.eop.lap.util.Envelope;

public class OpenNlpPosTaggerAE extends PosTaggerAE<OpenNlpPosTagger> {

	// TODO remove  defaultValue?
	/**
	 * Model file of this tokenizer.
	 */
	public static final String PARAM_MODEL_FILE = "model_file";
	@ConfigurationParameter(name = PARAM_MODEL_FILE, mandatory = true)
	private File modelFile;
	
	public static final String PARAM_TAG_DICT = "tagDict";
	@ConfigurationParameter(name = PARAM_TAG_DICT, mandatory = true)
	private String tagDict;

	private static Envelope<OpenNlpPosTagger> envelope = new Envelope<OpenNlpPosTagger>();
	
	@Override
	protected final Envelope<OpenNlpPosTagger> getEnvelope(){return envelope;}
	
	@Override
	protected OpenNlpPosTagger buildInnerTool() throws Exception {
		OpenNlpPosTagger tagger = new OpenNlpPosTagger(modelFile, tagDict);
		tagger.init();
		return tagger;
	}
	
}
