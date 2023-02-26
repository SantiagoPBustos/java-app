package views.footer;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import persistence.LanguageController;
import utilities.Utilities;
import views.ConstantsUI;

public class JPTotalValueOfConsign extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel jltitleValueOfConsign, jlValueOfConsign;
	
	public JPTotalValueOfConsign() {
		this.setLayout(new GridLayout(1,2));
		this.setBorder(BorderFactory.createEmptyBorder(30,180, 30, 200));
		this.setBackground(ConstantsUI.COLOR_CYAN);
		initComponents();
	}

	private void initComponents() {
		jltitleValueOfConsign=new JLabel(LanguageController.languageProperties.getProperty(ConstantsUI.T_LABEL_TOTAL_VALUE_OF_CONSIGN));
		jltitleValueOfConsign.setFont(ConstantsUI.FONT_MAIN_WINDOW_LABELS);
		this.add(jltitleValueOfConsign);
		
		jlValueOfConsign=new JLabel("0");
		jlValueOfConsign.setHorizontalAlignment(SwingConstants.RIGHT);
		jlValueOfConsign.setFont(ConstantsUI.FONT_MAIN_WINDOW_LABELS);
		this.add(jlValueOfConsign);
	}
	
	public void updateValueOfConsign(double totalValueOfConsign) {
		jlValueOfConsign.setText(String.valueOf(totalValueOfConsign));
		jlValueOfConsign.setText( Utilities.toDecimalFormat(totalValueOfConsign ));
	}
	
	public void manageChangeLenguage() {
		jltitleValueOfConsign.setText(LanguageController.languageProperties.getProperty(ConstantsUI.T_LABEL_TOTAL_VALUE_OF_CONSIGN));
	}
}