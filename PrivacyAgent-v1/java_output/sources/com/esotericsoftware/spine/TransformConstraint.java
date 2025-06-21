package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class TransformConstraint implements com.esotericsoftware.spine.Constraint {
    public final com.esotericsoftware.spine.TransformConstraintData a;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> b;
    public com.esotericsoftware.spine.Bone c;
    public float d;
    public float e;
    public float f;
    public float g;
    public final com.badlogic.gdx.math.Vector2 h = new com.badlogic.gdx.math.Vector2();

    public TransformConstraint(com.esotericsoftware.spine.TransformConstraint transformConstraint, com.esotericsoftware.spine.Skeleton skeleton) {
        if (transformConstraint == null) {
            throw new java.lang.IllegalArgumentException("constraint cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = transformConstraint.a;
        this.b = new com.badlogic.gdx.utils.Array<>(transformConstraint.b.size);
        java.util.Iterator<com.esotericsoftware.spine.Bone> it = transformConstraint.b.iterator();
        while (it.hasNext()) {
            this.b.add(skeleton.b.get(it.next().a.a));
        }
        this.c = skeleton.b.get(transformConstraint.c.a.a);
        this.d = transformConstraint.d;
        this.e = transformConstraint.e;
        this.f = transformConstraint.f;
        this.g = transformConstraint.g;
    }

    public TransformConstraint(com.esotericsoftware.spine.TransformConstraintData transformConstraintData, com.esotericsoftware.spine.Skeleton skeleton) {
        if (transformConstraintData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = transformConstraintData;
        this.d = transformConstraintData.e;
        this.e = transformConstraintData.f;
        this.f = transformConstraintData.g;
        this.g = transformConstraintData.h;
        this.b = new com.badlogic.gdx.utils.Array<>(transformConstraintData.c.size);
        java.util.Iterator<com.esotericsoftware.spine.BoneData> it = transformConstraintData.c.iterator();
        while (it.hasNext()) {
            this.b.add(skeleton.findBone(it.next().b));
        }
        this.c = skeleton.findBone(transformConstraintData.d.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array;
        int i;
        float f;
        float f2;
        float f3;
        com.esotericsoftware.spine.TransformConstraint transformConstraint = this;
        float f4 = transformConstraint.d;
        float f5 = transformConstraint.e;
        float f6 = transformConstraint.f;
        float f7 = transformConstraint.g;
        com.esotericsoftware.spine.Bone bone = transformConstraint.c;
        if (!bone.f308s) {
            bone.updateAppliedTransform();
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array2 = transformConstraint.b;
        int i2 = array2.size;
        int i3 = 0;
        while (i3 < i2) {
            com.esotericsoftware.spine.Bone bone2 = array2.get(i3);
            if (!bone2.f308s) {
                bone2.updateAppliedTransform();
            }
            float f8 = bone2.n;
            if (f4 != 0.0f) {
                array = array2;
                i = i2;
                f8 += (((bone.n - f8) + transformConstraint.a.i) - ((16384 - ((int) (16384.499999999996d - (r15 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * f4;
            } else {
                array = array2;
                i = i2;
            }
            float f9 = bone2.l;
            float f10 = bone2.m;
            if (f5 != 0.0f) {
                float f11 = bone.l - f9;
                com.esotericsoftware.spine.TransformConstraintData transformConstraintData = transformConstraint.a;
                f9 += (f11 + transformConstraintData.j) * f5;
                f10 += ((bone.m - f10) + transformConstraintData.k) * f5;
            }
            float f12 = f10;
            float f13 = bone2.o;
            float f14 = bone2.p;
            if (f6 > 0.0f) {
                if (f13 != 0.0f) {
                    f13 = ((((bone.o - f13) + transformConstraint.a.l) * f6) + f13) / f13;
                }
                if (f14 != 0.0f) {
                    f2 = ((((bone.p - f14) + transformConstraint.a.m) * f6) + f14) / f14;
                    f = f13;
                    float f15 = bone2.r;
                    if (f7 <= 0.0f) {
                        f3 = f4;
                        bone2.k += (((bone.r - f15) + transformConstraint.a.n) - ((16384 - ((int) (16384.499999999996d - (r13 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * f7;
                    } else {
                        f3 = f4;
                    }
                    bone2.updateWorldTransform(f9, f12, f8, f, f2, bone2.q, f15);
                    i3++;
                    transformConstraint = this;
                    array2 = array;
                    i2 = i;
                    f4 = f3;
                }
            }
            f = f13;
            f2 = f14;
            float f152 = bone2.r;
            if (f7 <= 0.0f) {
            }
            bone2.updateWorldTransform(f9, f12, f8, f, f2, bone2.q, f152);
            i3++;
            transformConstraint = this;
            array2 = array;
            i2 = i;
            f4 = f3;
        }
    }

    public void apply() {
        update();
    }

    public final void b() {
        float f;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array;
        float f2;
        int i;
        int i2;
        boolean z;
        com.esotericsoftware.spine.TransformConstraint transformConstraint = this;
        float f3 = transformConstraint.d;
        float f4 = transformConstraint.e;
        float f5 = transformConstraint.f;
        float f6 = transformConstraint.g;
        com.esotericsoftware.spine.Bone bone = transformConstraint.c;
        float f7 = bone.t;
        float f8 = bone.u;
        float f9 = bone.w;
        float f10 = bone.x;
        float f11 = (f7 * f10) - (f8 * f9) > 0.0f ? 0.017453292f : -0.017453292f;
        com.esotericsoftware.spine.TransformConstraintData transformConstraintData = transformConstraint.a;
        float f12 = transformConstraintData.i * f11;
        float f13 = transformConstraintData.n * f11;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array2 = transformConstraint.b;
        int i3 = array2.size;
        int i4 = 0;
        while (i4 < i3) {
            com.esotericsoftware.spine.Bone bone2 = array2.get(i4);
            boolean z2 = true;
            if (f3 != 0.0f) {
                array = array2;
                float f14 = bone2.t;
                i = i3;
                float f15 = bone2.u;
                i2 = i4;
                float f16 = bone2.w;
                f2 = f13;
                float f17 = bone2.x;
                float atan2 = (com.esotericsoftware.spine.utils.SpineUtils.atan2(f9, f7) - com.esotericsoftware.spine.utils.SpineUtils.atan2(f16, f14)) + f12;
                if (atan2 > 3.1415927f) {
                    atan2 -= 6.2831855f;
                } else if (atan2 < -3.1415927f) {
                    atan2 += 6.2831855f;
                }
                float f18 = atan2 * f3;
                float cos = com.esotericsoftware.spine.utils.SpineUtils.cos(f18);
                float sin = com.esotericsoftware.spine.utils.SpineUtils.sin(f18);
                f = f3;
                bone2.t = (cos * f14) - (sin * f16);
                bone2.u = (cos * f15) - (sin * f17);
                bone2.w = (f14 * sin) + (f16 * cos);
                bone2.x = (sin * f15) + (cos * f17);
                z = true;
            } else {
                f = f3;
                array = array2;
                f2 = f13;
                i = i3;
                i2 = i4;
                z = false;
            }
            if (f4 != 0.0f) {
                com.badlogic.gdx.math.Vector2 vector2 = transformConstraint.h;
                com.esotericsoftware.spine.TransformConstraintData transformConstraintData2 = transformConstraint.a;
                bone.localToWorld(vector2.set(transformConstraintData2.j, transformConstraintData2.k));
                float f19 = bone2.v;
                bone2.v = f19 + ((vector2.x - f19) * f4);
                float f20 = bone2.y;
                bone2.y = f20 + ((vector2.y - f20) * f4);
                z = true;
            }
            float f21 = 0.0f;
            if (f5 > 0.0f) {
                float f22 = bone2.t;
                float f23 = bone2.w;
                float sqrt = (float) java.lang.Math.sqrt((f22 * f22) + (f23 * f23));
                if (sqrt != 0.0f) {
                    sqrt = ((((((float) java.lang.Math.sqrt((f7 * f7) + (f9 * f9))) - sqrt) + transformConstraint.a.l) * f5) + sqrt) / sqrt;
                }
                bone2.t *= sqrt;
                bone2.w *= sqrt;
                float f24 = bone2.u;
                float f25 = bone2.x;
                float sqrt2 = (float) java.lang.Math.sqrt((f24 * f24) + (f25 * f25));
                if (sqrt2 != 0.0f) {
                    sqrt2 = ((((((float) java.lang.Math.sqrt((f8 * f8) + (f10 * f10))) - sqrt2) + transformConstraint.a.m) * f5) + sqrt2) / sqrt2;
                }
                bone2.u *= sqrt2;
                bone2.x *= sqrt2;
                z = true;
                f21 = 0.0f;
            }
            if (f6 > f21) {
                float f26 = bone2.u;
                float atan22 = com.esotericsoftware.spine.utils.SpineUtils.atan2(bone2.x, f26);
                float atan23 = (com.esotericsoftware.spine.utils.SpineUtils.atan2(f10, f8) - com.esotericsoftware.spine.utils.SpineUtils.atan2(f9, f7)) - (atan22 - com.esotericsoftware.spine.utils.SpineUtils.atan2(bone2.w, bone2.t));
                if (atan23 > 3.1415927f) {
                    atan23 -= 6.2831855f;
                } else if (atan23 < -3.1415927f) {
                    atan23 += 6.2831855f;
                }
                float f27 = atan22 + ((atan23 + f2) * f6);
                float sqrt3 = (float) java.lang.Math.sqrt((f26 * f26) + (r12 * r12));
                bone2.u = com.esotericsoftware.spine.utils.SpineUtils.cos(f27) * sqrt3;
                bone2.x = com.esotericsoftware.spine.utils.SpineUtils.sin(f27) * sqrt3;
            } else {
                z2 = z;
            }
            if (z2) {
                bone2.f308s = false;
            }
            i4 = i2 + 1;
            transformConstraint = this;
            array2 = array;
            i3 = i;
            f13 = f2;
            f3 = f;
        }
    }

    public final void c() {
        float f;
        float f2;
        float f3 = this.d;
        float f4 = this.e;
        float f5 = this.f;
        float f6 = this.g;
        com.esotericsoftware.spine.Bone bone = this.c;
        if (!bone.f308s) {
            bone.updateAppliedTransform();
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
        int i = array.size;
        int i2 = 0;
        while (i2 < i) {
            com.esotericsoftware.spine.Bone bone2 = array.get(i2);
            if (!bone2.f308s) {
                bone2.updateAppliedTransform();
            }
            float f7 = bone2.n;
            if (f3 != 0.0f) {
                f7 += (bone.n + this.a.i) * f3;
            }
            float f8 = f7;
            float f9 = bone2.l;
            float f10 = bone2.m;
            if (f4 != 0.0f) {
                float f11 = bone.l;
                com.esotericsoftware.spine.TransformConstraintData transformConstraintData = this.a;
                f9 += (f11 + transformConstraintData.j) * f4;
                f10 += (bone.m + transformConstraintData.k) * f4;
            }
            float f12 = f9;
            float f13 = bone2.o;
            float f14 = bone2.p;
            if (f5 > 0.0f) {
                float f15 = bone.o - 1.0f;
                f = f3;
                com.esotericsoftware.spine.TransformConstraintData transformConstraintData2 = this.a;
                f2 = f4;
                f13 *= ((f15 + transformConstraintData2.l) * f5) + 1.0f;
                f14 *= (((bone.p - 1.0f) + transformConstraintData2.m) * f5) + 1.0f;
            } else {
                f = f3;
                f2 = f4;
            }
            float f16 = f14;
            float f17 = f13;
            float f18 = bone2.r;
            if (f6 > 0.0f) {
                f18 += (bone.r + this.a.n) * f6;
            }
            bone2.updateWorldTransform(f12, f10, f8, f17, f16, bone2.q, f18);
            i2++;
            f3 = f;
            f4 = f2;
        }
    }

    public final void d() {
        float f;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array;
        float f2;
        int i;
        int i2;
        boolean z;
        com.esotericsoftware.spine.Bone bone;
        float f3 = this.d;
        float f4 = this.e;
        float f5 = this.f;
        float f6 = this.g;
        com.esotericsoftware.spine.Bone bone2 = this.c;
        float f7 = bone2.t;
        float f8 = bone2.u;
        float f9 = bone2.w;
        float f10 = bone2.x;
        float f11 = (f7 * f10) - (f8 * f9) > 0.0f ? 0.017453292f : -0.017453292f;
        com.esotericsoftware.spine.TransformConstraintData transformConstraintData = this.a;
        float f12 = transformConstraintData.i * f11;
        float f13 = transformConstraintData.n * f11;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array2 = this.b;
        int i3 = array2.size;
        int i4 = 0;
        while (i4 < i3) {
            com.esotericsoftware.spine.Bone bone3 = array2.get(i4);
            boolean z2 = true;
            if (f3 != 0.0f) {
                array = array2;
                float f14 = bone3.t;
                i = i3;
                float f15 = bone3.u;
                i2 = i4;
                float f16 = bone3.w;
                f2 = f13;
                float f17 = bone3.x;
                float atan2 = com.esotericsoftware.spine.utils.SpineUtils.atan2(f9, f7) + f12;
                if (atan2 > 3.1415927f) {
                    atan2 -= 6.2831855f;
                } else if (atan2 < -3.1415927f) {
                    atan2 += 6.2831855f;
                }
                float f18 = atan2 * f3;
                float cos = com.esotericsoftware.spine.utils.SpineUtils.cos(f18);
                float sin = com.esotericsoftware.spine.utils.SpineUtils.sin(f18);
                f = f3;
                bone3.t = (cos * f14) - (sin * f16);
                bone3.u = (cos * f15) - (sin * f17);
                bone3.w = (f14 * sin) + (f16 * cos);
                bone3.x = (sin * f15) + (cos * f17);
                z = true;
            } else {
                f = f3;
                array = array2;
                f2 = f13;
                i = i3;
                i2 = i4;
                z = false;
            }
            if (f4 != 0.0f) {
                com.badlogic.gdx.math.Vector2 vector2 = this.h;
                com.esotericsoftware.spine.TransformConstraintData transformConstraintData2 = this.a;
                bone2.localToWorld(vector2.set(transformConstraintData2.j, transformConstraintData2.k));
                bone3.v += vector2.x * f4;
                bone3.y += vector2.y * f4;
                z = true;
            }
            if (f5 > 0.0f) {
                float sqrt = (((((float) java.lang.Math.sqrt((f7 * f7) + (f9 * f9))) - 1.0f) + this.a.l) * f5) + 1.0f;
                bone3.t *= sqrt;
                bone3.w *= sqrt;
                float sqrt2 = (((((float) java.lang.Math.sqrt((f8 * f8) + (f10 * f10))) - 1.0f) + this.a.m) * f5) + 1.0f;
                bone3.u *= sqrt2;
                bone3.x *= sqrt2;
                z = true;
            }
            if (f6 > 0.0f) {
                float atan22 = com.esotericsoftware.spine.utils.SpineUtils.atan2(f10, f8) - com.esotericsoftware.spine.utils.SpineUtils.atan2(f9, f7);
                if (atan22 > 3.1415927f) {
                    atan22 -= 6.2831855f;
                } else if (atan22 < -3.1415927f) {
                    atan22 += 6.2831855f;
                }
                float f19 = bone3.u;
                float f20 = bone3.x;
                float atan23 = com.esotericsoftware.spine.utils.SpineUtils.atan2(f20, f19) + (((atan22 - 1.5707964f) + f2) * f6);
                float f21 = (f19 * f19) + (f20 * f20);
                bone = bone3;
                float sqrt3 = (float) java.lang.Math.sqrt(f21);
                bone.u = com.esotericsoftware.spine.utils.SpineUtils.cos(atan23) * sqrt3;
                bone.x = com.esotericsoftware.spine.utils.SpineUtils.sin(atan23) * sqrt3;
            } else {
                bone = bone3;
                z2 = z;
            }
            if (z2) {
                bone.f308s = false;
            }
            i4 = i2 + 1;
            array2 = array;
            i3 = i;
            f13 = f2;
            f3 = f;
        }
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> getBones() {
        return this.b;
    }

    public com.esotericsoftware.spine.TransformConstraintData getData() {
        return this.a;
    }

    @Override // com.esotericsoftware.spine.Constraint
    public int getOrder() {
        return this.a.b;
    }

    public float getRotateMix() {
        return this.d;
    }

    public float getScaleMix() {
        return this.f;
    }

    public float getShearMix() {
        return this.g;
    }

    public com.esotericsoftware.spine.Bone getTarget() {
        return this.c;
    }

    public float getTranslateMix() {
        return this.e;
    }

    public void setRotateMix(float f) {
        this.d = f;
    }

    public void setScaleMix(float f) {
        this.f = f;
    }

    public void setShearMix(float f) {
        this.g = f;
    }

    public void setTarget(com.esotericsoftware.spine.Bone bone) {
        this.c = bone;
    }

    public void setTranslateMix(float f) {
        this.e = f;
    }

    public java.lang.String toString() {
        return this.a.a;
    }

    @Override // com.esotericsoftware.spine.Updatable
    public void update() {
        com.esotericsoftware.spine.TransformConstraintData transformConstraintData = this.a;
        if (transformConstraintData.p) {
            if (transformConstraintData.o) {
                c();
                return;
            } else {
                a();
                return;
            }
        }
        if (transformConstraintData.o) {
            d();
        } else {
            b();
        }
    }
}
