package com.core.dao;

import com.core.bean.BaseDict;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml"})
public class BaseDictDaoTest {

    @Resource
    private  BaseDictDao BaseDictDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectByTypecode() {
        String code="002";
        List<BaseDict> dictList = new ArrayList<BaseDict>();
        dictList = BaseDictDao.selectByTypecode(code);
        System.out.println(dictList);
    }

    @Test
    public void selectByPrimaryKey() {
        String dict_id = "6";
        BaseDict dict = BaseDictDao.selectByPrimaryKey(dict_id);
        System.out.println(dict);

    }
}