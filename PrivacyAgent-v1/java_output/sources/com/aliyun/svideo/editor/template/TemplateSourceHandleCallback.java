package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public interface TemplateSourceHandleCallback {
    void onFailure(java.lang.String str);

    void onHandleResourceTasks(java.lang.String str, java.util.List<com.aliyun.svideo.editor.template.TemplateResTask> list);

    void onSuccess();
}
