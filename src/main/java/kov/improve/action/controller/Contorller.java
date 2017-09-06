package kov.improve.action.controller;

import kov.improve.action.config.DataConfig;
import kov.improve.action.model.Action;
import kov.improve.action.model.Gift;
import kov.improve.action.service.ActionService;
import kov.improve.action.service.GiftService;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class Contorller {

    @Autowired
    GiftService giftService;

    @Autowired
    ActionService actionService;

    @GetMapping("")
    public String homePage(Model model) {
        model.addAttribute("actions", actionService.getAll());
        return "index";}

    @GetMapping("{id}")
    public String getAction(@PathVariable("id") int id, Model model){
        model.addAttribute("action", actionService.get(id));
        model.addAttribute("gifts", giftService.getAll());
        model.addAttribute("message", "");
        return "action";
     }

    @PostMapping("{id}")
    public String getGift(@PathVariable("id") int id, HttpServletRequest request, Model model){
        int currentAction = Integer.parseInt(request.getParameter("currentAction"));
        Gift gift = giftService.get(id);
        Action action = actionService.get(currentAction);
        action.setAmount(action.getAmount() - 1);
        gift.setQuantity(gift.getQuantity() - 1);
        Gift result = null;
        try {
            result = giftService.save(gift, action);
        } catch (Exception e) {
        }
        String message = result == null ? "К сожалению, подарок " + gift.getName() + " недоступен"
                         : "Поздравляем с получением " + gift.getName() + "!";
        Action resultAction = actionService.get(currentAction);
        model.addAttribute("message", message);
        model.addAttribute("action", resultAction);
        model.addAttribute("gifts", resultAction.getAmount() > 0 ? giftService.getAll() : new ArrayList<Gift>());
        return "action";
    }


}
