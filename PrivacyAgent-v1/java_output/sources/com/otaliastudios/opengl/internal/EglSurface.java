package com.otaliastudios.opengl.internal;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/otaliastudios/opengl/internal/EglSurface;", "", "Landroid/opengl/EGLSurface;", "component1", com.anythink.expressad.foundation.g.a.f.a, com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "", "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "a", "Landroid/opengl/EGLSurface;", "getNative", "()Landroid/opengl/EGLSurface;", "<init>", "(Landroid/opengl/EGLSurface;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final /* data */ class EglSurface {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final android.opengl.EGLSurface native;

    public EglSurface(@org.jetbrains.annotations.Nullable android.opengl.EGLSurface eGLSurface) {
        this.native = eGLSurface;
    }

    public static /* synthetic */ com.otaliastudios.opengl.internal.EglSurface copy$default(com.otaliastudios.opengl.internal.EglSurface eglSurface, android.opengl.EGLSurface eGLSurface, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            eGLSurface = eglSurface.native;
        }
        return eglSurface.copy(eGLSurface);
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: component1, reason: from getter */
    public final android.opengl.EGLSurface getNative() {
        return this.native;
    }

    @org.jetbrains.annotations.NotNull
    public final com.otaliastudios.opengl.internal.EglSurface copy(@org.jetbrains.annotations.Nullable android.opengl.EGLSurface r2) {
        return new com.otaliastudios.opengl.internal.EglSurface(r2);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this != other) {
            return (other instanceof com.otaliastudios.opengl.internal.EglSurface) && kotlin.jvm.internal.Intrinsics.areEqual(this.native, ((com.otaliastudios.opengl.internal.EglSurface) other).native);
        }
        return true;
    }

    @org.jetbrains.annotations.Nullable
    public final android.opengl.EGLSurface getNative() {
        return this.native;
    }

    public int hashCode() {
        android.opengl.EGLSurface eGLSurface = this.native;
        if (eGLSurface != null) {
            return eGLSurface.hashCode();
        }
        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "EglSurface(native=" + this.native + ")";
    }
}
