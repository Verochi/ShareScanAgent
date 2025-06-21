package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
public final class WebvttCssStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;

    @androidx.annotation.ColorInt
    public int f;
    public int h;
    public float o;
    public java.lang.String a = "";
    public java.lang.String b = "";
    public java.util.Set<java.lang.String> c = java.util.Collections.emptySet();
    public java.lang.String d = "";

    @androidx.annotation.Nullable
    public java.lang.String e = null;
    public boolean g = false;
    public boolean i = false;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int p = -1;
    public boolean q = false;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public static int a(int i, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    public int getBackgroundColor() {
        if (this.i) {
            return this.h;
        }
        throw new java.lang.IllegalStateException("Background color not defined.");
    }

    public boolean getCombineUpright() {
        return this.q;
    }

    public int getFontColor() {
        if (this.g) {
            return this.f;
        }
        throw new java.lang.IllegalStateException("Font color not defined");
    }

    @androidx.annotation.Nullable
    public java.lang.String getFontFamily() {
        return this.e;
    }

    public float getFontSize() {
        return this.o;
    }

    public int getFontSizeUnit() {
        return this.n;
    }

    public int getRubyPosition() {
        return this.p;
    }

    public int getSpecificityScore(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, java.util.Set<java.lang.String> set, @androidx.annotation.Nullable java.lang.String str3) {
        if (this.a.isEmpty() && this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty()) {
            return android.text.TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int a = a(a(a(0, this.a, str, 1073741824), this.b, str2, 2), this.d, str3, 4);
        if (a == -1 || !set.containsAll(this.c)) {
            return 0;
        }
        return a + (this.c.size() * 4);
    }

    public int getStyle() {
        int i = this.l;
        if (i == -1 && this.m == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.m == 1 ? 2 : 0);
    }

    public boolean hasBackgroundColor() {
        return this.i;
    }

    public boolean hasFontColor() {
        return this.g;
    }

    public boolean isLinethrough() {
        return this.j == 1;
    }

    public boolean isUnderline() {
        return this.k == 1;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setBackgroundColor(int i) {
        this.h = i;
        this.i = true;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setBold(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setCombineUpright(boolean z) {
        this.q = z;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontColor(int i) {
        this.f = i;
        this.g = true;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontFamily(@androidx.annotation.Nullable java.lang.String str) {
        this.e = com.google.android.exoplayer2.util.Util.toLowerInvariant(str);
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontSize(float f) {
        this.o = f;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setFontSizeUnit(short s2) {
        this.n = s2;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setItalic(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setLinethrough(boolean z) {
        this.j = z ? 1 : 0;
        return this;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setRubyPosition(int i) {
        this.p = i;
        return this;
    }

    public void setTargetClasses(java.lang.String[] strArr) {
        this.c = new java.util.HashSet(java.util.Arrays.asList(strArr));
    }

    public void setTargetId(java.lang.String str) {
        this.a = str;
    }

    public void setTargetTagName(java.lang.String str) {
        this.b = str;
    }

    public void setTargetVoice(java.lang.String str) {
        this.d = str;
    }

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle setUnderline(boolean z) {
        this.k = z ? 1 : 0;
        return this;
    }
}
