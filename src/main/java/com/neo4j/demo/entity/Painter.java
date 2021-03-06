package com.neo4j.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@NodeEntity(label = "Painter")
@Document(indexName = "painter_idx")
@Data
public class Painter {
    @Id
    @GeneratedValue
    private Long id;//主键id
    @Property(name = "name")
    @Field(analyzer = "ik_max_word")
    private String name;//姓名
    private String country;//国家
    private int birth;//出生年份
    private int death;//死亡年份
    private String description;//描述
    private String image;//图像

//    @Relationship(type = "SAME_ERA", direction = Relationship.OUTGOING)
//    private List<Painter> sameEraPainters;
//

    @Override
    public String toString() {
        return "{" +
                "id:" + id +"\n"+
                ", name:'" + name + '\'' +"\n"+
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Painter painter = (Painter) o;
        return birth == painter.birth &&
                death == painter.death &&
                Objects.equals(id, painter.id) &&
                Objects.equals(name, painter.name) &&
                Objects.equals(country, painter.country) &&
                Objects.equals(description, painter.description) &&
                Objects.equals(image, painter.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, birth, death, description, image);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public Painter() {
    }

    public Painter(Long id, String name, String country, int birth, int death, String description, String image) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birth = birth;
        this.death = death;
        this.description = description;
        this.image = image;
    }
}
