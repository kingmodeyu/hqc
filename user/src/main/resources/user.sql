-- rbac
-- companyId用来扩展
CREATE TABLE `hqc_company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `companyName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名称',
  `companyAddress` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司地址',
  `companyPhone` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司电话',
  `valid` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'Y' COMMENT 'Y:有效/N:无效',
  PRIMARY KEY (`companyId`,`companyName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='公司信息表';

CREATE TABLE `hqc_company_department` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
  `departmentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `departmentName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门名称',
  `departmentPhone` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门电话',
  `departmentDuty` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门职责',
  PRIMARY KEY (`companyId`,`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='公司部门信息表';

CREATE TABLE `hqc_department_user` (
  `departmentId` int(11) NOT NULL COMMENT '部门id',
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `userName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工名称',
  `userSex` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工性别',
  `userBirthday` datetime(60)  NOT NULL COMMENT '员工生日',
  `userAccount` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工账号',
  `userPassword` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工密码',
  `valid` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'Y' COMMENT 'Y:在职/N:离职',
  PRIMARY KEY (`departmentId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='部门员工信息表';

CREATE TABLE `hqc_role` (
  `companyId` int(11) NOT NULL '公司id',
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT COMMENT '角色id',
  `roleName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
  `valid` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'Y' COMMENT 'Y:有效/N:无效',
  PRIMARY KEY (`companyId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色信息表';

CREATE TABLE `hqc_permission` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
  `permissionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permissionName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限名称',
  `permissionUrl` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限链接',
  `permissionGroupId` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限组'
  PRIMARY KEY (`companyId`,`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限表';

CREATE TABLE `hqc_permission_group` (
  `companyId` int(11) NOT NULL '公司id',
  `permissionGroupId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限组id',
  `permissionGroupName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限组名称',
  PRIMARY KEY (`companyId`,`permissionGroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限组表';

CREATE TABLE `hqc_menu` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `menuId` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menuName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `menuUrl` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单链接',
  `menuGroup` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单组',
  PRIMARY KEY (`companyId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单表';

CREATE TABLE `hqc_menu_Group` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
  `menuGroupId` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单组id',
  `menuGroupName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单组名称',
  PRIMARY KEY (`companyId`,`menuGroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单组表';

-- 菜单权限
CREATE TABLE `hqc_user_menu` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
  `userId` int(11) NOT NULL COMMENT '员工id',
  `menuId` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`companyId`,`userId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='员工菜单权限表';

CREATE TABLE `hqc_role_menu` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
  `roleId` int(11) NOT NULL COMMENT '员工id',
  `menuId` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`companyId`,`roleId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色菜单权限表';


-- 资源权限
CREATE TABLE `hqc_user_permission` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
  `userId` int(11) NOT NULL COMMENT '员工id',
  `permissionId` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`companyId`,`userId`,`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='员工权限表';

CREATE TABLE `hqc_role_permission` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
  `roleId` int(11) NOT NULL COMMENT '员工id',
  `permissionId` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`companyId`,`roleId`,`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色菜单权限表';

-- 数据权限暂不考虑（熟悉mybatisPlus之后再考虑通过sql方式拼接） 需要设计sql条件拼接（保存为数据权限）表 员工数据权限表 角色数据权限表