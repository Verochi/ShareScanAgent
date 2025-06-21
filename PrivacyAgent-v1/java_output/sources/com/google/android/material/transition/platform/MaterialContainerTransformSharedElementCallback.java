package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
public class MaterialContainerTransformSharedElementCallback extends android.app.SharedElementCallback {

    @androidx.annotation.Nullable
    private static java.lang.ref.WeakReference<android.view.View> capturedSharedElement;

    @androidx.annotation.Nullable
    private android.graphics.Rect returnEndBounds;
    private boolean entering = true;
    private boolean transparentWindowBackgroundEnabled = true;
    private boolean sharedElementReenterTransitionEnabled = false;

    @androidx.annotation.Nullable
    private com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider shapeProvider = new com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeableViewShapeProvider();

    /* renamed from: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.material.transition.platform.TransitionListenerAdapter {
        final /* synthetic */ android.view.Window val$window;

        public AnonymousClass1(android.view.Window window) {
            this.val$window = window;
        }

        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
        public void onTransitionEnd(android.transition.Transition transition) {
            com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.restoreWindowBackground(this.val$window);
        }

        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
        public void onTransitionStart(android.transition.Transition transition) {
            com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.removeWindowBackground(this.val$window);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.android.material.transition.platform.TransitionListenerAdapter {
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass2(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
        public void onTransitionEnd(android.transition.Transition transition) {
            android.view.View view;
            if (com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.capturedSharedElement != null && (view = (android.view.View) com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.capturedSharedElement.get()) != null) {
                view.setAlpha(1.0f);
                java.lang.ref.WeakReference unused = com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
            }
            this.val$activity.finish();
            this.val$activity.overridePendingTransition(0, 0);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.android.material.transition.platform.TransitionListenerAdapter {
        final /* synthetic */ android.view.Window val$window;

        public AnonymousClass3(android.view.Window window) {
            this.val$window = window;
        }

        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
        public void onTransitionStart(android.transition.Transition transition) {
            com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.removeWindowBackground(this.val$window);
        }
    }

    public interface ShapeProvider {
        @androidx.annotation.Nullable
        com.google.android.material.shape.ShapeAppearanceModel provideShape(@androidx.annotation.NonNull android.view.View view);
    }

    public static class ShapeableViewShapeProvider implements com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        @androidx.annotation.Nullable
        public com.google.android.material.shape.ShapeAppearanceModel provideShape(@androidx.annotation.NonNull android.view.View view) {
            if (view instanceof com.google.android.material.shape.Shapeable) {
                return ((com.google.android.material.shape.Shapeable) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeWindowBackground(android.view.Window window) {
        window.getDecorView().getBackground().mutate().setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, androidx.core.graphics.BlendModeCompat.CLEAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void restoreWindowBackground(android.view.Window window) {
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private void setUpEnterTransform(android.view.Window window) {
        android.transition.Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof com.google.android.material.transition.platform.MaterialContainerTransform) {
            com.google.android.material.transition.platform.MaterialContainerTransform materialContainerTransform = (com.google.android.material.transition.platform.MaterialContainerTransform) sharedElementEnterTransition;
            if (!this.sharedElementReenterTransitionEnabled) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.AnonymousClass1(window));
            }
        }
    }

    private void setUpReturnTransform(android.app.Activity activity, android.view.Window window) {
        android.transition.Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof com.google.android.material.transition.platform.MaterialContainerTransform) {
            com.google.android.material.transition.platform.MaterialContainerTransform materialContainerTransform = (com.google.android.material.transition.platform.MaterialContainerTransform) sharedElementReturnTransition;
            materialContainerTransform.setHoldAtEndEnabled(true);
            materialContainerTransform.addListener(new com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.AnonymousClass2(activity));
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.AnonymousClass3(window));
            }
        }
    }

    private static void updateBackgroundFadeDuration(android.view.Window window, com.google.android.material.transition.platform.MaterialContainerTransform materialContainerTransform) {
        if (materialContainerTransform.getDuration() >= 0) {
            window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
        }
    }

    @androidx.annotation.Nullable
    public com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    @Override // android.app.SharedElementCallback
    @androidx.annotation.Nullable
    public android.os.Parcelable onCaptureSharedElementSnapshot(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Matrix matrix, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        capturedSharedElement = new java.lang.ref.WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    @androidx.annotation.Nullable
    public android.view.View onCreateSnapshotView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.Parcelable parcelable) {
        java.lang.ref.WeakReference<android.view.View> weakReference;
        android.view.View view;
        com.google.android.material.shape.ShapeAppearanceModel provideShape;
        android.view.View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (onCreateSnapshotView != null && (weakReference = capturedSharedElement) != null && this.shapeProvider != null && (view = weakReference.get()) != null && (provideShape = this.shapeProvider.provideShape(view)) != null) {
            onCreateSnapshotView.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, provideShape);
        }
        return onCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@androidx.annotation.NonNull java.util.List<java.lang.String> list, @androidx.annotation.NonNull java.util.Map<java.lang.String, android.view.View> map) {
        android.view.View view;
        android.app.Activity activity;
        if (list.isEmpty() || map.isEmpty() || (view = map.get(list.get(0))) == null || (activity = com.google.android.material.internal.ContextUtils.getActivity(view.getContext())) == null) {
            return;
        }
        android.view.Window window = activity.getWindow();
        if (this.entering) {
            setUpEnterTransform(window);
        } else {
            setUpReturnTransform(activity, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@androidx.annotation.NonNull java.util.List<java.lang.String> list, @androidx.annotation.NonNull java.util.List<android.view.View> list2, @androidx.annotation.NonNull java.util.List<android.view.View> list3) {
        if (!list2.isEmpty()) {
            android.view.View view = list2.get(0);
            int i = com.google.android.material.R.id.mtrl_motion_snapshot_view;
            if (view.getTag(i) instanceof android.view.View) {
                list2.get(0).setTag(i, null);
            }
        }
        if (!this.entering && !list2.isEmpty()) {
            this.returnEndBounds = com.google.android.material.transition.platform.TransitionUtils.getRelativeBoundsRect(list2.get(0));
        }
        this.entering = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@androidx.annotation.NonNull java.util.List<java.lang.String> list, @androidx.annotation.NonNull java.util.List<android.view.View> list2, @androidx.annotation.NonNull java.util.List<android.view.View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (this.entering || list2.isEmpty() || this.returnEndBounds == null) {
            return;
        }
        android.view.View view = list2.get(0);
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
        android.graphics.Rect rect = this.returnEndBounds;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setShapeProvider(@androidx.annotation.Nullable com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider shapeProvider) {
        this.shapeProvider = shapeProvider;
    }

    public void setSharedElementReenterTransitionEnabled(boolean z) {
        this.sharedElementReenterTransitionEnabled = z;
    }

    public void setTransparentWindowBackgroundEnabled(boolean z) {
        this.transparentWindowBackgroundEnabled = z;
    }
}
