package chibill.DeobLoader.launch;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import chibill.DeobLoader.loader.Load;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7383677203665318776L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static Load load = new Load();
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		load.SetupClassLoader();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Launch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				load.AddTargetToPath(textField_1.getText());
				load.AddTargetToPath(textField_2.getText());
				
				try {
					load.Start(textField.getText());
				} catch (NoSuchMethodException | SecurityException
						| IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(70, 221, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter the full class name of the file to launch.");
		lblNewLabel.setBounds(10, 34, 225, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(43, 59, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAndAlsoIts = new JLabel("And also its jar name.");
		lblAndAlsoIts.setBounds(70, 84, 104, 14);
		contentPane.add(lblAndAlsoIts);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(43, 158, 156, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(43, 109, 156, 20);
		contentPane.add(textField_2);
	}
}
