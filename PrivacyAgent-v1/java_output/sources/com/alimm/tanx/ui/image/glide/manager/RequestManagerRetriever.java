package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
public class RequestManagerRetriever implements android.os.Handler.Callback {
    static final java.lang.String FRAGMENT_TAG = "com.alimm.tanx.ui.image.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever INSTANCE = new com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever();
    private static final java.lang.String TAG = "RMRetriever";
    private volatile com.alimm.tanx.ui.image.glide.RequestManager applicationManager;
    final java.util.Map<android.app.FragmentManager, com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment> pendingRequestManagerFragments = new java.util.HashMap();
    final java.util.Map<androidx.fragment.app.FragmentManager, com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new java.util.HashMap();
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper(), this);

    @android.annotation.TargetApi(17)
    private static void assertNotDestroyed(android.app.Activity activity) {
        if (activity.isDestroyed()) {
            throw new java.lang.IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever get() {
        return INSTANCE;
    }

    private com.alimm.tanx.ui.image.glide.RequestManager getApplicationManager(android.content.Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = new com.alimm.tanx.ui.image.glide.RequestManager(context.getApplicationContext(), new com.alimm.tanx.ui.image.glide.manager.ApplicationLifecycle(), new com.alimm.tanx.ui.image.glide.manager.EmptyRequestManagerTreeNode());
                }
            }
        }
        return this.applicationManager;
    }

    @android.annotation.TargetApi(11)
    public com.alimm.tanx.ui.image.glide.RequestManager fragmentGet(android.content.Context context, android.app.FragmentManager fragmentManager) {
        com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager);
        com.alimm.tanx.ui.image.glide.RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        com.alimm.tanx.ui.image.glide.RequestManager requestManager2 = new com.alimm.tanx.ui.image.glide.RequestManager(context, requestManagerFragment.getLifecycle(), requestManagerFragment.getRequestManagerTreeNode());
        requestManagerFragment.setRequestManager(requestManager2);
        return requestManager2;
    }

    @android.annotation.TargetApi(11)
    public com.alimm.tanx.ui.image.glide.RequestManager get(android.app.Activity activity) {
        if (com.alimm.tanx.ui.image.glide.util.Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        assertNotDestroyed(activity);
        return fragmentGet(activity, activity.getFragmentManager());
    }

    @android.annotation.TargetApi(17)
    public com.alimm.tanx.ui.image.glide.RequestManager get(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (com.alimm.tanx.ui.image.glide.util.Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager());
    }

    public com.alimm.tanx.ui.image.glide.RequestManager get(android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.alimm.tanx.ui.image.glide.util.Util.isOnMainThread() && !(context instanceof android.app.Application)) {
            if (context instanceof androidx.fragment.app.FragmentActivity) {
                return get((androidx.fragment.app.FragmentActivity) context);
            }
            if (context instanceof android.app.Activity) {
                return get((android.app.Activity) context);
            }
            if (context instanceof android.content.ContextWrapper) {
                return get(((android.content.ContextWrapper) context).getBaseContext());
            }
        }
        return getApplicationManager(context);
    }

    public com.alimm.tanx.ui.image.glide.RequestManager get(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (com.alimm.tanx.ui.image.glide.util.Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return supportFragmentGet(fragment.getActivity(), fragment.getChildFragmentManager());
    }

    public com.alimm.tanx.ui.image.glide.RequestManager get(androidx.fragment.app.FragmentActivity fragmentActivity) {
        if (com.alimm.tanx.ui.image.glide.util.Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        return supportFragmentGet(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    @android.annotation.TargetApi(17)
    public com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment getRequestManagerFragment(android.app.FragmentManager fragmentManager) {
        com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment = (com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment2 = this.pendingRequestManagerFragments.get(fragmentManager);
        if (requestManagerFragment2 != null) {
            return requestManagerFragment2;
        }
        com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment requestManagerFragment3 = new com.alimm.tanx.ui.image.glide.manager.RequestManagerFragment();
        this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment3);
        fragmentManager.beginTransaction().add(requestManagerFragment3, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        return requestManagerFragment3;
    }

    public com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager fragmentManager) {
        com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = (com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment2 = this.pendingSupportRequestManagerFragments.get(fragmentManager);
        if (supportRequestManagerFragment2 != null) {
            return supportRequestManagerFragment2;
        }
        com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment3 = new com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment();
        this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment3);
        fragmentManager.beginTransaction().add(supportRequestManagerFragment3, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment3;
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

    public com.alimm.tanx.ui.image.glide.RequestManager supportFragmentGet(android.content.Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(fragmentManager);
        com.alimm.tanx.ui.image.glide.RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        com.alimm.tanx.ui.image.glide.RequestManager requestManager2 = new com.alimm.tanx.ui.image.glide.RequestManager(context, supportRequestManagerFragment.getTanxLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode());
        supportRequestManagerFragment.setRequestManager(requestManager2);
        return requestManager2;
    }
}
