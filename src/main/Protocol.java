package main;

public abstract class Protocol implements IConnector {
	
	public enum OSILev {
		PHYSICAL, DATA_LINK, NETWORK, TRANSPORT, SESSION, PRESENTATION, APPLICATION
	}
	
	protected OSILev level;

}
