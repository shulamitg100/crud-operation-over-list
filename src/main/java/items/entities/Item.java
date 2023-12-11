package items.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "LIST")
    private String list;
    @Column(name = "ITEM")
    private String item;

    public Item() {
    }

    public Item(UUID id, String list) {
        this.id = id;
        this.list = list;
    }

    public UUID getId() {
        return id;
    }

    public String getList() {
        return list;
    }

    public String getItem() {
        return item;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setList(String list) {
        this.list = list;
    }

    public void setItem(String value) {
        this.item = value;
    }
//
//    public void setItem(Object value) {
//        this.item = JsonHandler.convertObjectToJsonString(value);
//    }
}
