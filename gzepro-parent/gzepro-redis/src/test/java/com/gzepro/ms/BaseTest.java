package com.gzepro.ms;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzepro.ms.config.RedisConfig;

/**
 * 测试 基础类
 *
 * @author colg
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
public abstract class BaseTest {}
