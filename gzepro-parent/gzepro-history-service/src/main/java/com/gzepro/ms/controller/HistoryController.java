package com.gzepro.ms.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzepro.ms.service.DemoProductClientService;
import com.gzepro.ms.vo.ResultVo;

/**
 * 历史信息查询管理
 *
 * @author colg
 */
@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private DemoProductClientService demoProductClientService;

    /**
     * 添加商品类目
     *
     * @param categoryName
     * @param categoryType
     * @return
     */
    @PostMapping("/insertProductCategory")
    public ResultVo insertProductCategory(@RequestParam("categoryName") String categoryName,
                                          @RequestParam("categoryType") Integer categoryType) {
        return demoProductClientService.insertProductCategory(categoryName, categoryType);
    }
    
    /**
     * 分页查询商品类目
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectProductCategory")
    public ResultVo selectProductCategory(@RequestParam("pageNum") int pageNum,
                                          @RequestParam("pageSize") int pageSize) {
        return demoProductClientService.selectProductCategory(pageNum, pageSize);
    }
    
    /**
     * 修改商品类目 - 事务测试
     *
     * @param categoryName
     * @param categoryType
     * @return
     */
    @PostMapping("/updateProductCategory")
    public ResultVo updateProductCategory(@RequestParam("categoryId") String categoryId,
                                          @RequestParam("categoryName") String categoryName,
                                          @RequestParam("categoryType") Integer categoryType) {
        return demoProductClientService.updateProductCategory(categoryId, categoryName, categoryType);
    }
    
    /**
     * 添加商品 - redis 测试
     *
     * @return
     */
    @PostMapping("/insertProductInfo")
    public ResultVo insertProductInfo(@RequestParam("categoryType") Integer categoryType,
                                      @RequestParam("productName") String productName,
                                      @RequestParam("productPrice") BigDecimal productPrice,
                                      @RequestParam("productStock") Integer productStock,
                                      @RequestParam("productDescription") String productDescription,
                                      @RequestParam("productIcon") String productIcon) {
        return demoProductClientService.insertProductInfo(categoryType, productName, productPrice, productStock, productDescription, productIcon);
    }
    
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
    
    /**
     * 删除商品信息 - redis 测试
     *
     * @param productId
     * @return
     */
    @PostMapping("/deleteProductInfo")
    public ResultVo deleteProductInfo(@RequestParam("productId") String productId) {
        return demoProductClientService.deleteProductInfo(productId);
    }
}
