package com.zhjie.emp.service;

import java.util.List;

import com.zhjie.emp.entity.Emp;




public interface EmpService {

	public int addEmp(Emp emp);
	
    public int deleteEmp(Emp emp);
    
    public int updateEmp(Emp emp);
	
	public List<Emp> getEmps(Emp emp);
	
	public int getCount(Emp emp);
}
