package views.header;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import controllers.Commands;
import persistence.LanguageController;
import views.ConstantsUI;

public class JMBMainMenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenu jMenuFile, jMenuData;
	JMenuItem jMIAddRequest, jMIEditRequest, jMIDeleteRequest, jMICalculateDepositedValue , jMIExit, 
			  jMIPercentageRequest, jMIPercentagePerson, jMIPercentageDocument, jMIRequestForMonth;
	
	public JMBMainMenuBar(ActionListener actionListener) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(Color.BLACK);
		setUIManager();
		initComponents(actionListener);
	}

	
	private void setUIManager() {
		UIManager.put("Menu.font", ConstantsUI.FONT_MAIN_WINDOW_LABELS);
		UIManager.put("MenuItem.font", ConstantsUI.FONT_MAIN_WINDOW_LABELS);
		UIManager.put("Menu.background", ConstantsUI.COLOR_ORANGE);
	}


	private void initComponents(ActionListener actionListener) {
		jMenuFile=new JMenu( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_FILE) );
		jMenuFile.setForeground(Color.WHITE);
		jMenuFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jMIAddRequest=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_ADD_REQUEST) );
		jMIAddRequest.addActionListener(actionListener);
		jMIAddRequest.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		jMIAddRequest.setActionCommand(Commands.C_SHOW_REQUEST.toString());
		jMIAddRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMenuFile.add(jMIAddRequest);
		
		jMIEditRequest=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EDIT_REQUEST) );
		jMIEditRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMIEditRequest.addActionListener(actionListener);
		jMIEditRequest.setActionCommand(Commands.C_EDIT_REQUEST.toString());
		jMenuFile.add(jMIEditRequest);
		
		jMIDeleteRequest=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_DELETE_REQUEST) );
		jMIDeleteRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMIDeleteRequest.addActionListener(actionListener);
		jMIDeleteRequest.setActionCommand(Commands.C_DELETE_REQUEST.toString());
		jMenuFile.add(jMIDeleteRequest);
		
		jMICalculateDepositedValue=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_CALCULATE_VALUE_DEPOSITED) );
		jMICalculateDepositedValue.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMICalculateDepositedValue.addActionListener(actionListener);
		jMICalculateDepositedValue.setActionCommand(Commands.C_CALCULATE_VALUE_OF_CONSIGN.toString());
		jMenuFile.add(jMICalculateDepositedValue);
		
		jMIExit=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EXIT) );
		jMIExit.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jMIExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMIExit.addActionListener(actionListener);
		jMIExit.setActionCommand(Commands.C_EXIT_APP.toString());
		jMenuFile.add(jMIExit);
		
		this.add(jMenuFile);
		
		jMenuData=new JMenu( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_DATA) );
		jMenuData.setForeground(Color.WHITE);
		jMenuData.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jMIPercentageRequest=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_TYPE_REQUEST) );
		jMIPercentageRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMIPercentageRequest.addActionListener(actionListener);
		jMIPercentageRequest.setActionCommand(Commands.C_SHOW_PERCENTAJE_REQUEST.toString());
		jMenuData.add(jMIPercentageRequest);
		
		jMIPercentagePerson=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_TYPE_PERSON) );
		jMIPercentagePerson.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMIPercentagePerson.addActionListener(actionListener);
		jMIPercentagePerson.setActionCommand(Commands.C_SHOW_PERCENTAJE_PERSON.toString());
		jMenuData.add(jMIPercentagePerson);
		
		jMIPercentageDocument=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_TYPE_DOCUMENT) );
		jMIPercentageDocument.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMIPercentageDocument.addActionListener(actionListener);
		jMIPercentageDocument.setActionCommand(Commands.C_SHOW_PERCENTAJE_DOCUMENT.toString());
		jMenuData.add(jMIPercentageDocument);
		
		jMIRequestForMonth=new JMenuItem( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_NUMBER_REQUEST_FOR_MONTH));
		jMIRequestForMonth.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jMIRequestForMonth.addActionListener(actionListener);
		jMIRequestForMonth.setActionCommand(Commands.C_SHOW_NUMBER_REQUEST_FOR_MONTH.toString());
		jMenuData.add(jMIRequestForMonth);
		
		this.add(jMenuData);
	}
	
	public void manageChangeLenguage() {
		jMenuFile.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_FILE) );
		jMIAddRequest.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_ADD_REQUEST) );
		jMIEditRequest.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EDIT_REQUEST) );
		jMIDeleteRequest.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_DELETE_REQUEST) );
		jMICalculateDepositedValue.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_CALCULATE_VALUE_DEPOSITED) );
		jMIExit.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EXIT) );
		
		jMenuData.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_DATA) );
		jMIPercentageRequest.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_TYPE_REQUEST) );
		jMIPercentagePerson.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_TYPE_PERSON) );
		jMIPercentageDocument.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_TYPE_DOCUMENT) );
		jMIRequestForMonth.setText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_NUMBER_REQUEST_FOR_MONTH));
	}
}