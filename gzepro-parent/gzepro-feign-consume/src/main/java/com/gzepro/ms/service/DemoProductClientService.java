package com.gzepro.ms.service;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gzepro.ms.cons.ApplicationConst;
import com.gzepro.ms.fallback.DemoProductClientServiceFallback;
import com.gzepro.ms.vo.ResultVo;

/**
 * 商品服务 - 客户端
 * 
 * <pre>
 * `fallbackFactory = DemoProductClientServiceFallback.class`： 一旦返回异常信息，
 *  将进入 {@link com.gzepro.ms.fallback.DemoProductClientServiceFallback#create}，使用备用逻辑
 * </pre>
 *
 * @author colg
 */
@FeignClient(value = ApplicationConst.MONITOR_SERVICE, fallbackFactory = DemoProductClientServiceFallback.class)
@RequestMapping("/demo/product")
public interface DemoProductClientService {

    /**
     * 添加商品类目
     *
     * @param categoryName
     * @param categoryType
     * @return
     */
    @RequestMapping(value = "/insertProductCategory", method = RequestMethod.POST)
    ResultVo insertProductCategory(@RequestParam("categoryName") String categoryName,
                                   @RequestParam("categoryType") Integer categoryType);
    
    /**
     * 分页查询商品类目
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/selectProductCategory", method = RequestMethod.GET)
    ResultVo selectProductCategory(@RequestParam("pageNum") int pageNum,
                                   @RequestParam("pageSize") int pageSize);
    
    /**
     * 修改商品类目 - 事务测试
     *
     * @param categoryId
     * @param categoryName
     * @param categoryType
     * @return
     */
    @RequestMapping(value = "/updateProductCategory", method = RequestMethod.POST)
    ResultVo updateProductCategory(@RequestParam("categoryId") String categoryId,
                                   @RequestParam("categoryName") String categoryName,
                                   @RequestParam("categoryType") Integer categoryType);
    
    /**
     * 添加商品 - redis 测试
     *
     * @param categoryType
     * @param productName
     * @param productPrice
     * @param productStock
     * @param productDescription
     * @param productIcon
     * @return
     */
    @RequestMapping(value = "/insertProductInfo", method = RequestMethod.POST)
    ResultVo insertProductInfo(@RequestParam("categoryType") Integer categoryType,
                               @RequestParam("productName") String productName,
                               @RequestParam("productPrice") BigDecimal productPrice,
                               @RequestParam("productStock") Integer productStock,
                               @RequestParam("productDescription") String productDescription,
                               @RequestParam("productIcon") String productIcon);
    
    /**
     * 根据id查询商品 - redis 测试
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/findProductInfo", method = RequestMethod.GET)
    ResultVo findProductInfo(@RequestParam("productId") String productId);
    
    /**
     * 删除商品信息 - redis 测试
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/deleteProductInfo", method = RequestMethod.POST)
    ResultVo deleteProductInfo(@RequestParam("productId") String productId);
}
