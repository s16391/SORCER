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
	/** recipe name */
    private String name;
    /** recipe price */
    private int price;
    /** Amount of coffee used in recipe */
    private int amtCoffee;
    /** Amount of milk used in recipe */
    private int amtMilk;
    /** Amount of sugar used in recipe */
    private int amtSugar;
	/** Amount of chocolate in recipe */
    private int amtChocolate;

    /** Creates a recipe with default attributes */
    public Recipe() {
    	this.name = "";
    	this.price = 0;
    	this.amtCoffee = 0;
    	this.amtMilk = 0;
    	this.amtSugar = 0;
    	this.amtChocolate = 0;
    }
    
    /**
	 * Returns the amount of chocolate used in this recipe
	 * @return amount of chocolate used in this recipe
	 */
    public int getAmtChocolate() {
		return amtChocolate;
	}
    /**
	 * Sets the amount of milk used in this recipe
	 * @param amtChocolate - The amount of chocolate to be used in this recipe.
	 *                     If amtChocolate is negative, it will not be set
	 */
    public void setAmtChocolate(int amtChocolate) {
		if (amtChocolate >= 0) {
			this.amtChocolate = amtChocolate;
		} 
	}
    /**
	 * Returns the amount of coffee used in this recipe
	 * @return the amount of coffee used in this recipe
	 */
    public int getAmtCoffee() {
		return amtCoffee;
	}
    /**
	 * Sets the amount of milk in this recipe.
	 * @param amtCoffee	- The amount of coffee in this recipe.
	 *                  If amtCoffee is negative, it will not be set
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
	 * @param amtMilk - the amount of milk to be used in this recipe.
	 *                If amtMilk is negative, it will not be set
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
	 * Sets amount of sugar used in this recipe
	 * @param amtSugar - the amount of sugar to be used in this recipe.
	 *                   If amtSugar is negative, it will not be set
	 */
    public void setAmtSugar(int amtSugar) {
		if (amtSugar >= 0) {
			this.amtSugar = amtSugar;
		} 
	}
    /**
	 * Returns recipe name
	 * @return   the name of recipe
	 */
    public String getName() {
		return name;
	}
    /**
	 * Sets recipe name
	 * @param name - the name of recipe
	 *             	 If the name is null, it will not be set
	 */
    public void setName(String name) {
    	if(name != null) {
    		this.name = name;
    	}
	}
    /**
	 * Returns recipe price
	 * @return   the price of recipe.
	 */
    public int getPrice() {
		return price;
	}
    /**
	 * Sets recipe price
	 * @param price - the price of recipe.
	 *                If the price is negative, it will not be set
	 */
    public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		} 
	}
	/**
	 * Returns true if and only if the other recipe is not null
	 * and its name is equal to this recipe name
	 * @param r - other recipe
	 */
    public boolean equals(Recipe r) {
    	if (r == null) {
    		return false;
		}
        if((this.name).equals(r.getName())) {
            return true;
        }
        return false;
    }

	/**
	 * Converts this recipe to a String
	 * @return a string representation of this recipe
	 */
	public String toString() {
    	return name;
    }

	/**
	 * Returns Recipe object based on context
	 * @param context the context
	 * @return recipe based on context
	 * @throws ContextException
	 */
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

	/**
	 * Returns context based on passed recipe
	 * @param recipe - passed recipe
	 * @return context based on recipe passed as an argument
	 * @throws ContextException
	 */
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
