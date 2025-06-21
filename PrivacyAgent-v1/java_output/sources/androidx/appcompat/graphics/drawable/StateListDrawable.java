package androidx.appcompat.graphics.drawable;

@android.annotation.SuppressLint({"RestrictedAPI"})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class StateListDrawable extends androidx.appcompat.graphics.drawable.DrawableContainer {
    private static final boolean DEBUG = false;
    private static final java.lang.String TAG = "StateListDrawable";
    private boolean mMutated;
    private androidx.appcompat.graphics.drawable.StateListDrawable.StateListState mStateListState;

    public static class StateListState extends androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState {
        int[][] mStateSets;

        public StateListState(androidx.appcompat.graphics.drawable.StateListDrawable.StateListState stateListState, androidx.appcompat.graphics.drawable.StateListDrawable stateListDrawable, android.content.res.Resources resources) {
            super(stateListState, stateListDrawable, resources);
            if (stateListState != null) {
                this.mStateSets = stateListState.mStateSets;
            } else {
                this.mStateSets = new int[getCapacity()][];
            }
        }

        public int addStateSet(int[] iArr, android.graphics.drawable.Drawable drawable) {
            int addChild = addChild(drawable);
            this.mStateSets[addChild] = iArr;
            return addChild;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void growArray(int i, int i2) {
            super.growArray(i, i2);
            int[][] iArr = new int[i2][];
            java.lang.System.arraycopy(this.mStateSets, 0, iArr, 0, i);
            this.mStateSets = iArr;
        }

        public int indexOfStateSet(int[] iArr) {
            int[][] iArr2 = this.mStateSets;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (android.util.StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            int[][] iArr = this.mStateSets;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.mStateSets[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.mStateSets = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable() {
            return new androidx.appcompat.graphics.drawable.StateListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new androidx.appcompat.graphics.drawable.StateListDrawable(this, resources);
        }
    }

    public StateListDrawable() {
        this(null, null);
    }

    public StateListDrawable(@androidx.annotation.Nullable androidx.appcompat.graphics.drawable.StateListDrawable.StateListState stateListState) {
        if (stateListState != null) {
            setConstantState(stateListState);
        }
    }

    public StateListDrawable(androidx.appcompat.graphics.drawable.StateListDrawable.StateListState stateListState, android.content.res.Resources resources) {
        setConstantState(new androidx.appcompat.graphics.drawable.StateListDrawable.StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    private void inflateChildElements(android.content.Context context, android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        androidx.appcompat.graphics.drawable.StateListDrawable.StateListState stateListState = this.mStateListState;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.appcompat.resources.R.styleable.StateListDrawableItem);
                int resourceId = obtainAttributes.getResourceId(androidx.appcompat.resources.R.styleable.StateListDrawableItem_android_drawable, -1);
                android.graphics.drawable.Drawable drawable = resourceId > 0 ? androidx.appcompat.widget.ResourceManagerInternal.get().getDrawable(context, resourceId) : null;
                obtainAttributes.recycle();
                int[] extractStateSet = extractStateSet(attributeSet);
                if (drawable == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new org.xmlpull.v1.XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    drawable = android.graphics.drawable.Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                }
                stateListState.addStateSet(extractStateSet, drawable);
            }
        }
    }

    private void updateStateFromTypedArray(android.content.res.TypedArray typedArray) {
        androidx.appcompat.graphics.drawable.StateListDrawable.StateListState stateListState = this.mStateListState;
        stateListState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        stateListState.mVariablePadding = typedArray.getBoolean(androidx.appcompat.resources.R.styleable.StateListDrawable_android_variablePadding, stateListState.mVariablePadding);
        stateListState.mConstantSize = typedArray.getBoolean(androidx.appcompat.resources.R.styleable.StateListDrawable_android_constantSize, stateListState.mConstantSize);
        stateListState.mEnterFadeDuration = typedArray.getInt(androidx.appcompat.resources.R.styleable.StateListDrawable_android_enterFadeDuration, stateListState.mEnterFadeDuration);
        stateListState.mExitFadeDuration = typedArray.getInt(androidx.appcompat.resources.R.styleable.StateListDrawable_android_exitFadeDuration, stateListState.mExitFadeDuration);
        stateListState.mDither = typedArray.getBoolean(androidx.appcompat.resources.R.styleable.StateListDrawable_android_dither, stateListState.mDither);
    }

    public void addState(int[] iArr, android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.mStateListState.addStateSet(iArr, drawable);
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @androidx.annotation.RequiresApi(21)
    public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public androidx.appcompat.graphics.drawable.StateListDrawable.StateListState cloneConstantState() {
        return new androidx.appcompat.graphics.drawable.StateListDrawable.StateListState(this.mStateListState, this, null);
    }

    public int[] extractStateSet(android.util.AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return android.util.StateSet.trimStateSet(iArr, i);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    android.graphics.drawable.Drawable getStateDrawable(int i) {
        return this.mStateListState.getChild(i);
    }

    public int getStateDrawableIndex(int[] iArr) {
        return this.mStateListState.indexOfStateSet(iArr);
    }

    public androidx.appcompat.graphics.drawable.StateListDrawable.StateListState getStateListState() {
        return this.mStateListState;
    }

    int[] getStateSet(int i) {
        return this.mStateListState.mStateSets[i];
    }

    public void inflate(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.appcompat.resources.R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(androidx.appcompat.resources.R.styleable.StateListDrawable_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        updateDensity(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mStateListState.mutate();
            this.mMutated = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int indexOfStateSet = this.mStateListState.indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = this.mStateListState.indexOfStateSet(android.util.StateSet.WILD_CARD);
        }
        return selectDrawable(indexOfStateSet) || onStateChange;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(@androidx.annotation.NonNull androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof androidx.appcompat.graphics.drawable.StateListDrawable.StateListState) {
            this.mStateListState = (androidx.appcompat.graphics.drawable.StateListDrawable.StateListState) drawableContainerState;
        }
    }
}
