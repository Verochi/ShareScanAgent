package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class UnsupportedZipFeatureException extends java.util.zip.ZipException {
    private static final long serialVersionUID = 20161221;
    private final transient org.apache.tools.zip.ZipEntry entry;
    private final org.apache.tools.zip.UnsupportedZipFeatureException.Feature reason;

    public static class Feature implements java.io.Serializable {
        private final java.lang.String name;
        public static final org.apache.tools.zip.UnsupportedZipFeatureException.Feature ENCRYPTION = new org.apache.tools.zip.UnsupportedZipFeatureException.Feature("encryption");
        public static final org.apache.tools.zip.UnsupportedZipFeatureException.Feature METHOD = new org.apache.tools.zip.UnsupportedZipFeatureException.Feature("compression method");
        public static final org.apache.tools.zip.UnsupportedZipFeatureException.Feature DATA_DESCRIPTOR = new org.apache.tools.zip.UnsupportedZipFeatureException.Feature("data descriptor");

        private Feature(java.lang.String str) {
            this.name = str;
        }

        public java.lang.String toString() {
            return this.name;
        }
    }

    public UnsupportedZipFeatureException(org.apache.tools.zip.UnsupportedZipFeatureException.Feature feature, org.apache.tools.zip.ZipEntry zipEntry) {
        super("unsupported feature " + feature + " used in entry " + zipEntry.getName());
        this.reason = feature;
        this.entry = zipEntry;
    }

    public org.apache.tools.zip.ZipEntry getEntry() {
        return this.entry;
    }

    public org.apache.tools.zip.UnsupportedZipFeatureException.Feature getFeature() {
        return this.reason;
    }
}
