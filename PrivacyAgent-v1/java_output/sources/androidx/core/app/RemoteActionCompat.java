package androidx.core.app;

/* loaded from: classes.dex */
public final class RemoteActionCompat implements androidx.versionedparcelable.VersionedParcelable {

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.app.PendingIntent mActionIntent;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.lang.CharSequence mContentDescription;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mEnabled;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public androidx.core.graphics.drawable.IconCompat mIcon;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.lang.CharSequence mTitle;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@androidx.annotation.NonNull androidx.core.app.RemoteActionCompat remoteActionCompat) {
        androidx.core.util.Preconditions.checkNotNull(remoteActionCompat);
        this.mIcon = remoteActionCompat.mIcon;
        this.mTitle = remoteActionCompat.mTitle;
        this.mContentDescription = remoteActionCompat.mContentDescription;
        this.mActionIntent = remoteActionCompat.mActionIntent;
        this.mEnabled = remoteActionCompat.mEnabled;
        this.mShouldShowIcon = remoteActionCompat.mShouldShowIcon;
    }

    public RemoteActionCompat(@androidx.annotation.NonNull androidx.core.graphics.drawable.IconCompat iconCompat, @androidx.annotation.NonNull java.lang.CharSequence charSequence, @androidx.annotation.NonNull java.lang.CharSequence charSequence2, @androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
        this.mIcon = (androidx.core.graphics.drawable.IconCompat) androidx.core.util.Preconditions.checkNotNull(iconCompat);
        this.mTitle = (java.lang.CharSequence) androidx.core.util.Preconditions.checkNotNull(charSequence);
        this.mContentDescription = (java.lang.CharSequence) androidx.core.util.Preconditions.checkNotNull(charSequence2);
        this.mActionIntent = (android.app.PendingIntent) androidx.core.util.Preconditions.checkNotNull(pendingIntent);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(26)
    public static androidx.core.app.RemoteActionCompat createFromRemoteAction(@androidx.annotation.NonNull android.app.RemoteAction remoteAction) {
        android.graphics.drawable.Icon icon;
        java.lang.CharSequence title;
        java.lang.CharSequence contentDescription;
        android.app.PendingIntent actionIntent;
        boolean isEnabled;
        boolean shouldShowIcon;
        androidx.core.util.Preconditions.checkNotNull(remoteAction);
        icon = remoteAction.getIcon();
        androidx.core.graphics.drawable.IconCompat createFromIcon = androidx.core.graphics.drawable.IconCompat.createFromIcon(icon);
        title = remoteAction.getTitle();
        contentDescription = remoteAction.getContentDescription();
        actionIntent = remoteAction.getActionIntent();
        androidx.core.app.RemoteActionCompat remoteActionCompat = new androidx.core.app.RemoteActionCompat(createFromIcon, title, contentDescription, actionIntent);
        isEnabled = remoteAction.isEnabled();
        remoteActionCompat.setEnabled(isEnabled);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            shouldShowIcon = remoteAction.shouldShowIcon();
            remoteActionCompat.setShouldShowIcon(shouldShowIcon);
        }
        return remoteActionCompat;
    }

    @androidx.annotation.NonNull
    public android.app.PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    @androidx.annotation.NonNull
    public java.lang.CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @androidx.annotation.NonNull
    public androidx.core.graphics.drawable.IconCompat getIcon() {
        return this.mIcon;
    }

    @androidx.annotation.NonNull
    public java.lang.CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setShouldShowIcon(boolean z) {
        this.mShouldShowIcon = z;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(26)
    public android.app.RemoteAction toRemoteAction() {
        android.app.RemoteAction remoteAction = new android.app.RemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        remoteAction.setEnabled(isEnabled());
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            remoteAction.setShouldShowIcon(shouldShowIcon());
        }
        return remoteAction;
    }
}
