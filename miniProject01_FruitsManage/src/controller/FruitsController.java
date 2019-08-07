package controller;

import log.check.Log4J;
import model.FruitsModel;
import model.domain.Fruits;
import view.EndView;

public class FruitsController {
	
	static Log4J log = Log4J.getInstance();
	
	public static void controller(int request) {
		
			//전체 검색
		if(request == 1){  
			System.out.println(log.now());
			EndView.printAll(FruitsModel.getAll());
			
			//개별 검색
		}else if(request == 2){	
			EndView.printInfo(FruitsModel.getOne("딸기"));
			
			//삭제
		}else if(request == 3){ 
			System.out.println(log.disappear());
			FruitsModel.delete("자두");
			
			//물량 입고
		}else if(request == 4){ 
			System.out.println(log.upDateInven());
			FruitsModel.edit("수박", 30);
			
			//품목 입고
		}else if(request == 5){	
			System.out.println(log.upDate());
			FruitsModel.insert(new Fruits("자두", 75));
			
			//기준 재고 이상 검색
		}else if(request == 6){	
			EndView.PrintInven(FruitsModel.checkInven(60));
		}
	}
}