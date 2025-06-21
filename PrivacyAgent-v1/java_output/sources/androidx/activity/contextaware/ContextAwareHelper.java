package androidx.activity.contextaware;

/* loaded from: classes.dex */
public final class ContextAwareHelper {
    private volatile android.content.Context mContext;
    private final java.util.Set<androidx.activity.contextaware.OnContextAvailableListener> mListeners = new java.util.concurrent.CopyOnWriteArraySet();

    public void addOnContextAvailableListener(@androidx.annotation.NonNull androidx.activity.contextaware.OnContextAvailableListener onContextAvailableListener) {
        if (this.mContext != null) {
            onContextAvailableListener.onContextAvailable(this.mContext);
        }
        this.mListeners.add(onContextAvailableListener);
    }

    public void clearAvailableContext() {
        this.mContext = null;
    }

    public void dispatchOnContextAvailable(@androidx.annotation.NonNull android.content.Context context) {
        this.mContext = context;
        java.util.Iterator<androidx.activity.contextaware.OnContextAvailableListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onContextAvailable(context);
        }
    }

    @androidx.annotation.Nullable
    public android.content.Context peekAvailableContext() {
        return this.mContext;
    }

    public void removeOnContextAvailableListener(@androidx.annotation.NonNull androidx.activity.contextaware.OnContextAvailableListener onContextAvailableListener) {
        this.mListeners.remove(onContextAvailableListener);
    }
}
