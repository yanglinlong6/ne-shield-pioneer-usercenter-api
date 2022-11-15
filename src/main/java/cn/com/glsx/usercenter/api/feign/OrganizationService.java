package cn.com.glsx.usercenter.api.feign;

import cn.com.glsx.usercenter.api.dto.request.FindOrgRequest;
import cn.com.glsx.usercenter.api.dto.response.Organization;
import cn.com.glsx.usercenter.api.dto.tree.OrgTreeModel;
import cn.com.glsx.usercenter.api.feign.factory.OrganizationServiceFallbackFactory;
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
        path = "${feign.usercenter.path}" + "/forg",
        contextId = "feignorgz",
        fallbackFactory = OrganizationServiceFallbackFactory.class,
        decode404 = true
)
public interface OrganizationService {

    /**
     * 查找组织机构
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/findOrgs", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> findOrgs(FindOrgRequest request);

    /**
     * 根据userId获取租户机构
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/getTenantPathsByUserId", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> getTenantPathsByUserId(@RequestParam("userId") Long userId);

    /**
     * 根据userIds获取租户及（下级）机构
     *
     * @param userIds
     * @return
     */
    @PostMapping(value = "/getTenantPathsByUserIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> getTenantPathsByUserIds(@RequestBody Collection<Long> userIds);

    /**
     * 获取根组织层级
     *
     * @return
     */
    @GetMapping(value = "/getRootOrgs", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> getRootOrganizations();

    /**
     * 获取下级组织
     *
     * @param orgId
     * @return
     */
    @GetMapping(value = "/getSubOrgsBySuperiorId", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> getSubOrganizations(@RequestParam("orgId") Long orgId);

    /**
     * 根据用户id获取组织
     *
     * @param userIds
     * @return
     */
    @GetMapping(value = "/getOrgsByUserIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> getOrgsByUserIds(@RequestParam("userIds") Collection<Long> userIds);

    /**
     * 根据用户id获取组织-不带权限过滤
     *
     * @param userIds
     * @return
     */
    @GetMapping(value = "/getAllUserOrgsByUserIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> getAllUserOrgsByUserIds(@RequestParam("userIds") Collection<Long> userIds);

    /**
     * 获取特定层级的机构
     *
     * @param level
     * @return
     */
    @GetMapping(value = "/getSpecialLevelOrgs", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<Organization>> getSpecialLevelOrganizations(@RequestParam("level") Integer level);

    /**
     * 获取组织树
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/orgTree", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<List<OrgTreeModel>> orgTree(@RequestBody FindOrgRequest request);

    /**
     * 获取用户下级全部组织（本人、本人及下属角色时，也返回部门id）
     *
     * @return
     */
    @GetMapping(value = "/getAllSubOrgIds", consumes = MediaType.APPLICATION_JSON_VALUE)
    R<Set<Long>> getAllSubOrgIds();

}
