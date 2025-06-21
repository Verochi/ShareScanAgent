package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public class ToolbarUtils {
    private ToolbarUtils() {
    }

    @androidx.annotation.Nullable
    public static androidx.appcompat.view.menu.ActionMenuItemView getActionMenuItemView(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar, @androidx.annotation.IdRes int i) {
        androidx.appcompat.widget.ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null) {
            return null;
        }
        for (int i2 = 0; i2 < actionMenuView.getChildCount(); i2++) {
            android.view.View childAt = actionMenuView.getChildAt(i2);
            if (childAt instanceof androidx.appcompat.view.menu.ActionMenuItemView) {
                androidx.appcompat.view.menu.ActionMenuItemView actionMenuItemView = (androidx.appcompat.view.menu.ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static androidx.appcompat.widget.ActionMenuView getActionMenuView(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            android.view.View childAt = toolbar.getChildAt(i);
            if (childAt instanceof androidx.appcompat.widget.ActionMenuView) {
                return (androidx.appcompat.widget.ActionMenuView) childAt;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static android.widget.ImageButton getNavigationIconButton(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar) {
        android.graphics.drawable.Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            android.view.View childAt = toolbar.getChildAt(i);
            if (childAt instanceof android.widget.ImageButton) {
                android.widget.ImageButton imageButton = (android.widget.ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static android.view.View getSecondaryActionMenuItemView(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar) {
        androidx.appcompat.widget.ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null || actionMenuView.getChildCount() <= 1) {
            return null;
        }
        return actionMenuView.getChildAt(0);
    }

    @androidx.annotation.Nullable
    public static android.widget.TextView getSubtitleTextView(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar) {
        return getTextView(toolbar, toolbar.getSubtitle());
    }

    @androidx.annotation.Nullable
    private static android.widget.TextView getTextView(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar, java.lang.CharSequence charSequence) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            android.view.View childAt = toolbar.getChildAt(i);
            if (childAt instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) childAt;
                if (android.text.TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static android.widget.TextView getTitleTextView(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar toolbar) {
        return getTextView(toolbar, toolbar.getTitle());
    }
}
