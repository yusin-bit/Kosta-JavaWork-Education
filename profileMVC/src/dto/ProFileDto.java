package dto;

public class ProFileDto {

	private String name;
	private int weight;
	private int password;
	
	public ProFileDto() {
	}
	
	public ProFileDto(String name, int weight, int password) {
		this.name = name;
		this.password = password;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}


	public int getWeight() {
		return weight;
	}

	public int getPassword() {
		return password;
	}


}
