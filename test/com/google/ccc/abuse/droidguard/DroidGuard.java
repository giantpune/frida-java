package droidguard.abuse.ccc.google.com;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.util.Map;

/**
 * Created by j on 5/24/17.
 */
public class DroidGuard {

    static
    {
        Log( "Class has been instantiated" );
    }

    static final String LOG_TAG = "MyDroidGuard";
    public static void Log( String t )
    {
        Log.e( LOG_TAG, t );
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public DroidGuard(Context arg5, Parcelable arg6) {
        super();
        Parcelable v0 = arg6;
        byte[] v1 = ((Bundle)v0).getByteArray("c");
        byte[] v2 = ((Bundle)v0).getByteArray("b");
        String b = ((Bundle)v0).getString("d");
        Log("DroidGuard(Context arg5, Parcelable arg6)");
        Log( "b: " + bytesToHex(v2) );
        Log( "c: " + bytesToHex(v1) );
        Log( "d: " + b );
    }

    public DroidGuard(Context arg2, String arg3, byte[] arg4) {
        this(arg2, arg3, arg4, null);
        Log("DroidGuard(Context arg2, String arg3, byte[] arg4)");
        Log( "arg3: " + arg3 );
        Log( "arg4: " + bytesToHex(arg4) );
    }

    public DroidGuard(Context arg2, String arg3, byte[] arg4, Object arg5) {
        super();
        Log("DroidGuard(Context arg2, String arg3, byte[] arg4, Object arg5)");
        Log( "arg3: " + arg3 );
        Log( "arg4: " + bytesToHex(arg4) );
        Log( "arg5: " + arg5.toString() );
    }

    public DroidGuard(Context arg2, String arg3, byte[] arg4, Object arg5, boolean arg6) {
        super();
        Log("DroidGuard(Context arg2, String arg3, byte[] arg4, Object arg5, boolean arg6)");
        Log( "arg3: " + arg3 );
        Log( "arg4: " + bytesToHex(arg4) );
        Log( "arg5: " + arg5.toString() );
        Log( "arg6: " + arg6 );
    }



    public void close() {
        Log("close()");
    }

    public static void entryHelperNative(long arg0) {
        Log("entryHelperNative(): " + arg0);
    }

    public String getLog() {
        Log("getLog()");
        return "";
    }

    public boolean init() {
        Log("init()");
        return true;
    }

    public Object rb() {
        Log("rb()");
        return null;
    }

    public Object rd() {
        Log("rd()");
        return null;
    }

    public byte[] run(Map arg7) {
        Log("run(): " + arg7.toString());
        return null;
    }

    public byte[] ss(Map arg5) {
        Log("ss(): " + arg5.toString());
        return null;
    }

    public void wb(Object arg2) {
        Log("wb(): " + arg2.toString());
    }

    public void wd(Object arg2) {
        Log("wd(): " + arg2.toString());
    }
}
