package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_table_master;

@RepositoryRestResource
public interface t_table_masterRepository extends JpaRepository<t_table_master,Integer> {
	
	@Override
	t_table_master getOne(Integer id);

	@Override
	List<t_table_master> findAll();
	
	
	List<t_table_master> findByProjectId(String projectId);

	List<t_table_master> findByTableId(String tableId);
	
	@Override
	t_table_master save(t_table_master s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_table_master t);
	
	
	
	
}
