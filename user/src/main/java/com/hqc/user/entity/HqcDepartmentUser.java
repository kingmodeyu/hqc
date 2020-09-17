package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门员工信息表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcDepartmentUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId("departmentId")
    private Integer departmentId;

    /**
     * 员工id
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 员工名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 员工角色
     */
    @TableField("userRole")
    private String userRole;

    /**
     * Y:有效/N:无效
     */
    private String valid;


}
