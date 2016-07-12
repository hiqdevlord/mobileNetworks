package main;

public class Nokia3310 extends Phone {
	
	public Nokia3310() {
		touch = false;
		hasWifi = false;
		screenSize = 2;
	}
	
	@Override
	public void call(String number) {
		if (networkIsEnabled()) {
			if (network.checkActivationNumber(phoneNumber)) {
				System.out.println("Network subscriber: " + network.getClass().getName() + " with phone number: " + phoneNumber
						+ " Устанавливает связь с абонентом: " + number);
				if (!network.connect(number)) {
					System.out.println("Не удалось соединиться с " + number);
				} else {
					callCounter++;
				}
			} else {
				System.out.println("Номер не активирован");
			}
		} else {
			System.out.println("Сеть не подключена");
		}
	}
	
	@Override
	public void sendSMS(String msg, String number) {
		if (networkIsEnabled()) {
			if (network.checkActivationNumber(phoneNumber)) {
				System.out.println("Nokia3310 is calling to " + number);	
				if (!network.sendMsg(msg, number)) {
					System.out.println("Не удалось отправить СМС на номер: " + number);
				} else {
					msgCounter++;
				}
			} else {
				System.out.println("Номер не активирован");
			}
		} else {
			System.out.println("Сеть не подключена");
		}
	}

	@Override
	public String answer() {
		// TODO Auto-generated method stub
		return "Nokia3310 is answering";
	}
	
}
