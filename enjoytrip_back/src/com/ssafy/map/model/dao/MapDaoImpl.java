package com.ssafy.map.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.map.model.GugunDto;
import com.ssafy.map.model.MarkerDto;
import com.ssafy.map.model.SidoDto;
import com.ssafy.util.DBUtil;

public class MapDaoImpl implements MapDao{
	private static MapDao mapDao = new MapDaoImpl();
	private DBUtil dbUtil;
	
	private MapDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MapDao getMapDao() {
		return mapDao;
	}

	@Override
	public List<SidoDto> getSido() throws Exception {
		List<SidoDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from sido \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SidoDto sidoDto = new SidoDto();
				sidoDto.setSidoCode(rs.getInt("sido_code"));
				sidoDto.setSidoName(rs.getString("sido_name"));
				list.add(sidoDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<GugunDto> getGugun(int sidoCode) throws Exception {
		List<GugunDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from gugun \n");
			sql.append("where sido_code=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sidoCode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GugunDto gugunDto = new GugunDto();
				gugunDto.setGugunCode(rs.getInt("gugun_code"));
				gugunDto.setGugunName(rs.getString("gugun_name"));
				list.add(gugunDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<MarkerDto> getMarker(int area, int areaarea, int type) throws Exception {
		List<MarkerDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select content_type_id, title, addr1, addr2, first_image, readcount, latitude, longitude  \n");
			sql.append("from attraction_info \n");
			sql.append("where sido_code=? ");
			if(areaarea!=0)
				sql.append("and gugun_code=? ");
			if(type!=0)
				sql.append("and content_type_id=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, area);
			if(areaarea!=0 && type!=0) {
				pstmt.setInt(2, areaarea);
				pstmt.setInt(3, type);
			}
			else if(areaarea==0 && type!=0) {
				pstmt.setInt(2, type);
			}
			else if(areaarea!=0 && type==0) {
				pstmt.setInt(2, areaarea);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MarkerDto markerDto = new MarkerDto();
				markerDto.setContentTypeId(rs.getInt("content_type_id"));
				markerDto.setTitle(rs.getString("title"));
				markerDto.setAddr1(rs.getString("addr1"));
				markerDto.setAddr2(rs.getString("addr2"));
				markerDto.setFirstImage(rs.getString("first_image"));
				markerDto.setReadcount(rs.getInt("readcount"));
				markerDto.setLatitude(rs.getDouble("latitude"));
				markerDto.setLongitude(rs.getDouble("longitude"));
				list.add(markerDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}
}
