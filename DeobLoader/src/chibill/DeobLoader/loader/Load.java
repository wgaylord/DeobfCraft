package chibill.DeobLoader.loader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

import javax.swing.JOptionPane;

import net.minecraft.launchwrapper.LaunchClassLoader;

public class Load {

	private static LaunchClassLoader classLoader;

	public  void SetupClassLoader(){

		classLoader = new LaunchClassLoader(((URLClassLoader)getClass().getClassLoader()).getURLs());
	
		classLoader.registerTransformer("chibill.DeobLoader.loader.tweaker");
		
		
        
        classLoader.addTransformerExclusion("cpw.mods.fml.repackage.");
        classLoader.addTransformerExclusion("cpw.mods.fml.relauncher.");
        classLoader.addTransformerExclusion("cpw.mods.fml.common.asm.transformers.");	

        classLoader.addTransformerExclusion("chibill.DeobLoader.loader.");
	}

public void Start(String main) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	System.out.println(main);
	try {
		final Class<?> clazz = Class.forName(main, false, classLoader);
		final Method mainMethod = clazz.getMethod("main", new Class[]{String[].class});

        mainMethod.invoke(null, (Object)new String[0]);
				} catch (ClassNotFoundException e) {

		JOptionPane.showMessageDialog(null, "ERROR! ");
		e.printStackTrace();		
		
	}
	
	
}

	public void AddTargetToPath(String target){

		if(target.isEmpty()){
			target = "";
		}
		
		try {
			classLoader.addURL(new File(target).toURI().toURL());
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			
					}

	}

}
