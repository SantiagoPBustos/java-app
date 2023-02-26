package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JMButtonRounded extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int arcW;
	private int arcH;
	
	public JMButtonRounded( int arcW, int arcH, String text, String codeColorBackground, String codeColorForeground ) {
		super( text );
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground( Color.decode( codeColorBackground ) );
		//super(size);
		//setOpaque(false); 
	}

	public JMButtonRounded( int arcW, int arcH, String text, String codeColorBackground, String codeColorForeground, String pathImageIcon) {
		super( text );
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground( Color.decode( codeColorBackground ) );
		setContentAreaFilled( false );
		setForeground( Color.decode( codeColorForeground));
		this.setIcon( new ImageIcon(getClass().getResource( pathImageIcon )) );
		//			super(size);
		//			setOpaque(false); 
	}
	
	public JMButtonRounded( int arcW, int arcH, String text, Color codeColorBackground, Color codeColorForeground, String command, ActionListener listener) {
		super( text );
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground( codeColorBackground );
		this.setContentAreaFilled( false );
		this.setForeground(  codeColorForeground );
		this.setActionCommand( command );
		this.addActionListener( listener );
	}
	
	public JMButtonRounded( int arcW, int arcH, String text, Color codeColorBackground, Color codeColorForeground, Font font, String command, ActionListener listener) {
		super( text );
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground( codeColorBackground );
		this.setContentAreaFilled( false );
		this.setForeground(  codeColorForeground );
		this.setFont( font );
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setActionCommand( command );
		this.addActionListener( listener );
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; 
		g2.setColor(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);           
		g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
	}
}
