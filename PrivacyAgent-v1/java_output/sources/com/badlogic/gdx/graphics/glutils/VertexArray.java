package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class VertexArray implements com.badlogic.gdx.graphics.glutils.VertexData {
    public final com.badlogic.gdx.graphics.VertexAttributes a;
    public final java.nio.FloatBuffer b;
    public final java.nio.ByteBuffer c;
    public boolean d;

    public VertexArray(int i, com.badlogic.gdx.graphics.VertexAttributes vertexAttributes) {
        this.d = false;
        this.a = vertexAttributes;
        java.nio.ByteBuffer newUnsafeByteBuffer = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(vertexAttributes.vertexSize * i);
        this.c = newUnsafeByteBuffer;
        java.nio.FloatBuffer asFloatBuffer = newUnsafeByteBuffer.asFloatBuffer();
        this.b = asFloatBuffer;
        asFloatBuffer.flip();
        newUnsafeByteBuffer.flip();
    }

    public VertexArray(int i, com.badlogic.gdx.graphics.VertexAttribute... vertexAttributeArr) {
        this(i, new com.badlogic.gdx.graphics.VertexAttributes(vertexAttributeArr));
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void bind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
        int size = this.a.size();
        this.c.limit(this.b.limit() * 4);
        int i = 0;
        if (iArr == null) {
            while (i < size) {
                com.badlogic.gdx.graphics.VertexAttribute vertexAttribute = this.a.get(i);
                int attributeLocation = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                if (attributeLocation >= 0) {
                    shaderProgram.enableVertexAttribute(attributeLocation);
                    this.c.position(vertexAttribute.offset);
                    shaderProgram.setVertexAttribute(attributeLocation, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.a.vertexSize, this.c);
                }
                i++;
            }
        } else {
            while (i < size) {
                com.badlogic.gdx.graphics.VertexAttribute vertexAttribute2 = this.a.get(i);
                int i2 = iArr[i];
                if (i2 >= 0) {
                    shaderProgram.enableVertexAttribute(i2);
                    this.c.position(vertexAttribute2.offset);
                    shaderProgram.setVertexAttribute(i2, vertexAttribute2.numComponents, vertexAttribute2.type, vertexAttribute2.normalized, this.a.vertexSize, this.c);
                }
                i++;
            }
        }
        this.d = true;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData, com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.utils.BufferUtils.disposeUnsafeByteBuffer(this.c);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public com.badlogic.gdx.graphics.VertexAttributes getAttributes() {
        return this.a;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public java.nio.FloatBuffer getBuffer() {
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
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void setVertices(float[] fArr, int i, int i2) {
        com.badlogic.gdx.utils.BufferUtils.copy(fArr, this.c, i2, i);
        this.b.position(0);
        this.b.limit(i2);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        unbind(shaderProgram, null);
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void unbind(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, int[] iArr) {
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
        this.d = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.VertexData
    public void updateVertices(int i, float[] fArr, int i2, int i3) {
        int position = this.c.position();
        this.c.position(i * 4);
        com.badlogic.gdx.utils.BufferUtils.copy(fArr, i2, i3, (java.nio.Buffer) this.c);
        this.c.position(position);
    }
}
