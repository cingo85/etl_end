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
@Table(name="t_table_detail")
@ApiModel(description= "資料表邏輯表單")
@Data
public class t_table_detail  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name="sn",updatable = false,nullable = false,length=5)
	public Integer sn;
	
	@ApiModelProperty(value = "專案代碼", required = true)
	@Column(name="project_id",nullable = false,unique=true,length=10)
	public String projectId;
	
	@ApiModelProperty(value = "資料庫代碼", required = true)
	@Column(name="datasource_id",nullable = false,unique=true,length=10)
	public String datasourceId;
	
	@ApiModelProperty(value = "表單代碼", required = true)
	@Column(name="table_id",nullable = false,unique=true,length=10)
	public String tableId;
	
	@ApiModelProperty(value = "資料表邏輯代碼", required = true)
	@Column(name="table_detail_id",nullable = false,unique=true,length=10)
	public String tableDetailId;

	@ApiModelProperty(value = "搜尋Ukey序列", required = true)
	@Column(name="searched_uk",nullable = true,length=255)
	public String searchedUk;
	
	@ApiModelProperty(value = "串接資料庫代碼", required = true)
	@Column(name="source_datasource_id",nullable = false,length=10)
	public String sourceDatasourceId;
	
	@ApiModelProperty(value = "串接表單代碼", required = true)
	@Column(name="source_table_id",nullable = false,length=10)
	public String sourceTableId;
	
	@ApiModelProperty(value = "串接表單搜尋代碼", required = true)
	@Column(name="table_search_name",nullable = false,length=10)
	public String tableSearchName;
	
	@ApiModelProperty(value = "串接表單搜尋Ukey序列", required = true)
	@Column(name="table_search_uk",nullable = false,length=255)
	public String tableSearchUk;

	@ApiModelProperty(value = "串接表單搜尋型態", required = true)
	@Column(name="table_search_method_type",nullable = false,length=255)
	public String tableSearchMethodType;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="t_table_detail_project_id",referencedColumnName = "project_id"),
				  @JoinColumn(name="t_table_detail_datasource_id" , referencedColumnName = "datasource_id"),
				  @JoinColumn(name="t_table_detail_table_id",referencedColumnName = "table_id")
	})
	public t_table_master t_table_master;

}
