package cn.com.glsx.usercenter.api.feign.fallback;

import cn.com.glsx.usercenter.api.dto.request.SimpleAddUser;
import cn.com.glsx.usercenter.api.dto.response.User;
import cn.com.glsx.usercenter.api.feign.ApiUserService;
import com.glsx.plat.core.web.R;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ApiUserServiceFallbackImpl implements ApiUserService {

    @Setter
    private Throwable cause;

    @Override
    public R<List<User>> findByAccount(String account) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<User>> findByUsername(String username) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<User> addSimpleUser(SimpleAddUser simpleAddUser) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

}
