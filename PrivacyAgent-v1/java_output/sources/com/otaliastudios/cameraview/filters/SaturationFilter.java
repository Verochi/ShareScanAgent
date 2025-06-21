package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class SaturationFilter extends com.otaliastudios.cameraview.filter.BaseFilter implements com.otaliastudios.cameraview.filter.OneParameterFilter {
    public float e = 1.0f;
    public int f = -1;
    public int g = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform vec3 exponents;\nfloat shift;\nvec3 weights;\nvarying vec2 vTextureCoord;\nvoid main() {\n  weights[0] = 0.25;\n  weights[1] = 0.625;\n  weights[2] = 0.125;\n  shift = 0.003921569;\n  vec4 oldcolor = texture2D(sTexture, vTextureCoord);\n  float kv = dot(oldcolor.rgb, weights) + shift;\n  vec3 new_color = scale * oldcolor.rgb + (1.0 - scale) * kv;\n  gl_FragColor = vec4(new_color, oldcolor.a);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float de = dot(color.rgb, weights);\n  float inv_de = 1.0 / de;\n  vec3 verynew_color = de * pow(color.rgb * inv_de, exponents);\n  float max_color = max(max(max(verynew_color.r, verynew_color.g), verynew_color.b), 1.0);\n  gl_FragColor = gl_FragColor+vec4(verynew_color / max_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return (getSaturation() + 1.0f) / 2.0f;
    }

    public float getSaturation() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, "scale");
        this.f = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(i, "exponents");
        this.g = glGetUniformLocation2;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation2, "exponents");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.f = -1;
        this.g = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        float f = this.e;
        if (f <= 0.0f) {
            android.opengl.GLES20.glUniform1f(this.f, f + 1.0f);
            com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
            android.opengl.GLES20.glUniform3f(this.g, 0.0f, 0.0f, 0.0f);
            com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform3f");
            return;
        }
        android.opengl.GLES20.glUniform1f(this.f, 0.0f);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
        int i = this.g;
        float f2 = this.e;
        android.opengl.GLES20.glUniform3f(i, (0.9f * f2) + 1.0f, (2.1f * f2) + 1.0f, (f2 * 2.7f) + 1.0f);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform3f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f) {
        setSaturation((f * 2.0f) - 1.0f);
    }

    public void setSaturation(float f) {
        if (f < -1.0f) {
            f = -1.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.e = f;
    }
}
