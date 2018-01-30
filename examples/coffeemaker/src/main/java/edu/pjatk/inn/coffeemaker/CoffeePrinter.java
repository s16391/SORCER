package edu.pjatk.inn.coffeemaker;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;

public interface CoffeePrinter {

    public Context printCoffee(Context context) throws RemoteException, ContextException;

}
