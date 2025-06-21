package com.umeng.analytics.filter;

/* loaded from: classes19.dex */
public class d {
    private static final java.lang.String b = "Ă";
    private java.security.MessageDigest c;
    private boolean e;
    private final java.lang.String a = "MD5";
    private java.util.Set<java.lang.Object> d = new java.util.HashSet();

    public d(boolean z, java.lang.String str) {
        this.e = z;
        try {
            this.c = java.security.MessageDigest.getInstance("MD5");
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (str != null) {
            int i = 0;
            if (!z) {
                java.lang.String[] split = str.split(b);
                int length = split.length;
                while (i < length) {
                    this.d.add(split[i]);
                    i++;
                }
                return;
            }
            try {
                byte[] decode = android.util.Base64.decode(str.getBytes(), 0);
                while (i < decode.length / 4) {
                    int i2 = i * 4;
                    this.d.add(java.lang.Integer.valueOf(((decode[i2 + 0] & 255) << 24) + ((decode[i2 + 1] & 255) << 16) + ((decode[i2 + 2] & 255) << 8) + (decode[i2 + 3] & 255)));
                    i++;
                }
            } catch (java.lang.IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    private java.lang.Integer c(java.lang.String str) {
        try {
            this.c.update(str.getBytes());
            byte[] digest = this.c.digest();
            return java.lang.Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.Object> it = this.d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        java.lang.System.out.println(sb.toString());
    }

    public boolean a(java.lang.String str) {
        return this.e ? this.d.contains(c(str)) : this.d.contains(str);
    }

    public void b(java.lang.String str) {
        if (this.e) {
            this.d.add(c(str));
        } else {
            this.d.add(str);
        }
    }

    public java.lang.String toString() {
        if (!this.e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.Object obj : this.d) {
                if (sb.length() > 0) {
                    sb.append(b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.d.size() * 4];
        java.util.Iterator<java.lang.Object> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((java.lang.Integer) it.next()).intValue();
            int i2 = i + 1;
            bArr[i] = (byte) (((-16777216) & intValue) >> 24);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((16711680 & intValue) >> 16);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((65280 & intValue) >> 8);
            i = i4 + 1;
            bArr[i4] = (byte) (intValue & 255);
        }
        return new java.lang.String(android.util.Base64.encode(bArr, 0));
    }
}
