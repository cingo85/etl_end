package tw.com.leadteketl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.leadteketl.bean.t_table_master;
import tw.com.leadteketl.dao.t_table_masterRepository;

@Service
public class t_table_masterService {

	@Autowired
	t_table_masterRepository t_table_masterRepository;
	
	public List<t_table_master> findByProjectId(String projectId) {
		return t_table_masterRepository.findByProjectId(projectId);
	}
	
	public t_table_master save(t_table_master s) {
		return t_table_masterRepository.save(s);
	}
	
	public List<t_table_master> findAll(){
		return t_table_masterRepository.findAll();
	}
}
