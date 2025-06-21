package com.bumptech.glide.manager;

/* loaded from: classes.dex */
public class RequestManagerRetriever implements android.os.Handler.Callback {
    private static final com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory DEFAULT_FACTORY = new com.bumptech.glide.manager.RequestManagerRetriever.AnonymousClass1();
    private static final java.lang.String FRAGMENT_INDEX_KEY = "key";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final java.lang.String TAG = "RMRetriever";
    private volatile com.bumptech.glide.RequestManager applicationManager;
    private final com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory factory;
    private final android.os.Handler handler;

    @androidx.annotation.VisibleForTesting
    final java.util.Map<android.app.FragmentManager, com.bumptech.glide.manager.RequestManagerFragment> pendingRequestManagerFragments = new java.util.HashMap();

    @androidx.annotation.VisibleForTesting
    final java.util.Map<androidx.fragment.app.FragmentManager, com.bumptech.glide.manager.SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new java.util.HashMap();
    private final androidx.collection.ArrayMap<android.view.View, androidx.fragment.app.Fragment> tempViewToSupportFragment = new androidx.collection.ArrayMap<>();
    private final androidx.collection.ArrayMap<android.view.View, android.app.Fragment> tempViewToFragment = new androidx.collection.ArrayMap<>();
    private final android.os.Bundle tempBundle = new android.os.Bundle();

