package main;

public abstract class Phone {
	
	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;
	
	protected int callCounter;
	protected int msgCounter;
	
	protected String phoneNumber;
	
	protected MobileNetwork network;
	
	public final int getCallCounter() {
		return callCounter;
	}
	
	public final int getMsgCounter() {
		return msgCounter;
	}
	
	public boolean isTouch() {
		return touch;
	}
	
	public boolean isHasWifi() {
		return hasWifi;
	}
	
	public int getScreenSize() {
		return screenSize;
	}
	
	public void setNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getNumber() {
		return phoneNumber;
	}
	
	public void activationNumber() {
		if (networkIsEnabled()) {
			if (!network.activationNumber(this)) {
				System.out.println("Ошибка активации номера: " + phoneNumber);
			} else {
				System.out.println("Номер: " + phoneNumber + " подключен успешно");
			}
		} else {
			System.out.println("Не подключена сеть");
		}
	}
	
	public boolean onNetwork() {
		//Проверка принадлежности номера к какой нибуть сети
		MobileNetwork network = MobileNetwork.getMobileNetwork(phoneNumber);
		if (network != null) {
			this.network = network;
			System.out.println("Сеть: "+ network.getClass().getName() + " подключена");
			return true;
		} else {
			System.out.println("Номер: " + phoneNumber +" не принадлежит ни к одной сети");
			return false;
		}
	}
	
	public void offNetwork() {
		if (networkIsEnabled()) network = null;
	}
	
	public boolean networkIsEnabled() {
		return network != null;
	}
	
	public String getModel() {
		return this.getClass().getName();
	}
	
	public String getMobileNetwork() {
		return network.mobileNetworkName();
	}
	
	public abstract void call(String number);
	
	public abstract String answer();
	
	public abstract void sendSMS(String msg, String number);
	
}
