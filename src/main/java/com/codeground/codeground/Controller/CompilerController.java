package com.codeground.codeground.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeground.codeground.Services.CompilerService.CompilerService;

@RestController
@RequestMapping("/compile")
public class CompilerController {

    @Autowired
    private CompilerService compilerService;

    @PostMapping("/java")
    @CrossOrigin(origins = { "https://codeground-5c6f7.web.app", "http://localhost:3000" })
    public String compileAndExecuteJavaCode(@RequestBody String javaCode) {
        return compilerService.compileAndExecuteJavaCode(javaCode);
    }
}
