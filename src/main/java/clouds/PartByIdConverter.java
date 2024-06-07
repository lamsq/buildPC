package clouds;

import java.util.*;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import clouds.Part.Type;
import clouds.Part;

@Component
public class PartByIdConverter implements Converter<String, Part>{
	
	private Map<String, Part> partMap = new HashMap<>();

	public PartByIdConverter() {
		
		partMap.put("i5", new Part(Part.Type.CPU, "i5", "intel", 50.99, 1));
		partMap.put("rtx4060", new Part(Part.Type.GPU, "rtx4060", "nvidia", 300, 2));
		partMap.put("512", new Part(Part.Type.SSD, "512", "kingston", 150, 3));
		partMap.put("32", new Part(Part.Type.RAM, "32", "kingston", 135 , 4));
		partMap.put("breeze", new Part(Part.Type.COOLER, "breeze", "noctua", 40, 5));
		
	}



	public Part convert(String id) {
		return partMap.get(id);
	}
}
