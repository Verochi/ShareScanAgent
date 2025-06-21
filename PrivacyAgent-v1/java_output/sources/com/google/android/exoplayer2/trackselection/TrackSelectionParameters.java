package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public class TrackSelectionParameters implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.TrackSelectionParameters> CREATOR;

    @java.lang.Deprecated
    public static final com.google.android.exoplayer2.trackselection.TrackSelectionParameters DEFAULT;
    public static final com.google.android.exoplayer2.trackselection.TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;

    @androidx.annotation.Nullable
    public final java.lang.String preferredAudioLanguage;

    @androidx.annotation.Nullable
    public final java.lang.String preferredTextLanguage;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    /* renamed from: com.google.android.exoplayer2.trackselection.TrackSelectionParameters$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.TrackSelectionParameters> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.trackselection.TrackSelectionParameters(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters[] newArray(int i) {
            return new com.google.android.exoplayer2.trackselection.TrackSelectionParameters[i];
        }
    }

    public static class Builder {

        @androidx.annotation.Nullable
        public java.lang.String a;

        @androidx.annotation.Nullable
        public java.lang.String b;
        public int c;
        public boolean d;
        public int e;

        @java.lang.Deprecated
        public Builder() {
            this.a = null;
            this.b = null;
            this.c = 0;
            this.d = false;
            this.e = 0;
        }

        public Builder(android.content.Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
        }

        public Builder(com.google.android.exoplayer2.trackselection.TrackSelectionParameters trackSelectionParameters) {
            this.a = trackSelectionParameters.preferredAudioLanguage;
            this.b = trackSelectionParameters.preferredTextLanguage;
            this.c = trackSelectionParameters.preferredTextRoleFlags;
            this.d = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.e = trackSelectionParameters.disabledTextTrackSelectionFlags;
        }

        @androidx.annotation.RequiresApi(19)
        public final void a(android.content.Context context) {
            android.view.accessibility.CaptioningManager captioningManager;
            if ((com.google.android.exoplayer2.util.Util.SDK_INT >= 23 || android.os.Looper.myLooper() != null) && (captioningManager = (android.view.accessibility.CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.c = 1088;
                java.util.Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.b = com.google.android.exoplayer2.util.Util.getLocaleLanguageTag(locale);
                }
            }
        }

        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters build() {
            return new com.google.android.exoplayer2.trackselection.TrackSelectionParameters(this.a, this.b, this.c, this.d, this.e);
        }

        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder setDisabledTextTrackSelectionFlags(int i) {
            this.e = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder setPreferredAudioLanguage(@androidx.annotation.Nullable java.lang.String str) {
            this.a = str;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder setPreferredTextLanguage(@androidx.annotation.Nullable java.lang.String str) {
            this.b = str;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(android.content.Context context) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 19) {
                a(context);
            }
            return this;
        }

        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder setPreferredTextRoleFlags(int i) {
            this.c = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.d = z;
            return this;
        }
    }

    static {
        com.google.android.exoplayer2.trackselection.TrackSelectionParameters build = new com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
        CREATOR = new com.google.android.exoplayer2.trackselection.TrackSelectionParameters.AnonymousClass1();
    }

    public TrackSelectionParameters(android.os.Parcel parcel) {
        this.preferredAudioLanguage = parcel.readString();
        this.preferredTextLanguage = parcel.readString();
        this.preferredTextRoleFlags = parcel.readInt();
        this.selectUndeterminedTextLanguage = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
        this.disabledTextTrackSelectionFlags = parcel.readInt();
    }

    public TrackSelectionParameters(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i, boolean z, int i2) {
        this.preferredAudioLanguage = com.google.android.exoplayer2.util.Util.normalizeLanguageCode(str);
        this.preferredTextLanguage = com.google.android.exoplayer2.util.Util.normalizeLanguageCode(str2);
        this.preferredTextRoleFlags = i;
        this.selectUndeterminedTextLanguage = z;
        this.disabledTextTrackSelectionFlags = i2;
    }

    public static com.google.android.exoplayer2.trackselection.TrackSelectionParameters getDefaults(android.content.Context context) {
        return new com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder(context).build();
    }

    public com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder buildUpon() {
        return new com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.trackselection.TrackSelectionParameters trackSelectionParameters = (com.google.android.exoplayer2.trackselection.TrackSelectionParameters) obj;
        return android.text.TextUtils.equals(this.preferredAudioLanguage, trackSelectionParameters.preferredAudioLanguage) && android.text.TextUtils.equals(this.preferredTextLanguage, trackSelectionParameters.preferredTextLanguage) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == trackSelectionParameters.disabledTextTrackSelectionFlags;
    }

    public int hashCode() {
        java.lang.String str = this.preferredAudioLanguage;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        java.lang.String str2 = this.preferredTextLanguage;
        return ((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.preferredAudioLanguage);
        parcel.writeString(this.preferredTextLanguage);
        parcel.writeInt(this.preferredTextRoleFlags);
        com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
        parcel.writeInt(this.disabledTextTrackSelectionFlags);
    }
}
