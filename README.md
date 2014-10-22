DeObfuscating-Loader
====================  
 
Will load a Obfuscated Minecraft jar and at run time using MCP mappings deobfuscate it then load a program that uses Minecraft as a dependency.

This project will use code for ForgeModLoader and also code for the Sponge server Forge implementation code.

The Forge code will be used to help me understand deobfing at runtime and the Sponge code will be used (basicly all the @shadow and @Mixxin code) to allow for devs to hook in to minecrafts internalls and also add in cod eto be called.

This code will also use LegacyLauncher which is owned by Mojang as a libbary.

Will also beusing code my CXGamer that he uses in his Redstone Simulator that loads MCP mappings.

======================================
This will load your program and read a java file in your program that tells it what version of minecraft it wants and what version of MCP feild and method mappings it wants.
