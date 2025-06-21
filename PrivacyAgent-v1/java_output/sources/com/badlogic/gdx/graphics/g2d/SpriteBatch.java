package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class SpriteBatch implements com.badlogic.gdx.graphics.g2d.Batch {

    @java.lang.Deprecated
    public static com.badlogic.gdx.graphics.Mesh.VertexDataType defaultVertexDataType = com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexArray;
    public com.badlogic.gdx.graphics.Mesh a;
    public final float[] b;
    public int c;
    public com.badlogic.gdx.graphics.Texture d;
    public float e;
    public float f;
    public boolean g;
    public final com.badlogic.gdx.math.Matrix4 h;
    public final com.badlogic.gdx.math.Matrix4 i;
    public final com.badlogic.gdx.math.Matrix4 j;
    public boolean k;
    public int l;
    public int m;
    public int maxSpritesInBatch;
    public final com.badlogic.gdx.graphics.glutils.ShaderProgram n;
    public com.badlogic.gdx.graphics.glutils.ShaderProgram o;
    public boolean p;
    public float q;
    public com.badlogic.gdx.graphics.Color r;
    public int renderCalls;
    public int totalRenderCalls;

    public SpriteBatch() {
        this(1000, null);
    }

    public SpriteBatch(int i) {
        this(i, null);
    }

    public SpriteBatch(int i, com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        this.c = 0;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = false;
        this.h = new com.badlogic.gdx.math.Matrix4();
        com.badlogic.gdx.math.Matrix4 matrix4 = new com.badlogic.gdx.math.Matrix4();
        this.i = matrix4;
        this.j = new com.badlogic.gdx.math.Matrix4();
        this.k = false;
        this.l = com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA;
        this.m = com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA;
        this.o = null;
        this.q = com.badlogic.gdx.graphics.Color.WHITE.toFloatBits();
        this.r = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.maxSpritesInBatch = 0;
        if (i > 8191) {
            throw new java.lang.IllegalArgumentException("Can't have more than 8191 sprites per batch: " + i);
        }
        int i2 = i * 6;
        this.a = new com.badlogic.gdx.graphics.Mesh(com.badlogic.gdx.Gdx.gl30 != null ? com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObjectWithVAO : defaultVertexDataType, false, i * 4, i2, new com.badlogic.gdx.graphics.VertexAttribute(1, 2, com.badlogic.gdx.graphics.glutils.ShaderProgram.POSITION_ATTRIBUTE), new com.badlogic.gdx.graphics.VertexAttribute(4, 4, com.badlogic.gdx.graphics.glutils.ShaderProgram.COLOR_ATTRIBUTE), new com.badlogic.gdx.graphics.VertexAttribute(16, 2, "a_texCoord0"));
        matrix4.setToOrtho2D(0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
        this.b = new float[i * 20];
        short[] sArr = new short[i2];
        int i3 = 0;
        short s2 = 0;
        while (i3 < i2) {
            sArr[i3] = s2;
            sArr[i3 + 1] = (short) (s2 + 1);
            short s3 = (short) (s2 + 2);
            sArr[i3 + 2] = s3;
            sArr[i3 + 3] = s3;
            sArr[i3 + 4] = (short) (s2 + 3);
            sArr[i3 + 5] = s2;
            i3 += 6;
            s2 = (short) (s2 + 4);
        }
        this.a.setIndices(sArr);
        if (shaderProgram != null) {
            this.n = shaderProgram;
        } else {
            this.n = createDefaultShader();
            this.p = true;
        }
    }

    public static com.badlogic.gdx.graphics.glutils.ShaderProgram createDefaultShader() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = new com.badlogic.gdx.graphics.glutils.ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
        if (shaderProgram.isCompiled()) {
            return shaderProgram;
        }
        throw new java.lang.IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog());
    }

    public final void a() {
        this.j.set(this.i).mul(this.h);
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.o;
        if (shaderProgram != null) {
            shaderProgram.setUniformMatrix("u_projTrans", this.j);
            this.o.setUniformi("u_texture", 0);
        } else {
            this.n.setUniformMatrix("u_projTrans", this.j);
            this.n.setUniformi("u_texture", 0);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void begin() {
        if (this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.end must be called before begin.");
        }
        this.renderCalls = 0;
        com.badlogic.gdx.Gdx.gl.glDepthMask(false);
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.o;
        if (shaderProgram != null) {
            shaderProgram.begin();
        } else {
            this.n.begin();
        }
        a();
        this.g = true;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void disableBlending() {
        if (this.k) {
            return;
        }
        flush();
        this.k = true;
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram;
        this.a.dispose();
        if (!this.p || (shaderProgram = this.n) == null) {
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
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = this.q;
        int i = this.c;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f7;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 1.0f;
        fArr[i + 5] = f;
        fArr[i + 6] = f6;
        fArr[i + 7] = f7;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 10] = f5;
        fArr[i + 11] = f6;
        fArr[i + 12] = f7;
        fArr[i + 13] = 1.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = f5;
        fArr[i + 16] = f2;
        fArr[i + 17] = f7;
        fArr[i + 18] = 1.0f;
        fArr[i + 19] = 1.0f;
        this.c = i + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
        float f9 = f3 + f;
        float f10 = f4 + f2;
        float f11 = this.q;
        int i = this.c;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f11;
        fArr[i + 3] = f5;
        fArr[i + 4] = f6;
        fArr[i + 5] = f;
        fArr[i + 6] = f10;
        fArr[i + 7] = f11;
        fArr[i + 8] = f5;
        fArr[i + 9] = f8;
        fArr[i + 10] = f9;
        fArr[i + 11] = f10;
        fArr[i + 12] = f11;
        fArr[i + 13] = f7;
        fArr[i + 14] = f8;
        fArr[i + 15] = f9;
        fArr[i + 16] = f2;
        fArr[i + 17] = f11;
        fArr[i + 18] = f7;
        fArr[i + 19] = f6;
        this.c = i + 20;
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
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
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
        float f38 = this.e;
        float f39 = i * f38;
        float f40 = this.f;
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
        float f44 = this.q;
        int i5 = this.c;
        fArr[i5] = f30;
        fArr[i5 + 1] = f31;
        fArr[i5 + 2] = f44;
        fArr[i5 + 3] = f39;
        fArr[i5 + 4] = f41;
        fArr[i5 + 5] = f32;
        fArr[i5 + 6] = f33;
        fArr[i5 + 7] = f44;
        fArr[i5 + 8] = f39;
        fArr[i5 + 9] = f43;
        fArr[i5 + 10] = f34;
        fArr[i5 + 11] = f35;
        fArr[i5 + 12] = f44;
        fArr[i5 + 13] = f42;
        fArr[i5 + 14] = f43;
        fArr[i5 + 15] = f36;
        fArr[i5 + 16] = f37;
        fArr[i5 + 17] = f44;
        fArr[i5 + 18] = f42;
        fArr[i5 + 19] = f41;
        this.c = i5 + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
        float f5 = this.e;
        float f6 = i * f5;
        float f7 = this.f;
        float f8 = (i4 + i2) * f7;
        float f9 = (i + i3) * f5;
        float f10 = i2 * f7;
        float f11 = f3 + f;
        float f12 = f4 + f2;
        if (z) {
            f9 = f6;
            f6 = f9;
        }
        if (z2) {
            f8 = f10;
            f10 = f8;
        }
        float f13 = this.q;
        int i5 = this.c;
        fArr[i5] = f;
        fArr[i5 + 1] = f2;
        fArr[i5 + 2] = f13;
        fArr[i5 + 3] = f6;
        fArr[i5 + 4] = f8;
        fArr[i5 + 5] = f;
        fArr[i5 + 6] = f12;
        fArr[i5 + 7] = f13;
        fArr[i5 + 8] = f6;
        fArr[i5 + 9] = f10;
        fArr[i5 + 10] = f11;
        fArr[i5 + 11] = f12;
        fArr[i5 + 12] = f13;
        fArr[i5 + 13] = f9;
        fArr[i5 + 14] = f10;
        fArr[i5 + 15] = f11;
        fArr[i5 + 16] = f2;
        fArr[i5 + 17] = f13;
        fArr[i5 + 18] = f9;
        fArr[i5 + 19] = f8;
        this.c = i5 + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.Texture texture, float f, float f2, int i, int i2, int i3, int i4) {
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
        float f3 = this.e;
        float f4 = i * f3;
        float f5 = this.f;
        float f6 = (i2 + i4) * f5;
        float f7 = (i + i3) * f3;
        float f8 = i2 * f5;
        float f9 = i3 + f;
        float f10 = i4 + f2;
        float f11 = this.q;
        int i5 = this.c;
        fArr[i5] = f;
        fArr[i5 + 1] = f2;
        fArr[i5 + 2] = f11;
        fArr[i5 + 3] = f4;
        fArr[i5 + 4] = f6;
        fArr[i5 + 5] = f;
        fArr[i5 + 6] = f10;
        fArr[i5 + 7] = f11;
        fArr[i5 + 8] = f4;
        fArr[i5 + 9] = f8;
        fArr[i5 + 10] = f9;
        fArr[i5 + 11] = f10;
        fArr[i5 + 12] = f11;
        fArr[i5 + 13] = f7;
        fArr[i5 + 14] = f8;
        fArr[i5 + 15] = f9;
        fArr[i5 + 16] = f2;
        fArr[i5 + 17] = f11;
        fArr[i5 + 18] = f7;
        fArr[i5 + 19] = f6;
        this.c = i5 + 20;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[LOOP:0: B:8:0x0029->B:10:0x002c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0040 A[SYNTHETIC] */
    @Override // com.badlogic.gdx.graphics.g2d.Batch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(com.badlogic.gdx.graphics.Texture texture, float[] fArr, int i, int i2) {
        int i3;
        int min;
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        int length = this.b.length;
        if (texture != this.d) {
            switchTexture(texture);
        } else {
            i3 = length - this.c;
            if (i3 == 0) {
                flush();
            }
            min = java.lang.Math.min(i3, i2);
            java.lang.System.arraycopy(fArr, i, this.b, this.c, min);
            this.c += min;
            while (true) {
                i2 -= min;
                if (i2 > 0) {
                    return;
                }
                i += min;
                flush();
                min = java.lang.Math.min(length, i2);
                java.lang.System.arraycopy(fArr, i, this.b, 0, min);
                this.c += min;
            }
        }
        i3 = length;
        min = java.lang.Math.min(i3, i2);
        java.lang.System.arraycopy(fArr, i, this.b, this.c, min);
        this.c += min;
        while (true) {
            i2 -= min;
            if (i2 > 0) {
            }
            i += min;
            flush();
            min = java.lang.Math.min(length, i2);
            java.lang.System.arraycopy(fArr, i, this.b, 0, min);
            this.c += min;
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2) {
        draw(textureRegion, f, f2, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4) {
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float f7 = textureRegion.b;
        float f8 = textureRegion.e;
        float f9 = textureRegion.d;
        float f10 = textureRegion.c;
        float f11 = this.q;
        int i = this.c;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f11;
        fArr[i + 3] = f7;
        fArr[i + 4] = f8;
        fArr[i + 5] = f;
        fArr[i + 6] = f6;
        fArr[i + 7] = f11;
        fArr[i + 8] = f7;
        fArr[i + 9] = f10;
        fArr[i + 10] = f5;
        fArr[i + 11] = f6;
        fArr[i + 12] = f11;
        fArr[i + 13] = f9;
        fArr[i + 14] = f10;
        fArr[i + 15] = f5;
        fArr[i + 16] = f2;
        fArr[i + 17] = f11;
        fArr[i + 18] = f9;
        fArr[i + 19] = f8;
        this.c = i + 20;
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
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
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
        float f42 = this.q;
        int i = this.c;
        fArr[i] = f30;
        fArr[i + 1] = f31;
        fArr[i + 2] = f42;
        fArr[i + 3] = f38;
        fArr[i + 4] = f39;
        fArr[i + 5] = f32;
        fArr[i + 6] = f33;
        fArr[i + 7] = f42;
        fArr[i + 8] = f38;
        fArr[i + 9] = f41;
        fArr[i + 10] = f34;
        fArr[i + 11] = f35;
        fArr[i + 12] = f42;
        fArr[i + 13] = f40;
        fArr[i + 14] = f41;
        fArr[i + 15] = f36;
        fArr[i + 16] = f37;
        fArr[i + 17] = f42;
        fArr[i + 18] = f40;
        fArr[i + 19] = f39;
        this.c = i + 20;
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
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
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
        float f42 = f18;
        float f43 = f19;
        float f44 = f17;
        float f45 = this.q;
        int i = this.c;
        fArr[i] = f34;
        fArr[i + 1] = f35;
        fArr[i + 2] = f45;
        fArr[i + 3] = f44;
        fArr[i + 4] = f42;
        fArr[i + 5] = f36;
        fArr[i + 6] = f37;
        fArr[i + 7] = f45;
        fArr[i + 8] = f43;
        fArr[i + 9] = f42;
        fArr[i + 10] = f38;
        fArr[i + 11] = f39;
        fArr[i + 12] = f45;
        fArr[i + 13] = f43;
        fArr[i + 14] = f20;
        fArr[i + 15] = f40;
        fArr[i + 16] = f41;
        fArr[i + 17] = f45;
        fArr[i + 18] = f44;
        fArr[i + 19] = f20;
        this.c = i + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void draw(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, com.badlogic.gdx.math.Affine2 affine2) {
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before draw.");
        }
        float[] fArr = this.b;
        com.badlogic.gdx.graphics.Texture texture = textureRegion.a;
        if (texture != this.d) {
            switchTexture(texture);
        } else if (this.c == fArr.length) {
            flush();
        }
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
        float f19 = this.q;
        int i = this.c;
        fArr[i] = f3;
        fArr[i + 1] = f4;
        fArr[i + 2] = f19;
        fArr[i + 3] = f15;
        fArr[i + 4] = f16;
        fArr[i + 5] = f6;
        fArr[i + 6] = f8;
        fArr[i + 7] = f19;
        fArr[i + 8] = f15;
        fArr[i + 9] = f18;
        fArr[i + 10] = f10;
        fArr[i + 11] = f12;
        fArr[i + 12] = f19;
        fArr[i + 13] = f17;
        fArr[i + 14] = f18;
        fArr[i + 15] = f13;
        fArr[i + 16] = f14;
        fArr[i + 17] = f19;
        fArr[i + 18] = f17;
        fArr[i + 19] = f16;
        this.c = i + 20;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void enableBlending() {
        if (this.k) {
            flush();
            this.k = false;
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void end() {
        if (!this.g) {
            throw new java.lang.IllegalStateException("SpriteBatch.begin must be called before end.");
        }
        if (this.c > 0) {
            flush();
        }
        this.d = null;
        this.g = false;
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl;
        gl20.glDepthMask(true);
        if (isBlendingEnabled()) {
            gl20.glDisable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        }
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.o;
        if (shaderProgram != null) {
            shaderProgram.end();
        } else {
            this.n.end();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void flush() {
        int i = this.c;
        if (i == 0) {
            return;
        }
        this.renderCalls++;
        this.totalRenderCalls++;
        int i2 = i / 20;
        if (i2 > this.maxSpritesInBatch) {
            this.maxSpritesInBatch = i2;
        }
        int i3 = i2 * 6;
        this.d.bind();
        com.badlogic.gdx.graphics.Mesh mesh = this.a;
        mesh.setVertices(this.b, 0, this.c);
        mesh.getIndicesBuffer().position(0);
        mesh.getIndicesBuffer().limit(i3);
        if (this.k) {
            com.badlogic.gdx.Gdx.gl.glDisable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
        } else {
            com.badlogic.gdx.Gdx.gl.glEnable(com.badlogic.gdx.graphics.GL20.GL_BLEND);
            int i4 = this.l;
            if (i4 != -1) {
                com.badlogic.gdx.Gdx.gl.glBlendFunc(i4, this.m);
            }
        }
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.o;
        if (shaderProgram == null) {
            shaderProgram = this.n;
        }
        mesh.render(shaderProgram, 4, 0, i3);
        this.c = 0;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendDstFunc() {
        return this.m;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public int getBlendSrcFunc() {
        return this.l;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.graphics.Color getColor() {
        int floatToIntColor = com.badlogic.gdx.utils.NumberUtils.floatToIntColor(this.q);
        com.badlogic.gdx.graphics.Color color = this.r;
        color.r = (floatToIntColor & 255) / 255.0f;
        color.g = ((floatToIntColor >>> 8) & 255) / 255.0f;
        color.b = ((floatToIntColor >>> 16) & 255) / 255.0f;
        color.a = ((floatToIntColor >>> 24) & 255) / 255.0f;
        return color;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public float getPackedColor() {
        return this.q;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.math.Matrix4 getProjectionMatrix() {
        return this.i;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.graphics.glutils.ShaderProgram getShader() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.o;
        return shaderProgram == null ? this.n : shaderProgram;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public com.badlogic.gdx.math.Matrix4 getTransformMatrix() {
        return this.h;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public boolean isBlendingEnabled() {
        return !this.k;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public boolean isDrawing() {
        return this.g;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setBlendFunction(int i, int i2) {
        if (this.l == i && this.m == i2) {
            return;
        }
        flush();
        this.l = i;
        this.m = i2;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(float f) {
        this.q = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(float f, float f2, float f3, float f4) {
        int i = ((int) (f2 * 255.0f)) << 8;
        int i2 = (int) (f * 255.0f);
        this.q = com.badlogic.gdx.utils.NumberUtils.intToFloatColor(i2 | i | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24));
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.q = color.toFloatBits();
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setProjectionMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.g) {
            flush();
        }
        this.i.set(matrix4);
        if (this.g) {
            a();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setShader(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        if (this.g) {
            flush();
            com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram2 = this.o;
            if (shaderProgram2 != null) {
                shaderProgram2.end();
            } else {
                this.n.end();
            }
        }
        this.o = shaderProgram;
        if (this.g) {
            if (shaderProgram != null) {
                shaderProgram.begin();
            } else {
                this.n.begin();
            }
            a();
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.Batch
    public void setTransformMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.g) {
            flush();
        }
        this.h.set(matrix4);
        if (this.g) {
            a();
        }
    }

    public void switchTexture(com.badlogic.gdx.graphics.Texture texture) {
        flush();
        this.d = texture;
        this.e = 1.0f / texture.getWidth();
        this.f = 1.0f / texture.getHeight();
    }
}
