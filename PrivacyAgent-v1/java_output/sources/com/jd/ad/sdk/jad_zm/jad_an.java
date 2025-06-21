package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public abstract class jad_an {
    public java.net.URLConnection jad_an;

    public final com.jd.ad.sdk.jad_zm.jad_fs jad_an(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.util.List<java.lang.String> value = entry.getValue();
            if (!android.text.TextUtils.isEmpty(key) && !value.isEmpty()) {
                java.util.Iterator<java.lang.String> it = value.iterator();
                while (it.hasNext()) {
                    jad_fsVar.jad_an(key, it.next());
                }
            }
        }
        return jad_fsVar;
    }

    public abstract java.net.URLConnection jad_an(com.jd.ad.sdk.jad_zm.jad_ly jad_lyVar);

    public abstract void jad_an();

    public abstract int jad_bo();

    public com.jd.ad.sdk.jad_zm.jad_mz jad_bo(com.jd.ad.sdk.jad_zm.jad_ly jad_lyVar) {
        if (com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_lyVar.jad_an, 2)) {
            com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = jad_lyVar.jad_bo;
            com.jd.ad.sdk.jad_zm.jad_er jad_erVar = jad_lyVar.jad_fs;
            if (jad_erVar != null && jad_fsVar != null) {
                jad_fsVar.jad_bo("Content-Length", java.lang.Long.toString(jad_erVar.jad_an == null ? 0L : r3.length));
                jad_fsVar.jad_bo("Content-Type", "application/stream");
            }
            java.net.URLConnection jad_an = jad_an(jad_lyVar);
            this.jad_an = jad_an;
            if (jad_erVar != null) {
                try {
                    java.io.OutputStream outputStream = jad_an.getOutputStream();
                    java.io.BufferedOutputStream bufferedOutputStream = outputStream instanceof java.io.BufferedOutputStream ? (java.io.BufferedOutputStream) outputStream : new java.io.BufferedOutputStream(outputStream);
                    byte[] bArr = jad_erVar.jad_an;
                    if (bArr != null) {
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (java.lang.Exception e) {
                    throw new com.jd.ad.sdk.jad_do.jad_cp(e);
                }
            }
        } else {
            this.jad_an = jad_an(jad_lyVar);
        }
        try {
            int jad_bo = jad_bo();
            if (jad_bo >= 400) {
                int i = com.jd.ad.sdk.jad_zm.jad_mz.jad_er;
                com.jd.ad.sdk.jad_zm.jad_mz.jad_an jad_anVar = new com.jd.ad.sdk.jad_zm.jad_mz.jad_an();
                jad_anVar.jad_an = jad_bo;
                jad_anVar.jad_bo = null;
                jad_anVar.jad_cp = null;
                jad_anVar.jad_dq = this;
                return new com.jd.ad.sdk.jad_zm.jad_mz(jad_anVar);
            }
            java.io.InputStream inputStream = this.jad_an.getInputStream();
            java.io.BufferedInputStream bufferedInputStream = inputStream instanceof java.io.BufferedInputStream ? (java.io.BufferedInputStream) inputStream : new java.io.BufferedInputStream(inputStream);
            if (!(jad_lyVar.jad_hu != null)) {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                bufferedInputStream.close();
                jad_an();
                return null;
            }
            com.jd.ad.sdk.jad_zm.jad_fs jad_an2 = jad_an(this.jad_an.getHeaderFields());
            com.jd.ad.sdk.jad_zm.jad_ob jad_obVar = new com.jd.ad.sdk.jad_zm.jad_ob(jad_an2.jad_an("Content-Type"), bufferedInputStream);
            int i2 = com.jd.ad.sdk.jad_zm.jad_mz.jad_er;
            com.jd.ad.sdk.jad_zm.jad_mz.jad_an jad_anVar2 = new com.jd.ad.sdk.jad_zm.jad_mz.jad_an();
            jad_anVar2.jad_an = jad_bo;
            jad_anVar2.jad_bo = jad_an2;
            jad_anVar2.jad_cp = jad_obVar;
            jad_anVar2.jad_dq = this;
            return new com.jd.ad.sdk.jad_zm.jad_mz(jad_anVar2);
        } catch (java.net.SocketTimeoutException e2) {
            throw new com.jd.ad.sdk.jad_do.jad_bo(java.lang.String.format("Read data time out: %1$s.", this.jad_an.getURL().toString()), e2);
        } catch (java.lang.Exception e3) {
            if (e3 instanceof com.jd.ad.sdk.jad_do.jad_bo) {
                throw new com.jd.ad.sdk.jad_do.jad_bo(e3);
            }
            throw new com.jd.ad.sdk.jad_do.jad_bo(new java.lang.Exception(jad_lyVar.jad_er, e3));
        }
    }
}
