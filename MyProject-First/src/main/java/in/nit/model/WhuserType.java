package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "whutab")
@Data
public class WhuserType {
	@Id
	@GeneratedValue
	private Integer whuId;
	private String whuserTyp;
	private String whuCode;
	private String whusefor;
	private String whuEmail;
	private String whucont;
	private String whuIdType;
	private String whuIdNo;







}
