package jp.co.cyberagent.android.gpuimage.util;

/* loaded from: classes14.dex */
public class OpenGlUtils {
    public static final int NO_TEXTURE = -1;

    public static int loadProgram(java.lang.String str, java.lang.String str2) {
        int loadShader;
        int[] iArr = new int[1];
        int loadShader2 = loadShader(str, com.badlogic.gdx.graphics.GL20.GL_VERTEX_SHADER);
        if (loadShader2 == 0 || (loadShader = loadShader(str2, com.badlogic.gdx.graphics.GL20.GL_FRAGMENT_SHADER)) == 0) {
            return 0;
        }
        int glCreateProgram = android.opengl.GLES20.glCreateProgram();
        android.opengl.GLES20.glAttachShader(glCreateProgram, loadShader2);
        android.opengl.GLES20.glAttachShader(glCreateProgram, loadShader);
        android.opengl.GLES20.glLinkProgram(glCreateProgram);
        android.opengl.GLES20.glGetProgramiv(glCreateProgram, com.badlogic.gdx.graphics.GL20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] <= 0) {
            return 0;
        }
        android.opengl.GLES20.glDeleteShader(loadShader2);
        android.opengl.GLES20.glDeleteShader(loadShader);
        return glCreateProgram;
    }

    public static int loadShader(java.lang.String str, int i) {
        int[] iArr = new int[1];
        int glCreateShader = android.opengl.GLES20.glCreateShader(i);
        android.opengl.GLES20.glShaderSource(glCreateShader, str);
        android.opengl.GLES20.glCompileShader(glCreateShader);
        android.opengl.GLES20.glGetShaderiv(glCreateShader, com.badlogic.gdx.graphics.GL20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Compilation\n");
        sb.append(android.opengl.GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }

    public static int loadTexture(android.graphics.Bitmap bitmap, int i) {
        return loadTexture(bitmap, i, true);
    }

    public static int loadTexture(android.graphics.Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, iArr[0]);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, 33071.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, 33071.0f);
            android.opengl.GLUtils.texImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, bitmap, 0);
        } else {
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, i);
            android.opengl.GLUtils.texSubImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static int loadTexture(java.nio.IntBuffer intBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, iArr[0]);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, 33071.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, 33071.0f);
            android.opengl.GLES20.glTexImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, com.badlogic.gdx.graphics.GL20.GL_RGBA, i, i2, 0, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, intBuffer);
        } else {
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, i3);
            android.opengl.GLES20.glTexSubImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, 0, 0, i, i2, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, intBuffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }

    public static int loadTextureAsBitmap(java.nio.IntBuffer intBuffer, android.hardware.Camera.Size size, int i) {
        return loadTexture(android.graphics.Bitmap.createBitmap(intBuffer.array(), size.width, size.height, android.graphics.Bitmap.Config.ARGB_8888), i);
    }

    public static float rnd(float f, float f2) {
        return f + ((f2 - f) * ((float) java.lang.Math.random()));
    }
}
