package com.scalar.splitwise_app.commands;

import com.scalar.splitwise_app.controllers.SettleUpController;
import com.scalar.splitwise_app.dtos.SettleUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleUp implements Command {

    SettleUpController settleUpController = new SettleUpController();
    @Autowired
    public SettleUp(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }
    public boolean matches(String input){
        List<String> words = List.of(input.split(" "));
        if(words.get(1).equals("SettleUp"))
        {
            return true;
        }
        return false;

    }

    public void execute(String input){
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));
        SettleUpRequestDto SettleUpRequest= new SettleUpRequestDto();
        SettleUpRequest.setUserID(userId);


        settleUpController.SettleUp(SettleUpRequest);


    }

}
