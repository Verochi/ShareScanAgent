package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class Bone implements com.esotericsoftware.spine.Updatable {
    public final com.esotericsoftware.spine.BoneData a;
    public final com.esotericsoftware.spine.Skeleton b;
    public final com.esotericsoftware.spine.Bone c;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> d = new com.badlogic.gdx.utils.Array<>();
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f308s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public boolean z;

    /* renamed from: com.esotericsoftware.spine.Bone$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.esotericsoftware.spine.BoneData.TransformMode.values().length];
            a = iArr;
            try {
                iArr[com.esotericsoftware.spine.BoneData.TransformMode.normal.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.esotericsoftware.spine.BoneData.TransformMode.onlyTranslation.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.esotericsoftware.spine.BoneData.TransformMode.noRotationOrReflection.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.esotericsoftware.spine.BoneData.TransformMode.noScale.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.esotericsoftware.spine.BoneData.TransformMode.noScaleOrReflection.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public Bone(com.esotericsoftware.spine.Bone bone, com.esotericsoftware.spine.Skeleton skeleton, com.esotericsoftware.spine.Bone bone2) {
        if (bone == null) {
            throw new java.lang.IllegalArgumentException("bone cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.b = skeleton;
        this.c = bone2;
        this.a = bone.a;
        this.e = bone.e;
        this.f = bone.f;
        this.g = bone.g;
        this.h = bone.h;
        this.i = bone.i;
        this.j = bone.j;
        this.k = bone.k;
    }

    public Bone(com.esotericsoftware.spine.BoneData boneData, com.esotericsoftware.spine.Skeleton skeleton, com.esotericsoftware.spine.Bone bone) {
        if (boneData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = boneData;
        this.b = skeleton;
        this.c = bone;
        setToSetupPose();
    }

    public float getA() {
        return this.t;
    }

    public float getARotation() {
        return this.n;
    }

    public float getAScaleX() {
        return this.o;
    }

    public float getAScaleY() {
        return this.p;
    }

    public float getAShearX() {
        return this.q;
    }

    public float getAShearY() {
        return this.r;
    }

    public float getAX() {
        return this.l;
    }

    public float getAY() {
        return this.m;
    }

    public float getB() {
        return this.u;
    }

    public float getC() {
        return this.w;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> getChildren() {
        return this.d;
    }

    public float getD() {
        return this.x;
    }

    public com.esotericsoftware.spine.BoneData getData() {
        return this.a;
    }

    public com.esotericsoftware.spine.Bone getParent() {
        return this.c;
    }

    public float getRotation() {
        return this.g;
    }

    public float getScaleX() {
        return this.h;
    }

    public float getScaleY() {
        return this.i;
    }

    public float getShearX() {
        return this.j;
    }

    public float getShearY() {
        return this.k;
    }

    public com.esotericsoftware.spine.Skeleton getSkeleton() {
        return this.b;
    }

    public float getWorldRotationX() {
        return com.esotericsoftware.spine.utils.SpineUtils.atan2(this.w, this.t) * 57.295776f;
    }

    public float getWorldRotationY() {
        return com.esotericsoftware.spine.utils.SpineUtils.atan2(this.x, this.u) * 57.295776f;
    }

    public float getWorldScaleX() {
        float f = this.t;
        float f2 = this.w;
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
    }

    public float getWorldScaleY() {
        float f = this.u;
        float f2 = this.x;
        return (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
    }

    public com.badlogic.gdx.math.Matrix3 getWorldTransform(com.badlogic.gdx.math.Matrix3 matrix3) {
        if (matrix3 == null) {
            throw new java.lang.IllegalArgumentException("worldTransform cannot be null.");
        }
        float[] fArr = matrix3.val;
        fArr[0] = this.t;
        fArr[3] = this.u;
        fArr[1] = this.w;
        fArr[4] = this.x;
        fArr[6] = this.v;
        fArr[7] = this.y;
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[8] = 1.0f;
        return matrix3;
    }

    public float getWorldX() {
        return this.v;
    }

    public float getWorldY() {
        return this.y;
    }

    public float getX() {
        return this.e;
    }

    public float getY() {
        return this.f;
    }

    public boolean isAppliedValid() {
        return this.f308s;
    }

    public com.badlogic.gdx.math.Vector2 localToWorld(com.badlogic.gdx.math.Vector2 vector2) {
        float f = vector2.x;
        float f2 = vector2.y;
        vector2.x = (this.t * f) + (this.u * f2) + this.v;
        vector2.y = (f * this.w) + (f2 * this.x) + this.y;
        return vector2;
    }

    public float localToWorldRotation(float f) {
        float sinDeg = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f);
        float cosDeg = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f);
        return com.esotericsoftware.spine.utils.SpineUtils.atan2((this.w * cosDeg) + (this.x * sinDeg), (cosDeg * this.t) + (sinDeg * this.u)) * 57.295776f;
    }

    public void rotateWorld(float f) {
        float cosDeg = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f);
        float sinDeg = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f);
        float f2 = this.t * cosDeg;
        float f3 = this.w;
        float f4 = f2 - (sinDeg * f3);
        this.t = f4;
        float f5 = this.u * cosDeg;
        float f6 = this.x;
        float f7 = f5 - (sinDeg * f6);
        this.u = f7;
        this.w = (f4 * sinDeg) + (f3 * cosDeg);
        this.x = (sinDeg * f7) + (cosDeg * f6);
        this.f308s = false;
    }

    public void setA(float f) {
        this.t = f;
    }

    public void setARotation(float f) {
        this.n = f;
    }

    public void setAScaleX(float f) {
        this.o = f;
    }

    public void setAScaleY(float f) {
        this.p = f;
    }

    public void setAShearX(float f) {
        this.q = f;
    }

    public void setAShearY(float f) {
        this.r = f;
    }

    public void setAX(float f) {
        this.l = f;
    }

    public void setAY(float f) {
        this.m = f;
    }

    public void setAppliedValid(boolean z) {
        this.f308s = z;
    }

    public void setB(float f) {
        this.u = f;
    }

    public void setC(float f) {
        this.w = f;
    }

    public void setD(float f) {
        this.x = f;
    }

    public void setPosition(float f, float f2) {
        this.e = f;
        this.f = f2;
    }

    public void setRotation(float f) {
        this.g = f;
    }

    public void setScale(float f) {
        this.h = f;
        this.i = f;
    }

    public void setScale(float f, float f2) {
        this.h = f;
        this.i = f2;
    }

    public void setScaleX(float f) {
        this.h = f;
    }

    public void setScaleY(float f) {
        this.i = f;
    }

    public void setShearX(float f) {
        this.j = f;
    }

    public void setShearY(float f) {
        this.k = f;
    }

    public void setToSetupPose() {
        com.esotericsoftware.spine.BoneData boneData = this.a;
        this.e = boneData.e;
        this.f = boneData.f;
        this.g = boneData.g;
        this.h = boneData.h;
        this.i = boneData.i;
        this.j = boneData.j;
        this.k = boneData.k;
    }

    public void setWorldX(float f) {
        this.v = f;
    }

    public void setWorldY(float f) {
        this.y = f;
    }

    public void setX(float f) {
        this.e = f;
    }

    public void setY(float f) {
        this.f = f;
    }

    public java.lang.String toString() {
        return this.a.b;
    }

    @Override // com.esotericsoftware.spine.Updatable
    public void update() {
        updateWorldTransform(this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    public void updateAppliedTransform() {
        this.f308s = true;
        com.esotericsoftware.spine.Bone bone = this.c;
        if (bone == null) {
            this.l = this.v;
            this.m = this.y;
            this.n = com.esotericsoftware.spine.utils.SpineUtils.atan2(this.w, this.t) * 57.295776f;
            float f = this.t;
            float f2 = this.w;
            this.o = (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
            float f3 = this.u;
            float f4 = this.x;
            this.p = (float) java.lang.Math.sqrt((f3 * f3) + (f4 * f4));
            this.q = 0.0f;
            float f5 = this.t;
            float f6 = this.u;
            float f7 = this.w;
            float f8 = this.x;
            this.r = com.esotericsoftware.spine.utils.SpineUtils.atan2((f5 * f6) + (f7 * f8), (f5 * f8) - (f6 * f7)) * 57.295776f;
            return;
        }
        float f9 = bone.t;
        float f10 = bone.u;
        float f11 = bone.w;
        float f12 = bone.x;
        float f13 = 1.0f / ((f9 * f12) - (f10 * f11));
        float f14 = this.v - bone.v;
        float f15 = this.y - bone.y;
        this.l = ((f14 * f12) * f13) - ((f15 * f10) * f13);
        this.m = ((f15 * f9) * f13) - ((f14 * f11) * f13);
        float f16 = f12 * f13;
        float f17 = f9 * f13;
        float f18 = f10 * f13;
        float f19 = f13 * f11;
        float f20 = this.t;
        float f21 = this.w;
        float f22 = (f16 * f20) - (f18 * f21);
        float f23 = this.u;
        float f24 = this.x;
        float f25 = (f16 * f23) - (f18 * f24);
        float f26 = (f21 * f17) - (f20 * f19);
        float f27 = (f17 * f24) - (f19 * f23);
        this.q = 0.0f;
        float sqrt = (float) java.lang.Math.sqrt((f22 * f22) + (f26 * f26));
        this.o = sqrt;
        if (sqrt > 1.0E-4f) {
            float f28 = (f22 * f27) - (f25 * f26);
            this.p = f28 / sqrt;
            this.r = com.esotericsoftware.spine.utils.SpineUtils.atan2((f25 * f22) + (f27 * f26), f28) * 57.295776f;
            this.n = com.esotericsoftware.spine.utils.SpineUtils.atan2(f26, f22) * 57.295776f;
            return;
        }
        this.o = 0.0f;
        this.p = (float) java.lang.Math.sqrt((f25 * f25) + (f27 * f27));
        this.r = 0.0f;
        this.n = 90.0f - (com.esotericsoftware.spine.utils.SpineUtils.atan2(f27, f25) * 57.295776f);
    }

    public void updateWorldTransform() {
        updateWorldTransform(this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0115, code lost:
    
        if (((r11 * r14) - (r12 * r13)) < 0.0f) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0120, code lost:
    
        r9 = -r9;
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x011e, code lost:
    
        if (r5.m != r5.n) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateWorldTransform(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        float atan2;
        float f9 = f;
        float f10 = f2;
        this.l = f9;
        this.m = f10;
        this.n = f3;
        this.o = f4;
        this.p = f5;
        this.q = f6;
        this.r = f7;
        this.f308s = true;
        com.esotericsoftware.spine.Bone bone = this.c;
        if (bone == null) {
            float f11 = f3 + 90.0f + f7;
            float f12 = f3 + f6;
            float cosDeg = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f12) * f4;
            float cosDeg2 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f11) * f5;
            float sinDeg = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f12) * f4;
            float sinDeg2 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f11) * f5;
            com.esotericsoftware.spine.Skeleton skeleton = this.b;
            if (skeleton.m) {
                f9 = -f9;
                cosDeg = -cosDeg;
                cosDeg2 = -cosDeg2;
            }
            if (skeleton.n) {
                f10 = -f10;
                sinDeg = -sinDeg;
                sinDeg2 = -sinDeg2;
            }
            this.t = cosDeg;
            this.u = cosDeg2;
            this.w = sinDeg;
            this.x = sinDeg2;
            this.v = f9 + skeleton.o;
            this.y = f10 + skeleton.p;
            return;
        }
        float f13 = bone.t;
        float f14 = bone.u;
        float f15 = bone.w;
        float f16 = bone.x;
        this.v = (f13 * f9) + (f14 * f10) + bone.v;
        this.y = (f9 * f15) + (f10 * f16) + bone.y;
        int i = com.esotericsoftware.spine.Bone.AnonymousClass1.a[this.a.l.ordinal()];
        if (i == 1) {
            float f17 = 90.0f + f3 + f7;
            float f18 = f3 + f6;
            float cosDeg3 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f18) * f4;
            float cosDeg4 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f17) * f5;
            float sinDeg3 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f18) * f4;
            float sinDeg4 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f17) * f5;
            this.t = (f13 * cosDeg3) + (f14 * sinDeg3);
            this.u = (f13 * cosDeg4) + (f14 * sinDeg4);
            this.w = (cosDeg3 * f15) + (sinDeg3 * f16);
            this.x = (f15 * cosDeg4) + (f16 * sinDeg4);
            return;
        }
        if (i == 2) {
            float f19 = 90.0f + f3 + f7;
            float f20 = f3 + f6;
            this.t = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f20) * f4;
            this.u = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f19) * f5;
            this.w = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f20) * f4;
            this.x = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f19) * f5;
        } else if (i == 3) {
            float f21 = (f13 * f13) + (f15 * f15);
            if (f21 > 1.0E-4f) {
                float abs = java.lang.Math.abs((f16 * f13) - (f14 * f15)) / f21;
                f14 = f15 * abs;
                f16 = f13 * abs;
                atan2 = com.esotericsoftware.spine.utils.SpineUtils.atan2(f15, f13) * 57.295776f;
                f8 = 90.0f;
            } else {
                f8 = 90.0f;
                atan2 = 90.0f - (com.esotericsoftware.spine.utils.SpineUtils.atan2(f16, f14) * 57.295776f);
                f13 = 0.0f;
                f15 = 0.0f;
            }
            float f22 = (f6 + f3) - atan2;
            float f23 = ((f3 + f7) - atan2) + f8;
            float cosDeg5 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f22) * f4;
            float cosDeg6 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f23) * f5;
            float sinDeg5 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f22) * f4;
            float sinDeg6 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f23) * f5;
            this.t = (f13 * cosDeg5) - (f14 * sinDeg5);
            this.u = (f13 * cosDeg6) - (f14 * sinDeg6);
            this.w = (cosDeg5 * f15) + (sinDeg5 * f16);
            this.x = (f15 * cosDeg6) + (f16 * sinDeg6);
        } else if (i == 4 || i == 5) {
            float cosDeg7 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f3);
            float sinDeg7 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f3);
            float f24 = (f13 * cosDeg7) + (f14 * sinDeg7);
            float f25 = (cosDeg7 * f15) + (sinDeg7 * f16);
            float sqrt = (float) java.lang.Math.sqrt((f24 * f24) + (f25 * f25));
            if (sqrt > 1.0E-5f) {
                sqrt = 1.0f / sqrt;
            }
            float f26 = f24 * sqrt;
            float f27 = f25 * sqrt;
            float sqrt2 = (float) java.lang.Math.sqrt((f26 * f26) + (f27 * f27));
            float atan22 = com.esotericsoftware.spine.utils.SpineUtils.atan2(f27, f26) + 1.5707964f;
            float cos = com.esotericsoftware.spine.utils.SpineUtils.cos(atan22) * sqrt2;
            float sin = com.esotericsoftware.spine.utils.SpineUtils.sin(atan22) * sqrt2;
            float cosDeg8 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f6) * f4;
            float f28 = f7 + 90.0f;
            float cosDeg9 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f28) * f5;
            float sinDeg8 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f6) * f4;
            float sinDeg9 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f28) * f5;
            if (this.a.l == com.esotericsoftware.spine.BoneData.TransformMode.noScaleOrReflection) {
                com.esotericsoftware.spine.Skeleton skeleton2 = this.b;
            }
            this.t = (f26 * cosDeg8) + (cos * sinDeg8);
            this.u = (f26 * cosDeg9) + (cos * sinDeg9);
            this.w = (cosDeg8 * f27) + (sinDeg8 * sin);
            this.x = (f27 * cosDeg9) + (sin * sinDeg9);
            return;
        }
        com.esotericsoftware.spine.Skeleton skeleton3 = this.b;
        if (skeleton3.m) {
            this.t = -this.t;
            this.u = -this.u;
        }
        if (skeleton3.n) {
            this.w = -this.w;
            this.x = -this.x;
        }
    }

    public com.badlogic.gdx.math.Vector2 worldToLocal(com.badlogic.gdx.math.Vector2 vector2) {
        float f = this.t;
        float f2 = this.x;
        float f3 = this.u;
        float f4 = this.w;
        float f5 = 1.0f / ((f * f2) - (f3 * f4));
        float f6 = vector2.x - this.v;
        float f7 = vector2.y - this.y;
        vector2.x = ((f2 * f6) * f5) - ((f3 * f7) * f5);
        vector2.y = ((f7 * f) * f5) - ((f6 * f4) * f5);
        return vector2;
    }

    public float worldToLocalRotation(float f) {
        float sinDeg = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f);
        float cosDeg = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f);
        return com.esotericsoftware.spine.utils.SpineUtils.atan2((this.t * sinDeg) - (this.w * cosDeg), (this.x * cosDeg) - (this.u * sinDeg)) * 57.295776f;
    }
}
