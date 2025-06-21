package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0010\r\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a$\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\b\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\r\u001a\u00020\t*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u000e\u001a\u00020\t*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0000\u001a$\u0010\u000f\u001a\u00020\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0007\u001a-\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\b\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u001a\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0000\u001a$\u0010\u0015\u001a\u00020\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0007\u001a-\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\b\u001a\u0012\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010\u001a\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u0017\u001a\u00020\t\u001a$\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u001b\u001a\u00020\u0019*\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u001c\u001a\u00020\u0019*\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a9\u0010!\u001a\u00020\u0000*\u00020\u00002'\u0010\u0005\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u001eH\u0086\bø\u0001\u0000\u001a9\u0010!\u001a\u00020\u0019*\u00020\u00192'\u0010\u0005\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u001eH\u0086\bø\u0001\u0000\u001aV\u0010&\u001a\u00028\u0000\"\f\b\u0000\u0010$*\u00060\"j\u0002`#*\u00020\u00002\u0006\u0010%\u001a\u00028\u00002'\u0010\u0005\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a$\u0010(\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010(\u001a\u00020\u0019*\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001aA\u0010)\u001a\u00028\u0000\"\f\b\u0000\u0010$*\u00060\"j\u0002`#*\u00020\u00002\u0006\u0010%\u001a\u00028\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aA\u0010+\u001a\u00028\u0000\"\f\b\u0000\u0010$*\u00060\"j\u0002`#*\u00020\u00002\u0006\u0010%\u001a\u00028\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010*\u001a\u0012\u0010.\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020,\u001a\u0012\u0010.\u001a\u00020\u0019*\u00020\u00192\u0006\u0010-\u001a\u00020,\u001a\u0018\u0010.\u001a\u00020\u0000*\u00020\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0/\u001a\u0012\u00100\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u00100\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u00101\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u00101\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u0017\u001a\u00020\t\u001a$\u00102\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u00102\u001a\u00020\u0019*\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u00103\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u00103\u001a\u00020\u0019*\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\n\u00104\u001a\u00020\u0000*\u00020\u0000\u001aH\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\"\u0004\b\u0000\u00105\"\u0004\b\u0001\u00106*\u00020\u00002\u001e\u00108\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001070\u0003H\u0086\bø\u0001\u0000\u001a6\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000109\"\u0004\b\u0000\u00105*\u00020\u00002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000\u001aP\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\"\u0004\b\u0000\u00105\"\u0004\b\u0001\u00106*\u00020\u00002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\bø\u0001\u0000\u001aS\u0010@\u001a\u00028\u0001\"\u0004\b\u0000\u00105\"\u0018\b\u0001\u0010?*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00020\u00010>*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001am\u0010@\u001a\u00028\u0002\"\u0004\b\u0000\u00105\"\u0004\b\u0001\u00106\"\u0018\b\u0002\u0010?*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010>*\u00020\u00002\u0006\u0010%\u001a\u00028\u00022\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b@\u0010B\u001ae\u0010C\u001a\u00028\u0002\"\u0004\b\u0000\u00105\"\u0004\b\u0001\u00106\"\u0018\b\u0002\u0010?*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010>*\u00020\u00002\u0006\u0010%\u001a\u00028\u00022\u001e\u00108\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001070\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\bC\u0010A\u001a6\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u000009\"\u0004\b\u0000\u00106*\u00020\u00002\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000\u001aS\u0010F\u001a\u00028\u0001\"\u0004\b\u0000\u00106\"\u0018\b\u0001\u0010?*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0001\u0012\u0006\b\u0000\u0012\u00028\u00000>*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\bF\u0010A\u001a+\u0010H\u001a\u00028\u0000\"\u0010\b\u0000\u0010$*\n\u0012\u0006\b\u0000\u0012\u00020\u00010G*\u00020\u00002\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0004\bH\u0010I\u001a\u001a\u0010L\u001a\u0012\u0012\u0004\u0012\u00020\u00010Jj\b\u0012\u0004\u0012\u00020\u0001`K*\u00020\u0000\u001a\u0010\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00010M*\u00020\u0000\u001a\u0010\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00010O*\u00020\u0000\u001a\u0010\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00010Q*\u00020\u0000\u001a6\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0018\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000/0\u0003H\u0086\bø\u0001\u0000\u001aQ\u0010U\u001a\u00028\u0001\"\u0004\b\u0000\u0010S\"\u0010\b\u0001\u0010$*\n\u0012\u0006\b\u0000\u0012\u00028\u00000G*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012\u0018\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000/0\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a<\u0010W\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010M09\"\u0004\b\u0000\u00105*\u00020\u00002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000\u001aV\u0010W\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010M09\"\u0004\b\u0000\u00105\"\u0004\b\u0001\u00106*\u00020\u00002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\bø\u0001\u0000\u001aW\u0010X\u001a\u00028\u0001\"\u0004\b\u0000\u00105\"\u001c\b\u0001\u0010?*\u0016\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010O0>*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\bX\u0010A\u001aq\u0010X\u001a\u00028\u0002\"\u0004\b\u0000\u00105\"\u0004\b\u0001\u00106\"\u001c\b\u0002\u0010?*\u0016\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010O0>*\u00020\u00002\u0006\u0010%\u001a\u00028\u00022\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\bX\u0010B\u001a8\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000Y\"\u0004\b\u0000\u00105*\u00020\u00002\u0014\b\u0004\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000\u001a0\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000\u001aE\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002'\u00108\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000\u001aK\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\b\b\u0000\u0010S*\u00020]*\u00020\u00002)\u00108\u001a%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001eH\u0086\bø\u0001\u0000\u001af\u0010_\u001a\u00028\u0001\"\b\b\u0000\u0010S*\u00020]\"\u0010\b\u0001\u0010$*\n\u0012\u0006\b\u0000\u0012\u00028\u00000G*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012)\u00108\u001a%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a`\u0010a\u001a\u00028\u0001\"\u0004\b\u0000\u0010S\"\u0010\b\u0001\u0010$*\n\u0012\u0006\b\u0000\u0012\u00028\u00000G*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012'\u00108\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\ba\u0010`\u001a6\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\b\b\u0000\u0010S*\u00020]*\u00020\u00002\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003H\u0086\bø\u0001\u0000\u001aQ\u0010c\u001a\u00028\u0001\"\b\b\u0000\u0010S*\u00020]\"\u0010\b\u0001\u0010$*\n\u0012\u0006\b\u0000\u0012\u00028\u00000G*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\bc\u0010V\u001aK\u0010d\u001a\u00028\u0001\"\u0004\b\u0000\u0010S\"\u0010\b\u0001\u0010$*\n\u0012\u0006\b\u0000\u0012\u00028\u00000G*\u00020\u00002\u0006\u0010%\u001a\u00028\u00012\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\bd\u0010V\u001a\u0016\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010e0/*\u00020\u0000\u001a$\u0010g\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\n\u0010h\u001a\u00020\u0004*\u00020\u0000\u001a$\u0010h\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a$\u0010i\u001a\u00020\t*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001aN\u0010m\u001a\u00028\u0000\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002'\u0010l\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\bm\u0010n\u001ac\u0010p\u001a\u00028\u0000\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000oH\u0086\bø\u0001\u0000¢\u0006\u0004\bp\u0010q\u001aN\u0010r\u001a\u00028\u0000\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002'\u0010l\u001a#\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\br\u0010n\u001ac\u0010s\u001a\u00028\u0000\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00028\u00000oH\u0086\bø\u0001\u0000¢\u0006\u0004\bs\u0010q\u001a$\u0010v\u001a\u00020t*\u00020\u00002\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020t0\u0003H\u0086\bø\u0001\u0000\u001a9\u0010w\u001a\u00020t*\u00020\u00002'\u0010u\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020t0\u001eH\u0086\bø\u0001\u0000\u001a\u0013\u0010z\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\bx\u0010y\u001a;\u0010\u007f\u001a\u00020\u0001\"\u000e\b\u0000\u0010S*\b\u0012\u0004\u0012\u00028\u00000{*\u00020\u00002\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b}\u0010~\u001a?\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010S*\b\u0012\u0004\u0012\u00028\u00000{*\u00020\u00002\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010\b\u001a\u0017\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0005\b\u0081\u0001\u0010\u0007\u001a5\u0010\u0087\u0001\u001a\u00020\u0001*\u00020\u00002\u001d\u0010\u0084\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00010\u0082\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0083\u0001H\u0007¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a7\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u001d\u0010\u0084\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00010\u0082\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0083\u0001H\u0007¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0015\u0010\u008b\u0001\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0005\b\u008a\u0001\u0010y\u001a=\u0010\u008d\u0001\u001a\u00020\u0001\"\u000e\b\u0000\u0010S*\b\u0012\u0004\u0012\u00028\u00000{*\u00020\u00002\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000¢\u0006\u0005\b\u008c\u0001\u0010~\u001a?\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010S*\b\u0012\u0004\u0012\u00028\u00000{*\u00020\u00002\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000¢\u0006\u0005\b\u008e\u0001\u0010\b\u001a\u0017\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0005\b\u008f\u0001\u0010\u0007\u001a5\u0010\u0091\u0001\u001a\u00020\u0001*\u00020\u00002\u001d\u0010\u0084\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00010\u0082\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0083\u0001H\u0007¢\u0006\u0006\b\u0090\u0001\u0010\u0086\u0001\u001a7\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u001d\u0010\u0084\u0001\u001a\u0018\u0012\u0006\b\u0000\u0012\u00020\u00010\u0082\u0001j\u000b\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0083\u0001H\u0007¢\u0006\u0006\b\u0092\u0001\u0010\u0089\u0001\u001a\u000b\u0010\u0093\u0001\u001a\u00020\u0004*\u00020\u0000\u001a%\u0010\u0093\u0001\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a9\u0010\u0095\u0001\u001a\u00028\u0000\"\t\b\u0000\u0010\u0094\u0001*\u00020\u0000*\u00028\u00002\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020t0\u0003H\u0087\bø\u0001\u0000¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001\u001aN\u0010\u0097\u0001\u001a\u00028\u0000\"\t\b\u0000\u0010\u0094\u0001*\u00020\u0000*\u00028\u00002'\u0010u\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020t0\u001eH\u0087\bø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a:\u0010\u0099\u0001\u001a\u00020\u0001*\u00020\u00002'\u0010l\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001eH\u0086\bø\u0001\u0000\u001aO\u0010\u009a\u0001\u001a\u00020\u0001*\u00020\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010oH\u0086\bø\u0001\u0000\u001aZ\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010oH\u0087\bø\u0001\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001\u001aE\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002'\u0010l\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001eH\u0087\bø\u0001\u0000¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a:\u0010\u009f\u0001\u001a\u00020\u0001*\u00020\u00002'\u0010l\u001a#\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u00010\u001eH\u0086\bø\u0001\u0000\u001aO\u0010 \u0001\u001a\u00020\u0001*\u00020\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u00010oH\u0086\bø\u0001\u0000\u001aZ\u0010¡\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u00010oH\u0087\bø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010\u009c\u0001\u001aE\u0010¢\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u00002'\u0010l\u001a#\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u00010\u001eH\u0087\bø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010\u009e\u0001\u001aW\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002'\u0010l\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0087\bø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010¤\u0001\u001al\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000oH\u0087\bø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010¦\u0001\u001a@\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010M*\u00020\u00002'\u0010l\u001a#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001eH\u0087\bø\u0001\u0000\u001aU\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010M*\u00020\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010oH\u0087\bø\u0001\u0000\u001aW\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002'\u0010l\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0087\bø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010¤\u0001\u001al\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0006\u0010j\u001a\u00028\u00002<\u0010l\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000oH\u0087\bø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010¦\u0001\u001a%\u0010«\u0001\u001a\u00020\t*\u00020\u00002\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0003H\u0087\bø\u0001\u0000\u001a'\u0010\u00ad\u0001\u001a\u00030¬\u0001*\u00020\u00002\u0013\u0010|\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0005\u0012\u00030¬\u00010\u0003H\u0087\bø\u0001\u0000\u001a\u001c\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190M*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\tH\u0007\u001a6\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\t2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a\u001d\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190°\u0001*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\tH\u0007\u001a7\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000°\u0001\"\u0004\b\u0000\u0010S*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\t2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a1\u0010²\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000007*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a1\u0010²\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001907*\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a2\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190M*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\t2\t\b\u0002\u0010³\u0001\u001a\u00020\t2\t\b\u0002\u0010´\u0001\u001a\u00020\u0004H\u0007\u001aL\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\t2\t\b\u0002\u0010³\u0001\u001a\u00020\t2\t\b\u0002\u0010´\u0001\u001a\u00020\u00042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a3\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190°\u0001*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\t2\t\b\u0002\u0010³\u0001\u001a\u00020\t2\t\b\u0002\u0010´\u0001\u001a\u00020\u0004H\u0007\u001aM\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000°\u0001\"\u0004\b\u0000\u0010S*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\t2\t\b\u0002\u0010³\u0001\u001a\u00020\t2\t\b\u0002\u0010´\u0001\u001a\u00020\u00042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\u0007\u001a)\u0010¸\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001070M*\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\u0000H\u0086\u0004\u001a`\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u00106*\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\u000028\u00108\u001a4\u0012\u0014\u0012\u00120\u0001¢\u0006\r\b\u001f\u0012\t\b \u0012\u0005\b\b(¹\u0001\u0012\u0014\u0012\u00120\u0001¢\u0006\r\b\u001f\u0012\t\b \u0012\u0005\b\b(º\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000\u001a\u001f\u0010»\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001070M*\u00020\u0000H\u0007\u001aW\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000M\"\u0004\b\u0000\u0010S*\u00020\u000028\u00108\u001a4\u0012\u0014\u0012\u00120\u0001¢\u0006\r\b\u001f\u0012\t\b \u0012\u0005\b\b(¹\u0001\u0012\u0014\u0012\u00120\u0001¢\u0006\r\b\u001f\u0012\t\b \u0012\u0005\b\b(º\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0087\bø\u0001\u0000\u001a\u0011\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010/*\u00020\u0000\u001a\u0012\u0010½\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010°\u0001*\u00020\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006¾\u0001"}, d2 = {"", "", "first", "Lkotlin/Function1;", "", "predicate", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "", "index", "getOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "Lkotlin/random/Random;", "random", "randomOrNull", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)Ljava/lang/Character;", "single", "singleOrNull", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "drop", "", "dropLast", "dropLastWhile", "dropWhile", "filter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexed", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "C", "destination", "filterIndexedTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "Lkotlin/ranges/IntRange;", "indices", "slice", "", "take", "takeLast", "takeLastWhile", "takeWhile", "reversed", "K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "transform", "", "associate", "keySelector", "associateBy", "valueTransform", "", "M", "associateByTo", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "valueSelector", "associateWith", "associateWithTo", "", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toHashSet", "", "toList", "", "toMutableList", "", "toSet", "R", "flatMap", "flatMapTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "groupBy", "groupByTo", "Lkotlin/collections/Grouping;", "groupingBy", "map", "mapIndexed", "", "mapIndexedNotNull", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "Lkotlin/collections/IndexedValue;", "withIndex", "all", org.apache.commons.codec.language.bm.Languages.ANY, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "initial", "acc", "operation", "fold", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/Function3;", "foldIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "", "action", "forEach", "forEachIndexed", "maxOrThrow", "(Ljava/lang/CharSequence;)C", org.apache.tools.ant.types.selectors.DepthSelector.MAX_KEY, "", "selector", "maxByOrThrow", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)C", "maxBy", "maxByOrNull", "maxOrNull", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "maxWithOrThrow", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)C", "maxWith", "maxWithOrNull", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "minOrThrow", org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY, "minByOrThrow", "minBy", "minByOrNull", "minOrNull", "minWithOrThrow", "minWith", "minWithOrNull", "none", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "onEach", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "onEachIndexed", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/CharSequence;", "reduce", "reduceIndexed", "reduceIndexedOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function3;)Ljava/lang/Character;", "reduceOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "reduceRight", "reduceRightIndexed", "reduceRightIndexedOrNull", "reduceRightOrNull", "runningFold", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "runningFoldIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "runningReduce", "runningReduceIndexed", "scan", "scanIndexed", "sumBy", "", "sumByDouble", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED, "Lkotlin/sequences/Sequence;", "chunkedSequence", "partition", "step", "partialWindows", "windowed", "windowedSequence", "other", "zip", "a", "b", "zipWithNext", "asIterable", "asSequence", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
public class StringsKt___StringsKt extends kotlin.text.StringsKt___StringsJvmKt {
    public static final boolean all(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return !(charSequence.length() == 0);
    }

