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
public class ForeignerCitizenshipVerificationRequest {

	@NotNull(message = "{identity_cannot_be_blank}")
	private long identityNo;

	@NotBlank(message = "{name_cannot_be_blank}")
	private String name;

	@NotBlank(message = "{surname_cannot_be_blank}")
	private String surname;

	@NotNull(message = "{birth_day_cannot_be_blank}")
	private Integer birthDay;

	@NotNull(message = "{birth_month_cannot_be_blank}")
	private Integer birthMonth;

	@NotNull(message = "{birth_year_cannot_be_blank}")
	private int birthYear;

}
