package com.hqc.user.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcMenuGroup;
import com.hqc.user.service.IHqcMenuGroupService;
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

    @ApiOperation(value = "新增菜单组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addMenuGroup")
    public String addMenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        hqcMenuGroupService.save(menuGroup);
        return "index";
    }

    @ApiOperation(value = "删除菜单组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delMenuGroup")
    public String delmenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        Wrapper<HqcMenuGroup> queryWrapper = new QueryWrapper<HqcMenuGroup>(menuGroup);
        hqcMenuGroupService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新菜单组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updMenuGroup")
    public String updmenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        UpdateWrapper<HqcMenuGroup> updateWrapperWrapper = new UpdateWrapper<HqcMenuGroup>();
        updateWrapperWrapper.eq("menuGroupId",menuGroup.getMenuGroupId());

        hqcMenuGroupService.update(menuGroup,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询菜单组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryMenuGroup")
    public ModelAndView querymenuGroup(@RequestBody HqcMenuGroup menuGroup) {
        Wrapper<HqcMenuGroup> queryWrapper = new QueryWrapper<HqcMenuGroup>(menuGroup);
        List<HqcMenuGroup> list = hqcMenuGroupService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
