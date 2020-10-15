package com.hqc.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HqcCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司id
     */
    @TableId(value = "companyId", type = IdType.AUTO)
    private Integer companyId;

    /**
     * 公司名称
     */
    @TableField("companyName")
    private String companyName;

    /**
     * 公司地址
     */
    @TableField("companyAddress")
    private String companyAddress;

    /**
     * 公司电话
     */
    @TableField("companyPhone")
    private String companyPhone;

    /**
     * Y:有效/N:无效
     */
    private String valid;


}
