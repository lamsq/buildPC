package clouds;

import java.util.ArrayList;

import lombok.Data;


@Data
public class Order {
	
	private String recepientName;
	private double totalPrice;
	private int id;
	
	private String country;
	private String city;
	private String street;
	private String zip;
	
	private String cardNum;
	private String cardExpDate;
	private String cardCvv;
	
	private ArrayList<Pc> pc;
	
	public void addPc(Pc pc) {
		this.pc.add(pc);
	}

}
