package main;

import java.text.DecimalFormat;
import java.util.Random;

public class Main {
	
	public static void main(String args[]) {
		Random random = new Random();
		DecimalFormat decimalFormat = new DecimalFormat("0000000");
		
		Phone[] phones = new Phone[10];
		
		for (int i = 0; i < phones.length; i++) {
			int value = random.nextInt(10000000);
			String phoneNumber = decimalFormat.format(value);
			switch(random.nextInt(4)) {
				case 0:
					phones[i] = new IPhone();
					phones[i].setNumber("+38063" + phoneNumber);
					break;
				case 1:
					phones[i] = new IPhone5();
					phones[i].setNumber("+38050" + phoneNumber);
					break;
				case 2:
					phones[i] = new SamsungS4();
					phones[i].setNumber("+38097" + phoneNumber);
					break;
				case 3:
					phones[i] = new Nokia3310();
					phones[i].setNumber("+38099" + phoneNumber);
					break;
			}
		}
		
		for (Phone phone : phones) {
			phone.onNetwork();
			phone.activationNumber();
		}
		
		phones[0].call(phones[5].getNumber());
		System.out.println();
		phones[1].call(phones[4].getNumber());
	}

}
