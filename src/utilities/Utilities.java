package utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import models.DocumentType;
import models.NumberRequest;
import models.PersonType;
import models.Request;

public class Utilities {
	
	public static LocalDate parseDateToLocalDate(Date date) { 
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static String toDecimalFormat( double value ) {
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern( "###########,###.## $" );
		String strValue = df.format( value );
		return strValue;		
	}
	
	public static String parseFormatDate(String date) {
		SimpleDateFormat originalFormatter = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat newFormatter = new SimpleDateFormat ("dd/MM/yyyy");
		ParsePosition position = new ParsePosition(0);
		Date dateFormatted = originalFormatter.parse(date, position);
		String dateInNewFormat = newFormatter.format(dateFormatted);
		return dateInNewFormat;
	}
	
	public static Date parseStringToDate(String dateString) {
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static LocalDate parseStringToLocalDate( String stringDate) {
		return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
	}
	
	public static String[] splitLine(String line){
		return line.split("#");
	}
	
	public static NumberRequest getNumberRequest( String numberPerson) {
		switch (numberPerson) {
		case "Primera Vez":
			return NumberRequest.FIRST;
		case "Segunda Vez":
			return NumberRequest.SECOND;
		case "Tercera Vez":
			return NumberRequest.THIRD;
		default:
			return NumberRequest.FIRST;
		}
	}
	
	public static PersonType getTypePerson( String typePerson) {
		switch (typePerson) {
		case "Persona jurídica":
			return PersonType.LEGAL_PERSON;
		case "Persona natural":
			return PersonType.NATURAL_PERSON;
		case "Entidad sin ánimo de lucro":
			return PersonType.ENTITY;
		case "Unión temporal":
			return PersonType.TEMPORAL_JOIN;
		default:
			return PersonType.NATURAL_PERSON;
		}
	}
	
	public static DocumentType getTypeDocument( String documentType) {
		switch (documentType) {
		case "Cedula de Ciudadania":
			return DocumentType.CITIZENSHIP_ID;
		case "Pasaporte":
			return DocumentType.PASSPORT;
		case "Cedula de Extranjeria":
			return DocumentType.FOREIGNER_ID;
		default:
			return DocumentType.CITIZENSHIP_ID;
		}
	}
	
	public static String getLineRequest(Request request) {
		String line;
		line=request.getNumberRequest().getLabel()+"#";
		line+=request.getTypeOfPerson().getLabel()+"#";
		line+=request.getNameOrBusinessReason()+"#";
		line+=request.getTypeOfDocument().getLabel()+"#";
		line+=request.getIdNumber()+"#";
		line+=request.getNumberOfEmployees()+"#";
		line+=request.getDate();
		return line;
	}
	
	//Generador de solicitudes
	public static Request generateRequest(int numberRegistered, ArrayList<Request> arrayRequest,String[] listBusiness,int iterador) {
		return new Request(numberRegistered, generateNumberRequest(generateIntNumberRequest(arrayRequest,listBusiness[iterador])), 
				generatePersonType(numberAleatory(4,1)), listBusiness[iterador], generateDocumentType(numberAleatory(3,1)), 
				numberAleatory(100000000,90000000), numberAleatory(50,3), generateLocalDate(numberRegistered));
		
	}
	//Numero aleatorio
	public static int numberAleatory(int higher,int less) {
		return (int) Math.floor(Math.random()*(higher-less+1)+less);
	}
	//Validar numero de solicitud
	public static int generateIntNumberRequest(ArrayList<Request> arrayRequest, String nameBusiness) {
		int number=1;
		Iterator<Request> iteratorArray=arrayRequest.iterator();
		while (iteratorArray.hasNext()) {
			Request requestIterator = iteratorArray.next();
			if ( nameBusiness.equals(requestIterator.getNameOrBusinessReason())) {
				number+=1;
			}
		}
		return number;
	}
	//Numero de solicitud
	public static NumberRequest generateNumberRequest(int option) {
		switch (option) {
		case 1:
			return NumberRequest.FIRST;
		case 2:
			return NumberRequest.SECOND;
		case 3:
			return NumberRequest.THIRD;
		default:
			return NumberRequest.FIRST;
		}
	}
	//Tipo de Persona
	public static PersonType generatePersonType(int option) {
		switch (option) {
		case 1:
			return PersonType.LEGAL_PERSON;
		case 2:
			return PersonType.NATURAL_PERSON;
		case 3:
			return PersonType.ENTITY;
		case 4:
			return PersonType.TEMPORAL_JOIN;
		default:
			return PersonType.NATURAL_PERSON;
		}
	}
	//Tipo de Documento
	public static DocumentType generateDocumentType(int option) {
		switch (option) {
		case 1:
			return DocumentType.CITIZENSHIP_ID;
		case 2:
			return DocumentType.PASSPORT;
		case 3:
			return DocumentType.FOREIGNER_ID;
		default:
			return DocumentType.CITIZENSHIP_ID;
		}
	}
	//Generar fecha
	public static LocalDate generateLocalDate(int numberRequest) {
		LocalDate date=LocalDate.of(2020, numberAleatory(6,4), numberAleatory(28,1));
		return date;
		
	}
}
