package com.google.common.primitives;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class ParseRequest {
    public final java.lang.String a;
    public final int b;

    public ParseRequest(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static com.google.common.primitives.ParseRequest a(java.lang.String str) {
        if (str.length() == 0) {
            throw new java.lang.NumberFormatException("empty string");
        }
        char charAt = str.charAt(0);
        int i = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (charAt == '#') {
            str = str.substring(1);
        } else if (charAt != '0' || str.length() <= 1) {
            i = 10;
        } else {
            str = str.substring(1);
            i = 8;
        }
        return new com.google.common.primitives.ParseRequest(str, i);
    }
}
