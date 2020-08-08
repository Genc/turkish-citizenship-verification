package online.citizenshipverification.turkish;

import com.fasterxml.jackson.databind.ObjectMapper;
import online.citizenshipverification.turkish.model.DetailedCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.ForeignerCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.SimpleCitizenshipVerificationRequest;

import java.io.File;
import java.io.IOException;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public class TestUtils {

	private static final String TEST_RESOURCES_PATH = "src/test/resources/";

	public static TCKimlikNoDogrula generateTCKimlikNoDogrulaRequest() throws IOException {

		return convertJsonFileToJavaBean("TCKimlikNoDogrula.json", TCKimlikNoDogrula.class);
	}

	public static KisiVeCuzdanDogrula generateKisiVeCuzdanDogrula() throws IOException {

		return convertJsonFileToJavaBean("KisiVeCuzdanDogrula.json", KisiVeCuzdanDogrula.class);
	}

	public static YabanciKimlikNoDogrula generateYabanciKimlikNoDogrula() throws IOException {

		return convertJsonFileToJavaBean("YabanciKimlikNoDogrula.json", YabanciKimlikNoDogrula.class);
	}

	public static SimpleCitizenshipVerificationRequest generateSimpleCitizenshipVerificationRequest() throws IOException {

		return convertJsonFileToJavaBean("SimpleCitizenshipVerificationRequest.json", SimpleCitizenshipVerificationRequest.class);
	}

	public static DetailedCitizenshipVerificationRequest generateDetailedCitizenshipVerificationRequest() throws IOException {

		return convertJsonFileToJavaBean("DetailedCitizenshipVerificationRequest.json", DetailedCitizenshipVerificationRequest.class);
	}

	public static ForeignerCitizenshipVerificationRequest generateForeignerCitizenshipVerificationRequest() throws IOException {

		return convertJsonFileToJavaBean("ForeignerCitizenshipVerificationRequest.json", ForeignerCitizenshipVerificationRequest.class);
	}

	public static <T> T convertJsonFileToJavaBean(String fileName, Class<T> valueType) throws IOException {

		final ObjectMapper objectMapper = new ObjectMapper();
		final File file = new File(TEST_RESOURCES_PATH + fileName);

		return objectMapper.readValue(file, valueType);
	}

}
