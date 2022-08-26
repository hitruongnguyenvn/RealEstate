package com.unknown.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.unknown.mapper.IRowMapper;

/**
 * 
 * @author TruongNguyen Khi dung @value thì phải có component(yêu cầu bắt buộc
 *         của spring) và phải có @Autowired để khởi tạo đối tượng trong bean
 *         Khởi tạo là chạy từ đầu class đến cuối class chỗ nào cần gán giá trị
 *         thì gán. Ví dụ: @Value("${spring.datasource.url}") private String
 *         URL; Còn khởi tạo vùng nhớ (new) là chỉ cấp phát vùng nhớ chứ không
 *         khởi tạo đối tượng dẫn đến những thuộc tính cần lấy giá trị sẽ không
 *         bị null vì không lấy đc giá trị để gán.
 */
@Component
@PropertySource("classpath:application.properties")
public class DataProviderRepository {

	@Value("${spring.datasource.url}")
	private String URL;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	private Connection connect;
	private PreparedStatement pstmt;
	private ResultSet dataResult;

	public DataProviderRepository() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = null;
			pstmt = null;
			dataResult = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public <T> List<T> executeQuery(String query, IRowMapper<T> rowMapper, Object[] parameter) {
		List<T> convertResult = new ArrayList<>();
		try {
			this.connect = DriverManager.getConnection(URL, userName, password);
			this.pstmt = connect.prepareStatement(query);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					this.pstmt.setObject(i + 1, parameter[i]);
				}
			}
			this.dataResult = this.pstmt.executeQuery();
			while (this.dataResult.next()) {
				convertResult.add(rowMapper.mapRow(this.dataResult));
			}
			return convertResult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					this.dataResult.close();
				}
				if (pstmt != null) {
					this.pstmt.close();
				}
				if (connect != null) {
					this.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return convertResult;
	}

	public Integer executeNonQuery(String query, Object[] parameter) {
		Integer data = null;
		try {
			this.connect = DriverManager.getConnection(URL);
			connect.setAutoCommit(false);
			pstmt = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					pstmt.setObject(i + 1, parameter[i]);
				}
			}
			pstmt.executeUpdate();
			dataResult = pstmt.getGeneratedKeys();
			if (dataResult.next()) {
				data = dataResult.getInt(1);
			}
			connect.commit();
			return data;
		} catch (SQLException e) {
			if (connect != null) {
				try {
					connect.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (dataResult != null) {
					this.dataResult.close();
				}
				if (pstmt != null) {
					this.pstmt.close();
				}
				if (connect != null) {
					this.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public Object executeScalar(String query, Object[] parameter) {
		Object data = null;
		try {
			this.connect = DriverManager.getConnection(URL);
			pstmt = connect.prepareStatement(query);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					pstmt.setObject(i + 1, parameter[i]);
				}
			}
			data = pstmt.executeQuery().next();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					this.dataResult.close();
				}
				if (pstmt != null) {
					this.pstmt.close();
				}
				if (connect != null) {
					this.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public int count(String query, Object[] parameter) {
		int data = 0;
		try {
			this.connect = DriverManager.getConnection(URL);
			pstmt = connect.prepareStatement(query);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					pstmt.setObject(i + 1, parameter[i]);
				}
			}
			dataResult = pstmt.executeQuery();
			if (dataResult.next()) {
				data = dataResult.getInt(1);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					this.dataResult.close();
				}
				if (pstmt != null) {
					this.pstmt.close();
				}
				if (connect != null) {
					this.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
