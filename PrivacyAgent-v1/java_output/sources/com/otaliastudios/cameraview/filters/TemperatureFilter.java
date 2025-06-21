package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class TemperatureFilter extends com.otaliastudios.cameraview.filter.BaseFilter implements com.otaliastudios.cameraview.filter.OneParameterFilter {
    public float e = 1.0f;
    public int f = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  vec3 new_color = color.rgb;\n  new_color.r = color.r + color.r * ( 1.0 - color.r) * scale;\n  new_color.b = color.b - color.b * ( 1.0 - color.b) * scale;\n  if (scale > 0.0) { \n    new_color.g = color.g + color.g * ( 1.0 - color.g) * scale * 0.25;\n  }\n  float max_value = max(new_color.r, max(new_color.g, new_color.b));\n  if (max_value > 1.0) { \n     new_color /= max_value;\n  } \n  gl_FragColor = vec4(new_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return (getTemperature() + 1.0f) / 2.0f;
    }

    public float getTemperature() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, "scale");
        this.f = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.f = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        android.opengl.GLES20.glUniform1f(this.f, this.e);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f) {
        setTemperature((f * 2.0f) - 1.0f);
    }

    public void setTemperature(float f) {
        if (f < -1.0f) {
            f = -1.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.e = f;
    }
}
