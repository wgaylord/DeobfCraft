package chibill.main;

import chibill.Constants;
import chibill.downloader.DownloadManager;

public class Main {

	public static void main(String[] args) throws Exception {
		
		DownloadManager.Download(Constants.MINECRAFT_DOWNLOAD_SERVER+"1.8.3/1.8.3.jar", "1.8.3.jar");
		Runtime.getRuntime().exit(0);
	}

}
