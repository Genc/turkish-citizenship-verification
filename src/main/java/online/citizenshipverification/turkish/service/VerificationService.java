package online.citizenshipverification.turkish.service;

import online.citizenshipverification.turkish.model.DetailedCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.ForeignerCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.SimpleCitizenshipVerificationRequest;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public interface VerificationService {

	boolean isValid(SimpleCitizenshipVerificationRequest simpleCitizenshipVerificationRequest);

	boolean isValid(DetailedCitizenshipVerificationRequest detailedCitizenshipVerificationRequest);

	boolean isValid(ForeignerCitizenshipVerificationRequest foreignerCitizenshipVerificationRequest);

}

