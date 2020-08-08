package online.citizenshipverification.turkish.client;

import online.citizenshipverification.turkish.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.Objects;

import static online.citizenshipverification.turkish.utils.ProjectConstants.*;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Service
public class WebServiceClient extends WebServiceGatewaySupport {

	WebServiceClient() {

		final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(PROJECT_CONTEXT_PATH);

		this.setDefaultUri(WEB_SERVICE_DEFAULT_URI);
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}

	public boolean isValid(TCKimlikNoDogrula request) {

		final TCKimlikNoDogrulaResponse response = (TCKimlikNoDogrulaResponse) sendAndReceive(KPS_PUBLIC_URI, request, TR_IDENTITY_NO_VALIDATE_SOAP_ACTION);

		return Objects.nonNull(response) && response.isTCKimlikNoDogrulaResult();
	}

	public boolean isValid(KisiVeCuzdanDogrula request) {

		final KisiVeCuzdanDogrulaResponse response = (KisiVeCuzdanDogrulaResponse) sendAndReceive(KPS_PUBLIC_URI_V2, request, TR_IDENTITY_NO_DETAILED_VALIDATE_URI_SOAP_ACTION);

		return Objects.nonNull(response) && response.isKisiVeCuzdanDogrulaResult();
	}

	public boolean isValid(YabanciKimlikNoDogrula request) {

		final YabanciKimlikNoDogrulaResponse response = (YabanciKimlikNoDogrulaResponse) sendAndReceive(KPS_PUBLIC_URI_FOR_FOREIGN, request, FOREIGN_IDENTITY_NO_VALIDATE_SOAP_ACTION);

		return Objects.nonNull(response) && response.isYabanciKimlikNoDogrulaResult();
	}

	private Object sendAndReceive(final String URI, final Object requestPayload, final WebServiceMessageCallback requestCallback) {

		try {
			return getWebServiceTemplate().marshalSendAndReceive(URI, requestPayload, requestCallback);
		}
		catch (Exception e) {
			throw new WebServiceException(e);
		}
	}
}
