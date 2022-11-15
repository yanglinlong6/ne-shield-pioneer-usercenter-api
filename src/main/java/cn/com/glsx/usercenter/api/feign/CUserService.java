package cn.com.glsx.usercenter.api.feign;

import cn.com.glsx.usercenter.api.dto.response.CUser;
import cn.com.glsx.usercenter.api.feign.factory.UserServiceFallbackFactory;
import com.glsx.plat.core.web.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

@FeignClient(
        name = "${feign.usercenter.name}",
        path = "${feign.usercenter.path}" + "/fcuser",
        contextId = "feignCUser",
        fallbackFactory = UserServiceFallbackFactory.class,
        decode404 = true
)
public interface CUserService {

    /**
     * 根据c端用户id获取用户本地账号信息
     *
     * @param cuserIds
     * @return
     */
    @PostMapping(value = "/getLocalCUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<CUser>> getLocalCUsers(@RequestBody Collection<Long> cuserIds);

    /**
     * 根据后台用户id（t_user.id）获取用户信息
     *
     * @param relUserIds
     * @return
     */
    @PostMapping(value = "/getLocalRelCUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<CUser>> getLocalRelCUsers(@RequestBody Collection<Long> relUserIds);

    /**
     * 根据c端用户id获取用户微信账号信息
     *
     * @param cuserIds
     * @return
     */
    @PostMapping(value = "/getWechatUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<CUser>> getWechatUsers(@RequestBody Collection<Long> cuserIds);

}
