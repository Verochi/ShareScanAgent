package com.google.android.exoplayer2.text;

/* loaded from: classes22.dex */
public final class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = -3.4028235E38f;
    public static final com.google.android.exoplayer2.text.Cue EMPTY = new com.google.android.exoplayer2.text.Cue.Builder().setText("").build();
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public static final int VERTICAL_TYPE_LR = 2;
    public static final int VERTICAL_TYPE_RL = 1;

    @androidx.annotation.Nullable
    public final android.graphics.Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;

    @androidx.annotation.Nullable
    public final java.lang.CharSequence text;

    @androidx.annotation.Nullable
    public final android.text.Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    public static final class Builder {

        @androidx.annotation.Nullable
        public java.lang.CharSequence a;

        @androidx.annotation.Nullable
        public android.graphics.Bitmap b;

        @androidx.annotation.Nullable
        public android.text.Layout.Alignment c;
        public float d;
        public int e;
        public int f;
        public float g;
        public int h;
        public int i;
        public float j;
        public float k;
        public float l;
        public boolean m;

        @androidx.annotation.ColorInt
        public int n;
        public int o;

        public Builder() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = -3.4028235E38f;
            this.e = Integer.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.g = -3.4028235E38f;
            this.h = Integer.MIN_VALUE;
            this.i = Integer.MIN_VALUE;
            this.j = -3.4028235E38f;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = false;
            this.n = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
            this.o = Integer.MIN_VALUE;
        }

        public Builder(com.google.android.exoplayer2.text.Cue cue) {
            this.a = cue.text;
            this.b = cue.bitmap;
            this.c = cue.textAlignment;
            this.d = cue.line;
            this.e = cue.lineType;
            this.f = cue.lineAnchor;
            this.g = cue.position;
            this.h = cue.positionAnchor;
            this.i = cue.textSizeType;
            this.j = cue.textSize;
            this.k = cue.size;
            this.l = cue.bitmapHeight;
            this.m = cue.windowColorSet;
            this.n = cue.windowColor;
            this.o = cue.verticalType;
        }

        public /* synthetic */ Builder(com.google.android.exoplayer2.text.Cue cue, com.google.android.exoplayer2.text.Cue.AnonymousClass1 anonymousClass1) {
            this(cue);
        }

        public com.google.android.exoplayer2.text.Cue build() {
            return new com.google.android.exoplayer2.text.Cue(this.a, this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, null);
        }

        public com.google.android.exoplayer2.text.Cue.Builder clearWindowColor() {
            this.m = false;
            return this;
        }

        @androidx.annotation.Nullable
        public android.graphics.Bitmap getBitmap() {
            return this.b;
        }

        public float getBitmapHeight() {
            return this.l;
        }

        public float getLine() {
            return this.d;
        }

        public int getLineAnchor() {
            return this.f;
        }

        public int getLineType() {
            return this.e;
        }

        public float getPosition() {
            return this.g;
        }

        public int getPositionAnchor() {
            return this.h;
        }

        public float getSize() {
            return this.k;
        }

        @androidx.annotation.Nullable
        public java.lang.CharSequence getText() {
            return this.a;
        }

        @androidx.annotation.Nullable
        public android.text.Layout.Alignment getTextAlignment() {
            return this.c;
        }

        public float getTextSize() {
            return this.j;
        }

        public int getTextSizeType() {
            return this.i;
        }

        public int getVerticalType() {
            return this.o;
        }

        @androidx.annotation.ColorInt
        public int getWindowColor() {
            return this.n;
        }

        public boolean isWindowColorSet() {
            return this.m;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setBitmap(android.graphics.Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setBitmapHeight(float f) {
            this.l = f;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setLine(float f, int i) {
            this.d = f;
            this.e = i;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setLineAnchor(int i) {
            this.f = i;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setPosition(float f) {
            this.g = f;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setPositionAnchor(int i) {
            this.h = i;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setSize(float f) {
            this.k = f;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setText(java.lang.CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setTextAlignment(@androidx.annotation.Nullable android.text.Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setTextSize(float f, int i) {
            this.j = f;
            this.i = i;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setVerticalType(int i) {
            this.o = i;
            return this;
        }

        public com.google.android.exoplayer2.text.Cue.Builder setWindowColor(@androidx.annotation.ColorInt int i) {
            this.n = i;
            this.m = true;
            return this;
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    @java.lang.Deprecated
    public Cue(java.lang.CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    @java.lang.Deprecated
    public Cue(java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.text.Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
    }

    @java.lang.Deprecated
    public Cue(java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.text.Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, i4, f4, f3, -3.4028235E38f, false, androidx.core.view.ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE);
    }

    @java.lang.Deprecated
    public Cue(java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.text.Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z, i4, Integer.MIN_VALUE);
    }

    public Cue(@androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.text.Layout.Alignment alignment, @androidx.annotation.Nullable android.graphics.Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6) {
        if (charSequence == null) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(bitmap);
        } else {
            com.google.android.exoplayer2.util.Assertions.checkArgument(bitmap == null);
        }
        this.text = charSequence;
        this.textAlignment = alignment;
        this.bitmap = bitmap;
        this.line = f;
        this.lineType = i;
        this.lineAnchor = i2;
        this.position = f2;
        this.positionAnchor = i3;
        this.size = f4;
        this.bitmapHeight = f5;
        this.windowColorSet = z;
        this.windowColor = i5;
        this.textSizeType = i4;
        this.textSize = f3;
        this.verticalType = i6;
    }

    public /* synthetic */ Cue(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, android.graphics.Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, com.google.android.exoplayer2.text.Cue.AnonymousClass1 anonymousClass1) {
        this(charSequence, alignment, bitmap, f, i, i2, f2, i3, i4, f3, f4, f5, z, i5, i6);
    }

    public com.google.android.exoplayer2.text.Cue.Builder buildUpon() {
        return new com.google.android.exoplayer2.text.Cue.Builder(this, null);
    }
}
