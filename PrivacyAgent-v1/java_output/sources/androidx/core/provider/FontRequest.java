package androidx.core.provider;

/* loaded from: classes.dex */
public final class FontRequest {
    private final java.util.List<java.util.List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final java.lang.String mIdentifier;
    private final java.lang.String mProviderAuthority;
    private final java.lang.String mProviderPackage;
    private final java.lang.String mQuery;

    public FontRequest(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3, @androidx.annotation.ArrayRes int i) {
        this.mProviderAuthority = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str);
        this.mProviderPackage = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str2);
        this.mQuery = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str3);
        this.mCertificates = null;
        androidx.core.util.Preconditions.checkArgument(i != 0);
        this.mCertificatesArray = i;
        this.mIdentifier = createIdentifier(str, str2, str3);
    }

    public FontRequest(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3, @androidx.annotation.NonNull java.util.List<java.util.List<byte[]>> list) {
        this.mProviderAuthority = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str);
        this.mProviderPackage = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str2);
        this.mQuery = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str3);
        this.mCertificates = (java.util.List) androidx.core.util.Preconditions.checkNotNull(list);
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(str, str2, str3);
    }

    private java.lang.String createIdentifier(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3) {
        return str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3;
    }

    @androidx.annotation.Nullable
    public java.util.List<java.util.List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    @androidx.annotation.ArrayRes
    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public java.lang.String getId() {
        return this.mIdentifier;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public java.lang.String getIdentifier() {
        return this.mIdentifier;
    }

    @androidx.annotation.NonNull
    public java.lang.String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    @androidx.annotation.NonNull
    public java.lang.String getProviderPackage() {
        return this.mProviderPackage;
    }

    @androidx.annotation.NonNull
    public java.lang.String getQuery() {
        return this.mQuery;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            java.util.List<byte[]> list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(android.util.Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
