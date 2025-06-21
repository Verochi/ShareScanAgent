package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class IkConstraint implements com.esotericsoftware.spine.Constraint {
    public final com.esotericsoftware.spine.IkConstraintData a;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> b;
    public com.esotericsoftware.spine.Bone c;
    public float d;
    public int e;

    public IkConstraint(com.esotericsoftware.spine.IkConstraint ikConstraint, com.esotericsoftware.spine.Skeleton skeleton) {
        this.d = 1.0f;
        if (ikConstraint == null) {
            throw new java.lang.IllegalArgumentException("constraint cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = ikConstraint.a;
        this.b = new com.badlogic.gdx.utils.Array<>(ikConstraint.b.size);
        java.util.Iterator<com.esotericsoftware.spine.Bone> it = ikConstraint.b.iterator();
        while (it.hasNext()) {
            this.b.add(skeleton.b.get(it.next().a.a));
        }
        this.c = skeleton.b.get(ikConstraint.c.a.a);
        this.d = ikConstraint.d;
        this.e = ikConstraint.e;
    }

    public IkConstraint(com.esotericsoftware.spine.IkConstraintData ikConstraintData, com.esotericsoftware.spine.Skeleton skeleton) {
        this.d = 1.0f;
        if (ikConstraintData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = ikConstraintData;
        this.d = ikConstraintData.f;
        this.e = ikConstraintData.e;
        this.b = new com.badlogic.gdx.utils.Array<>(ikConstraintData.c.size);
        java.util.Iterator<com.esotericsoftware.spine.BoneData> it = ikConstraintData.c.iterator();
        while (it.hasNext()) {
            this.b.add(skeleton.findBone(it.next().b));
        }
        this.c = skeleton.findBone(ikConstraintData.d.b);
    }

    public static void apply(com.esotericsoftware.spine.Bone bone, float f, float f2, float f3) {
        if (!bone.f308s) {
            bone.updateAppliedTransform();
        }
        com.esotericsoftware.spine.Bone bone2 = bone.c;
        float f4 = bone2.t;
        float f5 = bone2.x;
        float f6 = bone2.u;
        float f7 = bone2.w;
        float f8 = 1.0f / ((f4 * f5) - (f6 * f7));
        float f9 = f - bone2.v;
        float f10 = f2 - bone2.y;
        float atan2 = com.esotericsoftware.spine.utils.SpineUtils.atan2((((f10 * f4) - (f9 * f7)) * f8) - bone.m, (((f5 * f9) - (f6 * f10)) * f8) - bone.l) * 57.295776f;
        float f11 = bone.q;
        float f12 = bone.n;
        float f13 = (atan2 - f11) - f12;
        float f14 = bone.o;
        if (f14 < 0.0f) {
            f13 += 180.0f;
        }
        if (f13 > 180.0f) {
            f13 -= 360.0f;
        } else if (f13 < -180.0f) {
            f13 += 360.0f;
        }
        bone.updateWorldTransform(bone.l, bone.m, f12 + (f13 * f3), f14, bone.p, f11, bone.r);
    }

    public static void apply(com.esotericsoftware.spine.Bone bone, com.esotericsoftware.spine.Bone bone2, float f, float f2, int i, float f3) {
        int i2;
        int i3;
        int i4;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float atan2;
        float f11;
        float f12;
        float f13;
        if (f3 == 0.0f) {
            bone2.updateWorldTransform();
            return;
        }
        if (!bone.f308s) {
            bone.updateAppliedTransform();
        }
        if (!bone2.f308s) {
            bone2.updateAppliedTransform();
        }
        float f14 = bone.l;
        float f15 = bone.m;
        float f16 = bone.o;
        float f17 = bone.p;
        float f18 = bone2.o;
        int i5 = 180;
        if (f16 < 0.0f) {
            f16 = -f16;
            i2 = -1;
            i3 = 180;
        } else {
            i2 = 1;
            i3 = 0;
        }
        if (f17 < 0.0f) {
            f17 = -f17;
            i2 = -i2;
        }
        if (f18 < 0.0f) {
            f18 = -f18;
        } else {
            i5 = 0;
        }
        float f19 = bone2.l;
        float f20 = bone.t;
        float f21 = bone.u;
        float f22 = bone.w;
        float f23 = bone.x;
        boolean z = java.lang.Math.abs(f16 - f17) <= 1.0E-4f;
        if (z) {
            i4 = i5;
            f4 = bone2.m;
            f5 = (f20 * f19) + (f21 * f4) + bone.v;
            f6 = (f22 * f19) + (f23 * f4) + bone.y;
        } else {
            f5 = (f20 * f19) + bone.v;
            f6 = (f22 * f19) + bone.y;
            i4 = i5;
            f4 = 0.0f;
        }
        com.esotericsoftware.spine.Bone bone3 = bone.c;
        float f24 = bone3.t;
        int i6 = i3;
        float f25 = bone3.u;
        float f26 = bone3.w;
        int i7 = i2;
        float f27 = bone3.x;
        float f28 = 1.0f / ((f24 * f27) - (f25 * f26));
        float f29 = f4;
        float f30 = bone3.v;
        float f31 = f - f30;
        float f32 = bone3.y;
        float f33 = f2 - f32;
        float f34 = (((f31 * f27) - (f33 * f25)) * f28) - f14;
        float f35 = ((f33 * f24) - (f31 * f26)) * f28;
        float f36 = f17;
        float f37 = f35 - f15;
        float f38 = f5 - f30;
        float f39 = f6 - f32;
        float f40 = (((f27 * f38) - (f25 * f39)) * f28) - f14;
        float f41 = (((f39 * f24) - (f38 * f26)) * f28) - f15;
        float sqrt = (float) java.lang.Math.sqrt((f40 * f40) + (f41 * f41));
        float f42 = bone2.a.d * f18;
        if (z) {
            float f43 = f42 * f16;
            float f44 = ((((f34 * f34) + (f37 * f37)) - (sqrt * sqrt)) - (f43 * f43)) / ((2.0f * sqrt) * f43);
            if (f44 < -1.0f) {
                f44 = -1.0f;
            } else if (f44 > 1.0f) {
                f44 = 1.0f;
            }
            f11 = ((float) java.lang.Math.acos(f44)) * i;
            float f45 = sqrt + (f44 * f43);
            float sin = f43 * com.esotericsoftware.spine.utils.SpineUtils.sin(f11);
            f13 = com.esotericsoftware.spine.utils.SpineUtils.atan2((f37 * f45) - (f34 * sin), (f34 * f45) + (f37 * sin));
        } else {
            float f46 = f16 * f42;
            float f47 = f42 * f36;
            float f48 = f46 * f46;
            float f49 = f47 * f47;
            float f50 = (f34 * f34) + (f37 * f37);
            float atan22 = com.esotericsoftware.spine.utils.SpineUtils.atan2(f37, f34);
            float f51 = (((f49 * sqrt) * sqrt) + (f48 * f50)) - (f48 * f49);
            float f52 = (-2.0f) * f49 * sqrt;
            float f53 = f49 - f48;
            float f54 = (f52 * f52) - ((4.0f * f53) * f51);
            float f55 = 0.0f;
            if (f54 >= 0.0f) {
                f7 = f46;
                float sqrt2 = (float) java.lang.Math.sqrt(f54);
                if (f52 < 0.0f) {
                    sqrt2 = -sqrt2;
                }
                float f56 = (-(f52 + sqrt2)) / 2.0f;
                float f57 = f56 / f53;
                float f58 = f51 / f56;
                if (java.lang.Math.abs(f57) >= java.lang.Math.abs(f58)) {
                    f57 = f58;
                }
                if (f57 * f57 <= f50) {
                    float sqrt3 = ((float) java.lang.Math.sqrt(f50 - r7)) * i;
                    atan2 = atan22 - com.esotericsoftware.spine.utils.SpineUtils.atan2(sqrt3, f57);
                    f11 = com.esotericsoftware.spine.utils.SpineUtils.atan2(sqrt3 / f36, (f57 - sqrt) / f16);
                    f13 = atan2;
                }
            } else {
                f7 = f46;
            }
            float f59 = sqrt - f7;
            float f60 = f59 * f59;
            float f61 = sqrt + f7;
            float f62 = f61 * f61;
            float f63 = f7;
            float f64 = ((-f63) * sqrt) / (f48 - f49);
            if (f64 < -1.0f || f64 > 1.0f) {
                f8 = 0.0f;
                f9 = 3.1415927f;
                f10 = 0.0f;
            } else {
                float acos = (float) java.lang.Math.acos(f64);
                float cos = (com.esotericsoftware.spine.utils.SpineUtils.cos(acos) * f63) + sqrt;
                f8 = f47 * com.esotericsoftware.spine.utils.SpineUtils.sin(acos);
                float f65 = (cos * cos) + (f8 * f8);
                if (f65 < f60) {
                    f60 = f65;
                    f10 = f8;
                    f12 = acos;
                    f59 = cos;
                } else {
                    f12 = 3.1415927f;
                    f10 = 0.0f;
                }
                if (f65 > f62) {
                    f62 = f65;
                    f55 = acos;
                    f61 = cos;
                    f9 = f12;
                } else {
                    f9 = f12;
                    f8 = 0.0f;
                }
            }
            if (f50 <= (f60 + f62) / 2.0f) {
                float f66 = i;
                atan2 = atan22 - com.esotericsoftware.spine.utils.SpineUtils.atan2(f10 * f66, f59);
                f11 = f9 * f66;
            } else {
                float f67 = i;
                atan2 = atan22 - com.esotericsoftware.spine.utils.SpineUtils.atan2(f8 * f67, f61);
                f11 = f55 * f67;
            }
            f13 = atan2;
        }
        float f68 = f11;
        float f69 = i7;
        float atan23 = com.esotericsoftware.spine.utils.SpineUtils.atan2(f29, f19) * f69;
        float f70 = bone.n;
        float f71 = (((f13 - atan23) * 57.295776f) + i6) - f70;
        if (f71 > 180.0f) {
            f71 -= 360.0f;
        } else if (f71 < -180.0f) {
            f71 += 360.0f;
        }
        bone.updateWorldTransform(f14, f15, f70 + (f71 * f3), bone.o, bone.p, 0.0f, 0.0f);
        float f72 = bone2.n;
        float f73 = bone2.q;
        float f74 = (((((f68 + atan23) * 57.295776f) - f73) * f69) + i4) - f72;
        if (f74 > 180.0f) {
            f74 -= 360.0f;
        } else if (f74 < -180.0f) {
            f74 += 360.0f;
        }
        bone2.updateWorldTransform(f19, f29, f72 + (f74 * f3), bone2.o, bone2.p, f73, bone2.r);
    }

    public void apply() {
        update();
    }

    public int getBendDirection() {
        return this.e;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> getBones() {
        return this.b;
    }

    public com.esotericsoftware.spine.IkConstraintData getData() {
        return this.a;
    }

    public float getMix() {
        return this.d;
    }

    @Override // com.esotericsoftware.spine.Constraint
    public int getOrder() {
        return this.a.b;
    }

    public com.esotericsoftware.spine.Bone getTarget() {
        return this.c;
    }

    public void setBendDirection(int i) {
        this.e = i;
    }

    public void setMix(float f) {
        this.d = f;
    }

    public void setTarget(com.esotericsoftware.spine.Bone bone) {
        this.c = bone;
    }

    public java.lang.String toString() {
        return this.a.a;
    }

    @Override // com.esotericsoftware.spine.Updatable
    public void update() {
        com.esotericsoftware.spine.Bone bone = this.c;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
        int i = array.size;
        if (i == 1) {
            apply(array.first(), bone.v, bone.y, this.d);
        } else {
            if (i != 2) {
                return;
            }
            apply(array.first(), array.get(1), bone.v, bone.y, this.e, this.d);
        }
    }
}
