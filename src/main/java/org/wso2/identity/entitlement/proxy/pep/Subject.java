package org.wso2.identity.entitlement.proxy.pep;

import org.openliberty.openaz.azapi.AzEntity;
import org.openliberty.openaz.azapi.constants.AzCategoryIdSubjectAccess;
import org.openliberty.openaz.azapi.pep.PepRequest;
import org.openliberty.openaz.azapi.pep.RequestAttributesFactory;

/**
 * This class is a non-generic facade for 
 * AzEntity<AzCategoryIdSubjectAccess> 
 * @author rlevinson,jbregman,pmishra
 *
 */
public class Subject extends 
		RequestAttributesImpl<AzCategoryIdSubjectAccess>{
    
    public Subject(
    		AzEntity<AzCategoryIdSubjectAccess> env, 
    		PepRequest ctx, 
    		RequestAttributesFactory<AzCategoryIdSubjectAccess> factory) {
        super(env,ctx,factory);
    }
    
    
    
}
