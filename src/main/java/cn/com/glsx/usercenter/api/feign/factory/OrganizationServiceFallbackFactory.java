package cn.com.glsx.usercenter.api.feign.factory;

import cn.com.glsx.usercenter.api.feign.OrganizationService;
import cn.com.glsx.usercenter.api.feign.fallback.OrganizationServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrganizationServiceFallbackFactory implements FallbackFactory<OrganizationService> {

    @Override
    public OrganizationService create(Throwable throwable) {
        OrganizationServiceFallbackImpl fallback = new OrganizationServiceFallbackImpl();
        fallback.setCause(throwable);
        return fallback;
    }

}
