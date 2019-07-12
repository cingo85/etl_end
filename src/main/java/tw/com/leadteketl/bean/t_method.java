package tw.com.leadteketl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "t_method")
@ApiModel(description= "代碼轉換主表單")
@Data
public class t_method  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name="sn",nullable = false,length=10)
	public Integer sn;	
	
	@ApiModelProperty(value = "ETL功能代碼", required = true)
	@Column(name="method_id",nullable = false,unique=true,length=10)
	public String method_id;
	
	@ApiModelProperty(value = "ETL功能名稱", required = true)
	@Column(name="method_name",nullable = false,length=100)
	public String method_name;
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="state",nullable = false,length=10)
	public String state	;

	

}
