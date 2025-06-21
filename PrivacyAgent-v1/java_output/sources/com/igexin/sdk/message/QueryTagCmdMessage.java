package com.igexin.sdk.message;

/* loaded from: classes23.dex */
public class QueryTagCmdMessage extends com.igexin.sdk.message.GTCmdMessage {
    private java.lang.String code;
    private java.lang.String sn;
    private com.igexin.sdk.Tag[] tags;

    public QueryTagCmdMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        super(i);
        this.sn = str;
        this.code = str2;
        if (android.text.TextUtils.isEmpty(str3) || str3.equals("none")) {
            return;
        }
        java.lang.String[] split = str3.split(" ");
        com.igexin.sdk.Tag[] tagArr = new com.igexin.sdk.Tag[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            com.igexin.sdk.Tag tag = new com.igexin.sdk.Tag();
            tag.setName(split[i2]);
            tagArr[i2] = tag;
        }
        this.tags = tagArr;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public java.lang.String getSn() {
        return this.sn;
    }

    public com.igexin.sdk.Tag[] getTags() {
        return this.tags;
    }

    public void setCode(java.lang.String str) {
        this.code = str;
    }

    public void setSn(java.lang.String str) {
        this.sn = str;
    }

    public void setTags(com.igexin.sdk.Tag[] tagArr) {
        this.tags = tagArr;
    }
}
