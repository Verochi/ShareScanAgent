package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class ShapeData {
    public final java.util.List<com.airbnb.lottie.model.CubicCurveData> a;
    public android.graphics.PointF b;
    public boolean c;

    public ShapeData() {
        this.a = new java.util.ArrayList();
    }

    public ShapeData(android.graphics.PointF pointF, boolean z, java.util.List<com.airbnb.lottie.model.CubicCurveData> list) {
        this.b = pointF;
        this.c = z;
        this.a = new java.util.ArrayList(list);
    }

    public final void a(float f, float f2) {
        if (this.b == null) {
            this.b = new android.graphics.PointF();
        }
        this.b.set(f, f2);
    }

    public java.util.List<com.airbnb.lottie.model.CubicCurveData> getCurves() {
        return this.a;
    }

    public android.graphics.PointF getInitialPoint() {
        return this.b;
    }

    public void interpolateBetween(com.airbnb.lottie.model.content.ShapeData shapeData, com.airbnb.lottie.model.content.ShapeData shapeData2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.b == null) {
            this.b = new android.graphics.PointF();
        }
        this.c = shapeData.isClosed() || shapeData2.isClosed();
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            com.airbnb.lottie.utils.Logger.warning("Curves must have the same number of control points. Shape 1: " + shapeData.getCurves().size() + "\tShape 2: " + shapeData2.getCurves().size());
        }
        int min = java.lang.Math.min(shapeData.getCurves().size(), shapeData2.getCurves().size());
        if (this.a.size() < min) {
            for (int size = this.a.size(); size < min; size++) {
                this.a.add(new com.airbnb.lottie.model.CubicCurveData());
            }
        } else if (this.a.size() > min) {
            for (int size2 = this.a.size() - 1; size2 >= min; size2--) {
                java.util.List<com.airbnb.lottie.model.CubicCurveData> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        android.graphics.PointF initialPoint = shapeData.getInitialPoint();
        android.graphics.PointF initialPoint2 = shapeData2.getInitialPoint();
        a(com.airbnb.lottie.utils.MiscUtils.lerp(initialPoint.x, initialPoint2.x, f), com.airbnb.lottie.utils.MiscUtils.lerp(initialPoint.y, initialPoint2.y, f));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.model.CubicCurveData cubicCurveData = shapeData.getCurves().get(size3);
            com.airbnb.lottie.model.CubicCurveData cubicCurveData2 = shapeData2.getCurves().get(size3);
            android.graphics.PointF controlPoint1 = cubicCurveData.getControlPoint1();
            android.graphics.PointF controlPoint2 = cubicCurveData.getControlPoint2();
            android.graphics.PointF vertex = cubicCurveData.getVertex();
            android.graphics.PointF controlPoint12 = cubicCurveData2.getControlPoint1();
            android.graphics.PointF controlPoint22 = cubicCurveData2.getControlPoint2();
            android.graphics.PointF vertex2 = cubicCurveData2.getVertex();
            this.a.get(size3).setControlPoint1(com.airbnb.lottie.utils.MiscUtils.lerp(controlPoint1.x, controlPoint12.x, f), com.airbnb.lottie.utils.MiscUtils.lerp(controlPoint1.y, controlPoint12.y, f));
            this.a.get(size3).setControlPoint2(com.airbnb.lottie.utils.MiscUtils.lerp(controlPoint2.x, controlPoint22.x, f), com.airbnb.lottie.utils.MiscUtils.lerp(controlPoint2.y, controlPoint22.y, f));
            this.a.get(size3).setVertex(com.airbnb.lottie.utils.MiscUtils.lerp(vertex.x, vertex2.x, f), com.airbnb.lottie.utils.MiscUtils.lerp(vertex.y, vertex2.y, f));
        }
    }

    public boolean isClosed() {
        return this.c;
    }

    public java.lang.String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }
}
