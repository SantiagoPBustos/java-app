package models;

public enum PersonType {
	LEGAL_PERSON("Persona jur�dica"),
	NATURAL_PERSON("Persona natural"),
	ENTITY("Entidad sin �nimo de lucro"),
	TEMPORAL_JOIN("Uni�n temporal");

	private String label;
	PersonType( String label ){
		this.label = label;		
	}
	public String getLabel(){
		return label;
	}
	public static int numberPerson(String label) {
		if(label.equals("Persona jur�dica")) {
			return 0;
		}else if(label.equals("Persona natural")) {
			return 1;
		}else if(label.equals("Entidad sin �nimo de lucro")){
			return 2;
		}else {
			return 3;
		}
	}
	@Override
	public String toString() {
		return getLabel();
	}
	
}
