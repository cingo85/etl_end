package tw.com.leadteketl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.leadteketl.bean.t_datasource;
import tw.com.leadteketl.dao.t_datasourceRepository;

@Service
public class t_datasourceService {
	
	@Autowired
	t_datasourceRepository t_datasourceRepository;


	public t_datasource save(t_datasource t_datasource) {
		
		return t_datasourceRepository.save(t_datasource);
	}
	
	public t_datasource saveState(t_datasource t_datasource) {
		
		List<t_datasource> temp = t_datasourceRepository.findByprojectId(t_datasource.getProjectId());
		
		for(t_datasource item : temp) {
			
			item.setState("TableMasterImport");
			t_datasourceRepository.save(item);
		}
		
		return null;
	}

	public List<t_datasource> findByprojectId(String projectId) {
		// TODO Auto-generated method stub
		return t_datasourceRepository.findByprojectId(projectId);
	}

	public List<t_datasource> findAll() {
		// TODO Auto-generated method stub
		return t_datasourceRepository.findAll();
	}
}
