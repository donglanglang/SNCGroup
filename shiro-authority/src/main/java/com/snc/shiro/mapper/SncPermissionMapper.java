package com.snc.shiro.mapper;

import com.snc.shiro.entity.SncPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Anthony.C
 * @since 2019-07-18
 */
@Component
public interface SncPermissionMapper extends BaseMapper<SncPermission> {
    List<String> findPermissionByUser(Long userId);
}
