package com.google.common.base;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Utf8 {
    public static int a(java.lang.CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (java.lang.Character.codePointAt(charSequence, i) == charAt) {
                        throw new java.lang.IllegalArgumentException(c(i));
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    public static boolean b(byte[] bArr, int i, int i2) {
        byte b;
        while (i < i2) {
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i3 != i2 && b2 >= -62) {
                        i = i3 + 1;
                        if (bArr[i3] > -65) {
                        }
                    }
                    return false;
                }
                if (b2 < -16) {
                    int i4 = i3 + 1;
                    if (i4 < i2 && (b = bArr[i3]) <= -65 && ((b2 != -32 || b >= -96) && (b2 != -19 || -96 > b))) {
                        i = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return false;
                }
                if (i3 + 2 >= i2) {
                    return false;
                }
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                if (b3 <= -65 && (((b2 << com.google.common.base.Ascii.FS) + (b3 + 112)) >> 30) == 0) {
                    int i6 = i5 + 1;
                    if (bArr[i5] <= -65) {
                        i3 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                }
                return false;
            }
            i = i3;
        }
        return true;
    }

    public static java.lang.String c(int i) {
        return "Unpaired surrogate at index " + i;
    }

    public static int encodedLength(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += a(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new java.lang.IllegalArgumentException("UTF-8 length does not fit in int: " + (i2 + tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT));
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormed(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        com.google.common.base.Preconditions.checkPositionIndexes(i, i3, bArr.length);
        while (i < i3) {
            if (bArr[i] < 0) {
                return b(bArr, i, i3);
            }
            i++;
        }
        return true;
    }
}
