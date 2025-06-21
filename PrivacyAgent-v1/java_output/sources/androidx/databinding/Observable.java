package androidx.databinding;

/* loaded from: classes.dex */
public interface Observable {

    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(androidx.databinding.Observable observable, int i);
    }

    void addOnPropertyChangedCallback(androidx.databinding.Observable.OnPropertyChangedCallback onPropertyChangedCallback);

    void removeOnPropertyChangedCallback(androidx.databinding.Observable.OnPropertyChangedCallback onPropertyChangedCallback);
}
