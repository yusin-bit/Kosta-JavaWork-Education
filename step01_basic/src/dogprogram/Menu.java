package dogprogram;
import java.util.Scanner;

class Menu {
	private final DogService dogService;

	Menu(DogService dogService) {
		this.dogService = dogService;
	}

    public void menu() {

        Scanner sc = new Scanner(System.in);

        loop:
        while (true) {

            System.out.println("---------강아지 구매 프로그램---------");
            System.out.println("0. 전체 강아지 보기 1. 품종 검색  2. 결제  3. 강아지 등록 4. 강아지 정보 수정 5. 종료");
            System.out.println("----------------------------------");

			int select = Integer.parseInt(sc.nextLine());

            switch (select) {

            	case 0:
					printDogs(dogService.getAll());
            		break;
            
                case 1:
					System.out.print("검색할 품종: ");
					printDogs(dogService.searchByBreed(sc.nextLine()));
                    break;

                case 2:
					System.out.print("구매할 강아지 코드: ");
					Dog selected = dogService.findByCode(Integer.parseInt(sc.nextLine()));
					System.out.println(selected == null ? "해당 강아지가 없습니다." : selected + " 구매 금액: " + selected.getPrice() + "원");
                    break;
                    
                case 3:
					System.out.print("코드 이름 나이 가격 품종을 공백으로 입력: ");
					String[] values = sc.nextLine().split("\\s+");
					Dog dog = new Dog(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]);
					System.out.println(dogService.insert(dog) ? "등록되었습니다." : "등록할 수 없습니다.");
                    break;
                    
                case 4:
					System.out.print("코드 이름 나이 가격 품종을 공백으로 입력: ");
					String[] update = sc.nextLine().split("\\s+");
					boolean updated = dogService.update(Integer.parseInt(update[0]), update[1], Integer.parseInt(update[2]), Integer.parseInt(update[3]), update[4]);
					System.out.println(updated ? "수정되었습니다." : "해당 강아지가 없습니다.");
                    break;
                    
                case 5:
                    System.out.println("이용해 주셔서 감사합니다.");
                    break loop;

                default:
                    System.out.println("0~5번을 입력해 주세요.");
            }
        }
    }

	private void printDogs(Dog[] dogs) {
		if (dogs.length == 0) {
			System.out.println("조회 결과가 없습니다.");
			return;
		}
		for (Dog dog : dogs) System.out.println(dog);
	}
}
