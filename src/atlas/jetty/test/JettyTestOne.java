/**
 * 
 */
package atlas.jetty.test;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.xml.XmlConfiguration;

/**
 * @author formica
 *
 */
public class JettyTestOne {

	private String getJarFolder() {
	    String name = this.getClass().getName().replace('.', '/');
	    String s = this.getClass().getResource("/" + name + ".class").toString();
	    s = s.replace('/', File.separatorChar);
	    s = s.substring(0, s.indexOf(".jar")+4);
	    s = s.substring(s.lastIndexOf(':')-1);
	    return s.substring(0, s.lastIndexOf(File.separatorChar)+1);
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Server server = new Server(8080);
        System.out.println("Test program for Jetty Server");

        try {
            System.out.println("Configuring Jetty Server...");
        	XmlConfiguration configuration = new XmlConfiguration(JettyTestOne.class.getResourceAsStream("/etc/myJetty.xml"));
    		Server server = (Server)configuration.configure();
            System.out.println("Server configured...");
        	
//        	server.setHandler(new HelloHandler());
        	
            System.out.println("Starting Jetty Server");
			server.start();
//	        server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
