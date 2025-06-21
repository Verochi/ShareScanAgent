package com.google.android.material.shape;

/* loaded from: classes22.dex */
public class ShapeAppearancePathProvider {
    private final com.google.android.material.shape.ShapePath[] cornerPaths = new com.google.android.material.shape.ShapePath[4];
    private final android.graphics.Matrix[] cornerTransforms = new android.graphics.Matrix[4];
    private final android.graphics.Matrix[] edgeTransforms = new android.graphics.Matrix[4];
    private final android.graphics.PointF pointF = new android.graphics.PointF();
    private final android.graphics.Path overlappedEdgePath = new android.graphics.Path();
    private final android.graphics.Path boundsPath = new android.graphics.Path();
    private final com.google.android.material.shape.ShapePath shapePath = new com.google.android.material.shape.ShapePath();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final android.graphics.Path edgePath = new android.graphics.Path();
    private final android.graphics.Path cornerPath = new android.graphics.Path();
    private boolean edgeIntersectionCheckEnabled = true;

    public static class Lazy {
        static final com.google.android.material.shape.ShapeAppearancePathProvider INSTANCE = new com.google.android.material.shape.ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i);

        void onEdgePathCreated(com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i);
    }

    public static final class ShapeAppearancePathSpec {

        @androidx.annotation.NonNull
        public final android.graphics.RectF bounds;
        public final float interpolation;

        @androidx.annotation.NonNull
        public final android.graphics.Path path;

        @androidx.annotation.Nullable
        public final com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener;

        @androidx.annotation.NonNull
        public final com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f, android.graphics.RectF rectF, @androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener, android.graphics.Path path) {
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f;
            this.bounds = rectF;
            this.path = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new com.google.android.material.shape.ShapePath();
            this.cornerTransforms[i] = new android.graphics.Matrix();
            this.edgeTransforms[i] = new android.graphics.Matrix();
        }
    }

    private float angleOfEdge(int i) {
        return (i + 1) * 90;
    }

    private void appendCornerPath(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        this.scratch[0] = this.cornerPaths[i].getStartX();
        this.scratch[1] = this.cornerPaths[i].getStartY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        if (i == 0) {
            android.graphics.Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            android.graphics.Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], shapeAppearancePathSpec.path);
        com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i], this.cornerTransforms[i], i);
        }
    }

    private void appendEdgePath(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        int i2 = (i + 1) % 4;
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i2].getStartX();
        this.scratch2[1] = this.cornerPaths[i2].getStartY();
        this.cornerTransforms[i2].mapPoints(this.scratch2);
        float f = this.scratch[0];
        float[] fArr = this.scratch2;
        float max = java.lang.Math.max(((float) java.lang.Math.hypot(f - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i);
        this.shapePath.reset(0.0f, 0.0f);
        com.google.android.material.shape.EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[i], this.edgePath);
        if (this.edgeIntersectionCheckEnabled && (edgeTreatmentForIndex.forceIntersection() || pathOverlapsCorner(this.edgePath, i) || pathOverlapsCorner(this.edgePath, i2))) {
            android.graphics.Path path = this.edgePath;
            path.op(path, this.boundsPath, android.graphics.Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i].mapPoints(this.scratch);
            android.graphics.Path path2 = this.overlappedEdgePath;
            float[] fArr2 = this.scratch;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i], this.overlappedEdgePath);
        } else {
            this.shapePath.applyToPath(this.edgeTransforms[i], shapeAppearancePathSpec.path);
        }
        com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i], i);
        }
    }

    private void getCoordinatesOfCorner(int i, @androidx.annotation.NonNull android.graphics.RectF rectF, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        if (i == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private com.google.android.material.shape.CornerSize getCornerSizeForIndex(int i, @androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        return i != 1 ? i != 2 ? i != 3 ? shapeAppearanceModel.getTopRightCornerSize() : shapeAppearanceModel.getTopLeftCornerSize() : shapeAppearanceModel.getBottomLeftCornerSize() : shapeAppearanceModel.getBottomRightCornerSize();
    }

    private com.google.android.material.shape.CornerTreatment getCornerTreatmentForIndex(int i, @androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        return i != 1 ? i != 2 ? i != 3 ? shapeAppearanceModel.getTopRightCorner() : shapeAppearanceModel.getTopLeftCorner() : shapeAppearanceModel.getBottomLeftCorner() : shapeAppearanceModel.getBottomRightCorner();
    }

    private float getEdgeCenterForIndex(@androidx.annotation.NonNull android.graphics.RectF rectF, int i) {
        float[] fArr = this.scratch;
        com.google.android.material.shape.ShapePath shapePath = this.cornerPaths[i];
        fArr[0] = shapePath.endX;
        fArr[1] = shapePath.endY;
        this.cornerTransforms[i].mapPoints(fArr);
        return (i == 1 || i == 3) ? java.lang.Math.abs(rectF.centerX() - this.scratch[0]) : java.lang.Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private com.google.android.material.shape.EdgeTreatment getEdgeTreatmentForIndex(int i, @androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        return i != 1 ? i != 2 ? i != 3 ? shapeAppearanceModel.getRightEdge() : shapeAppearanceModel.getTopEdge() : shapeAppearanceModel.getLeftEdge() : shapeAppearanceModel.getBottomEdge();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @androidx.annotation.UiThread
    public static com.google.android.material.shape.ShapeAppearancePathProvider getInstance() {
        return com.google.android.material.shape.ShapeAppearancePathProvider.Lazy.INSTANCE;
    }

    @androidx.annotation.RequiresApi(19)
    private boolean pathOverlapsCorner(android.graphics.Path path, int i) {
        this.cornerPath.reset();
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], this.cornerPath);
        android.graphics.RectF rectF = new android.graphics.RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, android.graphics.Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void setCornerPathAndTransform(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        getCornerTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i);
        this.cornerTransforms[i].reset();
        getCoordinatesOfCorner(i, shapeAppearancePathSpec.bounds, this.pointF);
        android.graphics.Matrix matrix = this.cornerTransforms[i];
        android.graphics.PointF pointF = this.pointF;
        matrix.setTranslate(pointF.x, pointF.y);
        this.cornerTransforms[i].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i) {
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i);
        this.edgeTransforms[i].reset();
        android.graphics.Matrix matrix = this.edgeTransforms[i];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i].preRotate(angleOfEdge);
    }

    public void calculatePath(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f, android.graphics.RectF rectF, @androidx.annotation.NonNull android.graphics.Path path) {
        calculatePath(shapeAppearanceModel, f, rectF, null, path);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f, android.graphics.RectF rectF, com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener, @androidx.annotation.NonNull android.graphics.Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, android.graphics.Path.Direction.CW);
        com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec = new com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec(shapeAppearanceModel, f, rectF, pathListener, path);
        for (int i = 0; i < 4; i++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i);
            setEdgePathAndTransform(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            appendCornerPath(shapeAppearancePathSpec, i2);
            appendEdgePath(shapeAppearancePathSpec, i2);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (this.overlappedEdgePath.isEmpty()) {
            return;
        }
        path.op(this.overlappedEdgePath, android.graphics.Path.Op.UNION);
    }

    public void setEdgeIntersectionCheckEnable(boolean z) {
        this.edgeIntersectionCheckEnabled = z;
    }
}
