package com.otaliastudios.opengl.program;

@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B-\b\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 ¢\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b$\u0010&B\u0019\b\u0016\u0012\u0006\u0010'\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020\u000e¢\u0006\u0004\b$\u0010)B\u001d\b\u0016\u0012\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 ¢\u0006\u0004\b$\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0004J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0004R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u001c\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgram;", "Lcom/otaliastudios/opengl/core/GlBindable;", "", "release", "bind", "unbind", "Lcom/otaliastudios/opengl/draw/GlDrawable;", com.anythink.expressad.foundation.h.i.c, "", "modelViewProjectionMatrix", com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "onPreDraw", "onDraw", "onPostDraw", "", "name", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "getAttribHandle", "getUniformHandle", "", "a", "Z", "isReleased", "", "b", "I", "getHandle", "()I", "handle", "c", "ownsHandle", "", "Lcom/otaliastudios/opengl/program/GlShader;", "d", "[Lcom/otaliastudios/opengl/program/GlShader;", "shaders", "<init>", "(IZ[Lcom/otaliastudios/opengl/program/GlShader;)V", "(I)V", "vertexShader", "fragmentShader", "(Ljava/lang/String;Ljava/lang/String;)V", "([Lcom/otaliastudios/opengl/program/GlShader;)V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlProgram implements com.otaliastudios.opengl.core.GlBindable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final com.otaliastudios.opengl.program.GlProgram.Companion INSTANCE = new com.otaliastudios.opengl.program.GlProgram.Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public boolean isReleased;

    /* renamed from: b, reason: from kotlin metadata */
    public final int handle;

    /* renamed from: c, reason: from kotlin metadata */
    public final boolean ownsHandle;

    /* renamed from: d, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlShader[] shaders;

    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgram$Companion;", "", "()V", "create", "", "shaders", "", "Lcom/otaliastudios/opengl/program/GlShader;", "([Lcom/otaliastudios/opengl/program/GlShader;)I", "vertexShaderSource", "", "fragmentShaderSource", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @kotlin.Deprecated(message = "Use create(GlShader) signature.")
        @kotlin.jvm.JvmStatic
        public final int create(@org.jetbrains.annotations.NotNull java.lang.String vertexShaderSource, @org.jetbrains.annotations.NotNull java.lang.String fragmentShaderSource) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexShaderSource, "vertexShaderSource");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fragmentShaderSource, "fragmentShaderSource");
            return create(new com.otaliastudios.opengl.program.GlShader(com.otaliastudios.opengl.internal.GlKt.getGL_VERTEX_SHADER(), vertexShaderSource), new com.otaliastudios.opengl.program.GlShader(com.otaliastudios.opengl.internal.GlKt.getGL_FRAGMENT_SHADER(), fragmentShaderSource));
        }

        @kotlin.jvm.JvmStatic
        public final int create(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.program.GlShader... shaders) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shaders, "shaders");
            int m191constructorimpl = kotlin.UInt.m191constructorimpl(android.opengl.GLES20.glCreateProgram());
            com.otaliastudios.opengl.core.Egloo.checkGlError("glCreateProgram");
            if (m191constructorimpl == 0) {
                throw new java.lang.RuntimeException("Could not create program");
            }
            for (com.otaliastudios.opengl.program.GlShader glShader : shaders) {
                android.opengl.GLES20.glAttachShader(m191constructorimpl, kotlin.UInt.m191constructorimpl(glShader.getId()));
                com.otaliastudios.opengl.core.Egloo.checkGlError("glAttachShader");
            }
            android.opengl.GLES20.glLinkProgram(m191constructorimpl);
            int[] iArr = new int[1];
            android.opengl.GLES20.glGetProgramiv(m191constructorimpl, com.otaliastudios.opengl.internal.GlKt.getGL_LINK_STATUS(), iArr, 0);
            if (iArr[0] == com.otaliastudios.opengl.internal.GlKt.getGL_TRUE()) {
                return m191constructorimpl;
            }
            java.lang.String str = "Could not link program: " + android.opengl.GLES20.glGetProgramInfoLog(m191constructorimpl);
            android.opengl.GLES20.glDeleteProgram(m191constructorimpl);
            throw new java.lang.RuntimeException(str);
        }
    }

    public GlProgram(int i) {
        this(i, false, new com.otaliastudios.opengl.program.GlShader[0]);
    }

    public GlProgram(int i, boolean z, @org.jetbrains.annotations.NotNull com.otaliastudios.opengl.program.GlShader... shaders) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shaders, "shaders");
        this.handle = i;
        this.ownsHandle = z;
        this.shaders = shaders;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlProgram(@org.jetbrains.annotations.NotNull java.lang.String vertexShader, @org.jetbrains.annotations.NotNull java.lang.String fragmentShader) {
        this(new com.otaliastudios.opengl.program.GlShader(com.otaliastudios.opengl.internal.GlKt.getGL_VERTEX_SHADER(), vertexShader), new com.otaliastudios.opengl.program.GlShader(com.otaliastudios.opengl.internal.GlKt.getGL_FRAGMENT_SHADER(), fragmentShader));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexShader, "vertexShader");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fragmentShader, "fragmentShader");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlProgram(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.program.GlShader... shaders) {
        this(INSTANCE.create((com.otaliastudios.opengl.program.GlShader[]) java.util.Arrays.copyOf(shaders, shaders.length)), true, (com.otaliastudios.opengl.program.GlShader[]) java.util.Arrays.copyOf(shaders, shaders.length));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shaders, "shaders");
    }

    @kotlin.Deprecated(message = "Use create(GlShader) signature.")
    @kotlin.jvm.JvmStatic
    public static final int create(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String str2) {
        return INSTANCE.create(str, str2);
    }

    @kotlin.jvm.JvmStatic
    public static final int create(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.program.GlShader... glShaderArr) {
        return INSTANCE.create(glShaderArr);
    }

    public static /* synthetic */ void draw$default(com.otaliastudios.opengl.program.GlProgram glProgram, com.otaliastudios.opengl.draw.GlDrawable glDrawable, float[] fArr, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw");
        }
        if ((i & 2) != 0) {
            fArr = glDrawable.getModelMatrix();
        }
        glProgram.draw(glDrawable, fArr);
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        android.opengl.GLES20.glUseProgram(kotlin.UInt.m191constructorimpl(this.handle));
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUseProgram");
    }

    @kotlin.jvm.JvmOverloads
    public final void draw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable glDrawable) {
        draw$default(this, glDrawable, null, 2, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void draw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable, @org.jetbrains.annotations.NotNull float[] modelViewProjectionMatrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelViewProjectionMatrix, "modelViewProjectionMatrix");
        com.otaliastudios.opengl.core.Egloo.checkGlError("draw start");
        com.otaliastudios.opengl.core.GlBindableKt.use(this, new com.otaliastudios.opengl.program.GlProgram$draw$1(this, drawable, modelViewProjectionMatrix));
        com.otaliastudios.opengl.core.Egloo.checkGlError("draw end");
    }

    @org.jetbrains.annotations.NotNull
    public final com.otaliastudios.opengl.program.GlProgramLocation getAttribHandle(@org.jetbrains.annotations.NotNull java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return com.otaliastudios.opengl.program.GlProgramLocation.INSTANCE.getAttrib(this.handle, name);
    }

    public final int getHandle() {
        return this.handle;
    }

    @org.jetbrains.annotations.NotNull
    public final com.otaliastudios.opengl.program.GlProgramLocation getUniformHandle(@org.jetbrains.annotations.NotNull java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return com.otaliastudios.opengl.program.GlProgramLocation.INSTANCE.getUniform(this.handle, name);
    }

    public void onDraw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        drawable.draw();
    }

    public void onPostDraw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    public void onPreDraw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable, @org.jetbrains.annotations.NotNull float[] modelViewProjectionMatrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelViewProjectionMatrix, "modelViewProjectionMatrix");
    }

    public void release() {
        if (this.isReleased) {
            return;
        }
        if (this.ownsHandle) {
            android.opengl.GLES20.glDeleteProgram(kotlin.UInt.m191constructorimpl(this.handle));
        }
        for (com.otaliastudios.opengl.program.GlShader glShader : this.shaders) {
            glShader.release();
        }
        this.isReleased = true;
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        android.opengl.GLES20.glUseProgram(0);
    }
}
