package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcCompanyDepartment;
import com.hqc.user.service.IHqcCompanyDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 公司部门信息表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-company-department")
public class HqcCompanyDepartmentController {

    @Autowired
    private IHqcCompanyDepartmentService hqcCompanyDepartmentService;

    @RequestMapping("/addDepartment")
    public String addUser(@RequestBody HqcCompanyDepartment department) {
        hqcCompanyDepartmentService.save(department);
        return "index";
    }

    @RequestMapping("/delDepartment")
    public String delUser(@RequestBody HqcCompanyDepartment department) {
        Wrapper<HqcCompanyDepartment> queryWrapper = new QueryWrapper<HqcCompanyDepartment>(department);
        hqcCompanyDepartmentService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updDepartment")
    public String updUser(@RequestBody HqcCompanyDepartment department) {
        UpdateWrapper<HqcCompanyDepartment> updateWrapperWrapper = new UpdateWrapper<HqcCompanyDepartment>();
        updateWrapperWrapper.eq("departmentId",department.getDepartmentId());

        hqcCompanyDepartmentService.update(department,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryDepartment")
    public ModelAndView queryUser(@RequestBody HqcCompanyDepartment department) {
        //model.addAttribute("welcome","hello fishpro");
        Wrapper<HqcCompanyDepartment> queryWrapper = new QueryWrapper<HqcCompanyDepartment>(department);
        List<HqcCompanyDepartment> list = hqcCompanyDepartmentService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
