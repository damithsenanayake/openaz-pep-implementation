package org.wso2.identity.entitlement.proxy.pep;

import org.openliberty.openaz.azapi.AzEntity;
import org.openliberty.openaz.azapi.AzRequestContext;
import org.openliberty.openaz.azapi.constants.AzCategoryIdAction;
import org.openliberty.openaz.azapi.constants.AzCategoryIdSubjectAccess;
import org.openliberty.openaz.azapi.pep.PepRequest;
import org.wso2.identity.entitlement.proxy.pep.impl.EntitlementRequestContext;

/**
 * SubjectFactory creates an instance of 
 * {@link AzEntity}<{@link AzCategoryIdSubjectAccess}>, which is 
 * an AzApi collection that can contain attributes to
 * represent the Subject entity in a Xacml Request.
 * <p>
 * TODO: The original intent of this class and the objects it
 * creates was to mask the generic character of the
 * AzApi attributes to simplify the PepApi. However,
 * since these collections all appear at the "SPI level"
 * such masking may not be necessary and these classes
 * may be removed as redundant.
 * 
 * @author rlevinson,jbregman,pmishra
 *
 */
public class SubjectFactory 
		extends RequestAttributesFactoryImpl<AzCategoryIdSubjectAccess> {

    public Subject createObject(PepRequest pepRequestContext) {
        
        AzRequestContext ctx = ((PepRequestImpl)pepRequestContext).getEntitlementRequestContext();
        
        AzCategoryIdSubjectAccess azSubjCat = 
                AzCategoryIdSubjectAccess.AZ_CATEGORY_ID_SUBJECT_ACCESS;

        AzEntity<AzCategoryIdSubjectAccess> accSubj = 
                ctx.createAzEntity(azSubjCat);
                
        ctx.addAzEntity(accSubj);
        
        return new Subject(accSubj,pepRequestContext,this);            
    }
}
