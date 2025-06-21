package androidx.fragment.app;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    java.lang.CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    java.lang.CharSequence mBreadCrumbTitleText;
    private final java.lang.ClassLoader mClassLoader;
    java.util.ArrayList<java.lang.Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final androidx.fragment.app.FragmentFactory mFragmentFactory;

    @androidx.annotation.Nullable
    java.lang.String mName;
    java.util.ArrayList<androidx.fragment.app.FragmentTransaction.Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    java.util.ArrayList<java.lang.String> mSharedElementSourceNames;
    java.util.ArrayList<java.lang.String> mSharedElementTargetNames;
    int mTransition;

    public static final class Op {
        int mCmd;
        androidx.lifecycle.Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        androidx.fragment.app.Fragment mFragment;
        androidx.lifecycle.Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        public Op() {
        }

        public Op(int i, androidx.fragment.app.Fragment fragment) {
            this.mCmd = i;
            this.mFragment = fragment;
            androidx.lifecycle.Lifecycle.State state = androidx.lifecycle.Lifecycle.State.RESUMED;
            this.mOldMaxState = state;
            this.mCurrentMaxState = state;
        }

        public Op(int i, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, androidx.lifecycle.Lifecycle.State state) {
            this.mCmd = i;
            this.mFragment = fragment;
            this.mOldMaxState = fragment.mMaxState;
            this.mCurrentMaxState = state;
        }
    }

    @java.lang.Deprecated
    public FragmentTransaction() {
        this.mOps = new java.util.ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    public FragmentTransaction(@androidx.annotation.NonNull androidx.fragment.app.FragmentFactory fragmentFactory, @androidx.annotation.Nullable java.lang.ClassLoader classLoader) {
        this.mOps = new java.util.ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    @androidx.annotation.NonNull
    private androidx.fragment.app.Fragment createFragment(@androidx.annotation.NonNull java.lang.Class<? extends androidx.fragment.app.Fragment> cls, @androidx.annotation.Nullable android.os.Bundle bundle) {
        androidx.fragment.app.FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory == null) {
            throw new java.lang.IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        java.lang.ClassLoader classLoader = this.mClassLoader;
        if (classLoader == null) {
            throw new java.lang.IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        androidx.fragment.app.Fragment instantiate = fragmentFactory.instantiate(classLoader, cls.getName());
        if (bundle != null) {
            instantiate.setArguments(bundle);
        }
        return instantiate;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction add(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        doAddOp(i, fragment, null, 1);
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction add(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable java.lang.String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentTransaction add(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull java.lang.Class<? extends androidx.fragment.app.Fragment> cls, @androidx.annotation.Nullable android.os.Bundle bundle) {
        return add(i, createFragment(cls, bundle));
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentTransaction add(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull java.lang.Class<? extends androidx.fragment.app.Fragment> cls, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable java.lang.String str) {
        return add(i, createFragment(cls, bundle), str);
    }

    public androidx.fragment.app.FragmentTransaction add(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable java.lang.String str) {
        fragment.mContainer = viewGroup;
        return add(viewGroup.getId(), fragment, str);
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction add(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable java.lang.String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentTransaction add(@androidx.annotation.NonNull java.lang.Class<? extends androidx.fragment.app.Fragment> cls, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable java.lang.String str) {
        return add(createFragment(cls, bundle), str);
    }

    public void addOp(androidx.fragment.app.FragmentTransaction.Op op) {
        this.mOps.add(op);
        op.mEnterAnim = this.mEnterAnim;
        op.mExitAnim = this.mExitAnim;
        op.mPopEnterAnim = this.mPopEnterAnim;
        op.mPopExitAnim = this.mPopExitAnim;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction addSharedElement(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.String str) {
        if (androidx.fragment.app.FragmentTransition.supportsTransition()) {
            java.lang.String transitionName = androidx.core.view.ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new java.lang.IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new java.util.ArrayList<>();
                this.mSharedElementTargetNames = new java.util.ArrayList<>();
            } else {
                if (this.mSharedElementTargetNames.contains(str)) {
                    throw new java.lang.IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new java.lang.IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(str);
        }
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction addToBackStack(@androidx.annotation.Nullable java.lang.String str) {
        if (!this.mAllowAddToBackStack) {
            throw new java.lang.IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = str;
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction attach(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        addOp(new androidx.fragment.app.FragmentTransaction.Op(7, fragment));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction detach(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        addOp(new androidx.fragment.app.FragmentTransaction.Op(6, fragment));
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new java.lang.IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    public void doAddOp(int i, androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable java.lang.String str, int i2) {
        java.lang.Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !java.lang.reflect.Modifier.isPublic(modifiers) || (cls.isMemberClass() && !java.lang.reflect.Modifier.isStatic(modifiers))) {
            throw new java.lang.IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            java.lang.String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new java.lang.IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new java.lang.IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new java.lang.IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        addOp(new androidx.fragment.app.FragmentTransaction.Op(i2, fragment));
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction hide(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        addOp(new androidx.fragment.app.FragmentTransaction.Op(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction remove(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        addOp(new androidx.fragment.app.FragmentTransaction.Op(3, fragment));
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction replace(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return replace(i, fragment, (java.lang.String) null);
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction replace(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable java.lang.String str) {
        if (i == 0) {
            throw new java.lang.IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i, fragment, str, 2);
        return this;
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentTransaction replace(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull java.lang.Class<? extends androidx.fragment.app.Fragment> cls, @androidx.annotation.Nullable android.os.Bundle bundle) {
        return replace(i, cls, bundle, null);
    }

    @androidx.annotation.NonNull
    public final androidx.fragment.app.FragmentTransaction replace(@androidx.annotation.IdRes int i, @androidx.annotation.NonNull java.lang.Class<? extends androidx.fragment.app.Fragment> cls, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable java.lang.String str) {
        return replace(i, createFragment(cls, bundle), str);
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction runOnCommit(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new java.util.ArrayList<>();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentTransaction setBreadCrumbShortTitle(@androidx.annotation.StringRes int i) {
        this.mBreadCrumbShortTitleRes = i;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentTransaction setBreadCrumbShortTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentTransaction setBreadCrumbTitle(@androidx.annotation.StringRes int i) {
        this.mBreadCrumbTitleRes = i;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentTransaction setBreadCrumbTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction setCustomAnimations(@androidx.annotation.AnimRes @androidx.annotation.AnimatorRes int i, @androidx.annotation.AnimRes @androidx.annotation.AnimatorRes int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction setCustomAnimations(@androidx.annotation.AnimRes @androidx.annotation.AnimatorRes int i, @androidx.annotation.AnimRes @androidx.annotation.AnimatorRes int i2, @androidx.annotation.AnimRes @androidx.annotation.AnimatorRes int i3, @androidx.annotation.AnimRes @androidx.annotation.AnimatorRes int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction setMaxLifecycle(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.State state) {
        addOp(new androidx.fragment.app.FragmentTransaction.Op(10, fragment, state));
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction setPrimaryNavigationFragment(@androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        addOp(new androidx.fragment.app.FragmentTransaction.Op(8, fragment));
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction setReorderingAllowed(boolean z) {
        this.mReorderingAllowed = z;
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction setTransition(int i) {
        this.mTransition = i;
        return this;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.fragment.app.FragmentTransaction setTransitionStyle(@androidx.annotation.StyleRes int i) {
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentTransaction show(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        addOp(new androidx.fragment.app.FragmentTransaction.Op(5, fragment));
        return this;
    }
}
