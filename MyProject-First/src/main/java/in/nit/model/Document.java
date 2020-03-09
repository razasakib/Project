package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "docstab")
public class Document {
	@Id
	@Column(name ="fid")
	private Integer fileId;
	private String fname;
	@Lob
	@Column(name = "fdata")
	private byte[] fileData;

}
