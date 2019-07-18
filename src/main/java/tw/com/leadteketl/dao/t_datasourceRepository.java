package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_datasource;

@RepositoryRestResource
public interface t_datasourceRepository extends JpaRepository<t_datasource,Integer>{

	
	@Override
	t_datasource getOne(Integer id);

	@Override
	List<t_datasource> findAll();
	
	@Override
	t_datasource save(t_datasource s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_datasource t);

	@Query(value="SELECT name FROM master.dbo.sysdatabases",nativeQuery = true)
	List<String> findSqlserverAllDbSchema();
	
	@Query(value ="SELECT TABLE_NAME, count(TABLE_NAME)'TableRows' " + 
			"FROM IR_國際事務管理系統.INFORMATION_SCHEMA.COLUMNS " + 
			"GROUP BY TABLE_NAME",nativeQuery = true)
	List<t_datasource> findSQLSERVERAllColumnInfoMation();
	
	
}
