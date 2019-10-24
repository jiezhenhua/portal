package com.zhjie.emp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhjie.emp.entity.Emp;
import com.zhjie.emp.service.EmpService;


@Controller
@RequestMapping("/emp")
public class EmpConteoller {

	
	@Autowired
	private  EmpService empService ;
	
	
	//  跳转页面
	@RequestMapping("/empHome/portal")
    public String empHome(){
        return "emp/empHome";
    }
	
	
	
	// 返回前台
	//查询所有符合条件的Emp
    @RequestMapping("/getEmps")
    @ResponseBody
    public  Map<String,Object> getEmps(int limit,int offset,String empno , String ename ,String job,String deptno ,String mgr){
    	Emp emp = new Emp();
    	emp.setStartSize(offset);
    	emp.setEndSize(offset+limit);
    	if("" != empno ){emp.setEmpno(Integer.parseInt(empno));}
    	emp.setEname(ename);
    	emp.setJob(job);
    	if("" != deptno ){emp.setDeptno(Integer.parseInt(deptno));}
    	if("" != mgr ){emp.setMgr(Integer.parseInt(mgr));}
   
    	PageHelper.startPage(offset, limit); 
    	List<Emp> data = empService.getEmps(emp);
    	PageInfo pageInfo=new PageInfo(data);
		 Map<String, Object> map = new HashMap<String, Object>();// 定义map
		 map.put("total", pageInfo.getTotal());// total键 存放总记录数，必须的
		 map.put("rows", data);// rows键 存放每页记录 list
		 return map;
    }
	
    //新增或更新员工信息
    @RequestMapping("/updateEmp")
    @ResponseBody
    public String updateEmp(String empno , String ename ,String job,String deptno ,String mgr,String sal,String comm , String  hiredate){
    	Emp emp = new Emp();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	if(null != empno && "" != empno ){emp.setEmpno(Integer.parseInt(empno));}
    	if(null != ename && "" != ename ) emp.setEname(ename);
    	if(null != job && "" != job ) emp.setJob(job);
    	if(null != deptno && "" != deptno ){emp.setDeptno(Integer.parseInt(deptno));}
    	if(null != mgr && "" != mgr ){emp.setMgr(Integer.parseInt(mgr));}
    	if(null != sal && "" != sal ) emp.setSal(Integer.parseInt(sal));
    	if(null != hiredate && "" != hiredate )
			try {
				emp.setHiredate(sdf.parse(hiredate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	
    	if(emp.getEmpno() != 0  ){
    		int r = empService.updateEmp(emp);//更新员工信息
    		if( r == 1 ){
    			return "updateOk";
    		}else{
    			return "updateFail";
    		} 
    	}else{
    		int r = empService.addEmp(emp); // 添加一个新员工信息
    		if( r == 1){
    			return "addOk";
    		}else{
    			return "addFail";
    		}
    	}
    }
    
    
    //新增或更新员工信息
    @RequestMapping("/deleteEmp")
    @ResponseBody
    public String deleteEmp(String empno){
    	Emp emp = new Emp();
    	if(null != empno && "" != empno ){emp.setEmpno(Integer.parseInt(empno));}
    		int r = empService.deleteEmp(emp); // 添加一个新员工信息
    		if( r == 1){
    			return "deleteOk";
    		}else{
    			return "deleteFail";
    		}
    }
	
}
