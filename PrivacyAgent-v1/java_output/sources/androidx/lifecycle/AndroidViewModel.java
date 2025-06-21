package androidx.lifecycle;

/* loaded from: classes.dex */
public class AndroidViewModel extends androidx.lifecycle.ViewModel {

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private android.app.Application mApplication;

    public AndroidViewModel(@androidx.annotation.NonNull android.app.Application application) {
        this.mApplication = application;
    }

    @androidx.annotation.NonNull
    public <T extends android.app.Application> T getApplication() {
        return (T) this.mApplication;
    }
}
