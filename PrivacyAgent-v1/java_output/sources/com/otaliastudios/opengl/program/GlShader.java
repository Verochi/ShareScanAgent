package com.otaliastudios.opengl.program;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/otaliastudios/opengl/program/GlShader;", "", "", "release", "", "a", "I", "getType", "()I", "type", "b", "getId", "id", "<init>", "(II)V", "", com.tencent.open.SocialConstants.PARAM_SOURCE, "(ILjava/lang/String;)V", "c", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlShader {

    /* renamed from: c, reason: from kotlin metadata */
    public static final com.otaliastudios.opengl.program.GlShader.Companion INSTANCE = new com.otaliastudios.opengl.program.GlShader.Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final int type;

    /* renamed from: b, reason: from kotlin metadata */
    public final int id;

    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\t"}, d2 = {"Lcom/otaliastudios/opengl/program/GlShader$Companion;", "", "", "type", "", com.tencent.open.SocialConstants.PARAM_SOURCE, "b", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b(int type, java.lang.String source) {
            int m191constructorimpl = kotlin.UInt.m191constructorimpl(android.opengl.GLES20.glCreateShader(kotlin.UInt.m191constructorimpl(type)));
            com.otaliastudios.opengl.core.Egloo.checkGlError("glCreateShader type=" + type);
            android.opengl.GLES20.glShaderSource(m191constructorimpl, source);
            android.opengl.GLES20.glCompileShader(m191constructorimpl);
            int[] iArr = new int[1];
            android.opengl.GLES20.glGetShaderiv(m191constructorimpl, com.otaliastudios.opengl.internal.GlKt.getGL_COMPILE_STATUS(), iArr, 0);
            if (iArr[0] != 0) {
                return m191constructorimpl;
            }
            java.lang.String str = "Could not compile shader " + type + ": '" + android.opengl.GLES20.glGetShaderInfoLog(m191constructorimpl) + "' source: " + source;
            android.opengl.GLES20.glDeleteShader(m191constructorimpl);
            throw new java.lang.RuntimeException(str);
        }
    }

    public GlShader(int i, int i2) {
        this.type = i;
        this.id = i2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlShader(int i, @org.jetbrains.annotations.NotNull java.lang.String source) {
        this(i, INSTANCE.b(i, source));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
    }

    public final int getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final void release() {
        android.opengl.GLES20.glDeleteShader(kotlin.UInt.m191constructorimpl(this.id));
    }
}
