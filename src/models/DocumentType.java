package models;

public enum DocumentType{
	CITIZENSHIP_ID("Cedula de Ciudadania"), 
	PASSPORT("Pasaporte"), 
	FOREIGNER_ID("Cedula de Extranjeria");
	
	private String label;
	
	DocumentType( String label ){
		this.label = label;		
	}
	public String getLabel(){
		return label;
	}
	public static int numberDocument(String label) {
		if(label.equals("Cedula de Ciudadania")) {
			return 0;
		}else if(label.equals("Pasaporte")) {
			return 1;
		}else {
			return 2;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getLabel();
	}
}