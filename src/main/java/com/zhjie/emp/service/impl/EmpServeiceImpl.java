package com.zhjie.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhjie.common.datasource.DataSource;
import com.zhjie.emp.dao.EmpDao;
import com.zhjie.emp.entity.Emp;
import com.zhjie.emp.service.EmpService;



@Service
@DataSource(name = DataSource.EMP)
public class EmpServeiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao ;
	@Override
	public int addEmp(Emp emp) {
		return empDao.addEmp(emp);
	}
	
	@Override
	public int deleteEmp(Emp emp) {
		return empDao.deleteEmp(emp);
	}

	@Override
	public int updateEmp(Emp emp) {
		return empDao.updateEmp(emp);
	}

	@Override
	public List<Emp> getEmps(Emp emp) {
		return empDao.getEmps(emp);
	}

	@Override
	public int getCount(Emp emp) {
		return empDao.getCount(emp);
	}


}
