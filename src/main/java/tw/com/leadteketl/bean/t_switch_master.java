package tw.com.leadteketl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "t_switch_master")
@ApiModel(description= "代碼轉換主表單")
@Data
public class t_switch_master  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name = "SN", updatable = false, nullable = false, length = 5)
	public Integer sn;

	@ApiModelProperty(value = "專案代碼", required = true)
	@Column(name = "project_id", nullable = false, unique = true, length = 10)
	public String project_id;
	
	@ApiModelProperty(value = "代碼轉換代碼", required = true)
	@Column(name = "switch_id", nullable = false, unique = true, length = 10)
	public String switch_id;
	
	@ApiModelProperty(value = "代碼轉換名稱", required = true)
	@Column(name = "switch_name", nullable = false, length = 255)
	public String switch_name;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name = "state", nullable = false, unique = true, length = 10)
	public String state;
	
	@OneToOne
	@JoinColumn(name = "t_switch_master_project_id",referencedColumnName="project_id")
	public t_project t_project;

}
