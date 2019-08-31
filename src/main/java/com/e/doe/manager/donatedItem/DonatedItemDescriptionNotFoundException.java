package com.e.doe.manager.donatedItem;

public class DonatedItemDescriptionNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DonatedItemDescriptionNotFoundException(String description)  {
		
        super("Description " + description + " not found\n");
	}


}