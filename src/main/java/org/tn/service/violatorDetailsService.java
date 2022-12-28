package org.tn.service;

import org.tn.model.violatorDetails;

import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class violatorDetailsService {

    private HashMap<String, violatorDetails> SerialnumberViolatorMap= new HashMap<>();


    public HashMap<String, violatorDetails> getSerialnumberViolatorMap() {
        return SerialnumberViolatorMap;
    }
    public void setSerialnumberViolatorMap(HashMap<String, violatorDetails> serialnumberViolatorMap) {
        SerialnumberViolatorMap = serialnumberViolatorMap;
    }
}
