package com.alimm.tanx.ui.image.util;

/* loaded from: classes.dex */
public class RoundedCorners implements com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool mBitmapPool;
    private final com.alimm.tanx.ui.image.util.RoundedCorners.CornerType mCornerType;
    private final int mDiameter;
    private final int mMargin;
    private final int mRadius;

    /* renamed from: com.alimm.tanx.ui.image.util.RoundedCorners$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType;

        static {
            int[] iArr = new int[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.values().length];
            $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType = iArr;
            try {
                iArr[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.ALL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.TOP.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.BOTTOM.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.LEFT.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.RIGHT.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$alimm$tanx$ui$image$util$RoundedCorners$CornerType[com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
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
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCorners(android.content.Context context, int i, int i2) {
        this(context, i, i2, com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.ALL);
    }

    public RoundedCorners(android.content.Context context, int i, int i2, com.alimm.tanx.ui.image.util.RoundedCorners.CornerType cornerType) {
        this(com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool(), i, i2, cornerType);
    }

    public RoundedCorners(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2) {
        this(bitmapPool, i, i2, com.alimm.tanx.ui.image.util.RoundedCorners.CornerType.ALL);
    }

    public RoundedCorners(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2, com.alimm.tanx.ui.image.util.RoundedCorners.CornerType cornerType) {
        this.mBitmapPool = bitmapPool;
        this.mRadius = i;
        this.mDiameter = i * 2;
        this.mMargin = i2;
        this.mCornerType = cornerType;
    }

    private void drawBottomLeftRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        android.graphics.RectF rectF = new android.graphics.RectF(this.mMargin, f2 - this.mDiameter, r1 + r3, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new android.graphics.RectF(f4, f4, r1 + this.mDiameter, f2 - this.mRadius), paint);
        canvas.drawRect(new android.graphics.RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawBottomRightRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        float f3 = this.mDiameter;
        android.graphics.RectF rectF = new android.graphics.RectF(f - f3, f2 - f3, f, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        float f5 = this.mMargin;
        canvas.drawRect(new android.graphics.RectF(f5, f5, f - this.mRadius, f2), paint);
        float f6 = this.mRadius;
        canvas.drawRect(new android.graphics.RectF(f - f6, this.mMargin, f, f2 - f6), paint);
    }

    private void drawBottomRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        android.graphics.RectF rectF = new android.graphics.RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new android.graphics.RectF(f4, f4, f, f2 - this.mRadius), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        int i = this.mMargin;
        float f3 = i;
        float f4 = i + this.mDiameter;
        android.graphics.RectF rectF = new android.graphics.RectF(f3, f3, f4, f4);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        float f6 = this.mDiameter;
        android.graphics.RectF rectF2 = new android.graphics.RectF(f - f6, f2 - f6, f, f2);
        float f7 = this.mRadius;
        canvas.drawRoundRect(rectF2, f7, f7, paint);
        canvas.drawRect(new android.graphics.RectF(this.mMargin, r1 + this.mRadius, f - this.mDiameter, f2), paint);
        canvas.drawRect(new android.graphics.RectF(this.mDiameter + r1, this.mMargin, f, f2 - this.mRadius), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        int i = this.mDiameter;
        android.graphics.RectF rectF = new android.graphics.RectF(f - i, this.mMargin, f, r3 + i);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        android.graphics.RectF rectF2 = new android.graphics.RectF(this.mMargin, f2 - this.mDiameter, r1 + r3, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF2, f4, f4, paint);
        float f5 = this.mMargin;
        float f6 = this.mRadius;
        canvas.drawRect(new android.graphics.RectF(f5, f5, f - f6, f2 - f6), paint);
        float f7 = this.mMargin + this.mRadius;
        canvas.drawRect(new android.graphics.RectF(f7, f7, f, f2), paint);
    }

    private void drawLeftRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        android.graphics.RectF rectF = new android.graphics.RectF(f3, f3, r1 + this.mDiameter, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        canvas.drawRect(new android.graphics.RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawOtherBottomLeftRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        android.graphics.RectF rectF = new android.graphics.RectF(f3, f3, f, r1 + this.mDiameter);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        android.graphics.RectF rectF2 = new android.graphics.RectF(f - this.mDiameter, this.mMargin, f, f2);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF2, f5, f5, paint);
        canvas.drawRect(new android.graphics.RectF(this.mMargin, r1 + r3, f - this.mRadius, f2), paint);
    }

    private void drawOtherBottomRightRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        android.graphics.RectF rectF = new android.graphics.RectF(f3, f3, f, r1 + this.mDiameter);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        float f5 = this.mMargin;
        android.graphics.RectF rectF2 = new android.graphics.RectF(f5, f5, r1 + this.mDiameter, f2);
        float f6 = this.mRadius;
        canvas.drawRoundRect(rectF2, f6, f6, paint);
        float f7 = this.mMargin + this.mRadius;
        canvas.drawRect(new android.graphics.RectF(f7, f7, f, f2), paint);
    }

    private void drawOtherTopLeftRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        android.graphics.RectF rectF = new android.graphics.RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        android.graphics.RectF rectF2 = new android.graphics.RectF(f - this.mDiameter, this.mMargin, f, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF2, f4, f4, paint);
        float f5 = this.mMargin;
        float f6 = this.mRadius;
        canvas.drawRect(new android.graphics.RectF(f5, f5, f - f6, f2 - f6), paint);
    }

    private void drawOtherTopRightRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        android.graphics.RectF rectF = new android.graphics.RectF(f3, f3, r1 + this.mDiameter, f2);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        android.graphics.RectF rectF2 = new android.graphics.RectF(this.mMargin, f2 - this.mDiameter, f, f2);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF2, f5, f5, paint);
        canvas.drawRect(new android.graphics.RectF(r1 + r2, this.mMargin, f, f2 - this.mRadius), paint);
    }

    private void drawRightRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        android.graphics.RectF rectF = new android.graphics.RectF(f - this.mDiameter, this.mMargin, f, f2);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new android.graphics.RectF(f4, f4, f - this.mRadius, f2), paint);
    }

    private void drawRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        float f4 = f - f3;
        float f5 = f2 - f3;
        switch (this.mCornerType) {
            case ALL:
                float f6 = this.mMargin;
                android.graphics.RectF rectF = new android.graphics.RectF(f6, f6, f4, f5);
                float f7 = this.mRadius;
                canvas.drawRoundRect(rectF, f7, f7, paint);
                break;
            case TOP_LEFT:
                drawTopLeftRoundRect(canvas, paint, f4, f5);
                break;
            case TOP_RIGHT:
                drawTopRightRoundRect(canvas, paint, f4, f5);
                break;
            case BOTTOM_LEFT:
                drawBottomLeftRoundRect(canvas, paint, f4, f5);
                break;
            case BOTTOM_RIGHT:
                drawBottomRightRoundRect(canvas, paint, f4, f5);
                break;
            case TOP:
                drawTopRoundRect(canvas, paint, f4, f5);
                break;
            case BOTTOM:
                drawBottomRoundRect(canvas, paint, f4, f5);
                break;
            case LEFT:
                drawLeftRoundRect(canvas, paint, f4, f5);
                break;
            case RIGHT:
                drawRightRoundRect(canvas, paint, f4, f5);
                break;
            case OTHER_TOP_LEFT:
                drawOtherTopLeftRoundRect(canvas, paint, f4, f5);
                break;
            case OTHER_TOP_RIGHT:
                drawOtherTopRightRoundRect(canvas, paint, f4, f5);
                break;
            case OTHER_BOTTOM_LEFT:
                drawOtherBottomLeftRoundRect(canvas, paint, f4, f5);
                break;
            case OTHER_BOTTOM_RIGHT:
                drawOtherBottomRightRoundRect(canvas, paint, f4, f5);
                break;
            case DIAGONAL_FROM_TOP_LEFT:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f4, f5);
                break;
            case DIAGONAL_FROM_TOP_RIGHT:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f4, f5);
                break;
            default:
                float f8 = this.mMargin;
                android.graphics.RectF rectF2 = new android.graphics.RectF(f8, f8, f4, f5);
                float f9 = this.mRadius;
                canvas.drawRoundRect(rectF2, f9, f9, paint);
                break;
        }
    }

    private void drawTopLeftRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        int i = this.mMargin;
        float f3 = i;
        float f4 = i + this.mDiameter;
        android.graphics.RectF rectF = new android.graphics.RectF(f3, f3, f4, f4);
        float f5 = this.mRadius;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        int i2 = this.mMargin;
        float f6 = i2;
        float f7 = i2 + this.mRadius;
        canvas.drawRect(new android.graphics.RectF(f6, f7, f7, f2), paint);
        canvas.drawRect(new android.graphics.RectF(this.mRadius + r1, this.mMargin, f, f2), paint);
    }

    private void drawTopRightRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        int i = this.mDiameter;
        android.graphics.RectF rectF = new android.graphics.RectF(f - i, this.mMargin, f, r3 + i);
        float f3 = this.mRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        float f4 = this.mMargin;
        canvas.drawRect(new android.graphics.RectF(f4, f4, f - this.mRadius, f2), paint);
        canvas.drawRect(new android.graphics.RectF(f - this.mRadius, this.mMargin + r1, f, f2), paint);
    }

    private void drawTopRoundRect(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2) {
        float f3 = this.mMargin;
        android.graphics.RectF rectF = new android.graphics.RectF(f3, f3, f, r1 + this.mDiameter);
        float f4 = this.mRadius;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        canvas.drawRect(new android.graphics.RectF(this.mMargin, r1 + this.mRadius, f, f2), paint);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("RoundedTransformation(radius=");
        tanxu_do2.append(this.mRadius);
        tanxu_do2.append(", margin=");
        tanxu_do2.append(this.mMargin);
        tanxu_do2.append(", diameter=");
        tanxu_do2.append(this.mDiameter);
        tanxu_do2.append(", cornerType=");
        tanxu_do2.append(this.mCornerType.name());
        tanxu_do2.append(")");
        return tanxu_do2.toString();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource, int i, int i2) {
        android.graphics.Bitmap bitmap = resource.get();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Bitmap bitmap2 = this.mBitmapPool.get(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        }
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap2);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setAntiAlias(true);
        android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
        paint.setShader(new android.graphics.BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, width, height);
        return com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }
}
