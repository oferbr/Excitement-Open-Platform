package eu.excitementproject.tu2014;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.uimafit.util.JCasUtil;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Lemma;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency.Dependency;
import eu.excitementproject.eop.common.utilities.uima.UimaUtils;
import eu.excitementproject.eop.common.utilities.uima.UimaUtilsException;
import eu.excitementproject.eop.lap.LAPAccess;
import eu.excitementproject.eop.lap.LAPException;
import eu.excitementproject.eop.lap.PlatformCASProber;
import eu.excitementproject.eop.lap.biu.uima.BIUFullLAP;
import eu.excitementproject.eop.lap.implbase.LAP_ImplBase;

/**
 * This heavily commented code introduces the Linguistic Analysis Pipeline 
 * (LAP) of EXCITEMENT open platform. Check EX1 exercise sheet first, and proceed 
 * with this example code. 
 * 
 * @author Gil, Ofer Bronstein
 */
public class Ex1b {

	public static void main(String[] args) throws LAPException, UimaUtilsException, CASException {
		
    	// init logs
    	BasicConfigurator.resetConfiguration();
    	BasicConfigurator.configure();
    	Logger.getRootLogger().setLevel(Level.WARN);  

		// Each and every LAP in EXCITEMENT Open Platform (EOP) 
		// implements the interface LAPAccess.
		System.out.println("Initializing LAP...");
		LAPAccess lap = new BIUFullLAP(
				"src/main/resources/model/left3words-wsj-0-18.tagger",
				"src/main/resources/model/ner-eng-ie.crf-3-all2008-distsim.ser.gz",
				"localhost",
				8080);
		
		annotateSingleText(lap);
		
		annotateTHPair(lap);
		
		annotateFullDataset(lap);
	}
	
	/**
	 * Directly annotates a single text document. Nothing to do with Textual Entailment.
	 * @param lap
	 * @throws UimaUtilsException
	 * @throws LAPException
	 */
	private static void annotateSingleText(LAPAccess lap) throws UimaUtilsException, LAPException {
		System.out.printf("\n==========\nannotateSingleText\n==========\n\n");
		
		JCas jcas = UimaUtils.newJcas();
		
		// Before asking LAP to process, you have to set at least two things. 
		// One is language, and the other is document itself. 
		jcas.setDocumentLanguage("EN"); // ISO 639-1 language code.  
		String doc = "This is a document. You can pass an arbitary document to CAS and let LAP work on it."; 
		jcas.setDocumentText(doc);
		
		// This actually performs all the annotating of the LAP
		lap.addAnnotationOn(jcas);

		// Example use of JCasUtil.select(), getCoveredText():
		// Find how many tokens are longer than 3 characters
		int count = 0;
		Collection<Token> allTokens = JCasUtil.select(jcas, Token.class);
		for (Token token : allTokens) {
			String tokenText = token.getCoveredText();
			if (tokenText.length() >= 3) {
				count += 1;
			}
		}
		System.out.printf("%d out of %d tokens have at least 3 characters.\n\n", count, allTokens.size());
		
		// Example use of JCasUtil.selectCovered, JCasUtil.toText:
		// Print list of token strings for each sentence separately
		for (Sentence sentence : JCasUtil.select(jcas, Sentence.class)) {
			Collection<Token> sentenceTokens = JCasUtil.selectCovered(Token.class, sentence);
			List<String> sentenceTokenTexts = JCasUtil.toText(sentenceTokens);
			System.out.printf("Sentence Tokens: %s\n", sentenceTokenTexts);
		}
		System.out.println();
	}
	
