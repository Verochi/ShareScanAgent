package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public final class jad_jw {
    public static final com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Boolean> jad_hu;
    public static final com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Boolean> jad_iv;
    public static final java.util.Set<java.lang.String> jad_jw;
    public static final com.jd.ad.sdk.jad_te.jad_jw.jad_bo jad_kx;
    public static final java.util.Set<com.jd.ad.sdk.jad_ju.jad_fs.jad_bo> jad_ly;
    public static final java.util.Queue<android.graphics.BitmapFactory.Options> jad_mz;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final android.util.DisplayMetrics jad_bo;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_cp;
    public final java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_dq;
    public final com.jd.ad.sdk.jad_te.jad_na jad_er = com.jd.ad.sdk.jad_te.jad_na.jad_an();
    public static final com.jd.ad.sdk.jad_ju.jad_iv<com.jd.ad.sdk.jad_ju.jad_bo> jad_fs = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.jd.ad.sdk.jad_ju.jad_bo.PREFER_ARGB_8888);
    public static final com.jd.ad.sdk.jad_ju.jad_iv<com.jd.ad.sdk.jad_ju.jad_kx> jad_jt = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, com.jd.ad.sdk.jad_ju.jad_iv.jad_er);

    public class jad_an implements com.jd.ad.sdk.jad_te.jad_jw.jad_bo {
        @Override // com.jd.ad.sdk.jad_te.jad_jw.jad_bo
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_te.jad_jw.jad_bo
        public void jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, android.graphics.Bitmap bitmap) {
        }
    }

    public interface jad_bo {
        void jad_an();

        void jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, android.graphics.Bitmap bitmap);
    }

    static {
        com.jd.ad.sdk.jad_te.jad_iv jad_ivVar = com.jd.ad.sdk.jad_te.jad_iv.jad_an;
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        jad_hu = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        jad_iv = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        jad_jw = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        jad_kx = new com.jd.ad.sdk.jad_te.jad_jw.jad_an();
        jad_ly = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.JPEG, com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG_A, com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG));
        char[] cArr = com.jd.ad.sdk.jad_ir.jad_ly.jad_an;
        jad_mz = new java.util.ArrayDeque(0);
    }

    public jad_jw(java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, android.util.DisplayMetrics displayMetrics, com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_dq = list;
        this.jad_bo = (android.util.DisplayMetrics) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(displayMetrics);
        this.jad_an = (com.jd.ad.sdk.jad_ny.jad_er) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_erVar);
        this.jad_cp = (com.jd.ad.sdk.jad_ny.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
    }

    public static int jad_an(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) java.lang.Math.round(d * 2.147483647E9d);
    }

    public static android.graphics.Bitmap jad_an(com.jd.ad.sdk.jad_te.jad_ob jad_obVar, android.graphics.BitmapFactory.Options options, com.jd.ad.sdk.jad_te.jad_jw.jad_bo jad_boVar, com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        if (!options.inJustDecodeBounds) {
            jad_boVar.jad_an();
            jad_obVar.jad_bo();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        java.lang.String str = options.outMimeType;
        java.util.concurrent.locks.Lock lock = com.jd.ad.sdk.jad_te.jad_vi.jad_bo;
        lock.lock();
        try {
            try {
                android.graphics.Bitmap jad_an2 = jad_obVar.jad_an(options);
                lock.unlock();
                return jad_an2;
            } catch (java.lang.IllegalArgumentException e) {
                java.io.IOException jad_an3 = jad_an(e, i, i2, str, options);
                if (android.util.Log.isLoggable("Downsampler", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", jad_an3);
                }
                android.graphics.Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw jad_an3;
                }
                try {
                    jad_erVar.jad_an(bitmap);
                    options.inBitmap = null;
                    android.graphics.Bitmap jad_an4 = jad_an(jad_obVar, options, jad_boVar, jad_erVar);
                    com.jd.ad.sdk.jad_te.jad_vi.jad_bo.unlock();
                    return jad_an4;
                } catch (java.io.IOException unused) {
                    throw jad_an3;
                }
            }
        } catch (java.lang.Throwable th) {
            com.jd.ad.sdk.jad_te.jad_vi.jad_bo.unlock();
            throw th;
        }
    }

    public static java.io.IOException jad_an(java.lang.IllegalArgumentException illegalArgumentException, int i, int i2, java.lang.String str, android.graphics.BitmapFactory.Options options) {
        return new java.io.IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + jad_an(options.inBitmap), illegalArgumentException);
    }

    @androidx.annotation.Nullable
    @android.annotation.TargetApi(19)
    public static java.lang.String jad_an(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an(" (");
        jad_an2.append(bitmap.getAllocationByteCount());
        jad_an2.append(")");
        java.lang.String sb = jad_an2.toString();
        java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("[");
        jad_an3.append(bitmap.getWidth());
        jad_an3.append("x");
        jad_an3.append(bitmap.getHeight());
        jad_an3.append("] ");
        jad_an3.append(bitmap.getConfig());
        jad_an3.append(sb);
        return jad_an3.toString();
    }

    public static void jad_an(android.graphics.BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static boolean jad_an(int i) {
        return i == 90 || i == 270;
    }

    public static int jad_bo(double d) {
        return (int) (d + 0.5d);
    }

    public static int[] jad_bo(com.jd.ad.sdk.jad_te.jad_ob jad_obVar, android.graphics.BitmapFactory.Options options, com.jd.ad.sdk.jad_te.jad_jw.jad_bo jad_boVar, com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        options.inJustDecodeBounds = true;
        jad_an(jad_obVar, options, jad_boVar, jad_erVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0425, code lost:
    
        r0 = r38.outColorSpace;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x04f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final android.graphics.Bitmap jad_an(com.jd.ad.sdk.jad_te.jad_ob jad_obVar, android.graphics.BitmapFactory.Options options, com.jd.ad.sdk.jad_te.jad_iv jad_ivVar, com.jd.ad.sdk.jad_ju.jad_bo jad_boVar, com.jd.ad.sdk.jad_ju.jad_kx jad_kxVar, boolean z, int i, int i2, boolean z2, com.jd.ad.sdk.jad_te.jad_jw.jad_bo jad_boVar2) {
        int i3;
        boolean z3;
        java.lang.String str;
        int i4;
        int i5;
        java.lang.String str2;
        java.lang.String str3;
        int i6;
        java.lang.String str4;
        java.lang.String str5;
        int i7;
        int i8;
        char c;
        java.lang.String str6;
        com.jd.ad.sdk.jad_te.jad_jw jad_jwVar;
        int i9;
        java.lang.String str7;
        boolean z4;
        boolean z5;
        int i10;
        int i11;
        int round;
        int round2;
        int i12;
        android.graphics.Bitmap jad_an2;
        boolean z6;
        android.graphics.Bitmap bitmap;
        float f;
        android.graphics.ColorSpace.Named named;
        android.graphics.ColorSpace colorSpace;
        boolean z7;
        android.graphics.ColorSpace colorSpace2;
        android.graphics.ColorSpace colorSpace3;
        boolean isWideGamut;
        android.graphics.Bitmap.Config config;
        android.graphics.Bitmap.Config config2;
        java.lang.String str8;
        java.lang.String str9;
        int i13;
        int i14;
        int i15;
        int floor;
        int floor2;
        int i16;
        long jad_an3 = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        int[] jad_bo2 = jad_bo(jad_obVar, options, jad_boVar2, this.jad_an);
        int i17 = jad_bo2[0];
        int i18 = jad_bo2[1];
        java.lang.String str10 = options.outMimeType;
        boolean z8 = (i17 == -1 || i18 == -1) ? false : z;
        int jad_cp = jad_obVar.jad_cp();
        switch (jad_cp) {
            case 3:
            case 4:
                i3 = 180;
                break;
            case 5:
            case 6:
                i3 = 90;
                break;
            case 7:
            case 8:
                i3 = 270;
                break;
            default:
                i3 = 0;
                break;
        }
        switch (jad_cp) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z3 = true;
                break;
            default:
                z3 = false;
                break;
        }
        int i19 = i == Integer.MIN_VALUE ? jad_an(i3) ? i18 : i17 : i;
        if (i2 == Integer.MIN_VALUE) {
            str = str10;
            i4 = jad_an(i3) ? i17 : i18;
        } else {
            str = str10;
            i4 = i2;
        }
        com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an4 = jad_obVar.jad_an();
        com.jd.ad.sdk.jad_ny.jad_er jad_erVar = this.jad_an;
        java.lang.String str11 = ", target density: ";
        if (i17 <= 0) {
            i5 = i18;
            str2 = ", density: ";
            str3 = "x";
            i6 = i17;
            int i20 = i19;
            str4 = "Downsampler";
            str5 = "]";
            i7 = i20;
            i8 = 3;
        } else {
            if (i18 > 0) {
                if (jad_an(i3)) {
                    str8 = "]";
                    str9 = ", target density: ";
                    i14 = i18;
                    i13 = i17;
                } else {
                    str8 = "]";
                    str9 = ", target density: ";
                    i13 = i18;
                    i14 = i17;
                }
                float jad_bo3 = jad_ivVar.jad_bo(i14, i13, i19, i4);
                if (jad_bo3 <= 0.0f) {
                    throw new java.lang.IllegalArgumentException("Cannot scale with factor: " + jad_bo3 + " from: " + jad_ivVar + ", source: [" + i17 + "x" + i18 + "], target: [" + i19 + "x" + i4 + str8);
                }
                int i21 = i3;
                int jad_an5 = jad_ivVar.jad_an(i14, i13, i19, i4);
                if (jad_an5 == 0) {
                    throw new java.lang.IllegalArgumentException("Cannot round with null rounding");
                }
                float f2 = i14;
                float f3 = i13;
                int i22 = i19;
                int jad_bo4 = i14 / jad_bo(jad_bo3 * f2);
                int jad_bo5 = i13 / jad_bo(jad_bo3 * f3);
                int max = jad_an5 == 1 ? java.lang.Math.max(jad_bo4, jad_bo5) : java.lang.Math.min(jad_bo4, jad_bo5);
                int i23 = android.os.Build.VERSION.SDK_INT;
                if (i23 > 23 || !jad_jw.contains(options.outMimeType)) {
                    int max2 = java.lang.Math.max(1, java.lang.Integer.highestOneBit(max));
                    if (jad_an5 == 1 && max2 < 1.0f / jad_bo3) {
                        max2 <<= 1;
                    }
                    i15 = max2;
                } else {
                    i15 = 1;
                }
                options.inSampleSize = i15;
                if (jad_an4 == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.JPEG) {
                    float min = java.lang.Math.min(i15, 8);
                    floor = (int) java.lang.Math.ceil(f2 / min);
                    floor2 = (int) java.lang.Math.ceil(f3 / min);
                    int i24 = i15 / 8;
                    if (i24 > 0) {
                        floor /= i24;
                        floor2 /= i24;
                    }
                } else {
                    if (jad_an4 != com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG && jad_an4 != com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG_A) {
                        jad_an4.getClass();
                        int i25 = com.jd.ad.sdk.jad_ju.jad_fs.jad_an.jad_an[jad_an4.ordinal()];
                        if (i25 == 1 || i25 == 2 || i25 == 3) {
                            if (i23 >= 24) {
                                float f4 = i15;
                                floor = java.lang.Math.round(f2 / f4);
                                floor2 = java.lang.Math.round(f3 / f4);
                            }
                        } else if (i14 % i15 == 0 && i13 % i15 == 0) {
                            floor = i14 / i15;
                            floor2 = i13 / i15;
                        } else {
                            int[] jad_bo6 = jad_bo(jad_obVar, options, jad_boVar2, jad_erVar);
                            floor = jad_bo6[0];
                            floor2 = jad_bo6[1];
                        }
                    }
                    float f5 = i15;
                    floor = (int) java.lang.Math.floor(f2 / f5);
                    floor2 = (int) java.lang.Math.floor(f3 / f5);
                }
                i7 = i22;
                double jad_bo7 = jad_ivVar.jad_bo(floor, floor2, i7, i4);
                options.inTargetDensity = jad_bo((jad_bo7 / (r6 / r1)) * jad_bo(jad_an(jad_bo7) * jad_bo7));
                int jad_an6 = jad_an(jad_bo7);
                options.inDensity = jad_an6;
                int i26 = options.inTargetDensity;
                if (i26 > 0 && jad_an6 > 0 && i26 != jad_an6) {
                    i16 = 1;
                    options.inScaled = true;
                } else {
                    i16 = 1;
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (android.util.Log.isLoggable("Downsampler", 2)) {
                    java.lang.Object[] objArr = new java.lang.Object[i16];
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    i6 = i17;
                    sb.append(i6);
                    str3 = "x";
                    sb.append(str3);
                    i5 = i18;
                    sb.append(i5);
                    sb.append("], degreesToRotate: ");
                    sb.append(i21);
                    sb.append(", target: [");
                    sb.append(i7);
                    sb.append(str3);
                    sb.append(i4);
                    sb.append("], power of two scaled: [");
                    sb.append(floor);
                    sb.append(str3);
                    sb.append(floor2);
                    sb.append("], exact scale factor: ");
                    sb.append(jad_bo3);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i15);
                    sb.append(", adjusted scale factor: ");
                    sb.append(jad_bo7);
                    str11 = str9;
                    sb.append(str11);
                    sb.append(options.inTargetDensity);
                    str2 = ", density: ";
                    sb.append(str2);
                    sb.append(options.inDensity);
                    objArr[0] = sb.toString();
                    com.jd.ad.sdk.logger.Logger.v("Downsampler", objArr);
                } else {
                    str2 = ", density: ";
                    str11 = str9;
                    i5 = i18;
                    str3 = "x";
                    i6 = i17;
                }
                str6 = "Downsampler";
                c = 0;
                jad_jwVar = this;
                java.lang.String str12 = str;
                i9 = i6;
                str7 = str6;
                z4 = z8;
                int i27 = i4;
                if (!jad_jwVar.jad_er.jad_an(i7, i4, options, z4, z3)) {
                    if (jad_boVar != com.jd.ad.sdk.jad_ju.jad_bo.PREFER_ARGB_8888) {
                        try {
                            z5 = jad_obVar.jad_an().jad_an;
                        } catch (java.io.IOException e) {
                            if (android.util.Log.isLoggable(str7, 3)) {
                                java.lang.Object[] objArr2 = new java.lang.Object[2];
                                objArr2[c] = "Cannot determine whether the image has alpha or not from header, format " + jad_boVar;
                                objArr2[1] = e;
                                com.jd.ad.sdk.logger.Logger.d(str7, objArr2);
                            }
                            z5 = false;
                        }
                        android.graphics.Bitmap.Config config3 = z5 ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565;
                        options.inPreferredConfig = config3;
                        if (config3 == android.graphics.Bitmap.Config.RGB_565) {
                            options.inDither = true;
                        }
                    } else {
                        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                    }
                }
                i10 = android.os.Build.VERSION.SDK_INT;
                i11 = options.inSampleSize;
                if (i9 >= 0 || i5 < 0 || !z2) {
                    int i28 = options.inTargetDensity;
                    float f6 = !(i28 <= 0 && (i12 = options.inDensity) > 0 && i28 != i12) ? i28 / options.inDensity : 1.0f;
                    float f7 = i11;
                    int ceil = (int) java.lang.Math.ceil(i9 / f7);
                    int ceil2 = (int) java.lang.Math.ceil(i5 / f7);
                    round = java.lang.Math.round(ceil * f6);
                    round2 = java.lang.Math.round(ceil2 * f6);
                    if (android.util.Log.isLoggable(str7, 2)) {
                        java.lang.Object[] objArr3 = new java.lang.Object[1];
                        objArr3[c] = "Calculated target [" + round + str3 + round2 + "] for source [" + i9 + str3 + i5 + "], sampleSize: " + i11 + ", targetDensity: " + options.inTargetDensity + str2 + options.inDensity + ", density multiplier: " + f6;
                        com.jd.ad.sdk.logger.Logger.v(str7, objArr3);
                    }
                } else {
                    round = i7;
                    round2 = i27;
                }
                if (round > 0 && round2 > 0) {
                    com.jd.ad.sdk.jad_ny.jad_er jad_erVar2 = jad_jwVar.jad_an;
                    if (i10 < 26) {
                        android.graphics.Bitmap.Config config4 = options.inPreferredConfig;
                        config2 = android.graphics.Bitmap.Config.HARDWARE;
                        config = config4 != config2 ? options.outConfig : null;
                    }
                    if (config == null) {
                        config = options.inPreferredConfig;
                    }
                    options.inBitmap = jad_erVar2.jad_bo(round, round2, config);
                }
                java.lang.String str13 = str2;
                if (jad_kxVar != null) {
                    if (i10 >= 28) {
                        if (jad_kxVar == com.jd.ad.sdk.jad_ju.jad_kx.DISPLAY_P3 && colorSpace3 != null) {
                            isWideGamut = colorSpace3.isWideGamut();
                            if (isWideGamut) {
                                z7 = true;
                                colorSpace2 = android.graphics.ColorSpace.get(!z7 ? android.graphics.ColorSpace.Named.DISPLAY_P3 : android.graphics.ColorSpace.Named.SRGB);
                                options.inPreferredColorSpace = colorSpace2;
                            }
                        }
                        z7 = false;
                        colorSpace2 = android.graphics.ColorSpace.get(!z7 ? android.graphics.ColorSpace.Named.DISPLAY_P3 : android.graphics.ColorSpace.Named.SRGB);
                        options.inPreferredColorSpace = colorSpace2;
                    } else if (i10 >= 26) {
                        named = android.graphics.ColorSpace.Named.SRGB;
                        colorSpace = android.graphics.ColorSpace.get(named);
                        options.inPreferredColorSpace = colorSpace;
                    }
                }
                jad_an2 = jad_an(jad_obVar, options, jad_boVar2, jad_jwVar.jad_an);
                jad_boVar2.jad_an(jad_jwVar.jad_an, jad_an2);
                if (!android.util.Log.isLoggable(str7, 2)) {
                    java.lang.Object[] objArr4 = new java.lang.Object[1];
                    java.lang.StringBuilder jad_an7 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded ");
                    jad_an7.append(jad_an(jad_an2));
                    jad_an7.append(" from [");
                    jad_an7.append(i9);
                    jad_an7.append(str3);
                    jad_an7.append(i5);
                    jad_an7.append("] ");
                    jad_an7.append(str12);
                    jad_an7.append(" with inBitmap ");
                    jad_an7.append(jad_an(options.inBitmap));
                    jad_an7.append(" for [");
                    jad_an7.append(i);
                    jad_an7.append(str3);
                    jad_an7.append(i2);
                    jad_an7.append("], sample size: ");
                    jad_an7.append(options.inSampleSize);
                    jad_an7.append(str13);
                    jad_an7.append(options.inDensity);
                    jad_an7.append(str11);
                    jad_an7.append(options.inTargetDensity);
                    jad_an7.append(", thread: ");
                    jad_an7.append(java.lang.Thread.currentThread().getName());
                    jad_an7.append(", duration: ");
                    jad_an7.append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an3));
                    objArr4[c] = jad_an7.toString();
                    com.jd.ad.sdk.logger.Logger.v(str7, objArr4);
                }
                if (jad_an2 != null) {
                    return null;
                }
                jad_an2.setDensity(jad_jwVar.jad_bo.densityDpi);
                com.jd.ad.sdk.jad_ny.jad_er jad_erVar3 = jad_jwVar.jad_an;
                switch (jad_cp) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        z6 = true;
                        break;
                    default:
                        z6 = false;
                        break;
                }
                if (z6) {
                    android.graphics.Matrix matrix = new android.graphics.Matrix();
                    switch (jad_cp) {
                        case 2:
                            matrix.setScale(-1.0f, 1.0f);
                            break;
                        case 3:
                            matrix.setRotate(180.0f);
                            break;
                        case 4:
                            f = 1.0f;
                            matrix.setRotate(180.0f);
                            matrix.postScale(-1.0f, f);
                            break;
                        case 5:
                            f = 1.0f;
                            matrix.setRotate(90.0f);
                            matrix.postScale(-1.0f, f);
                            break;
                        case 6:
                            matrix.setRotate(90.0f);
                            break;
                        case 7:
                            matrix.setRotate(-90.0f);
                            f = 1.0f;
                            matrix.postScale(-1.0f, f);
                            break;
                        case 8:
                            matrix.setRotate(-90.0f);
                            break;
                    }
                    android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, jad_an2.getWidth(), jad_an2.getHeight());
                    matrix.mapRect(rectF);
                    android.graphics.Bitmap jad_an8 = jad_erVar3.jad_an(java.lang.Math.round(rectF.width()), java.lang.Math.round(rectF.height()), jad_an2.getConfig() != null ? jad_an2.getConfig() : android.graphics.Bitmap.Config.ARGB_8888);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    jad_an8.setHasAlpha(jad_an2.hasAlpha());
                    java.util.concurrent.locks.Lock lock = com.jd.ad.sdk.jad_te.jad_vi.jad_bo;
                    lock.lock();
                    try {
                        android.graphics.Canvas canvas = new android.graphics.Canvas(jad_an8);
                        canvas.drawBitmap(jad_an2, matrix, com.jd.ad.sdk.jad_te.jad_vi.jad_an);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = jad_an8;
                    } catch (java.lang.Throwable th) {
                        com.jd.ad.sdk.jad_te.jad_vi.jad_bo.unlock();
                        throw th;
                    }
                } else {
                    bitmap = jad_an2;
                }
                if (jad_an2.equals(bitmap)) {
                    return bitmap;
                }
                jad_jwVar.jad_an.jad_an(jad_an2);
                return bitmap;
            }
            i5 = i18;
            str2 = ", density: ";
            i8 = 3;
            str3 = "x";
            i6 = i17;
            int i29 = i19;
            str4 = "Downsampler";
            str5 = "]";
            i7 = i29;
        }
        if (android.util.Log.isLoggable(str4, i8)) {
            c = 0;
            com.jd.ad.sdk.logger.Logger.d(str4, "Unable to determine dimensions for: " + jad_an4 + " with target [" + i7 + str3 + i4 + str5);
        } else {
            c = 0;
        }
        jad_jwVar = this;
        str6 = str4;
        java.lang.String str122 = str;
        i9 = i6;
        str7 = str6;
        z4 = z8;
        int i272 = i4;
        if (!jad_jwVar.jad_er.jad_an(i7, i4, options, z4, z3)) {
        }
        i10 = android.os.Build.VERSION.SDK_INT;
        i11 = options.inSampleSize;
        if (i9 >= 0) {
        }
        int i282 = options.inTargetDensity;
        if (!(i282 <= 0 && (i12 = options.inDensity) > 0 && i282 != i12)) {
        }
        float f72 = i11;
        int ceil3 = (int) java.lang.Math.ceil(i9 / f72);
        int ceil22 = (int) java.lang.Math.ceil(i5 / f72);
        round = java.lang.Math.round(ceil3 * f6);
        round2 = java.lang.Math.round(ceil22 * f6);
        if (android.util.Log.isLoggable(str7, 2)) {
        }
        if (round > 0) {
            com.jd.ad.sdk.jad_ny.jad_er jad_erVar22 = jad_jwVar.jad_an;
            if (i10 < 26) {
            }
            if (config == null) {
            }
            options.inBitmap = jad_erVar22.jad_bo(round, round2, config);
        }
        java.lang.String str132 = str2;
        if (jad_kxVar != null) {
        }
        jad_an2 = jad_an(jad_obVar, options, jad_boVar2, jad_jwVar.jad_an);
        jad_boVar2.jad_an(jad_jwVar.jad_an, jad_an2);
        if (!android.util.Log.isLoggable(str7, 2)) {
        }
        if (jad_an2 != null) {
        }
    }

    public final com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(com.jd.ad.sdk.jad_te.jad_ob jad_obVar, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, com.jd.ad.sdk.jad_te.jad_jw.jad_bo jad_boVar) {
        java.util.Queue<android.graphics.BitmapFactory.Options> queue;
        android.graphics.BitmapFactory.Options options;
        android.graphics.BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.jad_cp.jad_an(65536, byte[].class);
        synchronized (com.jd.ad.sdk.jad_te.jad_jw.class) {
            queue = jad_mz;
            synchronized (queue) {
                options = (android.graphics.BitmapFactory.Options) ((java.util.ArrayDeque) queue).poll();
            }
            if (options == null) {
                options = new android.graphics.BitmapFactory.Options();
                jad_an(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        com.jd.ad.sdk.jad_ju.jad_bo jad_boVar2 = (com.jd.ad.sdk.jad_ju.jad_bo) jad_jwVar.jad_an(jad_fs);
        com.jd.ad.sdk.jad_ju.jad_kx jad_kxVar = (com.jd.ad.sdk.jad_ju.jad_kx) jad_jwVar.jad_an(jad_jt);
        com.jd.ad.sdk.jad_te.jad_iv jad_ivVar = (com.jd.ad.sdk.jad_te.jad_iv) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_iv.jad_dq);
        boolean booleanValue = ((java.lang.Boolean) jad_jwVar.jad_an(jad_hu)).booleanValue();
        com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Boolean> jad_ivVar2 = jad_iv;
        try {
            com.jd.ad.sdk.jad_te.jad_er jad_an2 = com.jd.ad.sdk.jad_te.jad_er.jad_an(jad_an(jad_obVar, options2, jad_ivVar, jad_boVar2, jad_kxVar, jad_jwVar.jad_an(jad_ivVar2) != null && ((java.lang.Boolean) jad_jwVar.jad_an(jad_ivVar2)).booleanValue(), i, i2, booleanValue, jad_boVar), this.jad_an);
            jad_an(options2);
            synchronized (queue) {
                ((java.util.ArrayDeque) queue).offer(options2);
            }
            this.jad_cp.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr);
            return jad_an2;
        } catch (java.lang.Throwable th) {
            jad_an(options2);
            java.util.Queue<android.graphics.BitmapFactory.Options> queue2 = jad_mz;
            synchronized (queue2) {
                ((java.util.ArrayDeque) queue2).offer(options2);
                this.jad_cp.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr);
                throw th;
            }
        }
    }
}
