package com.nick.springcloud.cache.service;

import com.nick.springcloud.cache.model.UserInfo;

/**
 *
 * @author nick
 * @date 2020/6/25 10:01 AM
 * @package com.nick.springcloud.cache.service
 * @description
 *
 */
public interface UserInfoCacheService {

    /**
     * 增加用户信息
     *
     * @param userInfo 用户信息
     */
    void addUserInfo(UserInfo userInfo);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserInfo getByName(Integer id);

    /**
     * 修改用户信息
     *
     * @param userInfo 用户信息
     * @return 用户信息
     */
    UserInfo updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     */
    void deleteById(Integer id);

}
