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
name="t_table_master",
uniqueConstraints= {@UniqueConstraint(columnNames = {"project_id","database_id","table_id"})})
@ApiModel(description= "資料表主表單")
@Data
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
	public String project_id;
	
	@ApiModelProperty(value = "資料庫代碼", required = true)
	@Column(name="database_id",nullable = false,length=100)
	public String database_id;
	
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
	@Column(name="table_column_quantity",nullable = false,length=100)
	public Integer table_column_quantity;
	
	@ApiModelProperty(value = "表單資料數量", required = true)
	@Column(name="table_data_quantity",nullable = false,length=100)
	public Integer table_data_quantity;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="state",nullable = false,length=10)
	public String state;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="t_table_master_project_id",referencedColumnName = "project_id")
	,@JoinColumn(name="t_table_master_database_id",referencedColumnName = "database_id")})
	public t_database t_database;

}
