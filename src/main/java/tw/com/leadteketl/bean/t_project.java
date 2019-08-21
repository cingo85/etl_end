package tw.com.leadteketl.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Entity
@Table(name="t_project")
@ApiModel(description= "專案表單")
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
	@Column(name="project_id",nullable = false,unique=true,length=36)
	public String projectId;
	
	@ApiModelProperty(value = "專案名稱", required = true)
	@Column(name="project_name",nullable = false,length=30)
	public String project_name;
	
	@ApiModelProperty(value = "建立人員", required = true)
	@Column(name="project_creater_id",nullable = false,length=30)
	public String project_creater_id;
	
	@ApiModelProperty(value = "建立日期", required = true)
	@Column(name="project_create_date",nullable = false,length=100)
	public Date project_create_date;	
	
	@ApiModelProperty(value = "最後修改人員", required = true)
	@Column(name="project_last_modify_id",nullable = false,length=30)
	public String project_last_modify_id;
	
	@ApiModelProperty(value = "最後修改日期", required = true)
	@Column(name="project_last_modify_date",nullable = false,length=100)
	@Temporal(TemporalType.DATE)
	public Date project_last_modify_date;	
	
	@ApiModelProperty(value = "是否結案", required = true)
	@Column(name="is_close",nullable = false,length=1)
	public boolean is_close;

	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="ProjectState",nullable = true,length=10)
	public String ProjectState;
	
	@ApiModelProperty(value = "客戶名稱")
	@Column(name="customer_name",length=255)
	public String customer_name;
	
	@ApiModelProperty(value = "驗收日期")
	@Column(name="check_date",length=100)
	@Temporal(TemporalType.DATE)
	public Date check_date;	 
	
	@ApiModelProperty(value = "保固期限")
	@Column(name="warr_date",length=100)
	@Temporal(TemporalType.DATE)
	public Date warr_date;
	
	@ApiModelProperty(value = "備註")
	@Column(name="note",length=255)
	public String note;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "t_project_project_id")
	public List<t_datasource> t_datasource;
	
	@Transient
	public List<t_datasource> t_datasource2;

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_creater_id() {
		return project_creater_id;
	}

	public void setProject_creater_id(String project_creater_id) {
		this.project_creater_id = project_creater_id;
	}

	public Date getProject_create_date() {
		return project_create_date;
	}

	public void setProject_create_date(Date project_create_date) {
		this.project_create_date = project_create_date;
	}

	public String getProject_last_modify_id() {
		return project_last_modify_id;
	}

	public void setProject_last_modify_id(String project_last_modify_id) {
		this.project_last_modify_id = project_last_modify_id;
	}

	public Date getProject_last_modify_date() {
		return project_last_modify_date;
	}

	public void setProject_last_modify_date(Date project_last_modify_date) {
		this.project_last_modify_date = project_last_modify_date;
	}

	public boolean isIs_close() {
		return is_close;
	}

	public void setIs_close(boolean is_close) {
		this.is_close = is_close;
	}

	

	public String getProjectState() {
		return ProjectState;
	}

	public void setProjectState(String projectState) {
		ProjectState = projectState;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Date getCheck_date() {
		return check_date;
	}

	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}

	public Date getWarr_date() {
		return warr_date;
	}

	public void setWarr_date(Date warr_date) {
		this.warr_date = warr_date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<t_datasource> getT_datasource() {
		return t_datasource;
	}

	public void setT_datasource(List<t_datasource> t_datasource) {
		this.t_datasource = t_datasource;
	}

	public List<t_datasource> getT_datasource2() {
		return t_datasource2;
	}

	public void setT_datasource2(List<t_datasource> t_datasource2) {
		this.t_datasource2 = t_datasource2;
	}
	
	

}
