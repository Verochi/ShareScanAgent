package com.badlogic.gdx.graphics;

/* loaded from: classes12.dex */
public class Color {
    public float a;
    public float b;
    public float g;
    public float r;
    public static final com.badlogic.gdx.graphics.Color CLEAR = new com.badlogic.gdx.graphics.Color(0.0f, 0.0f, 0.0f, 0.0f);
    public static final com.badlogic.gdx.graphics.Color BLACK = new com.badlogic.gdx.graphics.Color(0.0f, 0.0f, 0.0f, 1.0f);
    public static final com.badlogic.gdx.graphics.Color WHITE = new com.badlogic.gdx.graphics.Color(-1);
    public static final com.badlogic.gdx.graphics.Color LIGHT_GRAY = new com.badlogic.gdx.graphics.Color(-1077952513);
    public static final com.badlogic.gdx.graphics.Color GRAY = new com.badlogic.gdx.graphics.Color(2139062271);
    public static final com.badlogic.gdx.graphics.Color DARK_GRAY = new com.badlogic.gdx.graphics.Color(1061109759);
    public static final com.badlogic.gdx.graphics.Color BLUE = new com.badlogic.gdx.graphics.Color(0.0f, 0.0f, 1.0f, 1.0f);
    public static final com.badlogic.gdx.graphics.Color NAVY = new com.badlogic.gdx.graphics.Color(0.0f, 0.0f, 0.5f, 1.0f);
    public static final com.badlogic.gdx.graphics.Color ROYAL = new com.badlogic.gdx.graphics.Color(1097458175);
    public static final com.badlogic.gdx.graphics.Color SLATE = new com.badlogic.gdx.graphics.Color(1887473919);
    public static final com.badlogic.gdx.graphics.Color SKY = new com.badlogic.gdx.graphics.Color(-2016482305);
    public static final com.badlogic.gdx.graphics.Color CYAN = new com.badlogic.gdx.graphics.Color(0.0f, 1.0f, 1.0f, 1.0f);
    public static final com.badlogic.gdx.graphics.Color TEAL = new com.badlogic.gdx.graphics.Color(0.0f, 0.5f, 0.5f, 1.0f);
    public static final com.badlogic.gdx.graphics.Color GREEN = new com.badlogic.gdx.graphics.Color(16711935);
    public static final com.badlogic.gdx.graphics.Color CHARTREUSE = new com.badlogic.gdx.graphics.Color(2147418367);
    public static final com.badlogic.gdx.graphics.Color LIME = new com.badlogic.gdx.graphics.Color(852308735);
    public static final com.badlogic.gdx.graphics.Color FOREST = new com.badlogic.gdx.graphics.Color(579543807);
    public static final com.badlogic.gdx.graphics.Color OLIVE = new com.badlogic.gdx.graphics.Color(1804477439);
    public static final com.badlogic.gdx.graphics.Color YELLOW = new com.badlogic.gdx.graphics.Color(-65281);
    public static final com.badlogic.gdx.graphics.Color GOLD = new com.badlogic.gdx.graphics.Color(-2686721);
    public static final com.badlogic.gdx.graphics.Color GOLDENROD = new com.badlogic.gdx.graphics.Color(-626712321);
    public static final com.badlogic.gdx.graphics.Color ORANGE = new com.badlogic.gdx.graphics.Color(-5963521);
    public static final com.badlogic.gdx.graphics.Color BROWN = new com.badlogic.gdx.graphics.Color(-1958407169);
    public static final com.badlogic.gdx.graphics.Color TAN = new com.badlogic.gdx.graphics.Color(-759919361);
    public static final com.badlogic.gdx.graphics.Color FIREBRICK = new com.badlogic.gdx.graphics.Color(-1306385665);
    public static final com.badlogic.gdx.graphics.Color RED = new com.badlogic.gdx.graphics.Color(-16776961);
    public static final com.badlogic.gdx.graphics.Color SCARLET = new com.badlogic.gdx.graphics.Color(-13361921);
    public static final com.badlogic.gdx.graphics.Color CORAL = new com.badlogic.gdx.graphics.Color(-8433409);
    public static final com.badlogic.gdx.graphics.Color SALMON = new com.badlogic.gdx.graphics.Color(-92245249);
    public static final com.badlogic.gdx.graphics.Color PINK = new com.badlogic.gdx.graphics.Color(-9849601);
    public static final com.badlogic.gdx.graphics.Color MAGENTA = new com.badlogic.gdx.graphics.Color(1.0f, 0.0f, 1.0f, 1.0f);
    public static final com.badlogic.gdx.graphics.Color PURPLE = new com.badlogic.gdx.graphics.Color(-1608453889);
    public static final com.badlogic.gdx.graphics.Color VIOLET = new com.badlogic.gdx.graphics.Color(-293409025);
    public static final com.badlogic.gdx.graphics.Color MAROON = new com.badlogic.gdx.graphics.Color(-1339006721);

