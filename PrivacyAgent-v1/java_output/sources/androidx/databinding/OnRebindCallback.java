package androidx.databinding;

/* loaded from: classes.dex */
public abstract class OnRebindCallback<T extends androidx.databinding.ViewDataBinding> {
    public void onBound(T t) {
    }

    public void onCanceled(T t) {
    }

    public boolean onPreBind(T t) {
        return true;
    }
}
