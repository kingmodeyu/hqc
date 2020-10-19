package com.hqc.user.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcMenuGroup;
import com.hqc.user.service.IHqcMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 菜单组表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-menuGroup-group")
public class HqcMenuGroupController {

    @Autowired
    private IHqcMenuGroupService hqcMenuGroupService;

    @RequestMapping("/addMenuGroup")
    public String addmenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        hqcMenuGroupService.save(menuGroup);
        return "index";
    }

    @RequestMapping("/delMenuGroup")
    public String delmenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        Wrapper<HqcMenuGroup> queryWrapper = new QueryWrapper<HqcMenuGroup>(menuGroup);
        hqcMenuGroupService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updMenuGroup")
    public String updmenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        UpdateWrapper<HqcMenuGroup> updateWrapperWrapper = new UpdateWrapper<HqcMenuGroup>();
        updateWrapperWrapper.eq("menuGroupId",menuGroup.getMenuGroupId());

        hqcMenuGroupService.update(menuGroup,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryMenuGroup")
    public ModelAndView querymenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        Wrapper<HqcMenuGroup> queryWrapper = new QueryWrapper<HqcMenuGroup>(menuGroup);
        List<HqcMenuGroup> list = hqcMenuGroupService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