    public Color() {
    }

    public Color(float f, float f2, float f3, float f4) {
        this.r = f;
        this.g = f2;
        this.b = f3;
        this.a = f4;
        clamp();
    }

    public Color(int i) {
        rgba8888ToColor(this, i);
    }

    public Color(com.badlogic.gdx.graphics.Color color) {
        set(color);
    }

    public static void abgr8888ToColor(com.badlogic.gdx.graphics.Color color, float f) {
        int floatToIntColor = com.badlogic.gdx.utils.NumberUtils.floatToIntColor(f);
        color.a = (((-16777216) & floatToIntColor) >>> 24) / 255.0f;
        color.b = ((16711680 & floatToIntColor) >>> 16) / 255.0f;
        color.g = ((65280 & floatToIntColor) >>> 8) / 255.0f;
        color.r = (floatToIntColor & 255) / 255.0f;
    }

    public static int alpha(float f) {
        return (int) (f * 255.0f);
    }

    public static int argb8888(float f, float f2, float f3, float f4) {
        return (((int) (f * 255.0f)) << 24) | (((int) (f2 * 255.0f)) << 16) | (((int) (f3 * 255.0f)) << 8) | ((int) (f4 * 255.0f));
    }

    public static int argb8888(com.badlogic.gdx.graphics.Color color) {
        return ((int) (color.b * 255.0f)) | (((int) (color.a * 255.0f)) << 24) | (((int) (color.r * 255.0f)) << 16) | (((int) (color.g * 255.0f)) << 8);
    }

    public static void argb8888ToColor(com.badlogic.gdx.graphics.Color color, int i) {
        color.a = (((-16777216) & i) >>> 24) / 255.0f;
        color.r = ((16711680 & i) >>> 16) / 255.0f;
        color.g = ((65280 & i) >>> 8) / 255.0f;
        color.b = (i & 255) / 255.0f;
    }

    public static int luminanceAlpha(float f, float f2) {
        return (((int) (f * 255.0f)) << 8) | ((int) (f2 * 255.0f));
    }

    public static int rgb565(float f, float f2, float f3) {
        return (((int) (f * 31.0f)) << 11) | (((int) (f2 * 63.0f)) << 5) | ((int) (f3 * 31.0f));
    }

    public static int rgb565(com.badlogic.gdx.graphics.Color color) {
        return ((int) (color.b * 31.0f)) | (((int) (color.r * 31.0f)) << 11) | (((int) (color.g * 63.0f)) << 5);
    }

    public static void rgb565ToColor(com.badlogic.gdx.graphics.Color color, int i) {
        color.r = ((63488 & i) >>> 11) / 31.0f;
        color.g = ((i & 2016) >>> 5) / 63.0f;
        color.b = ((i & 31) >>> 0) / 31.0f;
    }

    public static int rgb888(float f, float f2, float f3) {
        return (((int) (f * 255.0f)) << 16) | (((int) (f2 * 255.0f)) << 8) | ((int) (f3 * 255.0f));
    }

    public static int rgb888(com.badlogic.gdx.graphics.Color color) {
        return ((int) (color.b * 255.0f)) | (((int) (color.r * 255.0f)) << 16) | (((int) (color.g * 255.0f)) << 8);
    }

    public static void rgb888ToColor(com.badlogic.gdx.graphics.Color color, int i) {
        color.r = ((16711680 & i) >>> 16) / 255.0f;
        color.g = ((65280 & i) >>> 8) / 255.0f;
        color.b = (i & 255) / 255.0f;
    }

