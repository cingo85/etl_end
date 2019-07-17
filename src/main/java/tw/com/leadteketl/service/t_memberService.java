package tw.com.leadteketl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import tw.com.leadteketl.bean.t_member;
import tw.com.leadteketl.dao.t_memberRepository;

@Service
public class t_memberService{
	
    @Autowired
    t_memberRepository t_memberRepository;
    
    public String registeredMember(t_member t_member) {
    	t_member check_member = t_memberRepository.findByusername(t_member.username);
    	
    	if(check_member== null) {
    		t_memberRepository.save(t_member);
    	}else {
    		return "已有此帳號存在";
    	}
    	return "新增帳號成功";
    }
    
    public List<t_member> ListAllMember() {
    
		return t_memberRepository.findAll();
    }
    

	


}
