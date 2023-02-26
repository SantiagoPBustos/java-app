package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.ManagerRequest;
import models.Request;
import persistence.FileTextManager;
import persistence.LanguageController;
import utilities.Utilities;
import views.ConstantsUI;
import views.JFMainWindow;

public class Controller implements ActionListener{
	
	private JFMainWindow jfMainWindow;
	private ManagerRequest managerRequest;
	private LanguageController config;
	private FileTextManager fileTextManager;
	private int idEditRequest;
	
	public static final String PATH_SPANISH= "Resources/languages/languageES.properties";
	public static final String PATH_ENGLISH= "resources/languages/languageUS.properties";
	public static final String PATH_ITALIAN= "resources/languages/languageIT.properties";
	public static final String PATH_CONFIG="resources/config/config.init";
	
	public static final String PATH_FILE_REQUESTS= "resources/file_requests/requests.txt";
	public static final String PATH_FILE_NAMES= "resources/file_requests/empresas.txt";

	public Controller() {
		loadConfiguration();
		fileTextManager=new FileTextManager();
		managerRequest=new ManagerRequest();
		jfMainWindow=new JFMainWindow(this);
		loadRequests();
		jfMainWindow.setVisible(true);
	}	
	
	public void actionPerformed(ActionEvent e) {
		try {
			switch (Commands.valueOf(e.getActionCommand())) {
				case C_ADD_REQUEST:
					this.addRequest();
					break;
				case C_SHOW_REQUEST:
					this.showDialogRequest();
					break;
				case C_CANCEL_REQUEST:
					this.jfMainWindow.makeInvisibleDialogAddRequest();
					this.jfMainWindow.makeInvisibleDialogEditRequest();
					break;
				case C_EDIT_REQUEST:	
					this.showEditRequest(this.getIndexToEdit());
					break;
				case C_SAVE_REQUEST_EDIT:	
					managerRequest.addEditRequest(this.editRequest()); 
					this.showRequest();
					break;
				case C_DELETE_REQUEST:
					this.validateDeleteRequest(managerRequest.deleteRequest(this.deleteRequest()));
					this.showRequest();
					break;
				case C_RELOAD_REQUESTS:
					this.showRequest();
					break;
				case C_SAVE_REQUESTS:
					this.saveRequests();
					break;
				case C_CALCULATE_VALUE_OF_CONSIGN:
					this.managerRequest.calculateValueOfConsign();
					this.showRequest();
					break;
				case C_SHOW_PERCENTAJE_REQUEST:
					this.jfMainWindow.showDialogPercentajeRequest(managerRequest.percentajeTypeRequest());
					break;
				case C_SHOW_PERCENTAJE_PERSON:
					this.jfMainWindow.showDialogPercentajePerson(managerRequest.percentajeTypePerson());
					break;
				case C_SHOW_PERCENTAJE_DOCUMENT:
					this.jfMainWindow.showDialogPercentajeDocument(managerRequest.percentajeTypeDocument());
					break;
				case C_SHOW_NUMBER_REQUEST_FOR_MONTH:
					this.jfMainWindow.showDialogNumberForMonth(managerRequest.calculateNumberForMonth());
					break;
				case C_LENGUAGE_ES:
					this.manageChangeLenguageES();
					break;
				case C_LENGUAGE_US:
					this.manageChangeLenguageUS();
					break;
				case C_LENGUAGE_IT:
					this.manageChangeLenguageIT();
					break;
				case C_EXIT_APP:
					this.manageExitApp();
					break;
				default:
					break;
			}
		}catch (Exception e2) {
			this.showException();
		}
	}	
	
	//Cargar Registros desde archivo
	private void loadRequests() {
		try {
			ArrayList<String> arrayRequests=fileTextManager.readFile(PATH_FILE_REQUESTS);
			this.tokenizeLinesManager( arrayRequests );
			this.showRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}
	//Generar Solicitudes 
//	private void generateRequest() {
//		try {
//			ArrayList<String> listBusiness=fileTextManager.readFile(PATH_FILE_NAMES);
//			String[] list=listBusiness.toArray(new String[listBusiness.size()]);
//			for (int i = 0; i < list.length; i++) {
//				managerRequest.addRequest(Utilities.generateRequest(managerRequest.getArrayRequest().size()+1, managerRequest.getArrayRequest(), 
//						list,i));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	private void tokenizeLinesManager( ArrayList<String> arrayList) {
		for (String request : arrayList) {
			String [] aux=Utilities.splitLine(request);
			if( aux.length == 7 ) {
				managerRequest.addRequest(new Request(managerRequest.getArrayRequest().size()+1, 
						Utilities.getNumberRequest(aux[0]), Utilities.getTypePerson(aux[1]), 
						aux[2], Utilities.getTypeDocument(aux[3]),Integer.parseInt(aux[4]),Integer.parseInt(aux[5]), 
						Utilities.parseStringToLocalDate(aux[6])));
			}
		}
	}
	
	//Guardar Registros en el archivo
	private void saveRequests() {
		ArrayList<String> arrayListRequests=new ArrayList<String>();
		ArrayList<Request> arrayRequest=managerRequest.getArrayRequest();
		for (Request request : arrayRequest) {
			arrayListRequests.add(Utilities.getLineRequest(request));
		}
		fileTextManager.writeFile(PATH_FILE_REQUESTS, arrayListRequests);
	}

