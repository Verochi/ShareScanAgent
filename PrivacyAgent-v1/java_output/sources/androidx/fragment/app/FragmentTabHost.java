package androidx.fragment.app;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends android.widget.TabHost implements android.widget.TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private android.content.Context mContext;
    private androidx.fragment.app.FragmentManager mFragmentManager;
    private androidx.fragment.app.FragmentTabHost.TabInfo mLastTab;
    private android.widget.TabHost.OnTabChangeListener mOnTabChangeListener;
    private android.widget.FrameLayout mRealTabContent;
    private final java.util.ArrayList<androidx.fragment.app.FragmentTabHost.TabInfo> mTabs;

    public static class DummyTabFactory implements android.widget.TabHost.TabContentFactory {
        private final android.content.Context mContext;

        public DummyTabFactory(android.content.Context context) {
            this.mContext = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public android.view.View createTabContent(java.lang.String str) {
            android.view.View view = new android.view.View(this.mContext);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    public static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.fragment.app.FragmentTabHost.SavedState> CREATOR = new androidx.fragment.app.FragmentTabHost.SavedState.AnonymousClass1();
        java.lang.String curTab;

        /* renamed from: androidx.fragment.app.FragmentTabHost$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.fragment.app.FragmentTabHost.SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.fragment.app.FragmentTabHost.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.fragment.app.FragmentTabHost.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.fragment.app.FragmentTabHost.SavedState[] newArray(int i) {
                return new androidx.fragment.app.FragmentTabHost.SavedState[i];
            }
        }

        public SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return "FragmentTabHost.SavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " curTab=" + this.curTab + com.alipay.sdk.m.u.i.d;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.curTab);
        }
    }

    public static final class TabInfo {

        @androidx.annotation.Nullable
        final android.os.Bundle args;

        @androidx.annotation.NonNull
        final java.lang.Class<?> clss;
        androidx.fragment.app.Fragment fragment;

        @androidx.annotation.NonNull
        final java.lang.String tag;

        public TabInfo(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.Nullable android.os.Bundle bundle) {
            this.tag = str;
            this.clss = cls;
            this.args = bundle;
        }
    }

    @java.lang.Deprecated
    public FragmentTabHost(@androidx.annotation.NonNull android.content.Context context) {
        super(context, null);
        this.mTabs = new java.util.ArrayList<>();
        initFragmentTabHost(context, null);
    }

    @java.lang.Deprecated
    public FragmentTabHost(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabs = new java.util.ArrayList<>();
        initFragmentTabHost(context, attributeSet);
    }

    @androidx.annotation.Nullable
    private androidx.fragment.app.FragmentTransaction doTabChanged(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable androidx.fragment.app.FragmentTransaction fragmentTransaction) {
        androidx.fragment.app.Fragment fragment;
        androidx.fragment.app.FragmentTabHost.TabInfo tabInfoForTag = getTabInfoForTag(str);
        if (this.mLastTab != tabInfoForTag) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            androidx.fragment.app.FragmentTabHost.TabInfo tabInfo = this.mLastTab;
            if (tabInfo != null && (fragment = tabInfo.fragment) != null) {
                fragmentTransaction.detach(fragment);
            }
            if (tabInfoForTag != null) {
                androidx.fragment.app.Fragment fragment2 = tabInfoForTag.fragment;
                if (fragment2 == null) {
                    androidx.fragment.app.Fragment instantiate = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), tabInfoForTag.clss.getName());
                    tabInfoForTag.fragment = instantiate;
                    instantiate.setArguments(tabInfoForTag.args);
                    fragmentTransaction.add(this.mContainerId, tabInfoForTag.fragment, tabInfoForTag.tag);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.mLastTab = tabInfoForTag;
        }
        return fragmentTransaction;
    }

    private void ensureContent() {
        if (this.mRealTabContent == null) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(this.mContainerId);
            this.mRealTabContent = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new java.lang.IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
        }
    }

    private void ensureHierarchy(android.content.Context context) {
        if (findViewById(android.R.id.tabs) == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            android.widget.TabWidget tabWidget = new android.widget.TabWidget(context);
            tabWidget.setId(android.R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0f));
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
            frameLayout.setId(android.R.id.tabcontent);
            linearLayout.addView(frameLayout, new android.widget.LinearLayout.LayoutParams(0, 0, 0.0f));
            android.widget.FrameLayout frameLayout2 = new android.widget.FrameLayout(context);
            this.mRealTabContent = frameLayout2;
            frameLayout2.setId(this.mContainerId);
            linearLayout.addView(frameLayout2, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @androidx.annotation.Nullable
    private androidx.fragment.app.FragmentTabHost.TabInfo getTabInfoForTag(java.lang.String str) {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.FragmentTabHost.TabInfo tabInfo = this.mTabs.get(i);
            if (tabInfo.tag.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }

    private void initFragmentTabHost(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.inflatedId}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @java.lang.Deprecated
    public void addTab(@androidx.annotation.NonNull android.widget.TabHost.TabSpec tabSpec, @androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.Nullable android.os.Bundle bundle) {
        tabSpec.setContent(new androidx.fragment.app.FragmentTabHost.DummyTabFactory(this.mContext));
        java.lang.String tag = tabSpec.getTag();
        androidx.fragment.app.FragmentTabHost.TabInfo tabInfo = new androidx.fragment.app.FragmentTabHost.TabInfo(tag, cls, bundle);
        if (this.mAttached) {
            androidx.fragment.app.Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(tag);
            tabInfo.fragment = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                androidx.fragment.app.FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                beginTransaction.detach(tabInfo.fragment);
                beginTransaction.commit();
            }
        }
        this.mTabs.add(tabInfo);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    @java.lang.Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.String currentTabTag = getCurrentTabTag();
        int size = this.mTabs.size();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.FragmentTabHost.TabInfo tabInfo = this.mTabs.get(i);
            androidx.fragment.app.Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(tabInfo.tag);
            tabInfo.fragment = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                if (tabInfo.tag.equals(currentTabTag)) {
                    this.mLastTab = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.mFragmentManager.beginTransaction();
                    }
                    fragmentTransaction.detach(tabInfo.fragment);
                }
            }
        }
        this.mAttached = true;
        androidx.fragment.app.FragmentTransaction doTabChanged = doTabChanged(currentTabTag, fragmentTransaction);
        if (doTabChanged != null) {
            doTabChanged.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @java.lang.Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    @java.lang.Deprecated
    public void onRestoreInstanceState(@android.annotation.SuppressLint({"UnknownNullness"}) android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.fragment.app.FragmentTabHost.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.fragment.app.FragmentTabHost.SavedState savedState = (androidx.fragment.app.FragmentTabHost.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Override // android.view.View
    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public android.os.Parcelable onSaveInstanceState() {
        androidx.fragment.app.FragmentTabHost.SavedState savedState = new androidx.fragment.app.FragmentTabHost.SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @java.lang.Deprecated
    public void onTabChanged(@androidx.annotation.Nullable java.lang.String str) {
        androidx.fragment.app.FragmentTransaction doTabChanged;
        if (this.mAttached && (doTabChanged = doTabChanged(str, null)) != null) {
            doTabChanged.commit();
        }
        android.widget.TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @java.lang.Deprecated
    public void setOnTabChangedListener(@androidx.annotation.Nullable android.widget.TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @java.lang.Deprecated
    public void setup() {
        throw new java.lang.IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @java.lang.Deprecated
    public void setup(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        ensureContent();
    }

    @java.lang.Deprecated
    public void setup(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, int i) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i;
        ensureContent();
        this.mRealTabContent.setId(i);
        if (getId() == -1) {
            setId(android.R.id.tabhost);
        }
    }
}
