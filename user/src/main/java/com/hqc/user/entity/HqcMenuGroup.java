package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单组表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("hqc_menu_Group")
public class HqcMenuGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司id
     */
    @TableId("companyId")
    private Integer companyId;

    /**
     * 菜单组id
     */
    @TableField("menuGroupId")
    private Integer menuGroupId;

    /**
     * 菜单组名称
     */
    @TableField("menuGroupName")
    private String menuGroupName;


}
