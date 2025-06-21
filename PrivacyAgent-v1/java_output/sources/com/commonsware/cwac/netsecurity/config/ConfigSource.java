package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public interface ConfigSource {
    com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig getDefaultConfig();

    java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> getPerDomainConfigs();
}
