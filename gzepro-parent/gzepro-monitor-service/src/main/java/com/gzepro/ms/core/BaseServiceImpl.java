package com.gzepro.ms.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.gzepro.ms.cache.JedisClient;
import com.gzepro.ms.mapper.DemoProductCategoryMapper;
import com.gzepro.ms.mapper.DemoProductInfoMapper;

/**
 * ServiceImpl 基础类
 *
 * @author colg
 */
public abstract class BaseServiceImpl {

    @Autowired
    protected DemoProductInfoMapper demoProductInfoMapper;
    @Autowired
    protected DemoProductCategoryMapper demoProductCategoryMapper;

    /// ----------------------------------------------------------------------------------------------------

    @Autowired
    protected JedisClient jedisClient;

    @Autowired
    protected MongoTemplate mongoTemplate;
}
