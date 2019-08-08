package tw.com.leadteketl.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.leadteketl.bean.t_datasource;
import tw.com.leadteketl.bean.t_project;
import tw.com.leadteketl.dao.t_datasourceRepository;
import tw.com.leadteketl.dao.t_projectRepository;

@Service
public class t_projectService {
	
	
	@Autowired
	t_projectRepository t_projectRepository;
	
	@Autowired
	t_datasourceRepository t_datasourceRepository;
	
	public String saveNewProject(t_project t_project) {
		
		if(t_project.t_datasource2.size()>0) {
			t_project.t_datasource.addAll(t_project.t_datasource2);
		}
		
		SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
	
//		t_project.setProject_id(UUID.randomUUID().toString());
		t_project.setProject_create_date(nowdate.get2DigitYearStart());
		t_project.setProject_last_modify_date(nowdate.get2DigitYearStart());

			 
		
		
		
		t_projectRepository.save(t_project);
		
		return "Ok";
	}

	public List<t_project> findAll() {
		// TODO Auto-generated method stub
		return t_projectRepository.findAll();
	}

	public t_project findBySn(Integer sn) {
		// TODO Auto-generated method stub
		return t_projectRepository.findBySn(sn);
	}

	public void save(t_project _old_t_project) {
		t_projectRepository.save(_old_t_project);
		
	}
}
