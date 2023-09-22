package com.training.membership.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.membership.dto.*;

@Repository
public class JdbcPersonRepository implements PersonRepository{
	
	private DataSource dataSource;
	
	@Autowired
	public JdbcPersonRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public int join(PersonJoinForm form) {
		System.out.println("@Repository" + form.toString());
		
		final String sql = "insert into person values(0, ?, ?, ?, ?, ?, ?, ?, ? , ?)";
		int idx = -1;
		
		try (Connection conn = dataSource.getConnection()){
			// insert문으로 생성된 데이터의 컬럼의 값을 반환 받는다.
			String generatedColums[] = {"idx", "name"};
			PreparedStatement pstmt = conn.prepareStatement(sql, generatedColums);
			pstmt.setString(1, form.getUserid());
			pstmt.setString(2, form.getUserpwd());
			pstmt.setString(3, form.getName());
			pstmt.setString(4, form.getBirthday());
			pstmt.setString(5, form.getGender());
			pstmt.setString(6, form.getPhone());
			pstmt.setString(7, form.getEmail());
			pstmt.setString(8, form.getPostcode());
			pstmt.setString(9, form.getAddress() + form.getDetailAddress() + form.getExtraAddress());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) idx = rs.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return idx;
	}

	@Override
	public Person login(String id, String password) {
		System.out.println("@Repository" + " id : "+ id + "password : "+ password);
		
		final String sql = "select * from person p where p.id = ? and p.password = ?";
		Person person = new Person();
		
		try(Connection conn = dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsd = rs.getMetaData();
			for(int i = 1, cc = rsd.getColumnCount(); i <= cc; i++) 
				System.out.printf("● %s [%s]\n" ,rsd.getColumnName(i), rsd.getColumnTypeName(i));
			
			if(rs.next()) {
				person.setIdx(rs.getInt(1));
				person.setId(rs.getString(2));
				person.setPassword(rs.getString(3));
				person.setName(rs.getString(4));
				person.setBirthday(rs.getString(5));
				person.setGender(rs.getString(6));
				person.setPhone(rs.getString(7));
				person.setEmail(rs.getString(8));
				person.setPostcode(rs.getString(9));
				person.setAddress(rs.getString(10));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return person;
	}

	@Override
	public List<String> searchId(String email) {
		System.out.println("@Repository" + " email : "+ email);
		
		final String sql = "select p.id from person p where p.email = ?";
		List<String> list = new ArrayList<>();
		
		try(Connection conn = dataSource.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) list.add(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
