package com.gzepro.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzepro.ms.model.DemoProductInfo;

/**
 * - @mbg.generated
 *
 * @author colg
 */
public interface DemoProductInfoMapper extends tk.mybatis.mapper.common.Mapper<DemoProductInfo> {

    /**
     * 根据商品类目查询商品信息列表
     *
     * @param categoryType
     * @return
     */
    List<DemoProductInfo> selectByCategoryType(@Param("categoryType") Integer categoryType);

}