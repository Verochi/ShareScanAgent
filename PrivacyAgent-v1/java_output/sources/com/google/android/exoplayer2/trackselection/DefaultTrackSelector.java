package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public class DefaultTrackSelector extends com.google.android.exoplayer2.trackselection.MappingTrackSelector {
    public static final int[] g = new int[0];
    public static final com.google.common.collect.Ordering<java.lang.Integer> h = com.google.common.collect.Ordering.from(new defpackage.vz());
    public static final com.google.common.collect.Ordering<java.lang.Integer> i = com.google.common.collect.Ordering.from(new defpackage.wz());
    public final com.google.android.exoplayer2.trackselection.TrackSelection.Factory d;
    public final java.util.concurrent.atomic.AtomicReference<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters> e;
    public boolean f;

    public static final class AudioTrackScore implements java.lang.Comparable<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore> {
        public final int A;
        public final int B;
        public final boolean isWithinConstraints;

        @androidx.annotation.Nullable
        public final java.lang.String n;
        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters t;
        public final boolean u;
        public final int v;
        public final int w;
        public final int x;
        public final boolean y;
        public final int z;

        public AudioTrackScore(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, int i) {
            this.t = parameters;
            this.n = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
            int i2 = 0;
            this.u = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i, false);
            this.v = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredAudioLanguage, false);
            boolean z = true;
            this.y = (format.selectionFlags & 1) != 0;
            int i3 = format.channelCount;
            this.z = i3;
            this.A = format.sampleRate;
            int i4 = format.bitrate;
            this.B = i4;
            if ((i4 != -1 && i4 > parameters.maxAudioBitrate) || (i3 != -1 && i3 > parameters.maxAudioChannelCount)) {
                z = false;
            }
            this.isWithinConstraints = z;
            java.lang.String[] systemLanguageCodes = com.google.android.exoplayer2.util.Util.getSystemLanguageCodes();
            int i5 = 0;
            while (true) {
                if (i5 >= systemLanguageCodes.length) {
                    i5 = Integer.MAX_VALUE;
                    break;
                }
                int formatLanguageScore = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getFormatLanguageScore(format, systemLanguageCodes[i5], false);
                if (formatLanguageScore > 0) {
                    i2 = formatLanguageScore;
                    break;
                }
                i5++;
            }
            this.w = i5;
            this.x = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore) {
            com.google.common.collect.Ordering reverse = (this.isWithinConstraints && this.u) ? com.google.android.exoplayer2.trackselection.DefaultTrackSelector.h : com.google.android.exoplayer2.trackselection.DefaultTrackSelector.h.reverse();
            com.google.common.collect.ComparisonChain compare = com.google.common.collect.ComparisonChain.start().compareFalseFirst(this.u, audioTrackScore.u).compare(this.v, audioTrackScore.v).compareFalseFirst(this.isWithinConstraints, audioTrackScore.isWithinConstraints).compare(java.lang.Integer.valueOf(this.B), java.lang.Integer.valueOf(audioTrackScore.B), this.t.forceLowestBitrate ? com.google.android.exoplayer2.trackselection.DefaultTrackSelector.h.reverse() : com.google.android.exoplayer2.trackselection.DefaultTrackSelector.i).compareFalseFirst(this.y, audioTrackScore.y).compare(java.lang.Integer.valueOf(this.w), java.lang.Integer.valueOf(audioTrackScore.w), com.google.common.collect.Ordering.natural().reverse()).compare(this.x, audioTrackScore.x).compare(java.lang.Integer.valueOf(this.z), java.lang.Integer.valueOf(audioTrackScore.z), reverse).compare(java.lang.Integer.valueOf(this.A), java.lang.Integer.valueOf(audioTrackScore.A), reverse);
            java.lang.Integer valueOf = java.lang.Integer.valueOf(this.B);
            java.lang.Integer valueOf2 = java.lang.Integer.valueOf(audioTrackScore.B);
            if (!com.google.android.exoplayer2.util.Util.areEqual(this.n, audioTrackScore.n)) {
                reverse = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.i;
            }
            return compare.compare(valueOf, valueOf2, reverse).result();
        }
    }

    public static final class OtherTrackScore implements java.lang.Comparable<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.OtherTrackScore> {
        public final boolean n;
        public final boolean t;

        public OtherTrackScore(com.google.android.exoplayer2.Format format, int i) {
            this.n = (format.selectionFlags & 1) != 0;
            this.t = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i, false);
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.OtherTrackScore otherTrackScore) {
            return com.google.common.collect.ComparisonChain.start().compareFalseFirst(this.t, otherTrackScore.t).compareFalseFirst(this.n, otherTrackScore.n).result();
        }
    }

    public static final class Parameters extends com.google.android.exoplayer2.trackselection.TrackSelectionParameters {
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxAudioBitrate;
        public final int maxAudioChannelCount;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final int minVideoBitrate;
        public final int minVideoFrameRate;
        public final int minVideoHeight;
        public final int minVideoWidth;
        private final android.util.SparseBooleanArray rendererDisabledFlags;
        private final android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;
        public static final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters DEFAULT_WITHOUT_CONTEXT = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder().build();
        public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters> CREATOR = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.AnonymousClass1();

        /* renamed from: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters[] newArray(int i) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters[i];
            }
        }

        public Parameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, boolean z3, int i9, int i10, boolean z4, @androidx.annotation.Nullable java.lang.String str, int i11, int i12, boolean z5, boolean z6, boolean z7, boolean z8, @androidx.annotation.Nullable java.lang.String str2, int i13, boolean z9, int i14, boolean z10, boolean z11, boolean z12, int i15, android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray, android.util.SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i13, z9, i14);
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.maxVideoFrameRate = i3;
            this.maxVideoBitrate = i4;
            this.minVideoWidth = i5;
            this.minVideoHeight = i6;
            this.minVideoFrameRate = i7;
            this.minVideoBitrate = i8;
            this.exceedVideoConstraintsIfNecessary = z;
            this.allowVideoMixedMimeTypeAdaptiveness = z2;
            this.allowVideoNonSeamlessAdaptiveness = z3;
            this.viewportWidth = i9;
            this.viewportHeight = i10;
            this.viewportOrientationMayChange = z4;
            this.maxAudioChannelCount = i11;
            this.maxAudioBitrate = i12;
            this.exceedAudioConstraintsIfNecessary = z5;
            this.allowAudioMixedMimeTypeAdaptiveness = z6;
            this.allowAudioMixedSampleRateAdaptiveness = z7;
            this.allowAudioMixedChannelCountAdaptiveness = z8;
            this.forceLowestBitrate = z10;
            this.forceHighestSupportedBitrate = z11;
            this.exceedRendererCapabilitiesIfNecessary = z12;
            this.tunnelingAudioSessionId = i15;
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
        }

        public Parameters(android.os.Parcel parcel) {
            super(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoFrameRate = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.minVideoWidth = parcel.readInt();
            this.minVideoHeight = parcel.readInt();
            this.minVideoFrameRate = parcel.readInt();
            this.minVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.allowVideoMixedMimeTypeAdaptiveness = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.allowVideoNonSeamlessAdaptiveness = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.maxAudioChannelCount = parcel.readInt();
            this.maxAudioBitrate = parcel.readInt();
            this.exceedAudioConstraintsIfNecessary = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.allowAudioMixedMimeTypeAdaptiveness = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.allowAudioMixedSampleRateAdaptiveness = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.allowAudioMixedChannelCountAdaptiveness = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.forceLowestBitrate = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.forceHighestSupportedBitrate = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
            this.tunnelingAudioSessionId = parcel.readInt();
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = (android.util.SparseBooleanArray) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readSparseBooleanArray());
        }

        private static boolean areRendererDisabledFlagsEqual(android.util.SparseBooleanArray sparseBooleanArray, android.util.SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray, android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (java.util.Map.Entry<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> entry : map.entrySet()) {
                com.google.android.exoplayer2.source.TrackGroupArray key = entry.getKey();
                if (!map2.containsKey(key) || !com.google.android.exoplayer2.util.Util.areEqual(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters getDefaults(android.content.Context context) {
            return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder(context).build();
        }

        private static android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> readSelectionOverrides(android.os.Parcel parcel) {
            int readInt = parcel.readInt();
            android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray = new android.util.SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                java.util.HashMap hashMap = new java.util.HashMap(readInt3);
                for (int i2 = 0; i2 < readInt3; i2++) {
                    hashMap.put((com.google.android.exoplayer2.source.TrackGroupArray) com.google.android.exoplayer2.util.Assertions.checkNotNull((com.google.android.exoplayer2.source.TrackGroupArray) parcel.readParcelable(com.google.android.exoplayer2.source.TrackGroupArray.class.getClassLoader())), (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride) parcel.readParcelable(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(android.os.Parcel parcel, android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> valueAt = sparseArray.valueAt(i);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (java.util.Map.Entry<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon() {
            return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder(this, null);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters) obj;
            return super.equals(obj) && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.maxVideoFrameRate == parameters.maxVideoFrameRate && this.maxVideoBitrate == parameters.maxVideoBitrate && this.minVideoWidth == parameters.minVideoWidth && this.minVideoHeight == parameters.minVideoHeight && this.minVideoFrameRate == parameters.minVideoFrameRate && this.minVideoBitrate == parameters.minVideoBitrate && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxAudioChannelCount == parameters.maxAudioChannelCount && this.maxAudioBitrate == parameters.maxAudioBitrate && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.forceLowestBitrate == parameters.forceLowestBitrate && this.forceHighestSupportedBitrate == parameters.forceHighestSupportedBitrate && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides);
        }

        public final boolean getRendererDisabled(int i) {
            return this.rendererDisabledFlags.get(i);
        }

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride getSelectionOverride(int i, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.selectionOverrides.get(i);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean hasSelectionOverride(int i, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.selectionOverrides.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + this.tunnelingAudioSessionId;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoFrameRate);
            parcel.writeInt(this.maxVideoBitrate);
            parcel.writeInt(this.minVideoWidth);
            parcel.writeInt(this.minVideoHeight);
            parcel.writeInt(this.minVideoFrameRate);
            parcel.writeInt(this.minVideoBitrate);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.allowVideoMixedMimeTypeAdaptiveness);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.allowVideoNonSeamlessAdaptiveness);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeInt(this.maxAudioChannelCount);
            parcel.writeInt(this.maxAudioBitrate);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.exceedAudioConstraintsIfNecessary);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.allowAudioMixedMimeTypeAdaptiveness);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.allowAudioMixedSampleRateAdaptiveness);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.allowAudioMixedChannelCountAdaptiveness);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.forceLowestBitrate);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.forceHighestSupportedBitrate);
            com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            parcel.writeInt(this.tunnelingAudioSessionId);
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
        }
    }

    public static final class ParametersBuilder extends com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder {
        public boolean A;
        public boolean B;
        public int C;
        public final android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> D;
        public final android.util.SparseBooleanArray E;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public boolean n;
        public boolean o;
        public boolean p;
        public int q;
        public int r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f364s;
        public int t;
        public int u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;

        @java.lang.Deprecated
        public ParametersBuilder() {
            c();
            this.D = new android.util.SparseArray<>();
            this.E = new android.util.SparseBooleanArray();
        }

        public ParametersBuilder(android.content.Context context) {
            super(context);
            c();
            this.D = new android.util.SparseArray<>();
            this.E = new android.util.SparseBooleanArray();
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        public ParametersBuilder(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
            super(parameters);
            this.f = parameters.maxVideoWidth;
            this.g = parameters.maxVideoHeight;
            this.h = parameters.maxVideoFrameRate;
            this.i = parameters.maxVideoBitrate;
            this.j = parameters.minVideoWidth;
            this.k = parameters.minVideoHeight;
            this.l = parameters.minVideoFrameRate;
            this.m = parameters.minVideoBitrate;
            this.n = parameters.exceedVideoConstraintsIfNecessary;
            this.o = parameters.allowVideoMixedMimeTypeAdaptiveness;
            this.p = parameters.allowVideoNonSeamlessAdaptiveness;
            this.q = parameters.viewportWidth;
            this.r = parameters.viewportHeight;
            this.f364s = parameters.viewportOrientationMayChange;
            this.t = parameters.maxAudioChannelCount;
            this.u = parameters.maxAudioBitrate;
            this.v = parameters.exceedAudioConstraintsIfNecessary;
            this.w = parameters.allowAudioMixedMimeTypeAdaptiveness;
            this.x = parameters.allowAudioMixedSampleRateAdaptiveness;
            this.y = parameters.allowAudioMixedChannelCountAdaptiveness;
            this.z = parameters.forceLowestBitrate;
            this.A = parameters.forceHighestSupportedBitrate;
            this.B = parameters.exceedRendererCapabilitiesIfNecessary;
            this.C = parameters.tunnelingAudioSessionId;
            this.D = b(parameters.selectionOverrides);
            this.E = parameters.rendererDisabledFlags.clone();
        }

        public /* synthetic */ ParametersBuilder(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AnonymousClass1 anonymousClass1) {
            this(parameters);
        }

        public static android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> b(android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray) {
            android.util.SparseArray<java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride>> sparseArray2 = new android.util.SparseArray<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                sparseArray2.put(sparseArray.keyAt(i), new java.util.HashMap(sparseArray.valueAt(i)));
            }
            return sparseArray2;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters build() {
            return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.f364s, this.a, this.t, this.u, this.v, this.w, this.x, this.y, this.b, this.c, this.d, this.e, this.z, this.A, this.B, this.C, this.D, this.E);
        }

        public final void c() {
            this.f = Integer.MAX_VALUE;
            this.g = Integer.MAX_VALUE;
            this.h = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.n = true;
            this.o = false;
            this.p = true;
            this.q = Integer.MAX_VALUE;
            this.r = Integer.MAX_VALUE;
            this.f364s = true;
            this.t = Integer.MAX_VALUE;
            this.u = Integer.MAX_VALUE;
            this.v = true;
            this.w = false;
            this.x = false;
            this.y = false;
            this.z = false;
            this.A = false;
            this.B = true;
            this.C = 0;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearSelectionOverride(int i, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.D.get(i);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.D.remove(i);
                }
            }
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearSelectionOverrides() {
            if (this.D.size() == 0) {
                return this;
            }
            this.D.clear();
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearSelectionOverrides(int i) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.D.get(i);
            if (map != null && !map.isEmpty()) {
                this.D.remove(i);
            }
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
            this.y = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
            this.w = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
            this.x = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
            this.o = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
            this.p = z;
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setDisabledTextTrackSelectionFlags(int i) {
            super.setDisabledTextTrackSelectionFlags(i);
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z) {
            this.v = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z) {
            this.B = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z) {
            this.n = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setForceHighestSupportedBitrate(boolean z) {
            this.A = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setForceLowestBitrate(boolean z) {
            this.z = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxAudioBitrate(int i) {
            this.u = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxAudioChannelCount(int i) {
            this.t = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoBitrate(int i) {
            this.i = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoFrameRate(int i) {
            this.h = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoSize(int i, int i2) {
            this.f = i;
            this.g = i2;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMinVideoBitrate(int i) {
            this.m = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMinVideoFrameRate(int i) {
            this.l = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setMinVideoSize(int i, int i2) {
            this.j = i;
            this.k = i2;
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setPreferredAudioLanguage(@androidx.annotation.Nullable java.lang.String str) {
            super.setPreferredAudioLanguage(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setPreferredTextLanguage(@androidx.annotation.Nullable java.lang.String str) {
            super.setPreferredTextLanguage(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(android.content.Context context) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setPreferredTextRoleFlags(int i) {
            super.setPreferredTextRoleFlags(i);
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setRendererDisabled(int i, boolean z) {
            if (this.E.get(i) == z) {
                return this;
            }
            if (z) {
                this.E.put(i, true);
            } else {
                this.E.delete(i);
            }
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setSelectUndeterminedTextLanguage(boolean z) {
            super.setSelectUndeterminedTextLanguage(z);
            return this;
        }

        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setSelectionOverride(int i, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, @androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride) {
            java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> map = this.D.get(i);
            if (map == null) {
                map = new java.util.HashMap<>();
                this.D.put(i, map);
            }
            if (map.containsKey(trackGroupArray) && com.google.android.exoplayer2.util.Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setTunnelingAudioSessionId(int i) {
            this.C = i;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setViewportSize(int i, int i2, boolean z) {
            this.q = i;
            this.r = i2;
            this.f364s = z;
            return this;
        }

        public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder setViewportSizeToPhysicalDisplaySize(android.content.Context context, boolean z) {
            android.graphics.Point currentDisplayModeSize = com.google.android.exoplayer2.util.Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z);
        }
    }

    public static final class SelectionOverride implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> CREATOR = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.AnonymousClass1();
        public final int data;
        public final int groupIndex;
        public final int length;
        public final int reason;
        public final int[] tracks;

        /* renamed from: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride[] newArray(int i) {
                return new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride[i];
            }
        }

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 2, 0);
        }

        public SelectionOverride(int i, int[] iArr, int i2, int i3) {
            this.groupIndex = i;
            int[] copyOf = java.util.Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            this.reason = i2;
            this.data = i3;
            java.util.Arrays.sort(copyOf);
        }

        public SelectionOverride(android.os.Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int readByte = parcel.readByte();
            this.length = readByte;
            int[] iArr = new int[readByte];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
            this.reason = parcel.readInt();
            this.data = parcel.readInt();
        }

        public boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride) obj;
            return this.groupIndex == selectionOverride.groupIndex && java.util.Arrays.equals(this.tracks, selectionOverride.tracks) && this.reason == selectionOverride.reason && this.data == selectionOverride.data;
        }

        public int hashCode() {
            return (((((this.groupIndex * 31) + java.util.Arrays.hashCode(this.tracks)) * 31) + this.reason) * 31) + this.data;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
            parcel.writeInt(this.reason);
            parcel.writeInt(this.data);
        }
    }

    public static final class TextTrackScore implements java.lang.Comparable<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore> {
        public final boolean isWithinConstraints;
        public final boolean n;
        public final boolean t;
        public final boolean u;
        public final int v;
        public final int w;
        public final int x;
        public final boolean y;

        public TextTrackScore(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, int i, @androidx.annotation.Nullable java.lang.String str) {
            boolean z = false;
            this.n = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i, false);
            int i2 = format.selectionFlags & (~parameters.disabledTextTrackSelectionFlags);
            boolean z2 = (i2 & 1) != 0;
            this.t = z2;
            boolean z3 = (i2 & 2) != 0;
            this.u = z3;
            int formatLanguageScore = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredTextLanguage, parameters.selectUndeterminedTextLanguage);
            this.v = formatLanguageScore;
            int bitCount = java.lang.Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.w = bitCount;
            this.y = (format.roleFlags & 1088) != 0;
            int formatLanguageScore2 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getFormatLanguageScore(format, str, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.x = formatLanguageScore2;
            if (formatLanguageScore > 0 || ((parameters.preferredTextLanguage == null && bitCount > 0) || z2 || (z3 && formatLanguageScore2 > 0))) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore textTrackScore) {
            com.google.common.collect.ComparisonChain compare = com.google.common.collect.ComparisonChain.start().compareFalseFirst(this.n, textTrackScore.n).compare(this.v, textTrackScore.v).compare(this.w, textTrackScore.w).compareFalseFirst(this.t, textTrackScore.t).compare(java.lang.Boolean.valueOf(this.u), java.lang.Boolean.valueOf(textTrackScore.u), this.v == 0 ? com.google.common.collect.Ordering.natural() : com.google.common.collect.Ordering.natural().reverse()).compare(this.x, textTrackScore.x);
            if (this.w == 0) {
                compare = compare.compareTrueFirst(this.y, textTrackScore.y);
            }
            return compare.result();
        }
    }

    public static final class VideoTrackScore implements java.lang.Comparable<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore> {
        public final boolean isWithinMaxConstraints;
        public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters n;
        public final boolean t;
        public final boolean u;
        public final int v;
        public final int w;

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
        
            if (r10 < r8.minVideoFrameRate) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x005b, code lost:
        
            if (r10 < r8.minVideoBitrate) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VideoTrackScore(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, int i, boolean z) {
            boolean z2;
            int i2;
            int i3;
            float f;
            int i4;
            int i5;
            int i6;
            int i7;
            this.n = parameters;
            boolean z3 = true;
            if (z && (((i5 = format.width) == -1 || i5 <= parameters.maxVideoWidth) && ((i6 = format.height) == -1 || i6 <= parameters.maxVideoHeight))) {
                float f2 = format.frameRate;
                if ((f2 == -1.0f || f2 <= parameters.maxVideoFrameRate) && ((i7 = format.bitrate) == -1 || i7 <= parameters.maxVideoBitrate)) {
                    z2 = true;
                    this.isWithinMaxConstraints = z2;
                    if (z && (((i2 = format.width) == -1 || i2 >= parameters.minVideoWidth) && ((i3 = format.height) == -1 || i3 >= parameters.minVideoHeight))) {
                        f = format.frameRate;
                        if (f != -1.0f) {
                        }
                        i4 = format.bitrate;
                        if (i4 != -1) {
                        }
                        this.t = z3;
                        this.u = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i, false);
                        this.v = format.bitrate;
                        this.w = format.getPixelCount();
                    }
                    z3 = false;
                    this.t = z3;
                    this.u = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i, false);
                    this.v = format.bitrate;
                    this.w = format.getPixelCount();
                }
            }
            z2 = false;
            this.isWithinMaxConstraints = z2;
            if (z) {
                f = format.frameRate;
                if (f != -1.0f) {
                }
                i4 = format.bitrate;
                if (i4 != -1) {
                }
                this.t = z3;
                this.u = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i, false);
                this.v = format.bitrate;
                this.w = format.getPixelCount();
            }
            z3 = false;
            this.t = z3;
            this.u = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(i, false);
            this.v = format.bitrate;
            this.w = format.getPixelCount();
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore videoTrackScore) {
            com.google.common.collect.Ordering reverse = (this.isWithinMaxConstraints && this.u) ? com.google.android.exoplayer2.trackselection.DefaultTrackSelector.h : com.google.android.exoplayer2.trackselection.DefaultTrackSelector.h.reverse();
            return com.google.common.collect.ComparisonChain.start().compareFalseFirst(this.u, videoTrackScore.u).compareFalseFirst(this.isWithinMaxConstraints, videoTrackScore.isWithinMaxConstraints).compareFalseFirst(this.t, videoTrackScore.t).compare(java.lang.Integer.valueOf(this.v), java.lang.Integer.valueOf(videoTrackScore.v), this.n.forceLowestBitrate ? com.google.android.exoplayer2.trackselection.DefaultTrackSelector.h.reverse() : com.google.android.exoplayer2.trackselection.DefaultTrackSelector.i).compare(java.lang.Integer.valueOf(this.w), java.lang.Integer.valueOf(videoTrackScore.w), reverse).compare(java.lang.Integer.valueOf(this.v), java.lang.Integer.valueOf(videoTrackScore.v), reverse).result();
        }
    }

    @java.lang.Deprecated
    public DefaultTrackSelector() {
        this(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT, new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(android.content.Context context) {
        this(context, new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(android.content.Context context, com.google.android.exoplayer2.trackselection.TrackSelection.Factory factory) {
        this(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.getDefaults(context), factory);
    }

    public DefaultTrackSelector(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, com.google.android.exoplayer2.trackselection.TrackSelection.Factory factory) {
        this.d = factory;
        this.e = new java.util.concurrent.atomic.AtomicReference<>(parameters);
    }

    @java.lang.Deprecated
    public DefaultTrackSelector(com.google.android.exoplayer2.trackselection.TrackSelection.Factory factory) {
        this(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT, factory);
    }

    public static int getFormatLanguageScore(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.lang.String str, boolean z) {
        if (!android.text.TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        java.lang.String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        java.lang.String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 == null || normalizeUndeterminedLanguageToNull == null) {
            return (z && normalizeUndeterminedLanguageToNull2 == null) ? 1 : 0;
        }
        if (normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) || normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
            return 3;
        }
        return com.google.android.exoplayer2.util.Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0].equals(com.google.android.exoplayer2.util.Util.splitAtFirst(normalizeUndeterminedLanguageToNull, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0]) ? 2 : 0;
    }

    public static void h(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, int i2, @androidx.annotation.Nullable java.lang.String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, java.util.List<java.lang.Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!o(trackGroup.getFormat(intValue), str, iArr[intValue], i2, i3, i4, i5, i6, i7, i8, i9, i10)) {
                list.remove(size);
            }
        }
    }

    public static int[] i(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, int i2, int i3, boolean z, boolean z2, boolean z3) {
        com.google.android.exoplayer2.Format format = trackGroup.getFormat(i2);
        int[] iArr2 = new int[trackGroup.length];
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroup.length; i5++) {
            if (i5 == i2 || n(trackGroup.getFormat(i5), iArr[i5], format, i3, z, z2, z3)) {
                iArr2[i4] = i5;
                i4++;
            }
        }
        return java.util.Arrays.copyOf(iArr2, i4);
    }

    public static boolean isSupported(int i2, boolean z) {
        int d = defpackage.ub2.d(i2);
        return d == 4 || (z && d == 3);
    }

    public static int j(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, int i2, @androidx.annotation.Nullable java.lang.String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, java.util.List<java.lang.Integer> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            int intValue = list.get(i12).intValue();
            if (o(trackGroup.getFormat(intValue), str, iArr[intValue], i2, i3, i4, i5, i6, i7, i8, i9, i10)) {
                i11++;
            }
        }
        return i11;
    }

    public static int[] k(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z2) {
        java.lang.String str;
        int i13;
        int i14;
        java.util.HashSet hashSet;
        if (trackGroup.length < 2) {
            return g;
        }
        java.util.List<java.lang.Integer> m = m(trackGroup, i11, i12, z2);
        if (m.size() < 2) {
            return g;
        }
        if (z) {
            str = null;
        } else {
            java.util.HashSet hashSet2 = new java.util.HashSet();
            java.lang.String str2 = null;
            int i15 = 0;
            int i16 = 0;
            while (i16 < m.size()) {
                java.lang.String str3 = trackGroup.getFormat(m.get(i16).intValue()).sampleMimeType;
                if (hashSet2.add(str3)) {
                    i13 = i15;
                    i14 = i16;
                    hashSet = hashSet2;
                    int j = j(trackGroup, iArr, i2, str3, i3, i4, i5, i6, i7, i8, i9, i10, m);
                    if (j > i13) {
                        i15 = j;
                        str2 = str3;
                        i16 = i14 + 1;
                        hashSet2 = hashSet;
                    }
                } else {
                    i13 = i15;
                    i14 = i16;
                    hashSet = hashSet2;
                }
                i15 = i13;
                i16 = i14 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        }
        h(trackGroup, iArr, i2, str, i3, i4, i5, i6, i7, i8, i9, i10, m);
        return m.size() < 2 ? g : com.google.common.primitives.Ints.toArray(m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.graphics.Point l(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
        }
        i3 = i2;
        i2 = i3;
        int i6 = i4 * i2;
        int i7 = i5 * i3;
        return i6 >= i7 ? new android.graphics.Point(i3, com.google.android.exoplayer2.util.Util.ceilDivide(i7, i4)) : new android.graphics.Point(com.google.android.exoplayer2.util.Util.ceilDivide(i6, i5), i2);
    }

    public static java.util.List<java.lang.Integer> m(com.google.android.exoplayer2.source.TrackGroup trackGroup, int i2, int i3, boolean z) {
        int i4;
        java.util.ArrayList arrayList = new java.util.ArrayList(trackGroup.length);
        for (int i5 = 0; i5 < trackGroup.length; i5++) {
            arrayList.add(java.lang.Integer.valueOf(i5));
        }
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < trackGroup.length; i7++) {
                com.google.android.exoplayer2.Format format = trackGroup.getFormat(i7);
                int i8 = format.width;
                if (i8 > 0 && (i4 = format.height) > 0) {
                    android.graphics.Point l = l(z, i2, i3, i8, i4);
                    int i9 = format.width;
                    int i10 = format.height;
                    int i11 = i9 * i10;
                    if (i9 >= ((int) (l.x * 0.98f)) && i10 >= ((int) (l.y * 0.98f)) && i11 < i6) {
                        i6 = i11;
                    }
                }
            }
            if (i6 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((java.lang.Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i6) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean n(com.google.android.exoplayer2.Format format, int i2, com.google.android.exoplayer2.Format format2, int i3, boolean z, boolean z2, boolean z3) {
        int i4;
        java.lang.String str;
        int i5;
        if (!isSupported(i2, false)) {
            return false;
        }
        int i6 = format.bitrate;
        if (i6 != -1 && i6 > i3) {
            return false;
        }
        if (!z3 && ((i5 = format.channelCount) == -1 || i5 != format2.channelCount)) {
            return false;
        }
        if (z || ((str = format.sampleMimeType) != null && android.text.TextUtils.equals(str, format2.sampleMimeType))) {
            return z2 || ((i4 = format.sampleRate) != -1 && i4 == format2.sampleRate);
        }
        return false;
    }

    @androidx.annotation.Nullable
    public static java.lang.String normalizeUndeterminedLanguageToNull(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean o(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.lang.String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if ((format.roleFlags & 16384) != 0 || !isSupported(i2, false) || (i2 & i3) == 0) {
            return false;
        }
        if (str != null && !com.google.android.exoplayer2.util.Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i12 = format.width;
        if (i12 != -1 && (i8 > i12 || i12 > i4)) {
            return false;
        }
        int i13 = format.height;
        if (i13 != -1 && (i9 > i13 || i13 > i5)) {
            return false;
        }
        float f = format.frameRate;
        if (f != -1.0f && (i10 > f || f > i6)) {
            return false;
        }
        int i14 = format.bitrate;
        return i14 == -1 || (i11 <= i14 && i14 <= i7);
    }

    public static /* synthetic */ int p(java.lang.Integer num, java.lang.Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public static /* synthetic */ int q(java.lang.Integer num, java.lang.Integer num2) {
        return 0;
    }

    public static void r(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurationArr, com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, int i2) {
        boolean z;
        if (i2 == 0) {
            return;
        }
        boolean z2 = false;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < mappedTrackInfo.getRendererCount(); i5++) {
            int rendererType = mappedTrackInfo.getRendererType(i5);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArr[i5];
            if ((rendererType == 1 || rendererType == 2) && trackSelection != null && s(iArr[i5], mappedTrackInfo.getTrackGroups(i5), trackSelection)) {
                if (rendererType == 1) {
                    if (i4 != -1) {
                        z = false;
                        break;
                    }
                    i4 = i5;
                } else {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i5;
                }
            }
        }
        z = true;
        if (i4 != -1 && i3 != -1) {
            z2 = true;
        }
        if (z && z2) {
            com.google.android.exoplayer2.RendererConfiguration rendererConfiguration = new com.google.android.exoplayer2.RendererConfiguration(i2);
            rendererConfigurationArr[i4] = rendererConfiguration;
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
    }

    public static boolean s(int[][] iArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i2 = 0; i2 < trackSelection.length(); i2++) {
            if (defpackage.ub2.f(iArr[indexOf][trackSelection.getIndexInTrackGroup(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.trackselection.TrackSelection.Definition t(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, int i2, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray2 = trackGroupArray;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters2 = parameters;
        int i3 = parameters2.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = parameters2.allowVideoMixedMimeTypeAdaptiveness && (i2 & i3) != 0;
        int i4 = 0;
        while (i4 < trackGroupArray2.length) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArray2.get(i4);
            int i5 = i4;
            int[] k = k(trackGroup, iArr[i4], z, i3, parameters2.maxVideoWidth, parameters2.maxVideoHeight, parameters2.maxVideoFrameRate, parameters2.maxVideoBitrate, parameters2.minVideoWidth, parameters2.minVideoHeight, parameters2.minVideoFrameRate, parameters2.minVideoBitrate, parameters2.viewportWidth, parameters2.viewportHeight, parameters2.viewportOrientationMayChange);
            if (k.length > 0) {
                return new com.google.android.exoplayer2.trackselection.TrackSelection.Definition(trackGroup, k);
            }
            i4 = i5 + 1;
            trackGroupArray2 = trackGroupArray;
            parameters2 = parameters;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.trackselection.TrackSelection.Definition u(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        int i2 = -1;
        com.google.android.exoplayer2.source.TrackGroup trackGroup = null;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore videoTrackScore = null;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroupArray.get(i3);
            java.util.List<java.lang.Integer> m = m(trackGroup2, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                com.google.android.exoplayer2.Format format = trackGroup2.getFormat(i4);
                if ((format.roleFlags & 16384) == 0 && isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore videoTrackScore2 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore(format, parameters, iArr2[i4], m.contains(java.lang.Integer.valueOf(i4)));
                    if ((videoTrackScore2.isWithinMaxConstraints || parameters.exceedVideoConstraintsIfNecessary) && (videoTrackScore == null || videoTrackScore2.compareTo(videoTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i2 = i4;
                        videoTrackScore = videoTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new com.google.android.exoplayer2.trackselection.TrackSelection.Definition(trackGroup, i2);
    }

    public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    public void experimentalAllowMultipleAdaptiveSelections() {
        this.f = true;
    }

    public com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters getParameters() {
        return this.e.get();
    }

    public com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] selectAllTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) throws com.google.android.exoplayer2.ExoPlaybackException {
        int i2;
        java.lang.String str;
        int i3;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore;
        java.lang.String str2;
        int i4;
        int rendererCount = mappedTrackInfo.getRendererCount();
        com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] definitionArr = new com.google.android.exoplayer2.trackselection.TrackSelection.Definition[rendererCount];
        int i5 = 0;
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo.getRendererType(i6)) {
                if (!z) {
                    com.google.android.exoplayer2.trackselection.TrackSelection.Definition selectVideoTrack = selectVideoTrack(mappedTrackInfo.getTrackGroups(i6), iArr[i6], iArr2[i6], parameters, true);
                    definitionArr[i6] = selectVideoTrack;
                    z = selectVideoTrack != null;
                }
                i7 |= mappedTrackInfo.getTrackGroups(i6).length <= 0 ? 0 : 1;
            }
            i6++;
        }
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore2 = null;
        java.lang.String str3 = null;
        int i8 = -1;
        int i9 = 0;
        while (i9 < rendererCount) {
            if (i2 == mappedTrackInfo.getRendererType(i9)) {
                i3 = i8;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i4 = i9;
                android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection.Definition, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore> selectAudioTrack = selectAudioTrack(mappedTrackInfo.getTrackGroups(i9), iArr[i9], iArr2[i9], parameters, this.f || i7 == 0);
                if (selectAudioTrack != null && (audioTrackScore == null || ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) selectAudioTrack.second).compareTo(audioTrackScore) > 0)) {
                    if (i3 != -1) {
                        definitionArr[i3] = null;
                    }
                    com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition = (com.google.android.exoplayer2.trackselection.TrackSelection.Definition) selectAudioTrack.first;
                    definitionArr[i4] = definition;
                    str3 = definition.group.getFormat(definition.tracks[0]).language;
                    audioTrackScore2 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) selectAudioTrack.second;
                    i8 = i4;
                    i9 = i4 + 1;
                    i2 = 1;
                }
            } else {
                i3 = i8;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i4 = i9;
            }
            i8 = i3;
            audioTrackScore2 = audioTrackScore;
            str3 = str2;
            i9 = i4 + 1;
            i2 = 1;
        }
        java.lang.String str4 = str3;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore textTrackScore = null;
        int i10 = -1;
        while (i5 < rendererCount) {
            int rendererType = mappedTrackInfo.getRendererType(i5);
            if (rendererType != 1) {
                if (rendererType != 2) {
                    if (rendererType != 3) {
                        definitionArr[i5] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i5), iArr[i5], parameters);
                    } else {
                        str = str4;
                        android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection.Definition, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore> selectTextTrack = selectTextTrack(mappedTrackInfo.getTrackGroups(i5), iArr[i5], parameters, str);
                        if (selectTextTrack != null && (textTrackScore == null || ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) selectTextTrack.second).compareTo(textTrackScore) > 0)) {
                            if (i10 != -1) {
                                definitionArr[i10] = null;
                            }
                            definitionArr[i5] = (com.google.android.exoplayer2.trackselection.TrackSelection.Definition) selectTextTrack.first;
                            textTrackScore = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) selectTextTrack.second;
                            i10 = i5;
                        }
                    }
                }
                str = str4;
            } else {
                str = str4;
            }
            i5++;
            str4 = str;
        }
        return definitionArr;
    }

    @androidx.annotation.Nullable
    public android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection.Definition, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore> selectAudioTrack(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, int i2, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition = null;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore = null;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < trackGroupArray.length; i5++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArray.get(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < trackGroup.length; i6++) {
                if (isSupported(iArr2[i6], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore audioTrackScore2 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore(trackGroup.getFormat(i6), parameters, iArr2[i6]);
                    if ((audioTrackScore2.isWithinConstraints || parameters.exceedAudioConstraintsIfNecessary) && (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0)) {
                        i3 = i5;
                        i4 = i6;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroupArray.get(i3);
        if (!parameters.forceHighestSupportedBitrate && !parameters.forceLowestBitrate && z) {
            int[] i7 = i(trackGroup2, iArr[i3], i4, parameters.maxAudioBitrate, parameters.allowAudioMixedMimeTypeAdaptiveness, parameters.allowAudioMixedSampleRateAdaptiveness, parameters.allowAudioMixedChannelCountAdaptiveness);
            if (i7.length > 1) {
                definition = new com.google.android.exoplayer2.trackselection.TrackSelection.Definition(trackGroup2, i7);
            }
        }
        if (definition == null) {
            definition = new com.google.android.exoplayer2.trackselection.TrackSelection.Definition(trackGroup2, i4);
        }
        return android.util.Pair.create(definition, (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) com.google.android.exoplayer2.util.Assertions.checkNotNull(audioTrackScore));
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.TrackSelection.Definition selectOtherTrack(int i2, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.source.TrackGroup trackGroup = null;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.OtherTrackScore otherTrackScore = null;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    com.google.android.exoplayer2.trackselection.DefaultTrackSelector.OtherTrackScore otherTrackScore2 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.OtherTrackScore(trackGroup2.getFormat(i5), iArr2[i5]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroup2;
                        i3 = i5;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new com.google.android.exoplayer2.trackselection.TrackSelection.Definition(trackGroup, i3);
    }

    @androidx.annotation.Nullable
    public android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection.Definition, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore> selectTextTrack(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, @androidx.annotation.Nullable java.lang.String str) throws com.google.android.exoplayer2.ExoPlaybackException {
        int i2 = -1;
        com.google.android.exoplayer2.source.TrackGroup trackGroup = null;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore textTrackScore = null;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore textTrackScore2 = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore(trackGroup2.getFormat(i4), parameters, iArr2[i4], str);
                    if (textTrackScore2.isWithinConstraints && (textTrackScore == null || textTrackScore2.compareTo(textTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i2 = i4;
                        textTrackScore = textTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return android.util.Pair.create(new com.google.android.exoplayer2.trackselection.TrackSelection.Definition(trackGroup, i2), (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) com.google.android.exoplayer2.util.Assertions.checkNotNull(textTrackScore));
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public final android.util.Pair<com.google.android.exoplayer2.RendererConfiguration[], com.google.android.exoplayer2.trackselection.TrackSelection[]> selectTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters = this.e.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        int i2 = 0;
        while (true) {
            if (i2 >= rendererCount) {
                break;
            }
            if (parameters.getRendererDisabled(i2)) {
                selectAllTracks[i2] = null;
            } else {
                com.google.android.exoplayer2.source.TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i2);
                if (parameters.hasSelectionOverride(i2, trackGroups)) {
                    com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = parameters.getSelectionOverride(i2, trackGroups);
                    selectAllTracks[i2] = selectionOverride != null ? new com.google.android.exoplayer2.trackselection.TrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.reason, java.lang.Integer.valueOf(selectionOverride.data)) : null;
                }
            }
            i2++;
        }
        com.google.android.exoplayer2.trackselection.TrackSelection[] createTrackSelections = this.d.createTrackSelections(selectAllTracks, getBandwidthMeter());
        com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurationArr = new com.google.android.exoplayer2.RendererConfiguration[rendererCount];
        for (int i3 = 0; i3 < rendererCount; i3++) {
            rendererConfigurationArr[i3] = !parameters.getRendererDisabled(i3) && (mappedTrackInfo.getRendererType(i3) == 6 || createTrackSelections[i3] != null) ? com.google.android.exoplayer2.RendererConfiguration.DEFAULT : null;
        }
        r(mappedTrackInfo, iArr, rendererConfigurationArr, createTrackSelections, parameters.tunnelingAudioSessionId);
        return android.util.Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.TrackSelection.Definition selectVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, int[][] iArr, int i2, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.TrackSelection.Definition t = (parameters.forceHighestSupportedBitrate || parameters.forceLowestBitrate || !z) ? null : t(trackGroupArray, iArr, i2, parameters);
        return t == null ? u(trackGroupArray, iArr, parameters) : t;
    }

    public void setParameters(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(parameters);
        if (this.e.getAndSet(parameters).equals(parameters)) {
            return;
        }
        invalidate();
    }

    public void setParameters(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }
}
