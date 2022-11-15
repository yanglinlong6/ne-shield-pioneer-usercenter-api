package cn.com.glsx.usercenter.api.feign;

import cn.com.glsx.usercenter.api.dto.request.SimpleAddUser;
import cn.com.glsx.usercenter.api.dto.response.User;
import cn.com.glsx.usercenter.api.feign.factory.UserServiceFallbackFactory;
import com.glsx.plat.core.web.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 不需要登录的接口
 */
@FeignClient(
        name = "${feign.usercenter.name}",
        path = "${feign.usercenter.path}" + "/api/user",
        contextId = "feignApiUser",
        fallbackFactory = UserServiceFallbackFactory.class,
        decode404 = true
)
public interface ApiUserService {

    /**
     * 根据账号名获取用户列表
     *
     * @param account
     * @return
     */
    @GetMapping(value = "/findByAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<User>> findByAccount(@RequestParam("account") String account);

    /**
     * 根据用户名获取用户列表
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/findByUsername", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<User>> findByUsername(@RequestParam("username") String username);

    /**
     * 创建帐号接口
     *
     * @param simpleAddUser
     * @return
     */
    @PostMapping(value = "/simple/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<User> addSimpleUser(@RequestBody SimpleAddUser simpleAddUser);
}
