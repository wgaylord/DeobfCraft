package craftdevs.main;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JLabel;

public class Main {
	
	private JLabel MCVersion;
	
	private JFrame frame;
	final JFileChooser fc = new JFileChooser();
	private JTextField textField;
	protected File tragetFile;
	private about About = new about();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(Constants.NAME+ " " + Constants.VERSION);
		frame.setIconImage(new ImageIcon("logo.png").getImage());
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime.getRuntime().exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 162, 268, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOpenFile = new JButton("Open File Dialog");
		btnOpenFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int temp =fc.showOpenDialog(frame);
				if(temp == 0){
				tragetFile = fc.getSelectedFile();
				textField.setText(tragetFile.getPath());
			}
			}});
		btnOpenFile.setBounds(288, 148, 136, 23);
		frame.getContentPane().add(btnOpenFile);
		
		JButton btnRunProgram = new JButton("Run Program");
		btnRunProgram.setBounds(288, 182, 136, 23);
		frame.getContentPane().add(btnRunProgram);
		
		JLabel lblMinecraftVersion = new JLabel("Minecraft Version");
		lblMinecraftVersion.setBounds(10, 23, 104, 28);
		frame.getContentPane().add(lblMinecraftVersion);
		
		MCVersion = new JLabel("????");
		MCVersion.setBounds(116, 30, 291, 14);
		frame.getContentPane().add(MCVersion);
	}
	
	public File getTargetFile(){
		return new File(textField.getText());
	}
	public void DownloadMCJar(String version){
		MCVersion.setText(version);
		
	}
}
