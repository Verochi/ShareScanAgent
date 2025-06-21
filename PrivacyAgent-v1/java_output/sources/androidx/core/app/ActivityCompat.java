package androidx.core.app;

/* loaded from: classes.dex */
public class ActivityCompat extends androidx.core.content.ContextCompat {
    private static androidx.core.app.ActivityCompat.PermissionCompatDelegate sDelegate;

    /* renamed from: androidx.core.app.ActivityCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ java.lang.String[] val$permissions;
        final /* synthetic */ int val$requestCode;

        public AnonymousClass1(java.lang.String[] strArr, android.app.Activity activity, int i) {
            this.val$permissions = strArr;
            this.val$activity = activity;
            this.val$requestCode = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.val$permissions.length];
            android.content.pm.PackageManager packageManager = this.val$activity.getPackageManager();
            java.lang.String packageName = this.val$activity.getPackageName();
            int length = this.val$permissions.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.val$permissions[i], packageName);
            }
            ((androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, iArr);
        }
    }

    /* renamed from: androidx.core.app.ActivityCompat$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass2(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$activity.isFinishing() || androidx.core.app.ActivityRecreator.recreate(this.val$activity)) {
                return;
            }
            this.val$activity.recreate();
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static void setLocusContext(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable androidx.core.content.LocusIdCompat locusIdCompat, @androidx.annotation.Nullable android.os.Bundle bundle) {
            activity.setLocusContext(locusIdCompat == null ? null : locusIdCompat.toLocusId(), bundle);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.IntRange(from = 0) int i, int i2, @androidx.annotation.Nullable android.content.Intent intent);

        boolean requestPermissions(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.IntRange(from = 0) int i);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    @androidx.annotation.RequiresApi(21)
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final androidx.core.app.SharedElementCallback mCallback;

        /* renamed from: androidx.core.app.ActivityCompat$SharedElementCallback21Impl$1, reason: invalid class name */
        public class AnonymousClass1 implements androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener {
            final /* synthetic */ android.app.SharedElementCallback.OnSharedElementsReadyListener val$listener;

            public AnonymousClass1(android.app.SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
                this.val$listener = onSharedElementsReadyListener;
            }

            @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
            public void onSharedElementsReady() {
                this.val$listener.onSharedElementsReady();
            }
        }

        public SharedElementCallback21Impl(androidx.core.app.SharedElementCallback sharedElementCallback) {
            this.mCallback = sharedElementCallback;
        }

        @Override // android.app.SharedElementCallback
        public android.os.Parcelable onCaptureSharedElementSnapshot(android.view.View view, android.graphics.Matrix matrix, android.graphics.RectF rectF) {
            return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public android.view.View onCreateSnapshotView(android.content.Context context, android.os.Parcelable parcelable) {
            return this.mCallback.onCreateSnapshotView(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(java.util.List<java.lang.String> list, java.util.Map<java.lang.String, android.view.View> map) {
            this.mCallback.onMapSharedElements(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(java.util.List<android.view.View> list) {
            this.mCallback.onRejectSharedElements(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3) {
            this.mCallback.onSharedElementEnd(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3) {
            this.mCallback.onSharedElementStart(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        @androidx.annotation.RequiresApi(23)
        public void onSharedElementsArrived(java.util.List<java.lang.String> list, java.util.List<android.view.View> list2, android.app.SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.mCallback.onSharedElementsArrived(list, list2, new androidx.core.app.ActivityCompat.SharedElementCallback21Impl.AnonymousClass1(onSharedElementsReadyListener));
        }
    }

    public static void finishAffinity(@androidx.annotation.NonNull android.app.Activity activity) {
        activity.finishAffinity();
    }

    public static void finishAfterTransition(@androidx.annotation.NonNull android.app.Activity activity) {
        activity.finishAfterTransition();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.app.ActivityCompat.PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @androidx.annotation.Nullable
    public static android.net.Uri getReferrer(@androidx.annotation.NonNull android.app.Activity activity) {
        android.net.Uri referrer;
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            referrer = activity.getReferrer();
            return referrer;
        }
        android.content.Intent intent = activity.getIntent();
        android.net.Uri uri = (android.net.Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        java.lang.String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return android.net.Uri.parse(stringExtra);
        }
        return null;
    }

    @java.lang.Deprecated
    public static boolean invalidateOptionsMenu(android.app.Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static void postponeEnterTransition(@androidx.annotation.NonNull android.app.Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void recreate(@androidx.annotation.NonNull android.app.Activity activity) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            activity.recreate();
        } else if (i <= 23) {
            new android.os.Handler(activity.getMainLooper()).post(new androidx.core.app.ActivityCompat.AnonymousClass2(activity));
        } else {
            if (androidx.core.app.ActivityRecreator.recreate(activity)) {
                return;
            }
            activity.recreate();
        }
    }

    @androidx.annotation.Nullable
    public static androidx.core.view.DragAndDropPermissionsCompat requestDragAndDropPermissions(android.app.Activity activity, android.view.DragEvent dragEvent) {
        return androidx.core.view.DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.IntRange(from = 0) int i) {
        androidx.core.app.ActivityCompat.PermissionCompatDelegate permissionCompatDelegate = sDelegate;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.requestPermissions(activity, strArr, i)) {
            for (java.lang.String str : strArr) {
                if (android.text.TextUtils.isEmpty(str)) {
                    throw new java.lang.IllegalArgumentException("Permission request for permissions " + java.util.Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator) {
                    ((androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback) {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new androidx.core.app.ActivityCompat.AnonymousClass1(strArr, activity, i));
            }
        }
    }

    @androidx.annotation.NonNull
    public static <T extends android.view.View> T requireViewById(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.IdRes int i) {
        android.view.View requireViewById;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            requireViewById = activity.requireViewById(i);
            return (T) requireViewById;
        }
        T t = (T) activity.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new java.lang.IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable androidx.core.app.SharedElementCallback sharedElementCallback) {
        activity.setEnterSharedElementCallback(sharedElementCallback != null ? new androidx.core.app.ActivityCompat.SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void setExitSharedElementCallback(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable androidx.core.app.SharedElementCallback sharedElementCallback) {
        activity.setExitSharedElementCallback(sharedElementCallback != null ? new androidx.core.app.ActivityCompat.SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void setLocusContext(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable androidx.core.content.LocusIdCompat locusIdCompat, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            androidx.core.app.ActivityCompat.Api30Impl.setLocusContext(activity, locusIdCompat, bundle);
        }
    }

    public static void setPermissionCompatDelegate(@androidx.annotation.Nullable androidx.core.app.ActivityCompat.PermissionCompatDelegate permissionCompatDelegate) {
        sDelegate = permissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull java.lang.String str) {
        boolean shouldShowRequestPermissionRationale;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return false;
        }
        shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
        return shouldShowRequestPermissionRationale;
    }

    public static void startActivityForResult(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.content.Intent intent, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void startIntentSenderForResult(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.content.IntentSender intentSender, int i, @androidx.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, @androidx.annotation.Nullable android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void startPostponedEnterTransition(@androidx.annotation.NonNull android.app.Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
