
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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu May 01 14:10:46 IDT 2014
 * @generated */
public class Port_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Port_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Port_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Port(addr, Port_Type.this);
  			   Port_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Port(addr, Port_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Port.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("eu.excitementproject.tu2014.uima_example.simpleipport.Port");
 
  /** @generated */
  final Feature casFeat_Number;
  /** @generated */
  final int     casFeatCode_Number;
  /** @generated */ 
  public short getNumber(int addr) {
        if (featOkTst && casFeat_Number == null)
      jcas.throwFeatMissing("Number", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    return ll_cas.ll_getShortValue(addr, casFeatCode_Number);
  }
  /** @generated */    
  public void setNumber(int addr, short v) {
        if (featOkTst && casFeat_Number == null)
      jcas.throwFeatMissing("Number", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    ll_cas.ll_setShortValue(addr, casFeatCode_Number, v);}
    
  
 
  /** @generated */
  final Feature casFeat_IsKnown;
  /** @generated */
  final int     casFeatCode_IsKnown;
  /** @generated */ 
  public boolean getIsKnown(int addr) {
        if (featOkTst && casFeat_IsKnown == null)
      jcas.throwFeatMissing("IsKnown", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_IsKnown);
  }
  /** @generated */    
  public void setIsKnown(int addr, boolean v) {
        if (featOkTst && casFeat_IsKnown == null)
      jcas.throwFeatMissing("IsKnown", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_IsKnown, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Port_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Number = jcas.getRequiredFeatureDE(casType, "Number", "uima.cas.Short", featOkTst);
    casFeatCode_Number  = (null == casFeat_Number) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Number).getCode();

 
    casFeat_IsKnown = jcas.getRequiredFeatureDE(casType, "IsKnown", "uima.cas.Boolean", featOkTst);
    casFeatCode_IsKnown  = (null == casFeat_IsKnown) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_IsKnown).getCode();

  }
}



    