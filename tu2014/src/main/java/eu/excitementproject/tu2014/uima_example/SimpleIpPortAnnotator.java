package eu.excitementproject.tu2014.uima_example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint;
import eu.excitementproject.tu2014.uima_example.simpleipport.IpAddress;
import eu.excitementproject.tu2014.uima_example.simpleipport.Port;

public class SimpleIpPortAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		try {
			Pattern pattern = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)");
			Matcher matcher = pattern.matcher(jCas.getDocumentText());
			
			while (matcher.find()) {
				IpAddress ipAnno = new IpAddress(jCas, matcher.start(1), matcher.end(1));
				ipAnno.addToIndexes();
				if (ipAnno.getCoveredText().startsWith("192.168.") ||
					ipAnno.getCoveredText().startsWith("10.0.0.")) {
					
					ipAnno.setIsPrivate(true);
				}
				
				Port portAnno = new Port(jCas, matcher.start(2), matcher.end(2));
				portAnno.addToIndexes();
				
				Short number = Short.parseShort(portAnno.getCoveredText());
				portAnno.setNumber(number);
				if (number > 30000) {
					throw new SimpleIpPortAnnotatorException("invalid port value");
				}
				
				final Set<Short> KNOWN_PORTS = new HashSet<Short>(
						Arrays.asList(new Short[] {21, 23, 80}));
				if (KNOWN_PORTS.contains(number)) {
					portAnno.setIsKnown(true);
				}
				
				ConnectionEndPoint connFS = new ConnectionEndPoint(jCas);
				connFS.addToIndexes();
				connFS.setIpAddress(ipAnno);
				connFS.setPort(portAnno);
			}

		}
		catch (SimpleIpPortAnnotatorException e) {
			throw new AnalysisEngineProcessException(
					AnalysisEngineProcessException.ANNOTATOR_EXCEPTION, null, e); 
		}
	}
}
