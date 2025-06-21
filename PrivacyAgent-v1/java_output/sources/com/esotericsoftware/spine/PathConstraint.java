package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class PathConstraint implements com.esotericsoftware.spine.Constraint {
    public final com.esotericsoftware.spine.PathConstraintData a;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> b;
    public com.esotericsoftware.spine.Slot c;
    public float d;
    public float e;
    public float f;
    public float g;
    public final com.badlogic.gdx.utils.FloatArray h;
    public final com.badlogic.gdx.utils.FloatArray i;
    public final com.badlogic.gdx.utils.FloatArray j;
    public final com.badlogic.gdx.utils.FloatArray k;
    public final com.badlogic.gdx.utils.FloatArray l;
    public final float[] m;

    public PathConstraint(com.esotericsoftware.spine.PathConstraint pathConstraint, com.esotericsoftware.spine.Skeleton skeleton) {
        this.h = new com.badlogic.gdx.utils.FloatArray();
        this.i = new com.badlogic.gdx.utils.FloatArray();
        this.j = new com.badlogic.gdx.utils.FloatArray();
        this.k = new com.badlogic.gdx.utils.FloatArray();
        this.l = new com.badlogic.gdx.utils.FloatArray();
        this.m = new float[10];
        if (pathConstraint == null) {
            throw new java.lang.IllegalArgumentException("constraint cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = pathConstraint.a;
        this.b = new com.badlogic.gdx.utils.Array<>(pathConstraint.b.size);
        java.util.Iterator<com.esotericsoftware.spine.Bone> it = pathConstraint.b.iterator();
        while (it.hasNext()) {
            this.b.add(skeleton.b.get(it.next().a.a));
        }
        this.c = skeleton.c.get(pathConstraint.c.a.a);
        this.d = pathConstraint.d;
        this.e = pathConstraint.e;
        this.f = pathConstraint.f;
        this.g = pathConstraint.g;
    }

    public PathConstraint(com.esotericsoftware.spine.PathConstraintData pathConstraintData, com.esotericsoftware.spine.Skeleton skeleton) {
        this.h = new com.badlogic.gdx.utils.FloatArray();
        this.i = new com.badlogic.gdx.utils.FloatArray();
        this.j = new com.badlogic.gdx.utils.FloatArray();
        this.k = new com.badlogic.gdx.utils.FloatArray();
        this.l = new com.badlogic.gdx.utils.FloatArray();
        this.m = new float[10];
        if (pathConstraintData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = pathConstraintData;
        this.b = new com.badlogic.gdx.utils.Array<>(pathConstraintData.c.size);
        java.util.Iterator<com.esotericsoftware.spine.BoneData> it = pathConstraintData.c.iterator();
        while (it.hasNext()) {
            this.b.add(skeleton.findBone(it.next().b));
        }
        this.c = skeleton.findSlot(pathConstraintData.d.b);
        this.d = pathConstraintData.i;
        this.e = pathConstraintData.j;
        this.f = pathConstraintData.k;
        this.g = pathConstraintData.l;
    }

    public final void a(float f, float[] fArr, int i, float[] fArr2, int i2) {
        float f2 = fArr[i + 2];
        float f3 = fArr[i + 3];
        float atan2 = (float) java.lang.Math.atan2(f3 - fArr[i + 1], f2 - fArr[i]);
        double d = atan2;
        fArr2[i2] = f2 + (((float) java.lang.Math.cos(d)) * f);
        fArr2[i2 + 1] = f3 + (f * ((float) java.lang.Math.sin(d)));
        fArr2[i2 + 2] = atan2;
    }

    public void apply() {
        update();
    }

    public final void b(float f, float[] fArr, int i, float[] fArr2, int i2) {
        float f2 = fArr[i];
        float f3 = fArr[i + 1];
        float atan2 = (float) java.lang.Math.atan2(fArr[i + 3] - f3, fArr[i + 2] - f2);
        double d = atan2;
        fArr2[i2] = f2 + (((float) java.lang.Math.cos(d)) * f);
        fArr2[i2 + 1] = f3 + (f * ((float) java.lang.Math.sin(d)));
        fArr2[i2 + 2] = atan2;
    }

    public final void c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float[] fArr, int i, boolean z) {
        float f10 = 1.0E-5f;
        if (f >= 1.0E-5f && !java.lang.Float.isNaN(f)) {
            f10 = f;
        }
        float f11 = f10 * f10 * f10;
        float f12 = 1.0f - f10;
        float f13 = f12 * f12 * f12;
        float f14 = 3.0f * f12 * f10;
        float f15 = f12 * f14;
        float f16 = f14 * f10;
        float f17 = (f2 * f13) + (f4 * f15) + (f6 * f16) + (f8 * f11);
        fArr[i] = f17;
        fArr[i + 1] = (f13 * f3) + (f15 * f5) + (f7 * f16) + (f11 * f9);
        if (z) {
            fArr[i + 2] = (float) java.lang.Math.atan2(r5 - (((f3 * r4) + ((f5 * r6) * 2.0f)) + (f7 * r1)), f17 - (((f2 * r4) + ((f4 * r6) * 2.0f)) + (r1 * f6)));
        }
    }

    public float[] d(com.esotericsoftware.spine.attachments.PathAttachment pathAttachment, int i, boolean z, boolean z2, boolean z3) {
        int i2;
        float[] size;
        int i3;
        float f;
        int i4;
        int i5;
        float f2;
        float[] fArr;
        float f3;
        int i6;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int i7;
        float f10;
        int i8;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int i9;
        int i10;
        float[] fArr2;
        float f16;
        int i11;
        com.esotericsoftware.spine.Slot slot = this.c;
        float f17 = this.d;
        float[] fArr3 = this.h.items;
        int i12 = 2;
        float[] size2 = this.i.setSize((i * 3) + 2);
        boolean closed = pathAttachment.getClosed();
        int worldVerticesLength = pathAttachment.getWorldVerticesLength();
        int i13 = worldVerticesLength / 6;
        if (!pathAttachment.getConstantSpeed()) {
            float[] lengths = pathAttachment.getLengths();
            int i14 = i13 - (closed ? 1 : 2);
            float f18 = lengths[i14];
            if (z2) {
                f17 *= f18;
            }
            if (z3) {
                for (int i15 = 0; i15 < i; i15++) {
                    fArr3[i15] = fArr3[i15] * f18;
                }
            }
            float[] size3 = this.j.setSize(8);
            int i16 = 0;
            int i17 = -1;
            int i18 = 0;
            int i19 = 0;
            while (i18 < i) {
                float f19 = fArr3[i18];
                float f20 = f17 + f19;
                if (closed) {
                    f15 = f20 % f18;
                    if (f15 < 0.0f) {
                        f15 += f18;
                    }
                    i16 = 0;
                } else {
                    if (f20 < 0.0f) {
                        if (i17 != -2) {
                            pathAttachment.computeWorldVertices(slot, 2, 4, size3, 0, 2);
                            i17 = -2;
                        }
                        b(f20, size3, 0, size2, i19);
                    } else if (f20 > f18) {
                        if (i17 != -3) {
                            pathAttachment.computeWorldVertices(slot, worldVerticesLength - 6, 4, size3, 0, 2);
                            i17 = -3;
                        }
                        a(f20 - f18, size3, 0, size2, i19);
                    } else {
                        f15 = f20;
                    }
                    i9 = i14;
                    i10 = i18;
                    fArr2 = fArr3;
                    i18 = i10 + 1;
                    i19 += 3;
                    f17 = f20;
                    i14 = i9;
                    fArr3 = fArr2;
                }
                while (true) {
                    f16 = lengths[i16];
                    if (f15 <= f16) {
                        break;
                    }
                    i16++;
                }
                if (i16 != 0) {
                    float f21 = lengths[i16 - 1];
                    f15 -= f21;
                    f16 -= f21;
                }
                float f22 = f15 / f16;
                if (i16 != i17) {
                    if (closed && i16 == i14) {
                        pathAttachment.computeWorldVertices(slot, worldVerticesLength - 4, 4, size3, 0, 2);
                        pathAttachment.computeWorldVertices(slot, 0, 4, size3, 4, 2);
                    } else {
                        pathAttachment.computeWorldVertices(slot, (i16 * 6) + 2, 8, size3, 0, 2);
                    }
                    i11 = i16;
                } else {
                    i11 = i17;
                }
                i9 = i14;
                i10 = i18;
                fArr2 = fArr3;
                c(f22, size3[0], size3[1], size3[2], size3[3], size3[4], size3[5], size3[6], size3[7], size2, i19, z || (i18 > 0 && f19 < 1.0E-5f));
                i17 = i11;
                i16 = i16;
                i18 = i10 + 1;
                i19 += 3;
                f17 = f20;
                i14 = i9;
                fArr3 = fArr2;
            }
            return size2;
        }
        if (closed) {
            i2 = worldVerticesLength + 2;
            size = this.j.setSize(i2);
            int i20 = i2 - 4;
            pathAttachment.computeWorldVertices(slot, 2, i20, size, 0, 2);
            pathAttachment.computeWorldVertices(slot, 0, 2, size, i20, 2);
            size[i2 - 2] = size[0];
            size[i2 - 1] = size[1];
        } else {
            i13--;
            i2 = worldVerticesLength - 4;
            size = this.j.setSize(i2);
            pathAttachment.computeWorldVertices(slot, 2, i2, size, 0, 2);
        }
        int i21 = i2;
        float[] fArr4 = size;
        float[] size4 = this.k.setSize(i13);
        float f23 = fArr4[0];
        float f24 = fArr4[1];
        int i22 = 0;
        float f25 = 0.0f;
        float f26 = 0.0f;
        float f27 = 0.0f;
        float f28 = 0.0f;
        float f29 = 0.0f;
        float f30 = 0.0f;
        float f31 = 0.0f;
        while (i22 < i13) {
            f25 = fArr4[i12];
            f26 = fArr4[i12 + 1];
            f27 = fArr4[i12 + 2];
            f28 = fArr4[i12 + 3];
            f29 = fArr4[i12 + 4];
            float f32 = fArr4[i12 + 5];
            float f33 = ((f23 - (f25 * 2.0f)) + f27) * 0.1875f;
            float f34 = ((f24 - (f26 * 2.0f)) + f28) * 0.1875f;
            float f35 = ((((f25 - f27) * 3.0f) - f23) + f29) * 0.09375f;
            float f36 = ((((f26 - f28) * 3.0f) - f24) + f32) * 0.09375f;
            float f37 = (f33 * 2.0f) + f35;
            float f38 = (2.0f * f34) + f36;
            float sqrt = f31 + ((float) java.lang.Math.sqrt((r0 * r0) + (r1 * r1)));
            float f39 = ((f25 - f23) * 0.75f) + f33 + (f35 * 0.16666667f) + f37;
            float f40 = ((f26 - f24) * 0.75f) + f34 + (0.16666667f * f36) + f38;
            float f41 = f37 + f35;
            float f42 = f38 + f36;
            float sqrt2 = sqrt + ((float) java.lang.Math.sqrt((f39 * f39) + (f40 * f40)));
            float sqrt3 = sqrt2 + ((float) java.lang.Math.sqrt((r0 * r0) + (r1 * r1)));
            float f43 = f39 + f41 + f41 + f35;
            float f44 = f40 + f42 + f42 + f36;
            f31 = sqrt3 + ((float) java.lang.Math.sqrt((f43 * f43) + (f44 * f44)));
            size4[i22] = f31;
            i22++;
            i12 += 6;
            f24 = f32;
            f30 = f24;
            f23 = f29;
        }
        if (z2) {
            f17 *= f31;
        }
        if (z3) {
            for (int i23 = 0; i23 < i; i23++) {
                fArr3[i23] = fArr3[i23] * f31;
            }
        }
        float[] fArr5 = this.m;
        float f45 = f25;
        float f46 = f26;
        float f47 = f29;
        float f48 = f30;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        float f49 = 0.0f;
        int i27 = 0;
        float f50 = f27;
        float f51 = f28;
        int i28 = -1;
        float f52 = f23;
        float f53 = f17;
        float f54 = f24;
        while (i24 < i) {
            float f55 = fArr3[i24];
            float f56 = f53 + f55;
            if (closed) {
                f2 = f56 % f31;
                if (f2 < 0.0f) {
                    f2 += f31;
                }
                i3 = i24;
                f = f52;
                i4 = i28;
                i5 = 0;
            } else {
                if (f56 < 0.0f) {
                    i3 = i24;
                    f = f52;
                    i4 = i28;
                    b(f56, fArr4, 0, size2, i25);
                } else {
                    i3 = i24;
                    f = f52;
                    i4 = i28;
                    if (f56 > f31) {
                        a(f56 - f31, fArr4, i21 - 4, size2, i25);
                    } else {
                        i5 = i26;
                        f2 = f56;
                    }
                }
                i28 = i4;
                fArr = fArr5;
                f52 = f;
                i24 = i3 + 1;
                i25 += 3;
                fArr5 = fArr;
                f53 = f56;
            }
            while (true) {
                f3 = size4[i5];
                if (f2 <= f3) {
                    break;
                }
                i5++;
            }
            if (i5 != 0) {
                float f57 = size4[i5 - 1];
                f2 -= f57;
                f3 -= f57;
            }
            float f58 = f2 / f3;
            if (i5 != i4) {
                int i29 = i5 * 6;
                float f59 = fArr4[i29];
                float f60 = fArr4[i29 + 1];
                float f61 = fArr4[i29 + 2];
                float f62 = fArr4[i29 + 3];
                float f63 = fArr4[i29 + 4];
                float f64 = fArr4[i29 + 5];
                float f65 = fArr4[i29 + 6];
                float f66 = fArr4[i29 + 7];
                float f67 = ((f59 - (f61 * 2.0f)) + f63) * 0.03f;
                float f68 = ((f60 - (f62 * 2.0f)) + f64) * 0.03f;
                float f69 = ((((f61 - f63) * 3.0f) - f59) + f65) * 0.006f;
                float f70 = ((((f62 - f64) * 3.0f) - f60) + f66) * 0.006f;
                float f71 = (f67 * 2.0f) + f69;
                float f72 = (f68 * 2.0f) + f70;
                float f73 = ((f61 - f59) * 0.3f) + f67 + (f69 * 0.16666667f);
                float f74 = ((f62 - f60) * 0.3f) + f68 + (f70 * 0.16666667f);
                i6 = i5;
                float sqrt4 = (float) java.lang.Math.sqrt((f73 * f73) + (f74 * f74));
                fArr5[0] = sqrt4;
                int i30 = 1;
                while (i30 < 8) {
                    f73 += f71;
                    f74 += f72;
                    f71 += f69;
                    f72 += f70;
                    sqrt4 += (float) java.lang.Math.sqrt((f73 * f73) + (f74 * f74));
                    fArr5[i30] = sqrt4;
                    i30++;
                    f60 = f60;
                }
                float sqrt5 = sqrt4 + ((float) java.lang.Math.sqrt((r39 * r39) + (r2 * r2)));
                fArr5[8] = sqrt5;
                float f75 = f73 + f71 + f71 + f69;
                float f76 = f74 + f72 + f72 + f70;
                float sqrt6 = sqrt5 + ((float) java.lang.Math.sqrt((f75 * f75) + (f76 * f76)));
                fArr5[9] = sqrt6;
                f4 = f60;
                f12 = f62;
                f5 = f63;
                f6 = f64;
                f7 = f65;
                f8 = f66;
                f9 = sqrt6;
                i7 = 0;
                f10 = f59;
                i8 = i6;
                f11 = f61;
            } else {
                i6 = i5;
                f4 = f54;
                f5 = f50;
                f6 = f51;
                f7 = f47;
                f8 = f48;
                f9 = f49;
                i7 = i27;
                f10 = f;
                i8 = i4;
                f11 = f45;
                f12 = f46;
            }
            float f77 = f58 * f9;
            int i31 = i7;
            while (true) {
                f13 = fArr5[i31];
                if (f77 <= f13) {
                    break;
                }
                i31++;
            }
            if (i31 == 0) {
                f14 = f77 / f13;
            } else {
                float f78 = fArr5[i31 - 1];
                f14 = ((f77 - f78) / (f13 - f78)) + i31;
            }
            fArr = fArr5;
            int i32 = i31;
            c(0.1f * f14, f10, f4, f11, f12, f5, f6, f7, f8, size2, i25, z || (i3 > 0 && f55 < 1.0E-5f));
            i28 = i8;
            f52 = f10;
            f54 = f4;
            f45 = f11;
            f46 = f12;
            f50 = f5;
            f51 = f6;
            f47 = f7;
            f48 = f8;
            f49 = f9;
            i26 = i6;
            i27 = i32;
            i24 = i3 + 1;
            i25 += 3;
            fArr5 = fArr;
            f53 = f56;
        }
        return size2;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> getBones() {
        return this.b;
    }

    public com.esotericsoftware.spine.PathConstraintData getData() {
        return this.a;
    }

    @Override // com.esotericsoftware.spine.Constraint
    public int getOrder() {
        return this.a.b;
    }

    public float getPosition() {
        return this.d;
    }

    public float getRotateMix() {
        return this.f;
    }

    public float getSpacing() {
        return this.e;
    }

    public com.esotericsoftware.spine.Slot getTarget() {
        return this.c;
    }

    public float getTranslateMix() {
        return this.g;
    }

    public void setPosition(float f) {
        this.d = f;
    }

    public void setRotateMix(float f) {
        this.f = f;
    }

    public void setSpacing(float f) {
        this.e = f;
    }

    public void setTarget(com.esotericsoftware.spine.Slot slot) {
        this.c = slot;
    }

    public void setTranslateMix(float f) {
        this.g = f;
    }

    public java.lang.String toString() {
        return this.a.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x010c, code lost:
    
        if (r14 == com.esotericsoftware.spine.PathConstraintData.RotateMode.chain) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0231  */
    @Override // com.esotericsoftware.spine.Updatable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update() {
        int i;
        com.esotericsoftware.spine.Bone[] boneArr;
        boolean z;
        float f;
        float f2;
        com.esotericsoftware.spine.Bone[] boneArr2;
        int i2;
        float f3;
        int i3;
        boolean z2;
        float f4;
        float f5;
        float atan2;
        float f6;
        float atan22;
        com.esotericsoftware.spine.attachments.Attachment attachment = this.c.e;
        if (attachment instanceof com.esotericsoftware.spine.attachments.PathAttachment) {
            float f7 = this.f;
            float f8 = this.g;
            boolean z3 = f8 > 0.0f;
            boolean z4 = f7 > 0.0f;
            if (z3 || z4) {
                com.esotericsoftware.spine.PathConstraintData pathConstraintData = this.a;
                com.esotericsoftware.spine.PathConstraintData.SpacingMode spacingMode = pathConstraintData.f;
                boolean z5 = spacingMode == com.esotericsoftware.spine.PathConstraintData.SpacingMode.length;
                com.esotericsoftware.spine.PathConstraintData.RotateMode rotateMode = pathConstraintData.g;
                boolean z6 = rotateMode == com.esotericsoftware.spine.PathConstraintData.RotateMode.tangent;
                boolean z7 = rotateMode == com.esotericsoftware.spine.PathConstraintData.RotateMode.chainScale;
                com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
                int i4 = array.size;
                int i5 = z6 ? i4 : i4 + 1;
                com.esotericsoftware.spine.Bone[] boneArr3 = array.items;
                float[] size = this.h.setSize(i5);
                float f9 = this.e;
                if (z7 || z5) {
                    r19 = z7 ? this.l.setSize(i4) : null;
                    int i6 = i5 - 1;
                    i = i4;
                    int i7 = 0;
                    while (i7 < i6) {
                        com.esotericsoftware.spine.Bone[] boneArr4 = boneArr3;
                        com.esotericsoftware.spine.Bone bone = boneArr3[i7];
                        int i8 = i6;
                        float f10 = bone.a.d;
                        if (f10 < 1.0E-5f) {
                            if (z7) {
                                r19[i7] = 0.0f;
                            }
                            i7++;
                            size[i7] = 0.0f;
                            f = f7;
                            f2 = f8;
                            z = z4;
                        } else {
                            z = z4;
                            float f11 = bone.t * f10;
                            float f12 = bone.w * f10;
                            f = f7;
                            f2 = f8;
                            float sqrt = (float) java.lang.Math.sqrt((f11 * f11) + (f12 * f12));
                            if (z7) {
                                r19[i7] = sqrt;
                            }
                            i7++;
                            size[i7] = ((z5 ? f10 + f9 : f9) * sqrt) / f10;
                        }
                        i6 = i8;
                        boneArr3 = boneArr4;
                        z4 = z;
                        f7 = f;
                        f8 = f2;
                    }
                    boneArr = boneArr3;
                } else {
                    for (int i9 = 1; i9 < i5; i9++) {
                        size[i9] = f9;
                    }
                    boneArr = boneArr3;
                    i = i4;
                }
                float f13 = f7;
                float f14 = f8;
                boolean z8 = z4;
                com.esotericsoftware.spine.Bone[] boneArr5 = boneArr;
                int i10 = i;
                float[] d = d((com.esotericsoftware.spine.attachments.PathAttachment) attachment, i5, z6, pathConstraintData.e == com.esotericsoftware.spine.PathConstraintData.PositionMode.percent, spacingMode == com.esotericsoftware.spine.PathConstraintData.SpacingMode.percent);
                float f15 = d[0];
                boolean z9 = true;
                float f16 = d[1];
                float f17 = pathConstraintData.h;
                if (f17 != 0.0f) {
                    com.esotericsoftware.spine.Bone bone2 = this.c.b;
                    f17 *= (bone2.t * bone2.x) - (bone2.u * bone2.w) > 0.0f ? 0.017453292f : -0.017453292f;
                }
                z9 = false;
                float f18 = f16;
                int i11 = 3;
                float f19 = f15;
                int i12 = 0;
                while (i12 < i10) {
                    com.esotericsoftware.spine.Bone bone3 = boneArr5[i12];
                    float f20 = bone3.v;
                    bone3.v = f20 + ((f19 - f20) * f14);
                    float f21 = bone3.y;
                    bone3.y = f21 + ((f18 - f21) * f14);
                    float f22 = d[i11];
                    float f23 = d[i11 + 1];
                    float f24 = f22 - f19;
                    float f25 = f23 - f18;
                    if (z7) {
                        float f26 = r19[i12];
                        if (f26 >= 1.0E-5f) {
                            boneArr2 = boneArr5;
                            i2 = i10;
                            float sqrt2 = (((((float) java.lang.Math.sqrt((f24 * f24) + (f25 * f25))) / f26) - 1.0f) * f13) + 1.0f;
                            bone3.t *= sqrt2;
                            bone3.w *= sqrt2;
                            if (z8) {
                                f3 = f17;
                                i3 = i11;
                                z2 = z6;
                            } else {
                                float f27 = bone3.t;
                                float f28 = bone3.u;
                                float f29 = bone3.w;
                                float f30 = bone3.x;
                                if (z6) {
                                    f6 = d[i11 - 1];
                                } else if (size[i12 + 1] < 1.0E-5f) {
                                    f6 = d[i11 + 2];
                                } else {
                                    f4 = f30;
                                    z2 = z6;
                                    i3 = i11;
                                    f5 = f28;
                                    atan2 = (float) java.lang.Math.atan2(f25, f24);
                                    f3 = f17;
                                    atan22 = atan2 - ((float) java.lang.Math.atan2(f29, f27));
                                    if (z9) {
                                        atan22 += f3;
                                    } else {
                                        double d2 = atan22;
                                        float cos = (float) java.lang.Math.cos(d2);
                                        float sin = (float) java.lang.Math.sin(d2);
                                        float f31 = bone3.a.d;
                                        f22 += ((((cos * f27) - (sin * f29)) * f31) - f24) * f13;
                                        f23 += ((f31 * ((sin * f27) + (cos * f29))) - f25) * f13;
                                    }
                                    if (atan22 <= 3.1415927f) {
                                        atan22 -= 6.2831855f;
                                    } else if (atan22 < -3.1415927f) {
                                        atan22 += 6.2831855f;
                                    }
                                    double d3 = atan22 * f13;
                                    float cos2 = (float) java.lang.Math.cos(d3);
                                    float sin2 = (float) java.lang.Math.sin(d3);
                                    bone3.t = (cos2 * f27) - (sin2 * f29);
                                    bone3.u = (cos2 * f5) - (sin2 * f4);
                                    bone3.w = (f27 * sin2) + (f29 * cos2);
                                    bone3.x = (sin2 * f5) + (cos2 * f4);
                                }
                                i3 = i11;
                                f5 = f28;
                                f4 = f30;
                                atan2 = f6;
                                z2 = z6;
                                f3 = f17;
                                atan22 = atan2 - ((float) java.lang.Math.atan2(f29, f27));
                                if (z9) {
                                }
                                if (atan22 <= 3.1415927f) {
                                }
                                double d32 = atan22 * f13;
                                float cos22 = (float) java.lang.Math.cos(d32);
                                float sin22 = (float) java.lang.Math.sin(d32);
                                bone3.t = (cos22 * f27) - (sin22 * f29);
                                bone3.u = (cos22 * f5) - (sin22 * f4);
                                bone3.w = (f27 * sin22) + (f29 * cos22);
                                bone3.x = (sin22 * f5) + (cos22 * f4);
                            }
                            f19 = f22;
                            f18 = f23;
                            bone3.f308s = false;
                            i12++;
                            i11 = i3 + 3;
                            f17 = f3;
                            z6 = z2;
                            i10 = i2;
                            boneArr5 = boneArr2;
                        }
                    }
                    boneArr2 = boneArr5;
                    i2 = i10;
                    if (z8) {
                    }
                    f19 = f22;
                    f18 = f23;
                    bone3.f308s = false;
                    i12++;
                    i11 = i3 + 3;
                    f17 = f3;
                    z6 = z2;
                    i10 = i2;
                    boneArr5 = boneArr2;
                }
            }
        }
    }
}
