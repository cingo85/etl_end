package tw.com.leadteketl.bean;

import java.io.Serializable;

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
@Table(name = "t_member")
@ApiModel(description = "人員表單")
@Data
public class t_member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name = "SN", updatable = false, nullable = false, length = 5)
	public Integer sn;

	@ApiModelProperty(value = "名稱", required = true)
	@Column(name = "username", nullable = false, unique = true, length = 100)
	public String username;

	@ApiModelProperty(value = "密碼", required = true)
	@Column(name = "password", nullable = false, length = 200)
	public String password;

	@ApiModelProperty(value = "職稱", required = true)
	@Column(name = "member_title", nullable = false, length = 200)
	public String member_title;

}
