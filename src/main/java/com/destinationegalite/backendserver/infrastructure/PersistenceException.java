package com.destinationegalite.backendserver.infrastructure;

@SuppressWarnings("serial")
public class PersistenceException extends Exception {

	public PersistenceException(String message){
		super(message);
	}
}
