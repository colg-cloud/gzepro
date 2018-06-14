package com.gzepro.ms.util;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.gzepro.ms.exception.CheckException;

/**
 * 校验工具
 *
 * @author colg
 */
@Component
public final class CheckUtil {

    private static MessageSource messageSource;

    @Autowired
    public void init(MessageSource messageSource) {
        CheckUtil.messageSource = messageSource;
    }

    private CheckUtil() {}

    /**
     * 表达式的结果为 false 时，抛出校验异常
     *
     * @param bool 校验条件
     * @param msgKey 消息提示的 key ，支持国际化
     * @author colg
     */
    public static void checkTrue(boolean bool, String msgKey) {
        if (!bool) {
            throwFail(msgKey);
        }
    }

    /**
     * 表达式的结果为 true 时，抛出校验异常
     *
     * @param bool 校验条件
     * @param msgKey 消息提示的 key ，支持国际化
     * @author colg
     */
    public static void checkFalse(boolean bool, String msgKey) {
        if (bool) {
            throwFail(msgKey);
        }
    }

    /**
     * 对象，字符串，集合为空白时，抛出校验异常，空白的定义如下： <br>
     * 1、Object: 为 null <br>
     * 2、String: 为不可见字符（如空格） <br>
     * 3、String: "" <br>
     * 4、Collection/Map: size()==0 <br>
     *
     * @param value 需要校验的对象，字符串，集合
     * @param msgKey 消息提示的 key ，支持国际化
     * @author colg
     */
    public static void checkNotNull(Object value, String msgKey) {
        if (value == null) {
            throwFail(msgKey);
        }

        if (value instanceof String) {
            // 校验 String
            String str = (String)value;
            if (str.trim().length() == 0) {
                throwFail(msgKey);
            }
        } else if (value instanceof Collection<?>) {
            // 校验 Collection
            Collection<?> coll = (Collection<?>)value;
            if (coll.size() == 0) {
                throwFail(msgKey);
            }
        } else if (value instanceof Map<?, ?>) {
            // 校验 Map
            Map<?, ?> map = (Map<?, ?>)value;
            if (map.size() == 0) {
                throwFail(msgKey);
            }
        }
    }

    /**
     * 对象不为 null 时，抛出校验异常，空白的定义如下： <br>
     *
     * @param value 需要校验的对象
     * @param msgKey 消息提示的 key ，支持国际化
     * @author colg
     */
    public static void checkNull(Object value, String msgKey) {
        if (value != null) {
            throwFail(msgKey);
        }
    }

    /**
     * 抛出校验异常
     *
     * @param msgKey 消息提示的 key ，支持国际化。
     * @author colg
     */
    public static void throwFail(String msgKey) {
        Locale locale = LocaleContextHolder.getLocale();
        // 如果根据 msgKey 找不到 value ，则返回 msgKey 。
        String message = messageSource.getMessage(msgKey, null, msgKey, locale);
        throw new CheckException(message);
    }
}
