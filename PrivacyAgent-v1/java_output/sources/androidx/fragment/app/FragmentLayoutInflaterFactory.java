package androidx.fragment.app;

/* loaded from: classes.dex */
class FragmentLayoutInflaterFactory implements android.view.LayoutInflater.Factory2 {
    private static final java.lang.String TAG = "FragmentManager";
    final androidx.fragment.app.FragmentManager mFragmentManager;

    /* renamed from: androidx.fragment.app.FragmentLayoutInflaterFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnAttachStateChangeListener {
        final /* synthetic */ androidx.fragment.app.FragmentStateManager val$fragmentStateManager;

        public AnonymousClass1(androidx.fragment.app.FragmentStateManager fragmentStateManager) {
            this.val$fragmentStateManager = fragmentStateManager;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            androidx.fragment.app.Fragment fragment = this.val$fragmentStateManager.getFragment();
            this.val$fragmentStateManager.moveToExpectedState();
            androidx.fragment.app.SpecialEffectsController.getOrCreateController((android.view.ViewGroup) fragment.mView.getParent(), androidx.fragment.app.FragmentLayoutInflaterFactory.this.mFragmentManager).forceCompleteAllOperations();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
        }
    }

    public FragmentLayoutInflaterFactory(androidx.fragment.app.FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory2
    @androidx.annotation.Nullable
    public android.view.View onCreateView(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        androidx.fragment.app.FragmentStateManager createOrGetFragmentStateManager;
        if (androidx.fragment.app.FragmentContainerView.class.getName().equals(str)) {
            return new androidx.fragment.app.FragmentContainerView(context, attributeSet, this.mFragmentManager);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        java.lang.String attributeValue = attributeSet.getAttributeValue(null, "class");
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.fragment.R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(androidx.fragment.R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(androidx.fragment.R.styleable.Fragment_android_id, -1);
        java.lang.String string = obtainStyledAttributes.getString(androidx.fragment.R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !androidx.fragment.app.FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new java.lang.IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        androidx.fragment.app.Fragment findFragmentById = resourceId != -1 ? this.mFragmentManager.findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = this.mFragmentManager.findFragmentByTag(string);
        }
        if (findFragmentById == null && id != -1) {
            findFragmentById = this.mFragmentManager.findFragmentById(id);
        }
        if (findFragmentById == null) {
            findFragmentById = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
            findFragmentById.mFromLayout = true;
            findFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
            findFragmentById.mContainerId = id;
            findFragmentById.mTag = string;
            findFragmentById.mInLayout = true;
            androidx.fragment.app.FragmentManager fragmentManager = this.mFragmentManager;
            findFragmentById.mFragmentManager = fragmentManager;
            findFragmentById.mHost = fragmentManager.getHost();
            findFragmentById.onInflate(this.mFragmentManager.getHost().getContext(), attributeSet, findFragmentById.mSavedFragmentState);
            createOrGetFragmentStateManager = this.mFragmentManager.addFragment(findFragmentById);
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Fragment ");
                sb.append(findFragmentById);
                sb.append(" has been inflated via the <fragment> tag: id=0x");
                sb.append(java.lang.Integer.toHexString(resourceId));
            }
        } else {
            if (findFragmentById.mInLayout) {
                throw new java.lang.IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + java.lang.Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + java.lang.Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            findFragmentById.mInLayout = true;
            androidx.fragment.app.FragmentManager fragmentManager2 = this.mFragmentManager;
            findFragmentById.mFragmentManager = fragmentManager2;
            findFragmentById.mHost = fragmentManager2.getHost();
            findFragmentById.onInflate(this.mFragmentManager.getHost().getContext(), attributeSet, findFragmentById.mSavedFragmentState);
            createOrGetFragmentStateManager = this.mFragmentManager.createOrGetFragmentStateManager(findFragmentById);
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Retained Fragment ");
                sb2.append(findFragmentById);
                sb2.append(" has been re-attached via the <fragment> tag: id=0x");
                sb2.append(java.lang.Integer.toHexString(resourceId));
            }
        }
        findFragmentById.mContainer = (android.view.ViewGroup) view;
        createOrGetFragmentStateManager.moveToExpectedState();
        createOrGetFragmentStateManager.ensureInflatedView();
        android.view.View view2 = findFragmentById.mView;
        if (view2 == null) {
            throw new java.lang.IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (findFragmentById.mView.getTag() == null) {
            findFragmentById.mView.setTag(string);
        }
        findFragmentById.mView.addOnAttachStateChangeListener(new androidx.fragment.app.FragmentLayoutInflaterFactory.AnonymousClass1(createOrGetFragmentStateManager));
        return findFragmentById.mView;
    }

    @Override // android.view.LayoutInflater.Factory
    @androidx.annotation.Nullable
    public android.view.View onCreateView(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
