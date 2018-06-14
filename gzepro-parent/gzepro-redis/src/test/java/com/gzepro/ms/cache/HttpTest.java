package com.gzepro.ms.cache;

import org.junit.Test;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import cn.hutool.http.HttpUtil;

/**
 * 测试 http 请求
 *
 * @author colg
 */
public class HttpTest {

    @Test
    public void testName() throws Exception {
        int count = 100;
        for (int i = 0; i < count; i++) {
            Console.log(selectProductCategory9101());
            Console.log(selectProductCategory9161());
            Console.log(findProductInfo9151());
        }
    }

    public String selectProductCategory9101() {
        String urlString = "http://127.0.0.1:9101/demo/product/selectProductCategory";
        Dict paramMap = new Dict().set("pageNum", 1).set("pageSize", 10);
        return HttpUtil.get(urlString, paramMap);
    }

    public String selectProductCategory9161() {
        String urlString = "http://127.0.0.1:9161/history/selectProductCategory";
        Dict paramMap = new Dict().set("pageNum", 1).set("pageSize", 10);
        return HttpUtil.get(urlString, paramMap);
    }

    public String findProductInfo9151() {
        String urlString = "http://127.0.0.1:9151/manage/findProductInfo";
        Dict paramMap = new Dict().set("productId", "0ec36dca08354af1ba9d12c2e478763b");
        return HttpUtil.get(urlString, paramMap);
    }
}
