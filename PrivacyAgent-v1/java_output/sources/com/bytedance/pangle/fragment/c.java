package com.bytedance.pangle.fragment;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public final class c implements android.app.Application.ActivityLifecycleCallbacks {
    android.app.Fragment a;

    public c(android.app.Fragment fragment) {
        this.a = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        r0 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName("android.app.FragmentState"), r10.length - 1);
        r2 = new int[r10.length - 1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        if (r3 >= r10.length) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
    
        r6 = r10[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
    
        if (r6 == r5) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r0[r4] = r6;
        r2[r4] = r3;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
    
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mActive", r0);
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mAdded", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        return;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onActivityPostSaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle bundle) {
        java.lang.Object[] objArr;
        java.lang.Object obj;
        if (this.a.getActivity() != activity) {
            return;
        }
        try {
            android.os.Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (java.lang.Object[]) com.bytedance.pangle.util.FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    obj = null;
                    break;
                }
                obj = objArr[i2];
                java.lang.Object readField = com.bytedance.pangle.util.FieldUtils.readField(obj, "mTag");
                if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) || ((readField instanceof java.lang.String) && (((java.lang.String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") || ((java.lang.String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                    break;
                } else {
                    i2++;
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        r0 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName("android.app.FragmentState"), r10.length - 1);
        r2 = new int[r10.length - 1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        if (r3 >= r10.length) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
    
        r6 = r10[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
    
        if (r6 == r5) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r0[r4] = r6;
        r2[r4] = r3;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
    
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mActive", r0);
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mAdded", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        return;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        java.lang.Object[] objArr;
        java.lang.Object obj;
        if (this.a.getActivity() != activity) {
            return;
        }
        try {
            android.os.Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (java.lang.Object[]) com.bytedance.pangle.util.FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    obj = null;
                    break;
                }
                obj = objArr[i2];
                java.lang.Object readField = com.bytedance.pangle.util.FieldUtils.readField(obj, "mTag");
                if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(readField) || ((readField instanceof java.lang.String) && (((java.lang.String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") || ((java.lang.String) readField).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                    break;
                } else {
                    i2++;
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(android.app.Activity activity) {
    }
}
