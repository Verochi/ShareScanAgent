package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class PolygonSpriteBatch implements com.badlogic.gdx.graphics.g2d.Batch {
    public com.badlogic.gdx.graphics.Mesh a;
    public final float[] b;
    public final short[] c;
    public int d;
    public int e;
    public com.badlogic.gdx.graphics.Texture f;
    public float g;
    public float h;
    public boolean i;
    public final com.badlogic.gdx.math.Matrix4 j;
    public final com.badlogic.gdx.math.Matrix4 k;
    public final com.badlogic.gdx.math.Matrix4 l;
    public boolean m;
    public int maxTrianglesInBatch;
    public int n;
    public int o;
    public final com.badlogic.gdx.graphics.glutils.ShaderProgram p;
    public com.badlogic.gdx.graphics.glutils.ShaderProgram q;
    public boolean r;
    public int renderCalls;

    /* renamed from: s, reason: collision with root package name */
    public float f289s;
    public com.badlogic.gdx.graphics.Color t;
    public int totalRenderCalls;

    public PolygonSpriteBatch() {
        this(2000, null);
    }

    public PolygonSpriteBatch(int i) {
        this(i, i * 2, null);
    }

    public PolygonSpriteBatch(int i, int i2, com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        this.g = 0.0f;
        this.h = 0.0f;
        this.j = new com.badlogic.gdx.math.Matrix4();
        com.badlogic.gdx.math.Matrix4 matrix4 = new com.badlogic.gdx.math.Matrix4();
        this.k = matrix4;
        this.l = new com.badlogic.gdx.math.Matrix4();
        this.n = com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA;
        this.o = com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA;
        this.f289s = com.badlogic.gdx.graphics.Color.WHITE.toFloatBits();
        this.t = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.maxTrianglesInBatch = 0;
        if (i > 32767) {
            throw new java.lang.IllegalArgumentException("Can't have more than 32767 vertices per batch: " + i);
        }
        int i3 = i2 * 3;
        this.a = new com.badlogic.gdx.graphics.Mesh(com.badlogic.gdx.Gdx.gl30 != null ? com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObjectWithVAO : com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexArray, false, i, i3, new com.badlogic.gdx.graphics.VertexAttribute(1, 2, com.badlogic.gdx.graphics.glutils.ShaderProgram.POSITION_ATTRIBUTE), new com.badlogic.gdx.graphics.VertexAttribute(4, 4, com.badlogic.gdx.graphics.glutils.ShaderProgram.COLOR_ATTRIBUTE), new com.badlogic.gdx.graphics.VertexAttribute(16, 2, "a_texCoord0"));
        this.b = new float[i * 5];
        this.c = new short[i3];
        if (shaderProgram == null) {
            this.p = com.badlogic.gdx.graphics.g2d.SpriteBatch.createDefaultShader();
            this.r = true;
        } else {
            this.p = shaderProgram;
        }
        matrix4.setToOrtho2D(0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
    }

    public PolygonSpriteBatch(int i, com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        this(i, i * 2, shaderProgram);
    }

    public final void a() {
        this.l.set(this.k).mul(this.j);
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.q;
        if (shaderProgram != null) {
            shaderProgram.setUniformMatrix("u_projTrans", this.l);
            this.q.setUniformi("u_texture", 0);
        } else {
            this.p.setUniformMatrix("u_projTrans", this.l);
            this.p.setUniformi("u_texture", 0);
        }
    }

    public final void b(com.badlogic.gdx.graphics.Texture texture) {
        flush();
        this.f = texture;
        this.g = 1.0f / texture.getWidth();
        this.h = 1.0f / texture.getHeight();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void begin() {
        if (this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.end must be called before begin.");
        }
        this.renderCalls = 0;
        com.badlogic.gdx.Gdx.gl.glDepthMask(false);
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.q;
        if (shaderProgram != null) {
            shaderProgram.begin();
        } else {
            this.p.begin();
        }
        a();
        this.i = true;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void disableBlending() {
        flush();
        this.m = true;
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram;
        this.a.dispose();
        if (!this.r || (shaderProgram = this.p) == null) {
            return;
        }
        shaderProgram.dispose();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2) {
        draw(texture, f, f2, texture.getWidth(), texture.getHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d;
        int i3 = i2 / 5;
        int i4 = i + 1;
        short s2 = (short) i3;
        sArr[i] = s2;
        int i5 = i4 + 1;
        sArr[i4] = (short) (i3 + 1);
        int i6 = i5 + 1;
        short s3 = (short) (i3 + 2);
        sArr[i5] = s3;
        int i7 = i6 + 1;
        sArr[i6] = s3;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i3 + 3);
        sArr[i8] = s2;
        this.e = i8 + 1;
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = this.f289s;
        int i9 = i2 + 1;
        fArr[i2] = f;
        int i10 = i9 + 1;
        fArr[i9] = f2;
        int i11 = i10 + 1;
        fArr[i10] = f7;
        int i12 = i11 + 1;
        fArr[i11] = 0.0f;
        int i13 = i12 + 1;
        fArr[i12] = 1.0f;
        int i14 = i13 + 1;
        fArr[i13] = f;
        int i15 = i14 + 1;
        fArr[i14] = f6;
        int i16 = i15 + 1;
        fArr[i15] = f7;
        int i17 = i16 + 1;
        fArr[i16] = 0.0f;
        int i18 = i17 + 1;
        fArr[i17] = 0.0f;
        int i19 = i18 + 1;
        fArr[i18] = f5;
        int i20 = i19 + 1;
        fArr[i19] = f6;
        int i21 = i20 + 1;
        fArr[i20] = f7;
        int i22 = i21 + 1;
        fArr[i21] = 1.0f;
        int i23 = i22 + 1;
        fArr[i22] = 0.0f;
        int i24 = i23 + 1;
        fArr[i23] = f5;
        int i25 = i24 + 1;
        fArr[i24] = f2;
        int i26 = i25 + 1;
        fArr[i25] = f7;
        int i27 = i26 + 1;
        fArr[i26] = 1.0f;
        fArr[i27] = 1.0f;
        this.d = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d;
        int i3 = i2 / 5;
        int i4 = i + 1;
        short s2 = (short) i3;
        sArr[i] = s2;
        int i5 = i4 + 1;
        sArr[i4] = (short) (i3 + 1);
        int i6 = i5 + 1;
        short s3 = (short) (i3 + 2);
        sArr[i5] = s3;
        int i7 = i6 + 1;
        sArr[i6] = s3;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i3 + 3);
        sArr[i8] = s2;
        this.e = i8 + 1;
        float f9 = f + f3;
        float f10 = f2 + f4;
        float f11 = this.f289s;
        int i9 = i2 + 1;
        fArr[i2] = f;
        int i10 = i9 + 1;
        fArr[i9] = f2;
        int i11 = i10 + 1;
        fArr[i10] = f11;
        int i12 = i11 + 1;
        fArr[i11] = f5;
        int i13 = i12 + 1;
        fArr[i12] = f6;
        int i14 = i13 + 1;
        fArr[i13] = f;
        int i15 = i14 + 1;
        fArr[i14] = f10;
        int i16 = i15 + 1;
        fArr[i15] = f11;
        int i17 = i16 + 1;
        fArr[i16] = f5;
        int i18 = i17 + 1;
        fArr[i17] = f8;
        int i19 = i18 + 1;
        fArr[i18] = f9;
        int i20 = i19 + 1;
        fArr[i19] = f10;
        int i21 = i20 + 1;
        fArr[i20] = f11;
        int i22 = i21 + 1;
        fArr[i21] = f7;
        int i23 = i22 + 1;
        fArr[i22] = f8;
        int i24 = i23 + 1;
        fArr[i23] = f9;
        int i25 = i24 + 1;
        fArr[i24] = f2;
        int i26 = i25 + 1;
        fArr[i25] = f11;
        int i27 = i26 + 1;
        fArr[i26] = f7;
        fArr[i27] = f6;
        this.d = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i5 = this.e;
        int i6 = this.d / 5;
        int i7 = i5 + 1;
        short s2 = (short) i6;
        sArr[i5] = s2;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i6 + 1);
        int i9 = i8 + 1;
        short s3 = (short) (i6 + 2);
        sArr[i8] = s3;
        int i10 = i9 + 1;
        sArr[i9] = s3;
        int i11 = i10 + 1;
        sArr[i10] = (short) (i6 + 3);
        sArr[i11] = s2;
        this.e = i11 + 1;
        float f17 = f + f3;
        float f18 = f2 + f4;
        float f19 = -f3;
        float f20 = -f4;
        float f21 = f5 - f3;
        float f22 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f19 *= f7;
            f20 *= f8;
            f21 *= f7;
            f22 *= f8;
        }
        if (f9 != 0.0f) {
            float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f9);
            float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f9);
            float f23 = cosDeg * f19;
            f11 = f23 - (sinDeg * f20);
            float f24 = f19 * sinDeg;
            float f25 = (f20 * cosDeg) + f24;
            float f26 = sinDeg * f22;
            f10 = f23 - f26;
            float f27 = f22 * cosDeg;
            f14 = f24 + f27;
            float f28 = (cosDeg * f21) - f26;
            float f29 = f27 + (sinDeg * f21);
            f13 = f29 - (f14 - f25);
            f16 = (f28 - f10) + f11;
            f21 = f28;
            f12 = f25;
            f15 = f29;
        } else {
            f10 = f19;
            f11 = f10;
            f12 = f20;
            f13 = f12;
            f14 = f22;
            f15 = f14;
            f16 = f21;
        }
        float f30 = f11 + f17;
        float f31 = f12 + f18;
        float f32 = f10 + f17;
        float f33 = f14 + f18;
        float f34 = f21 + f17;
        float f35 = f15 + f18;
        float f36 = f16 + f17;
        float f37 = f13 + f18;
        float f38 = this.g;
        float f39 = i * f38;
        float f40 = this.h;
        float f41 = (i2 + i4) * f40;
        float f42 = (i + i3) * f38;
        float f43 = i2 * f40;
        if (z) {
            f39 = f42;
            f42 = f39;
        }
        if (z2) {
            f41 = f43;
            f43 = f41;
        }
        float f44 = this.f289s;
        int i12 = this.d;
        int i13 = i12 + 1;
        fArr[i12] = f30;
        int i14 = i13 + 1;
        fArr[i13] = f31;
        int i15 = i14 + 1;
        fArr[i14] = f44;
        int i16 = i15 + 1;
        fArr[i15] = f39;
        int i17 = i16 + 1;
        fArr[i16] = f41;
        int i18 = i17 + 1;
        fArr[i17] = f32;
        int i19 = i18 + 1;
        fArr[i18] = f33;
        int i20 = i19 + 1;
        fArr[i19] = f44;
        int i21 = i20 + 1;
        fArr[i20] = f39;
        int i22 = i21 + 1;
        fArr[i21] = f43;
        int i23 = i22 + 1;
        fArr[i22] = f34;
        int i24 = i23 + 1;
        fArr[i23] = f35;
        int i25 = i24 + 1;
        fArr[i24] = f44;
        int i26 = i25 + 1;
        fArr[i25] = f42;
        int i27 = i26 + 1;
        fArr[i26] = f43;
        int i28 = i27 + 1;
        fArr[i27] = f36;
        int i29 = i28 + 1;
        fArr[i28] = f37;
        int i30 = i29 + 1;
        fArr[i29] = f44;
        int i31 = i30 + 1;
        fArr[i30] = f42;
        fArr[i31] = f41;
        this.d = i31 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i5 = this.e;
        int i6 = this.d;
        int i7 = i6 / 5;
        int i8 = i5 + 1;
        short s2 = (short) i7;
        sArr[i5] = s2;
        int i9 = i8 + 1;
        sArr[i8] = (short) (i7 + 1);
        int i10 = i9 + 1;
        short s3 = (short) (i7 + 2);
        sArr[i9] = s3;
        int i11 = i10 + 1;
        sArr[i10] = s3;
        int i12 = i11 + 1;
        sArr[i11] = (short) (i7 + 3);
        sArr[i12] = s2;
        this.e = i12 + 1;
        float f5 = this.g;
        float f6 = i * f5;
        float f7 = this.h;
        float f8 = (i2 + i4) * f7;
        float f9 = (i + i3) * f5;
        float f10 = i2 * f7;
        float f11 = f + f3;
        float f12 = f2 + f4;
        if (z) {
            f6 = f9;
            f9 = f6;
        }
        if (z2) {
            f8 = f10;
            f10 = f8;
        }
        float f13 = this.f289s;
        int i13 = i6 + 1;
        fArr[i6] = f;
        int i14 = i13 + 1;
        fArr[i13] = f2;
        int i15 = i14 + 1;
        fArr[i14] = f13;
        int i16 = i15 + 1;
        fArr[i15] = f6;
        int i17 = i16 + 1;
        fArr[i16] = f8;
        int i18 = i17 + 1;
        fArr[i17] = f;
        int i19 = i18 + 1;
        fArr[i18] = f12;
        int i20 = i19 + 1;
        fArr[i19] = f13;
        int i21 = i20 + 1;
        fArr[i20] = f6;
        int i22 = i21 + 1;
        fArr[i21] = f10;
        int i23 = i22 + 1;
        fArr[i22] = f11;
        int i24 = i23 + 1;
        fArr[i23] = f12;
        int i25 = i24 + 1;
        fArr[i24] = f13;
        int i26 = i25 + 1;
        fArr[i25] = f9;
        int i27 = i26 + 1;
        fArr[i26] = f10;
        int i28 = i27 + 1;
        fArr[i27] = f11;
        int i29 = i28 + 1;
        fArr[i28] = f2;
        int i30 = i29 + 1;
        fArr[i29] = f13;
        int i31 = i30 + 1;
        fArr[i30] = f9;
        fArr[i31] = f8;
        this.d = i31 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, int i, int i2, int i3, int i4) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i5 = this.e;
        int i6 = this.d;
        int i7 = i6 / 5;
        int i8 = i5 + 1;
        short s2 = (short) i7;
        sArr[i5] = s2;
        int i9 = i8 + 1;
        sArr[i8] = (short) (i7 + 1);
        int i10 = i9 + 1;
        short s3 = (short) (i7 + 2);
        sArr[i9] = s3;
        int i11 = i10 + 1;
        sArr[i10] = s3;
        int i12 = i11 + 1;
        sArr[i11] = (short) (i7 + 3);
        sArr[i12] = s2;
        this.e = i12 + 1;
        float f3 = this.g;
        float f4 = i * f3;
        float f5 = this.h;
        float f6 = (i2 + i4) * f5;
        float f7 = (i + i3) * f3;
        float f8 = i2 * f5;
        float f9 = i3 + f;
        float f10 = i4 + f2;
        float f11 = this.f289s;
        int i13 = i6 + 1;
        fArr[i6] = f;
        int i14 = i13 + 1;
        fArr[i13] = f2;
        int i15 = i14 + 1;
        fArr[i14] = f11;
        int i16 = i15 + 1;
        fArr[i15] = f4;
        int i17 = i16 + 1;
        fArr[i16] = f6;
        int i18 = i17 + 1;
        fArr[i17] = f;
        int i19 = i18 + 1;
        fArr[i18] = f10;
        int i20 = i19 + 1;
        fArr[i19] = f11;
        int i21 = i20 + 1;
        fArr[i20] = f4;
        int i22 = i21 + 1;
        fArr[i21] = f8;
        int i23 = i22 + 1;
        fArr[i22] = f9;
        int i24 = i23 + 1;
        fArr[i23] = f10;
        int i25 = i24 + 1;
        fArr[i24] = f11;
        int i26 = i25 + 1;
        fArr[i25] = f7;
        int i27 = i26 + 1;
        fArr[i26] = f8;
        int i28 = i27 + 1;
        fArr[i27] = f9;
        int i29 = i28 + 1;
        fArr[i28] = f2;
        int i30 = i29 + 1;
        fArr[i29] = f11;
        int i31 = i30 + 1;
        fArr[i30] = f7;
        fArr[i31] = f6;
        this.d = i31 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float[] fArr, int i, int i2) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr2 = this.b;
        int i3 = (i2 / 20) * 6;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + i3 > sArr.length || this.d + i2 > fArr2.length) {
            flush();
        }
        int i4 = this.d;
        int i5 = this.e;
        short s2 = (short) (i4 / 5);
        int i6 = i3 + i5;
        while (i5 < i6) {
            sArr[i5] = s2;
            sArr[i5 + 1] = (short) (s2 + 1);
            short s3 = (short) (s2 + 2);
            sArr[i5 + 2] = s3;
            sArr[i5 + 3] = s3;
            sArr[i5 + 4] = (short) (s2 + 3);
            sArr[i5 + 5] = s2;
            i5 += 6;
            s2 = (short) (s2 + 4);
        }
        this.e = i5;
        java.lang.System.arraycopy(fArr, i, fArr2, i4, i2);
        this.d += i2;
    }

    public void draw(com.badlogic.gdx.graphics.Texture texture, float[] fArr, int i, int i2, short[] sArr, int i3, int i4) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr2 = this.c;
        float[] fArr2 = this.b;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + i4 > sArr2.length || this.d + i2 > fArr2.length) {
            flush();
        }
        int i5 = this.e;
        int i6 = this.d;
        int i7 = i6 / 5;
        int i8 = i4 + i3;
        while (i3 < i8) {
            sArr2[i5] = (short) (sArr[i3] + i7);
            i3++;
            i5++;
        }
        this.e = i5;
        java.lang.System.arraycopy(fArr, i, fArr2, i6, i2);
        this.d += i2;
    }

    public void draw(com.badlogic.gdx.graphics.g2d.PolygonRegion polygonRegion, float f, float f2) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        short[] sArr2 = polygonRegion.c;
        int length = sArr2.length;
        float[] fArr = polygonRegion.b;
        int length2 = fArr.length;
        com.badlogic.gdx.graphics.Texture texture = polygonRegion.d.a;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + length > sArr.length || this.d + ((length2 * 5) / 2) > this.b.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d;
        int i3 = i2 / 5;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            sArr[i] = (short) (sArr2[i5] + i3);
            i5++;
            i++;
        }
        this.e = i;
        float[] fArr2 = this.b;
        float f3 = this.f289s;
        float[] fArr3 = polygonRegion.a;
        while (i4 < length2) {
            int i6 = i2 + 1;
            fArr2[i2] = fArr[i4] + f;
            int i7 = i6 + 1;
            int i8 = i4 + 1;
            fArr2[i6] = fArr[i8] + f2;
            int i9 = i7 + 1;
            fArr2[i7] = f3;
            int i10 = i9 + 1;
            fArr2[i9] = fArr3[i4];
            fArr2[i10] = fArr3[i8];
            i4 += 2;
            i2 = i10 + 1;
        }
        this.d = i2;
    }

    public void draw(com.badlogic.gdx.graphics.g2d.PolygonRegion polygonRegion, float f, float f2, float f3, float f4) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        short[] sArr2 = polygonRegion.c;
        int length = sArr2.length;
        float[] fArr = polygonRegion.b;
        int length2 = fArr.length;
        com.badlogic.gdx.graphics.Texture texture = polygonRegion.d.a;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + length > sArr.length || this.d + ((length2 * 5) / 2) > this.b.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d;
        int i3 = i2 / 5;
        int length3 = sArr2.length;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length3) {
            sArr[i] = (short) (sArr2[i5] + i3);
            i5++;
            i++;
        }
        this.e = i;
        float[] fArr2 = this.b;
        float f5 = this.f289s;
        float[] fArr3 = polygonRegion.a;
        float f6 = f3 / r7.f;
        float f7 = f4 / r7.g;
        while (i4 < length2) {
            int i6 = i2 + 1;
            fArr2[i2] = (fArr[i4] * f6) + f;
            int i7 = i6 + 1;
            int i8 = i4 + 1;
            fArr2[i6] = (fArr[i8] * f7) + f2;
            int i9 = i7 + 1;
            fArr2[i7] = f5;
            int i10 = i9 + 1;
            fArr2[i9] = fArr3[i4];
            fArr2[i10] = fArr3[i8];
            i4 += 2;
            i2 = i10 + 1;
        }
        this.d = i2;
    }

    public void draw(com.badlogic.gdx.graphics.g2d.PolygonRegion polygonRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        short[] sArr2 = polygonRegion.c;
        int length = sArr2.length;
        float[] fArr = polygonRegion.b;
        int length2 = fArr.length;
        com.badlogic.gdx.graphics.Texture texture = polygonRegion.d.a;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + length > sArr.length || this.d + ((length2 * 5) / 2) > this.b.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d;
        int i3 = i2 / 5;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            sArr[i] = (short) (sArr2[i5] + i3);
            i5++;
            i++;
        }
        this.e = i;
        float[] fArr2 = this.b;
        float f10 = this.f289s;
        float[] fArr3 = polygonRegion.a;
        float f11 = f + f3;
        float f12 = f2 + f4;
        float f13 = f5 / r7.f;
        float f14 = f6 / r7.g;
        float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f9);
        float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f9);
        while (i4 < length2) {
            float f15 = ((fArr[i4] * f13) - f3) * f7;
            int i6 = i4 + 1;
            float f16 = ((fArr[i6] * f14) - f4) * f8;
            int i7 = i2 + 1;
            fArr2[i2] = ((cosDeg * f15) - (sinDeg * f16)) + f11;
            int i8 = i7 + 1;
            fArr2[i7] = (f15 * sinDeg) + (f16 * cosDeg) + f12;
            int i9 = i8 + 1;
            fArr2[i8] = f10;
            int i10 = i9 + 1;
            fArr2[i9] = fArr3[i4];
            fArr2[i10] = fArr3[i6];
            i4 += 2;
            i2 = i10 + 1;
        }
        this.d = i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2) {
        draw(textureRegion, f, f2, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d;
        int i3 = i2 / 5;
        int i4 = i + 1;
        short s2 = (short) i3;
        sArr[i] = s2;
        int i5 = i4 + 1;
        sArr[i4] = (short) (i3 + 1);
        int i6 = i5 + 1;
        short s3 = (short) (i3 + 2);
        sArr[i5] = s3;
        int i7 = i6 + 1;
        sArr[i6] = s3;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i3 + 3);
        sArr[i8] = s2;
        this.e = i8 + 1;
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = textureRegion.b;
        float f8 = textureRegion.e;
        float f9 = textureRegion.d;
        float f10 = textureRegion.c;
        float f11 = this.f289s;
        int i9 = i2 + 1;
        fArr[i2] = f;
        int i10 = i9 + 1;
        fArr[i9] = f2;
        int i11 = i10 + 1;
        fArr[i10] = f11;
        int i12 = i11 + 1;
        fArr[i11] = f7;
        int i13 = i12 + 1;
        fArr[i12] = f8;
        int i14 = i13 + 1;
        fArr[i13] = f;
        int i15 = i14 + 1;
        fArr[i14] = f6;
        int i16 = i15 + 1;
        fArr[i15] = f11;
        int i17 = i16 + 1;
        fArr[i16] = f7;
        int i18 = i17 + 1;
        fArr[i17] = f10;
        int i19 = i18 + 1;
        fArr[i18] = f5;
        int i20 = i19 + 1;
        fArr[i19] = f6;
        int i21 = i20 + 1;
        fArr[i20] = f11;
        int i22 = i21 + 1;
        fArr[i21] = f9;
        int i23 = i22 + 1;
        fArr[i22] = f10;
        int i24 = i23 + 1;
        fArr[i23] = f5;
        int i25 = i24 + 1;
        fArr[i24] = f2;
        int i26 = i25 + 1;
        fArr[i25] = f11;
        int i27 = i26 + 1;
        fArr[i26] = f9;
        fArr[i27] = f8;
        this.d = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d / 5;
        int i3 = i + 1;
        short s2 = (short) i2;
        sArr[i] = s2;
        int i4 = i3 + 1;
        sArr[i3] = (short) (i2 + 1);
        int i5 = i4 + 1;
        short s3 = (short) (i2 + 2);
        sArr[i4] = s3;
        int i6 = i5 + 1;
        sArr[i5] = s3;
        int i7 = i6 + 1;
        sArr[i6] = (short) (i2 + 3);
        sArr[i7] = s2;
        this.e = i7 + 1;
        float f17 = f + f3;
        float f18 = f2 + f4;
        float f19 = -f3;
        float f20 = -f4;
        float f21 = f5 - f3;
        float f22 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f19 *= f7;
            f20 *= f8;
            f21 *= f7;
            f22 *= f8;
        }
        if (f9 != 0.0f) {
            float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f9);
            float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f9);
            float f23 = cosDeg * f19;
            f11 = f23 - (sinDeg * f20);
            float f24 = f19 * sinDeg;
            float f25 = (f20 * cosDeg) + f24;
            float f26 = sinDeg * f22;
            f10 = f23 - f26;
            float f27 = f22 * cosDeg;
            f14 = f24 + f27;
            float f28 = (cosDeg * f21) - f26;
            float f29 = f27 + (sinDeg * f21);
            f13 = f29 - (f14 - f25);
            f16 = (f28 - f10) + f11;
            f21 = f28;
            f12 = f25;
            f15 = f29;
        } else {
            f10 = f19;
            f11 = f10;
            f12 = f20;
            f13 = f12;
            f14 = f22;
            f15 = f14;
            f16 = f21;
        }
        float f30 = f11 + f17;
        float f31 = f12 + f18;
        float f32 = f10 + f17;
        float f33 = f14 + f18;
        float f34 = f21 + f17;
        float f35 = f15 + f18;
        float f36 = f16 + f17;
        float f37 = f13 + f18;
        float f38 = textureRegion.b;
        float f39 = textureRegion.e;
        float f40 = textureRegion.d;
        float f41 = textureRegion.c;
        float f42 = this.f289s;
        int i8 = this.d;
        int i9 = i8 + 1;
        fArr[i8] = f30;
        int i10 = i9 + 1;
        fArr[i9] = f31;
        int i11 = i10 + 1;
        fArr[i10] = f42;
        int i12 = i11 + 1;
        fArr[i11] = f38;
        int i13 = i12 + 1;
        fArr[i12] = f39;
        int i14 = i13 + 1;
        fArr[i13] = f32;
        int i15 = i14 + 1;
        fArr[i14] = f33;
        int i16 = i15 + 1;
        fArr[i15] = f42;
        int i17 = i16 + 1;
        fArr[i16] = f38;
        int i18 = i17 + 1;
        fArr[i17] = f41;
        int i19 = i18 + 1;
        fArr[i18] = f34;
        int i20 = i19 + 1;
        fArr[i19] = f35;
        int i21 = i20 + 1;
        fArr[i20] = f42;
        int i22 = i21 + 1;
        fArr[i21] = f40;
        int i23 = i22 + 1;
        fArr[i22] = f41;
        int i24 = i23 + 1;
        fArr[i23] = f36;
        int i25 = i24 + 1;
        fArr[i24] = f37;
        int i26 = i25 + 1;
        fArr[i25] = f42;
        int i27 = i26 + 1;
        fArr[i26] = f40;
        fArr[i27] = f39;
        this.d = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d / 5;
        int i3 = i + 1;
        short s2 = (short) i2;
        sArr[i] = s2;
        int i4 = i3 + 1;
        sArr[i3] = (short) (i2 + 1);
        int i5 = i4 + 1;
        short s3 = (short) (i2 + 2);
        sArr[i4] = s3;
        int i6 = i5 + 1;
        sArr[i5] = s3;
        int i7 = i6 + 1;
        sArr[i6] = (short) (i2 + 3);
        sArr[i7] = s2;
        this.e = i7 + 1;
        float f21 = f + f3;
        float f22 = f2 + f4;
        float f23 = -f3;
        float f24 = -f4;
        float f25 = f5 - f3;
        float f26 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f23 *= f7;
            f24 *= f8;
            f25 *= f7;
            f26 *= f8;
        }
        if (f9 != 0.0f) {
            float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f9);
            float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f9);
            float f27 = cosDeg * f23;
            f11 = f27 - (sinDeg * f24);
            float f28 = f23 * sinDeg;
            float f29 = (f24 * cosDeg) + f28;
            float f30 = sinDeg * f26;
            f10 = f27 - f30;
            float f31 = f26 * cosDeg;
            f14 = f28 + f31;
            float f32 = (cosDeg * f25) - f30;
            float f33 = f31 + (sinDeg * f25);
            f13 = f33 - (f14 - f29);
            f16 = (f32 - f10) + f11;
            f25 = f32;
            f12 = f29;
            f15 = f33;
        } else {
            f10 = f23;
            f11 = f10;
            f12 = f24;
            f13 = f12;
            f14 = f26;
            f15 = f14;
            f16 = f25;
        }
        float f34 = f11 + f21;
        float f35 = f12 + f22;
        float f36 = f10 + f21;
        float f37 = f14 + f22;
        float f38 = f25 + f21;
        float f39 = f15 + f22;
        float f40 = f16 + f21;
        float f41 = f13 + f22;
        if (z) {
            f17 = textureRegion.d;
            f18 = textureRegion.e;
            f19 = textureRegion.b;
            f20 = textureRegion.c;
        } else {
            f17 = textureRegion.b;
            f18 = textureRegion.c;
            f19 = textureRegion.d;
            f20 = textureRegion.e;
        }
        float f42 = f20;
        float f43 = f18;
        float f44 = f19;
        float f45 = f17;
        float f46 = this.f289s;
        int i8 = this.d;
        int i9 = i8 + 1;
        fArr[i8] = f34;
        int i10 = i9 + 1;
        fArr[i9] = f35;
        int i11 = i10 + 1;
        fArr[i10] = f46;
        int i12 = i11 + 1;
        fArr[i11] = f45;
        int i13 = i12 + 1;
        fArr[i12] = f43;
        int i14 = i13 + 1;
        fArr[i13] = f36;
        int i15 = i14 + 1;
        fArr[i14] = f37;
        int i16 = i15 + 1;
        fArr[i15] = f46;
        int i17 = i16 + 1;
        fArr[i16] = f44;
        int i18 = i17 + 1;
        fArr[i17] = f43;
        int i19 = i18 + 1;
        fArr[i18] = f38;
        int i20 = i19 + 1;
        fArr[i19] = f39;
        int i21 = i20 + 1;
        fArr[i20] = f46;
        int i22 = i21 + 1;
        fArr[i21] = f44;
        int i23 = i22 + 1;
        fArr[i22] = f20;
        int i24 = i23 + 1;
        fArr[i23] = f40;
        int i25 = i24 + 1;
        fArr[i24] = f41;
        int i26 = i25 + 1;
        fArr[i25] = f46;
        int i27 = i26 + 1;
        fArr[i26] = f45;
        fArr[i27] = f42;
        this.d = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, com.badlogic.gdx.math.Affine2 affine2) {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
        }
        short[] sArr = this.c;
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.f) {
            b(texture);
        } else if (this.e + 6 > sArr.length || this.d + 20 > fArr.length) {
            flush();
        }
        int i = this.e;
        int i2 = this.d;
        int i3 = i2 / 5;
        int i4 = i + 1;
        short s2 = (short) i3;
        sArr[i] = s2;
        int i5 = i4 + 1;
        sArr[i4] = (short) (i3 + 1);
        int i6 = i5 + 1;
        short s3 = (short) (i3 + 2);
        sArr[i5] = s3;
        int i7 = i6 + 1;
        sArr[i6] = s3;
        int i8 = i7 + 1;
        sArr[i7] = (short) (i3 + 3);
        sArr[i8] = s2;
        this.e = i8 + 1;
        float f3 = affine2.m02;
        float f4 = affine2.m12;
        float f5 = affine2.m01;
        float f6 = (f5 * f2) + f3;
        float f7 = affine2.m11;
        float f8 = (f7 * f2) + f4;
        float f9 = affine2.m00;
        float f10 = (f9 * f) + (f5 * f2) + f3;
        float f11 = affine2.m10;
        float f12 = (f11 * f) + (f7 * f2) + f4;
        float f13 = (f9 * f) + f3;
        float f14 = (f11 * f) + f4;
        float f15 = textureRegion.b;
        float f16 = textureRegion.e;
        float f17 = textureRegion.d;
        float f18 = textureRegion.c;
        float f19 = this.f289s;
        int i9 = i2 + 1;
        fArr[i2] = f3;
        int i10 = i9 + 1;
        fArr[i9] = f4;
        int i11 = i10 + 1;
        fArr[i10] = f19;
        int i12 = i11 + 1;
        fArr[i11] = f15;
        int i13 = i12 + 1;
        fArr[i12] = f16;
        int i14 = i13 + 1;
        fArr[i13] = f6;
        int i15 = i14 + 1;
        fArr[i14] = f8;
        int i16 = i15 + 1;
        fArr[i15] = f19;
        int i17 = i16 + 1;
        fArr[i16] = f15;
        int i18 = i17 + 1;
        fArr[i17] = f18;
        int i19 = i18 + 1;
        fArr[i18] = f10;
        int i20 = i19 + 1;
        fArr[i19] = f12;
        int i21 = i20 + 1;
        fArr[i20] = f19;
        int i22 = i21 + 1;
        fArr[i21] = f17;
        int i23 = i22 + 1;
        fArr[i22] = f18;
        int i24 = i23 + 1;
        fArr[i23] = f13;
        int i25 = i24 + 1;
        fArr[i24] = f14;
        int i26 = i25 + 1;
        fArr[i25] = f19;
        int i27 = i26 + 1;
        fArr[i26] = f17;
        fArr[i27] = f16;
        this.d = i27 + 1;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void enableBlending() {
        flush();
        this.m = false;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void end() {
        if (!this.i) {
            throw new java.lang.IllegalStateException("PolygonSpriteBatch.begin must be called before end.");
        }
        if (this.d > 0) {
            flush();
        }
        this.f = null;
        this.i = false;
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl;
        gl20.glDepthMask(true);
        if (isBlendingEnabled()) {
            gl20.glDisable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        }
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.q;
        if (shaderProgram != null) {
            shaderProgram.end();
        } else {
            this.p.end();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void flush() {
        if (this.d == 0) {
            return;
        }
        this.renderCalls++;
        this.totalRenderCalls++;
        int i = this.e;
        if (i > this.maxTrianglesInBatch) {
            this.maxTrianglesInBatch = i;
        }
        this.f.bind();
        com.badlogic.gdx.graphics.Mesh mesh = this.a;
        mesh.setVertices(this.b, 0, this.d);
        mesh.setIndices(this.c, 0, this.e);
        if (this.m) {
            com.badlogic.gdx.Gdx.gl.glDisable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        } else {
            com.badlogic.gdx.Gdx.gl.glEnable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
            int i2 = this.n;
            if (i2 != -1) {
                com.badlogic.gdx.Gdx.gl.glBlendFunc(i2, this.o);
            }
        }
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.q;
        if (shaderProgram == null) {
            shaderProgram = this.p;
        }
        mesh.render(shaderProgram, 4, 0, i);
        this.d = 0;
        this.e = 0;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendDstFunc() {
        return this.o;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendSrcFunc() {
        return this.n;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.graphics.Color getColor() {
        int floatToIntColor = com.badlogic.gdx.utils.NumberUtils.floatToIntColor(this.f289s);
        com.badlogic.gdx.graphics.Color color = this.t;
        color.r = (floatToIntColor & 255) / 255.0f;
        color.g = ((floatToIntColor >>> 8) & 255) / 255.0f;
        color.b = ((floatToIntColor >>> 16) & 255) / 255.0f;
        color.a = ((floatToIntColor >>> 24) & 255) / 255.0f;
        return color;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public float getPackedColor() {
        return this.f289s;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.math.Matrix4 getProjectionMatrix() {
        return this.k;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.graphics.glutils.ShaderProgram getShader() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.q;
        return shaderProgram == null ? this.p : shaderProgram;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.math.Matrix4 getTransformMatrix() {
        return this.j;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public boolean isBlendingEnabled() {
        return !this.m;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public boolean isDrawing() {
        return this.i;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setBlendFunction(int i, int i2) {
        if (this.n == i && this.o == i2) {
            return;
        }
        flush();
        this.n = i;
        this.o = i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(float f) {
        this.f289s = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(float f, float f2, float f3, float f4) {
        int i = ((int) (f2 * 255.0f)) << 8;
        int i2 = (int) (f * 255.0f);
        this.f289s = com.badlogic.gdx.utils.NumberUtils.intToFloatColor(i2 | i | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24));
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.f289s = color.toFloatBits();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setProjectionMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.i) {
            flush();
        }
        this.k.set(matrix4);
        if (this.i) {
            a();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setShader(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        if (this.i) {
            flush();
            com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram2 = this.q;
            if (shaderProgram2 != null) {
                shaderProgram2.end();
            } else {
                this.p.end();
            }
        }
        this.q = shaderProgram;
        if (this.i) {
            if (shaderProgram != null) {
                shaderProgram.begin();
            } else {
                this.p.begin();
            }
            a();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setTransformMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.i) {
            flush();
        }
        this.j.set(matrix4);
        if (this.i) {
            a();
        }
    }
}
