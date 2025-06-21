package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class GlUtil {

    public static final class Attribute {
        public final int a;
        public final int b;

        @androidx.annotation.Nullable
        public java.nio.Buffer c;
        public int d;
        public final java.lang.String name;

        public Attribute(int i, int i2) {
            int[] iArr = new int[1];
            android.opengl.GLES20.glGetProgramiv(i, com.badlogic.gdx.graphics.GL20.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH, iArr, 0);
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            int[] iArr2 = new int[1];
            android.opengl.GLES20.glGetActiveAttrib(i, i2, i3, iArr2, 0, new int[1], 0, new int[1], 0, bArr, 0);
            java.lang.String str = new java.lang.String(bArr, 0, com.google.android.exoplayer2.util.GlUtil.c(bArr));
            this.name = str;
            this.b = android.opengl.GLES20.glGetAttribLocation(i, str);
            this.a = i2;
        }

        public void bind() {
            java.nio.Buffer buffer = (java.nio.Buffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c, "call setBuffer before bind");
            android.opengl.GLES20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, 0);
            android.opengl.GLES20.glVertexAttribPointer(this.b, this.d, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, buffer);
            android.opengl.GLES20.glEnableVertexAttribArray(this.a);
            com.google.android.exoplayer2.util.GlUtil.checkGlError();
        }

        public void setBuffer(float[] fArr, int i) {
            this.c = com.google.android.exoplayer2.util.GlUtil.createBuffer(fArr);
            this.d = i;
        }
    }

    public static final class Uniform {
        public final int a;
        public final int b;
        public final float[] c;
        public int d;
        public int e;
        public final java.lang.String name;

        public Uniform(int i, int i2) {
            int[] iArr = new int[1];
            android.opengl.GLES20.glGetProgramiv(i, com.badlogic.gdx.graphics.GL20.GL_ACTIVE_UNIFORM_MAX_LENGTH, iArr, 0);
            int[] iArr2 = new int[1];
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            android.opengl.GLES20.glGetActiveUniform(i, i2, i3, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            java.lang.String str = new java.lang.String(bArr, 0, com.google.android.exoplayer2.util.GlUtil.c(bArr));
            this.name = str;
            this.a = android.opengl.GLES20.glGetUniformLocation(i, str);
            this.b = iArr2[0];
            this.c = new float[1];
        }

        public void bind() {
            if (this.b == 5126) {
                android.opengl.GLES20.glUniform1fv(this.a, 1, this.c, 0);
                com.google.android.exoplayer2.util.GlUtil.checkGlError();
                return;
            }
            if (this.d == 0) {
                throw new java.lang.IllegalStateException("call setSamplerTexId before bind");
            }
            android.opengl.GLES20.glActiveTexture(this.e + com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
            int i = this.b;
            if (i == 36198) {
                android.opengl.GLES20.glBindTexture(36197, this.d);
            } else {
                if (i != 35678) {
                    int i2 = this.b;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(36);
                    sb.append("unexpected uniform type: ");
                    sb.append(i2);
                    throw new java.lang.IllegalStateException(sb.toString());
                }
                android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.d);
            }
            android.opengl.GLES20.glUniform1i(this.a, this.e);
            android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 10240, com.badlogic.gdx.graphics.GL20.GL_LINEAR);
            android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, com.badlogic.gdx.graphics.GL20.GL_LINEAR);
            android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, com.badlogic.gdx.graphics.GL20.GL_CLAMP_TO_EDGE);
            android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, com.badlogic.gdx.graphics.GL20.GL_CLAMP_TO_EDGE);
            com.google.android.exoplayer2.util.GlUtil.checkGlError();
        }

        public void setFloat(float f) {
            this.c[0] = f;
        }

        public void setSamplerTexId(int i, int i2) {
            this.d = i;
            this.e = i2;
        }
    }

    public static void b(int i, java.lang.String str, int i2) {
        int glCreateShader = android.opengl.GLES20.glCreateShader(i);
        android.opengl.GLES20.glShaderSource(glCreateShader, str);
        android.opengl.GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        android.opengl.GLES20.glGetShaderiv(glCreateShader, com.badlogic.gdx.graphics.GL20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] != 1) {
            java.lang.String glGetShaderInfoLog = android.opengl.GLES20.glGetShaderInfoLog(glCreateShader);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(glGetShaderInfoLog).length() + 10 + java.lang.String.valueOf(str).length());
            sb.append(glGetShaderInfoLog);
            sb.append(", source: ");
            sb.append(str);
            d(sb.toString());
        }
        android.opengl.GLES20.glAttachShader(i2, glCreateShader);
        android.opengl.GLES20.glDeleteShader(glCreateShader);
        checkGlError();
    }

    public static int c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return bArr.length;
    }

    public static void checkGlError() {
        while (true) {
            int glGetError = android.opengl.GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            java.lang.String valueOf = java.lang.String.valueOf(android.opengl.GLU.gluErrorString(glGetError));
            com.google.android.exoplayer2.util.Log.e("GlUtil", valueOf.length() != 0 ? "glError ".concat(valueOf) : new java.lang.String("glError "));
        }
    }

    public static int compileProgram(java.lang.String str, java.lang.String str2) {
        int glCreateProgram = android.opengl.GLES20.glCreateProgram();
        checkGlError();
        b(com.badlogic.gdx.graphics.GL20.GL_VERTEX_SHADER, str, glCreateProgram);
        b(com.badlogic.gdx.graphics.GL20.GL_FRAGMENT_SHADER, str2, glCreateProgram);
        android.opengl.GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        android.opengl.GLES20.glGetProgramiv(glCreateProgram, com.badlogic.gdx.graphics.GL20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] != 1) {
            java.lang.String valueOf = java.lang.String.valueOf(android.opengl.GLES20.glGetProgramInfoLog(glCreateProgram));
            d(valueOf.length() != 0 ? "Unable to link shader program: \n".concat(valueOf) : new java.lang.String("Unable to link shader program: \n"));
        }
        checkGlError();
        return glCreateProgram;
    }

    public static int compileProgram(java.lang.String[] strArr, java.lang.String[] strArr2) {
        return compileProgram(android.text.TextUtils.join("\n", strArr), android.text.TextUtils.join("\n", strArr2));
    }

    public static java.nio.FloatBuffer createBuffer(int i) {
        return java.nio.ByteBuffer.allocateDirect(i * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static java.nio.FloatBuffer createBuffer(float[] fArr) {
        return (java.nio.FloatBuffer) createBuffer(fArr.length).put(fArr).flip();
    }

    public static int createExternalTexture() {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, java.nio.IntBuffer.wrap(iArr));
        android.opengl.GLES20.glBindTexture(36197, iArr[0]);
        android.opengl.GLES20.glTexParameteri(36197, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, com.badlogic.gdx.graphics.GL20.GL_LINEAR);
        android.opengl.GLES20.glTexParameteri(36197, 10240, com.badlogic.gdx.graphics.GL20.GL_LINEAR);
        android.opengl.GLES20.glTexParameteri(36197, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, com.badlogic.gdx.graphics.GL20.GL_CLAMP_TO_EDGE);
        android.opengl.GLES20.glTexParameteri(36197, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, com.badlogic.gdx.graphics.GL20.GL_CLAMP_TO_EDGE);
        checkGlError();
        return iArr[0];
    }

    public static void d(java.lang.String str) {
        com.google.android.exoplayer2.util.Log.e("GlUtil", str);
    }

    public static com.google.android.exoplayer2.util.GlUtil.Attribute[] getAttributes(int i) {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetProgramiv(i, com.badlogic.gdx.graphics.GL20.GL_ACTIVE_ATTRIBUTES, iArr, 0);
        int i2 = iArr[0];
        if (i2 != 2) {
            throw new java.lang.IllegalStateException("expected two attributes");
        }
        com.google.android.exoplayer2.util.GlUtil.Attribute[] attributeArr = new com.google.android.exoplayer2.util.GlUtil.Attribute[i2];
        for (int i3 = 0; i3 < iArr[0]; i3++) {
            attributeArr[i3] = new com.google.android.exoplayer2.util.GlUtil.Attribute(i, i3);
        }
        return attributeArr;
    }

    public static com.google.android.exoplayer2.util.GlUtil.Uniform[] getUniforms(int i) {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetProgramiv(i, com.badlogic.gdx.graphics.GL20.GL_ACTIVE_UNIFORMS, iArr, 0);
        com.google.android.exoplayer2.util.GlUtil.Uniform[] uniformArr = new com.google.android.exoplayer2.util.GlUtil.Uniform[iArr[0]];
        for (int i2 = 0; i2 < iArr[0]; i2++) {
            uniformArr[i2] = new com.google.android.exoplayer2.util.GlUtil.Uniform(i, i2);
        }
        return uniformArr;
    }

    public static boolean isProtectedContentExtensionSupported(android.content.Context context) {
        java.lang.String eglQueryString;
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i < 24) {
            return false;
        }
        if (i >= 26 || !("samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) || "XT1650".equals(com.google.android.exoplayer2.util.Util.MODEL))) {
            return (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = android.opengl.EGL14.eglQueryString(android.opengl.EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        java.lang.String eglQueryString;
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 17 && (eglQueryString = android.opengl.EGL14.eglQueryString(android.opengl.EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_KHR_surfaceless_context");
    }
}
