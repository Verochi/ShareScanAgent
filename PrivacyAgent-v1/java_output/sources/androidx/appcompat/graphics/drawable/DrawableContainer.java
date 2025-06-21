package androidx.appcompat.graphics.drawable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class DrawableContainer extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final java.lang.String TAG = "DrawableContainer";
    private java.lang.Runnable mAnimationRunnable;
    private androidx.appcompat.graphics.drawable.DrawableContainer.BlockInvalidateCallback mBlockInvalidateCallback;
    private android.graphics.drawable.Drawable mCurrDrawable;
    private androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private android.graphics.Rect mHotspotBounds;
    private android.graphics.drawable.Drawable mLastDrawable;
    private boolean mMutated;
    private int mAlpha = 255;
    private int mCurIndex = -1;

    /* renamed from: androidx.appcompat.graphics.drawable.DrawableContainer$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.graphics.drawable.DrawableContainer.this.animate(true);
            androidx.appcompat.graphics.drawable.DrawableContainer.this.invalidateSelf();
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(android.graphics.drawable.Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void getOutline(android.graphics.drawable.Drawable drawable, android.graphics.Outline outline) {
            drawable.getOutline(outline);
        }

        public static android.content.res.Resources getResources(android.content.res.Resources.Theme theme) {
            return theme.getResources();
        }
    }

    public static class BlockInvalidateCallback implements android.graphics.drawable.Drawable.Callback {
        private android.graphics.drawable.Drawable.Callback mCallback;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable, long j) {
            android.graphics.drawable.Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable) {
            android.graphics.drawable.Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public android.graphics.drawable.Drawable.Callback unwrap() {
            android.graphics.drawable.Drawable.Callback callback = this.mCallback;
            this.mCallback = null;
            return callback;
        }

        public androidx.appcompat.graphics.drawable.DrawableContainer.BlockInvalidateCallback wrap(android.graphics.drawable.Drawable.Callback callback) {
            this.mCallback = callback;
            return this;
        }
    }

    public static abstract class DrawableContainerState extends android.graphics.drawable.Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        android.graphics.ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        android.graphics.Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        int mDensity;
        boolean mDither;
        android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> mDrawableFutures;
        android.graphics.drawable.Drawable[] mDrawables;
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final androidx.appcompat.graphics.drawable.DrawableContainer mOwner;
        android.content.res.Resources mSourceRes;
        boolean mStateful;
        android.content.res.ColorStateList mTintList;
        android.graphics.PorterDuff.Mode mTintMode;
        boolean mVariablePadding;

        public DrawableContainerState(androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState, androidx.appcompat.graphics.drawable.DrawableContainer drawableContainer, android.content.res.Resources resources) {
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = drawableContainer;
            this.mSourceRes = resources != null ? resources : drawableContainerState != null ? drawableContainerState.mSourceRes : null;
            int resolveDensity = androidx.appcompat.graphics.drawable.DrawableContainer.resolveDensity(resources, drawableContainerState != null ? drawableContainerState.mDensity : 0);
            this.mDensity = resolveDensity;
            if (drawableContainerState == null) {
                this.mDrawables = new android.graphics.drawable.Drawable[10];
                this.mNumChildren = 0;
                return;
            }
            this.mChangingConfigurations = drawableContainerState.mChangingConfigurations;
            this.mChildrenChangingConfigurations = drawableContainerState.mChildrenChangingConfigurations;
            this.mCheckedConstantState = true;
            this.mCanConstantState = true;
            this.mVariablePadding = drawableContainerState.mVariablePadding;
            this.mConstantSize = drawableContainerState.mConstantSize;
            this.mDither = drawableContainerState.mDither;
            this.mMutated = drawableContainerState.mMutated;
            this.mLayoutDirection = drawableContainerState.mLayoutDirection;
            this.mEnterFadeDuration = drawableContainerState.mEnterFadeDuration;
            this.mExitFadeDuration = drawableContainerState.mExitFadeDuration;
            this.mAutoMirrored = drawableContainerState.mAutoMirrored;
            this.mColorFilter = drawableContainerState.mColorFilter;
            this.mHasColorFilter = drawableContainerState.mHasColorFilter;
            this.mTintList = drawableContainerState.mTintList;
            this.mTintMode = drawableContainerState.mTintMode;
            this.mHasTintList = drawableContainerState.mHasTintList;
            this.mHasTintMode = drawableContainerState.mHasTintMode;
            if (drawableContainerState.mDensity == resolveDensity) {
                if (drawableContainerState.mCheckedPadding) {
                    this.mConstantPadding = drawableContainerState.mConstantPadding != null ? new android.graphics.Rect(drawableContainerState.mConstantPadding) : null;
                    this.mCheckedPadding = true;
                }
                if (drawableContainerState.mCheckedConstantSize) {
                    this.mConstantWidth = drawableContainerState.mConstantWidth;
                    this.mConstantHeight = drawableContainerState.mConstantHeight;
                    this.mConstantMinimumWidth = drawableContainerState.mConstantMinimumWidth;
                    this.mConstantMinimumHeight = drawableContainerState.mConstantMinimumHeight;
                    this.mCheckedConstantSize = true;
                }
            }
            if (drawableContainerState.mCheckedOpacity) {
                this.mOpacity = drawableContainerState.mOpacity;
                this.mCheckedOpacity = true;
            }
            if (drawableContainerState.mCheckedStateful) {
                this.mStateful = drawableContainerState.mStateful;
                this.mCheckedStateful = true;
            }
            android.graphics.drawable.Drawable[] drawableArr = drawableContainerState.mDrawables;
            this.mDrawables = new android.graphics.drawable.Drawable[drawableArr.length];
            this.mNumChildren = drawableContainerState.mNumChildren;
            android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> sparseArray = drawableContainerState.mDrawableFutures;
            if (sparseArray != null) {
                this.mDrawableFutures = sparseArray.clone();
            } else {
                this.mDrawableFutures = new android.util.SparseArray<>(this.mNumChildren);
            }
            int i = this.mNumChildren;
            for (int i2 = 0; i2 < i; i2++) {
                android.graphics.drawable.Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.mDrawableFutures.put(i2, constantState);
                    } else {
                        this.mDrawables[i2] = drawableArr[i2];
                    }
                }
            }
        }

        private void createAllFutures() {
            android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> sparseArray = this.mDrawableFutures;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.mDrawables[this.mDrawableFutures.keyAt(i)] = prepareDrawable(this.mDrawableFutures.valueAt(i).newDrawable(this.mSourceRes));
                }
                this.mDrawableFutures = null;
            }
        }

        private android.graphics.drawable.Drawable prepareDrawable(android.graphics.drawable.Drawable drawable) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(drawable, this.mLayoutDirection);
            }
            android.graphics.drawable.Drawable mutate = drawable.mutate();
            mutate.setCallback(this.mOwner);
            return mutate;
        }

        public final int addChild(android.graphics.drawable.Drawable drawable) {
            int i = this.mNumChildren;
            if (i >= this.mDrawables.length) {
                growArray(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.mOwner);
            this.mDrawables[i] = drawable;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return i;
        }

        @androidx.annotation.RequiresApi(21)
        public final void applyTheme(android.content.res.Resources.Theme theme) {
            if (theme != null) {
                createAllFutures();
                int i = this.mNumChildren;
                android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
                for (int i2 = 0; i2 < i; i2++) {
                    android.graphics.drawable.Drawable drawable = drawableArr[i2];
                    if (drawable != null && androidx.core.graphics.drawable.DrawableCompat.canApplyTheme(drawable)) {
                        androidx.core.graphics.drawable.DrawableCompat.applyTheme(drawableArr[i2], theme);
                        this.mChildrenChangingConfigurations |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                updateDensity(androidx.appcompat.graphics.drawable.DrawableContainer.Api21Impl.getResources(theme));
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.RequiresApi(21)
        public boolean canApplyTheme() {
            int i = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                android.graphics.drawable.Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    android.graphics.drawable.Drawable.ConstantState constantState = this.mDrawableFutures.get(i2);
                    if (constantState != null && androidx.appcompat.graphics.drawable.DrawableContainer.Api21Impl.canApplyTheme(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.DrawableCompat.canApplyTheme(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState) {
                return this.mCanConstantState;
            }
            createAllFutures();
            this.mCheckedConstantState = true;
            int i = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.mCanConstantState = false;
                    return false;
                }
            }
            this.mCanConstantState = true;
            return true;
        }

        public final void clearMutated() {
            this.mMutated = false;
        }

        public void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int i = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            for (int i2 = 0; i2 < i; i2++) {
                android.graphics.drawable.Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.mConstantWidth) {
                    this.mConstantWidth = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.mConstantHeight) {
                    this.mConstantHeight = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = minimumHeight;
                }
            }
        }

        public final int getCapacity() {
            return this.mDrawables.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final android.graphics.drawable.Drawable getChild(int i) {
            int indexOfKey;
            android.graphics.drawable.Drawable drawable = this.mDrawables[i];
            if (drawable != null) {
                return drawable;
            }
            android.util.SparseArray<android.graphics.drawable.Drawable.ConstantState> sparseArray = this.mDrawableFutures;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            android.graphics.drawable.Drawable prepareDrawable = prepareDrawable(this.mDrawableFutures.valueAt(indexOfKey).newDrawable(this.mSourceRes));
            this.mDrawables[i] = prepareDrawable;
            this.mDrawableFutures.removeAt(indexOfKey);
            if (this.mDrawableFutures.size() == 0) {
                this.mDrawableFutures = null;
            }
            return prepareDrawable;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final int getConstantHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumWidth;
        }

        public final android.graphics.Rect getConstantPadding() {
            android.graphics.Rect rect = null;
            if (this.mVariablePadding) {
                return null;
            }
            android.graphics.Rect rect2 = this.mConstantPadding;
            if (rect2 != null || this.mCheckedPadding) {
                return rect2;
            }
            createAllFutures();
            android.graphics.Rect rect3 = new android.graphics.Rect();
            int i = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new android.graphics.Rect(0, 0, 0, 0);
                    }
                    int i3 = rect3.left;
                    if (i3 > rect.left) {
                        rect.left = i3;
                    }
                    int i4 = rect3.top;
                    if (i4 > rect.top) {
                        rect.top = i4;
                    }
                    int i5 = rect3.right;
                    if (i5 > rect.right) {
                        rect.right = i5;
                    }
                    int i6 = rect3.bottom;
                    if (i6 > rect.bottom) {
                        rect.bottom = i6;
                    }
                }
            }
            this.mCheckedPadding = true;
            this.mConstantPadding = rect;
            return rect;
        }

        public final int getConstantWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            if (this.mCheckedOpacity) {
                return this.mOpacity;
            }
            createAllFutures();
            int i = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = android.graphics.drawable.Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.mOpacity = opacity;
            this.mCheckedOpacity = true;
            return opacity;
        }

        public void growArray(int i, int i2) {
            android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[i2];
            android.graphics.drawable.Drawable[] drawableArr2 = this.mDrawables;
            if (drawableArr2 != null) {
                java.lang.System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
            }
            this.mDrawables = drawableArr;
        }

        public void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful) {
                return this.mStateful;
            }
            createAllFutures();
            int i = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.mStateful = z;
            this.mCheckedStateful = true;
            return z;
        }

        public void mutate() {
            int i = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                android.graphics.drawable.Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.mMutated = true;
        }

        public final void setConstantSize(boolean z) {
            this.mConstantSize = z;
        }

        public final void setEnterFadeDuration(int i) {
            this.mEnterFadeDuration = i;
        }

        public final void setExitFadeDuration(int i) {
            this.mExitFadeDuration = i;
        }

        public final boolean setLayoutDirection(int i, int i2) {
            int i3 = this.mNumChildren;
            android.graphics.drawable.Drawable[] drawableArr = this.mDrawables;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                android.graphics.drawable.Drawable drawable = drawableArr[i4];
                if (drawable != null) {
                    boolean layoutDirection = android.os.Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(drawable, i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.mLayoutDirection = i;
            return z;
        }

        public final void setVariablePadding(boolean z) {
            this.mVariablePadding = z;
        }

        public final void updateDensity(android.content.res.Resources resources) {
            if (resources != null) {
                this.mSourceRes = resources;
                int resolveDensity = androidx.appcompat.graphics.drawable.DrawableContainer.resolveDensity(resources, this.mDensity);
                int i = this.mDensity;
                this.mDensity = resolveDensity;
                if (i != resolveDensity) {
                    this.mCheckedConstantSize = false;
                    this.mCheckedPadding = false;
                }
            }
        }
    }

    private void initializeDrawableForDisplay(android.graphics.drawable.Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new androidx.appcompat.graphics.drawable.DrawableContainer.BlockInvalidateCallback();
        }
        drawable.setCallback(this.mBlockInvalidateCallback.wrap(drawable.getCallback()));
        try {
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (drawableContainerState.mHasColorFilter) {
                drawable.setColorFilter(drawableContainerState.mColorFilter);
            } else {
                if (drawableContainerState.mHasTintList) {
                    androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, drawableContainerState.mTintList);
                }
                androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState2 = this.mDrawableContainerState;
                if (drawableContainerState2.mHasTintMode) {
                    androidx.core.graphics.drawable.DrawableCompat.setTintMode(drawable, drawableContainerState2.mTintMode);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.mDither);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(drawable, androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this));
            }
            androidx.core.graphics.drawable.DrawableCompat.setAutoMirrored(drawable, this.mDrawableContainerState.mAutoMirrored);
            android.graphics.Rect rect = this.mHotspotBounds;
            if (rect != null) {
                androidx.core.graphics.drawable.DrawableCompat.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.mBlockInvalidateCallback.unwrap());
        }
    }

    private boolean needsMirroring() {
        return isAutoMirrored() && androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 1;
    }

    public static int resolveDensity(@androidx.annotation.Nullable android.content.res.Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        return i == 0 ? com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void animate(boolean z) {
        boolean z2;
        android.graphics.drawable.Drawable drawable;
        boolean z3 = true;
        this.mHasAlpha = true;
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        android.graphics.drawable.Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            long j = this.mEnterAnimationEnd;
            if (j != 0) {
                if (j > uptimeMillis) {
                    drawable2.setAlpha(((255 - (((int) ((j - uptimeMillis) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
                    z2 = true;
                    drawable = this.mLastDrawable;
                    if (drawable == null) {
                        long j2 = this.mExitAnimationEnd;
                        if (j2 != 0) {
                            if (j2 > uptimeMillis) {
                                drawable.setAlpha(((((int) ((j2 - uptimeMillis) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
                                if (z && z3) {
                                    scheduleSelf(this.mAnimationRunnable, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                            drawable.setVisible(false, false);
                            this.mLastDrawable = null;
                            this.mExitAnimationEnd = 0L;
                        }
                    } else {
                        this.mExitAnimationEnd = 0L;
                    }
                    z3 = z2;
                    if (z) {
                        return;
                    } else {
                        return;
                    }
                }
                drawable2.setAlpha(this.mAlpha);
                this.mEnterAnimationEnd = 0L;
            }
        } else {
            this.mEnterAnimationEnd = 0L;
        }
        z2 = false;
        drawable = this.mLastDrawable;
        if (drawable == null) {
        }
        z3 = z2;
        if (z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.RequiresApi(21)
    public void applyTheme(@androidx.annotation.NonNull android.content.res.Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    public void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    public androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        android.graphics.drawable.Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final android.graphics.drawable.Drawable.ConstantState getConstantState() {
        if (!this.mDrawableContainerState.canConstantState()) {
            return null;
        }
        this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@androidx.annotation.NonNull android.graphics.Rect rect) {
        android.graphics.Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.mDrawableContainerState.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.RequiresApi(21)
    public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) {
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            androidx.appcompat.graphics.drawable.DrawableContainer.Api21Impl.getOutline(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@androidx.annotation.NonNull android.graphics.Rect rect) {
        boolean padding;
        android.graphics.Rect constantPadding = this.mDrawableContainerState.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            padding = (constantPadding.right | ((constantPadding.left | constantPadding.top) | constantPadding.bottom)) != 0;
        } else {
            android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (needsMirroring()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState != null) {
            drawableContainerState.invalidateCache();
        }
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        android.graphics.drawable.Drawable drawable = this.mLastDrawable;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            z = true;
        } else {
            z = false;
        }
        android.graphics.drawable.Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0L;
            z = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState cloneConstantState = cloneConstantState();
            cloneConstantState.mutate();
            setConstantState(cloneConstantState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        android.graphics.drawable.Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.mDrawableContainerState.setLayoutDirection(i, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        android.graphics.drawable.Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        android.graphics.drawable.Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        android.graphics.drawable.Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        android.graphics.drawable.Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable, long j) {
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean selectDrawable(int i) {
        java.lang.Runnable runnable;
        if (i == this.mCurIndex) {
            return false;
        }
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration > 0) {
            android.graphics.drawable.Drawable drawable = this.mLastDrawable;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            android.graphics.drawable.Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                this.mLastDrawable = drawable2;
                this.mExitAnimationEnd = this.mDrawableContainerState.mExitFadeDuration + uptimeMillis;
            } else {
                this.mLastDrawable = null;
                this.mExitAnimationEnd = 0L;
            }
        } else {
            android.graphics.drawable.Drawable drawable3 = this.mCurrDrawable;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0) {
            androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (i < drawableContainerState.mNumChildren) {
                android.graphics.drawable.Drawable child = drawableContainerState.getChild(i);
                this.mCurrDrawable = child;
                this.mCurIndex = i;
                if (child != null) {
                    int i2 = this.mDrawableContainerState.mEnterFadeDuration;
                    if (i2 > 0) {
                        this.mEnterAnimationEnd = uptimeMillis + i2;
                    }
                    initializeDrawableForDisplay(child);
                }
                if (this.mEnterAnimationEnd == 0 || this.mExitAnimationEnd != 0) {
                    runnable = this.mAnimationRunnable;
                    if (runnable != null) {
                        this.mAnimationRunnable = new androidx.appcompat.graphics.drawable.DrawableContainer.AnonymousClass1();
                    } else {
                        unscheduleSelf(runnable);
                    }
                    animate(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.mCurrDrawable = null;
        this.mCurIndex = -1;
        if (this.mEnterAnimationEnd == 0) {
        }
        runnable = this.mAnimationRunnable;
        if (runnable != null) {
        }
        animate(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mHasAlpha && this.mAlpha == i) {
            return;
        }
        this.mHasAlpha = true;
        this.mAlpha = i;
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            if (this.mEnterAnimationEnd == 0) {
                drawable.setAlpha(i);
            } else {
                animate(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.mAutoMirrored != z) {
            drawableContainerState.mAutoMirrored = z;
            android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                androidx.core.graphics.drawable.DrawableCompat.setAutoMirrored(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasColorFilter = true;
        if (drawableContainerState.mColorFilter != colorFilter) {
            drawableContainerState.mColorFilter = colorFilter;
            android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setConstantState(androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState) {
        this.mDrawableContainerState = drawableContainerState;
        int i = this.mCurIndex;
        if (i >= 0) {
            android.graphics.drawable.Drawable child = drawableContainerState.getChild(i);
            this.mCurrDrawable = child;
            if (child != null) {
                initializeDrawableForDisplay(child);
            }
        }
        this.mLastDrawable = null;
    }

    public void setCurrentIndex(int i) {
        selectDrawable(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.mDither != z) {
            drawableContainerState.mDither = z;
            android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setEnterFadeDuration(int i) {
        this.mDrawableContainerState.mEnterFadeDuration = i;
    }

    public void setExitFadeDuration(int i) {
        this.mDrawableContainerState.mExitFadeDuration = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setHotspot(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        android.graphics.Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new android.graphics.Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        android.graphics.drawable.Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setHotspotBounds(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasTintList = true;
        if (drawableContainerState.mTintList != colorStateList) {
            drawableContainerState.mTintList = colorStateList;
            androidx.core.graphics.drawable.DrawableCompat.setTintList(this.mCurrDrawable, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasTintMode = true;
        if (drawableContainerState.mTintMode != mode) {
            drawableContainerState.mTintMode = mode;
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(this.mCurrDrawable, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        android.graphics.drawable.Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        android.graphics.drawable.Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    public final void updateDensity(android.content.res.Resources resources) {
        this.mDrawableContainerState.updateDensity(resources);
    }
}
