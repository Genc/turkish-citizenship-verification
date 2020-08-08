package online.citizenshipverification.turkish.client;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public class WebServiceException extends RuntimeException {

	WebServiceException(Exception exception){
		super(exception);
	}

}
