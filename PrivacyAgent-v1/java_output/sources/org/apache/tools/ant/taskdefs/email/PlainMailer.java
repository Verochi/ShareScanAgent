package org.apache.tools.ant.taskdefs.email;

/* loaded from: classes25.dex */
class PlainMailer extends org.apache.tools.ant.taskdefs.email.Mailer {
    public void a(java.io.File file, java.io.PrintStream printStream) throws java.io.IOException {
        if (!file.exists() || !file.canRead()) {
            throw new org.apache.tools.ant.BuildException("File \"" + file.getName() + "\" does not exist or is not readable.");
        }
        if (this.includeFileNames) {
            printStream.println();
            java.lang.String name = file.getName();
            int length = name.length();
            printStream.println(name);
            for (int i = 0; i < length; i++) {
                printStream.print(com.alipay.sdk.m.n.a.h);
            }
            printStream.println();
        }
        byte[] bArr = new byte[1024];
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(fileInputStream, 1024);
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    return;
                } else {
                    printStream.write(bArr, 0, read);
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    public final void b(java.lang.String str, java.io.IOException iOException) {
        java.lang.String str2 = "Failed to send mail to " + str;
        if (!shouldIgnoreInvalidRecipients()) {
            throw new org.apache.tools.ant.BuildException(str2, iOException);
        }
        java.lang.String str3 = str2 + " because of :" + iOException.getMessage();
        org.apache.tools.ant.Task task = this.task;
        if (task != null) {
            task.log(str3, 1);
        } else {
            java.lang.System.err.println(str3);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.email.Mailer
    public void send() {
        try {
            org.apache.tools.mail.MailMessage mailMessage = new org.apache.tools.mail.MailMessage(this.host, this.port);
            mailMessage.from(this.from.toString());
            java.util.Enumeration<org.apache.tools.ant.taskdefs.email.EmailAddress> elements = this.replyToList.elements();
            while (elements.hasMoreElements()) {
                mailMessage.replyto(elements.nextElement().toString());
            }
            java.util.Enumeration<org.apache.tools.ant.taskdefs.email.EmailAddress> elements2 = this.toList.elements();
            boolean z = false;
            while (elements2.hasMoreElements()) {
                java.lang.String obj = elements2.nextElement().toString();
                try {
                    mailMessage.to(obj);
                    z = true;
                } catch (java.io.IOException e) {
                    b(obj, e);
                }
            }
            java.util.Enumeration<org.apache.tools.ant.taskdefs.email.EmailAddress> elements3 = this.ccList.elements();
            while (elements3.hasMoreElements()) {
                java.lang.String obj2 = elements3.nextElement().toString();
                try {
                    mailMessage.cc(obj2);
                    z = true;
                } catch (java.io.IOException e2) {
                    b(obj2, e2);
                }
            }
            java.util.Enumeration<org.apache.tools.ant.taskdefs.email.EmailAddress> elements4 = this.bccList.elements();
            while (elements4.hasMoreElements()) {
                java.lang.String obj3 = elements4.nextElement().toString();
                try {
                    mailMessage.bcc(obj3);
                    z = true;
                } catch (java.io.IOException e3) {
                    b(obj3, e3);
                }
            }
            if (!z) {
                throw new org.apache.tools.ant.BuildException("Couldn't reach any recipient");
            }
            java.lang.String str = this.subject;
            if (str != null) {
                mailMessage.setSubject(str);
            }
            mailMessage.setHeader("Date", getDate());
            if (this.message.getCharset() != null) {
                mailMessage.setHeader("Content-Type", this.message.getMimeType() + "; charset=\"" + this.message.getCharset() + "\"");
            } else {
                mailMessage.setHeader("Content-Type", this.message.getMimeType());
            }
            java.util.Vector<org.apache.tools.ant.taskdefs.email.Header> vector = this.headers;
            if (vector != null) {
                java.util.Enumeration<org.apache.tools.ant.taskdefs.email.Header> elements5 = vector.elements();
                while (elements5.hasMoreElements()) {
                    org.apache.tools.ant.taskdefs.email.Header nextElement = elements5.nextElement();
                    mailMessage.setHeader(nextElement.getName(), nextElement.getValue());
                }
            }
            java.io.PrintStream printStream = mailMessage.getPrintStream();
            this.message.print(printStream);
            java.util.Enumeration<java.io.File> elements6 = this.files.elements();
            while (elements6.hasMoreElements()) {
                a(elements6.nextElement(), printStream);
            }
            mailMessage.sendAndClose();
        } catch (java.io.IOException e4) {
            throw new org.apache.tools.ant.BuildException("IO error sending mail", e4);
        }
    }
}
