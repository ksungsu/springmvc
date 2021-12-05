package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("OK");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
                        //= request.getParameter("username")
                        @RequestParam("username") String memberName,
                               @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);

        return "OK";
    }


    /**
     * HTTP 파라미터 이름과 변수 이름과 같으면 @RequestParam(name="xxx") 생략 가능
     */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);

        return "OK";
    }

    /**
     * String, int 등 단순 타입일 때, @RequestParam도 생략 가능
     * 참고) @RequestParam은 되도록 생략 x
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {

        log.info("username={}, age={}", username, age);

        return "OK";
    }

    /**
     * required
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) int age) {

        log.info("username={}, age={}", username, age);

        return "OK";
    }

    /**
     * requestParamDefault
     * 파라미터 값이 없는 경우 defaultValue를 사용하면 기본 값을 적용할 수 있다.
     */
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {

        log.info("username={}, age={}", username, age);

        return "OK";
    }


    /**
     * 파라미터를 Map으로 조회
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "OK";
    }


    /**
     * @ModelAttribute 사용
     * 자동으로 HelloData 생성 및 Getter, Setter 적용
     *
     * @RequestParam String username;
     * @RequestParam int age;
     *
     * HelloData data = new HelloData();
     * data.setUsername(username);
     * data.setAge(age);
     *
     * 위 코드
     * 생략 가능
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "OK";
    }

    /**
     * @ModelAttribute 생략
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2( HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "OK";

    }

}
