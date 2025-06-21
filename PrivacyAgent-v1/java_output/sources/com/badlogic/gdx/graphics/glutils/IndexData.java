package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public interface IndexData extends com.badlogic.gdx.utils.Disposable {
    void bind();

    @Override // com.badlogic.gdx.utils.Disposable
    void dispose();

    java.nio.ShortBuffer getBuffer();

    int getNumIndices();

    int getNumMaxIndices();

    void invalidate();

    void setIndices(java.nio.ShortBuffer shortBuffer);

    void setIndices(short[] sArr, int i, int i2);

    void unbind();

    void updateIndices(int i, short[] sArr, int i2, int i3);
}
