package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public interface TextureArrayData {

    public static class Factory {
        public static com.badlogic.gdx.graphics.TextureArrayData loadFromFiles(com.badlogic.gdx.graphics.Pixmap.Format format, boolean z, com.badlogic.gdx.files.FileHandle... fileHandleArr) {
            return new com.badlogic.gdx.graphics.glutils.FileTextureArrayData(format, z, fileHandleArr);
        }
    }

    void consumeTextureArrayData();

    int getDepth();

    int getGLType();

    int getHeight();

    int getInternalFormat();

    int getWidth();

    boolean isManaged();

    boolean isPrepared();

    void prepare();
}
