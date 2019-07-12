package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_database;
import tw.com.leadteketl.bean.t_project;
import tw.com.leadteketl.bean.t_table_master;

@RepositoryRestResource
public interface t_table_masterRepository extends JpaRepository<t_table_master,Integer> {
	
	@Override
	t_table_master getOne(Integer id);

	@Override
	List<t_table_master> findAll();
	
	@Override
	t_table_master save(t_table_master s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_table_master t);
	
	
	
	
}
