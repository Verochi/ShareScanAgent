package com.autonavi.base.ae.gmap.glyph;

/* loaded from: classes12.dex */
public class FontStyle {
    public static final int SLANT_ITALIC = 1;
    public static final int SLANT_OBLIQUE = 2;
    public static final int SLANT_UPRIGHT = 0;
    public static final int WEIGHT_BLACK = 900;
    public static final int WEIGHT_BOLD = 700;
    public static final int WEIGHT_EXTRA_BLACK = 1000;
    public static final int WEIGHT_EXTRA_BOLD = 800;
    public static final int WEIGHT_EXTRA_LIGHT = 200;
    public static final int WEIGHT_INVISIBLE = 0;
    public static final int WEIGHT_LIGHT = 300;
    public static final int WEIGHT_MEDIUM = 500;
    public static final int WEIGHT_NORMAL = 400;
    public static final int WEIGHT_SEMI_BOLD = 600;
    public static final int WEIGHT_THIN = 100;
    public static final int WIDTH_CONDENSED = 3;
    public static final int WIDTH_EXPANDED = 7;
    public static final int WIDTH_EXTRA_CONDENSED = 2;
    public static final int WIDTH_EXTRA_EXPANDED = 8;
    public static final int WIDTH_NORMAL = 5;
    public static final int WIDTH_SEMI_CONDENSED = 4;
    public static final int WIDTH_SEMI_EXPANDED = 6;
    public static final int WIDTH_ULTRA_CONDENSED = 1;
    public static final int WIDTH_ULTRA_EXPANDED = 9;
    private int nFontStyleCode;

    public FontStyle() {
        this.nFontStyleCode = 328080;
    }

    public FontStyle(int i) {
        this.nFontStyleCode = i;
    }

    public FontStyle(int i, int i2, int i3) {
        this.nFontStyleCode = (i + i2) << ((i3 << 24) + 16);
    }

    public com.autonavi.base.ae.gmap.glyph.FontStyle Bold() {
        return new com.autonavi.base.ae.gmap.glyph.FontStyle(700, 5, 0);
    }

    public com.autonavi.base.ae.gmap.glyph.FontStyle BoldItalic() {
        return new com.autonavi.base.ae.gmap.glyph.FontStyle(700, 5, 1);
    }

    public com.autonavi.base.ae.gmap.glyph.FontStyle Italic() {
        return new com.autonavi.base.ae.gmap.glyph.FontStyle(400, 5, 1);
    }

    public com.autonavi.base.ae.gmap.glyph.FontStyle Normal() {
        return new com.autonavi.base.ae.gmap.glyph.FontStyle(400, 5, 0);
    }

    public int getCode() {
        return this.nFontStyleCode;
    }

    public int getSlant() {
        return (this.nFontStyleCode >> 24) & 255;
    }

    public int getWeight() {
        return this.nFontStyleCode & 65535;
    }

    public int getWidth() {
        return (this.nFontStyleCode >> 16) & 255;
    }

    public boolean isBold() {
        return getWeight() >= 600;
    }

    public boolean isItalic() {
        return getSlant() != 0;
    }
}
