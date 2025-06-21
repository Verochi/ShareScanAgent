package androidx.core.app;

/* loaded from: classes.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private java.util.List<androidx.core.app.NotificationChannelCompat> mChannels;
    java.lang.String mDescription;
    final java.lang.String mId;
    java.lang.CharSequence mName;

    public static class Builder {
        final androidx.core.app.NotificationChannelGroupCompat mGroup;

        public Builder(@androidx.annotation.NonNull java.lang.String str) {
            this.mGroup = new androidx.core.app.NotificationChannelGroupCompat(str);
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelGroupCompat.Builder setDescription(@androidx.annotation.Nullable java.lang.String str) {
            this.mGroup.mDescription = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelGroupCompat.Builder setName(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mGroup.mName = charSequence;
            return this;
        }
    }

    @androidx.annotation.RequiresApi(28)
    public NotificationChannelGroupCompat(@androidx.annotation.NonNull android.app.NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, java.util.Collections.emptyList());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RequiresApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NotificationChannelGroupCompat(@androidx.annotation.NonNull android.app.NotificationChannelGroup notificationChannelGroup, @androidx.annotation.NonNull java.util.List<android.app.NotificationChannel> list) {
        this(r0);
        java.lang.String id;
        java.lang.CharSequence name;
        boolean isBlocked;
        java.util.List<android.app.NotificationChannel> channels;
        java.lang.String description;
        id = notificationChannelGroup.getId();
        name = notificationChannelGroup.getName();
        this.mName = name;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            description = notificationChannelGroup.getDescription();
            this.mDescription = description;
        }
        if (i < 28) {
            this.mChannels = getChannelsCompat(list);
            return;
        }
        isBlocked = notificationChannelGroup.isBlocked();
        this.mBlocked = isBlocked;
        channels = notificationChannelGroup.getChannels();
        this.mChannels = getChannelsCompat(channels);
    }

    public NotificationChannelGroupCompat(@androidx.annotation.NonNull java.lang.String str) {
        this.mChannels = java.util.Collections.emptyList();
        this.mId = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str);
    }

    @androidx.annotation.RequiresApi(26)
    private java.util.List<androidx.core.app.NotificationChannelCompat> getChannelsCompat(java.util.List<android.app.NotificationChannel> list) {
        java.lang.String group;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.app.NotificationChannel notificationChannel : list) {
            java.lang.String str = this.mId;
            group = notificationChannel.getGroup();
            if (str.equals(group)) {
                arrayList.add(new androidx.core.app.NotificationChannelCompat(notificationChannel));
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public java.util.List<androidx.core.app.NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    @androidx.annotation.Nullable
    public java.lang.String getDescription() {
        return this.mDescription;
    }

    @androidx.annotation.NonNull
    public java.lang.String getId() {
        return this.mId;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getName() {
        return this.mName;
    }

    public android.app.NotificationChannelGroup getNotificationChannelGroup() {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        android.app.NotificationChannelGroup notificationChannelGroup = new android.app.NotificationChannelGroup(this.mId, this.mName);
        if (i >= 28) {
            notificationChannelGroup.setDescription(this.mDescription);
        }
        return notificationChannelGroup;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    @androidx.annotation.NonNull
    public androidx.core.app.NotificationChannelGroupCompat.Builder toBuilder() {
        return new androidx.core.app.NotificationChannelGroupCompat.Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }
}
