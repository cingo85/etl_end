package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_switch_master;

public interface t_switch_masterRepository extends JpaRepository<t_switch_master,Integer>{

	
	@Override
	t_switch_master getOne(Integer id);

	@Override
	List<t_switch_master> findAll();
	
	@Override
	t_switch_master save(t_switch_master s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_switch_master t);
}