    public static final boolean any(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Iterable<java.lang.Character> asIterable(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence instanceof java.lang.String) {
            if (charSequence.length() == 0) {
                return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
            }
        }
        return new kotlin.text.StringsKt___StringsKt$asIterable$$inlined$Iterable$1(charSequence);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.Character> asSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence instanceof java.lang.String) {
            if (charSequence.length() == 0) {
                return kotlin.sequences.SequencesKt__SequencesKt.emptySequence();
            }
        }
        return new kotlin.text.StringsKt___StringsKt$asSequence$$inlined$Sequence$1(charSequence);
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> associate(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends kotlin.Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(charSequence.length());
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(coerceAtLeast);
        for (int i = 0; i < charSequence.length(); i++) {
            kotlin.Pair<? extends K, ? extends V> invoke = transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i)));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K> java.util.Map<K, java.lang.Character> associateBy(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(charSequence.length());
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(coerceAtLeast);
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(keySelector.invoke(java.lang.Character.valueOf(charAt)), java.lang.Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> associateBy(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(charSequence.length());
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(coerceAtLeast);
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(keySelector.invoke(java.lang.Character.valueOf(charAt)), valueTransform.invoke(java.lang.Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, M extends java.util.Map<? super K, ? super java.lang.Character>> M associateByTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            destination.put(keySelector.invoke(java.lang.Character.valueOf(charAt)), java.lang.Character.valueOf(charAt));
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M associateByTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            destination.put(keySelector.invoke(java.lang.Character.valueOf(charAt)), valueTransform.invoke(java.lang.Character.valueOf(charAt)));
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> M associateTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends kotlin.Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            kotlin.Pair<? extends K, ? extends V> invoke = transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i)));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final <V> java.util.Map<java.lang.Character, V> associateWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends V> valueSelector) {
        int coerceAtMost;
        int mapCapacity;
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(charSequence.length(), 128);
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(coerceAtMost);
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(coerceAtLeast);
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(java.lang.Character.valueOf(charAt), valueSelector.invoke(java.lang.Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final <V, M extends java.util.Map<? super java.lang.Character, ? super V>> M associateWithTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            destination.put(java.lang.Character.valueOf(charAt), valueSelector.invoke(java.lang.Character.valueOf(charAt)));
        }
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.String> chunked(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return windowed(charSequence, i, i, true);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> chunked(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        return windowed(charSequence, i, i, true, transform);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.String> chunkedSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return chunkedSequence(charSequence, i, kotlin.text.StringsKt___StringsKt$chunkedSequence$1.INSTANCE);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <R> kotlin.sequences.Sequence<R> chunkedSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        return windowedSequence(charSequence, i, i, true, transform);
    }

    public static final int count(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence drop(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i >= 0) {
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, charSequence.length());
            return charSequence.subSequence(coerceAtMost, charSequence.length());
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.String drop(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= 0) {
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, str.length());
            java.lang.String substring = str.substring(coerceAtMost);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence dropLast(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i >= 0) {
            coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(charSequence.length() - i, 0);
            return take(charSequence, coerceAtLeast);
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.String dropLast(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= 0) {
            coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(str.length() - i, 0);
            return take(str, coerceAtLeast);
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence dropLastWhile(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(lastIndex))).booleanValue()) {
                return charSequence.subSequence(0, lastIndex + 1);
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String dropLastWhile(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(str); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(java.lang.Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                java.lang.String substring = str.substring(0, lastIndex + 1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence dropWhile(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String dropWhile(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(java.lang.Character.valueOf(str.charAt(i))).booleanValue()) {
                java.lang.String substring = str.substring(i);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence filter(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String filter(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence filterIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (predicate.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String filterIndexed(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i3 = i2 + 1;
            if (predicate.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "filterIndexedTo(StringBu…(), predicate).toString()");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    public static final <C extends java.lang.Appendable> C filterIndexedTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (predicate.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence filterNot(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String filterNot(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    public static final <C extends java.lang.Appendable> C filterNotTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <C extends java.lang.Appendable> C filterTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                destination.append(charAt);
            }
        }
        return destination;
    }

    public static final char first(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static final char first(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                return charAt;
            }
        }
        throw new java.util.NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character firstOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return java.lang.Character.valueOf(charSequence.charAt(0));
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character firstOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                return java.lang.Character.valueOf(charAt);
            }
        }
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> flatMap(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends java.lang.Iterable<? extends R>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R, C extends java.util.Collection<? super R>> C flatMapTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends java.lang.Iterable<? extends R>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i))));
        }
        return destination;
    }

    public static final <R> R fold(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super java.lang.Character, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        for (int i = 0; i < charSequence.length(); i++) {
            r = operation.mo5invoke(r, java.lang.Character.valueOf(charSequence.charAt(i)));
        }
        return r;
    }

    public static final <R> R foldIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super java.lang.Character, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            R r2 = r;
            r = operation.invoke(java.lang.Integer.valueOf(i2), r2, java.lang.Character.valueOf(charSequence.charAt(i)));
            i++;
            i2++;
        }
        return r;
    }

    public static final <R> R foldRight(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = operation.mo5invoke(java.lang.Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = operation.invoke(java.lang.Integer.valueOf(lastIndex), java.lang.Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final void forEach(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (int i = 0; i < charSequence.length(); i++) {
            action.invoke(java.lang.Character.valueOf(charSequence.charAt(i)));
        }
    }

    public static final void forEachIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            action.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charSequence.charAt(i)));
            i++;
            i2++;
        }
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character getOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0 || i > kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)) {
            return null;
        }
        return java.lang.Character.valueOf(charSequence.charAt(i));
    }

    @org.jetbrains.annotations.NotNull
    public static final <K> java.util.Map<K, java.util.List<java.lang.Character>> groupBy(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(java.lang.Character.valueOf(charAt));
            java.lang.Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new java.util.ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((java.util.List) obj).add(java.lang.Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, java.util.List<V>> groupBy(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(java.lang.Character.valueOf(charAt));
            java.util.List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new java.util.ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(java.lang.Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, M extends java.util.Map<? super K, java.util.List<java.lang.Character>>> M groupByTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(java.lang.Character.valueOf(charAt));
            java.lang.Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new java.util.ArrayList();
                destination.put(invoke, obj);
            }
            ((java.util.List) obj).add(java.lang.Character.valueOf(charAt));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? super K, java.util.List<V>>> M groupByTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            K invoke = keySelector.invoke(java.lang.Character.valueOf(charAt));
            java.lang.Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new java.util.ArrayList();
                destination.put(invoke, obj);
            }
            ((java.util.List) obj).add(valueTransform.invoke(java.lang.Character.valueOf(charAt)));
        }
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K> kotlin.collections.Grouping<java.lang.Character, K> groupingBy(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> keySelector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new kotlin.text.StringsKt___StringsKt$groupingBy$1(charSequence, keySelector);
    }

    public static final int indexOfFirst(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static char last(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence));
    }

    public static final char last(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char charAt = charSequence.charAt(length);
                if (!predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return charAt;
                }
            }
        }
        throw new java.util.NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character lastOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return java.lang.Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character lastOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            char charAt = charSequence.charAt(length);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                return java.lang.Character.valueOf(charAt);
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> map(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            arrayList.add(transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> mapIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length());
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            arrayList.add(transform.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charSequence.charAt(i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> mapIndexedNotNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            R mo5invoke = transform.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charSequence.charAt(i)));
            if (mo5invoke != null) {
                arrayList.add(mo5invoke);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R, C extends java.util.Collection<? super R>> C mapIndexedNotNullTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            R mo5invoke = transform.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charSequence.charAt(i)));
            if (mo5invoke != null) {
                destination.add(mo5invoke);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R, C extends java.util.Collection<? super R>> C mapIndexedTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            destination.add(transform.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(charSequence.charAt(i))));
            i++;
            i2++;
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> mapNotNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            R invoke = transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R, C extends java.util.Collection<? super R>> C mapNotNullTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            R invoke = transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <R, C extends java.util.Collection<? super R>> C mapTo(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            destination.add(transform.invoke(java.lang.Character.valueOf(charSequence.charAt(i))));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final <R extends java.lang.Comparable<? super R>> java.lang.Character maxByOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return java.lang.Character.valueOf(charAt);
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(charAt));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(java.lang.Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) < 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.jvm.JvmName(name = "maxByOrThrow")
    public static final <R extends java.lang.Comparable<? super R>> char maxByOrThrow(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return charAt;
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(charAt));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(java.lang.Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) < 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return charAt;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character maxOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (kotlin.jvm.internal.Intrinsics.compare((int) charAt, (int) charAt2) < 0) {
                charAt = charAt2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.jvm.JvmName(name = "maxOrThrow")
    public static final char maxOrThrow(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (kotlin.jvm.internal.Intrinsics.compare((int) charAt, (int) charAt2) < 0) {
                charAt = charAt2;
            }
        }
        return charAt;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character maxWithOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Comparator<? super java.lang.Character> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charAt2)) < 0) {
                charAt = charAt2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.jvm.JvmName(name = "maxWithOrThrow")
    public static final char maxWithOrThrow(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Comparator<? super java.lang.Character> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charAt2)) < 0) {
                charAt = charAt2;
            }
        }
        return charAt;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final <R extends java.lang.Comparable<? super R>> java.lang.Character minByOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return java.lang.Character.valueOf(charAt);
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(charAt));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(java.lang.Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) > 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.jvm.JvmName(name = "minByOrThrow")
    public static final <R extends java.lang.Comparable<? super R>> char minByOrThrow(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return charAt;
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(charAt));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(java.lang.Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) > 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return charAt;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character minOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (kotlin.jvm.internal.Intrinsics.compare((int) charAt, (int) charAt2) > 0) {
                charAt = charAt2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.jvm.JvmName(name = "minOrThrow")
    public static final char minOrThrow(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (kotlin.jvm.internal.Intrinsics.compare((int) charAt, (int) charAt2) > 0) {
                charAt = charAt2;
            }
        }
        return charAt;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character minWithOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Comparator<? super java.lang.Character> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charAt2)) > 0) {
                charAt = charAt2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.jvm.JvmName(name = "minWithOrThrow")
    public static final char minWithOrThrow(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Comparator<? super java.lang.Character> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException();
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            if (comparator.compare(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charAt2)) > 0) {
                charAt = charAt2;
            }
        }
        return charAt;
    }

    public static final boolean none(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    public static final boolean none(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <S extends java.lang.CharSequence> S onEach(@org.jetbrains.annotations.NotNull S s2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(s2, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (int i = 0; i < s2.length(); i++) {
            action.invoke(java.lang.Character.valueOf(s2.charAt(i)));
        }
        return s2;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <S extends java.lang.CharSequence> S onEachIndexed(@org.jetbrains.annotations.NotNull S s2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Character, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(s2, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        int i2 = 0;
        while (i < s2.length()) {
            action.mo5invoke(java.lang.Integer.valueOf(i2), java.lang.Character.valueOf(s2.charAt(i)));
            i++;
            i2++;
        }
        return s2;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.Pair<java.lang.CharSequence, java.lang.CharSequence> partition(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new kotlin.Pair<>(sb, sb2);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.Pair<java.lang.String, java.lang.String> partition(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        java.lang.String sb3 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb3, "first.toString()");
        java.lang.String sb4 = sb2.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb4, "second.toString()");
        return new kotlin.Pair<>(sb3, sb4);
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final char random(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        if (charSequence.length() == 0) {
            throw new java.util.NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(random.nextInt(charSequence.length()));
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character randomOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return java.lang.Character.valueOf(charSequence.charAt(random.nextInt(charSequence.length())));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final char reduce(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            throw new java.lang.UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            charAt = operation.mo5invoke(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charSequence.charAt(it.nextInt()))).charValue();
        }
        return charAt;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final char reduceIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            throw new java.lang.UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            charAt = operation.invoke(java.lang.Integer.valueOf(nextInt), java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charSequence.charAt(nextInt))).charValue();
        }
        return charAt;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character reduceIndexedOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            charAt = operation.invoke(java.lang.Integer.valueOf(nextInt), java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charSequence.charAt(nextInt))).charValue();
        }
        return java.lang.Character.valueOf(charAt);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character reduceOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        ?? it = new kotlin.ranges.IntRange(1, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            charAt = operation.mo5invoke(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charSequence.charAt(it.nextInt()))).charValue();
        }
        return java.lang.Character.valueOf(charAt);
    }

    public static final char reduceRight(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex < 0) {
            throw new java.lang.UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            charAt = operation.mo5invoke(java.lang.Character.valueOf(charSequence.charAt(i)), java.lang.Character.valueOf(charAt)).charValue();
        }
        return charAt;
    }

    public static final char reduceRightIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex < 0) {
            throw new java.lang.UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char charAt = charSequence.charAt(lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            charAt = operation.invoke(java.lang.Integer.valueOf(i), java.lang.Character.valueOf(charSequence.charAt(i)), java.lang.Character.valueOf(charAt)).charValue();
        }
        return charAt;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character reduceRightIndexedOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char charAt = charSequence.charAt(lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            charAt = operation.invoke(java.lang.Integer.valueOf(i), java.lang.Character.valueOf(charSequence.charAt(i)), java.lang.Character.valueOf(charAt)).charValue();
        }
        return java.lang.Character.valueOf(charAt);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character reduceRightOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char charAt = charSequence.charAt(lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            charAt = operation.mo5invoke(java.lang.Character.valueOf(charSequence.charAt(i)), java.lang.Character.valueOf(charAt)).charValue();
        }
        return java.lang.Character.valueOf(charAt);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence reversed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        java.lang.StringBuilder reverse = new java.lang.StringBuilder(charSequence).reverse();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> runningFold(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super java.lang.Character, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        for (int i = 0; i < charSequence.length(); i++) {
            r = operation.mo5invoke(r, java.lang.Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> runningFoldIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super java.lang.Character, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            r = operation.invoke(java.lang.Integer.valueOf(i), r, java.lang.Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Character> runningReduce(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = charSequence.charAt(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length());
        arrayList.add(java.lang.Character.valueOf(charAt));
        int length = charSequence.length();
        for (int i = 1; i < length; i++) {
            charAt = operation.mo5invoke(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charSequence.charAt(i))).charValue();
            arrayList.add(java.lang.Character.valueOf(charAt));
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Character> runningReduceIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Character, ? super java.lang.Character, java.lang.Character> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = charSequence.charAt(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length());
        arrayList.add(java.lang.Character.valueOf(charAt));
        int length = charSequence.length();
        for (int i = 1; i < length; i++) {
            charAt = operation.invoke(java.lang.Integer.valueOf(i), java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charSequence.charAt(i))).charValue();
            arrayList.add(java.lang.Character.valueOf(charAt));
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> scan(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super java.lang.Character, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        for (int i = 0; i < charSequence.length(); i++) {
            r = operation.mo5invoke(r, java.lang.Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> scanIndexed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super java.lang.Character, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            r = operation.invoke(java.lang.Integer.valueOf(i), r, java.lang.Character.valueOf(charSequence.charAt(i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final char single(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new java.util.NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new java.lang.IllegalArgumentException("Char sequence has more than one element.");
    }

    public static final char single(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                if (z) {
                    throw new java.lang.IllegalArgumentException("Char sequence contains more than one matching element.");
                }
                ch = java.lang.Character.valueOf(charAt);
                z = true;
            }
        }
        if (!z) {
            throw new java.util.NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(ch, "null cannot be cast to non-null type kotlin.Char");
        return ch.charValue();
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character singleOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return java.lang.Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Character singleOrNull(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        java.lang.Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (predicate.invoke(java.lang.Character.valueOf(charAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = java.lang.Character.valueOf(charAt);
                z = true;
            }
        }
        if (z) {
            return ch;
        }
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence slice(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.Iterable<java.lang.Integer> indices) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(collectionSizeOrDefault);
        java.util.Iterator<java.lang.Integer> it = indices.iterator();
        while (it.hasNext()) {
            sb.append(charSequence.charAt(it.next().intValue()));
        }
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence slice(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange indices) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? "" : kotlin.text.StringsKt__StringsKt.subSequence(charSequence, indices);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String slice(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange indices) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? "" : kotlin.text.StringsKt__StringsKt.substring(str, indices);
    }

    @kotlin.Deprecated(message = "Use sumOf instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    public static final int sumBy(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Integer> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += selector.invoke(java.lang.Character.valueOf(charSequence.charAt(i2))).intValue();
        }
        return i;
    }

    @kotlin.Deprecated(message = "Use sumOf instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    public static final double sumByDouble(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Double> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        double d = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            d += selector.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).doubleValue();
        }
        return d;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence take(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i >= 0) {
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, charSequence.length());
            return charSequence.subSequence(0, coerceAtMost);
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String take(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= 0) {
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, str.length());
            java.lang.String substring = str.substring(0, coerceAtMost);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence takeLast(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i >= 0) {
            int length = charSequence.length();
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, length);
            return charSequence.subSequence(length - coerceAtMost, length);
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.String takeLast(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= 0) {
            int length = str.length();
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, length);
            java.lang.String substring = str.substring(length - coerceAtMost);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new java.lang.IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence takeLastWhile(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(lastIndex))).booleanValue()) {
                return charSequence.subSequence(lastIndex + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String takeLastWhile(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(str); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(java.lang.Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                java.lang.String substring = str.substring(lastIndex + 1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return str;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence takeWhile(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(0, i);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String takeWhile(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(java.lang.Character.valueOf(str.charAt(i))).booleanValue()) {
                java.lang.String substring = str.substring(0, i);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return str;
    }

    @org.jetbrains.annotations.NotNull
    public static final <C extends java.util.Collection<? super java.lang.Character>> C toCollection(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull C destination) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        for (int i = 0; i < charSequence.length(); i++) {
            destination.add(java.lang.Character.valueOf(charSequence.charAt(i)));
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.HashSet<java.lang.Character> toHashSet(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        int coerceAtMost;
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(charSequence.length(), 128);
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(coerceAtMost);
        return (java.util.HashSet) toCollection(charSequence, new java.util.HashSet(mapCapacity));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Character> toList(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? toMutableList(charSequence) : kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(java.lang.Character.valueOf(charSequence.charAt(0))) : kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Character> toMutableList(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (java.util.List) toCollection(charSequence, new java.util.ArrayList(charSequence.length()));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.Set<java.lang.Character> toSet(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        java.util.Set<java.lang.Character> emptySet;
        java.util.Set<java.lang.Character> of;
        int coerceAtMost;
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            emptySet = kotlin.collections.SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        if (length == 1) {
            of = kotlin.collections.SetsKt__SetsJVMKt.setOf(java.lang.Character.valueOf(charSequence.charAt(0)));
            return of;
        }
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(charSequence.length(), 128);
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(coerceAtMost);
        return (java.util.Set) toCollection(charSequence, new java.util.LinkedHashSet(mapCapacity));
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.String> windowed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, int i2, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return windowed(charSequence, i, i2, z, kotlin.text.StringsKt___StringsKt$windowed$1.INSTANCE);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> windowed(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, int i2, boolean z, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        kotlin.collections.SlidingWindowKt.checkWindowSizeStep(i, i2);
        int length = charSequence.length();
        java.util.ArrayList arrayList = new java.util.ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        int i3 = 0;
        while (true) {
            if (!(i3 >= 0 && i3 < length)) {
                break;
            }
            int i4 = i3 + i;
            if (i4 < 0 || i4 > length) {
                if (!z) {
                    break;
                }
                i4 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i3, i4)));
            i3 += i2;
        }
        return arrayList;
    }

    public static /* synthetic */ java.util.List windowed$default(java.lang.CharSequence charSequence, int i, int i2, boolean z, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i, i2, z);
    }

    public static /* synthetic */ java.util.List windowed$default(java.lang.CharSequence charSequence, int i, int i2, boolean z, kotlin.jvm.functions.Function1 function1, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i, i2, z, function1);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.String> windowedSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, int i2, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return windowedSequence(charSequence, i, i2, z, kotlin.text.StringsKt___StringsKt$windowedSequence$1.INSTANCE);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <R> kotlin.sequences.Sequence<R> windowedSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, int i2, boolean z, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.CharSequence, ? extends R> transform) {
        kotlin.ranges.IntProgression step;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        kotlin.collections.SlidingWindowKt.checkWindowSizeStep(i, i2);
        step = kotlin.ranges.RangesKt___RangesKt.step(z ? kotlin.text.StringsKt__StringsKt.getIndices(charSequence) : kotlin.ranges.RangesKt___RangesKt.until(0, (charSequence.length() - i) + 1), i2);
        return kotlin.sequences.SequencesKt___SequencesKt.map(kotlin.collections.CollectionsKt___CollectionsKt.asSequence(step), new kotlin.text.StringsKt___StringsKt$windowedSequence$2(i, charSequence, transform));
    }

    public static /* synthetic */ kotlin.sequences.Sequence windowedSequence$default(java.lang.CharSequence charSequence, int i, int i2, boolean z, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i, i2, z);
    }

    public static /* synthetic */ kotlin.sequences.Sequence windowedSequence$default(java.lang.CharSequence charSequence, int i, int i2, boolean z, kotlin.jvm.functions.Function1 function1, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i, i2, z, function1);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Iterable<kotlin.collections.IndexedValue<java.lang.Character>> withIndex(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new kotlin.collections.IndexingIterable(new kotlin.text.StringsKt___StringsKt$withIndex$1(charSequence));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<kotlin.Pair<java.lang.Character, java.lang.Character>> zip(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int min = java.lang.Math.min(charSequence.length(), other.length());
        java.util.ArrayList arrayList = new java.util.ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.TuplesKt.to(java.lang.Character.valueOf(charSequence.charAt(i)), java.lang.Character.valueOf(other.charAt(i))));
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <V> java.util.List<V> zip(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence other, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super java.lang.Character, ? extends V> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        int min = java.lang.Math.min(charSequence.length(), other.length());
        java.util.ArrayList arrayList = new java.util.ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.mo5invoke(java.lang.Character.valueOf(charSequence.charAt(i)), java.lang.Character.valueOf(other.charAt(i))));
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<kotlin.Pair<java.lang.Character, java.lang.Character>> zipWithNext(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            i++;
            arrayList.add(kotlin.TuplesKt.to(java.lang.Character.valueOf(charAt), java.lang.Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <R> java.util.List<R> zipWithNext(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Character, ? super java.lang.Character, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(length);
        int i = 0;
        while (i < length) {
            java.lang.Character valueOf = java.lang.Character.valueOf(charSequence.charAt(i));
            i++;
            arrayList.add(transform.mo5invoke(valueOf, java.lang.Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }
}
