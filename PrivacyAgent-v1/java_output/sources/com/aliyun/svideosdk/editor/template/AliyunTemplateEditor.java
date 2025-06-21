package com.aliyun.svideosdk.editor.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunTemplateEditor extends com.aliyun.svideosdk.editor.template.AliyunTemplatePlayer {
    long getMainClipStartTime(int i);

    void updateCaption(com.aliyun.svideosdk.common.struct.template.AliyunTemplateTextParam aliyunTemplateTextParam, java.lang.String str);

    void updateMediaClip(com.aliyun.svideosdk.common.struct.template.AliyunTemplateVideoParam aliyunTemplateVideoParam, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip);
}
