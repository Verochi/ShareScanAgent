package com.google.android.exoplayer2.source.ads;

/* loaded from: classes22.dex */
public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final com.google.android.exoplayer2.source.ads.AdPlaybackState NONE = new com.google.android.exoplayer2.source.ads.AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final android.net.Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new android.net.Uri[0], new long[0]);
        }

        public AdGroup(int i, int[] iArr, android.net.Uri[] uriArr, long[] jArr) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }

        @androidx.annotation.CheckResult
        public static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int max = java.lang.Math.max(i, length);
            long[] copyOf = java.util.Arrays.copyOf(jArr, max);
            java.util.Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        @androidx.annotation.CheckResult
        public static int[] b(int[] iArr, int i) {
            int length = iArr.length;
            int max = java.lang.Math.max(i, length);
            int[] copyOf = java.util.Arrays.copyOf(iArr, max);
            java.util.Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup adGroup = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup) obj;
            return this.count == adGroup.count && java.util.Arrays.equals(this.uris, adGroup.uris) && java.util.Arrays.equals(this.states, adGroup.states) && java.util.Arrays.equals(this.durationsUs, adGroup.durationsUs);
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.states;
                if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public boolean hasUnplayedAds() {
            return this.count == -1 || getFirstAdIndexToPlay() < this.count;
        }

        public int hashCode() {
            return (((((this.count * 31) + java.util.Arrays.hashCode(this.uris)) * 31) + java.util.Arrays.hashCode(this.states)) * 31) + java.util.Arrays.hashCode(this.durationsUs);
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdCount(int i) {
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(i, b(this.states, i), (android.net.Uri[]) java.util.Arrays.copyOf(this.uris, i), a(this.durationsUs, i));
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdDurationsUs(long[] jArr) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(this.count == -1 || jArr.length <= this.uris.length);
            int length = jArr.length;
            android.net.Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            }
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(this.count, this.states, this.uris, jArr);
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdState(int i, int i2) {
            int i3 = this.count;
            com.google.android.exoplayer2.util.Assertions.checkArgument(i3 == -1 || i2 < i3);
            int[] b = b(this.states, i2 + 1);
            int i4 = b[i2];
            com.google.android.exoplayer2.util.Assertions.checkArgument(i4 == 0 || i4 == 1 || i4 == i);
            long[] jArr = this.durationsUs;
            if (jArr.length != b.length) {
                jArr = a(jArr, b.length);
            }
            android.net.Uri[] uriArr = this.uris;
            if (uriArr.length != b.length) {
                uriArr = (android.net.Uri[]) java.util.Arrays.copyOf(uriArr, b.length);
            }
            b[i2] = i;
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(this.count, b, uriArr, jArr);
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAdUri(android.net.Uri uri, int i) {
            int[] b = b(this.states, i + 1);
            long[] jArr = this.durationsUs;
            if (jArr.length != b.length) {
                jArr = a(jArr, b.length);
            }
            android.net.Uri[] uriArr = (android.net.Uri[]) java.util.Arrays.copyOf(this.uris, b.length);
            uriArr[i] = uri;
            b[i] = 1;
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(this.count, b, uriArr, jArr);
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(0, new int[0], new android.net.Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = java.util.Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                int i2 = copyOf[i];
                if (i2 == 1 || i2 == 0) {
                    copyOf[i] = 2;
                }
            }
            return new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup(length, copyOf, this.uris, this.durationsUs);
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = java.util.Arrays.copyOf(jArr, length);
        this.adGroups = new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[length];
        for (int i = 0; i < length; i++) {
            this.adGroups[i] = new com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup();
        }
        this.adResumePositionUs = 0L;
        this.contentDurationUs = -9223372036854775807L;
    }

    public AdPlaybackState(long[] jArr, com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr, long j, long j2) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = j;
        this.contentDurationUs = j2;
    }

    public final boolean a(long j, long j2, int i) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j3 = this.adGroupTimesUs[i];
        return j3 == Long.MIN_VALUE ? j2 == -9223372036854775807L || j < j2 : j < j3;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.source.ads.AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState = (com.google.android.exoplayer2.source.ads.AdPlaybackState) obj;
        return this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && java.util.Arrays.equals(this.adGroupTimesUs, adPlaybackState.adGroupTimesUs) && java.util.Arrays.equals(this.adGroups, adPlaybackState.adGroups);
    }

    public int getAdGroupIndexAfterPositionUs(long j, long j2) {
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        int i = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i >= jArr.length) {
                break;
            }
            long j3 = jArr[i];
            if (j3 == Long.MIN_VALUE || (j < j3 && this.adGroups[i].hasUnplayedAds())) {
                break;
            }
            i++;
        }
        if (i < this.adGroupTimesUs.length) {
            return i;
        }
        return -1;
    }

    public int getAdGroupIndexForPositionUs(long j, long j2) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0 && a(j, j2, length)) {
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    public int hashCode() {
        return (((((((this.adGroupCount * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + java.util.Arrays.hashCode(this.adGroupTimesUs)) * 31) + java.util.Arrays.hashCode(this.adGroups);
    }

    public boolean isAdInErrorState(int i, int i2) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup adGroup;
        int i3;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        return i < adGroupArr.length && (i3 = (adGroup = adGroupArr[i]).count) != -1 && i2 < i3 && adGroup.states[i2] == 4;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("AdPlaybackState(adResumePositionUs=");
        sb.append(this.adResumePositionUs);
        sb.append(", adGroups=[");
        for (int i = 0; i < this.adGroups.length; i++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.adGroupTimesUs[i]);
            sb.append(", ads=[");
            for (int i2 = 0; i2 < this.adGroups[i].states.length; i2++) {
                sb.append("ad(state=");
                int i3 = this.adGroups[i].states[i2];
                if (i3 == 0) {
                    sb.append('_');
                } else if (i3 == 1) {
                    sb.append('R');
                } else if (i3 == 2) {
                    sb.append('S');
                } else if (i3 == 3) {
                    sb.append('P');
                } else if (i3 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.adGroups[i].durationsUs[i2]);
                sb.append(')');
                if (i2 < this.adGroups[i].states.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < this.adGroups.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdCount(int i, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i2 > 0);
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i].count == i2) {
            return this;
        }
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = this.adGroups[i].withAdCount(i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdDurationsUs(long[][] jArr) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        for (int i = 0; i < this.adGroupCount; i++) {
            adGroupArr2[i] = adGroupArr2[i].withAdDurationsUs(jArr[i]);
        }
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdLoadError(int i, int i2) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdState(4, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdResumePositionUs(long j) {
        return this.adResumePositionUs == j ? this : new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, this.adGroups, j, this.contentDurationUs);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withAdUri(int i, int i2, android.net.Uri uri) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdUri(uri, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withContentDurationUs(long j) {
        return this.contentDurationUs == j ? this : new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withPlayedAd(int i, int i2) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdState(3, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withSkippedAd(int i, int i2) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdState(2, i2);
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.source.ads.AdPlaybackState withSkippedAdGroup(int i) {
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr = this.adGroups;
        com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[] adGroupArr2 = (com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAllAdsSkipped();
        return new com.google.android.exoplayer2.source.ads.AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }
}
