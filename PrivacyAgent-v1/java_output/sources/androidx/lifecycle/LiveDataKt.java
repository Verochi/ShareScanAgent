package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a@\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"observe", "Landroidx/lifecycle/Observer;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "", "lifecycle-livedata-core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LiveDataKt {
    @kotlin.Deprecated(message = "This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"")
    @androidx.annotation.MainThread
    @org.jetbrains.annotations.NotNull
    public static final <T> androidx.lifecycle.Observer<T> observe(@org.jetbrains.annotations.NotNull androidx.lifecycle.LiveData<T> liveData, @org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onChanged) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(liveData, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1 liveDataKt$observe$wrappedObserver$1 = new androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1(onChanged);
        liveData.observe(owner, liveDataKt$observe$wrappedObserver$1);
        return liveDataKt$observe$wrappedObserver$1;
    }
}
