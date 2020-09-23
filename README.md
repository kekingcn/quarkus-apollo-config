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
## Quarkus Config Use
- 1、How to configure the class
```
@ConfigProperties(prefix = "quarkus.app")
public class QuarkusConfig {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
- 2、Property injection method
```
@Singleton
@Startup
public class ConfigService {

    @ConfigProperty(name = "quarkus.app.name")
    String appName;
    
    public void print(){
        System.out.println(appName);
    }
}
```
- 3、Api manual acquisition method
```
@Singleton
@Startup
public class ConfigService {

    public void print(){
        Config config = ConfigProvider.getConfig();
        System.out.println(config.getValue("quarkus.app.name",String.class));
    }
}
```
## Other resources
- apollo : https://github.com/ctripcorp/apollo
- quarkus: https://github.com/quarkusio/quarkus
- klblog : http://www.kailing.pub/