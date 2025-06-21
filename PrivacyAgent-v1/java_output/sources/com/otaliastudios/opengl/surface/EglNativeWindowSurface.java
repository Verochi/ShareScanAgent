package com.otaliastudios.opengl.surface;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglNativeWindowSurface;", "Lcom/otaliastudios/opengl/surface/EglSurface;", "eglCore", "Lcom/otaliastudios/opengl/core/EglCore;", "eglSurface", "Lcom/otaliastudios/opengl/internal/EglSurface;", "(Lcom/otaliastudios/opengl/core/EglCore;Lcom/otaliastudios/opengl/internal/EglSurface;)V", "swapBuffers", "", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public abstract class EglNativeWindowSurface extends com.otaliastudios.opengl.surface.EglSurface {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EglNativeWindowSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, @org.jetbrains.annotations.NotNull com.otaliastudios.opengl.internal.EglSurface eglSurface) {
        super(eglCore, eglSurface);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
    }

    public final boolean swapBuffers() {
        return getEglCore().swapSurfaceBuffers$egloo_metadata_release(getEglSurface());
    }
}
