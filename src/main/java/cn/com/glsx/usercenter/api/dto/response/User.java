package cn.com.glsx.usercenter.api.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;

    /**
     * 组织（部门）id
     */
    private Long orgId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账户名
     */
    private String account;

    /**
     * 映射id，可能是用户上级id，也可能是用户下级id
     */
    private Long mid;

}
