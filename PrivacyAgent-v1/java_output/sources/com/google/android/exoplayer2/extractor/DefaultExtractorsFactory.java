package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class DefaultExtractorsFactory implements com.google.android.exoplayer2.extractor.ExtractorsFactory {
    public static final int[] l = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7};

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.extractor.Extractor> m;
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int j;
    public int i = 1;
    public int k = com.google.android.exoplayer2.extractor.ts.TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    static {
        java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.extractor.Extractor> constructor = null;
        try {
            if (java.lang.Boolean.TRUE.equals(java.lang.Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]))) {
                constructor = java.lang.Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(com.google.android.exoplayer2.extractor.Extractor.class).getConstructor(java.lang.Integer.TYPE);
            }
        } catch (java.lang.ClassNotFoundException unused) {
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Error instantiating FLAC extension", e);
        }
        m = constructor;
    }

    public final void a(int i, java.util.List<com.google.android.exoplayer2.extractor.Extractor> list) {
        switch (i) {
            case 0:
                list.add(new com.google.android.exoplayer2.extractor.ts.Ac3Extractor());
                return;
            case 1:
                list.add(new com.google.android.exoplayer2.extractor.ts.Ac4Extractor());
                return;
            case 2:
                list.add(new com.google.android.exoplayer2.extractor.ts.AdtsExtractor(this.b | (this.a ? 1 : 0)));
                return;
            case 3:
                list.add(new com.google.android.exoplayer2.extractor.amr.AmrExtractor(this.c | (this.a ? 1 : 0)));
                return;
            case 4:
                java.lang.reflect.Constructor<? extends com.google.android.exoplayer2.extractor.Extractor> constructor = m;
                if (constructor == null) {
                    list.add(new com.google.android.exoplayer2.extractor.flac.FlacExtractor(this.d));
                    return;
                }
                try {
                    list.add(constructor.newInstance(java.lang.Integer.valueOf(this.d)));
                    return;
                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalStateException("Unexpected error creating FLAC extractor", e);
                }
            case 5:
                list.add(new com.google.android.exoplayer2.extractor.flv.FlvExtractor());
                return;
            case 6:
                list.add(new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor(this.e));
                return;
            case 7:
                list.add(new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor(this.h | (this.a ? 1 : 0)));
                return;
            case 8:
                list.add(new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(this.g));
                list.add(new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor(this.f));
                return;
            case 9:
                list.add(new com.google.android.exoplayer2.extractor.ogg.OggExtractor());
                return;
            case 10:
                list.add(new com.google.android.exoplayer2.extractor.ts.PsExtractor());
                return;
            case 11:
                list.add(new com.google.android.exoplayer2.extractor.ts.TsExtractor(this.i, this.j, this.k));
                return;
            case 12:
                list.add(new com.google.android.exoplayer2.extractor.wav.WavExtractor());
                return;
            default:
                return;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
        return createExtractors(android.net.Uri.EMPTY, new java.util.HashMap());
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized com.google.android.exoplayer2.extractor.Extractor[] createExtractors(android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList(14);
        int inferFileTypeFromResponseHeaders = com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromResponseHeaders(map);
        if (inferFileTypeFromResponseHeaders != -1) {
            a(inferFileTypeFromResponseHeaders, arrayList);
        }
        int inferFileTypeFromUri = com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromUri(uri);
        if (inferFileTypeFromUri != -1 && inferFileTypeFromUri != inferFileTypeFromResponseHeaders) {
            a(inferFileTypeFromUri, arrayList);
        }
        for (int i : l) {
            if (i != inferFileTypeFromResponseHeaders && i != inferFileTypeFromUri) {
                a(i, arrayList);
            }
        }
        return (com.google.android.exoplayer2.extractor.Extractor[]) arrayList.toArray(new com.google.android.exoplayer2.extractor.Extractor[arrayList.size()]);
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setAdtsExtractorFlags(int i) {
        this.b = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setAmrExtractorFlags(int i) {
        this.c = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        this.a = z;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setFlacExtractorFlags(int i) {
        this.d = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i) {
        this.g = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setMatroskaExtractorFlags(int i) {
        this.e = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setMp3ExtractorFlags(int i) {
        this.h = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setMp4ExtractorFlags(int i) {
        this.f = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setTsExtractorFlags(int i) {
        this.j = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setTsExtractorMode(int i) {
        this.i = i;
        return this;
    }

    public synchronized com.google.android.exoplayer2.extractor.DefaultExtractorsFactory setTsExtractorTimestampSearchBytes(int i) {
        this.k = i;
        return this;
    }
}
