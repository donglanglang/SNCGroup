package com.snc.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snc.shiro.entity.SncUser;
import com.snc.shiro.mapper.SncPermissionMapper;
import com.snc.shiro.mapper.SncRoleMapper;
import com.snc.shiro.mapper.SncUserMapper;
import com.snc.shiro.service.ISncUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Anthony.C
 * @since 2019-07-18
 */
@Service
public class SncUserServiceImpl extends ServiceImpl<SncUserMapper, SncUser> implements ISncUserService {


    @Autowired
    private SncRoleMapper sncRoleMapper;

    @Autowired
    private SncPermissionMapper sncPermissionMapper;

    @Override
    public List<String> findRoleByUser(Long userId) {
        return sncRoleMapper.findRoleByUser(userId);
    }

    @Override
    public List<String> findPermissionByUser(Long userId) {
        return sncPermissionMapper.findPermissionByUser(userId);
    }

    @Override
    public SncUser findByUserName(String userName) {
        return this.baseMapper.selectOne(new QueryWrapper<SncUser>().eq("USER_NAME",userName));
    }
}
