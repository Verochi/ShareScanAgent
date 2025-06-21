package org.apache.tools.ant.taskdefs.email;

/* loaded from: classes25.dex */
public class EmailTask extends org.apache.tools.ant.Task {
    public static final java.lang.String AUTO = "auto";
    public static final java.lang.String MIME = "mime";
    public static final java.lang.String PLAIN = "plain";
    public static final java.lang.String UU = "uu";
    public java.lang.String C;
    public java.lang.String u = "auto";
    public java.lang.String v = org.apache.tools.mail.MailMessage.DEFAULT_HOST;
    public java.lang.Integer w = null;
    public java.lang.String x = null;
    public org.apache.tools.ant.taskdefs.email.Message y = null;
    public boolean z = true;
    public boolean A = false;
    public java.lang.String B = null;
    public org.apache.tools.ant.taskdefs.email.EmailAddress D = null;
    public java.util.Vector E = new java.util.Vector();
    public java.util.Vector F = new java.util.Vector();
    public java.util.Vector G = new java.util.Vector();
    public java.util.Vector H = new java.util.Vector();
    public java.util.Vector I = new java.util.Vector();
    public org.apache.tools.ant.types.Path J = null;
    public java.lang.String K = null;
    public java.lang.String L = null;
    public java.lang.String M = null;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;

