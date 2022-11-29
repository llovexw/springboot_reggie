package com.itlr.reggie.common;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-22-16:07
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}


