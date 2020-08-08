package online.citizenshipverification.turkish.client;

import online.citizenshipverification.turkish.KisiVeCuzdanDogrula;
import online.citizenshipverification.turkish.TCKimlikNoDogrula;
import online.citizenshipverification.turkish.YabanciKimlikNoDogrula;
import online.citizenshipverification.turkish.model.DetailedCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.ForeignerCitizenshipVerificationRequest;
import online.citizenshipverification.turkish.model.SimpleCitizenshipVerificationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Mapper
public interface WebServiceMapper {

	WebServiceMapper INSTANCE = Mappers.getMapper(WebServiceMapper.class);

	@Named("toUpperCase")
	static String toUpperCase(String name) {
		return name.toUpperCase();
	}

	@Mapping(source = "birthYear", target = "dogumYili")
	@Mapping(source = "identityNo", target = "TCKimlikNo")
	@Mapping(source = "name", target = "ad", qualifiedByName = "toUpperCase")
	@Mapping(source = "surname", target = "soyad", qualifiedByName = "toUpperCase")
	TCKimlikNoDogrula map(SimpleCitizenshipVerificationRequest simpleCitizenshipVerificationRequest);

	@Mapping(source = "birthDay", target = "dogumGun")
	@Mapping(source = "birthMonth", target = "dogumAy")
	@Mapping(source = "birthYear", target = "dogumYil")
	@Mapping(source = "identityNo", target = "TCKimlikNo")
	@Mapping(source = "serialCode", target = "cuzdanSeri")
	@Mapping(source = "serialNumber", target = "cuzdanNo")
	@Mapping(source = "documentNo", target = "TCKKSeriNo")
	@Mapping(source = "hasNotSurname", target = "soyadYok")
	@Mapping(source = "hasNotDayOfBirth", target = "dogumGunYok")
	@Mapping(source = "hasNotMonthOfBirth", target = "dogumAyYok")
	@Mapping(source = "name", target = "ad", qualifiedByName = "toUpperCase")
	@Mapping(source = "surname", target = "soyad", qualifiedByName = "toUpperCase")
	KisiVeCuzdanDogrula map(DetailedCitizenshipVerificationRequest request);

	@Mapping(source = "birthDay", target = "dogumGun")
	@Mapping(source = "birthMonth", target = "dogumAy")
	@Mapping(source = "birthYear", target = "dogumYil")
	@Mapping(source = "identityNo", target = "kimlikNo")
	@Mapping(source = "name", target = "ad", qualifiedByName = "toUpperCase")
	@Mapping(source = "surname", target = "soyad", qualifiedByName = "toUpperCase")
	YabanciKimlikNoDogrula map(ForeignerCitizenshipVerificationRequest foreignerCitizenshipVerificationRequest);

}
