package com.ohgiraffers.restapitest.controller;

import com.ohgiraffers.restapitest.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

}
