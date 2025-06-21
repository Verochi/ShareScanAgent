package com.esotericsoftware.spine.utils;

/* loaded from: classes22.dex */
public class SkeletonClipping {
    public final com.esotericsoftware.spine.utils.Triangulator a = new com.esotericsoftware.spine.utils.Triangulator();
    public final com.badlogic.gdx.utils.FloatArray b = new com.badlogic.gdx.utils.FloatArray();
    public final com.badlogic.gdx.utils.FloatArray c = new com.badlogic.gdx.utils.FloatArray(128);
    public final com.badlogic.gdx.utils.FloatArray d = new com.badlogic.gdx.utils.FloatArray(128);
    public final com.badlogic.gdx.utils.ShortArray e = new com.badlogic.gdx.utils.ShortArray(128);
    public final com.badlogic.gdx.utils.FloatArray f = new com.badlogic.gdx.utils.FloatArray();
    public com.esotericsoftware.spine.attachments.ClippingAttachment g;
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> h;

    public static void b(com.badlogic.gdx.utils.FloatArray floatArray) {
        float[] fArr = floatArray.items;
        int i = floatArray.size;
        int i2 = i - 2;
        float f = (fArr[i2] * fArr[1]) - (fArr[0] * fArr[i - 1]);
        int i3 = i - 3;
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i4 + 2;
            f += (fArr[i4] * fArr[i4 + 3]) - (fArr[i5] * fArr[i4 + 1]);
            i4 = i5;
        }
        if (f < 0.0f) {
            return;
        }
        int i6 = i >> 1;
        for (int i7 = 0; i7 < i6; i7 += 2) {
            float f2 = fArr[i7];
            int i8 = i7 + 1;
            float f3 = fArr[i8];
            int i9 = i2 - i7;
            fArr[i7] = fArr[i9];
            int i10 = i9 + 1;
            fArr[i8] = fArr[i10];
            fArr[i9] = f2;
            fArr[i10] = f3;
        }
    }

    public boolean a(float f, float f2, float f3, float f4, float f5, float f6, com.badlogic.gdx.utils.FloatArray floatArray, com.badlogic.gdx.utils.FloatArray floatArray2) {
        com.badlogic.gdx.utils.FloatArray floatArray3;
        com.badlogic.gdx.utils.FloatArray floatArray4;
        float[] fArr;
        int i = 2;
        if (floatArray.size % 4 >= 2) {
            floatArray4 = this.f;
            floatArray3 = floatArray2;
        } else {
            floatArray3 = this.f;
            floatArray4 = floatArray2;
        }
        floatArray3.clear();
        floatArray3.add(f);
        floatArray3.add(f2);
        floatArray3.add(f3);
        floatArray3.add(f4);
        floatArray3.add(f5);
        floatArray3.add(f6);
        floatArray3.add(f);
        floatArray3.add(f2);
        floatArray4.clear();
        float[] fArr2 = floatArray.items;
        int i2 = floatArray.size - 4;
        int i3 = 0;
        boolean z = false;
        while (true) {
            float f7 = fArr2[i3];
            float f8 = fArr2[i3 + 1];
            int i4 = i3 + 2;
            float f9 = fArr2[i4];
            float f10 = fArr2[i3 + 3];
            float f11 = f7 - f9;
            float f12 = f8 - f10;
            float[] fArr3 = floatArray3.items;
            int i5 = floatArray3.size - i;
            int i6 = floatArray4.size;
            boolean z2 = z;
            int i7 = 0;
            while (i7 < i5) {
                float f13 = fArr3[i7];
                float f14 = fArr3[i7 + 1];
                int i8 = i7 + 2;
                int i9 = i5;
                float f15 = fArr3[i8];
                float f16 = fArr3[i7 + 3];
                boolean z3 = ((f16 - f10) * f11) - ((f15 - f9) * f12) > 0.0f;
                if (((f14 - f10) * f11) - ((f13 - f9) * f12) > 0.0f) {
                    if (z3) {
                        floatArray4.add(f15);
                        floatArray4.add(f16);
                        fArr = fArr2;
                        i5 = i9;
                        i7 = i8;
                        fArr2 = fArr;
                    } else {
                        float f17 = f16 - f14;
                        float f18 = f15 - f13;
                        float f19 = ((f8 - f14) * f18) - ((f7 - f13) * f17);
                        float f20 = f9 - f7;
                        float f21 = f10 - f8;
                        float f22 = f19 / ((f17 * f20) - (f18 * f21));
                        floatArray4.add(f7 + (f20 * f22));
                        floatArray4.add(f8 + (f21 * f22));
                    }
                } else if (z3) {
                    float f23 = f16 - f14;
                    float f24 = f15 - f13;
                    float f25 = ((f8 - f14) * f24) - ((f7 - f13) * f23);
                    float f26 = f9 - f7;
                    float f27 = f10 - f8;
                    float f28 = f25 / ((f23 * f26) - (f24 * f27));
                    fArr = fArr2;
                    floatArray4.add(f7 + (f26 * f28));
                    floatArray4.add(f8 + (f27 * f28));
                    floatArray4.add(f15);
                    floatArray4.add(f16);
                    z2 = true;
                    i5 = i9;
                    i7 = i8;
                    fArr2 = fArr;
                }
                fArr = fArr2;
                z2 = true;
                i5 = i9;
                i7 = i8;
                fArr2 = fArr;
            }
            float[] fArr4 = fArr2;
            if (i6 == floatArray4.size) {
                floatArray2.clear();
                return true;
            }
            floatArray4.add(floatArray4.items[0]);
            floatArray4.add(floatArray4.items[1]);
            if (i3 == i2) {
                if (floatArray2 != floatArray4) {
                    floatArray2.clear();
                    floatArray2.addAll(floatArray4.items, 0, floatArray4.size - 2);
                } else {
                    floatArray2.setSize(floatArray2.size - 2);
                }
                return z2;
            }
            floatArray3.clear();
            i3 = i4;
            z = z2;
            fArr2 = fArr4;
            i = 2;
            com.badlogic.gdx.utils.FloatArray floatArray5 = floatArray4;
            floatArray4 = floatArray3;
            floatArray3 = floatArray5;
        }
    }

    public void clipEnd() {
        if (this.g == null) {
            return;
        }
        this.g = null;
        this.h = null;
        this.d.clear();
        this.e.clear();
        this.b.clear();
    }

    public void clipEnd(com.esotericsoftware.spine.Slot slot) {
        com.esotericsoftware.spine.attachments.ClippingAttachment clippingAttachment = this.g;
        if (clippingAttachment == null || clippingAttachment.getEndSlot() != slot.getData()) {
            return;
        }
        clipEnd();
    }

    public int clipStart(com.esotericsoftware.spine.Slot slot, com.esotericsoftware.spine.attachments.ClippingAttachment clippingAttachment) {
        int worldVerticesLength;
        if (this.g != null || (worldVerticesLength = clippingAttachment.getWorldVerticesLength()) < 6) {
            return 0;
        }
        this.g = clippingAttachment;
        clippingAttachment.computeWorldVertices(slot, 0, worldVerticesLength, this.b.setSize(worldVerticesLength), 0, 2);
        b(this.b);
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> a = this.a.a(this.b, this.a.d(this.b));
        this.h = a;
        java.util.Iterator<com.badlogic.gdx.utils.FloatArray> it = a.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.FloatArray next = it.next();
            b(next);
            next.add(next.items[0]);
            next.add(next.items[1]);
        }
        return this.h.size;
    }

    public void clipTriangles(float[] fArr, int i, short[] sArr, int i2, float[] fArr2, float f, float f2, boolean z) {
        int i3;
        int i4;
        com.badlogic.gdx.utils.FloatArray floatArray = this.c;
        com.badlogic.gdx.utils.FloatArray floatArray2 = this.d;
        com.badlogic.gdx.utils.ShortArray shortArray = this.e;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array = this.h;
        com.badlogic.gdx.utils.FloatArray[] floatArrayArr = array.items;
        int i5 = array.size;
        int i6 = z ? 6 : 5;
        floatArray2.clear();
        shortArray.clear();
        int i7 = i2;
        short s2 = 0;
        int i8 = 0;
        while (i8 < i7) {
            int i9 = sArr[i8] << 1;
            float f3 = fArr[i9];
            int i10 = i9 + 1;
            float f4 = fArr[i10];
            float f5 = fArr2[i9];
            float f6 = fArr2[i10];
            int i11 = sArr[i8 + 1] << 1;
            float f7 = fArr[i11];
            int i12 = i11 + 1;
            float f8 = fArr[i12];
            float f9 = fArr2[i11];
            float f10 = fArr2[i12];
            int i13 = sArr[i8 + 2] << 1;
            float f11 = fArr[i13];
            int i14 = i13 + 1;
            float f12 = fArr[i14];
            float f13 = fArr2[i13];
            float f14 = fArr2[i14];
            short s3 = s2;
            int i15 = 0;
            while (true) {
                if (i15 >= i5) {
                    i3 = i8;
                    s2 = s3;
                    break;
                }
                int i16 = floatArray2.size;
                int i17 = i15;
                i3 = i8;
                if (a(f3, f4, f7, f8, f11, f12, floatArrayArr[i15], floatArray)) {
                    int i18 = floatArray.size;
                    if (i18 != 0) {
                        float f15 = f8 - f12;
                        float f16 = f11 - f7;
                        float f17 = f3 - f11;
                        float f18 = f12 - f4;
                        float f19 = 1.0f / ((f15 * f17) + ((f4 - f12) * f16));
                        int i19 = i18 >> 1;
                        float[] fArr3 = floatArray.items;
                        float[] size = floatArray2.setSize(i16 + (i19 * i6));
                        for (int i20 = 0; i20 < i18; i20 += 2) {
                            float f20 = fArr3[i20];
                            float f21 = fArr3[i20 + 1];
                            size[i16] = f20;
                            size[i16 + 1] = f21;
                            size[i16 + 2] = f;
                            if (z) {
                                size[i16 + 3] = f2;
                                i4 = i16 + 4;
                            } else {
                                i4 = i16 + 3;
                            }
                            float f22 = f20 - f11;
                            float f23 = f21 - f12;
                            float f24 = ((f15 * f22) + (f16 * f23)) * f19;
                            float f25 = ((f22 * f18) + (f23 * f17)) * f19;
                            float f26 = (1.0f - f24) - f25;
                            size[i4] = (f5 * f24) + (f9 * f25) + (f13 * f26);
                            size[i4 + 1] = (f24 * f6) + (f25 * f10) + (f26 * f14);
                            i16 = i4 + 2;
                        }
                        int i21 = shortArray.size;
                        short[] size2 = shortArray.setSize(((i19 - 2) * 3) + i21);
                        int i22 = i19 - 1;
                        for (int i23 = 1; i23 < i22; i23++) {
                            size2[i21] = s3;
                            int i24 = s3 + i23;
                            size2[i21 + 1] = (short) i24;
                            size2[i21 + 2] = (short) (i24 + 1);
                            i21 += 3;
                        }
                        s3 = (short) (s3 + i22 + 1);
                    }
                    i15 = i17 + 1;
                    i8 = i3;
                } else {
                    float[] size3 = floatArray2.setSize(i16 + (i6 * 3));
                    size3[i16] = f3;
                    size3[i16 + 1] = f4;
                    size3[i16 + 2] = f;
                    if (z) {
                        size3[i16 + 3] = f2;
                        size3[i16 + 4] = f5;
                        size3[i16 + 5] = f6;
                        size3[i16 + 6] = f7;
                        size3[i16 + 7] = f8;
                        size3[i16 + 8] = f;
                        size3[i16 + 9] = f2;
                        size3[i16 + 10] = f9;
                        size3[i16 + 11] = f10;
                        size3[i16 + 12] = f11;
                        size3[i16 + 13] = f12;
                        size3[i16 + 14] = f;
                        size3[i16 + 15] = f2;
                        size3[i16 + 16] = f13;
                        size3[i16 + 17] = f14;
                    } else {
                        size3[i16 + 3] = f5;
                        size3[i16 + 4] = f6;
                        size3[i16 + 5] = f7;
                        size3[i16 + 6] = f8;
                        size3[i16 + 7] = f;
                        size3[i16 + 8] = f9;
                        size3[i16 + 9] = f10;
                        size3[i16 + 10] = f11;
                        size3[i16 + 11] = f12;
                        size3[i16 + 12] = f;
                        size3[i16 + 13] = f13;
                        size3[i16 + 14] = f14;
                    }
                    int i25 = shortArray.size;
                    short[] size4 = shortArray.setSize(i25 + 3);
                    size4[i25] = s3;
                    size4[i25 + 1] = (short) (s3 + 1);
                    size4[i25 + 2] = (short) (s3 + 2);
                    s2 = (short) (s3 + 3);
                }
            }
            i8 = i3 + 3;
            i7 = i2;
        }
    }

    public com.badlogic.gdx.utils.ShortArray getClippedTriangles() {
        return this.e;
    }

    public com.badlogic.gdx.utils.FloatArray getClippedVertices() {
        return this.d;
    }

    public boolean isClipping() {
        return this.g != null;
    }
}
