package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class NinePatch {
    public static final int BOTTOM_CENTER = 7;
    public static final int BOTTOM_LEFT = 6;
    public static final int BOTTOM_RIGHT = 8;
    public static final int MIDDLE_CENTER = 4;
    public static final int MIDDLE_LEFT = 3;
    public static final int MIDDLE_RIGHT = 5;
    public static final int TOP_CENTER = 1;
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 2;
    public static final com.badlogic.gdx.graphics.Color x = new com.badlogic.gdx.graphics.Color();
    public com.badlogic.gdx.graphics.Texture a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float[] q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public final com.badlogic.gdx.graphics.Color f287s;
    public float t;
    public float u;
    public float v;
    public float w;

    public NinePatch(com.badlogic.gdx.graphics.Texture texture) {
        this(new com.badlogic.gdx.graphics.g2d.TextureRegion(texture));
    }

    public NinePatch(com.badlogic.gdx.graphics.Texture texture, int i, int i2, int i3, int i4) {
        this(new com.badlogic.gdx.graphics.g2d.TextureRegion(texture), i, i2, i3, i4);
    }

    public NinePatch(com.badlogic.gdx.graphics.Texture texture, com.badlogic.gdx.graphics.Color color) {
        this(texture);
        setColor(color);
    }

    public NinePatch(com.badlogic.gdx.graphics.g2d.NinePatch ninePatch) {
        this(ninePatch, ninePatch.f287s);
    }

    public NinePatch(com.badlogic.gdx.graphics.g2d.NinePatch ninePatch, com.badlogic.gdx.graphics.Color color) {
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.q = new float[180];
        com.badlogic.gdx.graphics.Color color2 = new com.badlogic.gdx.graphics.Color(com.badlogic.gdx.graphics.Color.WHITE);
        this.f287s = color2;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        this.a = ninePatch.a;
        this.b = ninePatch.b;
        this.c = ninePatch.c;
        this.d = ninePatch.d;
        this.e = ninePatch.e;
        this.f = ninePatch.f;
        this.g = ninePatch.g;
        this.h = ninePatch.h;
        this.i = ninePatch.i;
        this.j = ninePatch.j;
        this.k = ninePatch.k;
        this.l = ninePatch.l;
        this.m = ninePatch.m;
        this.n = ninePatch.n;
        this.o = ninePatch.o;
        this.p = ninePatch.p;
        this.t = ninePatch.t;
        this.v = ninePatch.v;
        this.w = ninePatch.w;
        this.u = ninePatch.u;
        float[] fArr = new float[ninePatch.q.length];
        this.q = fArr;
        float[] fArr2 = ninePatch.q;
        java.lang.System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        this.r = ninePatch.r;
        color2.set(color);
    }

    public NinePatch(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.q = new float[180];
        this.f287s = new com.badlogic.gdx.graphics.Color(com.badlogic.gdx.graphics.Color.WHITE);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        b(new com.badlogic.gdx.graphics.g2d.TextureRegion[]{null, null, null, null, textureRegion, null, null, null, null});
    }

    public NinePatch(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.q = new float[180];
        this.f287s = new com.badlogic.gdx.graphics.Color(com.badlogic.gdx.graphics.Color.WHITE);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        if (textureRegion == null) {
            throw new java.lang.IllegalArgumentException("region cannot be null.");
        }
        int regionWidth = (textureRegion.getRegionWidth() - i) - i2;
        int regionHeight = (textureRegion.getRegionHeight() - i3) - i4;
        com.badlogic.gdx.graphics.g2d.TextureRegion[] textureRegionArr = new com.badlogic.gdx.graphics.g2d.TextureRegion[9];
        if (i3 > 0) {
            if (i > 0) {
                textureRegionArr[0] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, 0, 0, i, i3);
            }
            if (regionWidth > 0) {
                textureRegionArr[1] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, i, 0, regionWidth, i3);
            }
            if (i2 > 0) {
                textureRegionArr[2] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, i + regionWidth, 0, i2, i3);
            }
        }
        if (regionHeight > 0) {
            if (i > 0) {
                textureRegionArr[3] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, 0, i3, i, regionHeight);
            }
            if (regionWidth > 0) {
                textureRegionArr[4] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, i, i3, regionWidth, regionHeight);
            }
            if (i2 > 0) {
                textureRegionArr[5] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, i + regionWidth, i3, i2, regionHeight);
            }
        }
        if (i4 > 0) {
            if (i > 0) {
                textureRegionArr[6] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, 0, i3 + regionHeight, i, i4);
            }
            if (regionWidth > 0) {
                textureRegionArr[7] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, i, i3 + regionHeight, regionWidth, i4);
            }
            if (i2 > 0) {
                textureRegionArr[8] = new com.badlogic.gdx.graphics.g2d.TextureRegion(textureRegion, i + regionWidth, i3 + regionHeight, i2, i4);
            }
        }
        if (i == 0 && regionWidth == 0) {
            textureRegionArr[1] = textureRegionArr[2];
            textureRegionArr[4] = textureRegionArr[5];
            textureRegionArr[7] = textureRegionArr[8];
            textureRegionArr[2] = null;
            textureRegionArr[5] = null;
            textureRegionArr[8] = null;
        }
        if (i3 == 0 && regionHeight == 0) {
            textureRegionArr[3] = textureRegionArr[6];
            textureRegionArr[4] = textureRegionArr[7];
            textureRegionArr[5] = textureRegionArr[8];
            textureRegionArr[6] = null;
            textureRegionArr[7] = null;
            textureRegionArr[8] = null;
        }
        b(textureRegionArr);
    }

    public NinePatch(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, com.badlogic.gdx.graphics.Color color) {
        this(textureRegion);
        setColor(color);
    }

    public NinePatch(com.badlogic.gdx.graphics.g2d.TextureRegion... textureRegionArr) {
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion2;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion3;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion4;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion5;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion6;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion7;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion8;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.q = new float[180];
        this.f287s = new com.badlogic.gdx.graphics.Color(com.badlogic.gdx.graphics.Color.WHITE);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        if (textureRegionArr == null || textureRegionArr.length != 9) {
            throw new java.lang.IllegalArgumentException("NinePatch needs nine TextureRegions");
        }
        b(textureRegionArr);
        float leftWidth = getLeftWidth();
        if ((textureRegionArr[0] != null && r2.getRegionWidth() != leftWidth) || (((textureRegion = textureRegionArr[3]) != null && textureRegion.getRegionWidth() != leftWidth) || ((textureRegion2 = textureRegionArr[6]) != null && textureRegion2.getRegionWidth() != leftWidth))) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Left side patches must have the same width");
        }
        float rightWidth = getRightWidth();
        if ((textureRegionArr[2] != null && r4.getRegionWidth() != rightWidth) || (((textureRegion3 = textureRegionArr[5]) != null && textureRegion3.getRegionWidth() != rightWidth) || ((textureRegion4 = textureRegionArr[8]) != null && textureRegion4.getRegionWidth() != rightWidth))) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Right side patches must have the same width");
        }
        float bottomHeight = getBottomHeight();
        if ((textureRegionArr[6] != null && r2.getRegionHeight() != bottomHeight) || (((textureRegion5 = textureRegionArr[7]) != null && textureRegion5.getRegionHeight() != bottomHeight) || ((textureRegion6 = textureRegionArr[8]) != null && textureRegion6.getRegionHeight() != bottomHeight))) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Bottom side patches must have the same height");
        }
        float topHeight = getTopHeight();
        if ((textureRegionArr[0] != null && r1.getRegionHeight() != topHeight) || (((textureRegion7 = textureRegionArr[1]) != null && textureRegion7.getRegionHeight() != topHeight) || ((textureRegion8 = textureRegionArr[2]) != null && textureRegion8.getRegionHeight() != topHeight))) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Top side patches must have the same height");
        }
    }

    public final int a(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float f, boolean z, boolean z2) {
        com.badlogic.gdx.graphics.Texture texture = this.a;
        if (texture == null) {
            this.a = textureRegion.getTexture();
        } else if (texture != textureRegion.getTexture()) {
            throw new java.lang.IllegalArgumentException("All regions must be from the same texture.");
        }
        float f2 = textureRegion.b;
        float f3 = textureRegion.e;
        float f4 = textureRegion.d;
        float f5 = textureRegion.c;
        if (z) {
            float width = 0.5f / this.a.getWidth();
            f2 += width;
            f4 -= width;
        }
        if (z2) {
            float height = 0.5f / this.a.getHeight();
            f3 -= height;
            f5 += height;
        }
        float[] fArr = this.q;
        int i = this.r;
        fArr[i + 2] = f;
        fArr[i + 3] = f2;
        fArr[i + 4] = f3;
        fArr[i + 7] = f;
        fArr[i + 8] = f2;
        fArr[i + 9] = f5;
        fArr[i + 12] = f;
        fArr[i + 13] = f4;
        fArr[i + 14] = f5;
        fArr[i + 17] = f;
        fArr[i + 18] = f4;
        fArr[i + 19] = f3;
        int i2 = i + 20;
        this.r = i2;
        return i2 - 20;
    }

    public final void b(com.badlogic.gdx.graphics.g2d.TextureRegion[] textureRegionArr) {
        float floatBits = com.badlogic.gdx.graphics.Color.WHITE.toFloatBits();
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = textureRegionArr[6];
        if (textureRegion != null) {
            this.b = a(textureRegion, floatBits, false, false);
            this.k = textureRegionArr[6].getRegionWidth();
            this.p = textureRegionArr[6].getRegionHeight();
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion2 = textureRegionArr[7];
        if (textureRegion2 != null) {
            this.c = a(textureRegion2, floatBits, true, false);
            this.m = java.lang.Math.max(this.m, textureRegionArr[7].getRegionWidth());
            this.p = java.lang.Math.max(this.p, textureRegionArr[7].getRegionHeight());
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion3 = textureRegionArr[8];
        if (textureRegion3 != null) {
            this.d = a(textureRegion3, floatBits, false, false);
            this.l = java.lang.Math.max(this.l, textureRegionArr[8].getRegionWidth());
            this.p = java.lang.Math.max(this.p, textureRegionArr[8].getRegionHeight());
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion4 = textureRegionArr[3];
        if (textureRegion4 != null) {
            this.e = a(textureRegion4, floatBits, false, true);
            this.k = java.lang.Math.max(this.k, textureRegionArr[3].getRegionWidth());
            this.n = java.lang.Math.max(this.n, textureRegionArr[3].getRegionHeight());
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion5 = textureRegionArr[4];
        if (textureRegion5 != null) {
            this.f = a(textureRegion5, floatBits, true, true);
            this.m = java.lang.Math.max(this.m, textureRegionArr[4].getRegionWidth());
            this.n = java.lang.Math.max(this.n, textureRegionArr[4].getRegionHeight());
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion6 = textureRegionArr[5];
        if (textureRegion6 != null) {
            this.g = a(textureRegion6, floatBits, false, true);
            this.l = java.lang.Math.max(this.l, textureRegionArr[5].getRegionWidth());
            this.n = java.lang.Math.max(this.n, textureRegionArr[5].getRegionHeight());
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion7 = textureRegionArr[0];
        if (textureRegion7 != null) {
            this.h = a(textureRegion7, floatBits, false, false);
            this.k = java.lang.Math.max(this.k, textureRegionArr[0].getRegionWidth());
            this.o = java.lang.Math.max(this.o, textureRegionArr[0].getRegionHeight());
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion8 = textureRegionArr[1];
        if (textureRegion8 != null) {
            this.i = a(textureRegion8, floatBits, true, false);
            this.m = java.lang.Math.max(this.m, textureRegionArr[1].getRegionWidth());
            this.o = java.lang.Math.max(this.o, textureRegionArr[1].getRegionHeight());
        }
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion9 = textureRegionArr[2];
        if (textureRegion9 != null) {
            this.j = a(textureRegion9, floatBits, false, false);
            this.l = java.lang.Math.max(this.l, textureRegionArr[2].getRegionWidth());
            this.o = java.lang.Math.max(this.o, textureRegionArr[2].getRegionHeight());
        }
        int i = this.r;
        float[] fArr = this.q;
        if (i < fArr.length) {
            float[] fArr2 = new float[i];
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, i);
            this.q = fArr2;
        }
    }

    public final void c(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4) {
        float f5 = f + this.k;
        float f6 = f + f3;
        float f7 = f6 - this.l;
        float f8 = f2 + this.p;
        float f9 = f2 + f4;
        float f10 = f9 - this.o;
        float floatBits = x.set(this.f287s).mul(batch.getColor()).toFloatBits();
        int i = this.b;
        if (i != -1) {
            d(i, f, f2, f5 - f, f8 - f2, floatBits);
        }
        int i2 = this.c;
        if (i2 != -1) {
            d(i2, f5, f2, f7 - f5, f8 - f2, floatBits);
        }
        int i3 = this.d;
        if (i3 != -1) {
            d(i3, f7, f2, f6 - f7, f8 - f2, floatBits);
        }
        int i4 = this.e;
        if (i4 != -1) {
            d(i4, f, f8, f5 - f, f10 - f8, floatBits);
        }
        int i5 = this.f;
        if (i5 != -1) {
            d(i5, f5, f8, f7 - f5, f10 - f8, floatBits);
        }
        int i6 = this.g;
        if (i6 != -1) {
            d(i6, f7, f8, f6 - f7, f10 - f8, floatBits);
        }
        int i7 = this.h;
        if (i7 != -1) {
            d(i7, f, f10, f5 - f, f9 - f10, floatBits);
        }
        int i8 = this.i;
        if (i8 != -1) {
            d(i8, f5, f10, f7 - f5, f9 - f10, floatBits);
        }
        int i9 = this.j;
        if (i9 != -1) {
            d(i9, f7, f10, f6 - f7, f9 - f10, floatBits);
        }
    }

    public final void d(int i, float f, float f2, float f3, float f4, float f5) {
        float f6 = f3 + f;
        float f7 = f4 + f2;
        float[] fArr = this.q;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f5;
        fArr[i + 5] = f;
        fArr[i + 6] = f7;
        fArr[i + 7] = f5;
        fArr[i + 10] = f6;
        fArr[i + 11] = f7;
        fArr[i + 12] = f5;
        fArr[i + 15] = f6;
        fArr[i + 16] = f2;
        fArr[i + 17] = f5;
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4) {
        c(batch, f, f2, f3, f4);
        batch.draw(this.a, this.q, 0, this.r);
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        c(batch, f, f2, f5, f6);
        float f10 = f + f3;
        float f11 = f2 + f4;
        int i = this.r;
        float[] fArr = this.q;
        if (f9 != 0.0f) {
            for (int i2 = 0; i2 < i; i2 += 5) {
                float f12 = (fArr[i2] - f10) * f7;
                int i3 = i2 + 1;
                float f13 = (fArr[i3] - f11) * f8;
                float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f9);
                float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f9);
                fArr[i2] = ((cosDeg * f12) - (sinDeg * f13)) + f10;
                fArr[i3] = (sinDeg * f12) + (cosDeg * f13) + f11;
            }
        } else if (f7 != 1.0f || f8 != 1.0f) {
            for (int i4 = 0; i4 < i; i4 += 5) {
                fArr[i4] = ((fArr[i4] - f10) * f7) + f10;
                int i5 = i4 + 1;
                fArr[i5] = ((fArr[i5] - f11) * f8) + f11;
            }
        }
        batch.draw(this.a, fArr, 0, i);
    }

    public float getBottomHeight() {
        return this.p;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.f287s;
    }

    public float getLeftWidth() {
        return this.k;
    }

    public float getMiddleHeight() {
        return this.n;
    }

    public float getMiddleWidth() {
        return this.m;
    }

    public float getPadBottom() {
        float f = this.w;
        return f == -1.0f ? getBottomHeight() : f;
    }

    public float getPadLeft() {
        float f = this.t;
        return f == -1.0f ? getLeftWidth() : f;
    }

    public float getPadRight() {
        float f = this.u;
        return f == -1.0f ? getRightWidth() : f;
    }

    public float getPadTop() {
        float f = this.v;
        return f == -1.0f ? getTopHeight() : f;
    }

    public float getRightWidth() {
        return this.l;
    }

    public com.badlogic.gdx.graphics.Texture getTexture() {
        return this.a;
    }

    public float getTopHeight() {
        return this.o;
    }

    public float getTotalHeight() {
        return this.o + this.n + this.p;
    }

    public float getTotalWidth() {
        return this.k + this.m + this.l;
    }

    public void scale(float f, float f2) {
        this.k *= f;
        this.l *= f;
        this.o *= f2;
        this.p *= f2;
        this.m *= f;
        this.n *= f2;
        float f3 = this.t;
        if (f3 != -1.0f) {
            this.t = f3 * f;
        }
        float f4 = this.u;
        if (f4 != -1.0f) {
            this.u = f4 * f;
        }
        float f5 = this.v;
        if (f5 != -1.0f) {
            this.v = f5 * f2;
        }
        float f6 = this.w;
        if (f6 != -1.0f) {
            this.w = f6 * f2;
        }
    }

    public void setBottomHeight(float f) {
        this.p = f;
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.f287s.set(color);
    }

    public void setLeftWidth(float f) {
        this.k = f;
    }

    public void setMiddleHeight(float f) {
        this.n = f;
    }

    public void setMiddleWidth(float f) {
        this.m = f;
    }

    public void setPadBottom(float f) {
        this.w = f;
    }

    public void setPadLeft(float f) {
        this.t = f;
    }

    public void setPadRight(float f) {
        this.u = f;
    }

    public void setPadTop(float f) {
        this.v = f;
    }

    public void setPadding(float f, float f2, float f3, float f4) {
        this.t = f;
        this.u = f2;
        this.v = f3;
        this.w = f4;
    }

    public void setRightWidth(float f) {
        this.l = f;
    }

    public void setTopHeight(float f) {
        this.o = f;
    }
}
