package cn.com.glsx.usercenter.api.feign;

import cn.com.glsx.usercenter.api.dto.request.FindUserRequest;
import cn.com.glsx.usercenter.api.dto.response.User;
import cn.com.glsx.usercenter.api.feign.factory.UserServiceFallbackFactory;
import com.glsx.plat.core.web.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@FeignClient(
        name = "${feign.usercenter.name}",
        path = "${feign.usercenter.path}" + "/fuser",
        contextId = "feignUser",
        fallbackFactory = UserServiceFallbackFactory.class,
        decode404 = true
)
public interface UserService {

    /**
     * 获取所有（特定租户）用户
     *
     * @return
     */
    @GetMapping(value = "/findAll", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<User>> findAll();

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getById", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<User> getById(@RequestParam("id") Long id);

    /**
     * 根据id获取上级用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getSuperiorById", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<User> getSuperiorById(@RequestParam("id") Long id);

    /**
     * 根据id获取上级用户信息
     *
     * @param userIds
     * @return
     */
    @PostMapping(value = "/getSuperiorByIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<User>> getSuperiorByIds(@RequestBody Collection<Long> userIds);

    /**
     * 获取下级（含自己）用户列表
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/getSubordinateById", consumes = MediaType.APPLICATION_JSON_VALUE)
    public R<Set<Long>> getSubordinateById(@RequestParam("id") Long userId);

    /**
     * 根据用户信息查询用户
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/findByUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<User>> findByUser(FindUserRequest request);

    /**
     * 根据组织信息查询当前组织下面的用户
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/findByOrg", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<User>> findByOrg(FindUserRequest request);

    /**
     * 根据组织信息查询整个组织层级下的用户
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/findAllByOrg", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<User>> findAllByOrg(FindUserRequest request);

}
