package eu.excitementproject.tu2014;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.uima.jcas.JCas;

import eu.excitementproject.eop.common.DecisionLabel;
import eu.excitementproject.eop.common.EDABasic;
import eu.excitementproject.eop.common.EDAException;
import eu.excitementproject.eop.common.TEDecision;
import eu.excitementproject.eop.common.configuration.CommonConfig;
import eu.excitementproject.eop.common.exception.ComponentException;
import eu.excitementproject.eop.common.exception.ConfigurationException;
import eu.excitementproject.eop.common.utilities.configuration.ImplCommonConfig;
import eu.excitementproject.eop.common.utilities.uima.UimaUtils;
import eu.excitementproject.eop.common.utilities.uima.UimaUtilsException;
import eu.excitementproject.eop.core.ClassificationTEDecision;
import eu.excitementproject.eop.core.MaxEntClassificationEDA;
import eu.excitementproject.eop.lap.LAPAccess;
import eu.excitementproject.eop.lap.biu.uima.BIUFullLAP;

/**
 * This example code shows how you can initiate and use EDA. 
 * 
 * It deals two modes (process mode, training mode) of EDAs, and covers how you can 
 * train an EDA and use the trained model with that EDA. 
 * 
 * @author Gil, Ofer Bronstein
 *
 */

public class Ex2b {

	public static void main(String[] args) throws ConfigurationException, EDAException, ComponentException, UimaUtilsException {

    	// init logs
    	BasicConfigurator.resetConfiguration();
    	BasicConfigurator.configure();
    	Logger.getRootLogger().setLevel(Level.INFO);  

    	
		// This specific configuration uses only LEXICAL resources
    	// It actually uses only one lexical resource - Wordnet
    	// Of course many other options exist - take a look in:
    	// core/src/main/resources/configuration-file/
		File configFile = new File("src/main/resources/config/MaxEntClassificationEDA_Base+WN_NewModel.xml");        
		CommonConfig config = new ImplCommonConfig(configFile);

		// Before training, we must run the LAP on the training data
		// We output it to a folder, and set this folder in configuration to be the folder which
		// the training data reads CASes from
		LAPAccess lap = new BIUFullLAP(
				"src/main/resources/model/left3words-wsj-0-18.tagger",
				"src/main/resources/model/ner-eng-ie.crf-3-all2008-distsim.ser.gz",
				"localhost",
				8080);
		File devSet = new File("src/main/resources/dataset/RTE3_dev.xml"); 
		File trainDir = new File("target/xmi/RTE3_dev"); // as written in configuration!  
		trainDir.mkdirs();
		System.out.println("Running LAP on training data...");
		lap.processRawInputFormat(devSet, trainDir); 
		
		// Instantiate our TIE EDA for training
		// Note that although EDAs have an initialize() method, it should only be called
		// before processing (testing), but not before training,
		// as it expects a trained model to already exist 
		System.out.println("Creating EDA...");
		EDABasic<ClassificationTEDecision> eda = new MaxEntClassificationEDA();

		// The TIE EDA will read CASes from the training folder, train on them,
		// and output its model
		// Note that each EDA would require different parameters for training,
		// the configuration file must always fit the specific EDA that we use.
		System.out.println("Running EDA training on training data...");
		File modelDir = new File("target/model"); // as written in configuration!  
		modelDir.mkdirs();
		eda.startTraining(config); // This may take some time

		// Similarly to training data - run LAP on test data
		File testSet = new File("src/main/resources/dataset/RTE3_test_few.xml"); 
		File testDir = new File("target/xmi/RTE3_test"); // as written in configuration!  
		testDir.mkdirs();
		System.out.println("Running LAP on test data...");
		lap.processRawInputFormat(testSet, testDir); 

		// Now, after we have the model, and before we start processing all the pairs,
		// we should initialize()
		System.out.println("Initializing EDA...");
		eda.initialize(config);

		// Run EDA processing on each of the pairs in the test set
		// by iterating the dumped XMIs, loading them into CASes
		// and feeding them to the EDA
		int countEntail = 0;
		int totalPairs = 0;
		System.out.println("Running EDA processing on test data...");
		for (File xmiFile : testDir.listFiles()) {
			if (xmiFile.getName().toLowerCase().endsWith(".xmi")) {
				JCas jcas = UimaUtils.loadXmi(xmiFile);
				TEDecision decision = eda.process(jcas);
				System.out.printf("Entailment for pair stored in %s is: %s\n", xmiFile.getName(), decision.getDecision());
				
				// For each pair, we check if EDA decided it is entailing
				// Notice that we don't call equals(DecisionLabel.Entailment), as DecisionLabel is a hierarchy,
				// where also other labels represent cases of entailment (specifically - only Paraphrase)
				if (decision.getDecision().is(DecisionLabel.Entailment)) {
					countEntail = 1;
				}
				totalPairs += 1;
			}
		}
		System.out.printf("Processed %d pairs, out of which %d pairs were decided as entailing\n", totalPairs, countEntail);
	}
}
