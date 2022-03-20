package ru.zavrichko.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/selenoid.properties"})
public interface SelenoidConfig extends Config {

    @Config.Key("hubUrl")
    String hubUrl();

    @Key("user")
    String user();

    @Key("password")
    String password();

    @Key("videoUrl")
    String videoUrl();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("platformName")
    String platformName();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app")
    String app();
}
