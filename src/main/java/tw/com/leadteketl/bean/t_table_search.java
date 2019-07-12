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
@Table(name="t_table_search")
@ApiModel(description= "資料表搜尋方式表單")
@Data
public class t_table_search  implements java.io.Serializable{

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
	
	@ApiModelProperty(value = "表單搜尋代碼", required = true)
	@Column(name="table_search_id",nullable = false,unique=true,length=10)
	public String table_search_id;
	
	@ApiModelProperty(value = "表單搜尋名稱", required = true)
	@Column(name="table_search_name",nullable = false,length=255)
	public String table_search_name;
	
	@ApiModelProperty(value = "表單搜尋Ukey序列", required = true)
	@Column(name="table_search_uk",nullable = false,length=255)
	public String table_search_uk;
	
	@ApiModelProperty(value = "表單搜尋型態", required = true)
	@Column(name="table_search_type",nullable = false,length=100)
	public String table_search_type;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="state",nullable = false,length=10)
	public String state;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="t_table_search_project_id",referencedColumnName="project_id"),
			      @JoinColumn(name="t_table_search_database_id",referencedColumnName="database_id"),
			      @JoinColumn(name="t_table_search_table_id",referencedColumnName="table_id")
	})
	public t_table_master t_table_master;

}
