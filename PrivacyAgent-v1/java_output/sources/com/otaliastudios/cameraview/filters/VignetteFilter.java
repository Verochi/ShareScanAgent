package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class VignetteFilter extends com.otaliastudios.cameraview.filter.BaseFilter implements com.otaliastudios.cameraview.filter.TwoParameterFilter {
    public float e = 0.85f;
    public float f = 0.5f;
    public int g = 1;
    public int h = 1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float range;\nuniform float inv_max_dist;\nuniform float shade;\nuniform vec2 scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n  const float slope = 20.0;\n  vec2 coord = vTextureCoord - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = shade / (1.0 + exp((dist * inv_max_dist - range) * slope)) + (1.0 - shade);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = vec4(color.rgb * lumen, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return getVignetteScale();
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public float getParameter2() {
        return getVignetteShade();
    }

    public float getVignetteScale() {
        return this.e;
    }

    public float getVignetteShade() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, "range");
        this.i = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "range");
        int glGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(i, "inv_max_dist");
        this.j = glGetUniformLocation2;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation2, "inv_max_dist");
        int glGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(i, "shade");
        this.k = glGetUniformLocation3;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation3, "shade");
        int glGetUniformLocation4 = android.opengl.GLES20.glGetUniformLocation(i, "scale");
        this.l = glGetUniformLocation4;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation4, "scale");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        float[] fArr2 = new float[2];
        int i = this.g;
        int i2 = this.h;
        if (i > i2) {
            fArr2[0] = 1.0f;
            fArr2[1] = i2 / i;
        } else {
            fArr2[0] = i / i2;
            fArr2[1] = 1.0f;
        }
        android.opengl.GLES20.glUniform2fv(this.l, 1, fArr2, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform2fv");
        float f = fArr2[0];
        float f2 = fArr2[1];
        android.opengl.GLES20.glUniform1f(this.j, 1.0f / (((float) java.lang.Math.sqrt((f * f) + (f2 * f2))) * 0.5f));
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
        android.opengl.GLES20.glUniform1f(this.k, this.f);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
        android.opengl.GLES20.glUniform1f(this.i, 1.3f - (((float) java.lang.Math.sqrt(this.e)) * 0.7f));
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f) {
        setVignetteScale(f);
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public void setParameter2(float f) {
        setVignetteShade(f);
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i, int i2) {
        super.setSize(i, i2);
        this.g = i;
        this.h = i2;
    }

    public void setVignetteScale(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.e = f;
    }

    public void setVignetteShade(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f = f;
    }
}
