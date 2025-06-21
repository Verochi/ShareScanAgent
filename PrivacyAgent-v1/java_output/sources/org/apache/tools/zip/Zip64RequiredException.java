package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class Zip64RequiredException extends java.util.zip.ZipException {
    static final java.lang.String ARCHIVE_TOO_BIG_MESSAGE = "archive's size exceeds the limit of 4GByte.";
    static final java.lang.String TOO_MANY_ENTRIES_MESSAGE = "archive contains more than 65535 entries.";
    private static final long serialVersionUID = 20110809;

    public Zip64RequiredException(java.lang.String str) {
        super(str);
    }

    public static java.lang.String getEntryTooBigMessage(org.apache.tools.zip.ZipEntry zipEntry) {
        return zipEntry.getName() + "'s size exceeds the limit of 4GByte.";
    }
}
