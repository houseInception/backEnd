package houseInception.gptComm.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/test")
@RequiredArgsConstructor
@RestController
public class TestController {
    @PostMapping
    public String  test(){
        return "ok";
    }
}
