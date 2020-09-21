package org.github.keking.apollo;

import com.ctrip.framework.apollo.Config;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
/**
 * @author kl : http://kailing.pub
 * @version 1.0
 * @date 2020/9/18
 */
public class ApolloConfigSource implements ConfigSource {
        private static final String NAME_FORMAT = "ApolloPropertiesConfigSource[%s]";
        private final String configname;
        private final Config config;
        private static final int ORDINAL = 270; // 配置加载优先级高于文件系统或jar常规，但低于env vars

        ApolloConfigSource(String configname, Config config) {
            this.configname = configname;
            this.config = config;
        }

        @Override
        public int getOrdinal() {
            return ORDINAL;
        }

        @Override
        public Map<String, String> getProperties() {
            Map<String, String> propertyMap = new HashMap<>(6);
            config.getPropertyNames().forEach(key -> propertyMap.put(key, config.getProperty(key, null)));
            return propertyMap;
        }

        @Override
        public String getValue(String propertyName) {
            return config.getProperty(propertyName, null);
        }

        @Override
        public String getName() {
            return String.format(NAME_FORMAT, configname);
        }
    }