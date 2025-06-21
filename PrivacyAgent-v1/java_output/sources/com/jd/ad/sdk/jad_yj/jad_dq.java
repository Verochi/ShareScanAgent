package com.jd.ad.sdk.jad_yj;

/* loaded from: classes23.dex */
public class jad_dq implements com.jd.ad.sdk.jad_yj.jad_er<com.jd.ad.sdk.jad_xi.jad_cp, byte[]> {
    @Override // com.jd.ad.sdk.jad_yj.jad_er
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_mx.jad_xk<byte[]> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<com.jd.ad.sdk.jad_xi.jad_cp> jad_xkVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        byte[] bArr;
        java.nio.ByteBuffer asReadOnlyBuffer = jad_xkVar.get().jad_an.jad_an.jad_an.jad_er().asReadOnlyBuffer();
        java.util.concurrent.atomic.AtomicReference<byte[]> atomicReference = com.jd.ad.sdk.jad_ir.jad_an.jad_an;
        com.jd.ad.sdk.jad_ir.jad_an.jad_bo jad_boVar = (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) ? null : new com.jd.ad.sdk.jad_ir.jad_an.jad_bo(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
        if (jad_boVar != null && jad_boVar.jad_an == 0 && jad_boVar.jad_bo == jad_boVar.jad_cp.length) {
            bArr = asReadOnlyBuffer.array();
        } else {
            java.nio.ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
            asReadOnlyBuffer2.get(bArr2);
            bArr = bArr2;
        }
        return new com.jd.ad.sdk.jad_uf.jad_bo(bArr);
    }
}
