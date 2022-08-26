package com.unknown.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "ward")
	private String ward;

	@Column(name = "street")
	private String street;

	@Column(name = "structer")
	private String structer;

	@Column(name = "directions")
	private String directions;

	@Column(name = "numberOfBasement")
	private Integer numberOfBasement;

	@Column(name = "level")
	private String level;

	@Column(name = "discribe")
	private String discribe;

	@Column(name = "status", nullable = true)
	private Integer status;

	@Column(name = "serviceFee")
	private Double serviceFee;

	@Column(name = "carFee")
	private Double carFee;

	@Column(name = "motobikeFee")
	private Double motobikeFee;

	@Column(name = "overtimeFee")
	private Double overtimeFee;

	@Column(name = "electricityBill")
	private Double electricityBill;

	@Column(name = "payment")
	private String payment;

	@Column(name = "managerName")
	private String managerName;

	@Column(name = "managerPhoneNumber")
	private String managerPhoneNumber;

	@Column(name = "brokerFee")
	private Double brokerFee;

	@Column(name = "note")
	private String note;

	@Column(name = "link")
	private String link;

	@Column(name = "map")
	private String map;

	@Column(name = "image")
	private String image;

	@Column(name = "districtId")
	private Integer districtId;

	@Column(name = "buildingTypeId")
	private Integer buildingTypeId;

	@OneToMany(mappedBy = "buildingEntity")
	List<AreaEntity> areaEnties;

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

	public Double getBrokerFee() {
		return brokerFee;
	}

	public void setBrokerFee(Double brokerFee) {
		this.brokerFee = brokerFee;
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

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getBuildingTypeId() {
		return buildingTypeId;
	}

	public void setBuildingTypeId(Integer buildingTypeId) {
		this.buildingTypeId = buildingTypeId;
	}

	public List<AreaEntity> getAreaEnties() {
		return areaEnties;
	}

	public void setAreaEnties(List<AreaEntity> areaEnties) {
		this.areaEnties = areaEnties;
	}

}
