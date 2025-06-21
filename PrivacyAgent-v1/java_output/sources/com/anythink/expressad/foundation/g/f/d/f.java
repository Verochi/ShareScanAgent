package com.anythink.expressad.foundation.g.f.d;

/* loaded from: classes12.dex */
public class f extends com.anythink.expressad.foundation.g.f.i<java.lang.String> {
    private static final java.lang.String c = "f";
    private java.util.Map<java.lang.String, java.lang.String> d;
    private com.anythink.expressad.foundation.g.f.c.b[] e;
    private java.lang.String f;

    private f(int i, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, com.anythink.expressad.foundation.g.f.c.b[] bVarArr, com.anythink.expressad.foundation.g.f.e<java.lang.String> eVar) {
        super(i, str, eVar);
        this.f = "---------Ij5ei4KM7KM7ae0KM7cH2ae0Ij5Ef1";
        this.d = map;
        this.e = bVarArr;
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final com.anythink.expressad.foundation.g.f.k<java.lang.String> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return com.anythink.expressad.foundation.g.f.k.a(new java.lang.String(cVar.b, com.anythink.expressad.foundation.g.f.g.d.a(cVar.d)), cVar);
        } catch (java.io.UnsupportedEncodingException e) {
            e.getMessage();
            return com.anythink.expressad.foundation.g.f.k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final void a(java.io.OutputStream outputStream) {
        java.io.DataOutputStream dataOutputStream = (java.io.DataOutputStream) outputStream;
        try {
            try {
                com.anythink.expressad.foundation.g.f.c.b[] bVarArr = this.e;
                if (bVarArr != null) {
                    for (com.anythink.expressad.foundation.g.f.c.b bVar : bVarArr) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("--");
                        sb.append(this.f);
                        sb.append("\r\n");
                        sb.append("Content-Disposition: form-data;name=\"" + bVar.f() + "\";filename=\"" + bVar.e() + "\"\r\n");
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Content-Type: ");
                        sb2.append(bVar.g());
                        sb2.append("\r\n\r\n");
                        sb.append(sb2.toString());
                        dataOutputStream.write(sb.toString().getBytes());
                        if (bVar.c() != null) {
                            byte[] bArr = new byte[1024];
                            int i = 0;
                            while (true) {
                                int read = bVar.c().read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                dataOutputStream.write(bArr, 0, read);
                                i += read;
                                com.anythink.expressad.foundation.g.f.e<T> eVar = this.b;
                                if (eVar != 0) {
                                    eVar.a(bVar.a(), i);
                                }
                            }
                            bVar.c().close();
                        } else {
                            dataOutputStream.write(bVar.d(), 0, bVar.d().length);
                        }
                        dataOutputStream.write("\r\n".getBytes());
                    }
                }
                dataOutputStream.writeBytes("--" + this.f + "--\r\n");
                dataOutputStream.flush();
            } catch (java.io.IOException e) {
                e.getMessage();
                this.b.a(new com.anythink.expressad.foundation.g.f.a.a(2, null));
                try {
                    dataOutputStream.close();
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            try {
                dataOutputStream.close();
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final byte[] h() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.d.entrySet()) {
            sb.append("--");
            sb.append(this.f);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
            sb.append(entry.getValue());
            sb.append("\r\n");
        }
        return sb.toString().getBytes();
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final void i() {
        super.i();
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "multipart/form-data; boundary=" + this.f);
        a((java.util.Map<java.lang.String, java.lang.String>) hashMap);
    }
}
