package com.hqc.user.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcMenu;
import com.hqc.user.service.IHqcMenuService;
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
 * 菜单表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/menu/hqc-menu")
public class HqcMenuController {

    @Autowired
    private IHqcMenuService hqcMenmenuvice;

    @ApiOperation(value = "新增菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addMenu")
    public String addmenu(@RequestBody HqcMenu menu) {
        hqcMenmenuvice.save(menu);
        return "index";
    }

    @ApiOperation(value = "删除菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delMenu")
    public String delmenu(@RequestBody HqcMenu menu) {
        Wrapper<HqcMenu> queryWrapper = new QueryWrapper<HqcMenu>(menu);
        hqcMenmenuvice.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updMenu")
    public String updmenu(@RequestBody HqcMenu menu) {
        UpdateWrapper<HqcMenu> updateWrapperWrapper = new UpdateWrapper<HqcMenu>();
        updateWrapperWrapper.eq("menuId",menu.getMenuId());

        hqcMenmenuvice.update(menu,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryMenu")
    public ModelAndView querymenu(@RequestBody HqcMenu menu) {
        Wrapper<HqcMenu> queryWrapper = new QueryWrapper<HqcMenu>(menu);
        List<HqcMenu> list = hqcMenmenuvice.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
