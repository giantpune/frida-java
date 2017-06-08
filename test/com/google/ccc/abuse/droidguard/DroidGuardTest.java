package droidguard.abuse.ccc.google.com;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


import re.frida.Script;
import re.frida.Eatable;
import re.frida.TestRunner;

import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Base64;

public class DroidGuardTest {
    private static Class bananaClass = null;
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    private String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }

    public void RunDroidGuardWithParameterFile( String params ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        System.out.println( "running with params from file: " + params );
        
        JSONObject paramData = new JSONObject( readFileAsString( params ) );
        
        String type = paramData.getString( "type" );
        byte[] bytes = Base64.decode( paramData.getString( "bytes"), Base64.DEFAULT );
        Object ob = null;

        Map<String, String> map = new HashMap<>();
        JSONObject o = paramData.getJSONObject("map");

        for( int i = 0; i < o.names().length(); i++)
        {
            String key = o.names().getString( i );
            map.put( key, o.getString( key ) );
        }
        
        DroidGuard dg = new DroidGuard( null, type, bytes, ob );
        dg.Log( "Ok.  about to run" );
        dg.run( map );
        
        //System.out.println( "loaded the script: " + script );
    
    }

    @Test
    public void DroidGuardAdTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String script = readFileAsString("/data/local/tmp/frida-java-tests/test.js");
        
        System.out.println( "loading script: " + script );
        loadScript( script );
        try
        {
            Class cl = Class.forName("obv");
            System.out.println( "loaded obv" );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        try
        {
          RunDroidGuardWithParameterFile( "/data/logging/droidParams1496861273.json");
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return;
        }
    }

    private Script script = null;

    private void loadScript(String code) {
        Script script = new Script(TestRunner.fridaJavaBundle +
                ";\n(function (Java) {" +
                "Java.perform(function () {" +
                "Java.classFactory.loader = Java.cast(Memory.readPointer(ptr(" + TestRunner.classLoaderPointer +
                    ")), Java.use('java.lang.ClassLoader'));" +
                code +
                "});" +
                "})(LocalJava);");
        this.script = script;
    }

    @After
    public void tearDown() throws IOException {
        if (script != null) {
            script.close();
            script = null;
        }
    }
}