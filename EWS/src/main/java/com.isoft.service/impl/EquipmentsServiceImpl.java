package com.isoft.service.impl;

import com.isoft.service.IEquimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("equipmentsService")
public class EquipmentsServiceImpl implements IEquimentsService {
    @Override
    public List<Map<String, Object>> findAllEquipments(int page, int pageSize) {
        return null;
    }

    @Override
    public Map<String, Object> findEquipmentsCount() {
        return null;
    }

    @Override
    public int deleteEquipmentsInfoById(int id) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> equipmentsTotal() {
        return null;
    }


}
