package com.gzepro.ms.fallback;

import static com.gzepro.ms.util.ResultVoUtil.fail;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.gzepro.ms.service.DemoProductClientService;
import com.gzepro.ms.vo.ResultVo;

import feign.hystrix.FallbackFactory;

/**
 * 商品服务 - 接口熔断处理（服务降级）
 *
 * @author colg
 */
@Component
public class DemoProductClientServiceFallback implements FallbackFactory<DemoProductClientService> {

    @Override
    public DemoProductClientService create(Throwable cause) {
        return new DemoProductClientService() {

            /** 通信异常 {@value} */
            private static final String ERROR_MSG = "服务通信异常，客户端服务已降级";

            @Override
            public ResultVo insertProductCategory(String categoryName, Integer categoryType) {
                return fail(ResultVo.CONNECTION_FAIL, ERROR_MSG);
            }

            @Override
            public ResultVo selectProductCategory(int pageNum, int pageSize) {
                return fail(ResultVo.CONNECTION_FAIL, ERROR_MSG);
            }

            @Override
            public ResultVo findProductInfo(String productId) {
                return fail(ResultVo.CONNECTION_FAIL, ERROR_MSG);
            }

            @Override
            public ResultVo updateProductCategory(String categoryId, String categoryName, Integer categoryType) {
                return fail(ResultVo.CONNECTION_FAIL, ERROR_MSG);
            }

            @Override
            public ResultVo insertProductInfo(Integer categoryType, String productName, BigDecimal productPrice, Integer productStock,
                String productDescription, String productIcon) {
                return fail(ResultVo.CONNECTION_FAIL, ERROR_MSG);
            }

            @Override
            public ResultVo deleteProductInfo(String productId) {
                return fail(ResultVo.CONNECTION_FAIL, ERROR_MSG);
            }
        };
    }

}
