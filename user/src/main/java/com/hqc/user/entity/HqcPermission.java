package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId(value = "permissionId", type = IdType.AUTO)
    private Integer permissionId;

    /**
     * 公司id
     */
    @TableField("companyId")
    private Integer companyId;

    /**
     * 权限名称
     */
    @TableField("permissionName")
    private String permissionName;

    /**
     * 权限链接
     */
    @TableField("permissionUrl")
    private String permissionUrl;

    /**
     * 权限组
     */
    @TableField("permissionGroupId")
    private String permissionGroupId;


}
