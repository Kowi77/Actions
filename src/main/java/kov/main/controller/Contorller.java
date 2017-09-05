package kov.main.controller;

import kov.main.config.DataConfig;
import kov.main.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Contorller {

    @Autowired
    GiftService giftService;

    @Autowired
    DataConfig dataConfig;

    @GetMapping("/")
    public String root() {return "index";}


}
