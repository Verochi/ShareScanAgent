package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class SkeletonBounds {
    public float a;
    public float b;
    public float c;
    public float d;
    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.attachments.BoundingBoxAttachment> e = new com.badlogic.gdx.utils.Array<>();
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> f = new com.badlogic.gdx.utils.Array<>();
    public com.badlogic.gdx.utils.Pool<com.badlogic.gdx.utils.FloatArray> g = new com.esotericsoftware.spine.SkeletonBounds.AnonymousClass1();

    /* renamed from: com.esotericsoftware.spine.SkeletonBounds$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.utils.Pool {
        public AnonymousClass1() {
        }

        @Override // com.badlogic.gdx.utils.Pool
        public java.lang.Object newObject() {
            return new com.badlogic.gdx.utils.FloatArray();
        }
    }

    public final void a() {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array = this.f;
        int i = array.size;
        float f = 2.1474836E9f;
        float f2 = 2.1474836E9f;
        float f3 = -2.1474836E9f;
        float f4 = -2.1474836E9f;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.utils.FloatArray floatArray = array.get(i2);
            float[] fArr = floatArray.items;
            int i3 = floatArray.size;
            for (int i4 = 0; i4 < i3; i4 += 2) {
                float f5 = fArr[i4];
                float f6 = fArr[i4 + 1];
                f = java.lang.Math.min(f, f5);
                f2 = java.lang.Math.min(f2, f6);
                f3 = java.lang.Math.max(f3, f5);
                f4 = java.lang.Math.max(f4, f6);
            }
        }
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public boolean aabbContainsPoint(float f, float f2) {
        return f >= this.a && f <= this.c && f2 >= this.b && f2 <= this.d;
    }

    public boolean aabbIntersectsSegment(float f, float f2, float f3, float f4) {
        float f5 = this.a;
        float f6 = this.b;
        float f7 = this.c;
        float f8 = this.d;
        if ((f <= f5 && f3 <= f5) || ((f2 <= f6 && f4 <= f6) || ((f >= f7 && f3 >= f7) || (f2 >= f8 && f4 >= f8)))) {
            return false;
        }
        float f9 = (f4 - f2) / (f3 - f);
        float f10 = ((f5 - f) * f9) + f2;
        if (f10 > f6 && f10 < f8) {
            return true;
        }
        float f11 = ((f7 - f) * f9) + f2;
        if (f11 > f6 && f11 < f8) {
            return true;
        }
        float f12 = ((f6 - f2) / f9) + f;
        if (f12 > f5 && f12 < f7) {
            return true;
        }
        float f13 = ((f8 - f2) / f9) + f;
        return f13 > f5 && f13 < f7;
    }

    public boolean aabbIntersectsSkeleton(com.esotericsoftware.spine.SkeletonBounds skeletonBounds) {
        return this.a < skeletonBounds.c && this.c > skeletonBounds.a && this.b < skeletonBounds.d && this.d > skeletonBounds.b;
    }

    public com.esotericsoftware.spine.attachments.BoundingBoxAttachment containsPoint(float f, float f2) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array = this.f;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (containsPoint(array.get(i2), f, f2)) {
                return this.e.get(i2);
            }
        }
        return null;
    }

    public boolean containsPoint(com.badlogic.gdx.utils.FloatArray floatArray, float f, float f2) {
        float[] fArr = floatArray.items;
        int i = floatArray.size;
        int i2 = i - 2;
        boolean z = false;
        for (int i3 = 0; i3 < i; i3 += 2) {
            float f3 = fArr[i3 + 1];
            float f4 = fArr[i2 + 1];
            if ((f3 < f2 && f4 >= f2) || (f4 < f2 && f3 >= f2)) {
                float f5 = fArr[i3];
                if (f5 + (((f2 - f3) / (f4 - f3)) * (fArr[i2] - f5)) < f) {
                    z = !z;
                }
            }
            i2 = i3;
        }
        return z;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.attachments.BoundingBoxAttachment> getBoundingBoxes() {
        return this.e;
    }

    public float getHeight() {
        return this.d - this.b;
    }

    public float getMaxX() {
        return this.c;
    }

    public float getMaxY() {
        return this.d;
    }

    public float getMinX() {
        return this.a;
    }

    public float getMinY() {
        return this.b;
    }

    public com.badlogic.gdx.utils.FloatArray getPolygon(com.esotericsoftware.spine.attachments.BoundingBoxAttachment boundingBoxAttachment) {
        if (boundingBoxAttachment == null) {
            throw new java.lang.IllegalArgumentException("boundingBox cannot be null.");
        }
        int indexOf = this.e.indexOf(boundingBoxAttachment, true);
        if (indexOf == -1) {
            return null;
        }
        return this.f.get(indexOf);
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> getPolygons() {
        return this.f;
    }

    public float getWidth() {
        return this.c - this.a;
    }

    public com.esotericsoftware.spine.attachments.BoundingBoxAttachment intersectsSegment(float f, float f2, float f3, float f4) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array = this.f;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (intersectsSegment(array.get(i2), f, f2, f3, f4)) {
                return this.e.get(i2);
            }
        }
        return null;
    }

    public boolean intersectsSegment(com.badlogic.gdx.utils.FloatArray floatArray, float f, float f2, float f3, float f4) {
        float[] fArr = floatArray.items;
        int i = floatArray.size;
        float f5 = f - f3;
        float f6 = f2 - f4;
        float f7 = (f * f4) - (f2 * f3);
        float f8 = fArr[i - 2];
        float f9 = fArr[i - 1];
        int i2 = 0;
        while (i2 < i) {
            float f10 = fArr[i2];
            float f11 = fArr[i2 + 1];
            float f12 = (f8 * f11) - (f9 * f10);
            float f13 = f8 - f10;
            float f14 = f9 - f11;
            float f15 = (f5 * f14) - (f6 * f13);
            float f16 = ((f13 * f7) - (f5 * f12)) / f15;
            if (((f16 >= f8 && f16 <= f10) || (f16 >= f10 && f16 <= f8)) && ((f16 >= f && f16 <= f3) || (f16 >= f3 && f16 <= f))) {
                float f17 = ((f14 * f7) - (f12 * f6)) / f15;
                if ((f17 >= f9 && f17 <= f11) || (f17 >= f11 && f17 <= f9)) {
                    if (f17 >= f2 && f17 <= f4) {
                        return true;
                    }
                    if (f17 >= f4 && f17 <= f2) {
                        return true;
                    }
                }
            }
            i2 += 2;
            f8 = f10;
            f9 = f11;
        }
        return false;
    }

    public void update(com.esotericsoftware.spine.Skeleton skeleton, boolean z) {
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.attachments.BoundingBoxAttachment> array = this.e;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.FloatArray> array2 = this.f;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array3 = skeleton.c;
        int i = array3.size;
        array.clear();
        this.g.freeAll(array2);
        array2.clear();
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.Slot slot = array3.get(i2);
            com.esotericsoftware.spine.attachments.Attachment attachment = slot.e;
            if (attachment instanceof com.esotericsoftware.spine.attachments.BoundingBoxAttachment) {
                com.esotericsoftware.spine.attachments.BoundingBoxAttachment boundingBoxAttachment = (com.esotericsoftware.spine.attachments.BoundingBoxAttachment) attachment;
                array.add(boundingBoxAttachment);
                com.badlogic.gdx.utils.FloatArray obtain = this.g.obtain();
                array2.add(obtain);
                boundingBoxAttachment.computeWorldVertices(slot, 0, boundingBoxAttachment.getWorldVerticesLength(), obtain.setSize(boundingBoxAttachment.getWorldVerticesLength()), 0, 2);
            }
        }
        if (z) {
            a();
            return;
        }
        this.a = -2.1474836E9f;
        this.b = -2.1474836E9f;
        this.c = 2.1474836E9f;
        this.d = 2.1474836E9f;
    }
}
