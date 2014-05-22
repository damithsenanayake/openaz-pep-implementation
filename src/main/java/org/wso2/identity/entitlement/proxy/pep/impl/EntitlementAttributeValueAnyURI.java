/**
 * Copyright 2009 Oracle, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *
 * Authors:
 * 		Rich Levinson (Oracle)
 * Contributor:
 * 		Rich Levinson (Oracle)
 */
package org.wso2.identity.entitlement.proxy.pep.impl;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openliberty.openaz.azapi.*;
import org.openliberty.openaz.azapi.constants.*;


public class EntitlementAttributeValueAnyURI
	extends EntitlementAttributeValue<AzDataTypeIdAnyURI, URI> 
	implements AzAttributeValueAnyURI {
	URI uri;
	Log log = LogFactory.getLog(this.getClass()); 
	public EntitlementAttributeValueAnyURI(URI uri){
		super(AzDataTypeIdAnyURI.AZ_DATATYPE_ID_ANYURI, uri);
		this.uri = uri;
		if (log.isTraceEnabled()) log.trace(
			"\n\tURI Created = " + uri);
	}
	public void setValue(URI uri){
		this.uri = uri;
	}
	public URI getValue() {
		return uri;
	}
	public String toXacmlString() {
		return uri.toString();
	}
	public boolean validate(){
		return true;
	}
}