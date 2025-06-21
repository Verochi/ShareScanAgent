package androidx.constraintlayout.solver.widgets.analyzer;

/* loaded from: classes.dex */
public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer container;
    private androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer mContainer;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> mRuns = new java.util.ArrayList<>();
    private java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.RunGroup> runGroups = new java.util.ArrayList<>();
    private androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer mMeasurer = null;
    private androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure mMeasure = new androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure();
    java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.RunGroup> mGroups = new java.util.ArrayList<>();

    public DependencyGraph(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode, int i, int i2, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2, java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.RunGroup> arrayList, androidx.constraintlayout.solver.widgets.analyzer.RunGroup runGroup) {
        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun) {
                return;
            }
            if (runGroup == null) {
                runGroup = new androidx.constraintlayout.solver.widgets.analyzer.RunGroup(widgetRun, i2);
                arrayList.add(runGroup);
            }
            widgetRun.runGroup = runGroup;
            runGroup.add(widgetRun);
            for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency : widgetRun.start.dependencies) {
                if (dependency instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                    applyGroup((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency, i, 0, dependencyNode2, arrayList, runGroup);
                }
            }
            for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency2 : widgetRun.end.dependencies) {
                if (dependency2 instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                    applyGroup((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, runGroup);
                }
            }
            if (i == 1 && (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun)) {
                for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency3 : ((androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) widgetRun).baseline.dependencies) {
                    if (dependency3 instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                        applyGroup((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
            for (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode3 : widgetRun.start.targets) {
                if (dependencyNode3 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode3, i, 0, dependencyNode2, arrayList, runGroup);
            }
            for (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode4 : widgetRun.end.targets) {
                if (dependencyNode4 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode4, i, 1, dependencyNode2, arrayList, runGroup);
            }
            if (i == 1 && (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun)) {
                java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> it = ((androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) widgetRun).baseline.targets.iterator();
                while (it.hasNext()) {
                    applyGroup(it.next(), i, 2, dependencyNode2, arrayList, runGroup);
                }
            }
        }
    }

    private boolean basicMeasureWidgets(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
        int i;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = next.mListDimensionBehaviors;
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr2[0];
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr2[1];
            if (next.getVisibility() == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour7 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour8 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > 0.0f) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour7 == dimensionBehaviour9 && (dimensionBehaviour8 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour8 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour8 == dimensionBehaviour9 && (dimensionBehaviour7 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour7 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour9 && dimensionBehaviour8 == dimensionBehaviour9) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour7 == dimensionBehaviour10 && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = dimensionBehaviour7;
                if (dimensionBehaviour8 == dimensionBehaviour10 && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = dimensionBehaviour8;
                androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour11;
                int i3 = next.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = i3;
                androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour12;
                int i4 = next.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = i4;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour11 == dimensionBehaviour13 || dimensionBehaviour11 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour11 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour12 == dimensionBehaviour13 || dimensionBehaviour12 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour12 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int width = next.getWidth();
                    if (dimensionBehaviour11 == dimensionBehaviour13) {
                        i = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i = width;
                        dimensionBehaviour = dimensionBehaviour11;
                    }
                    int height = next.getHeight();
                    if (dimensionBehaviour12 == dimensionBehaviour13) {
                        i2 = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i2 = height;
                        dimensionBehaviour2 = dimensionBehaviour12;
                    }
                    measure(next, dimensionBehaviour, i, dimensionBehaviour2, i2);
                    next.horizontalRun.dimension.resolve(next.getWidth());
                    next.verticalRun.dimension.resolve(next.getHeight());
                    next.measured = true;
                } else {
                    if (dimensionBehaviour11 == dimensionBehaviour10 && (dimensionBehaviour12 == (dimensionBehaviour6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour12 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i3 == 3) {
                            if (dimensionBehaviour12 == dimensionBehaviour6) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                            }
                            int height2 = next.getHeight();
                            int i5 = (int) ((height2 * next.mDimensionRatio) + 0.5f);
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour14, i5, dimensionBehaviour14, height2);
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i3 == 1) {
                            measure(next, dimensionBehaviour6, 0, dimensionBehaviour12, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                        } else if (i3 == 2) {
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = constraintWidgetContainer.mListDimensionBehaviors[0];
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour15 == dimensionBehaviour16 || dimensionBehaviour15 == dimensionBehaviour13) {
                                measure(next, dimensionBehaviour16, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour12, next.getHeight());
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour12, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour12 == dimensionBehaviour10 && (dimensionBehaviour11 == (dimensionBehaviour5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour11 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i4 == 3) {
                            if (dimensionBehaviour11 == dimensionBehaviour5) {
                                measure(next, dimensionBehaviour5, 0, dimensionBehaviour5, 0);
                            }
                            int width2 = next.getWidth();
                            float f = next.mDimensionRatio;
                            if (next.getDimensionRatioSide() == -1) {
                                f = 1.0f / f;
                            }
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour17, width2, dimensionBehaviour17, (int) ((width2 * f) + 0.5f));
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i4 == 1) {
                            measure(next, dimensionBehaviour11, 0, dimensionBehaviour5, 0);
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i4 == 2) {
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = constraintWidgetContainer.mListDimensionBehaviors[1];
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour18 == dimensionBehaviour19 || dimensionBehaviour18 == dimensionBehaviour13) {
                                measure(next, dimensionBehaviour11, next.getWidth(), dimensionBehaviour19, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                measure(next, dimensionBehaviour5, 0, dimensionBehaviour12, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour11 == dimensionBehaviour10 && dimensionBehaviour12 == dimensionBehaviour10) {
                        if (i3 == 1 || i4 == 1) {
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            measure(next, dimensionBehaviour20, 0, dimensionBehaviour20, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i4 == 2 && i3 == 2 && ((dimensionBehaviour3 = (dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors)[0]) == (dimensionBehaviour4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED) || dimensionBehaviour3 == dimensionBehaviour4)) {
                            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour21 = dimensionBehaviourArr[1];
                            if (dimensionBehaviour21 == dimensionBehaviour4 || dimensionBehaviour21 == dimensionBehaviour4) {
                                measure(next, dimensionBehaviour4, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour4, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int computeWrap(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, int i) {
        int size = this.mGroups.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j = java.lang.Math.max(j, this.mGroups.get(i2).computeWrapSize(constraintWidgetContainer, i));
        }
        return (int) j;
    }

    private void displayGraph() {
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = this.mRuns.iterator();
        java.lang.String str = "digraph {\n";
        while (it.hasNext()) {
            str = generateDisplayGraph(it.next(), str);
        }
        java.lang.String str2 = str + "\n}\n";
        java.lang.System.out.println("content:<<\n" + str2 + "\n>>");
    }

    private void findGroup(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun, int i, java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.RunGroup> arrayList) {
        for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency : widgetRun.start.dependencies) {
            if (dependency instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                applyGroup((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) {
                applyGroup(((androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency2 : widgetRun.end.dependencies) {
            if (dependency2 instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                applyGroup((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) {
                applyGroup(((androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i == 1) {
            for (androidx.constraintlayout.solver.widgets.analyzer.Dependency dependency3 : ((androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (dependency3 instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) {
                    applyGroup((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) dependency3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    private java.lang.String generateChainDisplayGraph(androidx.constraintlayout.solver.widgets.analyzer.ChainRun chainRun, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        int i = chainRun.orientation;
        java.lang.String str4 = "cluster_" + chainRun.widget.getDebugName();
        if (i == 0) {
            str2 = str4 + "_h";
        } else {
            str2 = str4 + "_v";
        }
        java.lang.String str5 = "subgraph " + str2 + " {\n";
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = chainRun.widgets.iterator();
        java.lang.String str6 = "";
        while (it.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next = it.next();
            java.lang.String debugName = next.widget.getDebugName();
            if (i == 0) {
                str3 = debugName + "_HORIZONTAL";
            } else {
                str3 = debugName + "_VERTICAL";
            }
            str5 = str5 + str3 + ";\n";
            str6 = generateDisplayGraph(next, str6);
        }
        return str + str6 + (str5 + "}\n");
    }

    private java.lang.String generateDisplayGraph(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun, java.lang.String str) {
        boolean z;
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode = widgetRun.start;
        androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 = widgetRun.end;
        if (!(widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HelperReferences) && dependencyNode.dependencies.isEmpty() && (dependencyNode2.dependencies.isEmpty() && dependencyNode.targets.isEmpty()) && dependencyNode2.targets.isEmpty()) {
            return str;
        }
        java.lang.String str2 = str + nodeDefinition(widgetRun);
        boolean isCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
        java.lang.String generateDisplayNode = generateDisplayNode(dependencyNode2, isCenteredConnection, generateDisplayNode(dependencyNode, isCenteredConnection, str2));
        boolean z2 = widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
        if (z2) {
            generateDisplayNode = generateDisplayNode(((androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) widgetRun).baseline, isCenteredConnection, generateDisplayNode);
        }
        if ((widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun) || (((z = widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun)) && ((androidx.constraintlayout.solver.widgets.analyzer.ChainRun) widgetRun).orientation == 0)) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
            if (horizontalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED || horizontalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n");
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n");
                }
            } else if (horizontalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                widgetRun.widget.getDebugName();
            }
        } else if (z2 || (z && ((androidx.constraintlayout.solver.widgets.analyzer.ChainRun) widgetRun).orientation == 1)) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour();
            if (verticalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED || verticalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n");
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n");
                }
            } else if (verticalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                widgetRun.widget.getDebugName();
            }
        }
        return widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun ? generateChainDisplayGraph((androidx.constraintlayout.solver.widgets.analyzer.ChainRun) widgetRun, generateDisplayNode) : generateDisplayNode;
    }

    private java.lang.String generateDisplayNode(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode, boolean z, java.lang.String str) {
        for (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2 : dependencyNode.targets) {
            java.lang.String str2 = ("\n" + dependencyNode.name()) + " -> " + dependencyNode2.name();
            if (dependencyNode.margin > 0 || z || (dependencyNode.run instanceof androidx.constraintlayout.solver.widgets.analyzer.HelperReferences)) {
                java.lang.String str3 = str2 + "[";
                if (dependencyNode.margin > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.margin + "\"";
                    if (z) {
                        str3 = str3 + ",";
                    }
                }
                if (z) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.run instanceof androidx.constraintlayout.solver.widgets.analyzer.HelperReferences) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            str = str + (str2 + "\n");
        }
        return str;
    }

    private boolean isCenteredConnection(androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode, androidx.constraintlayout.solver.widgets.analyzer.DependencyNode dependencyNode2) {
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> it = dependencyNode.targets.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() != dependencyNode2) {
                i++;
            }
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> it2 = dependencyNode2.targets.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (it2.next() != dependencyNode) {
                i2++;
            }
        }
        return i > 0 && i2 > 0;
    }

    private void measure(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private java.lang.String nodeDefinition(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun widgetRun) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        boolean z = widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
        java.lang.String debugName = widgetRun.widget.getDebugName();
        androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = widgetRun.widget;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = !z ? constraintWidget.getHorizontalDimensionBehaviour() : constraintWidget.getVerticalDimensionBehaviour();
        androidx.constraintlayout.solver.widgets.analyzer.RunGroup runGroup = widgetRun.runGroup;
        if (z) {
            str = debugName + "_VERTICAL";
        } else {
            str = debugName + "_HORIZONTAL";
        }
        java.lang.String str5 = ((str + " [shape=none, label=<") + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">") + "  <TR>";
        if (z) {
            java.lang.String str6 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str6 = str6 + " BGCOLOR=\"green\"";
            }
            str2 = str6 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        } else {
            java.lang.String str7 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str7 = str7 + " BGCOLOR=\"green\"";
            }
            str2 = str7 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        }
        java.lang.String str8 = str2 + "    <TD BORDER=\"1\" ";
        boolean z2 = widgetRun.dimension.resolved;
        if (z2 && !widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"green\" ";
        } else if (z2 && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"lightgray\" ";
        } else if (!z2 && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"yellow\" ";
        }
        if (horizontalDimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            str8 = str8 + "style=\"dashed\"";
        }
        if (runGroup != null) {
            str3 = " [" + (runGroup.groupIndex + 1) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + androidx.constraintlayout.solver.widgets.analyzer.RunGroup.index + "]";
        } else {
            str3 = "";
        }
        java.lang.String str9 = str8 + ">" + debugName + str3 + " </TD>";
        if (z) {
            java.lang.String str10 = str9 + "    <TD ";
            if ((widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) && ((androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun) widgetRun).baseline.resolved) {
                str10 = str10 + " BGCOLOR=\"green\"";
            }
            java.lang.String str11 = (str10 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>") + "    <TD ";
            if (widgetRun.end.resolved) {
                str11 = str11 + " BGCOLOR=\"green\"";
            }
            str4 = str11 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        } else {
            java.lang.String str12 = str9 + "    <TD ";
            if (widgetRun.end.resolved) {
                str12 = str12 + " BGCOLOR=\"green\"";
            }
            str4 = str12 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
        }
        return (str4 + "  </TR></TABLE>") + ">];\n";
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        androidx.constraintlayout.solver.widgets.analyzer.RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> arrayList) {
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = this.mContainer.mChildren.iterator();
        java.util.HashSet hashSet = null;
        while (it.hasNext()) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
            if (next instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                arrayList.add(new androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new androidx.constraintlayout.solver.widgets.analyzer.ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new java.util.HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new androidx.constraintlayout.solver.widgets.analyzer.ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new java.util.HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof androidx.constraintlayout.solver.widgets.HelperWidget) {
                    arrayList.add(new androidx.constraintlayout.solver.widgets.analyzer.HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next2 = it3.next();
            if (next2.widget != this.mContainer) {
                next2.apply();
            }
        }
    }

    public void defineTerminalWidgets(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.mNeedBuildGraph) {
            buildGraph();
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = this.container.mChildren.iterator();
            boolean z = false;
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.RunGroup> it2 = this.mGroups.iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.solver.widgets.analyzer.RunGroup next2 = it2.next();
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                next2.defineTerminalWidgets(dimensionBehaviour == dimensionBehaviour3, dimensionBehaviour2 == dimensionBehaviour3);
            }
        }
    }

    public boolean directMeasure(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = z & true;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.horizontalRun.reset();
                next.verticalRun.reset();
            }
            this.container.ensureWidgetRuns();
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.horizontalRun.reset();
            this.container.verticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x = this.container.getX();
        int y = this.container.getY();
        this.container.horizontalRun.start.resolve(x);
        this.container.verticalRun.start.resolve(y);
        measureWidgets();
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z4) {
                java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it2 = this.mRuns.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().supportsWrapComputation()) {
                        z4 = false;
                        break;
                    }
                }
            }
            if (z4 && dimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setHorizontalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.horizontalRun.dimension.resolve(constraintWidgetContainer3.getWidth());
            }
            if (z4 && dimensionBehaviour2 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
                constraintWidgetContainer5.verticalRun.dimension.resolve(constraintWidgetContainer5.getHeight());
            }
        }
        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer6.mListDimensionBehaviors[0];
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour4 == dimensionBehaviour5 || dimensionBehaviour4 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int width = constraintWidgetContainer6.getWidth() + x;
            this.container.horizontalRun.end.resolve(width);
            this.container.horizontalRun.dimension.resolve(width - x);
            measureWidgets();
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer7 = this.container;
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = constraintWidgetContainer7.mListDimensionBehaviors[1];
            if (dimensionBehaviour6 == dimensionBehaviour5 || dimensionBehaviour6 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer7.getHeight() + y;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y);
            }
            measureWidgets();
            z2 = true;
        } else {
            z2 = false;
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it3 = this.mRuns.iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next2 = it3.next();
            if (next2.widget != this.container || next2.resolved) {
                next2.applyToWidget();
            }
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it4 = this.mRuns.iterator();
        while (it4.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next3 = it4.next();
            if (z2 || next3.widget != this.container) {
                if (!next3.start.resolved || ((!next3.end.resolved && !(next3 instanceof androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference)) || (!next3.dimension.resolved && !(next3 instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun) && !(next3 instanceof androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference)))) {
                    z3 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z3;
    }

    public boolean directMeasureSetup(boolean z) {
        if (this.mNeedBuildGraph) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimension.resolved = false;
                horizontalWidgetRun.resolved = false;
                horizontalWidgetRun.reset();
                androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimension.resolved = false;
                verticalWidgetRun.resolved = false;
                verticalWidgetRun.reset();
            }
            this.container.ensureWidgetRuns();
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
            horizontalWidgetRun2.dimension.resolved = false;
            horizontalWidgetRun2.resolved = false;
            horizontalWidgetRun2.reset();
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun verticalWidgetRun2 = this.container.verticalRun;
            verticalWidgetRun2.dimension.resolved = false;
            verticalWidgetRun2.resolved = false;
            verticalWidgetRun2.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        boolean z2;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z3 = true;
        boolean z4 = z & true;
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(0);
        androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = this.container.getDimensionBehaviour(1);
        int x = this.container.getX();
        int y = this.container.getY();
        if (z4 && (dimensionBehaviour2 == (dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it = this.mRuns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next = it.next();
                if (next.orientation == i && !next.supportsWrapComputation()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && dimensionBehaviour2 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer = this.container;
                    constraintWidgetContainer.setWidth(computeWrap(constraintWidgetContainer, 0));
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                    constraintWidgetContainer2.horizontalRun.dimension.resolve(constraintWidgetContainer2.getWidth());
                }
            } else if (z4 && dimensionBehaviour3 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.setHeight(computeWrap(constraintWidgetContainer3, 1));
                androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.verticalRun.dimension.resolve(constraintWidgetContainer4.getHeight());
            }
        }
        if (i == 0) {
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer5.mListDimensionBehaviors[0];
            if (dimensionBehaviour4 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = constraintWidgetContainer5.getWidth() + x;
                this.container.horizontalRun.end.resolve(width);
                this.container.horizontalRun.dimension.resolve(width - x);
                z2 = true;
            }
            z2 = false;
        } else {
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
            androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidgetContainer6.mListDimensionBehaviors[1];
            if (dimensionBehaviour5 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer6.getHeight() + y;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y);
                z2 = true;
            }
            z2 = false;
        }
        measureWidgets();
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it2 = this.mRuns.iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next2 = it2.next();
            if (next2.orientation == i && (next2.widget != this.container || next2.resolved)) {
                next2.applyToWidget();
            }
        }
        java.util.Iterator<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> it3 = this.mRuns.iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun next3 = it3.next();
            if (next3.orientation == i && (z2 || next3.widget != this.container)) {
                if (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun) && !next3.dimension.resolved)) {
                    z3 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z3;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency;
        java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
            if (!next.measured) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z = false;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i = next.mMatchConstraintDefaultWidth;
                int i2 = next.mMatchConstraintDefaultHeight;
                androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency2 = next.horizontalRun.dimension;
                boolean z3 = dimensionDependency2.resolved;
                androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency dimensionDependency3 = next.verticalRun.dimension;
                boolean z4 = dimensionDependency3.resolved;
                if (z3 && z4) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED;
                    measure(next, dimensionBehaviour4, dimensionDependency2.value, dimensionBehaviour4, dimensionDependency3.value);
                    next.measured = true;
                } else if (z3 && z) {
                    measure(next, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.value, dimensionBehaviour3, dimensionDependency3.value);
                    if (dimensionBehaviour2 == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    } else {
                        next.verticalRun.dimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z4 && z2) {
                    measure(next, dimensionBehaviour3, dimensionDependency2.value, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency3.value);
                    if (dimensionBehaviour == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                    } else {
                        next.horizontalRun.dimension.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (dimensionDependency = next.verticalRun.baselineDimension) != null) {
                    dimensionDependency.resolve(next.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }
}
