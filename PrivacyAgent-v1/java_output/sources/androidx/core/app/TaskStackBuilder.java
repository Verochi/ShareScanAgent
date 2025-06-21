package androidx.core.app;

/* loaded from: classes.dex */
public final class TaskStackBuilder implements java.lang.Iterable<android.content.Intent> {
    private static final java.lang.String TAG = "TaskStackBuilder";
    private final java.util.ArrayList<android.content.Intent> mIntents = new java.util.ArrayList<>();
    private final android.content.Context mSourceContext;

    public interface SupportParentable {
        @androidx.annotation.Nullable
        android.content.Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(android.content.Context context) {
        this.mSourceContext = context;
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.TaskStackBuilder create(@androidx.annotation.NonNull android.content.Context context) {
        return new androidx.core.app.TaskStackBuilder(context);
    }

    @java.lang.Deprecated
    public static androidx.core.app.TaskStackBuilder from(android.content.Context context) {
        return create(context);
    }

    @androidx.annotation.NonNull
    public androidx.core.app.TaskStackBuilder addNextIntent(@androidx.annotation.NonNull android.content.Intent intent) {
        this.mIntents.add(intent);
        return this;
    }

    @androidx.annotation.NonNull
    public androidx.core.app.TaskStackBuilder addNextIntentWithParentStack(@androidx.annotation.NonNull android.content.Intent intent) {
        android.content.ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (component != null) {
            addParentStack(component);
        }
        addNextIntent(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    public androidx.core.app.TaskStackBuilder addParentStack(@androidx.annotation.NonNull android.app.Activity activity) {
        android.content.Intent supportParentActivityIntent = activity instanceof androidx.core.app.TaskStackBuilder.SupportParentable ? ((androidx.core.app.TaskStackBuilder.SupportParentable) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = androidx.core.app.NavUtils.getParentActivityIntent(activity);
        }
        if (supportParentActivityIntent != null) {
            android.content.ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            addParentStack(component);
            addNextIntent(supportParentActivityIntent);
        }
        return this;
    }

    public androidx.core.app.TaskStackBuilder addParentStack(android.content.ComponentName componentName) {
        int size = this.mIntents.size();
        try {
            android.content.Intent parentActivityIntent = androidx.core.app.NavUtils.getParentActivityIntent(this.mSourceContext, componentName);
            while (parentActivityIntent != null) {
                this.mIntents.add(size, parentActivityIntent);
                parentActivityIntent = androidx.core.app.NavUtils.getParentActivityIntent(this.mSourceContext, parentActivityIntent.getComponent());
            }
            return this;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    @androidx.annotation.NonNull
    public androidx.core.app.TaskStackBuilder addParentStack(@androidx.annotation.NonNull java.lang.Class<?> cls) {
        return addParentStack(new android.content.ComponentName(this.mSourceContext, cls));
    }

    @androidx.annotation.Nullable
    public android.content.Intent editIntentAt(int i) {
        return this.mIntents.get(i);
    }

    @java.lang.Deprecated
    public android.content.Intent getIntent(int i) {
        return editIntentAt(i);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    @androidx.annotation.NonNull
    public android.content.Intent[] getIntents() {
        int size = this.mIntents.size();
        android.content.Intent[] intentArr = new android.content.Intent[size];
        if (size == 0) {
            return intentArr;
        }
        intentArr[0] = new android.content.Intent(this.mIntents.get(0)).addFlags(268484608);
        for (int i = 1; i < size; i++) {
            intentArr[i] = new android.content.Intent(this.mIntents.get(i));
        }
        return intentArr;
    }

    @androidx.annotation.Nullable
    public android.app.PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, null);
    }

    @androidx.annotation.Nullable
    public android.app.PendingIntent getPendingIntent(int i, int i2, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (this.mIntents.isEmpty()) {
            throw new java.lang.IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        java.util.ArrayList<android.content.Intent> arrayList = this.mIntents;
        android.content.Intent[] intentArr = (android.content.Intent[]) arrayList.toArray(new android.content.Intent[arrayList.size()]);
        intentArr[0] = new android.content.Intent(intentArr[0]).addFlags(268484608);
        return android.app.PendingIntent.getActivities(this.mSourceContext, i, intentArr, i2, bundle);
    }

    @Override // java.lang.Iterable
    @java.lang.Deprecated
    public java.util.Iterator<android.content.Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(@androidx.annotation.Nullable android.os.Bundle bundle) {
        if (this.mIntents.isEmpty()) {
            throw new java.lang.IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        java.util.ArrayList<android.content.Intent> arrayList = this.mIntents;
        android.content.Intent[] intentArr = (android.content.Intent[]) arrayList.toArray(new android.content.Intent[arrayList.size()]);
        intentArr[0] = new android.content.Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.ContextCompat.startActivities(this.mSourceContext, intentArr, bundle)) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.mSourceContext.startActivity(intent);
    }
}
