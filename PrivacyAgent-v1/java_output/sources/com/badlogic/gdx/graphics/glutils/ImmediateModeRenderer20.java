package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class ImmediateModeRenderer20 implements com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer {
    public int a;
    public int b;
    public int c;
    public final int d;
    public int e;
    public final com.badlogic.gdx.graphics.Mesh f;
    public com.badlogic.gdx.graphics.glutils.ShaderProgram g;
    public boolean h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final com.badlogic.gdx.math.Matrix4 n;
    public final float[] o;
    public final java.lang.String[] p;

    public ImmediateModeRenderer20(int i, boolean z, boolean z2, int i2) {
        this(i, z, z2, i2, createDefaultShader(z, z2, i2));
        this.h = true;
    }

    public ImmediateModeRenderer20(int i, boolean z, boolean z2, int i2, com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        this.n = new com.badlogic.gdx.math.Matrix4();
        this.d = i;
        this.i = i2;
        this.g = shaderProgram;
        com.badlogic.gdx.graphics.Mesh mesh = new com.badlogic.gdx.graphics.Mesh(false, i, 0, a(z, z2, i2));
        this.f = mesh;
        this.o = new float[i * (mesh.getVertexAttributes().vertexSize / 4)];
        this.j = mesh.getVertexAttributes().vertexSize / 4;
        this.k = mesh.getVertexAttribute(8) != null ? mesh.getVertexAttribute(8).offset / 4 : 0;
        this.l = mesh.getVertexAttribute(4) != null ? mesh.getVertexAttribute(4).offset / 4 : 0;
        this.m = mesh.getVertexAttribute(16) != null ? mesh.getVertexAttribute(16).offset / 4 : 0;
        this.p = new java.lang.String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.p[i3] = "u_sampler" + i3;
        }
    }

    public ImmediateModeRenderer20(boolean z, boolean z2, int i) {
        this(5000, z, z2, i, createDefaultShader(z, z2, i));
        this.h = true;
    }

    public static java.lang.String b(boolean z, boolean z2, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("#ifdef GL_ES\nprecision mediump float;\n#endif\n");
        if (z2) {
            sb.append("varying vec4 v_col;\n");
        }
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("varying vec2 v_tex");
            sb.append(i2);
            sb.append(";\n");
            sb.append("uniform sampler2D u_sampler");
            sb.append(i2);
            sb.append(";\n");
        }
        sb.append("void main() {\n   gl_FragColor = ");
        sb.append(z2 ? "v_col" : "vec4(1, 1, 1, 1)");
        if (i > 0) {
            sb.append(" * ");
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 == i - 1) {
                sb.append(" texture2D(u_sampler");
                sb.append(i3);
                sb.append(",  v_tex");
                sb.append(i3);
                sb.append(")");
            } else {
                sb.append(" texture2D(u_sampler");
                sb.append(i3);
                sb.append(",  v_tex");
                sb.append(i3);
                sb.append(") *");
            }
        }
        sb.append(";\n}");
        return sb.toString();
    }

    public static java.lang.String c(boolean z, boolean z2, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("attribute vec4 a_position;\n");
        sb.append(z ? "attribute vec3 a_normal;\n" : "");
        sb.append(z2 ? "attribute vec4 a_color;\n" : "");
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(sb.toString());
        for (int i2 = 0; i2 < i; i2++) {
            sb2.append("attribute vec2 a_texCoord");
            sb2.append(i2);
            sb2.append(";\n");
        }
        sb2.append("uniform mat4 u_projModelView;\n");
        sb2.append(z2 ? "varying vec4 v_col;\n" : "");
        for (int i3 = 0; i3 < i; i3++) {
            sb2.append("varying vec2 v_tex");
            sb2.append(i3);
            sb2.append(";\n");
        }
        sb2.append("void main() {\n   gl_Position = u_projModelView * a_position;\n");
        sb2.append(z2 ? "   v_col = a_color;\n" : "");
        for (int i4 = 0; i4 < i; i4++) {
            sb2.append("   v_tex");
            sb2.append(i4);
            sb2.append(" = ");
            sb2.append(com.badlogic.gdx.graphics.glutils.ShaderProgram.TEXCOORD_ATTRIBUTE);
            sb2.append(i4);
            sb2.append(";\n");
        }
        sb2.append("   gl_PointSize = 1.0;\n");
        sb2.append("}\n");
        return sb2.toString();
    }

    public static com.badlogic.gdx.graphics.glutils.ShaderProgram createDefaultShader(boolean z, boolean z2, int i) {
        return new com.badlogic.gdx.graphics.glutils.ShaderProgram(c(z, z2, i), b(z, z2, i));
    }

    public final com.badlogic.gdx.graphics.VertexAttribute[] a(boolean z, boolean z2, int i) {
        com.badlogic.gdx.utils.Array array = new com.badlogic.gdx.utils.Array();
        array.add(new com.badlogic.gdx.graphics.VertexAttribute(1, 3, com.badlogic.gdx.graphics.glutils.ShaderProgram.POSITION_ATTRIBUTE));
        if (z) {
            array.add(new com.badlogic.gdx.graphics.VertexAttribute(8, 3, com.badlogic.gdx.graphics.glutils.ShaderProgram.NORMAL_ATTRIBUTE));
        }
        if (z2) {
            array.add(new com.badlogic.gdx.graphics.VertexAttribute(4, 4, com.badlogic.gdx.graphics.glutils.ShaderProgram.COLOR_ATTRIBUTE));
        }
        for (int i2 = 0; i2 < i; i2++) {
            array.add(new com.badlogic.gdx.graphics.VertexAttribute(16, 2, com.badlogic.gdx.graphics.glutils.ShaderProgram.TEXCOORD_ATTRIBUTE + i2));
        }
        com.badlogic.gdx.graphics.VertexAttribute[] vertexAttributeArr = new com.badlogic.gdx.graphics.VertexAttribute[array.size];
        for (int i3 = 0; i3 < array.size; i3++) {
            vertexAttributeArr[i3] = (com.badlogic.gdx.graphics.VertexAttribute) array.get(i3);
        }
        return vertexAttributeArr;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void begin(com.badlogic.gdx.math.Matrix4 matrix4, int i) {
        this.n.set(matrix4);
        this.a = i;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void color(float f) {
        this.o[this.b + this.l] = f;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void color(float f, float f2, float f3, float f4) {
        this.o[this.b + this.l] = com.badlogic.gdx.graphics.Color.toFloatBits(f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void color(com.badlogic.gdx.graphics.Color color) {
        this.o[this.b + this.l] = color.toFloatBits();
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void dispose() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram;
        if (this.h && (shaderProgram = this.g) != null) {
            shaderProgram.dispose();
        }
        this.f.dispose();
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void end() {
        flush();
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void flush() {
        if (this.e == 0) {
            return;
        }
        this.g.begin();
        this.g.setUniformMatrix("u_projModelView", this.n);
        for (int i = 0; i < this.i; i++) {
            this.g.setUniformi(this.p[i], i);
        }
        this.f.setVertices(this.o, 0, this.b);
        this.f.render(this.g, this.a);
        this.g.end();
        this.c = 0;
        this.b = 0;
        this.e = 0;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public int getMaxVertices() {
        return this.d;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public int getNumVertices() {
        return this.e;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void normal(float f, float f2, float f3) {
        int i = this.b + this.k;
        float[] fArr = this.o;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f3;
    }

    public void setShader(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        if (this.h) {
            this.g.dispose();
        }
        this.g = shaderProgram;
        this.h = false;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void texCoord(float f, float f2) {
        int i = this.b + this.m;
        float[] fArr = this.o;
        int i2 = this.c;
        fArr[i + i2] = f;
        fArr[i + i2 + 1] = f2;
        this.c = i2 + 2;
    }

    @Override // com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer
    public void vertex(float f, float f2, float f3) {
        int i = this.b;
        float[] fArr = this.o;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f3;
        this.c = 0;
        this.b = i + this.j;
        this.e++;
    }
}
