package net.spisok.app.dao;

import net.spisok.app.model.Thing;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DaoThings {
    private static int _COUNT;
    private List<Thing> things;

    {
        things = new ArrayList<>();

        things.add(new Thing(++_COUNT, "молоко","нужно купить"));
        things.add(new Thing(++_COUNT, "хлеб","нужно купить"));
        things.add(new Thing(++_COUNT, "чай","нужно купить"));

    }

    public List<Thing> index() {
        return things;
    }

    public void save(String name) {
        Thing thing = new Thing(0,name,"нужно купить");
        thing.setId(++_COUNT);
        thing.setBought("нужно купить");

        things.add(thing);
    }
    public void delete(int id) {
        things.removeIf(t -> t.getId() == id);
    }
    public void changeStatus(int id){
        Thing r = things.stream().filter(thing -> thing.getId() == id).findAny().orElse(null);
        if (r.getBought() == "нужно купить"){
            r.setBought("купленно");
        }else {
            r.setBought("нужно купить");
        }
    }

//    public Thing show(int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//    }
}
