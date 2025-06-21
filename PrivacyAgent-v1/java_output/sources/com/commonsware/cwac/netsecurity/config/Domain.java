package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class Domain {
    public final java.lang.String hostname;
    public final boolean subdomainsIncluded;

    public Domain(java.lang.String str, boolean z) {
        if (str == null) {
            throw new java.lang.NullPointerException("Hostname must not be null");
        }
        this.hostname = str.toLowerCase(java.util.Locale.US);
        this.subdomainsIncluded = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.commonsware.cwac.netsecurity.config.Domain)) {
            return false;
        }
        com.commonsware.cwac.netsecurity.config.Domain domain = (com.commonsware.cwac.netsecurity.config.Domain) obj;
        return domain.subdomainsIncluded == this.subdomainsIncluded && domain.hostname.equals(this.hostname);
    }

    public int hashCode() {
        return this.hostname.hashCode() ^ (this.subdomainsIncluded ? 1231 : 1237);
    }
}
