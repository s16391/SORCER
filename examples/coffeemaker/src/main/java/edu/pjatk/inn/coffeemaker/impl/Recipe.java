package edu.pjatk.inn.coffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * COPYRIGHT (C) 2018 sorcersoft.org. All rights reserved
 * This class is holding basic recipe's data
 * @author  Sarah & Mike
 * @version 1.0
 */
public class Recipe implements Serializable {
	/** Name of the recipe */
    private String name;
    /** Price of coffee sold prepared using this recipe */
    private int price;
    /** Amount of coffee used for this recipe */
    private int amtCoffee;
    /** Amount of milk used for this recipe */
    private int amtMilk;
    /** Amount of sugar used for this recipe */
    private int amtSugar;
	/** Amount of chocolate used for this recipe */
    private int amtChocolate;

    /** Constructs new recipe with default values for fields */
    public Recipe() {
    	this.name = "";
    	this.price = 0;
    	this.amtCoffee = 0;
    	this.amtMilk = 0;
    	this.amtSugar = 0;
    	this.amtChocolate = 0;
    }
    
    /**
	 * @return amount of chocolate used for this recipe
	 */
    public int getAmtChocolate() {
		return amtChocolate;
	}
    /**
	 * @param amtChocolate The amount of chocolate which is to be set on this recipe.
	 */
    public void setAmtChocolate(int amtChocolate) {
		if (amtChocolate >= 0) {
			this.amtChocolate = amtChocolate;
		} 
	}
    /**
	 * @return amount of coffee used in this recipe
	 */
    public int getAmtCoffee() {
		return amtCoffee;
	}
    /**
	 * Sets the amount of milk in this recipe.
	 * If the amount is negative, amount will not be set.
	 * @param amtCoffee	  The amount of coffee in this recipe
	 */
    public void setAmtCoffee(int amtCoffee) {
		if (amtCoffee >= 0) {
			this.amtCoffee = amtCoffee;
		} 
	}
    /**
	 * Returns integer value representing amount of milk
	 * in this recipe
	 * @return amount of milk used in this recipe
	 */
    public int getAmtMilk() {
		return amtMilk;
	}
    /**
	 * Sets the amount of milk in this recipe
	 * @param amtMilk The amount of milk to be set.
	 *                If amtMilk is negative,
	 *                it will not be set
	 */
    public void setAmtMilk(int amtMilk) {
		if (amtMilk >= 0) {
			this.amtMilk = amtMilk;
		} 
	}
    /**
	 * @return amount of sugar used in this recipe
	 */
    public int getAmtSugar() {
		return amtSugar;
	}
    /**
	 * Sets amount of sugar in this recipe
	 * @param amtSugar   The amount of sugar to be set.
	 *                   If amtSugar is negative, it will not be set
	 */
    public void setAmtSugar(int amtSugar) {
		if (amtSugar >= 0) {
			this.amtSugar = amtSugar;
		} 
	}
    /**
	 * @return   the name of recipe
	 */
    public String getName() {
		return name;
	}
    /**
	 * Sets recipe name
	 * @param name   the name of recipe
	 *             	 If the name is null, it will not be set
	 */
    public void setName(String name) {
    	if(name != null) {
    		this.name = name;
    	}
	}
    /**
	 * @return   Returns the recipe name.
	 */
    public int getPrice() {
		return price;
	}
    /**
	 * Sets the recipe name
	 * @param price   the price of the recipe.
	 *                If the price is negative, it will not be set
	 */
    public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		} 
	} 
    public boolean equals(Recipe r) {
        if((this.name).equals(r.getName())) {
            return true;
        }
        return false;
    }

	/**
	 * Returns a String object representing recipe
	 * @return a string representation of this object
	 */
	public String toString() {
    	return name;
    }

    /** */
	static public Recipe getRecipe(Context context) throws ContextException {
		Recipe r = new Recipe();
		try {
			r.name = (String)context.getValue("key");
			r.price = (int)context.getValue("price");
			r.amtCoffee = (int)context.getValue("amtCoffee");
			r.amtMilk = (int)context.getValue("amtMilk");
			r.amtSugar = (int)context.getValue("amtSugar");
			r.amtChocolate = (int)context.getValue("amtChocolate");
		} catch (RemoteException e) {
			throw new ContextException(e);
		}
		return r;
	}

	static public Context getContext(Recipe recipe) throws ContextException {
		Context cxt = new ServiceContext();
		cxt.putValue("key", recipe.getName());
		cxt.putValue("price", recipe.getPrice());
		cxt.putValue("amtCoffee", recipe.getAmtCoffee());
		cxt.putValue("amtMilk", recipe.getAmtMilk());
		cxt.putValue("amtSugar", recipe.getAmtSugar());
		cxt.putValue("amtChocolate", recipe.getAmtChocolate());
		return cxt;
	}


}
