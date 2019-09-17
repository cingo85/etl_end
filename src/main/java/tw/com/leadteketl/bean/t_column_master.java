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
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="t_column_master")
@ApiModel(description= "欄位表單")
public class t_column_master implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name="SN",updatable = false,nullable = false,length=5)
	public Integer sn;	
	
	@ApiModelProperty(value = "表單代碼", required = true)
	@Column(name="table_id",nullable = false,length=40)
	public String tableId;	
	
	@ApiModelProperty(value = "欄位代碼", required = true)
	@Column(name="column_id",nullable = false,unique=true,length=40)
	public String columnId;
	
	@ApiModelProperty(value = "欄位名稱", required = true)
	@Column(name="column_name",nullable = false,length=100)
	public String columnName;
	
	@ApiModelProperty(value = "欄位讀取名稱", required = true)
	@Column(name="column_read_name",length=100)
	public String columnReadName;
	
	@ApiModelProperty(value = "欄位中文名稱", required = true)
	@Column(name="column_c_name",length=100)
	public String columnCname;
	
	@ApiModelProperty(value = "欄位是否為Pkey", required = true)
	@Column(name="is_pk",nullable = false,length=1)
	public boolean isPk;
	
	@ApiModelProperty(value = "欄位型態", required = true)
	@Column(name="column_type",nullable = false,length=20)
	public String columnType;
	
	@ApiModelProperty(value = "欄位預設值", required = true)
	@Column(name="column_default",nullable = false,length=255)
	public String columnDefault;
	
	@ApiModelProperty(value = "欄位是否推送", required = true)
	@Column(name="is_datamodel_attribute",length=1)
	public boolean isDatamodelAttribute;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="ColumnMasterState",nullable = false,length=40)
	public String ColumnMasterState;
	
	@ApiModelProperty(value = "欄位長度", required = true)
	@Column(name="column_length",length=100)
	public Integer columnLength;
	
	/*
	 * 0827
	 * */
	
	@ApiModelProperty(value = "欄位在表內型態", required = true)
	@Column(name="columnInTableType",length=100)
	public String columnInTableType;
	
	@ManyToOne
	@JoinColumn(name="t_column_master_table_id",referencedColumnName = "table_id")
	public t_table_master t_table_master;

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnReadName() {
		return columnReadName;
	}

	public void setColumnReadName(String columnReadName) {
		this.columnReadName = columnReadName;
	}

	public String getColumnCname() {
		return columnCname;
	}

	public void setColumnCname(String columnCname) {
		this.columnCname = columnCname;
	}

	public boolean isPk() {
		return isPk;
	}

	public void setPk(boolean pk) {
		isPk = pk;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public boolean isDatamodelAttribute() {
		return isDatamodelAttribute;
	}

	public void setDatamodelAttribute(boolean datamodelAttribute) {
		isDatamodelAttribute = datamodelAttribute;
	}

	public String getColumnMasterState() {
		return ColumnMasterState;
	}

	public void setColumnMasterState(String columnMasterState) {
		ColumnMasterState = columnMasterState;
	}

	public Integer getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}

	public String getColumnInTableType() {
		return columnInTableType;
	}

	public void setColumnInTableType(String columnInTableType) {
		this.columnInTableType = columnInTableType;
	}

	public tw.com.leadteketl.bean.t_table_master getT_table_master() {
		return t_table_master;
	}

	public void setT_table_master(tw.com.leadteketl.bean.t_table_master t_table_master) {
		this.t_table_master = t_table_master;
	}
}
