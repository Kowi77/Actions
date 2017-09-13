package kov.improve.action.utils;

import kov.improve.action.model.Gift;
import java.util.ArrayList;
import java.util.List;

public class ControllerUtils {
    public static  List<Gift> getGiftsForActualAction(List<Gift> gifts, int amount){
        return amount > 0 ? gifts : new ArrayList<Gift>();
    }
}
