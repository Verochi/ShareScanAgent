package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ju.jad_dq<java.nio.ByteBuffer> {
    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_an(byteBuffer, file);
    }

    public boolean jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull java.io.File file) {
        try {
            com.jd.ad.sdk.jad_ir.jad_an.jad_an(byteBuffer, file);
            return true;
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable("ByteBufferEncoder", 3)) {
                com.jd.ad.sdk.logger.Logger.d("ByteBufferEncoder", "Failed to write data", e);
            }
            return false;
        }
    }
}
