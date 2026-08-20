package dogprogram;
class Dog {
	
	private int code;
    private String name;
    private int age;
    private int price;
    private String breed;
    
    public Dog() {
    	
    }

    public Dog(int code, String name, int age, int price, String breed) {
    	this.code = code;
    	this.name = name;
    	this.age = age;
    	this.price = price;
    	this.breed = breed;
    }
    	
    
   
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getBreed() {
        return breed;
    }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPrice(int price) { this.price = price; }
    public void setBreed(String breed) { this.breed = breed; }

    @Override
    public String toString() {
        return "Dog [code=" + code + ", name=" + name + ", age=" + age
                + ", price=" + price + ", breed=" + breed + "]";
    }
}
