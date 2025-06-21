package org.apache.tools.ant.listener;

/* loaded from: classes25.dex */
public class MailLogger extends org.apache.tools.ant.DefaultLogger {
    public java.lang.StringBuffer t = new java.lang.StringBuffer();

    public static class Values {
        public java.lang.String a;
        public int b;
        public java.lang.String c;
        public java.lang.String d;
        public boolean e;
        public java.lang.String f;
        public java.lang.String g;
        public java.lang.String h;
        public java.lang.String i;
        public java.lang.String j;
        public java.lang.String k;
        public java.lang.String l;
        public java.lang.String m;
        public java.lang.String n;
        public boolean o;

        public Values() {
        }

        public /* synthetic */ Values(org.apache.tools.ant.listener.MailLogger.AnonymousClass1 anonymousClass1) {
            this();
        }

        public java.lang.String A() {
            return this.h;
        }

        public org.apache.tools.ant.listener.MailLogger.Values B(java.lang.String str) {
            this.h = str;
            return this;
        }

        public java.lang.String C() {
            return this.c;
        }

        public org.apache.tools.ant.listener.MailLogger.Values D(java.lang.String str) {
            this.c = str;
            return this;
        }

        public java.lang.String a() {
            return this.n;
        }

        public org.apache.tools.ant.listener.MailLogger.Values b(java.lang.String str) {
            this.n = str;
            return this;
        }

        public java.lang.String c() {
            return this.l;
        }

        public org.apache.tools.ant.listener.MailLogger.Values d(java.lang.String str) {
            this.l = str;
            return this;
        }

        public java.lang.String e() {
            return this.f;
        }

        public org.apache.tools.ant.listener.MailLogger.Values f(java.lang.String str) {
            this.f = str;
            return this;
        }

        public java.lang.String g() {
            return this.a;
        }

        public org.apache.tools.ant.listener.MailLogger.Values h(java.lang.String str) {
            this.a = str;
            return this;
        }

        public java.lang.String i() {
            return this.m;
        }

        public org.apache.tools.ant.listener.MailLogger.Values j(java.lang.String str) {
            this.m = str;
            return this;
        }

        public java.lang.String k() {
            return this.d;
        }

        public org.apache.tools.ant.listener.MailLogger.Values l(java.lang.String str) {
            this.d = str;
            return this;
        }

        public int m() {
            return this.b;
        }

        public org.apache.tools.ant.listener.MailLogger.Values n(int i) {
            this.b = i;
            return this;
        }

        public java.lang.String o() {
            return this.g;
        }

        public org.apache.tools.ant.listener.MailLogger.Values p(java.lang.String str) {
            this.g = str;
            return this;
        }

        public org.apache.tools.ant.listener.MailLogger.Values q(boolean z) {
            this.e = z;
            return this;
        }

        public boolean r() {
            return this.e;
        }

        public org.apache.tools.ant.listener.MailLogger.Values s(boolean z) {
            this.o = z;
            return this;
        }

        public boolean t() {
            return this.o;
        }

        public java.lang.String u() {
            return this.k;
        }

        public org.apache.tools.ant.listener.MailLogger.Values v(java.lang.String str) {
            this.k = str;
            return this;
        }

        public java.lang.String w() {
            return this.j;
        }

        public org.apache.tools.ant.listener.MailLogger.Values x(java.lang.String str) {
            this.j = str;
            return this;
        }

        public java.lang.String y() {
            return this.i;
        }

        public org.apache.tools.ant.listener.MailLogger.Values z(java.lang.String str) {
            this.i = str;
            return this;
        }
    }

    public final java.lang.String b(java.util.Hashtable<java.lang.String, java.lang.Object> hashtable, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = "MailLogger." + str;
        java.lang.String str4 = (java.lang.String) hashtable.get(str3);
        if (str4 != null) {
            str2 = str4;
        }
        if (str2 != null) {
            return str2;
        }
        throw new java.lang.RuntimeException("Missing required parameter: " + str3);
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        java.io.FileInputStream fileInputStream;
        super.buildFinished(buildEvent);
        org.apache.tools.ant.Project project = buildEvent.getProject();
        java.util.Hashtable<java.lang.String, java.lang.Object> properties = project.getProperties();
        java.util.Properties properties2 = new java.util.Properties();
        java.lang.String str = (java.lang.String) properties.get("MailLogger.properties.file");
        java.io.FileInputStream fileInputStream2 = null;
        if (str != null) {
            try {
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    properties2.load(fileInputStream);
                } catch (java.io.IOException unused) {
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                    throw th;
                }
            } catch (java.io.IOException unused2) {
                fileInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
        }
        java.util.Enumeration keys = properties2.keys();
        while (keys.hasMoreElements()) {
            java.lang.String str2 = (java.lang.String) keys.nextElement();
            properties.put(str2, project.replaceProperties(properties2.getProperty(str2)));
        }
        boolean z = buildEvent.getException() == null;
        java.lang.String str3 = z ? "success" : "failure";
        try {
            if (org.apache.tools.ant.Project.toBoolean(b(properties, str3 + ".notify", kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON))) {
                org.apache.tools.ant.listener.MailLogger.Values v = new org.apache.tools.ant.listener.MailLogger.Values(null).h(b(properties, "mailhost", org.apache.tools.mail.MailMessage.DEFAULT_HOST)).n(java.lang.Integer.parseInt(b(properties, tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, java.lang.String.valueOf(25)))).D(b(properties, com.umeng.analytics.pro.ay.m, "")).l(b(properties, "password", "")).q(org.apache.tools.ant.Project.toBoolean(b(properties, "ssl", kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF))).s(org.apache.tools.ant.Project.toBoolean(b(properties, "starttls.enable", kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF))).f(b(properties, "from", null)).p(b(properties, "replyto", "")).B(b(properties, str3 + ".to", null)).z(b(properties, str3 + ".cc", "")).x(b(properties, str3 + ".bcc", "")).j(b(properties, "mimeType", com.baidu.mobads.sdk.internal.am.e)).d(b(properties, "charset", "")).b(b(properties, str3 + ".body", "")).v(b(properties, str3 + ".subject", z ? "Build Success" : "Build Failure"));
                if (!v.C().equals("") || !v.k().equals("") || v.r() || v.t()) {
                    d(buildEvent.getProject(), v, this.t.substring(0));
                } else {
                    c(v, this.t.substring(0));
                }
            }
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("MailLogger failed to send e-mail!");
            e.printStackTrace(java.lang.System.err);
        }
    }

