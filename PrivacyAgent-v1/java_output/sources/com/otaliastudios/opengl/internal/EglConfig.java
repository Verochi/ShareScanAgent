package com.otaliastudios.opengl.internal;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/otaliastudios/opengl/internal/EglConfig;", "", "Landroid/opengl/EGLConfig;", "component1", com.anythink.expressad.foundation.g.a.f.a, com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "", "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "a", "Landroid/opengl/EGLConfig;", "getNative", "()Landroid/opengl/EGLConfig;", "<init>", "(Landroid/opengl/EGLConfig;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final /* data */ class EglConfig {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.opengl.EGLConfig native;

    public EglConfig(@org.jetbrains.annotations.NotNull android.opengl.EGLConfig eGLConfig) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eGLConfig, "native");
        this.native = eGLConfig;
    }

    public static /* synthetic */ com.otaliastudios.opengl.internal.EglConfig copy$default(com.otaliastudios.opengl.internal.EglConfig eglConfig, android.opengl.EGLConfig eGLConfig, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            eGLConfig = eglConfig.native;
        }
        return eglConfig.copy(eGLConfig);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: component1, reason: from getter */
    public final android.opengl.EGLConfig getNative() {
        return this.native;
    }

    @org.jetbrains.annotations.NotNull
    public final com.otaliastudios.opengl.internal.EglConfig copy(@org.jetbrains.annotations.NotNull android.opengl.EGLConfig r2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, "native");
        return new com.otaliastudios.opengl.internal.EglConfig(r2);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this != other) {
            return (other instanceof com.otaliastudios.opengl.internal.EglConfig) && kotlin.jvm.internal.Intrinsics.areEqual(this.native, ((com.otaliastudios.opengl.internal.EglConfig) other).native);
        }
        return true;
    }

    @org.jetbrains.annotations.NotNull
    public final android.opengl.EGLConfig getNative() {
        return this.native;
    }

    public int hashCode() {
        android.opengl.EGLConfig eGLConfig = this.native;
        if (eGLConfig != null) {
            return eGLConfig.hashCode();
        }
        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "EglConfig(native=" + this.native + ")";
    }
}
