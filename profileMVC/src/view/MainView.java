package view;

import java.io.IOException;
import java.util.Scanner;

import dto.ProFileDto;
import exception.ProfileAlreadyExistsException;
import exception.ProfileNotFoundException;
import service.ProFileService;
import service.ProFileServiceImpl;

public class MainView {

    public static void main(String[] args) {
        ProFileService service = new ProFileServiceImpl();
        Scanner sc = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("\n다음 사항에 맞게 입력하여 주십시오");
            System.out.println("몸무게 입력은 1번");
            System.out.println("몸무게 검색은 2번");
            System.out.println("몸무게 변경은 3번");
            System.out.println("비밀번호변경은 4번");
            System.out.println("프로그램 종료는 5번");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();

            switch (menu) {
            case 1:
                System.out.println("이름을 입력하여 주십시오.");
                System.out.print("이름 : ");
                String name = sc.next();

                System.out.println("몸무게를 입력하여 주십시오");
                System.out.print("몸무게 : ");
                int weight = sc.nextInt();

                System.out.println("비밀번호를 입력하여 주십시오");
                System.out.print("비밀번호 : ");
                int password = sc.nextInt();

                try {
                    service.saveprofile(new ProFileDto(name, weight, password));
                } catch (ProfileAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println("프로필 저장중 오류가 발생했습니다");
                }
                break;

            case 2:
                System.out.println("이름을 입력하여 주십시오");
                System.out.print("이름 : ");
                String searchName = sc.next();

                try {
                    ProFileDto dto = service.loadprofile(searchName);

                    boolean success = false;
                    for (int count = 1; count <= 3; count++) {
                        System.out.println("비밀번호를 입력하여 주십시오");
                        System.out.print("비밀번호 : ");
                        int inputPassword = sc.nextInt();

                        if (dto.getPassword() == inputPassword) {
                            System.out.println("***************************************");
                            System.out.println("현재 " + dto.getName() + "님의 몸무게는 "
                                    + dto.getWeight() + " Kg 입니다.");
                            System.out.println("***************************************");
                            success = true;
                            break;
                        } else {
                            System.out.println("비밀번호가 일치하지 않습니다.");
                        }
                    }

                    if (!success) {
                        System.out.println("비밀번호를 3회 틀렸습니다. 처음 메뉴로 돌아갑니다.");
                    }

                } catch (ProfileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println("프로필 불러오기 중 오류가 발생했습니다.");
                }
                break;

            case 3:
                System.out.println("이름을 입력하여 주십시오.");
                System.out.print("이름 : ");
                String weightName = sc.next();

                try {
                    ProFileDto dto = service.loadprofile(weightName);

                    System.out.println("비밀번호를 입력하여 주십시오");
                    System.out.print("비밀번호 : ");
                    int weightPassword = sc.nextInt();

                    if (dto.getPassword() == weightPassword) {
                        System.out.println("***************************************");
                        System.out.println("현재 " + dto.getName() + "님의 몸무게는 "
                                + dto.getWeight() + " Kg 입니다.");
                        System.out.println("***************************************");
                        System.out.println("변경할 몸무게를 입력하여 주십시오.");
                        System.out.print("변경할 몸무게 : ");
                        int newWeight = sc.nextInt();

                        service.updateWeight(weightName, newWeight);
                        System.out.println("몸무게가 변경되었습니다.");
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }

                } catch (ProfileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println("몸무게 변경 중 오류가 발생했습니다.");
                }
                break;

            case 4:
                System.out.println("이름을 입력하여 주십시오.");
                System.out.print("이름 : ");
                String passwordName = sc.next();

                try {
                    ProFileDto dto = service.loadprofile(passwordName);

                    System.out.println("비밀번호를 입력하여 주십시오");
                    System.out.print("비밀번호 : ");
                    int oldPassword = sc.nextInt();

                    if (dto.getPassword() == oldPassword) {
                        System.out.println("***************************************");
                        System.out.println("현재 " + dto.getName() + "님의 비밀번호는 "
                                + dto.getPassword() + " 입니다.");
                        System.out.println("***************************************");
                        System.out.println("변경할 비밀번호를 입력하여 주십시오.");
                        System.out.print("변경할 비밀번호 : ");
                        int newPassword = sc.nextInt();

                        service.updatePassword(passwordName, newPassword);
                        System.out.println("비밀번호가 변경되었습니다.");
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }

                } catch (ProfileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println("비밀번호 변경 중 오류가 발생했습니다.");
                }
                break;

            case 5:
                System.out.println("프로그램을 종료합니다.");
                break loop;

            default:
                System.out.println("1~5번 중에서 선택해 주세요.");
            }
        }

        sc.close();
    }
}
