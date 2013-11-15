package com.change.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Author: Ronnie.Chen
 * Date: 13-2-20
 * Time: 下午3:18
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class JSSupport implements JSSupportMBean {
    @Override
    public String executeJS(String js) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
     //   String js = "function doSwing(t){var f=new Packages.com.alcatelsbell.nms.util.js.MyBean();return f.say();}";
        engine.eval(js);

        return "success";
    }

    @Override
    public String executeJSFunction(String js,String functionName) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        //   String js = "function doSwing(t){var f=new Packages.com.alcatelsbell.nms.util.js.MyBean();return f.say();}";
        engine.eval(js);
        //Invocable 接口: 允许java平台调用脚本程序中的函数或方法
        Invocable inv = (Invocable) engine;
        //invokeFunction()中的第一个参数就是被调用的脚本程序中的函数，第二个参数是传递给被调用函数的参数；
        Object o = inv.invokeFunction(functionName);
        System.out.println(o);
        return o.toString();
    }

    @Override
    public String executeJSFile(String filePath) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(new FileReader(filePath));
        return "success";
    }

    @Override
    public String executeJSFile(String filePath,String functionName) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(new FileReader(filePath));
        Invocable inv = (Invocable) engine;
        //invokeFunction()中的第一个参数就是被调用的脚本程序中的函数，第二个参数是传递给被调用函数的参数；
        Object o = inv.invokeFunction(functionName);
        System.out.println(o);
        return o.toString();
    }

    public static void bind(String domainName) throws  Exception {
            JSSupport support = new JSSupport();
        ArrayList<MBeanServer> mBeanServerList = MBeanServerFactory.findMBeanServer(null);
        MBeanServer mbeanServer = null;
        if (mBeanServerList.size() > 0) {
            mbeanServer  = mBeanServerList.get(0);
            ObjectName ifcON = new ObjectName(domainName +":name=JSSupport");
            mbeanServer.registerMBean(support, ifcON);
        }
    }
}
