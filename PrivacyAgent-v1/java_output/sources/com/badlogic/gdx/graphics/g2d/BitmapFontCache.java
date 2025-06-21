package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class BitmapFontCache {
    public static final com.badlogic.gdx.graphics.Color n = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
    public static final float o = com.badlogic.gdx.graphics.Color.WHITE.toFloatBits();
    public final com.badlogic.gdx.graphics.g2d.BitmapFont a;
    public boolean b;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.GlyphLayout> c;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.GlyphLayout> d;
    public int e;
    public float f;
    public float g;
    public final com.badlogic.gdx.graphics.Color h;
    public float i;
    public float[][] j;
    public int[] k;
    public com.badlogic.gdx.utils.IntArray[] l;
    public int[] m;

    public BitmapFontCache(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont) {
        this(bitmapFont, bitmapFont.usesIntegerPositions());
    }

    public BitmapFontCache(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont, boolean z) {
        this.c = new com.badlogic.gdx.utils.Array<>();
        this.d = new com.badlogic.gdx.utils.Array<>();
        this.h = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.a = bitmapFont;
        this.b = z;
        int i = bitmapFont.b.size;
        if (i == 0) {
            throw new java.lang.IllegalArgumentException("The specified font must contain at least one texture page.");
        }
        this.j = new float[i][];
        this.k = new int[i];
        if (i > 1) {
            com.badlogic.gdx.utils.IntArray[] intArrayArr = new com.badlogic.gdx.utils.IntArray[i];
            this.l = intArrayArr;
            int length = intArrayArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = new com.badlogic.gdx.utils.IntArray();
            }
        }
        this.m = new int[i];
    }

    public final void a(com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph, float f, float f2, float f3) {
        com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData = this.a.a;
        float f4 = bitmapFontData.scaleX;
        float f5 = bitmapFontData.scaleY;
        float f6 = f + (glyph.xoffset * f4);
        float f7 = f2 + (glyph.yoffset * f5);
        float f8 = glyph.width * f4;
        float f9 = glyph.height * f5;
        float f10 = glyph.u;
        float f11 = glyph.u2;
        float f12 = glyph.v;
        float f13 = glyph.v2;
        if (this.b) {
            f6 = java.lang.Math.round(f6);
            f7 = java.lang.Math.round(f7);
            f8 = java.lang.Math.round(f8);
            f9 = java.lang.Math.round(f9);
        }
        float f14 = f8 + f6;
        float f15 = f9 + f7;
        int i = glyph.page;
        int[] iArr = this.k;
        int i2 = iArr[i];
        iArr[i] = i2 + 20;
        com.badlogic.gdx.utils.IntArray[] intArrayArr = this.l;
        if (intArrayArr != null) {
            com.badlogic.gdx.utils.IntArray intArray = intArrayArr[i];
            int i3 = this.e;
            this.e = i3 + 1;
            intArray.add(i3);
        }
        float[] fArr = this.j[i];
        int i4 = i2 + 1;
        fArr[i2] = f6;
        int i5 = i4 + 1;
        fArr[i4] = f7;
        int i6 = i5 + 1;
        fArr[i5] = f3;
        int i7 = i6 + 1;
        fArr[i6] = f10;
        int i8 = i7 + 1;
        fArr[i7] = f12;
        int i9 = i8 + 1;
        fArr[i8] = f6;
        int i10 = i9 + 1;
        fArr[i9] = f15;
        int i11 = i10 + 1;
        fArr[i10] = f3;
        int i12 = i11 + 1;
        fArr[i11] = f10;
        int i13 = i12 + 1;
        fArr[i12] = f13;
        int i14 = i13 + 1;
        fArr[i13] = f14;
        int i15 = i14 + 1;
        fArr[i14] = f15;
        int i16 = i15 + 1;
        fArr[i15] = f3;
        int i17 = i16 + 1;
        fArr[i16] = f11;
        int i18 = i17 + 1;
        fArr[i17] = f13;
        int i19 = i18 + 1;
        fArr[i18] = f14;
        int i20 = i19 + 1;
        fArr[i19] = f7;
        int i21 = i20 + 1;
        fArr[i20] = f3;
        fArr[i21] = f11;
        fArr[i21 + 1] = f12;
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout addText(java.lang.CharSequence charSequence, float f, float f2) {
        return addText(charSequence, f, f2, 0, charSequence.length(), 0.0f, 8, false, null);
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout addText(java.lang.CharSequence charSequence, float f, float f2, float f3, int i, boolean z) {
        return addText(charSequence, f, f2, 0, charSequence.length(), f3, i, z, null);
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout addText(java.lang.CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z) {
        return addText(charSequence, f, f2, i, i2, f3, i3, z, null);
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout addText(java.lang.CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z, java.lang.String str) {
        com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout = (com.badlogic.gdx.graphics.g2d.GlyphLayout) com.badlogic.gdx.utils.Pools.obtain(com.badlogic.gdx.graphics.g2d.GlyphLayout.class);
        this.d.add(glyphLayout);
        glyphLayout.setText(this.a, charSequence, i, i2, this.h, f3, i3, z, str);
        addText(glyphLayout, f, f2);
        return glyphLayout;
    }

    public void addText(com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout, float f, float f2) {
        b(glyphLayout, f, f2 + this.a.a.ascent);
    }

    public final void b(com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout, float f, float f2) {
        int i;
        int i2 = this.a.b.size;
        float[][] fArr = this.j;
        if (fArr.length < i2) {
            float[][] fArr2 = new float[i2][];
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            this.j = fArr2;
            int[] iArr = new int[i2];
            int[] iArr2 = this.k;
            java.lang.System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            this.k = iArr;
            com.badlogic.gdx.utils.IntArray[] intArrayArr = new com.badlogic.gdx.utils.IntArray[i2];
            com.badlogic.gdx.utils.IntArray[] intArrayArr2 = this.l;
            if (intArrayArr2 != null) {
                i = intArrayArr2.length;
                java.lang.System.arraycopy(intArrayArr2, 0, intArrayArr, 0, intArrayArr2.length);
            } else {
                i = 0;
            }
            while (i < i2) {
                intArrayArr[i] = new com.badlogic.gdx.utils.IntArray();
                i++;
            }
            this.l = intArrayArr;
            this.m = new int[i2];
        }
        this.c.add(glyphLayout);
        c(glyphLayout);
        int i3 = glyphLayout.runs.size;
        for (int i4 = 0; i4 < i3; i4++) {
            com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun = glyphLayout.runs.get(i4);
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array = glyphRun.glyphs;
            com.badlogic.gdx.utils.FloatArray floatArray = glyphRun.xAdvances;
            float floatBits = glyphRun.color.toFloatBits();
            float f3 = glyphRun.x + f;
            float f4 = glyphRun.y + f2;
            int i5 = array.size;
            for (int i6 = 0; i6 < i5; i6++) {
                com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph = array.get(i6);
                f3 += floatArray.get(i6);
                a(glyph, f3, f4, floatBits);
            }
        }
        this.i = o;
    }

    public final void c(com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout) {
        if (this.j.length == 1) {
            int i = glyphLayout.runs.size;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += glyphLayout.runs.get(i3).glyphs.size;
            }
            d(0, i2);
            return;
        }
        int[] iArr = this.m;
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = 0;
        }
        int i5 = glyphLayout.runs.size;
        for (int i6 = 0; i6 < i5; i6++) {
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array = glyphLayout.runs.get(i6).glyphs;
            int i7 = array.size;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = array.get(i8).page;
                iArr[i9] = iArr[i9] + 1;
            }
        }
        int length2 = iArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            d(i10, iArr[i10]);
        }
    }

    public void clear() {
        this.f = 0.0f;
        this.g = 0.0f;
        com.badlogic.gdx.utils.Pools.freeAll(this.d, true);
        this.d.clear();
        this.c.clear();
        int length = this.k.length;
        for (int i = 0; i < length; i++) {
            com.badlogic.gdx.utils.IntArray[] intArrayArr = this.l;
            if (intArrayArr != null) {
                intArrayArr[i].clear();
            }
            this.k[i] = 0;
        }
    }

    public final void d(int i, int i2) {
        com.badlogic.gdx.utils.IntArray[] intArrayArr = this.l;
        if (intArrayArr != null) {
            com.badlogic.gdx.utils.IntArray intArray = intArrayArr[i];
            int[] iArr = intArray.items;
            if (i2 > iArr.length) {
                intArray.ensureCapacity(i2 - iArr.length);
            }
        }
        int i3 = this.k[i];
        int i4 = (i2 * 20) + i3;
        float[][] fArr = this.j;
        float[] fArr2 = fArr[i];
        if (fArr2 == null) {
            fArr[i] = new float[i4];
        } else if (fArr2.length < i4) {
            float[] fArr3 = new float[i4];
            java.lang.System.arraycopy(fArr2, 0, fArr3, 0, i3);
            this.j[i] = fArr3;
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> regions = this.a.getRegions();
        int length = this.j.length;
        for (int i = 0; i < length; i++) {
            if (this.k[i] > 0) {
                batch.draw(regions.get(i).getTexture(), this.j[i], 0, this.k[i]);
            }
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        if (f == 1.0f) {
            draw(batch);
            return;
        }
        com.badlogic.gdx.graphics.Color color = getColor();
        float f2 = color.a;
        color.a = f * f2;
        setColors(color);
        draw(batch);
        color.a = f2;
        setColors(color);
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, int i, int i2) {
        if (this.j.length == 1) {
            batch.draw(this.a.getRegion().getTexture(), this.j[0], i * 20, (i2 - i) * 20);
            return;
        }
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> regions = this.a.getRegions();
        int length = this.j.length;
        for (int i3 = 0; i3 < length; i3++) {
            com.badlogic.gdx.utils.IntArray intArray = this.l[i3];
            int i4 = intArray.size;
            int i5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = intArray.get(i7);
                if (i8 >= i2) {
                    break;
                }
                if (i5 == -1 && i8 >= i) {
                    i5 = i7;
                }
                if (i8 >= i) {
                    i6++;
                }
            }
            if (i5 != -1 && i6 != 0) {
                batch.draw(regions.get(i3).getTexture(), this.j[i3], i5 * 20, i6 * 20);
            }
        }
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.h;
    }

    public com.badlogic.gdx.graphics.g2d.BitmapFont getFont() {
        return this.a;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.GlyphLayout> getLayouts() {
        return this.c;
    }

    public int getVertexCount(int i) {
        return this.k[i];
    }

    public float[] getVertices() {
        return getVertices(0);
    }

    public float[] getVertices(int i) {
        return this.j[i];
    }

    public float getX() {
        return this.f;
    }

    public float getY() {
        return this.g;
    }

    public void setAlphas(float f) {
        int i = ((int) (f * 254.0f)) << 24;
        int length = this.j.length;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr = this.j[i2];
            int i3 = this.k[i2];
            for (int i4 = 2; i4 < i3; i4 += 5) {
                float f4 = fArr[i4];
                if (f4 != f2 || i4 == 2) {
                    f3 = com.badlogic.gdx.utils.NumberUtils.intToFloatColor((com.badlogic.gdx.utils.NumberUtils.floatToIntColor(f4) & 16777215) | i);
                    fArr[i4] = f3;
                    f2 = f4;
                } else {
                    fArr[i4] = f3;
                }
            }
        }
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.h.set(f, f2, f3, f4);
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.h.set(color);
    }

    public void setColors(float f) {
        int length = this.j.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = this.j[i];
            int i2 = this.k[i];
            for (int i3 = 2; i3 < i2; i3 += 5) {
                fArr[i3] = f;
            }
        }
    }

    public void setColors(float f, float f2, float f3, float f4) {
        int i = ((int) (f2 * 255.0f)) << 8;
        int i2 = (int) (f * 255.0f);
        setColors(com.badlogic.gdx.utils.NumberUtils.intToFloatColor(i2 | i | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24)));
    }

    public void setColors(float f, int i, int i2) {
        float[][] fArr = this.j;
        if (fArr.length == 1) {
            float[] fArr2 = fArr[0];
            int i3 = i2 * 20;
            for (int i4 = (i * 20) + 2; i4 < i3; i4 += 5) {
                fArr2[i4] = f;
            }
            return;
        }
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            float[] fArr3 = this.j[i5];
            com.badlogic.gdx.utils.IntArray intArray = this.l[i5];
            int i6 = intArray.size;
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = intArray.items[i7];
                if (i8 >= i2) {
                    break;
                }
                if (i8 >= i) {
                    for (int i9 = 0; i9 < 20; i9 += 5) {
                        fArr3[(i7 * 20) + 2 + i9] = f;
                    }
                }
            }
        }
    }

    public void setColors(com.badlogic.gdx.graphics.Color color) {
        setColors(color.toFloatBits());
    }

    public void setColors(com.badlogic.gdx.graphics.Color color, int i, int i2) {
        setColors(color.toFloatBits(), i, i2);
    }

    public void setPosition(float f, float f2) {
        translate(f - this.f, f2 - this.g);
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout setText(java.lang.CharSequence charSequence, float f, float f2) {
        clear();
        return addText(charSequence, f, f2, 0, charSequence.length(), 0.0f, 8, false);
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout setText(java.lang.CharSequence charSequence, float f, float f2, float f3, int i, boolean z) {
        clear();
        return addText(charSequence, f, f2, 0, charSequence.length(), f3, i, z);
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout setText(java.lang.CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z) {
        clear();
        return addText(charSequence, f, f2, i, i2, f3, i3, z);
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout setText(java.lang.CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z, java.lang.String str) {
        clear();
        return addText(charSequence, f, f2, i, i2, f3, i3, z, str);
    }

    public void setText(com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout, float f, float f2) {
        clear();
        addText(glyphLayout, f, f2);
    }

    public void setUseIntegerPositions(boolean z) {
        this.b = z;
    }

    public void tint(com.badlogic.gdx.graphics.Color color) {
        float floatBits = color.toFloatBits();
        if (this.i == floatBits) {
            return;
        }
        this.i = floatBits;
        int[] iArr = this.m;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = 0;
        }
        int i2 = this.c.size;
        for (int i3 = 0; i3 < i2; i3++) {
            com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout = this.c.get(i3);
            int i4 = glyphLayout.runs.size;
            for (int i5 = 0; i5 < i4; i5++) {
                com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun = glyphLayout.runs.get(i5);
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array = glyphRun.glyphs;
                float floatBits2 = n.set(glyphRun.color).mul(color).toFloatBits();
                int i6 = array.size;
                for (int i7 = 0; i7 < i6; i7++) {
                    int i8 = array.get(i7).page;
                    int i9 = iArr[i8];
                    int i10 = (i9 * 20) + 2;
                    iArr[i8] = i9 + 1;
                    float[] fArr = this.j[i8];
                    for (int i11 = 0; i11 < 20; i11 += 5) {
                        fArr[i10 + i11] = floatBits2;
                    }
                }
            }
        }
    }

    public void translate(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        if (this.b) {
            f = java.lang.Math.round(f);
            f2 = java.lang.Math.round(f2);
        }
        this.f += f;
        this.g += f2;
        float[][] fArr = this.j;
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float[] fArr2 = fArr[i];
            int i2 = this.k[i];
            for (int i3 = 0; i3 < i2; i3 += 5) {
                fArr2[i3] = fArr2[i3] + f;
                int i4 = i3 + 1;
                fArr2[i4] = fArr2[i4] + f2;
            }
        }
    }

    public boolean usesIntegerPositions() {
        return this.b;
    }
}
