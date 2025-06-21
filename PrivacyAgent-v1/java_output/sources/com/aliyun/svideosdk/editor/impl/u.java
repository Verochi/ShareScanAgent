package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class u extends com.aliyun.svideosdk.common.impl.b implements com.aliyun.svideosdk.editor.AliyunISourcePartManager {
    private com.aliyun.svideosdk.editor.AliyunIEditor b;

    public u(java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> list, com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor) {
        super(list);
        this.b = aliyunIEditor;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISourcePartManager
    public int applySourceChange() {
        return this.b.applySourceChange();
    }
}
