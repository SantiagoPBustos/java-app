package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.Request;
import views.body.JPTableElements;
import views.footer.JPTotalValueOfConsign;
import views.header.JPContainerHeaderPanel;

public class JPMainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPContainerHeaderPanel jpContainerHeader;
	JPTableElements jpContainerBody;
	JPTotalValueOfConsign jpTotalValueOfConsign;
	
	public JPMainPanel( ActionListener actionListener ) {
		this.setLayout(new BorderLayout());
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		jpContainerHeader=new JPContainerHeaderPanel(actionListener);
		this.add(jpContainerHeader,BorderLayout.NORTH);
		
		jpContainerBody=new JPTableElements();
		this.add(jpContainerBody,BorderLayout.CENTER);
		
		jpTotalValueOfConsign=new JPTotalValueOfConsign();
		this.add(jpTotalValueOfConsign,BorderLayout.SOUTH);
	}
	
	public void addAllElementToTable(ArrayList<Request> arrayRequest) {
		jpContainerBody.addAllElementToTable( arrayRequest );
	}
	
	public void addElementToTable(Object[] vectorElement) {
		jpContainerBody.addElementToTable( vectorElement );
	}
	
	public String[]  getElementToTable(int numberRequest) {
		return jpContainerBody.getElementToTable(numberRequest-1);
	}
	
	public int getRowSelectedAndDelete() {
		return jpContainerBody.getRowSelectedAndDelete();
	}
	
	public int getRowSelected() {
		return jpContainerBody.getRowSelected();
	}

	public void updateValueOfConsign(double totalValueOfConsign) {
		jpTotalValueOfConsign.updateValueOfConsign(totalValueOfConsign);
	}
	
	public void manageChangeLenguage() {
		jpContainerHeader.manageChangeLenguage();
		jpContainerBody.manageChangeLenguage();
		jpTotalValueOfConsign.manageChangeLenguage();
	}
	
}
