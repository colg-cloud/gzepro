package com.gzepro.ms.service.impl;

import static com.gzepro.ms.util.CheckUtil.throwFail;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.gzepro.ms.core.BaseServiceImpl;
import com.gzepro.ms.model.DemoProductCategory;
import com.gzepro.ms.service.DemoProductCategoryService;
import com.gzepro.ms.service.DemoProductInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author colg
 */
@Slf4j
@Service
public class DemoProductCategoryServiceImpl extends BaseServiceImpl implements DemoProductCategoryService {

    @Autowired
    private DemoProductInfoService demoProductInfoService;
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public DemoProductCategory insert(DemoProductCategory demoProductCategory) {
        demoProductCategoryMapper.insertSelective(demoProductCategory);
        log.info("DemoProductCategoryServiceImpl.insert() >> 添加商品类目成功 : {}", demoProductCategory.getCategoryId());
        return demoProductCategoryMapper.selectByPrimaryKey(demoProductCategory.getCategoryId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(DemoProductCategory demoProductCategory) {
        // 获取商品类目下的商品列表
        DemoProductCategory dpc = demoProductCategoryMapper.selectByPrimaryKey(demoProductCategory.getCategoryId());
        // 修改商品信息的类目
        demoProductInfoService.selectByCategoryType(dpc.getCategoryType()).forEach(e -> {
            e.setCategoryType(demoProductCategory.getCategoryType());
            demoProductInfoMapper.updateByPrimaryKey(e);
        });

        // 修改商品类目
        demoProductCategoryMapper.updateByPrimaryKey(demoProductCategory);

        if (RandomUtils.nextBoolean()) {
            throwFail("测试事务是否回滚");
        }
    }

    @Override
    public List<DemoProductCategory> selectProductCategory(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize)
                         .doSelectPage(() -> demoProductCategoryMapper.selectAll());
    }

    @Override
    public List<DemoProductCategory> selectByCategoryType(Integer categoryType) {
        return demoProductCategoryMapper.selectByCategoryType(categoryType);
    }

    @Override
    public DemoProductCategory insertMongo(DemoProductCategory demoProductCategory) {
        // 插入
        mongoTemplate.insert(demoProductCategory, "demo_product_category");
        log.info("DemoProductCategoryServiceImpl.insertMongo() >> mongodb插入数据 : {}", demoProductCategory);
        
        // 查询
        CriteriaDefinition criteriaDefinition = Criteria.where("categoryId").is(demoProductCategory.getCategoryId());
        Query query = new Query().addCriteria(criteriaDefinition);
        DemoProductCategory category = mongoTemplate.findOne(query , DemoProductCategory.class, "demo_product_category");
        return category;
    }

}
