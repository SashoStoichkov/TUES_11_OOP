package main.java.com.oop;

import java.util.List;

public class Skara {
    void bake(List<IBakeable> stuffToBake){
        for (IBakeable item : stuffToBake){
            item.bake(this);
        }
    }
}
