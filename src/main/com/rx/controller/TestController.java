package com.rx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

@Slf4j
@RestController
public class TestController {

    @PostMapping("/")
    public String test() {
        String[] names = {"sora", "asami", "tommy", "geroge", "britney", "saw", "minnie", "chao"};
        Observable
                .from(names)
                .filter(new Func1<String, Boolean>() {
                            @Override
                            public Boolean call(String s) {
                                return s.startsWith("s");
                            }
                        }

                )
                .subscribe(
                        new Action1<String>() {
                            @Override
                            public void call(String s) {
                                log.info("Hello " + s + "!");
                            }

                        });
        return "success";
    }
}
