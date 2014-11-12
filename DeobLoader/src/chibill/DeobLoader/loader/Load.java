package chibill.DeobLoader.loader;

import java.net.URLClassLoader;

import net.minecraft.launchwrapper.LaunchClassLoader;

public class Load {

	private LaunchClassLoader classLoader;

	public void SetupClassLoader(){

		classLoader = new LaunchClassLoader(((URLClassLoader)getClass().getClassLoader()).getURLs());
	
		classLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.DeobfuscationTransformer");
	
	}

public void Start(String main){
	
	try {
		final Class<?> clazz = Class.forName(main, false, classLoader);
	} catch (ClassNotFoundException e) {

				
	}
	
	
}

	public void AddTargetToPath(String target){



	}

}
