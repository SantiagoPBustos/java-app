package models;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Request {
	private int numberRegistered;
	private NumberRequest numberRequest;
	private PersonType typeOfPerson;
	private String nameOrBusinessReason;
	private DocumentType typeOfDocument;
	private int idNumber;
	private int numberOfEmployees;
	private LocalDate date;
	private float valueConsignment;
	
	DecimalFormat decimalFormat =new DecimalFormat("$ "+"##,###.##");
	
	public Request(int numberRegistered,NumberRequest numberRequest,PersonType typeOfPerson,String nameOrBusinessReason,DocumentType typeOfDocument,int idNumber,int numberOfEmployees,LocalDate date ) {
		this.numberRegistered=numberRegistered;
		this.numberRequest=numberRequest;
		this.typeOfPerson=typeOfPerson;
		this.nameOrBusinessReason=nameOrBusinessReason;
		this.typeOfDocument=typeOfDocument;
		this.idNumber=idNumber;
		this.numberOfEmployees=numberOfEmployees;
		this.date=date;
		this.valueConsignment=0;
	}

	public int getNumberRegistered() {
		return numberRegistered;
	}
	public void setNumberRegistered(int numberRegistered) {
		this.numberRegistered = numberRegistered;
	}
	
	public NumberRequest getNumberRequest() {
		return numberRequest;
	}

	public void setNumberRequest(NumberRequest numberRequest) {
		this.numberRequest = numberRequest;
	}

	public PersonType getTypeOfPerson() {
		return typeOfPerson;
	}

	public void setTypeOfPerson(PersonType typeOfPerson) {
		this.typeOfPerson = typeOfPerson;
	}

	public String getNameOrBusinessReason() {
		return nameOrBusinessReason;
	}

	public void setNameOrBusinessReason(String nameOrBusinessReason) {
		this.nameOrBusinessReason = nameOrBusinessReason;
	}

	public DocumentType getTypeOfDocument() {
		return typeOfDocument;
	}

	public void setTypeOfDocument(DocumentType typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public float getValueConsignment() {
		return valueConsignment;
	}
	public void setValueConsignment(float valueConsignment) {
		this.valueConsignment = valueConsignment;
	}
	public Object[] toObjectVector() {
		return new Object[]{numberRegistered,numberRequest.getLabel(),typeOfPerson.getLabel(),nameOrBusinessReason,typeOfDocument.getLabel(),
				idNumber,numberOfEmployees,date,decimalFormat.format(valueConsignment)};
	}
}
