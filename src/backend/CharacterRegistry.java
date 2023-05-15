package backend;

import backend.Character;

import java.util.ArrayList;

public class CharacterRegistry {
    Character one;
    Character two;
    Character three;
    Character four;
    Character five;
    int teamSize;


    public CharacterRegistry(){

        teamSize = 0;
    }

    public CharacterRegistry(Character a){
        this.one = a;
        teamSize = 1;
    }
    public CharacterRegistry(Character a, Character b){
        this.one = a;
        this.two = b;
        teamSize = 2;
    }
    public CharacterRegistry(Character a, Character b, Character c){
        this.one = a;
        this.two = b;
        this.two = c;
        teamSize = 3;
    }
    public CharacterRegistry(Character a, Character b, Character c, Character d){
        this.one = a;
        this.two = b;
        this.three = c;
        this.four = d;
        teamSize = 4;
    }
    public CharacterRegistry(Character a, Character b, Character c, Character d, Character e){
        this.one = a;
        this.two = b;
        this.three = c;
        this.four = d;
        this.five = e;
        teamSize = 5;
    }

    public boolean addCharacter(Character a){
        if(one.getRegion().equals("placeholder")){
            one = a;
            return true;
        }
        if(two.getRegion().equals("placeholder")){
            two = a;
            return true;
        }
        if(three.getRegion().equals("placeholder")){
            three = a;
            return true;
        }
        if(four.getRegion().equals("placeholder")){
            four = a;
            return true;
        }
        if(five.getRegion().equals("placeholder")){
            five = a;
            return true;
        } else{
            return false;
        }
        
        


    }


}

