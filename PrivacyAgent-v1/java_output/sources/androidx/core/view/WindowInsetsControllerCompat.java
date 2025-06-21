package androidx.core.view;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final androidx.core.view.WindowInsetsControllerCompat.Impl mImpl;

    public static class Impl {
        public void addOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void controlWindowInsetsAnimation(int i, long j, android.view.animation.Interpolator interpolator, android.os.CancellationSignal cancellationSignal, androidx.core.view.WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        public int getSystemBarsBehavior() {
            return 0;
        }

        public void hide(int i) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        public void removeOnControllableInsetsChangedListener(@androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void setAppearanceLightNavigationBars(boolean z) {
        }

        public void setAppearanceLightStatusBars(boolean z) {
        }

        public void setSystemBarsBehavior(int i) {
        }

        public void show(int i) {
        }
    }

    @androidx.annotation.RequiresApi(20)
    public static class Impl20 extends androidx.core.view.WindowInsetsControllerCompat.Impl {

        @androidx.annotation.Nullable
        private final android.view.View mView;

        @androidx.annotation.NonNull
        protected final android.view.Window mWindow;

        /* renamed from: androidx.core.view.WindowInsetsControllerCompat$Impl20$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.view.View val$finalView;

            public AnonymousClass1(android.view.View view) {
                this.val$finalView = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((android.view.inputmethod.InputMethodManager) this.val$finalView.getContext().getSystemService("input_method")).showSoftInput(this.val$finalView, 0);
            }
        }

        public Impl20(@androidx.annotation.NonNull android.view.Window window, @androidx.annotation.Nullable android.view.View view) {
            this.mWindow = window;
            this.mView = view;
        }

        private void hideForType(int i) {
            if (i == 1) {
                setSystemUiFlag(4);
            } else if (i == 2) {
                setSystemUiFlag(2);
            } else {
                if (i != 8) {
                    return;
                }
                ((android.view.inputmethod.InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
            }
        }

        private void showForType(int i) {
            if (i == 1) {
                unsetSystemUiFlag(4);
                unsetWindowFlag(1024);
                return;
            }
            if (i == 2) {
                unsetSystemUiFlag(2);
                return;
            }
            if (i != 8) {
                return;
            }
            android.view.View view = this.mView;
            if (view == null || !(view.isInEditMode() || view.onCheckIsTextEditor())) {
                view = this.mWindow.getCurrentFocus();
            } else {
                view.requestFocus();
            }
            if (view == null) {
                view = this.mWindow.findViewById(android.R.id.content);
            }
            if (view == null || !view.hasWindowFocus()) {
                return;
            }
            view.post(new androidx.core.view.WindowInsetsControllerCompat.Impl20.AnonymousClass1(view));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void addOnControllableInsetsChangedListener(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void controlWindowInsetsAnimation(int i, long j, android.view.animation.Interpolator interpolator, android.os.CancellationSignal cancellationSignal, androidx.core.view.WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void hide(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    hideForType(i2);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void removeOnControllableInsetsChangedListener(@androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setSystemBarsBehavior(int i) {
            if (i == 0) {
                unsetSystemUiFlag(com.badlogic.gdx.graphics.GL30.GL_COLOR);
                return;
            }
            if (i == 1) {
                unsetSystemUiFlag(4096);
                setSystemUiFlag(2048);
            } else {
                if (i != 2) {
                    return;
                }
                unsetSystemUiFlag(2048);
                setSystemUiFlag(4096);
            }
        }

        public void setSystemUiFlag(int i) {
            android.view.View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public void setWindowFlag(int i) {
            this.mWindow.addFlags(i);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void show(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    showForType(i2);
                }
            }
        }

        public void unsetSystemUiFlag(int i) {
            android.view.View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        public void unsetWindowFlag(int i) {
            this.mWindow.clearFlags(i);
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static class Impl23 extends androidx.core.view.WindowInsetsControllerCompat.Impl20 {
        public Impl23(@androidx.annotation.NonNull android.view.Window window, @androidx.annotation.Nullable android.view.View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if (!z) {
                unsetSystemUiFlag(8192);
                return;
            }
            unsetWindowFlag(67108864);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
        }
    }

    @androidx.annotation.RequiresApi(26)
    public static class Impl26 extends androidx.core.view.WindowInsetsControllerCompat.Impl23 {
        public Impl26(@androidx.annotation.NonNull android.view.Window window, @androidx.annotation.Nullable android.view.View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if (!z) {
                unsetSystemUiFlag(16);
                return;
            }
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class Impl30 extends androidx.core.view.WindowInsetsControllerCompat.Impl {
        final androidx.core.view.WindowInsetsControllerCompat mCompatController;
        final android.view.WindowInsetsController mInsetsController;
        private final androidx.collection.SimpleArrayMap<androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener, android.view.WindowInsetsController.OnControllableInsetsChangedListener> mListeners;

        /* renamed from: androidx.core.view.WindowInsetsControllerCompat$Impl30$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.WindowInsetsAnimationControlListener {
            private androidx.core.view.WindowInsetsAnimationControllerCompat mCompatAnimController = null;
            final /* synthetic */ androidx.core.view.WindowInsetsAnimationControlListenerCompat val$listener;

            public AnonymousClass1(androidx.core.view.WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
                this.val$listener = windowInsetsAnimationControlListenerCompat;
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onCancelled(@androidx.annotation.Nullable android.view.WindowInsetsAnimationController windowInsetsAnimationController) {
                this.val$listener.onCancelled(windowInsetsAnimationController == null ? null : this.mCompatAnimController);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onFinished(@androidx.annotation.NonNull android.view.WindowInsetsAnimationController windowInsetsAnimationController) {
                this.val$listener.onFinished(this.mCompatAnimController);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onReady(@androidx.annotation.NonNull android.view.WindowInsetsAnimationController windowInsetsAnimationController, int i) {
                androidx.core.view.WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new androidx.core.view.WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                this.mCompatAnimController = windowInsetsAnimationControllerCompat;
                this.val$listener.onReady(windowInsetsAnimationControllerCompat, i);
            }
        }

        /* renamed from: androidx.core.view.WindowInsetsControllerCompat$Impl30$2, reason: invalid class name */
        public class AnonymousClass2 implements android.view.WindowInsetsController.OnControllableInsetsChangedListener {
            final /* synthetic */ androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener val$listener;

            public AnonymousClass2(androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
                this.val$listener = onControllableInsetsChangedListener;
            }

            @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
            public void onControllableInsetsChanged(@androidx.annotation.NonNull android.view.WindowInsetsController windowInsetsController, int i) {
                androidx.core.view.WindowInsetsControllerCompat.Impl30 impl30 = androidx.core.view.WindowInsetsControllerCompat.Impl30.this;
                if (impl30.mInsetsController == windowInsetsController) {
                    this.val$listener.onControllableInsetsChanged(impl30.mCompatController, i);
                }
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Impl30(@androidx.annotation.NonNull android.view.Window window, @androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this(r1, windowInsetsControllerCompat);
            android.view.WindowInsetsController insetsController;
            insetsController = window.getInsetsController();
        }

        public Impl30(@androidx.annotation.NonNull android.view.WindowInsetsController windowInsetsController, @androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.mListeners = new androidx.collection.SimpleArrayMap<>();
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void addOnControllableInsetsChangedListener(@androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            androidx.core.view.WindowInsetsControllerCompat.Impl30.AnonymousClass2 anonymousClass2 = new androidx.core.view.WindowInsetsControllerCompat.Impl30.AnonymousClass2(onControllableInsetsChangedListener);
            this.mListeners.put(onControllableInsetsChangedListener, anonymousClass2);
            this.mInsetsController.addOnControllableInsetsChangedListener(anonymousClass2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void controlWindowInsetsAnimation(int i, long j, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.mInsetsController.controlWindowInsetsAnimation(i, j, interpolator, cancellationSignal, new androidx.core.view.WindowInsetsControllerCompat.Impl30.AnonymousClass1(windowInsetsAnimationControlListenerCompat));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public int getSystemBarsBehavior() {
            int systemBarsBehavior;
            systemBarsBehavior = this.mInsetsController.getSystemBarsBehavior();
            return systemBarsBehavior;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void hide(int i) {
            this.mInsetsController.hide(i);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            int systemBarsAppearance;
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            return (systemBarsAppearance & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            int systemBarsAppearance;
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            return (systemBarsAppearance & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void removeOnControllableInsetsChangedListener(@androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            android.view.WindowInsetsController.OnControllableInsetsChangedListener remove = this.mListeners.remove(onControllableInsetsChangedListener);
            if (remove != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(remove);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if (z) {
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if (z) {
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setSystemBarsBehavior(int i) {
            this.mInsetsController.setSystemBarsBehavior(i);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void show(int i) {
            this.mInsetsController.show(i);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat windowInsetsControllerCompat, int i);
    }

    public WindowInsetsControllerCompat(@androidx.annotation.NonNull android.view.Window window, @androidx.annotation.NonNull android.view.View view) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new androidx.core.view.WindowInsetsControllerCompat.Impl30(window, this);
            return;
        }
        if (i >= 26) {
            this.mImpl = new androidx.core.view.WindowInsetsControllerCompat.Impl26(window, view);
        } else if (i >= 23) {
            this.mImpl = new androidx.core.view.WindowInsetsControllerCompat.Impl23(window, view);
        } else {
            this.mImpl = new androidx.core.view.WindowInsetsControllerCompat.Impl20(window, view);
        }
    }

    @androidx.annotation.RequiresApi(30)
    private WindowInsetsControllerCompat(@androidx.annotation.NonNull android.view.WindowInsetsController windowInsetsController) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new androidx.core.view.WindowInsetsControllerCompat.Impl30(windowInsetsController, this);
        } else {
            this.mImpl = new androidx.core.view.WindowInsetsControllerCompat.Impl();
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(30)
    public static androidx.core.view.WindowInsetsControllerCompat toWindowInsetsControllerCompat(@androidx.annotation.NonNull android.view.WindowInsetsController windowInsetsController) {
        return new androidx.core.view.WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i, long j, @androidx.annotation.Nullable android.view.animation.Interpolator interpolator, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.view.WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(i, j, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int i) {
        this.mImpl.hide(i);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z) {
        this.mImpl.setAppearanceLightNavigationBars(z);
    }

    public void setAppearanceLightStatusBars(boolean z) {
        this.mImpl.setAppearanceLightStatusBars(z);
    }

    public void setSystemBarsBehavior(int i) {
        this.mImpl.setSystemBarsBehavior(i);
    }

    public void show(int i) {
        this.mImpl.show(i);
    }
}
