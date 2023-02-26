package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.Request;
import persistence.LanguageController;

public class JFMainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPMainPanel jpMainPanel;
	private JDialogAddRequest jdAddRequest,jdEditRequest;
	private MDJDialogData jdTypeRequest,jdTypePerson,jdTypeDocument,jdNumberForMonth;
	
	public JFMainWindow( ActionListener controller ) {
		this.setTitle(LanguageController.languageProperties.getProperty(ConstantsUI.T_MAIN_WINDOW));
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(1280, 900));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsUI.PATH_MAIN_ICON)).getImage());
		this.setLocationRelativeTo(null);
		this.jdAddRequest=new JDialogAddRequest(controller, this);
		this.jdEditRequest=new JDialogAddRequest(controller, this,ConstantsUI.PATH_EDIT_ICON);
		initDialogs();
		initComponents(controller);
	}
	private void initComponents( ActionListener actionListener ) {
		jpMainPanel=new JPMainPanel( actionListener );
		this.add(jpMainPanel);
	}
	
	public void showDialogRequest() {
		jdAddRequest.showDialog();
		jdAddRequest.setVisible(true);
	}
	
	public void showDialogEditRequest(int numberRequest) {
		jdEditRequest.showDialogEdit(getElementToTable(numberRequest));
		jdEditRequest.setVisible(true);
	}
	
	public String[]  getElementToTable(int numberRequest) {
		return jpMainPanel.getElementToTable(numberRequest);
	}
	
	public void makeInvisibleDialogAddRequest( ) {
		jdAddRequest.setVisible( false );
	}
	
	public void makeInvisibleDialogEditRequest( ) {
		jdEditRequest.setVisible( false );
	}
	
	public Request createRequest(int numberRegistered) {
		return jdAddRequest.createRequest(numberRegistered);
	}
	public Request editRequest(int numberRegistered) {
		return jdEditRequest.createRequest(numberRegistered);
	}
	
	public void addAllElementToTable(ArrayList<Request> arrayRequest) {
		jpMainPanel.addAllElementToTable( arrayRequest );
	}
	
	public void addElementToTable(Object[] vectorElement) {
		jpMainPanel.addElementToTable( vectorElement );
	}
	
	public int getRowSelectedAndDelete() {
		return jpMainPanel.getRowSelectedAndDelete();
	}
	
	public int getRowSelected() {
		return jpMainPanel.getRowSelected();
	}
	
	public void updateValueOfConsign(double totalValueOfConsign) {
		jpMainPanel.updateValueOfConsign(totalValueOfConsign);
	}

	private void initDialogs() {
		this.jdTypeRequest=new MDJDialogData(LanguageController.languageProperties.getProperty(ConstantsUI.T_MAIN_PERCENTAJE_REQUEST), this, 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_REQUEST), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_FIRTS_TIME), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_SECOND_TIME), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_THIRD_TIME));
		
		this.jdTypePerson=new MDJDialogData(LanguageController.languageProperties.getProperty(ConstantsUI.T_MAIN_PERCENTAJE_PERSON), this, 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_PERSON), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_LEGAL_PERSON), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_NATURAL_PERSON), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_ENTITY),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_TEMPORAL_UNION));
		
		this.jdTypeDocument=new MDJDialogData(LanguageController.languageProperties.getProperty(ConstantsUI.T_MAIN_PERCENTAJE_DOCUMENT), this, 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_DOCUMENT), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_CITIZENSHIP), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_PASSPORT), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_FOREIGNERS));
		
		this.jdNumberForMonth=new MDJDialogData(LanguageController.languageProperties.getProperty(ConstantsUI.T_MAIN_NUMBER_FOR_MONTH), this, 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_NUMBER_FOR_MONTH), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_APRIL), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_MAY), 
				LanguageController.languageProperties.getProperty(ConstantsUI.T_JUNE));
	}
	
	public void showDialogPercentajeRequest(float[] vectorPercentajeRequest) {
		jdTypeRequest.jpbFirstValue.setValue((int) vectorPercentajeRequest[0]);
		jdTypeRequest.jpbSecondValue.setValue((int) vectorPercentajeRequest[1]);
		jdTypeRequest.jpbThirdValue.setValue((int) vectorPercentajeRequest[2]);
		jdTypeRequest.setVisible(true);
	}
	
	public void showDialogPercentajePerson(float[] vectorPercentajePerson) {
		jdTypePerson.jpbFirstValue.setValue((int) vectorPercentajePerson[0]);
		jdTypePerson.jpbSecondValue.setValue((int) vectorPercentajePerson[1]);
		jdTypePerson.jpbThirdValue.setValue((int) vectorPercentajePerson[2]);
		jdTypePerson.jpbFourValue.setValue((int) vectorPercentajePerson[3]);
		jdTypePerson.setVisible(true);
	}
	
	public void showDialogPercentajeDocument(float[] vectorPercentajeDocument) {
		jdTypeDocument.jpbFirstValue.setValue((int) vectorPercentajeDocument[0]);
		jdTypeDocument.jpbSecondValue.setValue((int) vectorPercentajeDocument[1]);
		jdTypeDocument.jpbThirdValue.setValue((int) vectorPercentajeDocument[2]);
		jdTypeDocument.setVisible(true);
	}
	
	public void showDialogNumberForMonth(float[] vectorNumberForMonth) {
		jdNumberForMonth.jpbFirstValue.setValue((int) vectorNumberForMonth[0]);
		jdNumberForMonth.jpbSecondValue.setValue((int) vectorNumberForMonth[1]);
		jdNumberForMonth.jpbThirdValue.setValue((int) vectorNumberForMonth[2]);
		jdNumberForMonth.setVisible(true);
	}
	
	public void manageChangeLenguage() {
		this.setTitle(LanguageController.languageProperties.getProperty(ConstantsUI.T_MAIN_WINDOW));
		this.initDialogs();
		this.jdAddRequest.manageChangeLenguage();
		this.jdEditRequest.manageChangeLenguage();
		this.jpMainPanel.manageChangeLenguage();
	}
}
