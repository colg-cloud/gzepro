package com.gzepro.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzepro.ms.service.DemoProductClientService;
import com.gzepro.ms.vo.ResultVo;

/**
 * 管理中心 - 测试
 *
 * @author colg
 */
@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private DemoProductClientService demoProductClientService;

    /**
     * 根据id查询商品 - redis 测试
     *
     * @param productId
     * @return
     */
    @GetMapping("/findProductInfo")
    public ResultVo findProductInfo(@RequestParam("productId") String productId) {
        return demoProductClientService.findProductInfo(productId);
    }
}
