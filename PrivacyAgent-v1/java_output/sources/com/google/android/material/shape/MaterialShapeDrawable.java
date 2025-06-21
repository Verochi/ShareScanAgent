package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class MaterialShapeDrawable extends android.graphics.drawable.Drawable implements androidx.core.graphics.drawable.TintAwareDrawable, com.google.android.material.shape.Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final java.lang.String TAG = "MaterialShapeDrawable";
    private static final android.graphics.Paint clearPaint = new android.graphics.Paint(1);
    private final java.util.BitSet containsIncompatibleShadowOp;
    private final com.google.android.material.shape.ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    private com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState drawableState;
    private final com.google.android.material.shape.ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final android.graphics.Paint fillPaint;
    private final android.graphics.RectF insetRectF;
    private final android.graphics.Matrix matrix;
    private final android.graphics.Path path;

    @androidx.annotation.NonNull
    private final android.graphics.RectF pathBounds;
    private boolean pathDirty;
    private final android.graphics.Path pathInsetByStroke;
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider;

    @androidx.annotation.NonNull
    private final com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final android.graphics.RectF rectF;
    private final android.graphics.Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final com.google.android.material.shadow.ShadowRenderer shadowRenderer;
    private final android.graphics.Paint strokePaint;
    private com.google.android.material.shape.ShapeAppearanceModel strokeShapeAppearance;

    @androidx.annotation.Nullable
    private android.graphics.PorterDuffColorFilter strokeTintFilter;

    @androidx.annotation.Nullable
    private android.graphics.PorterDuffColorFilter tintFilter;
    private final android.graphics.Region transparentRegion;

    /* renamed from: com.google.android.material.shape.MaterialShapeDrawable$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.material.shape.ShapeAppearancePathProvider.PathListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onCornerPathCreated(@androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i) {
            com.google.android.material.shape.MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i, shapePath.containsIncompatibleShadowOp());
            com.google.android.material.shape.MaterialShapeDrawable.this.cornerShadowOperation[i] = shapePath.createShadowCompatOperation(matrix);
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onEdgePathCreated(@androidx.annotation.NonNull com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i) {
            com.google.android.material.shape.MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i + 4, shapePath.containsIncompatibleShadowOp());
            com.google.android.material.shape.MaterialShapeDrawable.this.edgeShadowOperation[i] = shapePath.createShadowCompatOperation(matrix);
        }
    }

    /* renamed from: com.google.android.material.shape.MaterialShapeDrawable$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator {
        final /* synthetic */ float val$strokeInsetLength;

        public AnonymousClass2(float f) {
            this.val$strokeInsetLength = f;
        }

        @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
        @androidx.annotation.NonNull
        public com.google.android.material.shape.CornerSize apply(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            return cornerSize instanceof com.google.android.material.shape.RelativeCornerSize ? cornerSize : new com.google.android.material.shape.AdjustedCornerSize(this.val$strokeInsetLength, cornerSize);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    public static final class MaterialShapeDrawableState extends android.graphics.drawable.Drawable.ConstantState {
        public int alpha;

        @androidx.annotation.Nullable
        public android.graphics.ColorFilter colorFilter;
        public float elevation;

        @androidx.annotation.Nullable
        public com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider;

        @androidx.annotation.Nullable
        public android.content.res.ColorStateList fillColor;
        public float interpolation;

        @androidx.annotation.Nullable
        public android.graphics.Rect padding;
        public android.graphics.Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public int shadowCompatRotation;

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;

        @androidx.annotation.Nullable
        public android.content.res.ColorStateList strokeColor;

        @androidx.annotation.Nullable
        public android.content.res.ColorStateList strokeTintList;
        public float strokeWidth;

        @androidx.annotation.Nullable
        public android.content.res.ColorStateList tintList;

        @androidx.annotation.Nullable
        public android.graphics.PorterDuff.Mode tintMode;
        public float translationZ;
        public boolean useTintColorForShadow;

        public MaterialShapeDrawableState(@androidx.annotation.NonNull com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = android.graphics.PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = android.graphics.Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.colorFilter = materialShapeDrawableState.colorFilter;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.useTintColorForShadow = materialShapeDrawableState.useTintColorForShadow;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.translationZ = materialShapeDrawableState.translationZ;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.strokeTintList = materialShapeDrawableState.strokeTintList;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new android.graphics.Rect(materialShapeDrawableState.padding);
            }
        }

        public MaterialShapeDrawableState(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = android.graphics.PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = android.graphics.Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.elevationOverlayProvider = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable() {
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(this, null);
            materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }
    }

    public MaterialShapeDrawable() {
        this(new com.google.android.material.shape.ShapeAppearanceModel());
    }

    public MaterialShapeDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        this(com.google.android.material.shape.ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    private MaterialShapeDrawable(@androidx.annotation.NonNull com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState) {
        this.cornerShadowOperation = new com.google.android.material.shape.ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new com.google.android.material.shape.ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new java.util.BitSet(8);
        this.matrix = new android.graphics.Matrix();
        this.path = new android.graphics.Path();
        this.pathInsetByStroke = new android.graphics.Path();
        this.rectF = new android.graphics.RectF();
        this.insetRectF = new android.graphics.RectF();
        this.transparentRegion = new android.graphics.Region();
        this.scratchRegion = new android.graphics.Region();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.fillPaint = paint;
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new com.google.android.material.shadow.ShadowRenderer();
        this.pathProvider = android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread() ? com.google.android.material.shape.ShapeAppearancePathProvider.getInstance() : new com.google.android.material.shape.ShapeAppearancePathProvider();
        this.pathBounds = new android.graphics.RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = materialShapeDrawableState;
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint3 = clearPaint;
        paint3.setColor(-1);
        paint3.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new com.google.android.material.shape.MaterialShapeDrawable.AnonymousClass1();
    }

    public /* synthetic */ MaterialShapeDrawable(com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState, com.google.android.material.shape.MaterialShapeDrawable.AnonymousClass1 anonymousClass1) {
        this(materialShapeDrawableState);
    }

    public MaterialShapeDrawable(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this(new com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    @java.lang.Deprecated
    public MaterialShapeDrawable(@androidx.annotation.NonNull com.google.android.material.shape.ShapePathModel shapePathModel) {
        this((com.google.android.material.shape.ShapeAppearanceModel) shapePathModel);
    }

    @androidx.annotation.Nullable
    private android.graphics.PorterDuffColorFilter calculatePaintColorTintFilter(@androidx.annotation.NonNull android.graphics.Paint paint, boolean z) {
        int color;
        int compositeElevationOverlayIfNeeded;
        if (!z || (compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded((color = paint.getColor()))) == color) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(compositeElevationOverlayIfNeeded, android.graphics.PorterDuff.Mode.SRC_IN);
    }

    private void calculatePath(@androidx.annotation.NonNull android.graphics.RectF rectF, @androidx.annotation.NonNull android.graphics.Path path) {
        calculatePathForSize(rectF, path);
        if (this.drawableState.scale != 1.0f) {
            this.matrix.reset();
            android.graphics.Matrix matrix = this.matrix;
            float f = this.drawableState.scale;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        com.google.android.material.shape.ShapeAppearanceModel withTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new com.google.android.material.shape.MaterialShapeDrawable.AnonymousClass2(-getStrokeInsetLength()));
        this.strokeShapeAppearance = withTransformedCornerSizes;
        this.pathProvider.calculatePath(withTransformedCornerSizes, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @androidx.annotation.NonNull
    private android.graphics.PorterDuffColorFilter calculateTintColorTintFilter(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        return new android.graphics.PorterDuffColorFilter(colorForState, mode);
    }

    @androidx.annotation.NonNull
    private android.graphics.PorterDuffColorFilter calculateTintFilter(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList, @androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode, @androidx.annotation.NonNull android.graphics.Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? calculatePaintColorTintFilter(paint, z) : calculateTintColorTintFilter(colorStateList, mode, z);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.MaterialShapeDrawable createWithElevationOverlay(android.content.Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.MaterialShapeDrawable createWithElevationOverlay(android.content.Context context, float f) {
        int color = com.google.android.material.color.MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurface, com.google.android.material.shape.MaterialShapeDrawable.class.getSimpleName());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f);
        return materialShapeDrawable;
    }

    private void drawCompatShadow(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        this.containsIncompatibleShadowOp.cardinality();
        if (this.drawableState.shadowCompatOffset != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i = 0; i < 4; i++) {
            this.cornerShadowOperation[i].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
            this.edgeShadowOperation[i].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.path, clearPaint);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    private void drawFillShape(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
    }

    private void drawShape(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, @androidx.annotation.NonNull android.graphics.Path path, @androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        if (!shapeAppearanceModel.isRoundRect(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        }
    }

    private void drawStrokeShape(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @androidx.annotation.NonNull
    private android.graphics.RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        int i = materialShapeDrawableState.shadowCompatMode;
        return i != 1 && materialShapeDrawableState.shadowCompatRadius > 0 && (i == 2 || requiresCompatShadow());
    }

    private boolean hasFill() {
        android.graphics.Paint.Style style = this.drawableState.paintStyle;
        return style == android.graphics.Paint.Style.FILL_AND_STROKE || style == android.graphics.Paint.Style.FILL;
    }

    private boolean hasStroke() {
        android.graphics.Paint.Style style = this.drawableState.paintStyle;
        return (style == android.graphics.Paint.Style.FILL_AND_STROKE || style == android.graphics.Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.pathBounds.width() - getBounds().width());
            int height = (int) (this.pathBounds.height() - getBounds().height());
            if (width < 0 || height < 0) {
                throw new java.lang.IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2) + width, ((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2) + height, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas2 = new android.graphics.Canvas(createBitmap);
            float f = (getBounds().left - this.drawableState.shadowCompatRadius) - width;
            float f2 = (getBounds().top - this.drawableState.shadowCompatRadius) - height;
            canvas2.translate(-f, -f2);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(createBitmap, f, f2, (android.graphics.Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int modulateAlpha(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        canvas.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor == null || color2 == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
            z = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z = true;
        }
        if (this.drawableState.strokeColor == null || color == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
            return z;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private boolean updateTintFilter() {
        android.graphics.PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        android.graphics.PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        this.tintFilter = calculateTintFilter(materialShapeDrawableState.tintList, materialShapeDrawableState.tintMode, this.fillPaint, true);
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(materialShapeDrawableState2.strokeTintList, materialShapeDrawableState2.tintMode, this.strokePaint, false);
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState3 = this.drawableState;
        if (materialShapeDrawableState3.useTintColorForShadow) {
            this.shadowRenderer.setShadowColor(materialShapeDrawableState3.tintList.getColorForState(getState(), 0));
        }
        return (androidx.core.util.ObjectsCompat.equals(porterDuffColorFilter, this.tintFilter) && androidx.core.util.ObjectsCompat.equals(porterDuffColorFilter2, this.strokeTintFilter)) ? false : true;
    }

    private void updateZ() {
        float z = getZ();
        this.drawableState.shadowCompatRadius = (int) java.lang.Math.ceil(0.75f * z);
        this.drawableState.shadowCompatOffset = (int) java.lang.Math.ceil(z * 0.25f);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@androidx.annotation.NonNull android.graphics.RectF rectF, @androidx.annotation.NonNull android.graphics.Path path) {
        com.google.android.material.shape.ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        shapeAppearancePathProvider.calculatePath(materialShapeDrawableState.shapeAppearanceModel, materialShapeDrawableState.interpolation, rectF, this.pathShadowListener, path);
    }

    @androidx.annotation.ColorInt
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@androidx.annotation.ColorInt int i) {
        float z = getZ() + getParentAbsoluteElevation();
        com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i, z) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.alpha));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath(getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }
        maybeDrawCompatShadow(canvas);
        if (hasFill()) {
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, @androidx.annotation.NonNull android.graphics.Path path, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        drawShape(canvas, paint, path, this.drawableState.shapeAppearanceModel, rectF);
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    @androidx.annotation.NonNull
    public android.graphics.RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @android.annotation.TargetApi(21)
    public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) {
        if (this.drawableState.shadowCompatMode == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.interpolation);
            return;
        }
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() || android.os.Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.path);
            } catch (java.lang.IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@androidx.annotation.NonNull android.graphics.Rect rect) {
        android.graphics.Rect rect2 = this.drawableState.padding;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public android.graphics.Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    @java.lang.Deprecated
    public void getPathForSize(int i, int i2, @androidx.annotation.NonNull android.graphics.Path path) {
        calculatePathForSize(new android.graphics.RectF(0.0f, 0.0f, i, i2), path);
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @java.lang.Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (materialShapeDrawableState.shadowCompatOffset * java.lang.Math.sin(java.lang.Math.toRadians(materialShapeDrawableState.shadowCompatRotation)));
    }

    public int getShadowOffsetY() {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (materialShapeDrawableState.shadowCompatOffset * java.lang.Math.cos(java.lang.Math.toRadians(materialShapeDrawableState.shadowCompatRotation)));
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    @Override // com.google.android.material.shape.Shapeable
    @androidx.annotation.NonNull
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public com.google.android.material.shape.ShapePathModel getShapedViewModel() {
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof com.google.android.material.shape.ShapePathModel) {
            return (com.google.android.material.shape.ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, android.graphics.Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(android.content.Context context) {
        this.drawableState.elevationOverlayProvider = new com.google.android.material.elevation.ElevationOverlayProvider(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
        return elevationOverlayProvider != null && elevationOverlayProvider.isThemeElevationOverlayEnabled();
    }

    public boolean isElevationOverlayInitialized() {
        return this.drawableState.elevationOverlayProvider != null;
    }

    public boolean isPointInTransparentRegion(int i, int i2) {
        return getTransparentRegion().contains(i, i2);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF());
    }

    @java.lang.Deprecated
    public boolean isShadowEnabled() {
        int i = this.drawableState.shadowCompatMode;
        return i == 0 || i == 2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2;
        android.content.res.ColorStateList colorStateList3;
        android.content.res.ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.drawableState.tintList) != null && colorStateList.isStateful()) || (((colorStateList2 = this.drawableState.strokeTintList) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.drawableState.strokeColor) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.drawableState.fillColor) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable mutate() {
        this.drawableState = new com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z = updateColorsForState(iArr) || updateTintFilter();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public boolean requiresCompatShadow() {
        return (isRoundRect() || this.path.isConvex() || android.os.Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@androidx.annotation.IntRange(from = 0, to = 255) int i) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.alpha != i) {
            materialShapeDrawableState.alpha = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        this.drawableState.colorFilter = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(f));
    }

    public void setCornerSize(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(cornerSize));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z);
    }

    public void setElevation(float f) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.elevation != f) {
            materialShapeDrawableState.elevation = f;
            updateZ();
        }
    }

    public void setFillColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.fillColor != colorStateList) {
            materialShapeDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.interpolation != f) {
            materialShapeDrawableState.interpolation = f;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new android.graphics.Rect();
        }
        this.drawableState.padding.set(i, i2, i3, i4);
        invalidateSelf();
    }

    public void setPaintStyle(android.graphics.Paint.Style style) {
        this.drawableState.paintStyle = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.parentAbsoluteElevation != f) {
            materialShapeDrawableState.parentAbsoluteElevation = f;
            updateZ();
        }
    }

    public void setScale(float f) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.scale != f) {
            materialShapeDrawableState.scale = f;
            invalidateSelf();
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z) {
        this.shadowBitmapDrawingEnable = z;
    }

    public void setShadowColor(int i) {
        this.shadowRenderer.setShadowColor(i);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatRotation != i) {
            materialShapeDrawableState.shadowCompatRotation = i;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatMode != i) {
            materialShapeDrawableState.shadowCompatMode = i;
            invalidateSelfIgnoreShape();
        }
    }

    @java.lang.Deprecated
    public void setShadowElevation(int i) {
        setElevation(i);
    }

    @java.lang.Deprecated
    public void setShadowEnabled(boolean z) {
        setShadowCompatibilityMode(!z ? 1 : 0);
    }

    @java.lang.Deprecated
    public void setShadowRadius(int i) {
        this.drawableState.shadowCompatRadius = i;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatOffset != i) {
            materialShapeDrawableState.shadowCompatOffset = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        invalidateSelf();
    }

    @java.lang.Deprecated
    public void setShapedViewModel(@androidx.annotation.NonNull com.google.android.material.shape.ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f, @androidx.annotation.ColorInt int i) {
        setStrokeWidth(f);
        setStrokeColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setStroke(float f, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        setStrokeWidth(f);
        setStrokeColor(colorStateList);
    }

    public void setStrokeColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.strokeColor != colorStateList) {
            materialShapeDrawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(@androidx.annotation.ColorInt int i) {
        setStrokeTint(android.content.res.ColorStateList.valueOf(i));
    }

    public void setStrokeTint(android.content.res.ColorStateList colorStateList) {
        this.drawableState.strokeTintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f) {
        this.drawableState.strokeWidth = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@androidx.annotation.ColorInt int i) {
        setTintList(android.content.res.ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.tintMode != mode) {
            materialShapeDrawableState.tintMode = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.translationZ != f) {
            materialShapeDrawableState.translationZ = f;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z) {
        com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.useTintColorForShadow != z) {
            materialShapeDrawableState.useTintColorForShadow = z;
            invalidateSelf();
        }
    }

    public void setZ(float f) {
        setTranslationZ(f - getElevation());
    }
}
