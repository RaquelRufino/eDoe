package com.e.doe.manager.donatedItem;

public class DonatedItemNotNullRuntimeException{

	private static final long serialVersionUID = -8855688573022904276L;

	public String DonatedItemNotNullRuntimeException(long id) {
		
		return "DonatedItem " + Long.toString(id) + " is not related to any donated items\n" ;
	}

	
	public String getErrorCode() {
		return "DONATED_ITEM_NOT_NULL";
	}

}
