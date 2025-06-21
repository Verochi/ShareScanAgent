package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class DependencyNode implements androidx.constraintlayout.solver.widgets.analyzer.Dependency {
    int margin;
    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun run;
    public int value;
    public androidx.constraintlayout.solver.widgets.analyzer.Dependency updateDelegate = null;
    public boolean delegateToWidgetRun = false;
    public boolean readyToSolve = false;
    androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type type = androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.UNKNOWN;
    int marginFactor = 1;
    androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency marginDependency = null;
    public boolean resolved = false;
    java.util.List<androidx.constraintlayout.solver.widgets.analyzer.Dependency> dependencies = new java.util.ArrayList();
    java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> targets = new java.util.ArrayList();

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun) {
        this.run = widgetRun;
    }

    public void addDependency(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
        this.dependencies.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public java.lang.String name() {
        java.lang.String str;
        java.lang.String debugName = this.run.widget.getDebugName();
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type type = this.type;
        if (type == androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.LEFT || type == androidx.constraintlayout.solver.widgets.analyzer.DependencyNode.Type.RIGHT) {
            str = debugName + "_HORIZONTAL";
        } else {
            str = debugName + "_VERTICAL";
        }
        return str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.type.name();
    }

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

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.run.widget.getDebugName());
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb.append(this.type);
        sb.append("(");
        sb.append(this.resolved ? java.lang.Integer.valueOf(this.value) : "unresolved");
        sb.append(") <t=");
        sb.append(this.targets.size());
        sb.append(":d=");
        sb.append(this.dependencies.size());
        sb.append(">");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency) {
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> it = this.targets.iterator();
        while (it.hasNext()) {
            if (!it.next().resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency2 = this.updateDelegate;
        if (dependency2 != null) {
            dependency2.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.run.update(this);
            return;
        }
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = null;
        int i = 0;
        for (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 : this.targets) {
            if (!(dependencyNode2 instanceof androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency)) {
                i++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i == 1 && dependencyNode.resolved) {
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency = this.marginDependency;
            if (dimensionDependency != null) {
                if (!dimensionDependency.resolved) {
                    return;
                } else {
                    this.margin = this.marginFactor * dimensionDependency.value;
                }
            }
            resolve(dependencyNode.value + this.margin);
        }
        androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency3 = this.updateDelegate;
        if (dependency3 != null) {
            dependency3.update(this);
        }
    }
}
