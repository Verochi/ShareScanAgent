package androidx.core.app;

/* loaded from: classes.dex */
public class NotificationChannelCompat {
    public static final java.lang.String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    android.media.AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    java.lang.String mConversationId;
    java.lang.String mDescription;
    java.lang.String mGroupId;

    @androidx.annotation.NonNull
    final java.lang.String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    java.lang.CharSequence mName;
    java.lang.String mParentId;
    boolean mShowBadge;
    android.net.Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    public static class Builder {
        private final androidx.core.app.NotificationChannelCompat mChannel;

        public Builder(@androidx.annotation.NonNull java.lang.String str, int i) {
            this.mChannel = new androidx.core.app.NotificationChannelCompat(str, i);
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat build() {
            return this.mChannel;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setConversationId(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                androidx.core.app.NotificationChannelCompat notificationChannelCompat = this.mChannel;
                notificationChannelCompat.mParentId = str;
                notificationChannelCompat.mConversationId = str2;
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setDescription(@androidx.annotation.Nullable java.lang.String str) {
            this.mChannel.mDescription = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setGroup(@androidx.annotation.Nullable java.lang.String str) {
            this.mChannel.mGroupId = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setImportance(int i) {
            this.mChannel.mImportance = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setLightColor(int i) {
            this.mChannel.mLightColor = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setLightsEnabled(boolean z) {
            this.mChannel.mLights = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setName(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mChannel.mName = charSequence;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setShowBadge(boolean z) {
            this.mChannel.mShowBadge = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setSound(@androidx.annotation.Nullable android.net.Uri uri, @androidx.annotation.Nullable android.media.AudioAttributes audioAttributes) {
            androidx.core.app.NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mSound = uri;
            notificationChannelCompat.mAudioAttributes = audioAttributes;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setVibrationEnabled(boolean z) {
            this.mChannel.mVibrationEnabled = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationChannelCompat.Builder setVibrationPattern(@androidx.annotation.Nullable long[] jArr) {
            androidx.core.app.NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mVibrationEnabled = jArr != null && jArr.length > 0;
            notificationChannelCompat.mVibrationPattern = jArr;
            return this;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RequiresApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NotificationChannelCompat(@androidx.annotation.NonNull android.app.NotificationChannel notificationChannel) {
        this(r0, r1);
        java.lang.String id;
        int importance;
        java.lang.CharSequence name;
        java.lang.String description;
        java.lang.String group;
        boolean canShowBadge;
        android.net.Uri sound;
        android.media.AudioAttributes audioAttributes;
        boolean shouldShowLights;
        int lightColor;
        boolean shouldVibrate;
        long[] vibrationPattern;
        boolean canBypassDnd;
        int lockscreenVisibility;
        boolean isImportantConversation;
        boolean canBubble;
        java.lang.String parentChannelId;
        java.lang.String conversationId;
        id = notificationChannel.getId();
        importance = notificationChannel.getImportance();
        name = notificationChannel.getName();
        this.mName = name;
        description = notificationChannel.getDescription();
        this.mDescription = description;
        group = notificationChannel.getGroup();
        this.mGroupId = group;
        canShowBadge = notificationChannel.canShowBadge();
        this.mShowBadge = canShowBadge;
        sound = notificationChannel.getSound();
        this.mSound = sound;
        audioAttributes = notificationChannel.getAudioAttributes();
        this.mAudioAttributes = audioAttributes;
        shouldShowLights = notificationChannel.shouldShowLights();
        this.mLights = shouldShowLights;
        lightColor = notificationChannel.getLightColor();
        this.mLightColor = lightColor;
        shouldVibrate = notificationChannel.shouldVibrate();
        this.mVibrationEnabled = shouldVibrate;
        vibrationPattern = notificationChannel.getVibrationPattern();
        this.mVibrationPattern = vibrationPattern;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 30) {
            parentChannelId = notificationChannel.getParentChannelId();
            this.mParentId = parentChannelId;
            conversationId = notificationChannel.getConversationId();
            this.mConversationId = conversationId;
        }
        canBypassDnd = notificationChannel.canBypassDnd();
        this.mBypassDnd = canBypassDnd;
        lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        this.mLockscreenVisibility = lockscreenVisibility;
        if (i >= 29) {
            canBubble = notificationChannel.canBubble();
            this.mCanBubble = canBubble;
        }
        if (i >= 30) {
            isImportantConversation = notificationChannel.isImportantConversation();
            this.mImportantConversation = isImportantConversation;
        }
    }

    public NotificationChannelCompat(@androidx.annotation.NonNull java.lang.String str, int i) {
        this.mShowBadge = true;
        this.mSound = android.provider.Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (java.lang.String) androidx.core.util.Preconditions.checkNotNull(str);
        this.mImportance = i;
        this.mAudioAttributes = android.app.Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    @androidx.annotation.Nullable
    public android.media.AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @androidx.annotation.Nullable
    public java.lang.String getConversationId() {
        return this.mConversationId;
    }

    @androidx.annotation.Nullable
    public java.lang.String getDescription() {
        return this.mDescription;
    }

    @androidx.annotation.Nullable
    public java.lang.String getGroup() {
        return this.mGroupId;
    }

    @androidx.annotation.NonNull
    public java.lang.String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getName() {
        return this.mName;
    }

    public android.app.NotificationChannel getNotificationChannel() {
        java.lang.String str;
        java.lang.String str2;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(this.mId, this.mName, this.mImportance);
        notificationChannel.setDescription(this.mDescription);
        notificationChannel.setGroup(this.mGroupId);
        notificationChannel.setShowBadge(this.mShowBadge);
        notificationChannel.setSound(this.mSound, this.mAudioAttributes);
        notificationChannel.enableLights(this.mLights);
        notificationChannel.setLightColor(this.mLightColor);
        notificationChannel.setVibrationPattern(this.mVibrationPattern);
        notificationChannel.enableVibration(this.mVibrationEnabled);
        if (i >= 30 && (str = this.mParentId) != null && (str2 = this.mConversationId) != null) {
            notificationChannel.setConversationId(str, str2);
        }
        return notificationChannel;
    }

    @androidx.annotation.Nullable
    public java.lang.String getParentChannelId() {
        return this.mParentId;
    }

    @androidx.annotation.Nullable
    public android.net.Uri getSound() {
        return this.mSound;
    }

    @androidx.annotation.Nullable
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    @androidx.annotation.NonNull
    public androidx.core.app.NotificationChannelCompat.Builder toBuilder() {
        return new androidx.core.app.NotificationChannelCompat.Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }
}
