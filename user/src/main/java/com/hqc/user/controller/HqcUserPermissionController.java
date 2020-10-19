package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcUserPermission;
import com.hqc.user.service.IHqcUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 员工权限表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-user-permission")
public class HqcUserPermissionController {

    @Autowired
    private IHqcUserPermissionService hqcUserPermissionService;

    @RequestMapping("/addUserPermission")
    public String addmenuGroup(@RequestBody HqcUserPermission userPermission) {
        hqcUserPermissionService.save(userPermission);
        return "index";
    }

    @RequestMapping("/delUserPermission")
    public String delmenuGroup(@RequestBody HqcUserPermission userPermission) {
        Wrapper<HqcUserPermission> queryWrapper = new QueryWrapper<HqcUserPermission>(userPermission);
        hqcUserPermissionService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updUserPermission")
    public String updmenuGroup(@RequestBody HqcUserPermission userPermission) {
        UpdateWrapper<HqcUserPermission> updateWrapperWrapper = new UpdateWrapper<HqcUserPermission>();
        updateWrapperWrapper.eq("userId",userPermission.getUserId());

        hqcUserPermissionService.update(userPermission,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryUserPermission")
    public ModelAndView querymenuGroup(@RequestBody HqcUserPermission userPermission) {
        Wrapper<HqcUserPermission> queryWrapper = new QueryWrapper<HqcUserPermission>(userPermission);
        List<HqcUserPermission> list = hqcUserPermissionService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