	//Añadir Registro
	private void addRequest() {
		try {
			Request request=jfMainWindow.createRequest(managerRequest.getArrayRequest().get(managerRequest.getArrayRequest().size()-1).getNumberRegistered()+1);
			boolean option=managerRequest.addRequest(request);
			if(option==true) {
				jfMainWindow.addElementToTable( request.toObjectVector() );
				jfMainWindow.updateValueOfConsign( managerRequest.getToTotalValueOfConsign());
			}else {
				JOptionPane.showMessageDialog(null,LanguageController.languageProperties.getProperty(ConstantsUI.T_USER_INVALID) + request.getIdNumber()
				+" "+LanguageController.languageProperties.getProperty(ConstantsUI.T_USER_INVALID_REQUEST), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_REQUEST), JOptionPane.ERROR_MESSAGE);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_DATA) , 
					LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_REQUEST), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void showDialogRequest() {
		jfMainWindow.showDialogRequest();
	}
	
	//Mostrar Registros
	private void showRequest() {
		jfMainWindow.addAllElementToTable(managerRequest.getArrayRequest());
		jfMainWindow.updateValueOfConsign( managerRequest.getToTotalValueOfConsign());
	}
	
	//Editar Registro
	private void showEditRequest(int numberRequest) {
		jfMainWindow.showDialogEditRequest(numberRequest);
	}
	
	private int getIndexToEdit() {
		int idRequest=-1;
		try {
			idRequest=jfMainWindow.getRowSelected();
		}catch(Exception e){
			idRequest=Integer.parseInt(JOptionPane.showInputDialog(null,LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_ID_REQUEST) ,
					LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_EDIT_REQUEST) , JOptionPane.DEFAULT_OPTION));
		}
		idEditRequest=idRequest;
		return idRequest;
	}
	
	private Request editRequest() {
		Request request=null;
		try {
			request=jfMainWindow.editRequest(idEditRequest);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_DATA) , 
					LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_REQUEST), JOptionPane.ERROR_MESSAGE);
		}
		return request;
	}

	//Borrar Registro
	private int deleteRequest() {
		int idRequest=-1;
		try {
			idRequest=jfMainWindow.getRowSelectedAndDelete();
		} catch (Exception e) {
			idRequest=Integer.parseInt(JOptionPane.showInputDialog(null,LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_ID_REQUEST) ,
					LanguageController.languageProperties.getProperty(ConstantsUI.T_INVALID_DELETE_REQUEST) , JOptionPane.DEFAULT_OPTION));
		}
		return idRequest;
	}
	
	private void validateDeleteRequest(boolean option) {
		if(option==false) {
			JOptionPane.showMessageDialog(null, LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_INVALID_REQUEST),
					LanguageController.languageProperties.getProperty(ConstantsUI.T_ERROR), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Cargar idioma que se especifica
	public void loadConfiguration() {
		if (config==null) {
			config=new LanguageController(PATH_CONFIG);
		}
		try {
			config.loadLenguage();
		}catch(Exception e){
			JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
		}
	}
	
	//Manager para cambiar a Español
	public void manageChangeLenguageES() {
		try {
			changeToSpanish();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(jfMainWindow, e1.getMessage());
		}
		manageChangeLenguage();
	}
	
	public void changeToSpanish() throws IOException{
		LanguageController.language = PATH_SPANISH;
		saveConfiguration();
		loadConfiguration();
	}
	
	//Manager para cambiar a Ingles
	public void manageChangeLenguageUS() {
		try {
			changeToEnglish();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(jfMainWindow, e1.getMessage());
		}
		manageChangeLenguage();
	}
		
	public void changeToEnglish() throws IOException{
		LanguageController.language = PATH_ENGLISH;			
		saveConfiguration();
		loadConfiguration();
	}	
	
	//Manager para cambiar a Italiano
	public void manageChangeLenguageIT() {
		try {
			changeToItalian();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(jfMainWindow, e1.getMessage());
		}
		manageChangeLenguage();
	}
			
	public void changeToItalian() throws IOException{
		LanguageController.language = PATH_ITALIAN;
		saveConfiguration();
		loadConfiguration();
	}	
	
	//Actualizar idioma
	public void manageChangeLenguage() {
		jfMainWindow.manageChangeLenguage();
	}
	
	//Guardar lenguaje
	public void saveConfiguration() {
		try {
			new LanguageController(PATH_CONFIG).saveLanguage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
		}
	}
	
	public void showException() {
		JOptionPane.showMessageDialog(null, LanguageController.languageProperties.getProperty(ConstantsUI.T_ERROR),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_ERROR), JOptionPane.ERROR_MESSAGE);
	}
	
	
	private void manageExitApp() {
		int option = JOptionPane.showConfirmDialog(null, LanguageController.languageProperties.getProperty(ConstantsUI.MESSAGE_EXIT_APP), LanguageController.languageProperties.getProperty(ConstantsUI.T_EXIT), 
				JOptionPane.NO_OPTION);
		if ( option == 0 ) {
			this.saveRequests();
			System.exit( 0 );
		}
	}
}
