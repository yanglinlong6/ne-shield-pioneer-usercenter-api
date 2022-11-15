package cn.com.glsx.usercenter.api.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@Accessors(chain = true)
public class FindOrgRequest {

    private String orgName;

    /**
     * 租户ids
     */
    private Collection<Long> tenantIds;

    /**
     * 组织ids
     */
    private Collection<Long> orgIds;

    /**
     * 取上级部门
     */
    private Collection<Long> supOrgIds;

    /**
     * 取下级部门
     */
    private Collection<Long> subOrgIds;

    /**
     * 用户ids
     */
    private Collection<Long> userIds;

    /**
     * 用户子树
     */
    private Boolean hasUserLeaf = false;

}
