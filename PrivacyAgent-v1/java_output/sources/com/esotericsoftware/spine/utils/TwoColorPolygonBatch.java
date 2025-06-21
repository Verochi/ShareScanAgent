package com.esotericsoftware.spine.utils;

/* loaded from: classes22.dex */
public class TwoColorPolygonBatch {
    public final com.badlogic.gdx.graphics.Mesh a;
    public final float[] b;
    public final short[] c;
    public final com.badlogic.gdx.math.Matrix4 d;
    public final com.badlogic.gdx.math.Matrix4 e;
    public final com.badlogic.gdx.math.Matrix4 f;
    public final com.badlogic.gdx.graphics.glutils.ShaderProgram g;
    public com.badlogic.gdx.graphics.glutils.ShaderProgram h;
    public int i;
    public int j;
    public com.badlogic.gdx.graphics.Texture k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;

    public TwoColorPolygonBatch(int i) {
        this(i, i * 2);
    }

    public TwoColorPolygonBatch(int i, int i2) {
        this.d = new com.badlogic.gdx.math.Matrix4();
        com.badlogic.gdx.math.Matrix4 matrix4 = new com.badlogic.gdx.math.Matrix4();
        this.e = matrix4;
        this.f = new com.badlogic.gdx.math.Matrix4();
        this.m = com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA;
        this.n = com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA;
        this.o = com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA;
        this.p = com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA;
        if (i > 32767) {
            throw new java.lang.IllegalArgumentException("Can't have more than 32767 vertices per batch: " + i2);
        }
        int i3 = i2 * 3;
        this.a = new com.badlogic.gdx.graphics.Mesh(com.badlogic.gdx.Gdx.gl30 != null ? com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObjectWithVAO : com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexArray, false, i, i3, new com.badlogic.gdx.graphics.VertexAttribute(1, 2, com.badlogic.gdx.graphics.glutils.ShaderProgram.POSITION_ATTRIBUTE), new com.badlogic.gdx.graphics.VertexAttribute(4, 4, "a_light"), new com.badlogic.gdx.graphics.VertexAttribute(4, 4, "a_dark"), new com.badlogic.gdx.graphics.VertexAttribute(16, 2, "a_texCoord0"));
        this.b = new float[i * 6];
        this.c = new short[i3];
        com.badlogic.gdx.graphics.glutils.ShaderProgram a = a();
        this.g = a;
        this.h = a;
        matrix4.setToOrtho2D(0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
    }

    public final com.badlogic.gdx.graphics.glutils.ShaderProgram a() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = new com.badlogic.gdx.graphics.glutils.ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_light;\nattribute vec4 a_dark;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_light;\nvarying vec4 v_dark;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_light = a_light;\n   v_light.a = v_light.a * (255.0/254.0);\n   v_dark = a_dark;\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_light;\nvarying LOWP vec4 v_dark;\nuniform float u_pma;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  vec4 texColor = texture2D(u_texture, v_texCoords);\n  gl_FragColor.a = texColor.a * v_light.a;\n  gl_FragColor.rgb = ((texColor.a - 1.0) * u_pma + 1.0 - texColor.rgb) * v_dark.rgb + texColor.rgb * v_light.rgb;\n}");
        if (shaderProgram.isCompiled()) {
            return shaderProgram;
        }
        throw new java.lang.IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog());
    }

    public final void b() {
        this.f.set(this.e).mul(this.d);
        this.h.setUniformf("u_pma", this.q ? 1.0f : 0.0f);
        this.h.setUniformMatrix("u_projTrans", this.f);
        this.h.setUniformi("u_texture", 0);
    }

    public void begin() {
        if (this.l) {
            throw new java.lang.IllegalStateException("end must be called before begin.");
        }
        com.badlogic.gdx.Gdx.gl.glDepthMask(false);
        this.h.begin();
        b();
        this.l = true;
    }

    public void dispose() {
        this.a.dispose();
        this.h.dispose();
    }

    public void draw(com.badlogic.gdx.graphics.Texture texture, float[] fArr, int i, int i2, short[] sArr, int i3, int i4) {
        if (!this.l) {
            throw new java.lang.IllegalStateException("begin must be called before draw.");
        }
        short[] sArr2 = this.c;
        float[] fArr2 = this.b;
        if (texture != this.k) {
            flush();
            this.k = texture;
        } else if (this.j + i4 > sArr2.length || this.i + i2 > fArr2.length) {
            flush();
        }
        int i5 = this.j;
        int i6 = this.i;
        int i7 = i6 / 6;
        int i8 = i4 + i3;
        while (i3 < i8) {
            sArr2[i5] = (short) (sArr[i3] + i7);
            i3++;
            i5++;
        }
        this.j = i5;
        java.lang.System.arraycopy(fArr, i, fArr2, i6, i2);
        this.i += i2;
    }

    public void end() {
        if (!this.l) {
            throw new java.lang.IllegalStateException("begin must be called before end.");
        }
        if (this.i > 0) {
            flush();
        }
        this.h.end();
        com.badlogic.gdx.Gdx.gl.glDepthMask(true);
        com.badlogic.gdx.Gdx.gl.glDisable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        this.k = null;
        this.l = false;
    }

    public void flush() {
        if (this.i == 0) {
            return;
        }
        this.k.bind();
        com.badlogic.gdx.graphics.Mesh mesh = this.a;
        mesh.setVertices(this.b, 0, this.i);
        mesh.setIndices(this.c, 0, this.j);
        com.badlogic.gdx.Gdx.gl.glEnable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        int i = this.m;
        if (i != -1) {
            com.badlogic.gdx.Gdx.gl.glBlendFuncSeparate(i, this.n, this.o, this.p);
        }
        mesh.render(this.h, 4, 0, this.j);
        this.i = 0;
        this.j = 0;
    }

    public com.badlogic.gdx.math.Matrix4 getProjectionMatrix() {
        return this.e;
    }

    public com.badlogic.gdx.math.Matrix4 getTransformMatrix() {
        return this.d;
    }

    public void setBlendFunction(int i, int i2) {
        setBlendFunctionSeparate(i, i2, i, i2);
    }

    public void setBlendFunctionSeparate(int i, int i2, int i3, int i4) {
        if (this.m == i && this.n == i2 && this.o == i3 && this.p == i4) {
            return;
        }
        flush();
        this.m = i;
        this.n = i2;
        this.o = i3;
        this.p = i4;
    }

    public void setPremultipliedAlpha(boolean z) {
        if (this.q == z) {
            return;
        }
        if (this.l) {
            flush();
        }
        this.q = z;
        if (this.l) {
            b();
        }
    }

    public void setProjectionMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.l) {
            flush();
        }
        this.e.set(matrix4);
        if (this.l) {
            b();
        }
    }

    public void setShader(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        if (this.h == shaderProgram) {
            return;
        }
        if (this.l) {
            flush();
            this.h.end();
        }
        if (shaderProgram == null) {
            shaderProgram = this.g;
        }
        this.h = shaderProgram;
        if (this.l) {
            shaderProgram.begin();
            b();
        }
    }

    public void setTransformMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.l) {
            flush();
        }
        this.d.set(matrix4);
        if (this.l) {
            b();
        }
    }
}
