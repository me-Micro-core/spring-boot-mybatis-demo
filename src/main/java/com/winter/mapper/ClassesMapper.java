package com.winter.mapper;

import com.winter.model.Classes;

import java.util.List;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    //新添加
    List<Classes> getAll();
}