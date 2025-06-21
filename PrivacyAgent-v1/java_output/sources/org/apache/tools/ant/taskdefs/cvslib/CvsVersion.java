package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
public class CvsVersion extends org.apache.tools.ant.taskdefs.AbstractCvsTask {
    public java.lang.String Q;
    public java.lang.String R;
    public java.lang.String S;
    public java.lang.String T;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c9, code lost:
    
        if (r7 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f3, code lost:
    
        if (r1.hasMoreTokens() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f5, code lost:
    
        r10.R = r1.nextToken() + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cf, code lost:
    
        if (r1.hasMoreTokens() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d1, code lost:
    
        r10.Q = r1.nextToken() + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e6, code lost:
    
        r7 = null;
        r3 = false;
        r5 = false;
     */
    @Override // org.apache.tools.ant.taskdefs.AbstractCvsTask, org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        setOutputStream(byteArrayOutputStream);
        setErrorStream(new java.io.ByteArrayOutputStream());
        setCommand("version");
        super.execute();
        java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        log("Received version response \"" + byteArrayOutputStream2 + "\"", 4);
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(byteArrayOutputStream2);
        java.lang.String str = null;
        java.lang.String str2 = null;
        boolean z = false;
        boolean z2 = false;
        loop0: while (true) {
            boolean z3 = false;
            while (true) {
                if (!z && !stringTokenizer.hasMoreTokens()) {
                    break loop0;
                }
                java.lang.String nextToken = z ? str : stringTokenizer.nextToken();
                if (nextToken.equals("Client:")) {
                    z2 = true;
                } else if (nextToken.equals("Server:")) {
                    z3 = true;
                } else if (nextToken.startsWith("(CVS") && nextToken.endsWith(")")) {
                    if (nextToken.length() == 5) {
                        str2 = "";
                    } else {
                        str2 = " " + nextToken;
                    }
                }
                if (!z2 && !z3 && str2 != null && str == null && stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken();
                    z = true;
                } else {
                    if (z3 && str2 != null) {
                        break;
                    }
                    if (!nextToken.equals("(client/server)") || str2 == null || str == null || z2 || z3) {
                        z = false;
                    } else {
                        java.lang.String str3 = str + str2;
                        this.R = str3;
                        this.Q = str3;
                        str = null;
                        str2 = null;
                        z = false;
                        z2 = true;
                        z3 = true;
                    }
                }
            }
            str2 = null;
            z = false;
        }
        if (this.S != null) {
            getProject().setNewProperty(this.S, this.Q);
        }
        if (this.T != null) {
            getProject().setNewProperty(this.T, this.R);
        }
    }

    public java.lang.String getClientVersion() {
        return this.Q;
    }

    public java.lang.String getServerVersion() {
        return this.R;
    }

    public void setClientVersionProperty(java.lang.String str) {
        this.S = str;
    }

    public void setServerVersionProperty(java.lang.String str) {
        this.T = str;
    }

    public boolean supportsCvsLogWithSOption() {
        if (this.R == null) {
            return false;
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(this.R, ".");
        long j = 10000;
        long j2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            int i = 0;
            while (i < nextToken.length() && java.lang.Character.isDigit(nextToken.charAt(i))) {
                i++;
            }
            j2 += java.lang.Long.parseLong(nextToken.substring(0, i)) * j;
            if (j == 1) {
                break;
            }
            j /= 100;
        }
        return j2 >= 11102;
    }
}
