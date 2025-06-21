package okhttp3.internal;

/* loaded from: classes23.dex */
public abstract class NamedRunnable implements java.lang.Runnable {
    protected final java.lang.String name;

    public NamedRunnable(java.lang.String str, java.lang.Object... objArr) {
        this.name = okhttp3.internal.Util.format(str, objArr);
    }

    public abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String name = java.lang.Thread.currentThread().getName();
        java.lang.Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            java.lang.Thread.currentThread().setName(name);
        }
    }
}
