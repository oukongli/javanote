package com.shdev.demo;

import javax.script.*;
import java.io.*;

public class ScriptDemo {

    public static void main(String args[]) throws Exception {
        // Get the JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Set JavaScript variables
        Bindings vars = new SimpleBindings();
        vars.put("demoVar", "value set in ScriptDemo.java");
        vars.put("strBuf", new StringBuffer("string buffer"));

        // Run DemoScript.js
        Reader scriptReader = new InputStreamReader(ScriptDemo.class.getClassLoader().getResourceAsStream("DemoScript.js"));
        try {
            engine.eval(scriptReader, vars);
        } finally {
            scriptReader.close();
        }
//        System.out.println("123".substring(1, 2));
    }

}