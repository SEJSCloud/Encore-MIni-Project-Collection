package view;

import controller.FruitsController;

public class StartView {
	
	public static void main(String[] args) {
		FruitsController.controller(1);
		FruitsController.controller(4);
		FruitsController.controller(1);
		System.out.println("--- 딸기 검색 ---");
		FruitsController.controller(2);
		FruitsController.controller(5);
		FruitsController.controller(1);
		FruitsController.controller(3);
		FruitsController.controller(1);
		System.out.println("--- 재고량 60 이상 검색 ---");
		FruitsController.controller(6);
	}
}
