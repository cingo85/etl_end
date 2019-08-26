package tw.com.leadteketl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.leadteketl.bean.t_column_master;
import tw.com.leadteketl.dao.t_column_masterRepository;

@Service
public class t_column_masterService {
	
	@Autowired
	t_column_masterRepository t_column_masterRepository;
	
	public t_column_master save(t_column_master s) {
		return t_column_masterRepository.save(s);
	}
	
	public List<t_column_master> findAll(){
		return t_column_masterRepository.findAll();
	}
	
	public List<t_column_master> findByTableId(String TableId) {
		return t_column_masterRepository.findByTableId(TableId);
	}
	
}
