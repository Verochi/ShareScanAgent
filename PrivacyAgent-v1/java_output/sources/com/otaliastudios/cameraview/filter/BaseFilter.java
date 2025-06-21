package com.otaliastudios.cameraview.filter;

/* loaded from: classes19.dex */
public abstract class BaseFilter implements com.otaliastudios.cameraview.filter.Filter {
    protected static final java.lang.String DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME = "vTextureCoord";
    protected static final java.lang.String DEFAULT_VERTEX_MVP_MATRIX_NAME = "uMVPMatrix";
    protected static final java.lang.String DEFAULT_VERTEX_POSITION_NAME = "aPosition";
    protected static final java.lang.String DEFAULT_VERTEX_TEXTURE_COORDINATE_NAME = "aTextureCoord";
    protected static final java.lang.String DEFAULT_VERTEX_TRANSFORM_MATRIX_NAME = "uTexMatrix";
    public static final com.otaliastudios.cameraview.CameraLogger d = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.filter.BaseFilter.class.getSimpleName());

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.size.Size c;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.opengl.program.GlTextureProgram a = null;
    public com.otaliastudios.opengl.draw.GlDrawable b = null;
    protected java.lang.String vertexPositionName = DEFAULT_VERTEX_POSITION_NAME;
    protected java.lang.String vertexTextureCoordinateName = DEFAULT_VERTEX_TEXTURE_COORDINATE_NAME;
    protected java.lang.String vertexModelViewProjectionMatrixName = DEFAULT_VERTEX_MVP_MATRIX_NAME;
    protected java.lang.String vertexTransformMatrixName = DEFAULT_VERTEX_TRANSFORM_MATRIX_NAME;
    protected java.lang.String fragmentTextureCoordinateName = DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME;

    @androidx.annotation.NonNull
    public static java.lang.String a(@androidx.annotation.NonNull java.lang.String str) {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 " + str + ";\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, " + str + ");\n}\n";
    }

    @androidx.annotation.NonNull
    public static java.lang.String b(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3, @androidx.annotation.NonNull java.lang.String str4, @androidx.annotation.NonNull java.lang.String str5) {
        return "uniform mat4 " + str3 + ";\nuniform mat4 " + str4 + ";\nattribute vec4 " + str + ";\nattribute vec4 " + str2 + ";\nvarying vec2 " + str5 + ";\nvoid main() {\n    gl_Position = " + str3 + " * " + str + ";\n    " + str5 + " = (" + str4 + " * " + str2 + ").xy;\n}\n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.filter.BaseFilter copy() {
        com.otaliastudios.cameraview.filter.BaseFilter onCopy = onCopy();
        com.otaliastudios.cameraview.size.Size size = this.c;
        if (size != null) {
            onCopy.setSize(size.getWidth(), this.c.getHeight());
        }
        if (this instanceof com.otaliastudios.cameraview.filter.OneParameterFilter) {
            ((com.otaliastudios.cameraview.filter.OneParameterFilter) onCopy).setParameter1(((com.otaliastudios.cameraview.filter.OneParameterFilter) this).getParameter1());
        }
        if (this instanceof com.otaliastudios.cameraview.filter.TwoParameterFilter) {
            ((com.otaliastudios.cameraview.filter.TwoParameterFilter) onCopy).setParameter2(((com.otaliastudios.cameraview.filter.TwoParameterFilter) this).getParameter2());
        }
        return onCopy;
    }

    @androidx.annotation.NonNull
    public java.lang.String createDefaultFragmentShader() {
        return a(this.fragmentTextureCoordinateName);
    }

    @androidx.annotation.NonNull
    public java.lang.String createDefaultVertexShader() {
        return b(this.vertexPositionName, this.vertexTextureCoordinateName, this.vertexModelViewProjectionMatrixName, this.vertexTransformMatrixName, this.fragmentTextureCoordinateName);
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void draw(long j, @androidx.annotation.NonNull float[] fArr) {
        if (this.a == null) {
            d.w("Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            return;
        }
        onPreDraw(j, fArr);
        onDraw(j);
        onPostDraw(j);
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getVertexShader() {
        return createDefaultVertexShader();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.BaseFilter onCopy() {
        try {
            return (com.otaliastudios.cameraview.filter.BaseFilter) getClass().newInstance();
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (java.lang.InstantiationException e2) {
            throw new java.lang.RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        this.a = new com.otaliastudios.opengl.program.GlTextureProgram(i, this.vertexPositionName, this.vertexModelViewProjectionMatrixName, this.vertexTextureCoordinateName, this.vertexTransformMatrixName);
        this.b = new com.otaliastudios.opengl.draw.GlRect();
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        this.a.release();
        this.a = null;
        this.b = null;
    }

    public void onDraw(long j) {
        this.a.onDraw(this.b);
    }

    public void onPostDraw(long j) {
        this.a.onPostDraw(this.b);
    }

    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        this.a.setTextureTransform(fArr);
        com.otaliastudios.opengl.program.GlTextureProgram glTextureProgram = this.a;
        com.otaliastudios.opengl.draw.GlDrawable glDrawable = this.b;
        glTextureProgram.onPreDraw(glDrawable, glDrawable.getModelMatrix());
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i, int i2) {
        this.c = new com.otaliastudios.cameraview.size.Size(i, i2);
    }
}
