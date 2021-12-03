package hello.springmvc.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
            return "OK";
    }

    @GetMapping(value ="/mapping-get-v2")
    public String mappingGetv2(){
        log.info("mapping-get-v2");
        return "OK";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId={}", data);
        return "OK";
    }

    //mode=debug라는 파라미터가 있어야 실행
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "OK";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "OK";
    }
//
//    @PostMapping(value = "/mapping-consume", consumes = "application.json")
//    public String mappingConsumes(){
//        log.info("mappingConsumes");
//        return "OK";
//    }
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces(){
        log.info("mappingProduces");
        return "OK";
    }
}

