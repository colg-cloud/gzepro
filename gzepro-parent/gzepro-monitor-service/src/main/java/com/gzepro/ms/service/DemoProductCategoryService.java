package com.gzepro.ms.service;

import java.util.List;

import com.gzepro.ms.model.DemoProductCategory;

/**
 * 
 *
 * @author colg
 */
public interface DemoProductCategoryService {

    /**
     * 添加商品类目
     *
     * @param demoProductCategory
     * @return
     */
    DemoProductCategory insert(DemoProductCategory demoProductCategory);

    /**
     * 修改商品类目 - 事务测试
     *
     * @param demoProductCategory
     */
    void update(DemoProductCategory demoProductCategory);

    /**
     * 分页查询商品类目
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<DemoProductCategory> selectProductCategory(int pageNum, int pageSize);

    /**
     * 根据商品类目编号查询商品类目列表
     *
     * @param categoryType
     * @return
     */
    List<DemoProductCategory> selectByCategoryType(Integer categoryType);

    /// ----------------------------------------------------------------------------------------------------

    /// mongodb
    
    /**
     * 添加商品类目 - mongodb
     *
     * @param demoProductCategory
     * @return
     * @author colg
     */
    DemoProductCategory insertMongo(DemoProductCategory demoProductCategory);

}
