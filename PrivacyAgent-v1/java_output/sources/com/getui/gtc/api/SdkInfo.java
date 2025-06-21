package com.getui.gtc.api;

/* loaded from: classes22.dex */
public class SdkInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.getui.gtc.api.SdkInfo> CREATOR = new com.getui.gtc.api.SdkInfo.AnonymousClass1();
    private java.lang.String appid;
    private java.lang.String cid;
    private java.lang.String moduleName;
    private java.lang.String psUrl;
    private java.util.List<com.getui.gtc.entity.a.C0306a> stubs;
    private java.lang.String version;

    /* renamed from: com.getui.gtc.api.SdkInfo$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.api.SdkInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.getui.gtc.api.SdkInfo createFromParcel(android.os.Parcel parcel) {
            return new com.getui.gtc.api.SdkInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.getui.gtc.api.SdkInfo[] newArray(int i) {
            return new com.getui.gtc.api.SdkInfo[i];
        }
    }

    public static class Builder {
        private java.lang.String appid;
        private java.lang.String cid;
        private java.lang.String moduleName;
        private java.lang.String psUrl;
        private java.util.List<com.getui.gtc.entity.a.C0306a> stubs = new java.util.ArrayList();
        private java.lang.String version;

        public com.getui.gtc.api.SdkInfo.Builder addStub(java.lang.String str, boolean z) {
            com.getui.gtc.entity.a.C0306a c0306a = new com.getui.gtc.entity.a.C0306a();
            c0306a.d = str;
            c0306a.j = z;
            this.stubs.add(c0306a);
            return this;
        }

        public com.getui.gtc.api.SdkInfo.Builder appid(java.lang.String str) {
            this.appid = str;
            return this;
        }

        public com.getui.gtc.api.SdkInfo build() {
            return new com.getui.gtc.api.SdkInfo(this);
        }

        public com.getui.gtc.api.SdkInfo.Builder cid(java.lang.String str) {
            this.cid = str;
            return this;
        }

        public com.getui.gtc.api.SdkInfo.Builder moduleName(java.lang.String str) {
            this.moduleName = str;
            return this;
        }

        public com.getui.gtc.api.SdkInfo.Builder psUrl(java.lang.String str) {
            this.psUrl = str;
            return this;
        }

        public com.getui.gtc.api.SdkInfo.Builder version(java.lang.String str) {
            this.version = str;
            return this;
        }
    }

    public SdkInfo(android.os.Parcel parcel) {
        this.moduleName = parcel.readString();
        this.version = parcel.readString();
        this.appid = parcel.readString();
        this.cid = parcel.readString();
        this.psUrl = parcel.readString();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.stubs = arrayList;
        parcel.readTypedList(arrayList, com.getui.gtc.entity.a.C0306a.CREATOR);
    }

    public SdkInfo(com.getui.gtc.api.SdkInfo.Builder builder) {
        this.moduleName = builder.moduleName;
        this.version = builder.version;
        this.appid = builder.appid;
        this.cid = builder.cid;
        this.psUrl = builder.psUrl;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.stubs = arrayList;
        arrayList.addAll(builder.stubs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAppid() {
        return this.appid;
    }

    public java.lang.String getCid() {
        return this.cid;
    }

    public java.lang.String getModuleName() {
        return this.moduleName;
    }

    public java.lang.String getPsUrl() {
        return this.psUrl;
    }

    public java.util.List<com.getui.gtc.entity.a.C0306a> getStubs() {
        return this.stubs;
    }

    public java.lang.String getVersion() {
        return this.version;
    }

    public void setAppid(java.lang.String str) {
        this.appid = str;
    }

    public void setCid(java.lang.String str) {
        this.cid = str;
    }

    public void setModuleName(java.lang.String str) {
        this.moduleName = str;
    }

    public void setPsUrl(java.lang.String str) {
        this.psUrl = str;
    }

    public void setStubs(java.util.List<com.getui.gtc.entity.a.C0306a> list) {
        this.stubs = list;
    }

    public void setVersion(java.lang.String str) {
        this.version = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.moduleName);
        parcel.writeString(this.version);
        parcel.writeString(this.appid);
        parcel.writeString(this.cid);
        parcel.writeString(this.psUrl);
        parcel.writeTypedList(this.stubs);
    }
}
