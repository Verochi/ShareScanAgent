package com.aliyun.svideo.common.utils.image;

/* loaded from: classes.dex */
public class GlideRoundedCornersTransform extends com.bumptech.glide.load.resource.bitmap.CenterCrop {
    private static final java.lang.String ID = "com.bumptech.glideGlideRoundedCornersTransform.1";
    private static final byte[] ID_BYTES = ID.getBytes(com.bumptech.glide.load.Key.CHARSET);
    private static final int VERSION = 1;
    private com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType mCornerType;
    private float mRadius;

    /* renamed from: com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType;

        static {
            int[] iArr = new int[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.values().length];
            $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType = iArr;
            try {
                iArr[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.ALL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.BOTTOM_LEFT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.TOP.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.BOTTOM.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.LEFT.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.RIGHT.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.TOP_LEFT_BOTTOM_RIGHT.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.TOP_RIGHT_BOTTOM_LEFT.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.TOP_LEFT_TOP_RIGHT_BOTTOM_RIGHT.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.TOP_RIGHT_BOTTOM_RIGHT_BOTTOM_LEFT.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
        }
    }

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        TOP_LEFT_BOTTOM_RIGHT,
        TOP_RIGHT_BOTTOM_LEFT,
        TOP_LEFT_TOP_RIGHT_BOTTOM_RIGHT,
        TOP_RIGHT_BOTTOM_RIGHT_BOTTOM_LEFT
    }

    public GlideRoundedCornersTransform(android.content.Context context, float f, com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType cornerType) {
        this.mRadius = com.aliyun.svideo.common.utils.DensityUtils.dip2px(context, f);
        this.mCornerType = cornerType;
    }

    private void drawPath(float[] fArr, android.graphics.Canvas canvas, android.graphics.Paint paint, android.graphics.Path path, int i, int i2) {
        path.addRoundRect(new android.graphics.RectF(0.0f, 0.0f, i, i2), fArr, android.graphics.Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    private void drawRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, android.graphics.Path path, int i, int i2) {
        switch (com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.AnonymousClass1.$SwitchMap$com$aliyun$svideo$common$utils$image$GlideRoundedCornersTransform$CornerType[this.mCornerType.ordinal()]) {
            case 1:
                float f = this.mRadius;
                drawPath(new float[]{f, f, f, f, f, f, f, f}, canvas, paint, path, i, i2);
                return;
            case 2:
                float f2 = this.mRadius;
                drawPath(new float[]{f2, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 3:
                float f3 = this.mRadius;
                drawPath(new float[]{0.0f, 0.0f, f3, f3, 0.0f, 0.0f, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 4:
                float f4 = this.mRadius;
                drawPath(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f4, f4, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 5:
                float f5 = this.mRadius;
                drawPath(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f5, f5}, canvas, paint, path, i, i2);
                return;
            case 6:
                float f6 = this.mRadius;
                drawPath(new float[]{f6, f6, f6, f6, 0.0f, 0.0f, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 7:
                float f7 = this.mRadius;
                drawPath(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f7, f7, f7, f7}, canvas, paint, path, i, i2);
                return;
            case 8:
                float f8 = this.mRadius;
                drawPath(new float[]{f8, f8, 0.0f, 0.0f, 0.0f, 0.0f, f8, f8}, canvas, paint, path, i, i2);
                return;
            case 9:
                float f9 = this.mRadius;
                drawPath(new float[]{0.0f, 0.0f, f9, f9, f9, f9, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 10:
                float f10 = this.mRadius;
                drawPath(new float[]{f10, f10, 0.0f, 0.0f, f10, f10, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 11:
                float f11 = this.mRadius;
                drawPath(new float[]{0.0f, 0.0f, f11, f11, 0.0f, 0.0f, f11, f11}, canvas, paint, path, i, i2);
                return;
            case 12:
                float f12 = this.mRadius;
                drawPath(new float[]{f12, f12, f12, f12, f12, f12, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 13:
                float f13 = this.mRadius;
                drawPath(new float[]{0.0f, 0.0f, f13, f13, f13, f13, f13, f13}, canvas, paint, path, i, i2);
                return;
            default:
                throw new java.lang.RuntimeException("RoundedCorners type not belong to CornerType");
        }
    }

    private android.graphics.Bitmap roundCrop(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap2);
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
        paint.setShader(new android.graphics.BitmapShader(bitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        drawRoundRect(canvas, paint, new android.graphics.Path(), width, height);
        return bitmap2;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.CenterCrop, com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        return obj instanceof com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.CenterCrop, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1208321065;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.CenterCrop, com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public android.graphics.Bitmap transform(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap, int i, int i2) {
        return roundCrop(bitmapPool, super.transform(bitmapPool, bitmap, i, i2));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.CenterCrop, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
