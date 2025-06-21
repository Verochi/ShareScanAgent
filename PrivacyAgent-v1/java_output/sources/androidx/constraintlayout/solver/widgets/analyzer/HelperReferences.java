package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
class HelperReferences extends androidx.constraintlayout.solver.widgets.analyzer.WidgetRun {
    public HelperReferences(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void addDependency(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode) {
        this.start.dependencies.add(dependencyNode);
        dependencyNode.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
            this.start.delegateToWidgetRun = true;
            androidx.constraintlayout.solver.widgets.Barrier barrier = (androidx.constraintlayout.solver.widgets.Barrier) constraintWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.allowsGoneWidget();
            int i = 0;
            if (barrierType == 0) {
                this.start.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.LEFT;
                while (i < barrier.mWidgetsCount) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget2 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = constraintWidget2.horizontalRun.start;
                        dependencyNode.dependencies.add(this.start);
                        this.start.targets.add(dependencyNode);
                    }
                    i++;
                }
                addDependency(this.widget.horizontalRun.start);
                addDependency(this.widget.horizontalRun.end);
                return;
            }
            if (barrierType == 1) {
                this.start.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.RIGHT;
                while (i < barrier.mWidgetsCount) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget3 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = constraintWidget3.horizontalRun.end;
                        dependencyNode2.dependencies.add(this.start);
                        this.start.targets.add(dependencyNode2);
                    }
                    i++;
                }
                addDependency(this.widget.horizontalRun.start);
                addDependency(this.widget.horizontalRun.end);
                return;
            }
            if (barrierType == 2) {
                this.start.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.TOP;
                while (i < barrier.mWidgetsCount) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget4 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode3 = constraintWidget4.verticalRun.start;
                        dependencyNode3.dependencies.add(this.start);
                        this.start.targets.add(dependencyNode3);
                    }
                    i++;
                }
                addDependency(this.widget.verticalRun.start);
                addDependency(this.widget.verticalRun.end);
                return;
            }
            if (barrierType != 3) {
                return;
            }
            this.start.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.BOTTOM;
            while (i < barrier.mWidgetsCount) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget5 = barrier.mWidgets[i];
                if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode4 = constraintWidget5.verticalRun.end;
                    dependencyNode4.dependencies.add(this.start);
                    this.start.targets.add(dependencyNode4);
                }
                i++;
            }
            addDependency(this.widget.verticalRun.start);
            addDependency(this.widget.verticalRun.end);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
            int barrierType = ((androidx.constraintlayout.solver.widgets.Barrier) constraintWidget).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.widget.setX(this.start.value);
            } else {
                this.widget.setY(this.start.value);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
        androidx.constraintlayout.solver.widgets.Barrier barrier = (androidx.constraintlayout.solver.widgets.Barrier) this.widget;
        int barrierType = barrier.getBarrierType();
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> it = this.start.targets.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = it.next().value;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            this.start.resolve(i2 + barrier.getMargin());
        } else {
            this.start.resolve(i + barrier.getMargin());
        }
    }
}
