package me.weitao;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    private static Logger logger = LoggerUtil.setLoggerHanlder(Logger.getLogger("me.logger"));

    public HelloImpl() throws RemoteException {
        logger.info("Enter HelloImpl");
    }

    public String sayHello() {
        return "Hello World";
    }

    public static void main(String[] args) {
        try {
            HelloImpl obj = new HelloImpl();
            Naming.rebind("HelloServer", obj);
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage());
        }
    }
}
