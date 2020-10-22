package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcCompany;
import com.hqc.user.entity.HqcUserRole;
import com.hqc.user.service.IHqcCompanyService;
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
 * 公司信息表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-company")
public class HqcCompanyController {

    @Autowired
    private IHqcCompanyService hqcCompanyService;

    @ApiOperation(value = "新增公司")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = HqcCompany.class) })
    @RequestMapping("/addCompany")
    public String addCompany(@RequestBody HqcCompany company) {
        hqcCompanyService.save(company);
        return "index";
    }

    @ApiOperation(value = "删除公司")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = HqcCompany.class) })
    @RequestMapping("/delCompany")
    public String delCompany(@RequestBody HqcCompany company) {
        Wrapper<HqcCompany> queryWrapper = new QueryWrapper<HqcCompany>(company);
        hqcCompanyService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新公司")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updCompany")
    public String updCompany(@RequestBody HqcCompany company) {
        UpdateWrapper<HqcCompany>updateWrapperWrapper = new UpdateWrapper<HqcCompany>();
        updateWrapperWrapper.eq("companyId",company.getCompanyId());

        hqcCompanyService.update(company,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询公司")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryCompany")
    public ModelAndView queryCompany(@RequestBody HqcCompany company) {
        //model.addAttribute("welcome","hello fishpro");
        Wrapper<HqcCompany> queryWrapper = new QueryWrapper<HqcCompany>(company);
        List<HqcCompany> list = hqcCompanyService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
