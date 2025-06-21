package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class VertexBufferObjectWithVAO implements com.badlogic.gdx.graphics.glutils.VertexData {
    public static final java.nio.IntBuffer k = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(1);
    public final com.badlogic.gdx.graphics.VertexAttributes a;
    public final java.nio.FloatBuffer b;
    public final java.nio.ByteBuffer c;
    public int d;
    public final boolean e;
    public final int f;
    public boolean g;
    public boolean h;
    public int i;
    public com.badlogic.gdx.utils.IntArray j;

    public VertexBufferObjectWithVAO(boolean z, int i, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        this.g = false;
        this.h = false;
        this.i = -1;
        this.j = new com.badlogic.gdx.utils.IntArray();
        this.e = z;
        this.a = vertexAttributes;
        java.nio.ByteBuffer newUnsafeByteBuffer = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(vertexAttributes.vertexSize * i);
        this.c = newUnsafeByteBuffer;
        java.nio.FloatBuffer asFloatBuffer = newUnsafeByteBuffer.asFloatBuffer();
        this.b = asFloatBuffer;
        asFloatBuffer.flip();
        newUnsafeByteBuffer.flip();
        this.d = com.badlogic.gdx.Gdx.gl20.glGenBuffer();
        this.f = z ? com.badlogic.gdx.graphics.GL20.GL_STATIC_DRAW : com.badlogic.gdx.graphics.GL20.GL_DYNAMIC_DRAW;
        d();
    }

    public VertexBufferObjectWithVAO(boolean z, int i, com.badlogic.gdx.graphics.VertexAttribute... vertexAttributeArr) {
        this(z, i, new com.badlogic.gdx.graphics.VertexAttributes(vertexAttributeArr));
    }

    public final void a(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        boolean z = this.j.size != 0;
        int size = this.a.size();
        if (z) {
            if (iArr == null) {
                for (int i = 0; z && i < size; i++) {
                    z = shaderProgram.getAttributeLocation(this.a.get(i).alias) == this.j.get(i);
                }
            } else {
                z = iArr.length == this.j.size;
                for (int i2 = 0; z && i2 < size; i2++) {
                    z = iArr[i2] == this.j.get(i2);
                }
            }
        }
        if (z) {
            return;
        }
        com.badlogic.gdx.Gdx.gl.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.d);
        f(shaderProgram);
        this.j.clear();
        for (int i3 = 0; i3 < size; i3++) {
            com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = this.a.get(i3);
            if (iArr == null) {
                this.j.add(shaderProgram.getAttributeLocation(vertexAttribute.alias));
            } else {
                this.j.add(iArr[i3]);
            }
            int i4 = this.j.get(i3);
            if (i4 >= 0) {
                shaderProgram.enableVertexAttribute(i4);
                shaderProgram.setVertexAttribute(i4, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.a.vertexSize, vertexAttribute.offset);
            }
        }
    }

    public final void b(com.badlogic.gdx.graphics.GL20 gl20) {
        if (this.g) {
            gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.d);
            this.c.limit(this.b.limit() * 4);
            gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.c.limit(), this.c, this.f);
            this.g = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        com.badlogic.gdx.graphics.GL30 gl30 = com.badlogic.gdx.Gdx.gl30;
        gl30.glBindVertexArray(this.i);
        a(shaderProgram, iArr);
        b(gl30);
        this.h = true;
    }

    public final void c() {
        if (this.h) {
            com.badlogic.gdx.Gdx.gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.c.limit(), this.c, this.f);
            this.g = false;
        }
    }

    public final void d() {
        java.nio.IntBuffer intBuffer = k;
        intBuffer.clear();
        com.badlogic.gdx.Gdx.gl30.glGenVertexArrays(1, intBuffer);
        this.i = intBuffer.get();
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.GL30 gl30 = com.badlogic.gdx.Gdx.gl30;
        gl30.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, 0);
        gl30.glDeleteBuffer(this.d);
        this.d = 0;
        com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(this.c);
        e();
    }

    public final void e() {
        if (this.i != -1) {
            java.nio.IntBuffer intBuffer = k;
            intBuffer.clear();
            intBuffer.put(this.i);
            intBuffer.flip();
            com.badlogic.gdx.Gdx.gl30.glDeleteVertexArrays(1, intBuffer);
            this.i = -1;
        }
    }

    public final void f(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        if (this.j.size == 0) {
            return;
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            int i2 = this.j.get(i);
            if (i2 >= 0) {
                shaderProgram.disableVertexAttribute(i2);
            }
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public com.badlogic.gdx.graphics.VertexAttributes getAttributes() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public java.nio.FloatBuffer getBuffer() {
        this.g = true;
        return this.b;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public int getNumMaxVertices() {
        return this.c.capacity() / this.a.vertexSize;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public int getNumVertices() {
        return (this.b.limit() * 4) / this.a.vertexSize;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void invalidate() {
        this.d = com.badlogic.gdx.Gdx.gl30.glGenBuffer();
        d();
        this.g = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void setVertices(float[] fArr, int i, int i2) {
        this.g = true;
        com.badlogic.gdx.utils.BufferUtils.copy(fArr, this.c, i2, i);
        this.b.position(0);
        this.b.limit(i2);
        c();
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        unbind(shaderProgram, null);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        com.badlogic.gdx.Gdx.gl30.glBindVertexArray(0);
        this.h = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void updateVertices(int i, float[] fArr, int i2, int i3) {
        this.g = true;
        int position = this.c.position();
        this.c.position(i * 4);
        com.badlogic.gdx.utils.BufferUtils.copy(fArr, i2, i3, (java.nio.Buffer) this.c);
        this.c.position(position);
        this.b.position(0);
        c();
    }
}
