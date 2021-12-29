package com.ilop.architecture.data.response.manager;

import com.ilop.architecture.utils.NetworkUtils;

/**
 * @author skygge
 * @date 7/6/21.
 * GitHub：javofxu@github.com
 * email：skygge@yeah.net
 * description：
 */
public interface OnNetworkCallBack {

    void getNetWorkState(NetworkUtils.NetworkType type);
}
