package chibill.main;
/**Copyright 2015 chibill

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
**/
import chibill.Constants;
import chibill.downloader.DownloadManager;

public class Main {

	public static void main(String[] args) throws Exception {
		
		DownloadManager.Download(Constants.MINECRAFT_DOWNLOAD_SERVER+"1.8.3/1.8.3.jar", "1.8.3.jar");
		Runtime.getRuntime().exit(0);
	}

}
