DeObfuscating-Loader
====================  
 
At load this program will download a minecraft server/client jar then Deobfuscate it using mappings.
It will then load up you program with the deobfuscated classes on the classpath.

This program will allow you to make edits to the minecraft src using patch files. These patch files will be a standard unified diff patch file.

Also you have the ability to use an Access Transformer to change method and variable accesses levels.

In the end it will also supporting mappings from the Enigma project and MCP mappings.

It will also allow you to set the MCP mappings for the fields and methods using the MCP-Bot exporter site. And a metadate file in your jar.

To Dev
====================  

Run ..gradle eclipse and then import into eclipse.

======================================
