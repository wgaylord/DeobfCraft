package craftdevs.chibill.deobfcraft.patcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javassist.ByteArrayClassPath;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import craftdevs.chibill.deobfcraft.deobf.SS;
import net.md_5.specialsource.Jar;
import net.md_5.specialsource.JarMapping;
import net.md_5.specialsource.provider.JointProvider;

public class MinecraftCtClassFactory {

	public HashMap<String,CtClass> classes = new HashMap<String,CtClass>();
	
	Jar jar;

	public ClassPool pool;
	
	public MinecraftCtClassFactory(){
		
	}

	
	public void setJar(Jar jar){
		this.jar = jar;
	}
	
	public void BuildMCCtClasses() throws NotFoundException{
		JarMapping jarMapping = new JarMapping();
		try {
			jarMapping.loadMappings("joined.srg", false, false, null,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JointProvider inheritanceProviders = new JointProvider();
	    jarMapping.setFallbackInheritanceProvider(inheritanceProviders);
	    SS jarRemapper = new SS(null, jarMapping, null);
	   
	    try {
	    	jarRemapper.remapJar(jar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    HashMap<String, byte[]> Classes = jarRemapper.getClasses();
	    
	    Iterator<String> classes =Classes.keySet().iterator();
	    
	    while( classes.hasNext()){
	    	String name  = classes.next();
	    	 byte[] clazz = Classes.get(name);
	    	 
	    	pool = ClassPool.getDefault();
	    	pool.insertClassPath(new ByteArrayClassPath(name, clazz));
	    	this.classes.put(name,pool.get(name));
	    	
	    	//pool.get(name).debugWriteFile("mc");
	    }
	}
	
}

