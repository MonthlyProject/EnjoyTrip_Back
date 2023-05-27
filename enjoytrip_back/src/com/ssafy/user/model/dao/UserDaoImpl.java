package com.ssafy.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.user.model.UserDto;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	private DBUtil dbUtil;
	private static UserDao instance;
	private UserDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public int signUp(UserDto user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into `user` \n");
			sql.append("values(?,?,?,?,?) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getEmailId());
			pstmt.setString(5, user.getEmailDomain());
			return pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		
	}

	@Override
	public UserDto signIn(UserDto user) throws SQLException {
		UserDto res = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select `user_id`, `user_pwd` \n");
			sql.append("from `user` \n");
			sql.append("where `user_id` = ? and `user_pwd` = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPwd());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = new UserDto();
				res.setUserId(rs.getString(1));
				res.setUserPwd(rs.getString(2));
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		
		return res;
	}

}
