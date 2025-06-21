package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes22.dex */
final class ScriptTagPayloadReader extends com.google.android.exoplayer2.extractor.flv.TagPayloadReader {
    public long b;
    public long[] c;
    public long[] d;

    public ScriptTagPayloadReader() {
        super(new com.google.android.exoplayer2.extractor.DummyTrackOutput());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    public static java.lang.Boolean g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return java.lang.Boolean.valueOf(parsableByteArray.readUnsignedByte() == 1);
    }

    @androidx.annotation.Nullable
    public static java.lang.Object h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        if (i == 0) {
            return j(parsableByteArray);
        }
        if (i == 1) {
            return g(parsableByteArray);
        }
        if (i == 2) {
            return n(parsableByteArray);
        }
        if (i == 3) {
            return l(parsableByteArray);
        }
        if (i == 8) {
            return k(parsableByteArray);
        }
        if (i == 10) {
            return m(parsableByteArray);
        }
        if (i != 11) {
            return null;
        }
        return i(parsableByteArray);
    }

    public static java.util.Date i(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.util.Date date = new java.util.Date((long) j(parsableByteArray).doubleValue());
        parsableByteArray.skipBytes(2);
        return date;
    }

    public static java.lang.Double j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return java.lang.Double.valueOf(java.lang.Double.longBitsToDouble(parsableByteArray.readLong()));
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>(readUnsignedIntToInt);
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            java.lang.String n = n(parsableByteArray);
            java.lang.Object h = h(parsableByteArray, o(parsableByteArray));
            if (h != null) {
                hashMap.put(n, h);
            }
        }
        return hashMap;
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> l(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        while (true) {
            java.lang.String n = n(parsableByteArray);
            int o = o(parsableByteArray);
            if (o == 9) {
                return hashMap;
            }
            java.lang.Object h = h(parsableByteArray, o);
            if (h != null) {
                hashMap.put(n, h);
            }
        }
    }

    public static java.util.ArrayList<java.lang.Object> m(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>(readUnsignedIntToInt);
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            java.lang.Object h = h(parsableByteArray, o(parsableByteArray));
            if (h != null) {
                arrayList.add(h);
            }
        }
        return arrayList;
    }

    public static java.lang.String n(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return new java.lang.String(parsableByteArray.getData(), position, readUnsignedShort);
    }

    public static int o(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return parsableByteArray.readUnsignedByte();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) {
        if (o(parsableByteArray) != 2 || !"onMetaData".equals(n(parsableByteArray)) || o(parsableByteArray) != 8) {
            return false;
        }
        java.util.HashMap<java.lang.String, java.lang.Object> k = k(parsableByteArray);
        java.lang.Object obj = k.get("duration");
        if (obj instanceof java.lang.Double) {
            double doubleValue = ((java.lang.Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.b = (long) (doubleValue * 1000000.0d);
            }
        }
        java.lang.Object obj2 = k.get("keyframes");
        if (obj2 instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj2;
            java.lang.Object obj3 = map.get("filepositions");
            java.lang.Object obj4 = map.get("times");
            if ((obj3 instanceof java.util.List) && (obj4 instanceof java.util.List)) {
                java.util.List list = (java.util.List) obj3;
                java.util.List list2 = (java.util.List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; i++) {
                    java.lang.Object obj5 = list.get(i);
                    java.lang.Object obj6 = list2.get(i);
                    if (!(obj6 instanceof java.lang.Double) || !(obj5 instanceof java.lang.Double)) {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                    this.c[i] = (long) (((java.lang.Double) obj6).doubleValue() * 1000000.0d);
                    this.d[i] = ((java.lang.Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.b;
    }

    public long[] e() {
        return this.d;
    }

    public long[] f() {
        return this.c;
    }
}
