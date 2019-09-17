package tw.com.leadteketl.bean;

import java.util.UUID;

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
@Table(name = "t_datasource")
@ApiModel(description = "資料庫表單")
//@Data
public class t_datasource implements java.io.Serializable {


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
    @Column(name = "project_id", nullable = false, length = 36)
    public String projectId;

    @ApiModelProperty(value = "資料源代碼", required = true)
    @Column(name = "datasource_id", nullable = false, unique = true, length = 36)
    public String datasourceId;

    @ApiModelProperty(value = "是否為目標資料源", required = true)
    @Column(name = "is_output_datasource", nullable = true, length = 1)
    public boolean isOutputDatasource;

    @ApiModelProperty(value = "是否為來源資料源", required = true)
    @Column(name = "is_input_datasource", nullable = true, length = 1)
    public boolean isInputDatasource;

    @ApiModelProperty(value = "資料源類型", required = true)
    @Column(name = "datasource_type", nullable = false, length = 100)
    public String datasourceType;

    @ApiModelProperty(value = "資料庫IP", required = true)
    @Column(name = "database_ip", nullable = true, length = 255)
    public String databaseIp;

    @ApiModelProperty(value = "資料庫PORT", required = true)
    @Column(name = "database_port", nullable = true, length = 100)
    public String databasePort;

    @ApiModelProperty(value = "資料源名稱", required = true)
    @Column(name = "datasource_name", nullable = false, length = 255)
    public String datasourceName;

    @ApiModelProperty(value = "資料庫輪廓", required = true)
    @Column(name = "database_schema_name", nullable = true, length = 255)
    public String databaseSchemaName;

    @ApiModelProperty(value = "資料庫帳號", required = true)
    @Column(name = "database_user", nullable = true, length = 255)
    public String databaseUser;

    @ApiModelProperty(value = "資料庫密碼", required = true)
    @Column(name = "database_password", nullable = true, length = 255)
    public String databasePassword;

    @ApiModelProperty(value = "備註", required = true)
    @Column(name = "database_note", nullable = true, length = 200)
    public String databaseNote;

    @ApiModelProperty(value = "狀態", required = true)
    @Column(name = "DataBaseState", nullable = true, length = 40)
    public String DataBaseState;

    @ApiModelProperty(value = "資料根目錄", required = true)
    @Column(name = "data_root", nullable = true, length = 255)
    public String dataRoot;

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

	public String getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(String datasourceId) {
		this.datasourceId = datasourceId;
	}

	public boolean isOutputDatasource() {
		return isOutputDatasource;
	}

	public void setOutputDatasource(boolean outputDatasource) {
		isOutputDatasource = outputDatasource;
	}

	public boolean isInputDatasource() {
		return isInputDatasource;
	}

	public void setInputDatasource(boolean inputDatasource) {
		isInputDatasource = inputDatasource;
	}

	public String getDatasourceType() {
		return datasourceType;
	}

	public void setDatasourceType(String datasourceType) {
		this.datasourceType = datasourceType;
	}

	public String getDatabaseIp() {
		return databaseIp;
	}

	public void setDatabaseIp(String databaseIp) {
		this.databaseIp = databaseIp;
	}

	public String getDatabasePort() {
		return databasePort;
	}

	public void setDatabasePort(String databasePort) {
		this.databasePort = databasePort;
	}

	public String getDatasourceName() {
		return datasourceName;
	}

	public void setDatasourceName(String datasourceName) {
		this.datasourceName = datasourceName;
	}

	public String getDatabaseSchemaName() {
		return databaseSchemaName;
	}

	public void setDatabaseSchemaName(String databaseSchemaName) {
		this.databaseSchemaName = databaseSchemaName;
	}

	public String getDatabaseUser() {
		return databaseUser;
	}

	public void setDatabaseUser(String databaseUser) {
		this.databaseUser = databaseUser;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}

	public String getDatabaseNote() {
		return databaseNote;
	}

	public void setDatabaseNote(String databaseNote) {
		this.databaseNote = databaseNote;
	}

	public String getDataBaseState() {
		return DataBaseState;
	}

	public void setDataBaseState(String dataBaseState) {
		DataBaseState = dataBaseState;
	}

	public String getDataRoot() {
		return dataRoot;
	}

	public void setDataRoot(String dataRoot) {
		this.dataRoot = dataRoot;
	}
}
