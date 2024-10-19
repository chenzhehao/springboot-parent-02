package com.chenzhehao.test.springbootmoredatasourcedynamic.infrastructure.persistence.mapper;

import com.chenzhehao.test.springbootmoredatasourcedynamic.infrastructure.persistence.dao.CzhTableTest;

public interface CzhTableTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CzhTableTest record);

    int insertSelective(CzhTableTest record);

    CzhTableTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CzhTableTest record);

    int updateByPrimaryKey(CzhTableTest record);

    CzhTableTest queryByUuid(String uuid);
}