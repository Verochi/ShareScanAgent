package com.aliyun.dns;

/* loaded from: classes.dex */
public class DomainProcessor {
    private static final java.lang.String TAG;
    private static com.aliyun.dns.DomainProcessor sInstance;

    static {
        com.aliyun.utils.f.f();
        TAG = com.aliyun.dns.DomainProcessor.class.getSimpleName();
        sInstance = null;
    }

    private DomainProcessor() {
    }

    public static com.aliyun.dns.DomainProcessor getInstance() {
        if (sInstance == null) {
            synchronized (com.aliyun.dns.DomainProcessor.class) {
                if (sInstance == null) {
                    sInstance = new com.aliyun.dns.DomainProcessor();
                }
            }
        }
        return sInstance;
    }

    public static void loadClass() {
    }

    private static native void nAddEnhancedHttpDnsDomain(java.lang.String str);

    private static native void nAddPreResolveDomain(java.lang.String str);

    @java.lang.Deprecated
    public void addEnhancedHttpDnsDomain(java.lang.String str) {
        if (com.aliyun.utils.f.b() && !android.text.TextUtils.isEmpty(str)) {
            nAddEnhancedHttpDnsDomain(str);
        }
    }

    public void addPreResolveDomain(java.lang.String str) {
        if (com.aliyun.utils.f.b() && !android.text.TextUtils.isEmpty(str)) {
            nAddPreResolveDomain(str);
        }
    }
}
