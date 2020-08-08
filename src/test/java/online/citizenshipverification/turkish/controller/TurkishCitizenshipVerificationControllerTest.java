package online.citizenshipverification.turkish.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import online.citizenshipverification.turkish.model.DetailedCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.ForeignerCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.SimpleCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.service.VerificationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static online.citizenshipverification.turkish.TestUtils.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@ExtendWith(MockitoExtension.class)
class TurkishCitizenshipVerificationControllerTest {

	private static final String SIMPLE_VERIFICATION_ENDPOINT = "/simple-verification";

	private static final String DETAILED_VERIFICATION_ENDPOINT = "/detailed-verification";

	private static final String FOREIGNER_VERIFICATION_ENDPOINT = "/foreigner-verification";

	private MockMvc mockMvc;

	private ObjectMapper objectMapper;

	@Mock
	private VerificationService verificationService;

	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(new TurkishCitizenshipVerificationController(verificationService)).build();
	}

	@Test
	void simpleVerificationForTurkishIdentification() throws Exception {

		final SimpleCitizenshipVerificationRequest request = generateSimpleCitizenshipVerificationRequest();

		mockMvc.perform(post(SIMPLE_VERIFICATION_ENDPOINT).contentType(APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(request))).andExpect(status().isOk());

		ArgumentCaptor<SimpleCitizenshipVerificationRequest> argumentCaptor = ArgumentCaptor.forClass(SimpleCitizenshipVerificationRequest.class);

		verify(verificationService, Mockito.times(1)).isValid(argumentCaptor.capture());
		Assertions.assertEquals(argumentCaptor.getValue().getName(), request.getName());
	}

	@Test
	void detailedVerificationForTurkishIdentification() throws Exception {

		final DetailedCitizenshipVerificationRequest request = generateDetailedCitizenshipVerificationRequest();

		mockMvc.perform(post(DETAILED_VERIFICATION_ENDPOINT).contentType(APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(request))).andExpect(status().isOk());

		ArgumentCaptor<DetailedCitizenshipVerificationRequest> argumentCaptor = ArgumentCaptor.forClass(DetailedCitizenshipVerificationRequest.class);

		verify(verificationService, Mockito.times(1)).isValid(argumentCaptor.capture());
		Assertions.assertEquals(argumentCaptor.getValue().getDocumentNo(), request.getDocumentNo());
	}

	@Test
	void verificationForForeignerIdentification() throws Exception{

		final ForeignerCitizenshipVerificationRequest request = generateForeignerCitizenshipVerificationRequest();

		mockMvc.perform(post(FOREIGNER_VERIFICATION_ENDPOINT).contentType(APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(request))).andExpect(status().isOk());

		ArgumentCaptor<ForeignerCitizenshipVerificationRequest> argumentCaptor = ArgumentCaptor.forClass(ForeignerCitizenshipVerificationRequest.class);

		verify(verificationService, Mockito.times(1)).isValid(argumentCaptor.capture());
		Assertions.assertEquals(argumentCaptor.getValue().getBirthMonth(), request.getBirthMonth());
	}

	@Test
	void whenInvalidRequestThenReturnBadRequest() throws Exception{

		final SimpleCitizenshipVerificationRequest request = new SimpleCitizenshipVerificationRequest();

		mockMvc.perform(post(SIMPLE_VERIFICATION_ENDPOINT).contentType(APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(request))).andExpect(status().isBadRequest());
	}

}
