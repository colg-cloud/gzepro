package com.gzepro.ms.service;

import java.util.List;

import com.gzepro.ms.model.DemoProductInfo;

/**
 * 
 *
 * @author colg
 */
public interface DemoProductInfoService {

    /**
     * 根据商品类目查询商品列表
     *
     * @param categoryType
     * @return
     * @author colg
     */
    List<DemoProductInfo> selectByCategoryType(Integer categoryType);

    /**
     * 添加商品 - redis 测试
     *
     * @param demoProductInfo
     * @return
     * @author colg
     */
    DemoProductInfo insertProductInfo(DemoProductInfo demoProductInfo);

    /**
     * 根据id查询商品 - redis 测试
     *
     * @param productId
     * @return
     * @author colg
     */
    DemoProductInfo findProductInfo(String productId);

    /**
     * 删除商品信息 - redis 测试
     *
     * @param productId
     * @author colg
     */
    void deleteProductInfo(String productId);
}
