package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class DuotoneFilter extends com.otaliastudios.cameraview.filter.BaseFilter implements com.otaliastudios.cameraview.filter.TwoParameterFilter {
    public int e = -65281;
    public int f = androidx.core.view.InputDeviceCompat.SOURCE_ANY;
    public int g = -1;
    public int h = -1;

    @androidx.annotation.ColorInt
    public int getFirstColor() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform vec3 first;\nuniform vec3 second;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float energy = (color.r + color.g + color.b) * 0.3333;\n  vec3 new_color = (1.0 - energy) * first + energy * second;\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        int firstColor = getFirstColor();
        return android.graphics.Color.argb(0, android.graphics.Color.red(firstColor), android.graphics.Color.green(firstColor), android.graphics.Color.blue(firstColor)) / 1.6777215E7f;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public float getParameter2() {
        int secondColor = getSecondColor();
        return android.graphics.Color.argb(0, android.graphics.Color.red(secondColor), android.graphics.Color.green(secondColor), android.graphics.Color.blue(secondColor)) / 1.6777215E7f;
    }

    @androidx.annotation.ColorInt
    public int getSecondColor() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, "first");
        this.g = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "first");
        int glGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(i, org.apache.tools.ant.taskdefs.WaitFor.Unit.SECOND);
        this.h = glGetUniformLocation2;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation2, org.apache.tools.ant.taskdefs.WaitFor.Unit.SECOND);
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.g = -1;
        this.h = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        android.opengl.GLES20.glUniform3fv(this.g, 1, new float[]{android.graphics.Color.red(this.e) / 255.0f, android.graphics.Color.green(this.e) / 255.0f, android.graphics.Color.blue(this.e) / 255.0f}, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform3fv");
        android.opengl.GLES20.glUniform3fv(this.h, 1, new float[]{android.graphics.Color.red(this.f) / 255.0f, android.graphics.Color.green(this.f) / 255.0f, android.graphics.Color.blue(this.f) / 255.0f}, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform3fv");
    }

    public void setColors(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2) {
        setFirstColor(i);
        setSecondColor(i2);
    }

    public void setFirstColor(@androidx.annotation.ColorInt int i) {
        this.e = android.graphics.Color.rgb(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i));
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f) {
        setFirstColor((int) (f * 1.6777215E7f));
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public void setParameter2(float f) {
        setSecondColor((int) (f * 1.6777215E7f));
    }

    public void setSecondColor(@androidx.annotation.ColorInt int i) {
        this.f = android.graphics.Color.rgb(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i));
    }
}
