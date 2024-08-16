package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;


    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();
        if(!menuList.isEmpty()){
            printResult.printMenus(menuList);
        }else{
            printResult.printErrorMessage("조회할 메뉴가 없습니다.");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
        int menuCode =Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if(menu != null){
            printResult.printMenu(menu);
        }else{
            printResult.printErrorMessage(menuCode+"번의 메뉴는 없습니다.");
        }
    }

    public void registMenu(Map<String, String> parameter) {
        /* 설명. 사용자가 입력해 넘기 다양한 값들을 파싱하여 하난의 타입으로 넘긴다(가공처리) */
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        if(menuService.registMenu(menu)){
            printResult.printSuccessMessage("regist");
        }else{
            printResult.printErrorMessage("메뉴 추가 실패!");
        }
    }
}
