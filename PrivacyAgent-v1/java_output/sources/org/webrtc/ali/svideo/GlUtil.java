package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class GlUtil {
    private static final java.lang.String TAG = "GlUtil";

    private GlUtil() {
    }

    public static void checkNoGLES2Error(java.lang.String str) {
        int glGetError = android.opengl.GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new java.lang.RuntimeException(str + ": GLES20 error: " + glGetError);
    }

    public static java.nio.FloatBuffer createFloatBuffer(float[] fArr) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static java.nio.ByteBuffer dumpTextureToRGBA(int i, int i2, int i3) {
        java.nio.IntBuffer allocate = java.nio.IntBuffer.allocate(1);
        android.opengl.GLES20.glGetIntegerv(36006, allocate);
        int[] iArr = new int[2];
        android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
        android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, iArr[0]);
        android.opengl.GLES20.glFramebufferTexture2D(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_COLOR_ATTACHMENT0, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, i, 0);
        int glCheckFramebufferStatus = android.opengl.GLES20.glCheckFramebufferStatus(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER);
        if (glCheckFramebufferStatus != 36053) {
            org.webrtc.svideo.utils.AlivcLog.b(TAG, "glCheckFramebufferStatus, status = " + glCheckFramebufferStatus);
            return null;
        }
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i2 * i3 * 4);
        android.opengl.GLES20.glViewport(0, 0, i2, i3);
        if (allocateDirect != null) {
            android.opengl.GLES20.glReadPixels(0, 0, i2, i3, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, allocateDirect);
            allocateDirect.rewind();
        }
        android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, allocate.get());
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr, 0);
        return allocateDirect;
    }

    public static int generateTexture(int i) {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        android.opengl.GLES20.glBindTexture(i, i2);
        android.opengl.GLES20.glTexParameterf(i, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, 9729.0f);
        android.opengl.GLES20.glTexParameterf(i, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameterf(i, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, 33071.0f);
        android.opengl.GLES20.glTexParameterf(i, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return i2;
    }
}
