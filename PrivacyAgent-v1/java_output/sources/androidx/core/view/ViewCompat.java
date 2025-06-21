package androidx.core.view;

@android.annotation.SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

    @java.lang.Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @java.lang.Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @java.lang.Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @java.lang.Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @java.lang.Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @java.lang.Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @java.lang.Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @java.lang.Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @java.lang.Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @java.lang.Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final java.lang.String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static java.lang.reflect.Field sAccessibilityDelegateField;
    private static java.lang.reflect.Method sChildrenDrawingOrderMethod;
    private static java.lang.reflect.Method sDispatchFinishTemporaryDetach;
    private static java.lang.reflect.Method sDispatchStartTemporaryDetach;
    private static java.lang.reflect.Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static java.lang.reflect.Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static boolean sTempDetachBound;
    private static java.lang.ThreadLocal<android.graphics.Rect> sThreadLocalRect;
    private static java.util.WeakHashMap<android.view.View, java.lang.String> sTransitionNameMap;
    private static final java.util.concurrent.atomic.AtomicInteger sNextGeneratedId = new java.util.concurrent.atomic.AtomicInteger(1);
    private static java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {androidx.core.R.id.accessibility_custom_action_0, androidx.core.R.id.accessibility_custom_action_1, androidx.core.R.id.accessibility_custom_action_2, androidx.core.R.id.accessibility_custom_action_3, androidx.core.R.id.accessibility_custom_action_4, androidx.core.R.id.accessibility_custom_action_5, androidx.core.R.id.accessibility_custom_action_6, androidx.core.R.id.accessibility_custom_action_7, androidx.core.R.id.accessibility_custom_action_8, androidx.core.R.id.accessibility_custom_action_9, androidx.core.R.id.accessibility_custom_action_10, androidx.core.R.id.accessibility_custom_action_11, androidx.core.R.id.accessibility_custom_action_12, androidx.core.R.id.accessibility_custom_action_13, androidx.core.R.id.accessibility_custom_action_14, androidx.core.R.id.accessibility_custom_action_15, androidx.core.R.id.accessibility_custom_action_16, androidx.core.R.id.accessibility_custom_action_17, androidx.core.R.id.accessibility_custom_action_18, androidx.core.R.id.accessibility_custom_action_19, androidx.core.R.id.accessibility_custom_action_20, androidx.core.R.id.accessibility_custom_action_21, androidx.core.R.id.accessibility_custom_action_22, androidx.core.R.id.accessibility_custom_action_23, androidx.core.R.id.accessibility_custom_action_24, androidx.core.R.id.accessibility_custom_action_25, androidx.core.R.id.accessibility_custom_action_26, androidx.core.R.id.accessibility_custom_action_27, androidx.core.R.id.accessibility_custom_action_28, androidx.core.R.id.accessibility_custom_action_29, androidx.core.R.id.accessibility_custom_action_30, androidx.core.R.id.accessibility_custom_action_31};
    private static final androidx.core.view.OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new androidx.core.view.ViewCompat.AnonymousClass1();
    private static androidx.core.view.ViewCompat.AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new androidx.core.view.ViewCompat.AccessibilityPaneVisibilityManager();

    /* renamed from: androidx.core.view.ViewCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.core.view.OnReceiveContentViewBehavior {
        @Override // androidx.core.view.OnReceiveContentViewBehavior
        public androidx.core.view.ContentInfoCompat onReceiveContent(@androidx.annotation.NonNull androidx.core.view.ContentInfoCompat contentInfoCompat) {
            return contentInfoCompat;
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.Boolean> {
        public AnonymousClass2(int i, java.lang.Class cls, int i2) {
            super(i, cls, i2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(28)
        public java.lang.Boolean frameworkGet(android.view.View view) {
            boolean isScreenReaderFocusable;
            isScreenReaderFocusable = view.isScreenReaderFocusable();
            return java.lang.Boolean.valueOf(isScreenReaderFocusable);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(28)
        public void frameworkSet(android.view.View view, java.lang.Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public boolean shouldUpdate(java.lang.Boolean bool, java.lang.Boolean bool2) {
            return !booleanNullToFalseEquals(bool, bool2);
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.CharSequence> {
        public AnonymousClass3(int i, java.lang.Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(28)
        public java.lang.CharSequence frameworkGet(android.view.View view) {
            java.lang.CharSequence accessibilityPaneTitle;
            accessibilityPaneTitle = view.getAccessibilityPaneTitle();
            return accessibilityPaneTitle;
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(28)
        public void frameworkSet(android.view.View view, java.lang.CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public boolean shouldUpdate(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            return !android.text.TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.CharSequence> {
        public AnonymousClass4(int i, java.lang.Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(30)
        public java.lang.CharSequence frameworkGet(android.view.View view) {
            java.lang.CharSequence stateDescription;
            stateDescription = view.getStateDescription();
            return stateDescription;
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(30)
        public void frameworkSet(android.view.View view, java.lang.CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public boolean shouldUpdate(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            return !android.text.TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$5, reason: invalid class name */
    public class AnonymousClass5 extends androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.Boolean> {
        public AnonymousClass5(int i, java.lang.Class cls, int i2) {
            super(i, cls, i2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(28)
        public java.lang.Boolean frameworkGet(android.view.View view) {
            boolean isAccessibilityHeading;
            isAccessibilityHeading = view.isAccessibilityHeading();
            return java.lang.Boolean.valueOf(isAccessibilityHeading);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        @androidx.annotation.RequiresApi(28)
        public void frameworkSet(android.view.View view, java.lang.Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public boolean shouldUpdate(java.lang.Boolean bool, java.lang.Boolean bool2) {
            return !booleanNullToFalseEquals(bool, bool2);
        }
    }

    public static class AccessibilityPaneVisibilityManager implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.View.OnAttachStateChangeListener {
        private java.util.WeakHashMap<android.view.View, java.lang.Boolean> mPanesToVisible = new java.util.WeakHashMap<>();

        @androidx.annotation.RequiresApi(19)
        private void checkPaneVisibility(android.view.View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                androidx.core.view.ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, z2 ? 16 : 32);
                this.mPanesToVisible.put(view, java.lang.Boolean.valueOf(z2));
            }
        }

        @androidx.annotation.RequiresApi(19)
        private void registerForLayoutCallback(android.view.View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @androidx.annotation.RequiresApi(19)
        private void unregisterForLayoutCallback(android.view.View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @androidx.annotation.RequiresApi(19)
        public void addAccessibilityPane(android.view.View view) {
            this.mPanesToVisible.put(view, java.lang.Boolean.valueOf(view.getVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                registerForLayoutCallback(view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @androidx.annotation.RequiresApi(19)
        public void onGlobalLayout() {
            if (android.os.Build.VERSION.SDK_INT < 28) {
                for (java.util.Map.Entry<android.view.View, java.lang.Boolean> entry : this.mPanesToVisible.entrySet()) {
                    checkPaneVisibility(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @androidx.annotation.RequiresApi(19)
        public void onViewAttachedToWindow(android.view.View view) {
            registerForLayoutCallback(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
        }

        @androidx.annotation.RequiresApi(19)
        public void removeAccessibilityPane(android.view.View view) {
            this.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(view);
        }
    }

    public static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final java.lang.Class<T> mType;

        public AccessibilityViewProperty(int i, java.lang.Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        public AccessibilityViewProperty(int i, java.lang.Class<T> cls, int i2, int i3) {
            this.mTagKey = i;
            this.mType = cls;
            this.mContentChangeType = i2;
            this.mFrameworkMinimumSdk = i3;
        }

        private boolean extrasAvailable() {
            return true;
        }

        private boolean frameworkAvailable() {
            return android.os.Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
        }

        public boolean booleanNullToFalseEquals(java.lang.Boolean bool, java.lang.Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public abstract T frameworkGet(android.view.View view);

        public abstract void frameworkSet(android.view.View view, T t);

        public T get(android.view.View view) {
            if (frameworkAvailable()) {
                return frameworkGet(view);
            }
            if (!extrasAvailable()) {
                return null;
            }
            T t = (T) view.getTag(this.mTagKey);
            if (this.mType.isInstance(t)) {
                return t;
            }
            return null;
        }

        public void set(android.view.View view, T t) {
            if (frameworkAvailable()) {
                frameworkSet(view, t);
            } else if (extrasAvailable() && shouldUpdate(get(view), t)) {
                androidx.core.view.ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
                view.setTag(this.mTagKey, t);
                androidx.core.view.ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
            }
        }

        public boolean shouldUpdate(T t, T t2) {
            return !t2.equals(t);
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static class Api21Impl {

        /* renamed from: androidx.core.view.ViewCompat$Api21Impl$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnApplyWindowInsetsListener {
            androidx.core.view.WindowInsetsCompat mLastInsets = null;
            final /* synthetic */ androidx.core.view.OnApplyWindowInsetsListener val$listener;
            final /* synthetic */ android.view.View val$v;

            public AnonymousClass1(android.view.View view, androidx.core.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
                this.val$v = view;
                this.val$listener = onApplyWindowInsetsListener;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public android.view.WindowInsets onApplyWindowInsets(android.view.View view, android.view.WindowInsets windowInsets) {
                androidx.core.view.WindowInsetsCompat windowInsetsCompat = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                int i = android.os.Build.VERSION.SDK_INT;
                if (i < 30) {
                    androidx.core.view.ViewCompat.Api21Impl.callCompatInsetAnimationCallback(windowInsets, this.val$v);
                    if (windowInsetsCompat.equals(this.mLastInsets)) {
                        return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
                    }
                }
                this.mLastInsets = windowInsetsCompat;
                androidx.core.view.WindowInsetsCompat onApplyWindowInsets = this.val$listener.onApplyWindowInsets(view, windowInsetsCompat);
                if (i >= 30) {
                    return onApplyWindowInsets.toWindowInsets();
                }
                androidx.core.view.ViewCompat.requestApplyInsets(view);
                return onApplyWindowInsets.toWindowInsets();
            }
        }

        private Api21Impl() {
        }

        public static void callCompatInsetAnimationCallback(@androidx.annotation.NonNull android.view.WindowInsets windowInsets, @androidx.annotation.NonNull android.view.View view) {
            android.view.View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (android.view.View.OnApplyWindowInsetsListener) view.getTag(androidx.core.R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static androidx.core.view.WindowInsetsCompat computeSystemWindowInsets(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull android.graphics.Rect rect) {
            android.view.WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @androidx.annotation.Nullable
        public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(@androidx.annotation.NonNull android.view.View view) {
            return androidx.core.view.WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(view);
        }

        public static void setOnApplyWindowInsetsListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (android.os.Build.VERSION.SDK_INT < 30) {
                view.setTag(androidx.core.R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((android.view.View.OnApplyWindowInsetsListener) view.getTag(androidx.core.R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new androidx.core.view.ViewCompat.Api21Impl.AnonymousClass1(view, onApplyWindowInsetsListener));
            }
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @androidx.annotation.Nullable
        public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(@androidx.annotation.NonNull android.view.View view) {
            android.view.WindowInsets rootWindowInsets;
            rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
            return windowInsetsCompat;
        }
    }

    @androidx.annotation.RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void saveAttributeDataForStyleable(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull int[] iArr, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @androidx.annotation.Nullable
        public static androidx.core.view.WindowInsetsControllerCompat getWindowInsetsController(@androidx.annotation.NonNull android.view.View view) {
            android.view.WindowInsetsController windowInsetsController;
            windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return androidx.core.view.WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
            }
            return null;
        }
    }

    @androidx.annotation.RequiresApi(28)
    public static class CompatImplApi28 {

        /* renamed from: androidx.core.view.ViewCompat$CompatImplApi28$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnUnhandledKeyEventListener {
            final /* synthetic */ androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat val$listener;

            public AnonymousClass1(androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
                this.val$listener = onUnhandledKeyEventListenerCompat;
            }

            @Override // android.view.View.OnUnhandledKeyEventListener
            public boolean onUnhandledKeyEvent(android.view.View view, android.view.KeyEvent keyEvent) {
                return this.val$listener.onUnhandledKeyEvent(view, keyEvent);
            }
        }

        private CompatImplApi28() {
        }

        public static void addOnUnhandledKeyEventListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            int i = androidx.core.R.id.tag_unhandled_key_listeners;
            androidx.collection.SimpleArrayMap simpleArrayMap = (androidx.collection.SimpleArrayMap) view.getTag(i);
            if (simpleArrayMap == null) {
                simpleArrayMap = new androidx.collection.SimpleArrayMap();
                view.setTag(i, simpleArrayMap);
            }
            androidx.core.view.ViewCompat.CompatImplApi28.AnonymousClass1 anonymousClass1 = new androidx.core.view.ViewCompat.CompatImplApi28.AnonymousClass1(onUnhandledKeyEventListenerCompat);
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, anonymousClass1);
            view.addOnUnhandledKeyEventListener(anonymousClass1);
        }

        public static void removeOnUnhandledKeyEventListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            android.view.View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            androidx.collection.SimpleArrayMap simpleArrayMap = (androidx.collection.SimpleArrayMap) view.getTag(androidx.core.R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null || (onUnhandledKeyEventListener = (android.view.View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusDirection {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRealDirection {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRelativeDirection {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NestedScrollType {
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(android.view.View view, android.view.KeyEvent keyEvent);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    public static class UnhandledKeyEventManager {
        private static final java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> sViewsWithListeners = new java.util.ArrayList<>();

        @androidx.annotation.Nullable
        private java.util.WeakHashMap<android.view.View, java.lang.Boolean> mViewsContainingListeners = null;
        private android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> mCapturedKeys = null;
        private java.lang.ref.WeakReference<android.view.KeyEvent> mLastDispatchedPreViewKeyEvent = null;

        public static androidx.core.view.ViewCompat.UnhandledKeyEventManager at(android.view.View view) {
            int i = androidx.core.R.id.tag_unhandled_key_event_manager;
            androidx.core.view.ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager = (androidx.core.view.ViewCompat.UnhandledKeyEventManager) view.getTag(i);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            androidx.core.view.ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager2 = new androidx.core.view.ViewCompat.UnhandledKeyEventManager();
            view.setTag(i, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        @androidx.annotation.Nullable
        private android.view.View dispatchInOrder(android.view.View view, android.view.KeyEvent keyEvent) {
            java.util.WeakHashMap<android.view.View, java.lang.Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof android.view.ViewGroup) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        android.view.View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                        if (dispatchInOrder != null) {
                            return dispatchInOrder;
                        }
                    }
                }
                if (onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new android.util.SparseArray<>();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
            java.util.ArrayList arrayList = (java.util.ArrayList) view.getTag(androidx.core.R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            java.util.WeakHashMap<android.view.View, java.lang.Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> arrayList = sViewsWithListeners;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.mViewsContainingListeners == null) {
                    this.mViewsContainingListeners = new java.util.WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> arrayList2 = sViewsWithListeners;
                    android.view.View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.mViewsContainingListeners.put(view, java.lang.Boolean.TRUE);
                        for (android.view.ViewParent parent = view.getParent(); parent instanceof android.view.View; parent = parent.getParent()) {
                            this.mViewsContainingListeners.put((android.view.View) parent, java.lang.Boolean.TRUE);
                        }
                    }
                }
            }
        }

        public static void registerListeningView(android.view.View view) {
            java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                java.util.Iterator<java.lang.ref.WeakReference<android.view.View>> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                sViewsWithListeners.add(new java.lang.ref.WeakReference<>(view));
            }
        }

        public static void unregisterListeningView(android.view.View view) {
            synchronized (sViewsWithListeners) {
                int i = 0;
                while (true) {
                    java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> arrayList = sViewsWithListeners;
                    if (i >= arrayList.size()) {
                        return;
                    }
                    if (arrayList.get(i).get() == view) {
                        arrayList.remove(i);
                        return;
                    }
                    i++;
                }
            }
        }

        public boolean dispatch(android.view.View view, android.view.KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            android.view.View dispatchInOrder = dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (dispatchInOrder != null && !android.view.KeyEvent.isModifierKey(keyCode)) {
                    getCapturedKeys().put(keyCode, new java.lang.ref.WeakReference<>(dispatchInOrder));
                }
            }
            return dispatchInOrder != null;
        }

        public boolean preDispatch(android.view.KeyEvent keyEvent) {
            java.lang.ref.WeakReference<android.view.View> weakReference;
            int indexOfKey;
            java.lang.ref.WeakReference<android.view.KeyEvent> weakReference2 = this.mLastDispatchedPreViewKeyEvent;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new java.lang.ref.WeakReference<>(keyEvent);
            android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> capturedKeys = getCapturedKeys();
            if (keyEvent.getAction() != 1 || (indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = capturedKeys.valueAt(indexOfKey);
                capturedKeys.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = capturedKeys.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            android.view.View view = weakReference.get();
            if (view != null && androidx.core.view.ViewCompat.isAttachedToWindow(view)) {
                onUnhandledKeyEvent(view, keyEvent);
            }
            return true;
        }
    }

    @java.lang.Deprecated
    public ViewCompat() {
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.Boolean> accessibilityHeadingProperty() {
        return new androidx.core.view.ViewCompat.AnonymousClass5(androidx.core.R.id.tag_accessibility_heading, java.lang.Boolean.class, 28);
    }

    public static int addAccessibilityAction(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.CharSequence charSequence, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityViewCommand accessibilityViewCommand) {
        int availableActionIdFromResources = getAvailableActionIdFromResources(view);
        if (availableActionIdFromResources != -1) {
            addAccessibilityAction(view, new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
        }
        return availableActionIdFromResources;
    }

    private static void addAccessibilityAction(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        getOrCreateAccessibilityDelegateCompat(view);
        removeActionWithId(accessibilityActionCompat.getId(), view);
        getActionList(view).add(accessibilityActionCompat);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void addKeyboardNavigationClusters(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.util.Collection<android.view.View> collection, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.addKeyboardNavigationClusters(collection, i);
        }
    }

    public static void addOnUnhandledKeyEventListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            androidx.core.view.ViewCompat.CompatImplApi28.addOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        int i = androidx.core.R.id.tag_unhandled_key_listeners;
        java.util.ArrayList arrayList = (java.util.ArrayList) view.getTag(i);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            view.setTag(i, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            androidx.core.view.ViewCompat.UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    @androidx.annotation.NonNull
    public static androidx.core.view.ViewPropertyAnimatorCompat animate(@androidx.annotation.NonNull android.view.View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new java.util.WeakHashMap<>();
        }
        androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        androidx.core.view.ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new androidx.core.view.ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = android.view.View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new java.lang.Class[0]);
            sDispatchFinishTemporaryDetach = android.view.View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new java.lang.Class[0]);
        } catch (java.lang.NoSuchMethodException unused) {
        }
        sTempDetachBound = true;
    }

    @java.lang.Deprecated
    public static boolean canScrollHorizontally(android.view.View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @java.lang.Deprecated
    public static boolean canScrollVertically(android.view.View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void cancelDragAndDrop(@androidx.annotation.NonNull android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            view.cancelDragAndDrop();
        }
    }

    @java.lang.Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return android.view.View.combineMeasuredStates(i, i2);
    }

    private static void compatOffsetLeftAndRight(android.view.View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                tickleInvalidationFlag((android.view.View) parent);
            }
        }
    }

    private static void compatOffsetTopAndBottom(android.view.View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                tickleInvalidationFlag((android.view.View) parent);
            }
        }
    }

    @androidx.annotation.NonNull
    public static androidx.core.view.WindowInsetsCompat computeSystemWindowInsets(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull android.graphics.Rect rect) {
        return androidx.core.view.ViewCompat.Api21Impl.computeSystemWindowInsets(view, windowInsetsCompat, rect);
    }

    @androidx.annotation.NonNull
    public static androidx.core.view.WindowInsetsCompat dispatchApplyWindowInsets(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        android.view.WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            android.view.WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (!dispatchApplyWindowInsets.equals(windowInsets)) {
                return androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(dispatchApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(@androidx.annotation.NonNull android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            view.dispatchFinishTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        java.lang.reflect.Method method = sDispatchFinishTemporaryDetach;
        if (method == null) {
            view.onFinishTemporaryDetach();
        } else {
            try {
                method.invoke(view, new java.lang.Object[0]);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static boolean dispatchNestedFling(@androidx.annotation.NonNull android.view.View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    public static boolean dispatchNestedPreFling(@androidx.annotation.NonNull android.view.View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    public static boolean dispatchNestedPreScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, @androidx.annotation.Nullable int[] iArr, @androidx.annotation.Nullable int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, @androidx.annotation.Nullable int[] iArr, @androidx.annotation.Nullable int[] iArr2, int i3) {
        if (view instanceof androidx.core.view.NestedScrollingChild2) {
            return ((androidx.core.view.NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        if (i3 == 0) {
            return dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatchNestedScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, @androidx.annotation.Nullable int[] iArr, int i5, @androidx.annotation.NonNull int[] iArr2) {
        if (view instanceof androidx.core.view.NestedScrollingChild3) {
            ((androidx.core.view.NestedScrollingChild3) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
        } else {
            dispatchNestedScroll(view, i, i2, i3, i4, iArr, i5);
        }
    }

    public static boolean dispatchNestedScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, @androidx.annotation.Nullable int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4, @androidx.annotation.Nullable int[] iArr, int i5) {
        if (view instanceof androidx.core.view.NestedScrollingChild2) {
            return ((androidx.core.view.NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        if (i5 == 0) {
            return dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }
        return false;
    }

    public static void dispatchStartTemporaryDetach(@androidx.annotation.NonNull android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            view.dispatchStartTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        java.lang.reflect.Method method = sDispatchStartTemporaryDetach;
        if (method == null) {
            view.onStartTemporaryDetach();
        } else {
            try {
                method.invoke(view, new java.lang.Object[0]);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    @androidx.annotation.UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(android.view.View view, android.view.KeyEvent keyEvent) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return androidx.core.view.ViewCompat.UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
    }

    @androidx.annotation.UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(android.view.View view, android.view.KeyEvent keyEvent) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return androidx.core.view.ViewCompat.UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
    }

    public static void enableAccessibleClickableSpanSupport(android.view.View view) {
        getOrCreateAccessibilityDelegateCompat(view);
    }

    public static int generateViewId() {
        return android.view.View.generateViewId();
    }

    @androidx.annotation.Nullable
    public static androidx.core.view.AccessibilityDelegateCompat getAccessibilityDelegate(@androidx.annotation.NonNull android.view.View view) {
        android.view.View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        return accessibilityDelegateInternal instanceof androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat : new androidx.core.view.AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    @androidx.annotation.Nullable
    private static android.view.View.AccessibilityDelegate getAccessibilityDelegateInternal(@androidx.annotation.NonNull android.view.View view) {
        android.view.View.AccessibilityDelegate accessibilityDelegate;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return getAccessibilityDelegateThroughReflection(view);
        }
        accessibilityDelegate = view.getAccessibilityDelegate();
        return accessibilityDelegate;
    }

    @androidx.annotation.Nullable
    private static android.view.View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@androidx.annotation.NonNull android.view.View view) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            java.lang.Object obj = sAccessibilityDelegateField.get(view);
            if (obj instanceof android.view.View.AccessibilityDelegate) {
                return (android.view.View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (java.lang.Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static int getAccessibilityLiveRegion(@androidx.annotation.NonNull android.view.View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static androidx.core.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@androidx.annotation.NonNull android.view.View view) {
        android.view.accessibility.AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return new androidx.core.view.accessibility.AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    @androidx.annotation.UiThread
    public static java.lang.CharSequence getAccessibilityPaneTitle(android.view.View view) {
        return paneTitleProperty().get(view);
    }

    private static java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(android.view.View view) {
        int i = androidx.core.R.id.tag_accessibility_actions;
        java.util.ArrayList arrayList = (java.util.ArrayList) view.getTag(i);
        if (arrayList != null) {
            return arrayList;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        view.setTag(i, arrayList2);
        return arrayList2;
    }

    @java.lang.Deprecated
    public static float getAlpha(android.view.View view) {
        return view.getAlpha();
    }

    private static int getAvailableActionIdFromResources(android.view.View view) {
        java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        int i = 0;
        int i2 = -1;
        while (true) {
            int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if (i >= iArr.length || i2 != -1) {
                break;
            }
            int i3 = iArr[i];
            boolean z = true;
            for (int i4 = 0; i4 < actionList.size(); i4++) {
                z &= actionList.get(i4).getId() != i3;
            }
            if (z) {
                i2 = i3;
            }
            i++;
        }
        return i2;
    }

    public static android.content.res.ColorStateList getBackgroundTintList(@androidx.annotation.NonNull android.view.View view) {
        return view.getBackgroundTintList();
    }

    public static android.graphics.PorterDuff.Mode getBackgroundTintMode(@androidx.annotation.NonNull android.view.View view) {
        return view.getBackgroundTintMode();
    }

    @androidx.annotation.Nullable
    public static android.graphics.Rect getClipBounds(@androidx.annotation.NonNull android.view.View view) {
        return view.getClipBounds();
    }

    @androidx.annotation.Nullable
    public static android.view.Display getDisplay(@androidx.annotation.NonNull android.view.View view) {
        return view.getDisplay();
    }

    public static float getElevation(@androidx.annotation.NonNull android.view.View view) {
        return view.getElevation();
    }

    private static android.graphics.Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new java.lang.ThreadLocal<>();
        }
        android.graphics.Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new android.graphics.Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static androidx.core.view.OnReceiveContentViewBehavior getFallback(@androidx.annotation.NonNull android.view.View view) {
        return view instanceof androidx.core.view.OnReceiveContentViewBehavior ? (androidx.core.view.OnReceiveContentViewBehavior) view : NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(@androidx.annotation.NonNull android.view.View view) {
        return view.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(@androidx.annotation.NonNull android.view.View view) {
        return view.getImportantForAccessibility();
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@androidx.annotation.NonNull android.view.View view) {
        int importantForAutofill;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        importantForAutofill = view.getImportantForAutofill();
        return importantForAutofill;
    }

    public static int getLabelFor(@androidx.annotation.NonNull android.view.View view) {
        return view.getLabelFor();
    }

    @java.lang.Deprecated
    public static int getLayerType(android.view.View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(@androidx.annotation.NonNull android.view.View view) {
        return view.getLayoutDirection();
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public static android.graphics.Matrix getMatrix(android.view.View view) {
        return view.getMatrix();
    }

    @java.lang.Deprecated
    public static int getMeasuredHeightAndState(android.view.View view) {
        return view.getMeasuredHeightAndState();
    }

    @java.lang.Deprecated
    public static int getMeasuredState(android.view.View view) {
        return view.getMeasuredState();
    }

    @java.lang.Deprecated
    public static int getMeasuredWidthAndState(android.view.View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(@androidx.annotation.NonNull android.view.View view) {
        return view.getMinimumHeight();
    }

    public static int getMinimumWidth(@androidx.annotation.NonNull android.view.View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(@androidx.annotation.NonNull android.view.View view) {
        int nextClusterForwardId;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        nextClusterForwardId = view.getNextClusterForwardId();
        return nextClusterForwardId;
    }

    @androidx.annotation.Nullable
    public static java.lang.String[] getOnReceiveContentMimeTypes(@androidx.annotation.NonNull android.view.View view) {
        return (java.lang.String[]) view.getTag(androidx.core.R.id.tag_on_receive_content_mime_types);
    }

    public static androidx.core.view.AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@androidx.annotation.NonNull android.view.View view) {
        androidx.core.view.AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new androidx.core.view.AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
        return accessibilityDelegate;
    }

    @java.lang.Deprecated
    public static int getOverScrollMode(android.view.View view) {
        return view.getOverScrollMode();
    }

    @androidx.annotation.Px
    public static int getPaddingEnd(@androidx.annotation.NonNull android.view.View view) {
        return view.getPaddingEnd();
    }

    @androidx.annotation.Px
    public static int getPaddingStart(@androidx.annotation.NonNull android.view.View view) {
        return view.getPaddingStart();
    }

    public static android.view.ViewParent getParentForAccessibility(@androidx.annotation.NonNull android.view.View view) {
        return view.getParentForAccessibility();
    }

    @java.lang.Deprecated
    public static float getPivotX(android.view.View view) {
        return view.getPivotX();
    }

    @java.lang.Deprecated
    public static float getPivotY(android.view.View view) {
        return view.getPivotY();
    }

    @androidx.annotation.Nullable
    public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(@androidx.annotation.NonNull android.view.View view) {
        return android.os.Build.VERSION.SDK_INT >= 23 ? androidx.core.view.ViewCompat.Api23Impl.getRootWindowInsets(view) : androidx.core.view.ViewCompat.Api21Impl.getRootWindowInsets(view);
    }

    @java.lang.Deprecated
    public static float getRotation(android.view.View view) {
        return view.getRotation();
    }

    @java.lang.Deprecated
    public static float getRotationX(android.view.View view) {
        return view.getRotationX();
    }

    @java.lang.Deprecated
    public static float getRotationY(android.view.View view) {
        return view.getRotationY();
    }

    @java.lang.Deprecated
    public static float getScaleX(android.view.View view) {
        return view.getScaleX();
    }

    @java.lang.Deprecated
    public static float getScaleY(android.view.View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(@androidx.annotation.NonNull android.view.View view) {
        int scrollIndicators;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        scrollIndicators = view.getScrollIndicators();
        return scrollIndicators;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.UiThread
    public static final java.lang.CharSequence getStateDescription(@androidx.annotation.NonNull android.view.View view) {
        return stateDescriptionProperty().get(view);
    }

    @androidx.annotation.NonNull
    public static java.util.List<android.graphics.Rect> getSystemGestureExclusionRects(@androidx.annotation.NonNull android.view.View view) {
        java.util.List<android.graphics.Rect> systemGestureExclusionRects;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return java.util.Collections.emptyList();
        }
        systemGestureExclusionRects = view.getSystemGestureExclusionRects();
        return systemGestureExclusionRects;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getTransitionName(@androidx.annotation.NonNull android.view.View view) {
        return view.getTransitionName();
    }

    @java.lang.Deprecated
    public static float getTranslationX(android.view.View view) {
        return view.getTranslationX();
    }

    @java.lang.Deprecated
    public static float getTranslationY(android.view.View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(@androidx.annotation.NonNull android.view.View view) {
        return view.getTranslationZ();
    }

    @androidx.annotation.Nullable
    public static androidx.core.view.WindowInsetsControllerCompat getWindowInsetsController(@androidx.annotation.NonNull android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            return androidx.core.view.ViewCompat.Api30Impl.getWindowInsetsController(view);
        }
        for (android.content.Context context = view.getContext(); context instanceof android.content.ContextWrapper; context = ((android.content.ContextWrapper) context).getBaseContext()) {
            if (context instanceof android.app.Activity) {
                android.view.Window window = ((android.app.Activity) context).getWindow();
                if (window != null) {
                    return androidx.core.view.WindowCompat.getInsetsController(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static int getWindowSystemUiVisibility(@androidx.annotation.NonNull android.view.View view) {
        return view.getWindowSystemUiVisibility();
    }

    @java.lang.Deprecated
    public static float getX(android.view.View view) {
        return view.getX();
    }

    @java.lang.Deprecated
    public static float getY(android.view.View view) {
        return view.getY();
    }

    public static float getZ(@androidx.annotation.NonNull android.view.View view) {
        return view.getZ();
    }

    public static boolean hasAccessibilityDelegate(@androidx.annotation.NonNull android.view.View view) {
        return getAccessibilityDelegateInternal(view) != null;
    }

    public static boolean hasExplicitFocusable(@androidx.annotation.NonNull android.view.View view) {
        boolean hasExplicitFocusable;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return view.hasFocusable();
        }
        hasExplicitFocusable = view.hasExplicitFocusable();
        return hasExplicitFocusable;
    }

    public static boolean hasNestedScrollingParent(@androidx.annotation.NonNull android.view.View view) {
        return view.hasNestedScrollingParent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@androidx.annotation.NonNull android.view.View view, int i) {
        if (view instanceof androidx.core.view.NestedScrollingChild2) {
            ((androidx.core.view.NestedScrollingChild2) view).hasNestedScrollingParent(i);
            return false;
        }
        if (i == 0) {
            return hasNestedScrollingParent(view);
        }
        return false;
    }

    public static boolean hasOnClickListeners(@androidx.annotation.NonNull android.view.View view) {
        return view.hasOnClickListeners();
    }

    public static boolean hasOverlappingRendering(@androidx.annotation.NonNull android.view.View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean hasTransientState(@androidx.annotation.NonNull android.view.View view) {
        return view.hasTransientState();
    }

    @androidx.annotation.UiThread
    public static boolean isAccessibilityHeading(android.view.View view) {
        java.lang.Boolean bool = accessibilityHeadingProperty().get(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isAttachedToWindow(@androidx.annotation.NonNull android.view.View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(@androidx.annotation.NonNull android.view.View view) {
        boolean isFocusedByDefault;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return false;
        }
        isFocusedByDefault = view.isFocusedByDefault();
        return isFocusedByDefault;
    }

    public static boolean isImportantForAccessibility(@androidx.annotation.NonNull android.view.View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean isImportantForAutofill(@androidx.annotation.NonNull android.view.View view) {
        boolean isImportantForAutofill;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return true;
        }
        isImportantForAutofill = view.isImportantForAutofill();
        return isImportantForAutofill;
    }

    public static boolean isInLayout(@androidx.annotation.NonNull android.view.View view) {
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(@androidx.annotation.NonNull android.view.View view) {
        boolean isKeyboardNavigationCluster;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return false;
        }
        isKeyboardNavigationCluster = view.isKeyboardNavigationCluster();
        return isKeyboardNavigationCluster;
    }

    public static boolean isLaidOut(@androidx.annotation.NonNull android.view.View view) {
        return view.isLaidOut();
    }

    public static boolean isLayoutDirectionResolved(@androidx.annotation.NonNull android.view.View view) {
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(@androidx.annotation.NonNull android.view.View view) {
        return view.isNestedScrollingEnabled();
    }

    @java.lang.Deprecated
    public static boolean isOpaque(android.view.View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(@androidx.annotation.NonNull android.view.View view) {
        return view.isPaddingRelative();
    }

    @androidx.annotation.UiThread
    public static boolean isScreenReaderFocusable(android.view.View view) {
        java.lang.Boolean bool = screenReaderFocusableProperty().get(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @java.lang.Deprecated
    public static void jumpDrawablesToCurrentState(android.view.View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static android.view.View keyboardNavigationClusterSearch(@androidx.annotation.NonNull android.view.View view, android.view.View view2, int i) {
        android.view.View keyboardNavigationClusterSearch;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        keyboardNavigationClusterSearch = view.keyboardNavigationClusterSearch(view2, i);
        return keyboardNavigationClusterSearch;
    }

    @androidx.annotation.RequiresApi(19)
    public static void notifyViewAccessibilityStateChangedIfNeeded(android.view.View view, int i) {
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = getAccessibilityPaneTitle(view) != null && view.getVisibility() == 0;
            if (getAccessibilityLiveRegion(view) != 0 || z) {
                android.view.accessibility.AccessibilityEvent obtain = android.view.accessibility.AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(getAccessibilityPaneTitle(view));
                    setViewImportanceForAccessibilityIfNeeded(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (java.lang.AbstractMethodError unused) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(view.getParent().getClass().getSimpleName());
                        sb.append(" does not fully implement ViewParent");
                        return;
                    }
                }
                return;
            }
            android.view.accessibility.AccessibilityEvent obtain2 = android.view.accessibility.AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(obtain2);
            obtain2.setEventType(32);
            obtain2.setContentChangeTypes(i);
            obtain2.setSource(view);
            view.onPopulateAccessibilityEvent(obtain2);
            obtain2.getText().add(getAccessibilityPaneTitle(view));
            accessibilityManager.sendAccessibilityEvent(obtain2);
        }
    }

    public static void offsetLeftAndRight(@androidx.annotation.NonNull android.view.View view, int i) {
        boolean z;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        android.graphics.Rect emptyTempRect = getEmptyTempRect();
        java.lang.Object parent = view.getParent();
        if (parent instanceof android.view.View) {
            android.view.View view2 = (android.view.View) parent;
            emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        compatOffsetLeftAndRight(view, i);
        if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((android.view.View) parent).invalidate(emptyTempRect);
        }
    }

    public static void offsetTopAndBottom(@androidx.annotation.NonNull android.view.View view, int i) {
        boolean z;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        android.graphics.Rect emptyTempRect = getEmptyTempRect();
        java.lang.Object parent = view.getParent();
        if (parent instanceof android.view.View) {
            android.view.View view2 = (android.view.View) parent;
            emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        compatOffsetTopAndBottom(view, i);
        if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((android.view.View) parent).invalidate(emptyTempRect);
        }
    }

    @androidx.annotation.NonNull
    public static androidx.core.view.WindowInsetsCompat onApplyWindowInsets(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        android.view.WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            android.view.WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    @java.lang.Deprecated
    public static void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.View view, androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @java.lang.Deprecated
    public static void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.CharSequence> paneTitleProperty() {
        return new androidx.core.view.ViewCompat.AnonymousClass3(androidx.core.R.id.tag_accessibility_pane_title, java.lang.CharSequence.class, 8, 28);
    }

    public static boolean performAccessibilityAction(@androidx.annotation.NonNull android.view.View view, int i, android.os.Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    @androidx.annotation.Nullable
    public static androidx.core.view.ContentInfoCompat performReceiveContent(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.ContentInfoCompat contentInfoCompat) {
        if (android.util.Log.isLoggable("ViewCompat", 3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("performReceiveContent: ");
            sb.append(contentInfoCompat);
            sb.append(", view=");
            sb.append(view.getClass().getSimpleName());
            sb.append("[");
            sb.append(view.getId());
            sb.append("]");
        }
        androidx.core.view.OnReceiveContentListener onReceiveContentListener = (androidx.core.view.OnReceiveContentListener) view.getTag(androidx.core.R.id.tag_on_receive_content_listener);
        if (onReceiveContentListener == null) {
            return getFallback(view).onReceiveContent(contentInfoCompat);
        }
        androidx.core.view.ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
        if (onReceiveContent == null) {
            return null;
        }
        return getFallback(view).onReceiveContent(onReceiveContent);
    }

    public static void postInvalidateOnAnimation(@androidx.annotation.NonNull android.view.View view) {
        view.postInvalidateOnAnimation();
    }

    public static void postInvalidateOnAnimation(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4) {
        view.postInvalidateOnAnimation(i, i2, i3, i4);
    }

    public static void postOnAnimation(@androidx.annotation.NonNull android.view.View view, java.lang.Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void postOnAnimationDelayed(@androidx.annotation.NonNull android.view.View view, java.lang.Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void removeAccessibilityAction(@androidx.annotation.NonNull android.view.View view, int i) {
        removeActionWithId(i, view);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    private static void removeActionWithId(int i, android.view.View view) {
        java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i2 = 0; i2 < actionList.size(); i2++) {
            if (actionList.get(i2).getId() == i) {
                actionList.remove(i2);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            androidx.core.view.ViewCompat.CompatImplApi28.removeOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) view.getTag(androidx.core.R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                androidx.core.view.ViewCompat.UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void replaceAccessibilityAction(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable androidx.core.view.accessibility.AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(@androidx.annotation.NonNull android.view.View view) {
        view.requestApplyInsets();
    }

    @androidx.annotation.NonNull
    public static <T extends android.view.View> T requireViewById(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.IdRes int i) {
        android.view.View requireViewById;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            requireViewById = view.requireViewById(i);
            return (T) requireViewById;
        }
        T t = (T) view.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new java.lang.IllegalArgumentException("ID does not reference a View inside this View");
    }

    @java.lang.Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return android.view.View.resolveSizeAndState(i, i2, i3);
    }

    public static boolean restoreDefaultFocus(@androidx.annotation.NonNull android.view.View view) {
        boolean restoreDefaultFocus;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return view.requestFocus();
        }
        restoreDefaultFocus = view.restoreDefaultFocus();
        return restoreDefaultFocus;
    }

    public static void saveAttributeDataForStyleable(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull @android.annotation.SuppressLint({"ContextFirst"}) android.content.Context context, @androidx.annotation.NonNull int[] iArr, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, int i, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            androidx.core.view.ViewCompat.Api29Impl.saveAttributeDataForStyleable(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.Boolean> screenReaderFocusableProperty() {
        return new androidx.core.view.ViewCompat.AnonymousClass2(androidx.core.R.id.tag_screen_reader_focusable, java.lang.Boolean.class, 28);
    }

    public static void setAccessibilityDelegate(@androidx.annotation.NonNull android.view.View view, androidx.core.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new androidx.core.view.AccessibilityDelegateCompat();
        }
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }

    @androidx.annotation.UiThread
    public static void setAccessibilityHeading(android.view.View view, boolean z) {
        accessibilityHeadingProperty().set(view, java.lang.Boolean.valueOf(z));
    }

    public static void setAccessibilityLiveRegion(@androidx.annotation.NonNull android.view.View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    @androidx.annotation.UiThread
    public static void setAccessibilityPaneTitle(android.view.View view, java.lang.CharSequence charSequence) {
        paneTitleProperty().set(view, charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
        } else {
            sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
        }
    }

    @java.lang.Deprecated
    public static void setActivated(android.view.View view, boolean z) {
        view.setActivated(z);
    }

    @java.lang.Deprecated
    public static void setAlpha(android.view.View view, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        view.setAlpha(f);
    }

    public static void setAutofillHints(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable java.lang.String... strArr) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setAutofillHints(strArr);
        }
    }

    public static void setBackground(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(@androidx.annotation.NonNull android.view.View view, android.content.res.ColorStateList colorStateList) {
        int i = android.os.Build.VERSION.SDK_INT;
        view.setBackgroundTintList(colorStateList);
        if (i == 21) {
            android.graphics.drawable.Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void setBackgroundTintMode(@androidx.annotation.NonNull android.view.View view, android.graphics.PorterDuff.Mode mode) {
        int i = android.os.Build.VERSION.SDK_INT;
        view.setBackgroundTintMode(mode);
        if (i == 21) {
            android.graphics.drawable.Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    @java.lang.Deprecated
    public static void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = android.view.ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", java.lang.Boolean.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, java.lang.Boolean.valueOf(z));
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException unused2) {
        }
    }

    public static void setClipBounds(@androidx.annotation.NonNull android.view.View view, android.graphics.Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setElevation(@androidx.annotation.NonNull android.view.View view, float f) {
        view.setElevation(f);
    }

    @java.lang.Deprecated
    public static void setFitsSystemWindows(android.view.View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(@androidx.annotation.NonNull android.view.View view, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setFocusedByDefault(z);
        }
    }

    public static void setHasTransientState(@androidx.annotation.NonNull android.view.View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static void setImportantForAccessibility(@androidx.annotation.NonNull android.view.View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void setImportantForAutofill(@androidx.annotation.NonNull android.view.View view, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static void setKeyboardNavigationCluster(@androidx.annotation.NonNull android.view.View view, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setKeyboardNavigationCluster(z);
        }
    }

    public static void setLabelFor(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.IdRes int i) {
        view.setLabelFor(i);
    }

    public static void setLayerPaint(@androidx.annotation.NonNull android.view.View view, android.graphics.Paint paint) {
        view.setLayerPaint(paint);
    }

    @java.lang.Deprecated
    public static void setLayerType(android.view.View view, int i, android.graphics.Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void setLayoutDirection(@androidx.annotation.NonNull android.view.View view, int i) {
        view.setLayoutDirection(i);
    }

    public static void setNestedScrollingEnabled(@androidx.annotation.NonNull android.view.View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void setNextClusterForwardId(@androidx.annotation.NonNull android.view.View view, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setNextClusterForwardId(i);
        }
    }

    public static void setOnApplyWindowInsetsListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        androidx.core.view.ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable androidx.core.view.OnReceiveContentListener onReceiveContentListener) {
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z = false;
        if (onReceiveContentListener != null) {
            androidx.core.util.Preconditions.checkArgument(strArr != null, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (strArr[i].startsWith("*")) {
                    z = true;
                    break;
                }
                i++;
            }
            androidx.core.util.Preconditions.checkArgument(!z, "A MIME type set here must not start with *: " + java.util.Arrays.toString(strArr));
        }
        view.setTag(androidx.core.R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(androidx.core.R.id.tag_on_receive_content_listener, onReceiveContentListener);
    }

    @java.lang.Deprecated
    public static void setOverScrollMode(android.view.View view, int i) {
        view.setOverScrollMode(i);
    }

    public static void setPaddingRelative(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Px int i, @androidx.annotation.Px int i2, @androidx.annotation.Px int i3, @androidx.annotation.Px int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    @java.lang.Deprecated
    public static void setPivotX(android.view.View view, float f) {
        view.setPivotX(f);
    }

    @java.lang.Deprecated
    public static void setPivotY(android.view.View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(@androidx.annotation.NonNull android.view.View view, androidx.core.view.PointerIconCompat pointerIconCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((android.view.PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
        }
    }

    @java.lang.Deprecated
    public static void setRotation(android.view.View view, float f) {
        view.setRotation(f);
    }

    @java.lang.Deprecated
    public static void setRotationX(android.view.View view, float f) {
        view.setRotationX(f);
    }

    @java.lang.Deprecated
    public static void setRotationY(android.view.View view, float f) {
        view.setRotationY(f);
    }

    @java.lang.Deprecated
    public static void setSaveFromParentEnabled(android.view.View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @java.lang.Deprecated
    public static void setScaleX(android.view.View view, float f) {
        view.setScaleX(f);
    }

    @java.lang.Deprecated
    public static void setScaleY(android.view.View view, float f) {
        view.setScaleY(f);
    }

    @androidx.annotation.UiThread
    public static void setScreenReaderFocusable(android.view.View view, boolean z) {
        screenReaderFocusableProperty().set(view, java.lang.Boolean.valueOf(z));
    }

    public static void setScrollIndicators(@androidx.annotation.NonNull android.view.View view, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i);
        }
    }

    public static void setScrollIndicators(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    @androidx.annotation.UiThread
    public static void setStateDescription(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        stateDescriptionProperty().set(view, charSequence);
    }

    public static void setSystemGestureExclusionRects(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.util.List<android.graphics.Rect> list) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static void setTooltipText(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(@androidx.annotation.NonNull android.view.View view, java.lang.String str) {
        view.setTransitionName(str);
    }

    @java.lang.Deprecated
    public static void setTranslationX(android.view.View view, float f) {
        view.setTranslationX(f);
    }

    @java.lang.Deprecated
    public static void setTranslationY(android.view.View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(@androidx.annotation.NonNull android.view.View view, float f) {
        view.setTranslationZ(f);
    }

    private static void setViewImportanceForAccessibilityIfNeeded(android.view.View view) {
        if (getImportantForAccessibility(view) == 0) {
            setImportantForAccessibility(view, 1);
        }
        for (android.view.ViewParent parent = view.getParent(); parent instanceof android.view.View; parent = parent.getParent()) {
            if (getImportantForAccessibility((android.view.View) parent) == 4) {
                setImportantForAccessibility(view, 2);
                return;
            }
        }
    }

    public static void setWindowInsetsAnimationCallback(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
        androidx.core.view.WindowInsetsAnimationCompat.setCallback(view, callback);
    }

    @java.lang.Deprecated
    public static void setX(android.view.View view, float f) {
        view.setX(f);
    }

    @java.lang.Deprecated
    public static void setY(android.view.View view, float f) {
        view.setY(f);
    }

    public static void setZ(@androidx.annotation.NonNull android.view.View view, float f) {
        view.setZ(f);
    }

    public static boolean startDragAndDrop(@androidx.annotation.NonNull android.view.View view, android.content.ClipData clipData, android.view.View.DragShadowBuilder dragShadowBuilder, java.lang.Object obj, int i) {
        boolean startDragAndDrop;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return view.startDrag(clipData, dragShadowBuilder, obj, i);
        }
        startDragAndDrop = view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        return startDragAndDrop;
    }

    public static boolean startNestedScroll(@androidx.annotation.NonNull android.view.View view, int i) {
        return view.startNestedScroll(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
        if (view instanceof androidx.core.view.NestedScrollingChild2) {
            return ((androidx.core.view.NestedScrollingChild2) view).startNestedScroll(i, i2);
        }
        if (i2 == 0) {
            return startNestedScroll(view, i);
        }
        return false;
    }

    private static androidx.core.view.ViewCompat.AccessibilityViewProperty<java.lang.CharSequence> stateDescriptionProperty() {
        return new androidx.core.view.ViewCompat.AnonymousClass4(androidx.core.R.id.tag_state_description, java.lang.CharSequence.class, 64, 30);
    }

    public static void stopNestedScroll(@androidx.annotation.NonNull android.view.View view) {
        view.stopNestedScroll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@androidx.annotation.NonNull android.view.View view, int i) {
        if (view instanceof androidx.core.view.NestedScrollingChild2) {
            ((androidx.core.view.NestedScrollingChild2) view).stopNestedScroll(i);
        } else if (i == 0) {
            stopNestedScroll(view);
        }
    }

    private static void tickleInvalidationFlag(android.view.View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void updateDragShadow(@androidx.annotation.NonNull android.view.View view, android.view.View.DragShadowBuilder dragShadowBuilder) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }
}
