package com.aliyun.vod.qupaiokhttp.https;

/* loaded from: classes12.dex */
public class HttpsCerManager {
    private okhttp3.OkHttpClient.Builder okHttpBuilder;

    public class OkHttpTrustManager implements javax.net.ssl.X509TrustManager {
        private javax.net.ssl.X509TrustManager defaultTrustManager;
        private javax.net.ssl.X509TrustManager localTrustManager;

        public OkHttpTrustManager(javax.net.ssl.X509TrustManager x509TrustManager) throws java.security.NoSuchAlgorithmException, java.security.KeyStoreException {
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((java.security.KeyStore) null);
            this.defaultTrustManager = com.aliyun.vod.qupaiokhttp.https.HttpsCerManager.this.chooseTrustManager(trustManagerFactory.getTrustManagers());
            this.localTrustManager = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
            try {
                this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
            } catch (java.security.cert.CertificateException unused) {
                this.localTrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
        }
    }

    public HttpsCerManager(okhttp3.OkHttpClient.Builder builder) {
        this.okHttpBuilder = builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public javax.net.ssl.X509TrustManager chooseTrustManager(javax.net.ssl.TrustManager[] trustManagerArr) {
        for (javax.net.ssl.TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                return (javax.net.ssl.X509TrustManager) trustManager;
            }
        }
        return null;
    }

    private javax.net.ssl.KeyManager[] prepareKeyManager(java.io.InputStream inputStream, java.lang.String str) {
        if (inputStream != null && str != null) {
            try {
                java.security.KeyStore keyStore = java.security.KeyStore.getInstance("BKS");
                keyStore.load(inputStream, str.toCharArray());
                javax.net.ssl.KeyManagerFactory keyManagerFactory = javax.net.ssl.KeyManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, str.toCharArray());
                return keyManagerFactory.getKeyManagers();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            } catch (java.security.KeyStoreException e2) {
                e2.printStackTrace();
            } catch (java.security.NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            } catch (java.security.UnrecoverableKeyException e4) {
                e4.printStackTrace();
            } catch (java.security.cert.CertificateException e5) {
                e5.printStackTrace();
            } catch (java.lang.Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    private javax.net.ssl.TrustManager[] prepareTrustManager(java.io.InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
                java.security.KeyStore keyStore = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    java.io.InputStream inputStream = inputStreamArr[i];
                    int i3 = i2 + 1;
                    keyStore.setCertificateEntry(java.lang.Integer.toString(i2), certificateFactory.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    i++;
                    i2 = i3;
                }
                javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (java.security.KeyStoreException e) {
                e.printStackTrace();
            } catch (java.security.NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (java.security.cert.CertificateException e3) {
                e3.printStackTrace();
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    private void setCertificates(java.io.InputStream[] inputStreamArr, java.io.InputStream inputStream, java.lang.String str) {
        try {
            javax.net.ssl.TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
            javax.net.ssl.KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sSLContext.init(prepareKeyManager, new javax.net.ssl.TrustManager[]{new com.aliyun.vod.qupaiokhttp.https.HttpsCerManager.OkHttpTrustManager(chooseTrustManager(prepareTrustManager))}, new java.security.SecureRandom());
            this.okHttpBuilder.sslSocketFactory(sSLContext.getSocketFactory());
        } catch (java.security.KeyManagementException e) {
            e.printStackTrace();
        } catch (java.security.KeyStoreException e2) {
            e2.printStackTrace();
        } catch (java.security.NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        }
    }

    public void setCertificates(java.util.List<java.io.InputStream> list) {
        setCertificates((java.io.InputStream[]) list.toArray(new java.io.InputStream[0]), null, null);
    }

    public void setCertificates(java.io.InputStream... inputStreamArr) {
        setCertificates(inputStreamArr, null, null);
    }
}
