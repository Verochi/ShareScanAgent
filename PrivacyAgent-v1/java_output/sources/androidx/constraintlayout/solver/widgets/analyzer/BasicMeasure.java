package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer;
    private final java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> mVariableDimensionsWidgets = new java.util.ArrayList<>();
    private androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure mMeasure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
        void didMeasures();

        void measure(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure);
    }

    public BasicMeasure(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure2 = this.mMeasure;
        measure2.measureStrategy = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS;
        return measure2.measuredNeedsSolverPass;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
    
        if (r8 != r9) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0095, code lost:
    
        if (r5.mDimensionRatio <= 0.0f) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureChildren(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
        androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun;
        androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun;
        int size = constraintWidgetContainer.mChildren.size();
        boolean optimizeFor = constraintWidgetContainer.optimizeFor(64);
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            if (!(constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) && !constraintWidget.isInVirtualLayout() && (!optimizeFor || (horizontalWidgetRun = constraintWidget.horizontalRun) == null || (verticalWidgetRun = constraintWidget.verticalRun) == null || !horizontalWidgetRun.dimension.resolved || !verticalWidgetRun.dimension.resolved)) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                boolean z = true;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight != 1;
                if (!z2 && constraintWidgetContainer.optimizeFor(1) && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) {
                    if (dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth == 0 && dimensionBehaviour2 != dimensionBehaviour3 && !constraintWidget.isInHorizontalChain()) {
                        z2 = true;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight == 0 && dimensionBehaviour != dimensionBehaviour3 && !constraintWidget.isInHorizontalChain()) {
                        z2 = true;
                    }
                    if (dimensionBehaviour != dimensionBehaviour3) {
                    }
                }
                z = z2;
                if (!z) {
                    measure(measurer, constraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
                    androidx.constraintlayout.solver.Metrics metrics = constraintWidgetContainer.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, java.lang.String str, int i, int i2) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i);
        constraintWidgetContainer.setHeight(i2);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        int i10;
        int i11;
        boolean z2;
        boolean z3;
        boolean z4;
        int i12;
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer;
        int i13;
        int i14;
        int i15;
        boolean z5;
        androidx.constraintlayout.solver.Metrics metrics;
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer2 = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = androidx.constraintlayout.solver.widgets.Optimizer.enabled(i, 128);
        boolean z6 = enabled || androidx.constraintlayout.solver.widgets.Optimizer.enabled(i, 64);
        if (z6) {
            for (int i16 = 0; i16 < size; i16++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i16);
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z7 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((constraintWidget.isInHorizontalChain() && z7) || ((constraintWidget.isInVerticalChain() && z7) || (constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z6 = false;
                    break;
                }
            }
        }
        if (z6 && (metrics = androidx.constraintlayout.solver.LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        boolean z8 = z6 & ((i4 == 1073741824 && i6 == 1073741824) || enabled);
        if (z8) {
            int min = java.lang.Math.min(constraintWidgetContainer.getMaxWidth(), i5);
            int min2 = java.lang.Math.min(constraintWidgetContainer.getMaxHeight(), i7);
            if (i4 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i6 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                z = constraintWidgetContainer.directMeasure(enabled);
                i10 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer.directMeasureSetup(enabled);
                if (i4 == 1073741824) {
                    directMeasureSetup &= constraintWidgetContainer.directMeasureWithOrientation(enabled, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i6 == 1073741824) {
                    z = constraintWidgetContainer.directMeasureWithOrientation(enabled, 1) & directMeasureSetup;
                    i10++;
                } else {
                    z = directMeasureSetup;
                }
            }
            if (z) {
                constraintWidgetContainer.updateFromRuns(i4 == 1073741824, i6 == 1073741824);
            }
        } else {
            z = false;
            i10 = 0;
        }
        if (z && i10 == 2) {
            return 0L;
        }
        int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
        if (size > 0) {
            measureChildren(constraintWidgetContainer);
        }
        updateHierarchy(constraintWidgetContainer);
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer, "First pass", width, height);
        }
        if (size2 > 0) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z9 = horizontalDimensionBehaviour2 == dimensionBehaviour2;
            boolean z10 = constraintWidgetContainer.getVerticalDimensionBehaviour() == dimensionBehaviour2;
            int max = java.lang.Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = java.lang.Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i17 = 0;
            boolean z11 = false;
            while (i17 < size2) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i17);
                if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) {
                    int width2 = constraintWidget2.getWidth();
                    i13 = optimizationLevel;
                    int height2 = constraintWidget2.getHeight();
                    i14 = width;
                    boolean measure = measure(measurer2, constraintWidget2, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) | z11;
                    androidx.constraintlayout.solver.Metrics metrics2 = constraintWidgetContainer.mMetrics;
                    i15 = height;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets++;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z9 && constraintWidget2.getRight() > max) {
                            max = java.lang.Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        z5 = true;
                    } else {
                        z5 = measure;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z10 && constraintWidget2.getBottom() > max2) {
                            max2 = java.lang.Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        z5 = true;
                    }
                    z11 = z5 | ((androidx.constraintlayout.solver.widgets.VirtualLayout) constraintWidget2).needSolverPass();
                } else {
                    i13 = optimizationLevel;
                    i14 = width;
                    i15 = height;
                }
                i17++;
                optimizationLevel = i13;
                width = i14;
                height = i15;
            }
            int i18 = optimizationLevel;
            int i19 = width;
            int i20 = height;
            int i21 = 0;
            int i22 = 2;
            while (i21 < i22) {
                int i23 = 0;
                while (i23 < size2) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i23);
                    if (((constraintWidget3 instanceof androidx.constraintlayout.solver.widgets.Helper) && !(constraintWidget3 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) || (constraintWidget3 instanceof androidx.constraintlayout.solver.widgets.Guideline) || constraintWidget3.getVisibility() == 8 || ((z8 && constraintWidget3.horizontalRun.dimension.resolved && constraintWidget3.verticalRun.dimension.resolved) || (constraintWidget3 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout))) {
                        z4 = z8;
                        i12 = size2;
                        measurer = measurer2;
                    } else {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        int i24 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS;
                        z4 = z8;
                        if (i21 == 1) {
                            i24 = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.USE_GIVEN_DIMENSIONS;
                        }
                        boolean measure2 = measure(measurer2, constraintWidget3, i24) | z11;
                        androidx.constraintlayout.solver.Metrics metrics3 = constraintWidgetContainer.mMetrics;
                        i12 = size2;
                        measurer = measurer2;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets++;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z9 && constraintWidget3.getRight() > max) {
                                max = java.lang.Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            measure2 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z10 && constraintWidget3.getBottom() > max2) {
                                max2 = java.lang.Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            measure2 = true;
                        }
                        z11 = (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) ? measure2 : true;
                    }
                    i23++;
                    size2 = i12;
                    measurer2 = measurer;
                    z8 = z4;
                }
                boolean z12 = z8;
                int i25 = size2;
                androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer3 = measurer2;
                if (!z11) {
                    break;
                }
                solveLinearSystem(constraintWidgetContainer, "intermediate pass", i19, i20);
                i21++;
                measurer2 = measurer3;
                z8 = z12;
                i22 = 2;
                z11 = false;
                size2 = i25;
            }
            if (z11) {
                solveLinearSystem(constraintWidgetContainer, "2nd pass", i19, i20);
                if (constraintWidgetContainer.getWidth() < max) {
                    constraintWidgetContainer.setWidth(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (constraintWidgetContainer.getHeight() < max2) {
                    constraintWidgetContainer.setHeight(max2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    solveLinearSystem(constraintWidgetContainer, "3rd pass", i19, i20);
                }
            }
            i11 = i18;
        } else {
            i11 = optimizationLevel;
        }
        constraintWidgetContainer.setOptimizationLevel(i11);
        return 0L;
    }

    public void updateHierarchy(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
