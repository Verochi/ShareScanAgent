package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class SpriteCache implements com.badlogic.gdx.utils.Disposable {
    public static final float[] n = new float[30];
    public final com.badlogic.gdx.graphics.Mesh a;
    public boolean b;
    public final com.badlogic.gdx.math.Matrix4 c;
    public final com.badlogic.gdx.math.Matrix4 d;
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.SpriteCache.Cache> e;
    public final com.badlogic.gdx.math.Matrix4 f;
    public final com.badlogic.gdx.graphics.glutils.ShaderProgram g;
    public com.badlogic.gdx.graphics.g2d.SpriteCache.Cache h;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture> i;
    public final com.badlogic.gdx.utils.IntArray j;
    public float k;
    public com.badlogic.gdx.graphics.Color l;
    public com.badlogic.gdx.graphics.glutils.ShaderProgram m;
    public int renderCalls;
    public int totalRenderCalls;

    public static class Cache {
        public final int a;
        public final int b;
        public int c;
        public int d;
        public com.badlogic.gdx.graphics.Texture[] e;
        public int[] f;

        public Cache(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public SpriteCache() {
        this(1000, false);
    }

    public SpriteCache(int i, com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram, boolean z) {
        this.c = new com.badlogic.gdx.math.Matrix4();
        this.d = new com.badlogic.gdx.math.Matrix4();
        this.e = new com.badlogic.gdx.utils.Array<>();
        this.f = new com.badlogic.gdx.math.Matrix4();
        this.i = new com.badlogic.gdx.utils.Array<>(8);
        this.j = new com.badlogic.gdx.utils.IntArray(8);
        this.k = com.badlogic.gdx.graphics.Color.WHITE.toFloatBits();
        this.l = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.m = null;
        int i2 = 0;
        this.renderCalls = 0;
        this.totalRenderCalls = 0;
        this.g = shaderProgram;
        if (z && i > 8191) {
            throw new java.lang.IllegalArgumentException("Can't have more than 8191 sprites per batch: " + i);
        }
        com.badlogic.gdx.graphics.Mesh mesh = new com.badlogic.gdx.graphics.Mesh(true, (z ? 4 : 6) * i, z ? i * 6 : 0, new com.badlogic.gdx.graphics.VertexAttribute(1, 2, com.badlogic.gdx.graphics.glutils.ShaderProgram.POSITION_ATTRIBUTE), new com.badlogic.gdx.graphics.VertexAttribute(4, 4, com.badlogic.gdx.graphics.glutils.ShaderProgram.COLOR_ATTRIBUTE), new com.badlogic.gdx.graphics.VertexAttribute(16, 2, "a_texCoord0"));
        this.a = mesh;
        mesh.setAutoBind(false);
        if (z) {
            int i3 = i * 6;
            short[] sArr = new short[i3];
            short s2 = 0;
            while (i2 < i3) {
                sArr[i2 + 0] = s2;
                sArr[i2 + 1] = (short) (s2 + 1);
                short s3 = (short) (s2 + 2);
                sArr[i2 + 2] = s3;
                sArr[i2 + 3] = s3;
                sArr[i2 + 4] = (short) (s2 + 3);
                sArr[i2 + 5] = s2;
                i2 += 6;
                s2 = (short) (s2 + 4);
            }
            this.a.setIndices(sArr);
        }
        this.d.setToOrtho2D(0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
    }

    public SpriteCache(int i, boolean z) {
        this(i, a(), z);
    }

    public static com.badlogic.gdx.graphics.glutils.ShaderProgram a() {
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = new com.badlogic.gdx.graphics.glutils.ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n", "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
        if (shaderProgram.isCompiled()) {
            return shaderProgram;
        }
        throw new java.lang.IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog());
    }

    public void add(com.badlogic.gdx.graphics.Texture texture, float f, float f2) {
        float width = f + texture.getWidth();
        float height = f2 + texture.getHeight();
        float[] fArr = n;
        fArr[0] = f;
        fArr[1] = f2;
        float f3 = this.k;
        fArr[2] = f3;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = f;
        fArr[6] = height;
        fArr[7] = f3;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = width;
        fArr[11] = height;
        fArr[12] = f3;
        fArr[13] = 1.0f;
        fArr[14] = 0.0f;
        if (this.a.getNumIndices() > 0) {
            fArr[15] = width;
            fArr[16] = f2;
            fArr[17] = this.k;
            fArr[18] = 1.0f;
            fArr[19] = 1.0f;
            add(texture, fArr, 0, 20);
            return;
        }
        fArr[15] = width;
        fArr[16] = height;
        float f4 = this.k;
        fArr[17] = f4;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[20] = width;
        fArr[21] = f2;
        fArr[22] = f4;
        fArr[23] = 1.0f;
        fArr[24] = 1.0f;
        fArr[25] = f;
        fArr[26] = f2;
        fArr[27] = f4;
        fArr[28] = 0.0f;
        fArr[29] = 1.0f;
        add(texture, fArr, 0, 30);
    }

    public void add(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
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
        float width = 1.0f / texture.getWidth();
        float height = 1.0f / texture.getHeight();
        float f38 = i * width;
        float f39 = (i2 + i4) * height;
        float f40 = (i + i3) * width;
        float f41 = i2 * height;
        if (z) {
            f38 = f40;
            f40 = f38;
        }
        if (z2) {
            f39 = f41;
            f41 = f39;
        }
        float[] fArr = n;
        fArr[0] = f30;
        fArr[1] = f31;
        float f42 = this.k;
        fArr[2] = f42;
        fArr[3] = f38;
        fArr[4] = f39;
        fArr[5] = f32;
        fArr[6] = f33;
        fArr[7] = f42;
        fArr[8] = f38;
        fArr[9] = f41;
        fArr[10] = f34;
        fArr[11] = f35;
        fArr[12] = f42;
        fArr[13] = f40;
        fArr[14] = f41;
        if (this.a.getNumIndices() > 0) {
            fArr[15] = f36;
            fArr[16] = f37;
            fArr[17] = this.k;
            fArr[18] = f40;
            fArr[19] = f39;
            add(texture, fArr, 0, 20);
            return;
        }
        fArr[15] = f34;
        fArr[16] = f35;
        float f43 = this.k;
        fArr[17] = f43;
        fArr[18] = f40;
        fArr[19] = f41;
        fArr[20] = f36;
        fArr[21] = f37;
        fArr[22] = f43;
        fArr[23] = f40;
        fArr[24] = f39;
        fArr[25] = f30;
        fArr[26] = f31;
        fArr[27] = f43;
        fArr[28] = f38;
        fArr[29] = f39;
        add(texture, fArr, 0, 30);
    }

    public void add(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        float width = 1.0f / texture.getWidth();
        float height = 1.0f / texture.getHeight();
        float f5 = i * width;
        float f6 = (i2 + i4) * height;
        float f7 = (i + i3) * width;
        float f8 = i2 * height;
        float f9 = f + f3;
        float f10 = f2 + f4;
        if (!z) {
            f5 = f7;
            f7 = f5;
        }
        if (z2) {
            f6 = f8;
            f8 = f6;
        }
        float[] fArr = n;
        fArr[0] = f;
        fArr[1] = f2;
        float f11 = this.k;
        fArr[2] = f11;
        fArr[3] = f7;
        fArr[4] = f6;
        fArr[5] = f;
        fArr[6] = f10;
        fArr[7] = f11;
        fArr[8] = f7;
        fArr[9] = f8;
        fArr[10] = f9;
        fArr[11] = f10;
        fArr[12] = f11;
        fArr[13] = f5;
        fArr[14] = f8;
        if (this.a.getNumIndices() > 0) {
            fArr[15] = f9;
            fArr[16] = f2;
            fArr[17] = this.k;
            fArr[18] = f5;
            fArr[19] = f6;
            add(texture, fArr, 0, 20);
            return;
        }
        fArr[15] = f9;
        fArr[16] = f10;
        float f12 = this.k;
        fArr[17] = f12;
        fArr[18] = f5;
        fArr[19] = f8;
        fArr[20] = f9;
        fArr[21] = f2;
        fArr[22] = f12;
        fArr[23] = f5;
        fArr[24] = f6;
        fArr[25] = f;
        fArr[26] = f2;
        fArr[27] = f12;
        fArr[28] = f7;
        fArr[29] = f6;
        add(texture, fArr, 0, 30);
    }

    public void add(com.badlogic.gdx.graphics.Texture texture, float f, float f2, int i, int i2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = i + f;
        float f9 = f2 + i2;
        float[] fArr = n;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f7;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f;
        fArr[6] = f9;
        fArr[7] = f7;
        fArr[8] = f3;
        fArr[9] = f6;
        fArr[10] = f8;
        fArr[11] = f9;
        fArr[12] = f7;
        fArr[13] = f5;
        fArr[14] = f6;
        if (this.a.getNumIndices() > 0) {
            fArr[15] = f8;
            fArr[16] = f2;
            fArr[17] = f7;
            fArr[18] = f5;
            fArr[19] = f4;
            add(texture, fArr, 0, 20);
            return;
        }
        fArr[15] = f8;
        fArr[16] = f9;
        fArr[17] = f7;
        fArr[18] = f5;
        fArr[19] = f6;
        fArr[20] = f8;
        fArr[21] = f2;
        fArr[22] = f7;
        fArr[23] = f5;
        fArr[24] = f4;
        fArr[25] = f;
        fArr[26] = f2;
        fArr[27] = f7;
        fArr[28] = f3;
        fArr[29] = f4;
        add(texture, fArr, 0, 30);
    }

    public void add(com.badlogic.gdx.graphics.Texture texture, float f, float f2, int i, int i2, int i3, int i4) {
        float width = 1.0f / texture.getWidth();
        float height = 1.0f / texture.getHeight();
        float f3 = i * width;
        float f4 = (i2 + i4) * height;
        float f5 = (i + i3) * width;
        float f6 = i2 * height;
        float f7 = f + i3;
        float f8 = f2 + i4;
        float[] fArr = n;
        fArr[0] = f;
        fArr[1] = f2;
        float f9 = this.k;
        fArr[2] = f9;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f;
        fArr[6] = f8;
        fArr[7] = f9;
        fArr[8] = f3;
        fArr[9] = f6;
        fArr[10] = f7;
        fArr[11] = f8;
        fArr[12] = f9;
        fArr[13] = f5;
        fArr[14] = f6;
        if (this.a.getNumIndices() > 0) {
            fArr[15] = f7;
            fArr[16] = f2;
            fArr[17] = this.k;
            fArr[18] = f5;
            fArr[19] = f4;
            add(texture, fArr, 0, 20);
            return;
        }
        fArr[15] = f7;
        fArr[16] = f8;
        float f10 = this.k;
        fArr[17] = f10;
        fArr[18] = f5;
        fArr[19] = f6;
        fArr[20] = f7;
        fArr[21] = f2;
        fArr[22] = f10;
        fArr[23] = f5;
        fArr[24] = f4;
        fArr[25] = f;
        fArr[26] = f2;
        fArr[27] = f10;
        fArr[28] = f3;
        fArr[29] = f4;
        add(texture, fArr, 0, 30);
    }

    public void add(com.badlogic.gdx.graphics.Texture texture, float[] fArr, int i, int i2) {
        if (this.h == null) {
            throw new java.lang.IllegalStateException("beginCache must be called before add.");
        }
        int i3 = (i2 / ((this.a.getNumIndices() > 0 ? 4 : 6) * 5)) * 6;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture> array = this.i;
        int i4 = array.size - 1;
        if (i4 < 0 || array.get(i4) != texture) {
            this.i.add(texture);
            this.j.add(i3);
        } else {
            this.j.incr(i4, i3);
        }
        this.a.getVerticesBuffer().put(fArr, i, i2);
    }

    public void add(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
        if (this.a.getNumIndices() > 0) {
            add(sprite.getTexture(), sprite.getVertices(), 0, 20);
            return;
        }
        float[] vertices = sprite.getVertices();
        float[] fArr = n;
        java.lang.System.arraycopy(vertices, 0, fArr, 0, 15);
        java.lang.System.arraycopy(vertices, 10, fArr, 15, 5);
        java.lang.System.arraycopy(vertices, 15, fArr, 20, 5);
        java.lang.System.arraycopy(vertices, 0, fArr, 25, 5);
        add(sprite.getTexture(), fArr, 0, 30);
    }

    public void add(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2) {
        add(textureRegion, f, f2, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    public void add(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4) {
        float f5 = f + f3;
        float f6 = f2 + f4;
        float f7 = textureRegion.b;
        float f8 = textureRegion.e;
        float f9 = textureRegion.d;
        float f10 = textureRegion.c;
        float[] fArr = n;
        fArr[0] = f;
        fArr[1] = f2;
        float f11 = this.k;
        fArr[2] = f11;
        fArr[3] = f7;
        fArr[4] = f8;
        fArr[5] = f;
        fArr[6] = f6;
        fArr[7] = f11;
        fArr[8] = f7;
        fArr[9] = f10;
        fArr[10] = f5;
        fArr[11] = f6;
        fArr[12] = f11;
        fArr[13] = f9;
        fArr[14] = f10;
        if (this.a.getNumIndices() > 0) {
            fArr[15] = f5;
            fArr[16] = f2;
            fArr[17] = this.k;
            fArr[18] = f9;
            fArr[19] = f8;
            add(textureRegion.a, fArr, 0, 20);
            return;
        }
        fArr[15] = f5;
        fArr[16] = f6;
        float f12 = this.k;
        fArr[17] = f12;
        fArr[18] = f9;
        fArr[19] = f10;
        fArr[20] = f5;
        fArr[21] = f2;
        fArr[22] = f12;
        fArr[23] = f9;
        fArr[24] = f8;
        fArr[25] = f;
        fArr[26] = f2;
        fArr[27] = f12;
        fArr[28] = f7;
        fArr[29] = f8;
        add(textureRegion.a, fArr, 0, 30);
    }

    public void add(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
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
        float[] fArr = n;
        fArr[0] = f30;
        fArr[1] = f31;
        float f42 = this.k;
        fArr[2] = f42;
        fArr[3] = f38;
        fArr[4] = f39;
        fArr[5] = f32;
        fArr[6] = f33;
        fArr[7] = f42;
        fArr[8] = f38;
        fArr[9] = f41;
        fArr[10] = f34;
        fArr[11] = f35;
        fArr[12] = f42;
        fArr[13] = f40;
        fArr[14] = f41;
        if (this.a.getNumIndices() > 0) {
            fArr[15] = f36;
            fArr[16] = f37;
            fArr[17] = this.k;
            fArr[18] = f40;
            fArr[19] = f39;
            add(textureRegion.a, fArr, 0, 20);
            return;
        }
        fArr[15] = f34;
        fArr[16] = f35;
        float f43 = this.k;
        fArr[17] = f43;
        fArr[18] = f40;
        fArr[19] = f41;
        fArr[20] = f36;
        fArr[21] = f37;
        fArr[22] = f43;
        fArr[23] = f40;
        fArr[24] = f39;
        fArr[25] = f30;
        fArr[26] = f31;
        fArr[27] = f43;
        fArr[28] = f38;
        fArr[29] = f39;
        add(textureRegion.a, fArr, 0, 30);
    }

    public void begin() {
        if (this.b) {
            throw new java.lang.IllegalStateException("end must be called before begin.");
        }
        this.renderCalls = 0;
        this.f.set(this.d).mul(this.c);
        com.badlogic.gdx.Gdx.gl20.glDepthMask(false);
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.m;
        if (shaderProgram != null) {
            shaderProgram.begin();
            this.m.setUniformMatrix("u_proj", this.d);
            this.m.setUniformMatrix("u_trans", this.c);
            this.m.setUniformMatrix("u_projTrans", this.f);
            this.m.setUniformi("u_texture", 0);
            this.a.bind(this.m);
        } else {
            this.g.begin();
            this.g.setUniformMatrix("u_projectionViewMatrix", this.f);
            this.g.setUniformi("u_texture", 0);
            this.a.bind(this.g);
        }
        this.b = true;
    }

    public void beginCache() {
        if (this.h != null) {
            throw new java.lang.IllegalStateException("endCache must be called before begin.");
        }
        this.a.getNumIndices();
        com.badlogic.gdx.graphics.g2d.SpriteCache.Cache cache = new com.badlogic.gdx.graphics.g2d.SpriteCache.Cache(this.e.size, this.a.getVerticesBuffer().limit());
        this.h = cache;
        this.e.add(cache);
        this.a.getVerticesBuffer().compact();
    }

    public void beginCache(int i) {
        if (this.h != null) {
            throw new java.lang.IllegalStateException("endCache must be called before begin.");
        }
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.SpriteCache.Cache> array = this.e;
        if (i != array.size - 1) {
            this.h = array.get(i);
            this.a.getVerticesBuffer().position(this.h.b);
        } else {
            this.a.getVerticesBuffer().limit(array.removeIndex(i).b);
            beginCache();
        }
    }

    public void clear() {
        this.e.clear();
        this.a.getVerticesBuffer().clear().flip();
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        this.a.dispose();
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.g;
        if (shaderProgram != null) {
            shaderProgram.dispose();
        }
    }

    public void draw(int i) {
        if (!this.b) {
            throw new java.lang.IllegalStateException("SpriteCache.begin must be called before draw.");
        }
        com.badlogic.gdx.graphics.g2d.SpriteCache.Cache cache = this.e.get(i);
        int i2 = (cache.b / ((this.a.getNumIndices() > 0 ? 4 : 6) * 5)) * 6;
        com.badlogic.gdx.graphics.Texture[] textureArr = cache.e;
        int[] iArr = cache.f;
        int i3 = cache.d;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            textureArr[i4].bind();
            com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.m;
            if (shaderProgram != null) {
                this.a.render(shaderProgram, 4, i2, i5);
            } else {
                this.a.render(this.g, 4, i2, i5);
            }
            i2 += i5;
        }
        this.renderCalls += i3;
        this.totalRenderCalls += i3;
    }

    public void draw(int i, int i2, int i3) {
        int i4;
        int i5;
        if (!this.b) {
            throw new java.lang.IllegalStateException("SpriteCache.begin must be called before draw.");
        }
        com.badlogic.gdx.graphics.g2d.SpriteCache.Cache cache = this.e.get(i);
        int i6 = (i2 * 6) + cache.b;
        int i7 = i3 * 6;
        com.badlogic.gdx.graphics.Texture[] textureArr = cache.e;
        int[] iArr = cache.f;
        int i8 = cache.d;
        int i9 = 0;
        while (i9 < i8) {
            textureArr[i9].bind();
            int i10 = iArr[i9];
            if (i10 > i7) {
                i4 = i7;
                i5 = i8;
            } else {
                int i11 = i9;
                i4 = i7 - i10;
                i7 = i10;
                i5 = i11;
            }
            com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.m;
            if (shaderProgram != null) {
                this.a.render(shaderProgram, 4, i6, i7);
            } else {
                this.a.render(this.g, 4, i6, i7);
            }
            i6 += i7;
            int i12 = i4;
            i9 = i5 + 1;
            i7 = i12;
        }
        this.renderCalls += cache.d;
        this.totalRenderCalls += i8;
    }

    public void end() {
        if (!this.b) {
            throw new java.lang.IllegalStateException("begin must be called before end.");
        }
        this.b = false;
        this.g.end();
        com.badlogic.gdx.Gdx.gl20.glDepthMask(true);
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = this.m;
        if (shaderProgram != null) {
            this.a.unbind(shaderProgram);
        } else {
            this.a.unbind(this.g);
        }
    }

    public int endCache() {
        com.badlogic.gdx.graphics.g2d.SpriteCache.Cache cache = this.h;
        if (cache == null) {
            throw new java.lang.IllegalStateException("beginCache must be called before endCache.");
        }
        int position = this.a.getVerticesBuffer().position() - cache.b;
        com.badlogic.gdx.graphics.Texture[] textureArr = cache.e;
        if (textureArr == null) {
            cache.c = position;
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Texture> array = this.i;
            cache.d = array.size;
            cache.e = (com.badlogic.gdx.graphics.Texture[]) array.toArray(com.badlogic.gdx.graphics.Texture.class);
            cache.f = new int[cache.d];
            int i = this.j.size;
            for (int i2 = 0; i2 < i; i2++) {
                cache.f[i2] = this.j.get(i2);
            }
            this.a.getVerticesBuffer().flip();
        } else {
            if (position > cache.c) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("If a cache is not the last created, it cannot be redefined with more entries than when it was first created: " + position + " (" + cache.c + " max)");
            }
            int i3 = this.i.size;
            cache.d = i3;
            if (textureArr.length < i3) {
                cache.e = new com.badlogic.gdx.graphics.Texture[i3];
            }
            for (int i4 = 0; i4 < i3; i4++) {
                cache.e[i4] = this.i.get(i4);
            }
            int length = cache.f.length;
            int i5 = cache.d;
            if (length < i5) {
                cache.f = new int[i5];
            }
            for (int i6 = 0; i6 < i5; i6++) {
                cache.f[i6] = this.j.get(i6);
            }
            java.nio.FloatBuffer verticesBuffer = this.a.getVerticesBuffer();
            verticesBuffer.position(0);
            com.badlogic.gdx.graphics.g2d.SpriteCache.Cache cache2 = this.e.get(r2.size - 1);
            verticesBuffer.limit(cache2.b + cache2.c);
        }
        this.h = null;
        this.i.clear();
        this.j.clear();
        return cache.a;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        int floatToIntColor = com.badlogic.gdx.utils.NumberUtils.floatToIntColor(this.k);
        com.badlogic.gdx.graphics.Color color = this.l;
        color.r = (floatToIntColor & 255) / 255.0f;
        color.g = ((floatToIntColor >>> 8) & 255) / 255.0f;
        color.b = ((floatToIntColor >>> 16) & 255) / 255.0f;
        color.a = ((floatToIntColor >>> 24) & 255) / 255.0f;
        return color;
    }

    public com.badlogic.gdx.math.Matrix4 getProjectionMatrix() {
        return this.d;
    }

    public com.badlogic.gdx.math.Matrix4 getTransformMatrix() {
        return this.c;
    }

    public void setColor(float f) {
        this.k = f;
    }

    public void setColor(float f, float f2, float f3, float f4) {
        int i = ((int) (f2 * 255.0f)) << 8;
        int i2 = (int) (f * 255.0f);
        this.k = com.badlogic.gdx.utils.NumberUtils.intToFloatColor(i2 | i | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24));
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.k = color.toFloatBits();
    }

    public void setProjectionMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.b) {
            throw new java.lang.IllegalStateException("Can't set the matrix within begin/end.");
        }
        this.d.set(matrix4);
    }

    public void setShader(com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        this.m = shaderProgram;
    }

    public void setTransformMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        if (this.b) {
            throw new java.lang.IllegalStateException("Can't set the matrix within begin/end.");
        }
        this.c.set(matrix4);
    }
}
