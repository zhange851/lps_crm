package com.core.service;

import com.core.bean.BaseDict;
import java.util.List;

public interface SystemService {

    //�������Ͳ�ѯ�����ֵ�
    public List<BaseDict> findBaseDictListByType(String typecode);

}