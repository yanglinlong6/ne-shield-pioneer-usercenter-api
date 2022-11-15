package cn.com.glsx.usercenter.api.feign.factory;

import cn.com.glsx.usercenter.api.feign.UserService;
import cn.com.glsx.usercenter.api.feign.fallback.UserServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {
        UserServiceFallbackImpl fallback = new UserServiceFallbackImpl();
        fallback.setCause(throwable);
        return fallback;
    }

}
