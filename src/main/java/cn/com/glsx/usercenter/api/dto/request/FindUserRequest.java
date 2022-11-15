package cn.com.glsx.usercenter.api.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@Accessors(chain = true)
public class FindUserRequest {

    /**
     * 组织ids
     */
    private Collection<Long> orgIds;

    /**
     * 用户ids
     */
    private Collection<Long> userIds;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账户名
     */
    private String account;

}
