package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
final class HtmlUtils {
    public static java.lang.String a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 5 + java.lang.String.valueOf(str).length());
        sb.append(".");
        sb.append(str);
        sb.append(",.");
        sb.append(str);
        sb.append(" *");
        return sb.toString();
    }

    public static java.lang.String b(@androidx.annotation.ColorInt int i) {
        return com.google.android.exoplayer2.util.Util.formatInvariant("rgba(%d,%d,%d,%.3f)", java.lang.Integer.valueOf(android.graphics.Color.red(i)), java.lang.Integer.valueOf(android.graphics.Color.green(i)), java.lang.Integer.valueOf(android.graphics.Color.blue(i)), java.lang.Double.valueOf(android.graphics.Color.alpha(i) / 255.0d));
    }
}
