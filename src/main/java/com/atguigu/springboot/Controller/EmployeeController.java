package com.atguigu.springboot.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    //注入一个对象，
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        //得到所有员工的集合
        Collection<Employee> employees= employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toaddPage(Model model){
        //来到添加页面，查出所有部门，在页面显示
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/addpage";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //SpringMVC自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名字和Javabean入参的对象里面的属性名相同
        //重定向到list页面
        //redirect表示重定向到一个页面        /表示当前项目路径
        //forward表示转发到一个地址
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //来到修改页面,查出当前员工，到页面回显
    @GetMapping("/emp/{id}")
    public String toEditpage(@PathVariable("id") Integer id,Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //修改添加二合一
        return "emp/addpage";
    }
    //修改员工数据
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
