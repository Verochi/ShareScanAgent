package com.otaliastudios.opengl.core;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR*\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0018\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/otaliastudios/opengl/core/GlViewportAware;", "", "", "width", "height", "", "setViewportSize", "onViewportSizeChanged", "ensureViewportSize", "", "a", "[I", "viewportArray", "<set-?>", "b", "I", "getViewportWidth", "()I", "setViewportWidth", "(I)V", "viewportWidth", "c", "getViewportHeight", "setViewportHeight", "viewportHeight", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public abstract class GlViewportAware {

    /* renamed from: a, reason: from kotlin metadata */
    public final int[] viewportArray = new int[4];

    /* renamed from: b, reason: from kotlin metadata */
    public int viewportWidth = -1;

    /* renamed from: c, reason: from kotlin metadata */
    public int viewportHeight = -1;

    public final void ensureViewportSize() {
        if (this.viewportHeight == -1 || this.viewportWidth == -1) {
            android.opengl.GLES20.glGetIntegerv(kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.internal.GlKt.getGL_VIEWPORT()), this.viewportArray, 0);
            int[] iArr = this.viewportArray;
            setViewportSize(iArr[2], iArr[3]);
        }
    }

    public final int getViewportHeight() {
        return this.viewportHeight;
    }

    public final int getViewportWidth() {
        return this.viewportWidth;
    }

    public void onViewportSizeChanged() {
    }

    public final void setViewportHeight(int i) {
        this.viewportHeight = i;
    }

    public final void setViewportSize(int width, int height) {
        if (width == this.viewportWidth && height == this.viewportHeight) {
            return;
        }
        this.viewportWidth = width;
        this.viewportHeight = height;
        onViewportSizeChanged();
    }

    public final void setViewportWidth(int i) {
        this.viewportWidth = i;
    }
}
