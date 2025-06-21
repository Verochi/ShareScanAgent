package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i, int i2, @androidx.annotation.Nullable java.lang.Object obj);

    void onInserted(int i, int i2);

    void onMoved(int i, int i2);

    void onRemoved(int i, int i2);
}
