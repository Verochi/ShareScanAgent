package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public final class VertexAttribute {
    public final int a;
    public java.lang.String alias;
    public final boolean normalized;
    public final int numComponents;
    public int offset;
    public final int type;
    public int unit;
    public final int usage;

    public VertexAttribute(int i, int i2, int i3, boolean z, java.lang.String str) {
        this(i, i2, i3, z, str, 0);
    }

    public VertexAttribute(int i, int i2, int i3, boolean z, java.lang.String str, int i4) {
        this.usage = i;
        this.numComponents = i2;
        this.type = i3;
        this.normalized = z;
        this.alias = str;
        this.unit = i4;
        this.a = java.lang.Integer.numberOfTrailingZeros(i);
    }

    public VertexAttribute(int i, int i2, java.lang.String str) {
        this(i, i2, str, 0);
    }

    public VertexAttribute(int i, int i2, java.lang.String str, int i3) {
        this(i, i2, i == 4 ? com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE : com.badlogic.gdx.graphics.GL20.GL_FLOAT, i == 4, str, i3);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute Binormal() {
        return new com.badlogic.gdx.graphics.VertexAttribute(256, 3, com.badlogic.gdx.graphics.glutils.ShaderProgram.BINORMAL_ATTRIBUTE);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute BoneWeight(int i) {
        return new com.badlogic.gdx.graphics.VertexAttribute(64, 2, com.badlogic.gdx.graphics.glutils.ShaderProgram.BONEWEIGHT_ATTRIBUTE + i, i);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute ColorPacked() {
        return new com.badlogic.gdx.graphics.VertexAttribute(4, 4, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, true, com.badlogic.gdx.graphics.glutils.ShaderProgram.COLOR_ATTRIBUTE);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute ColorUnpacked() {
        return new com.badlogic.gdx.graphics.VertexAttribute(2, 4, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, com.badlogic.gdx.graphics.glutils.ShaderProgram.COLOR_ATTRIBUTE);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute Normal() {
        return new com.badlogic.gdx.graphics.VertexAttribute(8, 3, com.badlogic.gdx.graphics.glutils.ShaderProgram.NORMAL_ATTRIBUTE);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute Position() {
        return new com.badlogic.gdx.graphics.VertexAttribute(1, 3, com.badlogic.gdx.graphics.glutils.ShaderProgram.POSITION_ATTRIBUTE);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute Tangent() {
        return new com.badlogic.gdx.graphics.VertexAttribute(128, 3, com.badlogic.gdx.graphics.glutils.ShaderProgram.TANGENT_ATTRIBUTE);
    }

    public static com.badlogic.gdx.graphics.VertexAttribute TexCoords(int i) {
        return new com.badlogic.gdx.graphics.VertexAttribute(16, 2, com.badlogic.gdx.graphics.glutils.ShaderProgram.TEXCOORD_ATTRIBUTE + i, i);
    }

    public com.badlogic.gdx.graphics.VertexAttribute copy() {
        return new com.badlogic.gdx.graphics.VertexAttribute(this.usage, this.numComponents, this.type, this.normalized, this.alias, this.unit);
    }

    public boolean equals(com.badlogic.gdx.graphics.VertexAttribute vertexAttribute) {
        return vertexAttribute != null && this.usage == vertexAttribute.usage && this.numComponents == vertexAttribute.numComponents && this.type == vertexAttribute.type && this.normalized == vertexAttribute.normalized && this.alias.equals(vertexAttribute.alias) && this.unit == vertexAttribute.unit;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.badlogic.gdx.graphics.VertexAttribute) {
            return equals((com.badlogic.gdx.graphics.VertexAttribute) obj);
        }
        return false;
    }

    public int getKey() {
        return (this.a << 8) + (this.unit & 255);
    }

    public int getSizeInBytes() {
        int i = this.type;
        if (i == 5126 || i == 5132) {
            return this.numComponents * 4;
        }
        switch (i) {
            case com.badlogic.gdx.graphics.GL20.GL_BYTE /* 5120 */:
            case com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE /* 5121 */:
                return this.numComponents;
            case com.badlogic.gdx.graphics.GL20.GL_SHORT /* 5122 */:
            case com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_SHORT /* 5123 */:
                return this.numComponents * 2;
            default:
                return 0;
        }
    }

    public int hashCode() {
        return (((getKey() * 541) + this.numComponents) * 541) + this.alias.hashCode();
    }
}
