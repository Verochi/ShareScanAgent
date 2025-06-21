package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class HorizontalWidgetRun extends androidx.constraintlayout.solver.widgets.analyzer.WidgetRun {
    private static int[] tempDimensions = new int[2];

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
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

    public HorizontalWidgetRun(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.LEFT;
        this.end.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget parent;
        androidx.constraintlayout.solver.widgets.ConstraintWidget parent2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getWidth());
        }
        if (this.dimension.resolved) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (((parent = this.widget.getParent()) != null && parent.getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour2)) {
                addTarget(this.start, parent.horizontalRun.start, this.widget.mLeft.getMargin());
                addTarget(this.end, parent.horizontalRun.end, -this.widget.mRight.getMargin());
                return;
            }
        } else {
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.widget.getHorizontalDimensionBehaviour();
            this.dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour3 && (((parent2 = this.widget.getParent()) != null && parent2.getHorizontalDimensionBehaviour() == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                    int width = (parent2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    addTarget(this.start, parent2.horizontalRun.start, this.widget.mLeft.getMargin());
                    addTarget(this.end, parent2.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(width);
                    return;
                }
                if (this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        }
        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[1].mTarget != null) {
                    if (constraintWidget2.isInHorizontalChain()) {
                        this.start.margin = this.widget.mListAnchors[0].getMargin();
                        this.end.margin = -this.widget.mListAnchors[1].getMargin();
                        return;
                    }
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target = getTarget(this.widget.mListAnchors[0]);
                    if (target != null) {
                        addTarget(this.start, target, this.widget.mListAnchors[0].getMargin());
                    }
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target2 = getTarget(this.widget.mListAnchors[1]);
                    if (target2 != null) {
                        addTarget(this.end, target2, -this.widget.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.widget.mListAnchors[0].getMargin());
                        addTarget(this.end, this.start, this.dimension.value);
                        return;
                    }
                    return;
                }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.mTarget != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.widget.mListAnchors[1].getMargin());
                        addTarget(this.start, this.end, -this.dimension.value);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Helper) || constraintWidget2.getParent() == null || this.widget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER).mTarget != null) {
                    return;
                }
                addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                addTarget(this.end, this.start, this.dimension.value);
                return;
            }
        }
        if (this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.widget;
            int i = constraintWidget3.mMatchConstraintDefaultWidth;
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
            } else if (i == 3) {
                if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        this.dimension.targets.add(this.widget.verticalRun.dimension);
                        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                        androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                        verticalWidgetRun2.dimension.updateDelegate = this;
                        this.dimension.targets.add(verticalWidgetRun2.start);
                        this.dimension.targets.add(this.widget.verticalRun.end);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                    } else if (this.widget.isInHorizontalChain()) {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                    } else {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                    }
                } else {
                    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency4 = constraintWidget3.verticalRun.dimension;
                    dimensionDependency.targets.add(dimensionDependency4);
                    dimensionDependency4.dependencies.add(this.dimension);
                    this.widget.verticalRun.start.dependencies.add(this.dimension);
                    this.widget.verticalRun.end.dependencies.add(this.dimension);
                    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency5 = this.dimension;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                    this.start.targets.add(this.dimension);
                    this.end.targets.add(this.dimension);
                }
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.widget;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].mTarget != null) {
            if (constraintWidget4.isInHorizontalChain()) {
                this.start.margin = this.widget.mListAnchors[0].getMargin();
                this.end.margin = -this.widget.mListAnchors[1].getMargin();
                return;
            }
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target5 = getTarget(this.widget.mListAnchors[0]);
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target6 = getTarget(this.widget.mListAnchors[1]);
            target5.addDependency(this);
            target6.addDependency(this);
            this.mRunType = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target7 = getTarget(constraintAnchor4);
            if (target7 != null) {
                addTarget(this.start, target7, this.widget.mListAnchors[0].getMargin());
                addTarget(this.end, this.start, 1, this.dimension);
                return;
            }
            return;
        }
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.mTarget != null) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target8 = getTarget(constraintAnchor6);
            if (target8 != null) {
                addTarget(this.end, target8, -this.widget.mListAnchors[1].getMargin());
                addTarget(this.start, this.end, -1, this.dimension);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof androidx.constraintlayout.solver.widgets.Helper) || constraintWidget4.getParent() == null) {
            return;
        }
        addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
        addTarget(this.end, this.start, 1, this.dimension);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setX(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return this.dimensionBehavior != androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0;
    }

    public java.lang.String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02bc, code lost:
    
        if (r14 != 1) goto L135;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
        float f;
        float dimensionRatio;
        float f2;
        int i;
        int i2 = androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (i2 == 1) {
            updateRunStart(dependency);
        } else if (i2 == 2) {
            updateRunEnd(dependency);
        } else if (i2 == 3) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
            updateRunCenter(dependency, constraintWidget.mLeft, constraintWidget.mRight, 0);
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widget;
            int i3 = constraintWidget2.mMatchConstraintDefaultWidth;
            if (i3 == 2) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    if (parent.horizontalRun.dimension.resolved) {
                        this.dimension.resolve((int) ((r0.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
                    }
                }
            } else if (i3 == 3) {
                int i4 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i4 == 0 || i4 == 3) {
                    androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = verticalWidgetRun.start;
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = verticalWidgetRun.end;
                    boolean z = constraintWidget2.mLeft.mTarget != null;
                    boolean z2 = constraintWidget2.mTop.mTarget != null;
                    boolean z3 = constraintWidget2.mRight.mTarget != null;
                    boolean z4 = constraintWidget2.mBottom.mTarget != null;
                    int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                    if (z && z2 && z3 && z4) {
                        float dimensionRatio2 = this.widget.getDimensionRatio();
                        if (dependencyNode.resolved && dependencyNode2.resolved) {
                            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode3 = this.start;
                            if (dependencyNode3.readyToSolve && this.end.readyToSolve) {
                                computeInsetRatio(tempDimensions, dependencyNode3.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                return;
                            }
                            return;
                        }
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode4 = this.start;
                        if (dependencyNode4.resolved) {
                            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode5 = this.end;
                            if (dependencyNode5.resolved) {
                                if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                                    return;
                                }
                                computeInsetRatio(tempDimensions, dependencyNode4.value + dependencyNode4.margin, dependencyNode5.value - dependencyNode5.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                            }
                        }
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode6 = this.start;
                        if (!dependencyNode6.readyToSolve || !this.end.readyToSolve || !dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                            return;
                        }
                        computeInsetRatio(tempDimensions, dependencyNode6.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide);
                        this.dimension.resolve(tempDimensions[0]);
                        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                    } else if (z && z3) {
                        if (!this.start.readyToSolve || !this.end.readyToSolve) {
                            return;
                        }
                        float dimensionRatio3 = this.widget.getDimensionRatio();
                        int i5 = this.start.targets.get(0).value + this.start.margin;
                        int i6 = this.end.targets.get(0).value - this.end.margin;
                        if (dimensionRatioSide == -1 || dimensionRatioSide == 0) {
                            int limitedDimension = getLimitedDimension(i6 - i5, 0);
                            int i7 = (int) ((limitedDimension * dimensionRatio3) + 0.5f);
                            int limitedDimension2 = getLimitedDimension(i7, 1);
                            if (i7 != limitedDimension2) {
                                limitedDimension = (int) ((limitedDimension2 / dimensionRatio3) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension);
                            this.widget.verticalRun.dimension.resolve(limitedDimension2);
                        } else if (dimensionRatioSide == 1) {
                            int limitedDimension3 = getLimitedDimension(i6 - i5, 0);
                            int i8 = (int) ((limitedDimension3 / dimensionRatio3) + 0.5f);
                            int limitedDimension4 = getLimitedDimension(i8, 1);
                            if (i8 != limitedDimension4) {
                                limitedDimension3 = (int) ((limitedDimension4 * dimensionRatio3) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension3);
                            this.widget.verticalRun.dimension.resolve(limitedDimension4);
                        }
                    } else if (z2 && z4) {
                        if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                            return;
                        }
                        float dimensionRatio4 = this.widget.getDimensionRatio();
                        int i9 = dependencyNode.targets.get(0).value + dependencyNode.margin;
                        int i10 = dependencyNode2.targets.get(0).value - dependencyNode2.margin;
                        if (dimensionRatioSide != -1) {
                            if (dimensionRatioSide == 0) {
                                int limitedDimension5 = getLimitedDimension(i10 - i9, 1);
                                int i11 = (int) ((limitedDimension5 * dimensionRatio4) + 0.5f);
                                int limitedDimension6 = getLimitedDimension(i11, 0);
                                if (i11 != limitedDimension6) {
                                    limitedDimension5 = (int) ((limitedDimension6 / dimensionRatio4) + 0.5f);
                                }
                                this.dimension.resolve(limitedDimension6);
                                this.widget.verticalRun.dimension.resolve(limitedDimension5);
                            }
                        }
                        int limitedDimension7 = getLimitedDimension(i10 - i9, 1);
                        int i12 = (int) ((limitedDimension7 / dimensionRatio4) + 0.5f);
                        int limitedDimension8 = getLimitedDimension(i12, 0);
                        if (i12 != limitedDimension8) {
                            limitedDimension7 = (int) ((limitedDimension8 * dimensionRatio4) + 0.5f);
                        }
                        this.dimension.resolve(limitedDimension8);
                        this.widget.verticalRun.dimension.resolve(limitedDimension7);
                    }
                } else {
                    int dimensionRatioSide2 = constraintWidget2.getDimensionRatioSide();
                    if (dimensionRatioSide2 == -1) {
                        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = this.widget;
                        f = constraintWidget3.verticalRun.dimension.value;
                        dimensionRatio = constraintWidget3.getDimensionRatio();
                    } else if (dimensionRatioSide2 == 0) {
                        f2 = r0.verticalRun.dimension.value / this.widget.getDimensionRatio();
                        i = (int) (f2 + 0.5f);
                        this.dimension.resolve(i);
                    } else if (dimensionRatioSide2 != 1) {
                        i = 0;
                        this.dimension.resolve(i);
                    } else {
                        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = this.widget;
                        f = constraintWidget4.verticalRun.dimension.value;
                        dimensionRatio = constraintWidget4.getDimensionRatio();
                    }
                    f2 = f * dimensionRatio;
                    i = (int) (f2 + 0.5f);
                    this.dimension.resolve(i);
                }
            }
        }
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode7 = this.start;
        if (dependencyNode7.readyToSolve) {
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode8 = this.end;
            if (dependencyNode8.readyToSolve) {
                if (dependencyNode7.resolved && dependencyNode8.resolved && this.dimension.resolved) {
                    return;
                }
                if (!this.dimension.resolved && this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = this.widget;
                    if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInHorizontalChain()) {
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode9 = this.start.targets.get(0);
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode10 = this.end.targets.get(0);
                        int i13 = dependencyNode9.value;
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode11 = this.start;
                        int i14 = i13 + dependencyNode11.margin;
                        int i15 = dependencyNode10.value + this.end.margin;
                        dependencyNode11.resolve(i14);
                        this.end.resolve(i15);
                        this.dimension.resolve(i15 - i14);
                        return;
                    }
                }
                if (!this.dimension.resolved && this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    int min = java.lang.Math.min((this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget6 = this.widget;
                    int i16 = constraintWidget6.mMatchConstraintMaxWidth;
                    int max = java.lang.Math.max(constraintWidget6.mMatchConstraintMinWidth, min);
                    if (i16 > 0) {
                        max = java.lang.Math.min(i16, max);
                    }
                    this.dimension.resolve(max);
                }
                if (this.dimension.resolved) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode12 = this.start.targets.get(0);
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode13 = this.end.targets.get(0);
                    int i17 = dependencyNode12.value + this.start.margin;
                    int i18 = dependencyNode13.value + this.end.margin;
                    float horizontalBiasPercent = this.widget.getHorizontalBiasPercent();
                    if (dependencyNode12 == dependencyNode13) {
                        i17 = dependencyNode12.value;
                        i18 = dependencyNode13.value;
                        horizontalBiasPercent = 0.5f;
                    }
                    this.start.resolve((int) (i17 + 0.5f + (((i18 - i17) - this.dimension.value) * horizontalBiasPercent)));
                    this.end.resolve(this.start.value + this.dimension.value);
                }
            }
        }
    }
}
