package com.gzepro.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzepro.ms.model.DemoProductCategory;

/**
 * - @mbg.generated
 *
 * @author colg
 */
public interface DemoProductCategoryMapper extends tk.mybatis.mapper.common.Mapper<DemoProductCategory> {

    /**
     * 根据商品类目编号查询
     *
     * @param categoryType
     * @return
     */
    List<DemoProductCategory> selectByCategoryType(@Param("categoryType") Integer categoryType);
}