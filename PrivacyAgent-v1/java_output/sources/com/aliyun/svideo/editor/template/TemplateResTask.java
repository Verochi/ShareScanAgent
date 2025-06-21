package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class TemplateResTask {
    private com.aliyun.svideo.editor.template.TemplateResTask.HandleCallback mHandleCallback;
    private com.aliyun.svideo.editor.template.TemplateResTask.TemplateResType mResType;
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    public interface HandleCallback {
        void onCallback(com.aliyun.svideo.editor.template.TemplateResTask templateResTask);
    }

    public enum TemplateResType {
        Cover,
        Video,
        Project
    }

    public TemplateResTask(com.aliyun.svideo.editor.template.TemplateResTask.TemplateResType templateResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideo.editor.template.TemplateResTask.HandleCallback handleCallback) {
        this.mResType = templateResType;
        this.mSource = source;
        this.mHandleCallback = handleCallback;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public void onHandleCallback(com.aliyun.svideosdk.common.struct.project.Source source) {
        if (this.mHandleCallback != null) {
            if (source != null) {
                this.mSource.setId(source.getId());
                this.mSource.setPath(source.getPath());
                this.mSource.setURL(source.getURL());
            }
            this.mHandleCallback.onCallback(this);
            this.mHandleCallback = null;
        }
    }
}
