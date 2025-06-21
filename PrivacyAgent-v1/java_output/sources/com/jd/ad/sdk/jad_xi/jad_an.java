package com.jd.ad.sdk.jad_xi;

/* loaded from: classes23.dex */
public class jad_an implements com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, com.jd.ad.sdk.jad_xi.jad_cp> {
    public static final com.jd.ad.sdk.jad_xi.jad_an.C0414jad_an jad_fs = new com.jd.ad.sdk.jad_xi.jad_an.C0414jad_an();
    public static final com.jd.ad.sdk.jad_xi.jad_an.jad_bo jad_jt = new com.jd.ad.sdk.jad_xi.jad_an.jad_bo();
    public final android.content.Context jad_an;
    public final java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_bo;
    public final com.jd.ad.sdk.jad_xi.jad_an.jad_bo jad_cp;
    public final com.jd.ad.sdk.jad_xi.jad_an.C0414jad_an jad_dq;
    public final com.jd.ad.sdk.jad_xi.jad_bo jad_er;

    @androidx.annotation.VisibleForTesting
    /* renamed from: com.jd.ad.sdk.jad_xi.jad_an$jad_an, reason: collision with other inner class name */
    public static class C0414jad_an {
    }

    @androidx.annotation.VisibleForTesting
    public static class jad_bo {
        public final java.util.Queue<com.jd.ad.sdk.jad_it.jad_dq> jad_an = com.jd.ad.sdk.jad_ir.jad_ly.jad_an(0);
    }

    public jad_an(android.content.Context context, java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this(context, list, jad_erVar, jad_boVar, jad_jt, jad_fs);
    }

    @androidx.annotation.VisibleForTesting
    public jad_an(android.content.Context context, java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, com.jd.ad.sdk.jad_xi.jad_an.jad_bo jad_boVar2, com.jd.ad.sdk.jad_xi.jad_an.C0414jad_an c0414jad_an) {
        this.jad_an = context.getApplicationContext();
        this.jad_bo = list;
        this.jad_dq = c0414jad_an;
        this.jad_er = new com.jd.ad.sdk.jad_xi.jad_bo(jad_erVar, jad_boVar);
        this.jad_cp = jad_boVar2;
    }

