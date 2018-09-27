package me.weitao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloClient {

    private static Logger logger = LoggerUtil.setLoggerHanlder(Logger.getLogger("me.logger"));

    public static void main(String[] args) {
        try {
            // 在RMI服务注册表中查找名称为HelloServer的对象，并调用其上的方法
            Hello hello = (Hello) Naming.lookup("rmi://localhost:8518/HelloServer");
            String result = hello.sayHello();
            logger.log(Level.SEVERE, result);
            logger.log(Level.ALL, "调用远程对象的方法成功");
        } catch (NotBoundException e) {
            logger.info(e.getLocalizedMessage());
        } catch (MalformedURLException e) {
            logger.info(e.getLocalizedMessage());
        } catch (RemoteException e) {
            logger.info(e.getLocalizedMessage());
        }
    }
}
