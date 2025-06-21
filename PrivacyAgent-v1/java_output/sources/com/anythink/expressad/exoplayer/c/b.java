package com.anythink.expressad.exoplayer.c;

/* loaded from: classes12.dex */
public final class b {
    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final android.media.MediaCodec.CryptoInfo i;
    private final com.anythink.expressad.exoplayer.c.b.a j;

    @android.annotation.TargetApi(24)
    public static final class a {
        private final android.media.MediaCodec.CryptoInfo a;
        private final android.media.MediaCodec.CryptoInfo.Pattern b;

        private a(android.media.MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.b = new android.media.MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        public /* synthetic */ a(android.media.MediaCodec.CryptoInfo cryptoInfo, byte b) {
            this(cryptoInfo);
        }

        private void a(int i, int i2) {
            this.b.set(i, i2);
            this.a.setPattern(this.b);
        }

        public static /* synthetic */ void a(com.anythink.expressad.exoplayer.c.b.a aVar, int i, int i2) {
            aVar.b.set(i, i2);
            aVar.a.setPattern(aVar.b);
        }
    }

    public b() {
        int i = com.anythink.expressad.exoplayer.k.af.a;
        android.media.MediaCodec.CryptoInfo cryptoInfo = i >= 16 ? new android.media.MediaCodec.CryptoInfo() : null;
        this.i = cryptoInfo;
        this.j = i >= 24 ? new com.anythink.expressad.exoplayer.c.b.a(cryptoInfo, (byte) 0) : null;
    }

    @android.annotation.TargetApi(16)
    private static android.media.MediaCodec.CryptoInfo b() {
        return new android.media.MediaCodec.CryptoInfo();
    }

    @android.annotation.TargetApi(16)
    private void c() {
        android.media.MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = this.f;
        cryptoInfo.numBytesOfClearData = this.d;
        cryptoInfo.numBytesOfEncryptedData = this.e;
        cryptoInfo.key = this.b;
        cryptoInfo.iv = this.a;
        cryptoInfo.mode = this.c;
        if (com.anythink.expressad.exoplayer.k.af.a >= 24) {
            com.anythink.expressad.exoplayer.c.b.a.a(this.j, this.g, this.h);
        }
    }

    @android.annotation.TargetApi(16)
    public final android.media.MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.a = bArr2;
        this.c = i2;
        this.g = i3;
        this.h = i4;
        int i5 = com.anythink.expressad.exoplayer.k.af.a;
        if (i5 >= 16) {
            android.media.MediaCodec.CryptoInfo cryptoInfo = this.i;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i2;
            if (i5 >= 24) {
                com.anythink.expressad.exoplayer.c.b.a.a(this.j, i3, i4);
            }
        }
    }
}
