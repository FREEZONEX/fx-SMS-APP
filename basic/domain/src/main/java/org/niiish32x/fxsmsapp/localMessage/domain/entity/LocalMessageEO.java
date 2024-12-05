package org.niiish32x.fxsmsapp.localMessage.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * LocalMessageEO
 *
 * @author shenghao ni
 * @date 2024.12.05 14:07
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalMessageEO {
    private Long id;
    private String messageContent;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
