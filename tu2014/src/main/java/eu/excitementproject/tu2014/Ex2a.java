package eu.excitementproject.tu2014;

import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.uima.jcas.JCas;

import eu.excitementproject.eop.common.component.distance.DistanceCalculation;
import eu.excitementproject.eop.common.component.distance.DistanceComponentException;
import eu.excitementproject.eop.common.component.distance.DistanceValue;
import eu.excitementproject.eop.common.component.lexicalknowledge.LexicalResourceException;
import eu.excitementproject.eop.common.component.scoring.ScoringComponent;
import eu.excitementproject.eop.common.component.scoring.ScoringComponentException;
import eu.excitementproject.eop.common.exception.ConfigurationException;
import eu.excitementproject.eop.core.component.distance.FixedWeightLemmaEditDistance;
import eu.excitementproject.eop.core.component.scoring.BagOfLexesScoringEN;
import eu.excitementproject.eop.core.component.scoring.TreeSkeletonScoring;
import eu.excitementproject.eop.lap.LAPAccess;
import eu.excitementproject.eop.lap.LAPException;
import eu.excitementproject.eop.lap.biu.uima.BIUFullLAP;

/**
 * This code introduces Scoring components, and distance components. 
 * 
 * @author Gil, Ofer Bronstein
 */

public class Ex2a {

	/**
	 * @param args
	 * @throws ConfigurationException 
	 * @throws LexicalResourceException 
	 * @throws LAPException 
	 * @throws ScoringComponentException 
	 * @throws DistanceComponentException 
	 */
	public static void main(String[] args) throws ConfigurationException, LexicalResourceException, LAPException, ScoringComponentException, DistanceComponentException {
    	// init logs
    	BasicConfigurator.resetConfiguration();
    	BasicConfigurator.configure();
    	Logger.getRootLogger().setLevel(Level.INFO);  

    	
		// Two examples of ScoringComponent 
		
		// TreeSkeleton Scoring Component implements feature-extraction 
		// outlined in the paper "Rui Wang and Günter Neumann. 2007. Recognizing Textual Entailment Using a Subsequence Kernel Method "
		ScoringComponent c1 = new TreeSkeletonScoring(); 
		
		// BagOfLexesScoring is a Scoring component compares the given T-H on lemma level, 
		// but this comparison is done with expansion by lexical resource of VerbOcean and WordNet. 
		ScoringComponent c2 = new BagOfLexesScoringEN(true, new String[]{"HYPERNYM", "SYNONYM"}, true, false, false, "src/main/resources/knowledge/wordnet", true, new String[]{"STRONGER_THAN", "SIMILAR"}, true, "src/main/resources/knowledge/verbocean/verbocean.unrefined.2004-05-20.txt" ); 

		// Create CAS over a T-H pair
        String text = "Jack and Jill went up the hill to fetch a pail of water."; 
        String hypothesis = "Jill walked to get a bucket."; 
    	LAPAccess lap = new BIUFullLAP(
				"src/main/resources/model/left3words-wsj-0-18.tagger",
				"src/main/resources/model/ner-eng-ie.crf-3-all2008-distsim.ser.gz",
				"localhost",
				8080); 
    	JCas pair = lap.generateSingleTHPairCAS(text,  hypothesis); 

		// and we can now ask the scoring components to report their observation (features)  
        // .calculateScores(JCas) is the main method of Scoring Component. 
        // it returns a vector of Double (so the features are ordered). 
        Vector<Double> featureVector1 = c1.calculateScores(pair); 
        Vector<Double> featureVector2 = c2.calculateScores(pair);
        System.out.printf("Tree Skeleton built feature vector: %s\n", featureVector1);
        System.out.printf("Bag of Lexes built feature vector: %s\n", featureVector2);

        // DistanceCalulation is a sub-interface of ScoringComponent
        // It supports returning one score, that can be interpreted as
        //    some distance between T and H
		DistanceCalculation d1 = new FixedWeightLemmaEditDistance();

    	// .calculation(JCas) is the main method. it returns a specialized
    	// class DistanceValue, which naturally holds standardized "distance". 
    	DistanceValue v = d1.calculation(pair); 
    	System.out.printf("FixedWeightLemmaEditDistance returned final (normalized) distance: %s\n", v.getDistance()); 
    	System.out.printf("Its un-normalized value was: %s\n", v.getUnnormalizedValue()); 
	}
}
