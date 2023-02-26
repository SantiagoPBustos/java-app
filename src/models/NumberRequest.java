package models;

public enum NumberRequest {
	FIRST("Primera Vez"), 
	SECOND("Segunda Vez"), 
	THIRD("Tercera Vez");
	
	private String label;
	
	NumberRequest( String label ){
		this.label = label;		
	}
	public String getLabel(){
		return label;
	}
	public static int numberRequest(String label) {
		if(label.equals("Primera Vez")) {
			return 0;
		}else if(label.equals("Segunda Vez")) {
			return 1;
		}else {
			return 2;
		}
	}
	@Override
	public String toString() {
		return getLabel();
	}
}
