package com.google.android.exoplayer2.text.span;

/* loaded from: classes22.dex */
public final class RubySpan {
    public static final int POSITION_OVER = 1;
    public static final int POSITION_UNDER = 2;
    public static final int POSITION_UNKNOWN = -1;
    public final int position;
    public final java.lang.String rubyText;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Position {
    }

    public RubySpan(java.lang.String str, int i) {
        this.rubyText = str;
        this.position = i;
    }
}
