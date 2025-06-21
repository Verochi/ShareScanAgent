package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class GlyphLayout implements com.badlogic.gdx.utils.Pool.Poolable {
    public float height;
    public float width;
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun> runs = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> a = new com.badlogic.gdx.utils.Array<>(4);

    public static class GlyphRun implements com.badlogic.gdx.utils.Pool.Poolable {
        public float width;
        public float x;
        public float y;
        public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> glyphs = new com.badlogic.gdx.utils.Array<>();
        public com.badlogic.gdx.utils.FloatArray xAdvances = new com.badlogic.gdx.utils.FloatArray();
        public final com.badlogic.gdx.graphics.Color color = new com.badlogic.gdx.graphics.Color();

        @Override // com.badlogic.gdx.utils.Pool.Poolable
        public void reset() {
            this.glyphs.clear();
            this.xAdvances.clear();
            this.width = 0.0f;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(this.glyphs.size);
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array = this.glyphs;
            int i = array.size;
            for (int i2 = 0; i2 < i; i2++) {
                sb.append((char) array.get(i2).id);
            }
            sb.append(", #");
            sb.append(this.color);
            sb.append(", ");
            sb.append(this.x);
            sb.append(", ");
            sb.append(this.y);
            sb.append(", ");
            sb.append(this.width);
            return sb.toString();
        }
    }

    public GlyphLayout() {
    }

    public GlyphLayout(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont, java.lang.CharSequence charSequence) {
        setText(bitmapFont, charSequence);
    }

    public GlyphLayout(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont, java.lang.CharSequence charSequence, int i, int i2, com.badlogic.gdx.graphics.Color color, float f, int i3, boolean z, java.lang.String str) {
        setText(bitmapFont, charSequence, i, i2, color, f, i3, z, str);
    }

    public GlyphLayout(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont, java.lang.CharSequence charSequence, com.badlogic.gdx.graphics.Color color, float f, int i, boolean z) {
        setText(bitmapFont, charSequence, color, f, i, z);
    }

    public final void a(com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData, com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun) {
        if (bitmapFontData.isWhitespace((char) glyphRun.glyphs.peek().id)) {
            return;
        }
        float f = ((r0.xoffset + r0.width) * bitmapFontData.scaleX) - bitmapFontData.padRight;
        glyphRun.width += f - glyphRun.xAdvances.peek();
        glyphRun.xAdvances.set(r3.size - 1, f);
    }

    public final int b(java.lang.CharSequence charSequence, int i, int i2, com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.Color> pool) {
        int i3;
        int i4;
        if (i == i2) {
            return -1;
        }
        char charAt = charSequence.charAt(i);
        if (charAt != '#') {
            if (charAt == '[') {
                return -2;
            }
            if (charAt == ']') {
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> array = this.a;
                if (array.size > 1) {
                    pool.free(array.pop());
                }
                return 0;
            }
            for (int i5 = i + 1; i5 < i2; i5++) {
                if (charSequence.charAt(i5) == ']') {
                    com.badlogic.gdx.graphics.Color color = com.badlogic.gdx.graphics.Colors.get(charSequence.subSequence(i, i5).toString());
                    if (color == null) {
                        return -1;
                    }
                    com.badlogic.gdx.graphics.Color obtain = pool.obtain();
                    this.a.add(obtain);
                    obtain.set(color);
                    return i5 - i;
                }
            }
            return -1;
        }
        int i6 = i + 1;
        int i7 = 0;
        while (true) {
            if (i6 >= i2) {
                break;
            }
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 != ']') {
                if (charAt2 >= '0' && charAt2 <= '9') {
                    i3 = i7 * 16;
                    i4 = charAt2 - '0';
                } else if (charAt2 >= 'a' && charAt2 <= 'f') {
                    i3 = i7 * 16;
                    i4 = charAt2 - 'W';
                } else {
                    if (charAt2 < 'A' || charAt2 > 'F') {
                        break;
                    }
                    i3 = i7 * 16;
                    i4 = charAt2 - '7';
                }
                i7 = i3 + i4;
                i6++;
            } else if (i6 >= i + 2 && i6 <= i + 9) {
                int i8 = i6 - i;
                if (i8 <= 7) {
                    for (int i9 = 0; i9 < 9 - i8; i9++) {
                        i7 <<= 4;
                    }
                    i7 |= 255;
                }
                com.badlogic.gdx.graphics.Color obtain2 = pool.obtain();
                this.a.add(obtain2);
                com.badlogic.gdx.graphics.Color.rgba8888ToColor(obtain2, i7);
                return i8;
            }
        }
        return -1;
    }

    public final void c(com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData, com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun, float f, java.lang.String str, int i, com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun> pool) {
        com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun obtain = pool.obtain();
        bitmapFontData.getGlyphs(obtain, str, 0, str.length(), true);
        int i2 = obtain.xAdvances.size;
        float f2 = 0.0f;
        for (int i3 = 1; i3 < i2; i3++) {
            f2 += obtain.xAdvances.get(i3);
        }
        float f3 = f - f2;
        float f4 = glyphRun.x;
        int i4 = 0;
        while (true) {
            com.badlogic.gdx.utils.FloatArray floatArray = glyphRun.xAdvances;
            if (i4 >= floatArray.size) {
                break;
            }
            float f5 = floatArray.get(i4);
            f4 += f5;
            if (f4 > f3) {
                glyphRun.width = (f4 - glyphRun.x) - f5;
                break;
            }
            i4++;
        }
        if (i4 > 1) {
            glyphRun.glyphs.truncate(i4 - 1);
            glyphRun.xAdvances.truncate(i4);
            a(bitmapFontData, glyphRun);
            com.badlogic.gdx.utils.FloatArray floatArray2 = obtain.xAdvances;
            int i5 = floatArray2.size;
            if (i5 > 0) {
                glyphRun.xAdvances.addAll(floatArray2, 1, i5 - 1);
            }
        } else {
            glyphRun.glyphs.clear();
            glyphRun.xAdvances.clear();
            glyphRun.xAdvances.addAll(obtain.xAdvances);
            com.badlogic.gdx.utils.FloatArray floatArray3 = obtain.xAdvances;
            if (floatArray3.size > 0) {
                glyphRun.width += floatArray3.get(0);
            }
        }
        glyphRun.glyphs.addAll(obtain.glyphs);
        glyphRun.width += f2;
        pool.free(obtain);
    }

    public final com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun d(com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData, com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun, com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun> pool, int i, int i2) {
        int i3;
        com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun obtain = pool.obtain();
        obtain.color.set(glyphRun.color);
        int i4 = glyphRun.glyphs.size;
        while (i2 < i) {
            glyphRun.width += glyphRun.xAdvances.get(i2);
            i2++;
        }
        while (true) {
            i3 = i + 1;
            if (i2 <= i3) {
                break;
            }
            i2--;
            glyphRun.width -= glyphRun.xAdvances.get(i2);
        }
        if (i < i4) {
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array = obtain.glyphs;
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array2 = glyphRun.glyphs;
            array.addAll(array2, 0, i);
            array2.removeRange(0, i - 1);
            glyphRun.glyphs = array;
            obtain.glyphs = array2;
            com.badlogic.gdx.utils.FloatArray floatArray = obtain.xAdvances;
            com.badlogic.gdx.utils.FloatArray floatArray2 = glyphRun.xAdvances;
            floatArray.addAll(floatArray2, 0, i3);
            floatArray2.removeRange(1, i);
            floatArray2.set(0, ((-array2.first().xoffset) * bitmapFontData.scaleX) - bitmapFontData.padLeft);
            glyphRun.xAdvances = floatArray;
            obtain.xAdvances = floatArray2;
        }
        if (i == 0) {
            pool.free(glyphRun);
            this.runs.pop();
        } else {
            a(bitmapFontData, glyphRun);
        }
        return obtain;
    }

    @Override // com.badlogic.gdx.utils.Pool.Poolable
    public void reset() {
        com.badlogic.gdx.utils.Pools.get(com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun.class).freeAll(this.runs);
        this.runs.clear();
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public void setText(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont, java.lang.CharSequence charSequence) {
        setText(bitmapFont, charSequence, 0, charSequence.length(), bitmapFont.getColor(), 0.0f, 8, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont, java.lang.CharSequence charSequence, int i, int i2, com.badlogic.gdx.graphics.Color color, float f, int i3, boolean z, java.lang.String str) {
        com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.Color> pool;
        float f2;
        float f3;
        int i4;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> array;
        int i5;
        int i6;
        com.badlogic.gdx.graphics.Color color2;
        int i7;
        int i8;
        boolean z2;
        boolean z3;
        float f4;
        int i9;
        int i10;
        int i11;
        float f5;
        float f6;
        int i12;
        float[] fArr;
        float f7;
        int i13;
        float f8;
        com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun d;
        int i14;
        com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout = this;
        java.lang.CharSequence charSequence2 = charSequence;
        int i15 = i2;
        boolean z4 = str != null ? true : f <= bitmapFont.a.spaceWidth ? false : z;
        com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData = bitmapFont.a;
        boolean z5 = bitmapFontData.markupEnabled;
        com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun> pool2 = com.badlogic.gdx.utils.Pools.get(com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun.class);
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun> array2 = glyphLayout.runs;
        pool2.freeAll(array2);
        array2.clear();
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.Color> array3 = glyphLayout.a;
        array3.add(color);
        com.badlogic.gdx.utils.Pool<com.badlogic.gdx.graphics.Color> pool3 = com.badlogic.gdx.utils.Pools.get(com.badlogic.gdx.graphics.Color.class);
        int i16 = i;
        com.badlogic.gdx.graphics.Color color3 = color;
        com.badlogic.gdx.graphics.Color color4 = color3;
        boolean z6 = z4;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i17 = 0;
        int i18 = 0;
        int i19 = i16;
        loop0: while (true) {
            if (i19 != i15) {
                int i20 = i19 + 1;
                char charAt = charSequence2.charAt(i19);
                if (charAt != '\n') {
                    if (charAt == '[' && z5) {
                        int b = glyphLayout.b(charSequence2, i20, i15, pool3);
                        if (b >= 0) {
                            i14 = i20 - 1;
                            i20 += b + 1;
                            color2 = array3.peek();
                            i7 = -1;
                            z3 = true;
                            z2 = false;
                        } else if (b == -2) {
                            i19 = i20 + 1;
                        }
                    }
                    i5 = i20;
                    color2 = color4;
                    i7 = -1;
                    i6 = -1;
                } else {
                    i14 = i20 - 1;
                    color2 = color4;
                    i7 = -1;
                    z3 = false;
                    z2 = true;
                }
                int i21 = i14;
                i5 = i20;
                i6 = i21;
                if (i6 == i7) {
                    if (i6 != i16) {
                        com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun obtain = pool2.obtain();
                        obtain.color.set(color3);
                        obtain.x = f9;
                        obtain.y = f10;
                        i10 = i16;
                        i11 = i6;
                        pool = pool3;
                        f5 = f9;
                        array = array3;
                        bitmapFontData.getGlyphs(obtain, charSequence, i10, i11, z3);
                        if (obtain.glyphs.size == 0) {
                            pool2.free(obtain);
                        } else {
                            array2.add(obtain);
                            com.badlogic.gdx.utils.FloatArray floatArray = obtain.xAdvances;
                            float[] fArr2 = floatArray.items;
                            int i22 = floatArray.size;
                            float f12 = f11;
                            int i23 = 0;
                            float f13 = f10;
                            com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun = obtain;
                            float f14 = f13;
                            while (i23 < i22) {
                                float f15 = fArr2[i23];
                                float f16 = f5 + f15;
                                if (!z6 || f16 <= f) {
                                    i12 = i22;
                                } else {
                                    i12 = i22;
                                    if (i23 > 1) {
                                        float f17 = f16 - f15;
                                        fArr = fArr2;
                                        f5 = f16;
                                        int i24 = i23 - 1;
                                        float f18 = f12;
                                        if ((f17 + ((glyphRun.glyphs.get(i24).xoffset + glyphRun.glyphs.get(i24).width) * bitmapFontData.scaleX)) - 1.0E-4f <= f) {
                                            f7 = f18;
                                            glyphRun.width += f15;
                                            i13 = i23;
                                            f12 = f7;
                                            fArr2 = fArr;
                                            i23 = i13 + 1;
                                            glyphLayout = this;
                                            i22 = i12;
                                        } else {
                                            if (str != null) {
                                                f3 = f18;
                                                c(bitmapFontData, glyphRun, f, str, i23, pool2);
                                                f2 = glyphRun.x + glyphRun.width;
                                                i4 = i17;
                                                break loop0;
                                            }
                                            int i25 = i18;
                                            int wrapIndex = bitmapFontData.getWrapIndex(glyphRun.glyphs, i23);
                                            int i26 = (!(glyphRun.x == 0.0f && wrapIndex == 0) && wrapIndex < glyphRun.glyphs.size) ? wrapIndex : i24;
                                            if (i26 == 0) {
                                                f8 = f18;
                                                i18 = i25;
                                                d = glyphRun;
                                            } else {
                                                f8 = f18;
                                                i18 = i25;
                                                d = d(bitmapFontData, glyphRun, pool2, i26, i23);
                                                array2.add(d);
                                            }
                                            f12 = java.lang.Math.max(f8, glyphRun.x + glyphRun.width);
                                            f14 += bitmapFontData.down;
                                            i17++;
                                            d.x = 0.0f;
                                            d.y = f14;
                                            com.badlogic.gdx.utils.FloatArray floatArray2 = d.xAdvances;
                                            int i27 = floatArray2.size;
                                            fArr2 = floatArray2.items;
                                            glyphRun = d;
                                            i12 = i27;
                                            i13 = -1;
                                            f5 = 0.0f;
                                            i23 = i13 + 1;
                                            glyphLayout = this;
                                            i22 = i12;
                                        }
                                    }
                                }
                                fArr = fArr2;
                                f5 = f16;
                                f7 = f12;
                                glyphRun.width += f15;
                                i13 = i23;
                                f12 = f7;
                                fArr2 = fArr;
                                i23 = i13 + 1;
                                glyphLayout = this;
                                i22 = i12;
                            }
                            f6 = f12;
                            f10 = f14;
                            float f19 = f5;
                            if (z2) {
                                f6 = java.lang.Math.max(f6, f19);
                                float f20 = bitmapFontData.down;
                                if (i11 == i10) {
                                    f20 *= bitmapFontData.blankLineScale;
                                    i18++;
                                } else {
                                    i17++;
                                }
                                f10 += f20;
                                f19 = 0.0f;
                            }
                            f4 = f19;
                            f11 = f6;
                            i9 = i5;
                            color3 = color2;
                        }
                    } else {
                        i10 = i16;
                        i11 = i6;
                        pool = pool3;
                        f5 = f9;
                        array = array3;
                    }
                    f6 = f11;
                    float f192 = f5;
                    if (z2) {
                    }
                    f4 = f192;
                    f11 = f6;
                    i9 = i5;
                    color3 = color2;
                } else {
                    pool = pool3;
                    f4 = f9;
                    i9 = i16;
                    array = array3;
                }
                glyphLayout = this;
                charSequence2 = charSequence;
                i16 = i9;
                pool3 = pool;
                array3 = array;
                i19 = i5;
                color4 = color2;
                f9 = f4;
                i15 = i2;
            } else {
                if (i16 == i15) {
                    pool = pool3;
                    f2 = f9;
                    f3 = f11;
                    i4 = i17;
                    array = array3;
                    break;
                }
                i5 = i19;
                i6 = i15;
                color2 = color4;
                i7 = -1;
            }
            z3 = false;
            z2 = false;
            if (i6 == i7) {
            }
            glyphLayout = this;
            charSequence2 = charSequence;
            i16 = i9;
            pool3 = pool;
            array3 = array;
            i19 = i5;
            color4 = color2;
            f9 = f4;
            i15 = i2;
        }
        float max = java.lang.Math.max(f3, f2);
        int i28 = array.size;
        for (int i29 = 1; i29 < i28; i29++) {
            pool.free(array.get(i29));
        }
        array.clear();
        if ((i3 & 8) == 0) {
            boolean z7 = (i3 & 1) != 0;
            int i30 = array2.size;
            float f21 = 0.0f;
            float f22 = -2.1474836E9f;
            int i31 = 0;
            for (int i32 = 0; i32 < i30; i32++) {
                com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun2 = array2.get(i32);
                float f23 = glyphRun2.y;
                if (f23 != f22) {
                    float f24 = f - f21;
                    if (z7) {
                        f24 /= 2.0f;
                    }
                    while (true) {
                        i8 = i31;
                        if (i8 >= i32) {
                            break;
                        }
                        i31 = i8 + 1;
                        array2.get(i8).x += f24;
                    }
                    i31 = i8;
                    f22 = f23;
                    f21 = 0.0f;
                }
                f21 += glyphRun2.width;
            }
            float f25 = f - f21;
            if (z7) {
                f25 /= 2.0f;
            }
            while (true) {
                int i33 = i31;
                if (i33 >= i30) {
                    break;
                }
                i31 = i33 + 1;
                array2.get(i33).x += f25;
            }
        }
        glyphLayout.width = max;
        float f26 = bitmapFontData.capHeight;
        float f27 = bitmapFontData.lineHeight;
        glyphLayout.height = f26 + (i4 * f27) + (i18 * f27 * bitmapFontData.blankLineScale);
    }

    public void setText(com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont, java.lang.CharSequence charSequence, com.badlogic.gdx.graphics.Color color, float f, int i, boolean z) {
        setText(bitmapFont, charSequence, 0, charSequence.length(), color, f, i, z, null);
    }

    public java.lang.String toString() {
        if (this.runs.size == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append(this.width);
        sb.append('x');
        sb.append(this.height);
        sb.append('\n');
        int i = this.runs.size;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(this.runs.get(i2).toString());
            sb.append('\n');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