    public final void c(org.apache.tools.ant.listener.MailLogger.Values values, java.lang.String str) throws java.io.IOException {
        org.apache.tools.mail.MailMessage mailMessage = new org.apache.tools.mail.MailMessage(values.g(), values.m());
        mailMessage.setHeader("Date", org.apache.tools.ant.util.DateUtils.getDateForHeader());
        mailMessage.from(values.e());
        if (!values.o().equals("")) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(values.o(), ", ", false);
            while (stringTokenizer.hasMoreTokens()) {
                mailMessage.replyto(stringTokenizer.nextToken());
            }
        }
        java.util.StringTokenizer stringTokenizer2 = new java.util.StringTokenizer(values.A(), ", ", false);
        while (stringTokenizer2.hasMoreTokens()) {
            mailMessage.to(stringTokenizer2.nextToken());
        }
        mailMessage.setSubject(values.u());
        if (values.c().length() > 0) {
            mailMessage.setHeader("Content-Type", values.i() + "; charset=\"" + values.c() + "\"");
        } else {
            mailMessage.setHeader("Content-Type", values.i());
        }
        java.io.PrintStream printStream = mailMessage.getPrintStream();
        if (values.a().length() > 0) {
            str = values.a();
        }
        printStream.println(str);
        mailMessage.sendAndClose();
    }

    public final void d(org.apache.tools.ant.Project project, org.apache.tools.ant.listener.MailLogger.Values values, java.lang.String str) {
        try {
            org.apache.tools.ant.taskdefs.email.Mailer mailer = (org.apache.tools.ant.taskdefs.email.Mailer) org.apache.tools.ant.util.ClasspathUtils.newInstance("org.apache.tools.ant.taskdefs.email.MimeMailer", org.apache.tools.ant.listener.MailLogger.class.getClassLoader(), org.apache.tools.ant.taskdefs.email.Mailer.class);
            java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> e = e(values.o());
            mailer.setHost(values.g());
            mailer.setPort(values.m());
            mailer.setUser(values.C());
            mailer.setPassword(values.k());
            mailer.setSSL(values.r());
            mailer.setEnableStartTLS(values.t());
            if (values.a().length() > 0) {
                str = values.a();
            }
            org.apache.tools.ant.taskdefs.email.Message message = new org.apache.tools.ant.taskdefs.email.Message(str);
            message.setProject(project);
            message.setMimeType(values.i());
            if (values.c().length() > 0) {
                message.setCharset(values.c());
            }
            mailer.setMessage(message);
            mailer.setFrom(new org.apache.tools.ant.taskdefs.email.EmailAddress(values.e()));
            mailer.setReplyToList(e);
            mailer.setToList(e(values.A()));
            mailer.setCcList(e(values.y()));
            mailer.setBccList(e(values.w()));
            mailer.setFiles(new java.util.Vector<>());
            mailer.setSubject(values.u());
            mailer.setHeaders(new java.util.Vector<>());
            mailer.send();
        } catch (org.apache.tools.ant.BuildException e2) {
            e = e2;
            if (e.getCause() != null) {
                e = e.getCause();
            }
            log("Failed to initialise MIME mail: " + e.getMessage());
        }
    }

    public final java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> e(java.lang.String str) {
        java.util.Vector<org.apache.tools.ant.taskdefs.email.EmailAddress> vector = new java.util.Vector<>();
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(new org.apache.tools.ant.taskdefs.email.EmailAddress(stringTokenizer.nextToken()));
        }
        return vector;
    }

    @Override // org.apache.tools.ant.DefaultLogger
    public void log(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = this.t;
        stringBuffer.append(str);
        stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
    }
}