    public static int rgba4444(float f, float f2, float f3, float f4) {
        return (((int) (f * 15.0f)) << 12) | (((int) (f2 * 15.0f)) << 8) | (((int) (f3 * 15.0f)) << 4) | ((int) (f4 * 15.0f));
    }

    public static int rgba4444(com.badlogic.gdx.graphics.Color color) {
        return ((int) (color.a * 15.0f)) | (((int) (color.r * 15.0f)) << 12) | (((int) (color.g * 15.0f)) << 8) | (((int) (color.b * 15.0f)) << 4);
    }

    public static void rgba4444ToColor(com.badlogic.gdx.graphics.Color color, int i) {
        color.r = ((61440 & i) >>> 12) / 15.0f;
        color.g = ((i & 3840) >>> 8) / 15.0f;
        color.b = ((i & 240) >>> 4) / 15.0f;
        color.a = (i & 15) / 15.0f;
    }

    public static int rgba8888(float f, float f2, float f3, float f4) {
        return (((int) (f * 255.0f)) << 24) | (((int) (f2 * 255.0f)) << 16) | (((int) (f3 * 255.0f)) << 8) | ((int) (f4 * 255.0f));
    }

    public static int rgba8888(com.badlogic.gdx.graphics.Color color) {
        return ((int) (color.a * 255.0f)) | (((int) (color.r * 255.0f)) << 24) | (((int) (color.g * 255.0f)) << 16) | (((int) (color.b * 255.0f)) << 8);
    }

    public static void rgba8888ToColor(com.badlogic.gdx.graphics.Color color, int i) {
        color.r = (((-16777216) & i) >>> 24) / 255.0f;
        color.g = ((16711680 & i) >>> 16) / 255.0f;
        color.b = ((65280 & i) >>> 8) / 255.0f;
        color.a = (i & 255) / 255.0f;
    }

