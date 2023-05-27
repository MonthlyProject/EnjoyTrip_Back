package com.ssafy.map.model.service;

import java.util.List;

import com.ssafy.map.model.GugunDto;
import com.ssafy.map.model.MarkerDto;
import com.ssafy.map.model.SidoDto;

public interface MapService {
	List<SidoDto> getSido() throws Exception;
	List<GugunDto> getGugun(int sidoCode) throws Exception;
	List<MarkerDto> getMarker(int area, int areaarea, int type) throws Exception;
}
