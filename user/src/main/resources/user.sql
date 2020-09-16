CREATE TABLE `hqc_company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `companyName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名称',
  `valid` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'Y' COMMENT 'Y:有效/N:无效',
  PRIMARY KEY (`companyId`,`companyName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='公司信息表';

CREATE TABLE `hqc_company_department` (
  `companyId` int(11) NOT NULL COMMENT '公司id',
	`departmentId` int(11) NOT NULL COMMENT '部门id',
  `departmentName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`companyId`,`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='公司部门信息表';

CREATE TABLE `hqc_department_user` (
	`departmentId` int(11) NOT NULL COMMENT '部门id',
	`userId` int(11) NOT NULL COMMENT '员工id',
  `userName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工名称',
	`userRole` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工角色',
	`valid` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'Y' COMMENT 'Y:有效/N:无效',
  PRIMARY KEY (`departmentId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='部门员工信息表';

CREATE TABLE `hqc_role` (
	`roleId` int(11) NOT NULL COMMENT '角色id',
  `roleName` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
	`valid` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'Y' COMMENT 'Y:有效/N:无效',
  PRIMARY KEY (`roleId`,`roleName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色信息表';