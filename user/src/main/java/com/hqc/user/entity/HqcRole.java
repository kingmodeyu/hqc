package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "roleId", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 公司id
     */
    @TableField("companyId")
    private Integer companyId;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;

    /**
     * Y:有效/N:无效
     */
    private String valid;


}
