package tw.com.leadteketl.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
	public String datasourceId;
	
	@ApiModelProperty(value = "表單代碼", required = true)
	@Column(name="table_id",nullable = false,length=100)
	public String tableId;
	
	@ApiModelProperty(value = "表單名稱中文", required = true)
	@Column(name="table_cname",length=100)
	public String table_cname;
	
	@ApiModelProperty(value = "表單名稱英文", required = true)
	@Column(name="table_ename",length=100)
	public String table_ename;
	
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
	@Column(name="TableMasterState",nullable = false,length=40)
	public String TableMasterState;
	
	/*
	 * 
	 * 以下為自己加的
	 * 
	 * */
	
	@ApiModelProperty(value = "是否串接")
	@Column(name="isConcatenation",length=1)
	public boolean isConcatenation;
	
	@ApiModelProperty(value = "資料描述")
	@Column(name="description",length=200)
	public String description;
	
	@ApiModelProperty(value = "未串接原因")
	@Column(name="reason",length=200)
	public String reason;
	
	@ApiModelProperty(value = "備註")
	@Column(name="tMasterNote",length=10)
	public String tMasterNote;
	
	@ApiModelProperty(value = "版本號")
	@Column(name="version",length=200)
	public String version;
	
	/*
	 * 20190819
	 * */
	@ApiModelProperty(value = "資料源名稱", required = true)
	@Column(name="datasource_name",length=255)
	public String datasource_name;	
	
	@ApiModelProperty(value = "備註", required = true)
	@Column(name="database_note",nullable = true,length=200)
	public String database_note;
	
	@ApiModelProperty(value = "資料源類型", required = true)
	@Column(name="datasource_type",nullable = true,length=100)
	public String datasource_type;	
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="t_table_master_project_id",referencedColumnName = "project_id")
	,@JoinColumn(name="t_table_master_datasource_id",referencedColumnName = "datasource_id")})
	public t_datasource t_database;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "t_table_master_table_id")
	public List<t_column_master> t_column_master;

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

	




	public String getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(String datasourceId) {
		this.datasourceId = datasourceId;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getTable_cname() {
		return table_cname;
	}

	public void setTable_cname(String table_cname) {
		this.table_cname = table_cname;
	}

	public String getTable_ename() {
		return table_ename;
	}

	public void setTable_ename(String table_ename) {
		this.table_ename = table_ename;
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


	public String getTableMasterState() {
		return TableMasterState;
	}

	public void setTableMasterState(String tableMasterState) {
		TableMasterState = tableMasterState;
	}

	public List<t_column_master> getT_column_master() {
		return t_column_master;
	}

	public void setT_column_master(List<t_column_master> t_column_master) {
		this.t_column_master = t_column_master;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDatasource_name() {
		return datasource_name;
	}

	public void setDatasource_name(String datasource_name) {
		this.datasource_name = datasource_name;
	}

	public String getDatabase_note() {
		return database_note;
	}

	public void setDatabase_note(String database_note) {
		this.database_note = database_note;
	}

	public String getDatasource_type() {
		return datasource_type;
	}

	public void setDatasource_type(String datasource_type) {
		this.datasource_type = datasource_type;
	}
	
	
	

}
