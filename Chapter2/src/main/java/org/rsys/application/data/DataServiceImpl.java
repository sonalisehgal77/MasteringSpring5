package org.rsys.application.data;


import org.springframework.stereotype.Repository;
import org.rsys.application.beans.*;
import java.util.Arrays;
import java.util.List;

@Repository
public class DataServiceImpl implements DataService{
    public List<Data> retrieveData(User user) {

        return Arrays.asList(new Data(10), new Data(20));
    }
}
