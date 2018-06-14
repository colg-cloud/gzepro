package com.gzepro.ms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import com.gzepro.ms.core.BaseEntity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * - @mbg.generated
 *
 * @author colg
 */
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "demo_product_info")
public class DemoProductInfo extends BaseEntity implements Serializable {
    /**
     * 商品id
     */
    @Id
    @Column(name = "product_id")
    private String productId;

    /**
     * 商品类目编号
     */
    @Column(name = "category_type")
    private Integer categoryType;

    /**
     * 名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 单价
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @Column(name = "product_stock")
    private Integer productStock;

    /**
     * 描述
     */
    @Column(name = "product_description")
    private String productDescription;

    /**
     * 小图
     */
    @Column(name = "product_icon")
    private String productIcon;

    /**
     * 状态（0正常，1下架；默认0）
     */
    @Column(name = "product_status")
    private Integer productStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time", insertable = false, updatable = false)
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /// ----------------------------------------------------------------------------------------------------

    public DemoProductInfo(String productId, Integer categoryType, String productName, BigDecimal productPrice, Integer productStock, String productDescription,
        String productIcon) {
        this.productId = productId;
        this.categoryType = categoryType;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
    }
}