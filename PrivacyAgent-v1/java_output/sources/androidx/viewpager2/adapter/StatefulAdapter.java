package androidx.viewpager2.adapter;

/* loaded from: classes.dex */
public interface StatefulAdapter {
    void restoreState(@androidx.annotation.NonNull android.os.Parcelable parcelable);

    @androidx.annotation.NonNull
    android.os.Parcelable saveState();
}
