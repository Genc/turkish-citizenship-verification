package online.citizenshipverification.turkish.service;

import online.citizenshipverification.turkish.KisiVeCuzdanDogrula;
import online.citizenshipverification.turkish.TCKimlikNoDogrula;
import online.citizenshipverification.turkish.YabanciKimlikNoDogrula;
import online.citizenshipverification.turkish.client.WebServiceClient;
import online.citizenshipverification.turkish.model.DetailedCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.ForeignerCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.SimpleCitizenshipVerificationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static online.citizenshipverification.turkish.TestUtils.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@ExtendWith(MockitoExtension.class)
class VerificationServiceTest {

	@InjectMocks
	private VerificationServiceImpl verificationService;

	@Mock
	private WebServiceClient webServiceClient;

	@Test
	void simpleVerificationTest() throws IOException {

		final SimpleCitizenshipVerificationRequest request = generateSimpleCitizenshipVerificationRequest();
		final boolean isValid = verificationService.isValid(request);

		Assertions.assertFalse(isValid);
		Mockito.verify(webServiceClient, Mockito.times(1)).isValid(any(TCKimlikNoDogrula.class));
	}

	@Test
	void detailedVerificationTest() throws IOException {

		final DetailedCitizenshipVerificationRequest request = generateDetailedCitizenshipVerificationRequest();
		final boolean isValid = verificationService.isValid(request);

		Assertions.assertFalse(isValid);
		Mockito.verify(webServiceClient, Mockito.times(1)).isValid(any(KisiVeCuzdanDogrula.class));
	}

	@Test
	void foreignerVerificationTest() throws IOException {

		final ForeignerCitizenshipVerificationRequest request = generateForeignerCitizenshipVerificationRequest();
		final boolean isValid = verificationService.isValid(request);

		Assertions.assertFalse(isValid);
		Mockito.verify(webServiceClient, Mockito.times(1)).isValid(any(YabanciKimlikNoDogrula.class));
	}
}
