package com.aliyun.svideosdk.editor.resource;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class AliyunResTask {
    private com.aliyun.svideosdk.editor.resource.AliyunResTask.a mHandleCallback;
    private com.aliyun.svideosdk.editor.resource.AliyunResModuleType mResModuleType;
    private com.aliyun.svideosdk.editor.resource.AliyunResType mResType;
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    public interface a {
        void a(com.aliyun.svideosdk.editor.resource.AliyunResTask aliyunResTask);
    }

    public AliyunResTask(com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar) {
        this.mResModuleType = aliyunResModuleType;
        this.mResType = aliyunResType;
        this.mSource = source;
        this.mHandleCallback = aVar;
    }

    public com.aliyun.svideosdk.editor.resource.AliyunResModuleType getResModuleType() {
        return this.mResModuleType;
    }

    public com.aliyun.svideosdk.editor.resource.AliyunResType getResType() {
        return this.mResType;
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
            this.mHandleCallback.a(this);
            this.mHandleCallback = null;
        }
    }

    public void onIgnore() {
        onHandleCallback(null);
    }

    public abstract void onRemove();
}
