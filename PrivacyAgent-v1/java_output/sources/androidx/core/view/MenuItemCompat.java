package androidx.core.view;

/* loaded from: classes.dex */
public final class MenuItemCompat {

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @java.lang.Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final java.lang.String TAG = "MenuItemCompat";

    /* renamed from: androidx.core.view.MenuItemCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.MenuItem.OnActionExpandListener {
        final /* synthetic */ androidx.core.view.MenuItemCompat.OnActionExpandListener val$listener;

        public AnonymousClass1(androidx.core.view.MenuItemCompat.OnActionExpandListener onActionExpandListener) {
            this.val$listener = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(android.view.MenuItem menuItem) {
            return this.val$listener.onMenuItemActionCollapse(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(android.view.MenuItem menuItem) {
            return this.val$listener.onMenuItemActionExpand(menuItem);
        }
    }

    @java.lang.Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(android.view.MenuItem menuItem);

        boolean onMenuItemActionExpand(android.view.MenuItem menuItem);
    }

    private MenuItemCompat() {
    }

    @java.lang.Deprecated
    public static boolean collapseActionView(android.view.MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @java.lang.Deprecated
    public static boolean expandActionView(android.view.MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static androidx.core.view.ActionProvider getActionProvider(android.view.MenuItem menuItem) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            return ((androidx.core.internal.view.SupportMenuItem) menuItem).getSupportActionProvider();
        }
        return null;
    }

    @java.lang.Deprecated
    public static android.view.View getActionView(android.view.MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(android.view.MenuItem menuItem) {
        int alphabeticModifiers;
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            return ((androidx.core.internal.view.SupportMenuItem) menuItem).getAlphabeticModifiers();
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        alphabeticModifiers = menuItem.getAlphabeticModifiers();
        return alphabeticModifiers;
    }

    public static java.lang.CharSequence getContentDescription(android.view.MenuItem menuItem) {
        java.lang.CharSequence contentDescription;
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            return ((androidx.core.internal.view.SupportMenuItem) menuItem).getContentDescription();
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        contentDescription = menuItem.getContentDescription();
        return contentDescription;
    }

    public static android.content.res.ColorStateList getIconTintList(android.view.MenuItem menuItem) {
        android.content.res.ColorStateList iconTintList;
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            return ((androidx.core.internal.view.SupportMenuItem) menuItem).getIconTintList();
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        iconTintList = menuItem.getIconTintList();
        return iconTintList;
    }

    public static android.graphics.PorterDuff.Mode getIconTintMode(android.view.MenuItem menuItem) {
        android.graphics.PorterDuff.Mode iconTintMode;
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            return ((androidx.core.internal.view.SupportMenuItem) menuItem).getIconTintMode();
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        iconTintMode = menuItem.getIconTintMode();
        return iconTintMode;
    }

    public static int getNumericModifiers(android.view.MenuItem menuItem) {
        int numericModifiers;
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            return ((androidx.core.internal.view.SupportMenuItem) menuItem).getNumericModifiers();
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        numericModifiers = menuItem.getNumericModifiers();
        return numericModifiers;
    }

    public static java.lang.CharSequence getTooltipText(android.view.MenuItem menuItem) {
        java.lang.CharSequence tooltipText;
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            return ((androidx.core.internal.view.SupportMenuItem) menuItem).getTooltipText();
        }
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        tooltipText = menuItem.getTooltipText();
        return tooltipText;
    }

    @java.lang.Deprecated
    public static boolean isActionViewExpanded(android.view.MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static android.view.MenuItem setActionProvider(android.view.MenuItem menuItem, androidx.core.view.ActionProvider actionProvider) {
        return menuItem instanceof androidx.core.internal.view.SupportMenuItem ? ((androidx.core.internal.view.SupportMenuItem) menuItem).setSupportActionProvider(actionProvider) : menuItem;
    }

    @java.lang.Deprecated
    public static android.view.MenuItem setActionView(android.view.MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    @java.lang.Deprecated
    public static android.view.MenuItem setActionView(android.view.MenuItem menuItem, android.view.View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(android.view.MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            ((androidx.core.internal.view.SupportMenuItem) menuItem).setAlphabeticShortcut(c, i);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    public static void setContentDescription(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            ((androidx.core.internal.view.SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void setIconTintList(android.view.MenuItem menuItem, android.content.res.ColorStateList colorStateList) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            ((androidx.core.internal.view.SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void setIconTintMode(android.view.MenuItem menuItem, android.graphics.PorterDuff.Mode mode) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            ((androidx.core.internal.view.SupportMenuItem) menuItem).setIconTintMode(mode);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void setNumericShortcut(android.view.MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            ((androidx.core.internal.view.SupportMenuItem) menuItem).setNumericShortcut(c, i);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    @java.lang.Deprecated
    public static android.view.MenuItem setOnActionExpandListener(android.view.MenuItem menuItem, androidx.core.view.MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new androidx.core.view.MenuItemCompat.AnonymousClass1(onActionExpandListener));
    }

    public static void setShortcut(android.view.MenuItem menuItem, char c, char c2, int i, int i2) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            ((androidx.core.internal.view.SupportMenuItem) menuItem).setShortcut(c, c2, i, i2);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setShortcut(c, c2, i, i2);
        }
    }

    @java.lang.Deprecated
    public static void setShowAsAction(android.view.MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static void setTooltipText(android.view.MenuItem menuItem, java.lang.CharSequence charSequence) {
        if (menuItem instanceof androidx.core.internal.view.SupportMenuItem) {
            ((androidx.core.internal.view.SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else if (android.os.Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}
