package com.otaliastudios.cameraview.filters;

/* loaded from: classes19.dex */
public class LomoishFilter extends com.otaliastudios.cameraview.filter.BaseFilter {
    public static final java.util.Random k;
    public static final java.lang.String l;
    public int e = 1;
    public int f = 1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;

    static {
        java.util.Random random = new java.util.Random();
        k = random;
        l = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float stepsizeX;\nuniform float stepsizeY;\nuniform vec2 scale;\nuniform float inv_max_dist;\nvec2 seed;\nfloat stepsize;\nvarying vec2 vTextureCoord;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  return fract(part1 + part2 + part3);\n}\nvoid main() {\n  seed[0] = " + random.nextFloat() + ";\n  seed[1] = " + random.nextFloat() + ";\n  stepsize = 0.003921569;\n  vec3 nbr_color = vec3(0.0, 0.0, 0.0);\n  vec2 coord;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  coord.x = vTextureCoord.x - 0.5 * stepsizeX;\n  coord.y = vTextureCoord.y - stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x - stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y - 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  vec3 s_color = vec3(color.rgb + 0.3 * nbr_color);\n  vec3 c_color = vec3(0.0, 0.0, 0.0);\n  float value;\n  if (s_color.r < 0.5) {\n    value = s_color.r;\n  } else {\n    value = 1.0 - s_color.r;\n  }\n  float red = 4.0 * value * value * value;\n  if (s_color.r < 0.5) {\n    c_color.r = red;\n  } else {\n    c_color.r = 1.0 - red;\n  }\n  if (s_color.g < 0.5) {\n    value = s_color.g;\n  } else {\n    value = 1.0 - s_color.g;\n  }\n  float green = 2.0 * value * value;\n  if (s_color.g < 0.5) {\n    c_color.g = green;\n  } else {\n    c_color.g = 1.0 - green;\n  }\n  c_color.b = s_color.b * 0.5 + 0.25;\n  float dither = rand(vTextureCoord + seed);\n  vec3 xform = clamp((c_color.rgb - 0.15) * 1.53846, 0.0, 1.0);\n  vec3 temp = clamp((color.rgb + stepsize - 0.15) * 1.53846, 0.0, 1.0);\n  vec3 bw_color = clamp(xform + (temp - xform) * (dither - 0.5), 0.0, 1.0);\n  coord = vTextureCoord - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = 0.85 / (1.0 + exp((dist * inv_max_dist - 0.73) * 20.0)) + 0.15;\n  gl_FragColor = vec4(bw_color * lumen, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return l;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, "scale");
        this.g = glGetUniformLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(i, "inv_max_dist");
        this.h = glGetUniformLocation2;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation2, "inv_max_dist");
        int glGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(i, "stepsizeX");
        this.i = glGetUniformLocation3;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation3, "stepsizeX");
        int glGetUniformLocation4 = android.opengl.GLES20.glGetUniformLocation(i, "stepsizeY");
        this.j = glGetUniformLocation4;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetUniformLocation4, "stepsizeY");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @androidx.annotation.NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        float[] fArr2 = new float[2];
        int i = this.e;
        int i2 = this.f;
        if (i > i2) {
            fArr2[0] = 1.0f;
            fArr2[1] = i2 / i;
        } else {
            fArr2[0] = i / i2;
            fArr2[1] = 1.0f;
        }
        float f = fArr2[0];
        float f2 = fArr2[1];
        float sqrt = ((float) java.lang.Math.sqrt((f * f) + (f2 * f2))) * 0.5f;
        android.opengl.GLES20.glUniform2fv(this.g, 1, fArr2, 0);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform2fv");
        android.opengl.GLES20.glUniform1f(this.h, 1.0f / sqrt);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
        android.opengl.GLES20.glUniform1f(this.i, 1.0f / this.e);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
        android.opengl.GLES20.glUniform1f(this.j, 1.0f / this.f);
        com.otaliastudios.opengl.core.Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i, int i2) {
        super.setSize(i, i2);
        this.e = i;
        this.f = i2;
    }
}
