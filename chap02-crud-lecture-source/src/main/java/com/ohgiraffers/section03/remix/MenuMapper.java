package com.ohgiraffers.section03.remix;

import org.apache.ibatis.annotations.*;

import java.util.List;

/* 설명. DAO(또는 Repository) 계층에 해당하는 인터페이스이자 Mapper의 의미를 가진다. */
public interface MenuMapper {
    List<MenuDTO> selectAllMenus();
    MenuDTO selectMenu(int menuCode);
    int insertMenu(MenuDTO menu);
    int updateMenu(MenuDTO menu);
    int deleteMenu(int menuCode);
}