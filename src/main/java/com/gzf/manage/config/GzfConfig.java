package com.gzf.manage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author gzf
 */
@Component
@ConfigurationProperties(prefix = "gzf")
public class GzfConfig
{


    /** 上传路径 */
    private static String profile;


    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        GzfConfig.profile = profile;
    }


    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }
}
