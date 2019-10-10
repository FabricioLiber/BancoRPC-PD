package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppBanco {

    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        // Cria uma instância do serviço com.gugawag.rpc.banco.BancoServiceServer...
        BancoServiceIF bancoService = new BancoServiceServer();

        // instanciando o registro
//        Registry registry = LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry("10.0.1.4", 1099);


        // liga (bind) o serviço ao RMI Registry
        registry.rebind("BancoService", bancoService);

        System.out.println("Service de banco registrado ....");
    }
}
