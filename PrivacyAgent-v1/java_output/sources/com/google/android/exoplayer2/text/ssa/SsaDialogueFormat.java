package com.google.android.exoplayer2.text.ssa;

/* loaded from: classes22.dex */
final class SsaDialogueFormat {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public SsaDialogueFormat(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.text.ssa.SsaDialogueFormat a(java.lang.String str) {
        char c;
        com.google.android.exoplayer2.util.Assertions.checkArgument(str.startsWith("Format:"));
        java.lang.String[] split = android.text.TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < split.length; i5++) {
            java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(split[i5].trim());
            lowerInvariant.hashCode();
            switch (lowerInvariant.hashCode()) {
                case 100571:
                    if (lowerInvariant.equals("end")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3556653:
                    if (lowerInvariant.equals("text")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (lowerInvariant.equals(com.anythink.expressad.foundation.d.c.bT)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (lowerInvariant.equals(com.anythink.expressad.foundation.h.i.e)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    i2 = i5;
                    break;
                case 1:
                    i4 = i5;
                    break;
                case 2:
                    i = i5;
                    break;
                case 3:
                    i3 = i5;
                    break;
            }
        }
        if (i == -1 || i2 == -1) {
            return null;
        }
        return new com.google.android.exoplayer2.text.ssa.SsaDialogueFormat(i, i2, i3, i4, split.length);
    }
}
