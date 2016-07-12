package main;

public interface IConnector {
	
	public boolean connect(Object o);
	
	public boolean sendMsg(String msg, Object o);

}
