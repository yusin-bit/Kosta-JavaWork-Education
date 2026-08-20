package mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DuplicateModelNoException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//InitInfo.properties
        for(String key : rb.keySet()) {
     	  String value =  rb.getString(key); //100,\uC120\uD48D\uAE30,35000,\uC0BC\uC131 \uC120\uD48D\uAE30
     	   String data[] = value.split(",");
      	     list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
     	    		 Integer.parseInt( data[2]), data[3]) );
     	  
        }
        
        System.out.println("\n========== 초기 전자제품 목록 ==========");
        for (int i = 0; i < list.size(); i++) {
            Electronics electronics = list.get(i);
            System.out.printf(
                    "%d. 모델번호: %d | 제품명: %s | 가격: %,d원 | 설명: %s%n",
                    i + 1,
                    electronics.getModelNo(),
                    electronics.getModelName(),
                    electronics.getModelPrice(),
                    electronics.getModelDetail());
        }
        System.out.println("========================================\n");
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) 
			  throws ElectronicsArrayBoundsException, DuplicateModelNoException {
		  if(list.size() >= MAX_SIZE ) {
	    	   	throw new ElectronicsArrayBoundsException("배열의 길이를 벗어나 더이상 등록 할 수 없습니다.");
	       }
		  for(Electronics existing : list) {
			  if(existing.getModelNo() == electronics.getModelNo()) {
				  throw new DuplicateModelNoException(existing.getModelNo()  + "는 이미 등록된 모델번호입니다.");
					
				}
  	   	}
		  list.add(electronics);
	}

	@Override
	public List<Electronics> selectAll() {
		
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for(Electronics electronics : list) {
			if(electronics.getModelNo() == modelNo) {
				return electronics;
			}
		}
		throw new SearchNotFoundException(modelNo + "는 없는 모델번호로 검색할 수 없습니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		Electronics existing = searchByModelNo(electronics.getModelNo());
		existing.setModelDetail(electronics.getModelDetail());
		
		
		
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		Electronics existing = searchByModelNo(modelNo);
		list.remove(existing);
	}

	@Override
	public List<Electronics> selectSortByPrice() {
		list.sort((o1, o2) -> {
			int comparePrice = o1.getModelPrice() - o2.getModelPrice();
			if(comparePrice == 0) {
				return o1.getModelNo()-o2.getModelNo();
				
			}
			return comparePrice;
		});
		return list;
	}

	@Override
	public List<Electronics> searchByModelName(String modelName) throws SearchNotFoundException {
		List<Electronics> searchList = new ArrayList<Electronics>();

		for (Electronics electronics : list) {
			if (electronics.getModelName().contains(modelName)) {
				searchList.add(electronics);
			}
		}

		if (searchList.size() == 0) {
			throw new SearchNotFoundException(modelName + "인 제품을 찾을 수 없습니다.");
		}

		return searchList;
	}

	@Override
	public int countElectronics() {
		return list.size();
	}
    
} // 클래스 끝 
