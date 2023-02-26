package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MDJDialogData extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel jpContainerDialog;
	JLabel jlHeader,jlTypeData,jlFirtsElement,jlSecondElement,
			jlThirdElement,jlFourElement;
	JProgressBar jpbFirstValue,jpbSecondValue,jpbThirdValue,jpbFourValue;
	
	public MDJDialogData(String title,JFMainWindow jfMainWindow,String labelHeader,String labelTypeData,
						String labelFirstElement,String labelSecondElement,String labelThirdElement) {
		this.setTitle(title);
		this.setModal(true);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsUI.PATH_MAIN_ICON)).getImage());
		this.setSize(500, 250);
		this.setMinimumSize(new Dimension(400, 200));
		this.setLocationRelativeTo(jfMainWindow);
		initComponentsThree(labelHeader,labelTypeData,labelFirstElement,labelSecondElement,labelThirdElement);
	}
	
	public MDJDialogData(String title,JFMainWindow jfMainWindow,String labelHeader,String labelTypeData,
					String labelFirstElement,String labelSecondElement,String labelThirdElement,String labelFourElement) {
		this.setTitle(title);
		this.setModal(true);
		this.setIconImage(new ImageIcon(getClass().getResource(ConstantsUI.PATH_MAIN_ICON)).getImage());
		this.setSize(550, 280);
		this.setMinimumSize(new Dimension(450, 230));
		this.setLocationRelativeTo(jfMainWindow);
		initComponentsFour(labelHeader,labelTypeData,labelFirstElement,labelSecondElement,labelThirdElement,
						labelFourElement);
	}

	private void initComponentsThree(String labelHeader,String labelTypeData,String labelFirstElement,
							String labelSecondElement,String labelThirdElement) {
		jpContainerDialog=new JPanel();
		jpContainerDialog.setBackground(ConstantsUI.COLOR_CYAN);
		jpContainerDialog.setLayout(new GridLayout(4, 2, 15, 15));
		jpContainerDialog.setBorder(new EmptyBorder(25, 40, 25, 60));
		
		jlHeader=new JLabel(labelHeader);
		jlHeader.setFont(ConstantsUI.FONT_DIALOGS);
		jpContainerDialog.add(jlHeader);
		
		jlTypeData=new JLabel(labelTypeData);
		jlTypeData.setHorizontalAlignment(SwingConstants.RIGHT);
		jlTypeData.setFont(ConstantsUI.FONT_DIALOGS);
		jpContainerDialog.add(jlTypeData);
		
		jlFirtsElement=new JLabel(labelFirstElement);
		jpContainerDialog.add(jlFirtsElement);
		
		jpbFirstValue=new JProgressBar();
		jpContainerDialog.add(mpbJProgressBar(jpbFirstValue));
		
		jlSecondElement=new JLabel(labelSecondElement);
		jpContainerDialog.add(jlSecondElement);
		
		jpbSecondValue=new JProgressBar();
		jpContainerDialog.add(mpbJProgressBar(jpbSecondValue));
		
		jlThirdElement=new JLabel(labelThirdElement);
		jpContainerDialog.add(jlThirdElement);
		
		jpbThirdValue=new JProgressBar();
		jpContainerDialog.add(mpbJProgressBar(jpbThirdValue));
		
		this.add(jpContainerDialog);
	}
	
	private void initComponentsFour(String labelHeader,String labelTypeData,
								String labelFirstElement,String labelSecondElement,String labelThirdElement,String labelFourElement) {
		
		jpContainerDialog=new JPanel();
		jpContainerDialog.setBackground(ConstantsUI.COLOR_CYAN);
		jpContainerDialog.setLayout(new GridLayout(5, 2, 15, 15));
		jpContainerDialog.setBorder(new EmptyBorder(25, 40, 25, 60));
		
		jlHeader=new JLabel(labelHeader);
		jlHeader.setFont(ConstantsUI.FONT_DIALOGS);
		jpContainerDialog.add(jlHeader);
		
		jlTypeData=new JLabel(labelTypeData);
		jlTypeData.setHorizontalAlignment(SwingConstants.RIGHT);
		jlTypeData.setFont(ConstantsUI.FONT_DIALOGS);
		jpContainerDialog.add(jlTypeData);
		
		jlFirtsElement=new JLabel(labelFirstElement);
		jpContainerDialog.add(jlFirtsElement);
		
		jpbFirstValue=new JProgressBar();
		jpContainerDialog.add(mpbJProgressBar(jpbFirstValue));
		
		jlSecondElement=new JLabel(labelSecondElement);
		jpContainerDialog.add(jlSecondElement);
		
		jpbSecondValue=new JProgressBar();
		jpContainerDialog.add(mpbJProgressBar(jpbSecondValue));
		
		jlThirdElement=new JLabel(labelThirdElement);
		jpContainerDialog.add(jlThirdElement);
		
		jpbThirdValue=new JProgressBar();
		jpContainerDialog.add(mpbJProgressBar(jpbThirdValue));
		
		jlFourElement=new JLabel(labelFourElement);
		jpContainerDialog.add(jlFourElement);
		
		jpbFourValue=new JProgressBar();
		jpContainerDialog.add(mpbJProgressBar(jpbFourValue));
		
		this.add(jpContainerDialog);
	}
		
	private JProgressBar mpbJProgressBar(JProgressBar jProgressBar) {
		jProgressBar.setStringPainted(true);
		jProgressBar.setBackground(Color.WHITE);
		jProgressBar.setForeground(ConstantsUI.COLOR_HEADER_TABLE);
		jProgressBar.setBorderPainted(false);
		return jProgressBar;
	}
}
