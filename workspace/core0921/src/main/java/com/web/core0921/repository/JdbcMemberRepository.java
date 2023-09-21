package com.web.core0921.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.web.core0921.dto.Member;

//@Repository
public class JdbcMemberRepository implements MemberRepository{
	
	private final DataSource dataSource;
	
	public JdbcMemberRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Member save(Member member) {
		String sql = "INSERT INTO MEMBER VALUES (member_seq.nextval, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String generatedColums[] = {"ID"};
			pstmt = conn.prepareStatement(sql, generatedColums);
			pstmt.setString(1, member.getName());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				member.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("INSERT 실패");
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public List<Member> findAll() {
		String sql = "SELECT * FROM MEMBER";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				memberList.add(member);
			}
			
		} catch (SQLException e) {
			System.out.println("SELECT 실패");
			e.printStackTrace();
		}
		
		return memberList;
	}

}
