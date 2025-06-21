package com.otaliastudios.opengl.program;

@kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001JB=\b\u0004\u0012\u0006\u0010=\u001a\u00020\b\u0012\u0006\u0010>\u001a\u00020\u000f\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010A\u001a\u00020?\u0012\b\u0010B\u001a\u0004\u0018\u00010?\u0012\b\u0010C\u001a\u0004\u0018\u00010?¢\u0006\u0004\bD\u0010EBI\b\u0017\u0012\b\b\u0002\u0010F\u001a\u00020?\u0012\b\b\u0002\u0010G\u001a\u00020?\u0012\b\b\u0002\u0010@\u001a\u00020?\u0012\b\b\u0002\u0010A\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010?¢\u0006\u0004\bD\u0010HB=\b\u0017\u0012\u0006\u0010=\u001a\u00020\b\u0012\b\b\u0002\u0010@\u001a\u00020?\u0012\b\b\u0002\u0010A\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010?¢\u0006\u0004\bD\u0010IJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J8\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010#\u001a\u00060\u001fj\u0002` 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001dR\u0014\u0010'\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001dR\u0014\u0010)\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001dR\u0018\u0010.\u001a\u00060*j\u0002`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006K"}, d2 = {"Lcom/otaliastudios/opengl/program/GlTextureProgram;", "Lcom/otaliastudios/opengl/program/GlProgram;", "Lcom/otaliastudios/opengl/draw/GlDrawable;", com.anythink.expressad.foundation.h.i.c, "", "modelViewProjectionMatrix", "", "onPreDraw", "", "vertex", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "value", org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY, org.apache.tools.ant.types.selectors.DepthSelector.MAX_KEY, "", "horizontal", "computeTextureCoordinate", "onPostDraw", "release", "e", "[F", "getTextureTransform", "()[F", "setTextureTransform", "([F)V", "textureTransform", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "f", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "textureTransformHandle", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "g", "Ljava/nio/FloatBuffer;", "textureCoordsBuffer", "h", "textureCoordsHandle", "i", "vertexPositionHandle", "j", "vertexMvpMatrixHandle", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "k", "Landroid/graphics/RectF;", "lastDrawableBounds", "l", "I", "lastDrawableVersion", com.anythink.expressad.d.a.b.dH, "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "lastDrawable", "Lcom/otaliastudios/opengl/texture/GlTexture;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lcom/otaliastudios/opengl/texture/GlTexture;", "getTexture", "()Lcom/otaliastudios/opengl/texture/GlTexture;", "setTexture", "(Lcom/otaliastudios/opengl/texture/GlTexture;)V", "texture", "handle", "ownsHandle", "", "vertexPositionName", "vertexMvpMatrixName", "textureCoordsName", "textureTransformName", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vertexShader", "fragmentShader", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlTextureProgram extends com.otaliastudios.opengl.program.GlProgram {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SIMPLE_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SIMPLE_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public float[] textureTransform;

    /* renamed from: f, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlProgramLocation textureTransformHandle;

    /* renamed from: g, reason: from kotlin metadata */
    public java.nio.FloatBuffer textureCoordsBuffer;

    /* renamed from: h, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlProgramLocation textureCoordsHandle;

    /* renamed from: i, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlProgramLocation vertexPositionHandle;

    /* renamed from: j, reason: from kotlin metadata */
    public final com.otaliastudios.opengl.program.GlProgramLocation vertexMvpMatrixHandle;

    /* renamed from: k, reason: from kotlin metadata */
    public final android.graphics.RectF lastDrawableBounds;

    /* renamed from: l, reason: from kotlin metadata */
    public int lastDrawableVersion;

    /* renamed from: m, reason: from kotlin metadata */
    public com.otaliastudios.opengl.draw.Gl2dDrawable lastDrawable;

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.otaliastudios.opengl.texture.GlTexture texture;

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram() {
        this(null, null, null, null, null, null, 63, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(int i) {
        this(i, null, null, null, null, 30, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(int i, @org.jetbrains.annotations.NotNull java.lang.String str) {
        this(i, str, null, null, null, 28, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(int i, @org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String str2) {
        this(i, str, str2, null, null, 24, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(int i, @org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String str2, @org.jetbrains.annotations.Nullable java.lang.String str3) {
        this(i, str, str2, str3, null, 16, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(int i, @org.jetbrains.annotations.NotNull java.lang.String vertexPositionName, @org.jetbrains.annotations.NotNull java.lang.String vertexMvpMatrixName, @org.jetbrains.annotations.Nullable java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.String str2) {
        this(i, false, vertexPositionName, vertexMvpMatrixName, str, str2);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexPositionName, "vertexPositionName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexMvpMatrixName, "vertexMvpMatrixName");
    }

    public /* synthetic */ GlTextureProgram(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "aPosition" : str, (i2 & 4) != 0 ? "uMVPMatrix" : str2, (i2 & 8) != 0 ? "aTextureCoord" : str3, (i2 & 16) != 0 ? "uTexMatrix" : str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlTextureProgram(int i, boolean z, @org.jetbrains.annotations.NotNull java.lang.String vertexPositionName, @org.jetbrains.annotations.NotNull java.lang.String vertexMvpMatrixName, @org.jetbrains.annotations.Nullable java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.String str2) {
        super(i, z, new com.otaliastudios.opengl.program.GlShader[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexPositionName, "vertexPositionName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexMvpMatrixName, "vertexMvpMatrixName");
        this.textureTransform = com.otaliastudios.opengl.internal.MiscKt.matrixClone(com.otaliastudios.opengl.core.Egloo.IDENTITY_MATRIX);
        this.textureTransformHandle = str2 != null ? getUniformHandle(str2) : null;
        this.textureCoordsBuffer = com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(8);
        this.textureCoordsHandle = str != null ? getAttribHandle(str) : null;
        this.vertexPositionHandle = getAttribHandle(vertexPositionName);
        this.vertexMvpMatrixHandle = getUniformHandle(vertexMvpMatrixName);
        this.lastDrawableBounds = new android.graphics.RectF();
        this.lastDrawableVersion = -1;
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(@org.jetbrains.annotations.NotNull java.lang.String str) {
        this(str, null, null, null, null, null, 62, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String str2) {
        this(str, str2, null, null, null, null, 60, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String str2, @org.jetbrains.annotations.NotNull java.lang.String str3) {
        this(str, str2, str3, null, null, null, 56, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String str2, @org.jetbrains.annotations.NotNull java.lang.String str3, @org.jetbrains.annotations.NotNull java.lang.String str4) {
        this(str, str2, str3, str4, null, null, 48, null);
    }

    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String str2, @org.jetbrains.annotations.NotNull java.lang.String str3, @org.jetbrains.annotations.NotNull java.lang.String str4, @org.jetbrains.annotations.Nullable java.lang.String str5) {
        this(str, str2, str3, str4, str5, null, 32, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public GlTextureProgram(@org.jetbrains.annotations.NotNull java.lang.String vertexShader, @org.jetbrains.annotations.NotNull java.lang.String fragmentShader, @org.jetbrains.annotations.NotNull java.lang.String vertexPositionName, @org.jetbrains.annotations.NotNull java.lang.String vertexMvpMatrixName, @org.jetbrains.annotations.Nullable java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.String str2) {
        this(com.otaliastudios.opengl.program.GlProgram.INSTANCE.create(vertexShader, fragmentShader), true, vertexPositionName, vertexMvpMatrixName, str, str2);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexShader, "vertexShader");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fragmentShader, "fragmentShader");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexPositionName, "vertexPositionName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(vertexMvpMatrixName, "vertexMvpMatrixName");
    }

    public /* synthetic */ GlTextureProgram(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SIMPLE_VERTEX_SHADER : str, (i & 2) != 0 ? SIMPLE_FRAGMENT_SHADER : str2, (i & 4) != 0 ? "aPosition" : str3, (i & 8) != 0 ? "uMVPMatrix" : str4, (i & 16) != 0 ? "aTextureCoord" : str5, (i & 32) != 0 ? "uTexMatrix" : str6);
    }

    public float computeTextureCoordinate(int vertex, @org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.Gl2dDrawable drawable, float value, float min, float max, boolean horizontal) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        return (((value - min) / (max - min)) * 1.0f) + 0.0f;
    }

    @org.jetbrains.annotations.Nullable
    public final com.otaliastudios.opengl.texture.GlTexture getTexture() {
        return this.texture;
    }

    @org.jetbrains.annotations.NotNull
    public final float[] getTextureTransform() {
        return this.textureTransform;
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPostDraw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        super.onPostDraw(drawable);
        android.opengl.GLES20.glDisableVertexAttribArray(this.vertexPositionHandle.getUvalue());
        com.otaliastudios.opengl.program.GlProgramLocation glProgramLocation = this.textureCoordsHandle;
        if (glProgramLocation != null) {
            android.opengl.GLES20.glDisableVertexAttribArray(glProgramLocation.getUvalue());
        }
        com.otaliastudios.opengl.texture.GlTexture glTexture = this.texture;
        if (glTexture != null) {
            glTexture.unbind();
        }
        com.otaliastudios.opengl.core.Egloo.checkGlError("onPostDraw end");
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPreDraw(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.draw.GlDrawable drawable, @org.jetbrains.annotations.NotNull float[] modelViewProjectionMatrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modelViewProjectionMatrix, "modelViewProjectionMatrix");
        super.onPreDraw(drawable, modelViewProjectionMatrix);
        if (!(drawable instanceof com.otaliastudios.opengl.draw.Gl2dDrawable)) {
            throw new java.lang.RuntimeException("GlTextureProgram only supports 2D drawables.");
        }
        com.otaliastudios.opengl.texture.GlTexture glTexture = this.texture;
        if (glTexture != null) {
            glTexture.bind();
        }
        android.opengl.GLES20.glUniformMatrix4fv(this.vertexMvpMatrixHandle.getValue(), 1, false, modelViewProjectionMatrix, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniformMatrix4fv");
        com.otaliastudios.opengl.program.GlProgramLocation glProgramLocation = this.textureTransformHandle;
        if (glProgramLocation != null) {
            android.opengl.GLES20.glUniformMatrix4fv(glProgramLocation.getValue(), 1, false, this.textureTransform, 0);
            com.otaliastudios.opengl.core.Egloo.checkGlError("glUniformMatrix4fv");
        }
        com.otaliastudios.opengl.program.GlProgramLocation glProgramLocation2 = this.vertexPositionHandle;
        android.opengl.GLES20.glEnableVertexAttribArray(glProgramLocation2.getUvalue());
        com.otaliastudios.opengl.core.Egloo.checkGlError("glEnableVertexAttribArray");
        android.opengl.GLES20.glVertexAttribPointer(glProgramLocation2.getUvalue(), 2, com.otaliastudios.opengl.internal.GlKt.getGL_FLOAT(), false, drawable.getVertexStride(), (java.nio.Buffer) drawable.getVertexArray());
        com.otaliastudios.opengl.core.Egloo.checkGlError("glVertexAttribPointer");
        com.otaliastudios.opengl.program.GlProgramLocation glProgramLocation3 = this.textureCoordsHandle;
        if (glProgramLocation3 != null) {
            if ((!kotlin.jvm.internal.Intrinsics.areEqual(drawable, this.lastDrawable)) || drawable.getVertexArrayVersion() != this.lastDrawableVersion) {
                com.otaliastudios.opengl.draw.Gl2dDrawable gl2dDrawable = (com.otaliastudios.opengl.draw.Gl2dDrawable) drawable;
                this.lastDrawable = gl2dDrawable;
                this.lastDrawableVersion = drawable.getVertexArrayVersion();
                gl2dDrawable.getBounds(this.lastDrawableBounds);
                int vertexCount = drawable.getVertexCount() * 2;
                if (this.textureCoordsBuffer.capacity() < vertexCount) {
                    com.otaliastudios.opengl.types.BuffersKt.dispose(this.textureCoordsBuffer);
                    this.textureCoordsBuffer = com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(vertexCount);
                }
                this.textureCoordsBuffer.clear();
                this.textureCoordsBuffer.limit(vertexCount);
                for (int i = 0; i < vertexCount; i++) {
                    boolean z = i % 2 == 0;
                    float f = drawable.getVertexArray().get(i);
                    android.graphics.RectF rectF = this.lastDrawableBounds;
                    float f2 = z ? rectF.left : rectF.bottom;
                    android.graphics.RectF rectF2 = this.lastDrawableBounds;
                    this.textureCoordsBuffer.put(computeTextureCoordinate(i / 2, gl2dDrawable, f, f2, z ? rectF2.right : rectF2.top, z));
                }
            }
            this.textureCoordsBuffer.rewind();
            android.opengl.GLES20.glEnableVertexAttribArray(glProgramLocation3.getUvalue());
            com.otaliastudios.opengl.core.Egloo.checkGlError("glEnableVertexAttribArray");
            android.opengl.GLES20.glVertexAttribPointer(glProgramLocation3.getUvalue(), 2, com.otaliastudios.opengl.internal.GlKt.getGL_FLOAT(), false, drawable.getVertexStride(), (java.nio.Buffer) this.textureCoordsBuffer);
            com.otaliastudios.opengl.core.Egloo.checkGlError("glVertexAttribPointer");
        }
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void release() {
        super.release();
        com.otaliastudios.opengl.types.BuffersKt.dispose(this.textureCoordsBuffer);
        com.otaliastudios.opengl.texture.GlTexture glTexture = this.texture;
        if (glTexture != null) {
            glTexture.release();
        }
        this.texture = null;
    }

    public final void setTexture(@org.jetbrains.annotations.Nullable com.otaliastudios.opengl.texture.GlTexture glTexture) {
        this.texture = glTexture;
    }

    public final void setTextureTransform(@org.jetbrains.annotations.NotNull float[] fArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.textureTransform = fArr;
    }
}
