package org.rsys.application.data;

import org.rsys.application.beans.*;
import java.util.List;



public interface DataService {
    List<Data> retrieveData(User user);
}