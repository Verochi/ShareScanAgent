package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class SharpnessFilter extends com.otaliastudios.cameraview.filter.BaseFilter implements com.otaliastudios.cameraview.filter.OneParameterFilter {
    public float e = 0.5f;
    public int f = 1;
    public int g = 1;
    public int h = -1;
    public int i = -1;
    public int j = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform float stepsizeX;\nuniform float stepsizeY;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 nbr_color = vec3(0.0, 0.0, 0.0);\n  vec2 coord;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  coord.x = vTextureCoord.x - 0.5 * stepsizeX;\n  coord.y = vTextureCoord.y - stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x - stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y - 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  gl_FragColor = vec4(color.rgb - 2.0 * scale * nbr_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return getSharpness();
    }

    public float getSharpness() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, "scale");
        this.h = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(i, "stepsizeX");
        this.i = glGetUniformLocation2;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation2, "stepsizeX");
        int glGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(i, "stepsizeY");
        this.j = glGetUniformLocation3;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation3, "stepsizeY");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.h = -1;
        this.i = -1;
        this.j = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        android.opengl.GLES20.glUniform1f(this.h, this.e);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
        android.opengl.GLES20.glUniform1f(this.i, 1.0f / this.f);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
        android.opengl.GLES20.glUniform1f(this.j, 1.0f / this.g);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f) {
        setSharpness(f);
    }

    public void setSharpness(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.e = f;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i, int i2) {
        super.setSize(i, i2);
        this.f = i;
        this.g = i2;
    }
}
