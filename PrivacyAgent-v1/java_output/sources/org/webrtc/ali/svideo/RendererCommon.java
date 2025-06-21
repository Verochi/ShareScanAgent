package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* renamed from: org.webrtc.ali.svideo.RendererCommon$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$webrtc$ali$svideo$RendererCommon$ScalingType;

        static {
            int[] iArr = new int[org.webrtc.ali.svideo.RendererCommon.ScalingType.values().length];
            $SwitchMap$org$webrtc$ali$svideo$RendererCommon$ScalingType = iArr;
            try {
                iArr[org.webrtc.ali.svideo.RendererCommon.ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$ali$svideo$RendererCommon$ScalingType[org.webrtc.ali.svideo.RendererCommon.ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$ali$svideo$RendererCommon$ScalingType[org.webrtc.ali.svideo.RendererCommon.ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public interface GlDrawer {
        void drawOes(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7);

        void drawRgb(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7);

        void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6);

        void release();
    }

    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i, int i2, int i3);
    }

    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    public static class VideoLayoutMeasure {
        private org.webrtc.ali.svideo.RendererCommon.ScalingType scalingTypeMatchOrientation;
        private org.webrtc.ali.svideo.RendererCommon.ScalingType scalingTypeMismatchOrientation;

        public VideoLayoutMeasure() {
            org.webrtc.ali.svideo.RendererCommon.ScalingType scalingType = org.webrtc.ali.svideo.RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public android.graphics.Point measure(int i, int i2, int i3, int i4) {
            int defaultSize = android.view.View.getDefaultSize(Integer.MAX_VALUE, i);
            int defaultSize2 = android.view.View.getDefaultSize(Integer.MAX_VALUE, i2);
            if (i3 == 0 || i4 == 0 || defaultSize == 0 || defaultSize2 == 0) {
                return new android.graphics.Point(defaultSize, defaultSize2);
            }
            float f = i3 / i4;
            android.graphics.Point displaySize = org.webrtc.ali.svideo.RendererCommon.getDisplaySize(((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) > 0) == (((float) defaultSize) / ((float) defaultSize2) > 1.0f) ? this.scalingTypeMatchOrientation : this.scalingTypeMismatchOrientation, f, defaultSize, defaultSize2);
            if (android.view.View.MeasureSpec.getMode(i) == 1073741824) {
                displaySize.x = defaultSize;
            }
            if (android.view.View.MeasureSpec.getMode(i2) == 1073741824) {
                displaySize.y = defaultSize2;
            }
            return displaySize;
        }

        public void setScalingType(org.webrtc.ali.svideo.RendererCommon.ScalingType scalingType) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public void setScalingType(org.webrtc.ali.svideo.RendererCommon.ScalingType scalingType, org.webrtc.ali.svideo.RendererCommon.ScalingType scalingType2) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType2;
        }
    }

    public static class YuvUploader {
        private java.nio.ByteBuffer copyBuffer;
        private int[] yuvTextures;

        public void release() {
            this.copyBuffer = null;
            int[] iArr = this.yuvTextures;
            if (iArr != null) {
                android.opengl.GLES20.glDeleteTextures(3, iArr, 0);
                this.yuvTextures = null;
            }
        }

        public int[] uploadYuvData(int i, int i2, int[] iArr, java.nio.ByteBuffer[] byteBufferArr) {
            java.nio.ByteBuffer byteBuffer;
            java.nio.ByteBuffer byteBuffer2;
            int i3 = i / 2;
            int[] iArr2 = {i, i3, i3};
            int i4 = i2 / 2;
            int[] iArr3 = {i2, i4, i4};
            int i5 = 0;
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr[i6];
                int i8 = iArr2[i6];
                if (i7 > i8) {
                    i5 = java.lang.Math.max(i5, i8 * iArr3[i6]);
                }
            }
            if (i5 > 0 && ((byteBuffer2 = this.copyBuffer) == null || byteBuffer2.capacity() < i5)) {
                this.copyBuffer = java.nio.ByteBuffer.allocateDirect(i5);
            }
            if (this.yuvTextures == null) {
                this.yuvTextures = new int[3];
                for (int i9 = 0; i9 < 3; i9++) {
                    this.yuvTextures[i9] = org.webrtc.ali.svideo.GlUtil.generateTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D);
                }
            }
            for (int i10 = 0; i10 < 3; i10++) {
                android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0 + i10);
                android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.yuvTextures[i10]);
                int i11 = iArr[i10];
                int i12 = iArr2[i10];
                if (i11 == i12) {
                    byteBuffer = byteBufferArr[i10];
                } else {
                    org.webrtc.ali.svideo.VideoRenderer.nativeCopyPlane(byteBufferArr[i10], i12, iArr3[i10], i11, this.copyBuffer, i12);
                    byteBuffer = this.copyBuffer;
                }
                android.opengl.GLES20.glTexImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, com.badlogic.gdx.graphics.GL20.GL_LUMINANCE, iArr2[i10], iArr3[i10], 0, com.badlogic.gdx.graphics.GL20.GL_LUMINANCE, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, byteBuffer);
            }
            return this.yuvTextures;
        }
    }

    private static void adjustOrigin(float[] fArr) {
        float f = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[12] = f;
        float f2 = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[13] = f2;
        fArr[12] = f + 0.5f;
        fArr[13] = f2 + 0.5f;
    }

    private static float convertScalingTypeToVisibleFraction(org.webrtc.ali.svideo.RendererCommon.ScalingType scalingType) {
        int i = org.webrtc.ali.svideo.RendererCommon.AnonymousClass1.$SwitchMap$org$webrtc$ali$svideo$RendererCommon$ScalingType[scalingType.ordinal()];
        if (i == 1) {
            return 1.0f;
        }
        if (i == 2) {
            return 0.0f;
        }
        if (i == 3) {
            return BALANCED_VISIBLE_FRACTION;
        }
        throw new java.lang.IllegalArgumentException();
    }

    private static android.graphics.Point getDisplaySize(float f, float f2, int i, int i2) {
        return (f == 0.0f || f2 == 0.0f) ? new android.graphics.Point(i, i2) : new android.graphics.Point(java.lang.Math.min(i, java.lang.Math.round((i2 / f) * f2)), java.lang.Math.min(i2, java.lang.Math.round((i / f) / f2)));
    }

    public static android.graphics.Point getDisplaySize(org.webrtc.ali.svideo.RendererCommon.ScalingType scalingType, float f, int i, int i2) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f, i, i2);
    }

    public static float[] getLayoutMatrix(boolean z, float f, float f2) {
        float f3;
        float f4;
        if (f2 > f) {
            f4 = f / f2;
            f3 = 1.0f;
        } else {
            f3 = f2 / f;
            f4 = 1.0f;
        }
        if (z) {
            f3 *= -1.0f;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, f3, f4, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }

    public static final float[] horizontalFlipMatrix() {
        return new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    }

    public static final float[] identityMatrix() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static float[] multiplyMatrices(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        android.opengl.Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
        return fArr3;
    }

    public static float[] rotateTextureMatrix(float[] fArr, float f) {
        float[] fArr2 = new float[16];
        android.opengl.Matrix.setRotateM(fArr2, 0, f, 0.0f, 0.0f, 1.0f);
        adjustOrigin(fArr2);
        return multiplyMatrices(fArr, fArr2);
    }

    public static final float[] verticalFlipMatrix() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    }
}
