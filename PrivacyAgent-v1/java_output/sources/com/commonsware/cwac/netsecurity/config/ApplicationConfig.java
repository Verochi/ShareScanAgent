package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class ApplicationConfig {
    private static com.commonsware.cwac.netsecurity.config.ApplicationConfig sInstance;
    private static java.lang.Object sLock = new java.lang.Object();
    private com.commonsware.cwac.netsecurity.config.ConfigSource mConfigSource;
    private java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> mConfigs;
    private com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig mDefaultConfig;
    private javax.net.ssl.X509TrustManager mTrustManager;
    private final java.lang.Object mLock = new java.lang.Object();
    private boolean mInitialized = false;

    public ApplicationConfig(com.commonsware.cwac.netsecurity.config.ConfigSource configSource) {
        this.mConfigSource = configSource;
    }

    private void ensureInitialized() {
        synchronized (this.mLock) {
            if (this.mInitialized) {
                return;
            }
            this.mConfigs = this.mConfigSource.getPerDomainConfigs();
            this.mDefaultConfig = this.mConfigSource.getDefaultConfig();
            this.mConfigSource = null;
            this.mTrustManager = new com.commonsware.cwac.netsecurity.config.RootTrustManager(this);
            this.mInitialized = true;
        }
    }

    public static com.commonsware.cwac.netsecurity.config.ApplicationConfig getDefaultInstance() {
        com.commonsware.cwac.netsecurity.config.ApplicationConfig applicationConfig;
        synchronized (sLock) {
            applicationConfig = sInstance;
        }
        return applicationConfig;
    }

    public static void setDefaultInstance(com.commonsware.cwac.netsecurity.config.ApplicationConfig applicationConfig) {
        synchronized (sLock) {
            sInstance = applicationConfig;
        }
    }

    public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig getConfigForHostname(java.lang.String str) {
        ensureInitialized();
        if (str == null || str.isEmpty() || this.mConfigs == null) {
            return this.mDefaultConfig;
        }
        if (str.charAt(0) == '.') {
            throw new java.lang.IllegalArgumentException("hostname must not begin with a .");
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
        if (lowerCase.charAt(lowerCase.length() - 1) == '.') {
            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
        }
        android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig> pair = null;
        for (android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig> pair2 : this.mConfigs) {
            com.commonsware.cwac.netsecurity.config.Domain domain = (com.commonsware.cwac.netsecurity.config.Domain) pair2.first;
            com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig networkSecurityConfig = (com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig) pair2.second;
            if (domain.hostname.equals(lowerCase)) {
                return networkSecurityConfig;
            }
            if (domain.subdomainsIncluded && lowerCase.endsWith(domain.hostname) && lowerCase.charAt((lowerCase.length() - domain.hostname.length()) - 1) == '.' && (pair == null || domain.hostname.length() > ((com.commonsware.cwac.netsecurity.config.Domain) pair.first).hostname.length())) {
                pair = pair2;
            }
        }
        return pair != null ? (com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig) pair.second : this.mDefaultConfig;
    }

    public javax.net.ssl.X509TrustManager getTrustManager() {
        ensureInitialized();
        return this.mTrustManager;
    }

    public void handleTrustStorageUpdate() {
        ensureInitialized();
        this.mDefaultConfig.handleTrustStorageUpdate();
        if (this.mConfigs != null) {
            java.util.HashSet hashSet = new java.util.HashSet(this.mConfigs.size());
            for (android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig> pair : this.mConfigs) {
                if (hashSet.add(pair.second)) {
                    ((com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig) pair.second).handleTrustStorageUpdate();
                }
            }
        }
    }

    public boolean hasPerDomainConfigs() {
        ensureInitialized();
        java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> set = this.mConfigs;
        return (set == null || set.isEmpty()) ? false : true;
    }

    public boolean isCleartextTrafficPermitted() {
        ensureInitialized();
        java.util.Set<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> set = this.mConfigs;
        if (set != null) {
            java.util.Iterator<android.util.Pair<com.commonsware.cwac.netsecurity.config.Domain, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig>> it = set.iterator();
            while (it.hasNext()) {
                if (!((com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig) it.next().second).isCleartextTrafficPermitted()) {
                    return false;
                }
            }
        }
        return this.mDefaultConfig.isCleartextTrafficPermitted();
    }

    public boolean isCleartextTrafficPermitted(java.lang.String str) {
        return getConfigForHostname(str).isCleartextTrafficPermitted();
    }
}
