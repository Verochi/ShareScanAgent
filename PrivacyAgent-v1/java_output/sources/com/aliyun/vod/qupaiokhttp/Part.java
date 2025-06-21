package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public final class Part {
    private com.aliyun.vod.qupaiokhttp.FileWrapper fileWrapper;
    private java.lang.String key;
    private java.lang.String value;

    public Part(java.lang.String str, com.aliyun.vod.qupaiokhttp.FileWrapper fileWrapper) {
        setKey(str);
        this.fileWrapper = fileWrapper;
    }

    public Part(java.lang.String str, java.lang.String str2) {
        setKey(str);
        setValue(str2);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.aliyun.vod.qupaiokhttp.Part)) {
            com.aliyun.vod.qupaiokhttp.Part part = (com.aliyun.vod.qupaiokhttp.Part) obj;
            if (android.text.TextUtils.equals(part.getKey(), getKey()) && android.text.TextUtils.equals(part.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    public com.aliyun.vod.qupaiokhttp.FileWrapper getFileWrapper() {
        return this.fileWrapper;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public java.lang.String getValue() {
        return this.value;
    }

    public void setKey(java.lang.String str) {
        if (str == null) {
            this.key = "";
        } else {
            this.key = str;
        }
    }

    public void setValue(java.lang.String str) {
        if (str == null) {
            this.value = "";
        } else {
            this.value = str;
        }
    }
}
