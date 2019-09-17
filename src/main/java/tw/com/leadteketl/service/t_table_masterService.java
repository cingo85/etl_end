package tw.com.leadteketl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.leadteketl.bean.t_datasource;
import tw.com.leadteketl.bean.t_table_master;
import tw.com.leadteketl.dao.t_datasourceRepository;
import tw.com.leadteketl.dao.t_table_masterRepository;

@Service
public class t_table_masterService {

	@Autowired
	t_table_masterRepository t_table_masterRepository;
	
	@Autowired
	t_datasourceRepository t_datasourceRepository;
	
	public List<t_table_master> findByProjectId(String projectId) {
		return t_table_masterRepository.findByProjectId(projectId);
	}
	
	public List<t_table_master> findByTableId(String TableId) {
		return t_table_masterRepository.findByTableId(TableId);
	}
	
	public List<t_table_master> findByDatasourceId(String TableId) {
		return t_table_masterRepository.findByDatasourceId(TableId);
	}
	
	public t_table_master save(t_table_master s) {
		return t_table_masterRepository.save(s);
	}
	
	public List<t_table_master> findAll(){
		return t_table_masterRepository.findAll();
	}
	
	public List<t_table_master> compareDataSourceNTableMasterProjectId(String projectId) {
		
		List<t_table_master> result = new ArrayList<t_table_master>();
		
		List <t_table_master> tableResult = t_table_masterRepository.findByProjectId(projectId);
		List <t_datasource> datasourceResult = t_datasourceRepository.findByprojectId(projectId);
		
		for(t_datasource item:datasourceResult) {
			if(("").equals(item.DataBaseState) && item.isInputDatasource) {
				t_table_master temp = new t_table_master();
				temp.SN = item.sn;
				temp.projectId = item.projectId;
				temp.datasourceId = item.datasourceId;
				temp.datasourceType = item.datasourceType;
				temp.databaseNote = item.databaseNote;
				temp.tableMasterState =item.DataBaseState;
				temp.datasourceName = item.datasourceName;
				result.add(temp);
			}
		}
		
		for(t_table_master item:tableResult) {
			if("CsvImport".equals(item.tableMasterState)) {
				result.add(item);
			}
		}
		
		return result;	
		}
}
