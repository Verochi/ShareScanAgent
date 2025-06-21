package com.anythink.expressad.exoplayer.d;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public final class k implements com.anythink.expressad.exoplayer.d.i {
    private final android.media.MediaCrypto a;
    private final boolean b;

    private k(android.media.MediaCrypto mediaCrypto) {
        this(mediaCrypto, false);
    }

    public k(android.media.MediaCrypto mediaCrypto, boolean z) {
        this.a = (android.media.MediaCrypto) com.anythink.expressad.exoplayer.k.a.a(mediaCrypto);
        this.b = z;
    }

    public final android.media.MediaCrypto a() {
        return this.a;
    }

    @Override // com.anythink.expressad.exoplayer.d.i
    public final boolean a(java.lang.String str) {
        return !this.b && this.a.requiresSecureDecoderComponent(str);
    }
}
