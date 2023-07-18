package org.lboot.onlyoffice.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author kindear
 * office 文档编辑关闭事件 传入文件ID 和 用户ID
 */
@Getter
public class OfficeEditCloseEvent extends ApplicationEvent {
    String userId;

    String fileKey;

    public OfficeEditCloseEvent(Object source, String userId, String fileKey) {
        super(source);
        this.userId = userId;
        this.fileKey = fileKey;
    }

    public OfficeEditCloseEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
