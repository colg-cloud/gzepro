package com.gzepro.ms.controller;

import static com.gzepro.ms.util.CheckUtil.checkNotNull;
import static com.gzepro.ms.util.ResultVoUtil.success;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzepro.ms.core.BaseController;
import com.gzepro.ms.model.DemoProductCategory;
import com.gzepro.ms.model.DemoProductInfo;
import com.gzepro.ms.vo.ResultVo;

import cn.hutool.core.util.RandomUtil;

/**
 * 商品 Controller
 *
 * @author colg
 */
@RestController
@RequestMapping("/demo/product")
public class DemoProductController extends BaseController {

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
        DemoProductCategory demoProductCategory = new DemoProductCategory(RandomUtil.simpleUUID(), categoryName, categoryType);
        DemoProductCategory dbDemoProductCategory = demoProductCategoryService.insert(demoProductCategory);
        return success(dbDemoProductCategory);
    }
    
    /**
     * 分页查询商品类目
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectProductCategory")
    public ResultVo list(@RequestParam("pageNum") int pageNum,
                         @RequestParam("pageSize") int pageSize) {
        List<DemoProductCategory> demoProductCategorieList = demoProductCategoryService.selectProductCategory(pageNum, pageSize);
        return success(demoProductCategorieList);
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
        DemoProductCategory demoProductCategory = new DemoProductCategory(categoryId, categoryName, categoryType);
        demoProductCategoryService.update(demoProductCategory);
        return success();
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
        List<DemoProductCategory> list = demoProductCategoryService.selectByCategoryType(categoryType);
        checkNotNull(list, "商品类目编号错误");
        
        DemoProductInfo demoProductInfo = new DemoProductInfo(RandomUtil.simpleUUID(), categoryType, productName, productPrice, productStock, productDescription, productIcon);
        return success(demoProductInfoService.insertProductInfo(demoProductInfo));
    }
    
    /// ----------------------------------------------------------------------------------------------------

    // redis
    
    /**
     * 根据id查询商品 - redis 测试
     *
     * @param productId
     * @return
     */
    @GetMapping("/findProductInfo")
    public ResultVo findProductInfo(@RequestParam("productId") String productId) {
        return success(demoProductInfoService.findProductInfo(productId));
    }
    
    /**
     * 删除商品信息 - redis 测试
     *
     * @param productId
     * @return
     */
    @PostMapping("/deleteProductInfo")
    public ResultVo deleteProductInfo(@RequestParam("productId") String productId) {
        demoProductInfoService.deleteProductInfo(productId);
        return success();
    }
    
    /// ----------------------------------------------------------------------------------------------------

    // mongodb
    
    /**
     * 添加商品类目 - mongodb
     *
     * @param categoryName
     * @param categoryType
     * @return
     */
    @PostMapping("/insertProductCategoryMongo")
    public ResultVo insertProductCategoryMongo(@RequestParam("categoryName") String categoryName,
                                               @RequestParam("categoryType") Integer categoryType) {
        DemoProductCategory demoProductCategory = new DemoProductCategory(RandomUtil.simpleUUID(), categoryName, categoryType);
        
        demoProductCategory.setCreateTime(new Date())
                           .setUpdateTime(new Date());
        
        DemoProductCategory dbDemoProductCategory = demoProductCategoryService.insertMongo(demoProductCategory);
        return success(dbDemoProductCategory);
    }
}