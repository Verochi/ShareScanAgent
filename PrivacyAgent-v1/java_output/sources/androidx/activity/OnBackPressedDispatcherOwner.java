package androidx.activity;

/* loaded from: classes.dex */
public interface OnBackPressedDispatcherOwner extends androidx.lifecycle.LifecycleOwner {
    @androidx.annotation.NonNull
    androidx.activity.OnBackPressedDispatcher getOnBackPressedDispatcher();
}
