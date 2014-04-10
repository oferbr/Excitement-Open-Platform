package eu.excitementproject.tu2014;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.uima.jcas.JCas;

import eu.excitementproject.eop.common.EDABasic;
import eu.excitementproject.eop.common.EDAException;
import eu.excitementproject.eop.common.TEDecision;
import eu.excitementproject.eop.common.configuration.CommonConfig;
import eu.excitementproject.eop.common.exception.ComponentException;
import eu.excitementproject.eop.common.exception.ConfigurationException;
import eu.excitementproject.eop.common.utilities.configuration.ImplCommonConfig;
import eu.excitementproject.eop.core.ClassificationTEDecision;
import eu.excitementproject.eop.core.MaxEntClassificationEDA;
import eu.excitementproject.eop.lap.LAPAccess;
import eu.excitementproject.eop.lap.biu.uima.BiuAndOpenNlpLAP;

/**
 * A simple, minimal code that runs one LAP & EDA to check all environment is Okay. 
 * 
 * @author Gil, Ofer Bronstein
 *
 */
public class Ex1a 
{
    public static void main( String[] args ) throws ConfigurationException, EDAException, ComponentException
    {

    	// init logs
    	BasicConfigurator.resetConfiguration();
    	BasicConfigurator.configure();
    	Logger.getRootLogger().setLevel(Level.WARN);  

        System.out.println( "Hello Excitement!" );
        
        // Here's T-H of this welcome code. 
        String text = "Jack and Jill went up the hill to fetch a pail of water."; 
        String hypothesis = "Jill and Jack climbed a mountain to get bucket of water."; 
        // Minimal "running" example for Excitement open platform EDAs (Entailment Decision Algorithms) 
        // Basically, it performs two steps: 
        // 1) Do pre-processing (linguistic analysis) needed for the EDA, by calling an LAP 
        // 2) Initialize an EDA with configuration & pre-trained model. (consider a model & config is a pair)
        // 3) Ask EDA to decide Entailment. 
        
        
        // 1) Do pre-processing, via a LAP (Linguistic Analysis Pipeline). 
        System.out.println( "Running LAP for the T-H pair." );

    	// make a new BIUFullLAP based LAP 
    	LAPAccess lap = new BiuAndOpenNlpLAP(
				"src/main/resources/model/ner-eng-ie.crf-3-all2008-distsim.ser.gz",
				"localhost",
				8080);
    	
    	JCas annotated_THpair = lap.generateSingleTHPairCAS(text,  hypothesis); // ask it to process this T-H. 
 
        // 2) Initialize an EDA with a configuration (& corresponding model)  
        // (Model path is given in the configuration file.) 
        System.out.println("Initializing the EDA.");
        
    	// TIE (MaxEntClassificationEDA): a simple configuration with no knowledge resource. 
    	// extracts features from lemma, tokens and parse tree and use them as features. 
    	File configFile = new File("src/main/resources/MaxEntClassificationEDA_Base+TP_EN.xml");        
    	CommonConfig config = new ImplCommonConfig(configFile);
    	EDABasic<ClassificationTEDecision> eda = new MaxEntClassificationEDA(); 
    	eda.initialize(config); 

        
        // 3) Now, one input data is ready, and the EDA is also ready. 
        // Call the EDA.  
        System.out.println("Calling the EDA for decision.");
        TEDecision decision = eda.process(annotated_THpair); 

    	System.out.println("Run complete: EDA returned decision: " + decision.getDecision().toString());         
    }
}
