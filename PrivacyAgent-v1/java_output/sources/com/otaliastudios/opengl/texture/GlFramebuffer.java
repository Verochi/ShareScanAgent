package com.otaliastudios.opengl.texture;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0006R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/otaliastudios/opengl/texture/GlFramebuffer;", "Lcom/otaliastudios/opengl/core/GlBindable;", "Lcom/otaliastudios/opengl/texture/GlTexture;", "texture", "", "attachment", "", "attach", "bind", "unbind", "release", "a", "I", "getId", "()I", "id", "<init>", "(Ljava/lang/Integer;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlFramebuffer implements com.otaliastudios.opengl.core.GlBindable {

    /* renamed from: a, reason: from kotlin metadata */
    public final int id;

    public GlFramebuffer() {
        this(null, 1, null);
    }

    public GlFramebuffer(@org.jetbrains.annotations.Nullable java.lang.Integer num) {
        int m204getpVg5ArA;
        if (num != null) {
            m204getpVg5ArA = num.intValue();
        } else {
            int[] m198constructorimpl = kotlin.UIntArray.m198constructorimpl(1);
            int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(m198constructorimpl);
            int[] iArr = new int[m205getSizeimpl];
            for (int i = 0; i < m205getSizeimpl; i++) {
                iArr[i] = kotlin.UIntArray.m204getpVg5ArA(m198constructorimpl, i);
            }
            android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            for (int i2 = 0; i2 < 1; i2++) {
                kotlin.UIntArray.m209setVXSXFK8(m198constructorimpl, i2, kotlin.UInt.m191constructorimpl(iArr[i2]));
            }
            com.otaliastudios.opengl.core.Egloo.checkGlError("glGenFramebuffers");
            m204getpVg5ArA = kotlin.UIntArray.m204getpVg5ArA(m198constructorimpl, 0);
        }
        this.id = m204getpVg5ArA;
    }

    public /* synthetic */ GlFramebuffer(java.lang.Integer num, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    public static /* synthetic */ void attach$default(com.otaliastudios.opengl.texture.GlFramebuffer glFramebuffer, com.otaliastudios.opengl.texture.GlTexture glTexture, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = com.otaliastudios.opengl.internal.GlKt.getGL_COLOR_ATTACHMENT0();
        }
        glFramebuffer.attach(glTexture, i);
    }

    @kotlin.jvm.JvmOverloads
    public final void attach(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.texture.GlTexture glTexture) {
        attach$default(this, glTexture, 0, 2, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void attach(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.texture.GlTexture texture, int attachment) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(texture, "texture");
        com.otaliastudios.opengl.core.GlBindableKt.use(this, new com.otaliastudios.opengl.texture.GlFramebuffer$attach$1(attachment, texture));
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        android.opengl.GLES20.glBindFramebuffer(com.otaliastudios.opengl.internal.GlKt.getGL_FRAMEBUFFER(), kotlin.UInt.m191constructorimpl(this.id));
    }

    public final int getId() {
        return this.id;
    }

    public final void release() {
        int[] iArr = {kotlin.UInt.m191constructorimpl(this.id)};
        int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(iArr);
        int[] iArr2 = new int[m205getSizeimpl];
        for (int i = 0; i < m205getSizeimpl; i++) {
            iArr2[i] = kotlin.UIntArray.m204getpVg5ArA(iArr, i);
        }
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr2, 0);
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        for (int i2 = 0; i2 < 1; i2++) {
            kotlin.UIntArray.m209setVXSXFK8(iArr, i2, kotlin.UInt.m191constructorimpl(iArr2[i2]));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        android.opengl.GLES20.glBindFramebuffer(com.otaliastudios.opengl.internal.GlKt.getGL_FRAMEBUFFER(), 0);
    }
}
