package com.anythink.expressad.exoplayer.f;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public final class e {
    private e() {
    }

    private static void a(android.media.MediaFormat mediaFormat, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.l.b bVar) {
        if (bVar != null) {
            a(mediaFormat, "color-transfer", bVar.c);
            a(mediaFormat, "color-standard", bVar.a);
            a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", java.nio.ByteBuffer.wrap(bArr));
            }
        }
    }

    private static void a(android.media.MediaFormat mediaFormat, java.lang.String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void a(android.media.MediaFormat mediaFormat, java.lang.String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    private static void a(android.media.MediaFormat mediaFormat, java.lang.String str, java.lang.String str2) {
        mediaFormat.setString(str, str2);
    }

    private static void a(android.media.MediaFormat mediaFormat, java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, java.nio.ByteBuffer.wrap(bArr));
        }
    }

    public static void a(android.media.MediaFormat mediaFormat, java.util.List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer("csd-".concat(java.lang.String.valueOf(i)), java.nio.ByteBuffer.wrap(list.get(i)));
        }
    }
}
