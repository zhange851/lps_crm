package com.core.dao;

import com.core.bean.BaseDict;

import java.util.List;

public interface BaseDictDao {

    //���������ֵ��������ѯ
    List<BaseDict> selectByTypecode(String typecode);
    //���������ֵ�ID��ѯ
    BaseDict selectByPrimaryKey(String dictId);

}