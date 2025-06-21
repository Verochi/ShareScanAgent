package com.jd.ad.sdk.jad_it;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_it.jad_an {

    @androidx.annotation.ColorInt
    public int[] jad_an;
    public final com.jd.ad.sdk.jad_it.jad_an.InterfaceC0382jad_an jad_cp;
    public java.nio.ByteBuffer jad_dq;
    public byte[] jad_er;
    public short[] jad_fs;
    public byte[] jad_hu;
    public byte[] jad_iv;
    public byte[] jad_jt;

    @androidx.annotation.ColorInt
    public int[] jad_jw;
    public int jad_kx;
    public android.graphics.Bitmap jad_mz;
    public boolean jad_na;
    public int jad_ob;
    public int jad_pc;
    public int jad_qd;
    public int jad_re;

    @androidx.annotation.Nullable
    public java.lang.Boolean jad_sf;

    @androidx.annotation.ColorInt
    public final int[] jad_bo = new int[256];

    @androidx.annotation.NonNull
    public android.graphics.Bitmap.Config jad_tg = android.graphics.Bitmap.Config.ARGB_8888;
    public com.jd.ad.sdk.jad_it.jad_cp jad_ly = new com.jd.ad.sdk.jad_it.jad_cp();

    public jad_er(@androidx.annotation.NonNull com.jd.ad.sdk.jad_it.jad_an.InterfaceC0382jad_an interfaceC0382jad_an) {
        this.jad_cp = interfaceC0382jad_an;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public void clear() {
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar3;
        this.jad_ly = null;
        byte[] bArr = this.jad_iv;
        if (bArr != null && (jad_boVar3 = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar3.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr);
        }
        int[] iArr = this.jad_jw;
        if (iArr != null && (jad_boVar2 = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar2.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) iArr);
        }
        android.graphics.Bitmap bitmap = this.jad_mz;
        if (bitmap != null) {
            ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an.jad_an(bitmap);
        }
        this.jad_mz = null;
        this.jad_dq = null;
        this.jad_sf = null;
        byte[] bArr2 = this.jad_er;
        if (bArr2 == null || (jad_boVar = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_bo) == null) {
            return;
        }
        jad_boVar.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr2);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_an() {
        return this.jad_kx;
    }

    public void jad_an(@androidx.annotation.NonNull android.graphics.Bitmap.Config config) {
        if (config == android.graphics.Bitmap.Config.ARGB_8888 || config == android.graphics.Bitmap.Config.RGB_565) {
            this.jad_tg = config;
            return;
        }
        throw new java.lang.IllegalArgumentException("Unsupported format: " + config + ", must be one of " + android.graphics.Bitmap.Config.ARGB_8888 + " or " + android.graphics.Bitmap.Config.RGB_565);
    }

    public synchronized void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_it.jad_cp jad_cpVar, @androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = java.lang.Integer.highestOneBit(i);
        this.jad_ob = 0;
        this.jad_ly = jad_cpVar;
        this.jad_kx = -1;
        java.nio.ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.jad_dq = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.jad_dq.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.jad_na = false;
        java.util.Iterator<com.jd.ad.sdk.jad_it.jad_bo> it = jad_cpVar.jad_er.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().jad_jt == 3) {
                this.jad_na = true;
                break;
            }
        }
        this.jad_pc = highestOneBit;
        int i2 = jad_cpVar.jad_fs;
        this.jad_re = i2 / highestOneBit;
        int i3 = jad_cpVar.jad_jt;
        this.jad_qd = i3 / highestOneBit;
        this.jad_iv = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an(i2 * i3);
        com.jd.ad.sdk.jad_it.jad_an.InterfaceC0382jad_an interfaceC0382jad_an = this.jad_cp;
        int i4 = this.jad_re * this.jad_qd;
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = ((com.jd.ad.sdk.jad_xi.jad_bo) interfaceC0382jad_an).jad_bo;
        this.jad_jw = jad_boVar == null ? new int[i4] : (int[]) jad_boVar.jad_an(i4, int[].class);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_bo() {
        return this.jad_ly.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_cp() {
        return (this.jad_jw.length * 4) + this.jad_dq.limit() + this.jad_iv.length;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_dq() {
        int i;
        com.jd.ad.sdk.jad_it.jad_cp jad_cpVar = this.jad_ly;
        int i2 = jad_cpVar.jad_cp;
        if (i2 <= 0 || (i = this.jad_kx) < 0) {
            return 0;
        }
        if (i < 0 || i >= i2) {
            return -1;
        }
        return jad_cpVar.jad_er.get(i).jad_iv;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    @androidx.annotation.NonNull
    public java.nio.ByteBuffer jad_er() {
        return this.jad_dq;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fd, code lost:
    
        if (r5.jad_jw == r0.jad_hu) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04f5 A[Catch: all -> 0x0549, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:8:0x003c, B:13:0x0046, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:40:0x00c6, B:42:0x00ca, B:43:0x00d3, B:45:0x00da, B:47:0x00de, B:49:0x00e2, B:51:0x00e7, B:54:0x00ed, B:56:0x00f1, B:58:0x00f9, B:60:0x0100, B:62:0x0118, B:64:0x011d, B:66:0x0122, B:70:0x0128, B:72:0x012c, B:73:0x013c, B:75:0x014d, B:77:0x015a, B:79:0x0162, B:80:0x0166, B:82:0x016c, B:83:0x0170, B:85:0x0176, B:86:0x017c, B:88:0x0193, B:90:0x019d, B:94:0x01bc, B:144:0x01e0, B:99:0x01ee, B:101:0x020c, B:107:0x0234, B:113:0x0247, B:116:0x0256, B:118:0x025f, B:119:0x0269, B:121:0x026f, B:125:0x027c, B:128:0x028b, B:307:0x01ca, B:145:0x02b9, B:147:0x02c3, B:150:0x02ca, B:153:0x02db, B:155:0x02e5, B:158:0x02f3, B:160:0x02f9, B:162:0x0303, B:164:0x0307, B:166:0x030b, B:171:0x0314, B:173:0x031b, B:175:0x031f, B:178:0x0331, B:179:0x04e6, B:181:0x04ea, B:185:0x04f1, B:187:0x04f5, B:188:0x04fb, B:189:0x050e, B:192:0x0325, B:199:0x033b, B:202:0x0352, B:204:0x0367, B:207:0x036f, B:214:0x0391, B:215:0x0398, B:219:0x03a1, B:222:0x03ad, B:226:0x03bd, B:228:0x03ca, B:230:0x03d4, B:233:0x03d1, B:241:0x04be, B:242:0x03ea, B:244:0x03f9, B:245:0x040a, B:247:0x040f, B:250:0x0418, B:252:0x0423, B:254:0x043f, B:258:0x0448, B:259:0x044c, B:261:0x0451, B:264:0x0458, B:266:0x0463, B:268:0x0478, B:275:0x0495, B:277:0x049f, B:280:0x049c, B:284:0x0481, B:300:0x04d2, B:304:0x04e0, B:305:0x04dc, B:310:0x0150, B:311:0x007a, B:313:0x0526, B:315:0x052f, B:318:0x0010, B:320:0x0018, B:321:0x003a), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0118 A[Catch: all -> 0x0549, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:8:0x003c, B:13:0x0046, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:40:0x00c6, B:42:0x00ca, B:43:0x00d3, B:45:0x00da, B:47:0x00de, B:49:0x00e2, B:51:0x00e7, B:54:0x00ed, B:56:0x00f1, B:58:0x00f9, B:60:0x0100, B:62:0x0118, B:64:0x011d, B:66:0x0122, B:70:0x0128, B:72:0x012c, B:73:0x013c, B:75:0x014d, B:77:0x015a, B:79:0x0162, B:80:0x0166, B:82:0x016c, B:83:0x0170, B:85:0x0176, B:86:0x017c, B:88:0x0193, B:90:0x019d, B:94:0x01bc, B:144:0x01e0, B:99:0x01ee, B:101:0x020c, B:107:0x0234, B:113:0x0247, B:116:0x0256, B:118:0x025f, B:119:0x0269, B:121:0x026f, B:125:0x027c, B:128:0x028b, B:307:0x01ca, B:145:0x02b9, B:147:0x02c3, B:150:0x02ca, B:153:0x02db, B:155:0x02e5, B:158:0x02f3, B:160:0x02f9, B:162:0x0303, B:164:0x0307, B:166:0x030b, B:171:0x0314, B:173:0x031b, B:175:0x031f, B:178:0x0331, B:179:0x04e6, B:181:0x04ea, B:185:0x04f1, B:187:0x04f5, B:188:0x04fb, B:189:0x050e, B:192:0x0325, B:199:0x033b, B:202:0x0352, B:204:0x0367, B:207:0x036f, B:214:0x0391, B:215:0x0398, B:219:0x03a1, B:222:0x03ad, B:226:0x03bd, B:228:0x03ca, B:230:0x03d4, B:233:0x03d1, B:241:0x04be, B:242:0x03ea, B:244:0x03f9, B:245:0x040a, B:247:0x040f, B:250:0x0418, B:252:0x0423, B:254:0x043f, B:258:0x0448, B:259:0x044c, B:261:0x0451, B:264:0x0458, B:266:0x0463, B:268:0x0478, B:275:0x0495, B:277:0x049f, B:280:0x049c, B:284:0x0481, B:300:0x04d2, B:304:0x04e0, B:305:0x04dc, B:310:0x0150, B:311:0x007a, B:313:0x0526, B:315:0x052f, B:318:0x0010, B:320:0x0018, B:321:0x003a), top: B:3:0x0003 }] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54, types: [int] */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r3v63 */
    @Override // com.jd.ad.sdk.jad_it.jad_an
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized android.graphics.Bitmap jad_fs() {
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte[] bArr;
        int i9;
        byte[] bArr2;
        int i10;
        int i11;
        int i12;
        boolean z;
        short s2;
        int i13;
        android.graphics.Bitmap bitmap;
        int i14;
        int i15;
        int i16;
        if (this.jad_ly.jad_cp <= 0 || this.jad_kx < 0) {
            if (android.util.Log.isLoggable("StandardGifDecoder", 3)) {
                java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Unable to decode frame, frameCount=");
                jad_an.append(this.jad_ly.jad_cp);
                jad_an.append(", framePointer=");
                jad_an.append(this.jad_kx);
                com.jd.ad.sdk.logger.Logger.d("StandardGifDecoder", jad_an.toString());
            }
            this.jad_ob = 1;
        }
        int i17 = this.jad_ob;
        if (i17 != 1 && i17 != 2) {
            this.jad_ob = 0;
            byte b = 255;
            if (this.jad_er == null) {
                this.jad_er = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an(255);
            }
            com.jd.ad.sdk.jad_it.jad_bo jad_boVar = this.jad_ly.jad_er.get(this.jad_kx);
            int i18 = this.jad_kx - 1;
            com.jd.ad.sdk.jad_it.jad_bo jad_boVar2 = i18 >= 0 ? this.jad_ly.jad_er.get(i18) : null;
            int[] iArr2 = jad_boVar.jad_kx;
            if (iArr2 == null) {
                iArr2 = this.jad_ly.jad_an;
            }
            this.jad_an = iArr2;
            if (iArr2 == null) {
                if (android.util.Log.isLoggable("StandardGifDecoder", 3)) {
                    java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("No valid color table found for frame #");
                    jad_an2.append(this.jad_kx);
                    com.jd.ad.sdk.logger.Logger.d("StandardGifDecoder", jad_an2.toString());
                }
                this.jad_ob = 1;
                return null;
            }
            if (jad_boVar.jad_fs) {
                java.lang.System.arraycopy(iArr2, 0, this.jad_bo, 0, iArr2.length);
                int[] iArr3 = this.jad_bo;
                this.jad_an = iArr3;
                iArr3[jad_boVar.jad_hu] = 0;
                if (jad_boVar.jad_jt == 2 && this.jad_kx == 0) {
                    this.jad_sf = java.lang.Boolean.TRUE;
                }
            }
            int[] iArr4 = this.jad_jw;
            if (jad_boVar2 == null) {
                android.graphics.Bitmap bitmap2 = this.jad_mz;
                if (bitmap2 != null) {
                    ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an.jad_an(bitmap2);
                }
                this.jad_mz = null;
                java.util.Arrays.fill(iArr4, 0);
            }
            if (jad_boVar2 != null && jad_boVar2.jad_jt == 3 && this.jad_mz == null) {
                java.util.Arrays.fill(iArr4, 0);
            }
            if (jad_boVar2 != null && (i13 = jad_boVar2.jad_jt) > 0) {
                if (i13 == 2) {
                    if (!jad_boVar.jad_fs) {
                        com.jd.ad.sdk.jad_it.jad_cp jad_cpVar = this.jad_ly;
                        i14 = jad_cpVar.jad_kx;
                        if (jad_boVar.jad_kx != null) {
                        }
                        int i19 = jad_boVar2.jad_dq;
                        int i20 = this.jad_pc;
                        int i21 = i19 / i20;
                        int i22 = jad_boVar2.jad_bo / i20;
                        int i23 = jad_boVar2.jad_cp / i20;
                        int i24 = jad_boVar2.jad_an / i20;
                        int i25 = this.jad_re;
                        i15 = (i22 * i25) + i24;
                        i16 = (i21 * i25) + i15;
                        while (i15 < i16) {
                            int i26 = i15 + i23;
                            for (int i27 = i15; i27 < i26; i27++) {
                                iArr4[i27] = i14;
                            }
                            i15 += this.jad_re;
                        }
                    }
                    i14 = 0;
                    int i192 = jad_boVar2.jad_dq;
                    int i202 = this.jad_pc;
                    int i212 = i192 / i202;
                    int i222 = jad_boVar2.jad_bo / i202;
                    int i232 = jad_boVar2.jad_cp / i202;
                    int i242 = jad_boVar2.jad_an / i202;
                    int i252 = this.jad_re;
                    i15 = (i222 * i252) + i242;
                    i16 = (i212 * i252) + i15;
                    while (i15 < i16) {
                    }
                } else if (i13 == 3 && (bitmap = this.jad_mz) != null) {
                    int i28 = this.jad_re;
                    bitmap.getPixels(iArr4, 0, i28, 0, 0, i28, this.jad_qd);
                }
            }
            this.jad_dq.position(jad_boVar.jad_jw);
            int i29 = jad_boVar.jad_cp * jad_boVar.jad_dq;
            byte[] bArr3 = this.jad_iv;
            if (bArr3 == null || bArr3.length < i29) {
                this.jad_iv = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an(i29);
            }
            byte[] bArr4 = this.jad_iv;
            if (this.jad_fs == null) {
                this.jad_fs = new short[4096];
            }
            short[] sArr = this.jad_fs;
            if (this.jad_jt == null) {
                this.jad_jt = new byte[4096];
            }
            byte[] bArr5 = this.jad_jt;
            if (this.jad_hu == null) {
                this.jad_hu = new byte[4097];
            }
            byte[] bArr6 = this.jad_hu;
            int i30 = this.jad_dq.get() & 255;
            int i31 = 1 << i30;
            int i32 = i31 + 1;
            int i33 = i31 + 2;
            int i34 = i30 + 1;
            int i35 = (1 << i34) - 1;
            for (int i36 = 0; i36 < i31; i36++) {
                sArr[i36] = 0;
                bArr5[i36] = (byte) i36;
            }
            byte[] bArr7 = this.jad_er;
            int i37 = i34;
            int i38 = i33;
            int i39 = i35;
            int i40 = 0;
            int i41 = -1;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            while (true) {
                if (i40 >= i29) {
                    break;
                }
                if (i42 == 0) {
                    int i49 = this.jad_dq.get() & b;
                    if (i49 <= 0) {
                        i11 = i40;
                        i12 = i34;
                    } else {
                        java.nio.ByteBuffer byteBuffer = this.jad_dq;
                        i11 = i40;
                        i12 = i34;
                        byteBuffer.get(this.jad_er, 0, java.lang.Math.min(i49, byteBuffer.remaining()));
                    }
                    if (i49 <= 0) {
                        this.jad_ob = 3;
                        break;
                    }
                    i42 = i49;
                    i44 = 0;
                } else {
                    i11 = i40;
                    i12 = i34;
                }
                i45 += (bArr7[i44] & 255) << i43;
                i44++;
                i42--;
                ?? r3 = i41;
                int i50 = i43 + 8;
                int i51 = i37;
                int i52 = i38;
                int i53 = i48;
                i40 = i11;
                while (true) {
                    if (i50 < i51) {
                        i48 = i53;
                        i38 = i52;
                        i43 = i50;
                        i37 = i51;
                        bArr7 = bArr7;
                        i34 = i12;
                        b = 255;
                        i41 = r3;
                        break;
                    }
                    ?? r2 = i45 & i39;
                    i45 >>= i51;
                    i50 -= i51;
                    if (r2 == i31) {
                        i52 = i33;
                        i39 = i35;
                        i51 = i12;
                        r3 = -1;
                    } else {
                        if (r2 == i32) {
                            i41 = r3;
                            i43 = i50;
                            i37 = i51;
                            i34 = i12;
                            i38 = i52;
                            i48 = i53;
                            b = 255;
                            break;
                        }
                        byte[] bArr8 = bArr7;
                        if (r3 == -1) {
                            bArr4[i46] = bArr5[r2 == true ? 1 : 0];
                            i46++;
                            i40++;
                            r3 = r2 == true ? 1 : 0;
                            i53 = r3;
                            bArr7 = bArr8;
                        } else {
                            int i54 = i52;
                            if (r2 >= i54) {
                                z = r2 == true ? 1 : 0;
                                bArr6[i47] = (byte) i53;
                                i47++;
                                s2 = r3;
                            } else {
                                z = r2 == true ? 1 : 0;
                                s2 = r2;
                            }
                            while (s2 >= i31) {
                                bArr6[i47] = bArr5[s2];
                                i47++;
                                s2 = sArr[s2];
                            }
                            int i55 = i32;
                            int i56 = bArr5[s2] & 255;
                            byte b2 = (byte) i56;
                            bArr4[i46] = b2;
                            while (true) {
                                i46++;
                                i40++;
                                if (i47 <= 0) {
                                    break;
                                }
                                i47--;
                                bArr4[i46] = bArr6[i47];
                            }
                            if (i54 < 4096) {
                                sArr[i54] = (short) r3;
                                bArr5[i54] = b2;
                                int i57 = i54 + 1;
                                if ((i57 & i39) == 0 && i57 < 4096) {
                                    i51++;
                                    i39 += i57;
                                }
                                i52 = i57;
                            } else {
                                i52 = i54;
                            }
                            bArr7 = bArr8;
                            r3 = z;
                            i32 = i55;
                            i53 = i56;
                        }
                    }
                }
            }
            java.util.Arrays.fill(bArr4, i46, i29, (byte) 0);
            if (!jad_boVar.jad_er && this.jad_pc == 1) {
                int[] iArr5 = this.jad_jw;
                int i58 = jad_boVar.jad_dq;
                int i59 = jad_boVar.jad_bo;
                int i60 = jad_boVar.jad_cp;
                int i61 = jad_boVar.jad_an;
                boolean z2 = this.jad_kx == 0;
                int i62 = this.jad_re;
                byte[] bArr9 = this.jad_iv;
                int[] iArr6 = this.jad_an;
                byte b3 = -1;
                int i63 = 0;
                while (i63 < i58) {
                    int i64 = (i63 + i59) * i62;
                    int i65 = i64 + i61;
                    int i66 = i58;
                    int i67 = i65 + i60;
                    int i68 = i64 + i62;
                    if (i68 < i67) {
                        i67 = i68;
                    }
                    int i69 = jad_boVar.jad_cp * i63;
                    while (i65 < i67) {
                        int i70 = i67;
                        byte b4 = bArr9[i69];
                        int i71 = i59;
                        int i72 = b4 & 255;
                        if (i72 != b3) {
                            int i73 = iArr6[i72];
                            if (i73 != 0) {
                                iArr5[i65] = i73;
                            } else {
                                b3 = b4;
                            }
                        }
                        i69++;
                        i65++;
                        i67 = i70;
                        i59 = i71;
                    }
                    i63++;
                    i58 = i66;
                }
                java.lang.Boolean bool = this.jad_sf;
                this.jad_sf = java.lang.Boolean.valueOf((bool != null && bool.booleanValue()) || (this.jad_sf == null && z2 && b3 != -1));
                iArr = iArr4;
                if (this.jad_na && ((i10 = jad_boVar.jad_jt) == 0 || i10 == 1)) {
                    if (this.jad_mz == null) {
                        this.jad_mz = jad_hu();
                    }
                    android.graphics.Bitmap bitmap3 = this.jad_mz;
                    int i74 = this.jad_re;
                    bitmap3.setPixels(iArr, 0, i74, 0, 0, i74, this.jad_qd);
                }
                android.graphics.Bitmap jad_hu = jad_hu();
                int i75 = this.jad_re;
                jad_hu.setPixels(iArr, 0, i75, 0, 0, i75, this.jad_qd);
                return jad_hu;
            }
            int[] iArr7 = this.jad_jw;
            int i76 = jad_boVar.jad_dq;
            int i77 = this.jad_pc;
            int i78 = i76 / i77;
            int i79 = jad_boVar.jad_bo / i77;
            int i80 = jad_boVar.jad_cp / i77;
            int i81 = jad_boVar.jad_an / i77;
            boolean z3 = this.jad_kx == 0;
            int i82 = this.jad_re;
            int i83 = this.jad_qd;
            byte[] bArr10 = this.jad_iv;
            int[] iArr8 = this.jad_an;
            iArr = iArr4;
            java.lang.Boolean bool2 = this.jad_sf;
            int i84 = 0;
            int i85 = 0;
            int i86 = 1;
            int i87 = 8;
            while (i85 < i78) {
                java.lang.Boolean bool3 = bool2;
                if (jad_boVar.jad_er) {
                    if (i84 >= i78) {
                        int i88 = i86 + 1;
                        i = i78;
                        if (i88 == 2) {
                            i86 = i88;
                            i84 = 4;
                        } else if (i88 != 3) {
                            i86 = i88;
                            if (i88 == 4) {
                                i84 = 1;
                                i87 = 2;
                            }
                        } else {
                            i86 = i88;
                            i84 = 2;
                            i87 = 4;
                        }
                    } else {
                        i = i78;
                    }
                    i2 = i84 + i87;
                } else {
                    i = i78;
                    i2 = i84;
                    i84 = i85;
                }
                int i89 = i84 + i79;
                boolean z4 = i77 == 1;
                if (i89 < i83) {
                    int i90 = i89 * i82;
                    int i91 = i90 + i81;
                    i3 = i2;
                    int i92 = i91 + i80;
                    int i93 = i90 + i82;
                    if (i93 < i92) {
                        i92 = i93;
                    }
                    i4 = i79;
                    int i94 = i85 * i77 * jad_boVar.jad_cp;
                    if (z4) {
                        bool2 = bool3;
                        int i95 = i91;
                        while (i95 < i92) {
                            int i96 = i80;
                            int i97 = i81;
                            int i98 = iArr8[bArr10[i94] & 255];
                            if (i98 != 0) {
                                iArr7[i95] = i98;
                            } else if (z3 && bool2 == null) {
                                bool2 = java.lang.Boolean.TRUE;
                            }
                            i94 += i77;
                            i95++;
                            i80 = i96;
                            i81 = i97;
                        }
                        i5 = i80;
                        i6 = i81;
                    } else {
                        i5 = i80;
                        i6 = i81;
                        int i99 = ((i92 - i91) * i77) + i94;
                        bool2 = bool3;
                        int i100 = i91;
                        while (i100 < i92) {
                            int i101 = jad_boVar.jad_cp;
                            int i102 = i92;
                            int i103 = i94;
                            int i104 = i82;
                            int i105 = 0;
                            int i106 = 0;
                            int i107 = 0;
                            int i108 = 0;
                            int i109 = 0;
                            while (true) {
                                if (i103 >= this.jad_pc + i94) {
                                    i9 = i83;
                                    break;
                                }
                                byte[] bArr11 = this.jad_iv;
                                i9 = i83;
                                if (i103 >= bArr11.length || i103 >= i99) {
                                    break;
                                }
                                int i110 = this.jad_an[bArr11[i103] & 255];
                                if (i110 != 0) {
                                    bArr2 = bArr10;
                                    i108 += (i110 >> 24) & 255;
                                    i107 += (i110 >> 16) & 255;
                                    i106 += (i110 >> 8) & 255;
                                    i105 += i110 & 255;
                                    i109++;
                                } else {
                                    bArr2 = bArr10;
                                }
                                i103++;
                                i83 = i9;
                                bArr10 = bArr2;
                            }
                            byte[] bArr12 = bArr10;
                            int i111 = i101 + i94;
                            for (int i112 = i111; i112 < this.jad_pc + i111; i112++) {
                                byte[] bArr13 = this.jad_iv;
                                if (i112 >= bArr13.length || i112 >= i99) {
                                    break;
                                }
                                int i113 = this.jad_an[bArr13[i112] & 255];
                                if (i113 != 0) {
                                    i108 += (i113 >> 24) & 255;
                                    i107 += (i113 >> 16) & 255;
                                    i106 += (i113 >> 8) & 255;
                                    i105 += i113 & 255;
                                    i109++;
                                }
                            }
                            int i114 = i109 == 0 ? 0 : ((i108 / i109) << 24) | ((i107 / i109) << 16) | ((i106 / i109) << 8) | (i105 / i109);
                            if (i114 != 0) {
                                iArr7[i100] = i114;
                            } else if (z3 && bool2 == null) {
                                bool2 = java.lang.Boolean.TRUE;
                            }
                            i94 += i77;
                            i100++;
                            i92 = i102;
                            i82 = i104;
                            i83 = i9;
                            bArr10 = bArr12;
                        }
                    }
                    i7 = i82;
                    i8 = i83;
                    bArr = bArr10;
                } else {
                    i3 = i2;
                    i4 = i79;
                    i5 = i80;
                    i6 = i81;
                    i7 = i82;
                    i8 = i83;
                    bArr = bArr10;
                    bool2 = bool3;
                }
                i85++;
                i78 = i;
                i84 = i3;
                i79 = i4;
                i80 = i5;
                i81 = i6;
                i82 = i7;
                i83 = i8;
                bArr10 = bArr;
            }
            java.lang.Boolean bool4 = bool2;
            if (this.jad_sf == null) {
                this.jad_sf = java.lang.Boolean.valueOf(bool4 == null ? false : bool4.booleanValue());
            }
            if (this.jad_na) {
                if (this.jad_mz == null) {
                }
                android.graphics.Bitmap bitmap32 = this.jad_mz;
                int i742 = this.jad_re;
                bitmap32.setPixels(iArr, 0, i742, 0, 0, i742, this.jad_qd);
            }
            android.graphics.Bitmap jad_hu2 = jad_hu();
            int i752 = this.jad_re;
            jad_hu2.setPixels(iArr, 0, i752, 0, 0, i752, this.jad_qd);
            return jad_hu2;
        }
        if (android.util.Log.isLoggable("StandardGifDecoder", 3)) {
            java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Unable to decode frame, status=");
            jad_an3.append(this.jad_ob);
            com.jd.ad.sdk.logger.Logger.d("StandardGifDecoder", jad_an3.toString());
        }
        return null;
    }

    public final android.graphics.Bitmap jad_hu() {
        java.lang.Boolean bool = this.jad_sf;
        android.graphics.Bitmap.Config config = (bool == null || bool.booleanValue()) ? android.graphics.Bitmap.Config.ARGB_8888 : this.jad_tg;
        android.graphics.Bitmap jad_bo = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an.jad_bo(this.jad_re, this.jad_qd, config);
        jad_bo.setHasAlpha(true);
        return jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public void jad_jt() {
        this.jad_kx = (this.jad_kx + 1) % this.jad_ly.jad_cp;
    }
}
