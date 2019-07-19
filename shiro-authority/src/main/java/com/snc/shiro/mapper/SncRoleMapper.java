package com.snc.shiro.mapper;

import com.snc.shiro.entity.SncRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Anthony.C
 * @since 2019-07-18
 */
@Component
public interface SncRoleMapper extends BaseMapper<SncRole> {

    List<String> findRoleByUser(Long userId);
}
