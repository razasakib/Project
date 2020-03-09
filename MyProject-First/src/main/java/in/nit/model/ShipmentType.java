package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shiptab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer shipId;

	@Column(name="smode")
	private String shipMod;
	
	@Column(name="scode")
	private String shipCode;
	
	@Column(name="enbship")
	private String enbShip;
	
	@Column(name="sgrade")
	private String shipGrd;
	
	@Column(name="sdesc")
	private String shipDesc;
	
	public ShipmentType() {
		super();
	}
	
	public ShipmentType(Integer shipId) {
		super();
		this.shipId = shipId;
	}

	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	public String getShipCode() {
		return shipCode;
	}
	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}
	public String getEnbShip() {
		return enbShip;
	}
	public void setEnbShip(String enbShip) {
		this.enbShip = enbShip;
	}
	public String getShipGrd() {
		return shipGrd;
	}
	public void setShipGrd(String shipGrd) {
		this.shipGrd = shipGrd;
	}
	public String getShipDesc() {
		return shipDesc;
	}
	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}
	public String getShipMod() {
		return shipMod;
	}
	public void setShipMod(String shipMod) {
		this.shipMod = shipMod;
	}
	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipCode=" + shipCode + ", enbShip=" + enbShip + ", shipGrd="
				+ shipGrd + ", shipDesc=" + shipDesc + "]";
	}


}
