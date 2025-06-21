package androidx.activity.result;

/* loaded from: classes.dex */
public interface ActivityResultCaller {
    @androidx.annotation.NonNull
    <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(@androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback);

    @androidx.annotation.NonNull
    <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(@androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultRegistry activityResultRegistry, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback);
}
