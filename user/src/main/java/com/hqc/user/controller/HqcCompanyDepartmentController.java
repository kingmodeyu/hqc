package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcCompanyDepartment;
import com.hqc.user.service.IHqcCompanyDepartmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "新增部门")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addDepartment")
    public String addDepartment(@RequestBody HqcCompanyDepartment department) {
        hqcCompanyDepartmentService.save(department);
        return "index";
    }

    @ApiOperation(value = "删除部门")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delDepartment")
    public String delDepartment(@RequestBody HqcCompanyDepartment department) {
        Wrapper<HqcCompanyDepartment> queryWrapper = new QueryWrapper<HqcCompanyDepartment>(department);
        hqcCompanyDepartmentService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新部门")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updDepartment")
    public String updDepartment(@RequestBody HqcCompanyDepartment department) {
        UpdateWrapper<HqcCompanyDepartment> updateWrapperWrapper = new UpdateWrapper<HqcCompanyDepartment>();
        updateWrapperWrapper.eq("departmentId",department.getDepartmentId());

        hqcCompanyDepartmentService.update(department,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询部门")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryDepartment")
    public ModelAndView queryDepartment(@RequestBody HqcCompanyDepartment department) {
        //model.addAttribute("welcome","hello fishpro");
        Wrapper<HqcCompanyDepartment> queryWrapper = new QueryWrapper<HqcCompanyDepartment>(department);
        List<HqcCompanyDepartment> list = hqcCompanyDepartmentService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
