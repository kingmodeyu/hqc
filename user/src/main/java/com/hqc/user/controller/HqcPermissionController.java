package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcPermission;
import com.hqc.user.service.IHqcPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-permission")
public class HqcPermissionController {

    @Autowired
    private IHqcPermissionService HqcPermissionService;

    @RequestMapping("/addPermission")
    public String addmenuGroup(@RequestBody HqcPermission permission) {
        HqcPermissionService.save(permission);
        return "index";
    }

    @RequestMapping("/delPermission")
    public String delmenuGroup(@RequestBody HqcPermission permission) {
        Wrapper<HqcPermission> queryWrapper = new QueryWrapper<HqcPermission>(permission);
        HqcPermissionService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updPermission")
    public String updmenuGroup(@RequestBody HqcPermission permission) {
        UpdateWrapper<HqcPermission> updateWrapperWrapper = new UpdateWrapper<HqcPermission>();
        updateWrapperWrapper.eq("permissionId",permission.getPermissionId());

        HqcPermissionService.update(permission,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryPermission")
    public ModelAndView querymenuGroup(@RequestBody HqcPermission permission) {
        Wrapper<HqcPermission> queryWrapper = new QueryWrapper<HqcPermission>(permission);
        List<HqcPermission> list = HqcPermissionService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }
}
