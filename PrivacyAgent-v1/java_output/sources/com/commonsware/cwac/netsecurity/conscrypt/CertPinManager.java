package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public class CertPinManager {
    private static final boolean DEBUG = false;
    private final com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore certStore;
    private final java.util.Map<java.lang.String, com.commonsware.cwac.netsecurity.conscrypt.PinListEntry> entries;
    private final android.util.LruCache<java.lang.String, java.lang.String> hostnameCache;
    private boolean initialized;
    private long lastModified;
    private final java.io.File pinFile;

    public CertPinManager(com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore) throws com.commonsware.cwac.netsecurity.conscrypt.PinManagerException {
        this.entries = new java.util.HashMap();
        this.hostnameCache = new android.util.LruCache<>(10);
        this.initialized = false;
        this.pinFile = new java.io.File("/data/misc/keychain/pins");
        this.certStore = trustedCertificateStore;
    }

    public CertPinManager(java.lang.String str, com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore) throws com.commonsware.cwac.netsecurity.conscrypt.PinManagerException {
        this.entries = new java.util.HashMap();
        this.hostnameCache = new android.util.LruCache<>(10);
        this.initialized = false;
        if (str == null) {
            throw new java.lang.NullPointerException("path == null");
        }
        this.pinFile = new java.io.File(str);
        this.certStore = trustedCertificateStore;
    }

    private synchronized boolean ensureInitialized() throws com.commonsware.cwac.netsecurity.conscrypt.PinManagerException {
        if (this.initialized && isCacheValid()) {
            return true;
        }
        java.lang.String readPinFile = readPinFile();
        if (readPinFile != null) {
            for (java.lang.String str : getPinFileEntries(readPinFile)) {
                try {
                    com.commonsware.cwac.netsecurity.conscrypt.PinListEntry pinListEntry = new com.commonsware.cwac.netsecurity.conscrypt.PinListEntry(str, this.certStore);
                    this.entries.put(pinListEntry.getCommonName(), pinListEntry);
                } catch (com.commonsware.cwac.netsecurity.conscrypt.PinEntryException e) {
                    log("Pinlist contains a malformed pin: " + str, e);
                }
            }
            this.hostnameCache.evictAll();
            this.lastModified = this.pinFile.lastModified();
            this.initialized = true;
        }
        return this.initialized;
    }

    private java.lang.String getMatchingCN(java.lang.String str) {
        java.lang.String str2 = "";
        for (java.lang.String str3 : this.entries.keySet()) {
            if (str3.length() >= str2.length() && isHostnameMatchedBy(str, str3)) {
                str2 = str3;
            }
        }
        return str2;
    }

    private static java.lang.String[] getPinFileEntries(java.lang.String str) {
        return str.split("\n");
    }

    private boolean isCacheValid() {
        return this.pinFile.lastModified() == this.lastModified;
    }

    private static boolean isHostnameMatchedBy(java.lang.String str, java.lang.String str2) {
        int i;
        int length;
        int length2;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }
        java.lang.String lowerCase = str2.toLowerCase(java.util.Locale.US);
        if (!lowerCase.contains("*")) {
            return str.equals(lowerCase);
        }
        if (lowerCase.startsWith("*.") && str.regionMatches(0, lowerCase, 2, lowerCase.length() - 2)) {
            return true;
        }
        int indexOf = lowerCase.indexOf(42);
        return indexOf <= lowerCase.indexOf(46) && str.regionMatches(0, lowerCase, 0, indexOf) && str.indexOf(46, indexOf) >= (length2 = str.length() - (length = lowerCase.length() - (i = indexOf + 1))) && str.regionMatches(length2, lowerCase, i, length);
    }

    private static void log(java.lang.String str, java.lang.Exception exc) {
    }

    private synchronized com.commonsware.cwac.netsecurity.conscrypt.PinListEntry lookup(java.lang.String str) throws com.commonsware.cwac.netsecurity.conscrypt.PinManagerException {
        if (!ensureInitialized()) {
            return null;
        }
        java.lang.String str2 = this.hostnameCache.get(str);
        if (str2 != null) {
            return this.entries.get(str2);
        }
        java.lang.String matchingCN = getMatchingCN(str);
        if (matchingCN == null) {
            return null;
        }
        this.hostnameCache.put(str, matchingCN);
        return this.entries.get(matchingCN);
    }

    private java.lang.String readPinFile() throws com.commonsware.cwac.netsecurity.conscrypt.PinManagerException {
        try {
            return slurp(new java.io.FileInputStream(this.pinFile.getPath()));
        } catch (java.io.FileNotFoundException unused) {
            return null;
        } catch (java.io.IOException e) {
            throw new com.commonsware.cwac.netsecurity.conscrypt.PinManagerException("Unexpected error reading pin list; failing.", e);
        }
    }

    public static java.lang.String slurp(java.io.InputStream inputStream) throws java.io.IOException {
        char[] cArr = new char[128];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(inputStream, "UTF-8");
        while (true) {
            int read = inputStreamReader.read(cArr, 0, 128);
            if (read < 0) {
                inputStream.close();
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public boolean isChainValid(java.lang.String str, java.util.List<java.security.cert.X509Certificate> list) throws com.commonsware.cwac.netsecurity.conscrypt.PinManagerException {
        com.commonsware.cwac.netsecurity.conscrypt.PinListEntry lookup = lookup(str);
        if (lookup == null) {
            return true;
        }
        return lookup.isChainValid(list);
    }
}
