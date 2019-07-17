package tw.com.leadteketl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.leadteketl.dao.t_projectRepository;

@Service
public class t_projectService {
	
	@Autowired
	t_projectRepository t_projectRepository;
	
	
}
