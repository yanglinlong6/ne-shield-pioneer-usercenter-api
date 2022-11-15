package cn.com.glsx.usercenter.api.feign.fallback;

import cn.com.glsx.usercenter.api.dto.request.FindUserRequest;
import cn.com.glsx.usercenter.api.dto.response.User;
import cn.com.glsx.usercenter.api.feign.UserService;
import com.glsx.plat.core.web.R;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class UserServiceFallbackImpl implements UserService {

    @Setter
    private Throwable cause;

    @Override
    public R<List<User>> findAll() {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<User> getById(Long id) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<User> getSuperiorById(Long id) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<User>> getSuperiorByIds(Collection<Long> userIds) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<Set<Long>> getSubordinateById(Long userId) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<User>> findByUser(FindUserRequest request) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<User>> findByOrg(FindUserRequest request) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<User>> findAllByOrg(FindUserRequest request) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

}
