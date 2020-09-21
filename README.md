# quarkus-apollo-config
Apollo configuration center's quarkus framework extension

## Quick start
- 1、Introduce maven coordinates
```
            <dependency>
                <groupId>org.github.keking</groupId>
                <artifactId>quarkus-apollo-config-ext</artifactId>
                <version>1.0-SNAPSHOT</version>
            </dependency>
```
- 2、Add the following configuration in the application.properties file
```
#apollo
quarkus.apollo.config=true
quarkus.apollo.config.namespace=application,service
```
By default, the switch of apollo extension is turned off, and you need to use the quarkus.apollo.config configuration to manually turn it on. For other usages of apollo configuration usage, refer to the official [documentation](https://github.com/ctripcorp/apollo/wiki/Java%E5%AE%A2%E6%88%B7%E7%AB%AF%E4%BD%BF%E7%94%A8%E6%8C%87%E5%8D%97)
