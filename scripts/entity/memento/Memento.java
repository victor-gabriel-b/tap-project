package entity.memento;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Memento implements IMemento{
    private ArrayList<String> state;

    public Memento(ArrayList<String> stateToSave) {
        this.state = stateToSave;
    }

    public ZonedDateTime getDate(){
        return ZonedDateTime.now();
    }

    public ArrayList<String> getSavedState() {
        return this.state;
    }
}
