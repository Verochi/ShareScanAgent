package com.otaliastudios.cameraview.internal;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public class RotationHelper {
    public static byte[] rotate(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, int i) {
        if (i == 0) {
            return bArr;
        }
        if (i % 90 != 0 || i < 0 || i > 270) {
            throw new java.lang.IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
        }
        int width = size.getWidth();
        int height = size.getHeight();
        byte[] bArr2 = new byte[bArr.length];
        int i2 = width * height;
        boolean z = i % 180 != 0;
        boolean z2 = i % 270 != 0;
        boolean z3 = i >= 180;
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                int i5 = (i3 * width) + i4;
                int i6 = ((i3 >> 1) * width) + i2 + (i4 & (-2));
                int i7 = i6 + 1;
                int i8 = z ? height : width;
                int i9 = z ? width : height;
                int i10 = z ? i3 : i4;
                int i11 = z ? i4 : i3;
                if (z2) {
                    i10 = (i8 - i10) - 1;
                }
                if (z3) {
                    i11 = (i9 - i11) - 1;
                }
                int i12 = (i11 * i8) + i10;
                int i13 = i2 + ((i11 >> 1) * i8) + (i10 & (-2));
                bArr2[i12] = (byte) (bArr[i5] & 255);
                bArr2[i13] = (byte) (bArr[i6] & 255);
                bArr2[i13 + 1] = (byte) (bArr[i7] & 255);
            }
        }
        return bArr2;
    }
}
