package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DefaultBandwidthMeter implements com.google.android.exoplayer2.upstream.BandwidthMeter, com.google.android.exoplayer2.upstream.TransferListener {
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.upstream.DefaultBandwidthMeter p;

    @androidx.annotation.Nullable
    public final android.content.Context a;
    public final com.google.common.collect.ImmutableMap<java.lang.Integer, java.lang.Long> b;
    public final com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher c;
    public final com.google.android.exoplayer2.util.SlidingPercentile d;
    public final com.google.android.exoplayer2.util.Clock e;
    public int f;
    public long g;
    public long h;
    public int i;
    public long j;
    public long k;
    public long l;
    public long m;
    public boolean n;
    public int o;
    public static final com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.Integer> DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = b();
    public static final com.google.common.collect.ImmutableList<java.lang.Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = com.google.common.collect.ImmutableList.of(6100000L, 3800000L, 2100000L, 1300000L, 590000L);
    public static final com.google.common.collect.ImmutableList<java.lang.Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = com.google.common.collect.ImmutableList.of(218000L, 159000L, 145000L, 130000L, 112000L);
    public static final com.google.common.collect.ImmutableList<java.lang.Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = com.google.common.collect.ImmutableList.of(2200000L, 1300000L, 930000L, 730000L, 530000L);
    public static final com.google.common.collect.ImmutableList<java.lang.Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = com.google.common.collect.ImmutableList.of(4800000L, 2700000L, 1800000L, (long) java.lang.Long.valueOf(com.igexin.push.config.c.g), 630000L);
    public static final com.google.common.collect.ImmutableList<java.lang.Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = com.google.common.collect.ImmutableList.of(12000000L, 8800000L, 5900000L, 3500000L, 1800000L);

    public static final class Builder {

        @androidx.annotation.Nullable
        public final android.content.Context a;
        public java.util.Map<java.lang.Integer, java.lang.Long> b;
        public int c;
        public com.google.android.exoplayer2.util.Clock d;
        public boolean e;

        public Builder(android.content.Context context) {
            this.a = context == null ? null : context.getApplicationContext();
            this.b = b(com.google.android.exoplayer2.util.Util.getCountryCode(context));
            this.c = 2000;
            this.d = com.google.android.exoplayer2.util.Clock.DEFAULT;
            this.e = true;
        }

        public static com.google.common.collect.ImmutableList<java.lang.Integer> a(java.lang.String str) {
            com.google.common.collect.ImmutableList<java.lang.Integer> immutableList = com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.get((com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.Integer>) str);
            return immutableList.isEmpty() ? com.google.common.collect.ImmutableList.of(2, 2, 2, 2, 2) : immutableList;
        }

        public static java.util.Map<java.lang.Integer, java.lang.Long> b(java.lang.String str) {
            com.google.common.collect.ImmutableList<java.lang.Integer> a = a(str);
            java.util.HashMap hashMap = new java.util.HashMap(6);
            hashMap.put(0, 1000000L);
            com.google.common.collect.ImmutableList<java.lang.Long> immutableList = com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
            hashMap.put(2, immutableList.get(a.get(0).intValue()));
            hashMap.put(3, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(a.get(1).intValue()));
            hashMap.put(4, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(a.get(2).intValue()));
            hashMap.put(5, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(a.get(3).intValue()));
            hashMap.put(9, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(a.get(4).intValue()));
            hashMap.put(7, immutableList.get(a.get(0).intValue()));
            return hashMap;
        }

        public com.google.android.exoplayer2.upstream.DefaultBandwidthMeter build() {
            return new com.google.android.exoplayer2.upstream.DefaultBandwidthMeter(this.a, this.b, this.c, this.d, this.e, null);
        }

        public com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder setClock(com.google.android.exoplayer2.util.Clock clock) {
            this.d = clock;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder setInitialBitrateEstimate(int i, long j) {
            this.b.put(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j));
            return this;
        }

        public com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder setInitialBitrateEstimate(long j) {
            java.util.Iterator<java.lang.Integer> it = this.b.keySet().iterator();
            while (it.hasNext()) {
                setInitialBitrateEstimate(it.next().intValue(), j);
            }
            return this;
        }

        public com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder setInitialBitrateEstimate(java.lang.String str) {
            this.b = b(com.google.android.exoplayer2.util.Util.toUpperInvariant(str));
            return this;
        }

        public com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder setResetOnNetworkTypeChange(boolean z) {
            this.e = z;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder setSlidingWindowMaxWeight(int i) {
            this.c = i;
            return this;
        }
    }

    public static class ConnectivityActionReceiver extends android.content.BroadcastReceiver {
        public static com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver c;
        public final android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());
        public final java.util.ArrayList<java.lang.ref.WeakReference<com.google.android.exoplayer2.upstream.DefaultBandwidthMeter>> b = new java.util.ArrayList<>();

        public static synchronized com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver b(android.content.Context context) {
            com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver connectivityActionReceiver;
            synchronized (com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver.class) {
                if (c == null) {
                    c = new com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver();
                    android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                    intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                    context.registerReceiver(c, intentFilter);
                }
                connectivityActionReceiver = c;
            }
            return connectivityActionReceiver;
        }

        public synchronized void d(com.google.android.exoplayer2.upstream.DefaultBandwidthMeter defaultBandwidthMeter) {
            e();
            this.b.add(new java.lang.ref.WeakReference<>(defaultBandwidthMeter));
            this.a.post(new com.google.android.exoplayer2.upstream.b(this, defaultBandwidthMeter));
        }

        public final void e() {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                if (this.b.get(size).get() == null) {
                    this.b.remove(size);
                }
            }
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final void c(com.google.android.exoplayer2.upstream.DefaultBandwidthMeter defaultBandwidthMeter) {
            defaultBandwidthMeter.f();
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(android.content.Context context, android.content.Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            e();
            for (int i = 0; i < this.b.size(); i++) {
                com.google.android.exoplayer2.upstream.DefaultBandwidthMeter defaultBandwidthMeter = this.b.get(i).get();
                if (defaultBandwidthMeter != null) {
                    c(defaultBandwidthMeter);
                }
            }
        }
    }

    @java.lang.Deprecated
    public DefaultBandwidthMeter() {
        this(null, com.google.common.collect.ImmutableMap.of(), 2000, com.google.android.exoplayer2.util.Clock.DEFAULT, false);
    }

    public DefaultBandwidthMeter(@androidx.annotation.Nullable android.content.Context context, java.util.Map<java.lang.Integer, java.lang.Long> map, int i, com.google.android.exoplayer2.util.Clock clock, boolean z) {
        this.a = context == null ? null : context.getApplicationContext();
        this.b = com.google.common.collect.ImmutableMap.copyOf((java.util.Map) map);
        this.c = new com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener.EventDispatcher();
        this.d = new com.google.android.exoplayer2.util.SlidingPercentile(i);
        this.e = clock;
        int networkType = context == null ? 0 : com.google.android.exoplayer2.util.Util.getNetworkType(context);
        this.i = networkType;
        this.l = c(networkType);
        if (context == null || !z) {
            return;
        }
        com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.ConnectivityActionReceiver.b(context).d(this);
    }

    public /* synthetic */ DefaultBandwidthMeter(android.content.Context context, java.util.Map map, int i, com.google.android.exoplayer2.util.Clock clock, boolean z, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.AnonymousClass1 anonymousClass1) {
        this(context, map, i, clock, z);
    }

    public static com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.Integer> b() {
        com.google.common.collect.ImmutableListMultimap.Builder builder = com.google.common.collect.ImmutableListMultimap.builder();
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AD", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AE", (java.lang.Object[]) new java.lang.Integer[]{1, 4, 4, 4, 1});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AF", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AG", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AI", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AL", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AM", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AO", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AR", (java.lang.Object[]) new java.lang.Integer[]{2, 4, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AS", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AT", (java.lang.Object[]) new java.lang.Integer[]{0, 3, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AU", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 1, 1});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AW", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AX", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "AZ", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BA", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BB", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) com.qq.e.comm.managers.setting.GlobalSetting.BD_SDK_WRAPPER, (java.lang.Object[]) new java.lang.Integer[]{2, 0, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BE", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BF", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BG", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BH", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 2, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BI", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BJ", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BL", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BM", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BN", (java.lang.Object[]) new java.lang.Integer[]{4, 0, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BO", (java.lang.Object[]) new java.lang.Integer[]{2, 3, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BQ", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BR", (java.lang.Object[]) new java.lang.Integer[]{2, 4, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BS", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BT", (java.lang.Object[]) new java.lang.Integer[]{3, 0, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BW", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BY", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "BZ", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CA", (java.lang.Object[]) new java.lang.Integer[]{0, 3, 1, 2, 3});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CD", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CF", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CG", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CH", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 0, 0, 0});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CI", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CK", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CL", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CM", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CN", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 1, 3});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CO", (java.lang.Object[]) new java.lang.Integer[]{2, 4, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CR", (java.lang.Object[]) new java.lang.Integer[]{2, 3, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CU", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CV", (java.lang.Object[]) new java.lang.Integer[]{2, 3, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CW", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CY", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "CZ", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "DE", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 1, 2, 0});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "DJ", (java.lang.Object[]) new java.lang.Integer[]{4, 1, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "DK", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "DM", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "DO", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "DZ", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "EC", (java.lang.Object[]) new java.lang.Integer[]{2, 4, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "EE", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "EG", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "EH", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ER", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ES", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ET", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "FI", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 1, 0, 0});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "FJ", (java.lang.Object[]) new java.lang.Integer[]{3, 0, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "FK", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "FM", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "FO", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "FR", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GA", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GB", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GD", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GE", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 1, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GF", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GG", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GH", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GI", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GL", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GM", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 2, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GN", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GP", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GQ", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GR", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) com.igexin.push.core.b.j, (java.lang.Object[]) new java.lang.Integer[]{3, 2, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GU", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GW", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "GY", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) com.anythink.expressad.video.dynview.a.a.Z, (java.lang.Object[]) new java.lang.Integer[]{0, 2, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "HN", (java.lang.Object[]) new java.lang.Integer[]{3, 0, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "HR", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "HT", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "HU", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ID", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IE", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IL", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IM", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) com.anythink.core.api.ATCountryCode.INDIA, (java.lang.Object[]) new java.lang.Integer[]{2, 1, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IO", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IQ", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IR", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IS", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "IT", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "JE", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 0, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "JM", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "JO", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "JP", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 1, 3});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KE", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KG", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KH", (java.lang.Object[]) new java.lang.Integer[]{2, 0, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KI", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 3, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KM", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KN", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KP", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KR", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 1, 1, 1});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KW", (java.lang.Object[]) new java.lang.Integer[]{2, 3, 1, 1, 1});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KY", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "KZ", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LA", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LB", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LC", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LI", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LK", (java.lang.Object[]) new java.lang.Integer[]{2, 0, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LR", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LS", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LT", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LU", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LV", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "LY", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MA", (java.lang.Object[]) new java.lang.Integer[]{2, 1, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MC", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MD", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ME", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MF", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MG", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MH", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MK", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ML", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MM", (java.lang.Object[]) new java.lang.Integer[]{2, 3, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MN", (java.lang.Object[]) new java.lang.Integer[]{2, 4, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MO", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MP", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MQ", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MR", (java.lang.Object[]) new java.lang.Integer[]{3, 0, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MS", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MT", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MU", (java.lang.Object[]) new java.lang.Integer[]{3, 1, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MV", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 1, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MW", (java.lang.Object[]) new java.lang.Integer[]{4, 1, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MX", (java.lang.Object[]) new java.lang.Integer[]{2, 4, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MY", (java.lang.Object[]) new java.lang.Integer[]{2, 0, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "MZ", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NA", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NC", (java.lang.Object[]) new java.lang.Integer[]{2, 0, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NE", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NF", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NG", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NI", (java.lang.Object[]) new java.lang.Integer[]{3, 1, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NL", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 4, 2, 0});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NO", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NP", (java.lang.Object[]) new java.lang.Integer[]{2, 0, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NR", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 3, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NU", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "NZ", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 1, 2, 4});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "OM", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 0, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PA", (java.lang.Object[]) new java.lang.Integer[]{1, 3, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PE", (java.lang.Object[]) new java.lang.Integer[]{2, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PF", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PG", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PH", (java.lang.Object[]) new java.lang.Integer[]{3, 0, 3, 4, 4});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PK", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PL", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PM", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PR", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 3, 4});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PS", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) com.igexin.assist.sdk.AssistPushConsts.MSG_VALUE_PAYLOAD, (java.lang.Object[]) new java.lang.Integer[]{1, 1, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PW", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 3, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "PY", (java.lang.Object[]) new java.lang.Integer[]{2, 0, 3, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "QA", (java.lang.Object[]) new java.lang.Integer[]{2, 3, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "RE", (java.lang.Object[]) new java.lang.Integer[]{1, 0, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "RO", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "RS", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "RU", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "RW", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SA", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SB", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SC", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 0, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SD", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SE", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SG", (java.lang.Object[]) new java.lang.Integer[]{0, 0, 3, 3, 4});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SH", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SI", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SJ", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SK", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SL", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 3, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SM", (java.lang.Object[]) new java.lang.Integer[]{0, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SN", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SO", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SR", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 3, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SS", (java.lang.Object[]) new java.lang.Integer[]{4, 1, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ST", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SV", (java.lang.Object[]) new java.lang.Integer[]{2, 1, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SX", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SY", (java.lang.Object[]) new java.lang.Integer[]{4, 3, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "SZ", (java.lang.Object[]) new java.lang.Integer[]{3, 4, 3, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TC", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TD", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TG", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TH", (java.lang.Object[]) new java.lang.Integer[]{1, 3, 4, 3, 0});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TJ", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TL", (java.lang.Object[]) new java.lang.Integer[]{4, 1, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TM", (java.lang.Object[]) new java.lang.Integer[]{4, 2, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TN", (java.lang.Object[]) new java.lang.Integer[]{2, 1, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TO", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TR", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) com.qq.e.comm.managers.setting.GlobalSetting.TT_SDK_WRAPPER, (java.lang.Object[]) new java.lang.Integer[]{1, 3, 1, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TV", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 2, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) com.anythink.expressad.video.dynview.a.a.Y, (java.lang.Object[]) new java.lang.Integer[]{0, 0, 0, 0, 1});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "TZ", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "UA", (java.lang.Object[]) new java.lang.Integer[]{0, 3, 0, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "UG", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "US", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 3, 3, 3});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "UY", (java.lang.Object[]) new java.lang.Integer[]{2, 1, 1, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "UZ", (java.lang.Object[]) new java.lang.Integer[]{2, 0, 3, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "VC", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "VE", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "VG", (java.lang.Object[]) new java.lang.Integer[]{2, 2, 1, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "VI", (java.lang.Object[]) new java.lang.Integer[]{1, 2, 2, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "VN", (java.lang.Object[]) new java.lang.Integer[]{0, 1, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "VU", (java.lang.Object[]) new java.lang.Integer[]{4, 1, 3, 1, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "WS", (java.lang.Object[]) new java.lang.Integer[]{3, 1, 4, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "XK", (java.lang.Object[]) new java.lang.Integer[]{1, 1, 1, 0, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "YE", (java.lang.Object[]) new java.lang.Integer[]{4, 4, 4, 4, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "YT", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 1, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ZA", (java.lang.Object[]) new java.lang.Integer[]{2, 3, 2, 2, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ZM", (java.lang.Object[]) new java.lang.Integer[]{3, 2, 2, 3, 2});
        builder.putAll((com.google.common.collect.ImmutableListMultimap.Builder) "ZW", (java.lang.Object[]) new java.lang.Integer[]{3, 3, 3, 3, 2});
        return builder.build();
    }

    public static boolean d(com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    public static synchronized com.google.android.exoplayer2.upstream.DefaultBandwidthMeter getSingletonInstance(android.content.Context context) {
        com.google.android.exoplayer2.upstream.DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.class) {
            if (p == null) {
                p = new com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.Builder(context).build();
            }
            defaultBandwidthMeter = p;
        }
        return defaultBandwidthMeter;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(handler);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
        this.c.addListener(handler, eventListener);
    }

    public final long c(int i) {
        java.lang.Long l = this.b.get(java.lang.Integer.valueOf(i));
        if (l == null) {
            l = this.b.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public final void e(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.m) {
            return;
        }
        this.m = j2;
        this.c.bandwidthSample(i, j, j2);
    }

    public final synchronized void f() {
        int networkType;
        if (this.n) {
            networkType = this.o;
        } else {
            android.content.Context context = this.a;
            networkType = context == null ? 0 : com.google.android.exoplayer2.util.Util.getNetworkType(context);
        }
        if (this.i == networkType) {
            return;
        }
        this.i = networkType;
        if (networkType != 1 && networkType != 0 && networkType != 8) {
            this.l = c(networkType);
            long elapsedRealtime = this.e.elapsedRealtime();
            e(this.f > 0 ? (int) (elapsedRealtime - this.g) : 0, this.h, this.l);
            this.g = elapsedRealtime;
            this.h = 0L;
            this.k = 0L;
            this.j = 0L;
            this.d.reset();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public com.google.android.exoplayer2.upstream.TransferListener getTransferListener() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z, int i) {
        if (d(dataSpec, z)) {
            this.h += i;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z) {
        if (d(dataSpec, z)) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.f > 0);
            long elapsedRealtime = this.e.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.g);
            this.j += i;
            long j = this.k;
            long j2 = this.h;
            this.k = j + j2;
            if (i > 0) {
                this.d.addSample((int) java.lang.Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.j >= 2000 || this.k >= android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.l = (long) this.d.getPercentile(0.5f);
                }
                e(i, this.h, this.l);
                this.g = elapsedRealtime;
                this.h = 0L;
            }
            this.f--;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z) {
        if (d(dataSpec, z)) {
            if (this.f == 0) {
                this.g = this.e.elapsedRealtime();
            }
            this.f++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener) {
        this.c.removeListener(eventListener);
    }

    public synchronized void setNetworkTypeOverride(int i) {
        this.o = i;
        this.n = true;
        f();
    }
}
