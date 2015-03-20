package chibill.downloader;

import java.awt.FlowLayout;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class DownloadManager {
	public static void Download(String URL ,String file) throws Exception {
		String site=URL;
		String filename=file; 
		JFrame frm=new JFrame();
		JProgressBar current = new JProgressBar(0, 100);
		current.setSize(50,50);
		current.setValue(43);
		current.setStringPainted(true); 
		frm.add(current); 
		frm.setVisible(true);
		frm.setLayout(new FlowLayout()); 
		frm.setSize(80, 80); 
		frm.setTitle("Downloading "+file);
		frm.setName("Downloading "+file);
		try { 
			URL url=new URL(site);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			int filesize = connection.getContentLength();
			float totalDataRead=0;
			java.io.BufferedInputStream in = new java.io.BufferedInputStream(connection.getInputStream());
			java.io.FileOutputStream fos = new java.io.FileOutputStream(filename);
			java.io.BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
			byte[] data = new byte[1024];
			int i=0;
			while((i=in.read(data,0,1024))>=0) {
				totalDataRead=totalDataRead+i;
				bout.write(data,0,i);
				float Percent=(totalDataRead*100)/filesize; 
				current.setValue((int)Percent);
				}	
			bout.close(); 
			in.close();
			} catch(Exception e) {
				javax.swing.JOptionPane.showConfirmDialog((java.awt.Component) null,e.getMessage(), "Error", javax.swing.JOptionPane.DEFAULT_OPTION); 
				}
		}
}
