package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class s implements com.aliyun.svideosdk.editor.AliyunIPipTrack {
    private int b;
    private java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> a = new java.util.ArrayList();
    private com.aliyun.svideosdk.common.struct.project.VideoTrack c = new com.aliyun.svideosdk.common.struct.project.VideoTrack();

    public int a() {
        return this.b;
    }

    public int a(com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController) {
        this.a.add(aliyunIPipController);
        com.aliyun.svideosdk.editor.impl.q qVar = (com.aliyun.svideosdk.editor.impl.q) aliyunIPipController;
        qVar.a(this);
        qVar.a(a());
        this.c.getVideoTrackClips().add(qVar.c());
        return this.a.size();
    }

    public void a(int i) {
        this.b = i;
    }

    public int b(com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController) {
        if (!this.a.remove(aliyunIPipController)) {
            return -1;
        }
        com.aliyun.svideosdk.editor.impl.q qVar = (com.aliyun.svideosdk.editor.impl.q) aliyunIPipController;
        this.c.getVideoTrackClips().remove(qVar.c());
        qVar.a((com.aliyun.svideosdk.editor.AliyunIPipTrack) null);
        return this.a.size();
    }

    public com.aliyun.svideosdk.common.struct.project.VideoTrack b() {
        return this.c;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipTrack
    public java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> getPipClips() {
        return new java.util.ArrayList(this.a);
    }
}
