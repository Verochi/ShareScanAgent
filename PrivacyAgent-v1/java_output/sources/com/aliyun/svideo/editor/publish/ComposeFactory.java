package com.aliyun.svideo.editor.publish;

/* loaded from: classes12.dex */
public enum ComposeFactory {
    INSTANCE;

    private com.aliyun.svideosdk.editor.impl.AliyunVodCompose aliyunVodCompose = com.aliyun.svideosdk.editor.impl.AliyunComposeFactory.createAliyunVodCompose();

    ComposeFactory() {
    }

    public com.aliyun.svideosdk.editor.impl.AliyunVodCompose getAliyunVodCompose() {
        return this.aliyunVodCompose;
    }
}
