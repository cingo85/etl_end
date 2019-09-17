package tw.com.leadteketl.bean;

import java.util.ArrayList;
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
	
	@ApiModelProperty(value = "表單代碼", required = false)
	@Column(name="table_id",length=100)
	public String tableId;

	@ApiModelProperty(value = "表單名稱", required = true)
	@Column(name="table_name",length=100)
	public String tableName;
	
	@ApiModelProperty(value = "表單名稱中文", required = true)
	@Column(name="table_cname",length=100)
	public String tableCname;
	
	@ApiModelProperty(value = "表單名稱英文", required = true)
	@Column(name="table_ename",length=100)
	public String tableEname;
	
	@ApiModelProperty(value = "表單Pkey序列", required = true)
	@Column(name="table_pk",length=100)
	public String tablePk;
	
	@ApiModelProperty(value = "表單Pkey名稱", required = true)
	@Column(name="table_pk_name",length=100)
	public String tablePkName;
	
	@ApiModelProperty(value = "表單欄位數量", required = true)
	@Column(name="table_column_quantity",nullable = true,length=100)
	public Integer tableColumnQuantity;
	
	@ApiModelProperty(value = "表單資料數量", required = true)
	@Column(name="table_data_quantity",nullable = true,length=100)
	public Integer tableDataQuantity;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="table_master_state",nullable = false,length=40)
	public String tableMasterState;
	
	/*
	 * 
	 * 以下為自己加的
	 * 
	 * */
	
	@ApiModelProperty(value = "是否串接")
	@Column(name="is_Concatenation",length=1)
	public boolean isConcatenation;
	
	@ApiModelProperty(value = "資料描述")
	@Column(name="description",length=200)
	public String description;
	
	@ApiModelProperty(value = "未串接原因")
	@Column(name="reason",length=200)
	public String reason;
	
	@ApiModelProperty(value = "備註")
	@Column(name="t_master_note",length=10)
	public String tMasterNote;
	
	@ApiModelProperty(value = "版本號")
	@Column(name="version",length=200)
	public String version;
	
	/*
	 * 20190819
	 * */
	@ApiModelProperty(value = "資料源名稱", required = true)
	@Column(name="datasource_name",length=255)
	public String datasourceName;
	
	@ApiModelProperty(value = "備註", required = true)
	@Column(name="database_note",nullable = true,length=200)
	public String databaseNote;
	
	@ApiModelProperty(value = "資料源類型", required = true)
	@Column(name="datasource_type",nullable = true,length=100)
	public String datasourceType;

	@ApiModelProperty(value = "表頭順序")
	@Column(name="headerSeq",nullable = true,length=100)
	public ArrayList<String> headerSeq;
	
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

	public void setSN(Integer SN) {
		this.SN = SN;
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableCname() {
		return tableCname;
	}

	public void setTableCname(String tableCname) {
		this.tableCname = tableCname;
	}

	public String getTableEname() {
		return tableEname;
	}

	public void setTableEname(String tableEname) {
		this.tableEname = tableEname;
	}

	public String getTablePk() {
		return tablePk;
	}

	public void setTablePk(String tablePk) {
		this.tablePk = tablePk;
	}

	public String getTablePkName() {
		return tablePkName;
	}

	public void setTablePkName(String tablePkName) {
		this.tablePkName = tablePkName;
	}

	public Integer getTableColumnQuantity() {
		return tableColumnQuantity;
	}

	public void setTableColumnQuantity(Integer tableColumnQuantity) {
		this.tableColumnQuantity = tableColumnQuantity;
	}

	public Integer getTableDataQuantity() {
		return tableDataQuantity;
	}

	public void setTableDataQuantity(Integer tableDataQuantity) {
		this.tableDataQuantity = tableDataQuantity;
	}

	public String getTableMasterState() {
		return tableMasterState;
	}

	public void setTableMasterState(String tableMasterState) {
		this.tableMasterState = tableMasterState;
	}

	public boolean isConcatenation() {
		return isConcatenation;
	}

	public void setConcatenation(boolean concatenation) {
		isConcatenation = concatenation;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDatasourceName() {
		return datasourceName;
	}

	public void setDatasourceName(String datasourceName) {
		this.datasourceName = datasourceName;
	}

	public String getDatabaseNote() {
		return databaseNote;
	}

	public void setDatabaseNote(String databaseNote) {
		this.databaseNote = databaseNote;
	}

	public String getDatasourceType() {
		return datasourceType;
	}

	public void setDatasourceType(String datasourceType) {
		this.datasourceType = datasourceType;
	}

	public ArrayList<String> getHeaderSeq() {
		return headerSeq;
	}

	public void setHeaderSeq(ArrayList<String> headerSeq) {
		this.headerSeq = headerSeq;
	}

	public t_datasource getT_database() {
		return t_database;
	}

	public void setT_database(t_datasource t_database) {
		this.t_database = t_database;
	}

	public List<tw.com.leadteketl.bean.t_column_master> getT_column_master() {
		return t_column_master;
	}

	public void setT_column_master(List<tw.com.leadteketl.bean.t_column_master> t_column_master) {
		this.t_column_master = t_column_master;
	}


}
