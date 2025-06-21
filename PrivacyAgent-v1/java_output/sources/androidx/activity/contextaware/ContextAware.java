package androidx.activity.contextaware;

/* loaded from: classes.dex */
public interface ContextAware {
    void addOnContextAvailableListener(@androidx.annotation.NonNull androidx.activity.contextaware.OnContextAvailableListener onContextAvailableListener);

    @androidx.annotation.Nullable
    android.content.Context peekAvailableContext();

    void removeOnContextAvailableListener(@androidx.annotation.NonNull androidx.activity.contextaware.OnContextAvailableListener onContextAvailableListener);
}
