package com.jd.ad.sdk.jad_it;

/* loaded from: classes23.dex */
public class jad_dq {
    public java.nio.ByteBuffer jad_bo;
    public com.jd.ad.sdk.jad_it.jad_cp jad_cp;
    public final byte[] jad_an = new byte[256];
    public int jad_dq = 0;

    public final boolean jad_an() {
        return this.jad_cp.jad_bo != 0;
    }

    @androidx.annotation.Nullable
    public final int[] jad_an(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.jad_bo.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | androidx.core.view.ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (java.nio.BufferUnderflowException e) {
            if (android.util.Log.isLoggable(com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser.TAG, 3)) {
                com.jd.ad.sdk.logger.Logger.d(com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser.TAG, "Format Error Reading Color Table", e);
            }
            this.jad_cp.jad_bo = 1;
        }
        return iArr;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_it.jad_cp jad_bo() {
        if (this.jad_bo == null) {
            throw new java.lang.IllegalStateException("You must call setData() before parseHeader()");
        }
        if (jad_an()) {
            return this.jad_cp;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) jad_cp());
        }
        if (sb.toString().startsWith("GIF")) {
            this.jad_cp.jad_fs = this.jad_bo.getShort();
            this.jad_cp.jad_jt = this.jad_bo.getShort();
            int jad_cp = jad_cp();
            com.jd.ad.sdk.jad_it.jad_cp jad_cpVar = this.jad_cp;
            jad_cpVar.jad_hu = (jad_cp & 128) != 0;
            jad_cpVar.jad_iv = (int) java.lang.Math.pow(2.0d, (jad_cp & 7) + 1);
            this.jad_cp.jad_jw = jad_cp();
            com.jd.ad.sdk.jad_it.jad_cp jad_cpVar2 = this.jad_cp;
            jad_cp();
            jad_cpVar2.getClass();
            if (this.jad_cp.jad_hu && !jad_an()) {
                com.jd.ad.sdk.jad_it.jad_cp jad_cpVar3 = this.jad_cp;
                jad_cpVar3.jad_an = jad_an(jad_cpVar3.jad_iv);
                com.jd.ad.sdk.jad_it.jad_cp jad_cpVar4 = this.jad_cp;
                jad_cpVar4.jad_kx = jad_cpVar4.jad_an[jad_cpVar4.jad_jw];
            }
        } else {
            this.jad_cp.jad_bo = 1;
        }
        if (!jad_an()) {
            boolean z = false;
            while (!z && !jad_an() && this.jad_cp.jad_cp <= Integer.MAX_VALUE) {
                int jad_cp2 = jad_cp();
                if (jad_cp2 == 33) {
                    int jad_cp3 = jad_cp();
                    if (jad_cp3 != 1) {
                        if (jad_cp3 == 249) {
                            this.jad_cp.jad_dq = new com.jd.ad.sdk.jad_it.jad_bo();
                            jad_cp();
                            int jad_cp4 = jad_cp();
                            com.jd.ad.sdk.jad_it.jad_bo jad_boVar = this.jad_cp.jad_dq;
                            int i2 = (jad_cp4 & 28) >> 2;
                            jad_boVar.jad_jt = i2;
                            if (i2 == 0) {
                                jad_boVar.jad_jt = 1;
                            }
                            jad_boVar.jad_fs = (jad_cp4 & 1) != 0;
                            short s2 = this.jad_bo.getShort();
                            if (s2 < 2) {
                                s2 = 10;
                            }
                            com.jd.ad.sdk.jad_it.jad_bo jad_boVar2 = this.jad_cp.jad_dq;
                            jad_boVar2.jad_iv = s2 * 10;
                            jad_boVar2.jad_hu = jad_cp();
                            jad_cp();
                        } else if (jad_cp3 != 254 && jad_cp3 == 255) {
                            jad_dq();
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            for (int i3 = 0; i3 < 11; i3++) {
                                sb2.append((char) this.jad_an[i3]);
                            }
                            if (sb2.toString().equals("NETSCAPE2.0")) {
                                do {
                                    jad_dq();
                                    byte[] bArr = this.jad_an;
                                    if (bArr[0] == 1) {
                                        byte b = bArr[1];
                                        byte b2 = bArr[2];
                                        this.jad_cp.getClass();
                                    }
                                    if (this.jad_dq > 0) {
                                    }
                                } while (!jad_an());
                            }
                        }
                    }
                    jad_er();
                } else if (jad_cp2 == 44) {
                    com.jd.ad.sdk.jad_it.jad_cp jad_cpVar5 = this.jad_cp;
                    if (jad_cpVar5.jad_dq == null) {
                        jad_cpVar5.jad_dq = new com.jd.ad.sdk.jad_it.jad_bo();
                    }
                    jad_cpVar5.jad_dq.jad_an = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_bo = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_cp = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_dq = this.jad_bo.getShort();
                    int jad_cp5 = jad_cp();
                    boolean z2 = (jad_cp5 & 128) != 0;
                    int pow = (int) java.lang.Math.pow(2.0d, (jad_cp5 & 7) + 1);
                    com.jd.ad.sdk.jad_it.jad_bo jad_boVar3 = this.jad_cp.jad_dq;
                    jad_boVar3.jad_er = (jad_cp5 & 64) != 0;
                    if (z2) {
                        jad_boVar3.jad_kx = jad_an(pow);
                    } else {
                        jad_boVar3.jad_kx = null;
                    }
                    this.jad_cp.jad_dq.jad_jw = this.jad_bo.position();
                    jad_cp();
                    jad_er();
                    if (!jad_an()) {
                        com.jd.ad.sdk.jad_it.jad_cp jad_cpVar6 = this.jad_cp;
                        jad_cpVar6.jad_cp++;
                        jad_cpVar6.jad_er.add(jad_cpVar6.jad_dq);
                    }
                } else if (jad_cp2 != 59) {
                    this.jad_cp.jad_bo = 1;
                } else {
                    z = true;
                }
            }
            com.jd.ad.sdk.jad_it.jad_cp jad_cpVar7 = this.jad_cp;
            if (jad_cpVar7.jad_cp < 0) {
                jad_cpVar7.jad_bo = 1;
            }
        }
        return this.jad_cp;
    }

    public final int jad_cp() {
        try {
            return this.jad_bo.get() & 255;
        } catch (java.lang.Exception unused) {
            this.jad_cp.jad_bo = 1;
            return 0;
        }
    }

    public final void jad_dq() {
        int jad_cp = jad_cp();
        this.jad_dq = jad_cp;
        if (jad_cp <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.jad_dq;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.jad_bo.get(this.jad_an, i, i2);
                i += i2;
            } catch (java.lang.Exception e) {
                if (android.util.Log.isLoggable(com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser.TAG, 3)) {
                    com.jd.ad.sdk.logger.Logger.d(com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser.TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.jad_dq, e);
                }
                this.jad_cp.jad_bo = 1;
                return;
            }
        }
    }

    public final void jad_er() {
        int jad_cp;
        do {
            jad_cp = jad_cp();
            this.jad_bo.position(java.lang.Math.min(this.jad_bo.position() + jad_cp, this.jad_bo.limit()));
        } while (jad_cp > 0);
    }
}
