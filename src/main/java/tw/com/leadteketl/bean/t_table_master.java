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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(
name="t_table_master"
,uniqueConstraints= {@UniqueConstraint(columnNames = {"project_id","datasource_id","table_id"})}
)
@ApiModel(description= "資料表主表單")
public class t_table_master implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name="SN",updatable = false,nullable = false,length=12)
	public Integer SN;

	@ApiModelProperty(value = "專案代碼", required = true)
	@Column(name="project_id",nullable = false,length=100)
	public String projectId;
	
	@ApiModelProperty(value = "資料庫代碼", required = true)
	@Column(name="datasource_id",nullable = false,length=100)
	public String datasource_id;
	
	@ApiModelProperty(value = "表單代碼", required = true)
	@Column(name="table_id",nullable = false,length=100)
	public String table_id;
	
	@ApiModelProperty(value = "表單名稱", required = true)
	@Column(name="table_name",nullable = false,length=100)
	public String table_name;
	
	@ApiModelProperty(value = "表單Pkey序列", required = true)
	@Column(name="table_pk",length=100)
	public String table_pk;
	
	@ApiModelProperty(value = "表單Pkey名稱", required = true)
	@Column(name="table_pk_name",length=100)
	public String table_pk_name;
	
	@ApiModelProperty(value = "表單欄位數量", required = true)
	@Column(name="table_column_quantity",nullable = true,length=100)
	public Integer table_column_quantity;
	
	@ApiModelProperty(value = "表單資料數量", required = true)
	@Column(name="table_data_quantity",nullable = true,length=100)
	public Integer table_data_quantity;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="state",nullable = false,length=10)
	public String state;
	
	/*
	 * 
	 * 以下為自己加的
	 * 
	 * */
	
	@ApiModelProperty(value = "是否串接")
	@Column(name="isConcatenation",length=1)
	public boolean isConcatenation;
	
	@ApiModelProperty(value = "	資料描述")
	@Column(name="description",length=200)
	public String description;
	
	@ApiModelProperty(value = "	未串接原因")
	@Column(name="reason",length=200)
	public String reason;
	
	@ApiModelProperty(value = "備註")
	@Column(name="tMasterNote",length=10)
	public String tMasterNote;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="t_table_master_project_id",referencedColumnName = "project_id")
	,@JoinColumn(name="t_table_master_datasource_id",referencedColumnName = "datasource_id")})
	public t_datasource t_database;

	public Integer getSN() {
		return SN;
	}

	public void setSN(Integer sN) {
		SN = sN;
	}

	

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	

	public String getDatasource_id() {
		return datasource_id;
	}

	public void setDatasource_id(String datasource_id) {
		this.datasource_id = datasource_id;
	}

	public String getTable_id() {
		return table_id;
	}

	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getTable_pk() {
		return table_pk;
	}

	public void setTable_pk(String table_pk) {
		this.table_pk = table_pk;
	}

	public String getTable_pk_name() {
		return table_pk_name;
	}

	public void setTable_pk_name(String table_pk_name) {
		this.table_pk_name = table_pk_name;
	}

	public Integer getTable_column_quantity() {
		return table_column_quantity;
	}

	public void setTable_column_quantity(Integer table_column_quantity) {
		this.table_column_quantity = table_column_quantity;
	}

	public Integer getTable_data_quantity() {
		return table_data_quantity;
	}

	public void setTable_data_quantity(Integer table_data_quantity) {
		this.table_data_quantity = table_data_quantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isConcatenation() {
		return isConcatenation;
	}

	public void setConcatenation(boolean isConcatenation) {
		this.isConcatenation = isConcatenation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String gettMasterNote() {
		return tMasterNote;
	}

	public void settMasterNote(String tMasterNote) {
		this.tMasterNote = tMasterNote;
	}

	public t_datasource getT_database() {
		return t_database;
	}

	public void setT_database(t_datasource t_database) {
		this.t_database = t_database;
	}
	
	

}
