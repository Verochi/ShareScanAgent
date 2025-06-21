package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
public final class l implements com.anythink.expressad.exoplayer.j.a.i {
    public static final com.anythink.expressad.exoplayer.j.a.l b = new com.anythink.expressad.exoplayer.j.a.l(java.util.Collections.emptyMap());
    private static final int c = 10485760;
    private int d;
    private final java.util.Map<java.lang.String, byte[]> e;

    private l(java.util.Map<java.lang.String, byte[]> map) {
        this.e = java.util.Collections.unmodifiableMap(map);
    }

    public static com.anythink.expressad.exoplayer.j.a.l a(java.io.DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < readInt; i++) {
            java.lang.String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0 || readInt2 > c) {
                throw new java.io.IOException("Invalid value size: ".concat(java.lang.String.valueOf(readInt2)));
            }
            byte[] bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
            hashMap.put(readUTF, bArr);
        }
        return new com.anythink.expressad.exoplayer.j.a.l(hashMap);
    }

    private static java.util.Map<java.lang.String, byte[]> a(java.util.Map<java.lang.String, byte[]> map, com.anythink.expressad.exoplayer.j.a.k kVar) {
        java.util.HashMap hashMap = new java.util.HashMap(map);
        a((java.util.HashMap<java.lang.String, byte[]>) hashMap, kVar.a());
        a((java.util.HashMap<java.lang.String, byte[]>) hashMap, kVar.b());
        return hashMap;
    }

    private static void a(java.util.HashMap<java.lang.String, byte[]> hashMap, java.util.List<java.lang.String> list) {
        for (int i = 0; i < list.size(); i++) {
            hashMap.remove(list.get(i));
        }
    }

    private static void a(java.util.HashMap<java.lang.String, byte[]> hashMap, java.util.Map<java.lang.String, java.lang.Object> map) {
        byte[] bArr;
        for (java.lang.String str : map.keySet()) {
            java.lang.Object obj = map.get(str);
            if (obj instanceof java.lang.Long) {
                bArr = java.nio.ByteBuffer.allocate(8).putLong(((java.lang.Long) obj).longValue()).array();
            } else if (obj instanceof java.lang.String) {
                bArr = ((java.lang.String) obj).getBytes(java.nio.charset.Charset.forName("UTF-8"));
            } else {
                if (!(obj instanceof byte[])) {
                    throw new java.lang.IllegalArgumentException();
                }
                bArr = (byte[]) obj;
            }
            if (bArr.length > c) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("The size of %s (%d) is greater than maximum allowed: %d", str, java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(c)));
            }
            hashMap.put(str, bArr);
        }
    }

    private boolean a(java.util.Map<java.lang.String, byte[]> map) {
        if (this.e.size() != map.size()) {
            return false;
        }
        for (java.util.Map.Entry<java.lang.String, byte[]> entry : this.e.entrySet()) {
            if (!java.util.Arrays.equals(entry.getValue(), map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static byte[] a(java.lang.Object obj) {
        if (obj instanceof java.lang.Long) {
            return java.nio.ByteBuffer.allocate(8).putLong(((java.lang.Long) obj).longValue()).array();
        }
        if (obj instanceof java.lang.String) {
            return ((java.lang.String) obj).getBytes(java.nio.charset.Charset.forName("UTF-8"));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new java.lang.IllegalArgumentException();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final long a(java.lang.String str) {
        if (this.e.containsKey(str)) {
            return java.nio.ByteBuffer.wrap(this.e.get(str)).getLong();
        }
        return -1L;
    }

    public final com.anythink.expressad.exoplayer.j.a.l a(com.anythink.expressad.exoplayer.j.a.k kVar) {
        java.util.HashMap hashMap = new java.util.HashMap(this.e);
        a((java.util.HashMap<java.lang.String, byte[]>) hashMap, kVar.a());
        a((java.util.HashMap<java.lang.String, byte[]>) hashMap, kVar.b());
        return a((java.util.Map<java.lang.String, byte[]>) hashMap) ? this : new com.anythink.expressad.exoplayer.j.a.l(hashMap);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        return this.e.containsKey(str) ? new java.lang.String(this.e.get(str), java.nio.charset.Charset.forName("UTF-8")) : str2;
    }

    public final void a(java.io.DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.e.size());
        for (java.util.Map.Entry<java.lang.String, byte[]> entry : this.e.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final byte[] a(java.lang.String str, byte[] bArr) {
        if (!this.e.containsKey(str)) {
            return bArr;
        }
        byte[] bArr2 = this.e.get(str);
        return java.util.Arrays.copyOf(bArr2, bArr2.length);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final boolean b(java.lang.String str) {
        return this.e.containsKey(str);
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.anythink.expressad.exoplayer.j.a.l.class != obj.getClass()) {
            return false;
        }
        return a(((com.anythink.expressad.exoplayer.j.a.l) obj).e);
    }

    public final int hashCode() {
        if (this.d == 0) {
            int i = 0;
            for (java.util.Map.Entry<java.lang.String, byte[]> entry : this.e.entrySet()) {
                i += java.util.Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.d = i;
        }
        return this.d;
    }
}
