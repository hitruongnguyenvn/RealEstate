package com.unknown.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "UsersBuilding", uniqueConstraints = @UniqueConstraint(columnNames = { "users_id", "building_id" }))
@Table(name = "UsersBuilding")
public class UsersBuildingEntity {

	@Id
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false)
	private UsersEntity usersEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "building_id", nullable = false)
	private BuildingEntity buildingEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

	public BuildingEntity getBuildingEntity() {
		return buildingEntity;
	}

	public void setBuildingEntity(BuildingEntity buildingEntity) {
		this.buildingEntity = buildingEntity;
	}

}
