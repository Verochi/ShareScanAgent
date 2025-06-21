package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class Frame<PROPERTY> {
    float time;
    PROPERTY value;

    public static class FramePoint extends android.graphics.PointF {
        public FramePoint(float f, float f2) {
            super(f, f2);
        }

        @Override // android.graphics.PointF
        public java.lang.String toString() {
            return ((android.graphics.PointF) this).x + "," + ((android.graphics.PointF) this).y;
        }
    }

    public Frame(float f, PROPERTY property) {
        this.time = f;
        this.value = property;
    }
}
