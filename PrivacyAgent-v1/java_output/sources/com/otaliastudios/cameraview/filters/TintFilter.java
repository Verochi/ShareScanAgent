package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class TintFilter extends com.otaliastudios.cameraview.filter.BaseFilter implements com.otaliastudios.cameraview.filter.OneParameterFilter {
    public int e = androidx.core.internal.view.SupportMenu.CATEGORY_MASK;
    public int f = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform vec3 tint;\nvec3 color_ratio;\nvarying vec2 vTextureCoord;\nvoid main() {\n  color_ratio[0] = 0.21;\n  color_ratio[1] = 0.71;\n  color_ratio[2] = 0.07;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float avg_color = dot(color_ratio, color.rgb);\n  vec3 new_color = min(0.8 * avg_color + 0.2 * tint, 1.0);\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        int tint = getTint();
        return android.graphics.Color.argb(0, android.graphics.Color.red(tint), android.graphics.Color.green(tint), android.graphics.Color.blue(tint)) / 1.6777215E7f;
    }

    @androidx.annotation.ColorInt
    public int getTint() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, "tint");
        this.f = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "tint");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.f = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        android.opengl.GLES20.glUniform3fv(this.f, 1, new float[]{android.graphics.Color.red(this.e) / 255.0f, android.graphics.Color.green(this.e) / 255.0f, android.graphics.Color.blue(this.e) / 255.0f}, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform3fv");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f) {
        setTint((int) (f * 1.6777215E7f));
    }

    public void setTint(@androidx.annotation.ColorInt int i) {
        this.e = android.graphics.Color.rgb(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i));
    }
}
