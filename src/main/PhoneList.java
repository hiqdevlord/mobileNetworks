package main;

import java.util.Arrays;

public class PhoneList {
	
	private int capacity;
	private int size = 0;
	
	private Phone[] phoneList;
	
	public PhoneList() {
		capacity = 20;
		phoneList = new Phone[capacity];
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(Phone phone) {
		if (find(phone.getNumber()) == -1) {
			if (size == capacity) {
				resize();
			}
			phoneList[size++] = phone;
		} else {
			System.out.println("Номер активирован");
		}
	}
	
	public Phone get(String number) {
		return findPhone(number);
	}
	
	public boolean contains(String number) {
		return find(number) != -1;
	}
	
	public void remove(String number) {
		int index = find(number);
		if (index >= 0 && index < size) {
			if (index < size - 1) {
				System.arraycopy(
					phoneList,
					index + 1,
					phoneList,
					index,
					size - (index + 1)
				);
			}
			phoneList[size - 1] = null;
			size--;
		} else {
			System.out.println("Некоректный индекс");
		}
	}
	
	public String toString() {
		String[] phoneNumberList = new String[size];
		System.arraycopy(this.phoneList, 0, phoneNumberList, 0, size);
		return Arrays.toString(phoneNumberList);
	}
	
	private void resize() {
		Phone[] phoneNumberlist = new Phone[size + capacity];
		System.arraycopy(this.phoneList, 0, phoneNumberlist, 0, size);
		this.phoneList = phoneNumberlist;
		capacity = phoneNumberlist.length;
	}
	
	private int find(String number) {
		if (number == null) return -1;
		for (int i = 0; i < size; i++) {
			if (phoneList[i].getNumber().equals(number))
				return i;
		}
		return -1;
	}
	
	private Phone findPhone(String number) {
		if (number == null) return null;
		for (int i = 0; i < size; i++) {
			if (phoneList[i].getNumber().equals(number))
				return phoneList[i];
		}
		return null;
	}
	
}
