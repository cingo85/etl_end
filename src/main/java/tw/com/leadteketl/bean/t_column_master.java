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
@Table(name="t_column_master")
@ApiModel(description= "欄位表單")
@Data
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
	
	
	@ApiModelProperty(value = "專案代碼", required = true)
	@Column(name="project_id",nullable = false,unique=true,length=10)
	public String project_id;	
	
	@ApiModelProperty(value = "資料庫代碼", required = true)
	@Column(name="database_id",nullable = false,unique=true,length=10)
	public String database_id;
	
	@ApiModelProperty(value = "表單代碼", required = true)
	@Column(name="table_id",nullable = false,unique=true,length=10)
	public String table_id;	
	
	@ApiModelProperty(value = "欄位代碼", required = true)
	@Column(name="column_id",nullable = false,unique=true,length=10)
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
	@Column(name="state",nullable = false,length=10)
	public String state;
	
	@ApiModelProperty(value = "欄位長度", required = true)
	@Column(name="column_length",length=100)
	public Integer column_length;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="t_column_master_project_id",referencedColumnName = "project_id"),
				  @JoinColumn(name="t_column_master_database_id" , referencedColumnName = "database_id"),
				  @JoinColumn(name="t_column_master_table_id",referencedColumnName = "table_id")
	})
	public t_table_master t_table_master;
		
}
