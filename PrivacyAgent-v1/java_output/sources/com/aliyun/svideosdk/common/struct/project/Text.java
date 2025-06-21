package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class Text {
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public long fontId = -1;
    public boolean hasTextLabel;
    public float maxTextSize;
    public java.lang.String text;
    public int textAlignment;
    public int textColor;
    public int textHeight;
    public int textLabelColor;
    public int textStrokeColor;
    public int textWidth;

    public android.text.Layout.Alignment getTextAlignment() {
        int i = this.textAlignment;
        return i != 0 ? i != 2 ? android.text.Layout.Alignment.ALIGN_CENTER : android.text.Layout.Alignment.ALIGN_OPPOSITE : android.text.Layout.Alignment.ALIGN_NORMAL;
    }
}
