package bank1.bank1;

import java.awt.TrayIcon.MessageType;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.ensimag.api.node.INode;
import com.ensimag.api.node.Node;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  try {
	        	// 10000 est le port sur lequel sera publie le service. Nous devons le preciser a la fois sur le registry et a la fois a la creation du stub.
	            INode<MessageType> skeleton = (INode) UnicastRemoteObject.exportObject(new Node(), 10000); // Genere un stub vers notre service.
	            Registry registry = LocateRegistry.createRegistry(10000);
	            registry.rebind("getId", skeleton); // publie notre instance sous le nom "Add"
	        } catch (Exception e) {
	            e.printStackTrace();
	        }


    }
}
