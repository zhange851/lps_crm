package com.core.dao;

import com.core.bean.BaseDict;

import java.util.List;

public interface BaseDictDao {

    //根据数据字典类别代码查询
    List<BaseDict> selectByTypecode(String typecode);
    //根据数据字典ID查询
    BaseDict selectByPrimaryKey(String dictId);

}