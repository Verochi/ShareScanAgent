package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends androidx.constraintlayout.solver.widgets.WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    static int mycounter;
    private java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> horizontalWrapMax;
    private java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> horizontalWrapMin;
    androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure mBasicMeasureSolver;
    int mDebugSolverPassCount;
    public androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    androidx.constraintlayout.solver.widgets.ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    public androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure mMeasure;
    protected androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer mMeasurer;
    public androidx.constraintlayout.solver.Metrics mMetrics;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    protected androidx.constraintlayout.solver.LinearSystem mSystem;
    androidx.constraintlayout.solver.widgets.ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;
    private java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> verticalWrapMax;
    private java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> verticalWrapMin;

    public ConstraintWidgetContainer() {
        this.mBasicMeasureSolver = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure(this);
        this.mDependencyGraph = new androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new androidx.constraintlayout.solver.LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mHorizontalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.mBasicMeasureSolver = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure(this);
        this.mDependencyGraph = new androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new androidx.constraintlayout.solver.LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mHorizontalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mBasicMeasureSolver = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure(this);
        this.mDependencyGraph = new androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new androidx.constraintlayout.solver.LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mHorizontalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(java.lang.String str, int i, int i2) {
        super(i, i2);
        this.mBasicMeasureSolver = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure(this);
        this.mDependencyGraph = new androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new androidx.constraintlayout.solver.LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mHorizontalChainsArray = new androidx.constraintlayout.solver.widgets.ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();
        setDebugName(str);
    }

    private void addHorizontalChain(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        androidx.constraintlayout.solver.widgets.ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (androidx.constraintlayout.solver.widgets.ChainHead[]) java.util.Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new androidx.constraintlayout.solver.widgets.ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, androidx.constraintlayout.solver.SolverVariable solverVariable) {
        this.mSystem.addGreaterThan(solverVariable, this.mSystem.createObjectVariable(constraintAnchor), 0, 5);
    }

    private void addMinWrap(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, androidx.constraintlayout.solver.SolverVariable solverVariable) {
        this.mSystem.addGreaterThan(this.mSystem.createObjectVariable(constraintAnchor), solverVariable, 0, 5);
    }

    private void addVerticalChain(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        androidx.constraintlayout.solver.widgets.ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (androidx.constraintlayout.solver.widgets.ChainHead[]) java.util.Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new androidx.constraintlayout.solver.widgets.ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public static boolean measure(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure, int i) {
        int i2;
        int i3;
        if (measurer == null) {
            return false;
        }
        measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z3) {
            measure.horizontalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                measure.horizontalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z = false;
        }
        if (z2 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z4) {
            measure.verticalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                measure.verticalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (constraintWidget.isResolvedHorizontally()) {
            measure.horizontalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
            z = false;
        }
        if (constraintWidget.isResolvedVertically()) {
            measure.verticalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (z3) {
            if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                measure.horizontalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.verticalBehavior;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i3 = measure.verticalDimension;
                } else {
                    measure.horizontalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i3 = measure.measuredHeight;
                }
                measure.horizontalBehavior = dimensionBehaviour4;
                int i4 = constraintWidget.mDimensionRatioSide;
                if (i4 == 0 || i4 == -1) {
                    measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() * i3);
                } else {
                    measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() / i3);
                }
            }
        }
        if (z4) {
            if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                measure.verticalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.horizontalBehavior;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i2 = measure.horizontalDimension;
                } else {
                    measure.verticalBehavior = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i2 = measure.measuredWidth;
                }
                measure.verticalBehavior = dimensionBehaviour6;
                int i5 = constraintWidget.mDimensionRatioSide;
                if (i5 == 0 || i5 == -1) {
                    measure.verticalDimension = (int) (i2 / constraintWidget.getDimensionRatio());
                } else {
                    measure.verticalDimension = (int) (i2 * constraintWidget.getDimensionRatio());
                }
            }
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.measureStrategy = androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS;
        return measure.measuredNeedsSolverPass;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public void addChain(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(androidx.constraintlayout.solver.LinearSystem linearSystem) {
        boolean optimizeFor = optimizeFor(64);
        addToSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.setInBarrier(0, false);
            constraintWidget.setInBarrier(1, false);
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.mChildren.get(i2);
                if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    ((androidx.constraintlayout.solver.widgets.Barrier) constraintWidget2).markWidgets();
                }
            }
        }
        for (int i3 = 0; i3 < size; i3++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.mChildren.get(i3);
            if (constraintWidget3.addFirst()) {
                constraintWidget3.addToSolver(linearSystem, optimizeFor);
            }
        }
        if (androidx.constraintlayout.solver.LinearSystem.USE_DEPENDENCY_ORDERING) {
            java.util.HashSet<androidx.constraintlayout.solver.widgets.ConstraintWidget> hashSet = new java.util.HashSet<>();
            for (int i4 = 0; i4 < size; i4++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.mChildren.get(i4);
                if (!constraintWidget4.addFirst()) {
                    hashSet.add(constraintWidget4);
                }
            }
            addChildrenToSolverByDependency(this, linearSystem, hashSet, getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = hashSet.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
                androidx.constraintlayout.solver.widgets.Optimizer.checkMatchParent(this, linearSystem, next);
                next.addToSolver(linearSystem, optimizeFor);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = this.mChildren.get(i5);
                if (constraintWidget5 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.mListDimensionBehaviors;
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.setHorizontalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.setVerticalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget5.addToSolver(linearSystem, optimizeFor);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    androidx.constraintlayout.solver.widgets.Optimizer.checkMatchParent(this, linearSystem, constraintWidget5);
                    if (!constraintWidget5.addFirst()) {
                        constraintWidget5.addToSolver(linearSystem, optimizeFor);
                    }
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(this, linearSystem, null, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(this, linearSystem, null, 1);
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor) {
        java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference = this.horizontalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) {
            this.horizontalWrapMax = new java.lang.ref.WeakReference<>(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor) {
        java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference = this.horizontalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) {
            this.horizontalWrapMin = new java.lang.ref.WeakReference<>(constraintAnchor);
        }
    }

    public void addVerticalWrapMaxVariable(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor) {
        java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference = this.verticalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) {
            this.verticalWrapMax = new java.lang.ref.WeakReference<>(constraintAnchor);
        }
    }

    public void addVerticalWrapMinVariable(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor) {
        java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference = this.verticalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) {
            this.verticalWrapMin = new java.lang.ref.WeakReference<>(constraintAnchor);
        }
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z) {
        return this.mDependencyGraph.directMeasure(z);
    }

    public boolean directMeasureSetup(boolean z) {
        return this.mDependencyGraph.directMeasureSetup(z);
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        return this.mDependencyGraph.directMeasureWithOrientation(z, i);
    }

    public void fillMetrics(androidx.constraintlayout.solver.Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public java.util.ArrayList<androidx.constraintlayout.solver.widgets.Guideline> getHorizontalGuidelines() {
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.Guideline> arrayList = new java.util.ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public androidx.constraintlayout.solver.LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public java.lang.String getType() {
        return "ConstraintLayout";
    }

    public java.util.ArrayList<androidx.constraintlayout.solver.widgets.Guideline> getVerticalGuidelines() {
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.Guideline> arrayList = new java.util.ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    public void layout() {
        int i;
        int i2;
        boolean z;
        boolean z2;
        ?? r6;
        boolean z3;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int size = this.mChildren.size();
        int max = java.lang.Math.max(0, getWidth());
        int max2 = java.lang.Math.max(0, getHeight());
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        androidx.constraintlayout.solver.Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.layouts++;
        }
        if (androidx.constraintlayout.solver.widgets.Optimizer.enabled(this.mOptimizationLevel, 1)) {
            androidx.constraintlayout.solver.widgets.analyzer.Direct.solvingPass(this, getMeasurer());
            for (int i3 = 0; i3 < size; i3++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.mChildren.get(i3);
                if (constraintWidget.isMeasureRequested() && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline) && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) && !constraintWidget.isInVirtualLayout()) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidget.getDimensionBehaviour(0);
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidget.getDimensionBehaviour(1);
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (!(dimensionBehaviour4 == dimensionBehaviour6 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour5 == dimensionBehaviour6 && constraintWidget.mMatchConstraintDefaultHeight != 1)) {
                        measure(constraintWidget, this.mMeasurer, new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure(), androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                }
            }
        }
        if (size <= 2 || !((dimensionBehaviour3 == (dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) && androidx.constraintlayout.solver.widgets.Optimizer.enabled(this.mOptimizationLevel, 1024) && androidx.constraintlayout.solver.widgets.analyzer.Grouping.simpleSolvingPass(this, getMeasurer()))) {
            i = max2;
            i2 = max;
            z = false;
        } else {
            if (dimensionBehaviour3 == dimensionBehaviour) {
                if (max >= getWidth() || max <= 0) {
                    max = getWidth();
                } else {
                    setWidth(max);
                    this.mWidthMeasuredTooSmall = true;
                }
            }
            if (dimensionBehaviour2 == dimensionBehaviour) {
                if (max2 >= getHeight() || max2 <= 0) {
                    max2 = getHeight();
                } else {
                    setHeight(max2);
                    this.mHeightMeasuredTooSmall = true;
                }
            }
            i = max2;
            i2 = max;
            z = true;
        }
        boolean z4 = optimizeFor(64) || optimizeFor(128);
        androidx.constraintlayout.solver.LinearSystem linearSystem = this.mSystem;
        linearSystem.graphOptimizer = false;
        linearSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0 && z4) {
            linearSystem.newgraphOptimizer = true;
        }
        java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> arrayList = this.mChildren;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z5 = horizontalDimensionBehaviour == dimensionBehaviour7 || getVerticalDimensionBehaviour() == dimensionBehaviour7;
        resetChains();
        for (int i4 = 0; i4 < size; i4++) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.mChildren.get(i4);
            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.WidgetContainer) {
                ((androidx.constraintlayout.solver.widgets.WidgetContainer) constraintWidget2).layout();
            }
        }
        boolean optimizeFor = optimizeFor(64);
        boolean z6 = z;
        int i5 = 0;
        boolean z7 = true;
        while (z7) {
            int i6 = i5 + 1;
            try {
                this.mSystem.reset();
                resetChains();
                createObjectVariables(this.mSystem);
                for (int i7 = 0; i7 < size; i7++) {
                    this.mChildren.get(i7).createObjectVariables(this.mSystem);
                }
                z7 = addChildrenToSolver(this.mSystem);
                java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference = this.verticalWrapMin;
                if (weakReference != null && weakReference.get() != null) {
                    addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));
                    this.verticalWrapMin = null;
                }
                java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference2 = this.verticalWrapMax;
                if (weakReference2 != null && weakReference2.get() != null) {
                    addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));
                    this.verticalWrapMax = null;
                }
                java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference3 = this.horizontalWrapMin;
                if (weakReference3 != null && weakReference3.get() != null) {
                    addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));
                    this.horizontalWrapMin = null;
                }
                java.lang.ref.WeakReference<androidx.constraintlayout.solver.widgets.ConstraintAnchor> weakReference4 = this.horizontalWrapMax;
                if (weakReference4 != null && weakReference4.get() != null) {
                    addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));
                    this.horizontalWrapMax = null;
                }
                if (z7) {
                    this.mSystem.minimize();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                java.lang.System.out.println("EXCEPTION : " + e);
            }
            if (z7) {
                updateChildrenFromSolver(this.mSystem, androidx.constraintlayout.solver.widgets.Optimizer.flags);
            } else {
                updateFromSolver(this.mSystem, optimizeFor);
                for (int i8 = 0; i8 < size; i8++) {
                    this.mChildren.get(i8).updateFromSolver(this.mSystem, optimizeFor);
                }
            }
            if (z5 && i6 < 8 && androidx.constraintlayout.solver.widgets.Optimizer.flags[2]) {
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.mChildren.get(i11);
                    i9 = java.lang.Math.max(i9, constraintWidget3.mX + constraintWidget3.getWidth());
                    i10 = java.lang.Math.max(i10, constraintWidget3.mY + constraintWidget3.getHeight());
                }
                int max3 = java.lang.Math.max(this.mMinWidth, i9);
                int max4 = java.lang.Math.max(this.mMinHeight, i10);
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour3 != dimensionBehaviour8 || getWidth() >= max3) {
                    z2 = false;
                } else {
                    setWidth(max3);
                    this.mListDimensionBehaviors[0] = dimensionBehaviour8;
                    z2 = true;
                    z6 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour8 && getHeight() < max4) {
                    setHeight(max4);
                    this.mListDimensionBehaviors[1] = dimensionBehaviour8;
                    z2 = true;
                    z6 = true;
                }
            } else {
                z2 = false;
            }
            int max5 = java.lang.Math.max(this.mMinWidth, getWidth());
            if (max5 > getWidth()) {
                setWidth(max5);
                this.mListDimensionBehaviors[0] = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                z2 = true;
                z6 = true;
            }
            int max6 = java.lang.Math.max(this.mMinHeight, getHeight());
            if (max6 > getHeight()) {
                setHeight(max6);
                r6 = 1;
                this.mListDimensionBehaviors[1] = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                z2 = true;
                z3 = true;
            } else {
                r6 = 1;
                z3 = z6;
            }
            if (!z3) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = this.mListDimensionBehaviors[0];
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour9 == dimensionBehaviour10 && i2 > 0 && getWidth() > i2) {
                    this.mWidthMeasuredTooSmall = r6;
                    this.mListDimensionBehaviors[0] = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                    setWidth(i2);
                    z2 = true;
                    z3 = true;
                }
                if (this.mListDimensionBehaviors[r6] == dimensionBehaviour10 && i > 0 && getHeight() > i) {
                    this.mHeightMeasuredTooSmall = r6;
                    this.mListDimensionBehaviors[r6] = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                    setHeight(i);
                    z6 = true;
                    z7 = true;
                    i5 = i6;
                }
            }
            z7 = z2;
            z6 = z3;
            i5 = i6;
        }
        this.mChildren = arrayList;
        if (z6) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            dimensionBehaviourArr2[0] = dimensionBehaviour3;
            dimensionBehaviourArr2[1] = dimensionBehaviour2;
        }
        resetSolverVariables(this.mSystem.getCache());
    }

    public long measure(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mPaddingLeft = i8;
        this.mPaddingTop = i9;
        return this.mBasicMeasureSolver.solverMeasure(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        androidx.constraintlayout.solver.LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public void updateChildrenFromSolver(androidx.constraintlayout.solver.LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean optimizeFor = optimizeFor(64);
        updateFromSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).updateFromSolver(linearSystem, optimizeFor);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).updateFromRuns(z, z2);
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }
}
