package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class VertexBufferObjectSubData implements com.badlogic.gdx.graphics.glutils.VertexData {
    public final com.badlogic.gdx.graphics.VertexAttributes a;
    public final java.nio.FloatBuffer b;
    public final java.nio.ByteBuffer c;
    public int d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public boolean h = false;
    public boolean i = false;

    public VertexBufferObjectSubData(boolean z, int i, com.badlogic.gdx.graphics.VertexAttribute... vertexAttributeArr) {
        this.f = z;
        com.badlogic.gdx.graphics.VertexAttributes vertexAttributes = new com.badlogic.gdx.graphics.VertexAttributes(vertexAttributeArr);
        this.a = vertexAttributes;
        java.nio.ByteBuffer newByteBuffer = com.badlogic.gdx.utils.BufferUtils.newByteBuffer(vertexAttributes.vertexSize * i);
        this.c = newByteBuffer;
        this.e = true;
        this.g = z ? com.badlogic.gdx.graphics.GL20.GL_STATIC_DRAW : com.badlogic.gdx.graphics.GL20.GL_DYNAMIC_DRAW;
        java.nio.FloatBuffer asFloatBuffer = newByteBuffer.asFloatBuffer();
        this.b = asFloatBuffer;
        this.d = b();
        asFloatBuffer.flip();
        newByteBuffer.flip();
    }

    public final void a() {
        if (this.i) {
            com.badlogic.gdx.Gdx.gl20.glBufferSubData(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, 0, this.c.limit(), this.c);
            this.h = false;
        }
    }

    public final int b() {
        int glGenBuffer = com.badlogic.gdx.Gdx.gl20.glGenBuffer();
        com.badlogic.gdx.Gdx.gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, glGenBuffer);
        com.badlogic.gdx.Gdx.gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.c.capacity(), null, this.g);
        com.badlogic.gdx.Gdx.gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, 0);
        return glGenBuffer;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.d);
        int i = 0;
        if (this.h) {
            this.c.limit(this.b.limit() * 4);
            gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.c.limit(), this.c, this.g);
            this.h = false;
        }
        int size = this.a.size();
        if (iArr == null) {
            while (i < size) {
                com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = this.a.get(i);
                int attributeLocation = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                if (attributeLocation >= 0) {
                    shaderProgram.enableVertexAttribute(attributeLocation);
                    shaderProgram.setVertexAttribute(attributeLocation, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.a.vertexSize, vertexAttribute.offset);
                }
                i++;
            }
        } else {
            while (i < size) {
                com.badlogic.gdx.graphics.VertexAttribute vertexAttribute2 = this.a.get(i);
                int i2 = iArr[i];
                if (i2 >= 0) {
                    shaderProgram.enableVertexAttribute(i2);
                    shaderProgram.setVertexAttribute(i2, vertexAttribute2.numComponents, vertexAttribute2.type, vertexAttribute2.normalized, this.a.vertexSize, vertexAttribute2.offset);
                }
                i++;
            }
        }
        this.i = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, 0);
        gl20.glDeleteBuffer(this.d);
        this.d = 0;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public com.badlogic.gdx.graphics.VertexAttributes getAttributes() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public java.nio.FloatBuffer getBuffer() {
        this.h = true;
        return this.b;
    }

    public int getBufferHandle() {
        return this.d;
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
        this.d = b();
        this.h = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void setVertices(float[] fArr, int i, int i2) {
        this.h = true;
        if (this.e) {
            com.badlogic.gdx.utils.BufferUtils.copy(fArr, this.c, i2, i);
            this.b.position(0);
            this.b.limit(i2);
        } else {
            this.b.clear();
            this.b.put(fArr, i, i2);
            this.b.flip();
            this.c.position(0);
            this.c.limit(this.b.limit() << 2);
        }
        a();
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        unbind(shaderProgram, null);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        int size = this.a.size();
        if (iArr == null) {
            for (int i = 0; i < size; i++) {
                shaderProgram.disableVertexAttribute(this.a.get(i).alias);
            }
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    shaderProgram.disableVertexAttribute(i3);
                }
            }
        }
        gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, 0);
        this.i = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void updateVertices(int i, float[] fArr, int i2, int i3) {
        this.h = true;
        if (!this.e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Buffer must be allocated direct.");
        }
        int position = this.c.position();
        this.c.position(i * 4);
        com.badlogic.gdx.utils.BufferUtils.copy(fArr, i2, i3, (java.nio.Buffer) this.c);
        this.c.position(position);
        a();
    }
}
