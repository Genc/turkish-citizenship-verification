package online.citizenshipverification.turkish.service;

import lombok.RequiredArgsConstructor;
import online.citizenshipverification.turkish.KisiVeCuzdanDogrula;
import online.citizenshipverification.turkish.TCKimlikNoDogrula;
import online.citizenshipverification.turkish.YabanciKimlikNoDogrula;
import online.citizenshipverification.turkish.client.WebServiceClient;
import online.citizenshipverification.turkish.client.WebServiceMapper;
import online.citizenshipverification.turkish.model.DetailedCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.ForeignerCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.SimpleCitizenshipVerificationRequest;
import org.springframework.stereotype.Service;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Service
@RequiredArgsConstructor
public class VerificationServiceImpl implements VerificationService {

	private final WebServiceClient webServiceClient;

	@Override
	public boolean isValid(SimpleCitizenshipVerificationRequest simpleCitizenshipVerificationRequest) {

		final TCKimlikNoDogrula request = WebServiceMapper.INSTANCE.map(simpleCitizenshipVerificationRequest);

		return webServiceClient.isValid(request);
	}

	@Override
	public boolean isValid(DetailedCitizenshipVerificationRequest detailedCitizenshipVerificationRequest) {

		final KisiVeCuzdanDogrula request = WebServiceMapper.INSTANCE.map(detailedCitizenshipVerificationRequest);

		return webServiceClient.isValid(request);
	}

	@Override
	public boolean isValid(ForeignerCitizenshipVerificationRequest foreignerCitizenshipVerificationRequest) {

		final YabanciKimlikNoDogrula request = WebServiceMapper.INSTANCE.map(foreignerCitizenshipVerificationRequest);

		return webServiceClient.isValid(request);
	}
}
