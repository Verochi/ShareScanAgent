package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class c {

    /* renamed from: com.anythink.core.common.o.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.graphics.Bitmap b;
        final /* synthetic */ com.anythink.core.common.o.c.a c;

        /* renamed from: com.anythink.core.common.o.c$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01681 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap a;

            public RunnableC01681(android.graphics.Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.o.c.a aVar = com.anythink.core.common.o.c.AnonymousClass1.this.c;
                if (aVar != null) {
                    android.graphics.Bitmap bitmap = this.a;
                    if (bitmap != null) {
                        aVar.a(bitmap);
                    } else {
                        aVar.a();
                    }
                }
            }
        }

        public AnonymousClass1(android.content.Context context, android.graphics.Bitmap bitmap, com.anythink.core.common.o.c.a aVar) {
            this.a = context;
            this.b = bitmap;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.b.o.a().b(new com.anythink.core.common.o.c.AnonymousClass1.RunnableC01681(com.anythink.core.common.o.c.a(this.a, this.b)));
        }
    }

    public interface a {
        void a();

        void a(android.graphics.Bitmap bitmap);
    }

    private static int a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i3 <= 0 && i4 <= 0) {
            return 1;
        }
        while (i / i5 > i3 && i2 / i5 > i4) {
            i5 *= 2;
        }
        return i5;
    }

    private static android.graphics.Bitmap a(android.content.Context context, int i, int i2, int i3) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeResource(context.getResources(), i, options);
            options.inSampleSize = a(options.outWidth, options.outHeight, i2, i3);
            options.inJustDecodeBounds = false;
            return android.graphics.BitmapFactory.decodeResource(context.getResources(), i, options);
        } catch (java.lang.OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.graphics.Bitmap a(android.content.Context context, android.graphics.Bitmap bitmap) {
        android.renderscript.RenderScript renderScript;
        android.renderscript.Allocation allocation;
        ?? r2;
        android.renderscript.Allocation allocation2;
        if (bitmap.isRecycled()) {
            com.anythink.core.common.n.c.a("Error", "Error, cannot access an invalid/free'd bitmap here!", com.anythink.core.common.b.o.a().q());
            return null;
        }
        try {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth() / 3, bitmap.getHeight() / 3, android.graphics.Bitmap.Config.ARGB_8888);
            renderScript = android.renderscript.RenderScript.create(context);
            try {
                r2 = android.renderscript.ScriptIntrinsicBlur.create(renderScript, android.renderscript.Element.U8_4(renderScript));
                try {
                    allocation = android.renderscript.Allocation.createFromBitmap(renderScript, bitmap);
                    try {
                        allocation2 = android.renderscript.Allocation.createFromBitmap(renderScript, createBitmap);
                        try {
                            r2.setRadius(25.0f);
                            r2.setInput(allocation);
                            r2.forEach(allocation2);
                            allocation2.copyTo(createBitmap);
                            new android.graphics.Canvas(createBitmap).drawColor(855638016);
                            if (renderScript != null) {
                                try {
                                    renderScript.destroy();
                                } catch (java.lang.Throwable unused) {
                                }
                            }
                            try {
                                r2.destroy();
                            } catch (java.lang.Throwable unused2) {
                            }
                            if (allocation != null) {
                                try {
                                    allocation.destroy();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            try {
                                allocation2.destroy();
                            } catch (java.lang.Throwable unused4) {
                            }
                            return createBitmap;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                                if (renderScript != null) {
                                    try {
                                        renderScript.destroy();
                                    } catch (java.lang.Throwable unused5) {
                                    }
                                }
                                if (r2 != 0) {
                                    try {
                                        r2.destroy();
                                    } catch (java.lang.Throwable unused6) {
                                    }
                                }
                                if (allocation != null) {
                                    try {
                                        allocation.destroy();
                                    } catch (java.lang.Throwable unused7) {
                                    }
                                }
                                if (allocation2 != null) {
                                    try {
                                        allocation2.destroy();
                                    } catch (java.lang.Throwable unused8) {
                                    }
                                }
                                return null;
                            } finally {
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        allocation2 = null;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    allocation = null;
                    allocation2 = null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                allocation = null;
                r2 = allocation;
                allocation2 = r2;
                th.printStackTrace();
                if (renderScript != null) {
                }
                if (r2 != 0) {
                }
                if (allocation != null) {
                }
                if (allocation2 != null) {
                }
                return null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            renderScript = null;
            allocation = null;
        }
    }

    private static android.graphics.Bitmap a(android.graphics.Bitmap bitmap) {
        int i;
        int[] iArr;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[java.lang.Math.max(width, height)];
        int[] iArr7 = new int[173056];
        for (int i5 = 0; i5 < 173056; i5++) {
            iArr7[i5] = i5 / 676;
        }
        int[][] iArr8 = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Integer.TYPE, 51, 3);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i6 >= height) {
                break;
            }
            int i9 = -25;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 25; i9 <= i19; i19 = 25) {
                int i20 = height;
                int i21 = iArr2[java.lang.Math.min(i3, java.lang.Math.max(i9, 0)) + i7];
                int[] iArr9 = iArr8[i9 + 25];
                iArr9[0] = (i21 & 16711680) >> 16;
                iArr9[1] = (i21 & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i21 & 255;
                int abs = 26 - java.lang.Math.abs(i9);
                int i22 = iArr9[0];
                i10 += i22 * abs;
                int i23 = iArr9[1];
                i11 += i23 * abs;
                int i24 = iArr9[2];
                i12 += abs * i24;
                if (i9 > 0) {
                    i16 += i22;
                    i17 += i23;
                    i18 += i24;
                } else {
                    i13 += i22;
                    i14 += i23;
                    i15 += i24;
                }
                i9++;
                height = i20;
            }
            int i25 = height;
            int i26 = 25;
            int i27 = 0;
            while (i27 < width) {
                iArr3[i7] = iArr7[i10];
                iArr4[i7] = iArr7[i11];
                iArr5[i7] = iArr7[i12];
                int i28 = i10 - i13;
                int i29 = i11 - i14;
                int i30 = i12 - i15;
                int[] iArr10 = iArr8[((i26 - 25) + 51) % 51];
                int i31 = i13 - iArr10[0];
                int i32 = i14 - iArr10[1];
                int i33 = i15 - iArr10[2];
                if (i6 == 0) {
                    iArr = iArr7;
                    iArr6[i27] = java.lang.Math.min(i27 + 25 + 1, i3);
                } else {
                    iArr = iArr7;
                }
                int i34 = iArr2[iArr6[i27] + i8];
                int i35 = (i34 & 16711680) >> 16;
                iArr10[0] = i35;
                int i36 = (i34 & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[1] = i36;
                int i37 = i34 & 255;
                iArr10[2] = i37;
                int i38 = i16 + i35;
                int i39 = i17 + i36;
                int i40 = i18 + i37;
                i10 = i28 + i38;
                i11 = i29 + i39;
                i12 = i30 + i40;
                i26 = (i26 + 1) % 51;
                int[] iArr11 = iArr8[i26 % 51];
                int i41 = iArr11[0];
                i13 = i31 + i41;
                int i42 = iArr11[1];
                i14 = i32 + i42;
                int i43 = iArr11[2];
                i15 = i33 + i43;
                i16 = i38 - i41;
                i17 = i39 - i42;
                i18 = i40 - i43;
                i7++;
                i27++;
                iArr7 = iArr;
            }
            i8 += width;
            i6++;
            height = i25;
        }
        int[] iArr12 = iArr7;
        int i44 = height;
        int i45 = 0;
        while (i45 < width) {
            int i46 = width * (-25);
            int[] iArr13 = iArr6;
            int[] iArr14 = iArr2;
            int i47 = -25;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            for (int i57 = 25; i47 <= i57; i57 = 25) {
                int max = java.lang.Math.max(0, i46) + i45;
                int[] iArr15 = iArr8[i47 + 25];
                iArr15[0] = iArr3[max];
                iArr15[1] = iArr4[max];
                iArr15[2] = iArr5[max];
                int abs2 = 26 - java.lang.Math.abs(i47);
                i48 += iArr3[max] * abs2;
                i49 += iArr4[max] * abs2;
                i50 += iArr5[max] * abs2;
                if (i47 > 0) {
                    i54 += iArr15[0];
                    i55 += iArr15[1];
                    i56 += iArr15[2];
                } else {
                    i51 += iArr15[0];
                    i52 += iArr15[1];
                    i53 += iArr15[2];
                }
                if (i47 < i4) {
                    i46 += width;
                }
                i47++;
            }
            int i58 = i45;
            int i59 = i44;
            int i60 = 0;
            int i61 = 25;
            while (i60 < i59) {
                iArr14[i58] = (iArr14[i58] & androidx.core.view.ViewCompat.MEASURED_STATE_MASK) | (iArr12[i48] << 16) | (iArr12[i49] << 8) | iArr12[i50];
                int i62 = i48 - i51;
                int i63 = i49 - i52;
                int i64 = i50 - i53;
                int[] iArr16 = iArr8[((i61 - 25) + 51) % 51];
                int i65 = i51 - iArr16[0];
                int i66 = i52 - iArr16[1];
                int i67 = i53 - iArr16[2];
                if (i45 == 0) {
                    i = i59;
                    iArr13[i60] = java.lang.Math.min(i60 + 26, i4) * width;
                } else {
                    i = i59;
                }
                int i68 = iArr13[i60] + i45;
                int i69 = iArr3[i68];
                iArr16[0] = i69;
                int i70 = iArr4[i68];
                iArr16[1] = i70;
                int i71 = iArr5[i68];
                iArr16[2] = i71;
                int i72 = i54 + i69;
                int i73 = i55 + i70;
                int i74 = i56 + i71;
                i48 = i62 + i72;
                i49 = i63 + i73;
                i50 = i64 + i74;
                i61 = (i61 + 1) % 51;
                int[] iArr17 = iArr8[i61];
                int i75 = iArr17[0];
                i51 = i65 + i75;
                int i76 = iArr17[1];
                i52 = i66 + i76;
                int i77 = iArr17[2];
                i53 = i67 + i77;
                i54 = i72 - i75;
                i55 = i73 - i76;
                i56 = i74 - i77;
                i58 += width;
                i60++;
                i59 = i;
            }
            i44 = i59;
            i45++;
            iArr6 = iArr13;
            iArr2 = iArr14;
        }
        bitmap.setPixels(iArr2, 0, width, 0, 0, width, i44);
        return bitmap;
    }

    public static android.graphics.Bitmap a(java.io.FileDescriptor fileDescriptor, int i, int i2) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            options.inSampleSize = a(options.outWidth, options.outHeight, i, i2);
            options.inJustDecodeBounds = false;
            return android.graphics.BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        } catch (java.lang.OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static android.graphics.Bitmap a(java.lang.String str, int i, int i2) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            options.inSampleSize = a(options.outWidth, options.outHeight, i, i2);
            options.inJustDecodeBounds = false;
            return android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.OutOfMemoryError unused) {
            return null;
        }
    }

    public static void a(android.content.Context context, android.graphics.Bitmap bitmap, com.anythink.core.common.o.c.a aVar) {
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.c(new com.anythink.core.common.o.c.AnonymousClass1(context, bitmap, aVar));
    }

    public static int[] a(java.lang.String str) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            return new int[]{options.outWidth, options.outHeight};
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.OutOfMemoryError unused) {
            return null;
        }
    }
}
