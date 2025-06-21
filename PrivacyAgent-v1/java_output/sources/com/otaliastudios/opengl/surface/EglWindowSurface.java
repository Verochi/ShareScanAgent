package com.otaliastudios.opengl.surface;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B#\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglWindowSurface;", "Lcom/otaliastudios/opengl/surface/EglNativeWindowSurface;", "", "release", "Landroid/view/Surface;", "f", "Landroid/view/Surface;", "surface", "", "g", "Z", "releaseSurface", "Lcom/otaliastudios/opengl/core/EglCore;", "eglCore", "<init>", "(Lcom/otaliastudios/opengl/core/EglCore;Landroid/view/Surface;Z)V", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "(Lcom/otaliastudios/opengl/core/EglCore;Landroid/graphics/SurfaceTexture;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class EglWindowSurface extends com.otaliastudios.opengl.surface.EglNativeWindowSurface {

    /* renamed from: f, reason: from kotlin metadata */
    public android.view.Surface surface;

    /* renamed from: g, reason: from kotlin metadata */
    public boolean releaseSurface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EglWindowSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, @org.jetbrains.annotations.NotNull android.graphics.SurfaceTexture surfaceTexture) {
        super(eglCore, eglCore.createWindowSurface$egloo_metadata_release(surfaceTexture));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
    }

    @kotlin.jvm.JvmOverloads
    public EglWindowSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, @org.jetbrains.annotations.NotNull android.view.Surface surface) {
        this(eglCore, surface, false, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public EglWindowSurface(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.EglCore eglCore, @org.jetbrains.annotations.NotNull android.view.Surface surface, boolean z) {
        super(eglCore, eglCore.createWindowSurface$egloo_metadata_release(surface));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(surface, "surface");
        this.surface = surface;
        this.releaseSurface = z;
    }

    public /* synthetic */ EglWindowSurface(com.otaliastudios.opengl.core.EglCore eglCore, android.view.Surface surface, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(eglCore, surface, (i & 4) != 0 ? false : z);
    }

    @Override // com.otaliastudios.opengl.surface.EglNativeSurface
    public void release() {
        super.release();
        if (this.releaseSurface) {
            android.view.Surface surface = this.surface;
            if (surface != null) {
                surface.release();
            }
            this.surface = null;
        }
    }
}
