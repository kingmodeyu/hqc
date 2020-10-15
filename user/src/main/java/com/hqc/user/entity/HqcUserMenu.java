package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工菜单权限表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcUserMenu implements Serializable {

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
     * 菜单id
     */
    @TableField("menuId")
    private Integer menuId;


}
