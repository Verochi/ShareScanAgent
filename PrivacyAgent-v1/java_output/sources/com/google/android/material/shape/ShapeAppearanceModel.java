package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class ShapeAppearanceModel {
    public static final com.google.android.material.shape.CornerSize PILL = new com.google.android.material.shape.RelativeCornerSize(0.5f);
    com.google.android.material.shape.EdgeTreatment bottomEdge;
    com.google.android.material.shape.CornerTreatment bottomLeftCorner;
    com.google.android.material.shape.CornerSize bottomLeftCornerSize;
    com.google.android.material.shape.CornerTreatment bottomRightCorner;
    com.google.android.material.shape.CornerSize bottomRightCornerSize;
    com.google.android.material.shape.EdgeTreatment leftEdge;
    com.google.android.material.shape.EdgeTreatment rightEdge;
    com.google.android.material.shape.EdgeTreatment topEdge;
    com.google.android.material.shape.CornerTreatment topLeftCorner;
    com.google.android.material.shape.CornerSize topLeftCornerSize;
    com.google.android.material.shape.CornerTreatment topRightCorner;
    com.google.android.material.shape.CornerSize topRightCornerSize;

    public static final class Builder {

        @androidx.annotation.NonNull
        private com.google.android.material.shape.EdgeTreatment bottomEdge;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerTreatment bottomLeftCorner;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerSize bottomLeftCornerSize;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerTreatment bottomRightCorner;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerSize bottomRightCornerSize;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.EdgeTreatment leftEdge;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.EdgeTreatment rightEdge;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.EdgeTreatment topEdge;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerTreatment topLeftCorner;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerSize topLeftCornerSize;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerTreatment topRightCorner;

        @androidx.annotation.NonNull
        private com.google.android.material.shape.CornerSize topRightCornerSize;

        public Builder() {
            this.topLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        public Builder(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }

        private static float compatCornerTreatmentSize(com.google.android.material.shape.CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof com.google.android.material.shape.RoundedCornerTreatment) {
                return ((com.google.android.material.shape.RoundedCornerTreatment) cornerTreatment).radius;
            }
            if (cornerTreatment instanceof com.google.android.material.shape.CutCornerTreatment) {
                return ((com.google.android.material.shape.CutCornerTreatment) cornerTreatment).size;
            }
            return -1.0f;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel build() {
            return new com.google.android.material.shape.ShapeAppearanceModel(this, null);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCornerSizes(@androidx.annotation.Dimension float f) {
            return setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomRightCornerSize(f).setBottomLeftCornerSize(f);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCornerSizes(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCorners(int i, @androidx.annotation.Dimension float f) {
            return setAllCorners(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setAllCornerSizes(f);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCorners(@androidx.annotation.NonNull com.google.android.material.shape.CornerTreatment cornerTreatment) {
            return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllEdges(@androidx.annotation.NonNull com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomEdge(@androidx.annotation.NonNull com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.bottomEdge = edgeTreatment;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCorner(int i, @androidx.annotation.Dimension float f) {
            return setBottomLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(f);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCorner(int i, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            return setBottomLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(cornerSize);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCorner(@androidx.annotation.NonNull com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.bottomLeftCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setBottomLeftCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCornerSize(@androidx.annotation.Dimension float f) {
            this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCornerSize(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            this.bottomLeftCornerSize = cornerSize;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCorner(int i, @androidx.annotation.Dimension float f) {
            return setBottomRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(f);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCorner(int i, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            return setBottomRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(cornerSize);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCorner(@androidx.annotation.NonNull com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.bottomRightCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setBottomRightCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCornerSize(@androidx.annotation.Dimension float f) {
            this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCornerSize(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            this.bottomRightCornerSize = cornerSize;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setLeftEdge(@androidx.annotation.NonNull com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.leftEdge = edgeTreatment;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setRightEdge(@androidx.annotation.NonNull com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.rightEdge = edgeTreatment;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopEdge(@androidx.annotation.NonNull com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.topEdge = edgeTreatment;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCorner(int i, @androidx.annotation.Dimension float f) {
            return setTopLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(f);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCorner(int i, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            return setTopLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(cornerSize);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCorner(@androidx.annotation.NonNull com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.topLeftCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setTopLeftCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCornerSize(@androidx.annotation.Dimension float f) {
            this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCornerSize(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            this.topLeftCornerSize = cornerSize;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCorner(int i, @androidx.annotation.Dimension float f) {
            return setTopRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(f);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCorner(int i, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            return setTopRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(cornerSize);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCorner(@androidx.annotation.NonNull com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.topRightCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setTopRightCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCornerSize(@androidx.annotation.Dimension float f) {
            this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCornerSize(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
            this.topRightCornerSize = cornerSize;
            return this;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public interface CornerSizeUnaryOperator {
        @androidx.annotation.NonNull
        com.google.android.material.shape.CornerSize apply(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize);
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.topEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
    }

    private ShapeAppearanceModel(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel.Builder builder) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    public /* synthetic */ ShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.Builder builder, com.google.android.material.shape.ShapeAppearanceModel.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder() {
        return new com.google.android.material.shape.ShapeAppearanceModel.Builder();
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, @androidx.annotation.StyleRes int i, @androidx.annotation.StyleRes int i2) {
        return builder(context, i, i2, 0);
    }

    @androidx.annotation.NonNull
    private static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, @androidx.annotation.StyleRes int i, @androidx.annotation.StyleRes int i2, int i3) {
        return builder(context, i, i2, new com.google.android.material.shape.AbsoluteCornerSize(i3));
    }

    @androidx.annotation.NonNull
    private static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, @androidx.annotation.StyleRes int i, @androidx.annotation.StyleRes int i2, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
        if (i2 != 0) {
            android.view.ContextThemeWrapper contextThemeWrapper = new android.view.ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R.styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            com.google.android.material.shape.CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, com.google.android.material.R.styleable.ShapeAppearance_cornerSize, cornerSize);
            com.google.android.material.shape.CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, com.google.android.material.R.styleable.ShapeAppearance_cornerSizeTopLeft, cornerSize2);
            com.google.android.material.shape.CornerSize cornerSize4 = getCornerSize(obtainStyledAttributes, com.google.android.material.R.styleable.ShapeAppearance_cornerSizeTopRight, cornerSize2);
            com.google.android.material.shape.CornerSize cornerSize5 = getCornerSize(obtainStyledAttributes, com.google.android.material.R.styleable.ShapeAppearance_cornerSizeBottomRight, cornerSize2);
            return new com.google.android.material.shape.ShapeAppearanceModel.Builder().setTopLeftCorner(i4, cornerSize3).setTopRightCorner(i5, cornerSize4).setBottomRightCorner(i6, cornerSize5).setBottomLeftCorner(i7, getCornerSize(obtainStyledAttributes, com.google.android.material.R.styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSize2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        return builder(context, attributeSet, i, i2, 0);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, int i3) {
        return builder(context, attributeSet, i, i2, new com.google.android.material.shape.AbsoluteCornerSize(i3));
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, cornerSize);
    }

    @androidx.annotation.NonNull
    private static com.google.android.material.shape.CornerSize getCornerSize(android.content.res.TypedArray typedArray, int i, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
        android.util.TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cornerSize;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new com.google.android.material.shape.AbsoluteCornerSize(android.util.TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new com.google.android.material.shape.RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f)) : cornerSize;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        boolean z = this.leftEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class) && this.rightEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class) && this.topEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class) && this.bottomEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class);
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        return z && ((this.topRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.topRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomLeftCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.topRightCorner instanceof com.google.android.material.shape.RoundedCornerTreatment) && (this.topLeftCorner instanceof com.google.android.material.shape.RoundedCornerTreatment) && (this.bottomRightCorner instanceof com.google.android.material.shape.RoundedCornerTreatment) && (this.bottomLeftCorner instanceof com.google.android.material.shape.RoundedCornerTreatment));
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.ShapeAppearanceModel.Builder toBuilder() {
        return new com.google.android.material.shape.ShapeAppearanceModel.Builder(this);
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.ShapeAppearanceModel withCornerSize(float f) {
        return toBuilder().setAllCornerSizes(f).build();
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.ShapeAppearanceModel withCornerSize(@androidx.annotation.NonNull com.google.android.material.shape.CornerSize cornerSize) {
        return toBuilder().setAllCornerSizes(cornerSize).build();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public com.google.android.material.shape.ShapeAppearanceModel withTransformedCornerSizes(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
    }
}
