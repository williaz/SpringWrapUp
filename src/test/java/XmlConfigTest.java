import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.config.xml.Ipod;

/**
 * Created by williaz on 12/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/java/core/config/xml/xmlConfig.xml")
public class XmlConfigTest {
    @Autowired
    private Ipod ipod;

    @Test
    public void test_Ipod_Start() {
        assert ipod != null;
        ipod.start();
    }
}
