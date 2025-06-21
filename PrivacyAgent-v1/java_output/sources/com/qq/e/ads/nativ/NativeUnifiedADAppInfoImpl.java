package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public class NativeUnifiedADAppInfoImpl implements com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo {
    private final java.lang.String a;
    private final java.lang.String b;
    private final long c;
    private final java.lang.String d;
    private final java.lang.String e;
    private final java.lang.String f;
    private final java.lang.String g;
    private final java.lang.String h;
    private final java.lang.String i;

    public interface Keys {
        public static final java.lang.String APP_NAME = "app_name";
        public static final java.lang.String AUTHOR_NAME = "author_name";
        public static final java.lang.String DESCRIPTION_URL = "description_url";
        public static final java.lang.String ICP_NUMBER = "icp_number";
        public static final java.lang.String PACKAGE_SIZE = "package_size";
        public static final java.lang.String PERMISSION_URL = "permission_url";
        public static final java.lang.String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final java.lang.String SUITABLE_AGE = "suitable_age";
        public static final java.lang.String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(org.json.JSONObject jSONObject) {
        this.a = jSONObject.optString("app_name");
        this.b = jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME);
        this.c = jSONObject.optLong(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE);
        this.d = jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.PERMISSION_URL);
        this.e = jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.PRIVACY_AGREEMENT);
        this.f = jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
        this.g = jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.DESCRIPTION_URL);
        this.h = jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.ICP_NUMBER);
        this.i = jSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.SUITABLE_AGE);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getAppName() {
        return this.a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getAuthorName() {
        return this.b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getDescriptionUrl() {
        return this.g;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getIcpNumber() {
        return this.h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getPermissionsUrl() {
        return this.d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getPrivacyAgreement() {
        return this.e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getSuitableAge() {
        return this.i;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public java.lang.String getVersionName() {
        return this.f;
    }
}
