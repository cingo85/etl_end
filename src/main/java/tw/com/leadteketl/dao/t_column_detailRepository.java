package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_column_detail;
import tw.com.leadteketl.bean.t_database;

public interface t_column_detailRepository extends JpaRepository<t_column_detail,Integer>{
	
	@Override
	t_column_detail getOne(Integer id);

	@Override
	List<t_column_detail> findAll();
	
	@Override
	t_column_detail save(t_column_detail s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_column_detail t);

}
