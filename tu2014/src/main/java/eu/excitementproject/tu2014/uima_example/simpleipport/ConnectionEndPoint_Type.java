
/* First created by JCasGen Thu May 01 14:10:46 IDT 2014 */
package eu.excitementproject.tu2014.uima_example.simpleipport;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** 
 * Updated by JCasGen Thu May 01 14:10:46 IDT 2014
 * @generated */
public class ConnectionEndPoint_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ConnectionEndPoint_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ConnectionEndPoint_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ConnectionEndPoint(addr, ConnectionEndPoint_Type.this);
  			   ConnectionEndPoint_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ConnectionEndPoint(addr, ConnectionEndPoint_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ConnectionEndPoint.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
 
  /** @generated */
  final Feature casFeat_IpAddress;
  /** @generated */
  final int     casFeatCode_IpAddress;
  /** @generated */ 
  public int getIpAddress(int addr) {
        if (featOkTst && casFeat_IpAddress == null)
      jcas.throwFeatMissing("IpAddress", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    return ll_cas.ll_getRefValue(addr, casFeatCode_IpAddress);
  }
  /** @generated */    
  public void setIpAddress(int addr, int v) {
        if (featOkTst && casFeat_IpAddress == null)
      jcas.throwFeatMissing("IpAddress", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    ll_cas.ll_setRefValue(addr, casFeatCode_IpAddress, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Port;
  /** @generated */
  final int     casFeatCode_Port;
  /** @generated */ 
  public int getPort(int addr) {
        if (featOkTst && casFeat_Port == null)
      jcas.throwFeatMissing("Port", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    return ll_cas.ll_getRefValue(addr, casFeatCode_Port);
  }
  /** @generated */    
  public void setPort(int addr, int v) {
        if (featOkTst && casFeat_Port == null)
      jcas.throwFeatMissing("Port", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    ll_cas.ll_setRefValue(addr, casFeatCode_Port, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public ConnectionEndPoint_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_IpAddress = jcas.getRequiredFeatureDE(casType, "IpAddress", "eu.excitementproject.tu2014.uima_example.simpleipport.IpAddress", featOkTst);
    casFeatCode_IpAddress  = (null == casFeat_IpAddress) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_IpAddress).getCode();

 
    casFeat_Port = jcas.getRequiredFeatureDE(casType, "Port", "eu.excitementproject.tu2014.uima_example.simpleipport.Port", featOkTst);
    casFeatCode_Port  = (null == casFeat_Port) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Port).getCode();

  }
}



    