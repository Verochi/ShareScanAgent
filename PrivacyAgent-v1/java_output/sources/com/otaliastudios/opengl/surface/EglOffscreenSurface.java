package com.otaliastudios.opengl.surface;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglOffscreenSurface;", "Lcom/otaliastudios/opengl/surface/EglSurface;", "eglCore", "Lcom/otaliastudios/opengl/core/EglCore;", "width", "", "height", "(Lcom/otaliastudios/opengl/core/EglCore;II)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class EglOffscreenSurface extends com.otaliastudios.opengl.surface.EglSurface {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EglOffscreenSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, int i, int i2) {
        super(eglCore, eglCore.createOffscreenSurface$egloo_metadata_release(i, i2));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        setWidth(i);
        setHeight(i2);
    }
}
