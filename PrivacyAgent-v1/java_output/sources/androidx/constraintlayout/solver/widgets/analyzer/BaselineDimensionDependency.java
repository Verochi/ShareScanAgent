package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
class BaselineDimensionDependency extends androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency {
    public BaselineDimensionDependency(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode) {
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = this.run;
        ((androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) widgetRun).baseline.margin = widgetRun.widget.getBaselineDistance();
        this.resolved = true;
    }
}
