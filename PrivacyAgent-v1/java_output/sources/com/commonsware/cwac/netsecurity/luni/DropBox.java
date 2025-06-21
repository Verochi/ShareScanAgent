package com.commonsware.cwac.netsecurity.luni;

/* loaded from: classes22.dex */
public final class DropBox {
    private static volatile com.commonsware.cwac.netsecurity.luni.DropBox.Reporter REPORTER = new com.commonsware.cwac.netsecurity.luni.DropBox.DefaultReporter(null);

    public static final class DefaultReporter implements com.commonsware.cwac.netsecurity.luni.DropBox.Reporter {
        private DefaultReporter() {
        }

        public /* synthetic */ DefaultReporter(com.commonsware.cwac.netsecurity.luni.DropBox.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.commonsware.cwac.netsecurity.luni.DropBox.Reporter
        public void addData(java.lang.String str, byte[] bArr, int i) {
            java.lang.System.out.println(str + ": " + com.commonsware.cwac.netsecurity.luni.Base64.encode(bArr));
        }

        @Override // com.commonsware.cwac.netsecurity.luni.DropBox.Reporter
        public void addText(java.lang.String str, java.lang.String str2) {
            java.lang.System.out.println(str + ": " + str2);
        }
    }

    public interface Reporter {
        void addData(java.lang.String str, byte[] bArr, int i);

        void addText(java.lang.String str, java.lang.String str2);
    }

    public static void addData(java.lang.String str, byte[] bArr, int i) {
        getReporter().addData(str, bArr, i);
    }

    public static void addText(java.lang.String str, java.lang.String str2) {
        getReporter().addText(str, str2);
    }

    public static com.commonsware.cwac.netsecurity.luni.DropBox.Reporter getReporter() {
        return REPORTER;
    }

    public static void setReporter(com.commonsware.cwac.netsecurity.luni.DropBox.Reporter reporter) {
        if (reporter == null) {
            throw new java.lang.NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }
}
