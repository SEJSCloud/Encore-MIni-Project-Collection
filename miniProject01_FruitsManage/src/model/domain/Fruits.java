package model.domain;

public class Fruits {
	
	private String name;
	private int inven;
	
	public Fruits() {}
	public Fruits(String name, int inven) {
		this.name = name;
		this.inven = inven;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInven() {
		return inven;
	}
	public void setInven(int inven) {
		this.inven = inven;
	}
	public String toString() {
		return name + " " + inven;
	}
}