package models;

import java.util.ArrayList;
import java.util.Iterator;

public class ManagerRequest {
	ArrayList<Request> arrayRequest=new ArrayList<Request>();
	
	public static final int SIZE_COLUMNS=9;

	public boolean addRequest(Request request) {
		if(request.getNumberOfEmployees()>=3) {
			short countRequest = 0;
			Iterator<Request> iteratorArray=arrayRequest.iterator();
				while(iteratorArray.hasNext()) {
					Request requestIterator=iteratorArray.next();
					if(requestIterator.getIdNumber()==request.getIdNumber()) {
						countRequest++;
					}
				}
				if(countRequest<3) {
					arrayRequest.add(request);
					return true;
				}else {
					return false;
				}
		}else {
			return false;
		}
	}
	
	public void addEditRequest(Request requestEdit) {
		int position=requestEdit.getNumberRegistered()-1;
		arrayRequest.remove(position);
		arrayRequest.add(position, requestEdit);
		this.calculateValueOfConsign();
	}
	
	public Object[] searchRegistered(int numberRegistered) {
		Object[] request=null;
		Iterator<Request> iteratorArray=arrayRequest.iterator();
		while (iteratorArray.hasNext()) {
			Request requestIterator = iteratorArray.next();
			if(requestIterator.getNumberRegistered()==numberRegistered) {
				request=requestIterator.toObjectVector();
				return request;
			}
		}
		return request;
	}
	
	public boolean deleteRequest(int numberRegistered) {
		int position=-1;
		Iterator<Request> iteratorArray=arrayRequest.iterator();
		while (iteratorArray.hasNext()) {
			Request requestIterator = iteratorArray.next();
			if(requestIterator.getNumberRegistered()==numberRegistered) {
				position=arrayRequest.indexOf(requestIterator);
			}
		}
		if (position!=-1) {
			arrayRequest.remove(position);
			return true;
		}else {
			return false;
		}
	}
	
	public void calculateValueOfConsign() {
		int numberEmployees;
		for (int i = 0; i < arrayRequest.size(); i++) {
			numberEmployees=arrayRequest.get(i).getNumberOfEmployees();
			arrayRequest.get(i).setValueConsignment((float) (392262.8*numberEmployees));
		}
	}
	
	public Object[][] toMatrixListRequest(){
		Object [][] listRequest=new Object[arrayRequest.size()][SIZE_COLUMNS];
		int i=0;
		for (Request request : arrayRequest) {
			if(request!=null) {
				listRequest[i]=request.toObjectVector();
				i++;
			}
		}
		return listRequest;
	}
	
	public float [] percentajeTypeRequest() {
		int countFirst = 0,countSecond = 0,countThird = 0;
		for (Request request : arrayRequest) {
            if (request != null) {
            	if(request.getNumberRequest().equals(NumberRequest.FIRST)) {
            		countFirst++;
            	}else if(request.getNumberRequest().equals(NumberRequest.SECOND)) {
            		countSecond++;
            	}else {
            		countThird++;
            	}
            }
		}
		float first=calculatePorcentage(countFirst);
		float second=calculatePorcentage(countSecond);
		float third=calculatePorcentage(countThird);
		float[]listRequest= {first,second,third};
		return listRequest;
	}
	
	public float [] percentajeTypePerson() {
		int countNaturalPerson = 0,countLegalPerson = 0,countTemporal = 0,countEntity = 0;
		for (Request request : arrayRequest) {
            if (request != null) {
            	if(request.getTypeOfPerson().equals(PersonType.NATURAL_PERSON)) {
            		countNaturalPerson++;
            	}else if(request.getTypeOfPerson().equals(PersonType.LEGAL_PERSON)) {
            		countLegalPerson++;
            	}else if(request.getTypeOfPerson().equals(PersonType.TEMPORAL_JOIN)) {
            		countTemporal++;
            	}else {
            		countEntity++;
            	}
            }
		}
		float naturalPerson=calculatePorcentage(countNaturalPerson);
		float legalPerson=calculatePorcentage(countLegalPerson);
		float temporalJoin=calculatePorcentage(countTemporal);
		float entity=calculatePorcentage(countEntity);
		float[]listPerson= {naturalPerson,legalPerson,entity,temporalJoin};
		return listPerson;
	}
	
	public float [] percentajeTypeDocument() {
		int countCitizenship= 0,countPassport = 0,countForeigner= 0;
		for (Request request : arrayRequest) {
            if (request != null) {
            	if(request.getTypeOfDocument().equals(DocumentType.CITIZENSHIP_ID)) {
            		countCitizenship++;
            	}else if(request.getTypeOfDocument().equals(DocumentType.PASSPORT)) {
            		countPassport++;
            	}else {
            		countForeigner++;
            	}
            }
		}
		float citizenship=calculatePorcentage(countCitizenship);
		float passport=calculatePorcentage(countPassport);
		float foreigner=calculatePorcentage(countForeigner);
		float[]listDocument= {citizenship,passport,foreigner};
		return listDocument;
	}
	
	public float calculatePorcentage(int count) {
		int totalPersons=arrayRequest.size();
		return (count*100)/totalPersons;
	}
	
	public float[] calculateNumberForMonth() {
		int countApril=0,countMay=0,countJune=0,i=0,month;
		for (Request request : arrayRequest) {
			if (request != null) {
				month=(arrayRequest.get(i).getDate().getMonthValue());
				if(month==4) {
					countApril++;
				}else if(month==5) {
					countMay++;
				}else {
					countJune++;
				}
			i++;
            }
		}
		float april=calculatePorcentage(countApril);
		float may=calculatePorcentage(countMay);
		float june=calculatePorcentage(countJune);
		float[]listMonths= {april,may,june};
		return listMonths; 
	}
	
	public double getToTotalValueOfConsign() {
		double totalValueOfConsign=0;
		for (Request request : arrayRequest) {
			totalValueOfConsign+= request.getValueConsignment();
		}
		return totalValueOfConsign;
	}
	
	public ArrayList<Request> getArrayRequest() {
		return arrayRequest;
	}
	
	public void setArrayRequest(ArrayList<Request> arrayRequest) {
		this.arrayRequest = arrayRequest;
	}
	
}
