package com.dumiduh.jmeterrunner;

import java.io.FileInputStream;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String prop = "/home/dumiduh/SOFTWARE/apache-jmeter-2.13/bin/jmeter.properties";
        String jhome= "/home/dumiduh/SOFTWARE/apache-jmeter-2.13";
        String jtlhome="/home/dumiduh/SOFTWARE/";
        String script="/home/dumiduh/WORK/testscript.jmx";
        JmeterRunner runner = new JmeterRunner(script,prop, jhome, jtlhome);
        runner.runJScript();
        runner.processResult();
    }
}
