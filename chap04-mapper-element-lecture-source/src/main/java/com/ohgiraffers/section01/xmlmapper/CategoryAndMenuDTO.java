package com.ohgiraffers.section01.xmlmapper;


import java.util.List;

public class CategoryAndMenuDTO {
    private int categoryCode;
    private String categoryName;
    private Integer refCategroyCode; // wrapper class형태 nullable

    private List<MenuDTO> menus; //Collection 관계인 경우 속성이 늘어난다

    public CategoryAndMenuDTO() {
    }

    public CategoryAndMenuDTO(int categoryCode, String categoryName, Integer refCategroyCode, List<MenuDTO> menus) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategroyCode = refCategroyCode;
        this.menus = menus;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategroyCode() {
        return refCategroyCode;
    }

    public void setRefCategroyCode(Integer refCategroyCode) {
        this.refCategroyCode = refCategroyCode;
    }

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }
}