    public static int jad_an(com.jd.ad.sdk.jad_it.jad_cp jad_cpVar, int i, int i2) {
        int min = java.lang.Math.min(jad_cpVar.jad_jt / i2, jad_cpVar.jad_fs / i);
        int max = java.lang.Math.max(1, min == 0 ? 0 : java.lang.Integer.highestOneBit(min));
        if (android.util.Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            com.jd.ad.sdk.logger.Logger.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + jad_cpVar.jad_fs + "x" + jad_cpVar.jad_jt + "]");
        }
        return max;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<com.jd.ad.sdk.jad_xi.jad_cp> jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_it.jad_dq jad_dqVar;
        java.nio.ByteBuffer byteBuffer2 = byteBuffer;
        com.jd.ad.sdk.jad_xi.jad_an.jad_bo jad_boVar = this.jad_cp;
        synchronized (jad_boVar) {
            com.jd.ad.sdk.jad_it.jad_dq poll = jad_boVar.jad_an.poll();
            if (poll == null) {
                poll = new com.jd.ad.sdk.jad_it.jad_dq();
            }
            jad_dqVar = poll;
            jad_dqVar.jad_bo = null;
            java.util.Arrays.fill(jad_dqVar.jad_an, (byte) 0);
            jad_dqVar.jad_cp = new com.jd.ad.sdk.jad_it.jad_cp();
            jad_dqVar.jad_dq = 0;
            java.nio.ByteBuffer asReadOnlyBuffer = byteBuffer2.asReadOnlyBuffer();
            jad_dqVar.jad_bo = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            jad_dqVar.jad_bo.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        }
        try {
            com.jd.ad.sdk.jad_xi.jad_er jad_an = jad_an(byteBuffer2, i, i2, jad_dqVar, jad_jwVar);
            com.jd.ad.sdk.jad_xi.jad_an.jad_bo jad_boVar2 = this.jad_cp;
            synchronized (jad_boVar2) {
                jad_dqVar.jad_bo = null;
                jad_dqVar.jad_cp = null;
                jad_boVar2.jad_an.offer(jad_dqVar);
            }
            return jad_an;
        } catch (java.lang.Throwable th) {
            com.jd.ad.sdk.jad_xi.jad_an.jad_bo jad_boVar3 = this.jad_cp;
            synchronized (jad_boVar3) {
                jad_dqVar.jad_bo = null;
                jad_dqVar.jad_cp = null;
                jad_boVar3.jad_an.offer(jad_dqVar);
                throw th;
            }
        }
    }

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_xi.jad_er jad_an(java.nio.ByteBuffer byteBuffer, int i, int i2, com.jd.ad.sdk.jad_it.jad_dq jad_dqVar, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        long jad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        try {
            com.jd.ad.sdk.jad_it.jad_cp jad_bo2 = jad_dqVar.jad_bo();
            if (jad_bo2.jad_cp > 0 && jad_bo2.jad_bo == 0) {
                android.graphics.Bitmap.Config config = jad_jwVar.jad_an(com.jd.ad.sdk.jad_xi.jad_iv.jad_an) == com.jd.ad.sdk.jad_ju.jad_bo.PREFER_RGB_565 ? android.graphics.Bitmap.Config.RGB_565 : android.graphics.Bitmap.Config.ARGB_8888;
                int jad_an2 = jad_an(jad_bo2, i, i2);
                com.jd.ad.sdk.jad_xi.jad_an.C0414jad_an c0414jad_an = this.jad_dq;
                com.jd.ad.sdk.jad_xi.jad_bo jad_boVar = this.jad_er;
                c0414jad_an.getClass();
                com.jd.ad.sdk.jad_it.jad_er jad_erVar = new com.jd.ad.sdk.jad_it.jad_er(jad_boVar);
                jad_erVar.jad_an(jad_bo2, byteBuffer, jad_an2);
                jad_erVar.jad_an(config);
                jad_erVar.jad_kx = (jad_erVar.jad_kx + 1) % jad_erVar.jad_ly.jad_cp;
                android.graphics.Bitmap jad_fs2 = jad_erVar.jad_fs();
                if (jad_fs2 == null) {
                    if (android.util.Log.isLoggable("BufferGifDecoder", 2)) {
                        java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ");
                        jad_an3.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an));
                        com.jd.ad.sdk.logger.Logger.v("BufferGifDecoder", jad_an3.toString());
                    }
                    return null;
                }
                com.jd.ad.sdk.jad_xi.jad_er jad_erVar2 = new com.jd.ad.sdk.jad_xi.jad_er(new com.jd.ad.sdk.jad_xi.jad_cp(new com.jd.ad.sdk.jad_xi.jad_cp.jad_an(new com.jd.ad.sdk.jad_xi.jad_jt(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(this.jad_an), jad_erVar, i, i2, (com.jd.ad.sdk.jad_sd.jad_bo) com.jd.ad.sdk.jad_sd.jad_bo.jad_bo, jad_fs2))));
                if (android.util.Log.isLoggable("BufferGifDecoder", 2)) {
                    java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ");
                    jad_an4.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an));
                    com.jd.ad.sdk.logger.Logger.v("BufferGifDecoder", jad_an4.toString());
                }
                return jad_erVar2;
            }
            if (android.util.Log.isLoggable("BufferGifDecoder", 2)) {
                java.lang.StringBuilder jad_an5 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ");
                jad_an5.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an));
                com.jd.ad.sdk.logger.Logger.v("BufferGifDecoder", jad_an5.toString());
            }
            return null;
        } catch (java.lang.Throwable th) {
            if (android.util.Log.isLoggable("BufferGifDecoder", 2)) {
                java.lang.StringBuilder jad_an6 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ");
                jad_an6.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an));
                com.jd.ad.sdk.logger.Logger.v("BufferGifDecoder", jad_an6.toString());
            }
            throw th;
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return !((java.lang.Boolean) jad_jwVar.jad_an(com.jd.ad.sdk.jad_xi.jad_iv.jad_bo)).booleanValue() && com.jd.ad.sdk.jad_ju.jad_jt.jad_an(this.jad_bo, byteBuffer) == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.GIF;
    }
}
