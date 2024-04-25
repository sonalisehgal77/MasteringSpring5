import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.rsys.application.beans.User;
import org.rsys.application.beans.Data;
import org.rsys.application.business.BusinessService;
import org.rsys.application.business.BusinessServiceImpl;
import org.rsys.application.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockitoTest {

    private static final User DUMMY_USER = new User("nobody");


    @Mock
    private DataService dataService;

    @InjectMocks
    private BusinessService service = new BusinessServiceImpl();

    @Test
    public void testCalculateSum() {
        BDDMockito.given(dataService.retrieveData(Matchers.any(User.class)))
                .willReturn(Arrays.asList(new Data(10), new Data(15), new Data(25)));

        long sum = service.calculateSum(DUMMY_USER);
        assertEquals(10 + 15 + 25, sum);
    }

}

