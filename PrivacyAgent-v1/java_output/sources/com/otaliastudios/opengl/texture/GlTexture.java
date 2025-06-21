package com.otaliastudios.opengl.texture;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\u0018\u00002\u00020\u0001BU\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\"B)\b\u0017\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b!\u0010#BG\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b!\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015¨\u0006%"}, d2 = {"Lcom/otaliastudios/opengl/texture/GlTexture;", "Lcom/otaliastudios/opengl/core/GlBindable;", "", "bind", "unbind", "release", "", "a", "I", "getId", "()I", "id", "b", "getUnit", "unit", "c", "getTarget", com.umeng.ccg.a.A, "d", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "width", "e", "getHeight", "height", "f", "getFormat", "format", "g", "getType", "type", "internalFormat", "<init>", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "(IILjava/lang/Integer;)V", "(IIIIIII)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlTexture implements com.otaliastudios.opengl.core.GlBindable {

    /* renamed from: a, reason: from kotlin metadata */
    public final int id;

    /* renamed from: b, reason: from kotlin metadata */
    public final int unit;

    /* renamed from: c, reason: from kotlin metadata */
    public final int target;

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer width;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer height;

    /* renamed from: f, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer format;

    /* renamed from: g, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer type;

    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
    /* renamed from: com.otaliastudios.opengl.texture.GlTexture$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.Unit> {
        final /* synthetic */ java.lang.Integer $internalFormat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.Integer num) {
            super(0);
            this.$internalFormat = num;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
            invoke2();
            return kotlin.Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (com.otaliastudios.opengl.texture.GlTexture.this.getWidth() != null && com.otaliastudios.opengl.texture.GlTexture.this.getHeight() != null && com.otaliastudios.opengl.texture.GlTexture.this.getFormat() != null && this.$internalFormat != null && com.otaliastudios.opengl.texture.GlTexture.this.getType() != null) {
                android.opengl.GLES20.glTexImage2D(kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.texture.GlTexture.this.getTarget()), 0, this.$internalFormat.intValue(), com.otaliastudios.opengl.texture.GlTexture.this.getWidth().intValue(), com.otaliastudios.opengl.texture.GlTexture.this.getHeight().intValue(), 0, kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.texture.GlTexture.this.getFormat().intValue()), kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.texture.GlTexture.this.getType().intValue()), null);
            }
            android.opengl.GLES20.glTexParameterf(kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.texture.GlTexture.this.getTarget()), com.otaliastudios.opengl.internal.GlKt.getGL_TEXTURE_MIN_FILTER(), com.otaliastudios.opengl.internal.GlKt.getGL_NEAREST());
            android.opengl.GLES20.glTexParameterf(kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.texture.GlTexture.this.getTarget()), com.otaliastudios.opengl.internal.GlKt.getGL_TEXTURE_MAG_FILTER(), com.otaliastudios.opengl.internal.GlKt.getGL_LINEAR());
            android.opengl.GLES20.glTexParameteri(kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.texture.GlTexture.this.getTarget()), com.otaliastudios.opengl.internal.GlKt.getGL_TEXTURE_WRAP_S(), com.otaliastudios.opengl.internal.GlKt.getGL_CLAMP_TO_EDGE());
            android.opengl.GLES20.glTexParameteri(kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.texture.GlTexture.this.getTarget()), com.otaliastudios.opengl.internal.GlKt.getGL_TEXTURE_WRAP_T(), com.otaliastudios.opengl.internal.GlKt.getGL_CLAMP_TO_EDGE());
            com.otaliastudios.opengl.core.Egloo.checkGlError("glTexParameter");
        }
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture() {
        this(0, 0, (java.lang.Integer) null, 7, (kotlin.jvm.internal.DefaultConstructorMarker) null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture(int i) {
        this(i, 0, (java.lang.Integer) null, 6, (kotlin.jvm.internal.DefaultConstructorMarker) null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture(int i, int i2) {
        this(i, i2, (java.lang.Integer) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, 0, 0, 112, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 0, 96, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4, int i5, int i6) {
        this(i, i2, i3, i4, i5, i6, 0, 64, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(i, i2, null, java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i6), java.lang.Integer.valueOf(i7));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GlTexture(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, r6, (i8 & 32) != 0 ? r6 : i6, (i8 & 64) != 0 ? com.otaliastudios.opengl.internal.GlKt.getGL_UNSIGNED_BYTE() : i7);
        int gl_rgba = (i8 & 16) != 0 ? com.otaliastudios.opengl.internal.GlKt.getGL_RGBA() : i5;
    }

    @kotlin.jvm.JvmOverloads
    public GlTexture(int i, int i2, @org.jetbrains.annotations.Nullable java.lang.Integer num) {
        this(i, i2, num, null, null, null, null, null);
    }

    public /* synthetic */ GlTexture(int i, int i2, java.lang.Integer num, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? com.otaliastudios.opengl.internal.GlKt.getGL_TEXTURE0() : i, (i3 & 2) != 0 ? com.otaliastudios.opengl.internal.GlKt.getGL_TEXTURE_EXTERNAL_OES() : i2, (i3 & 4) != 0 ? null : num);
    }

    public GlTexture(int i, int i2, java.lang.Integer num, java.lang.Integer num2, java.lang.Integer num3, java.lang.Integer num4, java.lang.Integer num5, java.lang.Integer num6) {
        int m204getpVg5ArA;
        this.unit = i;
        this.target = i2;
        this.width = num2;
        this.height = num3;
        this.format = num4;
        this.type = num6;
        if (num != null) {
            m204getpVg5ArA = num.intValue();
        } else {
            int[] m198constructorimpl = kotlin.UIntArray.m198constructorimpl(1);
            int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(m198constructorimpl);
            int[] iArr = new int[m205getSizeimpl];
            for (int i3 = 0; i3 < m205getSizeimpl; i3++) {
                iArr[i3] = kotlin.UIntArray.m204getpVg5ArA(m198constructorimpl, i3);
            }
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            for (int i4 = 0; i4 < 1; i4++) {
                kotlin.UIntArray.m209setVXSXFK8(m198constructorimpl, i4, kotlin.UInt.m191constructorimpl(iArr[i4]));
            }
            com.otaliastudios.opengl.core.Egloo.checkGlError("glGenTextures");
            m204getpVg5ArA = kotlin.UIntArray.m204getpVg5ArA(m198constructorimpl, 0);
        }
        this.id = m204getpVg5ArA;
        if (num == null) {
            com.otaliastudios.opengl.core.GlBindableKt.use(this, new com.otaliastudios.opengl.texture.GlTexture.AnonymousClass1(num5));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        android.opengl.GLES20.glActiveTexture(kotlin.UInt.m191constructorimpl(this.unit));
        android.opengl.GLES20.glBindTexture(kotlin.UInt.m191constructorimpl(this.target), kotlin.UInt.m191constructorimpl(this.id));
        com.otaliastudios.opengl.core.Egloo.checkGlError("bind");
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getFormat() {
        return this.format;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getHeight() {
        return this.height;
    }

    public final int getId() {
        return this.id;
    }

    public final int getTarget() {
        return this.target;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getType() {
        return this.type;
    }

    public final int getUnit() {
        return this.unit;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getWidth() {
        return this.width;
    }

    public final void release() {
        int[] iArr = {kotlin.UInt.m191constructorimpl(this.id)};
        int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(iArr);
        int[] iArr2 = new int[m205getSizeimpl];
        for (int i = 0; i < m205getSizeimpl; i++) {
            iArr2[i] = kotlin.UIntArray.m204getpVg5ArA(iArr, i);
        }
        android.opengl.GLES20.glDeleteTextures(1, iArr2, 0);
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        for (int i2 = 0; i2 < 1; i2++) {
            kotlin.UIntArray.m209setVXSXFK8(iArr, i2, kotlin.UInt.m191constructorimpl(iArr2[i2]));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        android.opengl.GLES20.glBindTexture(kotlin.UInt.m191constructorimpl(this.target), kotlin.UInt.m191constructorimpl(0));
        android.opengl.GLES20.glActiveTexture(com.otaliastudios.opengl.internal.GlKt.getGL_TEXTURE0());
        com.otaliastudios.opengl.core.Egloo.checkGlError("unbind");
    }
}
