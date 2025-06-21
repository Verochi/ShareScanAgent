package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class IndexArray implements com.badlogic.gdx.graphics.glutils.IndexData {
    public final java.nio.ShortBuffer a;
    public final java.nio.ByteBuffer b;
    public final boolean c;

    public IndexArray(int i) {
        boolean z = i == 0;
        this.c = z;
        java.nio.ByteBuffer newUnsafeByteBuffer = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer((z ? 1 : i) * 2);
        this.b = newUnsafeByteBuffer;
        java.nio.ShortBuffer asShortBuffer = newUnsafeByteBuffer.asShortBuffer();
        this.a = asShortBuffer;
        asShortBuffer.flip();
        newUnsafeByteBuffer.flip();
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void bind() {
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(this.b);
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public java.nio.ShortBuffer getBuffer() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public int getNumIndices() {
        if (this.c) {
            return 0;
        }
        return this.a.limit();
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public int getNumMaxIndices() {
        if (this.c) {
            return 0;
        }
        return this.a.capacity();
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void invalidate() {
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void setIndices(java.nio.ShortBuffer shortBuffer) {
        int position = shortBuffer.position();
        this.a.clear();
        this.a.limit(shortBuffer.remaining());
        this.a.put(shortBuffer);
        this.a.flip();
        shortBuffer.position(position);
        this.b.position(0);
        this.b.limit(this.a.limit() << 1);
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void setIndices(short[] sArr, int i, int i2) {
        this.a.clear();
        this.a.put(sArr, i, i2);
        this.a.flip();
        this.b.position(0);
        this.b.limit(i2 << 1);
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void unbind() {
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void updateIndices(int i, short[] sArr, int i2, int i3) {
        int position = this.b.position();
        this.b.position(i * 2);
        com.badlogic.gdx.utils.BufferUtils.copy(sArr, i2, (java.nio.Buffer) this.b, i3);
        this.b.position(position);
    }
}
