package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "ordertype")
@Data
public class OrderMethodType {

	@Id
	@GeneratedValue(generator = "omid")
	@GenericGenerator(name = "omid",strategy = "increment")
	@Column(name = "orid")
	private Integer orderId;

	@Column(name = "ordMode")
	private String orderMode;
	
	@Column(name = "orcode")
	private String orderCode;

	@Column(name="orMethod")
	private String orderMeth;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name ="ordAccept",joinColumns =@JoinColumn(name = "orid"))
	@OrderColumn(name = "ordname")
	@Column(name = "orderacc")
	private List<String> orderAccept;

	@Column(name="ordesc")
	private String orderDesc;


}
