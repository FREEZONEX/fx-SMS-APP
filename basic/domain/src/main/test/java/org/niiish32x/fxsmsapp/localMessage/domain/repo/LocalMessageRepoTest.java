package org.niiish32x.fxsmsapp.localMessage.domain.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.niiish32x.fxsmsapp.localMessage.domain.entity.LocalMessageEO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * LocalMessageRepoTest
 *
 * @author shenghao ni
 * @date 2024.12.05 14:25
 */

@SpringBootTest(classes = {LocalMessageRepo.class})
@RunWith(SpringRunner.class)
public class LocalMessageRepoTest {
    @Resource
    LocalMessageRepo localMessageRepo;

    @Test
    public void test(){
        List<LocalMessageEO> query = localMessageRepo.query();
    }
}
