package cn.com.glsx.usercenter.api.feign.factory;

import cn.com.glsx.usercenter.api.feign.ApiUserService;
import cn.com.glsx.usercenter.api.feign.fallback.ApiUserServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ApiUserServiceFallbackFactory implements FallbackFactory<ApiUserService> {

    @Override
    public ApiUserService create(Throwable throwable) {
        ApiUserServiceFallbackImpl fallback = new ApiUserServiceFallbackImpl();
        fallback.setCause(throwable);
        return fallback;
    }

}
