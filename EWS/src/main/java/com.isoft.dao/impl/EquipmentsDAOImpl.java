package com.isoft.dao.impl;

import com.isoft.dao.IEquipmentsDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentsDAOImpl implements IEquipmentsDAO {
    @Autowired
    SqlSessionFactory sessionFactoryBean;

    @Override
    public List<Map<String, Object>> findAllEquipments(int page, int pageSize) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statement = "com.isoft.mapping.userMapper.findAllEquipments";
        Map map = new HashMap();
        map.put("page", (page-1) * pageSize);
        map.put("pageSize", pageSize);
        List<Map<String, Object>> list = sqlSession.selectList(statement, map);
        return list;
    }

//    @Override
//    public List<Map<String, Object>> equipmentsTotal() {
//        SqlSession sqlSession = sessionFactoryBean.openSession(true);
//        String statement = "com.isoft.mapping.userMapper.userTotal";
//        List<Map<String, Object>> list = sqlSession.selectList(statement);
//        return list;
//    }

    @Override
    public Map<String, Object> findEquipmentsCount() {
        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statement = "com.isoft.mapping.userMapper.findAllEquipments";
            Map map = sqlSession.selectOne(statement);
            System.out.println(map);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public int deleteEquipmentsInfoById(int eq_id) {
        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statement = "com.isoft.mapping.userMapper.deleteEquimentsInfoById";
            int i = sqlSession.delete(statement,eq_id);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
