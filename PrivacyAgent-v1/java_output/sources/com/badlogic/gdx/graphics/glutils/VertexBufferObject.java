package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class VertexBufferObject implements com.badlogic.gdx.graphics.glutils.VertexData {
    public com.badlogic.gdx.graphics.VertexAttributes a;
    public java.nio.FloatBuffer b;
    public java.nio.ByteBuffer c;
    public boolean d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;

    public VertexBufferObject(int i, java.nio.ByteBuffer byteBuffer, boolean z, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        this.g = false;
        this.h = false;
        this.e = com.badlogic.gdx.Gdx.gl20.glGenBuffer();
        setBuffer(byteBuffer, z, vertexAttributes);
        setUsage(i);
    }

    public VertexBufferObject(boolean z, int i, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        this.g = false;
        this.h = false;
        this.e = com.badlogic.gdx.Gdx.gl20.glGenBuffer();
        java.nio.ByteBuffer newUnsafeByteBuffer = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(vertexAttributes.vertexSize * i);
        newUnsafeByteBuffer.limit(0);
        setBuffer(newUnsafeByteBuffer, true, vertexAttributes);
        setUsage(z ? com.badlogic.gdx.graphics.GL20.GL_STATIC_DRAW : com.badlogic.gdx.graphics.GL20.GL_DYNAMIC_DRAW);
    }

    public VertexBufferObject(boolean z, int i, com.badlogic.gdx.graphics.VertexAttribute... vertexAttributeArr) {
        this(z, i, new com.badlogic.gdx.graphics.VertexAttributes(vertexAttributeArr));
    }

    public final void a() {
        if (this.h) {
            com.badlogic.gdx.Gdx.gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.c.limit(), this.c, this.f);
            this.g = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.e);
        int i = 0;
        if (this.g) {
            this.c.limit(this.b.limit() * 4);
            gl20.glBufferData(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, this.c.limit(), this.c, this.f);
            this.g = false;
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
        this.h = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        gl20.glBindBuffer(com.badlogic.gdx.graphics.GL20.GL_ARRAY_BUFFER, 0);
        gl20.glDeleteBuffer(this.e);
        this.e = 0;
        if (this.d) {
            com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(this.c);
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

    public int getUsage() {
        return this.f;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void invalidate() {
        this.e = com.badlogic.gdx.Gdx.gl20.glGenBuffer();
        this.g = true;
    }

    public void setBuffer(java.nio.Buffer buffer, boolean z, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        java.nio.ByteBuffer byteBuffer;
        if (this.h) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot change attributes while VBO is bound");
        }
        if (this.d && (byteBuffer = this.c) != null) {
            com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
        }
        this.a = vertexAttributes;
        if (!(buffer instanceof java.nio.ByteBuffer)) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Only ByteBuffer is currently supported");
        }
        java.nio.ByteBuffer byteBuffer2 = (java.nio.ByteBuffer) buffer;
        this.c = byteBuffer2;
        this.d = z;
        int limit = byteBuffer2.limit();
        java.nio.ByteBuffer byteBuffer3 = this.c;
        byteBuffer3.limit(byteBuffer3.capacity());
        this.b = this.c.asFloatBuffer();
        this.c.limit(limit);
        this.b.limit(limit / 4);
    }

    public void setUsage(int i) {
        if (this.h) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot change usage while VBO is bound");
        }
        this.f = i;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void setVertices(float[] fArr, int i, int i2) {
        this.g = true;
        com.badlogic.gdx.utils.BufferUtils.copy(fArr, this.c, i2, i);
        this.b.position(0);
        this.b.limit(i2);
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
        a();
    }
}
