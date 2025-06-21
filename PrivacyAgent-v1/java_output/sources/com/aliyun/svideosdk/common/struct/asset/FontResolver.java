package com.aliyun.svideosdk.common.struct.asset;

/* loaded from: classes12.dex */
public interface FontResolver {
    public static final int DEFAULT_FONT = 10002;
    public static final int DEFAULT_FONT_2 = 10003;
    public static final int DEFAULT_FONT_3 = 10004;
    public static final int SYSTEM_FONT = 10001;

    long getFontIdValue(long j);

    int getFontType(long j);

    android.graphics.Typeface getTypeface(long j);

    android.graphics.Typeface getTypefaceByFont(long j);

    boolean isFontExit(long j);

    void removeFontById(java.lang.Long l);

    void saveFontString(java.lang.Long l, java.lang.Long l2, java.lang.Integer num);
}
