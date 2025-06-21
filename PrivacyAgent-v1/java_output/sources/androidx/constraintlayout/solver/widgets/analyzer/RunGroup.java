package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun firstRun;
    int groupIndex;
    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> runs = new java.util.ArrayList<>();

    public RunGroup(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun, int i) {
        this.firstRun = null;
        this.lastRun = null;
        int i2 = index;
        this.groupIndex = i2;
        index = i2 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i;
    }

    private boolean defineTerminalWidget(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun, int i) {
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode;
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun2;
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2;
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun3;
        if (!widgetRun.widget.isTerminalWidget[i]) {
            return false;
        }
        for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency : widgetRun.start.dependencies) {
            if ((dependency instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) && (widgetRun3 = (dependencyNode2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun) {
                    java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = ((androidx.constraintlayout.solver.widgets.analyzer.ChainRun) widgetRun).widgets.iterator();
                    while (it.hasNext()) {
                        defineTerminalWidget(it.next(), i);
                    }
                } else if (!(widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i] = false;
                }
                defineTerminalWidget(dependencyNode2.run, i);
            }
        }
        for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency2 : widgetRun.end.dependencies) {
            if ((dependency2 instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) && (widgetRun2 = (dependencyNode = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun) {
                    java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it2 = ((androidx.constraintlayout.solver.widgets.analyzer.ChainRun) widgetRun).widgets.iterator();
                    while (it2.hasNext()) {
                        defineTerminalWidget(it2.next(), i);
                    }
                } else if (!(widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i] = false;
                }
                defineTerminalWidget(dependencyNode.run, i);
            }
        }
        return false;
    }

    private long traverseEnd(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode, long j) {
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HelperReferences) {
            return j;
        }
        int size = dependencyNode.dependencies.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency = dependencyNode.dependencies.get(i);
            if (dependency instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j2 = java.lang.Math.min(j2, traverseEnd(dependencyNode2, dependencyNode2.margin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j2;
        }
        long wrapDimension = j - widgetRun.getWrapDimension();
        return java.lang.Math.min(java.lang.Math.min(j2, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
    }

    private long traverseStart(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode, long j) {
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HelperReferences) {
            return j;
        }
        int size = dependencyNode.dependencies.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency = dependencyNode.dependencies.get(i);
            if (dependency instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j2 = java.lang.Math.max(j2, traverseStart(dependencyNode2, dependencyNode2.margin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j2;
        }
        long wrapDimension = j + widgetRun.getWrapDimension();
        return java.lang.Math.max(java.lang.Math.max(j2, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
    }

    public void add(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, int i) {
        long wrapDimension;
        int i2;
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = this.firstRun;
        if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun) {
            if (((androidx.constraintlayout.solver.widgets.analyzer.ChainRun) widgetRun).orientation != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun)) {
            return 0L;
        }
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = (i == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = (i == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
        boolean contains = widgetRun.start.targets.contains(dependencyNode);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode2);
        long wrapDimension2 = this.firstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.firstRun.start, 0L);
            long traverseEnd = traverseEnd(this.firstRun.end, 0L);
            long j = traverseStart - wrapDimension2;
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun2 = this.firstRun;
            int i3 = widgetRun2.end.margin;
            if (j >= (-i3)) {
                j += i3;
            }
            int i4 = widgetRun2.start.margin;
            long j2 = ((-traverseEnd) - wrapDimension2) - i4;
            if (j2 >= i4) {
                j2 -= i4;
            }
            float biasPercent = widgetRun2.widget.getBiasPercent(i);
            float f = biasPercent > 0.0f ? (long) ((j2 / biasPercent) + (j / (1.0f - biasPercent))) : 0L;
            long j3 = ((long) ((f * biasPercent) + 0.5f)) + wrapDimension2 + ((long) ((f * (1.0f - biasPercent)) + 0.5f));
            wrapDimension = r13.start.margin + j3;
            i2 = this.firstRun.end.margin;
        } else {
            if (contains) {
                return java.lang.Math.max(traverseStart(this.firstRun.start, r13.margin), this.firstRun.start.margin + wrapDimension2);
            }
            if (contains2) {
                return java.lang.Math.max(-traverseEnd(this.firstRun.end, r13.margin), (-this.firstRun.end.margin) + wrapDimension2);
            }
            wrapDimension = r13.start.margin + this.firstRun.getWrapDimension();
            i2 = this.firstRun.end.margin;
        }
        return wrapDimension - i2;
    }

    public void defineTerminalWidgets(boolean z, boolean z2) {
        if (z) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z2) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun2 = this.firstRun;
            if (widgetRun2 instanceof androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
