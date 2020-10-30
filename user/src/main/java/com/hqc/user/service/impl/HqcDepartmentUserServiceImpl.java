package com.hqc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hqc.user.entity.HqcDepartmentUser;
import com.hqc.user.entity.HqcRole;
import com.hqc.user.entity.HqcUserRole;
import com.hqc.user.mapper.HqcDepartmentUserMapper;
import com.hqc.user.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 部门员工信息表 服务实现类
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Service
public class HqcDepartmentUserServiceImpl extends ServiceImpl<HqcDepartmentUserMapper, HqcDepartmentUser> {

}
