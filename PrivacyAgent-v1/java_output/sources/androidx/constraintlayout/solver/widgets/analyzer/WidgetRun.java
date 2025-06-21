package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public abstract class WidgetRun implements androidx.constraintlayout.solver.widgets.analyzer.Dependency {
    protected androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public int matchConstraintsType;
    androidx.constraintlayout.solver.widgets.analyzer.RunGroup runGroup;
    androidx.constraintlayout.solver.widgets.ConstraintWidget widget;
    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimension = new androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency(this);
    public int orientation = 0;
    boolean resolved = false;
    public androidx.constraintlayout.solver.widgets.analyzer.DependencyNode start = new androidx.constraintlayout.solver.widgets.analyzer.DependencyNode(this);
    public androidx.constraintlayout.solver.widgets.analyzer.DependencyNode end = new androidx.constraintlayout.solver.widgets.analyzer.DependencyNode(this);
    protected androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType mRunType = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.NONE;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    private void resolveDimension(int i, int i2) {
        int i3 = this.matchConstraintsType;
        if (i3 == 0) {
            this.dimension.resolve(getLimitedDimension(i2, i));
            return;
        }
        if (i3 == 1) {
            this.dimension.resolve(java.lang.Math.min(getLimitedDimension(this.dimension.wrapValue, i), i2));
            return;
        }
        if (i3 == 2) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget parent = this.widget.getParent();
            if (parent != null) {
                if ((i == 0 ? parent.horizontalRun : parent.verticalRun).dimension.resolved) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
                    this.dimension.resolve(getLimitedDimension((int) ((r9.value * (i == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight)) + 0.5f), i));
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widget;
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = constraintWidget2.horizontalRun;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.dimensionBehavior;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.matchConstraintsType == 3) {
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
            if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                return;
            }
        }
        if (i == 0) {
            widgetRun = constraintWidget2.verticalRun;
        }
        if (widgetRun.dimension.resolved) {
            float dimensionRatio = constraintWidget2.getDimensionRatio();
            this.dimension.resolve(i == 1 ? (int) ((widgetRun.dimension.value / dimensionRatio) + 0.5f) : (int) ((dimensionRatio * widgetRun.dimension.value) + 0.5f));
        }
    }

    public final void addTarget(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2, int i) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public final void addTarget(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2, int i, androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i, int i2) {
        int max;
        if (i2 == 0) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
            int i3 = constraintWidget.mMatchConstraintMaxWidth;
            max = java.lang.Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i3 > 0) {
                max = java.lang.Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = this.widget;
            int i4 = constraintWidget2.mMatchConstraintMaxHeight;
            max = java.lang.Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i4 > 0) {
                max = java.lang.Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    public final androidx.constraintlayout.solver.widgets.analyzer.DependencyNode getTarget(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (i == 2) {
            return constraintWidget.horizontalRun.end;
        }
        if (i == 3) {
            return constraintWidget.verticalRun.start;
        }
        if (i == 4) {
            return constraintWidget.verticalRun.baseline;
        }
        if (i != 5) {
            return null;
        }
        return constraintWidget.verticalRun.end;
    }

    public final androidx.constraintlayout.solver.widgets.analyzer.DependencyNode getTarget(androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, int i) {
        androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int i2 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }

    public long getWrapDimension() {
        if (this.dimension.resolved) {
            return r0.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.targets.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.start.targets.get(i2).run != this) {
                i++;
            }
        }
        int size2 = this.end.targets.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (this.end.targets.get(i3).run != this) {
                i++;
            }
        }
        return i >= 2;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
    }

    public void updateRunCenter(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor constraintAnchor2, int i) {
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target = getTarget(constraintAnchor);
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i2 = margin2 - margin;
            if (!this.dimension.resolved && this.dimensionBehavior == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i, i2);
            }
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency = this.dimension;
            if (dimensionDependency.resolved) {
                if (dimensionDependency.value == i2) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
                float horizontalBiasPercent = i == 0 ? constraintWidget.getHorizontalBiasPercent() : constraintWidget.getVerticalBiasPercent();
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (margin + 0.5f + (((margin2 - margin) - this.dimension.value) * horizontalBiasPercent)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }

    public void updateRunEnd(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
    }

    public void updateRunStart(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
    }

    public long wrapSize(int i) {
        int i2;
        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency = this.dimension;
        if (!dimensionDependency.resolved) {
            return 0L;
        }
        long j = dimensionDependency.value;
        if (isCenterConnection()) {
            i2 = this.start.margin - this.end.margin;
        } else {
            if (i != 0) {
                return j - this.end.margin;
            }
            i2 = this.start.margin;
        }
        return j + i2;
    }
}
