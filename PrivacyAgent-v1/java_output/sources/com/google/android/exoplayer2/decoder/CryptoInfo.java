package com.google.android.exoplayer2.decoder;

/* loaded from: classes22.dex */
public final class CryptoInfo {
    public final android.media.MediaCodec.CryptoInfo a;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.decoder.CryptoInfo.PatternHolderV24 b;
    public int clearBlocks;
    public int encryptedBlocks;

    @androidx.annotation.Nullable
    public byte[] iv;

    @androidx.annotation.Nullable
    public byte[] key;
    public int mode;

    @androidx.annotation.Nullable
    public int[] numBytesOfClearData;

    @androidx.annotation.Nullable
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    @androidx.annotation.RequiresApi(24)
    public static final class PatternHolderV24 {
        public final android.media.MediaCodec.CryptoInfo a;
        public final android.media.MediaCodec.CryptoInfo.Pattern b;

        public PatternHolderV24(android.media.MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.b = new android.media.MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        public /* synthetic */ PatternHolderV24(android.media.MediaCodec.CryptoInfo cryptoInfo, com.google.android.exoplayer2.decoder.CryptoInfo.AnonymousClass1 anonymousClass1) {
            this(cryptoInfo);
        }

        public final void b(int i, int i2) {
            this.b.set(i, i2);
            this.a.setPattern(this.b);
        }
    }

    public CryptoInfo() {
        android.media.MediaCodec.CryptoInfo cryptoInfo = new android.media.MediaCodec.CryptoInfo();
        this.a = cryptoInfo;
        this.b = com.google.android.exoplayer2.util.Util.SDK_INT >= 24 ? new com.google.android.exoplayer2.decoder.CryptoInfo.PatternHolderV24(cryptoInfo, null) : null;
    }

    public android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.a;
    }

    @java.lang.Deprecated
    public android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return getFrameworkCryptoInfo();
    }

    public void increaseClearDataFirstSubSampleBy(int i) {
        if (i == 0) {
            return;
        }
        if (this.numBytesOfClearData == null) {
            int[] iArr = new int[1];
            this.numBytesOfClearData = iArr;
            this.a.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.numBytesOfClearData;
        iArr2[0] = iArr2[0] + i;
    }

    public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        android.media.MediaCodec.CryptoInfo cryptoInfo = this.a;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 24) {
            ((com.google.android.exoplayer2.decoder.CryptoInfo.PatternHolderV24) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b)).b(i3, i4);
        }
    }
}
