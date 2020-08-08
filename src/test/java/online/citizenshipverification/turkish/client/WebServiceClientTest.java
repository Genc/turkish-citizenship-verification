package online.citizenshipverification.turkish.client;

import online.citizenshipverification.turkish.KisiVeCuzdanDogrula;
import online.citizenshipverification.turkish.TCKimlikNoDogrula;
import online.citizenshipverification.turkish.YabanciKimlikNoDogrula;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.io.IOException;

import static online.citizenshipverification.turkish.TestUtils.*;
import static online.citizenshipverification.turkish.utils.ProjectConstants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@ExtendWith(MockitoExtension.class)
class WebServiceClientTest {

	@InjectMocks
	private WebServiceClient webServiceClient;

	@Mock
	private WebServiceTemplate webServiceTemplate;

	@Test
	void simpleVerificationTest() throws IOException {

		final TCKimlikNoDogrula request = generateTCKimlikNoDogrulaRequest();
		webServiceClient.isValid(request);

		verify(webServiceTemplate, times(1)).marshalSendAndReceive(KPS_PUBLIC_URI, request, TR_IDENTITY_NO_VALIDATE_SOAP_ACTION);
	}

	@Test
	void detailedVerificationTest() throws IOException {

		final KisiVeCuzdanDogrula request = generateKisiVeCuzdanDogrula();
		webServiceClient.isValid(request);

		verify(webServiceTemplate, times(1)).marshalSendAndReceive(KPS_PUBLIC_URI_V2, request, TR_IDENTITY_NO_DETAILED_VALIDATE_URI_SOAP_ACTION);
	}

	@Test
	void foreignerVerificationTest() throws IOException {

		final YabanciKimlikNoDogrula request = generateYabanciKimlikNoDogrula();
		webServiceClient.isValid(request);

		verify(webServiceTemplate, times(1)).marshalSendAndReceive(KPS_PUBLIC_URI_FOR_FOREIGN, request, FOREIGN_IDENTITY_NO_VALIDATE_SOAP_ACTION);
	}

	@Test
	void throwWebServiceException() {

		final TCKimlikNoDogrula request = new TCKimlikNoDogrula();
		when(webServiceClient.getWebServiceTemplate().marshalSendAndReceive(null, null, null)).thenThrow(new RuntimeException());
		assertThrows(WebServiceException.class, () -> webServiceClient.isValid(request));

	}
}
