package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Http extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n = null;
    public java.lang.String t = "GET";
    public boolean u = true;
    public int v = 400;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        if (this.n == null) {
            throw new org.apache.tools.ant.BuildException("No url specified in http condition");
        }
        log("Checking for " + this.n, 3);
        try {
            try {
                java.net.URLConnection openConnection = new java.net.URL(this.n).openConnection();
                if (!(openConnection instanceof java.net.HttpURLConnection)) {
                    return true;
                }
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod(this.t);
                httpURLConnection.setInstanceFollowRedirects(this.u);
                int responseCode = httpURLConnection.getResponseCode();
                log("Result code for " + this.n + " was " + responseCode, 3);
                if (responseCode > 0) {
                    if (responseCode < this.v) {
                        return true;
                    }
                }
                return false;
            } catch (java.net.ProtocolException e) {
                throw new org.apache.tools.ant.BuildException("Invalid HTTP protocol: " + this.t, e);
            } catch (java.io.IOException unused) {
                return false;
            }
        } catch (java.net.MalformedURLException e2) {
            throw new org.apache.tools.ant.BuildException("Badly formed URL: " + this.n, e2);
        }
    }

    public void setErrorsBeginAt(int i) {
        this.v = i;
    }

    public void setFollowRedirects(boolean z) {
        this.u = z;
    }

    public void setRequestMethod(java.lang.String str) {
        this.t = str == null ? "GET" : str.toUpperCase(java.util.Locale.ENGLISH);
    }

    public void setUrl(java.lang.String str) {
        this.n = str;
    }
}
