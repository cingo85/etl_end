package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_column_master;


public interface t_column_masterRepository extends JpaRepository<t_column_master,Integer>{
	@Override
	t_column_master getOne(Integer id);

	@Override
	List<t_column_master> findAll();
	
	@Override
	t_column_master save(t_column_master s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_column_master t);
}
