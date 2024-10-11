package houseInception.gptComm.contoller;

import houseInception.gptComm.dto.LoginResDto;
import houseInception.gptComm.dto.SignInDto;
import houseInception.gptComm.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/login")
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/sign-in")
    public LoginResDto signIn(@RequestBody @Valid SignInDto signInDto){
        LoginResDto result = loginService.signIn(signInDto);

        return result;
    }
}