package com.core.service.impl;

import com.core.bean.BaseDict;
import com.core.dao.BaseDictDao;
import com.core.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    private BaseDictDao baseDictDao;
    //�������ͱ�Ų�ѯ�����ֵ�
    public List<BaseDict> findBaseDictListByType(String typecode) {
        return baseDictDao.selectByTypecode(typecode);
    }
}
