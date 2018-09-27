package me.weitao;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;

public class HelloServer {
    private static Logger logger = LoggerUtil.setLoggerHanlder(Logger.getLogger("my.logger"));

    public static void main(String[] args) {
        int port = 8518;
        try {
            // 创建一个远程对象
            Hello hello = new HelloImpl();
            // 本地主机上的远程对象注册表Registry的实例，并指定端口为8518(Java默认端口是1099）
            LocateRegistry.createRegistry(port);
            // 把远程对象注册到RMI注册服务器上，并命名为HelloServer
            Naming.bind("rmi://localhost:" + port + "/HelloServer", hello);
            logger.info("Info -> 远程HelloServer对象绑定成功...");
        } catch (RemoteException e) {
            logger.info("创建远程对象发生异常" + e.getMessage());
        } catch (AlreadyBoundException e) {
            logger.info("发生重复绑定对象异常" + e.getMessage());
        } catch (MalformedURLException e) {
            logger.info("发生URL畸形异常" + e.getMessage());
        }
    }
}
