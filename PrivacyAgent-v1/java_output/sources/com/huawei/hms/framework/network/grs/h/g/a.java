package com.huawei.hms.framework.network.grs.h.g;

/* loaded from: classes22.dex */
public class a {
    private static final javax.net.ssl.HostnameVerifier a = new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier();

    public static javax.net.ssl.HostnameVerifier a() {
        return a;
    }

    public static javax.net.ssl.SSLSocketFactory a(android.content.Context context) {
        try {
            return new com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew(new com.huawei.secure.android.common.ssl.SecureX509TrustManager(context.getAssets().open(com.huawei.hms.framework.network.grs.GrsApp.getInstance().getBrand(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + "grs_sp.bks"), ""));
        } catch (java.io.IOException | java.security.KeyManagementException | java.security.NoSuchAlgorithmException e) {
            throw new java.lang.AssertionError(e);
        }
    }
}
