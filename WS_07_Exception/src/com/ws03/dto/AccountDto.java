package com.ws03.dto;

/**
 * 고객의 계좌정보 관리하는 객체
 */
public class AccountDto {

    private int accountSeq;      // 일련 번호
    private String accountNumber; // 계좌 번호
    private int balance;         // 잔고
    private int userSeq;         // 고객 번호

    public AccountDto() {
    }

    public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
        this.accountSeq = accountSeq;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.userSeq = userSeq;
    }

    public int getAccountSeq() {
        return accountSeq;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getUserSeq() {
        return userSeq;
    }


    public void setAccountSeq(int accountSeq) {
		this.accountSeq = accountSeq;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	@Override
    public String toString() {
        return "AccountDto [accountSeq=" + accountSeq
                + ", accountNumber=" + accountNumber
                + ", balance=" + balance
                + ", userSeq=" + userSeq + "]";
    }
}
