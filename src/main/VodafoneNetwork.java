package main;

public class VodafoneNetwork extends MobileNetwork {
	
	public VodafoneNetwork() {
		reservedNumbers = new String[] {"050", "066", "095", "099"};
	}
	
	@Override
	public String mobileNetworkName() {
		return "Vodafone";
	}
	
}
