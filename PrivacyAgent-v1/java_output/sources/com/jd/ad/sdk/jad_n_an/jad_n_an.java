package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_an {
    public int jad_n_an;
    public com.jd.ad.sdk.jad_n_an.jad_n_an.jad_n_cp jad_n_bo;
    public java.lang.ref.WeakReference<com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener> jad_n_cp;
    public final int jad_n_er;

    @androidx.annotation.Nullable
    public android.view.View jad_n_hu;
    public final android.os.Handler jad_n_fs = new android.os.Handler(android.os.Looper.getMainLooper());

    @androidx.annotation.NonNull
    public int jad_n_jt = 1;
    public final java.lang.Runnable jad_n_iv = new com.jd.ad.sdk.jad_n_an.jad_n_an.RunnableC0395jad_n_an();
    public final android.app.Application.ActivityLifecycleCallbacks jad_n_jw = new com.jd.ad.sdk.jad_n_an.jad_n_an.jad_n_bo();
    public final android.app.Application jad_n_dq = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getFoundationService().getApplication();

    /* renamed from: com.jd.ad.sdk.jad_n_an.jad_n_an$jad_n_an, reason: collision with other inner class name */
    public class RunnableC0395jad_n_an implements java.lang.Runnable {
        public RunnableC0395jad_n_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.ref.WeakReference<com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener> weakReference = com.jd.ad.sdk.jad_n_an.jad_n_an.this.jad_n_cp;
            if (weakReference != null && weakReference.get() != null) {
                com.jd.ad.sdk.jad_n_an.jad_n_an.this.jad_n_cp.get().onCountdown(com.jd.ad.sdk.jad_n_an.jad_n_an.this.jad_n_an);
            }
            com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = com.jd.ad.sdk.jad_n_an.jad_n_an.this;
            jad_n_anVar.jad_n_an--;
            com.jd.ad.sdk.logger.Logger.d("Native ad skip=====totalCount=" + com.jd.ad.sdk.jad_n_an.jad_n_an.this.jad_n_an);
            com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar2 = com.jd.ad.sdk.jad_n_an.jad_n_an.this;
            if (jad_n_anVar2.jad_n_an >= 0) {
                jad_n_anVar2.jad_n_fs.postDelayed(jad_n_anVar2.jad_n_iv, 1000L);
                return;
            }
            com.jd.ad.sdk.jad_n_an.jad_n_an.jad_n_cp jad_n_cpVar = jad_n_anVar2.jad_n_bo;
            if (jad_n_cpVar != null) {
                com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(((com.jd.ad.sdk.jad_n_an.jad_n_kx) jad_n_cpVar).jad_n_an, jad_n_anVar2.jad_n_hu, false);
            }
            com.jd.ad.sdk.logger.Logger.d("Native ad skip===stopCount");
            com.jd.ad.sdk.jad_n_an.jad_n_an.this.jad_n_bo();
        }
    }

    public class jad_n_bo implements android.app.Application.ActivityLifecycleCallbacks {
        public jad_n_bo() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
            com.jd.ad.sdk.logger.Logger.d("Native ad time onActivityDestroyed = " + activity);
            int hashCode = activity.hashCode();
            com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = com.jd.ad.sdk.jad_n_an.jad_n_an.this;
            if (hashCode == jad_n_anVar.jad_n_er) {
                jad_n_anVar.jad_n_bo();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity) {
            com.jd.ad.sdk.logger.Logger.d("Native ad time onActivityPaused = " + activity);
            int hashCode = activity.hashCode();
            com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = com.jd.ad.sdk.jad_n_an.jad_n_an.this;
            if (hashCode == jad_n_anVar.jad_n_er && jad_n_anVar.jad_n_jt == 2) {
                jad_n_anVar.jad_n_an(3);
                jad_n_anVar.jad_n_fs.removeCallbacksAndMessages(null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity) {
            com.jd.ad.sdk.logger.Logger.d("Native ad time onActivityResumed = " + activity);
            int hashCode = activity.hashCode();
            com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = com.jd.ad.sdk.jad_n_an.jad_n_an.this;
            if (hashCode == jad_n_anVar.jad_n_er && jad_n_anVar.jad_n_jt == 3) {
                jad_n_anVar.jad_n_an(2);
                jad_n_anVar.jad_n_fs.post(jad_n_anVar.jad_n_iv);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@androidx.annotation.NonNull android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@androidx.annotation.NonNull android.app.Activity activity) {
        }
    }

    public interface jad_n_cp {
    }

    public jad_n_an(com.jd.ad.sdk.nativead.JADNative jADNative) {
        this.jad_n_er = jADNative.getActivity() != null ? jADNative.getActivity().hashCode() : -1;
    }

    public final void jad_n_an() {
        if (this.jad_n_jt != 1) {
            return;
        }
        jad_n_an(2);
        int i = this.jad_n_an;
        if (i < 1 || i > 30) {
            this.jad_n_an = 5;
        }
        this.jad_n_fs.post(this.jad_n_iv);
        if (this.jad_n_dq == null || -1 == this.jad_n_er) {
            return;
        }
        com.jd.ad.sdk.logger.Logger.d("Native ad time registerLifeCycle");
        android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.jad_n_jw;
        if (activityLifecycleCallbacks != null) {
            this.jad_n_dq.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.jad_n_dq.registerActivityLifecycleCallbacks(this.jad_n_jw);
        }
    }

    public final void jad_n_an(@androidx.annotation.NonNull int i) {
        com.jd.ad.sdk.logger.Logger.d("Native ad counter state changed counterState= " + com.jd.ad.sdk.jad_n_an.jad_n_cp.jad_n_an(this.jad_n_jt) + ",now=" + com.jd.ad.sdk.jad_n_an.jad_n_cp.jad_n_an(i));
        this.jad_n_jt = i;
    }

    public void jad_n_bo() {
        com.jd.ad.sdk.logger.Logger.d("Native ad time stopCount=counterState=" + com.jd.ad.sdk.jad_n_an.jad_n_cp.jad_n_an(this.jad_n_jt));
        if (this.jad_n_jt == 4) {
            return;
        }
        jad_n_an(4);
        this.jad_n_an = 0;
        this.jad_n_fs.removeCallbacksAndMessages(null);
        if (this.jad_n_dq == null) {
            return;
        }
        com.jd.ad.sdk.logger.Logger.d("Native ad time unRegisterLifeCycle");
        android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.jad_n_jw;
        if (activityLifecycleCallbacks != null) {
            this.jad_n_dq.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }
}
