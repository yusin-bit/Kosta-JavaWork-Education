package com.ws03.dto;

/**
 * 고객의 정보를 관리할 객체
 */
public class UserDto {
    private int userSeq;
    private String name;
    private String email;
    private String phone;
    private boolean isSleep;

    public UserDto() {
    }

    public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
        this.userSeq = userSeq;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isSleep = isSleep;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean getisSleep() {
        return isSleep;
    }

	public void setSleep(boolean isSleep) {
		this.isSleep = isSleep;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDto [userSeq=" + userSeq + ", name=" + name + ", email=" + email + ", phone=" + phone + ", isSleep="
				+ isSleep + "]";
	}
}
