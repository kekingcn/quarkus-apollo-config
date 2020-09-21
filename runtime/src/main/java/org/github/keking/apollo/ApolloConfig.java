package org.github.keking.apollo;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

import java.util.Optional;

/**
 * @author kl : http://kailing.pub
 * @version 1.0
 * @date 2020/9/18
 */
@ConfigRoot(name = "apollo.config", phase = ConfigPhase.BOOTSTRAP)
public class ApolloConfig {

    /**
     * 是否开启Apollo
     */
    @ConfigItem(name = ConfigItem.PARENT, defaultValue = "false")
    boolean enabled;

    /**
     * 命名空间
     */
    @ConfigItem
    Optional<String> namespace;
}
