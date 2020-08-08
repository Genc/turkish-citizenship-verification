package online.citizenshipverification.turkish.controller;

import lombok.RequiredArgsConstructor;
import online.citizenshipverification.turkish.model.DetailedCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.ForeignerCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.SimpleCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.service.VerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@RestController
@RequiredArgsConstructor
public class TurkishCitizenshipVerificationController {

	private final VerificationService verificationService;

	@PostMapping("/simple-verification")
	public ResponseEntity<Boolean> simpleVerificationForTurkishIdentification(@Valid @RequestBody SimpleCitizenshipVerificationRequest request) {

		final boolean isValid = verificationService.isValid(request);

		return ResponseEntity.ok(isValid);
	}

	@PostMapping("/detailed-verification")
	public ResponseEntity<Boolean> detailedVerificationForTurkishIdentification(@Valid @RequestBody DetailedCitizenshipVerificationRequest request) {

		final boolean isValid = verificationService.isValid(request);

		return ResponseEntity.ok(isValid);
	}

	@PostMapping("/foreigner-verification")
	public ResponseEntity<Boolean> verificationForForeignerIdentification(@Valid @RequestBody ForeignerCitizenshipVerificationRequest request) {

		final boolean isValid = verificationService.isValid(request);

		return ResponseEntity.ok(isValid);
	}

}
