package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class AnimationState {
    public static final com.esotericsoftware.spine.Animation k = new com.esotericsoftware.spine.Animation("<empty>", new com.badlogic.gdx.utils.Array(0), 0.0f);
    public com.esotericsoftware.spine.AnimationStateData a;
    public boolean h;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> b = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> c = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.AnimationStateListener> d = new com.badlogic.gdx.utils.Array<>();
    public final com.esotericsoftware.spine.AnimationState.EventQueue e = new com.esotericsoftware.spine.AnimationState.EventQueue();
    public final com.badlogic.gdx.utils.IntSet f = new com.badlogic.gdx.utils.IntSet();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> g = new com.badlogic.gdx.utils.Array<>();
    public float i = 1.0f;
    public com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.AnimationState.TrackEntry> j = new com.esotericsoftware.spine.AnimationState.AnonymousClass1();

    /* renamed from: com.esotericsoftware.spine.AnimationState$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.utils.Pool {
        public AnonymousClass1() {
        }

        @Override // com.badlogic.gdx.utils.Pool
        public java.lang.Object newObject() {
            return new com.esotericsoftware.spine.AnimationState.TrackEntry();
        }
    }

    /* renamed from: com.esotericsoftware.spine.AnimationState$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.esotericsoftware.spine.AnimationState.EventType.values().length];
            a = iArr;
            try {
                iArr[com.esotericsoftware.spine.AnimationState.EventType.start.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.esotericsoftware.spine.AnimationState.EventType.interrupt.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.esotericsoftware.spine.AnimationState.EventType.end.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.esotericsoftware.spine.AnimationState.EventType.dispose.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.esotericsoftware.spine.AnimationState.EventType.complete.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.esotericsoftware.spine.AnimationState.EventType.event.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public static abstract class AnimationStateAdapter implements com.esotericsoftware.spine.AnimationState.AnimationStateListener {
        @Override // com.esotericsoftware.spine.AnimationState.AnimationStateListener
        public void complete(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
        }

        @Override // com.esotericsoftware.spine.AnimationState.AnimationStateListener
        public void dispose(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
        }

        @Override // com.esotericsoftware.spine.AnimationState.AnimationStateListener
        public void end(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
        }

        @Override // com.esotericsoftware.spine.AnimationState.AnimationStateListener
        public void event(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, com.esotericsoftware.spine.Event event) {
        }

        @Override // com.esotericsoftware.spine.AnimationState.AnimationStateListener
        public void interrupt(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
        }

        @Override // com.esotericsoftware.spine.AnimationState.AnimationStateListener
        public void start(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
        }
    }

    public interface AnimationStateListener {
        void complete(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry);

        void dispose(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry);

        void end(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry);

        void event(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, com.esotericsoftware.spine.Event event);

        void interrupt(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry);

        void start(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry);
    }

    public class EventQueue {
        public final com.badlogic.gdx.utils.Array a = new com.badlogic.gdx.utils.Array();
        public boolean b;

        public EventQueue() {
        }

        public void a() {
            this.a.clear();
        }

        public void b(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
            this.a.add(com.esotericsoftware.spine.AnimationState.EventType.complete);
            this.a.add(trackEntry);
        }

        public void c(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
            this.a.add(com.esotericsoftware.spine.AnimationState.EventType.dispose);
            this.a.add(trackEntry);
        }

        public void d() {
            if (this.b) {
                return;
            }
            this.b = true;
            com.badlogic.gdx.utils.Array array = this.a;
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.AnimationStateListener> array2 = com.esotericsoftware.spine.AnimationState.this.d;
            int i = 0;
            while (i < array.size) {
                com.esotericsoftware.spine.AnimationState.EventType eventType = (com.esotericsoftware.spine.AnimationState.EventType) array.get(i);
                int i2 = i + 1;
                com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry = (com.esotericsoftware.spine.AnimationState.TrackEntry) array.get(i2);
                switch (com.esotericsoftware.spine.AnimationState.AnonymousClass2.a[eventType.ordinal()]) {
                    case 1:
                        com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener = trackEntry.d;
                        if (animationStateListener != null) {
                            animationStateListener.start(trackEntry);
                        }
                        for (int i3 = 0; i3 < array2.size; i3++) {
                            array2.get(i3).start(trackEntry);
                        }
                        continue;
                    case 2:
                        com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener2 = trackEntry.d;
                        if (animationStateListener2 != null) {
                            animationStateListener2.interrupt(trackEntry);
                        }
                        for (int i4 = 0; i4 < array2.size; i4++) {
                            array2.get(i4).interrupt(trackEntry);
                        }
                        continue;
                    case 3:
                        com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener3 = trackEntry.d;
                        if (animationStateListener3 != null) {
                            animationStateListener3.end(trackEntry);
                        }
                        for (int i5 = 0; i5 < array2.size; i5++) {
                            array2.get(i5).end(trackEntry);
                        }
                        break;
                    case 5:
                        com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener4 = trackEntry.d;
                        if (animationStateListener4 != null) {
                            animationStateListener4.complete(trackEntry);
                        }
                        for (int i6 = 0; i6 < array2.size; i6++) {
                            array2.get(i6).complete(trackEntry);
                        }
                        continue;
                    case 6:
                        com.esotericsoftware.spine.Event event = (com.esotericsoftware.spine.Event) array.get(i + 2);
                        com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener5 = trackEntry.d;
                        if (animationStateListener5 != null) {
                            animationStateListener5.event(trackEntry, event);
                        }
                        for (int i7 = 0; i7 < array2.size; i7++) {
                            array2.get(i7).event(trackEntry, event);
                        }
                        i = i2;
                        continue;
                }
                com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener6 = trackEntry.d;
                if (animationStateListener6 != null) {
                    animationStateListener6.dispose(trackEntry);
                }
                for (int i8 = 0; i8 < array2.size; i8++) {
                    array2.get(i8).dispose(trackEntry);
                }
                com.esotericsoftware.spine.AnimationState.this.j.free(trackEntry);
                i += 2;
            }
            a();
            this.b = false;
        }

        public void e(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
            this.a.add(com.esotericsoftware.spine.AnimationState.EventType.end);
            this.a.add(trackEntry);
            com.esotericsoftware.spine.AnimationState.this.h = true;
        }

        public void f(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, com.esotericsoftware.spine.Event event) {
            this.a.add(com.esotericsoftware.spine.AnimationState.EventType.event);
            this.a.add(trackEntry);
            this.a.add(event);
        }

        public void g(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
            this.a.add(com.esotericsoftware.spine.AnimationState.EventType.interrupt);
            this.a.add(trackEntry);
        }

        public void h(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
            this.a.add(com.esotericsoftware.spine.AnimationState.EventType.start);
            this.a.add(trackEntry);
            com.esotericsoftware.spine.AnimationState.this.h = true;
        }
    }

    public enum EventType {
        start,
        interrupt,
        end,
        dispose,
        complete,
        event
    }

    public static class TrackEntry implements com.badlogic.gdx.utils.Pool.Poolable {
        public com.esotericsoftware.spine.Animation a;
        public com.esotericsoftware.spine.AnimationState.TrackEntry b;
        public com.esotericsoftware.spine.AnimationState.TrackEntry c;
        public com.esotericsoftware.spine.AnimationState.AnimationStateListener d;
        public int e;
        public boolean f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
        public float o;
        public float p;
        public float q;
        public float r;

        /* renamed from: s, reason: collision with root package name */
        public float f307s;
        public float t;
        public float u;
        public float v;
        public float w;
        public float x;
        public final com.badlogic.gdx.utils.IntArray y = new com.badlogic.gdx.utils.IntArray();
        public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> z = new com.badlogic.gdx.utils.Array<>();
        public final com.badlogic.gdx.utils.FloatArray A = new com.badlogic.gdx.utils.FloatArray();

        public final boolean a(int i) {
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array = this.a.b;
            com.esotericsoftware.spine.Animation.Timeline[] timelineArr = array.items;
            int i2 = array.size;
            for (int i3 = 0; i3 < i2; i3++) {
                if (timelineArr[i3].getPropertyId() == i) {
                    return true;
                }
            }
            return false;
        }

        public com.esotericsoftware.spine.AnimationState.TrackEntry b(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> array, com.badlogic.gdx.utils.IntSet intSet) {
            if (trackEntry != null) {
                array.add(trackEntry);
            }
            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry2 = this.c;
            com.esotericsoftware.spine.AnimationState.TrackEntry b = trackEntry2 != null ? trackEntry2.b(this, array, intSet) : this;
            if (trackEntry != null) {
                array.pop();
            }
            com.esotericsoftware.spine.AnimationState.TrackEntry[] trackEntryArr = array.items;
            int i = array.size - 1;
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array2 = this.a.b;
            com.esotericsoftware.spine.Animation.Timeline[] timelineArr = array2.items;
            int i2 = array2.size;
            int[] size = this.y.setSize(i2);
            this.z.clear();
            com.esotericsoftware.spine.AnimationState.TrackEntry[] size2 = this.z.setSize(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                int propertyId = timelineArr[i3].getPropertyId();
                if (!intSet.add(propertyId)) {
                    size[i3] = 0;
                } else if (trackEntry == null || !trackEntry.a(propertyId)) {
                    size[i3] = 1;
                } else {
                    int i4 = i;
                    while (true) {
                        if (i4 < 0) {
                            break;
                        }
                        com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry3 = trackEntryArr[i4];
                        if (trackEntry3.a(propertyId)) {
                            i4--;
                        } else if (trackEntry3.v > 0.0f) {
                            size[i3] = 3;
                            size2[i3] = trackEntry3;
                        }
                    }
                    size[i3] = 2;
                }
            }
            return b;
        }

        public float getAlpha() {
            return this.t;
        }

        public com.esotericsoftware.spine.Animation getAnimation() {
            return this.a;
        }

        public float getAnimationEnd() {
            return this.k;
        }

        public float getAnimationLast() {
            return this.l;
        }

        public float getAnimationStart() {
            return this.j;
        }

        public float getAnimationTime() {
            if (!this.f) {
                return java.lang.Math.min(this.o + this.j, this.k);
            }
            float f = this.k;
            float f2 = this.j;
            float f3 = f - f2;
            return f3 == 0.0f ? f2 : (this.o % f3) + f2;
        }

        public float getAttachmentThreshold() {
            return this.h;
        }

        public float getDelay() {
            return this.n;
        }

        public float getDrawOrderThreshold() {
            return this.i;
        }

        public float getEventThreshold() {
            return this.g;
        }

        public com.esotericsoftware.spine.AnimationState.AnimationStateListener getListener() {
            return this.d;
        }

        public boolean getLoop() {
            return this.f;
        }

        public float getMixDuration() {
            return this.v;
        }

        public float getMixTime() {
            return this.u;
        }

        public com.esotericsoftware.spine.AnimationState.TrackEntry getMixingFrom() {
            return this.c;
        }

        public com.esotericsoftware.spine.AnimationState.TrackEntry getNext() {
            return this.b;
        }

        public float getTimeScale() {
            return this.f307s;
        }

        public float getTrackEnd() {
            return this.r;
        }

        public int getTrackIndex() {
            return this.e;
        }

        public float getTrackTime() {
            return this.o;
        }

        public boolean isComplete() {
            return this.o >= this.k - this.j;
        }

        @Override // com.badlogic.gdx.utils.Pool.Poolable
        public void reset() {
            this.b = null;
            this.c = null;
            this.a = null;
            this.d = null;
            this.y.clear();
            this.z.clear();
            this.A.clear();
        }

        public void resetRotationDirections() {
            this.A.clear();
        }

        public void setAlpha(float f) {
            this.t = f;
        }

        public void setAnimation(com.esotericsoftware.spine.Animation animation) {
            this.a = animation;
        }

        public void setAnimationEnd(float f) {
            this.k = f;
        }

        public void setAnimationLast(float f) {
            this.l = f;
            this.m = f;
        }

        public void setAnimationStart(float f) {
            this.j = f;
        }

        public void setAttachmentThreshold(float f) {
            this.h = f;
        }

        public void setDelay(float f) {
            this.n = f;
        }

        public void setDrawOrderThreshold(float f) {
            this.i = f;
        }

        public void setEventThreshold(float f) {
            this.g = f;
        }

        public void setListener(com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener) {
            this.d = animationStateListener;
        }

        public void setLoop(boolean z) {
            this.f = z;
        }

        public void setMixDuration(float f) {
            this.v = f;
        }

        public void setMixTime(float f) {
            this.u = f;
        }

        public void setTimeScale(float f) {
            this.f307s = f;
        }

        public void setTrackEnd(float f) {
            this.r = f;
        }

        public void setTrackTime(float f) {
            this.o = f;
        }

        public java.lang.String toString() {
            com.esotericsoftware.spine.Animation animation = this.a;
            return animation == null ? "<none>" : animation.a;
        }
    }

    public AnimationState() {
    }

    public AnimationState(com.esotericsoftware.spine.AnimationStateData animationStateData) {
        if (animationStateData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        this.a = animationStateData;
    }

    public final void a() {
        this.h = false;
        com.badlogic.gdx.utils.IntSet intSet = this.f;
        intSet.clear();
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> array = this.g;
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry = this.b.get(i2);
            if (trackEntry != null) {
                trackEntry.b(null, array, intSet);
            }
        }
    }

    public com.esotericsoftware.spine.AnimationState.TrackEntry addAnimation(int i, com.esotericsoftware.spine.Animation animation, boolean z, float f) {
        if (animation == null) {
            throw new java.lang.IllegalArgumentException("animation cannot be null.");
        }
        com.esotericsoftware.spine.AnimationState.TrackEntry e = e(i);
        if (e != null) {
            while (true) {
                com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry = e.b;
                if (trackEntry == null) {
                    break;
                }
                e = trackEntry;
            }
        }
        com.esotericsoftware.spine.AnimationState.TrackEntry h = h(i, animation, z, e);
        if (e == null) {
            g(i, h, true);
            this.e.d();
        } else {
            e.b = h;
            if (f <= 0.0f) {
                float f2 = e.k - e.j;
                f = f2 != 0.0f ? f + ((f2 * (((int) (e.o / f2)) + 1)) - this.a.getMix(e.a, animation)) : 0.0f;
            }
        }
        h.n = f;
        return h;
    }

    public com.esotericsoftware.spine.AnimationState.TrackEntry addAnimation(int i, java.lang.String str, boolean z, float f) {
        com.esotericsoftware.spine.Animation findAnimation = this.a.a.findAnimation(str);
        if (findAnimation != null) {
            return addAnimation(i, findAnimation, z, f);
        }
        throw new java.lang.IllegalArgumentException("Animation not found: " + str);
    }

    public com.esotericsoftware.spine.AnimationState.TrackEntry addEmptyAnimation(int i, float f, float f2) {
        if (f2 <= 0.0f) {
            f2 -= f;
        }
        com.esotericsoftware.spine.AnimationState.TrackEntry addAnimation = addAnimation(i, k, false, f2);
        addAnimation.v = f;
        addAnimation.r = f;
        return addAnimation;
    }

    public void addListener(com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener) {
        if (animationStateListener == null) {
            throw new java.lang.IllegalArgumentException("listener cannot be null.");
        }
        this.d.add(animationStateListener);
    }

    public boolean apply(com.esotericsoftware.spine.Skeleton skeleton) {
        float f;
        int i;
        float[] fArr;
        int[] iArr;
        com.esotericsoftware.spine.Animation.MixPose mixPose;
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        if (this.h) {
            a();
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array = this.c;
        int i2 = this.b.size;
        boolean z = false;
        int i3 = 0;
        while (i3 < i2) {
            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry = this.b.get(i3);
            if (trackEntry != null && trackEntry.n <= 0.0f) {
                com.esotericsoftware.spine.Animation.MixPose mixPose2 = i3 == 0 ? com.esotericsoftware.spine.Animation.MixPose.current : com.esotericsoftware.spine.Animation.MixPose.currentLayered;
                float f2 = trackEntry.t;
                float b = trackEntry.c != null ? f2 * b(trackEntry, skeleton, mixPose2) : (trackEntry.o < trackEntry.r || trackEntry.b != null) ? f2 : 0.0f;
                float f3 = trackEntry.l;
                float animationTime = trackEntry.getAnimationTime();
                com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array2 = trackEntry.a.b;
                int i4 = array2.size;
                com.esotericsoftware.spine.Animation.Timeline[] timelineArr = array2.items;
                if (b == 1.0f) {
                    int i5 = 0;
                    while (i5 < i4) {
                        timelineArr[i5].apply(skeleton, f3, animationTime, array, 1.0f, com.esotericsoftware.spine.Animation.MixPose.setup, com.esotericsoftware.spine.Animation.MixDirection.in);
                        i5++;
                        i4 = i4;
                        f3 = f3;
                        timelineArr = timelineArr;
                        animationTime = animationTime;
                    }
                    f = animationTime;
                } else {
                    int[] iArr2 = trackEntry.y.items;
                    com.badlogic.gdx.utils.FloatArray floatArray = trackEntry.A;
                    boolean z2 = floatArray.size == 0;
                    if (z2) {
                        floatArray.setSize(i4 << 1);
                    }
                    float[] fArr2 = trackEntry.A.items;
                    int i6 = 0;
                    while (i6 < i4) {
                        com.esotericsoftware.spine.Animation.Timeline timeline = timelineArr[i6];
                        com.esotericsoftware.spine.Animation.MixPose mixPose3 = iArr2[i6] >= 1 ? com.esotericsoftware.spine.Animation.MixPose.setup : mixPose2;
                        if (timeline instanceof com.esotericsoftware.spine.Animation.RotateTimeline) {
                            i = i6;
                            fArr = fArr2;
                            iArr = iArr2;
                            mixPose = mixPose2;
                            c(timeline, skeleton, animationTime, b, mixPose3, fArr2, i6 << 1, z2);
                        } else {
                            i = i6;
                            fArr = fArr2;
                            iArr = iArr2;
                            mixPose = mixPose2;
                            timeline.apply(skeleton, f3, animationTime, array, b, mixPose3, com.esotericsoftware.spine.Animation.MixDirection.in);
                        }
                        i6 = i + 1;
                        mixPose2 = mixPose;
                        fArr2 = fArr;
                        iArr2 = iArr;
                    }
                    f = animationTime;
                }
                f(trackEntry, f);
                array.clear();
                trackEntry.m = f;
                trackEntry.q = trackEntry.o;
                z = true;
            }
            i3++;
        }
        this.e.d();
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float b(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, com.esotericsoftware.spine.Skeleton skeleton, com.esotericsoftware.spine.Animation.MixPose mixPose) {
        float f;
        int i;
        boolean z;
        int i2;
        float[] fArr;
        com.esotericsoftware.spine.Animation.MixPose mixPose2;
        com.esotericsoftware.spine.AnimationState.TrackEntry[] trackEntryArr;
        int[] iArr;
        com.esotericsoftware.spine.Animation.Timeline[] timelineArr;
        int i3;
        float f2;
        float f3;
        int i4;
        float f4;
        com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry2 = trackEntry.c;
        if (trackEntry2.c != null) {
            b(trackEntry2, skeleton, mixPose);
        }
        float f5 = trackEntry.v;
        if (f5 != 0.0f) {
            float f6 = trackEntry.u / f5;
            if (f6 <= 1.0f) {
                f = f6;
                com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array = f >= trackEntry2.g ? this.c : null;
                boolean z2 = f >= trackEntry2.h;
                boolean z3 = f >= trackEntry2.i;
                float f7 = trackEntry2.l;
                float animationTime = trackEntry2.getAnimationTime();
                com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array2 = trackEntry2.a.b;
                i = array2.size;
                com.esotericsoftware.spine.Animation.Timeline[] timelineArr2 = array2.items;
                int[] iArr2 = trackEntry2.y.items;
                com.esotericsoftware.spine.AnimationState.TrackEntry[] trackEntryArr2 = trackEntry2.z.items;
                com.badlogic.gdx.utils.FloatArray floatArray = trackEntry2.A;
                z = floatArray.size != 0;
                if (z) {
                    floatArray.setSize(i << 1);
                }
                float[] fArr2 = trackEntry2.A.items;
                float f8 = trackEntry2.t * trackEntry.w;
                float f9 = f8 * (1.0f - f);
                trackEntry2.x = 0.0f;
                i2 = 0;
                while (i2 < i) {
                    com.esotericsoftware.spine.Animation.Timeline timeline = timelineArr2[i2];
                    int i5 = iArr2[i2];
                    if (i5 == 0) {
                        fArr = fArr2;
                        if ((z2 || !(timeline instanceof com.esotericsoftware.spine.Animation.AttachmentTimeline)) && (z3 || !(timeline instanceof com.esotericsoftware.spine.Animation.DrawOrderTimeline))) {
                            mixPose2 = mixPose;
                        } else {
                            trackEntryArr = trackEntryArr2;
                            iArr = iArr2;
                            timelineArr = timelineArr2;
                            i3 = i;
                            f2 = animationTime;
                            f3 = f7;
                            i4 = i2;
                            i2 = i4 + 1;
                            animationTime = f2;
                            fArr2 = fArr;
                            trackEntryArr2 = trackEntryArr;
                            iArr2 = iArr;
                            timelineArr2 = timelineArr;
                            i = i3;
                            f7 = f3;
                        }
                    } else if (i5 != 1) {
                        if (i5 != 2) {
                            com.esotericsoftware.spine.Animation.MixPose mixPose3 = com.esotericsoftware.spine.Animation.MixPose.setup;
                            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry3 = trackEntryArr2[i2];
                            fArr = fArr2;
                            float max = java.lang.Math.max(0.0f, 1.0f - (trackEntry3.u / trackEntry3.v)) * f8;
                            mixPose2 = mixPose3;
                            f4 = max;
                        } else {
                            fArr = fArr2;
                            mixPose2 = com.esotericsoftware.spine.Animation.MixPose.setup;
                            f4 = f8;
                        }
                        trackEntry2.x += f4;
                        if (timeline instanceof com.esotericsoftware.spine.Animation.RotateTimeline) {
                            trackEntryArr = trackEntryArr2;
                            iArr = iArr2;
                            timelineArr = timelineArr2;
                            i3 = i;
                            f2 = animationTime;
                            f3 = f7;
                            i4 = i2;
                            timeline.apply(skeleton, f3, f2, array, f4, mixPose2, com.esotericsoftware.spine.Animation.MixDirection.out);
                        } else {
                            trackEntryArr = trackEntryArr2;
                            iArr = iArr2;
                            timelineArr = timelineArr2;
                            i3 = i;
                            f3 = f7;
                            i4 = i2;
                            c(timeline, skeleton, animationTime, f4, mixPose2, fArr, i2 << 1, z);
                            f2 = animationTime;
                        }
                        i2 = i4 + 1;
                        animationTime = f2;
                        fArr2 = fArr;
                        trackEntryArr2 = trackEntryArr;
                        iArr2 = iArr;
                        timelineArr2 = timelineArr;
                        i = i3;
                        f7 = f3;
                    } else {
                        fArr = fArr2;
                        mixPose2 = com.esotericsoftware.spine.Animation.MixPose.setup;
                    }
                    f4 = f9;
                    trackEntry2.x += f4;
                    if (timeline instanceof com.esotericsoftware.spine.Animation.RotateTimeline) {
                    }
                    i2 = i4 + 1;
                    animationTime = f2;
                    fArr2 = fArr;
                    trackEntryArr2 = trackEntryArr;
                    iArr2 = iArr;
                    timelineArr2 = timelineArr;
                    i = i3;
                    f7 = f3;
                }
                float f10 = animationTime;
                if (trackEntry.v > 0.0f) {
                    f(trackEntry2, f10);
                }
                this.c.clear();
                trackEntry2.m = f10;
                trackEntry2.q = trackEntry2.o;
                return f;
            }
        }
        f = 1.0f;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array3 = f >= trackEntry2.g ? this.c : null;
        if (f >= trackEntry2.h) {
        }
        if (f >= trackEntry2.i) {
        }
        float f72 = trackEntry2.l;
        float animationTime2 = trackEntry2.getAnimationTime();
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Animation.Timeline> array22 = trackEntry2.a.b;
        i = array22.size;
        com.esotericsoftware.spine.Animation.Timeline[] timelineArr22 = array22.items;
        int[] iArr22 = trackEntry2.y.items;
        com.esotericsoftware.spine.AnimationState.TrackEntry[] trackEntryArr22 = trackEntry2.z.items;
        com.badlogic.gdx.utils.FloatArray floatArray2 = trackEntry2.A;
        if (floatArray2.size != 0) {
        }
        if (z) {
        }
        float[] fArr22 = trackEntry2.A.items;
        float f82 = trackEntry2.t * trackEntry.w;
        float f92 = f82 * (1.0f - f);
        trackEntry2.x = 0.0f;
        i2 = 0;
        while (i2 < i) {
        }
        float f102 = animationTime2;
        if (trackEntry.v > 0.0f) {
        }
        this.c.clear();
        trackEntry2.m = f102;
        trackEntry2.q = trackEntry2.o;
        return f;
    }

    public final void c(com.esotericsoftware.spine.Animation.Timeline timeline, com.esotericsoftware.spine.Skeleton skeleton, float f, float f2, com.esotericsoftware.spine.Animation.MixPose mixPose, float[] fArr, int i, boolean z) {
        float curvePercent;
        float f3;
        float f4;
        float f5;
        if (z) {
            fArr[i] = 0.0f;
        }
        if (f2 == 1.0f) {
            timeline.apply(skeleton, 0.0f, f, null, 1.0f, mixPose, com.esotericsoftware.spine.Animation.MixDirection.in);
            return;
        }
        com.esotericsoftware.spine.Animation.RotateTimeline rotateTimeline = (com.esotericsoftware.spine.Animation.RotateTimeline) timeline;
        com.esotericsoftware.spine.Bone bone = skeleton.b.get(rotateTimeline.b);
        float[] fArr2 = rotateTimeline.c;
        if (f < fArr2[0]) {
            if (mixPose == com.esotericsoftware.spine.Animation.MixPose.setup) {
                bone.g = bone.a.g;
                return;
            }
            return;
        }
        if (f >= fArr2[fArr2.length - 2]) {
            curvePercent = bone.a.g + fArr2[fArr2.length - 1];
        } else {
            int b = com.esotericsoftware.spine.Animation.b(fArr2, f, 2);
            float f6 = fArr2[b - 1];
            float f7 = fArr2[b];
            curvePercent = ((f6 + (((fArr2[b + 1] - f6) - ((16384 - ((int) (16384.499999999996d - (r2 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE)) * rotateTimeline.getCurvePercent((b >> 1) - 1, 1.0f - ((f - f7) / (fArr2[b - 2] - f7))))) + bone.a.g) - ((16384 - ((int) (16384.499999999996d - (r9 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE);
        }
        float f8 = mixPose == com.esotericsoftware.spine.Animation.MixPose.setup ? bone.a.g : bone.g;
        float f9 = curvePercent - f8;
        if (f9 == 0.0f) {
            f5 = fArr[i];
        } else {
            f9 -= (16384 - ((int) (16384.499999999996d - (f9 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            if (z) {
                f4 = f9;
                f3 = 0.0f;
            } else {
                f3 = fArr[i];
                f4 = fArr[i + 1];
            }
            boolean z2 = f9 > 0.0f;
            boolean z3 = f3 >= 0.0f;
            if (java.lang.Math.signum(f4) != java.lang.Math.signum(f9) && java.lang.Math.abs(f4) <= 90.0f) {
                if (java.lang.Math.abs(f3) > 180.0f) {
                    f3 += java.lang.Math.signum(f3) * 360.0f;
                }
                z3 = z2;
            }
            f5 = (f9 + f3) - (f3 % 360.0f);
            if (z3 != z2) {
                f5 += java.lang.Math.signum(f3) * 360.0f;
            }
            fArr[i] = f5;
        }
        fArr[i + 1] = f9;
        bone.g = (f8 + (f5 * f2)) - ((16384 - ((int) (16384.499999999996d - (r2 / 360.0f)))) * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE);
    }

    public void clearListenerNotifications() {
        this.e.a();
    }

    public void clearListeners() {
        this.d.clear();
    }

    public void clearTrack(int i) {
        com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> array = this.b;
        if (i >= array.size || (trackEntry = array.get(i)) == null) {
            return;
        }
        this.e.e(trackEntry);
        d(trackEntry);
        com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry2 = trackEntry;
        while (true) {
            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry3 = trackEntry2.c;
            if (trackEntry3 == null) {
                this.b.set(trackEntry.e, null);
                this.e.d();
                return;
            } else {
                this.e.e(trackEntry3);
                trackEntry2.c = null;
                trackEntry2 = trackEntry3;
            }
        }
    }

    public void clearTracks() {
        com.esotericsoftware.spine.AnimationState.EventQueue eventQueue = this.e;
        boolean z = eventQueue.b;
        eventQueue.b = true;
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            clearTrack(i2);
        }
        this.b.clear();
        com.esotericsoftware.spine.AnimationState.EventQueue eventQueue2 = this.e;
        eventQueue2.b = z;
        eventQueue2.d();
    }

    public final void d(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
        for (com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry2 = trackEntry.b; trackEntry2 != null; trackEntry2 = trackEntry2.b) {
            this.e.c(trackEntry2);
        }
        trackEntry.b = null;
    }

    public final com.esotericsoftware.spine.AnimationState.TrackEntry e(int i) {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> array = this.b;
        int i2 = array.size;
        if (i < i2) {
            return array.get(i);
        }
        array.ensureCapacity((i - i2) + 1);
        this.b.size = i + 1;
        return null;
    }

    public final void f(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, float f) {
        float f2 = trackEntry.j;
        float f3 = trackEntry.k;
        float f4 = f3 - f2;
        float f5 = trackEntry.p % f4;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Event> array = this.c;
        int i = array.size;
        int i2 = 0;
        while (i2 < i) {
            com.esotericsoftware.spine.Event event = array.get(i2);
            float f6 = event.e;
            if (f6 < f5) {
                break;
            }
            if (f6 <= f3) {
                this.e.f(trackEntry, event);
            }
            i2++;
        }
        if (!trackEntry.f ? !(f < f3 || trackEntry.l >= f3) : f5 > trackEntry.o % f4) {
            this.e.b(trackEntry);
        }
        while (i2 < i) {
            if (array.get(i2).e >= f2) {
                this.e.f(trackEntry, array.get(i2));
            }
            i2++;
        }
    }

    public final void g(int i, com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, boolean z) {
        com.esotericsoftware.spine.AnimationState.TrackEntry e = e(i);
        this.b.set(i, trackEntry);
        if (e != null) {
            if (z) {
                this.e.g(e);
            }
            trackEntry.c = e;
            trackEntry.u = 0.0f;
            if (e.c != null) {
                float f = e.v;
                if (f > 0.0f) {
                    trackEntry.w *= java.lang.Math.min(1.0f, e.u / f);
                }
            }
            e.A.clear();
        }
        this.e.h(trackEntry);
    }

    public com.esotericsoftware.spine.AnimationState.TrackEntry getCurrent(int i) {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> array = this.b;
        if (i >= array.size) {
            return null;
        }
        return array.get(i);
    }

    public com.esotericsoftware.spine.AnimationStateData getData() {
        return this.a;
    }

    public float getTimeScale() {
        return this.i;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.AnimationState.TrackEntry> getTracks() {
        return this.b;
    }

    public final com.esotericsoftware.spine.AnimationState.TrackEntry h(int i, com.esotericsoftware.spine.Animation animation, boolean z, com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry) {
        com.esotericsoftware.spine.AnimationState.TrackEntry obtain = this.j.obtain();
        obtain.e = i;
        obtain.a = animation;
        obtain.f = z;
        obtain.g = 0.0f;
        obtain.h = 0.0f;
        obtain.i = 0.0f;
        obtain.j = 0.0f;
        obtain.k = animation.getDuration();
        obtain.l = -1.0f;
        obtain.m = -1.0f;
        obtain.n = 0.0f;
        obtain.o = 0.0f;
        obtain.p = -1.0f;
        obtain.q = -1.0f;
        obtain.r = Float.MAX_VALUE;
        obtain.f307s = 1.0f;
        obtain.t = 1.0f;
        obtain.w = 1.0f;
        obtain.u = 0.0f;
        obtain.v = trackEntry != null ? this.a.getMix(trackEntry.a, animation) : 0.0f;
        return obtain;
    }

    public final boolean i(com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry, float f) {
        com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry2 = trackEntry.c;
        if (trackEntry2 == null) {
            return true;
        }
        boolean i = i(trackEntry2, f);
        float f2 = trackEntry.u;
        if (f2 > 0.0f) {
            float f3 = trackEntry.v;
            if (f2 >= f3 || trackEntry.f307s == 0.0f) {
                if (trackEntry2.x == 0.0f || f3 == 0.0f) {
                    trackEntry.c = trackEntry2.c;
                    trackEntry.w = trackEntry2.w;
                    this.e.e(trackEntry2);
                }
                return i;
            }
        }
        trackEntry2.l = trackEntry2.m;
        trackEntry2.p = trackEntry2.q;
        trackEntry2.o += trackEntry2.f307s * f;
        trackEntry.u = f2 + (f * trackEntry.f307s);
        return false;
    }

    public void removeListener(com.esotericsoftware.spine.AnimationState.AnimationStateListener animationStateListener) {
        this.d.removeValue(animationStateListener, true);
    }

    public com.esotericsoftware.spine.AnimationState.TrackEntry setAnimation(int i, com.esotericsoftware.spine.Animation animation, boolean z) {
        boolean z2;
        if (animation == null) {
            throw new java.lang.IllegalArgumentException("animation cannot be null.");
        }
        com.esotericsoftware.spine.AnimationState.TrackEntry e = e(i);
        if (e != null) {
            if (e.q == -1.0f) {
                this.b.set(i, e.c);
                this.e.g(e);
                this.e.e(e);
                d(e);
                e = e.c;
                z2 = false;
                com.esotericsoftware.spine.AnimationState.TrackEntry h = h(i, animation, z, e);
                g(i, h, z2);
                this.e.d();
                return h;
            }
            d(e);
        }
        z2 = true;
        com.esotericsoftware.spine.AnimationState.TrackEntry h2 = h(i, animation, z, e);
        g(i, h2, z2);
        this.e.d();
        return h2;
    }

    public com.esotericsoftware.spine.AnimationState.TrackEntry setAnimation(int i, java.lang.String str, boolean z) {
        com.esotericsoftware.spine.Animation findAnimation = this.a.a.findAnimation(str);
        if (findAnimation != null) {
            return setAnimation(i, findAnimation, z);
        }
        throw new java.lang.IllegalArgumentException("Animation not found: " + str);
    }

    public void setData(com.esotericsoftware.spine.AnimationStateData animationStateData) {
        if (animationStateData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        this.a = animationStateData;
    }

    public com.esotericsoftware.spine.AnimationState.TrackEntry setEmptyAnimation(int i, float f) {
        com.esotericsoftware.spine.AnimationState.TrackEntry animation = setAnimation(i, k, false);
        animation.v = f;
        animation.r = f;
        return animation;
    }

    public void setEmptyAnimations(float f) {
        com.esotericsoftware.spine.AnimationState.EventQueue eventQueue = this.e;
        boolean z = eventQueue.b;
        eventQueue.b = true;
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry = this.b.get(i2);
            if (trackEntry != null) {
                setEmptyAnimation(trackEntry.e, f);
            }
        }
        com.esotericsoftware.spine.AnimationState.EventQueue eventQueue2 = this.e;
        eventQueue2.b = z;
        eventQueue2.d();
    }

    public void setTimeScale(float f) {
        this.i = f;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry = this.b.get(i2);
            if (trackEntry != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(trackEntry.toString());
            }
        }
        return sb.length() == 0 ? "<none>" : sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0086 A[LOOP:2: B:26:0x0084->B:27:0x0086, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(float f) {
        com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry;
        float f2 = f * this.i;
        int i = this.b.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry2 = this.b.get(i2);
            if (trackEntry2 != null) {
                trackEntry2.l = trackEntry2.m;
                float f3 = trackEntry2.q;
                trackEntry2.p = f3;
                float f4 = trackEntry2.f307s * f2;
                float f5 = trackEntry2.n;
                if (f5 > 0.0f) {
                    float f6 = f5 - f4;
                    trackEntry2.n = f6;
                    if (f6 <= 0.0f) {
                        f4 = -f6;
                        trackEntry2.n = 0.0f;
                    }
                }
                com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry3 = trackEntry2.b;
                if (trackEntry3 != null) {
                    float f7 = f3 - trackEntry3.n;
                    if (f7 >= 0.0f) {
                        trackEntry3.n = 0.0f;
                        trackEntry3.o = f7 + (trackEntry3.f307s * f2);
                        trackEntry2.o += f4;
                        g(i2, trackEntry3, true);
                        while (true) {
                            com.esotericsoftware.spine.AnimationState.TrackEntry trackEntry4 = trackEntry3.c;
                            if (trackEntry4 != null) {
                                trackEntry3.u += f4;
                                trackEntry3 = trackEntry4;
                            }
                        }
                    }
                    if (trackEntry2.c != null && i(trackEntry2, f2)) {
                        trackEntry2.c = null;
                        for (trackEntry = trackEntry2.c; trackEntry != null; trackEntry = trackEntry.c) {
                            this.e.e(trackEntry);
                        }
                    }
                    trackEntry2.o += f4;
                } else {
                    if (f3 >= trackEntry2.r && trackEntry2.c == null) {
                        this.b.set(i2, null);
                        this.e.e(trackEntry2);
                        d(trackEntry2);
                    }
                    if (trackEntry2.c != null) {
                        trackEntry2.c = null;
                        while (trackEntry != null) {
                        }
                    }
                    trackEntry2.o += f4;
                }
            }
        }
        this.e.d();
    }
}
