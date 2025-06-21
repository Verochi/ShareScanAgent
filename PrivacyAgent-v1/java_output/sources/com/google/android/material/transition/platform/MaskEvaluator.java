package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
class MaskEvaluator {
    private com.google.android.material.shape.ShapeAppearanceModel currentShapeAppearanceModel;
    private final android.graphics.Path path = new android.graphics.Path();
    private final android.graphics.Path startPath = new android.graphics.Path();
    private final android.graphics.Path endPath = new android.graphics.Path();
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider = com.google.android.material.shape.ShapeAppearancePathProvider.getInstance();

    public void clip(android.graphics.Canvas canvas) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.path);
        } else {
            canvas.clipPath(this.startPath);
            canvas.clipPath(this.endPath, android.graphics.Region.Op.UNION);
        }
    }

    public void evaluate(float f, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, android.graphics.RectF rectF, android.graphics.RectF rectF2, android.graphics.RectF rectF3, com.google.android.material.transition.platform.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        com.google.android.material.shape.ShapeAppearanceModel lerp = com.google.android.material.transition.platform.TransitionUtils.lerp(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f);
        this.currentShapeAppearanceModel = lerp;
        this.pathProvider.calculatePath(lerp, 1.0f, rectF2, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, rectF3, this.endPath);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.path.op(this.startPath, this.endPath, android.graphics.Path.Op.UNION);
        }
    }

    public com.google.android.material.shape.ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }

    public android.graphics.Path getPath() {
        return this.path;
    }
}
