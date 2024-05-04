package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: xuzifan
 * @Date: 2024/1/28 - 01 - 28 - 15:56
 * @Description: util
 * @version: 1.0
 */
public class PropertiesUtil {
    private Properties properties;

    public PropertiesUtil(String path){
        properties = new Properties();
        try (InputStream inputStream = this.getClass().getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new RuntimeException("无法找到配置文件: " + path);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("无法加载配置文件: " + path, e);
        }
    }

    public String getProperties(String key){
        return properties.getProperty(key);
    }

}
