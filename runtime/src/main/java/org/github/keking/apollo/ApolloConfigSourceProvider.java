package org.github.keking.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.google.common.base.Splitter;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kl : http://kailing.pub
 * @version 1.0
 * @date 2020/9/18
 */
public class ApolloConfigSourceProvider implements ConfigSourceProvider {

    private static final Logger log = LoggerFactory.getLogger(ApolloConfigSourceProvider.class);
    private final ApolloConfig config;
    private static final String DEFAULT_NAMESPACE = "application";
    private static final Splitter NAMESPACE_SPLITTER = Splitter.on(",").omitEmptyStrings().trimResults();

    public ApolloConfigSourceProvider(ApolloConfig config) {
        this.config = config;
    }

    @Override
    public Iterable<ConfigSource> getConfigSources(ClassLoader classLoader) {
        List<ConfigSource> configSources = new ArrayList<>(1);
        String namespaces = config.namespace.orElse(DEFAULT_NAMESPACE);
        log.info("加载apollo的namespaces:{}", namespaces);
        List<String> namespaceList = NAMESPACE_SPLITTER.splitToList(namespaces);
        for (String namespace : namespaceList) {
            Config conf = ConfigService.getConfig(namespace);
            configSources.add(new ApolloConfigSource(namespace, conf));
        }
        return configSources;
    }


}
