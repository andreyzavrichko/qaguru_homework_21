package ru.zavrichko.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config{
    @Key("device.user")
    String user();

    @Key("device.key")
    String key();

    @Key("device.app")
    String app();

    @Key("device.name")
    String device();

}