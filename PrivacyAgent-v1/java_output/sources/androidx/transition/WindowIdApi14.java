package androidx.transition;

/* loaded from: classes.dex */
class WindowIdApi14 implements androidx.transition.WindowIdImpl {
    private final android.os.IBinder mToken;

    public WindowIdApi14(android.os.IBinder iBinder) {
        this.mToken = iBinder;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof androidx.transition.WindowIdApi14) && ((androidx.transition.WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
