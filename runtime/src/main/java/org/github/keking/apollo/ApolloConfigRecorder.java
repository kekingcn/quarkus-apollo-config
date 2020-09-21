package org.github.keking.apollo;

import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSourceProvider;
import org.jboss.logging.Logger;

import java.util.Collections;

/**
 * @author kl : http://kailing.pub
 * @version 1.0
 * @date 2020/9/18
 */
@Recorder
public class ApolloConfigRecorder {

    private static final Logger log = Logger.getLogger(ApolloConfigRecorder.class);

    public RuntimeValue<ConfigSourceProvider> configSources(ApolloConfig apolloConfig) {
        if (!apolloConfig.enabled) {
            log.info("apollo配置未开启");
            return emptyRuntimeValue();
        }
        log.info("apollo配置已开启");
        return new RuntimeValue<>(new ApolloConfigSourceProvider(apolloConfig));
    }

    private RuntimeValue<ConfigSourceProvider> emptyRuntimeValue() {
        return new RuntimeValue<>(new EmptyConfigSourceProvider());
    }

    private static class EmptyConfigSourceProvider implements ConfigSourceProvider {
        @Override
        public Iterable<ConfigSource> getConfigSources(ClassLoader forClassLoader) {
            return Collections.emptyList();
        }
    }
}
