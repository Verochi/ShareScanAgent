package com.sina.weibo.sdk.auth;

/* loaded from: classes19.dex */
public final class AuthInfo implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.auth.AuthInfo> CREATOR = new com.sina.weibo.sdk.auth.AuthInfo.AnonymousClass1();
    private static final long serialVersionUID = 6421253895937667193L;
    private java.lang.String app_key;
    private java.lang.String hash;
    private java.lang.String package_name;
    private java.lang.String redirect_url;
    private java.lang.String scope;

    /* renamed from: com.sina.weibo.sdk.auth.AuthInfo$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.auth.AuthInfo> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.sina.weibo.sdk.auth.AuthInfo createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.auth.AuthInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.sina.weibo.sdk.auth.AuthInfo[] newArray(int i) {
            return new com.sina.weibo.sdk.auth.AuthInfo[i];
        }
    }

    public AuthInfo(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.app_key = str;
        this.redirect_url = str2;
        this.scope = str3;
        java.lang.String packageName = context.getPackageName();
        this.package_name = packageName;
        this.hash = com.sina.weibo.sdk.c.e.e(context, packageName);
    }

    public AuthInfo(android.os.Parcel parcel) {
        this.app_key = parcel.readString();
        this.redirect_url = parcel.readString();
        this.scope = parcel.readString();
        this.package_name = parcel.readString();
        this.hash = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final java.lang.String getAppKey() {
        return this.app_key;
    }

    public final java.lang.String getHash() {
        return this.hash;
    }

    public final java.lang.String getPackageName() {
        return this.package_name;
    }

    public final java.lang.String getRedirectUrl() {
        return this.redirect_url;
    }

    public final java.lang.String getScope() {
        return this.scope;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.app_key);
        parcel.writeString(this.redirect_url);
        parcel.writeString(this.scope);
        parcel.writeString(this.package_name);
        parcel.writeString(this.hash);
    }
}
