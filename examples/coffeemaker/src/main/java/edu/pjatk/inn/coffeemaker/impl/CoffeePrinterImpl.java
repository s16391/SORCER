package edu.pjatk.inn.coffeemaker.impl;

import edu.pjatk.inn.coffeemaker.CoffeePrinter;
import org.slf4j.LoggerFactory;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
import java.util.Optional;

public class CoffeePrinterImpl implements CoffeePrinter {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CoffeePrinterImpl.class);

    @Override
    public Context printCoffee(Context context) throws RemoteException, ContextException {
        String recipeName = (String)context.getValue("recipe/key");
        String passedText = (String)Optional.ofNullable(context.getValue("textToPrint")).orElse("");
        String coffeeText;
        if (recipeName != null && recipeName.equals("espresso")) {
            coffeeText = passedText + " espresso";
        } else {
            coffeeText = passedText + " defaultCoffee";
        }
        context.putValue("/coffee/text", coffeeText);
        logger.info(coffeeText);
        return context;
    }
}
