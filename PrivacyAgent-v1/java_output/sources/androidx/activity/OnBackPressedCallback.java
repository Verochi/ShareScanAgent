package androidx.activity;

/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private java.util.concurrent.CopyOnWriteArrayList<androidx.activity.Cancellable> mCancellables = new java.util.concurrent.CopyOnWriteArrayList<>();
    private boolean mEnabled;

    public OnBackPressedCallback(boolean z) {
        this.mEnabled = z;
    }

    public void addCancellable(@androidx.annotation.NonNull androidx.activity.Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    @androidx.annotation.MainThread
    public abstract void handleOnBackPressed();

    @androidx.annotation.MainThread
    public final boolean isEnabled() {
        return this.mEnabled;
    }

    @androidx.annotation.MainThread
    public final void remove() {
        java.util.Iterator<androidx.activity.Cancellable> it = this.mCancellables.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public void removeCancellable(@androidx.annotation.NonNull androidx.activity.Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }

    @androidx.annotation.MainThread
    public final void setEnabled(boolean z) {
        this.mEnabled = z;
    }
}
