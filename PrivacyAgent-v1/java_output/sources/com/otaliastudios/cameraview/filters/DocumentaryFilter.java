package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class DocumentaryFilter extends com.otaliastudios.cameraview.filter.BaseFilter {
    public static final java.util.Random i;
    public static final java.lang.String j;
    public int e = 1;
    public int f = 1;
    public int g = -1;
    public int h = -1;

    static {
        java.util.Random random = new java.util.Random();
        i = random;
        j = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvec2 seed;\nfloat stepsize;\nuniform float inv_max_dist;\nuniform vec2 scale;\nvarying vec2 vTextureCoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  seed[0] = " + random.nextFloat() + ";\n  seed[1] = " + random.nextFloat() + ";\n  stepsize = 0.003921569;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float dither = rand(vTextureCoord + seed);\n  vec3 xform = clamp(2.0 * color.rgb, 0.0, 1.0);\n  vec3 temp = clamp(2.0 * (color.rgb + stepsize), 0.0, 1.0);\n  vec3 new_color = clamp(xform + (temp - xform) * (dither - 0.5), 0.0, 1.0);\n  float gray = dot(new_color, vec3(0.299, 0.587, 0.114));\n  new_color = vec3(gray, gray, gray);\n  vec2 coord = vTextureCoord - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = 0.85 / (1.0 + exp((dist * inv_max_dist - 0.83) * 20.0)) + 0.15;\n  gl_FragColor = vec4(new_color * lumen, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return j;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i2) {
        super.onCreate(i2);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i2, "scale");
        this.g = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(i2, "inv_max_dist");
        this.h = glGetUniformLocation2;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation2, "inv_max_dist");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.g = -1;
        this.h = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j2, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j2, fArr);
        float[] fArr2 = new float[2];
        int i2 = this.e;
        int i3 = this.f;
        if (i2 > i3) {
            fArr2[0] = 1.0f;
            fArr2[1] = i3 / i2;
        } else {
            fArr2[0] = i2 / i3;
            fArr2[1] = 1.0f;
        }
        android.opengl.GLES20.glUniform2fv(this.g, 1, fArr2, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform2fv");
        float f = fArr2[0];
        float f2 = fArr2[1];
        android.opengl.GLES20.glUniform1f(this.h, 1.0f / (((float) java.lang.Math.sqrt((f * f) + (f2 * f2))) * 0.5f));
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i2, int i3) {
        super.setSize(i2, i3);
        this.e = i2;
        this.f = i3;
    }
}
