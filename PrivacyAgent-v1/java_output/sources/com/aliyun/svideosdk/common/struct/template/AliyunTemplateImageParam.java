package com.aliyun.svideosdk.common.struct.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunTemplateImageParam extends com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam {
    private transient com.aliyun.svideosdk.common.struct.project.Source mSource;

    public AliyunTemplateImageParam() {
        setType(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type.image);
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }
}
