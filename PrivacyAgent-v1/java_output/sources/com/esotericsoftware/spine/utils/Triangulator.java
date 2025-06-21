package com.esotericsoftware.spine.utils;

/* loaded from: classes22.dex */
class Triangulator {
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> a = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.ShortArray> b = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.ShortArray c = new com.badlogic.gdx.utils.ShortArray();
    public final com.badlogic.gdx.utils.BooleanArray d = new com.badlogic.gdx.utils.BooleanArray();
    public final com.badlogic.gdx.utils.ShortArray e = new com.badlogic.gdx.utils.ShortArray();
    public final com.badlogic.gdx.utils.Pool<com.badlogic.gdx.utils.FloatArray> f = new com.esotericsoftware.spine.utils.Triangulator.AnonymousClass1();
    public final com.badlogic.gdx.utils.Pool<com.badlogic.gdx.utils.ShortArray> g = new com.esotericsoftware.spine.utils.Triangulator.AnonymousClass2();

    /* renamed from: com.esotericsoftware.spine.utils.Triangulator$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.utils.Pool {
        public AnonymousClass1() {
        }

        @Override // com.badlogic.gdx.utils.Pool
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.badlogic.gdx.utils.FloatArray newObject() {
            return new com.badlogic.gdx.utils.FloatArray(16);
        }
    }

    /* renamed from: com.esotericsoftware.spine.utils.Triangulator$2, reason: invalid class name */
    public class AnonymousClass2 extends com.badlogic.gdx.utils.Pool {
        public AnonymousClass2() {
        }

        @Override // com.badlogic.gdx.utils.Pool
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.badlogic.gdx.utils.ShortArray newObject() {
            return new com.badlogic.gdx.utils.ShortArray(16);
        }
    }

