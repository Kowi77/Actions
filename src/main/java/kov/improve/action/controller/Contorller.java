package kov.improve.action.controller;

import kov.improve.action.model.Action;
import kov.improve.action.model.Gift;
import kov.improve.action.service.ActionService;
import kov.improve.action.service.GiftService;
import kov.improve.action.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class Contorller {

    GiftService giftService;
    ActionService actionService;

    @Autowired
    public Contorller(GiftService giftService, ActionService actionService) {
        this.giftService = giftService;
        this.actionService = actionService;
    }

    @GetMapping("")
    public String homePage(Model model) {
        model.addAttribute("actions", actionService.getAll());
        return "index";}

    @GetMapping("{id}")
    public String getAction(@PathVariable("id") int id, Model model){
        Action action = actionService.get(id);
        model.addAttribute("action",action);
        model.addAttribute("gifts", ControllerUtils.getGiftsForActualAction(giftService.getAll(), action.getAmount()));
        model.addAttribute("message", "");
        return "action";
     }

    @GetMapping("filtered/{id}")
    public String getFilteredAction(@PathVariable("id") int id, Model model, HttpServletRequest request){
        Action action = actionService.get(id);
        model.addAttribute("action", action);
        model.addAttribute("gifts", ControllerUtils.getGiftsForActualAction(giftService.getAllWithFilter(request.getParameter("part")), action.getAmount()));
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
        // количество подарков по акции могло изменится, поэтому запрашиваем заново
        Action resultAction = actionService.get(currentAction);
        model.addAttribute("message", message);
        model.addAttribute("action", resultAction);
        model.addAttribute("gifts", ControllerUtils.getGiftsForActualAction(giftService.getAll(), resultAction.getAmount()));
        return "action";
    }




}
