package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId(value = "menuId", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 公司id
     */
    @TableField("companyId")
    private Integer companyId;

    /**
     * 菜单名称
     */
    @TableField("menuName")
    private String menuName;

    /**
     * 菜单链接
     */
    @TableField("menuUrl")
    private String menuUrl;

    /**
     * 菜单组
     */
    @TableField("menuGroup")
    private String menuGroup;


}
