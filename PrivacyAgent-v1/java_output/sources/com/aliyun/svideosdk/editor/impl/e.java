package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class e implements com.aliyun.svideosdk.editor.AliyunICanvasController {
    private android.content.Context a;
    private int b;
    private int c;
    private com.aliyun.svideosdk.editor.impl.f d;
    private com.aliyun.svideosdk.editor.AliyunIPaint e = new com.aliyun.svideosdk.editor.impl.j();
    private com.aliyun.svideosdk.editor.AliyunIEditor f;
    private com.aliyun.svideosdk.editor.AliyunPasterRender g;
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject h;

    public e(android.content.Context context, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor, int i, int i2) {
        this.a = context;
        this.b = i;
        this.c = i2;
        this.f = aliyunIEditor;
        this.g = aliyunIEditor.getPasterRender();
        this.h = aliyunEditorProject;
        com.aliyun.svideosdk.editor.impl.f fVar = new com.aliyun.svideosdk.editor.impl.f(this.a, this.b, this.c);
        this.d = fVar;
        fVar.setAliyunPaint(this.e);
        this.d.setPath(aliyunEditorProject.getProjectDir().getAbsolutePath() + java.io.File.separator + "paint.png");
        if (this.h.getCanvasTrack() == null || this.h.getCanvasTrack().getCanvasInfo() == null) {
            return;
        }
        this.d.a(this.h.getCanvasTrack().getCanvasInfo().convertCoordinate(i, i2, true));
    }

    public int a() {
        com.aliyun.svideosdk.editor.impl.f fVar = this.d;
        if (fVar != null) {
            return fVar.getCanvasHeight();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public int applyPaintCanvas() {
        this.d.g();
        com.aliyun.svideosdk.common.struct.effect.EffectPaint effectPaint = new com.aliyun.svideosdk.common.struct.effect.EffectPaint();
        effectPaint.setCanvasInfo(this.d.getCanvasInfo());
        effectPaint.setPath(this.d.getPath());
        return com.aliyun.svideosdk.common.a.a(this.g.applyPaintCanvas(effectPaint));
    }

    public int b() {
        com.aliyun.svideosdk.editor.impl.f fVar = this.d;
        if (fVar != null) {
            return fVar.getCanvasWidth();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void cancel() {
        this.d.b();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void clear() {
        com.aliyun.svideosdk.editor.impl.f fVar = this.d;
        if (fVar != null) {
            fVar.c();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void confirm() {
        this.d.d();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public android.view.View getCanvas() {
        return this.d;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public boolean hasCanvasPath() {
        return this.h.getCanvasTrack() != null && new java.io.File(this.h.getCanvasTrack().getSource().getPath()).exists();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void release() {
        clear();
        com.aliyun.svideosdk.editor.impl.f fVar = this.d;
        if (fVar != null) {
            fVar.f();
        }
        this.a = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void removeCanvas() {
        if (this.f != null) {
            this.g.removeCanvas();
        }
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.h;
        if (aliyunEditorProject != null) {
            aliyunEditorProject.removeCanvasTrack();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public int resetPaintCanvas() {
        if (android.text.TextUtils.isEmpty(this.d.getPath())) {
            return 0;
        }
        com.aliyun.svideosdk.common.struct.effect.EffectPaint effectPaint = new com.aliyun.svideosdk.common.struct.effect.EffectPaint();
        effectPaint.setCanvasInfo(this.d.getCanvasInfo());
        effectPaint.setPath(this.d.getPath());
        return com.aliyun.svideosdk.common.a.a(this.g.applyPaintCanvas(effectPaint));
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void setCurrentColor(int i) {
        this.e.setCurrentColor(i);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void setCurrentSize(float f) {
        this.e.setCurrentSize(f);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void setPaint(android.graphics.Paint paint) {
        this.e.setPaint(paint);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void undo() {
        this.d.i();
    }
}
