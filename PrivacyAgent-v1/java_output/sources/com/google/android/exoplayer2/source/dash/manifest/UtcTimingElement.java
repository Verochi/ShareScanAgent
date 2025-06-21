package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public final class UtcTimingElement {
    public final java.lang.String schemeIdUri;
    public final java.lang.String value;

    public UtcTimingElement(java.lang.String str, java.lang.String str2) {
        this.schemeIdUri = str;
        this.value = str2;
    }

    public java.lang.String toString() {
        java.lang.String str = this.schemeIdUri;
        java.lang.String str2 = this.value;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 2 + java.lang.String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        return sb.toString();
    }
}
