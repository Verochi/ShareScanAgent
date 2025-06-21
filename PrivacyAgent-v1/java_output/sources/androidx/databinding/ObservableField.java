package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableField<T> extends androidx.databinding.BaseObservableField implements java.io.Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField() {
    }

    public ObservableField(T t) {
        this.mValue = t;
    }

    public ObservableField(androidx.databinding.Observable... observableArr) {
        super(observableArr);
    }

    @androidx.annotation.Nullable
    public T get() {
        return this.mValue;
    }

    public void set(T t) {
        if (t != this.mValue) {
            this.mValue = t;
            notifyChange();
        }
    }
}
