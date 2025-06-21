package org.apache.tools.mail;

/* loaded from: classes26.dex */
public class MailMessage {
    public static final java.lang.String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 25;
    public java.lang.String a;
    public int b;
    public java.lang.String c;
    public java.util.Vector<java.lang.String> d;
    public java.util.Vector<java.lang.String> e;
    public java.util.Vector<java.lang.String> f;
    public java.util.Vector<java.lang.String> g;
    public java.util.Vector<java.lang.String> h;
    public org.apache.tools.mail.MailPrintStream i;
    public org.apache.tools.mail.SmtpResponseReader j;
    public java.net.Socket k;

    public MailMessage() throws java.io.IOException {
        this(DEFAULT_HOST, 25);
    }

    public MailMessage(java.lang.String str) throws java.io.IOException {
        this(str, 25);
    }

    public MailMessage(java.lang.String str, int i) throws java.io.IOException {
        this.b = 25;
        this.d = new java.util.Vector<>();
        this.e = new java.util.Vector<>();
        this.f = new java.util.Vector<>();
        this.g = new java.util.Vector<>();
        this.h = new java.util.Vector<>();
        this.b = i;
        this.a = str;
        a();
        k();
    }

    public static java.lang.String f(java.lang.String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '(') {
                i4++;
                i = i3 != 0 ? i + 1 : 0;
                i2 = i;
            } else {
                if (charAt == ')') {
                    i4--;
                    if (i2 != 0) {
                    }
                    i3 = i + 1;
                } else {
                    if (i4 != 0 || charAt != '<') {
                        if (i4 == 0) {
                            if (charAt != '>') {
                            }
                            i2 = i;
                        }
                    }
                    i3 = i + 1;
                }
            }
        }
        if (i2 != 0) {
            length = i2;
        }
        return str.substring(i3, length);
    }

    public void a() throws java.io.IOException {
        this.k = new java.net.Socket(this.a, this.b);
        this.i = new org.apache.tools.mail.MailPrintStream(new java.io.BufferedOutputStream(this.k.getOutputStream()));
        this.j = new org.apache.tools.mail.SmtpResponseReader(this.k.getInputStream());
        d();
    }

    public void b() {
        org.apache.tools.mail.MailPrintStream mailPrintStream = this.i;
        if (mailPrintStream != null) {
            mailPrintStream.close();
        }
        org.apache.tools.mail.SmtpResponseReader smtpResponseReader = this.j;
        if (smtpResponseReader != null) {
            try {
                smtpResponseReader.close();
            } catch (java.io.IOException unused) {
            }
        }
        java.net.Socket socket = this.k;
        if (socket != null) {
            try {
                socket.close();
            } catch (java.io.IOException unused2) {
            }
        }
    }

    public void bcc(java.lang.String str) throws java.io.IOException {
        m(str);
    }

    public void c() {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            java.lang.String elementAt = this.g.elementAt(i);
            java.lang.String elementAt2 = this.h.elementAt(i);
            this.i.println(elementAt + ": " + elementAt2);
        }
        this.i.println();
        this.i.flush();
    }

    public void cc(java.lang.String str) throws java.io.IOException {
        m(str);
        this.f.addElement(str);
    }

    public void d() throws java.io.IOException {
        java.lang.String response = this.j.getResponse();
        if (e(response, new int[]{220})) {
            return;
        }
        throw new java.io.IOException("Didn't get introduction from server: " + response);
    }

    public boolean e(java.lang.String str, int[] iArr) {
        for (int i : iArr) {
            if (str.startsWith("" + i)) {
                return true;
            }
        }
        return false;
    }

    public void from(java.lang.String str) throws java.io.IOException {
        j(str);
        this.c = str;
    }

    public void g(java.lang.String str, int[] iArr) throws java.io.IOException {
        this.i.a(str + "\r\n");
        java.lang.String response = this.j.getResponse();
        if (e(response, iArr)) {
            return;
        }
        throw new java.io.IOException("Unexpected reply to command: " + str + ": " + response);
    }

    public java.io.PrintStream getPrintStream() throws java.io.IOException {
        o();
        p();
        q();
        n();
        setHeader("X-Mailer", "org.apache.tools.mail.MailMessage (ant.apache.org)");
        h();
        c();
        return this.i;
    }

    public void h() throws java.io.IOException {
        g("DATA", new int[]{354});
    }

    public void i() throws java.io.IOException {
        g("\r\n.", new int[]{250});
    }

    public void j(java.lang.String str) throws java.io.IOException {
        g("MAIL FROM: <" + f(str) + ">", new int[]{250});
    }

    public void k() throws java.io.IOException {
        g("HELO " + java.net.InetAddress.getLocalHost().getHostName(), new int[]{250});
    }

    public void l() throws java.io.IOException {
        try {
            g("QUIT", new int[]{221});
        } catch (java.io.IOException e) {
            throw new org.apache.tools.mail.ErrorInQuitException(e);
        }
    }

    public void m(java.lang.String str) throws java.io.IOException {
        g("RCPT TO: <" + f(str) + ">", new int[]{250, 251});
    }

    public void n() {
        if (this.f.isEmpty()) {
            return;
        }
        setHeader("Cc", r(this.f));
    }

    public void o() {
        setHeader("From", this.c);
    }

    public void p() {
        if (this.d.isEmpty()) {
            return;
        }
        setHeader("Reply-To", r(this.d));
    }

    public void q() {
        if (this.e.isEmpty()) {
            return;
        }
        setHeader("To", r(this.e));
    }

    public java.lang.String r(java.util.Vector vector) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            stringBuffer.append(elements.nextElement());
            if (elements.hasMoreElements()) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    public void replyto(java.lang.String str) {
        this.d.addElement(str);
    }

    public void sendAndClose() throws java.io.IOException {
        try {
            i();
            l();
        } finally {
            b();
        }
    }

    public void setHeader(java.lang.String str, java.lang.String str2) {
        this.g.add(str);
        this.h.add(str2);
    }

    public void setPort(int i) {
        this.b = i;
    }

    public void setSubject(java.lang.String str) {
        setHeader("Subject", str);
    }

    public void to(java.lang.String str) throws java.io.IOException {
        m(str);
        this.e.addElement(str);
    }
}
