package dogprogram;

public class DogService {
	
	Dog [] dogList = new Dog [10];
	int count = 0;
	public void init(Dog [] dogs) {
		for(int i=0; i < dogs.length && i < dogList.length; ++i) {
			dogList[i] = dogs[i];
		    ++count;
		}
	}

	public Dog[] getAll() {
		Dog[] result = new Dog[count];
		System.arraycopy(dogList, 0, result, 0, count);
		return result;
	}

	public Dog[] searchByBreed(String breed) {
		Dog[] matches = new Dog[count];
		int matchCount = 0;
		for (int i = 0; i < count; i++) {
			if (dogList[i].getBreed().equalsIgnoreCase(breed)) {
				matches[matchCount++] = dogList[i];
			}
		}
		Dog[] result = new Dog[matchCount];
		System.arraycopy(matches, 0, result, 0, matchCount);
		return result;
	}

	public boolean insert(Dog dog) {
		if (count >= dogList.length || findByCode(dog.getCode()) != null) return false;
		dogList[count++] = dog;
		return true;
	}

	public Dog findByCode(int code) {
		for (int i = 0; i < count; i++) {
			if (dogList[i].getCode() == code) return dogList[i];
		}
		return null;
	}

	public boolean update(int code, String name, int age, int price, String breed) {
		Dog dog = findByCode(code);
		if (dog == null) return false;
		dog.setName(name);
		dog.setAge(age);
		dog.setPrice(price);
		dog.setBreed(breed);
		return true;
	}
}
