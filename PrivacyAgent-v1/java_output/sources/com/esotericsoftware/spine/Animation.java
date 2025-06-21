package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class Animation {
    public final java.lang.String a;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> b;
    public float c;

    /* renamed from: com.esotericsoftware.spine.Animation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.esotericsoftware.spine.Animation.MixPose.values().length];
            a = iArr;
            try {
                iArr[com.esotericsoftware.spine.Animation.MixPose.setup.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.esotericsoftware.spine.Animation.MixPose.current.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static class AttachmentTimeline implements com.esotericsoftware.spine.Animation.Timeline {
        public int a;
        public final float[] b;
        public final java.lang.String[] c;

        public AttachmentTimeline(int i) {
            this.b = new float[i];
            this.c = new java.lang.String[i];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            com.esotericsoftware.spine.Slot slot = skeleton.c.get(this.a);
            if (mixDirection == com.esotericsoftware.spine.Animation.MixDirection.out && mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                java.lang.String str = slot.a.f;
                slot.setAttachment(str != null ? skeleton.getAttachment(this.a, str) : null);
                return;
            }
            float[] fArr = this.b;
            if (f2 >= fArr[0]) {
                java.lang.String str2 = this.c[(f2 >= fArr[fArr.length + (-1)] ? fArr.length : com.esotericsoftware.spine.Animation.a(fArr, f2)) - 1];
                slot.setAttachment(str2 != null ? skeleton.getAttachment(this.a, str2) : null);
            } else if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                java.lang.String str3 = slot.a.f;
                slot.setAttachment(str3 != null ? skeleton.getAttachment(this.a, str3) : null);
            }
        }

        public java.lang.String[] getAttachmentNames() {
            return this.c;
        }

        public int getFrameCount() {
            return this.b.length;
        }

        public float[] getFrames() {
            return this.b;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.attachment.ordinal() << 24) + this.a;
        }

        public int getSlotIndex() {
            return this.a;
        }

        public void setFrame(int i, float f, java.lang.String str) {
            this.b[i] = f;
            this.c[i] = str;
        }

        public void setSlotIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.a = i;
        }
    }

    public static class ColorTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 5;
        public int b;
        public final float[] c;

        public ColorTimeline(int i) {
            super(i);
            this.c = new float[i * 5];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            float f5;
            float f6;
            float f7;
            com.esotericsoftware.spine.Slot slot = skeleton.c.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    slot.c.set(slot.a.d);
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    com.badlogic.gdx.graphics.Color color = slot.c;
                    com.badlogic.gdx.graphics.Color color2 = slot.a.d;
                    color.add((color2.r - color.r) * f3, (color2.g - color.g) * f3, (color2.b - color.b) * f3, (color2.a - color.a) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 5]) {
                int length = fArr.length;
                f5 = fArr[length - 4];
                f6 = fArr[length - 3];
                f7 = fArr[length - 2];
                f4 = fArr[length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 5);
                float f8 = fArr[b - 4];
                float f9 = fArr[b - 3];
                float f10 = fArr[b - 2];
                float f11 = fArr[b - 1];
                float f12 = fArr[b];
                float curvePercent = getCurvePercent((b / 5) - 1, 1.0f - ((f2 - f12) / (fArr[b - 5] - f12)));
                float f13 = ((fArr[b + 1] - f8) * curvePercent) + f8;
                float f14 = ((fArr[b + 2] - f9) * curvePercent) + f9;
                float f15 = ((fArr[b + 3] - f10) * curvePercent) + f10;
                f4 = ((fArr[b + 4] - f11) * curvePercent) + f11;
                f5 = f13;
                f6 = f14;
                f7 = f15;
            }
            if (f3 == 1.0f) {
                slot.c.set(f5, f6, f7, f4);
                return;
            }
            com.badlogic.gdx.graphics.Color color3 = slot.c;
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                color3.set(slot.a.d);
            }
            color3.add((f5 - color3.r) * f3, (f6 - color3.g) * f3, (f7 - color3.b) * f3, (f4 - color3.a) * f3);
        }

        public float[] getFrames() {
            return this.c;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.color.ordinal() << 24) + this.b;
        }

        public int getSlotIndex() {
            return this.b;
        }

        public void setFrame(int i, float f, float f2, float f3, float f4, float f5) {
            int i2 = i * 5;
            float[] fArr = this.c;
            fArr[i2] = f;
            fArr[i2 + 1] = f2;
            fArr[i2 + 2] = f3;
            fArr[i2 + 3] = f4;
            fArr[i2 + 4] = f5;
        }

        public void setSlotIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }
    }

    public static abstract class CurveTimeline implements com.esotericsoftware.spine.Animation.Timeline {
        public static final float BEZIER = 2.0f;
        public static final float LINEAR = 0.0f;
        public static final float STEPPED = 1.0f;
        public final float[] a;

        public CurveTimeline(int i) {
            if (i > 0) {
                this.a = new float[(i - 1) * 19];
                return;
            }
            throw new java.lang.IllegalArgumentException("frameCount must be > 0: " + i);
        }

        public float getCurvePercent(int i, float f) {
            float f2 = 0.0f;
            float clamp = com.badlogic.gdx.math.MathUtils.clamp(f, 0.0f, 1.0f);
            float[] fArr = this.a;
            int i2 = i * 19;
            float f3 = fArr[i2];
            if (f3 == 0.0f) {
                return clamp;
            }
            if (f3 == 1.0f) {
                return 0.0f;
            }
            int i3 = i2 + 1;
            int i4 = (i3 + 19) - 1;
            int i5 = i3;
            while (i5 < i4) {
                f2 = fArr[i5];
                if (f2 >= clamp) {
                    if (i5 == i3) {
                        return (fArr[i5 + 1] * clamp) / f2;
                    }
                    float f4 = fArr[i5 - 2];
                    float f5 = fArr[i5 - 1];
                    return f5 + (((fArr[i5 + 1] - f5) * (clamp - f4)) / (f2 - f4));
                }
                i5 += 2;
            }
            float f6 = fArr[i5 - 1];
            return f6 + (((1.0f - f6) * (clamp - f2)) / (1.0f - f2));
        }

        public float getCurveType(int i) {
            int i2 = i * 19;
            float[] fArr = this.a;
            if (i2 == fArr.length) {
                return 0.0f;
            }
            float f = fArr[i2];
            if (f == 0.0f) {
                return 0.0f;
            }
            return f == 1.0f ? 1.0f : 2.0f;
        }

        public int getFrameCount() {
            return (this.a.length / 19) + 1;
        }

        public void setCurve(int i, float f, float f2, float f3, float f4) {
            float f5 = (((-f) * 2.0f) + f3) * 0.03f;
            float f6 = (((-f2) * 2.0f) + f4) * 0.03f;
            float f7 = (((f - f3) * 3.0f) + 1.0f) * 0.006f;
            float f8 = (((f2 - f4) * 3.0f) + 1.0f) * 0.006f;
            float f9 = (f5 * 2.0f) + f7;
            float f10 = (f6 * 2.0f) + f8;
            float f11 = (f * 0.3f) + f5 + (f7 * 0.16666667f);
            float f12 = (f2 * 0.3f) + f6 + (0.16666667f * f8);
            int i2 = i * 19;
            float[] fArr = this.a;
            int i3 = i2 + 1;
            fArr[i2] = 2.0f;
            int i4 = (i3 + 19) - 1;
            float f13 = f12;
            float f14 = f10;
            float f15 = f11;
            float f16 = f9;
            float f17 = f13;
            for (int i5 = i3; i5 < i4; i5 += 2) {
                fArr[i5] = f11;
                fArr[i5 + 1] = f13;
                f15 += f16;
                f17 += f14;
                f16 += f7;
                f14 += f8;
                f11 += f15;
                f13 += f17;
            }
        }

        public void setLinear(int i) {
            this.a[i * 19] = 0.0f;
        }

        public void setStepped(int i) {
            this.a[i * 19] = 1.0f;
        }
    }

    public static class DeformTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public int b;
        public com.esotericsoftware.spine.attachments.VertexAttachment c;
        public final float[] d;
        public final float[][] e;

        public DeformTimeline(int i) {
            super(i);
            this.d = new float[i];
            this.e = new float[i][];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            com.esotericsoftware.spine.Slot slot = skeleton.c.get(this.b);
            com.esotericsoftware.spine.attachments.Attachment attachment = slot.e;
            if (attachment instanceof com.esotericsoftware.spine.attachments.VertexAttachment) {
                com.esotericsoftware.spine.attachments.VertexAttachment vertexAttachment = (com.esotericsoftware.spine.attachments.VertexAttachment) attachment;
                if (vertexAttachment.applyDeform(this.c)) {
                    com.badlogic.gdx.utils.FloatArray attachmentVertices = slot.getAttachmentVertices();
                    if (attachmentVertices.size == 0) {
                        f3 = 1.0f;
                    }
                    float[][] fArr = this.e;
                    int i = 0;
                    int length = fArr[0].length;
                    float[] fArr2 = this.d;
                    if (f2 < fArr2[0]) {
                        int i2 = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                        if (i2 == 1) {
                            attachmentVertices.clear();
                            return;
                        }
                        if (i2 != 2) {
                            return;
                        }
                        if (f3 == 1.0f) {
                            attachmentVertices.clear();
                            return;
                        }
                        float[] size = attachmentVertices.setSize(length);
                        if (vertexAttachment.getBones() != null) {
                            float f4 = 1.0f - f3;
                            while (i < length) {
                                if (i < size.length) {
                                    size[i] = size[i] * f4;
                                }
                                i++;
                            }
                            return;
                        }
                        float[] vertices = vertexAttachment.getVertices();
                        while (i < length) {
                            if (i < size.length && i < vertices.length) {
                                float f5 = size[i];
                                size[i] = f5 + ((vertices[i] - f5) * f3);
                            }
                            i++;
                        }
                        return;
                    }
                    float[] size2 = attachmentVertices.setSize(length);
                    if (f2 >= fArr2[fArr2.length - 1]) {
                        float[] fArr3 = fArr[fArr2.length - 1];
                        if (f3 == 1.0f) {
                            java.lang.System.arraycopy(fArr3, 0, size2, 0, length);
                            return;
                        }
                        if (mixPose != com.esotericsoftware.spine.Animation.MixPose.setup) {
                            while (i < length) {
                                float f6 = size2[i];
                                size2[i] = f6 + ((fArr3[i] - f6) * f3);
                                i++;
                            }
                            return;
                        }
                        if (vertexAttachment.getBones() != null) {
                            while (i < length) {
                                size2[i] = fArr3[i] * f3;
                                i++;
                            }
                            return;
                        } else {
                            float[] vertices2 = vertexAttachment.getVertices();
                            while (i < length) {
                                float f7 = vertices2[i];
                                size2[i] = f7 + ((fArr3[i] - f7) * f3);
                                i++;
                            }
                            return;
                        }
                    }
                    int a = com.esotericsoftware.spine.Animation.a(fArr2, f2);
                    int i3 = a - 1;
                    float[] fArr4 = fArr[i3];
                    float[] fArr5 = fArr[a];
                    float f8 = fArr2[a];
                    float curvePercent = getCurvePercent(i3, 1.0f - ((f2 - f8) / (fArr2[i3] - f8)));
                    if (f3 == 1.0f) {
                        while (i < length) {
                            float f9 = fArr4[i];
                            size2[i] = f9 + ((fArr5[i] - f9) * curvePercent);
                            i++;
                        }
                        return;
                    }
                    if (mixPose != com.esotericsoftware.spine.Animation.MixPose.setup) {
                        while (i < length) {
                            float f10 = fArr4[i];
                            float f11 = size2[i];
                            size2[i] = f11 + (((f10 + ((fArr5[i] - f10) * curvePercent)) - f11) * f3);
                            i++;
                        }
                        return;
                    }
                    if (vertexAttachment.getBones() != null) {
                        while (i < length) {
                            float f12 = fArr4[i];
                            size2[i] = (f12 + ((fArr5[i] - f12) * curvePercent)) * f3;
                            i++;
                        }
                        return;
                    }
                    float[] vertices3 = vertexAttachment.getVertices();
                    while (i < length) {
                        float f13 = fArr4[i];
                        float f14 = vertices3[i];
                        size2[i] = f14 + (((f13 + ((fArr5[i] - f13) * curvePercent)) - f14) * f3);
                        i++;
                    }
                }
            }
        }

        public com.esotericsoftware.spine.attachments.VertexAttachment getAttachment() {
            return this.c;
        }

        public float[] getFrames() {
            return this.d;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.deform.ordinal() << 27) + this.c.getId() + this.b;
        }

        public int getSlotIndex() {
            return this.b;
        }

        public float[][] getVertices() {
            return this.e;
        }

        public void setAttachment(com.esotericsoftware.spine.attachments.VertexAttachment vertexAttachment) {
            this.c = vertexAttachment;
        }

        public void setFrame(int i, float f, float[] fArr) {
            this.d[i] = f;
            this.e[i] = fArr;
        }

        public void setSlotIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }
    }

    public static class DrawOrderTimeline implements com.esotericsoftware.spine.Animation.Timeline {
        public final float[] a;
        public final int[][] b;

        public DrawOrderTimeline(int i) {
            this.a = new float[i];
            this.b = new int[i][];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array2 = skeleton.d;
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array3 = skeleton.c;
            if (mixDirection == com.esotericsoftware.spine.Animation.MixDirection.out && mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                java.lang.System.arraycopy(array3.items, 0, array2.items, 0, array3.size);
                return;
            }
            float[] fArr = this.a;
            if (f2 < fArr[0]) {
                if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                    java.lang.System.arraycopy(array3.items, 0, array2.items, 0, array3.size);
                    return;
                }
                return;
            }
            int[] iArr = this.b[(f2 >= fArr[fArr.length + (-1)] ? fArr.length : com.esotericsoftware.spine.Animation.a(fArr, f2)) - 1];
            if (iArr == null) {
                java.lang.System.arraycopy(array3.items, 0, array2.items, 0, array3.size);
                return;
            }
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                array2.set(i, array3.get(iArr[i]));
            }
        }

        public int[][] getDrawOrders() {
            return this.b;
        }

        public int getFrameCount() {
            return this.a.length;
        }

        public float[] getFrames() {
            return this.a;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return com.esotericsoftware.spine.Animation.TimelineType.drawOrder.ordinal() << 24;
        }

        public void setFrame(int i, float f, int[] iArr) {
            this.a[i] = f;
            this.b[i] = iArr;
        }
    }

    public static class EventTimeline implements com.esotericsoftware.spine.Animation.Timeline {
        public final float[] a;
        public final com.esotericsoftware.spine.Event[] b;

        public EventTimeline(int i) {
            this.a = new float[i];
            this.b = new com.esotericsoftware.spine.Event[i];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            if (array == null) {
                return;
            }
            float[] fArr = this.a;
            int length = fArr.length;
            if (f > f2) {
                apply(skeleton, f, 2.1474836E9f, array, f3, mixPose, mixDirection);
                f4 = -1.0f;
            } else if (f >= fArr[length - 1]) {
                return;
            } else {
                f4 = f;
            }
            int i = 0;
            float f5 = fArr[0];
            if (f2 < f5) {
                return;
            }
            if (f4 >= f5) {
                int a = com.esotericsoftware.spine.Animation.a(fArr, f4);
                float f6 = fArr[a];
                while (a > 0 && fArr[a - 1] == f6) {
                    a--;
                }
                i = a;
            }
            while (i < length && f2 >= fArr[i]) {
                array.add(this.b[i]);
                i++;
            }
        }

        public com.esotericsoftware.spine.Event[] getEvents() {
            return this.b;
        }

        public int getFrameCount() {
            return this.a.length;
        }

        public float[] getFrames() {
            return this.a;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return com.esotericsoftware.spine.Animation.TimelineType.event.ordinal() << 24;
        }

        public void setFrame(int i, com.esotericsoftware.spine.Event event) {
            this.a[i] = event.e;
            this.b[i] = event;
        }
    }

    public static class IkConstraintTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 3;
        public int b;
        public final float[] c;

        public IkConstraintTimeline(int i) {
            super(i);
            this.c = new float[i * 3];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            com.esotericsoftware.spine.IkConstraint ikConstraint = skeleton.e.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    com.esotericsoftware.spine.IkConstraintData ikConstraintData = ikConstraint.a;
                    ikConstraint.d = ikConstraintData.f;
                    ikConstraint.e = ikConstraintData.e;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f4 = ikConstraint.d;
                    com.esotericsoftware.spine.IkConstraintData ikConstraintData2 = ikConstraint.a;
                    ikConstraint.d = f4 + ((ikConstraintData2.f - f4) * f3);
                    ikConstraint.e = ikConstraintData2.e;
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 3]) {
                if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                    com.esotericsoftware.spine.IkConstraintData ikConstraintData3 = ikConstraint.a;
                    float f5 = ikConstraintData3.f;
                    ikConstraint.d = f5 + ((fArr[fArr.length - 2] - f5) * f3);
                    ikConstraint.e = mixDirection == com.esotericsoftware.spine.Animation.MixDirection.out ? ikConstraintData3.e : (int) fArr[fArr.length - 1];
                    return;
                }
                float f6 = ikConstraint.d;
                ikConstraint.d = f6 + ((fArr[fArr.length - 2] - f6) * f3);
                if (mixDirection == com.esotericsoftware.spine.Animation.MixDirection.in) {
                    ikConstraint.e = (int) fArr[fArr.length - 1];
                    return;
                }
                return;
            }
            int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 3);
            float f7 = fArr[b - 2];
            float f8 = fArr[b];
            float curvePercent = getCurvePercent((b / 3) - 1, 1.0f - ((f2 - f8) / (fArr[b - 3] - f8)));
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                com.esotericsoftware.spine.IkConstraintData ikConstraintData4 = ikConstraint.a;
                float f9 = ikConstraintData4.f;
                ikConstraint.d = f9 + (((f7 + ((fArr[b + 1] - f7) * curvePercent)) - f9) * f3);
                ikConstraint.e = mixDirection == com.esotericsoftware.spine.Animation.MixDirection.out ? ikConstraintData4.e : (int) fArr[b - 1];
                return;
            }
            float f10 = ikConstraint.d;
            ikConstraint.d = f10 + (((f7 + ((fArr[b + 1] - f7) * curvePercent)) - f10) * f3);
            if (mixDirection == com.esotericsoftware.spine.Animation.MixDirection.in) {
                ikConstraint.e = (int) fArr[b - 1];
            }
        }

        public float[] getFrames() {
            return this.c;
        }

        public int getIkConstraintIndex() {
            return this.b;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.ikConstraint.ordinal() << 24) + this.b;
        }

        public void setFrame(int i, float f, float f2, int i2) {
            int i3 = i * 3;
            float[] fArr = this.c;
            fArr[i3] = f;
            fArr[i3 + 1] = f2;
            fArr[i3 + 2] = i2;
        }

        public void setIkConstraintIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }
    }

    public enum MixDirection {
        in,
        out
    }

    public enum MixPose {
        setup,
        current,
        currentLayered
    }

    public static class PathConstraintMixTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 3;
        public int b;
        public final float[] c;

        public PathConstraintMixTimeline(int i) {
            super(i);
            this.c = new float[i * 3];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            float f5;
            com.esotericsoftware.spine.PathConstraint pathConstraint = skeleton.g.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    com.esotericsoftware.spine.PathConstraintData pathConstraintData = pathConstraint.a;
                    pathConstraint.f = pathConstraintData.k;
                    pathConstraint.g = pathConstraintData.l;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f6 = pathConstraint.f;
                    com.esotericsoftware.spine.PathConstraintData pathConstraintData2 = pathConstraint.a;
                    pathConstraint.f = f6 + ((pathConstraintData2.k - f6) * f3);
                    float f7 = pathConstraint.g;
                    pathConstraint.g = f7 + ((pathConstraintData2.l - f7) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 3]) {
                f5 = fArr[fArr.length - 2];
                f4 = fArr[fArr.length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 3);
                float f8 = fArr[b - 2];
                float f9 = fArr[b - 1];
                float f10 = fArr[b];
                float curvePercent = getCurvePercent((b / 3) - 1, 1.0f - ((f2 - f10) / (fArr[b - 3] - f10)));
                float f11 = ((fArr[b + 1] - f8) * curvePercent) + f8;
                f4 = ((fArr[b + 2] - f9) * curvePercent) + f9;
                f5 = f11;
            }
            if (mixPose != com.esotericsoftware.spine.Animation.MixPose.setup) {
                float f12 = pathConstraint.f;
                pathConstraint.f = f12 + ((f5 - f12) * f3);
                float f13 = pathConstraint.g;
                pathConstraint.g = f13 + ((f4 - f13) * f3);
                return;
            }
            com.esotericsoftware.spine.PathConstraintData pathConstraintData3 = pathConstraint.a;
            float f14 = pathConstraintData3.k;
            pathConstraint.f = f14 + ((f5 - f14) * f3);
            float f15 = pathConstraintData3.l;
            pathConstraint.g = f15 + ((f4 - f15) * f3);
        }

        public float[] getFrames() {
            return this.c;
        }

        public int getPathConstraintIndex() {
            return this.b;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.pathConstraintMix.ordinal() << 24) + this.b;
        }

        public void setFrame(int i, float f, float f2, float f3) {
            int i2 = i * 3;
            float[] fArr = this.c;
            fArr[i2] = f;
            fArr[i2 + 1] = f2;
            fArr[i2 + 2] = f3;
        }

        public void setPathConstraintIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }
    }

    public static class PathConstraintPositionTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 2;
        public int b;
        public final float[] c;

        public PathConstraintPositionTimeline(int i) {
            super(i);
            this.c = new float[i * 2];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float curvePercent;
            com.esotericsoftware.spine.PathConstraint pathConstraint = skeleton.g.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    pathConstraint.d = pathConstraint.a.i;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f4 = pathConstraint.d;
                    pathConstraint.d = f4 + ((pathConstraint.a.i - f4) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 2]) {
                curvePercent = fArr[fArr.length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 2);
                float f5 = fArr[b - 1];
                float f6 = fArr[b];
                curvePercent = ((fArr[b + 1] - f5) * getCurvePercent((b / 2) - 1, 1.0f - ((f2 - f6) / (fArr[b - 2] - f6)))) + f5;
            }
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                float f7 = pathConstraint.a.i;
                pathConstraint.d = f7 + ((curvePercent - f7) * f3);
            } else {
                float f8 = pathConstraint.d;
                pathConstraint.d = f8 + ((curvePercent - f8) * f3);
            }
        }

        public float[] getFrames() {
            return this.c;
        }

        public int getPathConstraintIndex() {
            return this.b;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.pathConstraintPosition.ordinal() << 24) + this.b;
        }

        public void setFrame(int i, float f, float f2) {
            int i2 = i * 2;
            float[] fArr = this.c;
            fArr[i2] = f;
            fArr[i2 + 1] = f2;
        }

        public void setPathConstraintIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }
    }

    public static class PathConstraintSpacingTimeline extends com.esotericsoftware.spine.Animation.PathConstraintPositionTimeline {
        public PathConstraintSpacingTimeline(int i) {
            super(i);
        }

        @Override // com.esotericsoftware.spine.Animation.PathConstraintPositionTimeline, com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float curvePercent;
            com.esotericsoftware.spine.PathConstraint pathConstraint = skeleton.g.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    pathConstraint.e = pathConstraint.a.j;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f4 = pathConstraint.e;
                    pathConstraint.e = f4 + ((pathConstraint.a.j - f4) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 2]) {
                curvePercent = fArr[fArr.length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 2);
                float f5 = fArr[b - 1];
                float f6 = fArr[b];
                curvePercent = ((fArr[b + 1] - f5) * getCurvePercent((b / 2) - 1, 1.0f - ((f2 - f6) / (fArr[b - 2] - f6)))) + f5;
            }
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                float f7 = pathConstraint.a.j;
                pathConstraint.e = f7 + ((curvePercent - f7) * f3);
            } else {
                float f8 = pathConstraint.e;
                pathConstraint.e = f8 + ((curvePercent - f8) * f3);
            }
        }

        @Override // com.esotericsoftware.spine.Animation.PathConstraintPositionTimeline, com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.pathConstraintSpacing.ordinal() << 24) + this.b;
        }
    }

    public static class RotateTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 2;
        public int b;
        public final float[] c;

        public RotateTimeline(int i) {
            super(i);
            this.c = new float[i << 1];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            com.esotericsoftware.spine.Bone bone = skeleton.b.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    bone.g = bone.a.g;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f4 = bone.a.g;
                    float f5 = bone.g;
                    bone.g = f5 + (((f4 - f5) - ((16384 - ((int) (16384.499999999996d - (r9 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 2]) {
                if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                    bone.g = bone.a.g + (fArr[fArr.length - 1] * f3);
                    return;
                }
                float f6 = bone.a.g + fArr[fArr.length - 1];
                float f7 = bone.g;
                bone.g = f7 + (((f6 - f7) - ((16384 - ((int) (16384.499999999996d - (r10 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * f3);
                return;
            }
            int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 2);
            float f8 = fArr[b - 1];
            float f9 = fArr[b];
            float curvePercent = f8 + (((fArr[b + 1] - f8) - ((16384 - ((int) (16384.499999999996d - (r9 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * getCurvePercent((b >> 1) - 1, 1.0f - ((f2 - f9) / (fArr[b - 2] - f9))));
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                bone.g = bone.a.g + ((curvePercent - ((16384 - ((int) (16384.499999999996d - (curvePercent / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * f3);
            } else {
                float f10 = bone.a.g + curvePercent;
                float f11 = bone.g;
                bone.g = f11 + (((f10 - f11) - ((16384 - ((int) (16384.499999999996d - (r9 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * f3);
            }
        }

        public int getBoneIndex() {
            return this.b;
        }

        public float[] getFrames() {
            return this.c;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.rotate.ordinal() << 24) + this.b;
        }

        public void setBoneIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }

        public void setFrame(int i, float f, float f2) {
            int i2 = i << 1;
            float[] fArr = this.c;
            fArr[i2] = f;
            fArr[i2 + 1] = f2;
        }
    }

    public static class ScaleTimeline extends com.esotericsoftware.spine.Animation.TranslateTimeline {
        public ScaleTimeline(int i) {
            super(i);
        }

        @Override // com.esotericsoftware.spine.Animation.TranslateTimeline, com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            float f5;
            float f6;
            float f7;
            com.esotericsoftware.spine.Bone bone = skeleton.b.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    com.esotericsoftware.spine.BoneData boneData = bone.a;
                    bone.h = boneData.h;
                    bone.i = boneData.i;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f8 = bone.h;
                    com.esotericsoftware.spine.BoneData boneData2 = bone.a;
                    bone.h = f8 + ((boneData2.h - f8) * f3);
                    float f9 = bone.i;
                    bone.i = f9 + ((boneData2.i - f9) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 3]) {
                float f10 = fArr[fArr.length - 2];
                com.esotericsoftware.spine.BoneData boneData3 = bone.a;
                f5 = f10 * boneData3.h;
                f4 = fArr[fArr.length - 1] * boneData3.i;
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 3);
                float f11 = fArr[b - 2];
                float f12 = fArr[b - 1];
                float f13 = fArr[b];
                float curvePercent = getCurvePercent((b / 3) - 1, 1.0f - ((f2 - f13) / (fArr[b - 3] - f13)));
                float f14 = f11 + ((fArr[b + 1] - f11) * curvePercent);
                com.esotericsoftware.spine.BoneData boneData4 = bone.a;
                float f15 = f14 * boneData4.h;
                f4 = boneData4.i * (f12 + ((fArr[b + 2] - f12) * curvePercent));
                f5 = f15;
            }
            if (f3 == 1.0f) {
                bone.h = f5;
                bone.i = f4;
                return;
            }
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                com.esotericsoftware.spine.BoneData boneData5 = bone.a;
                f6 = boneData5.h;
                f7 = boneData5.i;
            } else {
                f6 = bone.h;
                f7 = bone.i;
            }
            if (mixDirection == com.esotericsoftware.spine.Animation.MixDirection.out) {
                f5 = java.lang.Math.abs(f5) * java.lang.Math.signum(f6);
                f4 = java.lang.Math.abs(f4) * java.lang.Math.signum(f7);
            } else {
                f6 = java.lang.Math.abs(f6) * java.lang.Math.signum(f5);
                f7 = java.lang.Math.abs(f7) * java.lang.Math.signum(f4);
            }
            bone.h = f6 + ((f5 - f6) * f3);
            bone.i = f7 + ((f4 - f7) * f3);
        }

        @Override // com.esotericsoftware.spine.Animation.TranslateTimeline, com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.scale.ordinal() << 24) + this.b;
        }
    }

    public static class ShearTimeline extends com.esotericsoftware.spine.Animation.TranslateTimeline {
        public ShearTimeline(int i) {
            super(i);
        }

        @Override // com.esotericsoftware.spine.Animation.TranslateTimeline, com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            float f5;
            com.esotericsoftware.spine.Bone bone = skeleton.b.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    com.esotericsoftware.spine.BoneData boneData = bone.a;
                    bone.j = boneData.j;
                    bone.k = boneData.k;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f6 = bone.j;
                    com.esotericsoftware.spine.BoneData boneData2 = bone.a;
                    bone.j = f6 + ((boneData2.j - f6) * f3);
                    float f7 = bone.k;
                    bone.k = f7 + ((boneData2.k - f7) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 3]) {
                f5 = fArr[fArr.length - 2];
                f4 = fArr[fArr.length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 3);
                float f8 = fArr[b - 2];
                float f9 = fArr[b - 1];
                float f10 = fArr[b];
                float curvePercent = getCurvePercent((b / 3) - 1, 1.0f - ((f2 - f10) / (fArr[b - 3] - f10)));
                float f11 = ((fArr[b + 1] - f8) * curvePercent) + f8;
                f4 = ((fArr[b + 2] - f9) * curvePercent) + f9;
                f5 = f11;
            }
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                com.esotericsoftware.spine.BoneData boneData3 = bone.a;
                bone.j = boneData3.j + (f5 * f3);
                bone.k = boneData3.k + (f4 * f3);
            } else {
                float f12 = bone.j;
                com.esotericsoftware.spine.BoneData boneData4 = bone.a;
                bone.j = f12 + (((boneData4.j + f5) - f12) * f3);
                float f13 = bone.k;
                bone.k = f13 + (((boneData4.k + f4) - f13) * f3);
            }
        }

        @Override // com.esotericsoftware.spine.Animation.TranslateTimeline, com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.shear.ordinal() << 24) + this.b;
        }
    }

    public interface Timeline {
        void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection);

        int getPropertyId();
    }

    public enum TimelineType {
        rotate,
        translate,
        scale,
        shear,
        attachment,
        color,
        deform,
        event,
        drawOrder,
        ikConstraint,
        transformConstraint,
        pathConstraintPosition,
        pathConstraintSpacing,
        pathConstraintMix,
        twoColor
    }

    public static class TransformConstraintTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 5;
        public int b;
        public final float[] c;

        public TransformConstraintTimeline(int i) {
            super(i);
            this.c = new float[i * 5];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            float f5;
            float f6;
            float f7;
            com.esotericsoftware.spine.TransformConstraint transformConstraint = skeleton.f.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                com.esotericsoftware.spine.TransformConstraintData transformConstraintData = transformConstraint.a;
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    transformConstraint.d = transformConstraintData.e;
                    transformConstraint.e = transformConstraintData.f;
                    transformConstraint.f = transformConstraintData.g;
                    transformConstraint.g = transformConstraintData.h;
                    return;
                }
                if (i != 2) {
                    return;
                }
                float f8 = transformConstraint.d;
                transformConstraint.d = f8 + ((transformConstraintData.e - f8) * f3);
                float f9 = transformConstraint.e;
                transformConstraint.e = f9 + ((transformConstraintData.f - f9) * f3);
                float f10 = transformConstraint.f;
                transformConstraint.f = f10 + ((transformConstraintData.g - f10) * f3);
                float f11 = transformConstraint.g;
                transformConstraint.g = f11 + ((transformConstraintData.h - f11) * f3);
                return;
            }
            if (f2 >= fArr[fArr.length - 5]) {
                int length = fArr.length;
                f5 = fArr[length - 4];
                f6 = fArr[length - 3];
                f7 = fArr[length - 2];
                f4 = fArr[length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 5);
                float f12 = fArr[b - 4];
                float f13 = fArr[b - 3];
                float f14 = fArr[b - 2];
                float f15 = fArr[b - 1];
                float f16 = fArr[b];
                float curvePercent = getCurvePercent((b / 5) - 1, 1.0f - ((f2 - f16) / (fArr[b - 5] - f16)));
                float f17 = ((fArr[b + 1] - f12) * curvePercent) + f12;
                float f18 = ((fArr[b + 2] - f13) * curvePercent) + f13;
                float f19 = ((fArr[b + 3] - f14) * curvePercent) + f14;
                f4 = ((fArr[b + 4] - f15) * curvePercent) + f15;
                f5 = f17;
                f6 = f18;
                f7 = f19;
            }
            if (mixPose != com.esotericsoftware.spine.Animation.MixPose.setup) {
                float f20 = transformConstraint.d;
                transformConstraint.d = f20 + ((f5 - f20) * f3);
                float f21 = transformConstraint.e;
                transformConstraint.e = f21 + ((f6 - f21) * f3);
                float f22 = transformConstraint.f;
                transformConstraint.f = f22 + ((f7 - f22) * f3);
                float f23 = transformConstraint.g;
                transformConstraint.g = f23 + ((f4 - f23) * f3);
                return;
            }
            com.esotericsoftware.spine.TransformConstraintData transformConstraintData2 = transformConstraint.a;
            float f24 = transformConstraintData2.e;
            transformConstraint.d = f24 + ((f5 - f24) * f3);
            float f25 = transformConstraintData2.f;
            transformConstraint.e = f25 + ((f6 - f25) * f3);
            float f26 = transformConstraintData2.g;
            transformConstraint.f = f26 + ((f7 - f26) * f3);
            float f27 = transformConstraintData2.h;
            transformConstraint.g = f27 + ((f4 - f27) * f3);
        }

        public float[] getFrames() {
            return this.c;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.transformConstraint.ordinal() << 24) + this.b;
        }

        public int getTransformConstraintIndex() {
            return this.b;
        }

        public void setFrame(int i, float f, float f2, float f3, float f4, float f5) {
            int i2 = i * 5;
            float[] fArr = this.c;
            fArr[i2] = f;
            fArr[i2 + 1] = f2;
            fArr[i2 + 2] = f3;
            fArr[i2 + 3] = f4;
            fArr[i2 + 4] = f5;
        }

        public void setTransformConstraintIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }
    }

    public static class TranslateTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 3;
        public int b;
        public final float[] c;

        public TranslateTimeline(int i) {
            super(i);
            this.c = new float[i * 3];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            float f5;
            com.esotericsoftware.spine.Bone bone = skeleton.b.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    com.esotericsoftware.spine.BoneData boneData = bone.a;
                    bone.e = boneData.e;
                    bone.f = boneData.f;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    float f6 = bone.e;
                    com.esotericsoftware.spine.BoneData boneData2 = bone.a;
                    bone.e = f6 + ((boneData2.e - f6) * f3);
                    float f7 = bone.f;
                    bone.f = f7 + ((boneData2.f - f7) * f3);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 3]) {
                f5 = fArr[fArr.length - 2];
                f4 = fArr[fArr.length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 3);
                float f8 = fArr[b - 2];
                float f9 = fArr[b - 1];
                float f10 = fArr[b];
                float curvePercent = getCurvePercent((b / 3) - 1, 1.0f - ((f2 - f10) / (fArr[b - 3] - f10)));
                float f11 = ((fArr[b + 1] - f8) * curvePercent) + f8;
                f4 = ((fArr[b + 2] - f9) * curvePercent) + f9;
                f5 = f11;
            }
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                com.esotericsoftware.spine.BoneData boneData3 = bone.a;
                bone.e = boneData3.e + (f5 * f3);
                bone.f = boneData3.f + (f4 * f3);
            } else {
                float f12 = bone.e;
                com.esotericsoftware.spine.BoneData boneData4 = bone.a;
                bone.e = f12 + (((boneData4.e + f5) - f12) * f3);
                float f13 = bone.f;
                bone.f = f13 + (((boneData4.f + f4) - f13) * f3);
            }
        }

        public int getBoneIndex() {
            return this.b;
        }

        public float[] getFrames() {
            return this.c;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.translate.ordinal() << 24) + this.b;
        }

        public void setBoneIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }

        public void setFrame(int i, float f, float f2, float f3) {
            int i2 = i * 3;
            float[] fArr = this.c;
            fArr[i2] = f;
            fArr[i2 + 1] = f2;
            fArr[i2 + 2] = f3;
        }
    }

    public static class TwoColorTimeline extends com.esotericsoftware.spine.Animation.CurveTimeline {
        public static final int ENTRIES = 8;
        public int b;
        public final float[] c;

        public TwoColorTimeline(int i) {
            super(i);
            this.c = new float[i * 8];
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            com.esotericsoftware.spine.Slot slot = skeleton.c.get(this.b);
            float[] fArr = this.c;
            if (f2 < fArr[0]) {
                int i = com.esotericsoftware.spine.Animation.AnonymousClass1.a[mixPose.ordinal()];
                if (i == 1) {
                    slot.c.set(slot.a.d);
                    slot.d.set(slot.a.e);
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    com.badlogic.gdx.graphics.Color color = slot.c;
                    com.badlogic.gdx.graphics.Color color2 = slot.d;
                    com.esotericsoftware.spine.SlotData slotData = slot.a;
                    com.badlogic.gdx.graphics.Color color3 = slotData.d;
                    com.badlogic.gdx.graphics.Color color4 = slotData.e;
                    color.add((color3.r - color.r) * f3, (color3.g - color.g) * f3, (color3.b - color.b) * f3, (color3.a - color.a) * f3);
                    color2.add((color4.r - color2.r) * f3, (color4.g - color2.g) * f3, (color4.b - color2.b) * f3, 0.0f);
                    return;
                }
            }
            if (f2 >= fArr[fArr.length - 8]) {
                int length = fArr.length;
                f5 = fArr[length - 7];
                f6 = fArr[length - 6];
                f7 = fArr[length - 5];
                f8 = fArr[length - 4];
                f9 = fArr[length - 3];
                f10 = fArr[length - 2];
                f4 = fArr[length - 1];
            } else {
                int b = com.esotericsoftware.spine.Animation.b(fArr, f2, 8);
                float f11 = fArr[b - 7];
                float f12 = fArr[b - 6];
                float f13 = fArr[b - 5];
                float f14 = fArr[b - 4];
                float f15 = fArr[b - 3];
                float f16 = fArr[b - 2];
                float f17 = fArr[b - 1];
                float f18 = fArr[b];
                float curvePercent = getCurvePercent((b / 8) - 1, 1.0f - ((f2 - f18) / (fArr[b - 8] - f18)));
                float f19 = ((fArr[b + 1] - f11) * curvePercent) + f11;
                float f20 = ((fArr[b + 2] - f12) * curvePercent) + f12;
                float f21 = ((fArr[b + 3] - f13) * curvePercent) + f13;
                float f22 = ((fArr[b + 4] - f14) * curvePercent) + f14;
                float f23 = ((fArr[b + 5] - f15) * curvePercent) + f15;
                float f24 = ((fArr[b + 6] - f16) * curvePercent) + f16;
                f4 = f17 + ((fArr[b + 7] - f17) * curvePercent);
                f5 = f19;
                f6 = f20;
                f7 = f21;
                f8 = f22;
                f9 = f23;
                f10 = f24;
            }
            if (f3 == 1.0f) {
                slot.c.set(f5, f6, f7, f8);
                slot.d.set(f9, f10, f4, 1.0f);
                return;
            }
            com.badlogic.gdx.graphics.Color color5 = slot.c;
            com.badlogic.gdx.graphics.Color color6 = slot.d;
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                color5.set(slot.a.d);
                color6.set(slot.a.e);
            }
            color5.add((f5 - color5.r) * f3, (f6 - color5.g) * f3, (f7 - color5.b) * f3, (f8 - color5.a) * f3);
            color6.add((f9 - color6.r) * f3, (f10 - color6.g) * f3, (f4 - color6.b) * f3, 0.0f);
        }

        public float[] getFrames() {
            return this.c;
        }

        @Override // com.esotericsoftware.spine.Animation.Timeline
        public int getPropertyId() {
            return (com.esotericsoftware.spine.Animation.TimelineType.twoColor.ordinal() << 24) + this.b;
        }

        public int getSlotIndex() {
            return this.b;
        }

        public void setFrame(int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            int i2 = i * 8;
            float[] fArr = this.c;
            fArr[i2] = f;
            fArr[i2 + 1] = f2;
            fArr[i2 + 2] = f3;
            fArr[i2 + 3] = f4;
            fArr[i2 + 4] = f5;
            fArr[i2 + 5] = f6;
            fArr[i2 + 6] = f7;
            fArr[i2 + 7] = f8;
        }

        public void setSlotIndex(int i) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("index must be >= 0.");
            }
            this.b = i;
        }
    }

    public Animation(java.lang.String str, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array, float f) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        if (array == null) {
            throw new java.lang.IllegalArgumentException("timelines cannot be null.");
        }
        this.a = str;
        this.b = array;
        this.c = f;
    }

    public static int a(float[] fArr, float f) {
        int length = fArr.length - 2;
        if (length <= 0) {
            return 1;
        }
        int i = length >>> 1;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (fArr[i3] <= f) {
                i2 = i3;
            } else {
                length = i;
            }
            if (i2 == length) {
                return i2 + 1;
            }
            i = (i2 + length) >>> 1;
        }
    }

    public static int b(float[] fArr, float f, int i) {
        int length = (fArr.length / i) - 2;
        if (length == 0) {
            return i;
        }
        int i2 = length >>> 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (fArr[i4 * i] <= f) {
                i3 = i4;
            } else {
                length = i2;
            }
            if (i3 == length) {
                return (i3 + 1) * i;
            }
            i2 = (i3 + length) >>> 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026 A[LOOP:0: B:11:0x0024->B:12:0x0026, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void apply(com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, boolean z, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array, float f3, com.esotericsoftware.spine.Animation.MixPose mixPose, com.esotericsoftware.spine.Animation.MixDirection mixDirection) {
        float f4;
        float f5;
        int i;
        int i2;
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        if (z) {
            float f6 = this.c;
            if (f6 != 0.0f) {
                float f7 = f2 % f6;
                f4 = f > 0.0f ? f % f6 : f;
                f5 = f7;
                com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array2 = this.b;
                i = array2.size;
                for (i2 = 0; i2 < i; i2++) {
                    array2.get(i2).apply(skeleton, f4, f5, array, f3, mixPose, mixDirection);
                }
            }
        }
        f4 = f;
        f5 = f2;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array22 = this.b;
        i = array22.size;
        while (i2 < i) {
        }
    }

    public float getDuration() {
        return this.c;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> getTimelines() {
        return this.b;
    }

    public void setDuration(float f) {
        this.c = f;
    }

    public java.lang.String toString() {
        return this.a;
    }
}
