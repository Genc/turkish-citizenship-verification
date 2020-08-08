package online.citizenshipverification.turkish.utils;

import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public class ProjectConstants {

	public static final SoapActionCallback TR_IDENTITY_NO_VALIDATE_SOAP_ACTION;

	public static final SoapActionCallback FOREIGN_IDENTITY_NO_VALIDATE_SOAP_ACTION;

	public static final SoapActionCallback TR_IDENTITY_NO_DETAILED_VALIDATE_URI_SOAP_ACTION;

	public static final String PROJECT_CONTEXT_PATH = "online.citizenshipverification.turkish";

	public static final String WEB_SERVICE_DEFAULT_URI = "http://tckimlik.nvi.gov.tr/WS";

	public static final String KPS_PUBLIC_URI = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";

	public static final String KPS_PUBLIC_URI_V2 = "https://tckimlik.nvi.gov.tr/Service/KPSPublicV2.asmx";

	public static final String KPS_PUBLIC_URI_FOR_FOREIGN = "https://tckimlik.nvi.gov.tr/Service/KPSPublicYabanciDogrula.asmx";

	public static final String TR_IDENTITY_NO_VALIDATE_URI = "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula";

	public static final String FOREIGN_IDENTITY_NO_VALIDATE_URI = "http://tckimlik.nvi.gov.tr/WS/YabanciKimlikNoDogrula";

	public static final String TR_IDENTITY_NO_DETAILED_VALIDATE_URI = "http://tckimlik.nvi.gov.tr/WS/KisiVeCuzdanDogrula";

	static {
		TR_IDENTITY_NO_VALIDATE_SOAP_ACTION = new SoapActionCallback(TR_IDENTITY_NO_VALIDATE_URI);
		FOREIGN_IDENTITY_NO_VALIDATE_SOAP_ACTION = new SoapActionCallback(FOREIGN_IDENTITY_NO_VALIDATE_URI);
		TR_IDENTITY_NO_DETAILED_VALIDATE_URI_SOAP_ACTION = new SoapActionCallback(TR_IDENTITY_NO_DETAILED_VALIDATE_URI);
	}

	private ProjectConstants() {
		throw new UnsupportedOperationException();
	}

}
