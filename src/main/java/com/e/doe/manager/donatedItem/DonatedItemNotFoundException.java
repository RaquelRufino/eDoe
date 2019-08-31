package com.e.doe.manager.donatedItem;

public class DonatedItemNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DonatedItemNotFoundException(String idDonation)  {
		
        super("DonatedItem " + idDonation + " not found\n");
	}


}
