package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限组表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcPermissionGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限组id
     */
    @TableId(value = "permissionGroupId", type = IdType.AUTO)
    private Integer permissionGroupId;

    /**
     * 公司id
     */
    @TableField("companyId")
    private Integer companyId;

    /**
     * 权限组名称
     */
    @TableField("permissionGroupName")
    private String permissionGroupName;


}
