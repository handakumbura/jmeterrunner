/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumiduh.jmeterrunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

/**
 *
 * @author dumiduh
 */
public class JmeterRunner {
private final String JMETERSCRIPT;    
private final String JMETERPROPFILE;
private final String JMETERHOME;
private final String JTLHOME;
private ArrayList<ResultDTO> results;
private final Log log = LogFactory.getLog(JmeterRunner.class);
public JmeterRunner(String jmeterscript, String jmeterpropfile, String jmeterhome, String resulthome)
{
    this.JMETERSCRIPT=jmeterscript;
    this.JMETERPROPFILE=jmeterpropfile;
    this.JMETERHOME=jmeterhome;
    this.JTLHOME=resulthome;    
}        
public void runJScript()
{
    try {
        
        StandardJMeterEngine jmeter = new StandardJMeterEngine();
        
        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties(JMETERPROPFILE);
        JMeterUtils.setJMeterHome(JMETERHOME);
        JMeterUtils.initLocale();
        
        // Initialize JMeter SaveService
        
        SaveService.loadProperties();
        
        
        // Load existing .jmx Test Plan
        FileInputStream in = new FileInputStream(JMETERSCRIPT);
        HashTree testPlanTree = SaveService.loadTree(in);
        in.close();
        
        // Run JMeter Test
        
        Summariser summer = new Summariser();
        String testLog = JTLHOME+new Date().getTime()+".jtl";
        MyResultCollector resultCollector = new MyResultCollector(summer);
        resultCollector.setFilename(testLog);
        testPlanTree.add(testPlanTree.getArray()[0], resultCollector);
        
        
        
        jmeter.configure(testPlanTree);
        jmeter.run();
        results = resultCollector.getResults();
        
    } catch (IOException ex) {
        log.error(ex);
    }
    
}

public void processResult()
{
    if(results!=null)
    {    
    for(ResultDTO result : results)
    {
        if(!result.isResult())
        {
            log.info("Assertion failed for "+result.getSamplerName()+" sampler with response code "+result.getResponseCode()+".");           
        }    
    }    
    }    
}        

     
    
}
