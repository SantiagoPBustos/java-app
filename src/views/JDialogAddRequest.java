package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;

import com.toedter.calendar.JDateChooser;

import controllers.Commands;
import models.DocumentType;
import models.NumberRequest;
import models.PersonType;
import models.Request;
import persistence.LanguageController;
import utilities.Utilities;

public class JDialogAddRequest extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jpContainerDialog;
	private JComboBox<NumberRequest> jcbNumberRequest;
	private JComboBox<PersonType> jcbPersonType;
	private JTextField jtfNameBussines;
	private JComboBox<DocumentType> jcbDocumentType;
	private JTextField jtfNameId;
	private JSpinner jspNumberEmployees;
	private JDateChooser jdcDateOfRequest;
	private JMButtonRounded jmButtonCreate, jmButtonCancel;
	
	public JDialogAddRequest(ActionListener actionListener, JFMainWindow jfMainWindow) {
		setModal(true);
		this.setTitle(LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_NEW_REQUEST));
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsUI.PATH_ADD_ICON)).getImage());
		this.setSize(450, 600);
		this.setMinimumSize(new Dimension(450, 550));
		this.setLocationRelativeTo(jfMainWindow);
		dialogAdd(actionListener);
	}
	
	public JDialogAddRequest(ActionListener actionListener, JFMainWindow jfMainWindow,String pathImage) {
		setModal(true);
		this.setTitle(LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EDIT_REQUEST));
		this.setIconImage(new ImageIcon(getClass().getResource(pathImage)).getImage());
		this.setSize(450, 600);
		this.setMinimumSize(new Dimension(450, 550));
		this.setLocationRelativeTo(jfMainWindow);
		dialogEdit(actionListener);
	}
	
	public void dialogAdd(ActionListener actionListener) {
		jpContainerDialog=new JPanel();
		jpContainerDialog.setBackground(Color.WHITE);
		jpContainerDialog.setLayout(new GridLayout(9, 1, 0, 9));
		jpContainerDialog.setBorder(new EmptyBorder(25, 25, 40, 25));
		
		jcbNumberRequest=new JComboBox<>(NumberRequest.values());
		jcbNumberRequest.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_OF_REQUEST)));
		jcbNumberRequest.setBackground(Color.WHITE);
		jpContainerDialog.add(jcbNumberRequest);
		
		jcbPersonType=new JComboBox<>(PersonType.values());
		jcbPersonType.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_TYPE_OF_PERSON)));
		jcbPersonType.setBackground(Color.WHITE);
		jpContainerDialog.add(jcbPersonType);
		
		jtfNameBussines=new JTextField();
		jtfNameBussines.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NAME_BUSSINES)));
		jpContainerDialog.add(jtfNameBussines);
		
		jcbDocumentType=new JComboBox<>(DocumentType.values());
		jcbDocumentType.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_TYPE_OF_DOCUMENT)));
		jcbDocumentType.setBackground(Color.WHITE);
		jpContainerDialog.add(jcbDocumentType);
		
		jtfNameId=new JTextField();
		jtfNameId.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_ID)));
		jpContainerDialog.add(jtfNameId);
		
		jspNumberEmployees=new JSpinner(new SpinnerNumberModel(3, 3, Integer.MAX_VALUE, 1));
		((DefaultFormatter) ((JSpinner.NumberEditor)jspNumberEmployees.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
		jspNumberEmployees.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_EMPLOYEES)));
		jspNumberEmployees.setBackground(Color.WHITE);
		jpContainerDialog.add(jspNumberEmployees);
	
		jdcDateOfRequest = new JDateChooser();
		jdcDateOfRequest.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_DATE)));
		jdcDateOfRequest.setBackground(Color.WHITE);
		jpContainerDialog.add( jdcDateOfRequest );
		
		jmButtonCreate = new JMButtonRounded(15, 15, LanguageController.languageProperties.getProperty(ConstantsUI.T_ADD_REQUEST), 
				Color.decode("#337AB7"), Color.WHITE, ConstantsUI.FONT_COMPONENTS_DIALOG_COST, Commands.C_ADD_REQUEST.toString(), actionListener );
		jpContainerDialog.add(jmButtonCreate);
		
		jmButtonCancel = new JMButtonRounded(15, 15, LanguageController.languageProperties.getProperty(ConstantsUI.T_CANCEL_REQUEST),
				Color.decode("#922B3E"), Color.WHITE, ConstantsUI.FONT_COMPONENTS_DIALOG_COST, Commands.C_CANCEL_REQUEST.toString(), actionListener );
		jpContainerDialog.add(jmButtonCancel);
		
		this.add(jpContainerDialog);
	}
	
	public void dialogEdit(ActionListener actionListener) {
		jpContainerDialog=new JPanel();
		jpContainerDialog.setBackground(Color.WHITE);
		jpContainerDialog.setLayout(new GridLayout(9, 1, 0, 9));
		jpContainerDialog.setBorder(new EmptyBorder(25, 25, 40, 25));
		
		jcbNumberRequest=new JComboBox<>(NumberRequest.values());
		jcbNumberRequest.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_OF_REQUEST)));
		jcbNumberRequest.setBackground(Color.WHITE);
		jpContainerDialog.add(jcbNumberRequest);
		
		jcbPersonType=new JComboBox<>(PersonType.values());
		jcbPersonType.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_TYPE_OF_PERSON)));
		jcbPersonType.setBackground(Color.WHITE);
		jpContainerDialog.add(jcbPersonType);
		
		jtfNameBussines=new JTextField();
		jtfNameBussines.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NAME_BUSSINES)));
		jpContainerDialog.add(jtfNameBussines);
		
		jcbDocumentType=new JComboBox<>(DocumentType.values());
		jcbDocumentType.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_TYPE_OF_DOCUMENT)));
		jcbDocumentType.setBackground(Color.WHITE);
		jpContainerDialog.add(jcbDocumentType);
		
		jtfNameId=new JTextField();
		jtfNameId.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_ID)));
		jpContainerDialog.add(jtfNameId);
		
		jspNumberEmployees=new JSpinner(new SpinnerNumberModel(3, 3, Integer.MAX_VALUE, 1));
		((DefaultFormatter) ((JSpinner.NumberEditor)jspNumberEmployees.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
		jspNumberEmployees.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_EMPLOYEES)));
		jspNumberEmployees.setBackground(Color.WHITE);
		jpContainerDialog.add(jspNumberEmployees);
		
		jdcDateOfRequest = new JDateChooser();
		jdcDateOfRequest.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_DATE)));
		jdcDateOfRequest.setBackground(Color.WHITE);
		jpContainerDialog.add( jdcDateOfRequest );
		
		jmButtonCreate = new JMButtonRounded(15, 15, LanguageController.languageProperties.getProperty(ConstantsUI.T_SAVE_REQUEST), 
				Color.decode("#337AB7"), Color.WHITE, ConstantsUI.FONT_COMPONENTS_DIALOG_COST, Commands.C_SAVE_REQUEST_EDIT.toString(), actionListener );
		jpContainerDialog.add(jmButtonCreate);
		
		jmButtonCancel = new JMButtonRounded(15, 15, LanguageController.languageProperties.getProperty(ConstantsUI.T_CANCEL_REQUEST),
				Color.decode("#922B3E"), Color.WHITE, ConstantsUI.FONT_COMPONENTS_DIALOG_COST, Commands.C_CANCEL_REQUEST.toString(), actionListener );
		jpContainerDialog.add(jmButtonCancel);
		
		this.add(jpContainerDialog);
	}
	
	public void showDialog() {
		jtfNameBussines.setText("");
		jtfNameId.setText("");
	}
	
	public void showDialogEdit(String[] request) {
		jcbNumberRequest.setSelectedIndex(( NumberRequest.numberRequest( request[1])));

		jcbPersonType.setSelectedIndex( PersonType.numberPerson( request[2]));
		
		jtfNameBussines.setText(request[3]);
		
		jcbDocumentType.setSelectedIndex( DocumentType.numberDocument( request[4]));
		jcbDocumentType.setEnabled(false);
		
		jtfNameId.setText(request[5]);
		jtfNameId.setEnabled(false);
		
		jspNumberEmployees.setValue(Integer.parseInt( request[6]) );
		System.out.println();

		jdcDateOfRequest.setDate(Utilities.parseStringToDate(Utilities.parseFormatDate(request[7])));
	}
	
	public Request createRequest(int numberRegistered) {
		this.setVisible(false);
		return new Request(numberRegistered, (NumberRequest)jcbNumberRequest.getSelectedItem(), (PersonType)jcbPersonType.getSelectedItem(), jtfNameBussines.getText(),
				(DocumentType)jcbDocumentType.getSelectedItem(), Integer.parseInt(jtfNameId.getText()), (int)(jspNumberEmployees.getValue()), 
				Utilities.parseDateToLocalDate(jdcDateOfRequest.getDate()));
	}
	
	public void manageChangeLenguage() {
		this.setTitle(LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_NEW_REQUEST));
		this.setTitle(LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EDIT_REQUEST));
		jcbNumberRequest.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_OF_REQUEST)));
		jcbPersonType.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_TYPE_OF_PERSON)));
		jtfNameBussines.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NAME_BUSSINES)));
		jcbDocumentType.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_TYPE_OF_DOCUMENT)));
		jtfNameId.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_ID)));
		jspNumberEmployees.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_EMPLOYEES)));
		jdcDateOfRequest.setBorder(BorderFactory.createTitledBorder(LanguageController.languageProperties.getProperty(ConstantsUI.T_DATE)));
		jmButtonCreate.setText(LanguageController.languageProperties.getProperty(ConstantsUI.T_SAVE_REQUEST));
		jmButtonCancel.setText(LanguageController.languageProperties.getProperty(ConstantsUI.T_CANCEL_REQUEST));
	}
}
