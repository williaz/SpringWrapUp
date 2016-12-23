import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.config.auto.CdPlayer;

/**
 * Created by williaz on 12/22/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = core.config.auto.CdPlayerConfig.class)
public class AutoWiringTest {
    @Autowired
    private CdPlayer ipod;

    @Test
    public void test_ipodShouldNotBeNull() {
        Assert.assertNotNull(ipod);
    }

    @Test
    public void test_ipod_Play() {
        ipod.play();
    }
}
