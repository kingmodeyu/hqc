package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工角色表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司id
     */
    @TableId("companyId")
    private Integer companyId;

    /**
     * 员工id
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 角色id
     */
    @TableField("roleId")
    private Integer roleId;


}
