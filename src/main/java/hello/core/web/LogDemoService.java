package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/**
 * packageName    : hello.core.web
 * fileName       : LogDemoService
 * author         : yoons
 * date           : 2025-02-12
 * description    :
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("serivce id : " + id);
    }
}
