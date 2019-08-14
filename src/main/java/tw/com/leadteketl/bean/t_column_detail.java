package tw.com.leadteketl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "t_column_detail")
@ApiModel(description= "欄位邏輯表單")
@Data
public class t_column_detail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name = "SN", updatable = false, nullable = false, length = 5)
	public Integer sn;

	@ApiModelProperty(value = "專案代碼", required = true)
	@Column(name = "project_id", nullable = false, unique = true, length = 10)
	public String project_id;

	@ApiModelProperty(value = "資料庫代碼", required = true)
	@Column(name = "datasource_id", nullable = false, unique = true, length = 10)
	public String datasource_id;

	@ApiModelProperty(value = "表單代碼", required = true)
	@Column(name = "table_id", nullable = false, unique = true, length = 10)
	public String table_id;

	@ApiModelProperty(value = "資料表邏輯代碼", required = true)
	@Column(name = "table_detail_id", nullable = false, unique = true, length = 10)
	public String table_detail_id;

	@ApiModelProperty(value = "來源欄位名稱", required = true)
	@Column(name = "source_column_name", nullable = false, unique = true, length = 100)
	public String source_column_name;

	@ApiModelProperty(value = "目標欄位名稱", required = true)
	@Column(name = "target_column_name", nullable = false, length = 100)
	public String target_column_name;

	@ApiModelProperty(value = "處理方法代碼", required = true)
	@Column(name = "method_id", nullable = true, length = 5)
	public String method_id;

	@ApiModelProperty(value = "專案代碼轉換代碼", required = true)
	@Column(name = "switch_id", nullable = true, length = 5)
	public String switch_id;

	@ApiModelProperty(value = "是否判斷非NULL", required = true)
	@Column(name = "is_null", nullable = true, length = 1)
	public boolean is_null;

	@ApiModelProperty(value = "狀態", required = true)
	@Column(name = "state", nullable = false, length = 10)
	public String state;
	

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "t_column_detail_project_id", referencedColumnName = "project_id"),
			@JoinColumn(name = "t_column_detail_datasource_id", referencedColumnName = "datasource_id"),
			@JoinColumn(name = "t_column_detail_table_id", referencedColumnName = "table_id"),
			@JoinColumn(name = "t_column_detail_table_detail_id", referencedColumnName = "table_detail_id") })
	public t_table_detail t_table_detail;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "t_column_detail_target_column_name", referencedColumnName = "column_name")})
	public t_column_master t_column_master;
	
	@OneToOne
	@JoinColumn(name = "t_column_detail_method_id",referencedColumnName="method_id")
	public t_method t_method;

}
