package androidx.databinding.adapters;

/* loaded from: classes.dex */
public class ListenerUtil {
    private static final android.util.SparseArray<java.util.WeakHashMap<android.view.View, java.lang.ref.WeakReference<?>>> sListeners = new android.util.SparseArray<>();

    public static <T> T getListener(android.view.View view, int i) {
        return (T) view.getTag(i);
    }

    public static <T> T trackListener(android.view.View view, T t, int i) {
        T t2 = (T) view.getTag(i);
        view.setTag(i, t);
        return t2;
    }
}
