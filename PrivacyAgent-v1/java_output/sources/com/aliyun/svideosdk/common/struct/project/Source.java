package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class Source implements com.aliyun.svideosdk.common.ISource {

    @com.google.gson.annotations.SerializedName("SourceId")
    private java.lang.String mId;

    @com.google.gson.annotations.SerializedName("Path")
    private java.lang.String mPath;

    @com.google.gson.annotations.SerializedName("URL")
    private java.lang.String mURL;

    public Source() {
    }

    public Source(java.lang.String str) {
        this.mPath = str;
    }

    public Source(java.lang.String str, java.lang.String str2) {
        this.mId = str;
        this.mPath = str2;
    }

    public Source(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mId = str;
        this.mPath = str2;
        this.mURL = str3;
    }

    public static boolean equals(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.aliyun.svideosdk.common.struct.project.Source)) {
            return false;
        }
        com.aliyun.svideosdk.common.struct.project.Source source = (com.aliyun.svideosdk.common.struct.project.Source) obj;
        if (equals(this.mPath, source.mPath)) {
            return true;
        }
        return equals(this.mId, source.mId) && equals(this.mURL, source.mURL);
    }

    @Override // com.aliyun.svideosdk.common.ISource
    public java.lang.String getId() {
        return this.mId;
    }

    public int getIntId() {
        try {
            return java.lang.Integer.parseInt(getId());
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    @Override // com.aliyun.svideosdk.common.ISource
    public java.lang.String getPath() {
        return this.mPath;
    }

    @Override // com.aliyun.svideosdk.common.ISource
    public java.lang.String getURL() {
        return this.mURL;
    }

    public void setId(java.lang.String str) {
        this.mId = str;
    }

    public void setPath(java.lang.String str) {
        this.mPath = str;
    }

    public void setURL(java.lang.String str) {
        this.mURL = str;
    }
}
