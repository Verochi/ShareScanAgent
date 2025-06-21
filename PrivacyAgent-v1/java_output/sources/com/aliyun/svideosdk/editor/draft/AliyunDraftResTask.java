package com.aliyun.svideosdk.editor.draft;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class AliyunDraftResTask extends com.aliyun.svideosdk.editor.resource.AliyunResTask {
    private com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a mTaskType;

    public enum a {
        preload,
        upload,
        download
    }

    public AliyunDraftResTask(com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a aVar, com.aliyun.svideosdk.editor.resource.AliyunResModuleType aliyunResModuleType, com.aliyun.svideosdk.editor.resource.AliyunResType aliyunResType, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.editor.resource.AliyunResTask.a aVar2) {
        super(aliyunResModuleType, aliyunResType, source, aVar2);
        this.mTaskType = aVar;
    }

    public com.aliyun.svideosdk.editor.draft.AliyunDraftResTask.a getTaskType() {
        return this.mTaskType;
    }
}
