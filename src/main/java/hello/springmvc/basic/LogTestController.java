package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private final Logger logerr = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        logerr.trace("trace log={}", name);
        logerr.debug("debug log={}", name);
        logerr.info("info log={}", name);
        logerr.warn("warn log={}", name);
        logerr.error("error log={}", name);

        return "OK";
    }


}
