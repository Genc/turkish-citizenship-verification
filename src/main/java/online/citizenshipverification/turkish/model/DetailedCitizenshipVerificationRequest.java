package online.citizenshipverification.turkish.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Getter
@Setter
public class DetailedCitizenshipVerificationRequest {

	@NotNull(message = "{identity_cannot_be_blank}")
	private long identityNo;

	@NotBlank(message = "{name_cannot_be_blank}")
	private String name;

	@NotBlank(message = "{surname_cannot_be_blank}")
	private String surname;

	private Integer birthDay;

	private Integer birthMonth;

	private int birthYear;

	private String serialCode;

	private Integer serialNumber;

	private String documentNo;

	private boolean hasNotSurname = false;

	private boolean hasNotDayOfBirth = false;

	private boolean hasNotMonthOfBirth = false;

}
