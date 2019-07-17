package tw.com.leadteketl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.leadteketl.bean.t_column_master;
import tw.com.leadteketl.bean.t_member;
import tw.com.leadteketl.bean.t_project;

public interface t_memberRepository extends JpaRepository<t_member,Integer>{
	
	@Override
	t_member save(t_member s);

	
	t_member findByusername(String username);
	
	@Override
	List<t_member> findAll();
	

}
