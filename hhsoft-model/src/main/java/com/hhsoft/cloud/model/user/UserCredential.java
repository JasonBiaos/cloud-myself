package com.hhsoft.cloud.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: UserCredential
 * @Description 用户凭证实体类
 * @Author Jason Biao
 * @Date 2019/3/21 13:44
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredential {

    /**
     * @NoArgsConstructor: 自动生成无参数构造函数。
     * @AllArgsConstructor: 自动生成全参数构造函数。
     */

    private static final long serialVersionUID = -958701617717204974L;

    /**
     *用户名或手机号等
     */
    private String username;

    /**
     * @see com.hhsoft.cloud.model.user.constants.CredentialType
     * 账号类型（用户名、手机号）
     */
    private String type;

    /**
     *
     */
    private Long userId;

}
