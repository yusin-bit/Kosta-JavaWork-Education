package ex0729pratice;

import java.util.Scanner;


// 주문과 계산을 담당하는 클래스
class CafeOrder {

    // 음료 번호를 받아서 음료 한 잔의 가격을 반환하는 메서드
    private int getPrice(int menuNumber) {

        switch (menuNumber) {

        case 1:
            return 3000;

        case 2:
            return 4000;

        case 3:
            return 4500;

        default:
            return 0;
        }
    }


    // 음료 번호를 받아서 음료 이름을 반환하는 메서드
    private String getDrinkName(int menuNumber) {

        switch (menuNumber) {

        case 1:
            return "아메리카노";

        case 2:
            return "카페라테";

        case 3:
            return "바닐라라테";

        default:
            return "없는 음료";
        }
    }


    // 한 잔 가격과 수량을 받아서 해당 주문 금액을 반환하는 메서드
    private int getOrderPrice(int price, int count) {

        return price * count;
    }


    // 총 주문 금액을 받아서 할인 금액을 반환하는 메서드
    private int getDiscount(int totalPrice) {

        if (totalPrice >= 10000) {

            return totalPrice / 10;
        }

        return 0;
    }


    // 총 주문 금액과 할인 금액을 받아서 최종 결제 금액을 반환하는 메서드
    private int getFinalPrice(int totalPrice, int discount) {

        return totalPrice - discount;
    }


    // 음료 하나의 주문을 처리하고 해당 주문 금액을 반환하는 메서드
    public int addOrder(int menuNumber, int count) {

        int price = getPrice(menuNumber);

        if (price == 0) {

            System.out.println("없는 음료 번호입니다.");

            return 0;
        }

        if (count <= 0) {

            System.out.println("수량은 1개 이상 입력해야 합니다.");

            return 0;
        }

        String drinkName = getDrinkName(menuNumber);

        int orderPrice = getOrderPrice(price, count);

        System.out.println();
        System.out.println(drinkName + " " + count + "개가 주문되었습니다.");
        System.out.println("한 잔 가격 : " + price + "원");
        System.out.println("이번 주문 금액 : " + orderPrice + "원");

        return orderPrice;
    }


    // 전체 주문이 끝난 후 최종 영수증을 출력하는 메서드
    public void printReceipt(String customerName, int totalPrice) {

        int discount = getDiscount(totalPrice);

        int finalPrice = getFinalPrice(totalPrice, discount);

        System.out.println();
        System.out.println("========== 최종 영수증 ==========");
        System.out.println("고객 이름 : " + customerName);
        System.out.println("총 주문 금액 : " + totalPrice + "원");
        System.out.println("할인 금액 : " + discount + "원");
        System.out.println("최종 결제 금액 : " + finalPrice + "원");
        System.out.println("================================");
        System.out.println();
    }
}


// 실행을 담당하는 클래스
 	class CafeOrderMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CafeOrder order = new CafeOrder();


        // 카페 프로그램 전체를 반복하는 반복문
        while (true) {

            System.out.println("========== 카페 주문 프로그램 ==========");
            System.out.println("1. 음료 주문");
            System.out.println("2. 프로그램 종료");
            System.out.print("메뉴 선택 : ");

            int mainMenu = sc.nextInt();


            switch (mainMenu) {

            case 1:

                System.out.print("고객 이름 : ");
                String customerName = sc.next();

                int totalPrice = 0;


                // 여러 종류의 음료를 계속 주문할 수 있게 하는 반복문
                while (true) {

                    System.out.println();
                    System.out.println("============ 음료 메뉴 ============");
                    System.out.println("1. 아메리카노  3000원");
                    System.out.println("2. 카페라테    4000원");
                    System.out.println("3. 바닐라라테  4500원");
                    System.out.println("0. 주문 완료");
                    System.out.println("==================================");
                    System.out.print("음료 번호 선택 : ");

                    int menuNumber = sc.nextInt();


                    // 0번을 입력하면 음료 주문 반복문 종료
                    if (menuNumber == 0) {

                        break;
                    }


                    // 없는 음료 번호를 입력한 경우
                    if (menuNumber < 1 || menuNumber > 3) {

                        System.out.println("없는 음료 번호입니다.");
                        System.out.println("0번부터 3번 중에서 선택해 주세요.");

                        continue;
                    }


                    System.out.print("주문 수량 : ");
                    int count = sc.nextInt();


                    // 수량이 0 이하인 경우
                    if (count <= 0) {

                        System.out.println("수량은 1개 이상 입력해야 합니다.");

                        continue;
                    }


                    // 선택한 음료의 주문 금액을 받아옴
                    int orderPrice = order.addOrder(menuNumber, count);


                    // 기존 총금액에 이번 주문 금액을 더함
                    totalPrice = totalPrice + orderPrice;
                }


                // 주문한 음료가 하나도 없는 경우
                if (totalPrice == 0) {

                    System.out.println("주문한 음료가 없습니다.");

                } else {

                    order.printReceipt(customerName, totalPrice);
                }

                break;


            case 2:

                System.out.println("카페 주문 프로그램을 종료합니다.");

                sc.close();

                return;


            default:

                System.out.println("1번 또는 2번을 선택해 주세요.");
            }
        }
    }
}