    public static float toFloatBits(float f, float f2, float f3, float f4) {
        return com.badlogic.gdx.utils.NumberUtils.intToFloatColor(((int) (f * 255.0f)) | (((int) (f2 * 255.0f)) << 8) | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24));
    }

    public static float toFloatBits(int i, int i2, int i3, int i4) {
        return com.badlogic.gdx.utils.NumberUtils.intToFloatColor(i | (i2 << 8) | (i3 << 16) | (i4 << 24));
    }

    public static int toIntBits(int i, int i2, int i3, int i4) {
        return i | (i2 << 8) | (i3 << 16) | (i4 << 24);
    }

    public static com.badlogic.gdx.graphics.Color valueOf(java.lang.String str) {
        if (str.charAt(0) == '#') {
            str = str.substring(1);
        }
        return new com.badlogic.gdx.graphics.Color(java.lang.Integer.valueOf(str.substring(0, 2), 16).intValue() / 255.0f, java.lang.Integer.valueOf(str.substring(2, 4), 16).intValue() / 255.0f, java.lang.Integer.valueOf(str.substring(4, 6), 16).intValue() / 255.0f, (str.length() != 8 ? 255 : java.lang.Integer.valueOf(str.substring(6, 8), 16).intValue()) / 255.0f);
    }

    public com.badlogic.gdx.graphics.Color add(float f, float f2, float f3, float f4) {
        this.r += f;
        this.g += f2;
        this.b += f3;
        this.a += f4;
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color add(com.badlogic.gdx.graphics.Color color) {
        this.r += color.r;
        this.g += color.g;
        this.b += color.b;
        this.a += color.a;
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color clamp() {
        float f = this.r;
        if (f < 0.0f) {
            this.r = 0.0f;
        } else if (f > 1.0f) {
            this.r = 1.0f;
        }
        float f2 = this.g;
        if (f2 < 0.0f) {
            this.g = 0.0f;
        } else if (f2 > 1.0f) {
            this.g = 1.0f;
        }
        float f3 = this.b;
        if (f3 < 0.0f) {
            this.b = 0.0f;
        } else if (f3 > 1.0f) {
            this.b = 1.0f;
        }
        float f4 = this.a;
        if (f4 < 0.0f) {
            this.a = 0.0f;
        } else if (f4 > 1.0f) {
            this.a = 1.0f;
        }
        return this;
    }

    public com.badlogic.gdx.graphics.Color cpy() {
        return new com.badlogic.gdx.graphics.Color(this);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && toIntBits() == ((com.badlogic.gdx.graphics.Color) obj).toIntBits();
    }

    public int hashCode() {
        float f = this.r;
        int floatToIntBits = (f != 0.0f ? com.badlogic.gdx.utils.NumberUtils.floatToIntBits(f) : 0) * 31;
        float f2 = this.g;
        int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? com.badlogic.gdx.utils.NumberUtils.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.b;
        int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? com.badlogic.gdx.utils.NumberUtils.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.a;
        return floatToIntBits3 + (f4 != 0.0f ? com.badlogic.gdx.utils.NumberUtils.floatToIntBits(f4) : 0);
    }

    public com.badlogic.gdx.graphics.Color lerp(float f, float f2, float f3, float f4, float f5) {
        float f6 = this.r;
        this.r = f6 + ((f - f6) * f5);
        float f7 = this.g;
        this.g = f7 + ((f2 - f7) * f5);
        float f8 = this.b;
        this.b = f8 + ((f3 - f8) * f5);
        float f9 = this.a;
        this.a = f9 + (f5 * (f4 - f9));
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color lerp(com.badlogic.gdx.graphics.Color color, float f) {
        float f2 = this.r;
        this.r = f2 + ((color.r - f2) * f);
        float f3 = this.g;
        this.g = f3 + ((color.g - f3) * f);
        float f4 = this.b;
        this.b = f4 + ((color.b - f4) * f);
        float f5 = this.a;
        this.a = f5 + (f * (color.a - f5));
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color mul(float f) {
        this.r *= f;
        this.g *= f;
        this.b *= f;
        this.a *= f;
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color mul(float f, float f2, float f3, float f4) {
        this.r *= f;
        this.g *= f2;
        this.b *= f3;
        this.a *= f4;
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color mul(com.badlogic.gdx.graphics.Color color) {
        this.r *= color.r;
        this.g *= color.g;
        this.b *= color.b;
        this.a *= color.a;
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color premultiplyAlpha() {
        float f = this.r;
        float f2 = this.a;
        this.r = f * f2;
        this.g *= f2;
        this.b *= f2;
        return this;
    }

    public com.badlogic.gdx.graphics.Color set(float f, float f2, float f3, float f4) {
        this.r = f;
        this.g = f2;
        this.b = f3;
        this.a = f4;
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color set(int i) {
        rgba8888ToColor(this, i);
        return this;
    }

    public com.badlogic.gdx.graphics.Color set(com.badlogic.gdx.graphics.Color color) {
        this.r = color.r;
        this.g = color.g;
        this.b = color.b;
        this.a = color.a;
        return this;
    }

    public com.badlogic.gdx.graphics.Color sub(float f, float f2, float f3, float f4) {
        this.r -= f;
        this.g -= f2;
        this.b -= f3;
        this.a -= f4;
        return clamp();
    }

    public com.badlogic.gdx.graphics.Color sub(com.badlogic.gdx.graphics.Color color) {
        this.r -= color.r;
        this.g -= color.g;
        this.b -= color.b;
        this.a -= color.a;
        return clamp();
    }

    public float toFloatBits() {
        return com.badlogic.gdx.utils.NumberUtils.intToFloatColor((((int) (this.a * 255.0f)) << 24) | (((int) (this.b * 255.0f)) << 16) | (((int) (this.g * 255.0f)) << 8) | ((int) (this.r * 255.0f)));
    }

    public int toIntBits() {
        return (((int) (this.a * 255.0f)) << 24) | (((int) (this.b * 255.0f)) << 16) | (((int) (this.g * 255.0f)) << 8) | ((int) (this.r * 255.0f));
    }

    public java.lang.String toString() {
        java.lang.String hexString = java.lang.Integer.toHexString((((int) (this.r * 255.0f)) << 24) | (((int) (this.g * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f)));
        while (hexString.length() < 8) {
            hexString = "0" + hexString;
        }
        return hexString;
    }
}
