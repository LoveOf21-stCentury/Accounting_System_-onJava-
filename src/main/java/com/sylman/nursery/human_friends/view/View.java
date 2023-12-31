package com.sylman.nursery.human_friends.view;

import com.sylman.nursery.human_friends.model.Animals;
import com.sylman.nursery.human_friends.model.Service;
import com.sylman.nursery.human_friends.presenter.exceptions.MenuOptionException;

public interface View {
    Service start() throws MenuOptionException;
    void printAnswer(String answer);
}
