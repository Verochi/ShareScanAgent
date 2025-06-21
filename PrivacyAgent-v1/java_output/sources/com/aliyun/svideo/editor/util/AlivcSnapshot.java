package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class AlivcSnapshot {
    public static final java.lang.String TAG = "AlivcSnapshot";
    private boolean isSnapshotting;

    /* renamed from: com.aliyun.svideo.editor.util.AlivcSnapshot$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.nio.ByteBuffer val$buf;
        final /* synthetic */ int val$height;
        final /* synthetic */ java.io.File val$outPutFile;
        final /* synthetic */ int val$width;

        public AnonymousClass1(int i, int i2, java.nio.ByteBuffer byteBuffer, java.io.File file) {
            this.val$width = i;
            this.val$height = i2;
            this.val$buf = byteBuffer;
            this.val$outPutFile = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(this.val$width, this.val$height, android.graphics.Bitmap.Config.ARGB_8888);
            createBitmap.setHasAlpha(true);
            createBitmap.copyPixelsFromBuffer(this.val$buf);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setScale(1.0f, -1.0f);
            android.graphics.Bitmap createBitmap2 = android.graphics.Bitmap.createBitmap(createBitmap, 0, 0, this.val$width, this.val$height, matrix, true);
            try {
                com.aliyun.svideo.editor.util.AlivcSnapshot.this.saveBitmapToFile(createBitmap2, this.val$outPutFile);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            createBitmap.recycle();
            createBitmap2.recycle();
            com.aliyun.svideo.editor.util.AlivcSnapshot.this.isSnapshotting = false;
        }
    }

    private static void checkGlError(java.lang.String str) {
        int glGetError = android.opengl.GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new java.lang.RuntimeException(str + ": glError 0x" + java.lang.Integer.toHexString(glGetError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveBitmapToFile(android.graphics.Bitmap bitmap, java.io.File file) throws java.io.IOException {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.lang.String file2 = file.toString();
        if (!file.exists()) {
            file.createNewFile();
        }
        java.io.OutputStream outputStream = null;
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file2));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.FileNotFoundException e) {
            e = e;
        }
        try {
            android.graphics.Bitmap.CompressFormat compressFormat = android.graphics.Bitmap.CompressFormat.JPEG;
            bitmap.compress(compressFormat, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            outputStream = compressFormat;
        } catch (java.io.FileNotFoundException e2) {
            e = e2;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            outputStream = bufferedOutputStream2;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
                outputStream = bufferedOutputStream2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            outputStream = bufferedOutputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    private void saveFrame(java.io.File file, int i, int i2) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i * i2 * 4);
        allocateDirect.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        android.opengl.GLES20.glReadPixels(0, 0, i, i2, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, allocateDirect);
        checkGlError("glReadPixels");
        allocateDirect.rewind();
        com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.util.AlivcSnapshot.AnonymousClass1(i, i2, allocateDirect, file));
    }

    public boolean isSnapshotting() {
        return this.isSnapshotting;
    }

    public void useTextureIDGetFrame(int i, int i2, int i3, java.io.File file) {
        this.isSnapshotting = true;
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetIntegerv(36006, iArr, 0);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("current fbo ");
        sb.append(iArr[0]);
        int[] iArr2 = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr2, 0);
        android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, iArr2[0]);
        android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, com.badlogic.gdx.graphics.GL20.GL_LINEAR);
        android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 10240, com.badlogic.gdx.graphics.GL20.GL_LINEAR);
        android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, com.badlogic.gdx.graphics.GL20.GL_CLAMP_TO_EDGE);
        android.opengl.GLES20.glTexParameteri(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, com.badlogic.gdx.graphics.GL20.GL_CLAMP_TO_EDGE);
        android.opengl.GLES20.glTexImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, com.badlogic.gdx.graphics.GL20.GL_RGBA, i2, i3, 0, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, null);
        int[] iArr3 = new int[1];
        android.opengl.GLES20.glGenFramebuffers(1, iArr3, 0);
        android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, iArr3[0]);
        android.opengl.GLES20.glFramebufferTexture2D(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_COLOR_ATTACHMENT0, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, iArr2[0], 0);
        new com.aliyun.svideo.editor.util.BasicRenderer().draw(i);
        saveFrame(file, i2, i3);
        android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, iArr[0]);
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr3, 0);
        android.opengl.GLES20.glDeleteTextures(1, iArr2, 0);
    }
}
