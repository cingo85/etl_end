package tw.com.leadteketl.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Entity
@Table(name="t_project")
@ApiModel(description= "專案表單")
@Data
public class t_project implements java.io.Serializable{

	/**
	 * 此部分查找所有資料庫
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
	
	@ApiModelProperty(value = "專案名稱", required = true)
	@Column(name="project_name",nullable = false,length=30)
	public String project_name;
	
	@ApiModelProperty(value = "建立人員", required = true)
	@Column(name="project_creater_id",nullable = false,length=30)
	public String project_creater_id;
	
	@ApiModelProperty(value = "建立日期", required = true)
	@Column(name="project_create_date",nullable = false,length=30)
	@Temporal(TemporalType.TIMESTAMP)
	public Date project_create_date;	
	
	@ApiModelProperty(value = "最後修改人員", required = true)
	@Column(name="project_last_modify_id",nullable = false,length=30)
	public String project_last_modify_id;
	
	@ApiModelProperty(value = "最後修改日期", required = true)
	@Column(name="project_last_modify_date",nullable = false,length=30)
	@Temporal(TemporalType.TIMESTAMP)
	public Date project_last_modify_date;	
	
	@ApiModelProperty(value = "是否結案", required = true)
	@Column(name="is_close",nullable = false,length=1)
	public boolean is_close;

	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="state",nullable = false,length=10)
	public String state;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "t_project_sn")
	public List<t_database> t_database;

}
