package com.airbnb.lottie.parser.moshi;

/* loaded from: classes.dex */
final class JsonScope {
    public static java.lang.String a(int i, int[] iArr, java.lang.String[] strArr, int[] iArr2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(kotlin.text.Typography.dollar);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(iArr2[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                java.lang.String str = strArr[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
