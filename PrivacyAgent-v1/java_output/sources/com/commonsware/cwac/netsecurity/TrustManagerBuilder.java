package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class TrustManagerBuilder {
    private static final java.lang.String META_DATA_NAME = "android.security.net.config";
    private com.commonsware.cwac.netsecurity.CompositeTrustManager mgr = com.commonsware.cwac.netsecurity.CompositeTrustManager.matchAll(new javax.net.ssl.X509TrustManager[0]);
    private com.commonsware.cwac.netsecurity.config.ApplicationConfig appConfig = null;

    private void validateConfig(android.content.Context context, int i, boolean z) {
        android.content.res.XmlResourceParser xml = context.getResources().getXml(i);
        java.lang.RuntimeException runtimeException = null;
        while (xml.getEventType() != 1) {
            try {
                if (xml.getEventType() == 2 && "certificates".equals(xml.getName())) {
                    for (int i2 = 0; i2 < xml.getAttributeCount(); i2++) {
                        if ("src".equals(xml.getAttributeName(i2)) && com.umeng.analytics.pro.ay.m.equals(xml.getAttributeValue(i2)) && !z) {
                            runtimeException = new java.lang.RuntimeException("requested <certificates src=\"user\">, not supported");
                        }
                    }
                }
                xml.next();
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException("Could not parse config XML", e);
            }
        }
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder add(javax.net.ssl.TrustManager... trustManagerArr) {
        for (javax.net.ssl.TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                this.mgr.add((javax.net.ssl.X509TrustManager) trustManager);
            }
        }
        return this;
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder and() {
        if (!this.mgr.isMatchAll()) {
            if (this.mgr.size() < 2) {
                this.mgr.setMatchAll(true);
            } else {
                this.mgr = com.commonsware.cwac.netsecurity.CompositeTrustManager.matchAll(this.mgr);
            }
        }
        return this;
    }

    public java.net.HttpURLConnection applyTo(java.net.HttpURLConnection httpURLConnection) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        if ((httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) && this.mgr.size() > 0) {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sSLContext.init(null, buildArray(), null);
            ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
            this.mgr.setHost(httpURLConnection.getURL().getHost());
        }
        return httpURLConnection;
    }

    public com.commonsware.cwac.netsecurity.CompositeTrustManager build() {
        return this.mgr;
    }

    public javax.net.ssl.X509TrustManager[] buildArray() {
        return new javax.net.ssl.X509TrustManager[]{build()};
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder denyAll() {
        this.mgr.add(new com.commonsware.cwac.netsecurity.DenyAllTrustManager());
        return this;
    }

    public boolean isCleartextTrafficPermitted() {
        com.commonsware.cwac.netsecurity.config.ApplicationConfig applicationConfig = this.appConfig;
        if (applicationConfig == null) {
            return true;
        }
        return applicationConfig.isCleartextTrafficPermitted();
    }

    public boolean isCleartextTrafficPermitted(java.lang.String str) {
        com.commonsware.cwac.netsecurity.config.ApplicationConfig applicationConfig = this.appConfig;
        if (applicationConfig == null) {
            return true;
        }
        return applicationConfig.isCleartextTrafficPermitted(str);
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder or() {
        if (this.mgr.isMatchAll()) {
            if (this.mgr.size() < 2) {
                this.mgr.setMatchAll(false);
            } else {
                this.mgr = com.commonsware.cwac.netsecurity.CompositeTrustManager.matchAny(this.mgr);
            }
        }
        return this;
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder useDefault() throws java.security.NoSuchAlgorithmException, java.security.KeyStoreException {
        javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((java.security.KeyStore) null);
        add(trustManagerFactory.getTrustManagers());
        return this;
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder withCertChainListener(com.commonsware.cwac.netsecurity.CertChainListener certChainListener) {
        this.mgr.addCertChainListener(certChainListener);
        return this;
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder withConfig(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.XmlRes int i) {
        validateConfig(context, i, false);
        return withConfig(new com.commonsware.cwac.netsecurity.config.XmlConfigSource(context, i, false));
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder withConfig(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.XmlRes int i, boolean z) {
        validateConfig(context, i, false);
        return withConfig(new com.commonsware.cwac.netsecurity.config.XmlConfigSource(context, i, z));
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder withConfig(@androidx.annotation.NonNull com.commonsware.cwac.netsecurity.config.ConfigSource configSource) {
        com.commonsware.cwac.netsecurity.config.ApplicationConfig applicationConfig = new com.commonsware.cwac.netsecurity.config.ApplicationConfig(configSource);
        this.appConfig = applicationConfig;
        return add(applicationConfig.getTrustManager());
    }

    public com.commonsware.cwac.netsecurity.TrustManagerBuilder withManifestConfig(@androidx.annotation.NonNull android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return this;
        }
        try {
            android.os.Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                throw new java.lang.RuntimeException("Could not find manifest meta-data!");
            }
            int i = bundle.getInt("android.security.net.config", -1);
            if (i == -1) {
                throw new java.lang.RuntimeException("Could not find android.security.net.config meta-data!");
            }
            validateConfig(context, i, true);
            return withConfig(new com.commonsware.cwac.netsecurity.config.ManifestConfigSource(context.getApplicationContext()));
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            throw new java.lang.RuntimeException("We could not find ourselves?!?", e);
        }
    }
}
