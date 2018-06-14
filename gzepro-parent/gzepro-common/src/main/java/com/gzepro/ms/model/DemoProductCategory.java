package com.gzepro.ms.model;

import java.io.Serializable;
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
@Table(name = "demo_product_category")
public class DemoProductCategory extends BaseEntity implements Serializable {
    /**
     * 商品类目id
     */
    @Id
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 类目名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 类目编号（唯一））
     */
    @Column(name = "category_type")
    private Integer categoryType;

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

    public DemoProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public DemoProductCategory(String categoryId, String categoryName, Integer categoryType) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}