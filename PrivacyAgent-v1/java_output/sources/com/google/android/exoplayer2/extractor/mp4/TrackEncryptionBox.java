package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
public final class TrackEncryptionBox {
    public final com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData;

    @androidx.annotation.Nullable
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;

    @androidx.annotation.Nullable
    public final java.lang.String schemeType;

    public TrackEncryptionBox(boolean z, @androidx.annotation.Nullable java.lang.String str, int i, byte[] bArr, int i2, int i3, @androidx.annotation.Nullable byte[] bArr2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((bArr2 == null) ^ (i == 0));
        this.isEncrypted = z;
        this.schemeType = str;
        this.perSampleIvSize = i;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData(a(str), bArr, i2, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return 1;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 2;
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 68);
                sb.append("Unsupported protection scheme type '");
                sb.append(str);
                sb.append("'. Assuming AES-CTR crypto mode.");
                com.google.android.exoplayer2.util.Log.w("TrackEncryptionBox", sb.toString());
            case 2:
            case 3:
                return 1;
        }
    }
}
