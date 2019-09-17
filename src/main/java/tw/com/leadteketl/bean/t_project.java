package tw.com.leadteketl.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Entity
@Table(name = "t_project")
@ApiModel(description = "專案表單")
public class t_project implements java.io.Serializable {

    /**
     * 此部分查找所有資料庫
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "自增序號", required = true)
    @Column(name = "sn", updatable = false, nullable = false, length = 5)
    public Integer sn;

    @ApiModelProperty(value = "專案代碼", required = true)
    @Column(name = "project_id", nullable = false, unique = true, length = 36)
    public String projectId;

    @ApiModelProperty(value = "專案名稱", required = true)
    @Column(name = "project_name", nullable = false, length = 30)
    public String projectName;

    @ApiModelProperty(value = "建立人員", required = true)
    @Column(name = "project_creater_id", nullable = false, length = 30)
    public String projectCreaterId;

    @ApiModelProperty(value = "建立日期", required = true)
    @Column(name = "project_create_date", nullable = false, length = 100)
    public Date projectCreateDate;

    @ApiModelProperty(value = "最後修改人員", required = true)
    @Column(name = "project_last_modify_id", nullable = false, length = 30)
    public String projectLastModifyId;

    @ApiModelProperty(value = "最後修改日期", required = true)
    @Column(name = "project_last_modify_date", nullable = false, length = 100)
    @Temporal(TemporalType.DATE)
    public Date projectLastModifyDate;

    @ApiModelProperty(value = "是否結案", required = true)
    @Column(name = "is_close", nullable = false, length = 1)
    public boolean isClose;

    @ApiModelProperty(value = "狀態", required = true)
    @Column(name = "ProjectState", nullable = true, length = 10)
    public String ProjectState;

    @ApiModelProperty(value = "客戶名稱")
    @Column(name = "customer_name", length = 255)
    public String customerName;

    @ApiModelProperty(value = "驗收日期")
    @Column(name = "check_date", length = 100)
    @Temporal(TemporalType.DATE)
    public Date checkDate;

    @ApiModelProperty(value = "保固期限")
    @Column(name = "warr_date", length = 100)
    @Temporal(TemporalType.DATE)
    public Date warrDate;

    @ApiModelProperty(value = "備註")
    @Column(name = "note", length = 255)
    public String note;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "t_project_project_id")
    public List<t_datasource> t_datasource;

    @Transient
    public List<t_datasource> t_datasource2;

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    public String getProjectState() {
        return ProjectState;
    }

    public void setProjectState(String projectState) {
        ProjectState = projectState;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<t_datasource> getT_datasource() {
        return t_datasource;
    }

    public void setT_datasource(List<t_datasource> t_datasource) {
        this.t_datasource = t_datasource;
    }

    public List<t_datasource> getT_datasource2() {
        return t_datasource2;
    }

    public void setT_datasource2(List<t_datasource> t_datasource2) {
        this.t_datasource2 = t_datasource2;
    }

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCreaterId() {
		return projectCreaterId;
	}

	public void setProjectCreaterId(String projectCreaterId) {
		this.projectCreaterId = projectCreaterId;
	}

	public Date getProjectCreateDate() {
		return projectCreateDate;
	}

	public void setProjectCreateDate(Date projectCreateDate) {
		this.projectCreateDate = projectCreateDate;
	}

	public String getProjectLastModifyId() {
		return projectLastModifyId;
	}

	public void setProjectLastModifyId(String projectLastModifyId) {
		this.projectLastModifyId = projectLastModifyId;
	}

	public Date getProjectLastModifyDate() {
		return projectLastModifyDate;
	}

	public void setProjectLastModifyDate(Date projectLastModifyDate) {
		this.projectLastModifyDate = projectLastModifyDate;
	}

	public boolean isClose() {
		return isClose;
	}

	public void setClose(boolean close) {
		isClose = close;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getWarrDate() {
		return warrDate;
	}

	public void setWarrDate(Date warrDate) {
		this.warrDate = warrDate;
	}

}