	private static void annotateTHPair(LAPAccess lap) throws LAPException, CASException, UimaUtilsException {
		System.out.printf("\n==========\nannotateTHPair\n==========\n\n");

		JCas jcas = lap.generateSingleTHPairCAS("This is the Text part. It's usually a few sentences long", "The Hypothesis is usually only one sentence. Only usually.");
		
		// Our CAS had two main vies, when it represents a T-H pair:
		// A view named "TextView" holds the T part, and all of its annotation
		// A view named "HypothesisView" holds the H part, and all of its annotation
		// Here, we want to do things with the hypothesis view
		// Note that in UIMA, a view is also a JCas object
		JCas hypoView = jcas.getView(LAP_ImplBase.HYPOTHESISVIEW);
		
		// Example use of JCasUtil.selectSingle
		// We assume that the hypothesis contains only one sentence
		Sentence sentence = null;
		try {
			sentence = JCasUtil.selectSingle(hypoView, Sentence.class);
		}
		catch (Exception e) {
			System.err.printf("Oh no! An error has occurred... A '%s' error! What on earth shall we do?\nWell, I guess it's your job to fix it!\n", e.toString());
			Collection<Sentence> allSentences = JCasUtil.select(hypoView, Sentence.class);
			sentence = (Sentence) allSentences.toArray()[0];
		}
		
		// Example use of UimaUtils.selectCoveredSingle
		// We assume that each Token annotation, has exactly one Lemma annotation which covers the same span
		// This is how we mark the token's lemma, but also other things - like the token's POS, etc.
		// NOTE that specifically, Token holds a direct reference to its Lemma (via token.getLemma())
		// and to its POS (via token.getPos()). We won't use them here because we want to show the use
		// of UimaUtils.selectCoveredSingle, but of course you are welcome to use them as you please.
		System.out.printf("Lemmas of sentence: ");
		for (Token token : JCasUtil.selectCovered(Token.class, sentence)) {
			Lemma lemma = UimaUtils.selectCoveredSingle(hypoView, Lemma.class, token);
			System.out.printf("%s ", lemma.getValue());
		}
		System.out.printf("\n\n");

		// Example use of PlatformCASProber.probeCas
		// Make sure out jcas has the basic elements required for a T-H pair, nd print some stats on annotations
		PlatformCASProber.probeCas(jcas, System.out);
		
		// Example use of UimaUtils.dumpXmi
		// Our JCas will be dumped to an XMI file
		UimaUtils.dumpXmi(new File("src/main/resources/xmi/EX1_THPair.xmi"), jcas);

	}
	
	
	private static void annotateFullDataset(LAPAccess lap) throws LAPException, UimaUtilsException, CASException {
		System.out.printf("\n==========\nannotateFullDataset\n==========\n\n");

		File dataset = new File("src/main/resources/dataset/RTE3_dev_few.xml"); 
		File outputDir = new File("src/main/resources/xmi/RTE3_dev"); 
		
		// Process all the pairs in the dataset, and dump them all to XMI files
		lap.processRawInputFormat(dataset, outputDir);

		// Load each dumped XMI
		// For each XMI, print all of its Dependencies in TextView
		for (File xmiFile : outputDir.listFiles()) {
			if (xmiFile.getName().toLowerCase().endsWith(".xmi")) {
				JCas jcas = UimaUtils.loadXmi(xmiFile);
				JCas textView = jcas.getView(LAP_ImplBase.TEXTVIEW);
				System.out.printf("\n%s:\n", xmiFile.getName());
				for (Sentence sentence : JCasUtil.select(textView, Sentence.class)) {
					System.out.printf("   Sentence in range [%d:%d]:\n", sentence.getBegin(), sentence.getEnd());
					
					// NOTE that Dependency annotations are not covered by any of the two dependent tokens
					// (the Governor and the Dependent). Their span is always the full sentence itself.
					// So we can visually imagine that they are "floating" above the sentence.
					for (Dependency dependency : JCasUtil.selectCovered(Dependency.class, sentence)) {
						Token gov = dependency.getGovernor();
						Token dep = dependency.getGovernor();
						System.out.printf("      %s[%s/%s] --(%s)--> %s[%s/%s]\n",
								gov.getCoveredText(), gov.getLemma().getValue(), gov.getPos().getPosValue(),
								dependency.getDependencyType(),
								dep.getCoveredText(), dep.getLemma().getValue(), dep.getPos().getPosValue());
					}
				}
			}
		}
	}
}
