package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcPermissionGroup;
import com.hqc.user.service.IHqcPermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 权限组表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-permission-group")
public class HqcPermissionGroupController {

    @Autowired
    private IHqcPermissionGroupService hqcPermissionGroupService;

    @RequestMapping("/addPermissionGroup")
    public String addmenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        hqcPermissionGroupService.save(permissionGroup);
        return "index";
    }

    @RequestMapping("/delPermissionGroup")
    public String delmenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        Wrapper<HqcPermissionGroup> queryWrapper = new QueryWrapper<HqcPermissionGroup>(permissionGroup);
        hqcPermissionGroupService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updPermissionGroup")
    public String updmenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        UpdateWrapper<HqcPermissionGroup> updateWrapperWrapper = new UpdateWrapper<HqcPermissionGroup>();
        updateWrapperWrapper.eq("permissionGroupId",permissionGroup.getPermissionGroupId());

        hqcPermissionGroupService.update(permissionGroup,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryPermissionGroup")
    public ModelAndView querymenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        Wrapper<HqcPermissionGroup> queryWrapper = new QueryWrapper<HqcPermissionGroup>(permissionGroup);
        List<HqcPermissionGroup> list = hqcPermissionGroupService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
