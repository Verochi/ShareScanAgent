package com.otaliastudios.opengl.surface;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglNativeSurface;", "", "", "width", "", "setWidth", "height", "setHeight", "getWidth", "getHeight", "release", "", "isCurrent", "makeCurrent", "makeNothingCurrent", "", "nsecs", "setPresentationTime", "a", "I", "b", "Lcom/otaliastudios/opengl/core/EglCore;", "c", "Lcom/otaliastudios/opengl/core/EglCore;", "getEglCore$egloo_metadata_release", "()Lcom/otaliastudios/opengl/core/EglCore;", "setEglCore$egloo_metadata_release", "(Lcom/otaliastudios/opengl/core/EglCore;)V", "eglCore", "Lcom/otaliastudios/opengl/internal/EglSurface;", "d", "Lcom/otaliastudios/opengl/internal/EglSurface;", "getEglSurface$egloo_metadata_release", "()Lcom/otaliastudios/opengl/internal/EglSurface;", "setEglSurface$egloo_metadata_release", "(Lcom/otaliastudios/opengl/internal/EglSurface;)V", "eglSurface", "<init>", "(Lcom/otaliastudios/opengl/core/EglCore;Lcom/otaliastudios/opengl/internal/EglSurface;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class EglNativeSurface {

    /* renamed from: a, reason: from kotlin metadata */
    public int width;

    /* renamed from: b, reason: from kotlin metadata */
    public int height;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public com.otaliastudios.opengl.core.EglCore eglCore;

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public com.otaliastudios.opengl.internal.EglSurface eglSurface;

    public EglNativeSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, @org.jetbrains.annotations.NotNull com.otaliastudios.opengl.internal.EglSurface eglSurface) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
        this.eglCore = eglCore;
        this.eglSurface = eglSurface;
        this.width = -1;
        this.height = -1;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: getEglCore$egloo_metadata_release, reason: from getter */
    public final com.otaliastudios.opengl.core.EglCore getEglCore() {
        return this.eglCore;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: getEglSurface$egloo_metadata_release, reason: from getter */
    public final com.otaliastudios.opengl.internal.EglSurface getEglSurface() {
        return this.eglSurface;
    }

    public final int getHeight() {
        int i = this.height;
        return i < 0 ? this.eglCore.querySurface$egloo_metadata_release(this.eglSurface, com.otaliastudios.opengl.internal.EglKt.getEGL_HEIGHT()) : i;
    }

    public final int getWidth() {
        int i = this.width;
        return i < 0 ? this.eglCore.querySurface$egloo_metadata_release(this.eglSurface, com.otaliastudios.opengl.internal.EglKt.getEGL_WIDTH()) : i;
    }

    public final boolean isCurrent() {
        return this.eglCore.isSurfaceCurrent$egloo_metadata_release(this.eglSurface);
    }

    public final void makeCurrent() {
        this.eglCore.makeSurfaceCurrent$egloo_metadata_release(this.eglSurface);
    }

    public final void makeNothingCurrent() {
        this.eglCore.makeCurrent$egloo_metadata_release();
    }

    public void release() {
        this.eglCore.releaseSurface$egloo_metadata_release(this.eglSurface);
        this.eglSurface = com.otaliastudios.opengl.internal.EglKt.getEGL_NO_SURFACE();
        this.height = -1;
        this.width = -1;
    }

    public final void setEglCore$egloo_metadata_release(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "<set-?>");
        this.eglCore = eglCore;
    }

    public final void setEglSurface$egloo_metadata_release(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.internal.EglSurface eglSurface) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglSurface, "<set-?>");
        this.eglSurface = eglSurface;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public final void setPresentationTime(long nsecs) {
        this.eglCore.setSurfacePresentationTime$egloo_metadata_release(this.eglSurface, nsecs);
    }

    public final void setWidth(int width) {
        this.width = width;
    }
}
