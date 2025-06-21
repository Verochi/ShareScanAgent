package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:alwaysDrawnWithCache", method = "setAlwaysDrawnWithCacheEnabled", type = android.view.ViewGroup.class), @androidx.databinding.BindingMethod(attribute = "android:animationCache", method = "setAnimationCacheEnabled", type = android.view.ViewGroup.class), @androidx.databinding.BindingMethod(attribute = "android:splitMotionEvents", method = "setMotionEventSplittingEnabled", type = android.view.ViewGroup.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ViewGroupBindingAdapter {

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewAdded val$added;
        final /* synthetic */ androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewRemoved val$removed;

        public AnonymousClass1(androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewAdded onChildViewAdded, androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewRemoved onChildViewRemoved) {
            this.val$added = onChildViewAdded;
            this.val$removed = onChildViewRemoved;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(android.view.View view, android.view.View view2) {
            androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewAdded onChildViewAdded = this.val$added;
            if (onChildViewAdded != null) {
                onChildViewAdded.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(android.view.View view, android.view.View view2) {
            androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewRemoved onChildViewRemoved = this.val$removed;
            if (onChildViewRemoved != null) {
                onChildViewRemoved.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationEnd val$end;
        final /* synthetic */ androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationRepeat val$repeat;
        final /* synthetic */ androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationStart val$start;

        public AnonymousClass2(androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationStart onAnimationStart, androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationEnd onAnimationEnd, androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationRepeat onAnimationRepeat) {
            this.val$start = onAnimationStart;
            this.val$end = onAnimationEnd;
            this.val$repeat = onAnimationRepeat;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationEnd onAnimationEnd = this.val$end;
            if (onAnimationEnd != null) {
                onAnimationEnd.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
            androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationRepeat onAnimationRepeat = this.val$repeat;
            if (onAnimationRepeat != null) {
                onAnimationRepeat.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationStart onAnimationStart = this.val$start;
            if (onAnimationStart != null) {
                onAnimationStart.onAnimationStart(animation);
            }
        }
    }

    public interface OnAnimationEnd {
        void onAnimationEnd(android.view.animation.Animation animation);
    }

    public interface OnAnimationRepeat {
        void onAnimationRepeat(android.view.animation.Animation animation);
    }

    public interface OnAnimationStart {
        void onAnimationStart(android.view.animation.Animation animation);
    }

    public interface OnChildViewAdded {
        void onChildViewAdded(android.view.View view, android.view.View view2);
    }

    public interface OnChildViewRemoved {
        void onChildViewRemoved(android.view.View view, android.view.View view2);
    }

    @androidx.databinding.BindingAdapter({"android:animateLayoutChanges"})
    @android.annotation.TargetApi(11)
    public static void setAnimateLayoutChanges(android.view.ViewGroup viewGroup, boolean z) {
        if (z) {
            viewGroup.setLayoutTransition(new android.animation.LayoutTransition());
        } else {
            viewGroup.setLayoutTransition(null);
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onAnimationStart", "android:onAnimationEnd", "android:onAnimationRepeat"})
    public static void setListener(android.view.ViewGroup viewGroup, androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationStart onAnimationStart, androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationEnd onAnimationEnd, androidx.databinding.adapters.ViewGroupBindingAdapter.OnAnimationRepeat onAnimationRepeat) {
        if (onAnimationStart == null && onAnimationEnd == null && onAnimationRepeat == null) {
            viewGroup.setLayoutAnimationListener(null);
        } else {
            viewGroup.setLayoutAnimationListener(new androidx.databinding.adapters.ViewGroupBindingAdapter.AnonymousClass2(onAnimationStart, onAnimationEnd, onAnimationRepeat));
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onChildViewAdded", "android:onChildViewRemoved"})
    public static void setListener(android.view.ViewGroup viewGroup, androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewAdded onChildViewAdded, androidx.databinding.adapters.ViewGroupBindingAdapter.OnChildViewRemoved onChildViewRemoved) {
        if (onChildViewAdded == null && onChildViewRemoved == null) {
            viewGroup.setOnHierarchyChangeListener(null);
        } else {
            viewGroup.setOnHierarchyChangeListener(new androidx.databinding.adapters.ViewGroupBindingAdapter.AnonymousClass1(onChildViewAdded, onChildViewRemoved));
        }
    }
}
