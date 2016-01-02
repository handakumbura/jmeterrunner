/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumiduh.jmeterrunner;

import java.util.ArrayList;
import org.apache.jmeter.assertions.AssertionResult;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleResult;

/**
 *
 * @author dumiduh
 */
public class MyResultCollector extends ResultCollector {
private boolean assertionStatus=false;
private ArrayList<ResultDTO> results;
    public MyResultCollector(Summariser summer) {
        super(summer);
        results = new ArrayList();
    }

    @Override
    public void sampleOccurred(SampleEvent e) {
        super.sampleOccurred(e);
        SampleResult r = e.getResult();
        
        ResultDTO result = new  ResultDTO();
        result.setSamplerName(r.getSampleLabel());
        result.setResponseCode(r.getResponseCode());
        result.setResult(r.isSuccessful());                
        getResults().add(result);

        if (r.isSuccessful()) {
            assertionStatus=true;
        }
        else
        {
            assertionStatus=false;
        }    
    }

    /**
     * @return the status
     */
    public boolean getAssertionStatus() {
        return assertionStatus;
    }

    /**
     * @return the results
     */
    public ArrayList<ResultDTO> getResults() {
        return results;
    }
    
}
