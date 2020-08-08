package online.citizenshipverification.turkish.advice;

import online.citizenshipverification.turkish.client.WebServiceException;
import online.citizenshipverification.turkish.controller.TurkishCitizenshipVerificationController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@RestControllerAdvice(basePackageClasses = TurkishCitizenshipVerificationController.class)
public class TurkishCitizenshipVerificationControllerAdvice {

	@ExceptionHandler(WebServiceException.class)
	ResponseEntity<ApiExceptionResponse> handleExceptions(WebServiceException exception) {

		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());

		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
