package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_table_search;

@RepositoryRestResource
public interface t_table_searchRepository extends JpaRepository<t_table_search,Integer> {
	
	@Override
	t_table_search getOne(Integer id);

	@Override
	List<t_table_search> findAll();
	
	@Override
	t_table_search save(t_table_search s);
	
	@Override
	@RestResource(exported = false)
	void delete(t_table_search t);
}
