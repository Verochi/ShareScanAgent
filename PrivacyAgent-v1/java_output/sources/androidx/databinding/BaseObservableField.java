package androidx.databinding;

/* loaded from: classes.dex */
abstract class BaseObservableField extends androidx.databinding.BaseObservable {

    public class DependencyCallback extends androidx.databinding.Observable.OnPropertyChangedCallback {
        public DependencyCallback() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(androidx.databinding.Observable observable, int i) {
            androidx.databinding.BaseObservableField.this.notifyChange();
        }
    }

    public BaseObservableField() {
    }

    public BaseObservableField(androidx.databinding.Observable... observableArr) {
        if (observableArr == null || observableArr.length == 0) {
            return;
        }
        androidx.databinding.BaseObservableField.DependencyCallback dependencyCallback = new androidx.databinding.BaseObservableField.DependencyCallback();
        for (androidx.databinding.Observable observable : observableArr) {
            observable.addOnPropertyChangedCallback(dependencyCallback);
        }
    }
}
