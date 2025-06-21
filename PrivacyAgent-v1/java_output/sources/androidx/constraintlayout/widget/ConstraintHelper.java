package androidx.constraintlayout.widget;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends android.view.View {
    protected int mCount;
    protected androidx.constraintlayout.solver.widgets.Helper mHelperWidget;
    protected int[] mIds;
    private java.util.HashMap<java.lang.Integer, java.lang.String> mMap;
    protected java.lang.String mReferenceIds;
    protected java.lang.String mReferenceTags;
    protected boolean mUseViewMeasure;
    private android.view.View[] mViews;
    protected android.content.Context myContext;

    public ConstraintHelper(android.content.Context context) {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new java.util.HashMap<>();
        this.myContext = context;
        init(null);
    }

    public ConstraintHelper(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new java.util.HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public ConstraintHelper(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new java.util.HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    private void addID(java.lang.String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        java.lang.String trim = str.trim();
        if (getParent() instanceof androidx.constraintlayout.widget.ConstraintLayout) {
        }
        int findId = findId(trim);
        if (findId != 0) {
            this.mMap.put(java.lang.Integer.valueOf(findId), trim);
            addRscID(findId);
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Could not find id of \"");
            sb.append(trim);
            sb.append("\"");
        }
    }

    private void addRscID(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.mCount + 1;
        int[] iArr = this.mIds;
        if (i2 > iArr.length) {
            this.mIds = java.util.Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mIds;
        int i3 = this.mCount;
        iArr2[i3] = i;
        this.mCount = i3 + 1;
    }

    private void addTag(java.lang.String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        java.lang.String trim = str.trim();
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = getParent() instanceof androidx.constraintlayout.widget.ConstraintLayout ? (androidx.constraintlayout.widget.ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = constraintLayout.getChildAt(i);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) && trim.equals(((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("to use ConstraintTag view ");
                    sb.append(childAt.getClass().getSimpleName());
                    sb.append(" must have an ID");
                } else {
                    addRscID(childAt.getId());
                }
            }
        }
    }

    private int[] convertReferenceString(android.view.View view, java.lang.String str) {
        java.lang.String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i = 0;
        for (java.lang.String str2 : split) {
            int findId = findId(str2.trim());
            if (findId != 0) {
                iArr[i] = findId;
                i++;
            }
        }
        return i != split.length ? java.util.Arrays.copyOf(iArr, i) : iArr;
    }

    private int findId(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, java.lang.String str) {
        android.content.res.Resources resources;
        java.lang.String str2;
        if (str == null || constraintLayout == null || (resources = this.myContext.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (android.content.res.Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int findId(java.lang.String str) {
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = getParent() instanceof androidx.constraintlayout.widget.ConstraintLayout ? (androidx.constraintlayout.widget.ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            java.lang.Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof java.lang.Integer) {
                i = ((java.lang.Integer) designInformation).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = findId(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = androidx.constraintlayout.widget.R.id.class.getField(str).getInt(null);
            } catch (java.lang.Exception unused) {
            }
        }
        return i == 0 ? this.myContext.getResources().getIdentifier(str, "id", this.myContext.getPackageName()) : i;
    }

    public void addView(android.view.View view) {
        if (view == this || view.getId() == -1 || view.getParent() == null) {
            return;
        }
        this.mReferenceIds = null;
        addRscID(view.getId());
        requestLayout();
    }

    public void applyLayoutFeatures() {
        android.view.ViewParent parent = getParent();
        if (parent == null || !(parent instanceof androidx.constraintlayout.widget.ConstraintLayout)) {
            return;
        }
        applyLayoutFeatures((androidx.constraintlayout.widget.ConstraintLayout) parent);
    }

    public void applyLayoutFeatures(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.mCount; i++) {
            android.view.View viewById = constraintLayout.getViewById(this.mIds[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return java.util.Arrays.copyOf(this.mIds, this.mCount);
    }

    public android.view.View[] getViews(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        android.view.View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.mViews = new android.view.View[this.mCount];
        }
        for (int i = 0; i < this.mCount; i++) {
            this.mViews[i] = constraintLayout.getViewById(this.mIds[i]);
        }
        return this.mViews;
    }

    public void init(android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    java.lang.String string = obtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                } else if (index == androidx.constraintlayout.widget.R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    java.lang.String string2 = obtainStyledAttributes.getString(index);
                    this.mReferenceTags = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void loadParameters(androidx.constraintlayout.widget.ConstraintSet.Constraint constraint, androidx.constraintlayout.solver.widgets.HelperWidget helperWidget, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams, android.util.SparseArray<androidx.constraintlayout.solver.widgets.ConstraintWidget> sparseArray) {
        androidx.constraintlayout.widget.ConstraintSet.Layout layout = constraint.layout;
        int[] iArr = layout.mReferenceIds;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            java.lang.String str = layout.mReferenceIdString;
            if (str != null && str.length() > 0) {
                androidx.constraintlayout.widget.ConstraintSet.Layout layout2 = constraint.layout;
                layout2.mReferenceIds = convertReferenceString(this, layout2.mReferenceIdString);
            }
        }
        helperWidget.removeAllIds();
        if (constraint.layout.mReferenceIds == null) {
            return;
        }
        int i = 0;
        while (true) {
            int[] iArr2 = constraint.layout.mReferenceIds;
            if (i >= iArr2.length) {
                return;
            }
            androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = sparseArray.get(iArr2[i]);
            if (constraintWidget != null) {
                helperWidget.add(constraintWidget);
            }
            i++;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.String str = this.mReferenceIds;
        if (str != null) {
            setIds(str);
        }
        java.lang.String str2 = this.mReferenceTags;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mUseViewMeasure) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void removeView(android.view.View view) {
        int i;
        int id = view.getId();
        if (id == -1) {
            return;
        }
        this.mReferenceIds = null;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mCount) {
                break;
            }
            if (this.mIds[i2] == id) {
                while (true) {
                    i = this.mCount;
                    if (i2 >= i - 1) {
                        break;
                    }
                    int[] iArr = this.mIds;
                    int i3 = i2 + 1;
                    iArr[i2] = iArr[i3];
                    i2 = i3;
                }
                this.mIds[i - 1] = 0;
                this.mCount = i - 1;
            } else {
                i2++;
            }
        }
        requestLayout();
    }

    public void resolveRtl(androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget, boolean z) {
    }

    public void setIds(java.lang.String str) {
        this.mReferenceIds = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addID(str.substring(i));
                return;
            } else {
                addID(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(java.lang.String str) {
        this.mReferenceTags = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addTag(str.substring(i));
                return;
            } else {
                addTag(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i : iArr) {
            addRscID(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, java.lang.Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.mReferenceIds == null) {
            addRscID(i);
        }
    }

    public void updatePostConstraints(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.widgets.Helper helper, android.util.SparseArray<androidx.constraintlayout.solver.widgets.ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        for (int i = 0; i < this.mCount; i++) {
            helper.add(sparseArray.get(this.mIds[i]));
        }
    }

    public void updatePreLayout(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        java.lang.String str;
        int findId;
        if (isInEditMode()) {
            setIds(this.mReferenceIds);
        }
        androidx.constraintlayout.solver.widgets.Helper helper = this.mHelperWidget;
        if (helper == null) {
            return;
        }
        helper.removeAllIds();
        for (int i = 0; i < this.mCount; i++) {
            int i2 = this.mIds[i];
            android.view.View viewById = constraintLayout.getViewById(i2);
            if (viewById == null && (findId = findId(constraintLayout, (str = this.mMap.get(java.lang.Integer.valueOf(i2))))) != 0) {
                this.mIds[i] = findId;
                this.mMap.put(java.lang.Integer.valueOf(findId), str);
                viewById = constraintLayout.getViewById(findId);
            }
            if (viewById != null) {
                this.mHelperWidget.add(constraintLayout.getViewWidget(viewById));
            }
        }
        this.mHelperWidget.updateConstraints(constraintLayout.mLayoutWidget);
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) {
            ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams).widget = (androidx.constraintlayout.solver.widgets.ConstraintWidget) this.mHelperWidget;
        }
    }
}
