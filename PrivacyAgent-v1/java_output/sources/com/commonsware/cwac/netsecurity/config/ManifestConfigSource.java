package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public class ManifestConfigSource implements com.commonsware.cwac.netsecurity.config.ConfigSource {
    private static final boolean DBG = true;
    private static final java.lang.String LOG_TAG = "NetworkSecurityConfig";
    public static final java.lang.String META_DATA_NETWORK_SECURITY_CONFIG = "android.security.net.config";
    private final int mApplicationInfoFlags;
    private com.commonsware.cwac.netsecurity.config.ConfigSource mConfigSource;
    private final android.content.Context mContext;
    private final java.lang.Object mLock = new java.lang.Object();
    private final int mTargetSdkVersion;

    public static final class DefaultConfigSource implements com.commonsware.cwac.netsecurity.config.ConfigSource {
        private final com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig mDefaultConfig;

        public DefaultConfigSource(boolean z, int i) {
            this.mDefaultConfig = com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.getDefaultBuilder(i).setCleartextTrafficPermitted(z).build();
        }

        @Override // com.commonsware.cwac.netsecurity.config.ConfigSource
        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig getDefaultConfig() {
            return this.mDefaultConfig;
        }

        @Override // com.commonsware.cwac.netsecurity.config.ConfigSource
        public java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> getPerDomainConfigs() {
            return null;
        }
    }

    public ManifestConfigSource(android.content.Context context) {
        this.mContext = context;
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        this.mApplicationInfoFlags = applicationInfo.flags;
        this.mTargetSdkVersion = applicationInfo.targetSdkVersion;
    }

    private com.commonsware.cwac.netsecurity.config.ConfigSource getConfigSource() {
        com.commonsware.cwac.netsecurity.config.ConfigSource defaultConfigSource;
        android.os.Bundle bundle;
        synchronized (this.mLock) {
            com.commonsware.cwac.netsecurity.config.ConfigSource configSource = this.mConfigSource;
            if (configSource != null) {
                return configSource;
            }
            try {
                android.content.pm.ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
                int i = (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? 0 : bundle.getInt(META_DATA_NETWORK_SECURITY_CONFIG);
                if (i != 0) {
                    boolean z = (this.mApplicationInfoFlags & 2) != 0;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Using Network Security Config from resource ");
                    sb.append(this.mContext.getResources().getResourceEntryName(i));
                    sb.append(" debugBuild: ");
                    sb.append(z);
                    defaultConfigSource = new com.commonsware.cwac.netsecurity.config.XmlConfigSource(this.mContext, i, z, this.mTargetSdkVersion);
                } else {
                    defaultConfigSource = new com.commonsware.cwac.netsecurity.config.ManifestConfigSource.DefaultConfigSource((this.mApplicationInfoFlags & 134217728) != 0, this.mTargetSdkVersion);
                }
                this.mConfigSource = defaultConfigSource;
                return defaultConfigSource;
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                throw new java.lang.RuntimeException("Failed to look up ApplicationInfo", e);
            }
        }
    }

    @Override // com.commonsware.cwac.netsecurity.config.ConfigSource
    public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig getDefaultConfig() {
        return getConfigSource().getDefaultConfig();
    }

    @Override // com.commonsware.cwac.netsecurity.config.ConfigSource
    public java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> getPerDomainConfigs() {
        return getConfigSource().getPerDomainConfigs();
    }
}
