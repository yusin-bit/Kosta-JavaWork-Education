package presentation;

import java.util.*;

class OrderService {

    private List<Integer> orders =
            new ArrayList<>(List.of(1001, 1002, 1003));

    private int expectedOrder = 1001;

    // 주문 처리 책임
    public void processNextOrder() {

        int orderNo = orders.remove(0);

        if (orderNo != expectedOrder) {
            throw new IllegalStateException("주문 처리 순서 오류");
        }

        expectedOrder++;

        System.out.println(orderNo + "번 주문 처리 완료");
    }

    // 원본이 아닌 복사본 전달
    public List<Integer> getOrders() {
        return new ArrayList<>(orders);
    }
}


class OrderView {

    // 화면 출력 책임
    public void showOrders(List<Integer> orders) {

        orders.sort(Comparator.reverseOrder());

        System.out.println("주문 목록 : " + orders);
    }
}


public class Main {

    public static void main(String[] args) {

        OrderService service = new OrderService();
        OrderView view = new OrderView();

        view.showOrders(service.getOrders());

        service.processNextOrder();
    }
}