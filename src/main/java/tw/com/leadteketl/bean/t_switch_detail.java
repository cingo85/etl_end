package tw.com.leadteketl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="t_switch_detail")
@ApiModel(description= "代碼轉換內容表單")
@Data
public class t_switch_detail  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name="sn",updatable = false,nullable = false,length=5)
	public Integer sn;
	
	@ApiModelProperty(value = "專案代碼", required = true)
	@Column(name="project_id",nullable = false,unique=true,length=10)
	public String project_id;
	
	@ApiModelProperty(value = "代碼轉換代碼", required = true)
	@Column(name="switch_id",nullable = false,unique=true,length=10)
	public String switch_id;
	
	@ApiModelProperty(value = "被轉換代碼", required = true)
	@Column(name="code",nullable = false,unique=true,length=255)
	public String code;
	
	@ApiModelProperty(value = "轉換代碼", required = true)
	@Column(name="name",nullable = false,length=255)
	public String name;
	
	@ApiModelProperty(value = "備註", required = true)
	@Column(name="note",length=255)
	public String note;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="state",nullable = false,length=10)
	public String state;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "t_switch_detail_project_id", referencedColumnName = "project_id"),
		@JoinColumn(name = "t_switch_detail_switch_id", referencedColumnName = "switch_id")})
	public t_switch_master t_switch_master;

	
}
