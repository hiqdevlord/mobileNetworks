package main;

public class LifeNetwork extends MobileNetwork {
	
	public LifeNetwork() {
		reservedNumbers = new String[] {"063", "073", "093"};
	}
	
	@Override
	public String mobileNetworkName() {
		return "Life";
	}
	
}
