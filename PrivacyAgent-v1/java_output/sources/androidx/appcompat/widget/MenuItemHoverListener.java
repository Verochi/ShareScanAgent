package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface MenuItemHoverListener {
    void onItemHoverEnter(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.MenuItem menuItem);

    void onItemHoverExit(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.MenuItem menuItem);
}
