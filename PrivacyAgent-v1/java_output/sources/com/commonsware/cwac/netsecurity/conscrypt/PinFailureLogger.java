package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public class PinFailureLogger {
    private static final long LOG_INTERVAL_NANOS = 817405952;
    private static long lastLoggedNanos;

    public static synchronized void log(java.lang.String str, boolean z, boolean z2, java.util.List<java.security.cert.X509Certificate> list) {
        synchronized (com.commonsware.cwac.netsecurity.conscrypt.PinFailureLogger.class) {
            if (timeToLog()) {
                writeToLog(str, z, z2, list);
                lastLoggedNanos = java.lang.System.nanoTime();
            }
        }
    }

    public static boolean timeToLog() {
        return java.lang.System.nanoTime() - lastLoggedNanos > LOG_INTERVAL_NANOS;
    }

    public static synchronized void writeToLog(java.lang.String str, boolean z, boolean z2, java.util.List<java.security.cert.X509Certificate> list) {
        synchronized (com.commonsware.cwac.netsecurity.conscrypt.PinFailureLogger.class) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append("|");
            sb.append(z);
            sb.append("|");
            sb.append(z2);
            sb.append("|");
            java.util.Iterator<java.security.cert.X509Certificate> it = list.iterator();
            while (it.hasNext()) {
                try {
                    sb.append(com.commonsware.cwac.netsecurity.luni.Base64.encode(it.next().getEncoded()));
                } catch (java.security.cert.CertificateEncodingException unused) {
                    sb.append("Error: could not encode certificate");
                }
                sb.append("|");
            }
            com.commonsware.cwac.netsecurity.luni.DropBox.addText("exp_det_cert_pin_failure", sb.toString());
        }
    }
}
