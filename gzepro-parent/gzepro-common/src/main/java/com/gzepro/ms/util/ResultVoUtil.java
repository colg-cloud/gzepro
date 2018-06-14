package com.gzepro.ms.util;

import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;
import com.gzepro.ms.vo.ResultVo;

/**
 * http 请求工具类
 *
 * @author colg
 */
public class ResultVoUtil {
    
    public static ResultVo success() {
        return new ResultVo(ResultVo.SUCCESS, ResultVo.MSG_SUCCESS);
    }
    
    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo().setCode(ResultVo.SUCCESS)
                                          .setMsg(ResultVo.MSG_SUCCESS);
        if (data instanceof Page<?>) {
            Page<?> page = (Page<?>)data;
            resultVo.setData(page.getResult())
                    .setTotal(page.getTotal());
            
        } else if (data instanceof Collection<?>) {
            List<?> list = (List<?>)data;
            resultVo.setData(list)
                    .setTotal((long)list.size());
        } else {
            resultVo.setData(data);
        }
        return resultVo;
    }
    
    public static ResultVo fail(Integer code, String msg) {
        return new ResultVo(code, msg);
    }

}
