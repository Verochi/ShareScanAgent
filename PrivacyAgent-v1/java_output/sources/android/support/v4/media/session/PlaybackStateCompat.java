package android.support.v4.media.session;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements android.os.Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;

    @java.lang.Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final android.os.Parcelable.Creator<android.support.v4.media.session.PlaybackStateCompat> CREATOR = new android.support.v4.media.session.PlaybackStateCompat.AnonymousClass1();
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    java.util.List<android.support.v4.media.session.PlaybackStateCompat.CustomAction> mCustomActions;
    final int mErrorCode;
    final java.lang.CharSequence mErrorMessage;
    final android.os.Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private java.lang.Object mStateObj;
    final long mUpdateTime;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.media.session.PlaybackStateCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.session.PlaybackStateCompat createFromParcel(android.os.Parcel parcel) {
            return new android.support.v4.media.session.PlaybackStateCompat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.session.PlaybackStateCompat[] newArray(int i) {
            return new android.support.v4.media.session.PlaybackStateCompat[i];
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Actions {
    }

    public static final class Builder {
        private long mActions;
        private long mActiveItemId;
        private long mBufferedPosition;
        private final java.util.List<android.support.v4.media.session.PlaybackStateCompat.CustomAction> mCustomActions;
        private int mErrorCode;
        private java.lang.CharSequence mErrorMessage;
        private android.os.Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder() {
            this.mCustomActions = new java.util.ArrayList();
            this.mActiveItemId = -1L;
        }

        public Builder(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.mCustomActions = arrayList;
            this.mActiveItemId = -1L;
            this.mState = playbackStateCompat.mState;
            this.mPosition = playbackStateCompat.mPosition;
            this.mRate = playbackStateCompat.mSpeed;
            this.mUpdateTime = playbackStateCompat.mUpdateTime;
            this.mBufferedPosition = playbackStateCompat.mBufferedPosition;
            this.mActions = playbackStateCompat.mActions;
            this.mErrorCode = playbackStateCompat.mErrorCode;
            this.mErrorMessage = playbackStateCompat.mErrorMessage;
            java.util.List<android.support.v4.media.session.PlaybackStateCompat.CustomAction> list = playbackStateCompat.mCustomActions;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.mActiveItemId = playbackStateCompat.mActiveItemId;
            this.mExtras = playbackStateCompat.mExtras;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder addCustomAction(android.support.v4.media.session.PlaybackStateCompat.CustomAction customAction) {
            if (customAction == null) {
                throw new java.lang.IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.mCustomActions.add(customAction);
            return this;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder addCustomAction(java.lang.String str, java.lang.String str2, int i) {
            return addCustomAction(new android.support.v4.media.session.PlaybackStateCompat.CustomAction(str, str2, i, null));
        }

        public android.support.v4.media.session.PlaybackStateCompat build() {
            return new android.support.v4.media.session.PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setActions(long j) {
            this.mActions = j;
            return this;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setActiveQueueItemId(long j) {
            this.mActiveItemId = j;
            return this;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setBufferedPosition(long j) {
            this.mBufferedPosition = j;
            return this;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setErrorMessage(int i, java.lang.CharSequence charSequence) {
            this.mErrorCode = i;
            this.mErrorMessage = charSequence;
            return this;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setErrorMessage(java.lang.CharSequence charSequence) {
            this.mErrorMessage = charSequence;
            return this;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setExtras(android.os.Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setState(int i, long j, float f) {
            return setState(i, j, f, android.os.SystemClock.elapsedRealtime());
        }

        public android.support.v4.media.session.PlaybackStateCompat.Builder setState(int i, long j, float f, long j2) {
            this.mState = i;
            this.mPosition = j;
            this.mUpdateTime = j2;
            this.mRate = f;
            return this;
        }
    }

    public static final class CustomAction implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.session.PlaybackStateCompat.CustomAction> CREATOR = new android.support.v4.media.session.PlaybackStateCompat.CustomAction.AnonymousClass1();
        private final java.lang.String mAction;
        private java.lang.Object mCustomActionObj;
        private final android.os.Bundle mExtras;
        private final int mIcon;
        private final java.lang.CharSequence mName;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.media.session.PlaybackStateCompat.CustomAction> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.PlaybackStateCompat.CustomAction createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.session.PlaybackStateCompat.CustomAction(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.PlaybackStateCompat.CustomAction[] newArray(int i) {
                return new android.support.v4.media.session.PlaybackStateCompat.CustomAction[i];
            }
        }

        public static final class Builder {
            private final java.lang.String mAction;
            private android.os.Bundle mExtras;
            private final int mIcon;
            private final java.lang.CharSequence mName;

            public Builder(java.lang.String str, java.lang.CharSequence charSequence, int i) {
                if (android.text.TextUtils.isEmpty(str)) {
                    throw new java.lang.IllegalArgumentException("You must specify an action to build a CustomAction.");
                }
                if (android.text.TextUtils.isEmpty(charSequence)) {
                    throw new java.lang.IllegalArgumentException("You must specify a name to build a CustomAction.");
                }
                if (i == 0) {
                    throw new java.lang.IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                }
                this.mAction = str;
                this.mName = charSequence;
                this.mIcon = i;
            }

            public android.support.v4.media.session.PlaybackStateCompat.CustomAction build() {
                return new android.support.v4.media.session.PlaybackStateCompat.CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }

            public android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder setExtras(android.os.Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }
        }

        public CustomAction(android.os.Parcel parcel) {
            this.mAction = parcel.readString();
            this.mName = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.mIcon = parcel.readInt();
            this.mExtras = parcel.readBundle(android.support.v4.media.session.MediaSessionCompat.class.getClassLoader());
        }

        public CustomAction(java.lang.String str, java.lang.CharSequence charSequence, int i, android.os.Bundle bundle) {
            this.mAction = str;
            this.mName = charSequence;
            this.mIcon = i;
            this.mExtras = bundle;
        }

        public static android.support.v4.media.session.PlaybackStateCompat.CustomAction fromCustomAction(java.lang.Object obj) {
            if (obj == null) {
                return null;
            }
            android.support.v4.media.session.PlaybackStateCompat.CustomAction customAction = new android.support.v4.media.session.PlaybackStateCompat.CustomAction(android.support.v4.media.session.PlaybackStateCompatApi21.CustomAction.getAction(obj), android.support.v4.media.session.PlaybackStateCompatApi21.CustomAction.getName(obj), android.support.v4.media.session.PlaybackStateCompatApi21.CustomAction.getIcon(obj), android.support.v4.media.session.PlaybackStateCompatApi21.CustomAction.getExtras(obj));
            customAction.mCustomActionObj = obj;
            return customAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public java.lang.String getAction() {
            return this.mAction;
        }

        public java.lang.Object getCustomAction() {
            java.lang.Object obj = this.mCustomActionObj;
            if (obj != null) {
                return obj;
            }
            java.lang.Object newInstance = android.support.v4.media.session.PlaybackStateCompatApi21.CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
            this.mCustomActionObj = newInstance;
            return newInstance;
        }

        public android.os.Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public java.lang.CharSequence getName() {
            return this.mName;
        }

        public java.lang.String toString() {
            return "Action:mName='" + ((java.lang.Object) this.mName) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeString(this.mAction);
            android.text.TextUtils.writeToParcel(this.mName, parcel, i);
            parcel.writeInt(this.mIcon);
            parcel.writeBundle(this.mExtras);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ErrorCode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface MediaKeyAction {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface RepeatMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShuffleMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    public PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, java.lang.CharSequence charSequence, long j4, java.util.List<android.support.v4.media.session.PlaybackStateCompat.CustomAction> list, long j5, android.os.Bundle bundle) {
        this.mState = i;
        this.mPosition = j;
        this.mBufferedPosition = j2;
        this.mSpeed = f;
        this.mActions = j3;
        this.mErrorCode = i2;
        this.mErrorMessage = charSequence;
        this.mUpdateTime = j4;
        this.mCustomActions = new java.util.ArrayList(list);
        this.mActiveItemId = j5;
        this.mExtras = bundle;
    }

    public PlaybackStateCompat(android.os.Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.mUpdateTime = parcel.readLong();
        this.mBufferedPosition = parcel.readLong();
        this.mActions = parcel.readLong();
        this.mErrorMessage = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mCustomActions = parcel.createTypedArrayList(android.support.v4.media.session.PlaybackStateCompat.CustomAction.CREATOR);
        this.mActiveItemId = parcel.readLong();
        this.mExtras = parcel.readBundle(android.support.v4.media.session.MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = parcel.readInt();
    }

    public static android.support.v4.media.session.PlaybackStateCompat fromPlaybackState(java.lang.Object obj) {
        java.util.ArrayList arrayList;
        if (obj == null) {
            return null;
        }
        java.util.List<java.lang.Object> customActions = android.support.v4.media.session.PlaybackStateCompatApi21.getCustomActions(obj);
        if (customActions != null) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList(customActions.size());
            java.util.Iterator<java.lang.Object> it = customActions.iterator();
            while (it.hasNext()) {
                arrayList2.add(android.support.v4.media.session.PlaybackStateCompat.CustomAction.fromCustomAction(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        android.support.v4.media.session.PlaybackStateCompat playbackStateCompat = new android.support.v4.media.session.PlaybackStateCompat(android.support.v4.media.session.PlaybackStateCompatApi21.getState(obj), android.support.v4.media.session.PlaybackStateCompatApi21.getPosition(obj), android.support.v4.media.session.PlaybackStateCompatApi21.getBufferedPosition(obj), android.support.v4.media.session.PlaybackStateCompatApi21.getPlaybackSpeed(obj), android.support.v4.media.session.PlaybackStateCompatApi21.getActions(obj), 0, android.support.v4.media.session.PlaybackStateCompatApi21.getErrorMessage(obj), android.support.v4.media.session.PlaybackStateCompatApi21.getLastPositionUpdateTime(obj), arrayList, android.support.v4.media.session.PlaybackStateCompatApi21.getActiveQueueItemId(obj), android.os.Build.VERSION.SDK_INT >= 22 ? android.support.v4.media.session.PlaybackStateCompatApi22.getExtras(obj) : null);
        playbackStateCompat.mStateObj = obj;
        return playbackStateCompat;
    }

    public static int toKeyCode(long j) {
        if (j == 4) {
            return 126;
        }
        if (j == 2) {
            return 127;
        }
        if (j == 32) {
            return 87;
        }
        if (j == 16) {
            return 88;
        }
        if (j == 1) {
            return 86;
        }
        if (j == 64) {
            return 90;
        }
        if (j == 8) {
            return 89;
        }
        return j == 512 ? 85 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public long getCurrentPosition(java.lang.Long l) {
        return java.lang.Math.max(0L, this.mPosition + ((long) (this.mSpeed * (l != null ? l.longValue() : android.os.SystemClock.elapsedRealtime() - this.mUpdateTime))));
    }

    public java.util.List<android.support.v4.media.session.PlaybackStateCompat.CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public java.lang.CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    @androidx.annotation.Nullable
    public android.os.Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public java.lang.Object getPlaybackState() {
        java.util.ArrayList arrayList;
        if (this.mStateObj == null) {
            if (this.mCustomActions != null) {
                arrayList = new java.util.ArrayList(this.mCustomActions.size());
                java.util.Iterator<android.support.v4.media.session.PlaybackStateCompat.CustomAction> it = this.mCustomActions.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getCustomAction());
                }
            } else {
                arrayList = null;
            }
            java.util.ArrayList arrayList2 = arrayList;
            if (android.os.Build.VERSION.SDK_INT >= 22) {
                this.mStateObj = android.support.v4.media.session.PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList2, this.mActiveItemId, this.mExtras);
            } else {
                this.mStateObj = android.support.v4.media.session.PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList2, this.mActiveItemId);
            }
        }
        return this.mStateObj;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public java.lang.String toString() {
        return "PlaybackState {state=" + this.mState + ", position=" + this.mPosition + ", buffered position=" + this.mBufferedPosition + ", speed=" + this.mSpeed + ", updated=" + this.mUpdateTime + ", actions=" + this.mActions + ", error code=" + this.mErrorCode + ", error message=" + this.mErrorMessage + ", custom actions=" + this.mCustomActions + ", active item id=" + this.mActiveItemId + com.alipay.sdk.m.u.i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeLong(this.mBufferedPosition);
        parcel.writeLong(this.mActions);
        android.text.TextUtils.writeToParcel(this.mErrorMessage, parcel, i);
        parcel.writeTypedList(this.mCustomActions);
        parcel.writeLong(this.mActiveItemId);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }
}
