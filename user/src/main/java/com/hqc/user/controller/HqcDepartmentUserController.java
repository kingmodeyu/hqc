package com.hqc.user.controller;


import com.hqc.user.service.IHqcDepartmentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门员工信息表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-department-user")
public class HqcDepartmentUserController {

    @Autowired
    private IHqcDepartmentUserService hqcDepartmentUserService;

}
