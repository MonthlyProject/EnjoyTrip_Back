package com.ssafy.map.model.service;

import java.util.List;

import com.ssafy.map.model.GugunDto;
import com.ssafy.map.model.MarkerDto;
import com.ssafy.map.model.SidoDto;
import com.ssafy.map.model.dao.MapDao;
import com.ssafy.map.model.dao.MapDaoImpl;

public class MapServiceImpl implements MapService {
	
	private static MapService mapService = new MapServiceImpl();
	private MapDao mapDao;
	
	private MapServiceImpl() {
		mapDao = MapDaoImpl.getMapDao();
	}
	
	public static MapService getMapService() {
		return mapService;
	}

	//서울, 인천, 부산, 대구... : 검색의 선택박스에 넣을 데이터 가져오기
	@Override
	public List<SidoDto> getSido() throws Exception {
		return mapDao.getSido();
	}

	@Override
	public List<GugunDto> getGugun(int sidoCode) throws Exception {
		return mapDao.getGugun(sidoCode);
	}

	@Override
	public List<MarkerDto> getMarker(int area, int areaarea, int type) throws Exception {
		return mapDao.getMarker(area, areaarea, type);
	}

}
