package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class VertexAttachment extends com.esotericsoftware.spine.attachments.Attachment {
    public static final java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger();
    public final int b;
    public int[] c;
    public float[] d;
    public int e;

    public VertexAttachment(java.lang.String str) {
        super(str);
        this.b = (f.getAndIncrement() & 65535) << 11;
    }

    public boolean applyDeform(com.esotericsoftware.spine.attachments.VertexAttachment vertexAttachment) {
        return this == vertexAttachment;
    }

    public void computeWorldVertices(com.esotericsoftware.spine.Slot slot, int i, int i2, float[] fArr, int i3, int i4) {
        int i5 = i3 + ((i2 >> 1) * i4);
        com.esotericsoftware.spine.Skeleton skeleton = slot.getSkeleton();
        com.badlogic.gdx.utils.FloatArray attachmentVertices = slot.getAttachmentVertices();
        float[] fArr2 = this.d;
        int[] iArr = this.c;
        if (iArr == null) {
            if (attachmentVertices.size > 0) {
                fArr2 = attachmentVertices.items;
            }
            com.esotericsoftware.spine.Bone bone = slot.getBone();
            float worldX = bone.getWorldX();
            float worldY = bone.getWorldY();
            float a = bone.getA();
            float b = bone.getB();
            float c = bone.getC();
            float d = bone.getD();
            int i6 = i;
            int i7 = i3;
            while (i7 < i5) {
                float f2 = fArr2[i6];
                float f3 = fArr2[i6 + 1];
                fArr[i7] = (f2 * a) + (f3 * b) + worldX;
                fArr[i7 + 1] = (f2 * c) + (f3 * d) + worldY;
                i6 += 2;
                i7 += i4;
            }
            return;
        }
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10 += 2) {
            int i11 = iArr[i8];
            i8 += i11 + 1;
            i9 += i11;
        }
        com.esotericsoftware.spine.Bone[] boneArr = skeleton.getBones().items;
        if (attachmentVertices.size == 0) {
            int i12 = i9 * 3;
            int i13 = i3;
            while (i13 < i5) {
                int i14 = i8 + 1;
                int i15 = iArr[i8] + i14;
                float f4 = 0.0f;
                float f5 = 0.0f;
                while (i14 < i15) {
                    com.esotericsoftware.spine.Bone bone2 = boneArr[iArr[i14]];
                    float f6 = fArr2[i12];
                    float f7 = fArr2[i12 + 1];
                    float f8 = fArr2[i12 + 2];
                    f4 += ((bone2.getA() * f6) + (bone2.getB() * f7) + bone2.getWorldX()) * f8;
                    f5 += ((f6 * bone2.getC()) + (f7 * bone2.getD()) + bone2.getWorldY()) * f8;
                    i14++;
                    i12 += 3;
                }
                fArr[i13] = f4;
                fArr[i13 + 1] = f5;
                i13 += i4;
                i8 = i14;
            }
            return;
        }
        float[] fArr3 = attachmentVertices.items;
        int i16 = i9 * 3;
        int i17 = i9 << 1;
        int i18 = i8;
        int i19 = i16;
        int i20 = i3;
        while (i20 < i5) {
            int i21 = i18 + 1;
            int i22 = iArr[i18] + i21;
            float f9 = 0.0f;
            float f10 = 0.0f;
            while (i21 < i22) {
                com.esotericsoftware.spine.Bone bone3 = boneArr[iArr[i21]];
                float f11 = fArr2[i19] + fArr3[i17];
                float f12 = fArr2[i19 + 1] + fArr3[i17 + 1];
                float f13 = fArr2[i19 + 2];
                f9 += ((bone3.getA() * f11) + (bone3.getB() * f12) + bone3.getWorldX()) * f13;
                f10 += ((f11 * bone3.getC()) + (f12 * bone3.getD()) + bone3.getWorldY()) * f13;
                i21++;
                i19 += 3;
                i17 += 2;
            }
            fArr[i20] = f9;
            fArr[i20 + 1] = f10;
            i20 += i4;
            i18 = i21;
        }
    }

    public int[] getBones() {
        return this.c;
    }

    public int getId() {
        return this.b;
    }

    public float[] getVertices() {
        return this.d;
    }

    public int getWorldVerticesLength() {
        return this.e;
    }

    public void setBones(int[] iArr) {
        this.c = iArr;
    }

    public void setVertices(float[] fArr) {
        this.d = fArr;
    }

    public void setWorldVerticesLength(int i) {
        this.e = i;
    }
}
