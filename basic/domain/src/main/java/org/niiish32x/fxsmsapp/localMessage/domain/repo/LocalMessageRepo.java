package org.niiish32x.fxsmsapp.localMessage.domain.repo;

import org.niiish32x.fxsmsapp.localMessage.domain.entity.LocalMessageEO;

import java.util.List;

/**
 * LocalMessageRepo
 *
 * @author shenghao ni
 * @date 2024.12.05 14:09
 */
public interface LocalMessageRepo {
    List<LocalMessageEO> query();
}
