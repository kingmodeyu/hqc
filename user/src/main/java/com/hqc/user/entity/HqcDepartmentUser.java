package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcDepartmentUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工id
     */
    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    /**
     * 部门id
     */
    @TableField("departmentId")
    private Integer departmentId;

    /**
     * 员工名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 员工性别
     */
    @TableField("userSex")
    private String userSex;

    /**
     * 员工生日
     */
    @TableField("userBirthday")
    private LocalDateTime userBirthday;

    /**
     * 员工账号
     */
    @TableField("userAccount")
    private String userAccount;

    /**
     * 员工密码
     */
    @TableField("userPassword")
    private String userPassword;

    /**
     * Y:在职/N:离职
     */
    private String valid;


}
