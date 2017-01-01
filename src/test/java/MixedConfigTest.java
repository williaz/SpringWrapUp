import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.config.PlayList;

/**
 * Created by williaz on 12/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = core.config.MixedConfig.class)
public class MixedConfigTest {
    @Autowired
    private PlayList list;
    @Test
    public void test_PlayList() {
        list.start();
    }
}
