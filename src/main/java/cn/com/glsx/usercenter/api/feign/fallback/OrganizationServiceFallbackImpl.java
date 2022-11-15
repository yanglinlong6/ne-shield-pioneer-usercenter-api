package cn.com.glsx.usercenter.api.feign.fallback;

import cn.com.glsx.usercenter.api.dto.request.FindOrgRequest;
import cn.com.glsx.usercenter.api.dto.response.Organization;
import cn.com.glsx.usercenter.api.dto.tree.OrgTreeModel;
import cn.com.glsx.usercenter.api.feign.OrganizationService;
import com.glsx.plat.core.web.R;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class OrganizationServiceFallbackImpl implements OrganizationService {

    @Setter
    private Throwable cause;

    @Override
    public R<List<Organization>> findOrgs(FindOrgRequest request) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<Organization>> getTenantPathsByUserId(Long userId) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<Organization>> getTenantPathsByUserIds(Collection<Long> userIds) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<Organization>> getRootOrganizations() {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<Organization>> getSubOrganizations(Long orgId) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<Organization>> getOrgsByUserIds(Collection<Long> userIds) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<Organization>> getAllUserOrgsByUserIds(Collection<Long> userIds) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<Organization>> getSpecialLevelOrganizations(Integer level) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<List<OrgTreeModel>> orgTree(FindOrgRequest request) {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

    @Override
    public R<Set<Long>> getAllSubOrgIds() {
        log.warn("熔断啦 {}", cause.getMessage());
        return R.ok();
    }

}
