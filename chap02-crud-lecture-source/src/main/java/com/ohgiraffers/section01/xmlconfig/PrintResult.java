package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printMenus(List<MenuDTO> menuList) {
        menuList.forEach(System.out::println);
    }

    public void printErrorMessage(String message) {
        System.out.println("에러메시지: "+message);

    }

    public void printMenu(MenuDTO menu) {
        System.out.println("menu = " + menu);
    }

    /* 설명. DML 작업 성공 시 해달 성공 메시지 출력용 메소드*/
    public void printSuccessMessage(String statusCode) {
        String successMessage = "";

        switch (statusCode){
            case "regist": successMessage = "신규 메뉴 등록에 성공하였습니다."; break;
            case "modify": break;
            case "remove":
        }

        System.out.println("successMessage = " + successMessage);

    }
}
