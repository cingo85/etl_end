package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_switch_detail;

public interface t_switch_detailRepository extends JpaRepository<t_switch_detail,Integer>{

	
	@Override
	t_switch_detail getOne(Integer id);

	@Override
	List<t_switch_detail> findAll();
	
	@Override
	t_switch_detail save(t_switch_detail s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_switch_detail t);
}
