package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String numero) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void adicionarConta (String numero, double saldo) throws RemoteException;
}
