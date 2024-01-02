package com.sylman.nursery.human_friends.presenter.exceptions;

public class MenuOptionException extends Exception{
    public MenuOptionException(String message){
        super(message);
    }

    public MenuOptionException(){
        super("Exception with select in menu");
    }
}
