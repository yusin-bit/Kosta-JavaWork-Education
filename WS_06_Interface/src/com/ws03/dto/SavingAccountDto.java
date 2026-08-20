package com.ws03.dto;

public class SavingAccountDto extends AccountDto {
	
	private int transferFee;

	public int getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}

	public SavingAccountDto() {
		super();
	}

	public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int transferFee) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.transferFee = transferFee;
	}

	@Override
	public String toString() {
		return super.toString() + " SavingAccountDto [transferFee=" + transferFee + "]";
	}	
		
	
}
	 
