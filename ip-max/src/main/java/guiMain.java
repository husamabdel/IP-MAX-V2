import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;


public class guiMain extends JFrame{

	private JMenuBar bar;

	private JPanel panel1;
	private JPanel panel2;
	private JTextArea textArea;
	private JTextField tf;
	private JLabel label;
	private JButton button;
	private JScrollPane scrollPane;
	private JSplitPane pane;
	
	public guiMain() {
		
		this.setTitle("IP-MAX");
		this.setSize(750,680);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel1();
		this.add(pane);
		this.setVisible(true);
		
	}
	
	public void setMenuBar() {
		
		
		
	}
	
	public void setPanel1() {
		
		panel1 = new JPanel();
		panel2= new JPanel();
		
		//panel1.setLayout(new BorderLayout());
		
		
		// button:
		ImageIcon icon = new ImageIcon("/home/husam/eclipse-workspace/ip-max/src/main/resources/globe.png");
		button = new JButton();
		button.setIcon(icon);
		button.addActionListener(new lookup());
		// Action Listener goes here:
		
        textArea = new JTextArea(30,60);
        textArea.setText("Results:\n\n");
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "IP Information:",TitledBorder.RIGHT, TitledBorder.TOP));
        textArea.setBackground(Color.WHITE);	
		
		tf = new JTextField(12);
		
		panel1.add(textArea);
		panel2.add(tf);
		panel2.add(button);
        
		pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		pane.add(panel1);
		pane.add(panel2);
		pane.setOneTouchExpandable(true);
		pane.setDividerLocation(560);
		
	}
	
	
	//ACTION LISTENER TO BUTTON:
	private class lookup implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
			
			String ip = tf.getText();
			
			if(ip.equals(null)) {
				
				JOptionPane.showMessageDialog(null,"The Value of the IP was not correct!","ERROR!",JOptionPane.ERROR_MESSAGE);
				return;
				
			} else {
			
			tf.setText(null);
			textArea.setText(null);
			
			try {
				webRequests request = new webRequests(ip);
				ipObject object = request.CreateObject();
				textArea.setText(object.GetObjectValue());
			
			
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
				
			}
			
			}
		}
	}
	
	
	public static void main(String []args) {
		
		new guiMain();
		
	}
	
	
}
