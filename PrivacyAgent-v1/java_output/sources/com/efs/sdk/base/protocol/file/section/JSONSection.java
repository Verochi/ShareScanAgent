package com.efs.sdk.base.protocol.file.section;

/* loaded from: classes22.dex */
public class JSONSection extends com.efs.sdk.base.protocol.file.section.AbsSection {
    private java.lang.String body;

    public JSONSection(java.lang.String str) {
        super(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
        this.name = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public java.lang.String changeToStr() {
        return getDeclarationLine() + "\n" + this.body + "\n";
    }

    public void setBody(java.lang.String str) {
        this.body = str;
    }
}
