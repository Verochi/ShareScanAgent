package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class IndexBufferObject implements com.badlogic.gdx.graphics.glutils.IndexData {
    public final java.nio.ShortBuffer a;
    public final java.nio.ByteBuffer b;
    public int c;
    public final boolean d;
    public boolean e;
    public boolean f;
    public final int g;
    public final boolean h;

    public IndexBufferObject(int i) {
        this(true, i);
    }

    public IndexBufferObject(boolean z, int i) {
        this.e = true;
        this.f = false;
        boolean z2 = i == 0;
        this.h = z2;
        java.nio.ByteBuffer newUnsafeByteBuffer = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer((z2 ? 1 : i) * 2);
        this.b = newUnsafeByteBuffer;
        this.d = true;
        java.nio.ShortBuffer asShortBuffer = newUnsafeByteBuffer.asShortBuffer();
        this.a = asShortBuffer;
        asShortBuffer.flip();
        newUnsafeByteBuffer.flip();
        this.c = com.badlogic.gdx.Gdx.gl20.glGenBuffer();
        this.g = z ? com.badlogic.gdx.graphics.GL20.GL_STATIC_DRAW : com.badlogic.gdx.graphics.GL20.GL_DYNAMIC_DRAW;
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void bind() {
        int i = this.c;
        if (i == 0) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No buffer allocated!");
        }
        com.badlogic.gdx.Gdx.gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ELEMENT_ARRAY_BUFFER, i);
        if (this.e) {
            this.b.limit(this.a.limit() * 2);
            com.badlogic.gdx.Gdx.gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ELEMENT_ARRAY_BUFFER, this.b.limit(), this.b, this.g);
            this.e = false;
        }
        this.f = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.Gdx.gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
        com.badlogic.gdx.Gdx.gl20.glDeleteBuffer(this.c);
        this.c = 0;
        com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(this.b);
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public java.nio.ShortBuffer getBuffer() {
        this.e = true;
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public int getNumIndices() {
        if (this.h) {
            return 0;
        }
        return this.a.limit();
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public int getNumMaxIndices() {
        if (this.h) {
            return 0;
        }
        return this.a.capacity();
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void invalidate() {
        this.c = com.badlogic.gdx.Gdx.gl20.glGenBuffer();
        this.e = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void setIndices(java.nio.ShortBuffer shortBuffer) {
        this.e = true;
        int position = shortBuffer.position();
        this.a.clear();
        this.a.put(shortBuffer);
        this.a.flip();
        shortBuffer.position(position);
        this.b.position(0);
        this.b.limit(this.a.limit() << 1);
        if (this.f) {
            com.badlogic.gdx.Gdx.gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ELEMENT_ARRAY_BUFFER, this.b.limit(), this.b, this.g);
            this.e = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void setIndices(short[] sArr, int i, int i2) {
        this.e = true;
        this.a.clear();
        this.a.put(sArr, i, i2);
        this.a.flip();
        this.b.position(0);
        this.b.limit(i2 << 1);
        if (this.f) {
            com.badlogic.gdx.Gdx.gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ELEMENT_ARRAY_BUFFER, this.b.limit(), this.b, this.g);
            this.e = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void unbind() {
        com.badlogic.gdx.Gdx.gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
        this.f = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.IndexData
    public void updateIndices(int i, short[] sArr, int i2, int i3) {
        this.e = true;
        int position = this.b.position();
        this.b.position(i * 2);
        com.badlogic.gdx.utils.BufferUtils.copy(sArr, i2, (java.nio.Buffer) this.b, i3);
        this.b.position(position);
        this.a.position(0);
        if (this.f) {
            com.badlogic.gdx.Gdx.gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ELEMENT_ARRAY_BUFFER, this.b.limit(), this.b, this.g);
            this.e = false;
        }
    }
}