    public static boolean b(int i, int i2, float[] fArr, short[] sArr) {
        int i3 = sArr[((i2 + i) - 1) % i2] << 1;
        int i4 = sArr[i] << 1;
        int i5 = sArr[(i + 1) % i2] << 1;
        return !c(fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1], fArr[i5], fArr[i5 + 1]);
    }

    public static boolean c(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f * (f6 - f4)) + (f3 * (f2 - f6))) + (f5 * (f4 - f2)) >= 0.0f;
    }

    public static int e(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f3 - f;
        float f8 = f4 - f2;
        return (((f5 * f8) - (f6 * f7)) + (f7 * f2)) - (f * f8) >= 0.0f ? 1 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> a(com.badlogic.gdx.utils.FloatArray floatArray, com.badlogic.gdx.utils.ShortArray shortArray) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.ShortArray> array;
        int i;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.ShortArray> array2;
        int i2;
        int i3;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array3;
        com.badlogic.gdx.utils.ShortArray shortArray2;
        int i4;
        int i5;
        boolean z;
        float[] fArr = floatArray.items;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array4 = this.a;
        this.f.freeAll(array4);
        array4.clear();
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.ShortArray> array5 = this.b;
        this.g.freeAll(array5);
        array5.clear();
        com.badlogic.gdx.utils.ShortArray obtain = this.g.obtain();
        obtain.clear();
        com.badlogic.gdx.utils.FloatArray obtain2 = this.f.obtain();
        obtain2.clear();
        short[] sArr = shortArray.items;
        int i6 = shortArray.size;
        int i7 = -1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = sArr[i8] << 1;
            int i11 = sArr[i8 + 1] << 1;
            int i12 = sArr[i8 + 2] << 1;
            float f = fArr[i10];
            float f2 = fArr[i10 + 1];
            int i13 = i6;
            float f3 = fArr[i11];
            short[] sArr2 = sArr;
            float f4 = fArr[i11 + 1];
            int i14 = i8;
            float f5 = fArr[i12];
            float f6 = fArr[i12 + 1];
            float[] fArr2 = fArr;
            if (i7 == i10) {
                int i15 = obtain2.size - 4;
                i5 = i7;
                float[] fArr3 = obtain2.items;
                int e = e(fArr3[i15], fArr3[i15 + 1], fArr3[i15 + 2], fArr3[i15 + 3], f5, f6);
                int e2 = e(f5, f6, fArr3[0], fArr3[1], fArr3[2], fArr3[3]);
                if (e == i9 && e2 == i9) {
                    obtain2.add(f5);
                    obtain2.add(f6);
                    obtain.add(i12);
                    z = true;
                    if (z) {
                        if (obtain2.size > 0) {
                            array4.add(obtain2);
                            array5.add(obtain);
                        } else {
                            this.f.free(obtain2);
                            this.g.free(obtain);
                        }
                        com.badlogic.gdx.utils.FloatArray obtain3 = this.f.obtain();
                        obtain3.clear();
                        obtain3.add(f);
                        obtain3.add(f2);
                        obtain3.add(f3);
                        obtain3.add(f4);
                        obtain3.add(f5);
                        obtain3.add(f6);
                        obtain = this.g.obtain();
                        obtain.clear();
                        obtain.add(i10);
                        obtain.add(i11);
                        obtain.add(i12);
                        i9 = e(f, f2, f3, f4, f5, f6);
                        obtain2 = obtain3;
                        i7 = i10;
                    } else {
                        i7 = i5;
                    }
                    i8 = i14 + 3;
                    i6 = i13;
                    sArr = sArr2;
                    fArr = fArr2;
                }
            } else {
                i5 = i7;
            }
            z = false;
            if (z) {
            }
            i8 = i14 + 3;
            i6 = i13;
            sArr = sArr2;
            fArr = fArr2;
        }
        if (obtain2.size > 0) {
            array4.add(obtain2);
            array5.add(obtain);
        }
        int i16 = array4.size;
        int i17 = 0;
        while (i17 < i16) {
            com.badlogic.gdx.utils.ShortArray shortArray3 = array5.get(i17);
            if (shortArray3.size != 0) {
                short s2 = shortArray3.get(0);
                short s3 = shortArray3.get(shortArray3.size - 1);
                com.badlogic.gdx.utils.FloatArray floatArray2 = array4.get(i17);
                int i18 = floatArray2.size - 4;
                float[] fArr4 = floatArray2.items;
                float f7 = fArr4[i18];
                float f8 = fArr4[i18 + 1];
                float f9 = fArr4[i18 + 2];
                float f10 = fArr4[i18 + 3];
                float f11 = fArr4[0];
                float f12 = fArr4[1];
                float f13 = fArr4[2];
                float f14 = fArr4[3];
                int e3 = e(f7, f8, f9, f10, f11, f12);
                int i19 = 0;
                while (i19 < i16) {
                    if (i19 == i17) {
                        i = i16;
                        i2 = i17;
                        array3 = array4;
                        array2 = array5;
                    } else {
                        i = i16;
                        com.badlogic.gdx.utils.ShortArray shortArray4 = array5.get(i19);
                        array2 = array5;
                        if (shortArray4.size != 3) {
                            i2 = i17;
                            array3 = array4;
                        } else {
                            short s4 = shortArray4.get(0);
                            i2 = i17;
                            short s5 = shortArray4.get(1);
                            com.badlogic.gdx.utils.ShortArray shortArray5 = shortArray3;
                            short s6 = shortArray4.get(2);
                            i3 = i19;
                            com.badlogic.gdx.utils.FloatArray floatArray3 = array4.get(i19);
                            array3 = array4;
                            float f15 = floatArray3.get(floatArray3.size - 2);
                            float f16 = floatArray3.get(floatArray3.size - 1);
                            if (s4 == s2 && s5 == s3) {
                                int e4 = e(f7, f8, f9, f10, f15, f16);
                                int e5 = e(f15, f16, f11, f12, f13, f14);
                                if (e4 == e3 && e5 == e3) {
                                    floatArray3.clear();
                                    shortArray4.clear();
                                    floatArray2.add(f15);
                                    floatArray2.add(f16);
                                    shortArray2 = shortArray5;
                                    shortArray2.add((int) s6);
                                    f8 = f10;
                                    f7 = f9;
                                    i4 = 0;
                                    f9 = f15;
                                    f10 = f16;
                                    i19 = i4 + 1;
                                    shortArray3 = shortArray2;
                                    i16 = i;
                                    array5 = array2;
                                    i17 = i2;
                                    array4 = array3;
                                }
                            }
                            shortArray2 = shortArray5;
                            i4 = i3;
                            i19 = i4 + 1;
                            shortArray3 = shortArray2;
                            i16 = i;
                            array5 = array2;
                            i17 = i2;
                            array4 = array3;
                        }
                    }
                    shortArray2 = shortArray3;
                    i3 = i19;
                    i4 = i3;
                    i19 = i4 + 1;
                    shortArray3 = shortArray2;
                    i16 = i;
                    array5 = array2;
                    i17 = i2;
                    array4 = array3;
                }
            }
            i17++;
            i16 = i16;
            array5 = array5;
            array4 = array4;
        }
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array6 = array4;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.ShortArray> array7 = array5;
        int i20 = array6.size - 1;
        while (i20 >= 0) {
            com.badlogic.gdx.utils.FloatArray floatArray4 = array6.get(i20);
            if (floatArray4.size == 0) {
                array6.removeIndex(i20);
                this.f.free(floatArray4);
                array = array7;
                this.g.free(array.removeIndex(i20));
            } else {
                array = array7;
            }
            i20--;
            array7 = array;
        }
        return array6;
    }

    public com.badlogic.gdx.utils.ShortArray d(com.badlogic.gdx.utils.FloatArray floatArray) {
        float[] fArr = floatArray.items;
        int i = floatArray.size >> 1;
        com.badlogic.gdx.utils.ShortArray shortArray = this.c;
        shortArray.clear();
        short[] size = shortArray.setSize(i);
        for (short s2 = 0; s2 < i; s2 = (short) (s2 + 1)) {
            size[s2] = s2;
        }
        com.badlogic.gdx.utils.BooleanArray booleanArray = this.d;
        boolean[] size2 = booleanArray.setSize(i);
        for (int i2 = 0; i2 < i; i2++) {
            size2[i2] = b(i2, i, fArr, size);
        }
        com.badlogic.gdx.utils.ShortArray shortArray2 = this.e;
        shortArray2.clear();
        shortArray2.ensureCapacity(java.lang.Math.max(0, i - 2) << 2);
        while (i > 3) {
            int i3 = i - 1;
            int i4 = 0;
            int i5 = 1;
            while (true) {
                if (!size2[i4]) {
                    int i6 = size[i3] << 1;
                    int i7 = size[i4] << 1;
                    int i8 = size[i5] << 1;
                    float f = fArr[i6];
                    float f2 = fArr[i6 + 1];
                    float f3 = fArr[i7];
                    float f4 = fArr[i7 + 1];
                    float f5 = fArr[i8];
                    float f6 = fArr[i8 + 1];
                    for (int i9 = (i5 + 1) % i; i9 != i3; i9 = (i9 + 1) % i) {
                        if (size2[i9]) {
                            int i10 = size[i9] << 1;
                            float f7 = fArr[i10];
                            float f8 = fArr[i10 + 1];
                            if (c(f5, f6, f, f2, f7, f8) && c(f, f2, f3, f4, f7, f8) && c(f3, f4, f5, f6, f7, f8)) {
                            }
                        }
                    }
                    break;
                }
                if (i5 == 0) {
                    while (size2[i4] && i4 - 1 > 0) {
                    }
                } else {
                    i3 = i4;
                    i4 = i5;
                    i5 = (i5 + 1) % i;
                }
            }
            shortArray2.add(size[((i + i4) - 1) % i]);
            shortArray2.add(size[i4]);
            shortArray2.add(size[(i4 + 1) % i]);
            shortArray.removeIndex(i4);
            booleanArray.removeIndex(i4);
            i--;
            int i11 = ((i + i4) - 1) % i;
            if (i4 == i) {
                i4 = 0;
            }
            size2[i11] = b(i11, i, fArr, size);
            size2[i4] = b(i4, i, fArr, size);
        }
        if (i == 3) {
            shortArray2.add(size[2]);
            shortArray2.add(size[0]);
            shortArray2.add(size[1]);
        }
        return shortArray2;
    }
}
