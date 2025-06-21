package androidx.core.app;

/* loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final java.lang.String CATEGORY_ALARM = "alarm";
    public static final java.lang.String CATEGORY_CALL = "call";
    public static final java.lang.String CATEGORY_EMAIL = "email";
    public static final java.lang.String CATEGORY_ERROR = "err";
    public static final java.lang.String CATEGORY_EVENT = "event";
    public static final java.lang.String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final java.lang.String CATEGORY_MESSAGE = "msg";
    public static final java.lang.String CATEGORY_MISSED_CALL = "missed_call";
    public static final java.lang.String CATEGORY_NAVIGATION = "navigation";
    public static final java.lang.String CATEGORY_PROGRESS = "progress";
    public static final java.lang.String CATEGORY_PROMO = "promo";
    public static final java.lang.String CATEGORY_RECOMMENDATION = "recommendation";
    public static final java.lang.String CATEGORY_REMINDER = "reminder";
    public static final java.lang.String CATEGORY_SERVICE = "service";
    public static final java.lang.String CATEGORY_SOCIAL = "social";
    public static final java.lang.String CATEGORY_STATUS = "status";
    public static final java.lang.String CATEGORY_STOPWATCH = "stopwatch";
    public static final java.lang.String CATEGORY_SYSTEM = "sys";
    public static final java.lang.String CATEGORY_TRANSPORT = "transport";
    public static final java.lang.String CATEGORY_WORKOUT = "workout";

    @androidx.annotation.ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_BIG_TEXT = "android.bigText";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_COLORIZED = "android.colorized";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final java.lang.String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_INFO_TEXT = "android.infoText";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_LARGE_ICON = "android.largeIcon";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_MEDIA_SESSION = "android.mediaSession";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_MESSAGES = "android.messages";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

    @android.annotation.SuppressLint({"ActionValue"})
    @java.lang.Deprecated
    public static final java.lang.String EXTRA_PEOPLE = "android.people";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_PEOPLE_LIST = "android.people.list";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_PICTURE = "android.picture";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_PROGRESS = "android.progress";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_PROGRESS_MAX = "android.progressMax";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_SHOW_WHEN = "android.showWhen";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_SMALL_ICON = "android.icon";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_SUB_TEXT = "android.subText";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_SUMMARY_TEXT = "android.summaryText";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_TEMPLATE = "android.template";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_TEXT = "android.text";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_TEXT_LINES = "android.textLines";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_TITLE = "android.title";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @java.lang.Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final java.lang.String GROUP_KEY_SILENT = "silent";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action {
        static final java.lang.String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final java.lang.String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public android.app.PendingIntent actionIntent;

        @java.lang.Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private final androidx.core.app.RemoteInput[] mDataOnlyRemoteInputs;
        final android.os.Bundle mExtras;

        @androidx.annotation.Nullable
        private androidx.core.graphics.drawable.IconCompat mIcon;
        private final boolean mIsContextual;
        private final androidx.core.app.RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public java.lang.CharSequence title;

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private final android.os.Bundle mExtras;
            private final androidx.core.graphics.drawable.IconCompat mIcon;
            private final android.app.PendingIntent mIntent;
            private boolean mIsContextual;
            private java.util.ArrayList<androidx.core.app.RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final java.lang.CharSequence mTitle;

            public Builder(int i, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
                this(i != 0 ? androidx.core.graphics.drawable.IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, new android.os.Bundle(), null, true, 0, true, false);
            }

            public Builder(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new android.os.Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface, action.isContextual());
            }

            public Builder(@androidx.annotation.Nullable androidx.core.graphics.drawable.IconCompat iconCompat, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new android.os.Bundle(), null, true, 0, true, false);
            }

            private Builder(@androidx.annotation.Nullable androidx.core.graphics.drawable.IconCompat iconCompat, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.Nullable androidx.core.app.RemoteInput[] remoteInputArr, boolean z, int i, boolean z2, boolean z3) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = iconCompat;
                this.mTitle = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                this.mRemoteInputs = remoteInputArr == null ? null : new java.util.ArrayList<>(java.util.Arrays.asList(remoteInputArr));
                this.mAllowGeneratedReplies = z;
                this.mSemanticAction = i;
                this.mShowsUserInterface = z2;
                this.mIsContextual = z3;
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual && this.mIntent == null) {
                    throw new java.lang.NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[LOOP:0: B:11:0x0034->B:12:0x0036, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
            @androidx.annotation.NonNull
            @androidx.annotation.RequiresApi(19)
            @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static androidx.core.app.NotificationCompat.Action.Builder fromAndroidAction(@androidx.annotation.NonNull android.app.Notification.Action action) {
                androidx.core.app.NotificationCompat.Action.Builder builder;
                android.app.RemoteInput[] remoteInputs;
                int i;
                boolean isContextual;
                int semanticAction;
                boolean allowGeneratedReplies;
                android.graphics.drawable.Icon icon;
                android.graphics.drawable.Icon icon2;
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    icon = action.getIcon();
                    if (icon != null) {
                        icon2 = action.getIcon();
                        builder = new androidx.core.app.NotificationCompat.Action.Builder(androidx.core.graphics.drawable.IconCompat.createFromIcon(icon2), action.title, action.actionIntent);
                        remoteInputs = action.getRemoteInputs();
                        if (remoteInputs != null && remoteInputs.length != 0) {
                            for (android.app.RemoteInput remoteInput : remoteInputs) {
                                builder.addRemoteInput(androidx.core.app.RemoteInput.fromPlatform(remoteInput));
                            }
                        }
                        i = android.os.Build.VERSION.SDK_INT;
                        if (i >= 24) {
                            allowGeneratedReplies = action.getAllowGeneratedReplies();
                            builder.mAllowGeneratedReplies = allowGeneratedReplies;
                        }
                        if (i >= 28) {
                            semanticAction = action.getSemanticAction();
                            builder.setSemanticAction(semanticAction);
                        }
                        if (i >= 29) {
                            isContextual = action.isContextual();
                            builder.setContextual(isContextual);
                        }
                        return builder;
                    }
                }
                builder = new androidx.core.app.NotificationCompat.Action.Builder(action.icon, action.title, action.actionIntent);
                remoteInputs = action.getRemoteInputs();
                if (remoteInputs != null) {
                    while (r3 < r2) {
                    }
                }
                i = android.os.Build.VERSION.SDK_INT;
                if (i >= 24) {
                }
                if (i >= 28) {
                }
                if (i >= 29) {
                }
                return builder;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder addExtras(@androidx.annotation.Nullable android.os.Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder addRemoteInput(@androidx.annotation.Nullable androidx.core.app.RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new java.util.ArrayList<>();
                }
                if (remoteInput != null) {
                    this.mRemoteInputs.add(remoteInput);
                }
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action build() {
                checkContextualActionNullFields();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                java.util.ArrayList<androidx.core.app.RemoteInput> arrayList3 = this.mRemoteInputs;
                if (arrayList3 != null) {
                    java.util.Iterator<androidx.core.app.RemoteInput> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        androidx.core.app.RemoteInput next = it.next();
                        if (next.isDataOnly()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                androidx.core.app.RemoteInput[] remoteInputArr = arrayList.isEmpty() ? null : (androidx.core.app.RemoteInput[]) arrayList.toArray(new androidx.core.app.RemoteInput[arrayList.size()]);
                return new androidx.core.app.NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayList2.isEmpty() ? null : (androidx.core.app.RemoteInput[]) arrayList2.toArray(new androidx.core.app.RemoteInput[arrayList2.size()]), remoteInputArr, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder extend(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Action.Extender extender) {
                extender.extend(this);
                return this;
            }

            @androidx.annotation.NonNull
            public android.os.Bundle getExtras() {
                return this.mExtras;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder setAllowGeneratedReplies(boolean z) {
                this.mAllowGeneratedReplies = z;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder setContextual(boolean z) {
                this.mIsContextual = z;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder setSemanticAction(int i) {
                this.mSemanticAction = i;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder setShowsUserInterface(boolean z) {
                this.mShowsUserInterface = z;
                return this;
            }
        }

        public interface Extender {
            @androidx.annotation.NonNull
            androidx.core.app.NotificationCompat.Action.Builder extend(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Action.Builder builder);
        }

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements androidx.core.app.NotificationCompat.Action.Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final java.lang.String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final java.lang.String KEY_CANCEL_LABEL = "cancelLabel";
            private static final java.lang.String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final java.lang.String KEY_FLAGS = "flags";
            private static final java.lang.String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private java.lang.CharSequence mCancelLabel;
            private java.lang.CharSequence mConfirmLabel;
            private int mFlags;
            private java.lang.CharSequence mInProgressLabel;

            public WearableExtender() {
                this.mFlags = 1;
            }

            public WearableExtender(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Action action) {
                this.mFlags = 1;
                android.os.Bundle bundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (bundle != null) {
                    this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            private void setFlag(int i, boolean z) {
                if (z) {
                    this.mFlags = i | this.mFlags;
                } else {
                    this.mFlags = (~i) & this.mFlags;
                }
            }

            @androidx.annotation.NonNull
            /* renamed from: clone, reason: merged with bridge method [inline-methods] */
            public androidx.core.app.NotificationCompat.Action.WearableExtender m3clone() {
                androidx.core.app.NotificationCompat.Action.WearableExtender wearableExtender = new androidx.core.app.NotificationCompat.Action.WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.Builder extend(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Action.Builder builder) {
                android.os.Bundle bundle = new android.os.Bundle();
                int i = this.mFlags;
                if (i != 1) {
                    bundle.putInt(KEY_FLAGS, i);
                }
                java.lang.CharSequence charSequence = this.mInProgressLabel;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
                }
                java.lang.CharSequence charSequence2 = this.mConfirmLabel;
                if (charSequence2 != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence2);
                }
                java.lang.CharSequence charSequence3 = this.mCancelLabel;
                if (charSequence3 != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, charSequence3);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
                return builder;
            }

            @androidx.annotation.Nullable
            @java.lang.Deprecated
            public java.lang.CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @androidx.annotation.Nullable
            @java.lang.Deprecated
            public java.lang.CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                return (this.mFlags & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.mFlags & 2) != 0;
            }

            @androidx.annotation.Nullable
            @java.lang.Deprecated
            public java.lang.CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.WearableExtender setAvailableOffline(boolean z) {
                setFlag(1, z);
                return this;
            }

            @androidx.annotation.NonNull
            @java.lang.Deprecated
            public androidx.core.app.NotificationCompat.Action.WearableExtender setCancelLabel(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            @androidx.annotation.NonNull
            @java.lang.Deprecated
            public androidx.core.app.NotificationCompat.Action.WearableExtender setConfirmLabel(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.WearableExtender setHintDisplayActionInline(boolean z) {
                setFlag(4, z);
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.Action.WearableExtender setHintLaunchesActivity(boolean z) {
                setFlag(2, z);
                return this;
            }

            @androidx.annotation.NonNull
            @java.lang.Deprecated
            public androidx.core.app.NotificationCompat.Action.WearableExtender setInProgressLabel(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }
        }

        public Action(int i, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
            this(i != 0 ? androidx.core.graphics.drawable.IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent);
        }

        public Action(int i, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable androidx.core.app.RemoteInput[] remoteInputArr, @androidx.annotation.Nullable androidx.core.app.RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3) {
            this(i != 0 ? androidx.core.graphics.drawable.IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i2, z2, z3);
        }

        public Action(@androidx.annotation.Nullable androidx.core.graphics.drawable.IconCompat iconCompat, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new android.os.Bundle(), (androidx.core.app.RemoteInput[]) null, (androidx.core.app.RemoteInput[]) null, true, 0, true, false);
        }

        public Action(@androidx.annotation.Nullable androidx.core.graphics.drawable.IconCompat iconCompat, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable androidx.core.app.RemoteInput[] remoteInputArr, @androidx.annotation.Nullable androidx.core.app.RemoteInput[] remoteInputArr2, boolean z, int i, boolean z2, boolean z3) {
            this.mShowsUserInterface = true;
            this.mIcon = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle == null ? new android.os.Bundle() : bundle;
            this.mRemoteInputs = remoteInputArr;
            this.mDataOnlyRemoteInputs = remoteInputArr2;
            this.mAllowGeneratedReplies = z;
            this.mSemanticAction = i;
            this.mShowsUserInterface = z2;
            this.mIsContextual = z3;
        }

        @androidx.annotation.Nullable
        public android.app.PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        @androidx.annotation.Nullable
        public androidx.core.app.RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        @androidx.annotation.NonNull
        public android.os.Bundle getExtras() {
            return this.mExtras;
        }

        @java.lang.Deprecated
        public int getIcon() {
            return this.icon;
        }

        @androidx.annotation.Nullable
        public androidx.core.graphics.drawable.IconCompat getIconCompat() {
            int i;
            if (this.mIcon == null && (i = this.icon) != 0) {
                this.mIcon = androidx.core.graphics.drawable.IconCompat.createWithResource(null, "", i);
            }
            return this.mIcon;
        }

        @androidx.annotation.Nullable
        public androidx.core.app.RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        @androidx.annotation.Nullable
        public java.lang.CharSequence getTitle() {
            return this.title;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends androidx.core.app.NotificationCompat.Style {
        private static final java.lang.String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private androidx.core.graphics.drawable.IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private android.graphics.Bitmap mPicture;

        @androidx.annotation.RequiresApi(16)
        public static class Api16Impl {
            private Api16Impl() {
            }

            @androidx.annotation.RequiresApi(16)
            public static void setBigLargeIcon(android.app.Notification.BigPictureStyle bigPictureStyle, android.graphics.Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            @androidx.annotation.RequiresApi(16)
            public static void setSummaryText(android.app.Notification.BigPictureStyle bigPictureStyle, java.lang.CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        @androidx.annotation.RequiresApi(23)
        public static class Api23Impl {
            private Api23Impl() {
            }

            @androidx.annotation.RequiresApi(23)
            public static void setBigLargeIcon(android.app.Notification.BigPictureStyle bigPictureStyle, android.graphics.drawable.Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        public BigPictureStyle() {
        }

        public BigPictureStyle(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        @androidx.annotation.Nullable
        private static androidx.core.graphics.drawable.IconCompat asIconCompat(@androidx.annotation.Nullable android.os.Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (android.os.Build.VERSION.SDK_INT >= 23 && (parcelable instanceof android.graphics.drawable.Icon)) {
                return androidx.core.graphics.drawable.IconCompat.createFromIcon((android.graphics.drawable.Icon) parcelable);
            }
            if (parcelable instanceof android.graphics.Bitmap) {
                return androidx.core.graphics.drawable.IconCompat.createWithBitmap((android.graphics.Bitmap) parcelable);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = android.os.Build.VERSION.SDK_INT;
            android.app.Notification.BigPictureStyle bigPicture = new android.app.Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
            if (this.mBigLargeIconSet) {
                androidx.core.graphics.drawable.IconCompat iconCompat = this.mBigLargeIcon;
                if (iconCompat == null) {
                    androidx.core.app.NotificationCompat.BigPictureStyle.Api16Impl.setBigLargeIcon(bigPicture, null);
                } else if (i >= 23) {
                    androidx.core.app.NotificationCompat.BigPictureStyle.Api23Impl.setBigLargeIcon(bigPicture, this.mBigLargeIcon.toIcon(notificationBuilderWithBuilderAccessor instanceof androidx.core.app.NotificationCompatBuilder ? ((androidx.core.app.NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).getContext() : null));
                } else if (iconCompat.getType() == 1) {
                    androidx.core.app.NotificationCompat.BigPictureStyle.Api16Impl.setBigLargeIcon(bigPicture, this.mBigLargeIcon.getBitmap());
                } else {
                    androidx.core.app.NotificationCompat.BigPictureStyle.Api16Impl.setBigLargeIcon(bigPicture, null);
                }
            }
            if (this.mSummaryTextSet) {
                androidx.core.app.NotificationCompat.BigPictureStyle.Api16Impl.setSummaryText(bigPicture, this.mSummaryText);
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.BigPictureStyle bigLargeIcon(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
            this.mBigLargeIcon = bitmap == null ? null : androidx.core.graphics.drawable.IconCompat.createWithBitmap(bitmap);
            this.mBigLargeIconSet = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.BigPictureStyle bigPicture(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_LARGE_ICON_BIG);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_PICTURE);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.lang.String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            if (bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_LARGE_ICON_BIG)) {
                this.mBigLargeIcon = asIconCompat(bundle.getParcelable(androidx.core.app.NotificationCompat.EXTRA_LARGE_ICON_BIG));
                this.mBigLargeIconSet = true;
            }
            this.mPicture = (android.graphics.Bitmap) bundle.getParcelable(androidx.core.app.NotificationCompat.EXTRA_PICTURE);
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.BigPictureStyle setBigContentTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mBigContentTitle = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.BigPictureStyle setSummaryText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mSummaryText = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class BigTextStyle extends androidx.core.app.NotificationCompat.Style {
        private static final java.lang.String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private java.lang.CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.addCompatExtras(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            android.app.Notification.BigTextStyle bigText = new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet) {
                bigText.setSummaryText(this.mSummaryText);
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.BigTextStyle bigText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mBigText = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.lang.String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mBigText = bundle.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_BIG_TEXT);
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.BigTextStyle setBigContentTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mBigContentTitle = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.BigTextStyle setSummaryText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mSummaryText = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private android.app.PendingIntent mDeleteIntent;
        private int mDesiredHeight;

        @androidx.annotation.DimenRes
        private int mDesiredHeightResId;
        private int mFlags;
        private androidx.core.graphics.drawable.IconCompat mIcon;
        private android.app.PendingIntent mPendingIntent;
        private java.lang.String mShortcutId;

        @androidx.annotation.RequiresApi(29)
        public static class Api29Impl {
            private Api29Impl() {
            }

            @androidx.annotation.Nullable
            @androidx.annotation.RequiresApi(29)
            public static androidx.core.app.NotificationCompat.BubbleMetadata fromPlatform(@androidx.annotation.Nullable android.app.Notification.BubbleMetadata bubbleMetadata) {
                android.app.PendingIntent intent;
                android.app.PendingIntent intent2;
                android.graphics.drawable.Icon icon;
                boolean autoExpandBubble;
                android.app.PendingIntent deleteIntent;
                boolean isNotificationSuppressed;
                int desiredHeight;
                int desiredHeightResId;
                int desiredHeightResId2;
                int desiredHeight2;
                if (bubbleMetadata == null) {
                    return null;
                }
                intent = bubbleMetadata.getIntent();
                if (intent == null) {
                    return null;
                }
                intent2 = bubbleMetadata.getIntent();
                icon = bubbleMetadata.getIcon();
                androidx.core.app.NotificationCompat.BubbleMetadata.Builder builder = new androidx.core.app.NotificationCompat.BubbleMetadata.Builder(intent2, androidx.core.graphics.drawable.IconCompat.createFromIcon(icon));
                autoExpandBubble = bubbleMetadata.getAutoExpandBubble();
                androidx.core.app.NotificationCompat.BubbleMetadata.Builder autoExpandBubble2 = builder.setAutoExpandBubble(autoExpandBubble);
                deleteIntent = bubbleMetadata.getDeleteIntent();
                androidx.core.app.NotificationCompat.BubbleMetadata.Builder deleteIntent2 = autoExpandBubble2.setDeleteIntent(deleteIntent);
                isNotificationSuppressed = bubbleMetadata.isNotificationSuppressed();
                androidx.core.app.NotificationCompat.BubbleMetadata.Builder suppressNotification = deleteIntent2.setSuppressNotification(isNotificationSuppressed);
                desiredHeight = bubbleMetadata.getDesiredHeight();
                if (desiredHeight != 0) {
                    desiredHeight2 = bubbleMetadata.getDesiredHeight();
                    suppressNotification.setDesiredHeight(desiredHeight2);
                }
                desiredHeightResId = bubbleMetadata.getDesiredHeightResId();
                if (desiredHeightResId != 0) {
                    desiredHeightResId2 = bubbleMetadata.getDesiredHeightResId();
                    suppressNotification.setDesiredHeightResId(desiredHeightResId2);
                }
                return suppressNotification.build();
            }

            @androidx.annotation.Nullable
            @androidx.annotation.RequiresApi(29)
            public static android.app.Notification.BubbleMetadata toPlatform(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.BubbleMetadata bubbleMetadata) {
                android.app.Notification.BubbleMetadata.Builder icon;
                android.app.Notification.BubbleMetadata.Builder intent;
                android.app.Notification.BubbleMetadata.Builder deleteIntent;
                android.app.Notification.BubbleMetadata.Builder autoExpandBubble;
                android.app.Notification.BubbleMetadata.Builder suppressNotification;
                android.app.Notification.BubbleMetadata build;
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                icon = new android.app.Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.getIcon().toIcon());
                intent = icon.setIntent(bubbleMetadata.getIntent());
                deleteIntent = intent.setDeleteIntent(bubbleMetadata.getDeleteIntent());
                autoExpandBubble = deleteIntent.setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble());
                suppressNotification = autoExpandBubble.setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                build = suppressNotification.build();
                return build;
            }
        }

        @androidx.annotation.RequiresApi(30)
        public static class Api30Impl {
            private Api30Impl() {
            }

            @androidx.annotation.Nullable
            @androidx.annotation.RequiresApi(30)
            public static androidx.core.app.NotificationCompat.BubbleMetadata fromPlatform(@androidx.annotation.Nullable android.app.Notification.BubbleMetadata bubbleMetadata) {
                java.lang.String shortcutId;
                androidx.core.app.NotificationCompat.BubbleMetadata.Builder builder;
                android.app.PendingIntent intent;
                android.graphics.drawable.Icon icon;
                boolean autoExpandBubble;
                android.app.PendingIntent deleteIntent;
                boolean isNotificationSuppressed;
                int desiredHeight;
                int desiredHeightResId;
                int desiredHeightResId2;
                int desiredHeight2;
                java.lang.String shortcutId2;
                if (bubbleMetadata == null) {
                    return null;
                }
                shortcutId = bubbleMetadata.getShortcutId();
                if (shortcutId != null) {
                    shortcutId2 = bubbleMetadata.getShortcutId();
                    builder = new androidx.core.app.NotificationCompat.BubbleMetadata.Builder(shortcutId2);
                } else {
                    intent = bubbleMetadata.getIntent();
                    icon = bubbleMetadata.getIcon();
                    builder = new androidx.core.app.NotificationCompat.BubbleMetadata.Builder(intent, androidx.core.graphics.drawable.IconCompat.createFromIcon(icon));
                }
                autoExpandBubble = bubbleMetadata.getAutoExpandBubble();
                androidx.core.app.NotificationCompat.BubbleMetadata.Builder autoExpandBubble2 = builder.setAutoExpandBubble(autoExpandBubble);
                deleteIntent = bubbleMetadata.getDeleteIntent();
                androidx.core.app.NotificationCompat.BubbleMetadata.Builder deleteIntent2 = autoExpandBubble2.setDeleteIntent(deleteIntent);
                isNotificationSuppressed = bubbleMetadata.isNotificationSuppressed();
                deleteIntent2.setSuppressNotification(isNotificationSuppressed);
                desiredHeight = bubbleMetadata.getDesiredHeight();
                if (desiredHeight != 0) {
                    desiredHeight2 = bubbleMetadata.getDesiredHeight();
                    builder.setDesiredHeight(desiredHeight2);
                }
                desiredHeightResId = bubbleMetadata.getDesiredHeightResId();
                if (desiredHeightResId != 0) {
                    desiredHeightResId2 = bubbleMetadata.getDesiredHeightResId();
                    builder.setDesiredHeightResId(desiredHeightResId2);
                }
                return builder.build();
            }

            @androidx.annotation.Nullable
            @androidx.annotation.RequiresApi(30)
            public static android.app.Notification.BubbleMetadata toPlatform(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.BubbleMetadata bubbleMetadata) {
                android.app.Notification.BubbleMetadata.Builder deleteIntent;
                android.app.Notification.BubbleMetadata.Builder autoExpandBubble;
                android.app.Notification.BubbleMetadata build;
                if (bubbleMetadata == null) {
                    return null;
                }
                android.app.Notification.BubbleMetadata.Builder builder = bubbleMetadata.getShortcutId() != null ? new android.app.Notification.BubbleMetadata.Builder(bubbleMetadata.getShortcutId()) : new android.app.Notification.BubbleMetadata.Builder(bubbleMetadata.getIntent(), bubbleMetadata.getIcon().toIcon());
                deleteIntent = builder.setDeleteIntent(bubbleMetadata.getDeleteIntent());
                autoExpandBubble = deleteIntent.setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble());
                autoExpandBubble.setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                build = builder.build();
                return build;
            }
        }

        public static final class Builder {
            private android.app.PendingIntent mDeleteIntent;
            private int mDesiredHeight;

            @androidx.annotation.DimenRes
            private int mDesiredHeightResId;
            private int mFlags;
            private androidx.core.graphics.drawable.IconCompat mIcon;
            private android.app.PendingIntent mPendingIntent;
            private java.lang.String mShortcutId;

            @java.lang.Deprecated
            public Builder() {
            }

            public Builder(@androidx.annotation.NonNull android.app.PendingIntent pendingIntent, @androidx.annotation.NonNull androidx.core.graphics.drawable.IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new java.lang.NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat == null) {
                    throw new java.lang.NullPointerException("Bubbles require non-null icon");
                }
                this.mPendingIntent = pendingIntent;
                this.mIcon = iconCompat;
            }

            @androidx.annotation.RequiresApi(30)
            public Builder(@androidx.annotation.NonNull java.lang.String str) {
                if (android.text.TextUtils.isEmpty(str)) {
                    throw new java.lang.NullPointerException("Bubble requires a non-null shortcut id");
                }
                this.mShortcutId = str;
            }

            @androidx.annotation.NonNull
            private androidx.core.app.NotificationCompat.BubbleMetadata.Builder setFlag(int i, boolean z) {
                if (z) {
                    this.mFlags = i | this.mFlags;
                } else {
                    this.mFlags = (~i) & this.mFlags;
                }
                return this;
            }

            @androidx.annotation.NonNull
            @android.annotation.SuppressLint({"SyntheticAccessor"})
            public androidx.core.app.NotificationCompat.BubbleMetadata build() {
                java.lang.String str = this.mShortcutId;
                if (str == null && this.mPendingIntent == null) {
                    throw new java.lang.NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.mIcon == null) {
                    throw new java.lang.NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                androidx.core.app.NotificationCompat.BubbleMetadata bubbleMetadata = new androidx.core.app.NotificationCompat.BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, str, null);
                bubbleMetadata.setFlags(this.mFlags);
                return bubbleMetadata;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.BubbleMetadata.Builder setAutoExpandBubble(boolean z) {
                setFlag(1, z);
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.BubbleMetadata.Builder setDeleteIntent(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
                this.mDeleteIntent = pendingIntent;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.BubbleMetadata.Builder setDesiredHeight(@androidx.annotation.Dimension(unit = 0) int i) {
                this.mDesiredHeight = java.lang.Math.max(i, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.BubbleMetadata.Builder setDesiredHeightResId(@androidx.annotation.DimenRes int i) {
                this.mDesiredHeightResId = i;
                this.mDesiredHeight = 0;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.BubbleMetadata.Builder setIcon(@androidx.annotation.NonNull androidx.core.graphics.drawable.IconCompat iconCompat) {
                if (this.mShortcutId != null) {
                    throw new java.lang.IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                if (iconCompat == null) {
                    throw new java.lang.NullPointerException("Bubbles require non-null icon");
                }
                this.mIcon = iconCompat;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.BubbleMetadata.Builder setIntent(@androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
                if (this.mShortcutId != null) {
                    throw new java.lang.IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                if (pendingIntent == null) {
                    throw new java.lang.NullPointerException("Bubble requires non-null pending intent");
                }
                this.mPendingIntent = pendingIntent;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.BubbleMetadata.Builder setSuppressNotification(boolean z) {
                setFlag(2, z);
                return this;
            }
        }

        private BubbleMetadata(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent2, @androidx.annotation.Nullable androidx.core.graphics.drawable.IconCompat iconCompat, int i, @androidx.annotation.DimenRes int i2, int i3, @androidx.annotation.Nullable java.lang.String str) {
            this.mPendingIntent = pendingIntent;
            this.mIcon = iconCompat;
            this.mDesiredHeight = i;
            this.mDesiredHeightResId = i2;
            this.mDeleteIntent = pendingIntent2;
            this.mFlags = i3;
            this.mShortcutId = str;
        }

        public /* synthetic */ BubbleMetadata(android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, androidx.core.graphics.drawable.IconCompat iconCompat, int i, int i2, int i3, java.lang.String str, androidx.core.app.NotificationCompat.AnonymousClass1 anonymousClass1) {
            this(pendingIntent, pendingIntent2, iconCompat, i, i2, i3, str);
        }

        @androidx.annotation.Nullable
        public static androidx.core.app.NotificationCompat.BubbleMetadata fromPlatform(@androidx.annotation.Nullable android.app.Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 30) {
                return androidx.core.app.NotificationCompat.BubbleMetadata.Api30Impl.fromPlatform(bubbleMetadata);
            }
            if (i == 29) {
                return androidx.core.app.NotificationCompat.BubbleMetadata.Api29Impl.fromPlatform(bubbleMetadata);
            }
            return null;
        }

        @androidx.annotation.Nullable
        public static android.app.Notification.BubbleMetadata toPlatform(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 30) {
                return androidx.core.app.NotificationCompat.BubbleMetadata.Api30Impl.toPlatform(bubbleMetadata);
            }
            if (i == 29) {
                return androidx.core.app.NotificationCompat.BubbleMetadata.Api29Impl.toPlatform(bubbleMetadata);
            }
            return null;
        }

        public boolean getAutoExpandBubble() {
            return (this.mFlags & 1) != 0;
        }

        @androidx.annotation.Nullable
        public android.app.PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        @androidx.annotation.Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        @androidx.annotation.DimenRes
        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        @androidx.annotation.Nullable
        @android.annotation.SuppressLint({"InvalidNullConversion"})
        public androidx.core.graphics.drawable.IconCompat getIcon() {
            return this.mIcon;
        }

        @androidx.annotation.Nullable
        @android.annotation.SuppressLint({"InvalidNullConversion"})
        public android.app.PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        @androidx.annotation.Nullable
        public java.lang.String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            return (this.mFlags & 2) != 0;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setFlags(int i) {
            this.mFlags = i;
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.util.ArrayList<androidx.core.app.NotificationCompat.Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        android.widget.RemoteViews mBigContentView;
        androidx.core.app.NotificationCompat.BubbleMetadata mBubbleMetadata;
        java.lang.String mCategory;
        java.lang.String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        java.lang.CharSequence mContentInfo;
        android.app.PendingIntent mContentIntent;
        java.lang.CharSequence mContentText;
        java.lang.CharSequence mContentTitle;
        android.widget.RemoteViews mContentView;

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.content.Context mContext;
        android.os.Bundle mExtras;
        android.app.PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        java.lang.String mGroupKey;
        boolean mGroupSummary;
        android.widget.RemoteViews mHeadsUpContentView;
        java.util.ArrayList<androidx.core.app.NotificationCompat.Action> mInvisibleActions;
        android.graphics.Bitmap mLargeIcon;
        boolean mLocalOnly;
        androidx.core.content.LocusIdCompat mLocusId;
        android.app.Notification mNotification;
        int mNumber;

        @java.lang.Deprecated
        public java.util.ArrayList<java.lang.String> mPeople;

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.util.ArrayList<androidx.core.app.Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        android.app.Notification mPublicVersion;
        java.lang.CharSequence[] mRemoteInputHistory;
        java.lang.CharSequence mSettingsText;
        java.lang.String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        android.graphics.drawable.Icon mSmallIcon;
        java.lang.String mSortKey;
        androidx.core.app.NotificationCompat.Style mStyle;
        java.lang.CharSequence mSubText;
        android.widget.RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        @java.lang.Deprecated
        public Builder(@androidx.annotation.NonNull android.content.Context context) {
            this(context, (java.lang.String) null);
        }

        @androidx.annotation.RequiresApi(19)
        public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.app.Notification notification) {
            this(context, androidx.core.app.NotificationCompat.getChannelId(notification));
            java.util.ArrayList parcelableArrayList;
            android.graphics.drawable.Icon smallIcon;
            android.os.Bundle bundle = notification.extras;
            androidx.core.app.NotificationCompat.Style extractStyleFromNotification = androidx.core.app.NotificationCompat.Style.extractStyleFromNotification(notification);
            setContentTitle(androidx.core.app.NotificationCompat.getContentTitle(notification)).setContentText(androidx.core.app.NotificationCompat.getContentText(notification)).setContentInfo(androidx.core.app.NotificationCompat.getContentInfo(notification)).setSubText(androidx.core.app.NotificationCompat.getSubText(notification)).setSettingsText(androidx.core.app.NotificationCompat.getSettingsText(notification)).setStyle(extractStyleFromNotification).setContentIntent(notification.contentIntent).setGroup(androidx.core.app.NotificationCompat.getGroup(notification)).setGroupSummary(androidx.core.app.NotificationCompat.isGroupSummary(notification)).setLocusId(androidx.core.app.NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(androidx.core.app.NotificationCompat.getShowWhen(notification)).setUsesChronometer(androidx.core.app.NotificationCompat.getUsesChronometer(notification)).setAutoCancel(androidx.core.app.NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(androidx.core.app.NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(androidx.core.app.NotificationCompat.getOngoing(notification)).setLocalOnly(androidx.core.app.NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(androidx.core.app.NotificationCompat.getBadgeIconType(notification)).setCategory(androidx.core.app.NotificationCompat.getCategory(notification)).setBubbleMetadata(androidx.core.app.NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, androidx.core.app.NotificationCompat.getHighPriority(notification)).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(androidx.core.app.NotificationCompat.getColor(notification)).setVisibility(androidx.core.app.NotificationCompat.getVisibility(notification)).setPublicVersion(androidx.core.app.NotificationCompat.getPublicVersion(notification)).setSortKey(androidx.core.app.NotificationCompat.getSortKey(notification)).setTimeoutAfter(androidx.core.app.NotificationCompat.getTimeoutAfter(notification)).setShortcutId(androidx.core.app.NotificationCompat.getShortcutId(notification)).setProgress(bundle.getInt(androidx.core.app.NotificationCompat.EXTRA_PROGRESS_MAX), bundle.getInt(androidx.core.app.NotificationCompat.EXTRA_PROGRESS), bundle.getBoolean(androidx.core.app.NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(androidx.core.app.NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel).addExtras(getExtrasWithoutDuplicateData(notification, extractStyleFromNotification));
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                smallIcon = notification.getSmallIcon();
                this.mSmallIcon = smallIcon;
            }
            android.app.Notification.Action[] actionArr = notification.actions;
            if (actionArr != null && actionArr.length != 0) {
                for (android.app.Notification.Action action : actionArr) {
                    addAction(androidx.core.app.NotificationCompat.Action.Builder.fromAndroidAction(action).build());
                }
            }
            java.util.List<androidx.core.app.NotificationCompat.Action> invisibleActions = androidx.core.app.NotificationCompat.getInvisibleActions(notification);
            if (!invisibleActions.isEmpty()) {
                java.util.Iterator<androidx.core.app.NotificationCompat.Action> it = invisibleActions.iterator();
                while (it.hasNext()) {
                    addInvisibleAction(it.next());
                }
            }
            java.lang.String[] stringArray = notification.extras.getStringArray(androidx.core.app.NotificationCompat.EXTRA_PEOPLE);
            if (stringArray != null && stringArray.length != 0) {
                for (java.lang.String str : stringArray) {
                    addPerson(str);
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(androidx.core.app.NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !parcelableArrayList.isEmpty()) {
                java.util.Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    addPerson(androidx.core.app.Person.fromAndroidPerson((android.app.Person) it2.next()));
                }
            }
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 24 && bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
                setChronometerCountDown(bundle.getBoolean(androidx.core.app.NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
            }
            if (i < 26 || !bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_COLORIZED)) {
                return;
            }
            setColorized(bundle.getBoolean(androidx.core.app.NotificationCompat.EXTRA_COLORIZED));
        }

        public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            this.mActions = new java.util.ArrayList<>();
            this.mPersonList = new java.util.ArrayList<>();
            this.mInvisibleActions = new java.util.ArrayList<>();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            android.app.Notification notification = new android.app.Notification();
            this.mNotification = notification;
            this.mContext = context;
            this.mChannelId = str;
            notification.when = java.lang.System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new java.util.ArrayList<>();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RequiresApi(19)
        private static android.os.Bundle getExtrasWithoutDuplicateData(@androidx.annotation.NonNull android.app.Notification notification, @androidx.annotation.Nullable androidx.core.app.NotificationCompat.Style style) {
            if (notification.extras == null) {
                return null;
            }
            android.os.Bundle bundle = new android.os.Bundle(notification.extras);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_TITLE);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_TEXT);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_INFO_TEXT);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_SUB_TEXT);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_CHANNEL_ID);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_SHOW_WHEN);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_PROGRESS);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_PROGRESS_MAX);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_COLORIZED);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_PEOPLE_LIST);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_PEOPLE);
            bundle.remove(androidx.core.app.NotificationCompatExtras.EXTRA_SORT_KEY);
            bundle.remove(androidx.core.app.NotificationCompatExtras.EXTRA_GROUP_KEY);
            bundle.remove(androidx.core.app.NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            bundle.remove(androidx.core.app.NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            bundle.remove(androidx.core.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            android.os.Bundle bundle2 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle2 != null) {
                android.os.Bundle bundle3 = new android.os.Bundle(bundle2);
                bundle3.remove("invisible_actions");
                bundle.putBundle("android.car.EXTENSIONS", bundle3);
            }
            if (style != null) {
                style.clearCompatExtraKeys(bundle);
            }
            return bundle;
        }

        @androidx.annotation.Nullable
        public static java.lang.CharSequence limitCharSequenceLength(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        @androidx.annotation.Nullable
        private android.graphics.Bitmap reduceLargeIconSize(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
            if (bitmap == null || android.os.Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            android.content.res.Resources resources = this.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(androidx.core.R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(androidx.core.R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = java.lang.Math.min(dimensionPixelSize / java.lang.Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / java.lang.Math.max(1, bitmap.getHeight()));
            return android.graphics.Bitmap.createScaledBitmap(bitmap, (int) java.lang.Math.ceil(bitmap.getWidth() * min), (int) java.lang.Math.ceil(bitmap.getHeight() * min), true);
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                android.app.Notification notification = this.mNotification;
                notification.flags = i | notification.flags;
            } else {
                android.app.Notification notification2 = this.mNotification;
                notification2.flags = (~i) & notification2.flags;
            }
        }

        private boolean useExistingRemoteView() {
            androidx.core.app.NotificationCompat.Style style = this.mStyle;
            return style == null || !style.displayCustomViewInline();
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder addAction(int i, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
            this.mActions.add(new androidx.core.app.NotificationCompat.Action(i, charSequence, pendingIntent));
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder addAction(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.Action action) {
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder addExtras(@androidx.annotation.Nullable android.os.Bundle bundle) {
            if (bundle != null) {
                android.os.Bundle bundle2 = this.mExtras;
                if (bundle2 == null) {
                    this.mExtras = new android.os.Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RequiresApi(21)
        public androidx.core.app.NotificationCompat.Builder addInvisibleAction(int i, @androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
            this.mInvisibleActions.add(new androidx.core.app.NotificationCompat.Action(i, charSequence, pendingIntent));
            return this;
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RequiresApi(21)
        public androidx.core.app.NotificationCompat.Builder addInvisibleAction(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.Action action) {
            if (action != null) {
                this.mInvisibleActions.add(action);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder addPerson(@androidx.annotation.Nullable androidx.core.app.Person person) {
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.Builder addPerson(@androidx.annotation.Nullable java.lang.String str) {
            if (str != null && !str.isEmpty()) {
                this.mPeople.add(str);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public android.app.Notification build() {
            return new androidx.core.app.NotificationCompatBuilder(this).build();
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            android.os.Bundle bundle = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                android.os.Bundle bundle2 = new android.os.Bundle(bundle);
                bundle2.remove("invisible_actions");
                this.mExtras.putBundle("android.car.EXTENSIONS", bundle2);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        @androidx.annotation.Nullable
        @android.annotation.SuppressLint({"BuilderSetStyle"})
        public android.widget.RemoteViews createBigContentView() {
            android.app.Notification.Builder recoverBuilder;
            android.widget.RemoteViews createBigContentView;
            android.widget.RemoteViews makeBigContentView;
            int i = android.os.Build.VERSION.SDK_INT;
            if (this.mBigContentView != null && useExistingRemoteView()) {
                return this.mBigContentView;
            }
            androidx.core.app.NotificationCompatBuilder notificationCompatBuilder = new androidx.core.app.NotificationCompatBuilder(this);
            androidx.core.app.NotificationCompat.Style style = this.mStyle;
            if (style != null && (makeBigContentView = style.makeBigContentView(notificationCompatBuilder)) != null) {
                return makeBigContentView;
            }
            android.app.Notification build = notificationCompatBuilder.build();
            if (i < 24) {
                return build.bigContentView;
            }
            recoverBuilder = android.app.Notification.Builder.recoverBuilder(this.mContext, build);
            createBigContentView = recoverBuilder.createBigContentView();
            return createBigContentView;
        }

        @androidx.annotation.Nullable
        @android.annotation.SuppressLint({"BuilderSetStyle"})
        public android.widget.RemoteViews createContentView() {
            android.app.Notification.Builder recoverBuilder;
            android.widget.RemoteViews createContentView;
            android.widget.RemoteViews makeContentView;
            if (this.mContentView != null && useExistingRemoteView()) {
                return this.mContentView;
            }
            androidx.core.app.NotificationCompatBuilder notificationCompatBuilder = new androidx.core.app.NotificationCompatBuilder(this);
            androidx.core.app.NotificationCompat.Style style = this.mStyle;
            if (style != null && (makeContentView = style.makeContentView(notificationCompatBuilder)) != null) {
                return makeContentView;
            }
            android.app.Notification build = notificationCompatBuilder.build();
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return build.contentView;
            }
            recoverBuilder = android.app.Notification.Builder.recoverBuilder(this.mContext, build);
            createContentView = recoverBuilder.createContentView();
            return createContentView;
        }

        @androidx.annotation.Nullable
        @android.annotation.SuppressLint({"BuilderSetStyle"})
        public android.widget.RemoteViews createHeadsUpContentView() {
            android.app.Notification.Builder recoverBuilder;
            android.widget.RemoteViews createHeadsUpContentView;
            android.widget.RemoteViews makeHeadsUpContentView;
            int i = android.os.Build.VERSION.SDK_INT;
            if (this.mHeadsUpContentView != null && useExistingRemoteView()) {
                return this.mHeadsUpContentView;
            }
            androidx.core.app.NotificationCompatBuilder notificationCompatBuilder = new androidx.core.app.NotificationCompatBuilder(this);
            androidx.core.app.NotificationCompat.Style style = this.mStyle;
            if (style != null && (makeHeadsUpContentView = style.makeHeadsUpContentView(notificationCompatBuilder)) != null) {
                return makeHeadsUpContentView;
            }
            android.app.Notification build = notificationCompatBuilder.build();
            if (i < 24) {
                return build.headsUpContentView;
            }
            recoverBuilder = android.app.Notification.Builder.recoverBuilder(this.mContext, build);
            createHeadsUpContentView = recoverBuilder.createHeadsUpContentView();
            return createHeadsUpContentView;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder extend(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Extender extender) {
            extender.extend(this);
            return this;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public androidx.core.app.NotificationCompat.BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        @androidx.annotation.ColorInt
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.mColor;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews getContentView() {
            return this.mContentView;
        }

        @androidx.annotation.NonNull
        public android.os.Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new android.os.Bundle();
            }
            return this.mExtras;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public android.app.Notification getNotification() {
            return build();
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.mPriority;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.mShowWhen) {
                return this.mNotification.when;
            }
            return 0L;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setAllowSystemGeneratedContextualActions(boolean z) {
            this.mAllowSystemGeneratedContextualActions = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setAutoCancel(boolean z) {
            setFlag(16, z);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setBadgeIconType(int i) {
            this.mBadgeIcon = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setBubbleMetadata(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.BubbleMetadata bubbleMetadata) {
            this.mBubbleMetadata = bubbleMetadata;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setCategory(@androidx.annotation.Nullable java.lang.String str) {
            this.mCategory = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setChannelId(@androidx.annotation.NonNull java.lang.String str) {
            this.mChannelId = str;
            return this;
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RequiresApi(24)
        public androidx.core.app.NotificationCompat.Builder setChronometerCountDown(boolean z) {
            this.mChronometerCountDown = z;
            getExtras().putBoolean(androidx.core.app.NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setColor(@androidx.annotation.ColorInt int i) {
            this.mColor = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setColorized(boolean z) {
            this.mColorized = z;
            this.mColorizedSet = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setContent(@androidx.annotation.Nullable android.widget.RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setContentInfo(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setContentIntent(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setContentText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setContentTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setCustomBigContentView(@androidx.annotation.Nullable android.widget.RemoteViews remoteViews) {
            this.mBigContentView = remoteViews;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setCustomContentView(@androidx.annotation.Nullable android.widget.RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setCustomHeadsUpContentView(@androidx.annotation.Nullable android.widget.RemoteViews remoteViews) {
            this.mHeadsUpContentView = remoteViews;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setDefaults(int i) {
            android.app.Notification notification = this.mNotification;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setDeleteIntent(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setFullScreenIntent(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent, boolean z) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setGroup(@androidx.annotation.Nullable java.lang.String str) {
            this.mGroupKey = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setGroupAlertBehavior(int i) {
            this.mGroupAlertBehavior = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setGroupSummary(boolean z) {
            this.mGroupSummary = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setLargeIcon(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
            this.mLargeIcon = reduceLargeIconSize(bitmap);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setLights(@androidx.annotation.ColorInt int i, int i2, int i3) {
            android.app.Notification notification = this.mNotification;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            notification.flags = ((i2 == 0 || i3 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setLocalOnly(boolean z) {
            this.mLocalOnly = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setLocusId(@androidx.annotation.Nullable androidx.core.content.LocusIdCompat locusIdCompat) {
            this.mLocusId = locusIdCompat;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setOngoing(boolean z) {
            setFlag(2, z);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setOnlyAlertOnce(boolean z) {
            setFlag(8, z);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setPriority(int i) {
            this.mPriority = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setProgress(int i, int i2, boolean z) {
            this.mProgressMax = i;
            this.mProgress = i2;
            this.mProgressIndeterminate = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setPublicVersion(@androidx.annotation.Nullable android.app.Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setRemoteInputHistory(@androidx.annotation.Nullable java.lang.CharSequence[] charSequenceArr) {
            this.mRemoteInputHistory = charSequenceArr;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSettingsText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mSettingsText = limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setShortcutId(@androidx.annotation.Nullable java.lang.String str) {
            this.mShortcutId = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setShortcutInfo(@androidx.annotation.Nullable androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat) {
            if (shortcutInfoCompat == null) {
                return this;
            }
            this.mShortcutId = shortcutInfoCompat.getId();
            if (this.mLocusId == null) {
                if (shortcutInfoCompat.getLocusId() != null) {
                    this.mLocusId = shortcutInfoCompat.getLocusId();
                } else if (shortcutInfoCompat.getId() != null) {
                    this.mLocusId = new androidx.core.content.LocusIdCompat(shortcutInfoCompat.getId());
                }
            }
            if (this.mContentTitle == null) {
                setContentTitle(shortcutInfoCompat.getShortLabel());
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setShowWhen(boolean z) {
            this.mShowWhen = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSilent(boolean z) {
            this.mSilent = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSmallIcon(int i) {
            this.mNotification.icon = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSmallIcon(int i, int i2) {
            android.app.Notification notification = this.mNotification;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RequiresApi(23)
        public androidx.core.app.NotificationCompat.Builder setSmallIcon(@androidx.annotation.NonNull androidx.core.graphics.drawable.IconCompat iconCompat) {
            this.mSmallIcon = iconCompat.toIcon(this.mContext);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSortKey(@androidx.annotation.Nullable java.lang.String str) {
            this.mSortKey = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSound(@androidx.annotation.Nullable android.net.Uri uri) {
            android.app.Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = new android.media.AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSound(@androidx.annotation.Nullable android.net.Uri uri, int i) {
            android.app.Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = i;
            notification.audioAttributes = new android.media.AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i).build();
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setStyle(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setSubText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setTicker(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.Builder setTicker(@androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.widget.RemoteViews remoteViews) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setTimeoutAfter(long j) {
            this.mTimeout = j;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setVibrate(@androidx.annotation.Nullable long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setVisibility(int i) {
            this.mVisibility = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }
    }

    public static final class CarExtender implements androidx.core.app.NotificationCompat.Extender {

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final java.lang.String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final java.lang.String EXTRA_COLOR = "app_color";
        private static final java.lang.String EXTRA_CONVERSATION = "car_conversation";

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final java.lang.String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final java.lang.String EXTRA_LARGE_ICON = "large_icon";
        private static final java.lang.String KEY_AUTHOR = "author";
        private static final java.lang.String KEY_MESSAGES = "messages";
        private static final java.lang.String KEY_ON_READ = "on_read";
        private static final java.lang.String KEY_ON_REPLY = "on_reply";
        private static final java.lang.String KEY_PARTICIPANTS = "participants";
        private static final java.lang.String KEY_REMOTE_INPUT = "remote_input";
        private static final java.lang.String KEY_TEXT = "text";
        private static final java.lang.String KEY_TIMESTAMP = "timestamp";
        private int mColor;
        private android.graphics.Bitmap mLargeIcon;
        private androidx.core.app.NotificationCompat.CarExtender.UnreadConversation mUnreadConversation;

        @java.lang.Deprecated
        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final java.lang.String[] mMessages;
            private final java.lang.String[] mParticipants;
            private final android.app.PendingIntent mReadPendingIntent;
            private final androidx.core.app.RemoteInput mRemoteInput;
            private final android.app.PendingIntent mReplyPendingIntent;

            public static class Builder {
                private long mLatestTimestamp;
                private final java.util.List<java.lang.String> mMessages = new java.util.ArrayList();
                private final java.lang.String mParticipant;
                private android.app.PendingIntent mReadPendingIntent;
                private androidx.core.app.RemoteInput mRemoteInput;
                private android.app.PendingIntent mReplyPendingIntent;

                public Builder(@androidx.annotation.NonNull java.lang.String str) {
                    this.mParticipant = str;
                }

                @androidx.annotation.NonNull
                public androidx.core.app.NotificationCompat.CarExtender.UnreadConversation.Builder addMessage(@androidx.annotation.Nullable java.lang.String str) {
                    if (str != null) {
                        this.mMessages.add(str);
                    }
                    return this;
                }

                @androidx.annotation.NonNull
                public androidx.core.app.NotificationCompat.CarExtender.UnreadConversation build() {
                    java.util.List<java.lang.String> list = this.mMessages;
                    return new androidx.core.app.NotificationCompat.CarExtender.UnreadConversation((java.lang.String[]) list.toArray(new java.lang.String[list.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new java.lang.String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                @androidx.annotation.NonNull
                public androidx.core.app.NotificationCompat.CarExtender.UnreadConversation.Builder setLatestTimestamp(long j) {
                    this.mLatestTimestamp = j;
                    return this;
                }

                @androidx.annotation.NonNull
                public androidx.core.app.NotificationCompat.CarExtender.UnreadConversation.Builder setReadPendingIntent(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                @androidx.annotation.NonNull
                public androidx.core.app.NotificationCompat.CarExtender.UnreadConversation.Builder setReplyAction(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable androidx.core.app.RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }
            }

            public UnreadConversation(@androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable androidx.core.app.RemoteInput remoteInput, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent2, @androidx.annotation.Nullable java.lang.String[] strArr2, long j) {
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = strArr2;
                this.mLatestTimestamp = j;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            @androidx.annotation.Nullable
            public java.lang.String[] getMessages() {
                return this.mMessages;
            }

            @androidx.annotation.Nullable
            public java.lang.String getParticipant() {
                java.lang.String[] strArr = this.mParticipants;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @androidx.annotation.Nullable
            public java.lang.String[] getParticipants() {
                return this.mParticipants;
            }

            @androidx.annotation.Nullable
            public android.app.PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            @androidx.annotation.Nullable
            public androidx.core.app.RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            @androidx.annotation.Nullable
            public android.app.PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
            this.mColor = 0;
        }

        public CarExtender(@androidx.annotation.NonNull android.app.Notification notification) {
            this.mColor = 0;
            android.os.Bundle bundle = androidx.core.app.NotificationCompat.getExtras(notification) == null ? null : androidx.core.app.NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
            if (bundle != null) {
                this.mLargeIcon = (android.graphics.Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                this.mColor = bundle.getInt(EXTRA_COLOR, 0);
                this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION));
            }
        }

        @androidx.annotation.RequiresApi(21)
        private static android.os.Bundle getBundleForUnreadConversation(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.CarExtender.UnreadConversation unreadConversation) {
            android.os.Bundle bundle = new android.os.Bundle();
            java.lang.String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
            int length = unreadConversation.getMessages().length;
            android.os.Parcelable[] parcelableArr = new android.os.Parcelable[length];
            for (int i = 0; i < length; i++) {
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("text", unreadConversation.getMessages()[i]);
                bundle2.putString(KEY_AUTHOR, str);
                parcelableArr[i] = bundle2;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            androidx.core.app.RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                bundle.putParcelable(KEY_REMOTE_INPUT, new android.app.RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
            }
            bundle.putParcelable(KEY_ON_REPLY, unreadConversation.getReplyPendingIntent());
            bundle.putParcelable(KEY_ON_READ, unreadConversation.getReadPendingIntent());
            bundle.putStringArray(KEY_PARTICIPANTS, unreadConversation.getParticipants());
            bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
            return bundle;
        }

        @androidx.annotation.RequiresApi(21)
        private static androidx.core.app.NotificationCompat.CarExtender.UnreadConversation getUnreadConversationFromBundle(@androidx.annotation.Nullable android.os.Bundle bundle) {
            java.lang.String[] strArr;
            int i;
            int editChoicesBeforeSending;
            boolean z;
            androidx.core.app.RemoteInput remoteInput = null;
            if (bundle == null) {
                return null;
            }
            android.os.Parcelable[] parcelableArray = bundle.getParcelableArray("messages");
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                java.lang.String[] strArr2 = new java.lang.String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    android.os.Parcelable parcelable = parcelableArray[i2];
                    if (parcelable instanceof android.os.Bundle) {
                        java.lang.String string = ((android.os.Bundle) parcelable).getString("text");
                        strArr2[i2] = string;
                        if (string != null) {
                        }
                    }
                    z = false;
                    break;
                }
                z = true;
                if (!z) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            android.app.PendingIntent pendingIntent = (android.app.PendingIntent) bundle.getParcelable(KEY_ON_READ);
            android.app.PendingIntent pendingIntent2 = (android.app.PendingIntent) bundle.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput remoteInput2 = (android.app.RemoteInput) bundle.getParcelable(KEY_REMOTE_INPUT);
            java.lang.String[] stringArray = bundle.getStringArray(KEY_PARTICIPANTS);
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            if (remoteInput2 != null) {
                java.lang.String resultKey = remoteInput2.getResultKey();
                java.lang.CharSequence label = remoteInput2.getLabel();
                java.lang.CharSequence[] choices = remoteInput2.getChoices();
                boolean allowFreeFormInput = remoteInput2.getAllowFreeFormInput();
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    editChoicesBeforeSending = remoteInput2.getEditChoicesBeforeSending();
                    i = editChoicesBeforeSending;
                } else {
                    i = 0;
                }
                remoteInput = new androidx.core.app.RemoteInput(resultKey, label, choices, allowFreeFormInput, i, remoteInput2.getExtras(), null);
            }
            return new androidx.core.app.NotificationCompat.CarExtender.UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder extend(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Builder builder) {
            android.os.Bundle bundle = new android.os.Bundle();
            android.graphics.Bitmap bitmap = this.mLargeIcon;
            if (bitmap != null) {
                bundle.putParcelable(EXTRA_LARGE_ICON, bitmap);
            }
            int i = this.mColor;
            if (i != 0) {
                bundle.putInt(EXTRA_COLOR, i);
            }
            androidx.core.app.NotificationCompat.CarExtender.UnreadConversation unreadConversation = this.mUnreadConversation;
            if (unreadConversation != null) {
                bundle.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(unreadConversation));
            }
            builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
            return builder;
        }

        @androidx.annotation.ColorInt
        public int getColor() {
            return this.mColor;
        }

        @androidx.annotation.Nullable
        public android.graphics.Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @androidx.annotation.Nullable
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.CarExtender.UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.CarExtender setColor(@androidx.annotation.ColorInt int i) {
            this.mColor = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.CarExtender setLargeIcon(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.CarExtender setUnreadConversation(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.CarExtender.UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends androidx.core.app.NotificationCompat.Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final java.lang.String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        private android.widget.RemoteViews createRemoteViews(android.widget.RemoteViews remoteViews, boolean z) {
            int min;
            boolean z2 = true;
            android.widget.RemoteViews applyStandardTemplate = applyStandardTemplate(true, androidx.core.R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(androidx.core.R.id.actions);
            java.util.List<androidx.core.app.NotificationCompat.Action> nonContextualActions = getNonContextualActions(this.mBuilder.mActions);
            if (!z || nonContextualActions == null || (min = java.lang.Math.min(nonContextualActions.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(androidx.core.R.id.actions, generateActionButton(nonContextualActions.get(i)));
                }
            }
            int i2 = z2 ? 0 : 8;
            applyStandardTemplate.setViewVisibility(androidx.core.R.id.actions, i2);
            applyStandardTemplate.setViewVisibility(androidx.core.R.id.action_divider, i2);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        private android.widget.RemoteViews generateActionButton(androidx.core.app.NotificationCompat.Action action) {
            boolean z = action.actionIntent == null;
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.mBuilder.mContext.getPackageName(), z ? androidx.core.R.layout.notification_action_tombstone : androidx.core.R.layout.notification_action);
            androidx.core.graphics.drawable.IconCompat iconCompat = action.getIconCompat();
            if (iconCompat != null) {
                remoteViews.setImageViewBitmap(androidx.core.R.id.action_image, createColoredBitmap(iconCompat, this.mBuilder.mContext.getResources().getColor(androidx.core.R.color.notification_action_color_filter)));
            }
            remoteViews.setTextViewText(androidx.core.R.id.action_text, action.title);
            if (!z) {
                remoteViews.setOnClickPendingIntent(androidx.core.R.id.action_container, action.actionIntent);
            }
            remoteViews.setContentDescription(androidx.core.R.id.action_container, action.title);
            return remoteViews;
        }

        private static java.util.List<androidx.core.app.NotificationCompat.Action> getNonContextualActions(java.util.List<androidx.core.app.NotificationCompat.Action> list) {
            if (list == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (androidx.core.app.NotificationCompat.Action action : list) {
                if (!action.isContextual()) {
                    arrayList.add(action);
                }
            }
            return arrayList;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new android.app.Notification.DecoratedCustomViewStyle());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.lang.String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews makeBigContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            android.widget.RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return createRemoteViews(bigContentView, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews makeContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return createRemoteViews(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews makeHeadsUpContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            android.widget.RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            android.widget.RemoteViews contentView = headsUpContentView != null ? headsUpContentView : this.mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            return createRemoteViews(contentView, true);
        }
    }

    public interface Extender {
        @androidx.annotation.NonNull
        androidx.core.app.NotificationCompat.Builder extend(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Builder builder);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends androidx.core.app.NotificationCompat.Style {
        private static final java.lang.String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private java.util.ArrayList<java.lang.CharSequence> mTexts = new java.util.ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.InboxStyle addLine(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            if (charSequence != null) {
                this.mTexts.add(androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence));
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            android.app.Notification.InboxStyle bigContentTitle = new android.app.Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet) {
                bigContentTitle.setSummaryText(this.mSummaryText);
            }
            java.util.Iterator<java.lang.CharSequence> it = this.mTexts.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine(it.next());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.lang.String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mTexts.clear();
            if (bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_TEXT_LINES)) {
                java.util.Collections.addAll(this.mTexts, bundle.getCharSequenceArray(androidx.core.app.NotificationCompat.EXTRA_TEXT_LINES));
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.InboxStyle setBigContentTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mBigContentTitle = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.InboxStyle setSummaryText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mSummaryText = androidx.core.app.NotificationCompat.Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle extends androidx.core.app.NotificationCompat.Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final java.lang.String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";

        @androidx.annotation.Nullable
        private java.lang.CharSequence mConversationTitle;

        @androidx.annotation.Nullable
        private java.lang.Boolean mIsGroupConversation;
        private androidx.core.app.Person mUser;
        private final java.util.List<androidx.core.app.NotificationCompat.MessagingStyle.Message> mMessages = new java.util.ArrayList();
        private final java.util.List<androidx.core.app.NotificationCompat.MessagingStyle.Message> mHistoricMessages = new java.util.ArrayList();

        public static final class Message {
            static final java.lang.String KEY_DATA_MIME_TYPE = "type";
            static final java.lang.String KEY_DATA_URI = "uri";
            static final java.lang.String KEY_EXTRAS_BUNDLE = "extras";
            static final java.lang.String KEY_NOTIFICATION_PERSON = "sender_person";
            static final java.lang.String KEY_PERSON = "person";
            static final java.lang.String KEY_SENDER = "sender";
            static final java.lang.String KEY_TEXT = "text";
            static final java.lang.String KEY_TIMESTAMP = "time";

            @androidx.annotation.Nullable
            private java.lang.String mDataMimeType;

            @androidx.annotation.Nullable
            private android.net.Uri mDataUri;
            private android.os.Bundle mExtras;

            @androidx.annotation.Nullable
            private final androidx.core.app.Person mPerson;
            private final java.lang.CharSequence mText;
            private final long mTimestamp;

            public Message(@androidx.annotation.Nullable java.lang.CharSequence charSequence, long j, @androidx.annotation.Nullable androidx.core.app.Person person) {
                this.mExtras = new android.os.Bundle();
                this.mText = charSequence;
                this.mTimestamp = j;
                this.mPerson = person;
            }

            @java.lang.Deprecated
            public Message(@androidx.annotation.Nullable java.lang.CharSequence charSequence, long j, @androidx.annotation.Nullable java.lang.CharSequence charSequence2) {
                this(charSequence, j, new androidx.core.app.Person.Builder().setName(charSequence2).build());
            }

            @androidx.annotation.NonNull
            public static android.os.Bundle[] getBundleArrayForMessages(@androidx.annotation.NonNull java.util.List<androidx.core.app.NotificationCompat.MessagingStyle.Message> list) {
                android.os.Bundle[] bundleArr = new android.os.Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = list.get(i).toBundle();
                }
                return bundleArr;
            }

            @androidx.annotation.Nullable
            public static androidx.core.app.NotificationCompat.MessagingStyle.Message getMessageFromBundle(@androidx.annotation.NonNull android.os.Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        androidx.core.app.NotificationCompat.MessagingStyle.Message message = new androidx.core.app.NotificationCompat.MessagingStyle.Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.containsKey(KEY_PERSON) ? androidx.core.app.Person.fromBundle(bundle.getBundle(KEY_PERSON)) : (!bundle.containsKey(KEY_NOTIFICATION_PERSON) || android.os.Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new androidx.core.app.Person.Builder().setName(bundle.getCharSequence("sender")).build() : null : androidx.core.app.Person.fromAndroidPerson((android.app.Person) bundle.getParcelable(KEY_NOTIFICATION_PERSON)));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            message.setData(bundle.getString("type"), (android.net.Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey(KEY_EXTRAS_BUNDLE)) {
                            message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                        }
                        return message;
                    }
                } catch (java.lang.ClassCastException unused) {
                }
                return null;
            }

            @androidx.annotation.NonNull
            public static java.util.List<androidx.core.app.NotificationCompat.MessagingStyle.Message> getMessagesFromBundleArray(@androidx.annotation.NonNull android.os.Parcelable[] parcelableArr) {
                androidx.core.app.NotificationCompat.MessagingStyle.Message messageFromBundle;
                java.util.ArrayList arrayList = new java.util.ArrayList(parcelableArr.length);
                for (android.os.Parcelable parcelable : parcelableArr) {
                    if ((parcelable instanceof android.os.Bundle) && (messageFromBundle = getMessageFromBundle((android.os.Bundle) parcelable)) != null) {
                        arrayList.add(messageFromBundle);
                    }
                }
                return arrayList;
            }

            @androidx.annotation.NonNull
            private android.os.Bundle toBundle() {
                android.os.Bundle bundle = new android.os.Bundle();
                java.lang.CharSequence charSequence = this.mText;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.mTimestamp);
                androidx.core.app.Person person = this.mPerson;
                if (person != null) {
                    bundle.putCharSequence("sender", person.getName());
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(KEY_NOTIFICATION_PERSON, this.mPerson.toAndroidPerson());
                    } else {
                        bundle.putBundle(KEY_PERSON, this.mPerson.toBundle());
                    }
                }
                java.lang.String str = this.mDataMimeType;
                if (str != null) {
                    bundle.putString("type", str);
                }
                android.net.Uri uri = this.mDataUri;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                android.os.Bundle bundle2 = this.mExtras;
                if (bundle2 != null) {
                    bundle.putBundle(KEY_EXTRAS_BUNDLE, bundle2);
                }
                return bundle;
            }

            @androidx.annotation.Nullable
            public java.lang.String getDataMimeType() {
                return this.mDataMimeType;
            }

            @androidx.annotation.Nullable
            public android.net.Uri getDataUri() {
                return this.mDataUri;
            }

            @androidx.annotation.NonNull
            public android.os.Bundle getExtras() {
                return this.mExtras;
            }

            @androidx.annotation.Nullable
            public androidx.core.app.Person getPerson() {
                return this.mPerson;
            }

            @androidx.annotation.Nullable
            @java.lang.Deprecated
            public java.lang.CharSequence getSender() {
                androidx.core.app.Person person = this.mPerson;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            @androidx.annotation.Nullable
            public java.lang.CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            @androidx.annotation.NonNull
            public androidx.core.app.NotificationCompat.MessagingStyle.Message setData(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable android.net.Uri uri) {
                this.mDataMimeType = str;
                this.mDataUri = uri;
                return this;
            }

            @androidx.annotation.NonNull
            @androidx.annotation.RequiresApi(24)
            @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public android.app.Notification.MessagingStyle.Message toAndroidMessage() {
                android.app.Notification.MessagingStyle.Message message;
                androidx.core.app.Person person = getPerson();
                if (android.os.Build.VERSION.SDK_INT >= 28) {
                    message = new android.app.Notification.MessagingStyle.Message(getText(), getTimestamp(), person != null ? person.toAndroidPerson() : null);
                } else {
                    message = new android.app.Notification.MessagingStyle.Message(getText(), getTimestamp(), person != null ? person.getName() : null);
                }
                if (getDataMimeType() != null) {
                    message.setData(getDataMimeType(), getDataUri());
                }
                return message;
            }
        }

        public MessagingStyle() {
        }

        public MessagingStyle(@androidx.annotation.NonNull androidx.core.app.Person person) {
            if (android.text.TextUtils.isEmpty(person.getName())) {
                throw new java.lang.IllegalArgumentException("User's name must not be empty.");
            }
            this.mUser = person;
        }

        @java.lang.Deprecated
        public MessagingStyle(@androidx.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mUser = new androidx.core.app.Person.Builder().setName(charSequence).build();
        }

        @androidx.annotation.Nullable
        public static androidx.core.app.NotificationCompat.MessagingStyle extractMessagingStyleFromNotification(@androidx.annotation.NonNull android.app.Notification notification) {
            androidx.core.app.NotificationCompat.Style extractStyleFromNotification = androidx.core.app.NotificationCompat.Style.extractStyleFromNotification(notification);
            if (extractStyleFromNotification instanceof androidx.core.app.NotificationCompat.MessagingStyle) {
                return (androidx.core.app.NotificationCompat.MessagingStyle) extractStyleFromNotification;
            }
            return null;
        }

        @androidx.annotation.Nullable
        private androidx.core.app.NotificationCompat.MessagingStyle.Message findLatestIncomingMessage() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                androidx.core.app.NotificationCompat.MessagingStyle.Message message = this.mMessages.get(size);
                if (message.getPerson() != null && !android.text.TextUtils.isEmpty(message.getPerson().getName())) {
                    return message;
                }
            }
            if (this.mMessages.isEmpty()) {
                return null;
            }
            return this.mMessages.get(r0.size() - 1);
        }

        private boolean hasMessagesWithoutSender() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                androidx.core.app.NotificationCompat.MessagingStyle.Message message = this.mMessages.get(size);
                if (message.getPerson() != null && message.getPerson().getName() == null) {
                    return true;
                }
            }
            return false;
        }

        @androidx.annotation.NonNull
        private android.text.style.TextAppearanceSpan makeFontColorSpan(int i) {
            return new android.text.style.TextAppearanceSpan(null, 0, 0, android.content.res.ColorStateList.valueOf(i), null);
        }

        private java.lang.CharSequence makeMessageLine(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.MessagingStyle.Message message) {
            androidx.core.text.BidiFormatter bidiFormatter = androidx.core.text.BidiFormatter.getInstance();
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            java.lang.CharSequence name = message.getPerson() == null ? "" : message.getPerson().getName();
            boolean isEmpty = android.text.TextUtils.isEmpty(name);
            int i = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
            if (isEmpty) {
                name = this.mUser.getName();
                if (this.mBuilder.getColor() != 0) {
                    i = this.mBuilder.getColor();
                }
            }
            java.lang.CharSequence unicodeWrap = bidiFormatter.unicodeWrap(name);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((java.lang.CharSequence) "  ").append(bidiFormatter.unicodeWrap(message.getText() != null ? message.getText() : ""));
            return spannableStringBuilder;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(androidx.core.app.NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            bundle.putBundle(androidx.core.app.NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            bundle.putCharSequence(androidx.core.app.NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                bundle.putCharSequence(androidx.core.app.NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
            }
            if (!this.mMessages.isEmpty()) {
                bundle.putParcelableArray(androidx.core.app.NotificationCompat.EXTRA_MESSAGES, androidx.core.app.NotificationCompat.MessagingStyle.Message.getBundleArrayForMessages(this.mMessages));
            }
            if (!this.mHistoricMessages.isEmpty()) {
                bundle.putParcelableArray(androidx.core.app.NotificationCompat.EXTRA_HISTORIC_MESSAGES, androidx.core.app.NotificationCompat.MessagingStyle.Message.getBundleArrayForMessages(this.mHistoricMessages));
            }
            java.lang.Boolean bool = this.mIsGroupConversation;
            if (bool != null) {
                bundle.putBoolean(androidx.core.app.NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.MessagingStyle addHistoricMessage(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.MessagingStyle.Message message) {
            if (message != null) {
                this.mHistoricMessages.add(message);
                if (this.mHistoricMessages.size() > 25) {
                    this.mHistoricMessages.remove(0);
                }
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.MessagingStyle addMessage(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.MessagingStyle.Message message) {
            if (message != null) {
                this.mMessages.add(message);
                if (this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.MessagingStyle addMessage(@androidx.annotation.Nullable java.lang.CharSequence charSequence, long j, @androidx.annotation.Nullable androidx.core.app.Person person) {
            addMessage(new androidx.core.app.NotificationCompat.MessagingStyle.Message(charSequence, j, person));
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.MessagingStyle addMessage(@androidx.annotation.Nullable java.lang.CharSequence charSequence, long j, @androidx.annotation.Nullable java.lang.CharSequence charSequence2) {
            this.mMessages.add(new androidx.core.app.NotificationCompat.MessagingStyle.Message(charSequence, j, new androidx.core.app.Person.Builder().setName(charSequence2).build()));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            setGroupConversation(isGroupConversation());
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 24) {
                android.app.Notification.MessagingStyle messagingStyle = i >= 28 ? new android.app.Notification.MessagingStyle(this.mUser.toAndroidPerson()) : new android.app.Notification.MessagingStyle(this.mUser.getName());
                java.util.Iterator<androidx.core.app.NotificationCompat.MessagingStyle.Message> it = this.mMessages.iterator();
                while (it.hasNext()) {
                    messagingStyle.addMessage(it.next().toAndroidMessage());
                }
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    java.util.Iterator<androidx.core.app.NotificationCompat.MessagingStyle.Message> it2 = this.mHistoricMessages.iterator();
                    while (it2.hasNext()) {
                        messagingStyle.addHistoricMessage(it2.next().toAndroidMessage());
                    }
                }
                if (this.mIsGroupConversation.booleanValue() || android.os.Build.VERSION.SDK_INT >= 28) {
                    messagingStyle.setConversationTitle(this.mConversationTitle);
                }
                if (android.os.Build.VERSION.SDK_INT >= 28) {
                    messagingStyle.setGroupConversation(this.mIsGroupConversation.booleanValue());
                }
                messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            androidx.core.app.NotificationCompat.MessagingStyle.Message findLatestIncomingMessage = findLatestIncomingMessage();
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
            } else if (findLatestIncomingMessage != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                if (findLatestIncomingMessage.getPerson() != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(findLatestIncomingMessage.getPerson().getName());
                }
            }
            if (findLatestIncomingMessage != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentText(this.mConversationTitle != null ? makeMessageLine(findLatestIncomingMessage) : findLatestIncomingMessage.getText());
            }
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
            boolean z = this.mConversationTitle != null || hasMessagesWithoutSender();
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                androidx.core.app.NotificationCompat.MessagingStyle.Message message = this.mMessages.get(size);
                java.lang.CharSequence makeMessageLine = z ? makeMessageLine(message) : message.getText();
                if (size != this.mMessages.size() - 1) {
                    spannableStringBuilder.insert(0, (java.lang.CharSequence) "\n");
                }
                spannableStringBuilder.insert(0, makeMessageLine);
            }
            new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_CONVERSATION_TITLE);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_MESSAGES);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.lang.String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @androidx.annotation.Nullable
        public java.lang.CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        @androidx.annotation.NonNull
        public java.util.List<androidx.core.app.NotificationCompat.MessagingStyle.Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        @androidx.annotation.NonNull
        public java.util.List<androidx.core.app.NotificationCompat.MessagingStyle.Message> getMessages() {
            return this.mMessages;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.Person getUser() {
            return this.mUser;
        }

        @androidx.annotation.Nullable
        @java.lang.Deprecated
        public java.lang.CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            androidx.core.app.NotificationCompat.Builder builder = this.mBuilder;
            if (builder != null && builder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.mIsGroupConversation == null) {
                return this.mConversationTitle != null;
            }
            java.lang.Boolean bool = this.mIsGroupConversation;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mMessages.clear();
            if (bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                this.mUser = androidx.core.app.Person.fromBundle(bundle.getBundle(androidx.core.app.NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
            } else {
                this.mUser = new androidx.core.app.Person.Builder().setName(bundle.getString(androidx.core.app.NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            }
            java.lang.CharSequence charSequence = bundle.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = charSequence;
            if (charSequence == null) {
                this.mConversationTitle = bundle.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(androidx.core.app.NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.mMessages.addAll(androidx.core.app.NotificationCompat.MessagingStyle.Message.getMessagesFromBundleArray(parcelableArray));
            }
            android.os.Parcelable[] parcelableArray2 = bundle.getParcelableArray(androidx.core.app.NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (parcelableArray2 != null) {
                this.mHistoricMessages.addAll(androidx.core.app.NotificationCompat.MessagingStyle.Message.getMessagesFromBundleArray(parcelableArray2));
            }
            if (bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.mIsGroupConversation = java.lang.Boolean.valueOf(bundle.getBoolean(androidx.core.app.NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.MessagingStyle setConversationTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mConversationTitle = charSequence;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.MessagingStyle setGroupConversation(boolean z) {
            this.mIsGroupConversation = java.lang.Boolean.valueOf(z);
            return this;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NotificationVisibility {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StreamType {
    }

    public static abstract class Style {
        java.lang.CharSequence mBigContentTitle;

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected androidx.core.app.NotificationCompat.Builder mBuilder;
        java.lang.CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        private int calculateTopPadding() {
            android.content.res.Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(androidx.core.R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(androidx.core.R.dimen.notification_top_pad_large_text);
            float constrain = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return java.lang.Math.round(((1.0f - constrain) * dimensionPixelSize) + (constrain * dimensionPixelSize2));
        }

        private static float constrain(float f, float f2, float f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }

        @androidx.annotation.Nullable
        public static androidx.core.app.NotificationCompat.Style constructCompatStyleByName(@androidx.annotation.Nullable java.lang.String str) {
            if (str == null) {
                return null;
            }
            switch (str) {
                case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                    return new androidx.core.app.NotificationCompat.DecoratedCustomViewStyle();
                case "androidx.core.app.NotificationCompat$BigPictureStyle":
                    return new androidx.core.app.NotificationCompat.BigPictureStyle();
                case "androidx.core.app.NotificationCompat$InboxStyle":
                    return new androidx.core.app.NotificationCompat.InboxStyle();
                case "androidx.core.app.NotificationCompat$BigTextStyle":
                    return new androidx.core.app.NotificationCompat.BigTextStyle();
                case "androidx.core.app.NotificationCompat$MessagingStyle":
                    return new androidx.core.app.NotificationCompat.MessagingStyle();
                default:
                    return null;
            }
        }

        @androidx.annotation.Nullable
        private static androidx.core.app.NotificationCompat.Style constructCompatStyleByPlatformName(@androidx.annotation.Nullable java.lang.String str) {
            if (str == null) {
                return null;
            }
            int i = android.os.Build.VERSION.SDK_INT;
            if (str.equals(android.app.Notification.BigPictureStyle.class.getName())) {
                return new androidx.core.app.NotificationCompat.BigPictureStyle();
            }
            if (str.equals(android.app.Notification.BigTextStyle.class.getName())) {
                return new androidx.core.app.NotificationCompat.BigTextStyle();
            }
            if (str.equals(android.app.Notification.InboxStyle.class.getName())) {
                return new androidx.core.app.NotificationCompat.InboxStyle();
            }
            if (i >= 24) {
                if (str.equals(android.app.Notification.MessagingStyle.class.getName())) {
                    return new androidx.core.app.NotificationCompat.MessagingStyle();
                }
                if (str.equals(android.app.Notification.DecoratedCustomViewStyle.class.getName())) {
                    return new androidx.core.app.NotificationCompat.DecoratedCustomViewStyle();
                }
            }
            return null;
        }

        @androidx.annotation.Nullable
        public static androidx.core.app.NotificationCompat.Style constructCompatStyleForBundle(@androidx.annotation.NonNull android.os.Bundle bundle) {
            androidx.core.app.NotificationCompat.Style constructCompatStyleByName = constructCompatStyleByName(bundle.getString(androidx.core.app.NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            return constructCompatStyleByName != null ? constructCompatStyleByName : (bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_SELF_DISPLAY_NAME) || bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) ? new androidx.core.app.NotificationCompat.MessagingStyle() : bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_PICTURE) ? new androidx.core.app.NotificationCompat.BigPictureStyle() : bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_BIG_TEXT) ? new androidx.core.app.NotificationCompat.BigTextStyle() : bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_TEXT_LINES) ? new androidx.core.app.NotificationCompat.InboxStyle() : constructCompatStyleByPlatformName(bundle.getString(androidx.core.app.NotificationCompat.EXTRA_TEMPLATE));
        }

        @androidx.annotation.Nullable
        public static androidx.core.app.NotificationCompat.Style constructStyleForExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            androidx.core.app.NotificationCompat.Style constructCompatStyleForBundle = constructCompatStyleForBundle(bundle);
            if (constructCompatStyleForBundle == null) {
                return null;
            }
            try {
                constructCompatStyleForBundle.restoreFromCompatExtras(bundle);
                return constructCompatStyleForBundle;
            } catch (java.lang.ClassCastException unused) {
                return null;
            }
        }

        private android.graphics.Bitmap createColoredBitmap(int i, int i2, int i3) {
            return createColoredBitmap(androidx.core.graphics.drawable.IconCompat.createWithResource(this.mBuilder.mContext, i), i2, i3);
        }

        private android.graphics.Bitmap createColoredBitmap(@androidx.annotation.NonNull androidx.core.graphics.drawable.IconCompat iconCompat, int i, int i2) {
            android.graphics.drawable.Drawable loadDrawable = iconCompat.loadDrawable(this.mBuilder.mContext);
            int intrinsicWidth = i2 == 0 ? loadDrawable.getIntrinsicWidth() : i2;
            if (i2 == 0) {
                i2 = loadDrawable.getIntrinsicHeight();
            }
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, i2, android.graphics.Bitmap.Config.ARGB_8888);
            loadDrawable.setBounds(0, 0, intrinsicWidth, i2);
            if (i != 0) {
                loadDrawable.mutate().setColorFilter(new android.graphics.PorterDuffColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN));
            }
            loadDrawable.draw(new android.graphics.Canvas(createBitmap));
            return createBitmap;
        }

        private android.graphics.Bitmap createIconWithBackground(int i, int i2, int i3, int i4) {
            int i5 = androidx.core.R.drawable.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            android.graphics.Bitmap createColoredBitmap = createColoredBitmap(i5, i4, i2);
            android.graphics.Canvas canvas = new android.graphics.Canvas(createColoredBitmap);
            android.graphics.drawable.Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            mutate.setBounds(i6, i6, i7, i7);
            mutate.setColorFilter(new android.graphics.PorterDuffColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return createColoredBitmap;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static androidx.core.app.NotificationCompat.Style extractStyleFromNotification(@androidx.annotation.NonNull android.app.Notification notification) {
            android.os.Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            return constructStyleForExtras(extras);
        }

        private void hideNormalContent(android.widget.RemoteViews remoteViews) {
            remoteViews.setViewVisibility(androidx.core.R.id.title, 8);
            remoteViews.setViewVisibility(androidx.core.R.id.text2, 8);
            remoteViews.setViewVisibility(androidx.core.R.id.text, 8);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            if (this.mSummaryTextSet) {
                bundle.putCharSequence(androidx.core.app.NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
            }
            java.lang.CharSequence charSequence = this.mBigContentTitle;
            if (charSequence != null) {
                bundle.putCharSequence(androidx.core.app.NotificationCompat.EXTRA_TITLE_BIG, charSequence);
            }
            java.lang.String className = getClassName();
            if (className != null) {
                bundle.putString(androidx.core.app.NotificationCompat.EXTRA_COMPAT_TEMPLATE, className);
            }
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0183  */
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public android.widget.RemoteViews applyStandardTemplate(boolean z, int i, boolean z2) {
            boolean z3;
            boolean z4;
            java.lang.CharSequence charSequence;
            boolean z5;
            android.content.res.Resources resources = this.mBuilder.mContext.getResources();
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.mBuilder.mContext.getPackageName(), i);
            this.mBuilder.getPriority();
            int i2 = android.os.Build.VERSION.SDK_INT;
            androidx.core.app.NotificationCompat.Builder builder = this.mBuilder;
            if (builder.mLargeIcon != null) {
                int i3 = androidx.core.R.id.icon;
                remoteViews.setViewVisibility(i3, 0);
                remoteViews.setImageViewBitmap(i3, this.mBuilder.mLargeIcon);
                if (z && this.mBuilder.mNotification.icon != 0) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(androidx.core.R.dimen.notification_right_icon_size);
                    int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(androidx.core.R.dimen.notification_small_icon_background_padding) * 2);
                    androidx.core.app.NotificationCompat.Builder builder2 = this.mBuilder;
                    android.graphics.Bitmap createIconWithBackground = createIconWithBackground(builder2.mNotification.icon, dimensionPixelSize, dimensionPixelSize2, builder2.getColor());
                    int i4 = androidx.core.R.id.right_icon;
                    remoteViews.setImageViewBitmap(i4, createIconWithBackground);
                    remoteViews.setViewVisibility(i4, 0);
                }
            } else if (z && builder.mNotification.icon != 0) {
                int i5 = androidx.core.R.id.icon;
                remoteViews.setViewVisibility(i5, 0);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(androidx.core.R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(androidx.core.R.dimen.notification_big_circle_margin);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(androidx.core.R.dimen.notification_small_icon_size_as_large);
                androidx.core.app.NotificationCompat.Builder builder3 = this.mBuilder;
                remoteViews.setImageViewBitmap(i5, createIconWithBackground(builder3.mNotification.icon, dimensionPixelSize3, dimensionPixelSize4, builder3.getColor()));
            }
            java.lang.CharSequence charSequence2 = this.mBuilder.mContentTitle;
            if (charSequence2 != null) {
                remoteViews.setTextViewText(androidx.core.R.id.title, charSequence2);
            }
            java.lang.CharSequence charSequence3 = this.mBuilder.mContentText;
            boolean z6 = true;
            if (charSequence3 != null) {
                remoteViews.setTextViewText(androidx.core.R.id.text, charSequence3);
                z3 = true;
            } else {
                z3 = false;
            }
            androidx.core.app.NotificationCompat.Builder builder4 = this.mBuilder;
            java.lang.CharSequence charSequence4 = builder4.mContentInfo;
            if (charSequence4 != null) {
                int i6 = androidx.core.R.id.info;
                remoteViews.setTextViewText(i6, charSequence4);
                remoteViews.setViewVisibility(i6, 0);
            } else {
                if (builder4.mNumber <= 0) {
                    remoteViews.setViewVisibility(androidx.core.R.id.info, 8);
                    z4 = false;
                    charSequence = this.mBuilder.mSubText;
                    if (charSequence != null) {
                        remoteViews.setTextViewText(androidx.core.R.id.text, charSequence);
                        java.lang.CharSequence charSequence5 = this.mBuilder.mContentText;
                        if (charSequence5 != null) {
                            int i7 = androidx.core.R.id.text2;
                            remoteViews.setTextViewText(i7, charSequence5);
                            remoteViews.setViewVisibility(i7, 0);
                            z5 = true;
                            if (z5) {
                                if (z2) {
                                    remoteViews.setTextViewTextSize(androidx.core.R.id.text, 0, resources.getDimensionPixelSize(androidx.core.R.dimen.notification_subtext_size));
                                }
                                remoteViews.setViewPadding(androidx.core.R.id.line1, 0, 0, 0, 0);
                            }
                            if (this.mBuilder.getWhenIfShowing() == 0) {
                                z6 = z4;
                            } else if (this.mBuilder.mUseChronometer) {
                                int i8 = androidx.core.R.id.chronometer;
                                remoteViews.setViewVisibility(i8, 0);
                                remoteViews.setLong(i8, "setBase", this.mBuilder.getWhenIfShowing() + (android.os.SystemClock.elapsedRealtime() - java.lang.System.currentTimeMillis()));
                                remoteViews.setBoolean(i8, "setStarted", true);
                                boolean z7 = this.mBuilder.mChronometerCountDown;
                                if (z7 && i2 >= 24) {
                                    remoteViews.setChronometerCountDown(i8, z7);
                                }
                            } else {
                                int i9 = androidx.core.R.id.time;
                                remoteViews.setViewVisibility(i9, 0);
                                remoteViews.setLong(i9, "setTime", this.mBuilder.getWhenIfShowing());
                            }
                            remoteViews.setViewVisibility(androidx.core.R.id.right_side, z6 ? 0 : 8);
                            remoteViews.setViewVisibility(androidx.core.R.id.line3, z3 ? 0 : 8);
                            return remoteViews;
                        }
                        remoteViews.setViewVisibility(androidx.core.R.id.text2, 8);
                    }
                    z5 = false;
                    if (z5) {
                    }
                    if (this.mBuilder.getWhenIfShowing() == 0) {
                    }
                    remoteViews.setViewVisibility(androidx.core.R.id.right_side, z6 ? 0 : 8);
                    remoteViews.setViewVisibility(androidx.core.R.id.line3, z3 ? 0 : 8);
                    return remoteViews;
                }
                if (this.mBuilder.mNumber > resources.getInteger(androidx.core.R.integer.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(androidx.core.R.id.info, resources.getString(androidx.core.R.string.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(androidx.core.R.id.info, java.text.NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
                }
                remoteViews.setViewVisibility(androidx.core.R.id.info, 0);
            }
            z3 = true;
            z4 = true;
            charSequence = this.mBuilder.mSubText;
            if (charSequence != null) {
            }
            z5 = false;
            if (z5) {
            }
            if (this.mBuilder.getWhenIfShowing() == 0) {
            }
            remoteViews.setViewVisibility(androidx.core.R.id.right_side, z6 ? 0 : 8);
            remoteViews.setViewVisibility(androidx.core.R.id.line3, z3 ? 0 : 8);
            return remoteViews;
        }

        @androidx.annotation.Nullable
        public android.app.Notification build() {
            androidx.core.app.NotificationCompat.Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(android.widget.RemoteViews remoteViews, android.widget.RemoteViews remoteViews2) {
            hideNormalContent(remoteViews);
            int i = androidx.core.R.id.notification_main_column;
            remoteViews.removeAllViews(i);
            remoteViews.addView(i, remoteViews2.clone());
            remoteViews.setViewVisibility(i, 0);
            remoteViews.setViewPadding(androidx.core.R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@androidx.annotation.NonNull android.os.Bundle bundle) {
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_SUMMARY_TEXT);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_TITLE_BIG);
            bundle.remove(androidx.core.app.NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.graphics.Bitmap createColoredBitmap(int i, int i2) {
            return createColoredBitmap(i, i2, 0);
        }

        public android.graphics.Bitmap createColoredBitmap(@androidx.annotation.NonNull androidx.core.graphics.drawable.IconCompat iconCompat, int i) {
            return createColoredBitmap(iconCompat, i, 0);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return false;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public java.lang.String getClassName() {
            return null;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews makeBigContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews makeContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.widget.RemoteViews makeHeadsUpContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@androidx.annotation.NonNull android.os.Bundle bundle) {
            if (bundle.containsKey(androidx.core.app.NotificationCompat.EXTRA_SUMMARY_TEXT)) {
                this.mSummaryText = bundle.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_SUMMARY_TEXT);
                this.mSummaryTextSet = true;
            }
            this.mBigContentTitle = bundle.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(@androidx.annotation.Nullable androidx.core.app.NotificationCompat.Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    public static final class WearableExtender implements androidx.core.app.NotificationCompat.Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final java.lang.String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final java.lang.String KEY_ACTIONS = "actions";
        private static final java.lang.String KEY_BACKGROUND = "background";
        private static final java.lang.String KEY_BRIDGE_TAG = "bridgeTag";
        private static final java.lang.String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final java.lang.String KEY_CONTENT_ICON = "contentIcon";
        private static final java.lang.String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final java.lang.String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final java.lang.String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final java.lang.String KEY_DISMISSAL_ID = "dismissalId";
        private static final java.lang.String KEY_DISPLAY_INTENT = "displayIntent";
        private static final java.lang.String KEY_FLAGS = "flags";
        private static final java.lang.String KEY_GRAVITY = "gravity";
        private static final java.lang.String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final java.lang.String KEY_PAGES = "pages";

        @java.lang.Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;

        @java.lang.Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;

        @java.lang.Deprecated
        public static final int SIZE_DEFAULT = 0;

        @java.lang.Deprecated
        public static final int SIZE_FULL_SCREEN = 5;

        @java.lang.Deprecated
        public static final int SIZE_LARGE = 4;

        @java.lang.Deprecated
        public static final int SIZE_MEDIUM = 3;

        @java.lang.Deprecated
        public static final int SIZE_SMALL = 2;

        @java.lang.Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private java.util.ArrayList<androidx.core.app.NotificationCompat.Action> mActions;
        private android.graphics.Bitmap mBackground;
        private java.lang.String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private java.lang.String mDismissalId;
        private android.app.PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private java.util.ArrayList<android.app.Notification> mPages;

        public WearableExtender() {
            this.mActions = new java.util.ArrayList<>();
            this.mFlags = 1;
            this.mPages = new java.util.ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public WearableExtender(@androidx.annotation.NonNull android.app.Notification notification) {
            this.mActions = new java.util.ArrayList<>();
            this.mFlags = 1;
            this.mPages = new java.util.ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            android.os.Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            android.os.Bundle bundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (bundle != null) {
                java.util.ArrayList parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    androidx.core.app.NotificationCompat.Action[] actionArr = new androidx.core.app.NotificationCompat.Action[size];
                    for (int i = 0; i < size; i++) {
                        actionArr[i] = androidx.core.app.NotificationCompat.getActionCompatFromAction((android.app.Notification.Action) parcelableArrayList.get(i));
                    }
                    java.util.Collections.addAll(this.mActions, actionArr);
                }
                this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (android.app.PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                android.app.Notification[] notificationArrayFromBundle = androidx.core.app.NotificationCompat.getNotificationArrayFromBundle(bundle, "pages");
                if (notificationArrayFromBundle != null) {
                    java.util.Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (android.graphics.Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = bundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = bundle.getString(KEY_BRIDGE_TAG);
            }
        }

        @androidx.annotation.RequiresApi(20)
        private static android.app.Notification.Action getActionFromActionCompat(androidx.core.app.NotificationCompat.Action action) {
            android.app.Notification.Action.Builder builder;
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 23) {
                androidx.core.graphics.drawable.IconCompat iconCompat = action.getIconCompat();
                builder = new android.app.Notification.Action.Builder(iconCompat == null ? null : iconCompat.toIcon(), action.getTitle(), action.getActionIntent());
            } else {
                androidx.core.graphics.drawable.IconCompat iconCompat2 = action.getIconCompat();
                builder = new android.app.Notification.Action.Builder((iconCompat2 == null || iconCompat2.getType() != 2) ? 0 : iconCompat2.getResId(), action.getTitle(), action.getActionIntent());
            }
            android.os.Bundle bundle = action.getExtras() != null ? new android.os.Bundle(action.getExtras()) : new android.os.Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (i >= 24) {
                builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            builder.addExtras(bundle);
            androidx.core.app.RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (android.app.RemoteInput remoteInput : androidx.core.app.RemoteInput.fromCompat(remoteInputs)) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            return builder.build();
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                this.mFlags = i | this.mFlags;
            } else {
                this.mFlags = (~i) & this.mFlags;
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender addAction(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Action action) {
            this.mActions.add(action);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender addActions(@androidx.annotation.NonNull java.util.List<androidx.core.app.NotificationCompat.Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender addPage(@androidx.annotation.NonNull android.app.Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender addPages(@androidx.annotation.NonNull java.util.List<android.app.Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        @androidx.annotation.NonNull
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public androidx.core.app.NotificationCompat.WearableExtender m4clone() {
            androidx.core.app.NotificationCompat.WearableExtender wearableExtender = new androidx.core.app.NotificationCompat.WearableExtender();
            wearableExtender.mActions = new java.util.ArrayList<>(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new java.util.ArrayList<>(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.Builder extend(@androidx.annotation.NonNull androidx.core.app.NotificationCompat.Builder builder) {
            android.os.Bundle bundle = new android.os.Bundle();
            if (!this.mActions.isEmpty()) {
                java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>(this.mActions.size());
                java.util.Iterator<androidx.core.app.NotificationCompat.Action> it = this.mActions.iterator();
                while (it.hasNext()) {
                    arrayList.add(getActionFromActionCompat(it.next()));
                }
                bundle.putParcelableArrayList("actions", arrayList);
            }
            int i = this.mFlags;
            if (i != 1) {
                bundle.putInt(KEY_FLAGS, i);
            }
            android.app.PendingIntent pendingIntent = this.mDisplayIntent;
            if (pendingIntent != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, pendingIntent);
            }
            if (!this.mPages.isEmpty()) {
                java.util.ArrayList<android.app.Notification> arrayList2 = this.mPages;
                bundle.putParcelableArray("pages", (android.os.Parcelable[]) arrayList2.toArray(new android.app.Notification[arrayList2.size()]));
            }
            android.graphics.Bitmap bitmap = this.mBackground;
            if (bitmap != null) {
                bundle.putParcelable(KEY_BACKGROUND, bitmap);
            }
            int i2 = this.mContentIcon;
            if (i2 != 0) {
                bundle.putInt(KEY_CONTENT_ICON, i2);
            }
            int i3 = this.mContentIconGravity;
            if (i3 != 8388613) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, i3);
            }
            int i4 = this.mContentActionIndex;
            if (i4 != -1) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, i4);
            }
            int i5 = this.mCustomSizePreset;
            if (i5 != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, i5);
            }
            int i6 = this.mCustomContentHeight;
            if (i6 != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i6);
            }
            int i7 = this.mGravity;
            if (i7 != 80) {
                bundle.putInt(KEY_GRAVITY, i7);
            }
            int i8 = this.mHintScreenTimeout;
            if (i8 != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i8);
            }
            java.lang.String str = this.mDismissalId;
            if (str != null) {
                bundle.putString(KEY_DISMISSAL_ID, str);
            }
            java.lang.String str2 = this.mBridgeTag;
            if (str2 != null) {
                bundle.putString(KEY_BRIDGE_TAG, str2);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
            return builder;
        }

        @androidx.annotation.NonNull
        public java.util.List<androidx.core.app.NotificationCompat.Action> getActions() {
            return this.mActions;
        }

        @androidx.annotation.Nullable
        @java.lang.Deprecated
        public android.graphics.Bitmap getBackground() {
            return this.mBackground;
        }

        @androidx.annotation.Nullable
        public java.lang.String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @java.lang.Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @java.lang.Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        @java.lang.Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @java.lang.Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        @androidx.annotation.Nullable
        public java.lang.String getDismissalId() {
            return this.mDismissalId;
        }

        @androidx.annotation.Nullable
        @java.lang.Deprecated
        public android.app.PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @java.lang.Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        @java.lang.Deprecated
        public boolean getHintAmbientBigPicture() {
            return (this.mFlags & 32) != 0;
        }

        @java.lang.Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.mFlags & 64) != 0;
        }

        @java.lang.Deprecated
        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        @java.lang.Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @java.lang.Deprecated
        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public java.util.List<android.app.Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setBackground(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender setBridgeTag(@androidx.annotation.Nullable java.lang.String str) {
            this.mBridgeTag = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender setContentAction(int i) {
            this.mContentActionIndex = i;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setContentIcon(int i) {
            this.mContentIcon = i;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setContentIconGravity(int i) {
            this.mContentIconGravity = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender setContentIntentAvailableOffline(boolean z) {
            setFlag(1, z);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setCustomContentHeight(int i) {
            this.mCustomContentHeight = i;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setCustomSizePreset(int i) {
            this.mCustomSizePreset = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender setDismissalId(@androidx.annotation.Nullable java.lang.String str) {
            this.mDismissalId = str;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setDisplayIntent(@androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintAmbientBigPicture(boolean z) {
            setFlag(32, z);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            setFlag(16, z);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            setFlag(64, z);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintHideIcon(boolean z) {
            setFlag(2, z);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintScreenTimeout(int i) {
            this.mHintScreenTimeout = i;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintShowBackgroundOnly(boolean z) {
            setFlag(4, z);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.NotificationCompat.WearableExtender setStartScrollBottom(boolean z) {
            setFlag(8, z);
            return this;
        }
    }

    @java.lang.Deprecated
    public NotificationCompat() {
    }

    @androidx.annotation.Nullable
    public static androidx.core.app.NotificationCompat.Action getAction(@androidx.annotation.NonNull android.app.Notification notification, int i) {
        return getActionCompatFromAction(notification.actions[i]);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(20)
    public static androidx.core.app.NotificationCompat.Action getActionCompatFromAction(@androidx.annotation.NonNull android.app.Notification.Action action) {
        androidx.core.app.RemoteInput[] remoteInputArr;
        int i;
        int editChoicesBeforeSending;
        boolean z;
        boolean z2;
        android.graphics.drawable.Icon icon;
        android.graphics.drawable.Icon icon2;
        android.graphics.drawable.Icon icon3;
        int i2;
        boolean isContextual;
        boolean allowGeneratedReplies;
        android.app.RemoteInput[] remoteInputs = action.getRemoteInputs();
        androidx.core.graphics.drawable.IconCompat iconCompat = null;
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            androidx.core.app.RemoteInput[] remoteInputArr2 = new androidx.core.app.RemoteInput[remoteInputs.length];
            for (int i3 = 0; i3 < remoteInputs.length; i3++) {
                android.app.RemoteInput remoteInput = remoteInputs[i3];
                java.lang.String resultKey = remoteInput.getResultKey();
                java.lang.CharSequence label = remoteInput.getLabel();
                java.lang.CharSequence[] choices = remoteInput.getChoices();
                boolean allowFreeFormInput = remoteInput.getAllowFreeFormInput();
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    editChoicesBeforeSending = remoteInput.getEditChoicesBeforeSending();
                    i = editChoicesBeforeSending;
                } else {
                    i = 0;
                }
                remoteInputArr2[i3] = new androidx.core.app.RemoteInput(resultKey, label, choices, allowFreeFormInput, i, remoteInput.getExtras(), null);
            }
            remoteInputArr = remoteInputArr2;
        }
        int i4 = android.os.Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            if (!action.getExtras().getBoolean("android.support.allowGeneratedReplies")) {
                allowGeneratedReplies = action.getAllowGeneratedReplies();
                if (!allowGeneratedReplies) {
                    z = false;
                }
            }
            z = true;
        } else {
            z = action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        }
        boolean z3 = z;
        boolean z4 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        int semanticAction = i4 >= 28 ? action.getSemanticAction() : action.getExtras().getInt("android.support.action.semanticAction", 0);
        if (i4 >= 29) {
            isContextual = action.isContextual();
            z2 = isContextual;
        } else {
            z2 = false;
        }
        if (i4 < 23) {
            return new androidx.core.app.NotificationCompat.Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (androidx.core.app.RemoteInput[]) null, z3, semanticAction, z4, z2);
        }
        icon = action.getIcon();
        if (icon == null && (i2 = action.icon) != 0) {
            return new androidx.core.app.NotificationCompat.Action(i2, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (androidx.core.app.RemoteInput[]) null, z3, semanticAction, z4, z2);
        }
        icon2 = action.getIcon();
        if (icon2 != null) {
            icon3 = action.getIcon();
            iconCompat = androidx.core.graphics.drawable.IconCompat.createFromIconOrNullIfZeroResId(icon3);
        }
        return new androidx.core.app.NotificationCompat.Action(iconCompat, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (androidx.core.app.RemoteInput[]) null, z3, semanticAction, z4, z2);
    }

    public static int getActionCount(@androidx.annotation.NonNull android.app.Notification notification) {
        android.app.Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(@androidx.annotation.NonNull android.app.Notification notification) {
        boolean allowSystemGeneratedContextualActions;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return false;
        }
        allowSystemGeneratedContextualActions = notification.getAllowSystemGeneratedContextualActions();
        return allowSystemGeneratedContextualActions;
    }

    public static boolean getAutoCancel(@androidx.annotation.NonNull android.app.Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int getBadgeIconType(@androidx.annotation.NonNull android.app.Notification notification) {
        int badgeIconType;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        badgeIconType = notification.getBadgeIconType();
        return badgeIconType;
    }

    @androidx.annotation.Nullable
    public static androidx.core.app.NotificationCompat.BubbleMetadata getBubbleMetadata(@androidx.annotation.NonNull android.app.Notification notification) {
        android.app.Notification.BubbleMetadata bubbleMetadata;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return null;
        }
        bubbleMetadata = notification.getBubbleMetadata();
        return androidx.core.app.NotificationCompat.BubbleMetadata.fromPlatform(bubbleMetadata);
    }

    @androidx.annotation.Nullable
    public static java.lang.String getCategory(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.category;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getChannelId(@androidx.annotation.NonNull android.app.Notification notification) {
        java.lang.String channelId;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        channelId = notification.getChannelId();
        return channelId;
    }

    public static int getColor(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.color;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(19)
    public static java.lang.CharSequence getContentInfo(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(19)
    public static java.lang.CharSequence getContentText(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(19)
    public static java.lang.CharSequence getContentTitle(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @androidx.annotation.Nullable
    public static android.os.Bundle getExtras(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.extras;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getGroup(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.getGroup();
    }

    public static int getGroupAlertBehavior(@androidx.annotation.NonNull android.app.Notification notification) {
        int groupAlertBehavior;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        groupAlertBehavior = notification.getGroupAlertBehavior();
        return groupAlertBehavior;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static boolean getHighPriority(@androidx.annotation.NonNull android.app.Notification notification) {
        return (notification.flags & 128) != 0;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(21)
    public static java.util.List<androidx.core.app.NotificationCompat.Action> getInvisibleActions(@androidx.annotation.NonNull android.app.Notification notification) {
        android.os.Bundle bundle;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.os.Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle2 != null && (bundle = bundle2.getBundle("invisible_actions")) != null) {
            for (int i = 0; i < bundle.size(); i++) {
                arrayList.add(androidx.core.app.NotificationCompatJellybean.getActionFromBundle(bundle.getBundle(java.lang.Integer.toString(i))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(@androidx.annotation.NonNull android.app.Notification notification) {
        return (notification.flags & 256) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r3 = r3.getLocusId();
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static androidx.core.content.LocusIdCompat getLocusId(@androidx.annotation.NonNull android.app.Notification notification) {
        android.content.LocusId locusId;
        if (android.os.Build.VERSION.SDK_INT < 29 || locusId == null) {
            return null;
        }
        return androidx.core.content.LocusIdCompat.toLocusIdCompat(locusId);
    }

    @androidx.annotation.NonNull
    public static android.app.Notification[] getNotificationArrayFromBundle(@androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull java.lang.String str) {
        android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof android.app.Notification[]) || parcelableArray == null) {
            return (android.app.Notification[]) parcelableArray;
        }
        android.app.Notification[] notificationArr = new android.app.Notification[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; i++) {
            notificationArr[i] = (android.app.Notification) parcelableArray[i];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static boolean getOngoing(@androidx.annotation.NonNull android.app.Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean getOnlyAlertOnce(@androidx.annotation.NonNull android.app.Notification notification) {
        return (notification.flags & 8) != 0;
    }

    @androidx.annotation.NonNull
    public static java.util.List<androidx.core.app.Person> getPeople(@androidx.annotation.NonNull android.app.Notification notification) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            java.util.ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                java.util.Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(androidx.core.app.Person.fromAndroidPerson((android.app.Person) it.next()));
                }
            }
        } else {
            java.lang.String[] stringArray = notification.extras.getStringArray(EXTRA_PEOPLE);
            if (stringArray != null && stringArray.length != 0) {
                for (java.lang.String str : stringArray) {
                    arrayList.add(new androidx.core.app.Person.Builder().setUri(str).build());
                }
            }
        }
        return arrayList;
    }

    @androidx.annotation.Nullable
    public static android.app.Notification getPublicVersion(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.publicVersion;
    }

    @androidx.annotation.Nullable
    public static java.lang.CharSequence getSettingsText(@androidx.annotation.NonNull android.app.Notification notification) {
        java.lang.CharSequence settingsText;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        settingsText = notification.getSettingsText();
        return settingsText;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getShortcutId(@androidx.annotation.NonNull android.app.Notification notification) {
        java.lang.String shortcutId;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        shortcutId = notification.getShortcutId();
        return shortcutId;
    }

    @androidx.annotation.RequiresApi(19)
    public static boolean getShowWhen(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @androidx.annotation.Nullable
    public static java.lang.String getSortKey(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.getSortKey();
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(19)
    public static java.lang.CharSequence getSubText(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@androidx.annotation.NonNull android.app.Notification notification) {
        long timeoutAfter;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return 0L;
        }
        timeoutAfter = notification.getTimeoutAfter();
        return timeoutAfter;
    }

    @androidx.annotation.RequiresApi(19)
    public static boolean getUsesChronometer(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@androidx.annotation.NonNull android.app.Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(@androidx.annotation.NonNull android.app.Notification notification) {
        return (notification.flags & 512) != 0;
    }
}