    /* renamed from: com.bumptech.glide.manager.RequestManagerRetriever$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory {
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.RequestManager build(@androidx.annotation.NonNull com.bumptech.glide.Glide glide, @androidx.annotation.NonNull com.bumptech.glide.manager.Lifecycle lifecycle, @androidx.annotation.NonNull com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, @androidx.annotation.NonNull android.content.Context context) {
            return new com.bumptech.glide.RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    public interface RequestManagerFactory {
        @androidx.annotation.NonNull
        com.bumptech.glide.RequestManager build(@androidx.annotation.NonNull com.bumptech.glide.Glide glide, @androidx.annotation.NonNull com.bumptech.glide.manager.Lifecycle lifecycle, @androidx.annotation.NonNull com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, @androidx.annotation.NonNull android.content.Context context);
    }

    public RequestManagerRetriever(@androidx.annotation.Nullable com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.handler = new android.os.Handler(android.os.Looper.getMainLooper(), this);
    }

    @android.annotation.TargetApi(17)
    private static void assertNotDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
        if (activity.isDestroyed()) {
            throw new java.lang.IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @androidx.annotation.Nullable
    private static android.app.Activity findActivity(@androidx.annotation.NonNull android.content.Context context) {
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        if (context instanceof android.content.ContextWrapper) {
            return findActivity(((android.content.ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @android.annotation.TargetApi(26)
    @java.lang.Deprecated
    private void findAllFragmentsWithViews(@androidx.annotation.NonNull android.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.collection.ArrayMap<android.view.View, android.app.Fragment> arrayMap) {
        java.util.List<android.app.Fragment> fragments;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            findAllFragmentsWithViewsPreO(fragmentManager, arrayMap);
            return;
        }
        fragments = fragmentManager.getFragments();
        for (android.app.Fragment fragment : fragments) {
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
            }
        }
    }

    @java.lang.Deprecated
    private void findAllFragmentsWithViewsPreO(@androidx.annotation.NonNull android.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.collection.ArrayMap<android.view.View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.tempBundle.putInt("key", i);
            try {
                fragment = fragmentManager.getFragment(this.tempBundle, "key");
            } catch (java.lang.Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
            }
            i = i2;
        }
    }

    private static void findAllSupportFragmentsWithViews(@androidx.annotation.Nullable java.util.Collection<androidx.fragment.app.Fragment> collection, @androidx.annotation.NonNull java.util.Map<android.view.View, androidx.fragment.app.Fragment> map) {
        if (collection == null) {
            return;
        }
        for (androidx.fragment.app.Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    private android.app.Fragment findFragment(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.app.Activity activity) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
        android.view.View findViewById = activity.findViewById(android.R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToFragment.get(view)) == null && (view.getParent() instanceof android.view.View)) {
            view = (android.view.View) view.getParent();
        }
        this.tempViewToFragment.clear();
        return fragment;
    }

    @androidx.annotation.Nullable
    private androidx.fragment.app.Fragment findSupportFragment(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        android.view.View findViewById = fragmentActivity.findViewById(android.R.id.content);
        androidx.fragment.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof android.view.View)) {
            view = (android.view.View) view.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return fragment;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    private com.bumptech.glide.RequestManager fragmentGet(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.app.FragmentManager fragmentManager, @androidx.annotation.Nullable android.app.Fragment fragment, boolean z) {
        com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment, z);
        com.bumptech.glide.RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        com.bumptech.glide.RequestManager build = this.factory.build(com.bumptech.glide.Glide.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
        requestManagerFragment.setRequestManager(build);
        return build;
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.RequestManager getApplicationManager(@androidx.annotation.NonNull android.content.Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = this.factory.build(com.bumptech.glide.Glide.get(context.getApplicationContext()), new com.bumptech.glide.manager.ApplicationLifecycle(), new com.bumptech.glide.manager.EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.applicationManager;
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.manager.RequestManagerFragment getRequestManagerFragment(@androidx.annotation.NonNull android.app.FragmentManager fragmentManager, @androidx.annotation.Nullable android.app.Fragment fragment, boolean z) {
        com.bumptech.glide.manager.RequestManagerFragment requestManagerFragment = (com.bumptech.glide.manager.RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment == null && (requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager)) == null) {
            requestManagerFragment = new com.bumptech.glide.manager.RequestManagerFragment();
            requestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                requestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
            this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.manager.SupportRequestManagerFragment getSupportRequestManagerFragment(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.Nullable androidx.fragment.app.Fragment fragment, boolean z) {
        com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = (com.bumptech.glide.manager.SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new com.bumptech.glide.manager.SupportRequestManagerFragment();
            supportRequestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                supportRequestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
            this.handler.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    private static boolean isActivityVisible(android.content.Context context) {
        android.app.Activity findActivity = findActivity(context);
        return findActivity == null || !findActivity.isFinishing();
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.RequestManager supportFragmentGet(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.Nullable androidx.fragment.app.Fragment fragment, boolean z) {
        com.bumptech.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(fragmentManager, fragment, z);
        com.bumptech.glide.RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        com.bumptech.glide.RequestManager build = this.factory.build(com.bumptech.glide.Glide.get(context), supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
        supportRequestManagerFragment.setRequestManager(build);
        return build;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.RequestManager get(@androidx.annotation.NonNull android.app.Activity activity) {
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        assertNotDestroyed(activity);
        return fragmentGet(activity, activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    @androidx.annotation.NonNull
    @android.annotation.TargetApi(17)
    @java.lang.Deprecated
    public com.bumptech.glide.RequestManager get(@androidx.annotation.NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.RequestManager get(@androidx.annotation.NonNull android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.util.Util.isOnMainThread() && !(context instanceof android.app.Application)) {
            if (context instanceof androidx.fragment.app.FragmentActivity) {
                return get((androidx.fragment.app.FragmentActivity) context);
            }
            if (context instanceof android.app.Activity) {
                return get((android.app.Activity) context);
            }
            if (context instanceof android.content.ContextWrapper) {
                android.content.ContextWrapper contextWrapper = (android.content.ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return get(contextWrapper.getBaseContext());
                }
            }
        }
        return getApplicationManager(context);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.RequestManager get(@androidx.annotation.NonNull android.view.View view) {
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        com.bumptech.glide.util.Preconditions.checkNotNull(view);
        com.bumptech.glide.util.Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        android.app.Activity findActivity = findActivity(view.getContext());
        if (findActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (!(findActivity instanceof androidx.fragment.app.FragmentActivity)) {
            android.app.Fragment findFragment = findFragment(view, findActivity);
            return findFragment == null ? get(findActivity) : get(findFragment);
        }
        androidx.fragment.app.FragmentActivity fragmentActivity = (androidx.fragment.app.FragmentActivity) findActivity;
        androidx.fragment.app.Fragment findSupportFragment = findSupportFragment(view, fragmentActivity);
        return findSupportFragment != null ? get(findSupportFragment) : get(fragmentActivity);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.RequestManager get(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        com.bumptech.glide.util.Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        return supportFragmentGet(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.RequestManager get(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        return supportFragmentGet(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, isActivityVisible(fragmentActivity));
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public com.bumptech.glide.manager.RequestManagerFragment getRequestManagerFragment(android.app.Activity activity) {
        return getRequestManagerFragment(activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.manager.SupportRequestManagerFragment getSupportRequestManagerFragment(android.content.Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return getSupportRequestManagerFragment(fragmentManager, null, isActivityVisible(context));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        java.lang.Object obj;
        android.content.ComponentCallbacks remove;
        java.lang.Object obj2;
        android.content.ComponentCallbacks componentCallbacks;
        int i = message.what;
        boolean z = true;
        if (i == 1) {
            obj = (android.app.FragmentManager) message.obj;
            remove = this.pendingRequestManagerFragments.remove(obj);
        } else {
            if (i != 2) {
                componentCallbacks = null;
                z = false;
                obj2 = null;
                if (z && componentCallbacks == null && android.util.Log.isLoggable(TAG, 5)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to remove expected request manager fragment, manager: ");
                    sb.append(obj2);
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.pendingSupportRequestManagerFragments.remove(obj);
        }
        android.content.ComponentCallbacks componentCallbacks2 = remove;
        obj2 = obj;
        componentCallbacks = componentCallbacks2;
        if (z) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Failed to remove expected request manager fragment, manager: ");
            sb2.append(obj2);
        }
        return z;
    }
}
