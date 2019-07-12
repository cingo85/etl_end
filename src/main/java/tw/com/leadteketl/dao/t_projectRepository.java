package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tw.com.leadteketl.bean.t_project;

//@Repository
@RepositoryRestResource
public interface t_projectRepository extends JpaRepository<t_project,Integer>{
		
		@Override
		t_project getOne(Integer id);

		@Override
		List<t_project> findAll();
		
		@Override
		t_project save(t_project s);
		
		@Override
		@RestResource(exported = false)
		void delete(t_project t);
		
}


