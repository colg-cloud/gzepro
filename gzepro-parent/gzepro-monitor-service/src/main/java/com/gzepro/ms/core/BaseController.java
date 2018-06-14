package com.gzepro.ms.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.gzepro.ms.service.DemoProductCategoryService;
import com.gzepro.ms.service.DemoProductInfoService;

/**
 * Controller 基础类
 *
 * @author colg
 */
public abstract class BaseController {

    @Autowired
    protected DemoProductInfoService demoProductInfoService;
    @Autowired
    protected DemoProductCategoryService demoProductCategoryService;
}
