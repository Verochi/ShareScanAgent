package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class r implements com.aliyun.svideosdk.editor.AliyunIPipManager {
    private com.aliyun.svideosdk.editor.NativeEditor a;
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject b;
    private java.util.List<com.aliyun.svideosdk.editor.AliyunIPipTrack> c = new java.util.ArrayList();
    private java.lang.ref.WeakReference<com.aliyun.svideosdk.editor.impl.g> d;

    public r(com.aliyun.svideosdk.editor.NativeEditor nativeEditor, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.editor.impl.g gVar) {
        this.a = nativeEditor;
        this.b = aliyunEditorProject;
        this.d = new java.lang.ref.WeakReference<>(gVar);
    }

    public void a() {
        for (com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController : getAllPip()) {
            if (aliyunIPipController instanceof com.aliyun.svideosdk.editor.impl.q) {
                ((com.aliyun.svideosdk.editor.impl.q) aliyunIPipController).d();
            }
        }
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public com.aliyun.svideosdk.editor.AliyunIPipController createNewPip(java.lang.String str) {
        if (!new java.io.File(str).exists()) {
            return null;
        }
        com.aliyun.svideosdk.editor.impl.s sVar = new com.aliyun.svideosdk.editor.impl.s();
        this.c.add(sVar);
        sVar.a(this.c.size());
        com.aliyun.svideosdk.editor.impl.q qVar = new com.aliyun.svideosdk.editor.impl.q(this.a, str, this.d.get());
        sVar.a(qVar);
        this.b.getTimeline().getVideoTracks().add(sVar.b());
        return qVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public com.aliyun.svideosdk.editor.AliyunIPipController createPipInTrack(java.lang.String str, com.aliyun.svideosdk.editor.AliyunIPipTrack aliyunIPipTrack) {
        if (!new java.io.File(str).exists()) {
            return null;
        }
        com.aliyun.svideosdk.editor.impl.q qVar = new com.aliyun.svideosdk.editor.impl.q(this.a, str, this.d.get());
        if (aliyunIPipTrack instanceof com.aliyun.svideosdk.editor.impl.s) {
            ((com.aliyun.svideosdk.editor.impl.s) aliyunIPipTrack).a(qVar);
        }
        return qVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public com.aliyun.svideosdk.editor.AliyunIPipController findTopPipController(long j, android.graphics.PointF pointF) {
        for (com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController : getAllPip()) {
            android.graphics.RectF pipRectFInCurrentScreen = aliyunIPipController.getPipRectFInCurrentScreen();
            android.graphics.PointF position = aliyunIPipController.getLayoutController().getPosition();
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setTranslate(pointF.x, pointF.y);
            matrix.postRotate(-(aliyunIPipController.getLayoutController().getRotationRadian() * 57.32484f), position.x, position.y);
            float[] fArr = {0.0f, 0.0f};
            matrix.mapPoints(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            if (aliyunIPipController.getTimeLineStartTimeInMillis() <= j && aliyunIPipController.getTimeLineEndTimeInMillis() >= j && pipRectFInCurrentScreen.contains(f, f2)) {
                return aliyunIPipController;
            }
        }
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> getAllPip() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.aliyun.svideosdk.editor.AliyunIPipTrack> it = getPipTracks().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getPipClips());
        }
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public java.util.List<com.aliyun.svideosdk.editor.AliyunIPipTrack> getPipTracks() {
        return new java.util.ArrayList(this.c);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public boolean movePipIntoTrack(com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController, com.aliyun.svideosdk.editor.AliyunIPipTrack aliyunIPipTrack, long j) {
        com.aliyun.svideosdk.editor.impl.s sVar = (com.aliyun.svideosdk.editor.impl.s) aliyunIPipController.getOwnerTrack();
        int b = sVar.b(aliyunIPipController);
        if (b < 0) {
            return false;
        }
        if (b == 0) {
            this.b.getTimeline().getVideoTracks().remove(sVar.b());
            this.c.remove(sVar);
        }
        aliyunIPipController.setTimelineStartTime(j, java.util.concurrent.TimeUnit.MILLISECONDS);
        ((com.aliyun.svideosdk.editor.impl.s) aliyunIPipTrack).a(aliyunIPipController);
        return false;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public boolean removePip(com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController) {
        this.a.removePipInPic(aliyunIPipController.getStreamId());
        com.aliyun.svideosdk.editor.impl.s sVar = (com.aliyun.svideosdk.editor.impl.s) aliyunIPipController.getOwnerTrack();
        int b = sVar.b(aliyunIPipController);
        if (b == -1) {
            return false;
        }
        if (b != 0) {
            return true;
        }
        this.b.getTimeline().getVideoTracks().remove(sVar.b());
        this.c.remove(sVar);
        return true;
    }
}
