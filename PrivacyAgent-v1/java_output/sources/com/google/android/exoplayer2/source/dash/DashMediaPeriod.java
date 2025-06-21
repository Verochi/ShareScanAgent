package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
final class DashMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>>, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<com.google.android.exoplayer2.source.dash.DashChunkSource> {
    public static final java.util.regex.Pattern O = java.util.regex.Pattern.compile("CC([1-4])=(.+)");
    public static final java.util.regex.Pattern P = java.util.regex.Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    public final com.google.android.exoplayer2.source.TrackGroupArray A;
    public final com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] B;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory C;
    public final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler D;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher F;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher G;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod.Callback H;
    public com.google.android.exoplayer2.source.SequenceableLoader K;
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest L;
    public int M;
    public java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> N;
    public final int n;
    public final com.google.android.exoplayer2.source.dash.DashChunkSource.Factory t;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.TransferListener u;
    public final com.google.android.exoplayer2.drm.DrmSessionManager v;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy w;
    public final long x;
    public final com.google.android.exoplayer2.upstream.LoaderErrorThrower y;
    public final com.google.android.exoplayer2.upstream.Allocator z;
    public com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>[] I = n(0);
    public com.google.android.exoplayer2.source.dash.EventSampleStream[] J = new com.google.android.exoplayer2.source.dash.EventSampleStream[0];
    public final java.util.IdentityHashMap<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler> E = new java.util.IdentityHashMap<>();

    public static final class TrackGroupInfo {
        public final int[] a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        public TrackGroupInfo(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
            this.b = i;
            this.a = iArr;
            this.c = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.d = i6;
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo a(int[] iArr, int i) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(3, 1, iArr, i, -1, -1, -1);
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo b(int[] iArr, int i) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(4, 1, iArr, i, -1, -1, -1);
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo c(int i) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(4, 2, new int[0], -1, -1, -1, i);
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo d(int i, int[] iArr, int i2, int i3, int i4) {
            return new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo(i, 0, iArr, i2, i3, i4, -1);
        }
    }

    public DashMediaPeriod(int i, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i2, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher2, long j, com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback) {
        this.n = i;
        this.L = dashManifest;
        this.M = i2;
        this.t = factory;
        this.u = transferListener;
        this.v = drmSessionManager;
        this.G = eventDispatcher;
        this.w = loadErrorHandlingPolicy;
        this.F = eventDispatcher2;
        this.x = j;
        this.y = loaderErrorThrower;
        this.z = allocator;
        this.C = compositeSequenceableLoaderFactory;
        this.D = new com.google.android.exoplayer2.source.dash.PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator);
        this.K = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.I);
        com.google.android.exoplayer2.source.dash.manifest.Period period = dashManifest.getPeriod(i2);
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list = period.eventStreams;
        this.N = list;
        android.util.Pair<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[]> d = d(drmSessionManager, period.adaptationSets, list);
        this.A = (com.google.android.exoplayer2.source.TrackGroupArray) d.first;
        this.B = (com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[]) d.second;
    }

    public static void a(java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list, com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] trackGroupInfoArr, int i) {
        int i2 = 0;
        while (i2 < list.size()) {
            trackGroupArr[i] = new com.google.android.exoplayer2.source.TrackGroup(new com.google.android.exoplayer2.Format.Builder().setId(list.get(i2).id()).setSampleMimeType("application/x-emsg").build());
            trackGroupInfoArr[i] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.c(i2);
            i2++;
            i++;
        }
    }

    public static int b(com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[][] iArr, int i, boolean[] zArr, com.google.android.exoplayer2.Format[][] formatArr, com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] trackGroupInfoArr) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int[] iArr2 = iArr[i4];
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i6 : iArr2) {
                arrayList.addAll(list.get(i6).representations);
            }
            int size = arrayList.size();
            com.google.android.exoplayer2.Format[] formatArr2 = new com.google.android.exoplayer2.Format[size];
            for (int i7 = 0; i7 < size; i7++) {
                com.google.android.exoplayer2.Format format = ((com.google.android.exoplayer2.source.dash.manifest.Representation) arrayList.get(i7)).format;
                formatArr2[i7] = format.copyWithExoMediaCryptoType(drmSessionManager.getExoMediaCryptoType(format));
            }
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = list.get(iArr2[0]);
            int i8 = i5 + 1;
            if (zArr[i4]) {
                i2 = i8 + 1;
            } else {
                i2 = i8;
                i8 = -1;
            }
            if (formatArr[i4].length != 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            trackGroupArr[i5] = new com.google.android.exoplayer2.source.TrackGroup(formatArr2);
            trackGroupInfoArr[i5] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.d(adaptationSet.type, iArr2, i5, i8, i2);
            if (i8 != -1) {
                com.google.android.exoplayer2.Format.Builder builder = new com.google.android.exoplayer2.Format.Builder();
                int i9 = adaptationSet.id;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(16);
                sb.append(i9);
                sb.append(":emsg");
                trackGroupArr[i8] = new com.google.android.exoplayer2.source.TrackGroup(builder.setId(sb.toString()).setSampleMimeType("application/x-emsg").build());
                trackGroupInfoArr[i8] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.b(iArr2, i5);
            }
            if (i2 != -1) {
                trackGroupArr[i2] = new com.google.android.exoplayer2.source.TrackGroup(formatArr[i4]);
                trackGroupInfoArr[i2] = com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo.a(iArr2, i5);
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    public static android.util.Pair<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[]> d(com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list2) {
        int[][] i = i(list);
        int length = i.length;
        boolean[] zArr = new boolean[length];
        com.google.android.exoplayer2.Format[][] formatArr = new com.google.android.exoplayer2.Format[length][];
        int m = m(length, list, i, zArr, formatArr) + length + list2.size();
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[m];
        com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[] trackGroupInfoArr = new com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo[m];
        a(list2, trackGroupArr, trackGroupInfoArr, b(drmSessionManager, list, i, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return android.util.Pair.create(new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.dash.manifest.Descriptor e(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        return f(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.dash.manifest.Descriptor f(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, java.lang.String str) {
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i);
            if (str.equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.source.dash.manifest.Descriptor g(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        return f(list, "http://dashif.org/guidelines/trickmode");
    }

    public static com.google.android.exoplayer2.Format[] h(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = list.get(i);
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2 = list.get(i).accessibilityDescriptors;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list2.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                    com.google.android.exoplayer2.Format.Builder sampleMimeType = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/cea-608");
                    int i3 = adaptationSet.id;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(18);
                    sb.append(i3);
                    sb.append(":cea608");
                    return p(descriptor, O, sampleMimeType.setId(sb.toString()).build());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri)) {
                    com.google.android.exoplayer2.Format.Builder sampleMimeType2 = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/cea-708");
                    int i4 = adaptationSet.id;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder(18);
                    sb2.append(i4);
                    sb2.append(":cea708");
                    return p(descriptor, P, sampleMimeType2.setId(sb2.toString()).build());
                }
            }
        }
        return new com.google.android.exoplayer2.Format[0];
    }

    public static int[][] i(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list) {
        int i;
        com.google.android.exoplayer2.source.dash.manifest.Descriptor e;
        int size = list.size();
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray(size);
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        android.util.SparseArray sparseArray = new android.util.SparseArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(list.get(i2).id, i2);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            arrayList2.add(java.lang.Integer.valueOf(i2));
            arrayList.add(arrayList2);
            sparseArray.put(i2, arrayList2);
        }
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = list.get(i3);
            com.google.android.exoplayer2.source.dash.manifest.Descriptor g = g(adaptationSet.essentialProperties);
            if (g == null) {
                g = g(adaptationSet.supplementalProperties);
            }
            if (g == null || (i = sparseIntArray.get(java.lang.Integer.parseInt(g.value), -1)) == -1) {
                i = i3;
            }
            if (i == i3 && (e = e(adaptationSet.supplementalProperties)) != null) {
                for (java.lang.String str : com.google.android.exoplayer2.util.Util.split(e.value, ",")) {
                    int i4 = sparseIntArray.get(java.lang.Integer.parseInt(str), -1);
                    if (i4 != -1) {
                        i = java.lang.Math.min(i, i4);
                    }
                }
            }
            if (i != i3) {
                java.util.List list2 = (java.util.List) sparseArray.get(i3);
                java.util.List list3 = (java.util.List) sparseArray.get(i);
                list3.addAll(list2);
                sparseArray.put(i3, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i5 = 0; i5 < size2; i5++) {
            int[] array = com.google.common.primitives.Ints.toArray((java.util.Collection) arrayList.get(i5));
            iArr[i5] = array;
            java.util.Arrays.sort(array);
        }
        return iArr;
    }

    public static boolean l(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list2 = list.get(i).representations;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).inbandEventStreams.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int m(int i, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, int[][] iArr, boolean[] zArr, com.google.android.exoplayer2.Format[][] formatArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (l(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            com.google.android.exoplayer2.Format[] h = h(list, iArr[i3]);
            formatArr[i3] = h;
            if (h.length != 0) {
                i2++;
            }
        }
        return i2;
    }

    public static com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>[] n(int i) {
        return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream[i];
    }

    public static com.google.android.exoplayer2.Format[] p(com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor, java.util.regex.Pattern pattern, com.google.android.exoplayer2.Format format) {
        java.lang.String str = descriptor.value;
        if (str == null) {
            return new com.google.android.exoplayer2.Format[]{format};
        }
        java.lang.String[] split = com.google.android.exoplayer2.util.Util.split(str, com.alipay.sdk.m.u.i.b);
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[split.length];
        for (int i = 0; i < split.length; i++) {
            java.util.regex.Matcher matcher = pattern.matcher(split[i]);
            if (!matcher.matches()) {
                return new com.google.android.exoplayer2.Format[]{format};
            }
            int parseInt = java.lang.Integer.parseInt(matcher.group(1));
            com.google.android.exoplayer2.Format.Builder buildUpon = format.buildUpon();
            java.lang.String str2 = format.id;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 12);
            sb.append(str2);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(parseInt);
            formatArr[i] = buildUpon.setId(sb.toString()).setAccessibilityChannel(parseInt).setLanguage(matcher.group(2)).build();
        }
        return formatArr;
    }

    public final com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> c(com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo trackGroupInfo, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, long j) {
        com.google.android.exoplayer2.source.TrackGroup trackGroup;
        int i;
        com.google.android.exoplayer2.source.TrackGroup trackGroup2;
        int i2;
        int i3 = trackGroupInfo.f;
        boolean z = i3 != -1;
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z) {
            trackGroup = this.A.get(i3);
            i = 1;
        } else {
            trackGroup = null;
            i = 0;
        }
        int i4 = trackGroupInfo.g;
        boolean z2 = i4 != -1;
        if (z2) {
            trackGroup2 = this.A.get(i4);
            i += trackGroup2.length;
        } else {
            trackGroup2 = null;
        }
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[i];
        int[] iArr = new int[i];
        if (z) {
            formatArr[0] = trackGroup.getFormat(0);
            iArr[0] = 4;
            i2 = 1;
        } else {
            i2 = 0;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (z2) {
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                com.google.android.exoplayer2.Format format = trackGroup2.getFormat(i5);
                formatArr[i2] = format;
                iArr[i2] = 3;
                arrayList.add(format);
                i2++;
            }
        }
        if (this.L.dynamic && z) {
            playerTrackEmsgHandler = this.D.newPlayerTrackEmsgHandler();
        }
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream = new com.google.android.exoplayer2.source.chunk.ChunkSampleStream<>(trackGroupInfo.b, iArr, formatArr, this.t.createDashChunkSource(this.y, this.L, this.M, trackGroupInfo.a, trackSelection, trackGroupInfo.b, this.x, z, arrayList, playerTrackEmsgHandler2, this.u), this, this.z, j, this.v, this.G, this.w, this.F);
        synchronized (this) {
            this.E.put(chunkSampleStream, playerTrackEmsgHandler2);
        }
        return chunkSampleStream;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.K.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.I) {
            chunkSampleStream.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.I) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j, seekParameters);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.K.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.K.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public java.util.List<com.google.android.exoplayer2.offline.StreamKey> getStreamKeys(java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection> list) {
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list2 = this.L.getPeriod(this.M).adaptationSets;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : list) {
            com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo trackGroupInfo = this.B[this.A.indexOf(trackSelection.getTrackGroup())];
            if (trackGroupInfo.c == 0) {
                int[] iArr = trackGroupInfo.a;
                int length = trackSelection.length();
                int[] iArr2 = new int[length];
                for (int i = 0; i < trackSelection.length(); i++) {
                    iArr2[i] = trackSelection.getIndexInTrackGroup(i);
                }
                java.util.Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).representations.size();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr2[i4];
                    while (true) {
                        int i6 = i3 + size;
                        if (i5 >= i6) {
                            i2++;
                            size = list2.get(iArr[i2]).representations.size();
                            i3 = i6;
                        }
                    }
                    arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(this.M, iArr[i2], i5 - i3));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.A;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.K.isLoading();
    }

    public final int j(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.B[i2].e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.B[i5].c == 0) {
                return i4;
            }
        }
        return -1;
    }

    public final int[] k(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr) {
        int[] iArr = new int[trackSelectionArr.length];
        for (int i = 0; i < trackSelectionArr.length; i++) {
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArr[i];
            if (trackSelection != null) {
                iArr[i] = this.A.indexOf(trackSelection.getTrackGroup());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        this.y.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream) {
        this.H.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback
    public synchronized void onSampleStreamReleased(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream) {
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.E.remove(chunkSampleStream);
        if (remove != null) {
            remove.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        this.H = callback;
        callback.onPrepared(this);
    }

    public void q() {
        this.D.release();
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.I) {
            chunkSampleStream.release(this);
        }
        this.H = null;
    }

    public final void r(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (trackSelectionArr[i] == null || !zArr[i]) {
                com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i];
                if (sampleStream instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream) {
                    ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStream).release(this);
                } else if (sampleStream instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) {
                    ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) sampleStream).release();
                }
                sampleStreamArr[i] = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.K.reevaluateBuffer(j);
    }

    public final void s(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z;
        for (int i = 0; i < trackSelectionArr.length; i++) {
            com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i];
            if ((sampleStream instanceof com.google.android.exoplayer2.source.EmptySampleStream) || (sampleStream instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream)) {
                int j = j(i, iArr);
                if (j == -1) {
                    z = sampleStreamArr[i] instanceof com.google.android.exoplayer2.source.EmptySampleStream;
                } else {
                    com.google.android.exoplayer2.source.SampleStream sampleStream2 = sampleStreamArr[i];
                    z = (sampleStream2 instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) && ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) sampleStream2).parent == sampleStreamArr[j];
                }
                if (!z) {
                    com.google.android.exoplayer2.source.SampleStream sampleStream3 = sampleStreamArr[i];
                    if (sampleStream3 instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) {
                        ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream) sampleStream3).release();
                    }
                    sampleStreamArr[i] = null;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : this.I) {
            chunkSampleStream.seekToUs(j);
        }
        for (com.google.android.exoplayer2.source.dash.EventSampleStream eventSampleStream : this.J) {
            eventSampleStream.b(j);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int[] k = k(trackSelectionArr);
        r(trackSelectionArr, zArr, sampleStreamArr);
        s(trackSelectionArr, sampleStreamArr, k);
        t(trackSelectionArr, sampleStreamArr, zArr2, j, k);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (com.google.android.exoplayer2.source.SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream) {
                arrayList.add((com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStream);
            } else if (sampleStream instanceof com.google.android.exoplayer2.source.dash.EventSampleStream) {
                arrayList2.add((com.google.android.exoplayer2.source.dash.EventSampleStream) sampleStream);
            }
        }
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>[] n = n(arrayList.size());
        this.I = n;
        arrayList.toArray(n);
        com.google.android.exoplayer2.source.dash.EventSampleStream[] eventSampleStreamArr = new com.google.android.exoplayer2.source.dash.EventSampleStream[arrayList2.size()];
        this.J = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.K = this.C.createCompositeSequenceableLoader(this.I);
        return j;
    }

    public final void t(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr, long j, int[] iArr) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArr[i];
            if (trackSelection != null) {
                com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i];
                if (sampleStream == null) {
                    zArr[i] = true;
                    com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo trackGroupInfo = this.B[iArr[i]];
                    int i2 = trackGroupInfo.c;
                    if (i2 == 0) {
                        sampleStreamArr[i] = c(trackGroupInfo, trackSelection, j);
                    } else if (i2 == 2) {
                        sampleStreamArr[i] = new com.google.android.exoplayer2.source.dash.EventSampleStream(this.N.get(trackGroupInfo.d), trackSelection.getTrackGroup().getFormat(0), this.L.dynamic);
                    }
                } else if (sampleStream instanceof com.google.android.exoplayer2.source.chunk.ChunkSampleStream) {
                    ((com.google.android.exoplayer2.source.dash.DashChunkSource) ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStream).getChunkSource()).updateTrackSelection(trackSelection);
                }
            }
        }
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] == null && trackSelectionArr[i3] != null) {
                com.google.android.exoplayer2.source.dash.DashMediaPeriod.TrackGroupInfo trackGroupInfo2 = this.B[iArr[i3]];
                if (trackGroupInfo2.c == 1) {
                    int j2 = j(i3, iArr);
                    if (j2 == -1) {
                        sampleStreamArr[i3] = new com.google.android.exoplayer2.source.EmptySampleStream();
                    } else {
                        sampleStreamArr[i3] = ((com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStreamArr[j2]).selectEmbeddedTrack(j, trackGroupInfo2.b);
                    }
                }
            }
        }
    }

    public void u(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i) {
        this.L = dashManifest;
        this.M = i;
        this.D.updateManifest(dashManifest);
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource>[] chunkSampleStreamArr = this.I;
        if (chunkSampleStreamArr != null) {
            for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.dash.DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                chunkSampleStream.getChunkSource().updateManifest(dashManifest, i);
            }
            this.H.onContinueLoadingRequested(this);
        }
        this.N = dashManifest.getPeriod(i).eventStreams;
        for (com.google.android.exoplayer2.source.dash.EventSampleStream eventSampleStream : this.J) {
            java.util.Iterator<com.google.android.exoplayer2.source.dash.manifest.EventStream> it = this.N.iterator();
            while (true) {
                if (it.hasNext()) {
                    com.google.android.exoplayer2.source.dash.manifest.EventStream next = it.next();
                    if (next.id().equals(eventSampleStream.a())) {
                        eventSampleStream.c(next, dashManifest.dynamic && i == dashManifest.getPeriodCount() - 1);
                    }
                }
            }
        }
    }
}
