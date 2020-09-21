package org.github.keking.apollo;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.ExtensionSslNativeSupportBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.RunTimeConfigurationSourceValueBuildItem;
/**
 * @author kl : http://kailing.pub
 * @version 1.0
 * @date 2020/9/18
 */
public class ApolloConfigProcessor {

    private static final String FEATURE = "apolloConfig";

    @BuildStep
    public void feature(BuildProducer<FeatureBuildItem> feature) {
        feature.produce(new FeatureBuildItem(FEATURE));
    }

    @BuildStep
    public void enableSsl(BuildProducer<ExtensionSslNativeSupportBuildItem> extensionSslNativeSupport) {
        extensionSslNativeSupport.produce(new ExtensionSslNativeSupportBuildItem(FEATURE));
    }


    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    public RunTimeConfigurationSourceValueBuildItem configure(ApolloConfigRecorder recorder,
                                                              ApolloConfig apolloConfig) {
        return new RunTimeConfigurationSourceValueBuildItem(
                recorder.configSources(apolloConfig));
    }

}
