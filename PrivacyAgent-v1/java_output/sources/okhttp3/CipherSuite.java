package okhttp3;

/* loaded from: classes23.dex */
public final class CipherSuite {
    public final java.lang.String a;
    public static final java.util.Comparator<java.lang.String> b = new defpackage.nn();
    public static final java.util.Map<java.lang.String, okhttp3.CipherSuite> c = new java.util.LinkedHashMap();
    public static final okhttp3.CipherSuite TLS_RSA_WITH_NULL_MD5 = c("SSL_RSA_WITH_NULL_MD5", 1);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_NULL_SHA = c("SSL_RSA_WITH_NULL_SHA", 2);
    public static final okhttp3.CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5 = c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_RC4_128_MD5 = c("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_RC4_128_SHA = c("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final okhttp3.CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_DES_CBC_SHA = c("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA = c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA = c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final okhttp3.CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_RC4_128_MD5 = c("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final okhttp3.CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA = c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_DES_CBC_SHA = c("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA = c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_RC4_128_SHA = c("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_DES_CBC_MD5 = c("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_RC4_128_MD5 = c("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA = c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA = c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA = c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_NULL_SHA256 = c("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256 = c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256 = c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256 = c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256 = c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME);
    public static final okhttp3.CipherSuite TLS_PSK_WITH_RC4_128_SHA = c("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final okhttp3.CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA = c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL);
    public static final okhttp3.CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA = c("TLS_PSK_WITH_AES_128_CBC_SHA", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL);
    public static final okhttp3.CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA = c("TLS_PSK_WITH_AES_256_CBC_SHA", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_SEED_CBC_SHA = c("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = c("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = c("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", com.aliyun.svideosdk.facearengine.FaceARFaceResult.YUNOS_FL51PT_FACE_3D_KEY_POINT_NUM);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256 = c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE);
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384 = c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final okhttp3.CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV = c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final okhttp3.CipherSuite TLS_FALLBACK_SCSV = c("TLS_FALLBACK_SCSV", 22016);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA = c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA = c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA = c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA = c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA = c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA = c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA = c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_NULL_SHA = c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA = c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA = c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA = c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final okhttp3.CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final okhttp3.CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final okhttp3.CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final okhttp3.CipherSuite TLS_AES_128_GCM_SHA256 = c("TLS_AES_128_GCM_SHA256", 4865);
    public static final okhttp3.CipherSuite TLS_AES_256_GCM_SHA384 = c("TLS_AES_256_GCM_SHA384", 4866);
    public static final okhttp3.CipherSuite TLS_CHACHA20_POLY1305_SHA256 = c("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final okhttp3.CipherSuite TLS_AES_128_CCM_SHA256 = c("TLS_AES_128_CCM_SHA256", 4868);
    public static final okhttp3.CipherSuite TLS_AES_128_CCM_8_SHA256 = c("TLS_AES_128_CCM_8_SHA256", 4869);

    public CipherSuite(java.lang.String str) {
        str.getClass();
        this.a = str;
    }

    public static java.util.List<okhttp3.CipherSuite> b(java.lang.String... strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (java.lang.String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public static okhttp3.CipherSuite c(java.lang.String str, int i) {
        okhttp3.CipherSuite cipherSuite = new okhttp3.CipherSuite(str);
        c.put(str, cipherSuite);
        return cipherSuite;
    }

    public static /* synthetic */ int d(java.lang.String str, java.lang.String str2) {
        int min = java.lang.Math.min(str.length(), str2.length());
        for (int i = 4; i < min; i++) {
            char charAt = str.charAt(i);
            char charAt2 = str2.charAt(i);
            if (charAt != charAt2) {
                return charAt < charAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    public static java.lang.String e(java.lang.String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public static synchronized okhttp3.CipherSuite forJavaName(java.lang.String str) {
        okhttp3.CipherSuite cipherSuite;
        synchronized (okhttp3.CipherSuite.class) {
            java.util.Map<java.lang.String, okhttp3.CipherSuite> map = c;
            cipherSuite = map.get(str);
            if (cipherSuite == null) {
                cipherSuite = map.get(e(str));
                if (cipherSuite == null) {
                    cipherSuite = new okhttp3.CipherSuite(str);
                }
                map.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    public java.lang.String javaName() {
        return this.a;
    }

    public java.lang.String toString() {
        return this.a;
    }
}
