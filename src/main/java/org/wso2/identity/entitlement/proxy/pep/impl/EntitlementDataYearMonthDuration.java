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
import org.openliberty.openaz.azapi.*;
//import org.openliberty.openaz.azapi.constants.*;


public class EntitlementDataYearMonthDuration 
	implements AzDataYearMonthDuration{
	boolean isNegativeDuration = false;
	long years = 0;
	long months = 0;
	public EntitlementDataYearMonthDuration(
			boolean isNegativeDuration,
			long years,
			long months){
		this.isNegativeDuration = isNegativeDuration;
		this.years = years;
		this.months = months;
	}
	/**
	 * Set boolean indicating whether duration is positive or
	 * negative
	 * @param b true means negative, false means positive
	 */
	public void setNegativeDuration(boolean b){
		this.isNegativeDuration = b;
	}
	
	/**
	 * Get boolean indicating whether duration is positive or
	 * negative
	 * @return a boolean true if negative, false if positive
	 */
	public boolean getNegativeDuration(){
		return isNegativeDuration;
	}

	/**
	 * Set long indicating number of days in duration
	 * @param intLong integer number of day in duration
	 */
	public void setYearsInDuration(long intLong){
		this.years = intLong;
	}
	
	/**
	 * Get long indicating number of years in duration
	 * @return a long w integer specifying number of years
	 */
	public long getYearsInDuration(){
		return years;
	}

	/**
	 * Set long indicating number of years in duration
	 * @param intLong integer number of years in duration
	 */
	public void setMonthsInDuration(long intLong){
		this.months = intLong;
	}
	
	/**
	 * Get long indicating number of months in duration
	 * @return a long w integer specifying number of months
	 */
	public long getMonthsInDuration(){
		return months;
	}
}
