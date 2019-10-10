package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<>();
    }

    @Override
    public double saldo(String numero) throws RemoteException {
        for (Conta c: contas)
            if (c.getNumero().equals(numero))
                return c.getSaldo();
        return -1;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarConta (String numero, double saldo) throws RemoteException {
        contas.add(new Conta(numero, saldo));
    }

}
