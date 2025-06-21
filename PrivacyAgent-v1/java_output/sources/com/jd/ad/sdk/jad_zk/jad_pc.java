package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public class jad_pc implements android.os.Handler.Callback {
    public static final com.jd.ad.sdk.jad_zk.jad_pc.jad_bo jad_jt = new com.jd.ad.sdk.jad_zk.jad_pc.jad_an();
    public volatile com.jd.ad.sdk.jad_gr.jad_jw jad_an;

    @androidx.annotation.VisibleForTesting
    public final java.util.Map<android.app.FragmentManager, com.jd.ad.sdk.jad_zk.jad_ob> jad_bo = new java.util.HashMap();

    @androidx.annotation.VisibleForTesting
    public final java.util.Map<androidx.fragment.app.FragmentManager, com.jd.ad.sdk.jad_zk.jad_uh> jad_cp = new java.util.HashMap();
    public final android.os.Handler jad_dq;
    public final com.jd.ad.sdk.jad_zk.jad_pc.jad_bo jad_er;
    public final com.jd.ad.sdk.jad_zk.jad_kx jad_fs;

    public class jad_an implements com.jd.ad.sdk.jad_zk.jad_pc.jad_bo {
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_gr.jad_jw jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_ly jad_lyVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_qd jad_qdVar, @androidx.annotation.NonNull android.content.Context context) {
            return new com.jd.ad.sdk.jad_gr.jad_jw(jad_cpVar, jad_lyVar, jad_qdVar, new com.jd.ad.sdk.jad_zk.jad_re(), jad_cpVar.jad_bo(), context);
        }
    }

    public interface jad_bo {
    }

    public jad_pc(@androidx.annotation.Nullable com.jd.ad.sdk.jad_zk.jad_pc.jad_bo jad_boVar, com.jd.ad.sdk.jad_gr.jad_fs jad_fsVar) {
        new androidx.collection.ArrayMap();
        new androidx.collection.ArrayMap();
        new android.os.Bundle();
        this.jad_er = jad_boVar == null ? jad_jt : jad_boVar;
        this.jad_dq = new android.os.Handler(android.os.Looper.getMainLooper(), this);
        this.jad_fs = jad_an(jad_fsVar);
    }

    @androidx.annotation.Nullable
    public static android.app.Activity jad_an(@androidx.annotation.NonNull android.content.Context context) {
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        if (context instanceof android.content.ContextWrapper) {
            return jad_an(((android.content.ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static com.jd.ad.sdk.jad_zk.jad_kx jad_an(com.jd.ad.sdk.jad_gr.jad_fs jad_fsVar) {
        return (com.jd.ad.sdk.jad_te.jad_na.jad_hu && com.jd.ad.sdk.jad_te.jad_na.jad_jt) ? jad_fsVar.jad_an.containsKey(com.jd.ad.sdk.jad_gr.jad_dq.jad_er.class) ? new com.jd.ad.sdk.jad_zk.jad_iv() : new com.jd.ad.sdk.jad_zk.jad_jw() : new com.jd.ad.sdk.jad_zk.jad_jt();
    }

    @android.annotation.TargetApi(17)
    public static void jad_an(@androidx.annotation.NonNull android.app.Activity activity) {
        if (activity.isDestroyed()) {
            throw new java.lang.IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x016c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0158  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(android.os.Message message) {
        boolean z;
        android.content.ComponentCallbacks remove;
        android.app.FragmentManager fragmentManager;
        boolean z2;
        boolean z3;
        android.app.FragmentManager fragmentManager2;
        android.app.FragmentManager fragmentManager3;
        boolean z4;
        boolean z5 = message.arg1 == 1;
        int i = message.what;
        if (i == 1) {
            android.app.FragmentManager fragmentManager4 = (android.app.FragmentManager) message.obj;
            com.jd.ad.sdk.jad_zk.jad_ob jad_obVar = this.jad_bo.get(fragmentManager4);
            com.jd.ad.sdk.jad_zk.jad_ob jad_obVar2 = (com.jd.ad.sdk.jad_zk.jad_ob) fragmentManager4.findFragmentByTag("com.jd.ad.sdk.glide.manager");
            if (jad_obVar2 != jad_obVar) {
                if (jad_obVar2 != null && jad_obVar2.jad_dq != null) {
                    throw new java.lang.IllegalStateException("We've added two fragments with requests! Old: " + jad_obVar2 + " New: " + jad_obVar);
                }
                if (!z5 && !fragmentManager4.isDestroyed()) {
                    android.app.FragmentTransaction add = fragmentManager4.beginTransaction().add(jad_obVar, "com.jd.ad.sdk.glide.manager");
                    if (jad_obVar2 != null) {
                        add.remove(jad_obVar2);
                    }
                    add.commitAllowingStateLoss();
                    this.jad_dq.obtainMessage(1, 1, 0, fragmentManager4).sendToTarget();
                    if (android.util.Log.isLoggable("RMRetriever", 3)) {
                        com.jd.ad.sdk.logger.Logger.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
                    }
                    z = false;
                    if (z) {
                        remove = this.jad_bo.remove(fragmentManager4);
                        fragmentManager2 = fragmentManager4;
                        z2 = true;
                        z3 = true;
                        fragmentManager3 = fragmentManager2;
                        if (android.util.Log.isLoggable("RMRetriever", 5)) {
                        }
                        return z3;
                    }
                    fragmentManager = null;
                    z2 = false;
                    z3 = true;
                    remove = null;
                    fragmentManager3 = fragmentManager;
                    if (android.util.Log.isLoggable("RMRetriever", 5)) {
                    }
                    return z3;
                }
                if (android.util.Log.isLoggable("RMRetriever", 5)) {
                    if (fragmentManager4.isDestroyed()) {
                        com.jd.ad.sdk.logger.Logger.w("RMRetriever", "Parent was destroyed before our Fragment could be added");
                    } else {
                        com.jd.ad.sdk.logger.Logger.w("RMRetriever", "Tried adding Fragment twice and failed twice, giving up!");
                    }
                }
                jad_obVar.jad_an.jad_an();
            }
            z = true;
            if (z) {
            }
            fragmentManager = null;
            z2 = false;
            z3 = true;
            remove = null;
            fragmentManager3 = fragmentManager;
            if (android.util.Log.isLoggable("RMRetriever", 5)) {
            }
            return z3;
        }
        if (i != 2) {
            fragmentManager = null;
            z2 = false;
            z3 = false;
            remove = null;
            fragmentManager3 = fragmentManager;
            if (android.util.Log.isLoggable("RMRetriever", 5) && z2 && remove == null) {
                com.jd.ad.sdk.logger.Logger.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + fragmentManager3);
            }
            return z3;
        }
        androidx.fragment.app.FragmentManager fragmentManager5 = (androidx.fragment.app.FragmentManager) message.obj;
        com.jd.ad.sdk.jad_zk.jad_uh jad_uhVar = this.jad_cp.get(fragmentManager5);
        com.jd.ad.sdk.jad_zk.jad_uh jad_uhVar2 = (com.jd.ad.sdk.jad_zk.jad_uh) fragmentManager5.findFragmentByTag("com.jd.ad.sdk.glide.manager");
        if (jad_uhVar2 != jad_uhVar) {
            if (jad_uhVar2 != null && jad_uhVar2.jad_er != null) {
                throw new java.lang.IllegalStateException("We've added two fragments with requests! Old: " + jad_uhVar2 + " New: " + jad_uhVar);
            }
            if (!z5 && !fragmentManager5.isDestroyed()) {
                androidx.fragment.app.FragmentTransaction add2 = fragmentManager5.beginTransaction().add(jad_uhVar, "com.jd.ad.sdk.glide.manager");
                if (jad_uhVar2 != null) {
                    add2.remove(jad_uhVar2);
                }
                add2.commitNowAllowingStateLoss();
                this.jad_dq.obtainMessage(2, 1, 0, fragmentManager5).sendToTarget();
                if (android.util.Log.isLoggable("RMRetriever", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
                }
                z4 = false;
                if (z4) {
                    remove = this.jad_cp.remove(fragmentManager5);
                    fragmentManager2 = fragmentManager5;
                    z2 = true;
                    z3 = true;
                    fragmentManager3 = fragmentManager2;
                    if (android.util.Log.isLoggable("RMRetriever", 5)) {
                        com.jd.ad.sdk.logger.Logger.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + fragmentManager3);
                    }
                    return z3;
                }
                fragmentManager = null;
                z2 = false;
                z3 = true;
                remove = null;
                fragmentManager3 = fragmentManager;
                if (android.util.Log.isLoggable("RMRetriever", 5)) {
                }
                return z3;
            }
            if (fragmentManager5.isDestroyed()) {
                if (android.util.Log.isLoggable("RMRetriever", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
                }
            } else if (android.util.Log.isLoggable("RMRetriever", 6)) {
                com.jd.ad.sdk.logger.Logger.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
            }
            jad_uhVar.jad_an.jad_an();
        }
        z4 = true;
        if (z4) {
        }
        fragmentManager = null;
        z2 = false;
        z3 = true;
        remove = null;
        fragmentManager3 = fragmentManager;
        if (android.util.Log.isLoggable("RMRetriever", 5)) {
        }
        return z3;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_gr.jad_jw jad_an(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_cp()) {
            return jad_bo(fragmentActivity.getApplicationContext());
        }
        jad_an((android.app.Activity) fragmentActivity);
        this.jad_fs.jad_an(fragmentActivity);
        androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        android.app.Activity jad_an2 = jad_an((android.content.Context) fragmentActivity);
        boolean z = jad_an2 == null || !jad_an2.isFinishing();
        com.jd.ad.sdk.jad_zk.jad_uh jad_an3 = jad_an(supportFragmentManager, (androidx.fragment.app.Fragment) null);
        com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar = jad_an3.jad_er;
        if (jad_jwVar == null) {
            jad_jwVar = ((com.jd.ad.sdk.jad_zk.jad_pc.jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(fragmentActivity), jad_an3.jad_an, jad_an3.jad_bo, fragmentActivity);
            if (z) {
                jad_jwVar.jad_cp();
            }
            jad_an3.jad_er = jad_jwVar;
        }
        return jad_jwVar;
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_zk.jad_ob jad_an(@androidx.annotation.NonNull android.app.FragmentManager fragmentManager, @androidx.annotation.Nullable android.app.Fragment fragment) {
        com.jd.ad.sdk.jad_zk.jad_ob jad_obVar = this.jad_bo.get(fragmentManager);
        if (jad_obVar != null) {
            return jad_obVar;
        }
        com.jd.ad.sdk.jad_zk.jad_ob jad_obVar2 = (com.jd.ad.sdk.jad_zk.jad_ob) fragmentManager.findFragmentByTag("com.jd.ad.sdk.glide.manager");
        if (jad_obVar2 == null) {
            jad_obVar2 = new com.jd.ad.sdk.jad_zk.jad_ob(new com.jd.ad.sdk.jad_zk.jad_an());
            jad_obVar2.jad_fs = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                jad_obVar2.jad_an(fragment.getActivity());
            }
            this.jad_bo.put(fragmentManager, jad_obVar2);
            fragmentManager.beginTransaction().add(jad_obVar2, "com.jd.ad.sdk.glide.manager").commitAllowingStateLoss();
            this.jad_dq.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return jad_obVar2;
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_zk.jad_uh jad_an(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.Nullable androidx.fragment.app.Fragment fragment) {
        com.jd.ad.sdk.jad_zk.jad_uh jad_uhVar = this.jad_cp.get(fragmentManager);
        if (jad_uhVar != null) {
            return jad_uhVar;
        }
        com.jd.ad.sdk.jad_zk.jad_uh jad_uhVar2 = (com.jd.ad.sdk.jad_zk.jad_uh) fragmentManager.findFragmentByTag("com.jd.ad.sdk.glide.manager");
        if (jad_uhVar2 == null) {
            jad_uhVar2 = new com.jd.ad.sdk.jad_zk.jad_uh(new com.jd.ad.sdk.jad_zk.jad_an());
            jad_uhVar2.jad_fs = fragment;
            if (fragment != null && fragment.getContext() != null) {
                androidx.fragment.app.Fragment fragment2 = fragment;
                while (fragment2.getParentFragment() != null) {
                    fragment2 = fragment2.getParentFragment();
                }
                androidx.fragment.app.FragmentManager fragmentManager2 = fragment2.getFragmentManager();
                if (fragmentManager2 != null) {
                    jad_uhVar2.jad_an(fragment.getContext(), fragmentManager2);
                }
            }
            this.jad_cp.put(fragmentManager, jad_uhVar2);
            fragmentManager.beginTransaction().add(jad_uhVar2, "com.jd.ad.sdk.glide.manager").commitAllowingStateLoss();
            this.jad_dq.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return jad_uhVar2;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_gr.jad_jw jad_bo(@androidx.annotation.NonNull android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_dq() && !(context instanceof android.app.Application)) {
            if (context instanceof androidx.fragment.app.FragmentActivity) {
                return jad_an((androidx.fragment.app.FragmentActivity) context);
            }
            if (context instanceof android.app.Activity) {
                android.app.Activity activity = (android.app.Activity) context;
                if (com.jd.ad.sdk.jad_ir.jad_ly.jad_cp()) {
                    return jad_bo(activity.getApplicationContext());
                }
                if (activity instanceof androidx.fragment.app.FragmentActivity) {
                    return jad_an((androidx.fragment.app.FragmentActivity) activity);
                }
                jad_an(activity);
                this.jad_fs.jad_an(activity);
                android.app.FragmentManager fragmentManager = activity.getFragmentManager();
                android.app.Activity jad_an2 = jad_an((android.content.Context) activity);
                boolean z = jad_an2 == null || !jad_an2.isFinishing();
                com.jd.ad.sdk.jad_zk.jad_ob jad_an3 = jad_an(fragmentManager, (android.app.Fragment) null);
                com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar = jad_an3.jad_dq;
                if (jad_jwVar != null) {
                    return jad_jwVar;
                }
                com.jd.ad.sdk.jad_gr.jad_jw jad_an4 = ((com.jd.ad.sdk.jad_zk.jad_pc.jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(activity), jad_an3.jad_an, jad_an3.jad_bo, activity);
                if (z) {
                    jad_an4.jad_cp();
                }
                jad_an3.jad_dq = jad_an4;
                return jad_an4;
            }
            if (context instanceof android.content.ContextWrapper) {
                android.content.ContextWrapper contextWrapper = (android.content.ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return jad_bo(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.jad_an == null) {
            synchronized (this) {
                if (this.jad_an == null) {
                    this.jad_an = ((com.jd.ad.sdk.jad_zk.jad_pc.jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context.getApplicationContext()), new com.jd.ad.sdk.jad_zk.jad_bo(), new com.jd.ad.sdk.jad_zk.jad_hu(), context.getApplicationContext());
                }
            }
        }
        return this.jad_an;
    }
}
