package com.aliyun.svideosdk.common.struct.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunTemplateTextParam extends com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam {
    private transient java.lang.String mText;

    public AliyunTemplateTextParam() {
        setType(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type.text);
    }

    public java.lang.String getText() {
        return this.mText;
    }

    public void setText(java.lang.String str) {
        this.mText = str;
    }
}
