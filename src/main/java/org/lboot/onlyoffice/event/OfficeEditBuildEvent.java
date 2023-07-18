package org.lboot.onlyoffice.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author kindear
 * office 文档编辑构建事件 传入文件ID 和 用户ID
 */
@Getter
public class OfficeEditBuildEvent extends ApplicationEvent {
    String userId;

    String fileKey;

    public OfficeEditBuildEvent(Object source, String userId, String fileKey) {
        super(source);
        this.userId = userId;
        this.fileKey = fileKey;
    }

    public OfficeEditBuildEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
