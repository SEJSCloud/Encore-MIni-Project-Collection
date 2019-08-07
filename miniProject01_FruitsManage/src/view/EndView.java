package view;

import model.domain.Fruits;

public class EndView {
	
	public static void printAll(Fruits [] v) {
		for(Fruits a : v) {
			if(a != null) {
				System.out.println(a.toString());
			}
		}
	}
	
	public static void printInfo(Fruits v) {
		System.out.println(v.toString());
	}
	
	public static void PrintInven(Fruits [] v) {
		for(Fruits a : v) {
			if(a != null) {
				System.out.println(a.toString());
			}
		}
	}
}