package androidx.databinding;

/* loaded from: classes.dex */
public interface ObservableList<T> extends java.util.List<T> {

    public static abstract class OnListChangedCallback<T extends androidx.databinding.ObservableList> {
        public abstract void onChanged(T t);

        public abstract void onItemRangeChanged(T t, int i, int i2);

        public abstract void onItemRangeInserted(T t, int i, int i2);

        public abstract void onItemRangeMoved(T t, int i, int i2, int i3);

        public abstract void onItemRangeRemoved(T t, int i, int i2);
    }

    void addOnListChangedCallback(androidx.databinding.ObservableList.OnListChangedCallback<? extends androidx.databinding.ObservableList<T>> onListChangedCallback);

    void removeOnListChangedCallback(androidx.databinding.ObservableList.OnListChangedCallback<? extends androidx.databinding.ObservableList<T>> onListChangedCallback);
}
