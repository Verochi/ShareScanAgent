package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000d\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\u001a\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001aQ\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\n\u0010\b\u001aa\u0010\r\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\r\u0010\u000e\u001aa\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012\u001aE\u0010\u0016\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0013\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a3\u0010\u0018\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0013\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aE\u0010\u001a\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010\u0013\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0017\u001ay\u0010!\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u001b\"\u0018\b\u0003\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00020\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001d\u001a\u00028\u00032\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ay\u0010#\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u001b\"\u0018\b\u0003\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001d\u001a\u00028\u00032\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010\"\u001aI\u0010%\u001a\u00020$\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b%\u0010&\u001a@\u0010%\u001a\u00020$\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050'\u001a@\u0010%\u001a\u00020$\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050(\u001a\\\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u001b*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u001eH\u0086\bø\u0001\u0000\u001a\\\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u001b*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u001eH\u0086\bø\u0001\u0000\u001aJ\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0\u001eH\u0086\bø\u0001\u0000\u001aJ\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020+0\u001eH\u0086\bø\u0001\u0000\u001as\u0010/\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001d\u001a\u00028\u00022\u001e\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020+0\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b/\u0010\"\u001aV\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020+0\u001eH\u0086\bø\u0001\u0000\u001as\u00101\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001d\u001a\u00028\u00022\u001e\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020+0\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u0010\"\u001aV\u00102\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020+0\u001eH\u0086\bø\u0001\u0000\u001a4\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050'\u001aQ\u00103\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050'2\u0006\u0010\u001d\u001a\u00028\u0002¢\u0006\u0004\b3\u00104\u001a=\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b3\u0010\b\u001aS\u00103\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00042\u0006\u0010\u001d\u001a\u00028\u0002¢\u0006\u0004\b3\u00105\u001a4\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050(\u001aQ\u00103\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050(2\u0006\u0010\u001d\u001a\u00028\u0002¢\u0006\u0004\b3\u00106\u001a2\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001a2\u00107\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001aO\u00103\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u001c*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\t*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001d\u001a\u00028\u0002H\u0007¢\u0006\u0004\b3\u00108\u001aG\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086\u0002\u001aM\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050'H\u0086\u0002\u001aV\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004H\u0086\u0002¢\u0006\u0004\b:\u0010;\u001aM\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050(H\u0086\u0002\u001aI\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010<\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0002\u001aB\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0013\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\b=\u0010>\u001aA\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0087\u0002\u001aJ\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004H\u0087\u0002¢\u0006\u0004\b=\u0010@\u001aA\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0087\u0002\u001a0\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006B"}, d2 = {"K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "emptyMap", "", "Lkotlin/Pair;", "pairs", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "", "mutableMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "hashMapOf", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "linkedMapOf", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "key", "Lkotlin/Function0;", "defaultValue", "getOrElseNullable", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getValue", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrPut", "R", "M", "destination", "Lkotlin/Function1;", "", "transform", "mapValuesTo", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "mapKeysTo", "", "putAll", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "Lkotlin/sequences/Sequence;", "mapValues", "mapKeys", "", "predicate", "filterKeys", "filterValues", "filterTo", "filter", "filterNotTo", "filterNot", "toMap", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "pair", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "map", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "optimizeReadOnlyMap", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/MapsKt")
/* loaded from: classes14.dex */
public class MapsKt__MapsKt extends kotlin.collections.MapsKt__MapsJVMKt {
    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.Map<K, V> emptyMap() {
        kotlin.collections.EmptyMap emptyMap = kotlin.collections.EmptyMap.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> filter(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> filterKeys(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super K, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> filterNot(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M filterNotTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M filterTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> filterValues(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super V, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> V getOrElseNullable(@org.jetbrains.annotations.NotNull java.util.Map<K, ? extends V> map, K k, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends V> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : defaultValue.invoke();
    }

    public static final <K, V> V getOrPut(@org.jetbrains.annotations.NotNull java.util.Map<K, V> map, K k, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends V> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = map.get(k);
        if (v != null) {
            return v;
        }
        V invoke = defaultValue.invoke();
        map.put(k, invoke);
        return invoke;
    }

    @kotlin.SinceKotlin(version = "1.1")
    public static final <K, V> V getValue(@org.jetbrains.annotations.NotNull java.util.Map<K, ? extends V> map, K k) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        return (V) kotlin.collections.MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(map, k);
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.HashMap<K, V> hashMapOf(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>... pairs) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(pairs.length);
        java.util.HashMap<K, V> hashMap = new java.util.HashMap<>(mapCapacity);
        putAll(hashMap, pairs);
        return hashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.LinkedHashMap<K, V> linkedMapOf(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>... pairs) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(pairs.length);
        return (java.util.LinkedHashMap) toMap(pairs, new java.util.LinkedHashMap(mapCapacity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <K, V, R> java.util.Map<R, V> mapKeys(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(map.size());
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(mapCapacity);
        java.util.Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.lang.Object) it.next();
            linkedHashMap.put(transform.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <K, V, R, M extends java.util.Map<? super R, ? super V>> M mapKeysTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.lang.Object) it.next();
            destination.put(transform.invoke(entry), entry.getValue());
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.Map<K, V> mapOf(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>... pairs) {
        java.util.Map<K, V> emptyMap;
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        if (pairs.length > 0) {
            mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(pairs.length);
            return toMap(pairs, new java.util.LinkedHashMap(mapCapacity));
        }
        emptyMap = emptyMap();
        return emptyMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <K, V, R> java.util.Map<K, R> mapValues(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(map.size());
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(mapCapacity);
        java.util.Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.lang.Object) it.next();
            linkedHashMap.put(entry.getKey(), transform.invoke(entry));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <K, V, R, M extends java.util.Map<? super K, ? super R>> M mapValuesTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.lang.Object) it.next();
            destination.put(entry.getKey(), transform.invoke(entry));
        }
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> minus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends K> keys) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keys, "keys");
        java.util.Map mutableMap = toMutableMap(map);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> minus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, K k) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        java.util.Map mutableMap = toMutableMap(map);
        mutableMap.remove(k);
        return optimizeReadOnlyMap(mutableMap);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> minus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends K> keys) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keys, "keys");
        java.util.Map mutableMap = toMutableMap(map);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> minus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull K[] keys) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keys, "keys");
        java.util.Map mutableMap = toMutableMap(map);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> mutableMapOf(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>... pairs) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(pairs.length);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(mapCapacity);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> optimizeReadOnlyMap(@org.jetbrains.annotations.NotNull java.util.Map<K, ? extends V> map) {
        java.util.Map<K, V> emptyMap;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : kotlin.collections.MapsKt__MapsJVMKt.toSingletonMap(map);
        }
        emptyMap = emptyMap();
        return emptyMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> plus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends kotlin.Pair<? extends K, ? extends V>> pairs) {
        java.util.Map<K, V> map2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        if (map.isEmpty()) {
            map2 = toMap(pairs);
            return map2;
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> plus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map2, "map");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> plus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V> pair) {
        java.util.Map<K, V> mapOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pair, "pair");
        if (map.isEmpty()) {
            mapOf = kotlin.collections.MapsKt__MapsJVMKt.mapOf(pair);
            return mapOf;
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> plus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends kotlin.Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map);
        putAll(linkedHashMap, pairs);
        return optimizeReadOnlyMap(linkedHashMap);
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> plus(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        if (map.isEmpty()) {
            return toMap(pairs);
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final <K, V> void putAll(@org.jetbrains.annotations.NotNull java.util.Map<? super K, ? super V> map, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends kotlin.Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (kotlin.Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void putAll(@org.jetbrains.annotations.NotNull java.util.Map<? super K, ? super V> map, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends kotlin.Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (kotlin.Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void putAll(@org.jetbrains.annotations.NotNull java.util.Map<? super K, ? super V> map, @org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (kotlin.Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.Map<K, V> toMap(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends kotlin.Pair<? extends K, ? extends V>> iterable) {
        java.util.Map<K, V> emptyMap;
        java.util.Map<K, V> mapOf;
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof java.util.Collection)) {
            return optimizeReadOnlyMap(toMap(iterable, new java.util.LinkedHashMap()));
        }
        java.util.Collection collection = (java.util.Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            emptyMap = emptyMap();
            return emptyMap;
        }
        if (size != 1) {
            mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(collection.size());
            return toMap(iterable, new java.util.LinkedHashMap(mapCapacity));
        }
        mapOf = kotlin.collections.MapsKt__MapsJVMKt.mapOf(iterable instanceof java.util.List ? (kotlin.Pair<? extends K, ? extends V>) ((java.util.List) iterable).get(0) : iterable.iterator().next());
        return mapOf;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M toMap(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends kotlin.Pair<? extends K, ? extends V>> iterable, @org.jetbrains.annotations.NotNull M destination) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        putAll(destination, iterable);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> toMap(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        java.util.Map<K, V> emptyMap;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? toMutableMap(map) : kotlin.collections.MapsKt__MapsJVMKt.toSingletonMap(map);
        }
        emptyMap = emptyMap();
        return emptyMap;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M toMap(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull M destination) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        destination.putAll(map);
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> toMap(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends kotlin.Pair<? extends K, ? extends V>> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return optimizeReadOnlyMap(toMap(sequence, new java.util.LinkedHashMap()));
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M toMap(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends kotlin.Pair<? extends K, ? extends V>> sequence, @org.jetbrains.annotations.NotNull M destination) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        putAll(destination, sequence);
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> toMap(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>[] pairArr) {
        java.util.Map<K, V> emptyMap;
        java.util.Map<K, V> mapOf;
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairArr, "<this>");
        int length = pairArr.length;
        if (length == 0) {
            emptyMap = emptyMap();
            return emptyMap;
        }
        if (length != 1) {
            mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(pairArr.length);
            return toMap(pairArr, new java.util.LinkedHashMap(mapCapacity));
        }
        mapOf = kotlin.collections.MapsKt__MapsJVMKt.mapOf(pairArr[0]);
        return mapOf;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M toMap(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>[] pairArr, @org.jetbrains.annotations.NotNull M destination) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        putAll(destination, pairArr);
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> toMutableMap(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        return new java.util.LinkedHashMap(map);
    }
}
