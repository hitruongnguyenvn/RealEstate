package com.unknown.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class RoleEntity {

	@Id
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String name;

	@Column(name = "code", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
	private String code;

	@OneToMany(mappedBy = "roleEntity", fetch = FetchType.LAZY)
	private List<UsersEntity> usersEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UsersEntity> getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(List<UsersEntity> usersEntity) {
		this.usersEntity = usersEntity;
	}

}