    public static class Encoding extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"auto", "mime", org.apache.tools.ant.taskdefs.email.EmailTask.UU, org.apache.tools.ant.taskdefs.email.EmailTask.PLAIN};
        }
    }

    public void addBcc(org.apache.tools.ant.taskdefs.email.EmailAddress emailAddress) {
        this.H.addElement(emailAddress);
    }

    public void addCc(org.apache.tools.ant.taskdefs.email.EmailAddress emailAddress) {
        this.G.addElement(emailAddress);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        createAttachments().add(fileSet);
    }

    public void addFrom(org.apache.tools.ant.taskdefs.email.EmailAddress emailAddress) {
        if (this.D != null) {
            throw new org.apache.tools.ant.BuildException("Emails can only be from one address");
        }
        this.D = emailAddress;
    }

    public void addMessage(org.apache.tools.ant.taskdefs.email.Message message) throws org.apache.tools.ant.BuildException {
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("Only one message can be sent in an email");
        }
        this.y = message;
    }

    public void addReplyTo(org.apache.tools.ant.taskdefs.email.EmailAddress emailAddress) {
        this.E.add(emailAddress);
    }

    public void addTo(org.apache.tools.ant.taskdefs.email.EmailAddress emailAddress) {
        this.F.addElement(emailAddress);
    }

    public final void c(java.lang.String str, org.apache.tools.ant.BuildException buildException) {
        java.lang.Throwable cause = buildException.getCause();
        java.lang.Throwable th = buildException;
        if (cause != null) {
            th = buildException.getCause();
        }
        log(str + th.getMessage(), 1);
    }

    public org.apache.tools.ant.types.Path createAttachments() {
        if (this.J == null) {
            this.J = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.J.createPath();
    }

    public org.apache.tools.ant.taskdefs.email.Header createHeader() {
        org.apache.tools.ant.taskdefs.email.Header header = new org.apache.tools.ant.taskdefs.email.Header();
        this.I.add(header);
        return header;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        if (r14.N != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        if (r14.O == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0086, code lost:
    
        if (r14.u.equals(org.apache.tools.ant.taskdefs.email.EmailTask.UU) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        if (r14.u.equals(org.apache.tools.ant.taskdefs.email.EmailTask.PLAIN) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
    
        throw new org.apache.tools.ant.BuildException("SSL and STARTTLS only possible with MIME mail");
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1 A[Catch: all -> 0x02c5, Exception -> 0x02c7, BuildException -> 0x02e9, TryCatch #5 {BuildException -> 0x02e9, blocks: (B:3:0x0005, B:6:0x0018, B:11:0x0055, B:13:0x0059, B:15:0x005d, B:17:0x0065, B:20:0x006e, B:21:0x0075, B:24:0x0078, B:26:0x007c, B:28:0x0080, B:30:0x0088, B:33:0x0091, B:34:0x0098, B:35:0x0099, B:37:0x00a1, B:40:0x00c9, B:42:0x00d1, B:46:0x00e7, B:48:0x00eb, B:49:0x00f9, B:51:0x00fd, B:53:0x0103, B:55:0x010b, B:57:0x0113, B:60:0x011c, B:61:0x0123, B:62:0x0124, B:64:0x0128, B:66:0x0130, B:67:0x0138, B:68:0x013f, B:69:0x0140, B:71:0x0144, B:73:0x014c, B:74:0x0154, B:75:0x015b, B:76:0x015c, B:78:0x016c, B:79:0x0170, B:81:0x0176, B:83:0x018c, B:85:0x021a, B:86:0x022d, B:89:0x0299, B:93:0x0225, B:94:0x02a4, B:95:0x02ab, B:96:0x02ac, B:97:0x02c4, B:98:0x00db, B:107:0x00c4, B:118:0x0049), top: B:2:0x0005, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[Catch: all -> 0x02c5, Exception -> 0x02c7, BuildException -> 0x02e9, TryCatch #5 {BuildException -> 0x02e9, blocks: (B:3:0x0005, B:6:0x0018, B:11:0x0055, B:13:0x0059, B:15:0x005d, B:17:0x0065, B:20:0x006e, B:21:0x0075, B:24:0x0078, B:26:0x007c, B:28:0x0080, B:30:0x0088, B:33:0x0091, B:34:0x0098, B:35:0x0099, B:37:0x00a1, B:40:0x00c9, B:42:0x00d1, B:46:0x00e7, B:48:0x00eb, B:49:0x00f9, B:51:0x00fd, B:53:0x0103, B:55:0x010b, B:57:0x0113, B:60:0x011c, B:61:0x0123, B:62:0x0124, B:64:0x0128, B:66:0x0130, B:67:0x0138, B:68:0x013f, B:69:0x0140, B:71:0x0144, B:73:0x014c, B:74:0x0154, B:75:0x015b, B:76:0x015c, B:78:0x016c, B:79:0x0170, B:81:0x0176, B:83:0x018c, B:85:0x021a, B:86:0x022d, B:89:0x0299, B:93:0x0225, B:94:0x02a4, B:95:0x02ab, B:96:0x02ac, B:97:0x02c4, B:98:0x00db, B:107:0x00c4, B:118:0x0049), top: B:2:0x0005, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ac A[Catch: all -> 0x02c5, Exception -> 0x02c7, BuildException -> 0x02e9, TryCatch #5 {BuildException -> 0x02e9, blocks: (B:3:0x0005, B:6:0x0018, B:11:0x0055, B:13:0x0059, B:15:0x005d, B:17:0x0065, B:20:0x006e, B:21:0x0075, B:24:0x0078, B:26:0x007c, B:28:0x0080, B:30:0x0088, B:33:0x0091, B:34:0x0098, B:35:0x0099, B:37:0x00a1, B:40:0x00c9, B:42:0x00d1, B:46:0x00e7, B:48:0x00eb, B:49:0x00f9, B:51:0x00fd, B:53:0x0103, B:55:0x010b, B:57:0x0113, B:60:0x011c, B:61:0x0123, B:62:0x0124, B:64:0x0128, B:66:0x0130, B:67:0x0138, B:68:0x013f, B:69:0x0140, B:71:0x0144, B:73:0x014c, B:74:0x0154, B:75:0x015b, B:76:0x015c, B:78:0x016c, B:79:0x0170, B:81:0x0176, B:83:0x018c, B:85:0x021a, B:86:0x022d, B:89:0x0299, B:93:0x0225, B:94:0x02a4, B:95:0x02ab, B:96:0x02ac, B:97:0x02c4, B:98:0x00db, B:107:0x00c4, B:118:0x0049), top: B:2:0x0005, outer: #2 }] */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() {
        org.apache.tools.ant.taskdefs.email.Mailer mailer;
        boolean z;
        org.apache.tools.ant.BuildException e;
        org.apache.tools.ant.taskdefs.email.Mailer mailer2;
        org.apache.tools.ant.taskdefs.email.Mailer mailer3;
        org.apache.tools.ant.taskdefs.email.Message message = this.y;
        try {
            try {
                try {
                    mailer = null;
                    if (this.u.equals("mime") || this.u.equals("auto")) {
                        try {
                            java.lang.Class.forName("javax.activation.DataHandler");
                            java.lang.Class.forName("javax.mail.internet.MimeMessage");
                            mailer2 = (org.apache.tools.ant.taskdefs.email.Mailer) org.apache.tools.ant.util.ClasspathUtils.newInstance("org.apache.tools.ant.taskdefs.email.MimeMailer", org.apache.tools.ant.taskdefs.email.EmailTask.class.getClassLoader(), org.apache.tools.ant.taskdefs.email.Mailer.class);
                            try {
                                log("Using MIME mail", 3);
                                mailer = mailer2;
                                z = true;
                            } catch (org.apache.tools.ant.BuildException e2) {
                                e = e2;
                                z = true;
                                c("Failed to initialise MIME mail: ", e);
                                mailer = mailer2;
                                if (!z) {
                                    throw new org.apache.tools.ant.BuildException("SMTP auth only possible with MIME mail");
                                }
                                if (!this.u.equals(UU)) {
                                }
                                try {
                                    mailer3 = (org.apache.tools.ant.taskdefs.email.Mailer) org.apache.tools.ant.util.ClasspathUtils.newInstance("org.apache.tools.ant.taskdefs.email.UUMailer", org.apache.tools.ant.taskdefs.email.EmailTask.class.getClassLoader(), org.apache.tools.ant.taskdefs.email.Mailer.class);
                                    try {
                                        log("Using UU mail", 3);
                                        mailer = mailer3;
                                        z = true;
                                    } catch (org.apache.tools.ant.BuildException e3) {
                                        e = e3;
                                        mailer = mailer3;
                                        z = true;
                                        c("Failed to initialise UU mail: ", e);
                                        if (!this.u.equals(PLAIN)) {
                                        }
                                        mailer = new org.apache.tools.ant.taskdefs.email.PlainMailer();
                                        log("Using plain mail", 3);
                                        if (mailer == null) {
                                        }
                                    }
                                } catch (org.apache.tools.ant.BuildException e4) {
                                    e = e4;
                                }
                                if (!this.u.equals(PLAIN)) {
                                }
                                mailer = new org.apache.tools.ant.taskdefs.email.PlainMailer();
                                log("Using plain mail", 3);
                                if (mailer == null) {
                                }
                            }
                        } catch (org.apache.tools.ant.BuildException e5) {
                            z = false;
                            e = e5;
                            mailer2 = null;
                        }
                    } else {
                        z = false;
                    }
                    if (!z && ((this.L != null || this.M != null) && (this.u.equals(UU) || this.u.equals(PLAIN)))) {
                        throw new org.apache.tools.ant.BuildException("SMTP auth only possible with MIME mail");
                    }
                    if (!this.u.equals(UU) || (this.u.equals("auto") && !z)) {
                        mailer3 = (org.apache.tools.ant.taskdefs.email.Mailer) org.apache.tools.ant.util.ClasspathUtils.newInstance("org.apache.tools.ant.taskdefs.email.UUMailer", org.apache.tools.ant.taskdefs.email.EmailTask.class.getClassLoader(), org.apache.tools.ant.taskdefs.email.Mailer.class);
                        log("Using UU mail", 3);
                        mailer = mailer3;
                        z = true;
                    }
                    if (!this.u.equals(PLAIN) || (this.u.equals("auto") && !z)) {
                        mailer = new org.apache.tools.ant.taskdefs.email.PlainMailer();
                        log("Using plain mail", 3);
                    }
                } finally {
                    this.y = message;
                }
            } catch (org.apache.tools.ant.BuildException e6) {
                c("Failed to send email: ", e6);
                if (this.z) {
                    throw e6;
                }
            }
        } catch (java.lang.Exception e7) {
            log("Failed to send email: " + e7.getMessage(), 1);
            if (this.z) {
                throw new org.apache.tools.ant.BuildException(e7);
            }
        }
        if (mailer == null) {
            throw new org.apache.tools.ant.BuildException("Failed to initialise encoding: " + this.u);
        }
        if (this.y == null) {
            org.apache.tools.ant.taskdefs.email.Message message2 = new org.apache.tools.ant.taskdefs.email.Message();
            this.y = message2;
            message2.setProject(getProject());
        }
        org.apache.tools.ant.taskdefs.email.EmailAddress emailAddress = this.D;
        if (emailAddress == null || emailAddress.getAddress() == null) {
            throw new org.apache.tools.ant.BuildException("A from element is required");
        }
        if (this.F.isEmpty() && this.G.isEmpty() && this.H.isEmpty()) {
            throw new org.apache.tools.ant.BuildException("At least one of to, cc or bcc must be supplied");
        }
        if (this.B != null) {
            if (this.y.isMimeTypeSpecified()) {
                throw new org.apache.tools.ant.BuildException("The mime type can only be specified in one location");
            }
            this.y.setMimeType(this.B);
        }
        if (this.K != null) {
            if (this.y.getCharset() != null) {
                throw new org.apache.tools.ant.BuildException("The charset can only be specified in one location");
            }
            this.y.setCharset(this.K);
        }
        this.y.setInputEncoding(this.C);
        java.util.Vector<java.io.File> vector = new java.util.Vector<>();
        org.apache.tools.ant.types.Path path = this.J;
        if (path != null) {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = path.iterator();
            while (it.hasNext()) {
                vector.addElement(((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile());
            }
        }
        log("Sending email: " + this.x, 2);
        log("From " + this.D, 3);
        log("ReplyTo " + this.E, 3);
        log("To " + this.F, 3);
        log("Cc " + this.G, 3);
        log("Bcc " + this.H, 3);
        mailer.setHost(this.v);
        java.lang.Integer num = this.w;
        if (num != null) {
            mailer.setPort(num.intValue());
            mailer.setPortExplicitlySpecified(true);
        } else {
            mailer.setPort(25);
            mailer.setPortExplicitlySpecified(false);
        }
        mailer.setUser(this.L);
        mailer.setPassword(this.M);
        mailer.setSSL(this.N);
        mailer.setEnableStartTLS(this.O);
        mailer.setMessage(this.y);
        mailer.setFrom(this.D);
        mailer.setReplyToList(this.E);
        mailer.setToList(this.F);
        mailer.setCcList(this.G);
        mailer.setBccList(this.H);
        mailer.setFiles(vector);
        mailer.setSubject(this.x);
        mailer.setTask(this);
        mailer.setIncludeFileNames(this.A);
        mailer.setHeaders(this.I);
        mailer.setIgnoreInvalidRecipients(this.P);
        mailer.send();
        int size = vector.size();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Sent email with ");
        sb.append(size);
        sb.append(" attachment");
        sb.append(size == 1 ? "" : "s");
        log(sb.toString(), 2);
    }

    public java.lang.String getCharset() {
        return this.K;
    }

    public boolean getIncludeFileNames() {
        return this.A;
    }

    public void setBccList(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            this.H.addElement(new org.apache.tools.ant.taskdefs.email.EmailAddress(stringTokenizer.nextToken()));
        }
    }

    public void setCcList(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            this.G.addElement(new org.apache.tools.ant.taskdefs.email.EmailAddress(stringTokenizer.nextToken()));
        }
    }

    public void setCharset(java.lang.String str) {
        this.K = str;
    }

    public void setEnableStartTLS(boolean z) {
        this.O = z;
    }

    public void setEncoding(org.apache.tools.ant.taskdefs.email.EmailTask.Encoding encoding) {
        this.u = encoding.getValue();
    }

    public void setFailOnError(boolean z) {
        this.z = z;
    }

    public void setFiles(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ", ");
        while (stringTokenizer.hasMoreTokens()) {
            createAttachments().add(new org.apache.tools.ant.types.resources.FileResource(getProject().resolveFile(stringTokenizer.nextToken())));
        }
    }

    public void setFrom(java.lang.String str) {
        if (this.D != null) {
            throw new org.apache.tools.ant.BuildException("Emails can only be from one address");
        }
        this.D = new org.apache.tools.ant.taskdefs.email.EmailAddress(str);
    }

    public void setIgnoreInvalidRecipients(boolean z) {
        this.P = z;
    }

    public void setIncludefilenames(boolean z) {
        this.A = z;
    }

    public void setMailhost(java.lang.String str) {
        this.v = str;
    }

    public void setMailport(int i) {
        this.w = java.lang.Integer.valueOf(i);
    }

    public void setMessage(java.lang.String str) {
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("Only one message can be sent in an email");
        }
        org.apache.tools.ant.taskdefs.email.Message message = new org.apache.tools.ant.taskdefs.email.Message(str);
        this.y = message;
        message.setProject(getProject());
    }

    public void setMessageFile(java.io.File file) {
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("Only one message can be sent in an email");
        }
        org.apache.tools.ant.taskdefs.email.Message message = new org.apache.tools.ant.taskdefs.email.Message(file);
        this.y = message;
        message.setProject(getProject());
    }

    public void setMessageFileInputEncoding(java.lang.String str) {
        this.C = str;
    }

    public void setMessageMimeType(java.lang.String str) {
        this.B = str;
    }

    public void setPassword(java.lang.String str) {
        this.M = str;
    }

    public void setReplyTo(java.lang.String str) {
        this.E.add(new org.apache.tools.ant.taskdefs.email.EmailAddress(str));
    }

    public void setSSL(boolean z) {
        this.N = z;
    }

    public void setSubject(java.lang.String str) {
        this.x = str;
    }

    public void setToList(java.lang.String str) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            this.F.addElement(new org.apache.tools.ant.taskdefs.email.EmailAddress(stringTokenizer.nextToken()));
        }
    }

    public void setUser(java.lang.String str) {
        this.L = str;
    }
}
