import java.io.File;
import java.io.FileWriter;
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
		setMenuBar();
		this.setJMenuBar(bar);
		ImageIcon appIcon = new ImageIcon(getClass().getResource("/globe.png"));
		this.setIconImage(appIcon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public void setMenuBar() {
		
	
		bar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem item1 = new JMenuItem("Export results");
		item1.addActionListener(new export());
		JMenuItem item2 = new JMenuItem("exit");
		item2.addActionListener(new exit());
		
		menu.add(item1);
		menu.add(item2);
		bar.add(menu);
		
	}
	
	public void setPanel1() {
		
		panel1 = new JPanel();
		panel2= new JPanel();
		
		//panel1.setLayout(new BorderLayout());
		
		
		// button:
		ImageIcon icon = new ImageIcon(getClass().getResource("/globe.png"));
		button = new JButton();
		button.setIcon(icon);
		button.addActionListener(new lookup());
		button.setBackground(Color.WHITE);
		// Action Listener goes here:
		
        textArea = new JTextArea(30,60);
        textArea.setText("Results:\n\n");
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "IP Information:",TitledBorder.RIGHT, TitledBorder.TOP));
        textArea.setBackground(Color.WHITE);
        
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		tf = new JTextField(12);
		
		panel1.add(scrollPane);
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
				String text  = object.GetObjectValue();
				textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
				textArea.setText(text);
				System.out.println(object.GetObjectValue());
			
			
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
				
			}
			
			}
		}
	}




	private class export implements ActionListener{

		public void actionPerformed(ActionEvent e){

			String username = System.getProperty("user.name");
			String directory = "C:/Users/"+username+"Documents";

			JOptionPane.showMessageDialog(null, "Select the destination folder then name your file!", "Information", JOptionPane.INFORMATION_MESSAGE);

			String sb = textArea.getText();
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File(directory));
			int retrival = chooser.showSaveDialog(null);
			if (retrival == JFileChooser.APPROVE_OPTION) {
				try {
					FileWriter fw = new FileWriter(chooser.getSelectedFile());
					fw.write(sb.toString());
					fw.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}


		}

	}

	private class exit implements ActionListener{


		public void actionPerformed(ActionEvent e){

			System.exit(0);

		}


	}

	
	
	public static void main(String []args) {
		
		new guiMain();
		
	}
	
	
}
