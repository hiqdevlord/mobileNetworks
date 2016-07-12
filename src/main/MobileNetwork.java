package main;

public abstract class MobileNetwork extends Network {
	
	protected String[] reservedNumbers;
	
	protected PhoneList phoneList;
	
	private final String firstSymbols = "+38";
	private final int PHONE_NUMBER_LENGTH = 13;
	
	private final static MobileNetwork[] networkArr = {
		new VodafoneNetwork(), new LifeNetwork(), new KievstarNetwork()
	};
	
	public MobileNetwork() {
		protocol = new SIP();
		phoneList = new PhoneList();
	}
	
	//Определение сети по номеру
	public static MobileNetwork getMobileNetwork(String number) {
		for (MobileNetwork network : networkArr) {
			if (network.checkAffiliations(number)) {
				return network;
			}
		}
		return null;
	}
	
	//Добавление телефона в базу
	public final boolean activationNumber(Phone phone) {
		if (numberIsValid(phone.getNumber())) {
			phoneList.add(phone);
			return true;
		}
		return false;
	}
	
	public final boolean checkActivationNumber(String number) {
		return phoneList.contains(number);
	}
	
	public void removeNumber(String number) {
		phoneList.remove(number);
	}
	
	public String mobileNetworkName() {
		return this.getClass().getName();
	}
	
	@Override
	public boolean connect(Object number) {
		Phone phone = getPhone((String) number);
		if (phone != null) {
			return protocol.connect(phone);
		} else {
			return false;
		}
	}
	
	@Override
	public boolean sendMsg(String msg, Object number) {
		Phone phone = getPhone((String) number);
		if (phone != null) {
			return protocol.sendMsg(msg, (String) number);
		} else {
			return false;
		}
	}
	
	//Проверка принадлежности номера к сети
	protected final boolean checkAffiliations(String number) {
		return numberIsValid(number);
	}
	
	protected final boolean numberIsValid(String number) {
		if (number != null && number.length() == PHONE_NUMBER_LENGTH) {
			int index1 = number.indexOf(firstSymbols);
			int index2 = -1;
			for (String reservedNumber : reservedNumbers) {
				index2 = number.indexOf(reservedNumber);
				if (index2 != -1 && index2 == 3) break;
			}
			//Если index1 != -1 то первое вхождение подстроки "+38" должно начинаться с 0
			//Если index2 != -1 то первое вхождение подстроки "093" (или др. из списка) должно начинаться с 3
			if (index1 != -1 && index2 != -1 && index1 == 0 && index2 == 3) {
				//Если все проверки проходят - номер правильный
				return true;
			}
		}
		return false;
	}
	
	protected Phone getPhone(String number) {
		for (MobileNetwork network : networkArr) {
			Phone phone = network.phoneList.get((String) number);
			if (phone != null) {
				return phone;
			}
		}
		return null;
	}
	
}
