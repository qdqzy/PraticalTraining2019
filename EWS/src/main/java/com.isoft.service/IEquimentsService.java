package com.isoft.service;

import java.util.List;
import java.util.Map;

public interface IEquimentsService {
    List<Map<String,Object>> findAllEquipments(int page, int pageSize);
    Map<String,Object> findEquipmentsCount();
    int deleteEquipmentsInfoById(int id);
    List<Map<String,Object>> equipmentsTotal();
}
