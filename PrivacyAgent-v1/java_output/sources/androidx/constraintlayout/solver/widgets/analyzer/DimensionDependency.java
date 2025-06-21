package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
class DimensionDependency extends androidx.constraintlayout.solver.widgets.analyzer.DependencyNode {
    public int wrapValue;

    public DimensionDependency(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun) {
            this.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
    public void resolve(int i) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = i;
        for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency : this.dependencies) {
            dependency.update(dependency);
        }
    }
}
