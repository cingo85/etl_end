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
	public String column_id;
	
	@ApiModelProperty(value = "欄位名稱", required = true)
	@Column(name="column_name",nullable = false,length=100)
	public String column_name;
	
	@ApiModelProperty(value = "欄位讀取名稱", required = true)
	@Column(name="column_read_name",length=100)
	public String column_read_name;
	
	@ApiModelProperty(value = "欄位中文名稱", required = true)
	@Column(name="column_c_name",length=100)
	public String column_c_name;
	
	@ApiModelProperty(value = "欄位是否為Pkey", required = true)
	@Column(name="is_pk",nullable = false,length=1)
	public boolean is_pk;
	
	@ApiModelProperty(value = "欄位型態", required = true)
	@Column(name="column_type",nullable = false,length=20)
	public String column_type;
	
	@ApiModelProperty(value = "欄位預設值", required = true)
	@Column(name="column_default",nullable = false,length=255)
	public String column_default;
	
	@ApiModelProperty(value = "欄位是否推送", required = true)
	@Column(name="is_datamodel_attribute",length=1)
	public boolean is_datamodel_attribute;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="ColumnMasterState",nullable = false,length=40)
	public String ColumnMasterState;
	
	@ApiModelProperty(value = "欄位長度", required = true)
	@Column(name="column_length",length=100)
	public Integer column_length;
	
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

	public String getColumn_id() {
		return column_id;
	}

	public void setColumn_id(String column_id) {
		this.column_id = column_id;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getColumn_read_name() {
		return column_read_name;
	}

	public void setColumn_read_name(String column_read_name) {
		this.column_read_name = column_read_name;
	}

	public String getColumn_c_name() {
		return column_c_name;
	}

	public void setColumn_c_name(String column_c_name) {
		this.column_c_name = column_c_name;
	}

	public boolean isIs_pk() {
		return is_pk;
	}

	public void setIs_pk(boolean is_pk) {
		this.is_pk = is_pk;
	}

	public String getColumn_type() {
		return column_type;
	}

	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}

	public String getColumn_default() {
		return column_default;
	}

	public void setColumn_default(String column_default) {
		this.column_default = column_default;
	}

	public boolean isIs_datamodel_attribute() {
		return is_datamodel_attribute;
	}

	public void setIs_datamodel_attribute(boolean is_datamodel_attribute) {
		this.is_datamodel_attribute = is_datamodel_attribute;
	}

	public String getColumnMasterState() {
		return ColumnMasterState;
	}

	public void setColumnMasterState(String columnMasterState) {
		ColumnMasterState = columnMasterState;
	}

	public Integer getColumn_length() {
		return column_length;
	}

	public void setColumn_length(Integer column_length) {
		this.column_length = column_length;
	}

	public String getColumnInTableType() {
		return columnInTableType;
	}

	public void setColumnInTableType(String columnInTableType) {
		this.columnInTableType = columnInTableType;
	}

	public t_table_master getT_table_master() {
		return t_table_master;
	}

	public void setT_table_master(t_table_master t_table_master) {
		this.t_table_master = t_table_master;
	}
	
	
		
}
