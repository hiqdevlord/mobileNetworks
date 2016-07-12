package main;

public class SIP extends Protocol {
	
	public SIP() {
		level = OSILev.APPLICATION;
	}
	
	@Override
	public boolean connect(Object phone) {
		System.out.println("SIP: Установлено соединение с абонентом: "
				+ ((Phone) phone).getMobileNetwork() + " " + ((Phone) phone).getNumber());
		System.out.println("Answer: " + ((Phone) phone).answer());
		return true;
	}
	
	@Override
	public boolean sendMsg(String msg, Object phone) {
		System.out.println("Отправка СМС: " + msg + " на номер: " + ((Phone) phone).getNumber());
		return true;
	}

}
