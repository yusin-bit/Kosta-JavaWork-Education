package com.ws03.service;

import java.util.ArrayList;
import java.util.List;

import com.ws03.dto.AccountDto;
import com.ws03.dto.InstallAccountDto;
import com.ws03.dto.LoanAccountDto;
import com.ws03.dto.SavingAccountDto;
import com.ws03.dto.UserDto;

/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 */
public class BankService {

    private List<AccountDto> accountList;
    private List<UserDto> userList;

    /**
     * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 List에 저장한다.
     */
    public BankService() {
        userList = new ArrayList<>();
        accountList = new ArrayList<>();

        // 고객 3명
        userList.add(new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false));
        userList.add(new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true));
        userList.add(new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false));

        // 계좌 7개
        accountList.add(new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000)); // 정기예금계좌
        accountList.add(new SavingAccountDto(10, "00100101001001", 500, 111, 100)); // 저축계좌
        accountList.add(new LoanAccountDto(60, "00600606006006", 500, 333, "House")); // 대출계좌
        accountList.add(new LoanAccountDto(30, "00300303003003", 0, 111, "Building")); // 대출계좌
        accountList.add(new SavingAccountDto(70, "00700707007007", 500, 333, 200)); // 저축계좌
        accountList.add(new LoanAccountDto(50, "00500505005005", 200, 222, "Car")); // 대출계좌
        accountList.add(new SavingAccountDto(40, "00400404004004", 1000, 222, 50)); // 저축계좌
    }

    /**
     * 특정 사용자의 계좌 목록을 List로 리턴한다.
     */
    public List<AccountDto> getAccountList(int userSeq) {
        List<AccountDto> result = new ArrayList<>();

        for (AccountDto accountDto : accountList) {
            if (accountDto.getUserSeq() == userSeq) {
                result.add(accountDto);
            }
        }

        if (result.isEmpty()) {
            return null;
        }

        return result;
    }

    /**
     * 특정 사용자의 고객 정보를 리턴한다.
     */
    public UserDto getUserDetail(int userSeq) {
        for (UserDto userDto : userList) {
            if (userDto.getUserSeq() == userSeq) {
                return userDto;
            }
        }
        return null;
    }

    /**
     * 모든 계좌 목록을 리턴한다.
     */
    public List<AccountDto> getAccountList() {
        return new ArrayList<>(accountList);
    }

    /**
     * 람다식을 이용하여 잔고 기준으로 오름차순 정렬한 계좌 목록을 리턴한다.
     */
    public List<AccountDto> getAccountListSortByBalance() {
        List<AccountDto> result = new ArrayList<>(accountList);
        result.sort((o1, o2) -> Integer.compare(o1.getBalance(), o2.getBalance()));
        return result;
    }

    /**
     * 람다식을 이용하여 userSeq 기준으로 정렬한 계좌 목록을 리턴한다.
     */
    public List<AccountDto> getAccountListSortByUserSeq() {
        List<AccountDto> result = new ArrayList<>(accountList);
        result.sort((o1, o2) -> Integer.compare(o1.getUserSeq(), o2.getUserSeq()));
        return result;
    }
}
