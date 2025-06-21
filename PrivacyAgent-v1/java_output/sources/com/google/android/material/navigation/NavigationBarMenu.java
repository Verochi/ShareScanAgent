package com.google.android.material.navigation;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public final class NavigationBarMenu extends androidx.appcompat.view.menu.MenuBuilder {
    private final int maxItemCount;

    @androidx.annotation.NonNull
    private final java.lang.Class<?> viewClass;

    public NavigationBarMenu(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<?> cls, int i) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @androidx.annotation.NonNull
    public android.view.MenuItem addInternal(int i, int i2, int i3, @androidx.annotation.NonNull java.lang.CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            android.view.MenuItem addInternal = super.addInternal(i, i2, i3, charSequence);
            if (addInternal instanceof androidx.appcompat.view.menu.MenuItemImpl) {
                ((androidx.appcompat.view.menu.MenuItemImpl) addInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        java.lang.String simpleName = this.viewClass.getSimpleName();
        throw new java.lang.IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.maxItemCount + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @androidx.annotation.NonNull
    public android.view.SubMenu addSubMenu(int i, int i2, int i3, @androidx.annotation.NonNull java.lang.CharSequence charSequence) {
        throw new java.lang.UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
