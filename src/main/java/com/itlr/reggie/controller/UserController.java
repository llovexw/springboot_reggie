package com.itlr.reggie.controller;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-21:34
 */
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itlr.reggie.common.R;
import com.itlr.reggie.entity.User;
import com.itlr.reggie.service.EmailService;
import com.itlr.reggie.service.UserService;
import com.itlr.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        // 获取手机号或者邮箱
        String phone = user.getPhone();

        if (StringUtils.isNotEmpty(phone)){
            // 生成随机的6位验证码
            String code = String.valueOf(ValidateCodeUtils.generateValidateCode(6));
            log.info("code={}",code);

            String regex = "^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})|(19[0-9]{9})$";
            if(!phone.matches(regex)){
                // 发送验证码到邮箱
                emailService.sendSimpleMail(phone,code);
            }

            // 调用阿里云提供的短信服务API完成短信发送
            // SMSUtils.sendMessage("瑞吉外卖","",phone,code);

            // 需要将生成的验证码保存到session
            // session.setAttribute(phone,code);

            // 将生成的验证码缓存至Redis中，并且设置有效期为5分钟
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);

            return R.success("短信发送成功");
        }
        return R.error("短信发送失败");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session){
        log.info(map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();

        //从session中获取保存的验证码
        //String codeInSession = session.getAttribute(phone).toString();

        // 从Redis中获取缓存验证码
        Object codeInSession = redisTemplate.opsForValue().get(phone);


        //进行验证码的对比（页面提交的验证码和session中保存的验证码）
        if (code != null && code.equals(codeInSession)){
            //如果比对成功，则登录成功
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user = userService.getOne(queryWrapper);

            if (user == null){
                //判断当前手机号是否为新用户，如果是新用户则自动完成注入
                user = new User();
                user.setPhone(phone);
                userService.save(user);
            }

            // 设置session
            session.setAttribute("user",user.getId());

            // 如果用户登陆成功，删除Redis中缓存的验证码
            redisTemplate.delete(phone);

            return R.success(user);
        }
        return R.error("登录失败");
    }

    @PostMapping("/loginout")
    public R<String> logout(HttpServletRequest request){
        // 清楚密钥
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }

}

