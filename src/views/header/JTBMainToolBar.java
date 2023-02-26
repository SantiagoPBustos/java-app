package views.header;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import controllers.Commands;
import persistence.LanguageController;
import views.ConstantsUI;

public class JTBMainToolBar extends JToolBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton jbAddRequest, jbEditRequest, jbDeleteRequest, jbReloadRequest,jbSaveRequests,jbItaly, jbSpanish, jbEnglish;
	
	public JTBMainToolBar(ActionListener actionListener) {
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.setBackground(ConstantsUI.COLOR_CYAN);
		this.setFloatable(false);
		setUIManager();
		initComponents(actionListener);
	}
	private void setUIManager() {
		UIManager.put("Button.background", ConstantsUI.COLOR_TBAR_BACKGROUND);
	}
	private void initComponents(ActionListener actionListener) {
		jbAddRequest=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_ADD_ICON)));
		jbAddRequest.setOpaque(false);
		jbAddRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_ADD_REQUEST) );
		jbAddRequest.setBorderPainted(false);
		jbAddRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbAddRequest.addActionListener(actionListener);
		jbAddRequest.setActionCommand(Commands.C_SHOW_REQUEST.toString());
		jbAddRequest.setFocusable(false);
		this.add(jbAddRequest);
		
		jbEditRequest=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_EDIT_ICON)));
		jbEditRequest.setOpaque(false);
		jbEditRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EDIT_REQUEST) );
		jbEditRequest.setBorderPainted(false);
		jbEditRequest.setFocusable(false);
		jbEditRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbEditRequest.addActionListener(actionListener);
		jbEditRequest.setActionCommand(Commands.C_EDIT_REQUEST.toString());
		this.add(jbEditRequest);
		
		jbDeleteRequest=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_DELETE_ICON)));
		jbDeleteRequest.setOpaque(false);
		jbDeleteRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_DELETE_REQUEST) );
		jbDeleteRequest.setBorderPainted(false);
		jbDeleteRequest.setFocusable(false);
		jbDeleteRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbDeleteRequest.addActionListener(actionListener);
		jbDeleteRequest.setActionCommand(Commands.C_DELETE_REQUEST.toString());
		this.add(jbDeleteRequest);
		
		jbReloadRequest=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_RELOAD_ICON)));
		jbReloadRequest.setOpaque(false);
		jbReloadRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_RELOAD_REQUEST) );
		jbReloadRequest.setBorderPainted(false);
		jbReloadRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbReloadRequest.addActionListener(actionListener);
		jbReloadRequest.setActionCommand(Commands.C_RELOAD_REQUESTS.toString());
		jbReloadRequest.setFocusable(false);
		this.add(jbReloadRequest);
		
		jbSaveRequests=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_SAVE_ICON)));
		jbSaveRequests.setOpaque(false);
		jbSaveRequests.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_SAVE_REQUEST) );
		jbSaveRequests.setBorderPainted(false);
		jbSaveRequests.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbSaveRequests.addActionListener(actionListener);
		jbSaveRequests.setActionCommand(Commands.C_SAVE_REQUESTS.toString());
		jbSaveRequests.setFocusable(false);
		this.add(jbSaveRequests);
		
		this.add(Box.createHorizontalGlue());
		
		jbItaly=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_ITALY_ICON)));
		jbItaly.setOpaque(false);
		jbItaly.setBorderPainted(false);
		jbItaly.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbItaly.addActionListener(actionListener);
		jbItaly.setActionCommand(Commands.C_LENGUAGE_IT.toString()); 
		jbItaly.setFocusable(false);
		this.add(jbItaly);
		
		this.add(Box.createRigidArea(new Dimension(10,0)));
		
		jbSpanish=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_SPANISH_ICON)));
		jbSpanish.setOpaque(false);
		jbSpanish.setBorderPainted(false);
		jbSpanish.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbSpanish.addActionListener(actionListener);
		jbSpanish.setActionCommand(Commands.C_LENGUAGE_ES.toString()); 
		jbSpanish.setFocusable(false);
		this.add(jbSpanish);
		
		this.add(Box.createRigidArea(new Dimension(10,0)));
		
		jbEnglish=new JButton(new ImageIcon(getClass().getResource(ConstantsUI.PATH_ENGLISH_ICON)));
		jbEnglish.setOpaque(false);
		jbEnglish.setBorderPainted(false);
		jbEnglish.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbEnglish.addActionListener(actionListener);
		jbEnglish.setActionCommand(Commands.C_LENGUAGE_US.toString()); 
		jbEnglish.setFocusable(false);
		this.add(jbEnglish);
		
		this.add(Box.createRigidArea(new Dimension(10,0)));
	}
	public void manageChangeLenguage() {
		jbAddRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_ADD_REQUEST) );
		jbEditRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_EDIT_REQUEST) );
		jbDeleteRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_DELETE_REQUEST) );
		jbReloadRequest.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_RELOAD_REQUEST) );
		jbSaveRequests.setToolTipText( LanguageController.languageProperties.getProperty(ConstantsUI.T_MENU_ITEM_SAVE_REQUEST) );
	}
}
