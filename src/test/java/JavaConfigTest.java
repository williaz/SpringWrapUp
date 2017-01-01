import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.config.java.CdPlayer1;

/**
 * Created by williaz on 12/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = core.config.java.PlayerConfig.class)
public class JavaConfigTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void test_ApplicationContext_NotNull() {
        Assert.assertNotNull(context);
    }

    @Test
    public void test_Ipod_Start() {
        CdPlayer1 player = context.getBean("ipod", CdPlayer1.class);
        player.start();
    }

}
