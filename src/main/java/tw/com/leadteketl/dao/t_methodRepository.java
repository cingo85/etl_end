package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_method;

public interface t_methodRepository extends JpaRepository<t_method,Integer>{

	@Override
	t_method getOne(Integer id);

	@Override
	List<t_method> findAll();
	
	@Override
	t_method save(t_method s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_method t);
}
