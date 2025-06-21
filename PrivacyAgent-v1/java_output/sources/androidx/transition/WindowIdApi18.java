package androidx.transition;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes.dex */
class WindowIdApi18 implements androidx.transition.WindowIdImpl {
    private final android.view.WindowId mWindowId;

    public WindowIdApi18(@androidx.annotation.NonNull android.view.View view) {
        this.mWindowId = view.getWindowId();
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof androidx.transition.WindowIdApi18) && ((androidx.transition.WindowIdApi18) obj).mWindowId.equals(this.mWindowId);
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}
