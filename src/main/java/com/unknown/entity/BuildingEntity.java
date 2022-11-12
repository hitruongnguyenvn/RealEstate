package com.unknown.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Building")
public class BuildingEntity {

	@Id
	@Column(name = "id", columnDefinition = "INT", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", columnDefinition = "NVARCHAR(255)", nullable = false)
	private String name;

	@Column(name = "ward", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String ward;

	@Column(name = "street", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String street;

	@Column(name = "structer", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String structer;

	@Column(name = "directions", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String directions;

	@Column(name = "number_of_basement", columnDefinition = "INT", nullable = true)
	private Integer numberOfBasement;

	@Column(name = "level", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String level;

	@Column(name = "discribe", columnDefinition = "TEXT", nullable = true)
	private String discribe;

	@Column(name = "status", columnDefinition = "INT", nullable = false)
	private Integer status;

	@Column(name = "service_fee", columnDefinition = "FLOAT", nullable = true)
	private Double serviceFee;

	@Column(name = "car_fee", columnDefinition = "FLOAT", nullable = true)
	private Double carFee;

	@Column(name = "motobike_fee", columnDefinition = "FLOAT", nullable = true)
	private Double motobikeFee;

	@Column(name = "overtime_fee", columnDefinition = "FLOAT", nullable = true)
	private Double overtimeFee;

	@Column(name = "electricity_bill", columnDefinition = "FLOAT", nullable = true)
	private Double electricityBill;

	@Column(name = "broker_fee", columnDefinition = "FLOAT", nullable = true)
	private Double brokerFee;

	@Column(name = "payment", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String payment;

	@Column(name = "manager_name", columnDefinition = "NVARCHAR(255)", nullable = true)
	private String managerName;

	@Column(name = "manager_phone_number", columnDefinition = "VARCHAR(255)", nullable = true)
	private String managerPhoneNumber;

	@Column(name = "note", columnDefinition = "TEXT", nullable = true)
	private String note;

	@Column(name = "link", columnDefinition = "TEXT", nullable = true)
	private String link;

	@Column(name = "map", columnDefinition = "TEXT", nullable = true)
	private String map;

	@Column(name = "image", columnDefinition = "TEXT", nullable = true)
	private String image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	private DistrictEntity districtEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "building_type_id", nullable = false)
	private BuildingTypeEntity buildingTypeEntity;

	// 1 building có nhiều area
	@OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, orphanRemoval = true)
	private List<AreaEntity> areaEnties;

	@OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, orphanRemoval = true)
	private List<UsersBuildingEntity> usersBuildingEntities;

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

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStructer() {
		return structer;
	}

	public void setStructer(String structer) {
		this.structer = structer;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(Double serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Double getCarFee() {
		return carFee;
	}

	public void setCarFee(Double carFee) {
		this.carFee = carFee;
	}

	public Double getMotobikeFee() {
		return motobikeFee;
	}

	public void setMotobikeFee(Double motobikeFee) {
		this.motobikeFee = motobikeFee;
	}

	public Double getOvertimeFee() {
		return overtimeFee;
	}

	public void setOvertimeFee(Double overtimeFee) {
		this.overtimeFee = overtimeFee;
	}

	public Double getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(Double electricityBill) {
		this.electricityBill = electricityBill;
	}

	public Double getBrokerFee() {
		return brokerFee;
	}

	public void setBrokerFee(Double brokerFee) {
		this.brokerFee = brokerFee;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}

	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}

	public BuildingTypeEntity getBuildingTypeEntity() {
		return buildingTypeEntity;
	}

	public void setBuildingTypeEntity(BuildingTypeEntity buildingTypeEntity) {
		this.buildingTypeEntity = buildingTypeEntity;
	}

	public List<AreaEntity> getAreaEnties() {
		return areaEnties;
	}

	public void setAreaEnties(List<AreaEntity> areaEnties) {
		this.areaEnties = areaEnties;
	}

	public List<UsersBuildingEntity> getUsersBuildingEntities() {
		return usersBuildingEntities;
	}

	public void setUsersBuildingEntities(List<UsersBuildingEntity> usersBuildingEntities) {
		this.usersBuildingEntities = usersBuildingEntities;
	}

}
