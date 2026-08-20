package ex0814.set;

import java.util.Objects;

public class Member {
	private String name;
	private int age;
	private String addr;
	
	
	public Member(String name, int age, String addr) {
	    this.name = name;
	    this.age = age;
	    this.addr = addr;
	}	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Member m) {
			return name.equals(m.getName())
			&& age == m.getAge();
		}
			
		return false;
	}
	
	
}
	

