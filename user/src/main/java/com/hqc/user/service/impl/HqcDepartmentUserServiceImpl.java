package com.hqc.user.service.impl;

import com.hqc.user.entity.HqcDepartmentUser;
import com.hqc.user.mapper.HqcDepartmentUserMapper;
import com.hqc.user.service.IHqcDepartmentUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hqc.user.service.IHqcRolePermissionService;
import com.hqc.user.service.IHqcUserPermissionService;
import com.hqc.user.service.IHqcUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门员工信息表 服务实现类
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Service
public class HqcDepartmentUserServiceImpl extends ServiceImpl<HqcDepartmentUserMapper, HqcDepartmentUser> implements IHqcDepartmentUserService {

    @Autowired
    private IHqcUserRoleService userRoleService;

    @Autowired
    private IHqcUserPermissionService userPermissionService;

    @Autowired
    private IHqcRolePermissionService rolePermissionService;


}
