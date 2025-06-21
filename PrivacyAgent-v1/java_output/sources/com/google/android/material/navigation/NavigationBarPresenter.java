package com.google.android.material.navigation;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class NavigationBarPresenter implements androidx.appcompat.view.menu.MenuPresenter {
    private int id;
    private androidx.appcompat.view.menu.MenuBuilder menu;
    private com.google.android.material.navigation.NavigationBarMenuView menuView;
    private boolean updateSuspended = false;

    public static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.material.navigation.NavigationBarPresenter.SavedState> CREATOR = new com.google.android.material.navigation.NavigationBarPresenter.SavedState.AnonymousClass1();

        @androidx.annotation.Nullable
        com.google.android.material.internal.ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        /* renamed from: com.google.android.material.navigation.NavigationBarPresenter$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.navigation.NavigationBarPresenter.SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.navigation.NavigationBarPresenter.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.navigation.NavigationBarPresenter.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.navigation.NavigationBarPresenter.SavedState[] newArray(int i) {
                return new com.google.android.material.navigation.NavigationBarPresenter.SavedState[i];
            }
        }

        public SavedState() {
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (com.google.android.material.internal.ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@androidx.annotation.Nullable androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.Nullable androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@androidx.annotation.Nullable androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.Nullable androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.id;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @androidx.annotation.Nullable
    public androidx.appcompat.view.menu.MenuView getMenuView(@androidx.annotation.Nullable android.view.ViewGroup viewGroup) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@androidx.annotation.Nullable androidx.appcompat.view.menu.MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@androidx.annotation.NonNull android.os.Parcelable parcelable) {
        if (parcelable instanceof com.google.android.material.navigation.NavigationBarPresenter.SavedState) {
            com.google.android.material.navigation.NavigationBarPresenter.SavedState savedState = (com.google.android.material.navigation.NavigationBarPresenter.SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.selectedItemId);
            this.menuView.setBadgeDrawables(com.google.android.material.badge.BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.badgeSavedStates));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @androidx.annotation.NonNull
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.navigation.NavigationBarPresenter.SavedState savedState = new com.google.android.material.navigation.NavigationBarPresenter.SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        savedState.badgeSavedStates = com.google.android.material.badge.BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@androidx.annotation.Nullable androidx.appcompat.view.menu.SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@androidx.annotation.Nullable androidx.appcompat.view.menu.MenuPresenter.Callback callback) {
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMenuView(@androidx.annotation.NonNull com.google.android.material.navigation.NavigationBarMenuView navigationBarMenuView) {
        this.menuView = navigationBarMenuView;
    }

    public void setUpdateSuspended(boolean z) {
        this.updateSuspended = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.updateSuspended) {
            return;
        }
        if (z) {
            this.menuView.buildMenuView();
        } else {
            this.menuView.updateMenuView();
        }
    }
}
