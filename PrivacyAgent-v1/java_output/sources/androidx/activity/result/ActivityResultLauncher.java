package androidx.activity.result;

/* loaded from: classes.dex */
public abstract class ActivityResultLauncher<I> {
    @androidx.annotation.NonNull
    public abstract androidx.activity.result.contract.ActivityResultContract<I, ?> getContract();

    public void launch(@android.annotation.SuppressLint({"UnknownNullness"}) I i) {
        launch(i, null);
    }

    public abstract void launch(@android.annotation.SuppressLint({"UnknownNullness"}) I i, @androidx.annotation.Nullable androidx.core.app.ActivityOptionsCompat activityOptionsCompat);

    @androidx.annotation.MainThread
    public abstract void unregister();
}
