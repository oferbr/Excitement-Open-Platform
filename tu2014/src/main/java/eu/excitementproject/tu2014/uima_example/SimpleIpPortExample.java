package eu.excitementproject.tu2014.uima_example;

import java.io.File;
import java.io.IOException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;
import org.xml.sax.SAXException;

import eu.excitementproject.eop.common.utilities.file.FileUtils;

import eu.excitementproject.eop.common.utilities.uima.UimaUtils;
import eu.excitementproject.eop.common.utilities.uima.UimaUtilsException;

public class SimpleIpPortExample {

	public static void main(String[] args) throws InvalidXMLException, ResourceInitializationException, IOException, AnalysisEngineProcessException, SAXException, UimaUtilsException {

		String inputTextFile = args[0];
		String outputXmiFile = args[1];

		// Produce Analysis Engine
		AnalysisEngine ae = UimaUtils.loadAE("/desc/AnalysisEngineDescriptor-SimpleIpPort.xml");

		// Create CAS from file
		String fileContent = FileUtils.loadFileToString(new File(inputTextFile));
		JCas jcas = ae.newJCas();
		jcas.setDocumentLanguage("EN");
		jcas.setDocumentText(fileContent);
		
		// Run Analysis Engine
		ae.process(jcas);
		
		// Dump annotated jcas to XMI
		UimaUtils.dumpXmi(new File(outputXmiFile), jcas);
	}
}
