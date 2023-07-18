package org.lboot.onlyoffice.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ApiModel(value = "修改记录")
public class HistoryBean {
    /**
     * 修改记录（json字符串形式）
     <pre>
     [{
     "created": "2019-08-28 05:25:23",
     "user": {
     "name": "用户456",
     "id": "456"
     }
     }, {
     "created": "2019-08-28 05:25:33",
     "user": {
     "name": "用户789",
     "id": "789"
     }
     }
     ]
     </pre>
     */
    private String changes;
    /** onlyoffice服务端版本 **/
    private String serverVersion;
}
