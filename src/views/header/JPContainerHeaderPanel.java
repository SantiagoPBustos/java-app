package views.header;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class JPContainerHeaderPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMBMainMenuBar jmbMainMenuBar;
	JTBMainToolBar jtbMainToolBar;
	
	public JPContainerHeaderPanel(ActionListener actionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		jmbMainMenuBar=new JMBMainMenuBar(actionListener);
		this.add(jmbMainMenuBar);
		
		jtbMainToolBar=new JTBMainToolBar(actionListener);
		this.add(jtbMainToolBar);
		
	}
	
	public void manageChangeLenguage() {
		jmbMainMenuBar.manageChangeLenguage();
		jtbMainToolBar.manageChangeLenguage();
	}
}