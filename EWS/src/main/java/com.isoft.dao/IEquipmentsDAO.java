package com.isoft.dao;

import java.util.List;
import java.util.Map;

public interface IEquipmentsDAO {
    List<Map<String,Object>> findAllEquipments(int page, int pageSize);
    //List<Map<String,Object>> equipmentsTotal();
    Map<String,Object> findEquipmentsCount();
    int deleteEquipmentsInfoById(int id);

}
