package com.hqc.user.config;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hqc.user.entity.HqcDepartmentUser;
import com.hqc.user.entity.HqcRole;
import com.hqc.user.entity.HqcUserRole;
import com.hqc.user.service.IHqcDepartmentUserService;
import com.hqc.user.service.IHqcRoleService;
import com.hqc.user.service.IHqcUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IHqcDepartmentUserService userService;

    @Autowired
    private IHqcUserRoleService userRoleService;

    @Autowired
    private IHqcRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        HqcDepartmentUser hqcDepartmentUser = userService.getById(userId);
        // 判断用户是否存在
        if(hqcDepartmentUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        HqcUserRole role = new HqcUserRole();
        role.setUserId(Integer.parseInt(userId));
        Wrapper<HqcUserRole> queryWrapper = new QueryWrapper<HqcUserRole>(role);
        List<HqcUserRole> roles = userRoleService.list(queryWrapper);
        for (HqcUserRole hqcUserRole : roles) {
            HqcRole hqcRole = roleService.getById(hqcUserRole.getRoleId());
            ((ArrayList<GrantedAuthority>) authorities).add(new SimpleGrantedAuthority(hqcRole.getRoleName()));
        }


        // 返回UserDetails实现类
        return new User(hqcDepartmentUser.getUserName(), hqcDepartmentUser.getUserPassword(), authorities);
    }
}
