package com.sina.weibo.sdk.web;

/* loaded from: classes19.dex */
public class WebData implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.web.WebData> CREATOR = new com.sina.weibo.sdk.web.WebData.AnonymousClass1();
    private static final long serialVersionUID = -4038177938155795889L;
    protected com.sina.weibo.sdk.auth.AuthInfo aA;
    protected java.lang.String aB;
    protected int type;
    protected java.lang.String url;

    /* renamed from: com.sina.weibo.sdk.web.WebData$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.web.WebData> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.sina.weibo.sdk.web.WebData createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.web.WebData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.sina.weibo.sdk.web.WebData[] newArray(int i) {
            return new com.sina.weibo.sdk.web.WebData[i];
        }
    }

    public WebData(android.os.Parcel parcel) {
        this.aA = (com.sina.weibo.sdk.auth.AuthInfo) parcel.readParcelable(com.sina.weibo.sdk.auth.AuthInfo.class.getClassLoader());
        this.type = parcel.readInt();
        this.url = parcel.readString();
        this.aB = parcel.readString();
    }

    public WebData(com.sina.weibo.sdk.auth.AuthInfo authInfo, int i, java.lang.String str, java.lang.String str2) {
        this.aA = authInfo;
        this.type = i;
        this.url = str;
        this.aB = str2;
    }

    public final com.sina.weibo.sdk.auth.AuthInfo a() {
        return this.aA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final java.lang.String getUrl() {
        return this.url;
    }

    public final java.lang.String u() {
        return this.aB;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.aA, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
        parcel.writeString(this.aB);
    }
}
