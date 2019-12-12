package com.atguigu.springboot.exception;

public class UserNotExsitException extends RuntimeException{
    public UserNotExsitException() {
        super("用户不存在");
    }
}
