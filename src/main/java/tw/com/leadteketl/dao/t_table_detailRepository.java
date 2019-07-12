package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_table_detail;

public interface t_table_detailRepository extends JpaRepository<t_table_detail,Integer>{

	
	@Override
	t_table_detail getOne(Integer id);

	@Override
	List<t_table_detail> findAll();
	
	@Override
	t_table_detail save(t_table_detail s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_table_detail t);
}
