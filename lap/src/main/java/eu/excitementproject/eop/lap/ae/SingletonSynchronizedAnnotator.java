package eu.excitementproject.eop.lap.ae;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.resource.ResourceInitializationException;

import eu.excitementproject.eop.lap.util.Envelope;


public abstract class SingletonSynchronizedAnnotator<T> extends JCasAnnotator_ImplBase {
	protected T innerTool = null;
	
	public void initialize(UimaContext aContext) throws ResourceInitializationException
	{
		super.initialize(aContext);
		try {
			if (isInnerToolSingleInstance()) {
				innerTool = buildInnerToolSynchronized();
			}
			else {
				innerTool = buildInnerTool();
			}
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}

	private T buildInnerToolSynchronized() throws Exception {
		Envelope<T> envelope = getEnvelope();
		if (null == envelope.getT()) {
			synchronized (envelope) {
				if (null == envelope.getT()) {
					T builtTool = buildInnerTool();
					envelope.setT(builtTool);
				}
			}
		}
		return envelope.getT();
	}

	protected boolean isInnerToolSingleInstance() {
		return true;
	}
	
	protected abstract T buildInnerTool() throws Exception;
	protected abstract Envelope<T> getEnvelope();
}
