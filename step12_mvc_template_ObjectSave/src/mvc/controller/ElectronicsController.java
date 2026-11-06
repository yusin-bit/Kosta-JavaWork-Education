package mvc.controller;

import java.util.List;

import mvc.dto.Electronics;
import mvc.exception.DuplicateModelNoException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.service.ElectronicsService;
import mvc.service.ElectronicsServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;



/**
 * View와 Model 사이에서 중간 역할 
 *  : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 *    호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
	 private ElectronicsService service = ElectronicsServiceImpl.getInstance();

    /**
     * 전체검색
     */
    public void selectAll() {
		//서비스 호출하고 그결과에 따라 성공  or 실패로 이동
    	List<Electronics> list = service.selectAll();
    	SuccessView.printAll(list);
    }
 

	 /**
     * 전자제품 등록 
     */
   
    public void insert(Electronics electronics) {
		try {
			service.insert(electronics);
			SuccessView.printMessage("등록이 완료 되었습니다");
			
		}
		catch(ElectronicsArrayBoundsException e) {
			FailView.errorMessage(e.getMessage());
		}
 		catch(DuplicateModelNoException e) {
 			FailView.errorMessage(e.getMessage());
 		}
	
    }
    
    

    /**
     * 모델번호에 해당하는 전자제품 검색
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {
    		try {
    			Electronics	electronics= service.searchByModelNo(modelNo);
    			SuccessView.printSearchByModelNo(electronics);
    			
    			}
    		catch(SearchNotFoundException e) {
    			FailView.errorMessage(e.getMessage());
    			}
    } 

    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * @param electronics
     */
    public void update(Electronics electronics) {
    		try {
			service.update(electronics);
			SuccessView.printMessage("수정이 완료되었습니다");
			
    			}
    			catch(SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
    			}
    }
    
    /**
     * 모델번호에 해당하는 전자제품 삭제하기 
     * @param electronics
     */
	public void deleteModelNo(int modelNo) {
		
		try {
			service.delete(modelNo);
			SuccessView.printMessage("삭제가 완료되었습니다");
			
    			}
    			catch(SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
    			}
	}
	
	/**
     *  가격을 기준으로 정렬하기
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return
     */
    public void selectSortByPrice() {
     	List<Electronics> list = service.selectSortByPrice();
    	SuccessView.printAll(list);
    }

    /**
     * 제품 이름으로 검색
     */
    public void searchByModelName(String modelName) {
        try {
            List<Electronics> list = service.searchByModelName(modelName);
            SuccessView.printAll(list);
        } catch (SearchNotFoundException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 등록된 제품 개수 조회
     */
    public void countElectronics() {
        int count = service.countElectronics();
        SuccessView.printMessage("현재 등록된 제품은 " + count + "개입니다.");
    }
    /////////////////////////////////////////////////////////////////////////
    
    //종료 전에 파일 객체에 저장 
    
    public void saveObject() {
    		try {
    			service.saveObject();
    			SuccessView.printMessage("파일이 저장 되었습니다. \n 다음에 또 이용해주세요");
    			
    		}catch (Exception e) {
    			FailView.errorMessage(e.getMessage());
    		}
    	}
    }











