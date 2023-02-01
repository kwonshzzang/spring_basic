package kr.co.kwonshzzang.springbasic.aop;

import kr.co.kwonshzzang.springbasic.dto.UserInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {
    @Pointcut("execution(* kr.co.kwonshzzang.springbasic.controller..*.*(..))")
    private void cut() {

    }

    @Pointcut("@annotation(kr.co.kwonshzzang.springbasic.annotation.Decode)")
    private void enableDecode() {}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for(Object arg: args) {
            if(arg instanceof UserInfo) {
                UserInfo userInfo = UserInfo.class.cast(arg);
                String base64Email = userInfo.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                userInfo.setEmail(email);
            }
        }

    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if(returnObj instanceof UserInfo) {
            UserInfo userInfo = UserInfo.class.cast(returnObj);
            String email = userInfo.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            userInfo.setEmail(base64Email);
        }
    }
}
