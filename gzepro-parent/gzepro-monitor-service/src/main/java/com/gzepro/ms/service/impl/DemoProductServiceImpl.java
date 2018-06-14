package com.gzepro.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzepro.ms.core.BaseServiceImpl;
import com.gzepro.ms.model.DemoProductInfo;
import com.gzepro.ms.service.DemoProductInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author colg
 */
@Slf4j
@Service
public class DemoProductServiceImpl extends BaseServiceImpl implements DemoProductInfoService {

    @Value("${product_pre}")
    private String productPre;

    @Override
    public List<DemoProductInfo> selectByCategoryType(Integer categoryType) {
        return demoProductInfoMapper.selectByCategoryType(categoryType);
    }

    @Override
    public DemoProductInfo insertProductInfo(DemoProductInfo demoProductInfo) {
        demoProductInfoMapper.insertSelective(demoProductInfo);
        DemoProductInfo dbDemoProductInfo = demoProductInfoMapper.selectByPrimaryKey(demoProductInfo.getProductId());

        // 保存到 redis
        String key = productPre + ":" + dbDemoProductInfo.getProductId();
        jedisClient.set(key, dbDemoProductInfo.toString());
        return dbDemoProductInfo;
    }

    @Override
    public DemoProductInfo findProductInfo(String productId) {
        // 从 redis 中取
        String key = productPre + ":" + productId;
        String result = jedisClient.get(key);
        log.info("DemoProductServiceImpl.findProductInfo() >> redis 取得的数据 : {}", result);
        return result == null ? demoProductInfoMapper.selectByPrimaryKey(productId) : JSON.parseObject(result, DemoProductInfo.class);
    }

    @Override
    public void deleteProductInfo(String productId) {
        demoProductInfoMapper.deleteByPrimaryKey(productId);

        // 从 redis 中删除
        jedisClient.del(productPre + ":" + productId);
    }

}
