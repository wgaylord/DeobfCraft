package craftdevs.chibill.deobfcraft.deobf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.jar.JarEntry;

import net.md_5.specialsource.Jar;
import net.md_5.specialsource.JarMapping;
import net.md_5.specialsource.JarRemapper;
import net.md_5.specialsource.RemapperProcessor;
import net.md_5.specialsource.repo.ClassRepo;
import net.md_5.specialsource.repo.JarRepo;

public class SS extends JarRemapper {

	private HashMap<String,byte[]> classes = new HashMap<String,byte[]>();
	
	private static final int CLASS_LEN = ".class".length();
	
	public SS(RemapperProcessor preProcessor, JarMapping jarMapping,
			RemapperProcessor postProcessor) {
		super(preProcessor, jarMapping, postProcessor);
		
	}
    /**
     * Remap all the classes in a jar, writing a new jar to the target
     */
    public void remapJar(Jar jar) throws IOException {
      
        ClassRepo repo = new JarRepo(jar);
            if (jar == null) {
                return;
            }
            for (String name : jar.getEntryNames()) {

                JarEntry entry;

                InputStream is = jar.getResource(name);
                try {
                    byte[] data;
                    if (name.endsWith(".class")) {
                        // remap classes
                        name = name.substring(0, name.length() - CLASS_LEN);

                        data = remapClassFile(is, repo);
                        String newName = map(name);

                        entry = new JarEntry(newName == null ? name : newName + ".class");
                    } else if (name.endsWith(".DSA") || name.endsWith(".SF")) {
                        // skip signatures
                        continue;
                    } else {
                      
                        entry = new JarEntry(name);

                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        int n;
                        byte[] b = new byte[1 << 15]; // Max class file size
                        while ((n = is.read(b, 0, b.length)) != -1) {
                            buffer.write(b, 0, n);
                        }
                        buffer.flush();
                        data = buffer.toByteArray();
                    }
                    entry.setTime(0);
                    getClasses().put(map(name).replace("/", "."), data);
                } finally {
                    is.close();
                }
            }
        
    }
	public HashMap<String,byte[]> getClasses() {
		return classes;
	}
	
	
}
