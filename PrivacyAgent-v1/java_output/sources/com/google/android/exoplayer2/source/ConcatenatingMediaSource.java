package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class ConcatenatingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> {
    public static final com.google.android.exoplayer2.MediaItem N = new com.google.android.exoplayer2.MediaItem.Builder().setUri(android.net.Uri.EMPTY).build();

    @androidx.annotation.GuardedBy("this")
    public final java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> B;

    @androidx.annotation.GuardedBy("this")
    public final java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> C;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    public android.os.Handler D;
    public final java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> E;
    public final java.util.IdentityHashMap<com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> F;
    public final java.util.Map<java.lang.Object, com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> G;
    public final java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> H;
    public final boolean I;
    public final boolean J;
    public boolean K;
    public java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> L;
    public com.google.android.exoplayer2.source.ShuffleOrder M;

    public static final class ConcatenatedTimeline extends com.google.android.exoplayer2.AbstractConcatenatedTimeline {
        public final int d;
        public final int e;
        public final int[] f;
        public final int[] g;
        public final com.google.android.exoplayer2.Timeline[] h;
        public final java.lang.Object[] i;
        public final java.util.HashMap<java.lang.Object, java.lang.Integer> j;

        public ConcatenatedTimeline(java.util.Collection<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> collection, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, boolean z) {
            super(z, shuffleOrder);
            int size = collection.size();
            this.f = new int[size];
            this.g = new int[size];
            this.h = new com.google.android.exoplayer2.Timeline[size];
            this.i = new java.lang.Object[size];
            this.j = new java.util.HashMap<>();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder : collection) {
                this.h[i3] = mediaSourceHolder.a.getTimeline();
                this.g[i3] = i;
                this.f[i3] = i2;
                i += this.h[i3].getWindowCount();
                i2 += this.h[i3].getPeriodCount();
                java.lang.Object[] objArr = this.i;
                java.lang.Object obj = mediaSourceHolder.b;
                objArr[i3] = obj;
                this.j.put(obj, java.lang.Integer.valueOf(i3));
                i3++;
            }
            this.d = i;
            this.e = i2;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(java.lang.Object obj) {
            java.lang.Integer num = this.j.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.f, i + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.g, i + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public java.lang.Object getChildUidByChildIndex(int i) {
            return this.i[i];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            return this.f[i];
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            return this.g[i];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.e;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public com.google.android.exoplayer2.Timeline getTimelineByChildIndex(int i) {
            return this.h[i];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.d;
        }
    }

    public static final class FakeMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource {
        public FakeMediaSource() {
        }

        public /* synthetic */ FakeMediaSource(com.google.android.exoplayer2.source.ConcatenatingMediaSource.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public com.google.android.exoplayer2.MediaItem getMediaItem() {
            return com.google.android.exoplayer2.source.ConcatenatingMediaSource.N;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void maybeThrowSourceInfoRefreshError() {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        public void releaseSourceInternal() {
        }
    }

    public static final class HandlerAndRunnable {
        public final android.os.Handler a;
        public final java.lang.Runnable b;

        public HandlerAndRunnable(android.os.Handler handler, java.lang.Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        public void a() {
            this.a.post(this.b);
        }
    }

    public static final class MediaSourceHolder {
        public final com.google.android.exoplayer2.source.MaskingMediaSource a;
        public int d;
        public int e;
        public boolean f;
        public final java.util.List<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> c = new java.util.ArrayList();
        public final java.lang.Object b = new java.lang.Object();

        public MediaSourceHolder(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z) {
            this.a = new com.google.android.exoplayer2.source.MaskingMediaSource(mediaSource, z);
        }

        public void a(int i, int i2) {
            this.d = i;
            this.e = i2;
            this.f = false;
            this.c.clear();
        }
    }

    public static final class MessageData<T> {
        public final int a;
        public final T b;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable c;

        public MessageData(int i, T t, @androidx.annotation.Nullable com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable handlerAndRunnable) {
            this.a = i;
            this.b = t;
            this.c = handlerAndRunnable;
        }
    }

    public ConcatenatingMediaSource(boolean z, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(z, false, shuffleOrder, mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z, boolean z2, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        for (com.google.android.exoplayer2.source.MediaSource mediaSource : mediaSourceArr) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaSource);
        }
        this.M = shuffleOrder.getLength() > 0 ? shuffleOrder.cloneAndClear() : shuffleOrder;
        this.F = new java.util.IdentityHashMap<>();
        this.G = new java.util.HashMap();
        this.B = new java.util.ArrayList();
        this.E = new java.util.ArrayList();
        this.L = new java.util.HashSet();
        this.C = new java.util.HashSet();
        this.H = new java.util.HashSet();
        this.I = z;
        this.J = z2;
        addMediaSources(java.util.Arrays.asList(mediaSourceArr));
    }

    public ConcatenatingMediaSource(boolean z, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(z, new com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    public ConcatenatingMediaSource(com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public static java.lang.Object m(java.lang.Object obj) {
        return com.google.android.exoplayer2.AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(obj);
    }

    public static java.lang.Object n(java.lang.Object obj) {
        return com.google.android.exoplayer2.AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    public static java.lang.Object o(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, java.lang.Object obj) {
        return com.google.android.exoplayer2.AbstractConcatenatedTimeline.getConcatenatedUid(mediaSourceHolder.b, obj);
    }

    public final void A() {
        this.K = false;
        java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> set = this.L;
        this.L = new java.util.HashSet();
        refreshSourceInfo(new com.google.android.exoplayer2.source.ConcatenatingMediaSource.ConcatenatedTimeline(this.E, this.M, this.I));
        p().obtainMessage(5, set).sendToTarget();
    }

    public synchronized void addMediaSource(int i, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        g(i, java.util.Collections.singletonList(mediaSource), null, null);
    }

    public synchronized void addMediaSource(int i, com.google.android.exoplayer2.source.MediaSource mediaSource, android.os.Handler handler, java.lang.Runnable runnable) {
        g(i, java.util.Collections.singletonList(mediaSource), handler, runnable);
    }

    public synchronized void addMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        addMediaSource(this.B.size(), mediaSource);
    }

    public synchronized void addMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, android.os.Handler handler, java.lang.Runnable runnable) {
        addMediaSource(this.B.size(), mediaSource, handler, runnable);
    }

    public synchronized void addMediaSources(int i, java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection) {
        g(i, collection, null, null);
    }

    public synchronized void addMediaSources(int i, java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection, android.os.Handler handler, java.lang.Runnable runnable) {
        g(i, collection, handler, runnable);
    }

    public synchronized void addMediaSources(java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection) {
        g(this.B.size(), collection, null, null);
    }

    public synchronized void addMediaSources(java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection, android.os.Handler handler, java.lang.Runnable runnable) {
        g(this.B.size(), collection, handler, runnable);
    }

    public synchronized void clear() {
        removeMediaSourceRange(0, getSize());
    }

    public synchronized void clear(android.os.Handler handler, java.lang.Runnable runnable) {
        removeMediaSourceRange(0, getSize(), handler, runnable);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        java.lang.Object n = n(mediaPeriodId.periodUid);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(m(mediaPeriodId.periodUid));
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder = this.G.get(n);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder(new com.google.android.exoplayer2.source.ConcatenatingMediaSource.FakeMediaSource(null), this.J);
            mediaSourceHolder.f = true;
            prepareChildSource(mediaSourceHolder, mediaSourceHolder.a);
        }
        l(mediaSourceHolder);
        mediaSourceHolder.c.add(copyWithPeriodUid);
        com.google.android.exoplayer2.source.MaskingMediaPeriod createPeriod = mediaSourceHolder.a.createPeriod(copyWithPeriodUid, allocator, j);
        this.F.put(createPeriod, mediaSourceHolder);
        j();
        return createPeriod;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void disableInternal() {
        super.disableInternal();
        this.H.clear();
    }

    public final void e(int i, com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder) {
        if (i > 0) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder2 = this.E.get(i - 1);
            mediaSourceHolder.a(i, mediaSourceHolder2.e + mediaSourceHolder2.a.getTimeline().getWindowCount());
        } else {
            mediaSourceHolder.a(i, 0);
        }
        h(i, 1, mediaSourceHolder.a.getTimeline().getWindowCount());
        this.E.add(i, mediaSourceHolder);
        this.G.put(mediaSourceHolder.b, mediaSourceHolder);
        prepareChildSource(mediaSourceHolder, mediaSourceHolder.a);
        if (isEnabled() && this.F.isEmpty()) {
            this.H.add(mediaSourceHolder);
        } else {
            disableChildSource(mediaSourceHolder);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void enableInternal() {
    }

    public final void f(int i, java.util.Collection<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> collection) {
        java.util.Iterator<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> it = collection.iterator();
        while (it.hasNext()) {
            e(i, it.next());
            i++;
        }
    }

    @androidx.annotation.GuardedBy("this")
    public final void g(int i, java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.D;
        java.util.Iterator<com.google.android.exoplayer2.source.MediaSource> it = collection.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(it.next());
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<com.google.android.exoplayer2.source.MediaSource> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder(it2.next(), this.J));
        }
        this.B.addAll(i, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(i, arrayList, i(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public synchronized com.google.android.exoplayer2.Timeline getInitialTimeline() {
        return new com.google.android.exoplayer2.source.ConcatenatingMediaSource.ConcatenatedTimeline(this.B, this.M.getLength() != this.B.size() ? this.M.cloneAndClear().cloneAndInsert(0, this.B.size()) : this.M, this.I);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return N;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < mediaSourceHolder.c.size(); i++) {
            if (mediaSourceHolder.c.get(i).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(o(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    public synchronized com.google.android.exoplayer2.source.MediaSource getMediaSource(int i) {
        return this.B.get(i).a;
    }

    public synchronized int getSize() {
        return this.B.size();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public int getWindowIndexForChildWindowIndex(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, int i) {
        return i + mediaSourceHolder.e;
    }

    public final void h(int i, int i2, int i3) {
        while (i < this.E.size()) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder = this.E.get(i);
            mediaSourceHolder.d += i2;
            mediaSourceHolder.e += i3;
            i++;
        }
    }

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    public final com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable i(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable handlerAndRunnable = new com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable(handler, runnable);
        this.C.add(handlerAndRunnable);
        return handlerAndRunnable;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    public final void j() {
        java.util.Iterator<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> it = this.H.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder next = it.next();
            if (next.c.isEmpty()) {
                disableChildSource(next);
                it.remove();
            }
        }
    }

    public final synchronized void k(java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> set) {
        java.util.Iterator<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> it = set.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.C.removeAll(set);
    }

    public final void l(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder) {
        this.H.add(mediaSourceHolder);
        enableChildSource(mediaSourceHolder);
    }

    public synchronized void moveMediaSource(int i, int i2) {
        t(i, i2, null, null);
    }

    public synchronized void moveMediaSource(int i, int i2, android.os.Handler handler, java.lang.Runnable runnable) {
        t(i, i2, handler, runnable);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        z(mediaSourceHolder, timeline);
    }

    public final android.os.Handler p() {
        return (android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.D);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.D = new android.os.Handler(new defpackage.as(this));
        if (this.B.isEmpty()) {
            A();
        } else {
            this.M = this.M.cloneAndInsert(0, this.B.size());
            f(0, this.B);
            w();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean q(android.os.Message message) {
        int i = message.what;
        if (i == 0) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            this.M = this.M.cloneAndInsert(messageData.a, ((java.util.Collection) messageData.b).size());
            f(messageData.a, (java.util.Collection) messageData.b);
            x(messageData.c);
        } else if (i == 1) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData2 = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            int i2 = messageData2.a;
            int intValue = ((java.lang.Integer) messageData2.b).intValue();
            if (i2 == 0 && intValue == this.M.getLength()) {
                this.M = this.M.cloneAndClear();
            } else {
                this.M = this.M.cloneAndRemove(i2, intValue);
            }
            for (int i3 = intValue - 1; i3 >= i2; i3--) {
                u(i3);
            }
            x(messageData2.c);
        } else if (i == 2) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData3 = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder = this.M;
            int i4 = messageData3.a;
            com.google.android.exoplayer2.source.ShuffleOrder cloneAndRemove = shuffleOrder.cloneAndRemove(i4, i4 + 1);
            this.M = cloneAndRemove;
            this.M = cloneAndRemove.cloneAndInsert(((java.lang.Integer) messageData3.b).intValue(), 1);
            s(messageData3.a, ((java.lang.Integer) messageData3.b).intValue());
            x(messageData3.c);
        } else if (i == 3) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData4 = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            this.M = (com.google.android.exoplayer2.source.ShuffleOrder) messageData4.b;
            x(messageData4.c);
        } else if (i == 4) {
            A();
        } else {
            if (i != 5) {
                throw new java.lang.IllegalStateException();
            }
            k((java.util.Set) com.google.android.exoplayer2.util.Util.castNonNull(message.obj));
        }
        return true;
    }

    public final void r(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f && mediaSourceHolder.c.isEmpty()) {
            this.H.remove(mediaSourceHolder);
            releaseChildSource(mediaSourceHolder);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.F.remove(mediaPeriod));
        mediaSourceHolder.a.releasePeriod(mediaPeriod);
        mediaSourceHolder.c.remove(((com.google.android.exoplayer2.source.MaskingMediaPeriod) mediaPeriod).id);
        if (!this.F.isEmpty()) {
            j();
        }
        r(mediaSourceHolder);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.E.clear();
        this.H.clear();
        this.G.clear();
        this.M = this.M.cloneAndClear();
        android.os.Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.D = null;
        }
        this.K = false;
        this.L.clear();
        k(this.C);
    }

    public synchronized com.google.android.exoplayer2.source.MediaSource removeMediaSource(int i) {
        com.google.android.exoplayer2.source.MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        v(i, i + 1, null, null);
        return mediaSource;
    }

    public synchronized com.google.android.exoplayer2.source.MediaSource removeMediaSource(int i, android.os.Handler handler, java.lang.Runnable runnable) {
        com.google.android.exoplayer2.source.MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        v(i, i + 1, handler, runnable);
        return mediaSource;
    }

    public synchronized void removeMediaSourceRange(int i, int i2) {
        v(i, i2, null, null);
    }

    public synchronized void removeMediaSourceRange(int i, int i2, android.os.Handler handler, java.lang.Runnable runnable) {
        v(i, i2, handler, runnable);
    }

    public final void s(int i, int i2) {
        int min = java.lang.Math.min(i, i2);
        int max = java.lang.Math.max(i, i2);
        int i3 = this.E.get(min).e;
        java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> list = this.E;
        list.add(i2, list.remove(i));
        while (min <= max) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder = this.E.get(min);
            mediaSourceHolder.d = min;
            mediaSourceHolder.e = i3;
            i3 += mediaSourceHolder.a.getTimeline().getWindowCount();
            min++;
        }
    }

    public synchronized void setShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        y(shuffleOrder, null, null);
    }

    public synchronized void setShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, android.os.Handler handler, java.lang.Runnable runnable) {
        y(shuffleOrder, handler, runnable);
    }

    @androidx.annotation.GuardedBy("this")
    public final void t(int i, int i2, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.D;
        java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> list = this.B;
        list.add(i2, list.remove(i));
        if (handler2 != null) {
            handler2.obtainMessage(2, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(i, java.lang.Integer.valueOf(i2), i(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    public final void u(int i) {
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder remove = this.E.remove(i);
        this.G.remove(remove.b);
        h(i, -1, -remove.a.getTimeline().getWindowCount());
        remove.f = true;
        r(remove);
    }

    @androidx.annotation.GuardedBy("this")
    public final void v(int i, int i2, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.D;
        com.google.android.exoplayer2.util.Util.removeRange(this.B, i, i2);
        if (handler2 != null) {
            handler2.obtainMessage(1, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(i, java.lang.Integer.valueOf(i2), i(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    public final void w() {
        x(null);
    }

    public final void x(@androidx.annotation.Nullable com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable handlerAndRunnable) {
        if (!this.K) {
            p().obtainMessage(4).sendToTarget();
            this.K = true;
        }
        if (handlerAndRunnable != null) {
            this.L.add(handlerAndRunnable);
        }
    }

    @androidx.annotation.GuardedBy("this")
    public final void y(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.D;
        if (handler2 != null) {
            int size = getSize();
            if (shuffleOrder.getLength() != size) {
                shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, size);
            }
            handler2.obtainMessage(3, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(0, shuffleOrder, i(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder.getLength() > 0) {
            shuffleOrder = shuffleOrder.cloneAndClear();
        }
        this.M = shuffleOrder;
        if (runnable == null || handler == null) {
            return;
        }
        handler.post(runnable);
    }

    public final void z(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, com.google.android.exoplayer2.Timeline timeline) {
        if (mediaSourceHolder.d + 1 < this.E.size()) {
            int windowCount = timeline.getWindowCount() - (this.E.get(mediaSourceHolder.d + 1).e - mediaSourceHolder.e);
            if (windowCount != 0) {
                h(mediaSourceHolder.d + 1, 0, windowCount);
            }
        }
        w();
    }
}
