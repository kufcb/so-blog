package org.somall.controller;

import com.commons.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.somall.pojo.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
@Tag(name = "用户接口")
public class UserController {
    @PostMapping("/login")
    @Operation(summary = "登录")
    public ResponseResult login(@Validated UserDTO userDTO) {
        return ResponseResult.success("login");
    }

}
