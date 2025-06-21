package androidx.activity.result.contract;

/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {

        @android.annotation.SuppressLint({"UnknownNullness"})
        private final T mValue;

        public SynchronousResult(@android.annotation.SuppressLint({"UnknownNullness"}) T t) {
            this.mValue = t;
        }

        @android.annotation.SuppressLint({"UnknownNullness"})
        public T getValue() {
            return this.mValue;
        }
    }

    @androidx.annotation.NonNull
    public abstract android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @android.annotation.SuppressLint({"UnknownNullness"}) I i);

    @androidx.annotation.Nullable
    public androidx.activity.result.contract.ActivityResultContract.SynchronousResult<O> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @android.annotation.SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    @android.annotation.SuppressLint({"UnknownNullness"})
    public abstract O parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent);
}
