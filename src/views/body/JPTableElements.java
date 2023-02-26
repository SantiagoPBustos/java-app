package views.body;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import models.Request;
import persistence.LanguageController;
import views.ConstantsUI;

public class JPTableElements extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel dtmElementsTable;
	private JTable jtRequest;
	private JScrollPane jScrollPaneRequest;
	
	public DefaultTableModel getDtmElementsTable() {
		return dtmElementsTable;
	}
	public void setDtmElementsTable(DefaultTableModel dtmElementsTable) {
		this.dtmElementsTable = dtmElementsTable;
	}
	
	public JPTableElements() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
	}

	private void initComponents() {
		dtmElementsTable= new DefaultTableModel();
		dtmElementsTable.setColumnIdentifiers(this.asignHeadersTable());
		
		jtRequest=new JTable();
		jtRequest.setModel(dtmElementsTable);
		jtRequest.getTableHeader().setReorderingAllowed(false);
		jtRequest.getTableHeader().setBackground(ConstantsUI.COLOR_HEADER_TABLE);
		jtRequest.getTableHeader().setPreferredSize(new Dimension(0,40));
		jtRequest.getTableHeader().setForeground(Color.WHITE);
		jtRequest.getTableHeader().setFont(ConstantsUI.FONT_HEADERS_TABLE);
		jtRequest.setBackground(Color.WHITE);
		jtRequest.setFont(ConstantsUI.FONT_HEADERS_TABLE);
		jtRequest.setFillsViewportHeight(true);
		jtRequest.setRowHeight(35);
		
		asignWidthHeaders(0,90);
		asignWidthHeaders(1,95);
		asignWidthHeaders(2,170);
		asignWidthHeaders(4,170);
		asignWidthHeaders(5,130);
		asignWidthHeaders(6,120);
		asignWidthHeaders(7,100);
		asignWidthHeaders(8,200);
		centerTextInCell();
		
		jScrollPaneRequest=new JScrollPane(jtRequest);
		jScrollPaneRequest.setForeground(Color.WHITE);
		jScrollPaneRequest.setBorder(null);
		jScrollPaneRequest.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jScrollPaneRequest,BorderLayout.PAGE_END);
	}
	
	public void addAllElementToTable(ArrayList<Request> arrayRequests){
		cleanRowsTable();
		for (Request request : arrayRequests) {
			addElementToTable(request.toObjectVector());
		}
	}
	
	public void addElementToTable(Object[] vector){
		dtmElementsTable.addRow(vector);
	}
	
	public String[] getElementToTable(int row) {
		String[] request= {String.valueOf(dtmElementsTable.getValueAt(row, 0)),
					(String)(dtmElementsTable.getValueAt(row, 1)),
					(String) (dtmElementsTable.getValueAt(row, 2)), 
					(String) (dtmElementsTable.getValueAt(row, 3)),
					(String) (dtmElementsTable.getValueAt(row, 4)),	
					String.valueOf (dtmElementsTable.getValueAt(row, 5)), 
					String.valueOf (dtmElementsTable.getValueAt(row, 6)),
					String.valueOf (dtmElementsTable.getValueAt(row, 7))};
			return request;
	}

	public void cleanRowsTable() {
		dtmElementsTable.setNumRows(0);
	}
	
	public int getRowSelectedAndDelete() {
		int vectorRequest= (int) dtmElementsTable.getValueAt(jtRequest.getSelectedRow(), 0);
		dtmElementsTable.removeRow(jtRequest.getSelectedRow());
		return vectorRequest;
	}
	
	public int getRowSelected() {
		int vectorRequest= (int) dtmElementsTable.getValueAt(jtRequest.getSelectedRow(), 0);
		return vectorRequest;
	}
	
	private void asignWidthHeaders(int NumberHeader,int widthHeader) {
		TableColumn column;
		column=jtRequest.getColumnModel().getColumn(NumberHeader);
		column.setPreferredWidth(widthHeader);
		column.setMinWidth(widthHeader);
		column.setMaxWidth(widthHeader);
	}
	
	private void centerTextInCell() {
		DefaultTableCellRenderer centerModel = new DefaultTableCellRenderer(); 
		centerModel.setHorizontalAlignment(SwingConstants.CENTER); 
		for (int i = 0; i < dtmElementsTable.getColumnCount(); i++) {
			jtRequest.getColumnModel().getColumn(i).setCellRenderer(centerModel);  
		}
	}
	
	private String[] asignHeadersTable() {
		String[] headers = {
				LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_REGISTERED),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_REQUEST),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_PERSON),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_NAME_OR_COMPANY),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_PERCENTAJE_DOCUMENT),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_NUMBER_IDENTIFICATION),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_NUMBER_EMPLOYEES),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_HEADER_DATE),
				LanguageController.languageProperties.getProperty(ConstantsUI.T_VALUE_TO_CONSIGN)};
		return headers;
	}
	public void manageChangeLenguage() {
		dtmElementsTable.setColumnIdentifiers(this.asignHeadersTable());
		jtRequest.setModel(dtmElementsTable);
		jtRequest.getTableHeader().setReorderingAllowed(false);
		jtRequest.getTableHeader().setBackground(ConstantsUI.COLOR_HEADER_TABLE);
		jtRequest.getTableHeader().setPreferredSize(new Dimension(0,40));
		jtRequest.getTableHeader().setForeground(Color.WHITE);
		jtRequest.getTableHeader().setFont(ConstantsUI.FONT_HEADERS_TABLE);
		jtRequest.setBackground(Color.WHITE);
		jtRequest.setFont(ConstantsUI.FONT_HEADERS_TABLE);
		jtRequest.setFillsViewportHeight(true);
		jtRequest.setRowHeight(35);
		
		asignWidthHeaders(0,90);
		asignWidthHeaders(1,95);
		asignWidthHeaders(2,170);
		asignWidthHeaders(4,170);
		asignWidthHeaders(5,130);
		asignWidthHeaders(6,120);
		asignWidthHeaders(7,100);
		asignWidthHeaders(8,200);
		centerTextInCell();
		
		jScrollPaneRequest.setForeground(Color.WHITE);
		jScrollPaneRequest.setBorder(null);
		jScrollPaneRequest.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jScrollPaneRequest,BorderLayout.PAGE_END);
	}
}
