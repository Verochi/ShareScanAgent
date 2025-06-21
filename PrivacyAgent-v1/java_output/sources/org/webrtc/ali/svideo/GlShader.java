package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class GlShader {
    private static final java.lang.String TAG = "GlShader";
    private int program;

    public GlShader(java.lang.String str, java.lang.String str2) {
        int compileShader = compileShader(com.badlogic.gdx.graphics.GL20.GL_VERTEX_SHADER, str);
        int compileShader2 = compileShader(com.badlogic.gdx.graphics.GL20.GL_FRAGMENT_SHADER, str2);
        int glCreateProgram = android.opengl.GLES20.glCreateProgram();
        this.program = glCreateProgram;
        if (glCreateProgram == 0) {
            throw new java.lang.RuntimeException("glCreateProgram() failed. GLES20 error: " + android.opengl.GLES20.glGetError());
        }
        android.opengl.GLES20.glAttachShader(glCreateProgram, compileShader);
        android.opengl.GLES20.glAttachShader(this.program, compileShader2);
        android.opengl.GLES20.glLinkProgram(this.program);
        int[] iArr = {0};
        android.opengl.GLES20.glGetProgramiv(this.program, com.badlogic.gdx.graphics.GL20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] == 1) {
            android.opengl.GLES20.glDeleteShader(compileShader);
            android.opengl.GLES20.glDeleteShader(compileShader2);
            org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("Creating GlShader");
        } else {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "Could not link program: " + android.opengl.GLES20.glGetProgramInfoLog(this.program));
            throw new java.lang.RuntimeException(android.opengl.GLES20.glGetProgramInfoLog(this.program));
        }
    }

    private static int compileShader(int i, java.lang.String str) {
        int glCreateShader = android.opengl.GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            throw new java.lang.RuntimeException("glCreateShader() failed. GLES20 error: " + android.opengl.GLES20.glGetError());
        }
        android.opengl.GLES20.glShaderSource(glCreateShader, str);
        android.opengl.GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        android.opengl.GLES20.glGetShaderiv(glCreateShader, com.badlogic.gdx.graphics.GL20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 1) {
            org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("compileShader");
            return glCreateShader;
        }
        org.webrtc.svideo.utils.AlivcLog.b(TAG, "Could not compile shader " + i + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + android.opengl.GLES20.glGetShaderInfoLog(glCreateShader));
        throw new java.lang.RuntimeException(android.opengl.GLES20.glGetShaderInfoLog(glCreateShader));
    }

    public int getAttribLocation(java.lang.String str) {
        int i = this.program;
        if (i == -1) {
            throw new java.lang.RuntimeException("The program has been released");
        }
        int glGetAttribLocation = android.opengl.GLES20.glGetAttribLocation(i, str);
        if (glGetAttribLocation >= 0) {
            return glGetAttribLocation;
        }
        throw new java.lang.RuntimeException("Could not locate '" + str + "' in program");
    }

    public int getUniformLocation(java.lang.String str) {
        int i = this.program;
        if (i == -1) {
            throw new java.lang.RuntimeException("The program has been released");
        }
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i, str);
        if (glGetUniformLocation >= 0) {
            return glGetUniformLocation;
        }
        throw new java.lang.RuntimeException("Could not locate uniform '" + str + "' in program");
    }

    public void release() {
        org.webrtc.svideo.utils.AlivcLog.a(TAG, "Deleting shader.");
        int i = this.program;
        if (i != -1) {
            android.opengl.GLES20.glDeleteProgram(i);
            this.program = -1;
        }
    }

    public void setVertexAttribArray(java.lang.String str, int i, java.nio.FloatBuffer floatBuffer) {
        if (this.program == -1) {
            throw new java.lang.RuntimeException("The program has been released");
        }
        int attribLocation = getAttribLocation(str);
        android.opengl.GLES20.glEnableVertexAttribArray(attribLocation);
        android.opengl.GLES20.glVertexAttribPointer(attribLocation, i, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, (java.nio.Buffer) floatBuffer);
        org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("setVertexAttribArray");
    }

    public void useProgram() {
        int i = this.program;
        if (i == -1) {
            throw new java.lang.RuntimeException("The program has been released");
        }
        android.opengl.GLES20.glUseProgram(i);
        org.webrtc.ali.svideo.GlUtil.checkNoGLES2Error("glUseProgram");
    }
}
