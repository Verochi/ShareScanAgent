package androidx.constraintlayout.solver.state;

/* loaded from: classes.dex */
public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final java.lang.Integer PARENT = 0;
    static final int UNKNOWN = -1;
    public final androidx.constraintlayout.solver.state.ConstraintReference mParent;
    private int numHelpers;
    protected java.util.HashMap<java.lang.Object, androidx.constraintlayout.solver.state.Reference> mReferences = new java.util.HashMap<>();
    protected java.util.HashMap<java.lang.Object, androidx.constraintlayout.solver.state.HelperReference> mHelperReferences = new java.util.HashMap<>();

    /* renamed from: androidx.constraintlayout.solver.state.State$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;

        static {
            int[] iArr = new int[androidx.constraintlayout.solver.state.State.Helper.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = iArr;
            try {
                iArr[androidx.constraintlayout.solver.state.State.Helper.HORIZONTAL_CHAIN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[androidx.constraintlayout.solver.state.State.Helper.VERTICAL_CHAIN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[androidx.constraintlayout.solver.state.State.Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[androidx.constraintlayout.solver.state.State.Helper.ALIGN_VERTICALLY.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Helper[androidx.constraintlayout.solver.state.State.Helper.BARRIER.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public State() {
        androidx.constraintlayout.solver.state.ConstraintReference constraintReference = new androidx.constraintlayout.solver.state.ConstraintReference(this);
        this.mParent = constraintReference;
        this.numHelpers = 0;
        this.mReferences.put(PARENT, constraintReference);
    }

    private java.lang.String createHelperKey() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("__HELPER_KEY_");
        int i = this.numHelpers;
        this.numHelpers = i + 1;
        sb.append(i);
        sb.append("__");
        return sb.toString();
    }

    public void apply(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.removeAllChildren();
        this.mParent.getWidth().apply(this, constraintWidgetContainer, 0);
        this.mParent.getHeight().apply(this, constraintWidgetContainer, 1);
        for (java.lang.Object obj : this.mHelperReferences.keySet()) {
            androidx.constraintlayout.solver.widgets.HelperWidget helperWidget = this.mHelperReferences.get(obj).getHelperWidget();
            if (helperWidget != null) {
                androidx.constraintlayout.solver.state.Reference reference = this.mReferences.get(obj);
                if (reference == null) {
                    reference = constraints(obj);
                }
                reference.setConstraintWidget(helperWidget);
            }
        }
        java.util.Iterator<java.lang.Object> it = this.mReferences.keySet().iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.solver.state.Reference reference2 = this.mReferences.get(it.next());
            if (reference2 != this.mParent) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = reference2.getConstraintWidget();
                constraintWidget.setParent(null);
                if (reference2 instanceof androidx.constraintlayout.solver.state.helpers.GuidelineReference) {
                    reference2.apply();
                }
                constraintWidgetContainer.add(constraintWidget);
            } else {
                reference2.setConstraintWidget(constraintWidgetContainer);
            }
        }
        java.util.Iterator<java.lang.Object> it2 = this.mHelperReferences.keySet().iterator();
        while (it2.hasNext()) {
            androidx.constraintlayout.solver.state.HelperReference helperReference = this.mHelperReferences.get(it2.next());
            if (helperReference.getHelperWidget() != null) {
                java.util.Iterator<java.lang.Object> it3 = helperReference.mReferences.iterator();
                while (it3.hasNext()) {
                    helperReference.getHelperWidget().add(this.mReferences.get(it3.next()).getConstraintWidget());
                }
                helperReference.apply();
            }
        }
        java.util.Iterator<java.lang.Object> it4 = this.mReferences.keySet().iterator();
        while (it4.hasNext()) {
            this.mReferences.get(it4.next()).apply();
        }
    }

    public androidx.constraintlayout.solver.state.helpers.BarrierReference barrier(java.lang.Object obj, androidx.constraintlayout.solver.state.State.Direction direction) {
        androidx.constraintlayout.solver.state.helpers.BarrierReference barrierReference = (androidx.constraintlayout.solver.state.helpers.BarrierReference) helper(obj, androidx.constraintlayout.solver.state.State.Helper.BARRIER);
        barrierReference.setBarrierDirection(direction);
        return barrierReference;
    }

    public androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference centerHorizontally(java.lang.Object... objArr) {
        androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference alignHorizontallyReference = (androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference) helper(null, androidx.constraintlayout.solver.state.State.Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objArr);
        return alignHorizontallyReference;
    }

    public androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference centerVertically(java.lang.Object... objArr) {
        androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference alignVerticallyReference = (androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference) helper(null, androidx.constraintlayout.solver.state.State.Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objArr);
        return alignVerticallyReference;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference constraints(java.lang.Object obj) {
        androidx.constraintlayout.solver.state.Reference reference = this.mReferences.get(obj);
        if (reference == null) {
            reference = createConstraintReference(obj);
            this.mReferences.put(obj, reference);
            reference.setKey(obj);
        }
        if (reference instanceof androidx.constraintlayout.solver.state.ConstraintReference) {
            return (androidx.constraintlayout.solver.state.ConstraintReference) reference;
        }
        return null;
    }

    public int convertDimension(java.lang.Object obj) {
        if (obj instanceof java.lang.Float) {
            return ((java.lang.Float) obj).intValue();
        }
        if (obj instanceof java.lang.Integer) {
            return ((java.lang.Integer) obj).intValue();
        }
        return 0;
    }

    public androidx.constraintlayout.solver.state.ConstraintReference createConstraintReference(java.lang.Object obj) {
        return new androidx.constraintlayout.solver.state.ConstraintReference(this);
    }

    public void directMapping() {
        for (java.lang.Object obj : this.mReferences.keySet()) {
            constraints(obj).setView(obj);
        }
    }

    public androidx.constraintlayout.solver.state.helpers.GuidelineReference guideline(java.lang.Object obj, int i) {
        androidx.constraintlayout.solver.state.Reference reference = this.mReferences.get(obj);
        androidx.constraintlayout.solver.state.Reference reference2 = reference;
        if (reference == null) {
            androidx.constraintlayout.solver.state.helpers.GuidelineReference guidelineReference = new androidx.constraintlayout.solver.state.helpers.GuidelineReference(this);
            guidelineReference.setOrientation(i);
            guidelineReference.setKey(obj);
            this.mReferences.put(obj, guidelineReference);
            reference2 = guidelineReference;
        }
        return (androidx.constraintlayout.solver.state.helpers.GuidelineReference) reference2;
    }

    public androidx.constraintlayout.solver.state.State height(androidx.constraintlayout.solver.state.Dimension dimension) {
        return setHeight(dimension);
    }

    public androidx.constraintlayout.solver.state.HelperReference helper(java.lang.Object obj, androidx.constraintlayout.solver.state.State.Helper helper) {
        androidx.constraintlayout.solver.state.HelperReference horizontalChainReference;
        if (obj == null) {
            obj = createHelperKey();
        }
        androidx.constraintlayout.solver.state.HelperReference helperReference = this.mHelperReferences.get(obj);
        if (helperReference == null) {
            int i = androidx.constraintlayout.solver.state.State.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[helper.ordinal()];
            if (i == 1) {
                horizontalChainReference = new androidx.constraintlayout.solver.state.helpers.HorizontalChainReference(this);
            } else if (i == 2) {
                horizontalChainReference = new androidx.constraintlayout.solver.state.helpers.VerticalChainReference(this);
            } else if (i == 3) {
                horizontalChainReference = new androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference(this);
            } else if (i == 4) {
                horizontalChainReference = new androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference(this);
            } else if (i != 5) {
                helperReference = new androidx.constraintlayout.solver.state.HelperReference(this, helper);
                this.mHelperReferences.put(obj, helperReference);
            } else {
                horizontalChainReference = new androidx.constraintlayout.solver.state.helpers.BarrierReference(this);
            }
            helperReference = horizontalChainReference;
            this.mHelperReferences.put(obj, helperReference);
        }
        return helperReference;
    }

    public androidx.constraintlayout.solver.state.helpers.HorizontalChainReference horizontalChain(java.lang.Object... objArr) {
        androidx.constraintlayout.solver.state.helpers.HorizontalChainReference horizontalChainReference = (androidx.constraintlayout.solver.state.helpers.HorizontalChainReference) helper(null, androidx.constraintlayout.solver.state.State.Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objArr);
        return horizontalChainReference;
    }

    public androidx.constraintlayout.solver.state.helpers.GuidelineReference horizontalGuideline(java.lang.Object obj) {
        return guideline(obj, 0);
    }

    public void map(java.lang.Object obj, java.lang.Object obj2) {
        constraints(obj).setView(obj2);
    }

    public androidx.constraintlayout.solver.state.Reference reference(java.lang.Object obj) {
        return this.mReferences.get(obj);
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public androidx.constraintlayout.solver.state.State setHeight(androidx.constraintlayout.solver.state.Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    public androidx.constraintlayout.solver.state.State setWidth(androidx.constraintlayout.solver.state.Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public androidx.constraintlayout.solver.state.helpers.VerticalChainReference verticalChain(java.lang.Object... objArr) {
        androidx.constraintlayout.solver.state.helpers.VerticalChainReference verticalChainReference = (androidx.constraintlayout.solver.state.helpers.VerticalChainReference) helper(null, androidx.constraintlayout.solver.state.State.Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objArr);
        return verticalChainReference;
    }

    public androidx.constraintlayout.solver.state.helpers.GuidelineReference verticalGuideline(java.lang.Object obj) {
        return guideline(obj, 1);
    }

    public androidx.constraintlayout.solver.state.State width(androidx.constraintlayout.solver.state.Dimension dimension) {
        return setWidth(dimension);
    }
}
