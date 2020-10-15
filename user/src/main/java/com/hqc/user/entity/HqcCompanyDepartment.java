package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公司部门信息表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcCompanyDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "departmentId", type = IdType.AUTO)
    private Integer departmentId;

    /**
     * 公司id
     */
    @TableField("companyId")
    private Integer companyId;

    /**
     * 部门名称
     */
    @TableField("departmentName")
    private String departmentName;

    /**
     * 部门电话
     */
    @TableField("departmentPhone")
    private String departmentPhone;

    /**
     * 部门职责
     */
    @TableField("departmentDuty")
    private String departmentDuty;


}
