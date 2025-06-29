package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class VerticalWidgetRun extends androidx.constraintlayout.solver.widgets.analyzer.WidgetRun {
    public androidx.constraintlayout.solver.widgets.analyzer.DependencyNode baseline;
    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency baselineDimension;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = iArr;
            try {
                iArr[androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.START.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.END.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalWidgetRun(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        super(constraintWidget);
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = new androidx.constraintlayout.solver.widgets.analyzer.DependencyNode(this);
        this.baseline = dependencyNode;
        this.baselineDimension = null;
        this.start.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.TOP;
        this.end.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.BOTTOM;
        dependencyNode.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget parent;
        androidx.constraintlayout.solver.widgets.ConstraintWidget parent2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getHeight());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
            if (this.widget.hasBaseline()) {
                this.baselineDimension = new androidx.constraintlayout.solver.widgets.analyzer.BaselineDimensionDependency(this);
            }
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
            if (dimensionBehaviour != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.widget.getParent()) != null && parent2.getVerticalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                    addTarget(this.start, parent2.verticalRun.start, this.widget.mTop.getMargin());
                    addTarget(this.end, parent2.verticalRun.end, -this.widget.mBottom.getMargin());
                    this.dimension.resolve(height);
                    return;
                }
                if (this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.widget.getParent()) != null && parent.getVerticalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) {
            addTarget(this.start, parent.verticalRun.start, this.widget.mTop.getMargin());
            addTarget(this.end, parent.verticalRun.end, -this.widget.mBottom.getMargin());
            return;
        }
        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency = this.dimension;
        boolean z = dimensionDependency.resolved;
        if (z) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget2.isInVerticalChain()) {
                        this.start.margin = this.widget.mListAnchors[2].getMargin();
                        this.end.margin = -this.widget.mListAnchors[3].getMargin();
                    } else {
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target = getTarget(this.widget.mListAnchors[2]);
                        if (target != null) {
                            addTarget(this.start, target, this.widget.mListAnchors[2].getMargin());
                        }
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target2 = getTarget(this.widget.mListAnchors[3]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.widget.mListAnchors[3].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.widget.mListAnchors[2].getMargin());
                        addTarget(this.end, this.start, this.dimension.value);
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    return;
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.mTarget != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.widget.mListAnchors[3].getMargin());
                        addTarget(this.start, this.end, -this.dimension.value);
                    }
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                        return;
                    }
                    return;
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.mTarget != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target5 = getTarget(constraintAnchor4);
                    if (target5 != null) {
                        addTarget(this.baseline, target5, 0);
                        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
                        addTarget(this.end, this.start, this.dimension.value);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Helper) || constraintWidget2.getParent() == null || this.widget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER).mTarget != null) {
                    return;
                }
                addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                addTarget(this.end, this.start, this.dimension.value);
                if (this.widget.hasBaseline()) {
                    addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                    return;
                }
                return;
            }
        }
        if (z || this.dimensionBehavior != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            dimensionDependency.addDependency(this);
        } else {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.widget;
            int i = constraintWidget3.mMatchConstraintDefaultHeight;
            if (i == 2) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency2 = parent3.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency2);
                    dimensionDependency2.dependencies.add(this.dimension);
                    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency3 = this.dimension;
                    dimensionDependency3.delegateToWidgetRun = true;
                    dimensionDependency3.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i == 3 && !constraintWidget3.isInVerticalChain()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.widget;
                if (constraintWidget4.mMatchConstraintDefaultWidth != 3) {
                    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency4 = constraintWidget4.horizontalRun.dimension;
                    this.dimension.targets.add(dimensionDependency4);
                    dimensionDependency4.dependencies.add(this.dimension);
                    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency5 = this.dimension;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = this.widget;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.mListAnchors;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget5.isInVerticalChain()) {
                this.start.margin = this.widget.mListAnchors[2].getMargin();
                this.end.margin = -this.widget.mListAnchors[3].getMargin();
            } else {
                androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target6 = getTarget(this.widget.mListAnchors[2]);
                androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target7 = getTarget(this.widget.mListAnchors[3]);
                target6.addDependency(this);
                target7.addDependency(this);
                this.mRunType = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.CENTER;
            }
            if (this.widget.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.baselineDimension);
            }
        } else if (constraintAnchor6 != null) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target8 = getTarget(constraintAnchor5);
            if (target8 != null) {
                addTarget(this.start, target8, this.widget.mListAnchors[2].getMargin());
                addTarget(this.end, this.start, 1, this.dimension);
                if (this.widget.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.widget.getDimensionRatio() > 0.0f) {
                    androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun = this.widget.horizontalRun;
                    if (horizontalWidgetRun.dimensionBehavior == dimensionBehaviour3) {
                        horizontalWidgetRun.dimension.dependencies.add(this.dimension);
                        this.dimension.targets.add(this.widget.horizontalRun.dimension);
                        this.dimension.updateDelegate = this;
                    }
                }
            }
        } else {
            androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target9 = getTarget(constraintAnchor7);
                if (target9 != null) {
                    addTarget(this.end, target9, -this.widget.mListAnchors[3].getMargin());
                    addTarget(this.start, this.end, -1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                }
            } else {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target10 = getTarget(constraintAnchor8);
                    if (target10 != null) {
                        addTarget(this.baseline, target10, 0);
                        addTarget(this.start, this.baseline, -1, this.baselineDimension);
                        addTarget(this.end, this.start, 1, this.dimension);
                    }
                } else if (!(constraintWidget5 instanceof androidx.constraintlayout.solver.widgets.Helper) && constraintWidget5.getParent() != null) {
                    addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                    addTarget(this.end, this.start, 1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.dimensionBehavior;
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.widget.getDimensionRatio() > 0.0f) {
                        androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun2 = this.widget.horizontalRun;
                        if (horizontalWidgetRun2.dimensionBehavior == dimensionBehaviour5) {
                            horizontalWidgetRun2.dimension.dependencies.add(this.dimension);
                            this.dimension.targets.add(this.widget.horizontalRun.dimension);
                            this.dimension.updateDelegate = this;
                        }
                    }
                }
            }
        }
        if (this.dimension.targets.size() == 0) {
            this.dimension.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setY(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return this.dimensionBehavior != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultHeight == 0;
    }

    public java.lang.String toString() {
        return "VerticalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
        float f;
        float dimensionRatio;
        float f2;
        int i;
        int i2 = androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (i2 == 1) {
            updateRunStart(dependency);
        } else if (i2 == 2) {
            updateRunEnd(dependency);
        } else if (i2 == 3) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
            updateRunCenter(dependency, constraintWidget.mTop, constraintWidget.mBottom, 1);
            return;
        }
        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.readyToSolve && !dimensionDependency.resolved && this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widget;
            int i3 = constraintWidget2.mMatchConstraintDefaultHeight;
            if (i3 == 2) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    if (parent.verticalRun.dimension.resolved) {
                        this.dimension.resolve((int) ((r7.value * this.widget.mMatchConstraintPercentHeight) + 0.5f));
                    }
                }
            } else if (i3 == 3 && constraintWidget2.horizontalRun.dimension.resolved) {
                int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                if (dimensionRatioSide == -1) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.widget;
                    f = constraintWidget3.horizontalRun.dimension.value;
                    dimensionRatio = constraintWidget3.getDimensionRatio();
                } else if (dimensionRatioSide == 0) {
                    f2 = r7.horizontalRun.dimension.value * this.widget.getDimensionRatio();
                    i = (int) (f2 + 0.5f);
                    this.dimension.resolve(i);
                } else if (dimensionRatioSide != 1) {
                    i = 0;
                    this.dimension.resolve(i);
                } else {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.widget;
                    f = constraintWidget4.horizontalRun.dimension.value;
                    dimensionRatio = constraintWidget4.getDimensionRatio();
                }
                f2 = f / dimensionRatio;
                i = (int) (f2 + 0.5f);
                this.dimension.resolve(i);
            }
        }
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.readyToSolve) {
                if (dependencyNode.resolved && dependencyNode2.resolved && this.dimension.resolved) {
                    return;
                }
                if (!this.dimension.resolved && this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = this.widget;
                    if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInVerticalChain()) {
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode3 = this.start.targets.get(0);
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode4 = this.end.targets.get(0);
                        int i4 = dependencyNode3.value;
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode5 = this.start;
                        int i5 = i4 + dependencyNode5.margin;
                        int i6 = dependencyNode4.value + this.end.margin;
                        dependencyNode5.resolve(i5);
                        this.end.resolve(i6);
                        this.dimension.resolve(i6 - i5);
                        return;
                    }
                }
                if (!this.dimension.resolved && this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode6 = this.start.targets.get(0);
                    int i7 = (this.end.targets.get(0).value + this.end.margin) - (dependencyNode6.value + this.start.margin);
                    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency2 = this.dimension;
                    int i8 = dimensionDependency2.wrapValue;
                    if (i7 < i8) {
                        dimensionDependency2.resolve(i7);
                    } else {
                        dimensionDependency2.resolve(i8);
                    }
                }
                if (this.dimension.resolved && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode7 = this.start.targets.get(0);
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode8 = this.end.targets.get(0);
                    int i9 = dependencyNode7.value + this.start.margin;
                    int i10 = dependencyNode8.value + this.end.margin;
                    float verticalBiasPercent = this.widget.getVerticalBiasPercent();
                    if (dependencyNode7 == dependencyNode8) {
                        i9 = dependencyNode7.value;
                        i10 = dependencyNode8.value;
                        verticalBiasPercent = 0.5f;
                    }
                    this.start.resolve((int) (i9 + 0.5f + (((i10 - i9) - this.dimension.value) * verticalBiasPercent)));
                    this.end.resolve(this.start.value + this.dimension.value);
                }
            }
        }
    }
}
