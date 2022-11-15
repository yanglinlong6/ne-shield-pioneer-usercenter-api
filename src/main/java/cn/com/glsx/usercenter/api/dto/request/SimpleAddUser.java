package cn.com.glsx.usercenter.api.dto.request;

import lombok.Data;

@Data
public class SimpleAddUser {

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 帐号
     */
    private String account;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String phoneNum;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 部门ID
     */
    private Long departmentId;

    /**
     * 角色ID
     */
    private Long roleId;

    /*
     * 创建人
     */
    private Long createId;
}
