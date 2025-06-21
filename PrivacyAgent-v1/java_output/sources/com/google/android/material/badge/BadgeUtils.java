package com.google.android.material.badge;

@com.google.android.material.badge.ExperimentalBadgeUtils
/* loaded from: classes22.dex */
public class BadgeUtils {
    private static final java.lang.String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT = false;

    /* renamed from: com.google.android.material.badge.BadgeUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.google.android.material.badge.BadgeDrawable val$badgeDrawable;
        final /* synthetic */ android.widget.FrameLayout val$customBadgeParent;
        final /* synthetic */ int val$menuItemId;
        final /* synthetic */ androidx.appcompat.widget.Toolbar val$toolbar;

        public AnonymousClass1(androidx.appcompat.widget.Toolbar toolbar, int i, com.google.android.material.badge.BadgeDrawable badgeDrawable, android.widget.FrameLayout frameLayout) {
            this.val$toolbar = toolbar;
            this.val$menuItemId = i;
            this.val$badgeDrawable = badgeDrawable;
            this.val$customBadgeParent = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.view.menu.ActionMenuItemView actionMenuItemView = com.google.android.material.internal.ToolbarUtils.getActionMenuItemView(this.val$toolbar, this.val$menuItemId);
            if (actionMenuItemView != null) {
                com.google.android.material.badge.BadgeUtils.setToolbarOffset(this.val$badgeDrawable, this.val$toolbar.getResources());
                com.google.android.material.badge.BadgeUtils.attachBadgeDrawable(this.val$badgeDrawable, actionMenuItemView, this.val$customBadgeParent);
            }
        }
    }

    private BadgeUtils() {
    }

    public static void attachBadgeDrawable(@androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable badgeDrawable, @androidx.annotation.NonNull android.view.View view) {
        attachBadgeDrawable(badgeDrawable, view, (android.widget.FrameLayout) null);
    }

    public static void attachBadgeDrawable(@androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable badgeDrawable, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.widget.FrameLayout frameLayout) {
        setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
        } else {
            if (USE_COMPAT_PARENT) {
                throw new java.lang.IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void attachBadgeDrawable(@androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable badgeDrawable, @androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar, @androidx.annotation.IdRes int i) {
        attachBadgeDrawable(badgeDrawable, toolbar, i, null);
    }

    public static void attachBadgeDrawable(@androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable badgeDrawable, @androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar, @androidx.annotation.IdRes int i, @androidx.annotation.Nullable android.widget.FrameLayout frameLayout) {
        toolbar.post(new com.google.android.material.badge.BadgeUtils.AnonymousClass1(toolbar, i, badgeDrawable, frameLayout));
    }

    @androidx.annotation.NonNull
    public static android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> createBadgeDrawablesFromSavedStates(android.content.Context context, @androidx.annotation.NonNull com.google.android.material.internal.ParcelableSparseArray parcelableSparseArray) {
        android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> sparseArray = new android.util.SparseArray<>(parcelableSparseArray.size());
        for (int i = 0; i < parcelableSparseArray.size(); i++) {
            int keyAt = parcelableSparseArray.keyAt(i);
            com.google.android.material.badge.BadgeDrawable.SavedState savedState = (com.google.android.material.badge.BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i);
            if (savedState == null) {
                throw new java.lang.IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
            sparseArray.put(keyAt, com.google.android.material.badge.BadgeDrawable.createFromSavedState(context, savedState));
        }
        return sparseArray;
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.internal.ParcelableSparseArray createParcelableBadgeStates(@androidx.annotation.NonNull android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> sparseArray) {
        com.google.android.material.internal.ParcelableSparseArray parcelableSparseArray = new com.google.android.material.internal.ParcelableSparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            com.google.android.material.badge.BadgeDrawable valueAt = sparseArray.valueAt(i);
            if (valueAt == null) {
                throw new java.lang.IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(keyAt, valueAt.getSavedState());
        }
        return parcelableSparseArray;
    }

    public static void detachBadgeDrawable(@androidx.annotation.Nullable com.google.android.material.badge.BadgeDrawable badgeDrawable, @androidx.annotation.NonNull android.view.View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (USE_COMPAT_PARENT || badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void detachBadgeDrawable(@androidx.annotation.Nullable com.google.android.material.badge.BadgeDrawable badgeDrawable, @androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar, @androidx.annotation.IdRes int i) {
        if (badgeDrawable == null) {
            return;
        }
        androidx.appcompat.view.menu.ActionMenuItemView actionMenuItemView = com.google.android.material.internal.ToolbarUtils.getActionMenuItemView(toolbar, i);
        if (actionMenuItemView != null) {
            removeToolbarOffset(badgeDrawable);
            detachBadgeDrawable(badgeDrawable, actionMenuItemView);
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Trying to remove badge from a null menuItemView: ");
            sb.append(i);
        }
    }

    @androidx.annotation.VisibleForTesting
    public static void removeToolbarOffset(com.google.android.material.badge.BadgeDrawable badgeDrawable) {
        badgeDrawable.setAdditionalHorizontalOffset(0);
        badgeDrawable.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(@androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable badgeDrawable, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.widget.FrameLayout frameLayout) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.updateBadgeCoordinates(view, frameLayout);
    }

    @androidx.annotation.VisibleForTesting
    public static void setToolbarOffset(com.google.android.material.badge.BadgeDrawable badgeDrawable, android.content.res.Resources resources) {
        badgeDrawable.setAdditionalHorizontalOffset(resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        badgeDrawable.setAdditionalVerticalOffset(resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(@androidx.annotation.NonNull android.graphics.Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }
}
