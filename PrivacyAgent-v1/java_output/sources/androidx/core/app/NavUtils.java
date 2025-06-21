package androidx.core.app;

/* loaded from: classes.dex */
public final class NavUtils {
    public static final java.lang.String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final java.lang.String TAG = "NavUtils";

    private NavUtils() {
    }

    @androidx.annotation.Nullable
    public static android.content.Intent getParentActivityIntent(@androidx.annotation.NonNull android.app.Activity activity) {
        android.content.Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        java.lang.String parentActivityName = getParentActivityName(activity);
        if (parentActivityName == null) {
            return null;
        }
        android.content.ComponentName componentName = new android.content.ComponentName(activity, parentActivityName);
        try {
            return getParentActivityName(activity, componentName) == null ? android.content.Intent.makeMainActivity(componentName) : new android.content.Intent().setComponent(componentName);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getParentActivityIntent: bad parentActivityName '");
            sb.append(parentActivityName);
            sb.append("' in manifest");
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static android.content.Intent getParentActivityIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        android.content.ComponentName componentName2 = new android.content.ComponentName(componentName.getPackageName(), parentActivityName);
        return getParentActivityName(context, componentName2) == null ? android.content.Intent.makeMainActivity(componentName2) : new android.content.Intent().setComponent(componentName2);
    }

    @androidx.annotation.Nullable
    public static android.content.Intent getParentActivityIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<?> cls) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String parentActivityName = getParentActivityName(context, new android.content.ComponentName(context, cls));
        if (parentActivityName == null) {
            return null;
        }
        android.content.ComponentName componentName = new android.content.ComponentName(context, parentActivityName);
        return getParentActivityName(context, componentName) == null ? android.content.Intent.makeMainActivity(componentName) : new android.content.Intent().setComponent(componentName);
    }

    @androidx.annotation.Nullable
    public static java.lang.String getParentActivityName(@androidx.annotation.NonNull android.app.Activity activity) {
        try {
            return getParentActivityName(activity, activity.getComponentName());
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String getParentActivityName(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String string;
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        int i = android.os.Build.VERSION.SDK_INT;
        android.content.pm.ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i >= 29 ? 269222528 : i >= 24 ? 787072 : com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH);
        java.lang.String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        android.os.Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString(PARENT_ACTIVITY)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void navigateUpFromSameTask(@androidx.annotation.NonNull android.app.Activity activity) {
        android.content.Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent != null) {
            navigateUpTo(activity, parentActivityIntent);
            return;
        }
        throw new java.lang.IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.content.Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static boolean shouldUpRecreateTask(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.content.Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
