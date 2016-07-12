package main;

public class KievstarNetwork extends MobileNetwork {

	public KievstarNetwork() {
		reservedNumbers = new String[] {"067", "096", "097", "098"};
	}
	
	@Override
	public String mobileNetworkName() {
		return "Киевстар";
	}
	
}
