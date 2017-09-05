package kov.improve.action.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Contorller {

    /*@Autowired
    GiftService giftService;

    @Autowired
    DataConfig dataConfig;*/

    @GetMapping("")
    public String root() {
        System.out.println(System.getProperty("java.class.path"));
        return "index";}


}
