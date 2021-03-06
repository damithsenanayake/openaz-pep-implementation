package client;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;

import org.apache.axis2.AxisFault;
import org.openliberty.openaz.azapi.AzAttribute;
import org.openliberty.openaz.azapi.AzEntity;
import org.openliberty.openaz.azapi.AzService;
import org.openliberty.openaz.azapi.constants.AzCategoryIdObligation;
import org.openliberty.openaz.azapi.pep.Obligation;
import org.openliberty.openaz.azapi.pep.PepRequest;
import org.openliberty.openaz.azapi.pep.PepRequestFactory;
import org.openliberty.openaz.azapi.pep.PepResponse;
import org.wso2.carbon.authenticator.stub.LoginAuthenticationExceptionException;
import org.wso2.carbon.authenticator.stub.LogoutAuthenticationExceptionException;
import org.wso2.identity.entitlement.proxy.pep.PepRequestFactoryImpl;
import org.wso2.identity.entitlement.proxy.pep.provider.EntitlementServiceClient;

public class TestClient {

	public static void main(String args[]) {
		String session;
		AzService entitlementService;

		String backEndUrl = "https://localhost:9443/services/";

		String data[][] = new String[2][3];
		// just to see how an attribute with ">" or "<" affects the run
		data[0][0] = "bob";
		data[0][1] = "read";
		data[0][2] = "https://localhost:9443/services/EntitlementService";

		data[1][0] = "alice";
		data[1][1] = "read";
		data[1][2] = "https://localhost:9443/services/EntitlementService";

		try {
			session = EntitlementServiceClient.getSession("admin", "admin", backEndUrl);
			entitlementService = new EntitlementServiceClient(session, backEndUrl);
			PepRequestFactory pepRequestFactory =
			                                      new PepRequestFactoryImpl("ENTITLEMENT_SERVICE",
			                                                                entitlementService);

			for (int i = 0; i < data.length; i++) {// subjectName, actionID,
				                                   // resource //
				PepRequest request =
				                     pepRequestFactory.newPepRequest(data[i][0], data[i][1],
				                                                     data[i][2]);

				PepResponse response = request.decide();
				System.out.println(">>>>" + data[i][0] + " is trying to " + data[i][1] +
				                   " resource " + data[i][2] + "<<<<");

				if (response.allowed()) {
					System.out.println(data[i][0] + " has the " + data[i][1] + " permission.");
				} else {
					System.out.println(data[i][0] + " does not have the " + data[i][1] +
					                   " permission.");
				}

				Map<String, Obligation> obligations = response.getObligations();

				if (!obligations.isEmpty()) {
					System.out.println("Obligations>>");
				}

				for (String entry : obligations.keySet()) {
					AzEntity<AzCategoryIdObligation> temp = obligations.get(entry).getAzEntity();

					Set<AzAttribute<?>> mixedset = temp.getAzAttributeMixedSet();

					Iterator<AzAttribute<?>> itr = mixedset.iterator();
					while (itr.hasNext()) {
						AzAttribute<?> attr = itr.next();
						System.out.print("change attribute \"" + attr.getAttributeId() + "\" to \"");
						System.out.println(attr.getAzAttributeValue().toString().trim() + "\"");

					}

				}
				System.out.println();
			}

			EntitlementServiceClient.logout();
		} catch (AxisFault e) {
			System.out.println("AxisFault encountered:");
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("RemoteException encountered:");
			e.printStackTrace();
		} catch (LoginAuthenticationExceptionException e) {
			System.out.println("LoginAuthenticationException encountered:");
			e.printStackTrace();
		} catch (LogoutAuthenticationExceptionException e) {
			System.out.println("LogoutAuthenticationException encountered:");
			e.printStackTrace();
		}

	}

}
