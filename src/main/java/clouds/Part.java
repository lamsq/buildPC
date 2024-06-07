package clouds;

import lombok.Data;

@Data
public class Part {
	
	private final Type type;
	private final String model;
	private final String manufacturer;
	private final double price;
	private final int id;
	
	public enum Type {
		CASE, POWER_SUPPLY, MOTHERBOARD, CPU, GPU, COOLER, ETHERNET_ADAPTER, SOUND_CARD, HDD, SSD, RAM, CD_ROM, DVD_ROM, CARD_READER
	}

}
