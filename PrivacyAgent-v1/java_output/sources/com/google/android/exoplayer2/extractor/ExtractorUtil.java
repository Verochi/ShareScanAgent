package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
final class ExtractorUtil {
    public static int a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = 0;
        while (i3 < i2) {
            int peek = extractorInput.peek(bArr, i + i3, i2 - i3);
            if (peek == -1) {
                break;
            }
            i3 += peek;
        }
        return i3;
    }
}
