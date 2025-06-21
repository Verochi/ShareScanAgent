package androidx.core.view;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final androidx.core.view.WindowInsetsAnimationControllerCompat.Impl mImpl;

    public static class Impl {
        public void finish(boolean z) {
        }

        public float getCurrentAlpha() {
            return 0.0f;
        }

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        public float getCurrentFraction() {
            return 0.0f;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getCurrentInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getHiddenStateInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getShownStateInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        public boolean isCancelled() {
            return true;
        }

        public boolean isFinished() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public void setInsetsAndAlpha(@androidx.annotation.Nullable androidx.core.graphics.Insets insets, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2) {
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class Impl30 extends androidx.core.view.WindowInsetsAnimationControllerCompat.Impl {
        private final android.view.WindowInsetsAnimationController mController;

        public Impl30(@androidx.annotation.NonNull android.view.WindowInsetsAnimationController windowInsetsAnimationController) {
            this.mController = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void finish(boolean z) {
            this.mController.finish(z);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentAlpha() {
            float currentAlpha;
            currentAlpha = this.mController.getCurrentAlpha();
            return currentAlpha;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            float currentFraction;
            currentFraction = this.mController.getCurrentFraction();
            return currentFraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getCurrentInsets() {
            android.graphics.Insets currentInsets;
            currentInsets = this.mController.getCurrentInsets();
            return androidx.core.graphics.Insets.toCompatInsets(currentInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getHiddenStateInsets() {
            android.graphics.Insets hiddenStateInsets;
            hiddenStateInsets = this.mController.getHiddenStateInsets();
            return androidx.core.graphics.Insets.toCompatInsets(hiddenStateInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getShownStateInsets() {
            android.graphics.Insets shownStateInsets;
            shownStateInsets = this.mController.getShownStateInsets();
            return androidx.core.graphics.Insets.toCompatInsets(shownStateInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public int getTypes() {
            int types;
            types = this.mController.getTypes();
            return types;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isCancelled() {
            boolean isCancelled;
            isCancelled = this.mController.isCancelled();
            return isCancelled;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isFinished() {
            boolean isFinished;
            isFinished = this.mController.isFinished();
            return isFinished;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isReady() {
            boolean isReady;
            isReady = this.mController.isReady();
            return isReady;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(@androidx.annotation.Nullable androidx.core.graphics.Insets insets, float f, float f2) {
            this.mController.setInsetsAndAlpha(insets == null ? null : insets.toPlatformInsets(), f, f2);
        }
    }

    public WindowInsetsAnimationControllerCompat() {
        if (android.os.Build.VERSION.SDK_INT < 30) {
            this.mImpl = new androidx.core.view.WindowInsetsAnimationControllerCompat.Impl();
            return;
        }
        throw new java.lang.UnsupportedOperationException("On API 30+, the constructor taking a " + android.view.WindowInsetsAnimationController.class.getSimpleName() + " as parameter");
    }

    @androidx.annotation.RequiresApi(30)
    public WindowInsetsAnimationControllerCompat(@androidx.annotation.NonNull android.view.WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new androidx.core.view.WindowInsetsAnimationControllerCompat.Impl30(windowInsetsAnimationController);
    }

    public void finish(boolean z) {
        this.mImpl.finish(z);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    @androidx.annotation.NonNull
    public androidx.core.graphics.Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    @androidx.annotation.NonNull
    public androidx.core.graphics.Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    @androidx.annotation.NonNull
    public androidx.core.graphics.Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }

    public void setInsetsAndAlpha(@androidx.annotation.Nullable androidx.core.graphics.Insets insets, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mImpl.setInsetsAndAlpha(insets, f, f2);
    }
}
