package com.aliyun.svideosdk.editor.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunTemplateSourceHandleCallback {
    void onFailure(java.lang.String str);

    void onHandleResourceTasks(java.lang.String str, java.util.List<com.aliyun.svideosdk.editor.resource.AliyunResTask> list);

    void onSuccess();
}
